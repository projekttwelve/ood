package model;

/**
 * Interface made for those classes that want to 
 * get updates when the running total of the Sale
 * has changed.
*/

public interface SaleObserver{
  /**
   * Invoked when runningTotal has changed
   * @param amount new running total
   */
  void updateTotalAmount(int amount);

}
