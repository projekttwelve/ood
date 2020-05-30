package view;
import model.SaleObserver;

public class TotalRevenueView implements SaleObserver{
  private double runningTotal;

/**
  * updates the runningTotal
  * @param amount the new total
  */

  @Override
  public void updateTotalAmount(double amount){
    this.runningTotal = amount;
    printCurrentState();
  }

/**
 * prints the running total of the current sale
 */
  
  private void printCurrentState(){
    System.out.println("Running Total is: ");
    System.out.println(this.runningTotal);
  }
}
