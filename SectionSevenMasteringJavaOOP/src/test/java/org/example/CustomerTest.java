import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerTest {

    List<String> expected, result;

    @Test
    public void testFirstConstructor() {
        Customer customer = new Customer("Mark Taylor", "mark.taylor@example.com", 20_000.00);
        expected = Arrays.asList("Mark Taylor", "mark.taylor@example.com");
        result = Arrays.asList(customer.getName(), customer.getEmail());
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(20_000.00, customer.getCreditLimit());
    }

    @Test
    public void testSecondConstructor() {
        Customer customer = new Customer("Michelle Walker", "michelle.walker@example.com");
        expected = Arrays.asList("Michelle Walker", "michelle.walker@example.com");
        result = Arrays.asList(customer.getName(), customer.getEmail());
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(15_000.00, customer.getCreditLimit());
    }

    @Test
    public void testNoArgsConstructor() {
        Customer customer = new Customer();
        expected =  Arrays.asList("John Doe", "john.doe@example.com");
        result = Arrays.asList(customer.getName(), customer.getEmail());
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(10_000.00, customer.getCreditLimit());
    }
}
