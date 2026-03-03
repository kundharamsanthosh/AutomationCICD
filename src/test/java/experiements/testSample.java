package experiements;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
	
	public static void main(String[] args) throws IOException {
		ExcelPractice d= new ExcelPractice();
		ArrayList data=d.getData("threethree");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
	}
	

}
