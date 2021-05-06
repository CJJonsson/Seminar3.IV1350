package integration;

import model.Receipt;
import model.SaleItem;
import java.util.Set;

/**
 * Represents an external printer that is used for printing receipts.
 */
public class Printer {
    /**
     * Prints a receipt.
     *
     * @param receipt the receipt to be printed.
     */
    public void printReceipt(Receipt receipt){
        String receiptToPrint = createReceiptText(receipt);
        System.out.println(receiptToPrint);
    }

    private String createReceiptText (Receipt receipt){
        StringBuilder builder = new StringBuilder();
        builder.append("RECEIPT");
        builder.append(newRow());
        builder.append("Date: " + receipt.getSaleDate());
        builder.append(newRow());
        builder.append("Time: " + receipt.getSaleTime());
        builder.append(newRow());
        builder.append("Store: " + receipt.getStoreName());
        builder.append(newRow());
        builder.append("Address: " + receipt.getStoreAddress());
        builder.append(newRow());
        builder.append(createSaleItemsText(receipt));
        builder.append("Total price (inc. VAT): " + String.format("%.02f", receipt.getTotalPrice()));
        builder.append(newRow());
        builder.append("Total VAT: " + String.format("%.02f", receipt.getTotalVAT()));
        builder.append(newRow());
        builder.append("Paid amount: " + receipt.getPaidAmount());
        builder.append(newRow());
        builder.append("Change: " + String.format("%.02f", receipt.getChange()));
        builder.append(newRow());
        return builder.toString();
    }
    private String createSaleItemsText (Receipt receipt){
        StringBuilder builder = new StringBuilder();
        Set<ItemDTO> setOfItemDTOs = receipt.getSaleItems().keySet();
        for (ItemDTO keys: setOfItemDTOs){
            SaleItem itemForInfo = receipt.getSaleItems().get(keys);
            builder.append("Item: " + itemForInfo.getItemDescription());
            builder.append(" Price: " + itemForInfo.getPrice());
            builder.append(" Quantity: " + itemForInfo.getQuantity());
            builder.append(newRow());
        }
        return builder.toString();
    }
    private String newRow(){
        return "\n";
    }
}
