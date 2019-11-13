/**
  * This program implements a singly-linked list.
  *
  * The term U >: B expresses that the type parameter U or the abstract type U
  * refer to a supertype of type B
  */
trait Node[+B] {
  def prepend[U >: B](elem: U): Node[U]
}

/** class ListNode is a node which contains an element of type B (head)
  * and a reference to the rest of the list (tail).
  */
case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
  def head: B = h
  def tail: Node[B] = t
}

/** Nil represents an empty element (i.e. an empty list).
  */
case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
}

import org.scalatest.FlatSpec

class LowerTypeBoundsExampleSpec extends FlatSpec {
  behavior of "Lower Type Bounds"

  it should "declare a type to be a supertype of another type" in {

    trait Bird
    case class AfricanSwallow() extends Bird
    case class EuropeanSwallow() extends Bird

    val africanSwallowList = ListNode[AfricanSwallow](AfricanSwallow(), Nil())
    val birdList: Node[Bird] = africanSwallowList
    /** Node[Bird] can be assigned the africanSwallowList but then accept EuropeanSwallow's
      */
    birdList.prepend(EuropeanSwallow())
  }
}
