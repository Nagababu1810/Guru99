package datadriverntesting;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritedataColNum {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Nag\\Desktop\\data1.xlsx");
		
		
		FileOutputStream fos=null;
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheet("login");
		XSSFRow row=sheet.getRow(3);
		XSSFCell cell=row.getCell(3);
		
		cell.setCellValue("it is working");
		
		fos=new FileOutputStream("C:\\Users\\Nag\\Desktop\\data1.xlsx");
		
	
		wb.write(fos);
		wb.close();
		fos.close();		

	}

}
