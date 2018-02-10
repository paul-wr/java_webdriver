package myJavaSeleniumProject;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TakeScreenShot {

	@Test
	public void takeScreenshot() {
		System.setProperty("webdriver.gecko.driver", "/Users/mainaccount/developer/selenium/geckodriver");
		
		FirefoxOptions capabilities = new FirefoxOptions();
		capabilities.setCapability("marionette", true);
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///Users/mainaccount/developer/webdriver_java/index.html");
		
		TakesScreenshot camera = (TakesScreenshot) driver;
		byte[] imageBytes = camera.getScreenshotAs(OutputType.BYTES);
		
		try{
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("screenshot_test.png"));
		out.write(imageBytes);
		out.close();
		}catch(IOException ex){
			System.err.println("File not found!"+ex.getMessage());
		}
		
		driver.quit();
		
	}

}
