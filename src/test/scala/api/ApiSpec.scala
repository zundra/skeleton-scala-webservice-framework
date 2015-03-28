package api


import core.{BootedCore, CoreActors}
import org.specs2.mutable.Specification
import spray.http._



class ApiSpec extends Specification with Api with CoreActors with BootedCore  {

  "The Api Class" should {
    "contain a set of routes" in {
      routes != Nil
    }

    "contain a root service" in {
      rootService != Nil
    }
  }
}
