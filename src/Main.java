
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.google.com/mail/");
		WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
		email_phone.sendKeys("dummymayo06@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement password = driver.findElement(By.xpath("//input[@name='Passwd']"));
		password.sendKeys("dummymayo123");
		driver.findElement(By.id("passwordNext")).click();
		try { 
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("is:unread");
		search.sendKeys(Keys.RETURN);
		WebElement unreadMail = driver.findElement(By.xpath("//tr[contains(@class, 'zA zE')]"));
		String titleElement = unreadMail.findElement(By.xpath(".//span[@class='bqe']")).getAttribute("innerHTML");

        System.out.println(titleElement);

	}

}
