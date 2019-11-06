package com.Disney.test.Shared;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import com.Disney.Utils.ActionsUi;
import com.Disney.Utils.Checking;
import com.Disney.Utils.Drivers;
import com.Disney.test.PageObjects.PageObject;


public class Base {

	public WebDriver driver;
	public static PageObject obj;
	public static Checking chk;
	public Logger log;
	public ActionsUi action;
	public static String Browser;
	public static String URL;


	@Before
	public void setUp() throws Exception{
		log = Logger.getLogger(this.getClass().getName());
		obj = new PageObject();
		chk = new Checking(driver);
	}

	public void closeBrowser(WebDriver driver){
		System.out.println("Closing browser...");
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterClass
	public static void printReport(){
		System.out.println("\nTesting is finished!");
	}

	/**
	 * Getting driver by param
	 * @param dr
	 * @throws Exception
	 */
	public void setDriver(String dr) throws Exception{
		driver = Drivers.getDriver(dr);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	/**
	 * Opening URL
	 * @param URL
	 */
	public void getURL(String URL){
		driver.get(URL);
	}

}
