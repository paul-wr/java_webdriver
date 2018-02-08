package myJavaSeleniumProject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class myWebpageTest {
	
	@Test
	public void webpageTest() throws InterruptedException {
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
		
		// get password element and set value
		element = driver.findElement(By.name("password"));
		element.sendKeys("password");
								
		// create click event
		element = driver.findElement(By.name("submit"));
		element.click();
		System.out.println("Text: "+element.getText());
		
		// get the text of the H2 tag
		element = driver.findElement(By.tagName("h2"));
		System.out.println("H2 Text: "+element.getText());
		
		// element test
        copyrightCheck(element, driver);

        // print completion of test
        System.out.println("Test completed!");

        // Thread.sleep(5000);
        // driver.quit();

    }

    public void copyrightCheck(WebElement element, WebDriver driver){

        try{
            WebElement footer = driver.findElement(By.id("footer"));
            if(!footer.getText().contains("©")){
                System.err.println("Copyright symbol not found on page!");
            }
        }catch(NoSuchElementException e){
            System.err.println("Footer not found on page!");
        }
    }

}
