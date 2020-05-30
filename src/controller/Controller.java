package controller;
import model.*;
import integration.*;
import view.View;


public class Controller{  
  private Sale sale;
  private InventorySystem inventory;
  private Printer printer;

/**
 * Initialies the controller
 */

  public Controller(){
    this.sale = new Sale();
    this.inventory = InventorySystem.getInventory();
  }

/**
 * Adds an observer to the current sale
 * @param obs the observer to be added
 */

  public void addObserver(SaleObserver obs){
    this.sale.addObserver(obs);
  }

  /**
   * gets an item from the inventory
   * @return returns the item with the given itemID
   * @param itemID id of the item wanted
   */

  public Item getItem(int itemID) throws NoDatabaseConnectionException, ItemIdDoesNotExistException{
    try{
      return inventory.getItem(itemID);
    }catch(NoDatabaseConnectionException e){
      System.out.println("\nINTENDED FOR THE LOG");
      System.out.println("----------------------------");
      System.out.println(e.getMessage());
      System.out.println("----------------------------\n");
      throw new NoDatabaseConnectionException("Could not connect to our inventory system!\n");
    }catch(Exception e){
      System.out.println("\nINTENDED FOR THE LOG");
      System.out.println("----------------------------");
      System.out.println(e.getMessage());
      System.out.println("----------------------------\n");
      throw new ItemIdDoesNotExistException(String.format("Item with ID: itemID=%d does not exist\n", itemID));
    }
  }

/**
 * Gets the inventory
 * @return this.inventory returns the inventory
 */

  public InventorySystem getInventory(){
    return this.inventory;
  }

/**
 * Registers a item using the sale
 * associated with this controller
 */

  public void registerItem(Item item){
    this.sale.registerItem(item);
  }

/**
 * prints the Receipt associated
 * with this sale
 */
  
  public void printReceipt(){
    Receipt receipt = this.sale.getReceipt();
    this.printer = new Printer(receipt);
    this.printer.printReceipt();
  }

  /*
   * prints the total price of the sale 
   * and the VAT of the sale
   */

  public String printTotalPriceAndVAT(){
   return "Total Price: " + this.sale.getRunningTotal() + " VAT: 25%";
  }

/**
 * sets the amount paid in the sale
 * associated with this controller
 * @para amountpaid represents the amount paid by
 * the customer.
 */
  public void setAmountPaid(int amountPaid){
    this.sale.setAmountPaid(amountPaid);
  }

}
