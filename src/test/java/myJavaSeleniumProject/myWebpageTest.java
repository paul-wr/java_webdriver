package myJavaSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class myWebpageTest {

	public static void main(String[] args) throws InterruptedException {
		// set system property for gecko driver
		System.setProperty("webdriver.gecko.driver",  "/Users/mainaccount/developer/Selenium/geckodriver");
		
		// set capabilities
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		

		// declare WebDriver
		WebDriver driver = new FirefoxDriver();
				
		// get the webpage under test
		driver.get("file:///Users/mainaccount/developer/webdriver_java/test.html");
		
		
		// get an element by id
		WebElement element = driver.findElement(By.name("uname"));
		element.sendKeys("admin");
		
		// create click event
		element = driver.findElement(By.name("submit"));
		element.click();
		
		// print completion of test
		System.out.println("Test completed!");
		
		// Thread.sleep(5000);
		// driver.quit();
		
		

	}

}
