package storage.postgres.models

import org.joda.time.{DateTimeZone, DateTime}
import scala.slick.lifted.TableQuery
import scala.slick.driver.PostgresDriver.simple._
import storage.postgres.Connection
import storage.postgres.Tables
import storage.postgres.Types
import java.util.UUID
import core.Foo

object FooModel extends Connection {

  val table = TableQuery[Tables.Foos]

  def parseDouble(s: String) = try { Some(s.toDouble) } catch { case _:Throwable => None }
  def parseInt(s: String) = try { Some(s.toInt) } catch { case _:Throwable => None }

  def create(mdl: Foo): Foo = {
    Database.forURL(dbURL, driver = "org.postgresql.Driver") withSession {
      implicit session =>

        val rec = Types.Foo(
          name = mdl.name,
          created_at = mdl.created_at,
          updated_at = mdl.updated_at
        )

        table.insert(rec)

      mdl
    }
  }
}





