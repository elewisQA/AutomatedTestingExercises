package com.qa.PassionateTea;

//---[ Imports ]---
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//===[ Class Definition ]===
public class StepDefinitions {
	//-[ Class Usables ]-
	private final String URL = "http://www.practiceselenium.com/welcome.html";
	private ChromeDriver driver;
	private WebDriverWait waitShort;
	private WebDriverWait waitLong;
	
	//-[ Cucumber Testing ]-
	@Before
	public void init() {
		// Set-up Chrome-driver to use in tests
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		this.driver = new ChromeDriver(options);
		this.driver.manage().window().setSize(new Dimension(1366, 768));
		
		// Set-up wait-states
		waitShort = new WebDriverWait(driver, 10);
		waitLong = new WebDriverWait(driver, 100);
	}
	
	@Given("^the correct web address")
	public void correct_web_address() {
		// Open the website
		driver.get(this.URL);
		
		// Wait for something to load to proceed
		waitShort.until(ExpectedConditions.visibilityOfElementLocated(
				By.className("txt")));
	}
	
	@When("^I navigate to the 'Menu' page")
	public void navigate_menu_page() {
		// Find and click menu button
		driver.findElement(By.xpath("//a[@data-url='menu.html']"))
		.click();
	}
	
	@When("^I click on the checkout button")
	public void click_checkout() {
		// Find and click Checkout button
		driver.findElement(By.xpath("//a[@data-url='check-out.html']"))
		.click();
	}
	
	@Then("^I can browse a list of available products")
	public void browse_products() {
		// Wait until text loads on the page
		waitLong.until(ExpectedConditions.visibilityOfElementLocated(
				By.className("txt")));
	}
	
	@Then("^I am taken to the checkout page")
	public void checkout_page() {
		// Wait until 'place order' button loads onto page
		waitLong.until(ExpectedConditions.visibilityOfElementLocated(
				By.className("form-horizontal")));
	}
	
	@After
	public void tearDown() {
		// Shut-down driver to stop build-up of background processes
		driver.close(); driver.quit();
	}
}
