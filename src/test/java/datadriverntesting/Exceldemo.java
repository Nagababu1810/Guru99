package datadriverntesting;

public class Exceldemo {

	public static void main(String[] args) throws Exception {
		
		
		ExcelAPI a=new ExcelAPI("C:\\Users\\Nag\\Desktop\\data1.xlsx");
		
		System.out.println(a.getCellData("login", 1, 2));

		System.out.println(a.getRowCount("login"));
		
		System.out.println(a.columnCount("login"));
		
		System.out.println(a.setCellData("login", 4, 4, "happy"));
	
	}

}

