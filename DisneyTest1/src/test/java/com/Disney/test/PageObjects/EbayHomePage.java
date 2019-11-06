package com.Disney.test.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;

public class EbayHomePage {

	protected final WebDriver driver;
	protected Checking chk;
	protected ActionsUi action;

	Logger log;

	public EbayHomePage(WebDriver driver) {
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
	By input_searchField = By.xpath("//input[@id='gh-ac']");
	By searchBtn = By.xpath("//input[@id='gh-btn']");

	/**
	 * Enter text in to 'Search' field
	 * 
	 * @return
	 */
	public EbayHomePage enterSearchContext(String txt) {
		action.enterText(input_searchField, "Search Field", txt);
		return this;
	}

	/**
	 * Clicking Search button
	 * @return
	 */
	public EbayHomePage clickSearch() {
		action.clickItem(searchBtn, "Search button");
		return this;
	}

}
