package Reusable_BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.admin.pom.PropertyYieldRestrictions;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_PropertyYieldRestrictions_Booking extends BaseTest {

	String BeforeBooking_count;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] RateGrid() throws IOException {
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}

	@DataProvider
	public Object[][] ClassicFlow() throws IOException {

		Object[][] testObjArray2 = ReadDataFromExcel
				.readExcelAsMap(System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray2);
	}
	
	
	@DataProvider
	public Object[][] PropYieldRes() throws IOException {
		Object[][] testObjArray3 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "PropertyYieldRestrictions");

		return (testObjArray3);
	}


	@Test(priority = 1, enabled = true, dataProvider = "RateGrid", description = "RateGrid update")
	public void Admin(HashMap<String, String> h1) throws InterruptedException, IOException {

		try {
			test = extent.createTest("Setting up Rate Grid To conduct Property Yield Restrictions Availability testing  ");
			logger.info("Setting up Rate Grid To conduct Property Yield Restrictions Availability testing");

			RateGrid NewRategrid = PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

			PropertyYieldRestrictions propYieldRes = PageFactory.initElements(SeleniumRepo.driver,
					PropertyYieldRestrictions.class);

			String EnterValue = h1.get("EnterValue").toString().trim();
			String RoomType = h1.get("RoomType").toString().trim();
			String RoomRate = h1.get("RoomRate").toString().trim();

			login_Brand_Property();
			// NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();
			BeforeBooking_count = NewRategrid.CurrentRooms_Count(RoomType);
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();
			/*
			 * NewRategrid.Click_ManageDropdown(EnterValue);
			 * NewRategrid.Select_all(); NewRategrid.Click_Continue();
			 * NewRategrid.Enter_Startdate(); NewRategrid.Enter_Enddate();
			 * BeforeBooking_count=NewRategrid.CurrentRooms_Count(RoomType);
			 * 
			 */

			logger.info("Before Booking Rooms count is " + " " + BeforeBooking_count);
			test.log(Status.INFO, "Before Booking Rooms count is " + " " + BeforeBooking_count);

			

		} catch (Exception e) {
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}


	@Test(priority = 2, enabled = true, dataProvider = "PropYieldRes", description = "Same Day Check-In BE Availability ")
	public void SameDayCheckIn(HashMap<String, String> h2) throws InterruptedException, IOException, Exception {
		
		test = extent.createTest("Enabeling Property Yield Restrictions Allow Same Day checkin");
		logger.info("Allowing  Same day checkin ");


		ClasicFlow clasicflow = PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver,
				ClassicFlow_AvailPage.class);

		PropertyYieldRestrictions propYieldRes = PageFactory.initElements(SeleniumRepo.driver,
				PropertyYieldRestrictions.class);
		
		
		propYieldRes.click_PropertyYieldRestrictions();
		SeleniumRepo.waitForPageLoaded();
		propYieldRes.propYieldSameDayChkInAllow();
		propYieldRes.Click_Save();
		SeleniumRepo.waitForPageLoaded();

		test = extent.createTest("Opening Booking Engine to test the Property Yield Restrictions Allow same day check-in search");
		logger.info("BookingEngine ClassicFlow");

		logger.info("Opening New Window ");
		
		windowid();
		SeleniumRepo.driver.switchTo().window(NewWindow);

		logger.info("Switched to Booking Enginee Window Successfully ");

		logger.info("Browser Opened");
		
		


		clasicflow.GoToUrl();
		clasicflow.verify_mybooking();
		clasicflow.currencydropdown();

		classicFlowAvailPage.sameDayBookingDates("3");
		classicFlowAvailPage.click_CheckavailabitlityButton();
		SeleniumRepo.waitForPageLoaded();

		
		// TODO: assert and confirm page return expected results 

		SeleniumRepo.driver.switchTo().window(ParentWindow);
		
		test = extent.createTest("Testing Same Day Checkin Do not allow ");
		logger.info("Switching back to admin to change Same Day Checkin to Do not allow");

		propYieldRes.propYieldSameDayChkInDoNotAllow();
		propYieldRes.Click_Save();
		SeleniumRepo.waitForPageLoaded();

		SeleniumRepo.driver.switchTo().window(NewWindow);
		
		logger.info("Retruning back to the BE to attempt a same day booking availability search ");


		classicFlowAvailPage.sameDayBookingDates("3");
		classicFlowAvailPage.click_CheckavailabitlityButton();
		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 

		test = extent.createTest("Testing Same Day Checkin Do not allow after Future ");
		logger.info("Switching back to admin to change Same Day Checkin to Do not allow after when time is set in the future");
		SeleniumRepo.driver.switchTo().window(ParentWindow);

		
		propYieldRes.propYieldSameDayChkInDoNotAllowAfterAvail();
		propYieldRes.Click_Save();
		SeleniumRepo.waitForPageLoaded();

		SeleniumRepo.driver.switchTo().window(NewWindow);
		
		logger.info("Retruning back to the BE to attempt a same day booking availability search ");


		classicFlowAvailPage.sameDayBookingDates("2");
		classicFlowAvailPage.click_CheckavailabitlityButton();
		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 
		
		
		test = extent.createTest("Testing Same Day Checkin Do not allow after past ");
		logger.info("Switching back to admin to change Same Day Checkin to Do not allow after when time is set in the past");
		SeleniumRepo.driver.switchTo().window(ParentWindow);

		propYieldRes.propYieldSameDayChkInDoNotAllowAfterUnavail();
		propYieldRes.Click_Save();
		SeleniumRepo.waitForPageLoaded();

		SeleniumRepo.driver.switchTo().window(NewWindow);
		
		logger.info("Retruning back to the BE to attempt a same day booking availability search ");

		classicFlowAvailPage.sameDayBookingDates("3");
		classicFlowAvailPage.click_CheckavailabitlityButton();
		SeleniumRepo.waitForPageLoaded();
		
		
		logger.info("Retruning back to admin to set Property Yield Restictions Same Day Checkin to its default value Allow");

		SeleniumRepo.driver.switchTo().window(ParentWindow);
		
		propYieldRes.propYieldSameDayChkInAllow();
		
		propYieldRes.Click_Save();
		
		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 

		// SeleniumRepo.driver.navigate().refresh();

		// assert and confirm the search returns nothign

		//
		// SeleniumRepo.driver.switchTo().window(ParentWindow);
		// propYieldRes.click_PropertyYieldRestrictions();


		// SeleniumRepo.driver.navigate().refresh();

		// SeleniumRepo.waitForPageLoaded();

	}
	
	
	@Test(priority = 3, enabled = true, dataProvider = "PropYieldRes", description = "Impose Max LOS for BE Avialiability ")
	public void ImposeMaxLos(HashMap<String, String> h2) throws InterruptedException, IOException, Exception {
		
		

		String ImposingMaxLos = h2.get("Impose_Max_LOS ").toString().trim();
		String MaxLos = h2.get("Max_LOS").toString().split("[.]")[0].trim();
		String gtml = h2.get("GreaterThan_Max_LOS").toString().split("[.]")[0].trim();
		String ltml = h2.get("LessThan_Max_LOS").toString().split("[.]")[0].trim();
		String MinLeadTime = h2.get("Minimum_Lead_Time").toString().split("[.]")[0].trim();
		
	
		ClassicFlow_AvailPage classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver,
				ClassicFlow_AvailPage.class);

		PropertyYieldRestrictions propYieldRes = PageFactory.initElements(SeleniumRepo.driver,
				PropertyYieldRestrictions.class);

		
		test = extent.createTest("Testing Property Yield Restrictions  Impose Max LOS and MAX LOS fields");
		logger.info("Enabling Impose Max LOS and entering a value for Max LOS text field  "); 

		propYieldRes.propYieldImposeMaxLos(ImposingMaxLos);
		propYieldRes.propYieldMaxLOS(MaxLos);
		propYieldRes.Click_Save();
		SeleniumRepo.waitForPageLoaded();
		
		logger.info("Retruning to the BE  to search availability within the Max LOS  ");


		SeleniumRepo.driver.switchTo().window(NewWindow);

		SeleniumRepo.driver.navigate().refresh();
		
		SeleniumRepo.waitForPageLoaded();

		classicFlowAvailPage.maxLosBooking("01/03/2020", MaxLos);
		
		classicFlowAvailPage.click_CheckavailabitlityButton();
		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 

		logger.info("Remaining on the BE to search availability beyond the Max LOS  ");

		
		classicFlowAvailPage.maxLosBooking("01/03/2020", gtml);
		
		classicFlowAvailPage.click_CheckavailabitlityButton();
		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 
		
		logger.info("Retruning to the Admin to disable Impose Max LOS ");

		
		SeleniumRepo.driver.switchTo().window(ParentWindow);
		
		propYieldRes.propYieldImposeMaxLos("disable");
		propYieldRes.propYieldMaxLOS(" ");
		
		propYieldRes.Click_Save();
			
	}
	
	
	
	
	@Test(priority = 4, enabled = false, dataProvider = "PropYieldRes", description = "Min and Max Lead-Time  BE Avialiability ")
	public void MinMaxLeadTime(HashMap<String, String> h2) throws InterruptedException, IOException, Exception {
		
		test = extent.createTest("Testing Property Yield Restrictions  Min and Max Lead Time fields");
		logger.info("Enabling Impose Max LOS and entering a value for Max LOS text field  "); 

		
		

		String MinLeadTime = h2.get("Minimum_Lead_Time").toString().split("[.]")[0].trim();
		String MaxLeadTime = h2.get("Maximum_Lead_Time").toString().split("[.]")[0].trim();
		String los = h2.get("LessThan_Max_LOS").toString().split("[.]")[0].trim();
		
		
		
		
		ClassicFlow_AvailPage classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver,
				ClassicFlow_AvailPage.class);

		PropertyYieldRestrictions propYieldRes = PageFactory.initElements(SeleniumRepo.driver,
				PropertyYieldRestrictions.class);
		

		logger.info("Remaining on the Admin page to set Min Lead Time value");

		//Integer.toString( Integer.parseInt(MinLeadTime) )
		
		propYieldRes.propYieldMinLeadTime( MinLeadTime );		
		propYieldRes.Click_Save();
		
		SeleniumRepo.waitForPageLoaded();

		
		
		logger.info("Switching to the BE to conduct an avialability search below Min Lead time value");

		SeleniumRepo.driver.switchTo().window(NewWindow);
	
		classicFlowAvailPage.arivalDepartureDateAutoPicks("1", los);
		
		classicFlowAvailPage.click_CheckavailabitlityButton();

		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 
		
		logger.info("Remaining on the BE to conduct an avialability search equal to or greater than Min Lead time value");

		//SeleniumRepo.driver.navigate().refresh();
		//SeleniumRepo.waitForPageLoaded();


		classicFlowAvailPage.arivalDepartureDateAutoPicks(MinLeadTime, "2");
		
		classicFlowAvailPage.click_CheckavailabitlityButton();
		
		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 

		SeleniumRepo.driver.switchTo().window(ParentWindow);
		
		logger.info("Switching to the Admin to remove the value of Min Lead time and enter a value for Max Lead time");

		propYieldRes.propYieldMinLeadTime(" ");
		
		propYieldRes.Click_Save();

		SeleniumRepo.waitForPageLoaded();
				
		propYieldRes.propYieldMaxLeadTime(MaxLeadTime);
		
		propYieldRes.Click_Save();
		
		SeleniumRepo.waitForPageLoaded();

		
		SeleniumRepo.driver.switchTo().window(NewWindow);
		
		logger.info("Switching to the BE to Test the Max Lead Time changes");

		classicFlowAvailPage.arivalDepartureDateAutoPicks(MinLeadTime, los);

		classicFlowAvailPage.click_CheckavailabitlityButton();
		
		SeleniumRepo.waitForPageLoaded();
		
		//TODO: assert and confirm page return expected results 

		
		// When attempting to return unavailability by exceeding the max lead time
		//the 1 to 9999 popup appears and prevents the return of availability 
		//Need to refresh the page in order for it to go through 
		classicFlowAvailPage.arivalDepartureDateAutoPicks(MaxLeadTime, los);


		classicFlowAvailPage.click_CheckavailabitlityButton();
		
		SeleniumRepo.waitForPageLoaded();
		
		SeleniumRepo.driver.navigate().refresh();
		
		//TODO: assert and confirm page return expected results 
		
		SeleniumRepo.waitForPageLoaded();

		
		SeleniumRepo.driver.switchTo().window(ParentWindow);
		
		logger.info("Switching to the Admin to remove the value of Max Lead time");

		
		propYieldRes.propYieldMaxLeadTime(" ");	
		
		propYieldRes.Click_Save();

		SeleniumRepo.waitForPageLoaded();
		
		
	}
	
	
	@Test(priority = 5, enabled = false, dataProvider = "ClassicFlow", description = "Completing Property Yield Restricitions booking ")
	public void PropertyYieldResBooking(HashMap<String, String> h2) throws InterruptedException, IOException, Exception {
		
		test = extent.createTest("Completing a booking while All of Property Yield Restrictions fields are enabled ");
		logger.info("Enabling  Same Day Check-In, Impose Max LOS and Min/Max Lead Time "); 
		
		ClasicFlow clasicflow = PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver,ClassicFlow_AvailPage.class);
		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
		ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
		ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);


		PropertyYieldRestrictions propYieldRes = PageFactory.initElements(SeleniumRepo.driver,PropertyYieldRestrictions.class);
		
		String Enterrooms = h2.get("Enterrooms").toString().trim();
		String roomtype = h2.get("roomtype").toString().trim();
		String FirstName = h2.get("FirstName").toString().trim();
		String LastName = h2.get("LastName").toString().trim();
		String Email = h2.get("Email").toString().trim();
		String Cardname = h2.get("Cardname").toString().trim();
		String Numberoncard = h2.get("Numberoncard").toString().trim();
		String Entercountry = h2.get("Entercountry").toString().trim();
		String Address = h2.get("Address").toString().trim();
		String Address2 = h2.get("Address2").toString().trim();
		String Entercity = h2.get("Entercity").toString().trim();
		String Enterstate = h2.get("Enterstate").toString().trim();
		String Enterzipcode = h2.get("Enterzipcode").toString().trim();
		String Enterphonenum = h2.get("Enterphonenum").toString().trim();

		//SeleniumRepo.driver.switchTo().window(ParentWindow);
		
		propYieldRes.propYieldSameDayChkInDoNotAllow();
		propYieldRes.propYieldImposeMaxLos("enable");
		propYieldRes.propYieldMaxLOS("4");
		propYieldRes.propYieldMinLeadTime("3");
		propYieldRes.propYieldMaxLeadTime("6");
		
		propYieldRes.Click_Save();
		
		SeleniumRepo.waitForPageLoaded();
		
		logger.info("Switching to BE to complete a booking while all Property Yield Restrictions are active "); 

		SeleniumRepo.driver.switchTo().window(NewWindow);

		
		
		classicFlowAvailPage.arivalDepartureDateAutoPicks("4", "3");
		
		
		clasicflow.popup_ok();
		classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
		classicFlowAvailPage.select_Rooms(Enterrooms);
		classicFlowAvailPage.Click_SpecialRate();
		classicFlowAvailPage.SpecialRateplan_Validation();
		classicFlowAvailPage.Click_Done();
		//classicFlowAvailPage.click_CheckavailabitlityButton();
		classicFlowAvailPage.room_type(roomtype);
		classicFlowAvailPage.BookRoom();
		
		clasicflow.verify_Headingrooms();
		classicFlowReservationDet.verify_available_offers();
		classicFlowReservationDet.Verify_Reservationdetails();
		classicFlowReservationDet.checkbox();
		classicFlowReservationDet.First_name(FirstName);
		classicFlowReservationDet.Last_Name(LastName);
		classicFlowReservationDet.Email(Email);
		classicFlowReservationDet.extra_inforamtion();
		classicFlowReservationDet.confirmation();
		classicPaymentDet.card_information();
		classicPaymentDet.card_name(Cardname);
		classicPaymentDet.Card_number(Numberoncard);
		classicPaymentDet.Expdate();
		classicPaymentDet.Country(Entercountry);
		classicPaymentDet.Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
		classicPaymentDet.contact(Enterphonenum);
		classicPaymentDet.payment();
		classicConfirmationPg.verify_Thanku_page();
				
		
		SeleniumRepo.driver.switchTo().window(ParentWindow);
		logger.info("Retruning to Admin Property Yield Restrictions to reset all fields to their default values "); 

		propYieldRes.propYieldSameDayChkInAllow();  
		propYieldRes.propYieldImposeMaxLos("disable");
		propYieldRes.propYieldMaxLOS(" ");
		propYieldRes.propYieldMinLeadTime(" ");
		propYieldRes.propYieldMaxLeadTime(" ");
		
		
		propYieldRes.Click_Save();
		
		SeleniumRepo.waitForPageLoaded();

		
	}
		
		
	
	
	
	//@AfterMethod
	public void cleanup(){
		
		System.out.println("<-----------------------------After test --------------------------------------------->");
		
		SeleniumRepo.driver.switchTo().window(ParentWindow);

	}


}
