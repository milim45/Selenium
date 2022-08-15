package page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends GeneralPage {

	//find elements 

		@FindBy(css = ".page-heading.bottom-indent")
		private WebElement UniqPageName;

		@FindBy(css ="[name='id_contact']")
		private WebElement Subject;
		public Select subjects = new Select(Subject);
		
		@FindBy(css = "#email")
		private WebElement Mail;

		@FindBy(css ="#id_order")
		private WebElement Order;
		
		@FindBy(css ="#message")
		private WebElement Message;
		
		@FindBy(css ="#submitMessage")
		private WebElement Send;
		
		@FindBy(css = ".alert.alert-danger>ol>li")
		List< WebElement> Errlist;
		
		@FindBy(css = "#desc_contact2")
		public WebElement CustomerService;
		
		@FindBy(css = "#desc_contact1")
		private WebElement Webmaster;
		
		@FindBy(css = ".alert.alert-success")
		private WebElement Success;
		
	
	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
	
	//methods
	public void fillData(String subject,String mail,String message) {
		selectSubject("1");
		filltext(Mail, mail);
		filltext(Message, message);
		click(Send);
	}
	
	public String getUniqPageName() {
		String str = UniqPageName.getText();
		return str;
	}
	
	public void send(){
		Send.click();
	}
	
	public String gerErr() {
		String str= "";
		for (WebElement el : Errlist) {
			str = (str + el.getText());
		}
		return str;
	}
	
	public void selectSubject(String value) {
		subjects.selectByValue(value);
	}
	
	public String getCustomerServiceText() {
		String str = CustomerService.getText();
		return str;
	}
	
	public String getWebmasterText() {
		String str = Webmaster.getText();
		return str;
	}
	
	
	public String getSuccessText() {
		String str = Success.getText();
		return str;
	}
}
