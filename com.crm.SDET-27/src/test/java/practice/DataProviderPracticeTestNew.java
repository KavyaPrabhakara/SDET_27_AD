package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTestNew {
	@Test(dataProvider = "getData")
	public void readDataFromDataProviderTest(String Name, int qty)
	{
		System.out.println("Product Name--->"+Name+"---Product Qty--->"+qty);
	}
		@DataProvider
		public Object[][] getData()
		{
			Object[][] objArr = new Object[5][2];
			
			objArr[0][0] = "Lakme";
			objArr[0][1] = 50;
			
			objArr[1][0] = "Ponds";
			objArr[1][1] = 10;
			
			objArr[2][0] = "Elle18";
			objArr[2][1] = 30;
			
			objArr[3][0] = "Vaseline";
			objArr[3][1] = 30;
			
			objArr[4][0] = "Maybeline";
			objArr[4][1] = 30;

			return objArr;
		}
}
