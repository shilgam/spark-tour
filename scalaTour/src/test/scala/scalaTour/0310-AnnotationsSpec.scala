/**
  * ANNOTATIONS
  */
import org.scalatest.FunSpec

class AnnotationsExampleSpec extends FunSpec {
  describe("Annotation") {
    describe("the '@deprecated' annotation before a method") {
      it("should cause the compiler to print a warning if the method is used") {
        object DeprecationDemo {
          @deprecated(
            "deprecation message",
            "release # which deprecates method"
          )
          def hello: String = "hola"

          hello
        }
      }
    }

    describe("Ensuring correctness of encodings") {
      describe("(when tail-recursive implementation)") {
        it("should be compliled successfully") {
          import scala.annotation.tailrec

          def factorial(x: Int): Int = {

            /** The factorialHelper method has the @tailrec which ensures the method
              * is indeed tail-recursive.
              */
            @tailrec
            def factorialHelper(x: Int, accumulator: Int): Int = {
              if (x == 1) {
                accumulator
              } else {
                factorialHelper(x - 1, accumulator * x)
              }
            }
            factorialHelper(x, 1)
          }
        }
      }

      describe("(when non tail-recursive implementation)") {
        it("should fail") {
          import scala.annotation.tailrec

          def factorial(x: Int): Int = {
            // @tailrec
            /** uncomment this to see compilation error:
              * <<<could not optimize @tailrec annotated method>>>
              */
            def factorialHelper(x: Int): Int = {
              if (x == 1) 1 else x * factorialHelper(x - 1)
            }
            factorialHelper(x)
          }
        }
      }
    }
  }
}
