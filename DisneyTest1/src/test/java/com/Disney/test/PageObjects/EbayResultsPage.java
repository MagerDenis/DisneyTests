package com.Disney.test.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;

public class EbayResultsPage {

	protected final WebDriver driver;
	protected Checking chk;
	protected ActionsUi action;

	Logger log;

	public EbayResultsPage(WebDriver driver) {
		this.driver = driver;
		chk = new Checking(driver);

		action = new ActionsUi(driver);

		/* Get actual class name to be printed on */
		log = Logger.getLogger(this.getClass().getName());

		// Checking that we are on right page
		if (!driver.getTitle().trim().contains("eBay")) {
			log.error("This is not the Ebay page. It's" + driver.getTitle());
			throw new IllegalStateException("This is not the Gmail page. It's" + driver.getTitle());
		}

	}

	// The locators for these elements should only be defined once.
	//No locators for this page

	/**
	 * Clicking Item By Number
	 * @return
	 */
	public EbayResultsPage clickItemByNumber(int num) {
		By item = By.xpath("//h3[@class='s-item__title'][" + num + "]");
		action.clickItem(item, "Click " + num + " item");
		return this;
	}

}
