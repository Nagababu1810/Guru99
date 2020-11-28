package datadriverntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FBloginExcel {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		//WebDriverManager.chromedriver().setup();
		
	System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		ExcelAPI e=new ExcelAPI("C:\\Users\\Nag\\Desktop\\data1.xlsx");
		
		for(int i=1;i<e.getRowCount("login");i++) {
		
		driver.findElement(By.name("email")).clear();	
		driver.findElement(By.name("email")).sendKeys(e.getCellData("login", "usernam", i));
		
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "password", i));
		
		Thread.sleep(3000);
		}
	}

}
