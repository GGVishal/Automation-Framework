package com.Ecommerece.TestClass;

    
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommerce.BaseClass.Ecommerce_BaseClass;

import com.Ecommerce.PageClass.TC_Ecommerce_LoginPage;
public class TC_LoginTestCase extends Ecommerce_BaseClass {
	
	@Test
	public void Login_TestCase() throws InterruptedException, IOException {
		
		TC_Ecommerce_LoginPage TEL = new TC_Ecommerce_LoginPage();
		Thread.sleep(3000);
		logger.info("enter username");
		TEL.SetUserName(UserName);
		TEL.SetPassword(Pass);
		TEL.ClickButton();
		
		String expectedTitle ="nopCommerce demo store"; 
		
		if (driver.getTitle().equals(expectedTitle)) {
			Assert.assertTrue(true);
		}else {
			
			getScreenshotAs(expectedTitle);
			System.out.println(getScreenshotAs(expectedTitle));
			logger.info("Login Failed !!!");
			Assert.assertTrue(false);
		}
		
		
	}

	
	
} 
