package com.ParaBank.testScripts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ParaBank.base.BaseClass;
import com.ParaBank.pageObjects.HomePage;
import com.ParaBank.pageObjects.IndexPage;
import com.ParaBank.pageObjects.RegisterPage;

public class RegisterTest extends BaseClass
{
	WebDriver driver;
	public static Logger log=LogManager.getLogger(RegisterTest.class.getName());
	RegisterPage rp;
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver=sourceDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Browser is invoked for RegisterPage test");
	}
	
	@Test(dataProvider="validData")
	public void ANewRegister(String fname,String lname,String street,String city,String state,
			String zip,String phone,String ssn,String User,String password,String pwd) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		rp=IndexPage.Register(driver);
		rp.fname(driver).sendKeys(fname);
		rp.lname(driver).sendKeys(lname);
		rp.Street(driver).sendKeys(street);
		rp.City(driver).sendKeys(city);
		rp.state(driver).sendKeys(state);
		
		int zipcode=Integer.parseInt(zip);
		if(zipcode>=0)
		{
			rp.Zip(driver).sendKeys(zip);
		}
		
		
		int num=Integer.parseInt(phone);
		if(num>=0)
		{
			rp.Phone(driver).sendKeys(phone);
		}
			
		
		if (ssn.substring(3).contains("-") && ssn.substring(6).contains("-"))
		{
			rp.Ssn(driver).sendKeys(ssn);
		}
		
		rp.UserName(driver).sendKeys(User);
		rp.Password(driver).sendKeys(password);
		rp.Repeatpwd(driver).sendKeys(pwd);
		rp.Registration(driver);
		
		log.info("Valid details are provided and sign-up is done");
		
		
		boolean flag=HomePage.LogoutLink(driver).isDisplayed();
		Assert.assertTrue(flag);
		
		HomePage.LogoutLink(driver).click();
		
		FileOutputStream fos=new FileOutputStream(cred_path);
		proper.setProperty("fname",fname);
		proper.setProperty("lname",lname);
		proper.setProperty("address",street);
		proper.setProperty("city",city);
		proper.setProperty("state",state);
		proper.setProperty("zip",zip);
		proper.setProperty("ssn",ssn);
		proper.setProperty("username", User);
		proper.setProperty("password", password);
		proper.store(fos, null);
		
		
		log.info("Details are saved into credentials.properties file to use further");
	}

	@DataProvider
	public Object[][] validData()
	{
		Object[][] data=new Object[1][11];
		
		//registering new user        (Expected: Pass)
		data[0][0]="fname";
		data[0][1]="lname";
		data[0][2]="street";
		data[0][3]="city";
		data[0][4]="state";
		data[0][5]="123456";
		data[0][6]="1234567890";
		data[0][7]="SSS-SS-NNNN";
		data[0][8]="lajapati";
		data[0][9]="DemoPassword";
		data[0][10]="DemoPassword";
		return data;
	}
	
	@Test(dataProvider="existingUser")
	public void UserExisting(String fname,String lname,String street,String city,String state,
			String zip,String phone,String ssn,String User,String password,String pwd) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		rp=IndexPage.Register(driver);
		rp.fname(driver).sendKeys(fname);
		rp.lname(driver).sendKeys(lname);
		rp.Street(driver).sendKeys(street);
		rp.City(driver).sendKeys(city);
		rp.state(driver).sendKeys(state);
		
		int zipcode=Integer.parseInt(zip);
		if(zipcode>=0)
		{
			rp.Zip(driver).sendKeys(zip);
		}
		
		
		int num=Integer.parseInt(phone);
		if(num>=0)
		{
			rp.Phone(driver).sendKeys(phone);
		}
			
		
		if (ssn.substring(3).contains("-") && ssn.substring(6).contains("-"))
		{
			rp.Ssn(driver).sendKeys(ssn);
		}
		
		rp.UserName(driver).sendKeys(User);
		rp.Password(driver).sendKeys(password);
		rp.Repeatpwd(driver).sendKeys(pwd);
		rp.Registration(driver);
		
		log.info("Valid details are provided and sign-up is done");
		
		
		boolean flag=HomePage.LogoutLink(driver).isDisplayed();
		Assert.assertTrue(flag);
		
		HomePage.LogoutLink(driver).click();
		
		FileOutputStream fos=new FileOutputStream(cred_path);
		proper.setProperty("fname",fname);
		proper.setProperty("lname",lname);
		proper.setProperty("address",street);
		proper.setProperty("city",city);
		proper.setProperty("state",state);
		proper.setProperty("zip",zip);
		proper.setProperty("ssn",ssn);
		proper.setProperty("username", User);
		proper.setProperty("password", password);
		proper.store(fos, null);
		
		
		log.info("Details are saved into credentials.properties file to use further");
	}

	@DataProvider
	public Object[][] existingUser()
	{
		Object[][] data=new Object[1][11];
		
		//registering new user        (Expected: Pass)
		data[0][0]="fname";
		data[0][1]="lname";
		data[0][2]="street";
		data[0][3]="city";
		data[0][4]="state";
		data[0][5]="123456";
		data[0][6]="1234567890";
		data[0][7]="SSS-SS-NNNN";
		data[0][8]="lajapati";
		data[0][9]="DemoPassword";
		data[0][10]="DemoPassword";
		return data;
	}
	
	@Test(dataProvider="passwordMismatch")
	public void PasswordMismatch(String fname,String lname,String street,String city,String state,
			String zip,String phone,String ssn,String User,String password,String pwd) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		rp=IndexPage.Register(driver);
		rp.fname(driver).sendKeys(fname);
		rp.lname(driver).sendKeys(lname);
		rp.Street(driver).sendKeys(street);
		rp.City(driver).sendKeys(city);
		rp.state(driver).sendKeys(state);
		
		int zipcode=Integer.parseInt(zip);
		if(zipcode>=0)
		{
			rp.Zip(driver).sendKeys(zip);
		}
		
		
		int num=Integer.parseInt(phone);
		if(num>=0)
		{
			rp.Phone(driver).sendKeys(phone);
		}
			
		
		if (ssn.substring(3).contains("-") && ssn.substring(6).contains("-"))
		{
			rp.Ssn(driver).sendKeys(ssn);
		}
		
		rp.UserName(driver).sendKeys(User);
		rp.Password(driver).sendKeys(password);
		rp.Repeatpwd(driver).sendKeys(pwd);
		rp.Registration(driver);
		
		log.info("Valid details are provided and sign-up is done");
		
		
		boolean flag=HomePage.LogoutLink(driver).isDisplayed();
		Assert.assertTrue(flag);
		
		HomePage.LogoutLink(driver).click();
		
		FileOutputStream fos=new FileOutputStream(cred_path);
		proper.setProperty("fname",fname);
		proper.setProperty("lname",lname);
		proper.setProperty("address",street);
		proper.setProperty("city",city);
		proper.setProperty("state",state);
		proper.setProperty("zip",zip);
		proper.setProperty("ssn",ssn);
		proper.setProperty("username", User);
		proper.setProperty("password", password);
		proper.store(fos, null);
		
		
		log.info("Details are saved into credentials.properties file to use further");
	}

	@DataProvider
	public Object[][] passwordMismatch()
	{
		Object[][] data=new Object[1][11];
		
		data[0][0]="fname";
		data[0][1]="lname";
		data[0][2]="street";
		data[0][3]="city";
		data[0][4]="state";
		data[0][5]="123456";
		data[0][6]="1029384756";
		data[0][7]="SSS-SS-NNNN";
		data[0][8]="passwordMismatch";
		data[0][9]="DemoPassword";
		data[0][10]="Password";
		return data;
	}
	
	@Test(dataProvider="nullSet")
	public void NullSet(String fname,String lname,String street,String city,String state,
			String zip,String phone,String ssn,String User,String password,String pwd) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		rp=IndexPage.Register(driver);
		rp.fname(driver).sendKeys(fname);
		rp.lname(driver).sendKeys(lname);
		rp.Street(driver).sendKeys(street);
		rp.City(driver).sendKeys(city);
		rp.state(driver).sendKeys(state);
		
		int zipcode=Integer.parseInt(zip);
		if(zipcode>=0)
		{
			rp.Zip(driver).sendKeys(zip);
		}
		
		
		int num=Integer.parseInt(phone);
		if(num>=0)
		{
			rp.Phone(driver).sendKeys(phone);
		}
			
		
		if (ssn.substring(3).contains("-") && ssn.substring(6).contains("-"))
		{
			rp.Ssn(driver).sendKeys(ssn);
		}
		
		rp.UserName(driver).sendKeys(User);
		rp.Password(driver).sendKeys(password);
		rp.Repeatpwd(driver).sendKeys(pwd);
		rp.Registration(driver);
		log.info("Valid details are provided and sign-up is done");
		
		
		boolean flag=HomePage.LogoutLink(driver).isDisplayed();
		Assert.assertTrue(flag);
		
		HomePage.LogoutLink(driver).click();
		
		FileOutputStream fos=new FileOutputStream(cred_path);
		proper.setProperty("fname",fname);
		proper.setProperty("lname",lname);
		proper.setProperty("address",street);
		proper.setProperty("city",city);
		proper.setProperty("state",state);
		proper.setProperty("zip",zip);
		proper.setProperty("ssn",ssn);
		proper.setProperty("username", User);
		proper.setProperty("password", password);
		proper.store(fos, null);
		
		
		log.info("Details are saved into credentials.properties file to use further");
	}

	@DataProvider
	public Object[][] nullSet()
	{
		Object[][] data=new Object[1][11];
		data[0][0]=null;
		data[0][1]=null;
		data[0][2]=null;
		data[0][3]=null;
		data[0][4]=null;
		data[0][5]=null;
		data[0][6]=null;
		data[0][7]=null;
		data[0][8]=null;
		data[0][9]=null;
		data[0][10]=null;
		return data;
	}
	
	@Test(dataProvider="invalidPhone")
	public void InvalidZipAndPhone(String fname,String lname,String street,String city,String state,
			String zip,String phone,String ssn,String User,String password,String pwd) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		rp=IndexPage.Register(driver);
		rp.fname(driver).sendKeys(fname);
		rp.lname(driver).sendKeys(lname);
		rp.Street(driver).sendKeys(street);
		rp.City(driver).sendKeys(city);
		rp.state(driver).sendKeys(state);
		
		int zipcode=Integer.parseInt(zip);
		if(zipcode>=0)
		{
			rp.Zip(driver).sendKeys(zip);
		}
		
		
		int num=Integer.parseInt(phone);
		if(num>=0)
		{
			rp.Phone(driver).sendKeys(phone);
		}
			
		
		if (ssn.substring(3).contains("-") && ssn.substring(6).contains("-"))
		{
			rp.Ssn(driver).sendKeys(ssn);
		}
		
		rp.UserName(driver).sendKeys(User);
		rp.Password(driver).sendKeys(password);
		rp.Repeatpwd(driver).sendKeys(pwd);
		rp.Registration(driver);
		
		log.info("Valid details are provided and sign-up is done");
		
		
		boolean flag=HomePage.LogoutLink(driver).isDisplayed();
		Assert.assertTrue(flag);
		
		HomePage.LogoutLink(driver).click();
		
		FileOutputStream fos=new FileOutputStream(cred_path);
		proper.setProperty("fname",fname);
		proper.setProperty("lname",lname);
		proper.setProperty("address",street);
		proper.setProperty("city",city);
		proper.setProperty("state",state);
		proper.setProperty("zip",zip);
		proper.setProperty("ssn",ssn);
		proper.setProperty("username", User);
		proper.setProperty("password", password);
		proper.store(fos, null);
		
		
		log.info("Details are saved into credentials.properties file to use further");
	}

	@DataProvider
	public Object[][] invalidPhone()
	{
		Object[][] data=new Object[1][11];
		
		data[0][0]="fname";
		data[0][1]="lname";
		data[0][2]="street";
		data[0][3]="city";
		data[0][4]="state";
		data[0][5]="zipcode";
		data[0][6]="phone";
		data[0][7]="SSS-SS-NNNN";
		data[0][8]="invalidphone";
		data[0][9]="DemoPassword";
		data[0][10]="DemoPassword";
		return data;
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("RegisterPage test is done and browser is closed");
	}
}
