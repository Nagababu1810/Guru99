package com.impTest;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {

	public static WebDriver driver;
	public static String Projectpath = System.getProperty("user.dir");
	public static Properties p;
	public static FileInputStream fi;
	public static String filepath;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String testCaseName;
	public static Properties childprop;
	public static Properties parentprop;

	static {
		Date dt = new Date();
		filepath = dt.toString().replace(":", " ").replace("_", " ");

	}

	public void init() throws IOException {

		fi = new FileInputStream(Projectpath + "//Config.properties//data.properties");

		p = new Properties();
		p.load(fi);
		// String browserName=System.getProperty("browser");
		System.out.println("property file initilized");
		
		fi = new FileInputStream(Projectpath + "//environment.properties");
		parentprop = new Properties();
		parentprop.load(fi);
		String e = parentprop.getProperty("env");
		System.out.println(e);
		
		
		fi = new FileInputStream(Projectpath + "//"+ e + ".properties");
		childprop = new Properties();
		childprop.load(fi);
		//System.out.println(childProp.getProperty("amazonurl"));

		fi = new FileInputStream(Projectpath + "//config.properties//or.properties");
		orProp = new Properties();
		orProp.load(fi);

		fi = new FileInputStream(Projectpath + "//config.properties//log4jconfig.properties");
		PropertyConfigurator.configure(fi);

		report = ExtentManager.getInstance();

	}

	public void launch(String browser) {

		if (p.getProperty(browser).equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Projectpath + "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("browser lunched");
		} else if (p.getProperty(browser).equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Projectpath + "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (p.getProperty(browser).equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", Projectpath + "//Drivers//iedriverserver.exe");
			driver = new InternetExplorerDriver();

		}

	}

	public void navigateUrl(String url) {
		driver.get(childprop.getProperty(url));
		driver.manage().window().maximize();

	}

	public static void elementClick(String locatorKey) {
		getElement(locatorKey).click();
		// driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}

	public static void selectItem(String locatorKey, String option) {
		getElement(locatorKey).sendKeys(option);
		// driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	}
	
	public static void type(String locatorKey, String text) 
	{
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
	}

	public static WebElement getElement(String locatorKey) {
		WebElement element = null;

		if (locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}

		return element;

	}

	
	  public static void reportSuccess(String passMsg) 
	  { 
		  test.log(LogStatus.PASS, passMsg);
	  }
	  
	  public static void reportFailure(String failMsg) throws Exception 
	  {
	  test.log(LogStatus.FAIL, failMsg); takeScreenshot(); 
	  }
	  
	
	public static void takeScreenshot() throws Exception {

		Date dt = new Date();
		System.out.println(dt);
		String dateformate = dt.toString().replace(":", " ").replace("_", " ");

		File fo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fo, new File(Projectpath + "\\FailedScreenshots\\" + dateformate));

	}

	public static void waitforElement(WebElement locator, long timeoutInseconds, String waittime) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutInseconds);
		if (waittime.equals("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} else if (waittime.equals("visible")) {
			wait.until(ExpectedConditions.visibilityOf(locator));
		}

	}

	public static void selectoption(WebElement locator, int index) {

		Select s = new Select(locator);
		s.selectByIndex(4);

	}

	public static int randumNum() {

		Random r = new Random();
		int ran = r.nextInt(9999);
		return ran;
	}

	public void teardown() {

		driver.close();
	}

}
