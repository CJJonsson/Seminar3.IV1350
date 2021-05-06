package model;

/**
 * Represents a store in terms of name and address.
 */
public class Store {
    private String storeName;
    private String storeAddress;

    /**
     * Creates a new Store instance.
     */
    public Store(){
        setStoreName();
        setStoreAddress();
    }

    private void setStoreName(){
        this.storeName = "FunStore";
    }

    private void setStoreAddress(){
        this.storeAddress = "FunStreet 1, FunTown, FunCountry";
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress(){
        return storeAddress;
    }
}
