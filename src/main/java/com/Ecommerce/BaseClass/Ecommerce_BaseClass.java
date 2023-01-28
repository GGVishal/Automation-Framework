package com.Ecommerce.BaseClass;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecommerce.Configuration.ReadConfiguration;
import com.Ecommerce.Utilities.TestUtils;
import com.beust.jcommander.Parameter;

import net.bytebuddy.utility.RandomString;

public class Ecommerce_BaseClass {
	
	ReadConfiguration readConfi = new ReadConfiguration();
	
	
	public String BaseURL = readConfi.getApplicationURL();
	public String ff = readConfi.getFirefoxpath();
	public String UserName = readConfi.getUsername();
	public String Pass = readConfi.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("Browser")
	@BeforeMethod
	public void Setup(String browserName){
		logger =logger.getLogger("Ecommerce_BaseClass");
		PropertyConfigurator.configure("Log4j.properties");
		
		// Setting up browser as per parameter
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.driver.chrome", readConfi.getChromePath());
			driver = new ChromeDriver();
		
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.chrome", readConfi.getFirefoxpath());
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(BaseURL);
		
	} 
	
	public String getScreenshotAs(String TCname) throws IOException  {
		
		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String random = RandomString.make(3);                // Random String

		String destiStr = System.getProperty("user.dir")+"/Screenshot/"+TCname+random+".png";
		
		FileHandler.copy(Source, new File(destiStr));
		  
		return destiStr;
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
