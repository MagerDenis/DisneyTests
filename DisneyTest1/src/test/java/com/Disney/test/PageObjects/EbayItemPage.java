package com.Disney.test.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;

public class EbayItemPage {

	protected final WebDriver driver;
	protected Checking chk;
	protected ActionsUi action;

	Logger log;

	public EbayItemPage(WebDriver driver) {
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
	By itemPrice = By.xpath("//span[@itemprop='price']");
	By itemName = By.xpath("//h1[@id='itemTitle']");



	/**
	 * Print Item Name
	 * @return
	 * @throws Exception 
	 */
	public EbayItemPage printItemName() throws Exception {
		chk.waitElement(itemName);
		chk.highlightElement(itemName);
		String name = driver.findElement(itemName).getText();
		log.warn("Item Name: " + name);
		return this;
	}
	
	/**
	 * Print Item Price
	 * @return
	 * @throws Exception 
	 */
	public EbayItemPage printItemPrice() throws Exception {
		chk.waitElement(itemPrice);
		chk.highlightElement(itemPrice);
		String name = driver.findElement(itemPrice).getText();
		log.warn("Item Name: " + name);
		return this;
	}

}
