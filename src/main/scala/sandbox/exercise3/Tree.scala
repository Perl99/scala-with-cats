package sandbox.exercise3

import cats.Functor

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object TreeFunctorInstances {

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = {
      tree match {
        case Branch(left, right) => Branch(map(left)(f), map(right)(f))
        case Leaf(value) => Leaf(f(value))
      }
    }
  }
}
