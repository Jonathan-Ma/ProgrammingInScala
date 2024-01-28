import org.scalatest.funsuite.AnyFunSuite
import com.JonathanMa.Chapter14.Chapter14._
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AnyFun extends AnyFunSuite {
  test("addPos correctly adds two positive numbers"){
    assertResult(4)(addPos(1, 3))
  }
  test("addPos should throw an AssertionError for non-positive inputs"){
    assertThrows[AssertionError] {
      addPos(1, -2)
    }
  }
}

class AnyFlat extends AnyFlatSpec with Matchers{
  "addPos method" should "correctly add two integers" in {
    addPos(1, 3) should be (4)
  }
  it should "throw AssertException if int provided is negative" in {
    an [AssertionError] should be thrownBy { addPos(1, -3) }
  }
}