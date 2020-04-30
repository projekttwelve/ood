package controller;
import model.*;
import integration.*;
import view.View;


public class Controller{  
  private Sale sale;

/**
 * Initialies the controller
 * @para sale is the sale associated with this controller
 */

  public Controller(Sale sale){
    this.sale = sale;
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
    receipt.printReceipt(); 
  }

  /*
   * prints the total price of the sale 
   * and the VAT of the sale
   */

  public void printTotalPriceAndVAT(){
    System.out.println("Total Price: " + this.sale.getRunningTotal() + " VAT: 25%");
    System.out.println();
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
