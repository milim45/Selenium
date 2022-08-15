package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralPage extends BasePage {
	
	
	//find elements 
			@FindBy(css = ".header_user_info")
			private WebElement login;
			
			@FindBy(css = "#contact-link")
			private WebElement contact;
			
			@FindBy(css = ".page-heading")
			private WebElement PageName;
			
			@FindBy(css = ".header_user_info" )
			private WebElement CustomerName;
			
			
	public GeneralPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

		
	//methods
		
		public void contact() {
			contact.click();
		}
		
		public void Login() {
			login.click();
		}
		
		public String getPageName() {
			String str = PageName.getText();
			return str;
		}
		
		public String getCustomerName() {
			String str = CustomerName.getText();
			return str;
		}
		
		public void getMyAccount() {
			CustomerName.click();
		}
		}
		
		


