package sandbox.exercise2

import cats.Semigroup

case class Order(totalCost: Double, quantity: Double)

object OrderMonoidInstances {

  implicit val orderMonoid: Semigroup[Order] = Semigroup.instance[Order] { (o1, o2) =>
    Order(o1.totalCost + o2.totalCost, o1.quantity + o2.quantity)
  }
}
