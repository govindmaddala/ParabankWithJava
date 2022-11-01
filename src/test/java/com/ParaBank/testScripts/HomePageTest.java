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
import com.ParaBank.pageObjects.HomePage;
import com.ParaBank.pageObjects.IndexPage;

public class HomePageTest extends BaseClass
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver=sourceDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Browser is invoked and url is opened for HomePage Test");
		
		FileInputStream fis=new FileInputStream(cred_path);
		proper.load(fis);
		String UserName=proper.getProperty("username");
		String Password=proper.getProperty("password");
		IndexPage.login(driver, UserName, Password);
		log.info("Credentials are entered and login is done");
	}
	
	@Test
	public void NewAccountLinkStatusTest()
	{
		boolean flag=HomePage.NewAccountLink(driver).isEnabled();
		Assert.assertTrue(flag);
		log.info("NewAccountLinkStatus Test is done");
	}
	@Test
	public void OverViewLinkStatusTest()
	{
		boolean flag=HomePage.OverViewLink(driver) .isEnabled();
		Assert.assertTrue(flag);
		log.info("OverViewLinkStatus Test is done");
	}

	@Test
	public void TransferFundsLinkStatusTest()
	{
		boolean flag=HomePage.NewAccountLink(driver).isEnabled();
		Assert.assertTrue(flag);
		log.info("TransferFundsLinkStatusTest is done");
	}

	@Test
	public void BillsLinkStatusTest()
	{
		boolean flag=HomePage.BillsLink(driver).isEnabled();
		Assert.assertTrue(flag);
		log.info("BillsLinkStatus Test is done");
		
	}

	@Test
	public void FindTranLinkStatusTest()
	{
		boolean flag=HomePage.FindTranLink(driver).isEnabled();
		Assert.assertTrue(flag);
		log.info("FindTranLinkStatus Test is done");
	}
	
	@Test
	public void LoanLinkStatusTest()
	{
		boolean flag=HomePage.LoanLink(driver).isEnabled();
		Assert.assertTrue(flag);
		log.info("LoanLinkStatus Test is done");
	}
	
	@Test
	public void LogoutLinkStatusTest()
	{
		boolean flag=HomePage.LogoutLink(driver).isEnabled();
		Assert.assertTrue(flag);
		log.info("LogoutLinkStatus Test is done");
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("HomePage Test is done and browser is closed");
	}
}
