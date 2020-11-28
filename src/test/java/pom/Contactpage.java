package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.impTest.BaseTest;

public class Contactpage extends BaseTest{

	
	@FindBy(linkText="Contact us") public WebElement sigin;
	@FindBy(xpath="//select[@id='id_contact']") public WebElement subject_heading;
	@FindBy(xpath="//input[@id='email']") public WebElement email;
	@FindBy(xpath="//input[@id='id_order']")public WebElement reference_no;
	@FindBy(xpath="//input[@id='fileUpload']") public WebElement upload_file;
	@FindBy(xpath="//button[@name='submitMessage']") public WebElement send;
	@FindBy(xpath="//textarea[@id='message']") public WebElement msg;
	
	
	
	
	
	public Contactpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void sendingmessage() {
		
		sigin.click();
		selectoption(subject_heading,2);
		email.sendKeys("mdd@gmail.com");
		reference_no.sendKeys("93938938");
		msg.sendKeys("Hi this is referene no");
		send.click();
	}

}
