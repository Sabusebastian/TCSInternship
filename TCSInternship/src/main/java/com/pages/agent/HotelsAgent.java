package com.pages.agent;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsAgent {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@title='hotels']")
	private WebElement hotels;
	
	@FindBy(xpath="//span[text()=' Search by City']")
	private WebElement searchinput;
	
	@FindBy(xpath="//input[@aria-controls='select2-hotels_city-results']")
	private WebElement searchinput1;
	
	@FindBy(xpath="//li[text()='Dubai,United Arab Emirates']")
	private WebElement resultfound;
	
	@FindBy(xpath="//div[@class='btn-search text-center']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//li[@class='select2-results__option select2-results__message']")
	private WebElement alert;
	
	@FindBy(xpath="(//p[@class='card-meta'])[1]")
	private WebElement location;
	
	
	public HotelsAgent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void ClickHotels() throws InterruptedException {
		Thread.sleep(2000);
		hotels.click();
	}
	public void ClickSearch() throws InterruptedException {
		Thread.sleep(2000);
		searchinput.click();
	}
	public void EnterInvalidCityName(Object invalidcityname) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchinput1));
		searchinput1.sendKeys(invalidcityname.toString());
	}
	public String ReadAlert() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(alert));
		String Alert= alert.getText();
		return Alert;
	}
	public void EnterValidCityName(Object validcityname) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(searchinput1));
		searchinput1.sendKeys(validcityname.toString());		
		
		
	}
	public void SelectCity() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(resultfound));
		

		boolean isresultdisplayed = resultfound.isDisplayed();
		if(isresultdisplayed==true) {
			String resultcity= resultfound.getText();
			System.out.println(resultcity);
			searchinput1.sendKeys(Keys.ENTER);
			System.out.println("Result found and clicked");
		} else {
			System.out.println("No results found");
		}
	}
	public void ClickSearchButton() throws InterruptedException {
		Thread.sleep(3000);
		searchbutton.click();
	}
	public String GetLocation() throws InterruptedException {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(location));
		String locationfound= location.getText();
		return locationfound;
	}
	

}
