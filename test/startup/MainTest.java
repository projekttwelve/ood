package startup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest{
  private MainStartup instance;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp(){
    instance = new MainStartup();

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
  public void testUIstarted(){
    String[] args = null;
    MainStartup.main(args);
    String printout = printoutBuffer.toString();
    String expectedOutput = "Welcome";
    assertTrue(printout.contains(expectedOutput), "UI did not start correctly. ");
  }
}


