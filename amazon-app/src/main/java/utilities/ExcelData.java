package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static String getDataFromExcelSheet1(int a, int b) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("src\\test\\resources\\excelsheet\\Book.xlsx");
		Workbook w = WorkbookFactory.create(file);
		
		String d=  w.getSheet("Sheet1").getRow(a).getCell(b).getStringCellValue();
		return d;
		
	}
	public static String getDataFromExcelSheet(int a, int b) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("src\\test\\resources\\excelsheet\\Book.xlsx");
		Workbook w = WorkbookFactory.create(file);
		long n = (long) w.getSheet("Sheet1").getRow(a).getCell(b).getNumericCellValue();
        String str1 = Long.toString(n);

		return str1;
		
	}

}
