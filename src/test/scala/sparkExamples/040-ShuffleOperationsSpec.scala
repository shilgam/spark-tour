/**
  * Certain operations within Spark trigger an event known as the SHUFFLE.
  * The shuffle is Spark’s mechanism for re-distributing data
  * so that it’s grouped differently across partitions.
  * This typically involves copying data across executors and machines,
  * making the shuffle a complex and costly operation.
  */
