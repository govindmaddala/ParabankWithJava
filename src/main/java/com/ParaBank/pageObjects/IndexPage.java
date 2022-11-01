package com.ParaBank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage
{
	public static By userName=By.cssSelector("[name='username']");
	public static By passWord=By.cssSelector("[type='password']");
	public static By loginBtn=By.cssSelector("[type='submit']");
	
	public static By failLogin=By.cssSelector(".error");

	public static By forgot=By.partialLinkText("Forgot");
	
	public static By register=By.cssSelector("[href*='register']");
	
	public static By logo=By.cssSelector("[src*='logo']");
	public static By caption=By.cssSelector("[class='caption']");
	public static By homeBtn=By.xpath("//li[@class='home']/a");
	public static By aboutBtn=By.xpath("//li[@class='aboutus']/a");
	public static By contactBtn=By.xpath("//li[@class='contact']/a");
	
	public static HomePage login(WebDriver driver,String UserName,String pwd)
	{
		driver.findElement(userName).sendKeys(UserName);
		driver.findElement(passWord).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new HomePage();
	}
	
	public static ForgetPage Forget(WebDriver driver)
	{
		driver.findElement(forgot).click();
		return new ForgetPage();
	}
	
	public static RegisterPage Register(WebDriver driver)
	{
		driver.findElement(register).click();
		return new RegisterPage();
	}
	
	public static WebElement validateLogo(WebDriver driver)
	{
		return driver.findElement(logo);
	}
	public static WebElement validateCaption(WebDriver driver)
	{
		return driver.findElement(caption);
	}
	public static WebElement validateHomeIcon(WebDriver driver)
	{
		return driver.findElement(homeBtn);
	}
	public static WebElement validateAboutIcon(WebDriver driver)
	{
		return driver.findElement(aboutBtn);
	}
	public static WebElement validateContactIcon(WebDriver driver)
	{
		return driver.findElement(contactBtn);
	}
}