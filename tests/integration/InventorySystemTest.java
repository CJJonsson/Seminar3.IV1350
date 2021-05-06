package integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {

    @Test
    public void testDifferentItemIdentifiersNotEqual(){
        int oneItemIdentifier = 111;
        int otherItemIdentifier = 112;
        InventorySystem instance = new InventorySystem();
        boolean expResult = false;
        boolean result = instance.getItemInformation(oneItemIdentifier)
                .equals(instance.getItemInformation(otherItemIdentifier));
        assertEquals(expResult, result, "Different itemIdentifers return the same ItemDTO");
    }

    @Test
    public void testValidItemIdentifier(){
        int itemIdentifier = 111;
        InventorySystem instance = new InventorySystem();
        ItemDTO expResult = instance.getItemInformation(111);
        ItemDTO result = instance.getItemInformation(itemIdentifier);
        assertEquals(expResult, result, "Valid identifier returns wrong ItemDTO");
    }

    @Test
    public void testNotExistingItemIdentifier(){
        int itemIdentifier = 114;
        InventorySystem instance = new InventorySystem();
        ItemDTO expResult = null;
        ItemDTO result = instance.getItemInformation(itemIdentifier);
        assertEquals(expResult, result, "Not existing itemIdentifier returns an ItemDTO");
    }
}