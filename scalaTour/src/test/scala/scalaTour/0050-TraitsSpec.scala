/**
  * Traits are used to share interfaces and fields between classes.
  */
import org.scalatest.{FlatSpec, Matchers}

class TraitsExampleSpec extends FlatSpec {
  "Traits" should "be useful as generic types and with abstract methods" in {

    trait Iterator[A] {
      def hasNext: Boolean
      def next(): A
    }

    class IntIterator(to: Int) extends Iterator[Int] {
      private var current = 0
      override def hasNext: Boolean = current < to
      override def next(): Int = {
        if (hasNext) {
          val t = current
          current += 1
          t
        } else {
          0
        }
      }
    }

    val iterator = new IntIterator(3)

    assert(iterator.next() === 0)
    assert(iterator.next() === 1)
    assert(iterator.next() === 2)
    assert(iterator.next() === 0)
  }
}
