package cats

object CatsTCOverview {

  trait Semigroup[A] {
    def combine(x: A, y: A): A
  }

  trait Monoid[A] {
    def empty: A
  }

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Semigroupal[F[_]] {
    def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]
  }

  trait Apply[F[_]] extends Semigroupal[F] with Functor[F] {
    def ap[A, B](tab: F[A => B], fa: F[A]): F[B]

    def product[A, B](fa: F[A], fb: F[B]): F[(A, B)] = {

      val myFunction: A => B => (A, B) = (a: A) => (b: B) => (a, b)
      val fab: F[B => (A, B)] = map(fa)(myFunction)
      ap(fab, fb)
    }

    def mapN[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = {
      map(product(fa, fb)) {
        case (a, b) => f(a, b)
      }
    }
  }

  trait Applicative[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
  }

  trait FlatMap[F[_]] extends Functor[F] {
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  }


  trait Monad[F[_]] extends Applicative[F] with FlatMap[F] {

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    override def map[A, B](fa: F[A])(f: A => B): F[B] = {

      flatMap(fa)(a => pure(f(a)))
    }
  }




  //  import cats.syntax.functor._
  //  import cats.Functor


//  def do10General[F[_]](container: F[Int])(functor: Functor[F]): F[Int] = container.map(_ * 10)

}
