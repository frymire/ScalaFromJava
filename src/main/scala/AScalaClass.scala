
trait AScalaTrait { 
  def value: Any
  def printValue = println(value) 
}


class AScalaClass {  
  val valMember = 42;
  var varMember = 0; 
  def sayHello = println("Hello (class)")  
  def getATuple = (1, 2)     
}


object AScalaClass {
  val PI = 3.14
  def sayHello = println("Hello (object)") 
  def youSuck(name: String) = println(s"$name sucks.")  
  def apply10toFunction(f: Int => String) = f(10)
}