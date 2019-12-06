package com.nopcommerce.TestMaven1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Grouping {
  @BeforeClass
  public void beforeClass() {
	  System.out.println("TestNG_Grouping->beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("TestNG_Grouping->afterClass");
  }
  @Test(groups= {"bike"})
  public void testbikea() {
	  System.out.println("TestNG_Grouping->testbikea");
  }
  @Test(groups= {"bike"})
  public void testbikeb() {
	  System.out.println("TestNG_Grouping->testbikeb");
  }
  @Test (groups= {"cars","nisa"})
  public void testcarnisa() {
	  System.out.println("TestNG_Grouping->testcarnisa");
  }
  @Test (groups= {"cars","audi"})
  public void testcaraudi() {
	  System.out.println("TestNG_Grouping->testcaraudi");
  }

}
