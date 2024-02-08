package test;
import org.testng.annotations.Test;

import pages.AllMailPage;
import pages.GoogleAccountPage;
import pages.InputMailPage;
import pages.InputPasswordPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Collections;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class testNG {
	WebDriver driver;

  @Test
  public void f() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
    options.addArguments("--disable-blink-features=AutomationControlled");;
	options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
	options.setExperimentalOption("useAutomationExtension", false);
	
	this.driver = new ChromeDriver(options);
	
	// Cast WebDriver to JavascriptExecutor
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    // Execute the JavaScript code
    jsExecutor.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
    
    
	driver.get("https://mail.google.com/mail/");

	InputMailPage mailPage = new InputMailPage(driver);
	
	InputPasswordPage passwordPage = new InputPasswordPage(driver);
	
	AllMailPage allMailPage = new AllMailPage(driver);
	
	GoogleAccountPage googleAccountPage = new GoogleAccountPage(driver);
	
	String email = "gslcwebprog@gmail.com";
	String password = "Int3gr1ty!";
	String title = "Security alert";
	
	mailPage.fillEmail(email);
	mailPage.clickNext();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	passwordPage.fillPassword(password);
	passwordPage.clickNext();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	allMailPage.fillSearchField("is:unread");
	allMailPage.clickNext();
	String stringResult = allMailPage.getLastUnreadTitle();
	Boolean testResult = stringResult.equals(title);
	if(testResult) {
		System.out.println("Testing Success! (testing result is equals to expected result)");
	}
	else {
		System.out.println("Testing Failed! (testing result is not equals to expected result)");
	}
	
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
