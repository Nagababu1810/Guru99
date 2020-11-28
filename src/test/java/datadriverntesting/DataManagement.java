package datadriverntesting;

public class DataManagement {

	public static void main(String[] args) throws Exception {
	
		ExcelAPI e=new ExcelAPI("C:\\Users\\Nag\\Desktop\\data1.xlsx");
		String sheetname="TestData";
		String TestcaseName="TestA";
		
		int TeststartsRowNum = 0;
		while(!e.getCellData(sheetname, 0, TeststartsRowNum).equals(TestcaseName))
		{
			TeststartsRowNum++;
		}
		
		System.out.println("Test starts from now row:"+ TeststartsRowNum);
		
		int colstartRowNum=TeststartsRowNum +1;
		int datastartsRowNum=TeststartsRowNum +2;
		
		
		//calculate rows
		int rows=0;
		while(!e.getCellData(sheetname, 0, datastartsRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("total rows are:"+ rows);
				
		//calculate total colums
		
		
		int cols=0;
		while(!e.getCellData(sheetname, cols, colstartRowNum).equals(""))
		
		{
			cols++;
		}
		
		System.out.println("total cols are:"+ cols);
	

	//get data
	for(int rNum=datastartsRowNum;rNum<datastartsRowNum+rows;rNum++)
	{
		for(int cNum=0;cNum<cols;cNum++)
		{
			System.out.println(e.getCellData(sheetname, cNum, rNum));
		}
	}
	
	
}
}