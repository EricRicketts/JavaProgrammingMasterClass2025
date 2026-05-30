## Self-check Questions

### Phase 2: Constructors and initialization patterns

- Why is constructor chaining useful?

Constructor chaining is useful because it avoids writing duplicate code for each individual constructor.  A primary constructor can be used and each of the other constructors can call the primary constructor using the keyword "this" and mapping their arguments to the arguments of the primary constructor.  Additionally, all data integrity checks for constructor arguments along with assignment to any class fields should be in the body of the primary constructor.

- Which constructor should contain the actual assignment logic?

The primary constructor should contain the actual assignment logic, to avoid more than one class field assignment across different constructors.  The developer needs to ensure proper mapping of the secondary constructor arguments to the primary constructor arguments so that proper class field assignment takes place.

- What is the difference between initialization and reassignment?

Initialization is when a variable is first assigned after declaration.  For class field variables this usually happens in the body of the constructor.  Whenever the value for a variable is updated after initialization, this is called reassignment.