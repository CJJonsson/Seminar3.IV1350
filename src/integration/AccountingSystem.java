package integration;

import model.Sale;
import model.SaleItem;
import model.TotalPrice;
import java.util.ArrayList;
import java.util.Set;

/**
 * Represents a simple external accounting system that only stores information.
 */
public class AccountingSystem {
    private ArrayList<Object> accountingData = new ArrayList <>();

    /**
     * Stores information about the performed sale that should be used for accounting.
     *
     * @param sale          The current sale instance which includes information about the sold items.
     * @param totalPrice    The totalPrice instance which includes information about the total price and VAT.
     */
    public void updateAccountingInformation (Sale sale, TotalPrice totalPrice){
        accountingData.add(sale.getSaleDate());
        accountingData.add(sale.getSaleTime());
        accountingData.add(totalPrice.getTotalVat());
        accountingData.add(totalPrice.getRunningTotal());
        Set<ItemDTO> setOfItemDTOs = sale.getSaleItems().keySet();
        for (ItemDTO keys: setOfItemDTOs) {
            SaleItem itemForInfo = sale.getSaleItems().get(keys);
            accountingData.add(itemForInfo.getItemDescription());
            accountingData.add(itemForInfo.getQuantity());
        }
    }
}
