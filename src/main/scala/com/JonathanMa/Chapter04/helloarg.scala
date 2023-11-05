package com.JonathanMa.Chapter04
object Helloarg {
  def HelloArg(args: String*): Unit = println("Hello, " + args(0) + "!")
}
