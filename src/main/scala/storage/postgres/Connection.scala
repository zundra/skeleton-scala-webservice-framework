package storage.postgres

import com.typesafe.config.ConfigFactory

trait Connection {
  val conf = ConfigFactory.load
  val dbDriver = conf.getString("db.default.driver")
  val dbURL = conf.getString("db.default.url") + "?user=" + conf.getString("db.default.user") + "&password=" + conf.getString("db.default.password")
}
