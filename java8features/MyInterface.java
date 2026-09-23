package java8features;

@FunctionalInterface
public interface MyInterface {
    // The ONE and ONLY abstract method (Must be there)
    //abstract int calculate(int a, int b); OR
     int calculate(int a, int b);

    // Default methods are allowed!
    default void printResult(int result) {
        System.out.println("Result: " + result);
    }

    // Static methods are allowed too!
    static void description() {
        System.out.println("This is a simple calculator interface.");
    }
}


//So in Conclusion, What i got to know about Interface is - An interface can have abstract , static , default and private methods and abstract method has no body and it must be implemented by the other class which implement the interface. and rest of the do not need to be implemented (cannot Override).
// A Normal Interface can have multiple Abstract method but a Functional Interface can have only one Abstract method.

// A Normal Interface doesn't require to have an Abstract method (it can have 0, 1, 2.... number of abstract method).
// But A functional Interface must contain only one Abstract method. (Not 0 , not more than 1)

// Both Interface and Functional Interface can have static,public,private and default methods.