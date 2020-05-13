package view;
import model.SaleObserver;

public class TotalRevenueView implements SaleObserver{
  private int runningTotal;

/**
  * updates the runningTotal
  * @param the new total
  */

  @Override
  public void updateTotalAmount(int amount){
    this.runningTotal = amount;
    printCurrentState();
  }
  
  private void printCurrentState(){
    System.out.println("Running Total is: ");
    System.out.println(this.runningTotal);
  }
}
