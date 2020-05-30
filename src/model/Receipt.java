package model;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.lang.*;


public class Receipt{
  private Shoppingcart shoppingcart;
  private int VATSale = 25;
  private double runningTotal;
  private double AmountPaid;
  private double change;

/* Creates a new instance, representing a reciept, contains:
  *
  * @param sets the sales shoppingcart, running total, and amount paid
  */

  public Receipt(Shoppingcart shoppingcart, double runningTotal, double AmountPaid){
    this.shoppingcart = shoppingcart;
    this.runningTotal = runningTotal;
    this.AmountPaid = AmountPaid;
    this.change = Math.abs(AmountPaid-runningTotal);
  }


/** 
  * prints the Receipt, contains:
  * • Date and time of sale.
  * • Name, quantity and price for each item.
  * • Total price for the entire sale.
  * • VAT for the entire sale
  * • Amount paid and change
  * • change of the sale
  */

  public String printReceipt(){
    return "VAT: " + this.VATSale + "%\n Total: " + this.runningTotal + "kr\n AmountPaid: " + this.AmountPaid  + "kr\n Change: " + this.change + "kr";
  }

  public Shoppingcart getShoppingcart(){
    return this.shoppingcart;
  }

}
