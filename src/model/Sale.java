package model;
import java.util.*;
import integration.Item;
import model.*;

public class Sale{
  private int runningTotal;
  private int amountPaid;
  private Shoppingcart shoppingcart;

/**
 * Creates a new instance, representing a new sale
 * it creates a shoppingcart associated with the sale
 */

  public Sale(){
    this.shoppingcart = new Shoppingcart();
  }

  private void presentCurrentItemAndSale(Item item){
    System.out.println(item.toString());
    System.out.println("Running Total: " + this.getRunningTotal());
    System.out.println();
  }


/**
 * registers a new item, adds it to the
 * shoppingcart associated with the sale
 * and also updates the running total and
 * presents the item.
 *@ param item to be added
 */
  public void registerItem(Item item){
    this.shoppingcart.addToShoppingCart(item);
    runningTotal = runningTotal + item.getPrice();
    presentCurrentItemAndSale(item);
  }

/**
 * Gets the total price of the sale. 
 *@ return this.runningTotal is the running total price of the sale
 */
  public int getRunningTotal(){
    return this.runningTotal; 
  }

/**
 * Prints the receipt of the sale.
 * return new Receipt(this.shoppingcart, this.runningTotal, this.amountPaid) returns
 * the receipt associated with the sale 
 *
 */

  public Receipt getReceipt(){
    return new Receipt(this.shoppingcart, this.runningTotal, this.amountPaid);
  }

/**
 * Sets the amount paid 
 */

  public void setAmountPaid(int amountPaid){
    this.amountPaid = amountPaid;
  }

}
