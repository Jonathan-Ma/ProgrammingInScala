import Chapter16Lists.isort
//import com.JonathanMa.Chapter16.ch16.Chapter16Lists._
import org.scalatest.funsuite.AnyFunSuite

class Chapter16Test extends AnyFunSuite {
  test("Method isort should return an empty list when provided one"){
    assert(isort(List()) == List())
  }
}
