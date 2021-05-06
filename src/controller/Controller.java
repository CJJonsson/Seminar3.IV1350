package controller;

import integration.*;
import model.*;

/**
 * The application's only controller class, all model calls pass through this class.
 */
public class Controller {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Printer printer;
    private SaleRegistry saleRegistry;
    private CashRegister cashRegister;
    private Sale sale;

    /**
     * Creates a new controller instance.
     *
     * @param saleRegistry  Reference to saleRegistry.
     * @param systemCreator Used to get all classes that are external systems.
     */
    public Controller(SaleRegistry saleRegistry, SystemCreator systemCreator) {
        this.inventorySystem = systemCreator.getInventorySystem();
        this.accountingSystem = systemCreator.getAccountingSystem();
        this.printer = systemCreator.getPrinter();
        this.saleRegistry = saleRegistry;
        this.cashRegister = new CashRegister();
    }

    /**
     * Creates a new sale.
     */
    public void startNewSale(){
        this.sale = new Sale();
    }

    /**
     * Adds the scanned item to the sale.
     * 
     * @param itemIdentifier    Used to identify the scanned item.
     * @return                  Information about the scanned item and the runningTotal.
     */
    public String scanCurrentItem(int itemIdentifier){
         ItemDTO item = inventorySystem.getItemInformation(itemIdentifier);
         String saleInfo = sale.registerItemInSale(item);
         return saleInfo;
    }

    /**
     * Ends the sale process.
     * 
     * @return Total price as a string.
     */
    public String endSale(){
        return sale.endSale();
    }

    /**
     * Finalizes the sale.
     *
     * @param paidAmount The amount paid by the customer.
     * @return  Change as a string.
     */
    public String pay (double paidAmount){
        saleRegistry.logCompletedSale(sale);
        inventorySystem.updateInventory(sale);
        CashPayment payment = new CashPayment(paidAmount);
        cashRegister.registerPayment(payment);
        Receipt receipt = sale.payment (payment, accountingSystem);
        printer.printReceipt(receipt);
        return String.format("%.02f", receipt.getChange());

    }
}
