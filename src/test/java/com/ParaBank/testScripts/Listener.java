package com.ParaBank.testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ParaBank.base.BaseClass;
import com.ParaBank.base.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseClass implements ITestListener {
	ExtentReports erObj = ExtentReport.Reports();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = erObj.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is passed");
	}

	WebDriver driver = null;

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String className = result.getInstanceName();
		String methodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}

		try {
			test.addScreenCaptureFromPath(GetScreenShot(driver, className, methodName),
					result.getMethod().getMethodName());

		} catch (IOException e) {

		}
	}

	@Override
	public void onFinish(ITestContext context) {
		erObj.flush();
	}
}
