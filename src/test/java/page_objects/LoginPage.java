package page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends GeneralPage {

	//find elements 

		@FindBy(css = "#email_create")
		private WebElement NewMail;
		
		@FindBy(css = "#email")
		private WebElement ExistMail;
		
		@FindBy(css = "#passwd")
		private WebElement Password;
		
		@FindBy(css = "[title='Recover your forgotten password']")
		private WebElement RecoverBtn;
		
		@FindBy(css = "#SubmitCreate")
		private WebElement CreateBtn;
		
		@FindBy(css = "#SubmitLogin")
		private WebElement LoginBtn;
		
		@FindBy(css = "#create_account_error")
		private WebElement CreateErr;
		
		@FindBy(css = ".alert.alert-danger")
		List <WebElement>  LoginErr;
		
		
	public LoginPage(ChromeDriver driver) {
		super(driver);
	}
	
	
	
//methods
	public String getCreateErr() {
		String str= CreateErr.getText();
		return str;
	}
	
	public String getLoginErr() {
		String str = "";
		for (WebElement  el : LoginErr) {
			str = str + el.getText();
		}
		return str;
	}

	
	public void createAccount(String email) {
		filltext(NewMail, email);
		CreateBtn.click();
	}
	
	public void clickCreate() {
		CreateBtn.click();
	}
	
	public void clickLogin() {
		LoginBtn.click();
	}
	
	public void clickForgot() {
		RecoverBtn.click();
	}
	
	
	public void clearData() {
		ExistMail.clear();
		Password.clear();
	}
	
	public void LoginData(String email, String password) {
		filltext(ExistMail, email);
		filltext(Password, password);
		LoginBtn.click();
	}
}
