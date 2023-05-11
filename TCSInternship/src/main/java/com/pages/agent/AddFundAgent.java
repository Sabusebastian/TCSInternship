package com.pages.agent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFundAgent {
	
WebDriver driver;
	
	@FindBy(xpath="(//a[text()=' Add Funds'])[2]")
	private WebElement addfunds;
	
	@FindBy(xpath="(//h3[@class='title'])[1]")
	private WebElement pageHeader;
	
	
	public AddFundAgent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void clickAddFunds() throws InterruptedException {
		Thread.sleep(2000);
		addfunds.click();
	}
	
	public String GetPageHeader() throws InterruptedException {
		Thread.sleep(2000);
		String PageHeader= pageHeader.getText();
		return PageHeader;
	}
	
	

}
