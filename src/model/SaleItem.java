package model;

import integration.ItemDTO;

/**
 * Represents one specific item in the current Sale.
 */
public class SaleItem {
    private String itemDescription;
    private double price;
    private int quantity;
    private int initialQuantity = 1;

    /**
     * Creates a new SaleItem.
     *
     * @param item An itemDTO including information about the bew SaleItem.
     */
    public SaleItem (ItemDTO item){
        this.itemDescription = item.getItemDescription();
        this.price = item.getPrice();
        this.quantity = initialQuantity;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Increments the quantity of an already existing item in the sale.
     */
    public void increaseItemQuantityInSale() {
        this.quantity = this.quantity + 1;
    }
}
