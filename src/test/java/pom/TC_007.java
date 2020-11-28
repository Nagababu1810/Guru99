package pom;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.impTest.BaseTest;

public class TC_007 extends BaseTest {


	@BeforeMethod
	public void startprocess() throws Exception {
		
		init();
		launch("chromebrowser");
		navigateUrl("auturl");
	}
	@Test
	public void logintest() throws Exception {
		
		Loginpage p=new Loginpage(driver);
		p.userlogin();
	
	}
	
	@Test
	public void Createtest() throws Exception {
		
		CustomerAccountpage ca=new CustomerAccountpage(driver);
		ca.createaccount();
	}	
	
	@Test
	public void sendingtest() {
		
		Contactpage cg=new Contactpage(driver);
		cg.sendingmessage();
	}
	
	@AfterMethod
	public void endprocess() {
		
		teardown();
	}
}
