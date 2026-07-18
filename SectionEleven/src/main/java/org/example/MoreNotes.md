**Explanation: Why Casting is Required**

You are exactly right in your hypothesis. The reason you have to cast `betterFliers` to `ArrayList<FlightEnabled>` is due to how Java handles **declared types** versus **actual types** during compilation, and the hierarchy between interfaces and classes.

**1. Declared Type vs. Actual Type**
In your code, `betterFliers` is **declared** as a `List`:
```java
private List<FlightEnabled> betterFliers = new ArrayList<>();
```
Even though you know it's an `ArrayList` at runtime, the compiler only sees it as a `List`.

**2. Why the compiler blocks it**
Your methods are defined to specifically require an `ArrayList`:
```java
private static String triggerFliers(ArrayList<FlightEnabled> fliers) { ... }
```
In Java, an `ArrayList` **is a** `List`, but a `List` **is not necessarily** an `ArrayList`. It could be a `LinkedList`, a `Stack`, or any other class that implements the `List` interface.

Because the method signature explicitly asks for an `ArrayList`, the compiler cannot guarantee that your `List` variable will always be an `ArrayList`. Therefore, it forces you to either:
1. **Cast it** (telling the compiler "Trust me, I know this is an ArrayList").
2. **Change the method signature** to accept the interface.

---

**The "Better" Way: Coding to an Interface**

To avoid the cast and make your code more flexible, you should change the method signatures to use the `List` interface instead of the concrete `ArrayList` class. This is a design principle called **"Coding to an Interface"**.

**Recommended Change:**
Modify your methods to accept `List<FlightEnabled>`:

```java
// Change ArrayList to List in the parameter
private static String triggerFliers(List<FlightEnabled> fliers) {
    String output = "";
    for (var flier : fliers) {
        output = output.concat(flier.takeOff() + "\n");
    }
    return output;
}

// Do the same for flyFliers and landFliers...
```

**Why this is better:**
1. **No Casting Needed**: Both your `ArrayList<FlightEnabled> fliers` and `List<FlightEnabled> betterFliers` can be passed directly into these methods without any casting.
2. **Flexibility**: If you later decide to use a `LinkedList` for `betterFliers`, these methods will still work without any changes.
3. **Decoupling**: Your methods no longer depend on a specific implementation of a list, only on the behavior defined by the `List` interface.

In your `testBetterFliers` class, you would then be able to call the methods cleanly:
```java
@Test
public void testTriggerFlyers() {
    expected = "...";
    // No cast required anymore!
    result = triggerFliers(betterFliers); 
    assertEquals(expected, result);
}
```
My Question: "In the @Override of the transition method in the Jet Class,
why do I have to use the keyword "super"?"

I am about to search for Java files related to flight functionality in your project.

Found "**/FlightEnabled.java"

Found "**/FlightStages.java"

In the `Jet` class, the line `return FlightEnabled.super.transition(stage);` uses
the `super` keyword in a specific way to call a **default method** from an interface.

Here is the breakdown of why this syntax is required:

**1. Accessing Default Interface Methods**
The `transition` method is defined as a `default` method in the `FlightEnabled` interface:

```java
// Inside FlightEnabled.java
default FlightStages transition(FlightStages stage) {
    return stage.getNextStage();
}
```

When you override this method in the `Jet` class, you are essentially replacing that default logic.
If you want to still use the default logic from the interface within your override, you must
use the syntax `InterfaceName.super.methodName()`.

**2. Distinguishing from the Local Method**
If you simply wrote `return transition(stage);` inside the `Jet` class's `transition` method, you
would be calling the method you are currently inside. This would cause **infinite recursion**,
leading to a `StackOverflowError`.

The `super` keyword tells Java to look for an implementation higher up in the hierarchy rather than
using the one defined in the current class (`Jet`).

**3. `super` vs `InterfaceName.super`**
In Java, the keyword `super` used by itself (e.g., `super.methodName()`) refers to the immediate
**parent class** (which is `Animal` in this case).

Since the `Animal` class does not have a `transition` method, `super.transition(stage)` would
result in a compilation error. Therefore, you must specify `FlightEnabled.super` to tell the
compiler exactly which interface's default implementation you want to invoke.

**Summary**
You use `FlightEnabled.super.transition(stage)` because:
*   **`FlightEnabled`**: Identifies the specific interface where the default method lives.
*   **`.super`**: Indicates you want to call the "parent" (interface) implementation
rather than the one in the current class.
*   **`transition(stage)`**: Is the specific method you are invoking.