package com.SupplierBackEnd;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.basePackage.BaseClassSupplier;
import com.pages.supplier.BookingsSupl;
import com.pages.supplier.HomePageSupl;
import com.pages.supplier.LoginPageSupl;
import com.pages.supplier.ToursSupl;

import Utilities.ExcelUtility;

public class TestClassSupplier extends BaseClassSupplier {
	
	LoginPageSupl ObjLoginPageSupl;
	HomePageSupl ObjHomePageSupl;
	BookingsSupl ObjBookingsSupl;
	ToursSupl ObjToursSupl;

	
	
	@Test(priority = 1, description = "TC_1: Verify the Supplier log in with empty email id and valid password")
	public void LoginwithEmptyEmailId() throws InterruptedException, IOException {

		ObjLoginPageSupl = new LoginPageSupl(driver);
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		ObjLoginPageSupl.EnterEmail(Email);
		ObjLoginPageSupl.EnterPassword(Password);
		ObjLoginPageSupl.ClickLogin();
		String actualAlert = ObjLoginPageSupl.AlertDisplayed();
		String alertexpected = "The Email field is required.";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 2, description = "TC_2: Verify the Supplier log in with invalid email id and valid password")
	public void loginwithInvalidEmailId() throws InterruptedException, IOException {

		ObjLoginPageSupl = new LoginPageSupl(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		ObjLoginPageSupl.ClearValues();
		ObjLoginPageSupl.EnterEmail(Email);
		ObjLoginPageSupl.EnterPassword(Password);
		ObjLoginPageSupl.ClickLogin();
		String actualAlert = ObjLoginPageSupl.AlertDisplayed();
		String alertexpected = "Invalid Login Credentials";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 3, description = "TC_3: Verify the Supplier log in with valid email id and blank password")
	public void loginwithEmptyPassword() throws InterruptedException, IOException {

		ObjLoginPageSupl = new LoginPageSupl(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		String Password = ExcelUtility.GetCellData(3, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		ObjLoginPageSupl.ClearValues();
		ObjLoginPageSupl.EnterEmail(Email);
		ObjLoginPageSupl.EnterPassword(Password);
		ObjLoginPageSupl.ClickLogin();
		String actualAlert = ObjLoginPageSupl.AlertDisplayed();
		String alertexpected = "The Password field is required.";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 4, description = "TC_4: Verify the Supplier log in with valid email id and invalid password")
	public void loginwithInvalidPassword() throws InterruptedException, IOException {

		ObjLoginPageSupl = new LoginPageSupl(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		ObjLoginPageSupl.ClearValues();
		ObjLoginPageSupl.EnterEmail(Email);
		ObjLoginPageSupl.EnterPassword(Password);
		ObjLoginPageSupl.ClickLogin();
		String actualAlert = ObjLoginPageSupl.AlertDisplayed();
		String alertexpected = "Invalid Login Credentials";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 5, description = "TC_5: Verify the Supplier log in with invalid email id and invalid password")
	public void loginwithInvalidEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageSupl = new LoginPageSupl(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		ObjLoginPageSupl.ClearValues();
		ObjLoginPageSupl.EnterEmail(Email);
		ObjLoginPageSupl.EnterPassword(Password);
		ObjLoginPageSupl.ClickLogin();
		String actualAlert = ObjLoginPageSupl.AlertDisplayed();
		String alertexpected = "Invalid Login Credentials";
		Assert.assertEquals(actualAlert, alertexpected);

	}
	
	@Test(priority = 6, description = "TC_6: Verify the Supplier log in with blank email id and blank password")
	public void loginwithEmptyEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageSupl = new LoginPageSupl(driver);
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		String Password = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		ObjLoginPageSupl.ClearValues();
		ObjLoginPageSupl.EnterEmail(Email);
		ObjLoginPageSupl.EnterPassword(Password);
		ObjLoginPageSupl.ClickLogin();
		String actualAlert = ObjLoginPageSupl.AlertDisplayed();
		String alertexpected = "The Email field is required.\n"
		        + "The Password field is required.";
		Assert.assertEquals(actualAlert, alertexpected);	

	}
	
	
	@Test(priority = 7, description = "TC_7: Verify the Supplier log in with valid email id and valid password")
	public void loginverification() throws InterruptedException, IOException {

		ObjLoginPageSupl = new LoginPageSupl(driver);
		ObjHomePageSupl = new HomePageSupl(driver);
		
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 1);
		ObjLoginPageSupl.ClearValues();
		ObjLoginPageSupl.EnterEmail(Email);
		ObjLoginPageSupl.EnterPassword(Password);
		ObjLoginPageSupl.ClickLogin();
		boolean isDashboardDisplayed= ObjHomePageSupl.Isdashboarddisplayed();
		boolean isdashboardDisplayedExpected= true; 
		Assert.assertEquals(isDashboardDisplayed, isdashboardDisplayedExpected);

	}
	
	@Test(priority=8, description="TC_8: Check Sales overview & summary text is displayed in dashboad")
	public void CheckSalesOverviewandSummaryText() throws InterruptedException {
		
		ObjHomePageSupl = new HomePageSupl(driver);
		
		boolean IssalesoverviewandSummarydisplayedActual= ObjHomePageSupl.IssalesoverviewandSummarydisplayed();
		boolean IssalesoverviewandSummarydisplayedExpected= true; 
		Assert.assertEquals(IssalesoverviewandSummarydisplayedActual, IssalesoverviewandSummarydisplayedExpected);
		
	}
	
	@Test(priority=9, description="TC_9: Check Revenue Breakdown is displayed in dashboad")
	public void CheckRevenueBreakdownSession() throws InterruptedException {
		
		ObjHomePageSupl = new HomePageSupl(driver);
		
		boolean isrevenueBreakdowndisplayedActual= ObjHomePageSupl.isrevenueBreakdowndisplayed();
		boolean isrevenueBreakdowndisplayedExpected= true; 
		Assert.assertEquals(isrevenueBreakdowndisplayedActual, isrevenueBreakdowndisplayedExpected);
		
	}
	
	
	@Test(priority=10, description="TC_10: Change bookings status from pending to confirmed")
	public void ChangeBookingStatus() throws InterruptedException {
		
		ObjBookingsSupl = new BookingsSupl(driver);
		ObjHomePageSupl = new HomePageSupl(driver);
		
		int CountOld= ObjBookingsSupl.ConfirmedBookingsCount();
		ObjBookingsSupl.ClickPendingBookings();
		ObjBookingsSupl.ChangeBookingStatus();
		ObjHomePageSupl.ClickDashboard();
		int CountNew= ObjBookingsSupl.ConfirmedBookingsCount();
		int CountExpected= CountOld+1;
		
		Assert.assertEquals(CountExpected, CountNew);
		
		ObjBookingsSupl.ChangeConfirmedtoPending();
		
	}

	
	
	@Test(priority=12, description= "TC_12: Verify Tours page links")
	public void VerifyToursLinks() throws InterruptedException {
		
		ObjHomePageSupl = new HomePageSupl(driver);
		ObjToursSupl = new ToursSupl(driver);
		
		ObjHomePageSupl.ClickDashboard();
		ObjHomePageSupl.ClickManageTours();
		String actualPageHeader= ObjToursSupl.getPageHeader();
		String expectedPageHeader= "Tours Management";
		
		Assert.assertEquals(actualPageHeader, expectedPageHeader);
		
		
	}
	
	
	@Test(priority=14, description= "TC_14: Logout")
	public void Logout() throws InterruptedException {
		
		ObjHomePageSupl = new HomePageSupl(driver);
		ObjLoginPageSupl = new LoginPageSupl(driver);
		
		ObjHomePageSupl.ClickDashboard();
		ObjHomePageSupl.Logout();
		String ActualPageHeader= ObjLoginPageSupl.GetPageHeader();
		String ExpectedPageHeader="Login";
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
		
	}
	
}
