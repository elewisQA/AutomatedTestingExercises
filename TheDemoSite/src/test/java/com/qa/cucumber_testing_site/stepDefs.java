package com.qa.cucumber_testing_site;

import org.openqa.selenium.By;
//===[ Imports ]===
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//===[ Step Definitions ]===
public class stepDefs {
	//--[ Variables ]--
	private ChromeDriver driver;
	private final String URL = "http://thedemosite.co.uk";
	private WebDriverWait wait;
	private String username = null;
	private String password = null;

	//--[ Setup ]--
	@Before
	public void init() {
		// Set-up Chrome-driver
		System.setProperty("webdriver.chrome.driver",
				"D:/qa-workspace/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		//this.driver.manage().window().setSize(new Dimension(1366, 768));
	
		// Set-up wait-state
		this.wait = new WebDriverWait(driver, 100);
	}
	
	//--[ Given Condition(s) ]--
	@Given("I am on the login page")
	public void login_page() {
		driver.get(this.URL + "/login.php");

		// Wait for something to load to proceed
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@name='username']")));
	}
	
	@Given("I am on the add a user page")
	public void add_a_user() {
		driver.get(this.URL + "/addauser.php");
		
		// Wait for something to load to proceed
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form[@action='savedata.php']")));
	}
	
	//--[ When Condition(s) ]--
	@When("I enter a username: {string}")
	public void i_enter_a_username(String username) {
		this.username = username;
		driver.findElement(By.xpath("//input[@name='username']"))
		.sendKeys(this.username);
	}
	
	@And("I enter a password: {string}")
	public void and_a_password(String password) throws InterruptedException {
		this.password = password;
		driver.findElement(By.xpath("//input[@name='password']"))
		.sendKeys(this.password);
		
		Thread.sleep(3000);
		// Then click button
		driver.findElement(By.xpath("//input[@type='button']"))
		.click();
	}
	
	//-[ Then Condition(s) ]--
	@Then("I should see {string}")
	public void see_status(String status) {
		driver.findElement(
				By.xpath("//b[text()='**" + status + " Login**']"));
	}
	
	@Then("I add a new user")
	public void add_new_user() {
		driver.findElement(
				By.xpath(
						"(//blockquote[contains(.,'The username: " + 
								this.username +
								"The password: " + 
								this.password + "')])[3]"
						));
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
