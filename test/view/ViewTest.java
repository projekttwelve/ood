package view; 

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controller.Controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;


public class ViewTest{

  private View instance;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp(){
    Controller controller = new Controller();
    instance = new View(controller);

    printoutBuffer = new ByteArrayOutputStream();
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
  public void testRunFakeExecution(){
    instance.test();
    String printout = printoutBuffer.toString();
    String expectedOutput = "Welcome";
    assertTrue(printout.contains(expectedOutput), "did not print expected value");
  }


}


