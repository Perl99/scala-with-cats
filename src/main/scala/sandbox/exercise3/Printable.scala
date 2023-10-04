package sandbox.exercise3

trait Printable[A] {

  def format(value: A): String

  def contramap[B](func: B => A): Printable[B] = (value: B) => Printable.this.format(func(value))
}

object PrintableInstances {

  implicit val stringPrintable: Printable[String] = (value: String) => s"'$value'"

  implicit val booleanPrintable: Printable[Boolean] = (value: Boolean) => if (value) "yes" else "no"

  implicit def boxContramapPrintable[A](implicit inner: Printable[A]): Printable[Box[A]] =
    inner.contramap(_.value)

  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
}
