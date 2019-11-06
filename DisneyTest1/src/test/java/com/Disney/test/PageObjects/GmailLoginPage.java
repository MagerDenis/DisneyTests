package com.Disney.test.PageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;

public class GmailLoginPage {

	protected final WebDriver driver;
	protected Checking chk;
	protected ActionsUi action;

	Logger log;

	public GmailLoginPage(WebDriver driver) {
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
	By input_emailOrPhone = By.xpath("//input[@id='identifierId']");
	By button_Next = By.xpath("//div[@id='identifierNext']");
	By emailPageErrorMsg = By.xpath("//div[contains(text(),'t find your Google Account')]");

	/**
	 * Enter text in to 'Email or Phone' field
	 * 
	 * @return
	 */
	public GmailLoginPage enterEmailOrPhone(String txt) {
		action.enterText(input_emailOrPhone, "Email or Phone field", txt);
		return this;
	}

	/**
	 * Click Next button on Email page
	 * 
	 * @return
	 */
	public GmailLoginPage clickNextEmail() {
		action.clickItem(button_Next, "Next Email button");
		return this;
	}

	/**
	 * Checking that error message is visible on the email page
	 * @return
	 * @throws Exception
	 */
	public GmailLoginPage checkEmailError() throws Exception {
		log.warn("Checking that email page has error");
		chk.waitElement(emailPageErrorMsg);
		boolean present = chk.isElementPresent(emailPageErrorMsg);
		if(present) {
			chk.highlightElement(emailPageErrorMsg);
			log.warn("Error message is visible");
			}
		
		Assert.assertTrue("error message is not visible", present);
		return this;
	}

}
