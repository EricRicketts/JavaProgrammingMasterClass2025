package org.example;

import java.util.Objects;

public class Dog extends Animal {
    /*
        The "extends" keyword is used to indicate one class is inheriting from another.
        In this case the Dog class is inheriting from the Animal class.  When inheritance
        takes place, the subclass (inheriting class) gets all the attributes (fields) as long
        as those attributes and methods are not private.  Private fields and methods are not
        inherited from a parent class to a child class.
    */

    private String earShape, tailShape;

    public Dog() {
        // This is the no-arguments constructor for the Dog class.  It makes a call to the
        // three-argument constructor in the Animal class.  If one does not make a call to
        // "super" in the constructor, then Java makes an implicit call to the super class
        // default constructor.  If your super class does not have a default constructor, then
        // you must explicitly call "super" in all of your child class constructors passing
        // in the correct arguments for each call.
        super("Mutt", "Big", 50);
    }

    public Dog(String type, double weight) {
        // The keyword "this" enables us to call the four-argument constructor
        // defined immediately below.
        this(type, weight, "Perky", "Curled");
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        // A call is made to the super constructor (Animal) using an expression instead
        // of a passed-in parameter to set the weight of the dog.  The "super" keyword,
        // much like the "this" keyword, must be first in the constructor call.  Though
        // the "super" keyword refers to the three-argument constructor in the Animal
        //  class, the call to the "super" constructor is made within the context of
        // the Dog class.  Thus, at the end of this constructor all, an instance of the
        // Dog class is created.
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    /*
        Another important note here, all subclasses can execute the methods of the parent
        class even though the code itself is declared in the parent class.  Below we
        have the move() and makeNoise() methods from the parent class.  However, they
        are overridden in the child class to add additional functionality.  An override
        occurs when you define a method in the subclass which as the same signature as
        the parent class method.
    */
    @Override
    public String move(String speed) {
        String moveString;
        super.move(speed);
        if (Objects.equals(speed, "slow")) {
            moveString = walk() + "  " + wagTail();
        } else {
            moveString = run() + "  " + bark();
        }
        return moveString;
    }

    @Override
    public String makeNoise() {
        String noiseString;
        if (Objects.equals(type, "Wolf")) {
            noiseString = "Wolf is Howling.";
        } else {
            noiseString = bark();
        }
        return noiseString;
    }

    /*
        Four methods below are unique to dog behavior.
    */
    private String bark() {
        return "Woof!";
    }

    private String run() {
        return "Dog Running!";
    }

    private String walk() {
        return "Dog Walking!";
    }

    private String wagTail() {
        return "Dog Wagging Tail!";
    }

    @Override
    public String toString() {
        /*
            This toString() method makes a call to "super" from the parent class.
            However, unlike the constructor's use of "super" this call to "super"
            is used in an object context.  We now have access to the parent class
            methods in child class methods, which means we can call parent class
            methods in the child context.  In this case since the parent class
            toString() method captures all the information we need about the
            parent class attributes, there is no need to define a method in the
            child class to return a string containing the parent class attributes.
        */
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }
}
