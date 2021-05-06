package integration;

import model.Receipt;
import model.Sale;
import model.SaleItem;

import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.Set;

/**
 * Represents a simple external sale registry.
 */
public class SaleRegistry {
    private Hashtable <LocalDateTime, String> saleLog = new Hashtable<>();
    private LocalDateTime LocalDateAndTime;

    /**
     * Logs the completed sale as a string in a hashtable.
     *
     * @param sale  The finalized sale.
     */
    public void logCompletedSale (Sale sale){
        this.LocalDateAndTime = java.time.LocalDateTime.now();
        String dataToLog = createSaleLogText(sale);
        saleLog.put(LocalDateAndTime, dataToLog);
    }

    private String createSaleLogText (Sale sale) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        Set<ItemDTO> setOfKeys = sale.getSaleItems().keySet();
        for (ItemDTO keys : setOfKeys) {
            SaleItem itemForInfo = sale.getSaleItems().get(keys);
            builder.append("Item: " + itemForInfo.getItemDescription());
            builder.append(" Price: " + itemForInfo.getPrice());
            builder.append(" Quantity: " + itemForInfo.getQuantity());
            builder.append("\n");
        }
        return builder.toString();
    }

    public Hashtable<LocalDateTime, String> getSaleLog() {
        return saleLog;
    }
}
