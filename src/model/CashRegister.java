package model;

/**
 * Represents a cash register.
 */
public class CashRegister {
    private double balance;
    private double initialBalance = 0;

    /**
     * Creates a new CashRegister instance.
     */
    public CashRegister(){
    this.balance = initialBalance;
    }

    /**
     * Registers the payment in the Cash register.
     *
     * @param payment An CashPayment object which includes the amount paid.
     */
    public void registerPayment (CashPayment payment){
        balance = balance + payment.getPaidAmount();
    }

    public double getBalance() {
        return balance;
    }
}
