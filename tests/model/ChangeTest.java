package model;

import integration.ItemDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTest {

    @Test
    public void createdChangeHasCorrectValue(){
        double paymentAmount = 20;
        CashPayment testPayment = new CashPayment(paymentAmount);
        TotalPrice testTotalPrice = new TotalPrice();
        double itemPrice = 10;
        testTotalPrice.increasePriceOfSale(new ItemDTO(itemPrice, 0, "testItem"));
        Change instance = new Change(testPayment, testTotalPrice);
        double expResult = paymentAmount - itemPrice;
        double result = instance.getChange();
        assertEquals (expResult, result, "The change amount stored in a Change instance is not correct");
    }

}