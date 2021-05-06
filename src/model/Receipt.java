package model;

import integration.ItemDTO;
import java.util.Hashtable;

/**
 * Represents the receipts which proves that the sale is finished.
 */
public class Receipt {
    private String saleTime;
    private String saleDate;
    private String storeName;
    private String storeAddress;
    private Hashtable<ItemDTO, SaleItem> saleItems;
    private double totalPrice;
    private double totalVAT;
    private double paidAmount;
    private double change;

    /**
     * Creates a new Receipt instance.
     *
     * @param sale          Information about the sale and the sale items.
     * @param store         Information about the store.
     * @param totalPrice    Information about the total price of the sale.
     * @param payment       Information about the payment.
     * @param change        Information about the change.
     */
    public Receipt (Sale sale, Store store, TotalPrice totalPrice, CashPayment payment, Change change){
        this.saleTime = sale.getSaleTime();
        this.saleDate = sale.getSaleDate();
        this.storeName = store.getStoreName();
        this.storeAddress = store.getStoreAddress();
        this.saleItems = sale.getSaleItems();
        this.totalPrice = totalPrice.getRunningTotal();
        this.totalVAT = totalPrice.getTotalVat();
        this.paidAmount = payment.getPaidAmount();
        this.change = change.getChange();
    }
    public String getSaleTime(){
        return saleTime;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public Hashtable<ItemDTO, SaleItem> getSaleItems() {
        return saleItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getChange() {
        return change;
    }
}
