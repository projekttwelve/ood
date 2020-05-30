package model;
import java.util.*;
import integration.Item;

public class Sale{
  private double runningTotal;
  private int amountPaid;
  private Shoppingcart shoppingcart;
  private List<SaleObserver> saleObserver = new ArrayList<>();


/**
 * Creates a new instance, representing a new sale
 * it creates a shoppingcart associated with the sale
 */

  public Sale(){
    this.shoppingcart = new Shoppingcart();
  }

/**
 * adds a unit that wants
 * to observer this sale
 * to a List
 * @param obs observer to be added
 */

  public void addObserver(SaleObserver obs){
    this.saleObserver.add(obs);  
  }

/*
 * notifies the observer
 * that the running total 
 * has changed
 */

  private void notifyObservers(){
    for (SaleObserver obs : saleObserver) {
      obs.updateTotalAmount(this.runningTotal);
    } 
  } 

/*
 * Presents item and running total for this sale
 * @param item current item to be resented
 */

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
    Context context;
    this.shoppingcart.addToShoppingCart(item);

    if (item.getPrice() > 90){
      context = new Context(new DiscountOne());
      runningTotal = runningTotal + item.getPrice()*context.executeDiscount();
    }
    else if (item.getPrice() > 80){
      context = new Context(new DiscountTwo());
      runningTotal = runningTotal + item.getPrice()*context.executeDiscount();
    }
    else
      runningTotal = runningTotal + item.getPrice();
    notifyObservers();
    presentCurrentItemAndSale(item);
  }

/**
 * Gets the total price of the sale. 
 *@ return this.runningTotal is the running total price of the sale
 */
  public double getRunningTotal(){
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

  public int getAmountPaid(){
    return this.amountPaid;
  }
}
