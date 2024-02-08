package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputPasswordPage {
	WebDriver driver;
	public InputPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By password_field = By.xpath("//input[@name='Passwd']");
	
	public void fillPassword(String password) {
		this.driver.findElement(password_field).sendKeys(password);
	}
	
	public void clickNext() {
		driver.findElement(By.id("passwordNext")).click();
	}

}
