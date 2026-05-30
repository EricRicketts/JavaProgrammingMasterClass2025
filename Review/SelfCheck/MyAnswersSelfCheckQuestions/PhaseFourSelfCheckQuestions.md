## Self-check Questions

### Phase 4: Encapsulation

- What does encapsulation protect you from?

Encapsulation protects from unanticipated object field modifications which can bypass an object's valiation checks.  Lack of encapsulation might violate the underlying assumptions about the data stored on the object, leading to potential errors as the object interacts with the rest of the code base. 

- Why is “private fields + public methods” such a common design?

Private fields limit modification to the class itself, as the field is not exposed to scope outside of the class.  Public methods can contain and provide the desired modification of private fields while maintaing scope security.

- How does hiding data simplify use of a class?

Data hiding encourages the development of well defined interfaces to interact with class data that is otherwise non-accessible.  These interfaces definitively and intentionally limit how to use the class thereby simplifying the resulting implementation.  