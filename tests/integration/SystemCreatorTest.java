package integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SystemCreatorTest {

    @Test
    public void testCreateAccountingSystem() {
        SystemCreator instance = new SystemCreator();
        AccountingSystem result = instance.getAccountingSystem();
        assertTrue(result instanceof AccountingSystem, "SystemCreator did not create AccountingSystem");
    }

    @Test
    public void testCreateInventorySystem() {
        SystemCreator instance = new SystemCreator();
        InventorySystem result = instance.getInventorySystem();
        assertTrue(result instanceof InventorySystem, "SystemCreator did not create InventorySystem");
    }

    @Test
    public void testCreatePrinter() {
        SystemCreator instance = new SystemCreator();
        Printer result = instance.getPrinter();
        assertTrue(result instanceof Printer, "SystemCreator did not create Printer");
    }
}