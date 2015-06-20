package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMWrongIntervalCheckDefinition {
	
	protected WebDriver driver;
	private String url;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I add a new story with wrong interval$")
	public void I_add_a_new_story_with_wrong_interval() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I enter \"([^\"]*)\" in  the from date date box after I push the add button$")
	public void I_enter_in_the_from_date_date_box_after_I_push_the_add_button(String fromDate) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
		
		WebElement titleTextBox = driver.findElement(By.id("sprint-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys("tile test");
		
		WebElement descriptionTextBox = driver.findElement(By.id("sprint-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys("description test");
		
		WebElement startDateTextBox = driver.findElement(By.id("fromDt"));
		startDateTextBox.clear();
		startDateTextBox.sendKeys(fromDate);
		
		WebElement endDateTextBox = driver.findElement(By.id("toDt"));
		endDateTextBox.clear();
		endDateTextBox.sendKeys("2015-06-10 07:35");
		
		url = driver.getCurrentUrl();
		// Click on searchButton
		WebElement addStoryButton = driver.findElement(By.id("add-sprint-button"));
		addStoryButton.click();
	}

	@Then("^I should get sent to edit boxes$")
	public void I_should_get_sent_to_edit_boxes() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		Assert.assertEquals(url, driver.getCurrentUrl());

		driver.close();
	}

	
	@After
	public void closeBrowser() {
		driver.quit();
	}


}