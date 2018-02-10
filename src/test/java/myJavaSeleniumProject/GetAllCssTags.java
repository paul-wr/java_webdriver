package myJavaSeleniumProject;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GetAllCssTags {

	@Test
	public void getAllCssTags() {
		// set system property for gecko driver
		System.setProperty("webdriver.gecko.driver",  "/Users/mainaccount/developer/Selenium/geckodriver");
		
		// declare an ArrayList to store tag text
		// declare an ArrayList to store tag text
		List<String> cssSelectorText = new ArrayList<String>();
		
		// populate the ArrayList
		cssSelectorText.add("Welcome to the website");
		cssSelectorText.add("You can sign up for an account above");
		cssSelectorText.add("The website is still under going some construction!");
		cssSelectorText.add("Get in touch via Contact Form");
			
				
				
		// set capabilities
		FirefoxOptions capabilities = new FirefoxOptions();
		capabilities.setCapability("marionette", true);
				
				
		// declare WebDriver
		WebDriver driver = new FirefoxDriver();
	
		// get web page under test
		driver.get("file:///Users/mainaccount/developer/webdriver_java/index.html");
		
		// create a list of elements by class name
		List<WebElement> elements = driver.findElements(By.cssSelector("div.main_text > p"));
		
		// declare and initialize int variable to store loop count
		int count = 0;
		for(WebElement e : elements){
			// assert matching text in class tag as is stored in ArrayList
			assertThat("Wrong assumption!", e.getText(), equalTo(cssSelectorText.get(count).toString()));
			// increment count 
			count = count + 1;
			// print result to screen
			System.out.println("CSS Selector div.main_text > p content "+count+": "+e.getText());
		}
				
		
	}

}
