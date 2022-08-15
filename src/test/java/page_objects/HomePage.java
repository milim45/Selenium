package page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends GeneralPage{

	
	//find elements 

		@FindBy(css = ".sf-with-ul")
		List <WebElement> Category;
		
		
		@FindBy(css = ".subcategory-name" )
		List <WebElement>  SubCategory;
		
		
		@FindBy(css = "[itemprop='name']" )
		List <WebElement> products;
		
		
	public HomePage(ChromeDriver driver) {
		super(driver);
}
	
	
	//methods
	public  void clickCategory(String text) {
	for (WebElement el : Category) {
		String str = el.getText();
		if(str.equalsIgnoreCase(text)) {
			el.click();
			}
		}
	}
	
	public  void clickSubCategory(String text) {
		for (WebElement el : SubCategory) {
			String str = el.getText();
			if(str.equalsIgnoreCase(text)) {
				el.click();
			}
		}
	}
	
	
	public int countProducts() {
		int count = products.size();
		return count;
	}
	
	
	
	public String getFirstName() {
		String str = products.get(0).getText();
		return str;
	}
}
	
	
	


