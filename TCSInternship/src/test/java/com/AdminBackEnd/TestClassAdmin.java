package com.AdminBackEnd;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.basePackage.BaseClassAdmin;
import com.pages.admin.BookingsAdmin;
import com.pages.admin.HomePageAdmin;
import com.pages.admin.LoginPageAdmin;
import com.pages.supplier.ToursSupl;

import Utilities.ExcelUtility;

public class TestClassAdmin extends BaseClassAdmin{
	

	LoginPageAdmin ObjLoginPageAdmin;
	HomePageAdmin ObjHomePageAdmin;
	BookingsAdmin ObjBookingsAdmin;
	ToursSupl ObjToursSupl;

	String secondWindowHandle;
	


	@Test(priority = 1, description = "TC_1: Verify the Admin log in with empty email id and valid password")
	public void LoginwithEmptyEmailId() throws InterruptedException, IOException {

		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		ObjLoginPageAdmin.EnterEmail(Email);
		ObjLoginPageAdmin.EnterPassword(Password);
		ObjLoginPageAdmin.ClickLogin();
		String actualAlert = ObjLoginPageAdmin.AlertDisplayed();
		String alertexpected = "The Email field is required.";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 2, description = "TC_2: Verify the Admin log in with invalid email id and valid password")
	public void loginwithInvalidEmailId() throws InterruptedException, IOException {

		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		ObjLoginPageAdmin.ClearValues();
		ObjLoginPageAdmin.EnterEmail(Email);
		ObjLoginPageAdmin.EnterPassword(Password);
		ObjLoginPageAdmin.ClickLogin();
		String actualAlert = ObjLoginPageAdmin.AlertDisplayed();
		String alertexpected = "Invalid Login Credentials";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 3, description = "TC_3: Verify the Admin log in with valid email id and blank password")
	public void loginwithEmptyPassword() throws InterruptedException, IOException {

		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		String Password = ExcelUtility.GetCellData(3, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		ObjLoginPageAdmin.ClearValues();
		ObjLoginPageAdmin.EnterEmail(Email);
		ObjLoginPageAdmin.EnterPassword(Password);
		ObjLoginPageAdmin.ClickLogin();
		String actualAlert = ObjLoginPageAdmin.AlertDisplayed();
		String alertexpected = "The Password field is required.";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 4, description = "TC_4: Verify the Admin log in with valid email id and invalid password")
	public void loginwithInvalidPassword() throws InterruptedException, IOException {

		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		ObjLoginPageAdmin.ClearValues();
		ObjLoginPageAdmin.EnterEmail(Email);
		ObjLoginPageAdmin.EnterPassword(Password);
		ObjLoginPageAdmin.ClickLogin();
		String actualAlert = ObjLoginPageAdmin.AlertDisplayed();
		String alertexpected = "Invalid Login Credentials";
		Assert.assertEquals(actualAlert, alertexpected);

	}

	@Test(priority = 5, description = "TC_5: Verify the Admin log in with invalid email id and invalid password")
	public void loginwithInvalidEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		ObjLoginPageAdmin.ClearValues();
		ObjLoginPageAdmin.EnterEmail(Email);
		ObjLoginPageAdmin.EnterPassword(Password);
		ObjLoginPageAdmin.ClickLogin();
		String actualAlert = ObjLoginPageAdmin.AlertDisplayed();
		String alertexpected = "Invalid Login Credentials";
		Assert.assertEquals(actualAlert, alertexpected);

	}
	
	@Test(priority = 6, description = "TC_6: Verify the Admin log in with blank email id and blank password")
	public void loginwithEmptyEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		String Password = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		ObjLoginPageAdmin.ClearValues();
		ObjLoginPageAdmin.EnterEmail(Email);
		ObjLoginPageAdmin.EnterPassword(Password);
		ObjLoginPageAdmin.ClickLogin();
		String actualAlert = ObjLoginPageAdmin.AlertDisplayed();
		String alertexpected = "The Email field is required.\n"
		        + "The Password field is required.";
		Assert.assertEquals(actualAlert, alertexpected);	

	}
	

	
	@Test(priority = 7, description = "TC_7: Verify the Admin log in with valid email id and valid password")
	public void loginverification() throws InterruptedException, IOException {

		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		ObjHomePageAdmin = new HomePageAdmin(driver);
		
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 3);
		ObjLoginPageAdmin.ClearValues();
		ObjLoginPageAdmin.EnterEmail(Email);
		ObjLoginPageAdmin.EnterPassword(Password);
		ObjLoginPageAdmin.ClickLogin();
		boolean isDashboardDisplayed= ObjHomePageAdmin.Isdashboarddisplayed();
		boolean isdashboardDisplayedExpected= true; 
		Assert.assertEquals(isDashboardDisplayed, isdashboardDisplayedExpected);

	}
	@Test(priority=8, description="TC_8: Verify Bookings links")
	public void VerifybookingsLink() throws InterruptedException {
		
		ObjBookingsAdmin= new BookingsAdmin(driver);
		
		ObjBookingsAdmin.ClickBookings();
		
		boolean isInvoiceButtonfoundActual= ObjBookingsAdmin.isInvoiceOptionfound();
		boolean isInvoiceButtonfoundExpected= true; 
		
		Assert.assertEquals(isInvoiceButtonfoundActual, isInvoiceButtonfoundExpected);
			
	}
	

	@Test(priority=9, description="TC_9: Verify Confirmed bookings links and view invoice")	
	public void ViewInvoice() throws InterruptedException {
		
		ObjBookingsAdmin= new BookingsAdmin(driver);
		
		String firstWindowHandle = driver.getWindowHandle();
		
		ObjBookingsAdmin.ClickConfirmedBookings();
		ObjBookingsAdmin.ViewInvoice();
		
		
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
        boolean isDownloadButtonEnabledActual=ObjBookingsAdmin.isDownloadInvoicefound();

		Assert.assertEquals(isDownloadButtonEnabledActual, isDownloadButtonEnabledExpected);
		
		driver.switchTo().window(firstWindowHandle);

	}
	
	@Test(priority=10, description="TC_10: Verify Cancelled bookings links and delete a booking")
	public void DeleteCancelledBooking() throws InterruptedException {
		
		ObjBookingsAdmin= new BookingsAdmin(driver);
		
		ObjBookingsAdmin.ClickCancelledBookings();
		int CountOld= ObjBookingsAdmin.GetCancelledBookingsCount();

		ObjBookingsAdmin.DeleteCancelledBooking();
		
		int CountNew= ObjBookingsAdmin.GetCancelledBookingsCount();
		int CountExpected= CountOld-1;
		
		Assert.assertEquals(CountExpected, CountNew);	
	}
	
	
	@Test(priority=11, description="TC_11: Change bookings status from pending to confirmed and verify the booking count")
	public void ChangeBookingStatus() throws InterruptedException {
		
		ObjBookingsAdmin = new BookingsAdmin(driver);
		ObjHomePageAdmin = new HomePageAdmin(driver);
		
		int CountOld= ObjBookingsAdmin.GetPendingBookingsCount();
		ObjBookingsAdmin.ClickPendingBookings();
		ObjBookingsAdmin.ChangePendingtoConfirmed();
	//	ObjHomePageSupl.ClickDashboard();
		int CountNew= ObjBookingsAdmin.GetPendingBookingsCount();
		int CountExpected= CountOld-1;
		
		Assert.assertEquals(CountExpected, CountNew);	
		
		ObjBookingsAdmin.ChangePendingtoCancelled();
	}
	
	@Test(priority=12, description= "TC_12: Logout")
	public void Logout() throws InterruptedException {
		
		ObjHomePageAdmin = new HomePageAdmin(driver);
		ObjLoginPageAdmin = new LoginPageAdmin(driver);
		
		ObjHomePageAdmin.ClickDashboard();
		ObjHomePageAdmin.Logout();
		String ActualPageHeader= ObjLoginPageAdmin.GetPageHeader();
		String ExpectedPageHeader="Login";
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
		
	}
	
	
	

}
