package integration;

import model.Sale;
import model.SaleItem;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/**
 * Represents the made up inventory system which includes a simple item list
 * that information is gathered from, instead of a database.
 */
public class InventorySystem {
    private Hashtable<Integer, ItemDTO> itemList = new Hashtable<>();
    private ArrayList<Object> soldItems = new ArrayList <>();

    /**
     * Creates a new InventorySystem instance.
     */
    public InventorySystem(){
        createItemList();
    }

    /**
     * Gets information about a specified item from the item list.
     *
     * @param itemIdentifier    Used to identify the specific item.
     * @return                  An ItemDTO representing the specified item.
     */
    public ItemDTO getItemInformation(int itemIdentifier){
        return itemList.get(itemIdentifier);
    }

    private void createItemList(){
        itemList.put(111, new ItemDTO(20, 0.12,  "Pickles (360g)"));
        itemList.put(112, new ItemDTO(25, 0.25,  "Baked Beans (415g)"));
        itemList.put(113, new ItemDTO(30, 0.06,  "Fruit Pastilles (143g)"));
    }

    /**
     * Stores data about the sale that should be used to update the inventory.
     *
     * @param sale The current sale instance which includes information about the sold items.
     */
    public void updateInventory (Sale sale){
        Set<ItemDTO> setOfItemDTOs = sale.getSaleItems().keySet();
        for (ItemDTO keys: setOfItemDTOs){
            SaleItem itemForInfo = sale.getSaleItems().get(keys);
            soldItems.add(itemForInfo.getItemDescription());
            soldItems.add(itemForInfo.getQuantity());
        }
    }
}
