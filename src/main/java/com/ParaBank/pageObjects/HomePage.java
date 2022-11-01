package com.ParaBank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	int row=2;
	public static By openAccount=By.cssSelector("[href*='openaccount']");
	public static By overView=By.cssSelector("[href*='overview']");
	public static By transfer=By.cssSelector("[href*='transfer']");
	public static By billpay=By.cssSelector("[href*='billpay']");
	public static By findTransaction=By.cssSelector("[href*='findtrans']");
	public static By updateProfile=By.cssSelector("[href*='update']");
	public static By loan=By.cssSelector("[href*='loan']");
	public static By logout=By.cssSelector("[href*='logout']");
	//By accountType=By.xpath("//select[@id='type']");
	
	//By accountOpenSuccess=By.cssSelector("[class='title']");
	//By updateBtn=By.cssSelector("[type='submit']");
	
	//for account creation
	
	public static By accountTypeBtn=By.xpath("//select[@id='type']");
	public static By submitBtn=By.cssSelector("[type='submit']");
	
	
//	public void OpenNewAccount(WebDriver driver)
//	{
//		driver.findElement(openAccount).click();
//		WebElement drop=driver.findElement(accountTypeBtn);
//		Select op=new Select(drop);
//		op.selectByValue("1");  //for savings 
//		driver.findElement(submitBtn).click();   //creates account
//		row++;    //for each calling it increases by 1 and it meant that new extra column is created 
//	}
//	
//	public void AccountOverView(WebDriver driver)
//	{
//		driver.findElement(overView).click();
//		String[] amount=new String[row-1];
//		for(int i=0;i<row;i++)
//		{
//			amount[i]=driver.findElements(By.xpath("//tr/td")).get(2+i*3).getText();
//			amount[i].split("$");
//		}
//		
//	}
	
	
	public static WebElement NewAccountLink(WebDriver driver)
	{
		return driver.findElement(openAccount);
	}
	public static WebElement OverViewLink(WebDriver driver)
	{
		return driver.findElement(overView);
	}
	public static WebElement TransferFundsLink(WebDriver driver)
	{
		return driver.findElement(transfer);
	}
	
	public static WebElement BillsLink(WebDriver driver)
	{
		return driver.findElement(billpay);
	}
	public static WebElement FindTranLink(WebDriver driver)
	{
		return driver.findElement(findTransaction);
	}
	public static WebElement ProfileLink(WebDriver driver)
	{
		return driver.findElement(updateProfile);
	}
	public static WebElement LoanLink(WebDriver driver)
	{
		return driver.findElement(loan);
	}
	public  static WebElement LogoutLink(WebDriver driver)
	{
		return driver.findElement(logout);
	}	
}
