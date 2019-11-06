package com.Disney.test.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;

public class GoogleHomePage {

	protected final WebDriver driver;
	protected Checking chk;
	protected ActionsUi action;

	Logger log;

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		chk = new Checking(driver);

		action = new ActionsUi(driver);

		/* Get actual class name to be printed on */
		log = Logger.getLogger(this.getClass().getName());

	}

	// The locators for these elements should only be defined once.
	By signInBtn = By.xpath("//a[contains(@href,'ServiceLogin')]");


	/**
	 * Click Next button on Email page
	 * 
	 * @return
	 */
	public GoogleHomePage clickSignInBtn() {
		action.clickItem(signInBtn, "Sign In button");
		return this;
	}

}
