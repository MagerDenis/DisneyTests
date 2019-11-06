package com.Disney.test.PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObject {

/**
	 * Google Home Page
	 * @param driver
	 * @return
	 */
	public GoogleHomePage GoogleHomePage(WebDriver driver){
		GoogleHomePage obj = new GoogleHomePage(driver);
		return obj;
	}	
	
	/**
	 * Gmail Login Page
	 * @param driver
	 * @return
	 */
	public GmailLoginPage GmailLoginPage(WebDriver driver){
		GmailLoginPage obj = new GmailLoginPage(driver);
		return obj;
	}	
	
	/**
	 * Gmail Password Page
	 * @param driver
	 * @return
	 */
	public GmailPassPage GmailPassPage(WebDriver driver){
		GmailPassPage obj = new GmailPassPage(driver);
		return obj;
	}	
	
	
	/**
	 * Gmail Password Page
	 * @param driver
	 * @return
	 */
	public EmailPage EmailPage(WebDriver driver){
		EmailPage obj = new EmailPage(driver);
		return obj;
	}
	
	/**
	 * Ebay Home page
	 * @param driver
	 * @return
	 */
	public EbayHomePage EbayHomePage(WebDriver driver){
		EbayHomePage obj = new EbayHomePage(driver);
		return obj;
	}
	
	
	/**
	 * Ebay Results Page
	 * @param driver
	 * @return
	 */
	public EbayResultsPage EbayResultsPage(WebDriver driver){
		EbayResultsPage obj = new EbayResultsPage(driver);
		return obj;
	}
	
	/**
	 * Ebay Item Page
	 * @param driver
	 * @return
	 */
	public EbayItemPage EbayItemPage(WebDriver driver){
		EbayItemPage obj = new EbayItemPage(driver);
		return obj;
	}
}
