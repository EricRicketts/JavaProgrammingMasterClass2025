import org.example.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrinterTest {

    private Printer printer;

    @BeforeEach
    public void setUp() {
        printer = new Printer(50, false);
    }

    @Nested
    @DisplayName("test printer getters")
    class TestPrinterGetters {

        @Test
        public void testPrinterTonerLevelGetter() {
            assertEquals(50, printer.getTonerLevel());
        }

        @Test
        public void testPinterPrinterGetPagesPrinted() {
            assertEquals(0, printer.getPagesPrinted());
        }

        @Test
        public void testPrinterGetDuplexStatus() {
            assertFalse(printer.isDuplex());
        }
    }

    @Nested
    @DisplayName("test duplex setter")
    class TestDuplexSetter {

        @Test
        public void testDuplexSetterChangesDuplexState() {
            assertFalse(printer.isDuplex());

            printer.setDuplex(true);

            assertTrue(printer.isDuplex());
        }
    }

    @Nested
    @DisplayName("test add toner")
    class TestAddToner {

        @Test
        public void testAddZeroTonerAmount() {
            int newTonerLevel = printer.addToner(0);

            assertEquals(-1, newTonerLevel);
            assertEquals(50, printer.getTonerLevel());
        }

        @Test
        public void testAddNegativeTonerAmount() {
            int newTonerLevel = printer.addToner(-1);

            assertEquals(-1, newTonerLevel);
            assertEquals(50, printer.getTonerLevel());
        }

        @Test
        public void testAddTooMuchToner() {
            int newTonerLevel = printer.addToner(51);

            assertEquals(-1, newTonerLevel);
            assertEquals(50, printer.getTonerLevel());
        }

        @Test
        public void testAddMaximumToner() {
            int newTonerLevel = printer.addToner(50);

            assertEquals(100, newTonerLevel);
            assertEquals(100, printer.getTonerLevel());
        }

        @Test
        public void testAddTonerUnderMaximumAllowed() {
            int newTonerLevel = printer.addToner(1);

            assertEquals(51, newTonerLevel);
            assertEquals(51, printer.getTonerLevel());
        }
    }

    @Nested
    @DisplayName("test pages printed")
    class TestPagesPrinted {

        @Test
        public void testNonDuplexPrinterEvenNumberOfPages() {
            assertEquals(4, printer.printPages(4));
            assertEquals(4, printer.getPagesPrinted());
        }

        @Test
        public void testNonDuplexPrinterOddNumberOfPages() {
            assertEquals(3, printer.printPages(3));
            assertEquals(3, printer.getPagesPrinted());
        }

        @Test
        public void testDuplexPrinterEvenNumberOfPages() {
            printer.setDuplex(true);

            assertEquals(2, printer.printPages(4));
            assertEquals(2, printer.getPagesPrinted());
        }

        @Test
        public void testDuplexPrinterOddNumberOfPages() {
            printer.setDuplex(true);

            assertEquals(2, printer.printPages(3));
            assertEquals(2, printer.getPagesPrinted());
        }
    }
}
