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