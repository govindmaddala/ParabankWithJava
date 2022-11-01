package com.ParaBank.testScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ParaBank.base.BaseClass;
import com.ParaBank.pageObjects.ForgetPage;
import com.ParaBank.pageObjects.IndexPage;
import com.ParaBank.pageObjects.RegisterPage;

public class ForgetPageTest extends BaseClass
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(ForgetPageTest.class.getName());
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver=sourceDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Browser is invoked and url is opened for ForgetPage Test");
	}
	
	@Test
	public void RetrieveLoginInfo() throws IOException
	{
		ForgetPage fp=IndexPage.Forget(driver);
		RegisterPage rp=new RegisterPage();
		FileInputStream fis=new FileInputStream(cred_path);
		proper.load(fis);
		rp.fname(driver).sendKeys(proper.getProperty("fname"));
		rp.lname(driver).sendKeys(proper.getProperty("lname"));
		rp.Street(driver).sendKeys(proper.getProperty("address"));
		rp.City(driver).sendKeys(proper.getProperty("city"));
		rp.state(driver).sendKeys(proper.getProperty("state"));
		rp.Zip(driver).sendKeys(proper.getProperty("zip"));
		rp.Ssn(driver).sendKeys(proper.getProperty("ssn"));
		fp.ForgetSubmitBtn(driver).click();
		
		log.info("Required details are provided and submitted");
		
		String expected="Your login information was located successfully. You are now logged in.";
		String actual= fp.SuccessMsg(driver).getText();
				
		if (actual.contains(expected))
		{
			Assert.assertTrue(true);
			log.info("Login details are retrieved and user is successfully logged-in ");
		}
		else if(fp.ErrorMsg(driver).isDisplayed())
		{
			Assert.assertFalse(true);
			log.info("Login details are not retrieved because of 'An internal error has occurred and has been logged.' ");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("ForgetPage Test is done and browser is closed");
	}
}
