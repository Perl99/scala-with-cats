package sandbox.exercise3

import cats.implicits._
import sandbox.exercise3.CodecInstances._
import sandbox.exercise3.PrintableInstances._
import sandbox.exercise3.TreeFunctorInstances._

object Exercise3 {

  def main(args: Array[String]): Unit = {
    val tree: Tree[Int] = Branch(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), Leaf(4))

    println(tree.map(_ + 1))

    println(PrintableInstances.format("hello"))
    println(PrintableInstances.format(true))

    println(PrintableInstances.format(Box("hello world")))
    println(PrintableInstances.format(Box(false)))

    println(CodecInstances.encode(123))
    println(CodecInstances.decode[Boolean]("true"))
    println(CodecInstances.encode(Box(3.14)))
    println(CodecInstances.decode[Box[Double]]("3.14"))
  }
}
