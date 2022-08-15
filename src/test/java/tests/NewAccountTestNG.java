package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import page_objects.FormPage;
import page_objects.HomePage;
import page_objects.LoginPage;

//testing the creation of a new account - initial validation before moving to the form of a new account data

public class NewAccountTestNG extends BaseTest{
	@Test (description = " click login")
	@Description("click  the login  link")
	private void TC_01_login() {
		HomePage hp = new HomePage(driver);
		hp.sleep(5000);
		hp.Login();
		hp.sleep(500);
		LoginPage lp = new LoginPage(driver);
		String actual = lp.getPageName();
		System.out.println(actual);
		String expected = "AUTHENTICATION";
		assertEquals(actual, expected);	
	}
	
	@Test (description = "empty mail")
	@Description("click  the login  link without typing an email")
	private void TC_02_create_null() {
		LoginPage lp = new LoginPage(driver);
		lp.clickCreate();
		lp.sleep(5000);
		String actual = lp.getCreateErr();
		System.out.println(actual);
		String expected = "Invalid email address.";
		assertEquals(actual, expected);		
	}

	
	@Test (description = "wrong mail")
	@Description("click  the login  link with invalid  email")
	private void TC_03_create_invalid() {
		LoginPage lp = new LoginPage(driver);
		lp.createAccount("1111");
		lp.sleep(5000);
		String actual = lp.getCreateErr();
		System.out.println(actual);
		String expected = "Invalid email address.";
		assertEquals(actual, expected);		
	}

	
	@Test (description = "existing mail")
	@Description("click  the login  link with existing  email")
	private void TC_04_create_existing() {
		LoginPage lp = new LoginPage(driver);
		lp.createAccount("esevbar@gmail.com");
		lp.sleep(5000);
		String actual = lp.getCreateErr();
		System.out.println(actual);
		String expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
		assertEquals(actual, expected);		
	}
	
	@Test (description = "valid mail")
	@Description("click  the login  link with a valid  email")
	private void TC_05_create_new() {
		LoginPage lp = new LoginPage(driver);
		lp.createAccount("13214@gmail.com");
		lp.sleep(10000);
		FormPage fp = new FormPage(driver);
		String actual = fp.getPageName();
		System.out.println(actual);
		String expected = "CREATE AN ACCOUNT";
		assertEquals(actual, expected);		
	}

}
