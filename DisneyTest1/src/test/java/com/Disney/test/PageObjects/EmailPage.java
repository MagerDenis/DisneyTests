package com.Disney.test.PageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;

public class EmailPage {

	protected final WebDriver driver;
	protected Checking chk;
	protected ActionsUi action;

	Logger log;

	public EmailPage(WebDriver driver) {
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
	By googleAccountIcon = By.xpath("//a[contains(@aria-label,'Google Account')]");

	/**
	 * Check that icon contains email
	 * @param txt
	 * @return
	 * @throws Exception 
	 */
	public EmailPage checkForIcon(String txt) throws Exception {
		log.warn("Checking that account icon contains " + txt);
		By icon = By.xpath("//a[contains(@aria-label,'" + txt + "')]");
		chk.waitElement(googleAccountIcon);
		boolean present = chk.isElementPresent(icon);
		if(present) {
			chk.highlightElement(icon);
			log.warn("icon with text " + txt + " found");
			}
		
		Assert.assertTrue("This is not " + txt + " icon", present);
		return this;
	}

	
	
	
}
