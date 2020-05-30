package integration;

import model.*;
import integration.*;
import view.View;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest{

  InventorySystem inventory;

    @BeforeEach
    void setUp() {
      this.inventory = InventorySystem.getInventory();
    }

    @AfterEach
    void tearDown() {
      inventory = null;
    }

  @Test
  public void registerItem() throws ItemIdDoesNotExistException, NoDatabaseConnectionException{
    int cheeseID = 2;
    Item hopefully_cheese = this.inventory.getItem(cheeseID);
    Item cheese = new Item(25, 30, 2, "Cheese");
    assertEquals(hopefully_cheese, cheese);
  }

    @Test
    void IdNotExistRegisterItem() throws ItemIdDoesNotExistException {
      int itemID = 123213;
      try {
        this.inventory.getItem(itemID);
      }catch(ItemIdDoesNotExistException e){
      assertTrue(e.getMessage().contains("Item with ID: 123213 does not exist\n"));
      }
    }

  @Test
  void NoDatabaseConnectionRegisterItem()throws ItemIdDoesNotExistException, NoDatabaseConnectionException{
    int itemID = 503;
    try{
      this.inventory.getItem(itemID);
    }catch (NoDatabaseConnectionException e) {
      assertTrue(e.getMessage().contains("Could not connect to our inventory system!\n"));
    }

  }
}
