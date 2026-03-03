package Excelwork;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class getDataFromMultipleSheets {
	
	//DataProvider(name="Santhosh")
	@Test
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\ExcelPractice\\MultipleSheets.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//to get number of sheets in work book
		int numberOfSheets=workbook.getNumberOfSheets();
		System.out.println(numberOfSheets);
		//to get sheet names present in workbook
		for(int i=0;i<numberOfSheets;i++) 
		{
			String sheetNames=workbook.getSheetAt(i).getSheetName();
			System.out.println("The Sheet Names are:"+sheetNames);
			if(sheetNames.equals("Tickets"))
			{
				XSSFSheet sheet=workbook.getSheet("Tickets");
				int rowCount=sheet.getPhysicalNumberOfRows();
				System.out.println("Number of Rows in :"+sheetNames+" sheet is: "+rowCount);
				XSSFRow row=sheet.getRow(0);
				int columnCount=row.getLastCellNum();
				System.out.println("Number of Columns in :"+sheetNames+" sheet is: "+columnCount);
				for(int j=0;j<rowCount-1;j++) {
					row=sheet.getRow(j+1);//to get first row after header
					for(int k=0;k<columnCount;k++) {
						//System.out.println(row.getCell(j));
						if(j==2) {
						XSSFCell cell=row.getCell(k);
						
					System.out.println(cell);
						}
						
					}
				}
				
			}
			
			if(sheetNames.equals("NewTickets"))
			{
				XSSFSheet sheet=workbook.getSheet("NewTickets");
				int rowCount=sheet.getPhysicalNumberOfRows();
				System.out.println("Number of Rows in :"+sheetNames+" sheet is: "+rowCount);
				XSSFRow row=sheet.getRow(0);
				int columnCount=row.getLastCellNum();
				System.out.println("Number of Columns in :"+sheetNames+" sheet is: "+columnCount);
				for(int j=0;j<rowCount-1;j++) {
					row=sheet.getRow(j+1);//to get first row after header
					for(int k=0;k<columnCount;k++) {
						//System.out.println(row.getCell(j));
						if(j==3) {
						XSSFCell cell=row.getCell(k);
						
					System.out.println(cell);
						}
						
					}
				}
				
			}
			if(sheetNames.equals("Assigned Tickets"))
			{
				XSSFSheet sheet=workbook.getSheet("Assigned Tickets");
				int rowCount=sheet.getPhysicalNumberOfRows();
				System.out.println("Number of Rows in :"+sheetNames+" sheet is: "+rowCount);
				XSSFRow row=sheet.getRow(0);
				int columnCount=row.getLastCellNum();
				System.out.println("Number of Columns in :"+sheetNames+" sheet is: "+columnCount);
				for(int j=0;j<rowCount-1;j++) {
					row=sheet.getRow(j+1);//to get first row after header
					for(int k=0;k<columnCount;k++) {
						//System.out.println(row.getCell(j));
						if(j==4) {
						XSSFCell cell=row.getCell(k);
						
					System.out.println(cell);
						}
						
					}
				}
				
			}
			if(sheetNames.equals("Closed Tickets"))
			{
				XSSFSheet sheet=workbook.getSheet("Closed Tickets");
				int rowCount=sheet.getPhysicalNumberOfRows();
				System.out.println("Number of Rows in :"+sheetNames+" sheet is: "+rowCount);
				XSSFRow row=sheet.getRow(0);
				int columnCount=row.getLastCellNum();
				System.out.println("Number of Columns in :"+sheetNames+" sheet is: "+columnCount);
				for(int j=0;j<rowCount-1;j++) {
					row=sheet.getRow(j+1);//to get first row after header
					for(int k=0;k<columnCount;k++) {
						//System.out.println(row.getCell(j));
						if(j==rowCount-2) {
						XSSFCell cell=row.getCell(k);
						
					System.out.println(cell);
						}
						
					}
				}
				
			}
			
		}
		
	}
}
