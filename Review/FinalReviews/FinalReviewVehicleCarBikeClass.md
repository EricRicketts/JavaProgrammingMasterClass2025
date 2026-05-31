## AI Assistant
## Review Focused on Assignment Requirements
### Assignment: → , `Vehicle``Car``Bike`
Requirements appeared to be:
- Create a base class with and `Vehicle``brand``speed`
- Create subclass with `Car``numberOfDoors`
- Create subclass with `Bike``hasBell`
- Use inheritance with `extends`
- Use `super(...)` to initialize inherited state
- Include child-specific fields/methods
- Demonstrate inherited behavior through getters/setters and tests

## Overall Assessment
You met the main assignment requirements very well. The inheritance relationship is clear, the subclasses correctly extend , and both and add their own specialized state. Your constructors show a good understanding of how subclass constructors can call parent constructors with `super(...)`. `Vehicle``Car``Bike`
The test coverage is also strong for the scope of this exercise. You are not just checking the custom fields in and ; you are also checking inherited behavior like and , which is exactly what this exercise is meant to reinforce. `Car``Bike``brand``speed`
## What You Did Well
### 1. Correct use of inheritance
and both correctly extend . `Car``Bike``Vehicle`
That matches the assignment’s intended “is-a” relationship:
- A is a `Car``Vehicle`
- A is a `Bike``Vehicle`

This is a good use of inheritance for the exercise.
### 2. Good use of `super(...)`
Your subclass constructors properly delegate shared initialization to the parent class.
For example, uses: `Bike`
``` java
super(brand, speed);
```

and Car uses:
``` java
super(brand, speed);
```

That shows you understand that brand and speed belong to the parent Vehicle class and should be initialized there rather than duplicated in each child class.
3. Child-specific fields are handled correctly
Car adds:
``` java
private int numberOfDoors;
```

Bike adds:
``` java
private final boolean hasBell;
```

This is exactly the expected pattern: shared fields go in the parent, specialized fields go in the subclass.
4. Constructors are thoughtfully overloaded
You included multiple constructors for different object creation scenarios.
For Vehicle, you support:
no-argument construction
brand-only construction
brand-and-speed construction
For Car, you support:
default car
car with number of doors
car with brand and number of doors
car with brand, speed, and number of doors
For Bike, you support:
default bike
bike with brand
bike with brand and speed
bike with brand, speed, and bell status
That is very good practice for constructor overloading and object initialization.
5. Tests align well with the exercise
Your tests check:
default constructor behavior
overloaded constructor behavior
inherited getters
inherited setters
subclass-specific getters/setters
expected default values
This is especially useful because inheritance bugs often happen when a subclass does not initialize parent fields correctly. Your tests make sure that does not happen.
Instructional Comments
1. Consider constructor chaining to reduce repetition
This is not required, but it would make the constructors cleaner and reinforce another topic from your review plan.
For example, in Vehicle, instead of each constructor assigning fields separately, you could have the simpler constructors call the most complete constructor.
Conceptually:
``` java
public Vehicle() {
    this("Unknown", new BigDecimal("0.00"));
}

public Vehicle(String brand) {
    this(brand, new BigDecimal("0.00"));
}

public Vehicle(String brand, BigDecimal speed) {
    this.brand = brand;
    this.speed = validateSpeed(speed);
}
```

This avoids repeating the default speed value in multiple places and makes the “main” constructor the single place where initialization logic happens.
Again, this is not a major issue, but it would strengthen the object-initialization part of the assignment.
2. Bike has no setter for hasBell, which is okay if intentional
You made hasBell final:
``` java
private final boolean hasBell;
```

That means once a bike is created, its bell status cannot change.
That is a valid design choice. If the assignment expected setters for all fields, then a setHasBell() method would be needed. But based on the inheritance exercise itself, having only a getter is acceptable.
The important thing is that you understand the design implication:
final boolean hasBell means immutable after construction
non-final with setter means it can change later
3. Car is more mutable than Bike
Car allows numberOfDoors to be changed later:
``` java
public void setNumberOfDoors(int numberOfDoors)
```

Bike does not allow hasBell to be changed later.
That is not wrong, but it is worth noticing. For consistency, you might ask yourself:
Should both subclasses allow their special field to change?
Or should both be fixed after construction?
Either approach is fine at this level, but consistency is a useful design habit.
4. Good inherited behavior testing
Your CarTest and BikeTest do a nice job confirming that inherited methods work from subclass instances.
For example, testing customBike.setBrand(...) and customBike.setSpeed(...) confirms that Bike really is using the inherited Vehicle behavior.
That is exactly the kind of thing you should be practicing in an inheritance exercise.
5. Minor style note: one test method starts with uppercase
In BikeTest, this method:
``` java
public void TestBikeRejectsNegativeSpeed()
```

would normally be written with a lowercase first letter:
``` java
public void testBikeRejectsNegativeSpeed()
```

This does not affect whether the assignment requirements are met, but Java method naming conventions usually use lower camel case.
Validation Note
You asked not to penalize missing validation unless explicitly required. For this assignment, I would not heavily penalize validation either way.
You actually added some validation for negative speed and invalid door counts, which is fine. But the core learning goal here is inheritance, constructor use, and superclass/subclass design. Your solution demonstrates those well.
Grade
Grade: 95 / 100
Reasoning
You clearly satisfied the main exercise requirements:
Vehicle base class: yes
Car subclass: yes
Bike subclass: yes
Proper use of extends: yes
Proper use of super(...): yes
Child-specific fields: yes
Inherited behavior works: yes
Tests demonstrate the design: yes
The only small deductions would be for design/style improvements, not requirement failures:
constructors could use more chaining to reduce repeated defaults
Bike mutability is different from Car, which is okay but worth thinking about
minor naming convention issue in one test method
Overall, this is a strong submission for the inheritance exercise.

## Me
that was a big miss on my Vehicle class not to use constructor chaining, I know better

## AI Assistant

Not a big miss — more like a missed refinement opportunity.
For the assignment requirements, your Vehicle class still did its job:
it had the correct fields
it initialized objects correctly
it supported multiple constructors
it worked properly with Car and Bike
it supported the inheritance exercise
So I would not treat the lack of constructor chaining as a major assignment failure.
That said, your instinct is right: since constructor chaining was one of the review topics, this is exactly the kind of thing you want to catch and improve.
Better way to think about it
The original version showed:
“I know how to overload constructors.”
The improved version would show:
“I know how to overload constructors and centralize initialization logic.”
That second part is the real benefit of constructor chaining.
Why constructor chaining matters here
Without chaining, you can end up repeating default values:
``` java
new BigDecimal("0.00")
```

in multiple constructors.
With chaining, the simpler constructors delegate to the most complete constructor, so the full constructor becomes the single place where the object is actually initialized.
A cleaner structure would be:
``` java
public class Vehicle {

    private static final String SPEED_TO_LOW =
        "Speed cannot be less than zero.";

    private String brand;
    private BigDecimal speed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = validateSpeed(speed);
    }

    public Vehicle(String brand, BigDecimal speed) {
        this.brand = brand;
        this.speed = validateSpeed(speed);
    }

    public Vehicle(String brand) {
        this(brand, new BigDecimal("0.00"));
    }

    public Vehicle() {
        this("Unknown", new BigDecimal("0.00"));
    }

    private BigDecimal validateSpeed(BigDecimal speed) {
        if (speed.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(SPEED_TO_LOW);
        } else {
            return speed;
        }
    }
}
```

Even better small improvement
Since "0.00" is a repeated default value, you could also make it a constant:
``` java
public class Vehicle {

    private static final String SPEED_TO_LOW =
        "Speed cannot be less than zero.";

    private static final BigDecimal DEFAULT_SPEED = new BigDecimal("0.00");
    private static final String DEFAULT_BRAND = "Unknown";

    private String brand;
    private BigDecimal speed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = validateSpeed(speed);
    }

    public Vehicle(String brand, BigDecimal speed) {
        this.brand = brand;
        this.speed = validateSpeed(speed);
    }

    public Vehicle(String brand) {
        this(brand, DEFAULT_SPEED);
    }

    public Vehicle() {
        this(DEFAULT_BRAND, DEFAULT_SPEED);
    }

    private BigDecimal validateSpeed(BigDecimal speed) {
        if (speed.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(SPEED_TO_LOW);
        } else {
            return speed;
        }
    }
}
```

My teaching comment
This is exactly the right kind of mistake to notice.
You did not misunderstand inheritance. You did not misuse super. You did not fail to initialize your objects. The structure works.
The missed opportunity was mainly about constructor design quality:
avoid repeated default values
centralize initialization
make future changes easier
reinforce the “main constructor” pattern
Grade adjustment?
I would maybe adjust the score slightly, but not dramatically.
Original grade: 95 / 100
With stricter attention to the constructor-chaining topic: 92 / 100
That feels fair because the assignment was mainly about inheritance, and you met that. But since constructor chaining was part of the review goals, it deserves a small deduction.
Still a strong submission. The important thing is that you recognized the improvement yourself — that means the concept is becoming part of your design sense.
