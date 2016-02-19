package org.openjdk.jmh.samples

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations=1) @Measurement(iterations=1) @Fork(1) @Threads(1)
class ClassHierarchyAnalysis {
  trait TopLevelA {
    def get: Int
  }
  class ThingA1(v: Int) extends TopLevelA {
     def get = v
  }
  class ThingA2(v: Int) extends TopLevelA {
     def get = v
  }
  class ThingA3(v: Int) extends TopLevelA {
     def get = v
  }
  class ThingA4(v: Int) extends TopLevelA {
     def get = v
  }


  trait TopLevelB {
    def get: Int
  }
  class ThingB(v: Int) extends TopLevelB {
     def get = v
  }

  val topLevelA1: TopLevelA = new ThingA1(1)
  val topLevelA2: TopLevelA = new ThingA2(2)
  val topLevelA3: TopLevelA = new ThingA3(1)
  val topLevelA4: TopLevelA = new ThingA4(2)
  val topLevelB1: TopLevelB = new ThingB(1)
  val topLevelB2: TopLevelB = new ThingB(2)

  @Benchmark
  def multipleClasses = {
    topLevelA1.get + topLevelA2.get + topLevelA3.get + topLevelA4.get
  }
  @Benchmark
  def singleClass = {
    topLevelB1.get + topLevelB2.get + topLevelB1.get + topLevelB2.get
  }
}
