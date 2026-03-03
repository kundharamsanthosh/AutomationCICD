package experiements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPractice {
	
	
public ArrayList<String> getData(String testCaseName) throws IOException {
	ArrayList<String> a=new ArrayList<String>();
	FileInputStream fis=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Data.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++) {
		
		if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
		{
		
			XSSFSheet sheet=workbook.getSheetAt(i);
			//Identify TestCases column by scanning entire first row
			Iterator<Row> rows=sheet.iterator();//sheet is collection of rows
			Row firstrow=rows.next();
			System.out.println(firstrow);
			Iterator<Cell>ce=firstrow.cellIterator();//row is coluctions of cells
			System.out.println(ce);
			int k=0;
			int column = 0;
			
			while(ce.hasNext()) 
			{
				Cell value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("three")) 
				{
					//desired column
					column=k;
					
				}
				k++;
			}
			System.out.println(column);
			//once column is identified then scan entire testcase column to identify purchase testcase row
			
			while(rows.hasNext()) 
			{
			Row r=	rows.next();
			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
				//after you grab purchase testcase row pull all the data of that row and feed into test
				Iterator<Cell> cv=r.cellIterator();
				while(cv.hasNext()) 
				{
					Cell c=cv.next();
					if(c.getCellTypeEnum()==CellType.STRING) 
					{
						a.add(c.getStringCellValue());
						
					}
					else {
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
					
					
				}
					
				
			}
				
				
			}
			
			
			
		}
	
	}
	return a;
	
}

	
	public static void main(String[] args) throws IOException {
		
			
		

}
}
