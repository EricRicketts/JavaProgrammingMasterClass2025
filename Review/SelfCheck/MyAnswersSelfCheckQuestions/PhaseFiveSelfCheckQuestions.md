## Self-check Questions

### Phase 5: Encapsulation

- Why use inheritance instead of copying code?

Inhertitance is a more efficient way, via the `extends` keyword in the class declaration, of providing all the fields and methods of the parent class to the subclass without doing an explicit copy.  Otherwise, all subclasses would be forced to copy the code of the parent class to get access to the parent's fields and methods.   

- What does `super()` do?

`super()` enables the subclass to call the parent constructor and do initialization in the parent class which is shared by the subclass, without having to declare those identical constructors and fields in the subclass.

- When is inheritance a bad fit?

If there are no shared traits and behavior between a class and a potential parent then inheritance would not make any sense.