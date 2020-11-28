package actions;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptExecutin {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('email').value='naga'");
		
		String title=js.executeScript("return document.Title").toString();
		System.out.println("title is:" +title);
		
		
		//js.executeScript("window.scrollBy(0,200)");
		
		js.executeScript("window.scrollBy(0,200)");
		 
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 
		 js.executeScript("document.getElementById('pass').scrollIntoView()");
		 
		 js.executeScript("window.history.back()");
		 
		 js.executeScript("window.history.forward()");
		 
		 js.executeScript("window.history.go(0)");
		
		
	}
}
