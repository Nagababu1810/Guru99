package listerpack;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.impTest.BaseTest;

public class ListnerDemo extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		Reporter.log("Test Started Running:"+ result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
	
		if(result.isSuccess())
		{
			try {
			File fo=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
				FileHandler.copy(fo,new File(Projectpath+"//Sucess//"+filepath+".png"));
			
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Reporter.log("<a href='" + Projectpath+"//Sucess//"+filepath+".png" + "'> <img src='" + Projectpath+"//Sucess//"+filepath+".png" + "' height='100' width='100'/> </a>");
			Reporter.log("Test has passed:" + result.getMethod().getMethodName());
		
		}
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		if(!result.isSuccess())
		{
			try 
			{
				File fo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(fo, new File(Projectpath+"//failure//"+filepath+".png"));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Reporter.log("<a href='" + Projectpath+"//failure//"+filepath+".png" + "'> <img src='" + Projectpath+"//failure//"+filepath+".png" + "' height='100' width='100'/> </a>");
			Reporter.log("Test has Failed:" + result.getMethod().getMethodName());
		}
		
			
		
	}

	public void onTestSkipped(ITestResult result) {
	
		
		Reporter.log("Test is skipped :" + result.getMethod().getMethodName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
