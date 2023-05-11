package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook Workbook;
	public static XSSFSheet Worksheet;


	public static String GetCellData(int colNum, int rowNum,String ExcelPath,int SheetNum) throws IOException
	{
		
	FileInputStream Excel=new FileInputStream(ExcelPath);
	Workbook=new  XSSFWorkbook(Excel);
	Worksheet=Workbook.getSheetAt(SheetNum);
	Cell cell=Worksheet.getRow(rowNum).getCell(colNum);
	DataFormatter formatter=new DataFormatter();
	String cellValue=formatter.formatCellValue(cell);
	Workbook.close();
	return cellValue;
	
	}
}
