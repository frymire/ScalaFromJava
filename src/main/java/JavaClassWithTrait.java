
public class JavaClassWithTrait implements AScalaTrait {

  // Satisfy the trait's "value: Nothing => Object" requirement
  public Object value() { return "You just called JavaClassWithTrait.value()."; }

  // Satisfy the trait's printValue() requirement.  Ignore the Eclipse error, it works just fine.
  public void printValue() { AScalaTrait$class.printValue(this); }

  public static void main(String[] args) {
    JavaClassWithTrait myJCWT = new JavaClassWithTrait();
    System.out.println( myJCWT.value() );
    myJCWT.printValue();
  }

}