import Chapter16Lists.fruits

object Chapter16Lists {
/*
  Chapter 16: Working with Lists
    Some things to remember about Lists:
      1. They are immutable, operations always creates a new List
      2. They are recursive data structures
      3. They are homogeneous - elements can only have one type
      4. List type is covariant(List[+T]).
 */

  // 16.3 Constructing lists and list literals

  val fruits: List[String] = "lemon" :: ("orange" :: ("watermelon" :: Nil))
  val nums: List[Int] = 1 :: (2 :: (3 :: (4 ::Nil)))
  // We can leave out the parentheses:
  val reg: List[String] = "hello" :: "there" :: "!" :: Nil

  //insertion sort to show how lists can be processed
  def isort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))
  }
  def insert(x: Int, xs: List[Int]): List[Int] = {
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)
  }

  /*16.5 List patterns*/
  val List(a, b, c) = fruits
  // a: String = lemon
  // b: String = orange
  // c: String = watermelon
  // or use :: if you dont know the length of the list
  // j = 1 and rest is List(1, 2)
  val j :: rest = nums

  /*16.6 First order methods on class List*/

  // Taking the length of a list
  val length: Int = fruits.length

  // Accessing the end of a list: init and last
  val abcde: List[Char] = List('a', 'b', 'c', 'd', 'e')
  // abcde.last returns 'e' and abcde.init returns List(a, b, c, d)

  // Reversing lists: abcde.reverse -> List(e, d, c, b, a)
  // Reverse can be implemented using concatenation (:::):
  def rev[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
  }
  /* Following will be in test suites */
  /* Prefixes and suffixes: drop, take, splitAt */
  // spliAt returns two lists that is split at n
  // take returns a list of first n elements
  // drop returns list of elements after n
  //abcde spliAt 2 equals abcde take 2, abcde drop 2

  /* Element selection: apply and indices */
  // apply is basically element selection: abcde(3) is the same as abcde.apply(3)
  // indices just returns a range of the number of elements: abcde.indices -> Range(0, 1, 2, 3, 4)

  /* Flattening a list of lists: flatten */
  // List(List(1, 2), List(3), List(), List(4, 5)).flatten -> List(1, 2, 3, 4, 5)

  /* Zipping lists: zip and unzip */
  // abcde.indices zip abcde -> Vector((0,a), (1,b), (2,c), (3,d), (4,e))
  // the above can also be done with zipWithIndex: abcde.zipWithIndex
  // Any list of tuples can be unzipped back into a tuple of lists by using unzip method
  // abcde.zipWithIndex.unzip -> List(List('a', 'b', 'c', 'd', 'e'), List(0, 1, 2, 3, 4))

  /* Displaying lists: toString and mkString */
  // abcde.toString -> String = List(a, b, c, d, e)
  // abcde.mkString("[", ",", "]") -> String = [a, b, c, d, e]

  /* Converting lists: iterator, toArray, copyToArray */
  // abcde.toArray -> Array(a, b, c, d, e)

  /* 16.7 Higher-order methods on class List */
  /* Mapping over lists: map, flatmap and foreach */
  // val nums = List(1, 2, 3, 4)
  // nums.map(_*2) -> List(2, 4, 6, 8)
  val words = List("the", "quick", "brown", "fox")
  // words.map(_.length) -> List(3, 5, 5, 3)


}
