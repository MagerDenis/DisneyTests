package com.Disney.test.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Disney.test.Shared.Base;

public class EbayTest extends Base {

	@Before
	public void openBrowserAndUrl() throws Exception {
		setDriver("Chrome");
		getURL("http://ebay.com/");
	}

	@After
	public void finalize() {
		closeBrowser(driver);
	}

	//Ebay Test.
	//Open home page. Serch for guitar. Open First Get price. Print Price
	@Test()
	public void ebayItemNamePricePrint() throws Exception {

		System.out.println("\n\nTest: Open home page. Serch for guitar. Open First Get price. Print Price");

		obj.EbayHomePage(driver).enterSearchContext("Guitar");
		obj.EbayHomePage(driver).clickSearch();
		
		//Select first. Not "Sponsored"
		obj.EbayResultsPage(driver).clickItemByNumber(1);
		obj.EbayItemPage(driver).printItemName();
		obj.EbayItemPage(driver).printItemPrice();

		System.out.println("\n\nPassed - Open home page. Serch for guitar. Open First Get price. Print Price");
		
		Thread.sleep(5000);

	}

}
