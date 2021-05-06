package integration;

import model.Sale;
import model.SaleItem;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SaleRegistryTest {

    @Test
    void testLogOneSale() {
        SaleRegistry instance = new SaleRegistry();
        Sale saleToLog = new Sale();
        saleToLog.registerItemInSale(new ItemDTO(20, 0.12, "Pickles (360g)"));
        instance.logCompletedSale(saleToLog);
        String expResult = "Item: Pickles (360g) Price: 20.0 Quantity: 1";
        SaleItem resultSaleItem = new SaleItem(new ItemDTO(0,0,""));
        String result = "";
        Set<ItemDTO> keys = saleToLog.getSaleItems().keySet();
        for (ItemDTO key : keys) {
            resultSaleItem = saleToLog.getSaleItems().get(key);
            StringBuilder builder = new StringBuilder();
            builder.append("Item: " + resultSaleItem.getItemDescription());
            builder.append(" Price: " + resultSaleItem.getPrice());
            builder.append(" Quantity: " + resultSaleItem.getQuantity());
            result = builder.toString();
        }
        assertEquals(expResult, result, "Sale was not saved correctly");
    }

    @Test

    public void testNoSavedSale(){
    SaleRegistry instance = new SaleRegistry();
    assertTrue(instance.getSaleLog().isEmpty(), "A sale was found when none was stored");

    }
}