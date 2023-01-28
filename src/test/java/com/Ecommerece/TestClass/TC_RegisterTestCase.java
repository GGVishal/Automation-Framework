package com.Ecommerece.TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import com.Ecommerce.PageClass.Tc_Ecommerce_RegisterPage;

public class TC_RegisterTestCase extends Ecommerce_BaseClass {
	
	@Test
	public void newRegeStration() throws IOException {
		
		Tc_Ecommerce_RegisterPage tcr = new Tc_Ecommerce_RegisterPage();
		 tcr.RegistrationForm();
		 tcr.ClickMaleRadio();
		 tcr.SetFirstName("Vishal");
		 tcr.SetLastName("Gadade");
		 tcr.SetEmail("khsd.gadade14@gmail.com");
		 tcr.SetPassoword("nop123");
		 tcr.SetConfirmedPassoword("nop123");
		 tcr.Submit();
		 
		boolean test = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed();
		if (test== true) {
			logger.info("User Created");
			Assert.assertTrue(true);
		} else {
			logger.info("User Creatation Failed");
			getScreenshotAs("newRegeStration");
			Assert.assertTrue(false);
		}
	}
	
}
