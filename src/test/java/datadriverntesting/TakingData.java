package datadriverntesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingData {


	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		
		
		
		
		ExcelAPI e=new ExcelAPI("C:\\Users\\Nag\\Desktop\\data1.xlsx");
		
		for(int i=1;i<e.getRowCount("login");i++)
		{	
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(e.getCellData("login",0,1));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#txtPassword")).clear();
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(e.getCellData("login", 0,1));
		//driver.findElement(By.cssSelector("input#txtPassword")).clear();
		
		//driver.findElement(By.id("btnLogin")).click();
		
		
		}
		
		
		

	}

}
