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