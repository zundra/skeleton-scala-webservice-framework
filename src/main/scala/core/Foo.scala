package core

import org.joda.time.{DateTimeZone, DateTime}
import api.DefaultJsonFormats
import sprest.Formats._

import storage.postgres.models.FooModel

case class Foo(
                name: String,
                created_at: DateTime = DateTime.now(DateTimeZone.UTC),
                updated_at: DateTime = DateTime.now(DateTimeZone.UTC))
object Foo {
  def save(foo: Foo): Foo = {
    FooModel.create(foo)
  }
}

trait FooJson extends DefaultJsonFormats {
  implicit val jsonFormat = jsonFormat3(Foo.apply)
}