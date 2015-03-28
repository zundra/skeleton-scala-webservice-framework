package storage.postgres

import scala.slick.driver.PostgresDriver.simple._
import org.joda.time._
import java.util.UUID

object Types {
  case class Foo(name:String, created_at:DateTime, updated_at:DateTime)
  case class Bar(name:String, created_at:DateTime, updated_at:DateTime)
}

object Tables {

  class Foos(tag: Tag) extends Table[Types.Foo](tag, "foos") {
    implicit val dateTimeColumnType = MappedColumnType.base[org.joda.time.DateTime, java.sql.Timestamp]({ dt => new java.sql.Timestamp(dt.getMillis) }, { ts => new org.joda.time.DateTime(ts) })

    def id = column[UUID]("id", O.PrimaryKey, O.AutoInc)

    //Required fields

    def name = column[String]("name")

    def created_at = column[DateTime]("created_at")

    def updated_at = column[DateTime]("updated_at")

    def * = (name, created_at, updated_at) <> (Types.Foo.tupled, Types.Foo.unapply)
  }

  class Bars(tag: Tag) extends Table[Types.Bar](tag, "bars") {
    implicit val dateTimeColumnType = MappedColumnType.base[org.joda.time.DateTime, java.sql.Timestamp]({ dt => new java.sql.Timestamp(dt.getMillis) }, { ts => new org.joda.time.DateTime(ts) })

    def id = column[UUID]("id", O.PrimaryKey, O.AutoInc)

    //Required fields

    def name = column[String]("name")

    def created_at = column[DateTime]("created_at")

    def updated_at = column[DateTime]("updated_at")

    def * = (name, created_at, updated_at) <> (Types.Bar.tupled, Types.Bar.unapply)
  }

}


