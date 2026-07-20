Some important learning points here:

A concrete (non-abstract) subclass extending an abstract class is required to implement all inherited abstract methods.
If the subclass fails to implement any of these methods, it must itself be declared as abstract.

Key rules include:

1.  Concrete Subclasses: Must provide implementations for all abstract methods from parent abstract classes; otherwise,
the code will not compile.

2.  Abstract Subclasses: Can remain abstract without implementing inherited abstract methods, effectively passing the
implementation burden to their own concrete subclasses.

3.  Intermediate Implementations: If an intermediate abstract class provides an implementation for a parent's abstract
method, that method is no longer considered abstract for subsequent subclasses.

On the ***FliersTest.java*** file we see the advantage of using a more general type for the
argument to the ***trigger***, ***fly***, and ***land*** methods.  Notice for each of those methods, we used a
***List*** which is the most general of all the _List_ types.  Because of this in each of my following tests, I was
about to use a _List_ type, an _ArrayList_ type, and a _LinkedList_ type without any modification to the code.  Note
in the previous version of the code for each of the methods I specified a _List<FlightEnabled>_.  For each of the
method arguments, but I had to cast the _List<FlightEnabled>_ to an _ArrayList<FlightEnabled>_ because that is what
the initial method specified as an argument.  As we can see the initial version of the method overly constrained the
argument type.

Before ***JDK 8***, the _Interface type_ could only have _public abstract_ methods.  JDK8 introduced the _default_ and
_public static_ methods and ***JDK 9*** introduced _private_ methods both _static_ and _non-static_.  All of these
new method types are (on an interface) are _concrete methods_.  

Before ***JDK 8*** there was a problem when a developer decided to update an interface, specifically add a new
abstract method.  This meant all classes which implemented the interface had to implement the new abstract method.
As an example in the _FlightEnabled_ interface is a new method was added _FlightStages transition(FlightStages stage)_
then the _Bird_, _DragonFly_ and _Eagle_ classes all had to implement the new method.  For three classes the update is
no so bad but if 50 classes implemented the interface the update would be a lot of work.

Java solved this problem by introducing the _Interface Extension Method_.  This extension method is identified by the
_default_ modifier, this is more commonly known as the _default method_.  This method is a _concrete method_ meaning
we can add a code block with the accompanying statements.  The key point here is adding a _default method_ does not
break classes implementing the interface.  

Another enhancement in JDK 8 was support for public static methods on an interface.  In calling this
public static method, you must prefix the method name with the Interface name.

Remember all methods on an Interface are public unless otherwise specified.

JDK 9 gave the developer community private Interface methods both static and non-static.

A private static method on an Interface can be accessed by one of: A public static method,
a default method, or a private non-static method.

A private non-static method on an Interface can be accessed by one of: default method or
other private methods.

When to use an Abstract class versus an Interface.

Characteristics of an Abstract Class:

1. With an Abstract class you can declare fields that are not static and final, instance fields.
2. With an Abstract class you can use any of the four access modifiers for its concrete methods.
3. You can use all but the private access modifier for its abstract methods.
4. An Abstract class can only extend one parent class, but it can have multiple interfaces.
5. When an Abstract class is subclassed, the child class provides for implementations of all
the abstract methods in its parent class.  if the child class does not do this, then it must
be declared abstract.

Characteristics of an Interface:

1. An Interface is just the declaration of methods, which you want some classes to have; it is
not the implementation.
2. In an Interface, we define what kind of operation an Object can preform.  These operations
are defined by the classes that implement the Interface.
3. Interfaces form a contract between the class and the outside world, and this contract is
enforced at build time by the Java compiler.
4. You cannot instantiate Interfaces, but they can contain a mix of methods with or without an
implementation.
5. All methods on interfaces declared without a method body are automatically public and abstract.
6. All concrete methods declared in an Interface are public unless otherwise specified.
7. An interface can extend another interface.
8. Interfaces are more flexible and can deal with a lot more stress on the design of your
program because they are not part of the class hierarchy.
9. A best practice of coding is commonly called "Coding to an Interface".
10. By Introducing Interfaces, you are really introducing points of variation, at which
    you can plug in different implementations of that Interface.
11. Summary: The Interface decouples the "what" from the "how", and is used to make different
   types behave in similar ways.
12. Since Java 8, Interfaces can now contain default methods, i.e., methods with implementation.
13. Since Java 9, Interfaces can now contain private methods, commonly used when default methods
    share common code.

When to use an Abstract Class:

1. Use an abstract class when you want to share code among several closely related classes.
2. You expect classes that extend your abstract class to have many common methods or fields
or require access to modifiers other than public.
3. You want to declare non-static or non-final fields (for example, name, age).  This enables
you to define methods that access and modify the state of an object (getName, setName).
4. You have a requirement for your base class to provide a default implementation of certain
methods, but other methods are subject to being overridden by the child classes.
5. Summary: An Abstract Class provides a common definition, as a base class, that multiple
derived classes can share.

When to use an Interface:

1. You expect unrelated classes will use your Interface.
2. You want to specify the behavior of a particular data type, but you are not concerned
about who implements the behavior.
3. You want to separate different behaviors.
