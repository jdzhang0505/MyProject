package PageClassesUseGrid;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumGrid_ParallelTestFramework extends TestSuiteBase{
	
	//�����TestngGrid.xml ���ʹ�ã�ͨ��xml ִ��
	
  @BeforeClass
  public void beforeClass() {
	  
  }
  @Test
  public void test() throws InterruptedException {
	  search.setDestination("上海");
	  
	  search.setCheckinDate("2019/11/29");
	  search.setCheckoutDate("2019/11/30");
	  Thread.sleep(3000);
		
	  search.clickHotelGuestTextbox();
	  search.setAdultsTotal(2);
	  search.clickSearchButton();
	  
  }

  @AfterClass
  public void afterClass() throws Exception  {
	 
  }

}
