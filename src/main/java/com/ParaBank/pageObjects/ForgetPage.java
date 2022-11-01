package com.ParaBank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPage 
{
	public By submitBtn=By.cssSelector("[value*='Find My Login']");
	public By errormsg=By.cssSelector(".error");
	public By successMsg=By.xpath("//div[@id='rightPanel']/p[1]");
	
	public WebElement ForgetSubmitBtn(WebDriver driver)
	{
		return driver.findElement(submitBtn);
	}
	
	public WebElement ErrorMsg(WebDriver driver)
	{
		return driver.findElement(errormsg);
	}
	
	public WebElement SuccessMsg(WebDriver driver)
	{
		return driver.findElement(successMsg);
	}
}
