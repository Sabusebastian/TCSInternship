package com.pages.agent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfileAgent {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://phptravels.net/account/profile']//child::i")
	private WebElement myprofile;
	
	@FindBy(xpath="(//h3[@class='title'])[1]")
	private WebElement pageHeader;
	
	
	public MyProfileAgent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void ClickMyProfile() throws InterruptedException {
		Thread.sleep(2000);
		myprofile.click();
	}
	
	public String GetPageHeader() throws InterruptedException {
		Thread.sleep(2000);
		String PageHeader= pageHeader.getText();
		return PageHeader;
	}
	

}
