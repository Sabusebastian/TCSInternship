package com.pages.agent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageAgent {
	
	WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://phptravels.net/account/dashboard'])[2]")
	private WebElement dashboard;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement account;
	
	@FindBy(xpath = "//a[@href='https://phptravels.net/account/dashboard']")
	private WebElement dashboard1;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "(//button[@id='currency'])[1]")
	private WebElement currencyType;
	
	@FindBy(xpath = "//a[@href='https://phptravels.net/currency-INR']")
	private WebElement currencyINR;
	
	

	public HomePageAgent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean Isdashboarddisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		boolean isdashboarddisplayed= dashboard.isDisplayed();
		return isdashboarddisplayed;

	}
	
	public void Logout() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(account));
		account.click();
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}
	
	public void ClickDashboard() throws InterruptedException {
		Thread.sleep(2000);
		String AccountButtonText= account.getText();
		System.out.println(AccountButtonText);
		account.click();
		Thread.sleep(2000);
		String DashboardButtonText= account.getText();
		System.out.println(DashboardButtonText);
		dashboard1.click();
		
	}
	
	public String GetCurrentUrl() throws InterruptedException {
		Thread.sleep(2000);
		String url= driver.getCurrentUrl();
		return url;
	}
	
	public void SelectCurrencyDropdown() throws InterruptedException {
		Thread.sleep(2000);
		currencyType.click();
	}
	public void SelectCurrencyINR() throws InterruptedException {
		Thread.sleep(2000);
		currencyINR.click();
	}
	public String GetCurrentCurrentType() throws InterruptedException {
		Thread.sleep(2000);
		String CurrentType= currencyType.getText();
		return CurrentType;
	}
	
	

}
