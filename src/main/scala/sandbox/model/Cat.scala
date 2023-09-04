package sandbox.model

import sandbox.typeclass.Printable

import scala.Predef.{augmentString => _}

final case class Cat(name: String, age: Int, color: String)

object Cat {

  import cats.implicits._
  import cats.{Eq, Show}
  import sandbox.typeclass.PrintableInstances._
  import sandbox.typeclass.PrintableSyntax.PrintableOps

  implicit val printableCat: Printable[Cat] = (cat: Cat) => {
    val name = cat.name.format
    val age = cat.age.format
    val color = cat.color.format
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
