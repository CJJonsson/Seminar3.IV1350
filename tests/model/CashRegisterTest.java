package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    @Test
    public void testBalanceIsCorrectlyInitiated(){
        CashRegister instance = new CashRegister();
        double expResult = 0;
        double result = instance.getBalance();
        assertEquals(expResult, result, "The initiated balance is not correct");
    }

    @Test
    public void testStoredBalanceIsCorrect(){
        double paymentAmount = 20;
        CashRegister instance = new CashRegister();
        CashPayment paymentToStore = new CashPayment(paymentAmount);
        instance.registerPayment(paymentToStore);
        double expResult = 20;
        double result = instance.getBalance();
        assertEquals(expResult, result, "The stored balance is not correct");
    }

}