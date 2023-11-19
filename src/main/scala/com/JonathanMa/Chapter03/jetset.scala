package com.JonathanMa.Chapter03
import scala.collection.mutable.HashSet

object jetset {
  def jetSet(): Unit = {
    val jetSet = new HashSet[String]
    jetSet += "Lear"
    jetSet += ("Boeing", "Airbus")
    println(jetSet.contains("cessna"))
  }
}