package typeClassExample

object TypeClassExample {

  def processMyList[T](list: List[T])(implicit summable: Summable[T]): T =

    summable.sumElements(list)

  trait Summable[T] {
    def sumElements(list: List[T]): T

  }

  implicit object IntSummable extends Summable[Int] {
    override def sumElements(list: List[Int]): Int = list.sum

  }


  implicit object StringSummable extends Summable[String] {
    override def sumElements(list: List[String]) = {
      val res = list.mkString(" : ")

      println(res)
      res
    }

  }


  def main(args: Array[String]) = {
    val intSum = processMyList(List(1, 2, 3))
    val stringSum = processMyList(List("Scala", "is", "awesome"))

  }

}
