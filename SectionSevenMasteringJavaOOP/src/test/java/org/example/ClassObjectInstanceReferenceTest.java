import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClassObjectInstanceReferenceTest {

    Customer firstCustomer, secondCustomer;
    List<String> expected, result;

    @BeforeEach
    public void setUp() {
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
        String firstCustomerHexCode = Integer.toHexString(System.identityHashCode(firstCustomer));
        String secondCustomerHexCode = Integer.toHexString(System.identityHashCode(secondCustomer));
        Assertions.assertNotEquals(firstCustomerHexCode, secondCustomerHexCode);
    }
}
