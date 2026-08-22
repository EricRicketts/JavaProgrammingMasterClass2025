package org.example;

// Annotation below warns developers not to introduce future abstract methods to this interface.
@FunctionalInterface
public interface Operation<T> {

    T operate(T value1, T value2);
}
