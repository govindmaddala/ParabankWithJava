package com.ParaBank.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public WebDriver driver;
	public static Properties prop;
	public static Properties proper = new Properties();
	public static String cred_path = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\ParaBank\\base\\credentials.properties";
	public static String path = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\ParaBank\\base\\config.properties";
	String driverPath = System.getProperty("user.dir") + "\\Drivers";

	public WebDriver sourceDriver() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(path);

		prop.load(fis);

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			if (browserName.contains("headless")) {
				op.addArguments("headless");
			}
			driver = new ChromeDriver(op);
		}
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public String GetScreenShot(WebDriver driver, String className, String methodName) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(100,400)");
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String img_path = System.getProperty("user.dir") + "\\reports\\" + className + "-" + methodName + ".png";
		FileUtils.copyFile(img, new File(img_path));
		return img_path;
	}

}
