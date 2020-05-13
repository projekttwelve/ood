package controller;
import model.*;
import integration.*;
import view.View;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest{  
  Controller controller;

  @beforeEach
  public void setUp(){
    this.controller = new Controller();
  }

  @AfterEach
  public void tearDown(){
    contr = null;
  }

  @Test
  public void registerItem(){
    int cheese = 2; 
    Item hopefully_cheese = this.controller.getItem(cheese);
    Item cheese = new Item(25, 30, 2, "Cheese");
    assertTrue(hopefully_cheese.contains(cheese), "wrong");
  }

  @Test
  void idDoesNotExist(){
    int itemID = 123213;
    try {
      this.controller.getItem(itemID);
    }catch(ItemIdDoesNotExistException e){
    assertTrue(e.getMessage().contains("Item with ID: 123213 does not exist\n");
    }
  }

  @Test
  void NoDatabaseConnectionRegisterItem(){
    int itemID = 503;
    try{
      this.controller.getItem(itemID);
    }catch (NoDatabaseConnectionException e) {
      assertTrue(e.getMessage().contains("Could not connect to our inventory system!\n");
    }
  }
}
