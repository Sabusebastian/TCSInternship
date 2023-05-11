package com.pages.admin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageAdmin {
	
	WebDriver driver;

	@FindBy(xpath = "//div[text()='Dashboard']")
	private WebElement dashboard;
	
	@FindBy(xpath = "//i[text()='person']//parent::button")
	private WebElement profile;
	
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//a[@aria-controls='toursmodule']")
	private WebElement Tours;
	
	@FindBy(xpath = "//a[@data-bs-target='#Tours']")
	private WebElement Tours1;
	
	@FindBy(xpath = "//a[text()='Manage Tours']")
	private WebElement manageTours;

	public HomePageAdmin(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickDashboard() throws InterruptedException {
		Thread.sleep(3000);
		dashboard.click();
	}
	public boolean Isdashboarddisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		boolean isdashboarddisplayed= dashboard.isDisplayed();
		return isdashboarddisplayed;

	}
	
	public void Logout() throws InterruptedException {
		Thread.sleep(2000);
		profile.click();
		Thread.sleep(1000);
		logout.click();
	}
	
	public String GetCurrentUrl() throws InterruptedException {
		Thread.sleep(2000);
		String url= driver.getCurrentUrl();
		return url;
	}
	public void ClickManageTours() throws InterruptedException {
		Thread.sleep(2000);
		Tours.click();
		Thread.sleep(1000);
		Tours1.click();
		Thread.sleep(1000);
		manageTours.click();
		
	}
	

}
