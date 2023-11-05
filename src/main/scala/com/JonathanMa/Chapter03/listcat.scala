package com.JonathanMa.Chapter03

object listcat {
  def trylist(): Unit = {
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val cat = oneTwo ::: threeFour
    println(s"${oneTwo} and ${threeFour} were not mutated.")
    println(s"Thus, ${cat} is a new List.")
  }
}