package org.example;

import org.junit.jupiter.api.*;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SupplierTest {

    private Supplier<PlainOld> reference1, reference2, reference3;

    /*
        It is important to understand how this test is giving the expected results.  Remember, last_id was
        initialized to 1.  The post-increment operator assigns the current value of last_id to the id
        instance variable and then increments afterward.  Thus, a new instance of PlainOld gets the post-increment
        value of last_id assigned to its id instance field.

        Also, very important to understand about the Supplier object, the get() method comes with a supplier
        instance, and by default it returns the current instance of the class.  Thus, if we want to get the current
        value of the instance field id, we need to get an instance of PlainOld with get() and then call getId() on
        that instance.
    */
    @BeforeEach
    public void setUp() {
        reference1 = PlainOld::new;
        reference2 = PlainOld::new;
        reference3 = PlainOld::new;
    }

    @Test
    @Order(1)
    public void testIdForFirstReference() {
        assertEquals(1, reference1.get().getId());
    }

    @Test
    @Order(2)
    public void testIdForSecondReference() {
        assertEquals(2, reference2.get().getId());
    }

    @Test
    @Order(3)
    public void testIdForThirdReference() {
        assertEquals(3, reference3.get().getId());
    }

    @Test
    @Order(4)
    public void testLastIdCurrentValue() {
        assertTrue(4 == PlainOld.getLastId());
    }
}
