package com.pages.customer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageCust {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement login;

	@FindBy(xpath = "//div[@class='alert alert-danger failed']")
	private WebElement invalidcredentialsalert;

	public LoginPageCust(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterEmail(Object Email) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(Email.toString());
		Thread.sleep(500);
	}

	public void EnterPassword(String Password) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
		Thread.sleep(500);
	}

	public boolean Invalidcredentialsalert() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(invalidcredentialsalert));
		boolean isdisplayed= invalidcredentialsalert.isDisplayed();
		return isdisplayed;
	}

}
