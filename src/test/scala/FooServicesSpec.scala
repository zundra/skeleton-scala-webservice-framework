package api

import akka.actor.Props

import spray.testkit.Specs2RouteTest
import spray.routing.Directives
import org.specs2.mutable.Specification
import spray.http._


class FooServiceSpec extends Specification with Directives with DefaultJsonFormats with Specs2RouteTest {

  val route = new FooService().route
  
  "The routing infrastructure should support" >> {
    "the most simple and direct route" in {
      Get() ~> complete(HttpResponse()) ~> (_.response) === HttpResponse()
    }
  }
}
