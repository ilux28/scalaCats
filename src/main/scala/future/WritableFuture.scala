package future

import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global

object WritableFuture extends App {


  val aFuture = Future {
    32
  }

  object MyService {

    def produceAPreciousValue(theArg: Int): String = "The meaning of life is " + (theArg) / 32

    def submitTask[A](actualArg: A)(function: A => Unit): A = {
      actualArg
    }
  }

  val myPromise = Promise[String]()
  val myFuture = myPromise.future
  val furtherProcessing = myFuture.map(_.toUpperCase)

  def asyncCall(promise: Promise[String]): Unit = {
    promise.success("Your value here, your majesty")
  }

  asyncCall(myPromise)

  def gimmeMyPreciousValue(yourArg: Int): Future[String] = {

    val thePromise = Promise[String]()
    MyService.submitTask(yourArg) { x: Int =>
      val preciousValue: String = MyService.produceAPreciousValue(x)
      val res = thePromise.success(preciousValue)
      println(s"res: $res")
      println(s"yourArg: $yourArg")
    }

    thePromise.future
  }

  val resultFuture = gimmeMyPreciousValue(34)

  resultFuture.foreach(println)

}
