package com.JonathanMa.Chapter07

object chapter7{
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
  for(i <- list if i % 2 == 0) {
    println(i)
  }
  // Some for iterations

  def fileLines(file: java.io.File): Array[String] = scala.io.Source.fromFile(file).getLines().toArray
  def grep(pattern: String) =
    for (file <- filesHere if file.getName.endsWith(".scala"))
      for (line <- fileLines(file) if line.contains(pattern))
        println(s"$file: ${line.trim}")
}