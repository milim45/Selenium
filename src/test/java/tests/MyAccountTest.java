package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import page_objects.FormPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyAccountPage;
import utils.Utils;

public class MyAccountTest extends BaseTest {

	//testing the "my account" page  and it's buttons that refer to other pages
	
	@Test (description = "create account")
	@Description("create a new account and enter the my account page")
	private void TC_01_null() {
		HomePage hp = new HomePage(driver);
		hp.sleep(3000);
		hp.Login();
		hp.sleep(500);
		LoginPage lp = new LoginPage(driver);
		System.out.println(lp.getPageName());
		Utils u = new Utils();
		lp.createAccount(u.readProperty("nextuser"));
		lp.sleep(3000);
		FormPage fp = new FormPage(driver);
		fp.sleep(3000);
		fp.fillData("097432211", "0506879788", "deutsch", "mili", "12345", "myhome", "tlv", "12345", "1");
		MyAccountPage map = new MyAccountPage(driver);
		String actual = map.getPageName();
		String expected = "MY ACCOUNT";
		assertEquals(actual, expected);	
	}
	
	@Test (description = "orders")
	@Description("click  the orders link")
	private void TC_02_orders() {
		MyAccountPage map = new MyAccountPage(driver);
		map.clickOrders();
		String actual =  map.getPageName();
		String expected = "ORDER HISTORY";
		assertEquals(actual, expected);	
	}
	
	@Test ( description = "adresses")
	@Description("click  the adresses link")
	private void TC_03_adresses () {
		MyAccountPage map = new MyAccountPage(driver);
		map.clickBack();
		map.clickAdress();
		String actual =  map.getPageName();
		String expected = "MY ADDRESSES";
		assertEquals(actual, expected);	
	}
	
	
	@Test (description = "slips")
	@Description("click  the credit slips link")
	private void TC_04_slips () {
		MyAccountPage map = new MyAccountPage(driver);
		map.clickBack();
		map.clickSlips();
		String actual =  map.getPageName();
		String expected = "CREDIT SLIPS";
		assertEquals(actual, expected);	
	}
	
	@Test (description = " no slips")
	@Description("get a message that there aren't any slips")
	private void TC_05_slipsText () {
		MyAccountPage map = new MyAccountPage(driver);
		map.clickBack();
		map.clickSlips();
		String actual =  map.getNoDataText();
		String expected = "You have not received any credit slips.";
		assertEquals(actual, expected);	
	}
}

	
	
