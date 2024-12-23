import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    private Printer printer;

    @BeforeEach
    void setUp() {
        printer = new Printer("TestPrinter", 50);
    }

    @Test
    void testInitialState() {
        assertEquals("Ready", printer.getState());
        assertEquals(50.0, printer.getInkLevel());
        assertEquals(0, printer.getUsage());
    }

    @Test
    void testPrintColor() {
        printer.print(true);
        assertEquals(30.0, printer.getInkLevel(), 0.01);
        assertEquals(2, printer.getUsage());
        assertEquals("Ready", printer.getState());
    }

    @Test
    void testPrintBlackAndWhite() {
        printer.print(false);
        assertEquals(40.0, printer.getInkLevel(), 0.01);
        assertEquals(1, printer.getUsage());
        assertEquals("Ready", printer.getState());
    }

    @Test
    void testEnterInkSavingMode() {
        printer = new Printer("LowInkPrinter", 10);
        printer.print(true);
        assertEquals("Ink Saving", printer.getState());
    }

    @Test
    void testCannotPrintInMaintenance() {
        printer.sendToMaintenance();
        assertEquals("Maintenance", printer.getState());

        printer.print(true); // Attempt to print
        assertEquals(50.0, printer.getInkLevel());
        assertEquals(0, printer.getUsage());
        assertEquals("Maintenance", printer.getState());
    }

    @Test
    void testCannotPrintOutOfInk() {
        printer = new Printer("NoInkPrinter", 5);
        printer.print(true);
        assertEquals(5.0, printer.getInkLevel());
        assertEquals(0, printer.getUsage());
    }

    @Test
    void testUsageLimit() {
        for (int i = 0; i < 3; i++) {
            printer.print(true);
        }
        assertEquals(4, printer.getUsage());
        assertEquals(10, printer.getInkLevel(), 0.01);
        printer.print(true);
        assertEquals(4, printer.getUsage());
    }
}