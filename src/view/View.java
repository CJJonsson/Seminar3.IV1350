package view;

import controller.Controller;

/**
 * This application does not have a view. As a substitute, this class acts as
 * a placeholder for the view and conducts a sample execution.
 */
public class View {
    private Controller controller;

    /**
     * Creates a new view instance.
     *
     * @param controller The controller that is used for every operation.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * A sample execution that simulates a sale process
     * and thereby makes calls to every system operation.
     */
    public void sampleExecution(){
    String dataToBeDisplayed;

    System.out.println("Cashier starts a new sale\n");
    controller.startNewSale();

    System.out.println("Cashier enters item identifiers\n");
    System.out.println("Cashier enters 111:");
    dataToBeDisplayed = controller.scanCurrentItem(111);
    System.out.println(dataToBeDisplayed);
    System.out.println("Cashier enters 112:");
    dataToBeDisplayed = controller.scanCurrentItem(112);
    System.out.println(dataToBeDisplayed);
    System.out.println("Cashier enters 113:");
    dataToBeDisplayed = controller.scanCurrentItem(113);
    System.out.println(dataToBeDisplayed);
    System.out.println("Cashier enters 111:");
    dataToBeDisplayed = controller.scanCurrentItem(111);
    System.out.println(dataToBeDisplayed);

    System.out.println("Cashier ends the sale\n");
    dataToBeDisplayed = controller.endSale();
    System.out.println("Total price: "+  dataToBeDisplayed);

    System.out.println("\nCashier enters amount paid: 120\n");
    dataToBeDisplayed = controller.pay( 120);
    System.out.println("Change: "+  dataToBeDisplayed);
    }
}
