/**
  * GENERIC CLASSES are classes which take a type as a parameter.
  * They are particularly useful for collection classes.
  */
import org.scalatest.FlatSpec

// Defining a generic class
class Stack[A] {
  private var elements: List[A] = List.empty[A]
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

class GenericClassesExampleSpec extends FlatSpec {
  behavior of "generic class"

  it should "allow to use generic class" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop === 2)
    assert(stack.pop === 1)
  }
}
