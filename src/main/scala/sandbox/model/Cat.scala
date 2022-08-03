package sandbox.model

import sandbox.typeclass.Printable

final case class Cat(name: String, age: Int, color: String)

object Cat {

  import cats.{Eq, Show}
  import cats.implicits._
  import sandbox.typeclass.PrintableInstances._

  implicit val printableCat: Printable[Cat] = (cat: Cat) => {
    val name = Printable.format(cat.name)
    val age = Printable.format(cat.age)
    val color = Printable.format(cat.color)
    s"$name is a $age year-old $color cat"
  }

  implicit val showCat: Show[Cat] = Show.show { cat =>
    val name = cat.name.show
    val age = cat.age.show
    val color = cat.color.show
    s"$name is a $age year-old $color cat"
  }

  implicit val eqCat: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    cat1.name === cat2.name &&
      cat1.age === cat2.age &&
      cat1.color === cat2.color
  }
}
