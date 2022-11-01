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
import com.ParaBank.pageObjects.HomePage;
import com.ParaBank.pageObjects.IndexPage;
import com.ParaBank.pageObjects.RegisterPage;

public class IndexPageTest extends BaseClass
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(IndexPageTest.class.getName());
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver=sourceDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Browser is invoked and url is opened for IndexPage Test");
	}
	
	@Test
	public void LoginTest() throws IOException  
	{
		FileInputStream fis=new FileInputStream(cred_path);
		proper.load(fis);
		String UserName=proper.getProperty("username");
		String Password=proper.getProperty("password");
		IndexPage.login(driver, UserName, Password);
		boolean flag=HomePage.LogoutLink(driver).isDisplayed();
		log.info("Credentials are entered and login is done");
		Assert.assertTrue(flag);
		HomePage.LogoutLink(driver).click();
		log.info("logout is done and returned to index page");
	}
	
	@Test
	public void ForgotTest() 
	{
		ForgetPage forget=IndexPage.Forget(driver);
		boolean flag=forget.ForgetSubmitBtn(driver).isDisplayed();
		Assert.assertTrue(flag);
		log.info("Forgot Test is done and button's display is checked");
	}
	
	@Test
	public void RegisterTest()   
	{
		RegisterPage reg=IndexPage.Register(driver);
		boolean flag=reg.RegistrationBtn(driver).isDisplayed();
		Assert.assertTrue(flag);
		log.info("Register Test is done and button's display is checked");
	}
	
	@Test
	public void LogoIconTest()   
	{
		boolean flag=IndexPage.validateLogo(driver).isDisplayed();
		Assert.assertTrue(flag);
		log.info("LogoIcon Test is done and button's display is checked");
	}
	@Test
	public void CaptionTest()
	{
		String actual=IndexPage.validateCaption(driver).getText();
		String expected="Experience the difference";
		Assert.assertEquals(expected, actual);
		log.info("Caption Test is done and caption is cross-checked");
	}
	@Test
	public void HomeIconTest()
	{
		boolean flag=IndexPage.validateHomeIcon(driver).isDisplayed();
		Assert.assertTrue(flag);
		log.info("HomeIcon Test is done and button's display is checked");
	}
	@Test
	public void AboutIconTest()
	{
		boolean flag=IndexPage.validateAboutIcon(driver).isDisplayed();
		Assert.assertTrue(flag);
		log.info("AboutIcon Test is done and button's display is checked");
	}
	@Test
	public void ContactIconTest()
	{
		boolean flag=IndexPage.validateContactIcon(driver).isDisplayed();
		Assert.assertTrue(flag);
		log.info("ContactIconTest is done and button's display is checked");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
