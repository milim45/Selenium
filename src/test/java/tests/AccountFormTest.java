package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import page_objects.FormPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyAccountPage;


//testing the form for creating of a new account - required fields and validation 


public class AccountFormTest extends BaseTest{

	
	@Test(description = "an empty form")
	@Description("Send an empty form")
	private void tc_01_null() {
		HomePage hp = new HomePage(driver);
		hp.sleep(3000);
		hp.Login();
		hp.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		System.out.println(lp.getPageName());
		lp.createAccount("1302@test.com");
		lp.sleep(3000);
		FormPage fp = new FormPage(driver);
		fp.sleep(3000);
		fp.clickRegister();
		fp.sleep(1000);
		String actual = fp.gerErr();
		String expected = "You must register at least one phone number.lastname is required.firstname is required.passwd is required.address1 is required.city is required.The Zip/Postal code you've entered is invalid. It must follow this format: 00000This country requires you to choose a State.";
		assertEquals(actual, expected);	
}
	
	@Test(description = "missing  phone")
	@Description("Send a form without phone number and without mobile number")

	private void tc_02_nophone() {
		FormPage fp = new FormPage(driver);
		fp.fillData("", "", "deutsch", "mili", "12345", "myhome", "tlv", "12345", "1");
		String actual = fp.gerErr();
		String expected = "You must register at least one phone number.";
		assertEquals(actual, expected);	
	}
	
	@Test (description = "missing  first name") 
	@Description("Send a form without first name")

	private void tc_03_nofirstname() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "", "12345", "myhome", "tlv", "12345", "1");
		String actual = fp.gerErr();
		String expected = "firstname is required.";
		assertEquals(actual, expected);	
	}
	
	@Test (description = "missing  last name") 
	@Description("Send a form without last name")
	private void tc_04_nolasttname() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "", "mili", "12345", "myhome", "tlv", "12345", "1");
		String actual = fp.gerErr();
		String expected = "lastname is required.";
		assertEquals(actual, expected);	
	}
	
	@Test (description = "missing   password") 
	@Description("Send a form without  password")
	private void tc_05_nopass() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "mili", "", "myhome", "tlv", "12345", "1");
		String actual = fp.gerErr();
		String expected = "passwd is required.";
		assertEquals(actual, expected);	
	}
	
	@Test  (description = "missing   address")
	@Description("Send a form without  adress")
	private void tc_06_noadress() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "mili", "12345", "", "tlv", "12345", "1");
		String actual = fp.gerErr();
		String expected = "address1 is required.";
		assertEquals(actual, expected);	
	}
	
	@Test (description = "missing   city")
	@Description("Send a form without city")
	private void tc_07_nocity() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "mili", "12345", "myhome", "", "12345", "1");
		String actual = fp.gerErr();
		String expected = "city is required.";
		assertEquals(actual, expected);	
	}
	
	@Test  (description = "missing zip")
	@Description("Send a form without zip code")
	private void tc_08_nozip() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "mili", "12345", "myhome", "tlv", "", "1");
		String actual = fp.gerErr();
		String expected = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
		assertEquals(actual, expected);	
	}
	
	@Test (description = "wrong  zip")
	@Description("Send a form with invalid zip code")
	private void tc_09_wrongzip() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "mili", "12345", "myhome", "tlv", "12345678", "1");
		String actual = fp.gerErr();
		String expected = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
		assertEquals(actual, expected);	
	}

	
	@Test (description = "wrong  state ")
	@Description("Send a form without state")
	private void tc_10_nostate() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "mili", "12345", "myhome", "tlv", "12345", "");
		String actual = fp.gerErr();
		String expected = "This country requires you to choose a State.";
		assertEquals(actual, expected);	
	}
	
	
	@Test (description = "success")
	@Description("Send a form with valid and complete data")
	private void tc_11_good() {
		FormPage fp = new FormPage(driver);
		fp.fillData("097432211", "", "deutsch", "mili", "12345", "myhome", "tlv", "12345", "1");
		MyAccountPage map = new MyAccountPage(driver);
		String actual = map.getPageName();
		String expected = "MY ACCOUNT";
		assertEquals(actual, expected);	
	}
	

	
}
	
	

