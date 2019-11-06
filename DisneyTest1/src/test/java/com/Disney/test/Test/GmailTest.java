package com.Disney.test.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Disney.test.Shared.Base;

public class GmailTest extends Base {

	@Before
	public void openBrowserAndUrl() throws Exception {
		setDriver("Chrome");
		getURL("http://gmail.com/");
	}

	@After
	public void finalize() {
		closeBrowser(driver);
	}

	// Positive test for Login and checking icon in the right upper corner
	@Test()
	public void loginTest() throws Exception {

		System.out.println("\n\nTest: Login to the Gmail");

		obj.GmailLoginPage(driver).enterEmailOrPhone("dennisdisneyfortest@gmail.com");
		obj.GmailLoginPage(driver).clickNextEmail();
		obj.GmailPassPage(driver).enterPassword("Test123!");
		obj.GmailPassPage(driver).clickNextPassword();
		obj.EmailPage(driver).checkForIcon("dennisdisneyfortest@gmail.com");
		
		System.out.println("\n\nPassed - Login to the Gmail");
		
		Thread.sleep(5000);

	}

	// Negative test for checking email error message while entering wrong email
	@Test()
	public void loginWrongEmailTest() throws Exception {

		System.out.println("\n\nTest: Login to the Gmail. Wrong Email.");

		obj.GmailLoginPage(driver).enterEmailOrPhone("wrong_dennisdisneyfortest@gmail.com");
		obj.GmailLoginPage(driver).clickNextEmail();
		obj.GmailLoginPage(driver).checkEmailError();

		System.out.println("\n\nPassed - Login to the Gmail. Wrong Email.");
		
		Thread.sleep(5000);

	}

	// Negative test for checking email error message while entering wrong email
	@Test()
	public void loginWrongPassTest() throws Exception {

		System.out.println("\n\nTest: Login to the Gmail. Wrong Password");

		obj.GmailLoginPage(driver).enterEmailOrPhone("dennisdisneyfortest@gmail.com");
		obj.GmailLoginPage(driver).clickNextEmail();
		obj.GmailPassPage(driver).enterPassword("wrong_Test123!");
		obj.GmailPassPage(driver).clickNextPassword();
		obj.GmailPassPage(driver).checkPasswordError();

		System.out.println("\n\nPassed- Login to the Gmail. Wrong Password");
		
		Thread.sleep(5000);

	}

}
