package datadriverntesting;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadcolumName {

	public static void main(String[] args) throws IOException {
	
	FileInputStream fi=new FileInputStream("C:\\Users\\Nag\\Desktop\\data1.xlsx");
	
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	
	XSSFSheet sheet=wb.getSheet("login");
	
	XSSFRow row=sheet.getRow(0);
	XSSFCell cell;
	int cellindex=0;
	
	for(int i=0;i<row.getLastCellNum();i++) 
	{
		
		if(row.getCell(i).getStringCellValue().trim().equals("status"))
	
			cellindex=i;
		
	}
	
	row=sheet.getRow(3);
	cell=row.getCell(cellindex);
	String value=cell.getStringCellValue();
	System.out.println(value);
	
	wb.close();
	fi.close();
	
	
		

	}

}
