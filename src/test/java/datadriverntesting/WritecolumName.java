package datadriverntesting;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritecolumName {
	
	static FileInputStream fis;

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos=null;
		
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.getSheet("login");
	XSSFRow row=sheet.getRow(0);
	XSSFCell cell=null;
	int	cellindex=-1;
	
	for(int i=1;i<=row.getLastCellNum();i++) 
	{	
	if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("result"))
		cellindex=i;
	
	}
	row=sheet.getRow(1);
	cell=row.getCell(cellindex);
	cell.setCellValue("nagababu");	
		
		
	fos=new FileOutputStream("C:\\Users\\Nag\\Desktop\\data1.xlsx");
	wb.write(fos);
	wb.close();
	fos.close();
	
		

	}

}
