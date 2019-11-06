package com.Disney.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checking {

	private WebDriver driver;
	Logger log;

	public Checking(WebDriver driver)
	{
		/* Get actual class name to be printed on */
		log = Logger.getLogger(this.getClass().getName());
		this.driver = driver;
	}

	/**
	 * Wait until this element will be present for 60 seconds with 1 sec period
	 * @param by - Locator
	 * @throws Exception
	 */
	public void waitElement(By by) throws Exception
	{

		if (!isElementPresent(by)){
			int total = 1;
			System.out.print("Waiting for element... ");
			for (int second = 1;; second++) {
				if (second >= 60) throw new Exception("Timeout exception!");
				try { if (isElementPresent(by)) break; } catch (Exception e) {}
				System.out.print(".");
				Thread.sleep(1000);
				total = second;
			}
			System.out.println(total + " sec.");
		}
	}


	/**
	 * Highlight element by changing border color
	 * @param by - locator
	 * @throws InterruptedException
	 */
	public void highlightElement(By by) throws InterruptedException {
		WebElement element = driver.findElement(by);
		highlightElement(element);
	}

	/**
	 * Highlight element by changing border color
	 * @param element - WebElement
	 * @throws InterruptedException
	 */
	public void highlightElement(WebElement element) throws InterruptedException {
		String s = element.getAttribute("style");
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
					element, "color: yellow; border: 5px solid yellow;");
			Thread.sleep(50);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
					element, s);
		}
	}

	
	/**
	 * Checking for visibility of element
	 * @param by - Locator
	 * @return boolean
	 * @throws InterruptedException 
	 */
	public boolean isElementPresent(By by) throws InterruptedException {

		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			List<WebElement> allLinks = driver.findElements(by);

			int links = 0;
			for(int i = 0; i<allLinks.size(); i++){
				if(allLinks.get(i).isDisplayed()) links++;			
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			if(links == 0)
				return false;
			else
				return true;

		}
		catch (NoSuchElementException e) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return false;
		}
	}
}
