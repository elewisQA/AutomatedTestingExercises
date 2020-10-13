import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DemoSiteTest {

	private ChromeDriver driver;
	private String url = "http://thedemosite.co.uk/";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Don't show the browser
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	@Test
	public void test() throws InterruptedException {
		
		
		// Username & Password
		String uName = "guest";
		String pwd = "guest";
		
		driver.get(url);
		// Find Add User Link & Click it
		driver.findElement(By.xpath("//a[@href='addauser.php']")).click();
		
		// Find fields & put data into them
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);

		// Hit send on the "save" button
		driver.findElement(By.xpath("//input[@value='save']")).submit();
		
		
		// Go to Login-page
		driver.findElement(By.xpath("//a[@href='login.php']")).click();
		
		// Enter login details
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Test Login']")).submit();
		
		// Check if login sucessful
		//driver.findElement(By.tagName("b")
		String success = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/big[1]/blockquote[1]/blockquote[1]/font[1]/center[1]/b[1]")).getText();
		if(!success.equals("**Successful Login**")) {
			fail("Unsuccessful Login");
		}
		
		
	}
	
	@After
	public void tearDown() {
		//driver.close();
		driver.quit();
	}
}
