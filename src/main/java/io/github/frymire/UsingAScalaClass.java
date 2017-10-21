package io.github.frymire;

import io.github.frymire.AScalaClass;
import io.github.frymire.AScalaClass$;
import scala.Function1;
import scala.Tuple2;
import scala.runtime.AbstractFunction1;

import static io.github.frymire.AScalaClass.youSuck;
import static io.github.frymire.AScalaClass.PI;

public class UsingAScalaClass {

	public static void main(String[] args) {
				
		// Create and use an instance of a Scala class.  (NOTE: dealing with default parameters is a huge pain.)
		AScalaClass anInstance = new AScalaClass();
		anInstance.sayHello();
			    
		// You can call youSuck() from the companion object without any trouble, because there's no  
		// method with the same name in the class. However, you can't call sayHello() in the companion object  
		// directly, because it's hidden by the sayHello() method in the class.  Use the second form instead.
		AScalaClass.youSuck("Tony Romo");
		AScalaClass$.MODULE$.sayHello();  // AScalaClass.sayHello(); gives an error

		// Alternatively, you can import companion object members and methods statically (see import statements above).
    youSuck("Tom Brady");
    System.out.println(PI());
		
		// You can access members as you'd expect.  Note, though, that Scala convention doesn't use "get" and "set".
		// In Scala, you create mutable variables with a "var" modifier, but you are encouraged instead to create 
		// immutable instances by declaring variables with "val".  In the latter case, there is no "=" operator.
		// Also, since Java doesn't allow symbols like "=" in its function names, those get spelled out with a "_$eq",
		// so the equivalent of ".setMember(newValue)" is ".member_$eq(newValue)".
		System.out.println("valMember = " + anInstance.valMember());
		System.out.println("varMember = " + anInstance.varMember());
		// anInstance.valMember_$eq(5); // No such thing for a variable declared in Scala with val.
		anInstance.varMember_$eq(5);  // Reassign a var.
		System.out.println("varMember = " + anInstance.varMember());
				
		// Here's how to handle a Scala tuple
		// TODO: Figure out how to get Java to recognize this explicitly as a Tuple2<scala.Int, scala.Int>
		Tuple2<Object, Object> myTuple = anInstance.getATuple();		
		System.out.println(myTuple._1());
		System.out.println(myTuple._2());		
		
		// Create a function that we can pass to a Scala method.
		Function1<Object, String> f = new AbstractFunction1<Object, String>() {			
		    public String apply(Object someInt) { return someInt.toString(); }		    
		};	
		
		// Pass the function to a Scala method.
		// TODO: Java treats apply10toFunction() as a Function1<Object, String>.  Can we force it to expect a 
		// Function1<scala.Int, String> instead?  (You can define the AbstractFunction1 as scala.Int => String here in Java.)
		System.out.println(AScalaClass.apply10toFunction(f));						
	}

}
