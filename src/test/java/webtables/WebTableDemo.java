package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
		List<WebElement> tr_collections=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("table rows:"+tr_collections.size());
		
		for(WebElement trElement:tr_collections)
		{
			
			List<WebElement> td_collection=trElement.findElements(By.tagName("td"));
			
			for(WebElement tdElement:td_collection)
				
				if(tdElement.getText().equals("Italy"))
				{
				
				System.out.println(tdElement.getText());
		
				}
		}
		
		

	}

}
