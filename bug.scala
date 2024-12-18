```scala
class MyClass[T](val value: T) {
  def myMethod(implicit ev: T => Ordering[T]): Unit = {
    println(value)
  }
}

object Main extends App {
  implicit val intOrdering = Ordering.Int

  val myInt = new MyClass(10)
  myInt.myMethod // Works fine

  val myString = new MyClass("hello")
  myString.myMethod // This will cause a compile time error
}
```