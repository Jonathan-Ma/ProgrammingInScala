package com.JonathanMa.Chapter07

import java.io.FileReader
import java.io.FileNotFoundException

object chapter7 {
  val filesHere = (new java.io.File("src/main/scala/com/JonathanMa/Chapter07")).listFiles
  // Gets files and creates array of file names

  println("Using for to print files in current directory")
  for (file <- filesHere)
    println(file)
  println()
  // prints the file object

  println("For iteration with range 1 to 4")
  for (i <- 1 to 4)
    println(s"Iteration $i")
  println("For iteration with range 1 until 4")
  for (i <- 1 until 4)
    println(s"Iteration $i")
  println()
  println("For iteration filtering even num fof a list 1-20 using guard")
  val list = for (i <- 1 to 20) yield i
  for (i <- list if i % 2 == 0) {
    println(i)
  }
  // Some for iterations

  def fileLines(file: java.io.File): Array[String] = scala.io.Source.fromFile(file).getLines().toArray

  def grep(pattern: String) =
    for (file <- filesHere if file.getName.endsWith(".scala"))
      for (line <- fileLines(file) if line.contains(pattern))
        println(s"$file: ${line.trim}")

  //Some file handling with for comprehension
  def tryCatching(): Unit = {
    try {
      val file = new FileReader("input.txt")
    }
    catch {
      case ex: FileNotFoundException => println("where the file foo?")
    }
  }
  // error handling with try catch finally

  // Returns a row as a sequence
  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    } // Returns a row as a string

  def makeRow(row: Int) = makeRowSeq(row).mkString

  // Returns table as a string with one row per line
  def multiTable() = {
    val tableSeq = // a sequence of row strings
      for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }
}