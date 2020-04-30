package integration;
public class Item{
  private int VAT;
  private int price;
  private int ID; 
  private String name;

/**
 * Initializes an item
 * @para VAT represents the VAT of the sale
 * @para price represents the price of the item
 * @para ID represents the ID of the item
 * @para name represents the name of the item
 */

  public Item(int VAT, int price, int ID, String name){
    this.VAT = VAT;
    this.price = price;
    this.ID = ID;
    this.name = name;
  }

/**
 * get the name of an item
 * @retur this.name represents the name of the item
 */
  public String getName(){
    return this.name;
  }

/**
 * get the ID of an item
 * @retur this.ID represents the ID of the item
 */
  public int getID(){
    return this.ID;
  }

/**
 * get the price of an item
 * @retur this.price represents the price of the item
 */
  public int getPrice(){
    return this.price;
  }

/**
 * get the VAT of an item
 * @retur this.VAT represents the VAT of the item
 */
  public int getVAT(){
    return this.VAT;
  }

/**
 * a toString method of an item
 * @retur returns an string that contains all the attributes of an item
 */
  public String toString(){
    return "Name: " + this.getName() + "\n" + "Price: " + this.getPrice() + "\n" + "VAT: " + this.getVAT() + "%";
  }

}
