package model;

import integration.ItemDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalPriceTest {

    @Test
    public void testIncreaseRunningTotal(){
        TotalPrice instance = new TotalPrice();
        double price = 20;
        double VATrate = 0.12;
        String itemDescription = "testItem";
        ItemDTO itemDTO = new ItemDTO(price, VATrate, itemDescription);
        instance.increasePriceOfSale(itemDTO);
        double expResult = price * (1 + VATrate);
        double result = instance.getRunningTotal();
        assertEquals(expResult, result, "RunningTotal was not increased correctly");
    }

    @Test
    public void testIncreaseTotalVAT(){
        TotalPrice instance = new TotalPrice();
        double price = 20;
        double VATrate = 0.12;
        String itemDescription = "testItem";
        ItemDTO itemDTO = new ItemDTO(price, VATrate, itemDescription);
        instance.increasePriceOfSale(itemDTO);
        double expResult = price * VATrate;
        double result = instance.getTotalVat();
        assertEquals(expResult, result, "TotalVAT was not increased correctly");

    }

}