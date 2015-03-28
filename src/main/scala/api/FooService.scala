package api

import spray.routing.Directives
import concurrent.{Promise, Future}
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

import core.Foo
import core.FooJson

class FooService extends Directives with FooJson {

  object FooSaver {
    val fooPromise = Promise[Foo]

    def saveIt(record: Foo): Future[Foo] = {
      Future {
        Foo.save(record)
        fooPromise.success(record)
      }

      fooPromise.future
    }
  }

   val route = {
     get {
       pathPrefix("api" / "v1" / "foo" / JavaUUID) { id =>
         complete(Map("foo_id" -> id))
       }
     } ~
       post {
         pathPrefix("api" / "v1" / "foo") {
           entity(as[Foo]) { foo =>

             val fooFuture = FooSaver.saveIt(foo)

             fooFuture.onComplete {
               case Success(Foo(_,_,_)) =>
               case Failure(ex) =>
                 println("Foo Failure")
             }

             complete(foo)
           }
         }
       }
   }
}


