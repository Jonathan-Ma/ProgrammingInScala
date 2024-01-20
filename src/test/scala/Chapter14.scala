import org.scalatest.funsuite.AnyFunSuite
import com.JonathanMa.Chapter14.Chapter14._

class Chapter14 extends AnyFunSuite {
  test("addPos should throw an AssertionError for non-positive inputs"){
    assertThrows[AssertionError] {
      addPos(1, -2)
    }
  }
}