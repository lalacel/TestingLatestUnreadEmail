package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputMailPage {
	WebDriver driver;
	public InputMailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email_field = By.xpath("//input[@id='identifierId']");
	
	public void fillEmail(String email) {
		this.driver.findElement(email_field).sendKeys(email);
	}
	
	public void clickNext() {
		driver.findElement(By.id("identifierNext")).click();
	}
}
