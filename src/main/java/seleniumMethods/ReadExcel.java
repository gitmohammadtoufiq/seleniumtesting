package seleniumMethods;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public void dataRead() throws Exception {
		File src=new File ("/Users/mohammadtoufiq/Documents/garbage/CS-48 HOMEWORKS/HW 1.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook xsf=new XSSFWorkbook(fis);
		//for .xls files
		//HSSFWorkbook csf=new HSSFWorkbook(fis);
		
		XSSFSheet sheet=xsf.getSheetAt(1);
		String entry=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println("THE DATA IN THE BOX IS"+entry);
		
		xsf.close();
		
	}

}


