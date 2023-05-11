package com.pages.customer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageCust {

	WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://phptravels.net/account/dashboard'])[2]")
	private WebElement dashboard;
	
	@FindBy(xpath = "(//a[text()=' Logout'])[2]")
	private WebElement logout;

	public HomePageCust(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean Isdashboarddisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		boolean isdashboarddisplayed= dashboard.isDisplayed();
		return isdashboarddisplayed;

	}
	
	public void Logout() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}
	
	public String GetCurrentUrl() throws InterruptedException {
		Thread.sleep(2000);
		String url= driver.getCurrentUrl();
		return url;
	}
	
	

}
