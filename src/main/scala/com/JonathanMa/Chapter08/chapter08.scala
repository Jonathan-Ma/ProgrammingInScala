import java.io.IOException

object Main {
  def main(args: Array[String]): Unit = {
    // Method and local function result
    try{
      LongLines.processFile(args(0), 10)
    } catch {
      case e: ArrayIndexOutOfBoundsException => println("No file provided")
    }
    var increase = (x: Int) => {
      println("Keep")
      println("GOIN!")
      x + 1
    }
    println(increase(10))

    //foreach applies a function to a collection
    val someNums = List(1,2,3,4,5,6)
    someNums.foreach(x => print(x + 1 + " "))
    println()
    /*
      Or we can use placeholder syntax:
      someNums.foreach(_ + 1)

      Each placeholder represents a parameter that appears exactly once
     */

    //partially applied function example
    def sum(a: Int, b: Int, c: Int): Int = {
      a + b + c
    }
    val a = sum _
    println(a(2, 2, 2))
    // or we can give function value specific values like this:
    val b = sum(1, _, 3)
    println(b(10))
    // this is basically "wrapping" a function with a function value

    // closures refers to a function value created at runtime from a function literal
    var more = 3
    val c = (_: Int)+ more // c is a closure
    println(c(10))
    more = 4
    println(c(10))
    // the closure sees the change and 'more' can also be changed by the closure

  }
}

object LongLines{
  def processFile(fileName: String, width: Int): Unit = {
    def processLine(line: String): Unit = {
      if (line.length > width)
        println(fileName + ": " + line)

    val source = io.Source.fromFile(fileName)
    for (line <- source.getLines())
      processLine(line)
    }
  }
}
