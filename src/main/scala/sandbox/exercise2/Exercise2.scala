package sandbox.exercise2

import cats.implicits._
import cats.{Monoid, Semigroup}
import sandbox.exercise2.OrderMonoidInstances._

object Exercise2 {

  def main(args: Array[String]): Unit = {
    println("Add 10: " + addSimple(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println("Add 10 explicit: " + addExplicit(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println("Add 10 generic: " + addGeneric(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println("Add 10 generic with option: " + addGeneric(Seq(Some(1), Some(2), None, None, Some(5), Some(6), None, None, Some(9), None)))
    println("Add 10 generic with option: " + addGenericOption(Seq(Some(1), Some(2), None, None, Some(5), Some(6), None, None, Some(9), None)).flatten)

    val orders = Seq(Order(1, 2), Order(4, 5), Order(7, 8))
    println("Add orders: " + addGenericOption(orders))
  }

  private def addSimple(items: Seq[Int]): Int = Monoid[Int].combineAll(items)

  private def addExplicit(items: Seq[Int]): Int = items.foldLeft(Monoid[Int].empty)(_ |+| _)

  private def addGeneric[T: Monoid](items: Seq[T]): T = Monoid[T].combineAll(items)

  private def addGenericOption[T: Semigroup](items: Seq[T]): Option[T] = Semigroup[T].combineAllOption(items)
}
