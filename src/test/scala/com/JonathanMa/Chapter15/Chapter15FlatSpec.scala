import com.JonathanMa.Chapter15.Chapter15
import com.JonathanMa.Chapter15.Chapter15._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Chapter15FlatSpec extends AnyFlatSpec with Matchers {
  "simplifyTop" should "remove double negation in UnOp expressions" in {
    val expr = UnOp("-", UnOp("-", Var("x")))
    simplifyTop(expr) shouldEqual Var("x")
  }

  it should "return the original number when added to 0" in {
    val expr = BinOp("+", Var("x"), Number(0))
    simplifyTop(expr) shouldEqual Var("x")
  }
}

class Chapter15AnySpec extends AnyFunSuite {
  test("simplifyTop should return Var(\"x\") for BinOp(\"*\", Var(\"x\"), Number(1))") {
    val result = simplifyTop(BinOp("*", Var("x"), Number(1)))
    assert( result == Var("x"), "simplifyTop did not return the expected result")
  }

  test("simplifyTop(BinOp(\"*\", Number(0), Var(\"x\")) should return 0 ") {
    val result = simplifyTop(BinOp("*", Number(0), Var("x")))
    assert(result == 0, "simplifyTop did not return 0")
  }

  test("show() should return correct capital") {
    val testCases = Map(
      "France" -> "Paris",
      "Japan" -> "Tokyo"
    )

    testCases.foreach{ case (country, expectedCapital) =>
      assert(show(testCases get country) === expectedCapital)
    }
  }
}
