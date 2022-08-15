package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Utils;

public class BaseTest {

			  ChromeDriver driver;
			
			@BeforeClass
			public void setup() {
				System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				((WebDriver) driver).manage().window().maximize();
				((WebDriver) driver).get(Utils.readProperty("url"));
			
			}
			
			@AfterClass
			public void tearDown() {
			((WebDriver) driver).quit();	
			}



	}

