package com.pages.admin;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingsAdmin {

	WebDriver driver;

	@FindBy(xpath = "(//a[@href='https://phptravels.net/api/admin/bookings'])[1]")
	private WebElement bookings;

	@FindBy(xpath = "//div[text()='Paid Bookings']")
	private WebElement paidbookings;

	@FindBy(xpath = "//div[text()='Pending Bookings']")
	private WebElement pendingbookings;

	@FindBy(xpath = "//div[text()='Pending Bookings']//preceding-sibling::div")
	private WebElement pendingbookingscount;

	@FindBy(xpath = "//div[text()='Cancelled Bookings']//preceding-sibling::div")
	private WebElement cancelledbookingscount;

	@FindBy(xpath = "//table[@id='data']")
	private WebElement tableElement;

	@FindBy(xpath = "//tbody//tr[1]//td[14]")
	private WebElement invoice;

	@FindBy(xpath = "//tbody//tr[1]//td[15]")
	private WebElement delete;

	@FindBy(id = "download")
	private WebElement downloadinvoice;

	@FindBy(xpath = "//h3[@class='title']")
	private WebElement getTitle;

	@FindBy(xpath = "//div[text()='Cancelled Bookings']")
	private WebElement cancelledbookings;
	
	@FindBy(xpath="(//select[@class='form-select status pending'])[1]")
	private WebElement bookingStatus;

	public BookingsAdmin(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickBookings() throws InterruptedException {
		Thread.sleep(2000);
		bookings.click();
	}

	public void ClickConfirmedBookings() throws InterruptedException {
		Thread.sleep(2000);
		paidbookings.click();
	}

	public void ClickCancelledBookings() throws InterruptedException {
		Thread.sleep(2000);
		cancelledbookings.click();
	}

	public void DeleteCancelledBooking() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500, 0)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(delete));

		delete.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public int GetCancelledBookingsCount() throws InterruptedException {
		Thread.sleep(5000);
		String count = cancelledbookingscount.getText();
		int intCount = Integer.parseInt(count);
		System.out.println("Cancelled bookings count = " + intCount);
		return intCount;
	}


	public void ViewInvoice() throws InterruptedException {
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500, 0)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(invoice));

		invoice.click();
	}

	public boolean isInvoiceOptionfound() throws InterruptedException {

		Thread.sleep(2000);
		boolean IsInvoiceOptionfound = invoice.isDisplayed();
		return IsInvoiceOptionfound;
	}

	public boolean isDownloadInvoicefound() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(downloadinvoice));
		boolean IsDownloadInvoicefound = downloadinvoice.isDisplayed();
		return IsDownloadInvoicefound;
	}

	public String GetPageTitle() throws InterruptedException {

		Thread.sleep(2000);
		String InvoicePageTitle = getTitle.getText();
		return InvoicePageTitle;
	}
/*
	public int ConfirmedBookingsCount() throws InterruptedException {
		Thread.sleep(5000);
		String count = confirmedBookingscount.getText();
		int intCount = Integer.parseInt(count);
		System.out.println("Confirmed bookings count = " + intCount);
		return intCount;
	}
	*/

	public void ClickPendingBookings() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-500, 0)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pendingbookings));
		pendingbookings.click();
	}

	public void ChangePendingtoConfirmed() throws InterruptedException {
		Thread.sleep(3000);
		Select dropdown = new Select(bookingStatus);
		dropdown.selectByVisibleText("Confirmed");
	}

	public void ChangePendingtoCancelled() throws InterruptedException {
		Thread.sleep(3000);
		
		Select dropdown = new Select(bookingStatus);
		dropdown.selectByVisibleText("Cancelled");
	}
	public int GetPendingBookingsCount() throws InterruptedException {
		Thread.sleep(5000);
		String count = pendingbookingscount.getText();
		int intCount = Integer.parseInt(count);
		System.out.println("Pending bookings count = " + intCount);
		return intCount;
	}

}
