```scala
class MyClass[T](val value: T) {
  def myMethod(implicit ev: Ordering[T]): Unit = {
    println(value)
  }
}

object Main extends App {
  implicit val intOrdering = Ordering.Int

  val myInt = new MyClass(10)
  myInt.myMethod // Works fine

  implicit val stringOrdering = Ordering.fromLessThan[String](_ < _)

  val myString = new MyClass("hello")
  myString.myMethod // Works now with provided implicit Ordering
}
```