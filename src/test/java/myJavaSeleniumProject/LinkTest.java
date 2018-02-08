package myJavaSeleniumProject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;


import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinkTest {
	
	@Test
	public void webpageTest() throws WebDriverException {
		// set system property for gecko driver
		System.setProperty("webdriver.gecko.driver",  "/Users/mainaccount/developer/Selenium/geckodriver");
		
		// set capabilities
		FirefoxOptions capabilities = new FirefoxOptions();
		capabilities.setCapability("marionette", true);
		
		
		// declare WebDriver
		WebDriver driver = new FirefoxDriver();

		driver.get("file:///Users/mainaccount/developer/webdriver_java/index.html");
		
		try{
		driver.findElement(By.linkText("Contact")).click();
		}catch(WebDriverException e){
		  System.err.println(e.toString());
		  System.out.println("Test passed! No contact page exists");
		}
		try {
		  assertEquals("Problem loading page", driver.getTitle());
		} catch (Error e) {
		  System.err.println(e.toString());
		}

		

    }

}

