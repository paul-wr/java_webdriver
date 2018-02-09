package myJavaSeleniumProject;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GetAllClassTags {

@Test
public void getAllClassTags(){
	// set system property for gecko driver
	System.setProperty("webdriver.gecko.driver",  "/Users/mainaccount/developer/Selenium/geckodriver");
			
	// set capabilities
	FirefoxOptions capabilities = new FirefoxOptions();
	capabilities.setCapability("marionette", true);
			
			
	// declare WebDriver
	WebDriver driver = new FirefoxDriver();

	driver.get("file:///Users/mainaccount/developer/webdriver_java/index.html");
	
	List<WebElement> elements = driver.findElements(By.className("main_text_style"));
	
	int count = 0;
	for(WebElement e : elements){
		count = count + 1;
		System.out.println("Main text style Tag content "+count+": "+e.getText());
	}
}

}
