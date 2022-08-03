package sandbox.typeclass

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val printableString: Printable[String] = (value: String) => value
  implicit val printableInt: Printable[Int] = (value: Int) => s"$value"
}

object Printable {
  def format[A: Printable](value: A): String = implicitly[Printable[A]].format(value)

  def print[A: Printable](value: A): Unit = println(format(value))
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit printable: Printable[A]): String = Printable.format(value)

    def print(implicit printable: Printable[A]): Unit = Printable.print(value)
  }
}
