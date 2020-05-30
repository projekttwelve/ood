package view;
import controller.Controller;
import model.*;
import integration.*;

public class View {
  private Controller controller;

  /**
   * Initializes a view with a associated controller
   * @param controller represents the controller
   * that is associaed with the view.
   * Also creates a totalrevenue view
   */
  public View(Controller controller){
    this.controller = controller;
    this.controller.addObserver(new TotalRevenueView());
  }

/**
 * runs a test of the system
 */

  public void test(){
    System.out.println("Welcome");
    InventorySystem inventory = this.controller.getInventory();
    int itemIdThatDoesNotExist = 500; 
    int itemIdThatResultsInDatabaseConnectionError = 503;
    int cheese = 2; 
    int ham = 3; 
    
    try{
      Item Milk = this.controller.getItem(itemIdThatDoesNotExist);
    }catch(ItemIdDoesNotExistException e){
      System.out.println("Item with that id does not exist");
    }catch(NoDatabaseConnectionException e){
      System.out.println("Can't connect to our system, please try again\n");
    }

    try{
      Item Pineapple = this.controller.getItem(itemIdThatResultsInDatabaseConnectionError);
    }catch(ItemIdDoesNotExistException e){
      System.out.println("Item with that id does not exist");
    }catch(NoDatabaseConnectionException e){
      System.out.println("Can't connect to database");
    }

    try{
      Item Cheese = this.controller.getItem(cheese);
      Item Ham = this.controller.getItem(ham);
      this.controller.registerItem(Cheese);
      this.controller.registerItem(Ham);
    }catch(ItemIdDoesNotExistException e){
      System.out.println("Item with that id does not exist");
    }catch(NoDatabaseConnectionException e){
      System.out.println("Can't connect to database");
    }

      System.out.println("Do you wish to shop more? yes/no");
      System.out.println("No");
      System.out.println(this.controller.printTotalPriceAndVAT());
      System.out.println("Receipt");
      int amountPaid = 400;
      this.controller.setAmountPaid(amountPaid);
      this.controller.printReceipt();
  }
}
