package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {
	
	//static WebDriver driver;

	@FindBy(linkText="Sign in") WebElement login;
	@FindBy(id="email") WebElement emailaddress;
	@FindBy(name="passwd") WebElement Password;		
	@FindBy(xpath="//button[@id='SubmitLogin']") WebElement signin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") WebElement loginError;
	
	public  Loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void userlogin() throws Exception {
		
		Thread.sleep(3000);
		login.click();
		emailaddress.sendKeys("qatest76565@gmail.com");
		Password.sendKeys("password");
		signin.click();
	}
	
	public WebElement getLoginError() {
		
		return loginError;
		
	}
	
}
