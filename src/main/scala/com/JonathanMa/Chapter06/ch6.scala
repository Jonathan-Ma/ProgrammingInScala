package com.JonathanMa.Chapter06

class Rational(val n: Int, val d: Int){
  require(d != 0)
  // println("Created " +n+ "/" +d) //This will be executed as soon as new instance is created
  private val g = gcd(n.abs, d.abs)
  val gcdNum = n / g
  val gcdDenom = d / g


  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = s"$gcdNum/$gcdDenom" //Whenever you print an object the toString method will be called and interpreter will print class name with @somehex
  // so we override toString print what we want it to print when this object is printed
  def +(that: Rational):Rational = {
    new Rational (n * that.d + that.n * d, d * that.d)
  }

  def +(i: Int): Rational = {
    new Rational(n + i * d, d)
  }

  def lessThan(that: Rational) = this.n * that.d < that.n * this.d

  def max(that: Rational): Rational = if(this.lessThan(that)) that else this

  def this(n: Int) = this(n, 1)


}