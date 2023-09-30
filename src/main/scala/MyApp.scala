
//import JsonWriterInstances._

import JsonSyntax._

import scala.annotation.tailrec

object MyApp extends App {

  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {

    val res: (Int, Int, Int) = nums.foldLeft((0, 0, 0)) { (acc, x) =>

      if (x == 1) {

        if (acc._1 == 0) {
          if (acc._2 > acc._3) {
            (x, 1, acc._2)

          } else {
            (x, 1, acc._3)
          }
        } else {
          (x, acc._2 + 1, acc._3)

        }

      } else
        (x, acc._2, acc._3)
    }
    if (res._2 > res._3) res._2 else res._3
  }

  def findMaxConsecutiveOnesRec(nums: List[Int]): Int = {

    @tailrec
    def findMaxConsecutiveOnesRecWithParam(numList: List[Int], acc: (Int, Int, Int)): (Int, Int, Int) = {
      numList match {
        case x :: tail if x == 1 && acc._1 == 0 =>
          if (acc._2 > acc._3) {
            findMaxConsecutiveOnesRecWithParam(tail, (x, 1, acc._2))
          } else {
            findMaxConsecutiveOnesRecWithParam(tail, (x, 1, acc._3))
          }
        case x :: tail if x == 1 && acc._1 == 1 =>
          findMaxConsecutiveOnesRecWithParam(tail, (x, acc._2 + 1, acc._3))
        case x :: tail if x == 0 =>
          val resTuple = if (acc._2 > acc._3) (x, acc._2, acc._2) else (x, acc._2, acc._3)
          findMaxConsecutiveOnesRecWithParam(tail, resTuple)
        case _ =>
          if (acc._2 > acc._3)
            (0, acc._2, acc._2)
          else
            (0, acc._2 + 1, acc._3)
      }
    }

    findMaxConsecutiveOnesRecWithParam(nums, (0, 0, 0))._3

  }

  val nums = Array(1, 1, 0, 1, 1, 1, 1)
  val numsList = List(1, 1, 0, 1, 1, 1, 1)

  println(findMaxConsecutiveOnes(nums))
  println(findMaxConsecutiveOnesRec(numsList))

}
