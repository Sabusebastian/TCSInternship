package com.AgentFrontEnd;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.basePackage.BaseUserandAgent;
import com.pages.agent.AddFundAgent;
import com.pages.agent.BlogAgent;
import com.pages.agent.BookingsAgent;
import com.pages.agent.FlightsAgent;
import com.pages.agent.HomePageAgent;
import com.pages.agent.HotelsAgent;
import com.pages.agent.LoginPageAgent;
import com.pages.agent.MyProfileAgent;
import com.pages.agent.OffersAgent;
import com.pages.agent.ToursAgent;
import com.pages.agent.VisaAgent;

import Utilities.ExcelUtility;

public class TestClassAgent extends BaseUserandAgent{
	
	LoginPageAgent ObjLoginPageAgent;
	HomePageAgent ObjHomePageAgent;
	BookingsAgent ObjBookingsAgent;
	AddFundAgent ObjAddFundAgent;
	MyProfileAgent ObjMyProfileAgent;
	HotelsAgent ObjHotelsAgent;
	FlightsAgent ObjFlightsAgent;
	ToursAgent ObjToursAgent;
	VisaAgent ObjVisaAgent;
	BlogAgent ObjBlogAgent;
	OffersAgent ObjOffersAgent;
	
	String secondWindowHandle;


	@Test(priority = 1, description = "TC_1: Verify the AGENT log in with empty email id and valid password")
	public void LoginwithEmptyEmailId() throws InterruptedException, IOException {

		ObjLoginPageAgent= new LoginPageAgent(driver);
		
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		ObjLoginPageAgent.EnterEmail(Email);
		ObjLoginPageAgent.EnterPassword(Password);
		ObjLoginPageAgent.ClickLogin();

	}

	@Test(priority = 2, description = "TC_2: Verify the AGENT log in with invalid email id and valid password")
	public void loginwithInvalidEmailId() throws InterruptedException, IOException {

		ObjLoginPageAgent = new LoginPageAgent(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		ObjLoginPageAgent.ClearValues();
		ObjLoginPageAgent.EnterEmail(Email);
		ObjLoginPageAgent.EnterPassword(Password);
		ObjLoginPageAgent.ClickLogin();
		boolean Isalertdisplayed = ObjLoginPageAgent.Invalidcredentialsalert();
		boolean alertexpected = true;
		Assert.assertEquals(Isalertdisplayed, alertexpected);

	}

	@Test(priority = 3, description = "TC_3: Verify the AGENT log in with valid email id and blank password")
	public void loginwithEmptyPassword() throws InterruptedException, IOException {

		ObjLoginPageAgent = new LoginPageAgent(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		String Password = ExcelUtility.GetCellData(3, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		ObjLoginPageAgent.ClearValues();
		ObjLoginPageAgent.EnterEmail(Email);
		ObjLoginPageAgent.EnterPassword(Password);
		ObjLoginPageAgent.ClickLogin();

	}

	@Test(priority = 4, description = "TC_4: Verify the AGENT log in with valid email id and invalid password")
	public void loginwithInvalidPassword() throws InterruptedException, IOException {

		ObjLoginPageAgent = new LoginPageAgent(driver);
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		ObjLoginPageAgent.ClearValues();
		ObjLoginPageAgent.EnterEmail(Email);
		ObjLoginPageAgent.EnterPassword(Password);
		ObjLoginPageAgent.ClickLogin();
		boolean Isalertdisplayed = ObjLoginPageAgent.Invalidcredentialsalert();
		boolean alertexpected = true;
		Assert.assertEquals(Isalertdisplayed, alertexpected);

	}

	@Test(priority = 5, description = "TC_5: Verify the AGENT log in with invalid email id and invalid password")
	public void loginwithInvalidEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageAgent = new LoginPageAgent(driver);
		String Email = ExcelUtility.GetCellData(2, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		String Password = ExcelUtility.GetCellData(2, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		ObjLoginPageAgent.ClearValues();
		ObjLoginPageAgent.EnterEmail(Email);
		ObjLoginPageAgent.EnterPassword(Password);
		ObjLoginPageAgent.ClickLogin();
		boolean Isalertdisplayed = ObjLoginPageAgent.Invalidcredentialsalert();
		boolean alertexpected = true;
		Assert.assertEquals(Isalertdisplayed, alertexpected);

	}
	
	@Test(priority = 6, description = "TC_6: Verify the AGENT log in with blank email id and blank password")
	public void loginwithEmptyEmailandPassword() throws InterruptedException, IOException {

		ObjLoginPageAgent = new LoginPageAgent(driver);
		String Email = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		String Password = ExcelUtility.GetCellData(3, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		ObjLoginPageAgent.ClearValues();
		ObjLoginPageAgent.EnterEmail(Email);
		ObjLoginPageAgent.EnterPassword(Password);
		ObjLoginPageAgent.ClickLogin();
		

	}
	
	
	@Test(priority = 7, description = "TC_7: Verify the AGENT log in with valid email id and valid password")
	public void loginverification() throws InterruptedException, IOException {

		ObjLoginPageAgent = new LoginPageAgent(driver);
		ObjHomePageAgent = new HomePageAgent(driver);
		
		String Email = ExcelUtility.GetCellData(1, 1, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		String Password = ExcelUtility.GetCellData(1, 2, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);
		ObjLoginPageAgent.ClearValues();
		ObjLoginPageAgent.EnterEmail(Email);
		ObjLoginPageAgent.EnterPassword(Password);
		ObjLoginPageAgent.ClickLogin();
		boolean isDashboardDisplayed= ObjHomePageAgent.Isdashboarddisplayed();
		boolean isdashboardDisplayedExpected= true; 
		Assert.assertEquals(isDashboardDisplayed, isdashboardDisplayedExpected);

	}
	
	
	@Test(priority=8, description="TC_8: Verify My Bookings links")
	public void VerifyMybookingsLink() throws InterruptedException {
		
		ObjBookingsAgent= new BookingsAgent(driver);
		
		ObjBookingsAgent.ClickMyBookings();
		
		String PageTitleActual=ObjBookingsAgent.GetPageTitle();
		String PageTitleExpected= "My Bookings";
		
		Assert.assertEquals(PageTitleActual, PageTitleExpected);
			
	}
	

	@Test(priority=9, description="TC_9: View Booking invoice")	
	public void ViewVoucher() throws InterruptedException {
		ObjBookingsAgent= new BookingsAgent(driver);
		
		String firstWindowHandle = driver.getWindowHandle();
		
		ObjBookingsAgent.ViewVoucher();
		
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
        boolean isDownloadButtonEnabledActual=ObjBookingsAgent.isDownloadInvoicefound();

		Assert.assertEquals(isDownloadButtonEnabledActual, isDownloadButtonEnabledExpected);
		
		driver.switchTo().window(firstWindowHandle);

	}
	
	@Test(priority=10, description="TC_10: Test Add Funds Page Links")	
	public void AddFundsLinks() throws InterruptedException {
		ObjAddFundAgent = new AddFundAgent(driver);
		
		ObjAddFundAgent.clickAddFunds();
		String ActualPageHeader = ObjAddFundAgent.GetPageHeader();
		String ExpectedPageHeader = "Add Funds";
		
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
		
	}
	
	@Test(priority=11, description="TC_11: Test My Profile Page Links")	
	public void MyProfileLinks() throws InterruptedException {
		ObjMyProfileAgent = new MyProfileAgent(driver);
		
		ObjMyProfileAgent.ClickMyProfile();
		String ActualPageHeader = ObjMyProfileAgent.GetPageHeader();
		String ExpectedPageHeader = "Profile Information";
		
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
		
	}
	
	@Test(priority=12, description="TC_12: Search Hotels with invalid city name")	
	public void SearchHotelwithInvalidCityName() throws InterruptedException, IOException {
		ObjHotelsAgent= new HotelsAgent(driver);
		
		ObjHotelsAgent.ClickHotels();
		ObjHotelsAgent.ClickSearch();
		String invalidcityname = ExcelUtility.GetCellData(1, 3, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);

		ObjHotelsAgent.EnterInvalidCityName(invalidcityname);
		String Actualalert= ObjHotelsAgent.ReadAlert();
		String Expectedalert= "No results found";
		
		Assert.assertEquals(Actualalert, Expectedalert);
		
	}
	
	@Test(priority=13, description="TC_13: Search Hotels with valid city name")	
	public void SearchHotelwithValidCityName() throws InterruptedException, IOException {
		ObjHotelsAgent= new HotelsAgent(driver);
		
		ObjHotelsAgent.ClickHotels();
		ObjHotelsAgent.ClickSearch();
		String validcityname = ExcelUtility.GetCellData(1, 4, System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", 2);

		ObjHotelsAgent.EnterValidCityName(validcityname);
		ObjHotelsAgent.SelectCity();
		ObjHotelsAgent.ClickSearchButton();
	
		
		String ActualLocationfound= ObjHotelsAgent.GetLocation();
		String ExpectedLocationfound = validcityname;
	
		Assert.assertEquals(ActualLocationfound, ExpectedLocationfound);
		
	}
	
	
	@Test(priority=14, description="TC_14: Check Home Page link")	
	public void CheckHomePagelink() throws InterruptedException, IOException {
		ObjHomePageAgent = new HomePageAgent(driver);
		
		ObjHomePageAgent.ClickDashboard();
		boolean IsDashboardPageFoundActual= ObjHomePageAgent.Isdashboarddisplayed();
		boolean IsDashboardPageFoundExpected= true;
		
		Assert.assertEquals(IsDashboardPageFoundActual, IsDashboardPageFoundExpected);
			
	}
	@Test(priority=15, description="TC_15: Check Flights Page link")	
	public void CheckFlightPagelink() throws InterruptedException, IOException {
		
		ObjFlightsAgent = new FlightsAgent(driver);
	
		ObjFlightsAgent.ClickFlights();
		
		String ActualPageHeader= ObjFlightsAgent.PageHeader();
		String ExpectedPageHeader = "SEARCH FOR BEST FLIGHTS";
	
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
			
	}
	@Test(priority=16, description="TC_16: Check Tours Page link")	
	public void CheckToursPagelink() throws InterruptedException, IOException {
		
		
		ObjToursAgent = new ToursAgent(driver);
		
		ObjToursAgent.ClickTours();
			
		String ActualPageHeader= ObjToursAgent.PageHeader();
		String ExpectedPageHeader = "FIND THE BEST TOURS PACKAGES";
	
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
			
	}
	@Test(priority=17, description="TC_17: Check Visa Page link")	
	public void CheckVisaPagelink() throws InterruptedException, IOException {
		
		
		ObjVisaAgent = new VisaAgent(driver);
		
		ObjVisaAgent.ClickVisa();
			
		String ActualPageHeader= ObjVisaAgent.PageHeader();
		String ExpectedPageHeader = "SUBMIT YOUR VISA TODAY!";
	
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
			
	}
	@Test(priority=18, description="TC_18: Check Blog Page link")	
	public void CheckBlogPagelink() throws InterruptedException, IOException {
		
		
		ObjBlogAgent = new BlogAgent(driver);
		
		ObjBlogAgent.ClickBlog();
			
		String ActualPageHeader= ObjBlogAgent.PageHeader();
		String ExpectedPageHeader = "PHPTRAVELS BLOG";
	
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
			
	}
	@Test(priority=19, description="TC_19: Check Offers Page link")	
	public void CheckOffersPagelink() throws InterruptedException, IOException {
		
		
		ObjOffersAgent = new OffersAgent(driver);
		
		ObjOffersAgent.ClickOffers();
			
		String ActualPageHeader= ObjOffersAgent.PageHeader();
		String ExpectedPageHeader = "PHPTRAVELS OFFERS";
	
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
			
	}
	@Test(priority=20, description="TC_20: Change currency type to INR")	
	public void ChangeCurrencyTypetoINR() throws InterruptedException, IOException {
		
		
		ObjHomePageAgent = new HomePageAgent(driver);
		
		ObjHomePageAgent.SelectCurrencyDropdown();
		ObjHomePageAgent.SelectCurrencyINR();
		
		String ActualPageHeader= ObjHomePageAgent.GetCurrentCurrentType();
		String ExpectedPageHeader = "INR";
	
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
			
	}
	@Test(priority=21, description= "TC_21: Logout")
	public void Logout() throws InterruptedException {
		
		ObjHomePageAgent = new HomePageAgent(driver);
		ObjLoginPageAgent = new LoginPageAgent(driver);
		
		ObjHomePageAgent.Logout();
		
		String ActualPageHeader= ObjLoginPageAgent.GetPageHeader();
		String ExpectedPageHeader="Login";
		Assert.assertEquals(ActualPageHeader, ExpectedPageHeader);
		
	}
	

}
