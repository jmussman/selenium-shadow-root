package digitalworkorders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyComponentTests {
	
	private final String URL = "file:///C:/Users/jmussman/selenium-junit-starter/src/main/resources/index.html";

	private ChromeDriver driver;
	private WebDriverWait wait;
	
	@BeforeEach
	public void setup() {
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		
		driver.get(URL);
	}

	@Test
	public void myComponentLoads() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hw")));
		
		WebElement hw = driver.findElement(By.id("hw"));
		
		WebElement shadowRoot = (WebElement)driver.executeScript("return arguments[0].shadowRoot", hw);
		
		WebElement hello = shadowRoot.findElement(By.id("hello"));
		
		System.out.println(hello.getText());
		
		assertEquals("Hello, World!", hello.getText());
	}
}
