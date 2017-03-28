package CucumberTest.MaverCucumber;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import CucumberTest.MaverCucumber.Keywords;

public class TestScripts {
	
	WebDriver wd;
	Keywords keyword;
	String baseURL;
	String browser;
	
	@Before
	public void setUp() throws Exception {		
		baseURL = "www.google.com";
	//	browser = "ie";
		wd = new InternetExplorerDriver();
		keyword = new Keywords(wd);
		wd.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLogin() throws InterruptedException
	{
		keyword.launchApplication(baseURL);
		Thread.sleep(2000);
	//	keyword.type("id", "gs_htif0", "Hi");
		keyword.clickElement("xpath", "//a[@id='gb_70']");
		
	}
	
/*	@Test
	public void testAnonymous() throws InterruptedException
	{
		keyword.launchApplication(browser, baseURL);
		Thread.sleep(5000);
		keyword.switchWindow();
	}*/
	
	@After
	public void tearDown() throws Exception {
		//wd.close();
	}

}
