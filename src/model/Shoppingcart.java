package model;
import integration.*;
/**
 * class used to represent a list of items and it's quantity
 */
public class Shoppingcart{
  private ItemInShoppingCart firstItemInCart;

  private class ItemInShoppingCart{
    int quantity;
    ItemInShoppingCart next; 
    Item item;
    
    /*
     * Creates an instance of an Item that as an associated quantity
     * it also has a pointer to the next item in the shoppingcart
     * @param quantity represents how many of a certain item exits
     * @param item represents the item
     */

    public ItemInShoppingCart(int quantity, Item item){
      this.quantity = quantity;
      this.item = item;
      this.next = null;
    }

    /** 
     * Increments the quantity of a item
     */
    public void incrementQuantity(){
      this.quantity = this.quantity + 1;
    } 
  }

    /** 
     * @return this.firstItemInCart returns the first item in the shoppingcart
     */

  public ItemInShoppingCart getFirstItem(){
    return this.firstItemInCart;
  }

  private boolean cartIsEmpty(){
    return this.firstItemInCart == null;
  }

    /** 
     * This metod adds a item to the shoppingcart.
     * It iterates trough the shoppingcart and if
     * the item being added exits it increments 
     * the quantity and returns. 
     * If it does not exit it adds it to the shoppingcart
     * @param item to be added.
     */

  public void addToShoppingCart(Item item){
    ItemInShoppingCart currentItem;

    if (cartIsEmpty()){
      firstItemInCart = new ItemInShoppingCart(1, item);
      return;
    }

    currentItem = this.firstItemInCart;

    while (currentItem.next != null){
      if (currentItem.item.getID() == item.getID()){
        currentItem.incrementQuantity();
        return;
      }
      else
        currentItem = currentItem.next;
    }
    
    ItemInShoppingCart newItemToBeAdded = new ItemInShoppingCart(1, item);
    currentItem.next = newItemToBeAdded;
  }
/**
 * This method prints the items that exits in the shoppingcart
 * and the quantity
 */

  public void printItemsAndQuantity(){
    ItemInShoppingCart currentItem = getFirstItem();

    while (currentItem != null){
      System.out.format("%-3d %-20s %10d %2s%n", currentItem.quantity, currentItem.item.getName(), currentItem.item.getPrice()*currentItem.quantity, "kr");
      currentItem = currentItem.next;
    }
  }

}
