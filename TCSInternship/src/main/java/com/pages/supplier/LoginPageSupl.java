package com.pages.supplier;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageSupl {
	
	WebDriver driver;

	
	@FindBy(xpath = "//h1")
	private WebElement pageheader;
	
	@FindBy(xpath = "(//input[@name='email'])[1]")
	private WebElement email;

	@FindBy(xpath = "(//input[@name='password'])[1]")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;

	@FindBy(xpath = "//div[@class='alert alert-danger loading wow fadeIn animated animated']")
	private WebElement invalidcredentialsalert;

	public LoginPageSupl(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterEmail(Object Email) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(Email.toString());
		Thread.sleep(500);
	}

	public void EnterPassword(String Password) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(Password.toString());
		Thread.sleep(500);

	}

	public void ClearValues() throws InterruptedException {

		email.clear();
		password.clear();
		Thread.sleep(500);
	}

	public void ClickLogin() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
		Thread.sleep(1000);
	}

	public String AlertDisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(invalidcredentialsalert));
		String ViewAlert= invalidcredentialsalert.getText();
		System.out.println(ViewAlert);
		return ViewAlert;
	}
	public boolean isAlertDisplayed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(invalidcredentialsalert));
		boolean isdisplayed= invalidcredentialsalert.isDisplayed();
		String ViewAlert= invalidcredentialsalert.getText();
		System.out.println(ViewAlert);
		return isdisplayed;
	}
	
	public String GetPageHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pageheader));
		String PageHeader= pageheader.getText();
		return PageHeader;
		
	}

}
