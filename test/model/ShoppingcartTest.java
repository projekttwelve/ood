package model;
import model.Shoppingcart;
import integration.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingcartTest {
    private Shoppingcart crt;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp(){
        Shoppingcart crt = new Shoppingcart();

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    public void tearDown(){
        this.crt = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void addToShoppingCartTest(){
        Item cheese = new Item(25, 30, 2, "Cheese");
        crt.addToShoppingCart(cheese);
        crt.printItemsAndQuantity();
        String printout = printoutBuffer.toString();
        String expectedOutput = "kr";
        assertTrue(printout.contains(expectedOutput), "did not print expected value");
    }
}
