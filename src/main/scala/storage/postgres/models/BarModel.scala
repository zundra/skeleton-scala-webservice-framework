package storage.postgres.models

import org.joda.time.{DateTimeZone, DateTime}
import scala.slick.lifted.TableQuery
import scala.slick.driver.PostgresDriver.simple._
import storage.postgres.Connection
import storage.postgres.Tables
import storage.postgres.Types
import core.Bar

object BarModel extends Connection {

  val table = TableQuery[Tables.Bars]

  def parseDouble(s: String) = try { Some(s.toDouble) } catch { case _:Throwable => None }
  def parseInt(s: String) = try { Some(s.toInt) } catch { case _:Throwable => None }

  def create(mdl: Bar): Bar = {
    Database.forURL(dbURL, driver = "org.postgresql.Driver") withSession {
      implicit session =>

        val rec = Types.Bar(
          name = mdl.name,
          created_at = mdl.created_at,
          updated_at = mdl.updated_at
        )

        table.insert(rec)

        mdl
    }
  }
}





