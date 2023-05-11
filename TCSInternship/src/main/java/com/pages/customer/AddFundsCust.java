package com.pages.customer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFundsCust {
	
	WebDriver driver;
	
	@FindBy(xpath="(//a[text()=' Add Funds'])[2]")
	private WebElement addfunds;
	
	@FindBy(xpath="//img[@alt='paypal']")
	private WebElement paypalradiobutton;
	
	@FindBy(xpath="//input[@name='price']")
	private WebElement enteramount;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement paynow;
	
	@FindBy(xpath="//div[@class='btn-front']")
	private WebElement goback;
	
	@FindBy(xpath="//a[@class='yes']")
	private WebElement confirmGoback;
	
	public AddFundsCust(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void clickAddFunds() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addfunds));
		addfunds.click();
	}
	
	public void ChoosePaypal() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(paypalradiobutton));
		paypalradiobutton.click();
	}
	public void EnterAmount(Object fundValue) throws InterruptedException {
		Thread.sleep(2000);
		enteramount.clear();
		Thread.sleep(2000);
		enteramount.sendKeys(fundValue.toString());
	}
	public void ClickPaynow() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(paynow));
		paynow.click();
	}
	public String Getcurrenturl() throws InterruptedException {
		Thread.sleep(2000);
		String url= driver.getCurrentUrl();
		return url;
	}
	public void GoBack() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(goback));
		goback.click();
	}
	public void ConfirmGoBack() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(confirmGoback));
		confirmGoback.click();
	}
	
	

}
