package page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends GeneralPage {

	
	//find elements
	
	@FindBy(css = ".icon-list-ol")
	private WebElement Orders;
	
	@FindBy(css = ".icon-ban-circle")
	private WebElement Slips;
	
	@FindBy(css = "[href=\"http://automationpractice.com/index.php?controller=addresses\"]")
	private WebElement Adresses;
	
	@FindBy(css = ".icon-user")
	private WebElement info;
	
	@FindBy(css = ".icon-heart")
	private WebElement Wish;
	
	@FindBy(css = "[href=\"http://automationpractice.com/index.php?controller=my-account\"]")
	private WebElement Back;
	
	@FindBy(css = ".alert.alert-warning")
	private WebElement NoData;
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	//methods
	
	public void clickOrders() {
		Orders.click();
	}
	
	public void clickSlips() {
		Slips.click();
	}
	
	public void clickAdress() {
		Adresses.click();
	}
	
	public void clickinfo() {
		info.click();
	}
	
	public void clickWish() {
		Wish.click();
	}
	
	public void clickBack() {
		Back.click();
	}
	
	public String getNoDataText() {
		String str = NoData.getText();
		return str;
	}
}
	
