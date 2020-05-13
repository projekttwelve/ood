package test;
import src.Yao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class YaoTst{
  Yao obj; 

  @beforeEach
  public void setUp(){
    this.obj = new Yao(0,0,"0");
  }

  @AfterEach
  public void tearDown(){
    this.obj = null;
  }

  @Test
  public void testRunFakeExecution(){
    System.out.println(obj.getA());
    obj.setA(11);
    System.out.println(obj.getA());
  }

}
