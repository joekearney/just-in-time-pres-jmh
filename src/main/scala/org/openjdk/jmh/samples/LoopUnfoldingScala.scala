package org.openjdk.jmh.samples

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations=1) @Measurement(iterations=1) @Fork(1) @Threads(1)
class LoopUnfoldingScala {

  val a = 1
  val b = 2

  @Benchmark
  def measureRight: Int = { a + b }

  private def reps(reps: Int): Int = {
    var s = 0
    var i = 0

    while (i < reps) {
      s += (a + b)
      i += 1
    }

    s
  }

  @Benchmark @OperationsPerInvocation(100)
  def measureLoop100: Int = reps(100)
  @Benchmark @OperationsPerInvocation(10000)
  def measureLoop10000: Int = reps(10000)
}
