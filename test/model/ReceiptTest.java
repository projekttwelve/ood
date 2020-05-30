package model;
import controller.Controller;
import integration.Item;
import integration.ItemIdDoesNotExistException;
import integration.NoDatabaseConnectionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ReceiptTest {
    private Sale sale;
    private Receipt receipt;

    @BeforeEach
    public void setUp()throws ItemIdDoesNotExistException, NoDatabaseConnectionException {
        int cheeseID = 2;
        sale = new Sale();
        Item cheese = new Item(25, 30, 2, "Cheese");
        sale.registerItem(cheese);
        this.receipt = this.sale.getReceipt();
    }

    @AfterEach
    public void tearDown(){
        sale = null;
    }

    @Test
    public void printTest(){
        assertTrue(this.receipt.printReceipt().contains("VAT: "),
                "receipt not working");
    }
}