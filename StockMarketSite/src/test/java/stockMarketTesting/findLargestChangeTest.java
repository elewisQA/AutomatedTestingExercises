package stockMarketTesting;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class findLargestChangeTest {
	// Test Variables
	private WebDriverWait wait;
	private ChromeDriver driver;
	private WebElement targ = null; // This is always called for operations
	private String url = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Don't show the browser
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		this.driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1366, 768));	
	}
	
	@Test
	public void getBestRiserTest() throws InterruptedException {
		//--[ Test Set-up ]--
		driver.get(url);
		wait = new WebDriverWait(driver, 10);
		
		//--[ Test Code ]--
		// Accept Cookie
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("acceptCookie")));
		driver.findElement(By.id("acceptCookie")).click();
		
		// Click 'Riser' Button
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@title='View risers']")));
		driver.findElement(By.xpath("//a[@title='View risers']")).click();
		
		// Get table
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.className("stockTable")));
		List<WebElement> rows = driver.findElements(By.className("table-odd"));
		
		// Print:
		System.out.println("Top-Riser:");
		System.out.println(rows.get(0));
	}
	
	@After
	public void tearDown() {
		//driver.close();
		driver.quit();
	}
}
