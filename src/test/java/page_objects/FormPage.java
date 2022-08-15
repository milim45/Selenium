package page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends GeneralPage {

	
	//find elements 

	@FindBy(css = "#uniform-id_gender1")
	private WebElement Mr;
	
	@FindBy(css = "#uniform-id_gender2")
	private WebElement Mrs;
	
	@FindBy(css = "#customer_firstname")
	private WebElement FirstName;
	
	@FindBy(css = "#customer_lastname")
	private WebElement LastName;
	
	@FindBy(css = "#email")
	private WebElement Mail;
	
	@FindBy(css = "#passwd")
	private WebElement Password;
	
	@FindBy(css = "#firstname")
	private WebElement AddressName;
	
	@FindBy(css = "#lastname")
	private WebElement AddressLastName;
	
	@FindBy(css = "#company")
	private WebElement Company;
	
	@FindBy(css = "#address1")
	private WebElement Adress;
	
	@FindBy(css = "#address2")
	private WebElement Adress2;
	
	@FindBy(css = "#city")
	private WebElement City;
	
	@FindBy(css = "#id_state")
	private WebElement State;
	public Select states = new Select(State);
	
	@FindBy(css = "#postcode")
	private WebElement Zip;
	
	@FindBy(css = "#other")
	private WebElement Info;
	
	@FindBy(css = "#phone")
	private WebElement Phone;
	
	@FindBy(css = "#phone_mobile")
	private WebElement Mobile;
	
	@FindBy(css = "#alias")
	private WebElement Alias;
	
	@FindBy(css = "#submitAccount")
	private WebElement RegisterBtn;
	
	@FindBy(css = ".alert.alert-danger>ol>li")
	List< WebElement> Errlist;
	
	public FormPage(ChromeDriver driver) {
		super(driver);
			}

	
	//methods
	public void clickRegister() {
		RegisterBtn.click();
	}
	
	public String gerErr() {
		String str= "";
		for (WebElement el : Errlist) {
			str = (str + el.getText());
		}
		return str;
	}
	
	public void selectState(String value) {
		states.selectByValue(value);
	}
	
	public void fillData(String phone, String mobile, String lastname,String firstname,String password,String address1,String city,String zip,String state) {
		filltext(Phone, phone);
		filltext(Mobile, mobile);
		filltext(LastName, lastname);
		filltext(FirstName, firstname);
		filltext(Password, password);
		filltext(Adress, address1);
		filltext(City, city);
		filltext(Zip, zip);
		selectState(state);
		RegisterBtn.click();
	}
	
	
	}

