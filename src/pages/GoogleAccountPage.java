package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleAccountPage {
	WebDriver driver;
	public GoogleAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By goToAccountButton = By.xpath("//li[@class='h-c-header__cta-li-link\r\n"
			+ "                      h-c-header__cta-li-link--primary button-standard-mobile']");
//	By xpath = By.xpath("//a[@href='https://accounts.google.com/ServiceLogin?service=accountsettings&amp;continue=https://myaccount.google.com%3Futm_source%3Daccount-marketing-page%26utm_medium%3Dgo-to-account-button' and @aria-label='Go to your Google Account' and contains(@class, 'h-c-header__cta-li-link') and contains(@class, 'h-c-header__cta-li-link--primary') and contains(@class, 'button-standard-mobile')]");
//	By xpath = By.xpath("//a[@aria-label='Go to your Google Account' and contains(@class, 'h-c-header__cta-li-link') and contains(@class, 'h-c-header__cta-li-link--primary') and contains(@class, 'button-standard-mobile')]");
	By xpath = By.xpath("//a[contains(@href, 'accounts.google.com/ServiceLogin') and contains(@aria-label, 'Go to your Google Account') and contains(@class, 'button-standard') and contains(@class, 'h-c-header__cta-li-link--primary')]");
	
	public void clickGoToAccount() {
//		System.out.println(this.driver.findElement(xpath).getText());
//		System.out.println(this.driver.findElement(xpath).getAttribute("class"));
		this.driver.findElement(goToAccountButton).click();
	}
	
	

}
