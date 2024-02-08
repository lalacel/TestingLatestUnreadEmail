package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllMailPage {
	WebDriver driver;
	
	public AllMailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search_field = By.xpath("//input[@name='q']");
	
	public void fillSearchField(String title) {
		this.driver.findElement(search_field).sendKeys(title);
	}
	
	public void clickNext() {
		this.driver.findElement(search_field).sendKeys(Keys.RETURN);
	}
	
	public String getLastUnreadTitle() {
		WebElement unreadMail = this.driver.findElement(By.xpath("//tr[@class= 'zA zE']"));
		String titleElement = unreadMail.findElement(By.xpath(".//span[@class='bqe']")).getAttribute("innerHTML");
		return titleElement;
	}

	
}
