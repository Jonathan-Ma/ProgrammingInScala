package com.JonathanMa.Chapter03
import scala.collection.mutable.HashMap

object Maps {
  def Hashmap(): Unit = {
    val treasueMap = new HashMap[Int, String]
    treasueMap += (1 -> "Go to island")
    treasueMap += (2 -> "Find big X")
    treasueMap += (3 -> "Dig")

    println(treasueMap(2))

    val romanNumerals = Map(
      1 -> "I",
      2 -> "II"
    )

    println(romanNumerals(1))
  }
}