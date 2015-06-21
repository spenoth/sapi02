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

public class SCRUMWrongIntervalSuccessionCheckDefinition {

	protected WebDriver driver;
	private String url;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I add a new sprint with wrong dates successions$")
	public void I_add_a_new_sprint_with_wrong_dates() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I enter \"([^\"]*)\" in the to date datebox first$")
	public void I_enter_in_the_to_date_datebox_first(String toDate)
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("sprint-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys("tile test");

		WebElement descriptionTextBox = driver.findElement(By
				.id("sprint-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys("description test");

		WebElement toDateTextBox = driver.findElement(By.id("startTime"));
		toDateTextBox.clear();
		toDateTextBox.sendKeys(toDate);
	}

	@When("^enter \"([^\"]*)\" I push the add button$")
	public void enter_I_push_the_add_button(String endDate) throws Throwable {
		// Express the Regexp above with the code you wish you had
		WebElement endDateTextBox = driver.findElement(By.id("endTime"));
		endDateTextBox.clear();
		endDateTextBox.sendKeys(endDate);

		// Click on searchButton
		WebElement searchButton = driver.findElement(By.id("add-story-button"));
		searchButton.click();
	}

	@Then("^I should get sent to edit boxes because of wrong date succession$")
	public void I_should_get_sent_to_edit_boxes_because_of_wrong_date_succession()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		Assert.assertEquals(url, driver.getCurrentUrl());
		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}