package core

import org.joda.time.{DateTimeZone, DateTime}
import api.DefaultJsonFormats
import sprest.Formats._

import storage.postgres.models.BarModel

case class Bar(
                name: String,
                created_at: DateTime = DateTime.now(DateTimeZone.UTC),
                updated_at: DateTime = DateTime.now(DateTimeZone.UTC))
object Bar {
  def save(foo: Bar): Bar = {
    BarModel.create(foo)
  }
}

trait BarJson extends DefaultJsonFormats {
  implicit val jsonFormat = jsonFormat3(Bar.apply)
}