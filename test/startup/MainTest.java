package view; 

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.controller.Controller;
import src.model.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;


public class MainTest{
  private View instance; 
  private ByteArrrayOutPutStream printoutBuffer;
  private PrintStream originalSysOut;

  @beforeEach
  public void setUp(){
    instance = new Main();

    printoutBuffer = new ByteArrrayOutPutStream();
    PrintStream inMemSysOut = new PrintStream(printoutBuffer);
    originalSysOut = System.out;
    System.setOut(inMemSysOut);
  }

  @AfterEach
  public void tearDown(){
    this.instance = null;
    printoutBuffer = null;
    System.setOut(originalSysOut);
  }

  @Test
  public void testUIstarted(){
    String[] args = null;
    Main.main(args);
    String printout = printoutBuffer.toString();
    String expectedOutput = "Welcome";
    assertTrue(printout.contains(expectedOutput), "UI did not start correctly. ");
  }
}


