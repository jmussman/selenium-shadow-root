package digitalworkorders;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DigitalWO {
	
	private final String URL = "https://test.salesforce.com";
	private final String USERNAME = "joelmussman@gmail.com";
	private final String PASSWORD = "Salesforce1!";

	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeEach
	public void setup() {
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		
		driver.get(URL);
	}
	
	@Test
	public void launchesDigitalWorkOrders() {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("theloginform")));
	}
	
	@Test
	public void logsIntoDigitalWorkOrders() {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("theloginform")));
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("Login"));
		
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginButton.click();
		
		// WebElement span = driver.findElement(By.cssSelector("span[title='FMC Digital Work Order']"));
		// WebElement element = driver.findElement(By.cssSelector("div.desktop"));
		// WebElement element = driver.findElement(By.cssSelector("span.slds-truncate"));
		// WebElement element = driver.findElement(By.cssSelector("span[class='slds-truncate']"));
		// WebElement element = driver.findElement(By.xpath("//span[@title='FMC Digital Work Order']"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'FMC Digital Work Order')]")));
	}
}
