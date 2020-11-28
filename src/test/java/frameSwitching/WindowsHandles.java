package frameSwitching;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandles {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sc.com/in/bank-with-us/online-banking-login/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		String parentwindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@title='Apply Now']")).click();
		
		
		Set<String> multiplewindows=driver.getWindowHandles();
		
		Iterator<String> it=multiplewindows.iterator();
		
		while(it.hasNext())
		{
			String currentwindow=it.next();
			
			if(!currentwindow.equals(parentwindow))
			{
				
				driver.switchTo().window(currentwindow);
		
			}
		}
		
		String childwin=driver.getTitle();
		System.out.println("childwindow title:"+childwin);
		driver.close();
		
		
		driver.switchTo().window(parentwindow);
		System.out.println("Parent window title :" +driver.getTitle());
	
	}
	
}
