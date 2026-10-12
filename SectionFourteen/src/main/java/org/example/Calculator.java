package org.example;

public class Calculator {

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        // This is a functional interface, but it is manually created.  In other code and
        // tests we will look at Java's built-in functional interfaces.
        // Note a functional interface in Java is an interface that contains exactly one
        // abstract method, making it suitable for use with lambdas and method references.
        // Looking at the arguments, they are functionally typed; value1 and value2 are typed
        // according to what is specified as T, during the call to calculator.  Note
        // Operation <T> is a call to the Operation interface, which has been defined in
        // the main executable path.
        return function.operate(value1, value2);
    }
}
