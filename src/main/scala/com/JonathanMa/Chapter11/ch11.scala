/*
  11 Scala's Hierarchy
    All classes inherits from Any class which contains methods like
      final def ==(that: Any): Boolean
      final def !=(that: Any): Boolean
      def equals(that: Any): Boolean
      def ##: Int
      def hashCode: Int
      def toString: String
    Because every class inherits from Any, every object in Scala program can be compared using
    ==, !=, or equals; hashed, and formatted using toString.


*/