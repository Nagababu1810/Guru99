package datadriverntesting;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadColumNumber {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fi=new FileInputStream("C:\\Users\\Nag\\Desktop\\data1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		
		XSSFSheet sheet=wb.getSheet("login");
		
		XSSFRow row=sheet.getRow(3);
		XSSFCell cell=row.getCell(3);
		//System.out.println(cell);
		String value=cell.getStringCellValue();
		System.out.println(value);
		wb.close();
		fi.close();
		
		
		

	}

}
