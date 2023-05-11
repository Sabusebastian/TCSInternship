package com.pages.customer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyBookingsCust {
	
	WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://phptravels.net/account/bookings'])[2]")
	private WebElement mybookings;
	
	@FindBy(xpath="//a[text()=' View Voucher']")
	private WebElement viewvoucher;
	
	@FindBy(id="download")
	private WebElement downloadinvoice;
	
	@FindBy(xpath="//h3[@class='title']")
	private WebElement getTitle;
	
	public MyBookingsCust(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickMyBookings() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(mybookings));
		mybookings.click();
	}

	public void ViewVoucher() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(viewvoucher));
		viewvoucher.click();
	}
	
	public boolean isDownloadInvoicefound() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(downloadinvoice));
		boolean IsDownloadInvoicefound= downloadinvoice.isDisplayed();
		return IsDownloadInvoicefound;
	}
	
	public String GetPageTitle() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getTitle));
		String InvoicePageTitle= getTitle.getText();
		return InvoicePageTitle;
	}

}
