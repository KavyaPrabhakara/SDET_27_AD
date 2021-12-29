package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	
	@Test(dataProvider = "getData")
	public void readDataFromDataProviderTest(String Name, int qty)
	{
		System.out.println("Mobile name--->"+Name+"---Mobile Qty--->"+qty);
	}
		@DataProvider
		public Object[][] getData()
		{
			Object[][] objArr = new Object[3][2];
			
			objArr[0][0] = "MI";
			objArr[0][1] = 50;
			
			objArr[1][0] = "OnePlus";
			objArr[1][1] = 10;
			
			objArr[2][0] = "IPhone";
			objArr[2][1] = 30;
	
			return objArr;	
		}
}


