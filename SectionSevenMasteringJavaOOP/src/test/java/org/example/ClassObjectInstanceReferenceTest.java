import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClassObjectInstanceReferenceTest {

    Customer firstCustomer, secondCustomer;
    String firstCustomerHexCode, secondCustomerHexCode, thirdCustomerHexCode;
    List<String> expected, result;

    @BeforeEach
    public void setUp() {
        // This is very important to understand, we have created two Customer objects, but the only way
        // we can get access to them is through a reference, that is the variable assignments shown below.
        // if we were to create a new Customer object => new Customer(); that object would reside at a
        // memory location but without a reference to it, we cannot access it.  Now, there are times we
        // can instantiate an object without a reference and then call a method on an object to get a
        // value which we can use later, if this is all we need the object for then we can do that
        // of course then one might question which not define a static method so an object need not
        // be instantiated to get the desired result.
        firstCustomer = new Customer();
        secondCustomer = new Customer("Sam Park", "sam.park@example.com", 25_000.00);
    }

    @Test
    public void testAndExplainClassObjectInstance() {
        // we have a Customer class defined, a class is essentially a blueprint for future
        // objects.  The class defines an objects attributes and behavior.  The attributes
        // are the instance fields defined in the class, while the behavior is contained
        // in the instance methods.  The terms "object" and "instance" are used interchangeably.
        // we often say an "An object is an instance of a particular class."

        // these two objects or "instances of class Customer" have the same named attributes, but the
        // value for each of these attributes is different, making the objects distinct from one another

        expected = List.of("John Doe", "john.doe@example.com");
        result = List.of(firstCustomer.getName(), firstCustomer.getEmail());
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(10_000.00, firstCustomer.getCreditLimit());

        expected = List.of("Sam Park", "sam.park@example.com");
        result = List.of(secondCustomer.getName(), secondCustomer.getEmail());
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(25_000.00, secondCustomer.getCreditLimit());
    }

    @Test
    public void testGetCustomerReferences() {
        // I put a debug statement right at the assertions to pause the program.
        // The Hex value for firstCustomer was "78aab498" while the Hex value for
        // secondCustomer was "5dd6264", we can see from something akin to an object reference
        // that these instances of Customer are different as they reside in different memory locations
        // if they were pointing to the same object they would pont to the same memory location
        // not the next time I debug I could get different object references
        firstCustomerHexCode = Integer.toHexString(System.identityHashCode(firstCustomer));
        secondCustomerHexCode = Integer.toHexString(System.identityHashCode(secondCustomer));
        Assertions.assertNotEquals(firstCustomerHexCode, secondCustomerHexCode);
    }

    @Test
    public void testChangingReferences() {
        // we established firstCustomer and secondCustomer refer to different objects
        Customer thirdCustomer = firstCustomer;
        firstCustomerHexCode = Integer.toHexString(System.identityHashCode(firstCustomer));
        thirdCustomerHexCode = Integer.toHexString(System.identityHashCode(thirdCustomer));
        Assertions.assertEquals(firstCustomerHexCode, thirdCustomerHexCode);
        // As one can see the HashCode is the same for each variable, this is because firstCustomer
        // and thirdCustomer point to the same object in memory, so the references have to be the same
        // think of it like this, "what is the memory address of the object I want to use?"
        // Let's change the one of the attributes of firstCustomer and see what happens to thirdCustomer
        firstCustomer.setCreditLimit(35_515.00);
        Assertions.assertEquals(35_515.00, firstCustomer.getCreditLimit());
        Assertions.assertEquals(35_515.00, thirdCustomer.getCreditLimit());
        // we can see without explicitly changing the credit limit thirCustomer it was updated to match
        // the new credit limit for firstCustomer.  This is because firstCustomer and thirdCustomer
        // point to the same object in memory.  Now if I change a thirdCustomer attribute, the firstCustomer
        // will update as well
        thirdCustomer.setName("Sally Jennings");
        Assertions.assertEquals("Sally Jennings", thirdCustomer.getName());
        Assertions.assertEquals("Sally Jennings", firstCustomer.getName());
    }
}
