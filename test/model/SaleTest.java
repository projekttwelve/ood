package model;

import controller.Controller;
import integration.InventorySystem;
import integration.Item;
import integration.ItemIdDoesNotExistException;
import integration.NoDatabaseConnectionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaleTest {
    private Sale sale;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp(){
        sale = new Sale();

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    public void tearDown(){
        this.sale = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void registerItemTest(){
        Item cheese = new Item(25, 30, 2, "Cheese");
        sale.registerItem(cheese);
        String printout = printoutBuffer.toString();
        String expectedOutput = "Running Total: ";
        assertTrue(printout.contains(expectedOutput), "did not print expected value");
    }

    @Test
    public void setAmountPaidTest(){
        int price = 30;
        sale.setAmountPaid(price);
        int amt = sale.getAmountPaid();
        assertEquals(amt, price);
    }



}
