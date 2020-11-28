package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.impTest.BaseTest;

public class CustomerAccountpage extends BaseTest {
	
	WebDriver driver;
	
	@FindBy(linkText="Sign in") public WebElement singin;
	@FindBy(id="email_create") public WebElement Enter_email;
	@FindBy(id="SubmitCreate") public WebElement submit;
	
	@FindBy(xpath="//*[@id='create_account_error']/ol/li") public WebElement error;
	@FindBy(xpath="//input[@id='id_gender1']") public WebElement title_gen1;
	@FindBy(xpath="//input[@id='id_gender1']") public WebElement title_gen2;
	
	@FindBy(id="customer_firstname")  public WebElement firstname;
	@FindBy(id="customer_lastname")  public WebElement lastname;
	@FindBy(id="passwd")  public WebElement password;
	
	@FindBy(xpath="//select[@id='days']") public WebElement day;
	@FindBy(xpath="//select[@id='months']") public WebElement month;
	@FindBy(xpath="//select[@id='years']") public WebElement year;
	
	@FindBy(xpath="//div[@class='alert alert-danger']") public  WebElement returnerror;
	@FindBy(css="input#firstname") public WebElement First_name;
	@FindBy(css="input#lastname") public WebElement Last_name;
	@FindBy(css="input#company") public WebElement company_name;
	@FindBy(xpath="//input[@id='address1']")  public WebElement Address_1;
	@FindBy(xpath="//input[@id='address2']") public  WebElement Address_2;
	@FindBy(xpath="//input[@id='city']")  public WebElement city;
	@FindBy(xpath="//select[@id='id_country']") public WebElement state;
	@FindBy(xpath="//input[@id='postcode']") public  WebElement postal_code;
	@FindBy(xpath="//select[@id='id_country']") public WebElement countary;
	@FindBy(xpath="//textarea[@id='other']") public  WebElement Addtionldata;
	@FindBy(xpath="//input[@id='phone']") public  WebElement Home_phone;
	@FindBy(xpath="//input[@id='phone_mobile']") public  WebElement mobile_phone;
	@FindBy(xpath="//input[@id='alias']")  public WebElement ref_addres;
	@FindBy(css="button#submitAccount") public  WebElement submit_page;
	
	
	public CustomerAccountpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void createaccount() throws Exception 
	{
		//String Enter_email=p.getProperty("firstname")+p.getProperty("lastname")+randumNum()+p.getProperty("domain");
		singin.click();
		
		
		
		Enter_email.sendKeys("mdd@gmail.com");
		submit.click();
		
		waitforElement(title_gen1,60,"clickable");
		
		title_gen1.click();
		title_gen2.click();
		
		firstname.sendKeys("qa");
		lastname.sendKeys("test");
		password.sendKeys("12345");
		
		//waitforElement(day,60,"clickable");
		
		selectoption(day,10);
		//Select s1=new Select(day);
		//s1.selectByIndex(5);
		Thread.sleep(2000);
		selectoption(month,4);
		//Select s2=new Select(month);
		//s2.selectByIndex(2);
		Thread.sleep(2000);
		selectoption(year,6);
		
		//Select s3=new Select(year);
		//s3.selectByIndex(4);
		
		company_name.sendKeys("wipro");
		Address_1.sendKeys("kakinada");
		Address_2.sendKeys("kakinada");
		city.sendKeys("kakinada");
	
		postal_code.sendKeys("398289");
		Addtionldata.sendKeys("all are fine");
		Home_phone.sendKeys("2344343423");
		mobile_phone.sendKeys("3893739303");
		ref_addres.sendKeys("hyderabad");
		submit_page.click();
		
		
	}
	
	
	
	
	
	
	
}
