package com.pages.agent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersAgent {
	
	WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://phptravels.net/offers'])[1]")
	private WebElement offers;
	
	@FindBy(xpath = "(//h2)[1]")
	private WebElement pageheader;
	
	public OffersAgent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOffers() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(offers));
		offers.click();
	}
	public String PageHeader() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(pageheader));
		String pageHeader= pageheader.getText();
		return pageHeader;

	}

}
