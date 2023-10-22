@main def myScript(args: String*): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}