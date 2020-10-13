import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://googlea.co.uk");
		
		Thread.sleep(15000);
		assertEquals("Bing", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		//driver.close();
		driver.quit();
	}
}
