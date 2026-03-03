package experiements;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvier {
	
	DataFormatter formatter=new DataFormatter();
	@Test(dataProvider="driverTest")
	public void testCaseData(String greeting,String communication, String id) 
	{
		System.out.println(greeting+communication+id);
		
	}
	
	//to change any value to string
	@DataProvider(name="driverTest")
	public Object[][] getData() throws IOException
	{
		//public Object[][] getData() throws FileNotFoundException
		//{
		//Object[][] data= {{"hello","text","1"},{"bye","message","143"},{"solo","call","453"}};
		//return data;
		//every row of excel should be sent to 1 array
		FileInputStream fis=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Test.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
	int	rowCount=sheet.getPhysicalNumberOfRows();
//System.out.println(rowCount);
	XSSFRow row=sheet.getRow(0);
	int colCount=row.getLastCellNum();
	Object data[][]=new Object[rowCount-1][colCount];
	
	for(int i=0;i<rowCount-1;i++) {
		row=sheet.getRow(i+1);//to get first row after header
		for(int j=0;j<colCount;j++) {
			//System.out.println(row.getCell(j));
			XSSFCell cell=row.getCell(j);
			
			data[i][j]=formatter.formatCellValue(cell);
			
		}
		
	}
	return data;
	
	}

}
