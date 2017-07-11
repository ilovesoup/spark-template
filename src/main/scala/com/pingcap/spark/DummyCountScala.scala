package com.pingcap.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

import scala.util.Random

object DummyCountScala {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("DummyCountScala")
    val sc = new SparkContext(conf)
    val distData = sc.parallelize(List.range(1L, 101L), 100)
    distData.flatMap(_ => List.range(1L, 101L))
      .mapPartitions(x => {
        val rng = new Random()
        for (_ <- x) yield rng.nextLong()
      }).take(1)
  }
}
