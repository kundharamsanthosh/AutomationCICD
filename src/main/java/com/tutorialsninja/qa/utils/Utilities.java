package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME =20;
	
	public static String generateEmailWithTimeStamp() {  //to access this method easily put static
		Date date=new Date();
		String timeStamp= date.toString().replace(" ","_").replace(":","_");
		return "kundharamsanthosh18"+timeStamp+"@gmail.com";
		
	}
	
	public static Object[][] getTestDataFromExcel(String sheetName) throws IOException 
	{
		DataFormatter formatter=new DataFormatter();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\TutorialsNinjaTestData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int	rowCount=sheet.getPhysicalNumberOfRows();
		//int rows=sheet.getLastRowNum();
		XSSFRow row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		//int columns=sheet.getRow(0).getLastCellNum();
	Object[][] data=new Object[rowCount-1][colCount];
	
	/*for(int i=0;i<rowCount-1;i++) {
		 sheet.getRow(i+1);
		for(int j=0;j<colCount;j++) {
			XSSFCell cell=row.getCell(j);
			CellType cellType=cell.getCellTypeEnum();
			switch (cellType) {
			case STRING:
			data[i][j]=cell.getStringCellValue();
			break;
			case NUMERIC:
				data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				break;
			case BOOLEAN:
				data[i][j]=cell.getBooleanCellValue();
				break;
			}
			
		}
	}
		
		return data;*/
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
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot,new File (destinationScreenshotPath) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return destinationScreenshotPath;
	}

}
