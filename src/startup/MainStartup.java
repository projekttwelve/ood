package startup;
import controller.*;
import integration.*;
import model.*;
import view.*;

public class MainStartup {

/**
 * creates an Sale, controller and view 
 * and runs a test-simulation of the system
 */
  public static void main(String[] args){
    Sale sale = new Sale();
    Controller controller = new Controller(sale);
    View view = new View(controller);
    view.test();
  }
}
