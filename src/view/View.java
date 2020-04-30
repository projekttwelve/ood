package view;
import controller.Controller;
import model.*;
import integration.*;

public class View {
  private Controller controller;

  /**
   * Initializes a view with a associated controller
   * @para controller represents the controller
   * that is associaed with the view
   */
  public View(Controller controller){
    this.controller = controller;
  }

/**
 * runs a test of the system
 */

  public void test(){
    System.out.println("Welcome");
    InventorySystem inventory = new InventorySystem();
    Item Milk = inventory.getItem("Milk");
    Item Pineapple = inventory.getItem("Pineapple");
    Item Cheese = inventory.getItem("Cheese");
    Item Ham = inventory.getItem("Ham");
    this.controller.registerItem(Milk);
    this.controller.registerItem(Pineapple);
    this.controller.registerItem(Cheese);
    this.controller.registerItem(Ham);
    System.out.println("Do you wish to shop more? yes/no");
    System.out.println("No");
    this.controller.printTotalPriceAndVAT();
    System.out.println("Receipt");
    int amountPaid = 400;
    this.controller.setAmountPaid(amountPaid);
    this.controller.printReceipt();
  }
}
