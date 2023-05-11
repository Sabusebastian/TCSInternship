package com.CustomerFrontEnd;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.basePackage.BaseUserandAgent;
import com.pages.customer.AddFundsCust;
import com.pages.customer.HomePageCust;
import com.pages.customer.LoginPageCust;
import com.pages.customer.MyBookingsCust;
import com.pages.customer.MyProfile;

import Utilities.ExcelUtility;

public class TestClassCustomer extends BaseUserandAgent {

	LoginPageCust ObjLoginPageCust;
	HomePageCust ObjHomePageCust;
	MyBookingsCust ObjMyBookingsCust;
	AddFundsCust ObjAddFundsCust;
	MyProfile ObjMyProfile;
	
	String secondWindowHandle;


	
	@Test(priority = 1, description = "TC_1: Verify the customer log in with empty email id and valid password")
	public void LoginwithEmptyEmailId() throws InterruptedException, IOException {

		ObjLoginPageCust = new LoginPageCust(driver);
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjLoginPageCust.EnterEmail(Email);
		ObjLoginPageCust.EnterPassword(Password);
		ObjLoginPageCust.ClickLogin();

	}

	@Test(priority = 2, description = "TC_2: Verify the customer log in with invalid email id and valid password")
	public void loginwithInvalidEmailId() throws InterruptedException, IOException {

		ObjLoginPageCust = new LoginPageCust(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjLoginPageCust.ClearValues();
		ObjLoginPageCust.EnterEmail(Email);
		ObjLoginPageCust.EnterPassword(Password);
		ObjLoginPageCust.ClickLogin();
		boolean Isalertdisplayed = ObjLoginPageCust.Invalidcredentialsalert();
		boolean alertexpected = true;
		Assert.assertEquals(Isalertdisplayed, alertexpected);

	}

	@Test(priority = 3, description = "TC_3: Verify the customer log in with valid email id and blank password")
	public void loginwithEmptyPassword() throws InterruptedException, IOException {

		ObjLoginPageCust = new LoginPageCust(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Password = ExcelUtility.GetCellData(3, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjLoginPageCust.ClearValues();
		ObjLoginPageCust.EnterEmail(Email);
		ObjLoginPageCust.EnterPassword(Password);
		ObjLoginPageCust.ClickLogin();

	}

	@Test(priority = 4, description = "TC_4: Verify the customer log in with valid email id and invalid password")
	public void loginwithInvalidPassword() throws InterruptedException, IOException {

		ObjLoginPageCust = new LoginPageCust(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjLoginPageCust.ClearValues();
		ObjLoginPageCust.EnterEmail(Email);
		ObjLoginPageCust.EnterPassword(Password);
		ObjLoginPageCust.ClickLogin();
		boolean Isalertdisplayed = ObjLoginPageCust.Invalidcredentialsalert();
		boolean alertexpected = true;
		Assert.assertEquals(Isalertdisplayed, alertexpected);

	}

	@Test(priority = 5, description = "TC_5: Verify the customer log in with invalid email id and invalid password")
	public void loginwithInvalidEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageCust = new LoginPageCust(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjLoginPageCust.ClearValues();
		ObjLoginPageCust.EnterEmail(Email);
		ObjLoginPageCust.EnterPassword(Password);
		ObjLoginPageCust.ClickLogin();
		boolean Isalertdisplayed = ObjLoginPageCust.Invalidcredentialsalert();
		boolean alertexpected = true;
		Assert.assertEquals(Isalertdisplayed, alertexpected);

	}
	
	@Test(priority = 6, description = "TC_6: Verify the customer log in with blank email id and blank password")
	public void loginwithEmptyEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageCust = new LoginPageCust(driver);
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Password = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjLoginPageCust.ClearValues();
		ObjLoginPageCust.EnterEmail(Email);
		ObjLoginPageCust.EnterPassword(Password);
		ObjLoginPageCust.ClickLogin();
		

	}
	
	
	@Test(priority = 7, description = "TC_7: Verify the customer log in with valid email id and valid password")
	public void loginverification() throws InterruptedException, IOException {

		ObjLoginPageCust = new LoginPageCust(driver);
		ObjHomePageCust = new HomePageCust(driver);
		
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjLoginPageCust.ClearValues();
		ObjLoginPageCust.EnterEmail(Email);
		ObjLoginPageCust.EnterPassword(Password);
		ObjLoginPageCust.ClickLogin();
		boolean isDashboardDisplayed= ObjHomePageCust.Isdashboarddisplayed();
		boolean isdashboardDisplayedExpected= true; 
		Assert.assertEquals(isDashboardDisplayed, isdashboardDisplayedExpected);

	}
	
	
	@Test(priority=8, description="TC_8: Verify My Bookings links")
	public void VerifyMybookingsLink() throws InterruptedException {
		
		ObjMyBookingsCust= new MyBookingsCust(driver);
		
		ObjMyBookingsCust.ClickMyBookings();
		
		String PageTitleActual=ObjMyBookingsCust.GetPageTitle();
		String PageTitleExpected= "My Bookings";
		
		Assert.assertEquals(PageTitleActual, PageTitleExpected);
			
	}
	
	@Test(priority=9, description="TC_9: View Booking invoice")	
	public void ViewVoucher() throws InterruptedException {
		ObjMyBookingsCust= new MyBookingsCust(driver);
		
		String firstWindowHandle = driver.getWindowHandle();
		
		ObjMyBookingsCust.ViewVoucher();
		
		Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        for (String handle : windowHandles) {
            if (!handle.equals(firstWindowHandle)) {
                secondWindowHandle = handle;
                break;
            }
        }

        driver.switchTo().window(secondWindowHandle);
        Thread.sleep(5000);
        
        boolean isDownloadButtonEnabledExpected=true;
        boolean isDownloadButtonEnabledActual=ObjMyBookingsCust.isDownloadInvoicefound();

		Assert.assertEquals(isDownloadButtonEnabledActual, isDownloadButtonEnabledExpected);
		
		driver.switchTo().window(firstWindowHandle);

	}
	
	
	@Test(priority=10, description= "TC_10: Proceed to Add 50$ fund in account through paypal")
	public void AddFunds() throws InterruptedException, IOException {
		ObjAddFundsCust= new AddFundsCust(driver);
		
		ObjAddFundsCust.clickAddFunds();
		ObjAddFundsCust.ChoosePaypal();
		
		String FundValue= ExcelUtility.GetCellData(1, 3, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		ObjAddFundsCust.EnterAmount(FundValue);
		ObjAddFundsCust.ClickPaynow();
		
		String actualpageurl= ObjAddFundsCust.Getcurrenturl();
		String expectedpageurl= "https://phptravels.net/payment/paypal";
		
		Assert.assertEquals(actualpageurl, expectedpageurl);
		
		ObjAddFundsCust.GoBack();
		ObjAddFundsCust.ConfirmGoBack();
		
	}
	
	
	
	@Test(priority=11, description="TC_11: Update Address of the user")
	public void UpdateAddress() throws InterruptedException, IOException {
		
		ObjMyProfile= new MyProfile(driver);
		
		ObjMyProfile.ClickMyProfile();
		ObjMyProfile.AcceptCookies();
		ObjMyProfile.ClearAddress();
		
		String Adrress1= ExcelUtility.GetCellData(1, 4, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		String Address2= ExcelUtility.GetCellData(1, 5, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 0);
		
		ObjMyProfile.AddAddress1(Adrress1);
		ObjMyProfile.AddAddress2(Address2);
		
		ObjMyProfile.ClickUpdateProfile();
		
		boolean actual= ObjMyProfile.Isprofileupdatedmsgfound();
		boolean expected = true;
		
		Assert.assertEquals(actual, expected);
		
	}
	

	
	@Test(priority=12, description= "TC_12: Logout Verification")
	public void Logout() throws InterruptedException {
		
		ObjHomePageCust = new HomePageCust(driver);
		
		ObjHomePageCust.Logout();
		
		String Actualpageurl= ObjHomePageCust.GetCurrentUrl();
		String Expectedpageurl= "https://phptravels.net/login";
		
		Assert.assertEquals(Actualpageurl, Expectedpageurl);
		
	}
}
