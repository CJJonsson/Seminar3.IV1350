package model;

/**
 * Represents a payment in cash.
 */
public class CashPayment {
    private double paidAmount;

    /**
     * Creates a new CashPayment instance.
     *
     * @param paidAmount The paid amount.
     */
    public CashPayment (double paidAmount){
        this.paidAmount = paidAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }
}
