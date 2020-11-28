package com.impTest;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest{

	
public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
			report = new ExtentReports(Projectpath+"//ExtentReports//"+"report.html");
			report.loadConfig(new File(Projectpath+"//extentreportconfig.xml"));
			report.addSystemInfo("Selenium Language", "3.141.59");
		}
		
		return report;
	}

	
	
	
	
}
