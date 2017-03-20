package CucumberTest.MaverCucumber;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class GoogleTest {
    
	
	@Test
	public void testGoogle(){
	//WebDriver driver = new FirefoxDriver();
	WebDriver driver = new InternetExplorerDriver();
	driver.get("http://google.com");
	driver.quit();
	}
	
}
