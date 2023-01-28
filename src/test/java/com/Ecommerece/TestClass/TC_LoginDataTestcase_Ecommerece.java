package com.Ecommerece.TestClass;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import com.Ecommerce.PageClass.TC_Ecommerce_LoginPage;
import com.Ecommerce.Utilities.XLSUtilities;


public class TC_LoginDataTestcase_Ecommerece extends Ecommerce_BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginData(String uName, String pwd, String expectation) throws InterruptedException, IOException {
		logger.info("Open URL");
		TC_Ecommerce_LoginPage TEL = new TC_Ecommerce_LoginPage();
		Thread.sleep(3000);

		logger.info("Username Entered");

		TEL.SetUserName(uName);
		System.out.println("Hello");
		logger.info("Enter user mail");
		Thread.sleep(3000);
		TEL.SetPassword(pwd);
		logger.info("Enter User password");
		Thread.sleep(3000);
		TEL.ClickButton();
		logger.info("Clicked on longin button");
		String Actual_Result = driver.getTitle();
		String Expected_Result = "nopCommerce demo store";

		if (expectation.equals("Valid")) {

			if (Actual_Result.equals(Expected_Result)) {
//				TEL.Logout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} else if (Expected_Result.equals("Invalid")) {

			if (Expected_Result.equals(Actual_Result)) {
//				TEL.Logout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] DataLogin() throws IOException {
		String path = System.getProperty("user.dir")+"/src/main/java/com/Ecommerce/TestData/Login_TestData.xlsx";
		
		
		int rowCount = XLSUtilities.getRowCout(path, "Sheet1");
		int cellCount = XLSUtilities.getCellCount(path, "Sheet1", rowCount);

		String UserData[][] = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {
				UserData[i - 1][j] = XLSUtilities.getCellData(path, "Sheet1", i, j);
			}

		}
		return UserData;
	}

}
