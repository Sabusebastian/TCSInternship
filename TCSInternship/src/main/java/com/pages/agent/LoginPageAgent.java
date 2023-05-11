package com.pages.agent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageAgent {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement login;

	@FindBy(xpath = "//div[@class='alert alert-danger failed']")
	private WebElement invalidcredentialsalert;
	
	@FindBy(xpath = "(//h5)[1]")
	private WebElement pageheader;

	public LoginPageAgent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterEmail(Object Email) throws InterruptedException {

		email.sendKeys(Email.toString());
		Thread.sleep(3000);
	}

	public void EnterPassword(String Password) throws InterruptedException {

		password.sendKeys(Password.toString());
		Thread.sleep(3000);

	}

	public void ClearValues() throws InterruptedException {

		email.clear();
		password.clear();
		Thread.sleep(3000);
	}

	public void ClickLogin() throws InterruptedException {

		login.click();
		Thread.sleep(3000);
	}

	public boolean Invalidcredentialsalert() throws InterruptedException {

		boolean isdisplayed= invalidcredentialsalert.isDisplayed();
		return isdisplayed;
	}
	public String GetPageHeader() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(pageheader));
		String pageHeader= pageheader.getText();
		return pageHeader;
	}
}
