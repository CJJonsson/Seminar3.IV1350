package integration;

/**
 * Represents an particular item in terms of price, VAT rate, and item description.
 */
public class ItemDTO {
    private double price;
    private double VATrate;
    private String itemDescription;

    /**
     * Creates a new itemDTO instance.
     *
     * @param price             The price of the item.
     * @param VATrate           The VAT rate of the item.
     * @param itemDescription   The description of the item.
     */
    public ItemDTO(double price, double VATrate, String itemDescription){
        this.price = price;
        this.VATrate = VATrate;
        this.itemDescription = itemDescription;
    }

    public double getPrice() {
        return price;
    }

    public double getVATrate() {
        return VATrate;
    }

    public String getItemDescription(){
        return itemDescription;
    }
}
