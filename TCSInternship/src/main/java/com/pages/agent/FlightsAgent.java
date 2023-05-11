package com.pages.agent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsAgent {
	
	WebDriver driver;

	@FindBy(xpath = "//a[@href='https://phptravels.net/flights']")
	private WebElement flights;
	
	@FindBy(xpath = "(//h2)[1]")
	private WebElement pageheader;
	
	public FlightsAgent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickFlights() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(flights));
		flights.click();
	}
	public String PageHeader() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(pageheader));
		String pageHeader= pageheader.getText();
		return pageHeader;

	}

}
