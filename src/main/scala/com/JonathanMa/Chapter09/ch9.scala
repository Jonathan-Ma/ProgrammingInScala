package com.JonathanMa.Chapter09

import java.io.File


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