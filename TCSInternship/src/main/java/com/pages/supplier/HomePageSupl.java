package com.pages.supplier;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSupl {

	WebDriver driver;

	@FindBy(xpath = "//div[text()='Dashboard']")
	private WebElement dashboard;
	
	@FindBy(xpath = "//div[text()='Sales overview & summary']")
	private WebElement salesoverviewandSummary;
	
	@FindBy(xpath = "//h2[text()='Revenue Breakdown 2023']")
	private WebElement revenueBreakdown;
	
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

	public HomePageSupl(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickDashboard() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		dashboard.click();
		Thread.sleep(4000);
	}
	public boolean IssalesoverviewandSummarydisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(salesoverviewandSummary));
		boolean issalesoverviewandSummarydisplayed= salesoverviewandSummary.isDisplayed();
		return issalesoverviewandSummarydisplayed;
	}
	public boolean isrevenueBreakdowndisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(revenueBreakdown));
		boolean IsrevenueBreakdowndisplayed= revenueBreakdown.isDisplayed();
		return IsrevenueBreakdowndisplayed;
	}
	public boolean Isdashboarddisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		boolean isdashboarddisplayed= dashboard.isDisplayed();
		return isdashboarddisplayed;

	}
	
	public void Logout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(profile));
		profile.click();
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}
	
	public String GetCurrentUrl() throws InterruptedException {
		Thread.sleep(2000);
		String url= driver.getCurrentUrl();
		return url;
	}
	public void ClickManageTours() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Tours));
		Tours.click();
		wait.until(ExpectedConditions.visibilityOf(Tours1));
		Thread.sleep(1000);

		Tours1.click();
		wait.until(ExpectedConditions.visibilityOf(manageTours));
		Thread.sleep(1000);

		manageTours.click();
		
	}
	
}
