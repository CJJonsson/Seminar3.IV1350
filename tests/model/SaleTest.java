package model;

import integration.ItemDTO;
import integration.SaleRegistry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testItemIsRegistered(){
        Sale instance = new Sale();
        ItemDTO itemDTO = new ItemDTO(20, 0.12, "Pickles (360g)");
        instance.registerItemInSale(itemDTO);
        Hashtable<ItemDTO, SaleItem> result = instance.getSaleItems();
        assertFalse(result.isEmpty(), "Item was not registered in sale");
    }

    @Test
    public void testItemAlreadyInSale(){
        Sale instance = new Sale();
        ItemDTO itemDTO = new ItemDTO(20, 0.12, "Pickles (360g)");
        instance.registerItemInSale(itemDTO);
        boolean expResult = true;
        boolean result = instance.getSaleItems().containsKey(itemDTO);
        assertEquals(expResult, result, "The registered item is not recognized");
    }

    @Test
    public void testUpdateItemQuantity(){
        Sale instance = new Sale();
        ItemDTO itemDTO = new ItemDTO(20, 0.12, "Pickles (360g)");
        instance.registerItemInSale(itemDTO);
        instance.registerItemInSale(itemDTO);
        int expQuantity = 2;
        int expResult = expQuantity;
        int result = instance.getSaleItems().get(itemDTO).getQuantity();
        assertEquals(expResult, result, "Item quantity was not incremented correctly");
    }

    @Test
    public void testCorrectItemIdentifierAddedToSale(){
        Sale instance = new Sale();
        ItemDTO itemDTO = new ItemDTO(20, 0.12, "Pickles (360g)");
        instance.registerItemInSale(itemDTO);
        SaleItem actualSaleItem = new SaleItem(itemDTO);
        String expResult = actualSaleItem.getItemDescription();
        SaleItem addedSaleItem = instance.getSaleItems().get(itemDTO);
        String result = addedSaleItem.getItemDescription();
        assertEquals(expResult, result, "Wrong itemIdentifier is added to the sale");
    }

    @Test
    public void testCorrectItemPriceAddedToSale(){
        Sale instance = new Sale();
        ItemDTO itemDTO = new ItemDTO(20, 0.12, "Pickles (360g)");
        instance.registerItemInSale(itemDTO);
        SaleItem actualSaleItem = new SaleItem(itemDTO);
        double expResult = actualSaleItem.getPrice();
        SaleItem addedSaleItem = instance.getSaleItems().get(itemDTO);
        double result = addedSaleItem.getPrice();
        assertEquals(expResult, result, "Wrong itemPrice is added to the sale");
    }

    @Test
    public void testCorrectItemQuantityAddedToSale(){
        Sale instance = new Sale();
        ItemDTO itemDTO = new ItemDTO(20, 0.12, "Pickles (360g)");
        instance.registerItemInSale(itemDTO);
        SaleItem actualSaleItem = new SaleItem(itemDTO);
        int expResult = actualSaleItem.getQuantity();
        SaleItem addedSaleItem = instance.getSaleItems().get(itemDTO);
        int result = addedSaleItem.getQuantity();
        assertEquals(expResult, result, "Wrong itemQuantity is added to the sale");
    }
}