package model;

import integration.AccountingSystem;
import integration.ItemDTO;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Hashtable;

/**
 * Represents one sale process, where one or more items are purchased
 * by a single customer. The table saleItems is used to store item information.
 */
public class Sale {
    private Store store;
    private TotalPrice totalPrice;
    private String saleTime;
    private String saleDate;
    private Hashtable<ItemDTO, SaleItem> saleItems = new Hashtable<>();

    /**
     * Creates a new Sale instance.
     */
    public Sale(){
        this.totalPrice = new TotalPrice();
        this.store = new Store();
        setTimeOfSale();
        setDateOfSale();
    }

    /**
     * Registers the item entered by the Cashier in the current Sale.
     * If the item already exists in the current sale, the quantity is incremented.
     *
     * @param item Contains information about the item to register.
     * @return saleInformation that is to be displayed.
     */
    public String registerItemInSale(ItemDTO item){
        if (itemAlreadyInSale (item)){
            updateItemQuantity (item);
        }
        else addItemToSale (item);

        totalPrice.increasePriceOfSale(item);

        return registerItemDisplayInfo(item);
    }

    private Boolean itemAlreadyInSale (ItemDTO item){
        return saleItems.containsKey(item);
    }

    private void updateItemQuantity (ItemDTO item){
        saleItems.get(item).increaseItemQuantityInSale();
    }

    private void addItemToSale (ItemDTO item){
        SaleItem currentItem = new SaleItem(item);
        saleItems.put(item, currentItem);
    }

    private String registerItemDisplayInfo(ItemDTO item){
        StringBuilder builder = new StringBuilder();
        builder.append(item.getItemDescription());
        builder.append("\nPrice (ex. VAT): ");
        builder.append(item.getPrice());
        builder.append("\nRunning Total (inc. VAT): ");
        builder.append(String.format("%.02f", totalPrice.getRunningTotal()));
        builder.append("\n");
        return builder.toString();
    }

    /**
     * Ends the sale.
     *
     * @return Total price as a String.
     */
    public String endSale(){
        return String.format("%.02f", totalPrice.getRunningTotal());
    }

    /**
     * Creates a change instance and a receipt instance.
     * Send information about this sale to external systems.
     *
     * @param payment The payment made by the customer.
     * @return The created receipt.
     */
    public Receipt payment (CashPayment payment, AccountingSystem accountingSystem){
        accountingSystem.updateAccountingInformation(this, totalPrice);
        Change change = new Change(payment, totalPrice);
        Receipt receipt = new Receipt(this, store, totalPrice, payment, change);
        return receipt;
    }

    public Hashtable<ItemDTO, SaleItem> getSaleItems(){
        return saleItems;
    }
    private void setTimeOfSale(){
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.saleTime = time.toString();
    }

    private void setDateOfSale(){
        LocalDate date = LocalDate.now();
        this.saleDate = date.toString();
    }

    public String getSaleTime(){
        return this.saleTime;
    }
    public String getSaleDate(){
        return this.saleDate;
    }
}


