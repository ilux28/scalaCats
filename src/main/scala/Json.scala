

sealed trait Json

final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json

case object JsNull extends Json

trait JsonWriter[A] {
  def writer(value: A): Json
}

object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]) = w.writer(value)
}
