Here’s a critique of your **Phase 1 Self-check** answers.

## 1. Instance variable vs static variable

Your answer is mostly correct and shows good understanding of **object-level state vs class-level state**.

### What you got right

- You correctly identified that an **instance variable** belongs to an object.
- You correctly identified that a **static variable** belongs to the class rather than to a particular instance.
- You correctly mentioned that direct field access is usually avoided because it breaks encapsulation.
- You correctly described accessing static members through the class name.

### Corrections / refinements

There are a few important wording issues.
You wrote:

An instance variable is created when a field is declared in a class without the use of the "static" keyword.

This is basically right, but more precise wording would be:

*An instance variable is a non-static field. Each object has its own copy of that field.*

You also wrote:

The syntax for updating or retrieving the field is "objectName.methodName".
This is slightly off. That syntax is for calling a method, not directly accessing a field.

For example:
``` java
person.getName();     // method call
person.name;          // direct field access, if allowed
```

So if you’re talking about using the object’s interface, then "objectName.methodName()" is fine. If you’re talking about the field itself, it would be "objectName.fieldName".

You also wrote:

Methods which access or update the static field must be declared with the "static" keyword.

This is not always true.

A static method can access a static field directly, but an instance method can also access a static field.

For example:
``` java
class Counter {
    private static int count;

    public void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
```

The instance method increment() is allowed to modify the static field count.
A better version would be:

Static fields can be accessed from static methods and instance methods, but static methods cannot directly access instance fields unless they have an object reference.

Suggested improved answer
``` text
An instance variable is a non-static field that belongs to an individual object. Each instance of the class has its own copy of the variable, so changing the field in one object does not affect the same field in another object.

A static variable is a field declared with the static keyword. It belongs to the class itself rather than to any one object, so all instances share the same variable. Static variables are usually accessed through the class name, such as ClassName.fieldName, though they are often kept private and accessed through methods.
```

 
## 2. Why might you avoid a setter for some fields?

Your answer is good and captures the main idea: some fields should not be freely changed after construction.

### What you got right

You correctly explained that a setter should be avoided when the field should not change during the object’s lifecycle.
You correctly connected this idea to final fields and constructor initialization.

### Corrections / refinements

You wrote:
a setter is should not be declared
Small grammar issue: this should be:
a setter should not be declared

More importantly, avoiding a setter is not only for final fields. You may avoid a setter whenever you want to protect an object’s invariants or control how changes happen.

For example, a field might be mutable internally, but still not have a direct setter because changing it requires validation or coordinated updates.
Example:
``` java
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }
}
```

Here, you would avoid setBalance(double balance) because arbitrary balance changes would be dangerous. Instead, you provide meaningful methods like deposit and withdraw.
Suggested improved answer
``` text
You might avoid a setter when a field should not be changed freely after the object is created, or when changing it directly could break the object’s rules. Some fields may be final and initialized in the constructor. Other fields may be changed only through methods that enforce validation or preserve the class’s invariants.
```

 
1. What happens if a constructor does not initialize a field?
Your answer is partly correct, but one phrase needs fixing.
What you got right
You correctly stated that fields receive default values.
You correctly identified 0 for numeric types.
You correctly identified null for object/reference types.
Correction
You wrote:
each field takes its default value according to its type, which happens at field declaration.
The default initialization does not happen because of the field declaration itself in the sense that the declaration assigns the value. It happens as part of object creation, before the constructor body runs.
Also, you only mentioned numbers and objects. A more complete answer would include:
``` text
boolean -> false
char -> '\u0000'
numeric primitive types -> 0 or 0.0
reference types -> null
```

One more important distinction: this applies to fields, not local variables. Local variables inside methods do not receive default values and must be initialized before use.
Suggested improved answer
``` text
If a constructor does not explicitly initialize an instance field, Java gives the field a default value during object creation before the constructor body runs. Numeric primitive fields default to 0 or 0.0, boolean fields default to false, char fields default to '\u0000', and reference fields default to null. This rule applies to fields, not local variables.
```

 
Overall assessment
Your answers show a solid beginner-level understanding of Java fields, static, encapsulation, setters, constructors, and default values.
The main things to tighten are:
Distinguish between method access and field access syntax.
Remember that instance methods can access static fields.
Avoid implying that only final fields should lack setters.
Clarify that field default values are assigned during object creation, before the constructor body runs.
Mention the default values for boolean and char, not just numbers and objects.
Overall: good work. The concepts are mostly there; the next step is making the wording more precise.