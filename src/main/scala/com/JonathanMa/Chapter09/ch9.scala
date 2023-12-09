package com.JonathanMa.Chapter09

import java.io.{File, PrintWriter}


object FileMatcher {
  private val files = new java.io.File(".").listFiles

  def fileEnding(query: String): Array[File] = for (file <- files; if file.getName.endsWith(query))
    yield file

  def fileContains(query: String): Array[File] = for (file <- files; if file.getName.contains(query))
    yield file

  def fileMatch(query: String): Array[File] = for (file <- files; if file.getName.matches(query))
    yield file


}

object FileMatcher2 {
  private val files = new File(".").listFiles()

  private def fileMatcher(method: String => Boolean): Array[File] = for (file <- files; if method(file.getName))
    yield file

  def fileRegex(query: String): Array[File] = fileMatcher(_.matches(query))

  def fileContain(query: String): Array[File] = fileMatcher(_.contains(query))

  def fileEnds(query: String): Array[File] = fileMatcher(_.endsWith(query))
}

object Section2{
  def containsNeg(nums: List[Int]): Boolean = nums.exists(_ < 0)
  def containsOdd(nums: List[Int]): Boolean = nums.exists(_ % 2 == 1)
}

object Section3{
  def curriedSum(x: Int)(y: Int): Int = x + y

  def onePlus: Int => Int = curriedSum(1) _
}

object Section4{
  def twice(op: Double => Double, x: Int) = op(op(x))

  def withPrintWriter(file: File, op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)

    try{
      op(writer)
    } finally {
      writer.close()
    }
  }
  // note: you can use curly braces to provide argument to a function that only takes one parameter

  
}