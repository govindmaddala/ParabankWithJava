package com.ParaBank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage 
{
	public static By FName=By.cssSelector("[id*='firstName']");
	public static By LName=By.cssSelector("[id*='lastName']");
	public static By Street=By.cssSelector("[id*='street']");
	public static By City=By.cssSelector("[id*='city']");
	public static By State=By.cssSelector("[id*='state']");
	public static By ZipCode=By.cssSelector("[id*='zipCode']");
	public static By Phone=By.cssSelector("[id*='phoneNumber']");
	public static By Ssn=By.cssSelector("[id*='ssn']");
	public static By UserName=By.cssSelector("[id*='username']");
	public static By Password=By.cssSelector("[id*='password']");
	public static By repeat=By.cssSelector("[id*='repeatedPassword']");
	public static By submitBtn=By.cssSelector("[value='Register']");
	
	public By successMsg=By.xpath("//*[@id='rightPanel']/p");
	public By error=By.cssSelector(".error");
	
	public WebElement fname(WebDriver driver)
	{
		return driver.findElement(FName);
	}

	public WebElement lname(WebDriver driver)
	{
		return driver.findElement(LName);
	}
	
	public WebElement Street(WebDriver driver)
	{
		return driver.findElement(Street);
	}
	
	public WebElement City(WebDriver driver)
	{
		return driver.findElement(City);
	}
	
	public WebElement state(WebDriver driver)
	{
		return driver.findElement(State);
	}
	
	public WebElement Zip(WebDriver driver)
	{
		return driver.findElement(ZipCode);
	}

	public WebElement Phone(WebDriver driver)
	{
		return driver.findElement(Phone);
	}

	public WebElement Ssn(WebDriver driver)
	{
		return driver.findElement(Ssn);
	}
	
	public WebElement UserName(WebDriver driver)
	{
		return driver.findElement(UserName);
	}
	
	public WebElement Password(WebDriver driver)
	{
		return driver.findElement(Password);
	}

	public WebElement Repeatpwd(WebDriver driver)
	{
		return driver.findElement(repeat);
	}
	
	public WebElement RegistrationBtn(WebDriver driver)
	{
		return driver.findElement(submitBtn);
	}

	public HomePage Registration(WebDriver driver)
	{
		driver.findElement(submitBtn).click();
		return new HomePage();
	}	
}
