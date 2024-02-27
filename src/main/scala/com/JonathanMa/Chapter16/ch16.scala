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
  val nums: List[Int] = 1 :: (2 :: (3 :: Nil))
  val diag: List[List[Int]] = 1 :: (0 :: (0 :: Nil)) :: (0 :: (1 :: (0 :: Nil))) :: (0 :: (0 :: (1 :: Nil))) :: Nil
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

  /*16.6 Concatenating two lists*/
  //example: List(1, 2) ::: List(3, 4, 5) -> List(1, 2, 3, 4, 5)
  /*
    Or we can make a create an append function because its more instructive.
   */
  def append(xs: List[T], ys: List[T]):List[T] =
    xs match {
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
    }
  }

