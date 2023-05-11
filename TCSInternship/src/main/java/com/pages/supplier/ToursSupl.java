package com.pages.supplier;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToursSupl {
	
	WebDriver driver;

	@FindBy(xpath = "//p[@class='lead mb-0 text-white']")
	private WebElement pageHeader;
	
	public ToursSupl(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pageHeader));
		String PageHeader= pageHeader.getText();
		System.out.println(PageHeader);
		return PageHeader;
		
	}
}
