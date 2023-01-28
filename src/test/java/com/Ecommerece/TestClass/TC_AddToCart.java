package com.Ecommerece.TestClass;

import org.testng.annotations.Test;

import com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import com.Ecommerce.PageClass.TC_AddToCartPage;
import com.Ecommerce.PageClass.TC_Ecommerce_LoginPage;

public class TC_AddToCart extends Ecommerce_BaseClass {
	
	
	@Test
	public void addToCart() throws InterruptedException {
		
		TC_Ecommerce_LoginPage TEL = new TC_Ecommerce_LoginPage();
		Thread.sleep(3000);
		logger.info("enter username");
		TEL.SetUserName(UserName);
		TEL.SetPassword(Pass);
		TEL.ClickButton();
		
		
		
	}
	
	
}
