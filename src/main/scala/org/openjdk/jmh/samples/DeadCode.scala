package org.openjdk.jmh.samples

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations=1) @Measurement(iterations=1) @Fork(1) @Threads(1)
class DeadCodeScala {
  @Benchmark
  def measureLogWrong1: Unit = { Math.log(Math.PI) }
  @Benchmark
  def measureLogWrong3: Double = Math.log(Math.PI)

  private var x = Math.PI
  @Benchmark
  def measureLogWrong2: Unit = { Math.log(x) }
  @Benchmark
  def measureLogRight: Double = Math.log(x)
}
