package model;

/**
 * Represents the change that the cashier is to give back to the customer.
 */
public class Change {
    private double change;

    /**
     * Creates a new Change instance.
     *
     * @param payment       The payment made by the custmer.
     * @param totalPrice    The totalPrice instance which includes the total price of the sale.
     */
    public Change(CashPayment payment, TotalPrice totalPrice) {
        this.change = payment.getPaidAmount() - totalPrice.getRunningTotal();
    }

    public double getChange(){
        return change;
    }
}
