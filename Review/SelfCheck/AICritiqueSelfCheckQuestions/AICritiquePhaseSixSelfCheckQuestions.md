## Feedback on Self-check Questions
Your answers are **mostly correct** and clearly written. You understand the key distinction:
- **Overloading** = same method name, different parameter lists.
- **Overriding** = subclass provides its own implementation of an inherited method.
- **Overloading** is resolved at **compile time**.
- **Overriding** is resolved at **runtime**.

A few small refinements would make the answers more precise.
## Question 1: Difference between overloading and overriding
Your answer:
Method overloading occurs within a class and allows a class to have different methods called with the same method name, but with different parameters and return types. Method overriding occurs within the context of inheritance where the child method is a specific and unique implementation of the parent method.
This is good, but one important correction:
**Overloaded methods cannot differ only by return type.**
In Java, overloading is determined by the **method signature**, which includes:
- method name
- parameter number
- parameter types
- parameter order

The **return type alone does not distinguish overloaded methods**.
For example, this is **not valid overloading**:
``` java
public int calculate() {
    return 1;
}

public double calculate() {
    return 1.0;
}
```

But this is valid overloading:
``` java
public int calculate(int value) {
    return value;
}

public int calculate(int value, int multiplier) {
    return value * multiplier;
}
```

For overriding, your explanation is solid. You could also mention that the overriding method must have the same method signature as the parent method and a compatible return type.
 
Question 2: Which one is decided at compile time?
Your answer is correct.
Method overloading is decided at compile time because the compiler chooses the method based on the declared method name and argument list.
You might phrase it like this:
Method overloading is resolved at compile time. The compiler determines which overloaded method to call based on the method signature and the arguments provided. 
Question 3: Which one is decided at runtime?
Your answer is correct.
Method overriding is decided at runtime because Java uses the actual object type, not just the reference type, to decide which overridden method implementation to execute.
You might phrase it like this:
Method overriding is resolved at runtime. The JVM determines which overridden method to execute based on the actual object type. 
Suggested Revised Version``` markdown
## Self-check Questions

### Phase 6: Methods

- What is the difference between overloading and overriding?

Method overloading occurs when multiple methods have the same name but different parameter lists. The methods may have different return types, but they cannot differ only by return type.

Method overriding occurs in inheritance when a subclass provides its own implementation of a method inherited from a superclass. The overriding method must have the same method signature and a compatible return type.

- Which one is decided at compile time?

Method overloading is decided at compile time. The compiler determines which overloaded method to call based on the method signature and the arguments provided.

- Which one is decided at runtime?

Method overriding is decided at runtime. The JVM determines which overridden method to execute based on the actual object type.

Overall: nice work — your understanding is correct, with just one important precision needed around return types in overloading.