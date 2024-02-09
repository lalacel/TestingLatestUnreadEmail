package test;
import org.testng.annotations.Test;

import pages.AllMailPage;
import pages.InputMailPage;
import pages.InputPasswordPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class testNG {
	WebDriver driver;


  @Test
  public void mainTest() {
	ChromeOptions options = new ChromeOptions();
	Proxy proxy = new Proxy();
    proxy.setHttpProxy("<103.167.68.75:6363>");
    options.setCapability("proxy", proxy);
	options.addArguments("--incognito");
    options.addArguments("--disable-blink-features=AutomationControlled");;
	options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
	options.setExperimentalOption("useAutomationExtension", false);
	
	
	this.driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// Cast WebDriver to JavascriptExecutor
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    // Execute the JavaScript code
    jsExecutor.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
    
	driver.get("https://mail.google.com/mail/");

	InputMailPage mailPage = new InputMailPage(driver);
	
	InputPasswordPage passwordPage = new InputPasswordPage(driver);
	
	AllMailPage allMailPage = new AllMailPage(driver);
	
	
	String email = "gslcwebprog@gmail.com";
	String password = "Int3gr1ty!";
	String title = "Security alert";
	
	mailPage.fillEmail(email);
	mailPage.clickNext();
	
	passwordPage.fillPassword(password);
	passwordPage.clickNext();
	
	allMailPage.fillSearchField("is:unread");
	allMailPage.clickNext();
	String stringResult = allMailPage.getLastUnreadTitle();

	Assert.assertEquals(stringResult, title); 
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Starting Test On Chrome Browser");
  }

  @AfterMethod
  public void afterMethod() {
	  this.driver.close();
	  System.out.println("Finished Test On Chrome Browser");
  }

}
