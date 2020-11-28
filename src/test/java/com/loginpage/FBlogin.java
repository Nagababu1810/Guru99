package com.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FBlogin {

	public static WebDriver driver;
	@BeforeMethod
	@Parameters ({"browser"})
	public void openweb() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumResource\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();	
		
	}
	@Test
	public void userlogin() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mddnagababu1810@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Pavi@1234");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		Thread.sleep(3000);
		
		
		//driver.findElement(By.xpath("//div[@class='j83agx80 l9j0dhe7']")).click();
		//driver.findElement(By.xpath("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[5]/div/div[1]/div[2]/div")).click();
		
	}
	@AfterMethod
	public void close() {
		
		driver.close();
	}
	
	
}
