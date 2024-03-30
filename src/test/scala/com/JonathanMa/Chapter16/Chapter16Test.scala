import Chapter16Lists._
//import com.JonathanMa.Chapter16.ch16.Chapter16Lists._
import org.scalatest.funsuite.AnyFunSuite

class Chapter16Test extends AnyFunSuite {
  test("Method isort should return an empty list when provided one"){
    assert(isort(List()) == List())
  }
  test("Length of fruits should equal 3") {
    assert(fruits.length == 3)
  }
  test("abcde.last should return 'e' "){
    assert(abcde.last == 'e')
  }
  test("abcde.init should return 'List(a, b, c, d)' "){
    assert(abcde.init == List('a', 'b', 'c', 'd'))
  }
  test("abcde.reverse should return 'List('e', 'd', 'c', 'b', 'a')' "){
    assert(abcde.reverse == List('e', 'd', 'c', 'b', 'a'))
  }
  test("rev(List('a', 'b', 'c') should return 'List('c', 'b', 'a')' "){
    assert(rev(List('a', 'b', 'c')) == List('c', 'b', 'a'))
  }
  test("abcde take 2 should return List('a', 'b')"){
    assert(abcde.take(2) == List('a', 'b'))
  }
  test("abcde drop 2 should return List('c')"){
    assert(abcde.drop(2) == List('c', 'd', 'e'))
  }
  test("abcde.apply(2) should equal abcde(2)"){
    assert(abcde.apply(2) == abcde(2))
  }
  test("abcde.indices should return Range(0, 1, 2, 3, 4)"){
    assert(abcde.indices == (0 to 4))
  }
  test("abcde.zip(List(0, 1, 2)) should return Vector(('a', 0), ('b', 1), ('c', 2))"){
    assert(abcde.zip(List(0, 1, 2)) == List(('a', 0), ('b', 1), ('c', 2)))
  }
  test("abcde.zipWithIndex should return Vector(('a', 0), ('b', 1), ('c', 2), ('d', 3), ('e', 4))"){
    assert(abcde.zipWithIndex == List(('a', 0), ('b', 1), ('c', 2), ('d', 3), ('e', 4)))
  }
  test("abcde.zipWithIndex.unzip should return List((List('a', 'b', 'c', 'd', 'e'), List(0, 1, 2, 3, 4))"){
    assert(abcde.zipWithIndex.unzip == ((List('a', 'b', 'c', 'd', 'e'), List(0, 1, 2, 3, 4))))
  }
  test("abcde.toString should return \"List(a, b, c, d, e)\""){
    assert(abcde.toString == "List(a, b, c, d, e)" )
  }
  test("abcde.mkString(\"[\", \",\", \"]\") should return String = [a, b, c, d, e]"){
    assert(abcde.mkString("[", ", ", "]") == "[a, b, c, d, e]")
  }

  /* 16.7 Higher-order methods on class List */
  test("nums.map(_ * 2) should return List(2, 4, 6, 8)"){
    assert(nums.map(_ * 2) == List(2, 4, 6, 8, 10, 12, 20, 40, 60))
  }
  test("words.map(_.length) should return List(3, 5, 5, 3)"){
    assert(words.map(_.length) == List(3, 5, 5, 3))
  }
  test("words.flatMap(_.toList) should return List(t, h, e, q, u, i, c, k, b, r, o, w, n, f, o, x)"){
    assert(words.flatMap(_.toList) == List('t', 'h', 'e', 'q', 'u', 'i', 'c', 'k', 'b', 'r', 'o', 'w',
      'n', 'f', 'o', 'x'))
  }
  test("nums.filter(_ % 2 == 0) should return List(2, 4, 6, 10, 20, 30)"){
    assert(nums.filter(_ % 2 == 0) == List(2, 4, 6, 10, 20, 30))
  }
  test("nums.partition(_ % 2 == 0) should return (List(2, 4, 6, 10, 20, 30), List(1, 3, 5))"){
    assert(nums.partition(_ % 2 == 0) == (List(2, 4, 6, 10, 20, 30), List(1, 3, 5)))
  }
  test("nums.find(_ % 2 ==0) should return Some(2)"){
    assert(nums.find(_ % 2 == 0).contains(2))
  }
  test("val takeWhile should return should return List(1, 2, 3, 4, 5)"){
    assert(takeWhile == List(1, 2, 3, 4, 5))
  }
  test("val dropWhile should return should return List(6, 10, 20, 30)"){
    assert(dropWhile == List(6, 10, 20, 30))
  }
  test("val span should return should return (List(1, 2, 3, 4, 5), List(6, 10, 20, 30))"){
    assert(span == (List(1, 2, 3, 4, 5), List(6, 10, 20, 30)))
  }
  test("sum should equal to 81"){
    assert(sum == 81)
  }
}
