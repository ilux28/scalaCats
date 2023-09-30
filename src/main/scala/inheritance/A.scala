package inheritance

class A {

  def m(s: String) = println(s"A($s)")

}


trait B extends A {

  override def m(s: String) = super.m(s"B($s)")

}

trait C extends A {

  override def m(s: String) = super.m(s"C($s)")

}

trait D extends A {

  override def m(s: String) = super.m(s"D($s)")

}

trait E extends C {

  override def m(s: String) = super.m(s"E($s)")

}

trait F extends C {

  override def m(s: String) = super.m(s"F($s)")

}

class G extends D with E with F with B {

  override def m(s: String) = super.m(s"G($s)")

}


object Test2 {

  def main(args: Array[String]): Unit = {

    val x = new G().m("")
  }

}
