package com.Disney.Utils;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsUi {

	private WebDriver driver;
	Logger log;
	private Checking chk;

	public ActionsUi(WebDriver driver)
	{
		chk = new Checking(driver);
		/* Get actual class name to be printed on */
		log = Logger.getLogger(this.getClass().getName());

		this.driver = driver;
	}

	/**
	 * Wait and entering text in to input field
	 * @param item
	 * @param to
	 * @param txt
	 * @return
	 */
	public ActionsUi enterText(By item, String to, String txt){
		boolean res;

		log.warn("Entering " + txt + " text to " + to);

		try{
			chk.waitElement(item);
			chk.highlightElement(item);
			driver.findElement(item).sendKeys(txt);
			res = true;
		}
		catch(Exception ex){
			res = false;
			log.error("Failed entering text to " + to);
		}
		Assert.assertTrue("Failed entering text to " + to, res);
		return this;		
	}
	
	/**
	 * Wait Item and Click
	 * @param item
	 * @param itemName
	 * @return
	 */
	public ActionsUi clickItem(By item, String itemName){
		boolean res;

		log.warn("Clicking " + itemName);

		try{
			chk.waitElement(item);
			//move to element
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(item)).build().perform();
			
			chk.highlightElement(item);
			driver.findElement(item).click();
			res = true;
		}
		catch(Exception ex){
			res = false;
			log.error("Failed clicking " + itemName);
		}
		Assert.assertTrue("Failed clicking " + itemName, res);
		return this;		
	}
	
	public void closeBrowser(){
		System.out.println("Closing browser...");
		if (driver != null) {
			driver.quit();
		}
	}

}
