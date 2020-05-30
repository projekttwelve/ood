package integration;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import model.Receipt;

/**
 * Class for printing the reciept
 */
public class Printer {
    private Receipt receipt;

    /**
     * Initializes the Printer class.
     * @param receipt the receipt to be printed
     */
    public Printer(Receipt receipt){
        this.receipt = receipt;
    }

    /**
     * prints the receipt
     */
    public void printReceipt(){
        System.out.println(getDate());
        this.receipt.getShoppingcart().printItemsAndQuantity();
        System.out.println(this.receipt.printReceipt());
    }
    private String getDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}
