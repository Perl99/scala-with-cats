package sandbox.exercise1

import cats.implicits._
import sandbox.exercise1.PrintableSyntax._

object Exercise1 {
  private val cat = Cat("Morgana", 5, "black, mixed and white")

  println("Hello " |+| "Cats!")
  println()

  def main(args: Array[String]): Unit = {
    printable()
    println()
    equality()
  }

  private def printable(): Unit = {
    println("Cat using Printable:")
    cat.print

    println("Cat using Cats.Show:")
    println(cat.show)
  }

  private def equality(): Unit = {
    val cat2 = Cat("Garfield", 38, "orange and black")

    val optionCat = Option(cat)
    val optionCat2 = Option.empty[Cat]

    println(s"cat === cat: ${cat === cat}")
    println(s"cat === cat2: ${cat === cat2}")
    println(s"cat =!= cat2: ${cat =!= cat2}")
    println(s"Option(cat) === Option(cat): ${optionCat === optionCat}")
    println(s"Option(cat) === Option.empty: ${optionCat === optionCat2}")
    println(s"Option(cat) =!= Option.empty: ${optionCat =!= optionCat2}")
  }
}
