package com.pages.supplier;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingsSupl {

	WebDriver driver;

	@FindBy(xpath = "//div[text()='Pending Bookings']")
	private WebElement pendingBookings;
	
	@FindBy(xpath = "//div[text()='Confrimed Bookings']//preceding-sibling::div")
	private WebElement confirmedBookingscount;
	
	@FindBy(xpath="//select[@class='form-select status pending']")
	private WebElement bookingStatus;
	
	@FindBy(xpath="//div[text()='Unpaid Bookings']")
	private WebElement unpaidBookings;
		
	@FindBy(xpath="//select[@class='form-select status confirmed']")
	private WebElement bookingStatus1;
	
	public BookingsSupl(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int ConfirmedBookingsCount() throws InterruptedException {
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(confirmedBookingscount));
		String count = confirmedBookingscount.getText();
		int intCount = Integer.parseInt(count);
		System.out.println("Confirmed bookings count = " + intCount);
		return intCount;
		}
	
	public void ClickPendingBookings() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pendingBookings));
		pendingBookings.click();
	}
	
	public void ChangeBookingStatus() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(bookingStatus));
		Select dropdown = new Select(bookingStatus);
		dropdown.selectByVisibleText("Confirmed");
	}
	public void ChangeConfirmedtoPending() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(confirmedBookingscount));
		confirmedBookingscount.click();
		wait.until(ExpectedConditions.visibilityOf(bookingStatus1));
		Select dropdown = new Select(bookingStatus1);
		dropdown.selectByVisibleText("Pending");
	}
	
}
