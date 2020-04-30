package integration;
import integration.Item;
public class InventorySystem{
  private Item[] inventory = new Item[10];

  /* Initialies the Inventory System
   * runs the addItems function that adds
   * items to the inventory
   */
  public InventorySystem(){
    addItems();
  }

/**
 * returns an item
 * @para itemName represents the item to be fetched
 * @retur item represents the item to be returned
 */
  
  public Item getItem(String itemName){
    for(Item item : this.inventory){
      if (item.getName() == itemName)
        return item;
    }
    return null;
  }

  private void addItems(){
    inventory[0] = new Item(25, 10, 0, "Milk");
    inventory[1] = new Item(25, 20, 1, "Pineapple");
    inventory[2] = new Item(25, 30, 2, "Cheese");
    inventory[3] = new Item(25, 40, 3, "Ham");
    inventory[4] = new Item(25, 50, 4, "Burgers");
    inventory[5] = new Item(25, 60, 5, "Olive Oil");
    inventory[6] = new Item(25, 70, 6, "Chicken");
    inventory[7] = new Item(25, 80, 7, "Crab");
    inventory[8] = new Item(25, 90, 8, "Oysters");
    inventory[9] = new Item(25, 100, 10, "Lobsters"); 
  }

}