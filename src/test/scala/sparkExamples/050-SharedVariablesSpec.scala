/**
  * Normally, when a function passed to a Spark operation (such as map or reduce)
  * is executed on a remote cluster node, it works on separate copies of all the
  * variables used in the function.
  * These variables are copied to each machine, and no updates to the variables
  * on the remote machine are propagated back to the driver program.
  *
  * However, Spark does provide two limited types of shared variables for two common usage patterns:
  * broadcast variables and accumulators.
  */
import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FunSpec

class SharedVariablesSpec extends FunSpec with SharedSparkContext {

  describe("Shared Variables") {
    describe("broadcast variables") {
      it("allows to keep a read-only variable cached on each machine") {

        /** Spark automatically broadcasts the common data needed by tasks within each stage.
          * Explicitly creating broadcast vars is only useful when tasks across multiple stages
          * need the same data OR when caching the data in deserialized form is important
          */
        var v = Array(1, 2, 3)
        val broadcastVar = sc.broadcast(v)

        /** After the broadcast var is created, it should be used instead of the value v in any functions
          * run on the cluster so that v is not shipped to the nodes more than once.
          */

        /** In addition, the object v should not be modified after it is broadcast
          * in order to ensure that all nodes get the same value of the broadcast variable
          * (e.g. if the variable is shipped to a new node later).
          */
        v = Array(0, 2, 4)

        assert(broadcastVar.value === Array(1, 2, 3))
      }
    }

    describe("Accumulators") {
      it("can be used to implement counters or sums") {
        val accum = sc.longAccumulator("My Accumulator")

        sc.parallelize(Array(1, 2, 3, 4)).foreach(x => accum.add(x))

        assert(accum.value === 10)
      }
    }
  }
}
