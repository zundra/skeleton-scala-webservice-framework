package core

import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory


/**
 * Core is type containing the ``system: ActorSystem`` member. This enables us to use it in our
 * apps as well as in our tests.
 */
trait Core {
  implicit def system: ActorSystem
}

/**
 * This trait implements ``Core`` by starting the required ``ActorSystem`` and registering the
 * termination handler to stop the system when the JVM exits.
 */
trait BootedCore extends Core {
  val conf = ConfigFactory.load

  /**
   * Construct the ActorSystem we will use in our application
   */
  implicit lazy val system = ActorSystem(conf.getString("settings.ACTOR_SYSTEM"))

  /**
   * Ensure that the constructed ActorSystem is shut down when the JVM shuts down
   */
  sys.addShutdownHook(system.shutdown())

}

/**
 * This trait contains the actors that make up our application; it can be mixed in with
 * ``BootedCore`` for running code or ``TestKit`` for unit and integration tests.
 */
trait CoreActors {
  this: Core =>
}