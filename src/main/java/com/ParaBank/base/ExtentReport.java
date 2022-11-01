package com.ParaBank.base;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport 
{
	static ExtentReports er=new ExtentReports();
	
	@BeforeTest
	public static ExtentReports Reports()
	{
	    System.out.println("Erzz");
		String report_path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter esr=new ExtentSparkReporter(report_path);
		esr.config().setReportName("ParaBank Automation report Details");
		esr.config().setDocumentTitle("ParaBank Project Report");
		er.attachReporter(esr);
		er.setSystemInfo("Tester", "Govind Maddala");
		return er;
	}
}
