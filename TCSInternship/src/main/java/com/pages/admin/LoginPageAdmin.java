package com.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAdmin {
	
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

	public LoginPageAdmin(WebDriver driver) {

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

	public String AlertDisplayed() throws InterruptedException {

		String ViewAlert= invalidcredentialsalert.getText();
		System.out.println(ViewAlert);
		return ViewAlert;
	}
	public boolean isAlertDisplayed() throws InterruptedException {

		boolean isdisplayed= invalidcredentialsalert.isDisplayed();
		String ViewAlert= invalidcredentialsalert.getText();
		System.out.println(ViewAlert);
		return isdisplayed;
	}
	
	public String GetPageHeader() throws InterruptedException {
		Thread.sleep(2000);
		String PageHeader= pageheader.getText();
		return PageHeader;
		
	}


}
