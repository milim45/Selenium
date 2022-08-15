package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import page_objects.ContactPage;
import page_objects.HomePage;


//testing the "contact us" feature, required fields and validation


public class ContactTest extends BaseTest{
	@Test (description = "enter contact page")
	@Description("click the contact us link")
	private void tc_01_clickContact() {
		HomePage hp = new HomePage(driver);
		hp.sleep(3000);
		hp.contact();
		hp.sleep(500);
		ContactPage cp = new ContactPage(driver);
		String actual = cp.getUniqPageName();
		String expected = "CUSTOMER SERVICE - CONTACT US";
		assertEquals(actual, expected);	
}
	
	
	@Test (description = "empty message")
	@Description("send a request with blank message")
	private void tc_02_nomessage() {
		ContactPage cp = new ContactPage(driver);
		cp.fillData("1", "1@1.com", "");
		cp.send();
		String actual = cp.gerErr();
		String expected = "The message cannot be blank.";
		assertEquals(actual, expected);	
}
	
	
	@Test (description = "empty mail")
	@Description("send a request without mail")
	private void tc_03_nomail() {
		ContactPage cp = new ContactPage(driver);
		cp.fillData("1", "", "gfdgdgdgdsga");
		cp.send();
		String actual = cp.gerErr();
		String expected = "Invalid email address.";
		assertEquals(actual, expected);	
}
	
	
	@Test (description = "sucsses")
	@Description("send a request with correct and complete data")
	private void tc_04_good() {
		ContactPage cp = new ContactPage(driver);
		cp.fillData("1", "1@1.com","blabla");
		String actual = cp.getSuccessText();
		String expected = "Your message has been successfully sent to our team.";
		assertEquals(actual, expected);	
}
		


	
	

}
