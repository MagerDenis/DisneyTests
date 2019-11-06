package com.Disney.test.PageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;

public class GmailPassPage {

	protected final WebDriver driver;
	protected Checking chk;
	protected ActionsUi action;

	Logger log;

	public GmailPassPage(WebDriver driver) {
		this.driver = driver;
		chk = new Checking(driver);

		action = new ActionsUi(driver);

		/* Get actual class name to be printed on */
		log = Logger.getLogger(this.getClass().getName());

		// Checking that we are on right page
		if (!driver.getTitle().trim().contains("Gmail")) {
			log.error("This is not the Gmail page");
			throw new IllegalStateException("This is not the Gmail page");
		}

	}

	// The locators for these elements should only be defined once.
	By input_password = By.xpath("//input[@name='password']");
	By passwordNext_Btn = By.xpath("//div[@id='passwordNext']");
	By passPageErrorMsg = By.xpath("//span[contains(text(),'Wrong password. Try again or click Forgot password to reset it.')]");


	/**
	 * Click Next button on the Password page
	 * 
	 * @return
	 */
	public GmailPassPage clickNextPassword() {
		action.clickItem(passwordNext_Btn, "Next password button");
		return this;
	}

	/**
	 * Enter password in the password field
	 * 
	 * @param txt
	 * @return
	 */
	public GmailPassPage enterPassword(String txt) {
		action.enterText(input_password, "Password field", txt);
		return this;
	}

	
	/**
	 * Checking that error message is visible on the Password page
	 * @return
	 * @throws Exception
	 */
	public GmailPassPage checkPasswordError() throws Exception {
		log.warn("Checking that password page has error");
		chk.waitElement(passPageErrorMsg);
		boolean present = chk.isElementPresent(passPageErrorMsg);
		if(present) {
			chk.highlightElement(passPageErrorMsg);
			log.warn("Error message is visible");
			}
		
		Assert.assertTrue("error message is not visible", present);
		return this;
	}
}
