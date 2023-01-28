package com.Ecommerce.PageClass;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class TC_Ecommerce_LoginPage extends Ecommerce_BaseClass {

	public TC_Ecommerce_LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	public static WebElement UserName;

	@FindBy(id = "Password")
	public static WebElement Password;

	@FindBy(xpath = "//button[text()='Log in']")
	public static WebElement loginButton;

	public void SetUserName(String Uname) {

		UserName.sendKeys(Uname);
	}

	public void SetPassword(String Pass) {

		Password.sendKeys(Pass);
	}

	public void ClickButton() {

		loginButton.click();
	}

}
