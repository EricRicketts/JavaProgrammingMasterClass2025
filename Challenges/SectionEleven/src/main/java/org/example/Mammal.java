package org.example;

public abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    public abstract String shedHair();
}

/*
    An abstract class that extends another abstract class has additional flexibility.
    1.  It can implement all the parent's abstract methods.
    2.  It can implement some of the parent's abstract methods.
    3.  It can implement none of the parent's abstract methods.
    4.  If it introduces its own abstract methods, then the child class is obligated to
    implement the new abstract class's methods in addition to the abstract methods of the
    abstract parent class.

    Why use an abstract class?
    1.  An abstract class in your hierarchy forces the designers of subclasses to think about
    and create unique and targeted implementations of the abstract methods.
    2.  An abstract class cannot be instantiated, so if one is designing a framework, this is
    definitely an advantage.
*/
