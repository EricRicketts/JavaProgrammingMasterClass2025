## Phase 2: Constructors and initialization patterns
**Topics**
- constructor overloading
- constructor chaining
- default values
- object initialization order

### What to practice
1. Write multiple constructors.
2. Use `this(...)` to chain constructors.
3. Decide which constructor should be the “main” one.

### Exercise 3: `Rectangle`
Create a `Rectangle` class with:
- `width`
- `height`

Add:
- one constructor taking both values
- one constructor taking a single side and making a square
- method `area()`

### Exercise 4: `Person`
Create a `Person` class with:
- `name`
- `age`
- `city`

Use:
- one full constructor
- one partial constructor
- constructor chaining

### Self-check questions
- Why is constructor chaining useful?
- Which constructor should contain the actual assignment logic?
- What is the difference between initialization and reassignment?