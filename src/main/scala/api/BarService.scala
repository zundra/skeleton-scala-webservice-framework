package api

import spray.routing.Directives
import concurrent.{Promise, Future}
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

import core.Bar
import core.BarJson

class BarService extends Directives with BarJson {

  object BarSaver {
    val barPromise = Promise[Bar]

    def saveIt(record: Bar): Future[Bar] = {
      Future {
        Bar.save(record)
        barPromise.success(record)
      }

      barPromise.future
    }
  }

  val route = {
    get {
      pathPrefix("api" / "v1" / "bar" / JavaUUID) { id =>
        complete(Map("bar_id" -> id))
      }
    } ~
      post {
        pathPrefix("api" / "v1" / "bar") {
          entity(as[Bar]) { bar =>

            val barFuture = BarSaver.saveIt(bar)

            barFuture.onComplete {
              case Success(Bar(_,_,_)) =>
              case Failure(ex) =>
                println("Bar Failure")
            }

            complete(bar)
          }
        }
      }
  }
}


