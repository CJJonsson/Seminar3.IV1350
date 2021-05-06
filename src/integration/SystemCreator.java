package integration;

/**
 * An class that instantiates the external systems used when running the application,
 * accounting system, inventory system, and printer.
 */
public class SystemCreator {
    private AccountingSystem accountingSystem = new AccountingSystem();
    private InventorySystem inventorySystem = new InventorySystem();
    private Printer printer = new Printer();

    /**
     * Get the value of accountingSystem.
     *
     * @return the value of accountingSystem.
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * get the value of inventorySystem.
     *
     * @return the value of inventorySystem.
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }

    /**
     * get the value of Printer.
     *
     * @return the value of Printer.
     */
    public Printer getPrinter() {
        return printer;
    }
}
