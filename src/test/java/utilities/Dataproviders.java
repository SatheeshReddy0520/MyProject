package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders { 
	//Data Provider 1
	
	@DataProvider(name="logindata")
	public String [][] getData() throws IOException
	{
		String path=".\\testdata\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1); 
		
	String logindata[][]=new String[totalrows][totalcols];
	
	for(int i=1;i<totalrows;i++) //1 read the data from excel storing 
	{
		for(int j=0;j<totalcols;j++)   //0 is row j is coloum
		{
			logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);   // 1st row and or 1,0
		}
	}
		
	return 	logindata;   //returning two dimensional array 
	}
	
	//Dataprovider 2
	
	//Dataprovider 3
	
	//Dataprovider 4

}
