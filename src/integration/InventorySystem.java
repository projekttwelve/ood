package integration;
public class InventorySystem{
  private static final InventorySystem INSTANCE = new InventorySystem();
  private Item[] items = new Item[10];

  /* Initialies the Inventory System
   * runs the addItems function that adds
   * items to the inventory
   */
  private InventorySystem(){
    addItems();
  }

  /* *
  @return the only existing instance of this singleton.
   */
  public static InventorySystem getInventory(){
    return INSTANCE;
  }

  /**
   * returns an item
   * @param id represents the item to be fetched
   * @return item represents the item to be returned
   */

  public Item getItem(int id) throws NoDatabaseConnectionException, ItemIdDoesNotExistException{
    int dataBaseConnectionFail = 503;
    if (id == dataBaseConnectionFail)
      throw new NoDatabaseConnectionException("could not connect to server with ip: 11.133.333.33");
    else if( id < 0 || id > items.length)
      throw new ItemIdDoesNotExistException("array index out of bounds");
    return items[id];
  }

  private void addItems(){
    items[0] = new Item(25, 10, 0, "Milk");
    items[1] = new Item(25, 20, 1, "Pineapple");
    items[2] = new Item(25, 30, 2, "Cheese");
    items[3] = new Item(25, 40, 3, "Ham");
    items[4] = new Item(25, 50, 4, "Burgers");
    items[5] = new Item(25, 60, 5, "Olive Oil");
    items[6] = new Item(25, 70, 6, "Chicken");
    items[7] = new Item(25, 80, 7, "Crab");
    items[8] = new Item(25, 90, 8, "Oysters");
    items[9] = new Item(25, 100, 10, "Lobsters");
  }

}
