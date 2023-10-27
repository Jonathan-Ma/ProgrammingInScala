import scala.collection.mutable.HashSet

@main def jetSet(): Unit = {
  val jetSet = new HashSet[String]
  jetSet += "Lear"
  jetSet += ("Boeing", "Airbus")
  println(jetSet.contains("cessna"))
}