package model;

import integration.ItemDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleItemTest {

    @Test
    public void testIncreaseSaleItemQuantity(){
        ItemDTO itemDTO = new ItemDTO(20, 0.12, "Pickles (360g)");
        SaleItem instance = new SaleItem(itemDTO);
        instance.increaseItemQuantityInSale();
        int expResult = 2;
        int result = instance.getQuantity();
        assertEquals(expResult, result, "Quantity of saleItem was not incremented");
    }

}