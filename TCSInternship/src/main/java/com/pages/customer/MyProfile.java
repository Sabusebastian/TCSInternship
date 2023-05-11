package com.pages.customer;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfile {
	
WebDriver driver;
	
	@FindBy(xpath="(//a[text()=' My Profile'])[2]")
	private WebElement myprofile;
	
	@FindBy(xpath="//input[@name='address1']")
	private WebElement address1;
	
	@FindBy(xpath="//input[@name='address2']")
	private WebElement address2;
	
	@FindBy(xpath="//div[@class='btn-box mt-4']//child::button")
	private WebElement updateprofile;
	
	@FindBy(xpath="//button[text()='Got It']")
	private WebElement acceptcookies;
	
	@FindBy(xpath="//div[text()=' Profile updated successfully.                                ']")
	private WebElement alertmsg;
	
	
	public MyProfile(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickMyProfile() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(myprofile));
		myprofile.click();
	}
	
	public void ClearAddress() throws InterruptedException {
		Thread.sleep(2000);
		address1.clear();
		address2.clear();
	}
	public void AddAddress1(Object address) throws InterruptedException {
		Thread.sleep(2000);
		address1.sendKeys(address.toString());
	}
	public void AddAddress2(Object address) throws InterruptedException {
		Thread.sleep(2000);
		address2.sendKeys(address.toString());
	}
	public void AcceptCookies() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(acceptcookies));
		acceptcookies.click();
	}
	public void ClickUpdateProfile() throws InterruptedException {
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 350)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(updateprofile));
		
		updateprofile.click();
	}
	public String GetAddress1() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(address1));
		String currentAddress1= address1.getText();
		System.out.println(currentAddress1);
		return currentAddress1;
	}
	
	public String GetAddress2() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(address2));
		String currentAddress2= address2.getText();
		System.out.println(currentAddress2);
		return currentAddress2;
	}
	public boolean Isprofileupdatedmsgfound() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(alertmsg));
		boolean profileupdatedmsgfound= alertmsg.isDisplayed();
		return profileupdatedmsgfound;
		
	}
	


}
