package startup;

import controller.Controller;
import integration.SaleRegistry;
import integration.SystemCreator;
import view.View;

/**
 * Contains the <code>main</code> method which do the startup of the application.
 */
public class Main {
    /**
    * Starts the application.
    *
    * @param args The application do not take any command line parameters.
    */
    public static void main(String[] args){
        SaleRegistry saleRegistry = new SaleRegistry();
        SystemCreator systemCreator = new SystemCreator();
        Controller controller = new Controller(saleRegistry, systemCreator);
        new View(controller).sampleExecution();
    }
}
