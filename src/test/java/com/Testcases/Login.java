package com.Testcases;



import org.openqa.selenium.By;


import com.impTest.BaseTest;

public class Login extends BaseTest{

	public static void main(String[] args) {
		
	
	
	//public void userlogin() throws InterruptedException{
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//Thread.sleep(3000);
		
		driver.findElement(By.linkText("Welcome Linda")).click();
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
			
		}
		
	
	}

