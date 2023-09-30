package inheritance

class Collection[+A] {

  def flatMap[B](f: A => Collection[B]): Collection[B] = ???

  def map[B](f: A => B): Collection[B] = {
    flatMap(a => Collection(f(a)))
  }
}

object Collection {
  def apply[A](a: A): Collection[A] = new Collection[A]
}

object Fib extends App {

  def fib(n : Int): Int = {

    if (n == 0) {
      0
    } else if (n == 1) 1
    else {
      fib(n - 1) + fib(n - 2)
    }


  }

  println(fib(55))

}