package model;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.lang.*;


public class Receipt{
  private Shoppingcart shoppingcart;
  private int VATSale = 25;
  private int runningTotal;
  private int AmountPaid;
  private int change;

/* Creates a new instance, representing a reciept, contains:
  *
  * @param sets the sales shoppingcart, running total, and amount paid
  */

  public Receipt(Shoppingcart shoppingcart, int runningTotal, int AmountPaid){
    this.shoppingcart =shoppingcart;
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

  public void printReceipt(){
    System.out.println(getDate());
    this.shoppingcart.printItemsAndQuantity();
    System.out.println("VAT: " + this.VATSale + "%");
    System.out.println("Total: " + this.runningTotal + "kr");
    System.out.println("AmountPaid: " + this.AmountPaid  + "kr");
    System.out.println("Change: " + this.change + "kr");
  }

  private String getDate(){
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return date.format(formatter);
  }

}
