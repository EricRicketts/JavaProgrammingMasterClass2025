import org.example.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
