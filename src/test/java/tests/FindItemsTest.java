package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import page_objects.HomePage;


//testing search for items  by category and sub category 
public class FindItemsTest extends BaseTest {

	@Test (description = "dresses")
	@Description("choose the main category dresses")
	private void TC_01_click_category() {
	HomePage hp = new HomePage(driver);
	hp.sleep(7000);
	hp.clickCategory("DRESSES");
	hp.sleep(10000);
	int actual =  hp.countProducts();
	int expected = 5;
	assertEquals(actual, expected);	
}
	
	@Test (description = " summer dresses")
	@Description("choose the sub  category summer dresses")
	private void TC_02_click_subcategory() {
	HomePage hp = new HomePage(driver);
	hp.sleep(3000);
	hp.clickSubCategory("Summer Dresses");
	hp.sleep(7000);
	int actual =  hp.countProducts();
	int expected = 3;
	assertEquals(actual, expected);
}
	
	
	
	
	
	
	
}
