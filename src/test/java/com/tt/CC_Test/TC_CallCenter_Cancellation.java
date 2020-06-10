package com.tt.CC_Test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.BE.pom.CallCenterBookings;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_CallCenter_Cancellation extends BaseTest
{
	String AftercancelBooking;
	String EnterValue;
	String RoomType;
	String BeforeBooking_count;
	String AfterBooking_Count;
	String BeforeBookingprice;
	String EnterCurrency ;
	String Enterrooms;
	String roomtype;
	String FirstName;
	String LastName;
	String Email;
	String Cardname;
	String Numberoncard;
	String Entercountry;
	String Address;
	String Address2;
	String Entercity;
	String Enterstate;
	String Enterzipcode;
	String Enterphonenum;
	String CallCenterUser;
	String Adults;
	String Children;
	String RoomRate;
	String RateType;
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "CallCenter_bookings");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] RateGrid() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}

	@Test(dataProvider = "RateGrid",priority=1,enabled=true)
	public void Rates(HashMap<String, String> h1) throws InterruptedException, IOException 
	{

		try {
			test = extent.createTest("Checking the Rooms Count Before Booking and Canceling Reservation");
			logger.info("Checking the Rooms Count Before Booking and Canceling Reservation");
			
			
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		
			test = extent.createTest("Callcenter Booking");
			logger.info("Callcenter Booking");
			EnterValue = h1.get("EnterValue").toString().trim();
			RoomType=h1.get("RoomType").toString().trim();


			logger.info("Browser Opened");

			NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			BeforeBooking_count=NewRategrid.CurrentRooms_Count(RoomType);
			System.out.println("Before Booking Rooms count is "+" "+BeforeBooking_count);	
			
			logger.info("Before Booking Rooms count is "+" "+BeforeBooking_count);

			logger.info("Opening New Window ");
			System.out.println("opening new window");

			windowid();
			SeleniumRepo.driver.switchTo().window(NewWindow);
			System.out.println(" Switched to Booking Enginee Window Successfully");
			
			logger.info(" Switched to Booking Enginee Window Successfully");



		} catch (Exception e) {
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dataSupplier",priority=2,enabled=true)
	public void Callcenter(HashMap<String, String> h2) throws InterruptedException, IOException {

		try {
			
			CallCenterBookings  CallCenter=PageFactory.initElements(SeleniumRepo.driver, CallCenterBookings.class);
		
			test = extent.createTest("Callcenter Booking");
			logger.info("Callcenter Booking");

			EnterCurrency = h2.get("EnterCurrency").toString().trim();
			Enterrooms = h2.get("Enterrooms").toString().trim();
			roomtype = h2.get("roomtype").toString().trim();
			FirstName = h2.get("FirstName").toString().trim();
			LastName = h2.get("LastName").toString().trim();
			Email = h2.get("Email").toString().trim();
			Cardname = h2.get("Cardname").toString().trim();
			Numberoncard = h2.get("Numberoncard").toString().trim();
			Entercountry = h2.get("Entercountry").toString().trim();
			Address = h2.get("Address").toString().trim();
			Address2 = h2.get("Address2").toString().trim();
			Entercity = h2.get("Entercity").toString().trim();
			Enterstate = h2.get("Enterstate").toString().trim();
			Enterzipcode = h2.get("Enterzipcode").toString().trim();
			Enterphonenum = h2.get("Enterphonenum").toString().trim();
			CallCenterUser = h2.get("CallCenterUser").toString().trim();
			Adults = h2.get("Adults").toString().trim();
			Children = h2.get("Children").toString().trim();
			RateType=h2.get("RateType").toString().trim();


			logger.info("Browser Opened");

			CallCenter.GoToUrl();
			CallCenter.Call_Center_User(CallCenterUser);
			CallCenter.departuredate();
			CallCenter.arrival_date();
			
			CallCenter.select_rooms(Enterrooms);
			CallCenter.select_adults(Adults);
			CallCenter.select_Children(Children);

			CallCenter.Check_Availability();
			BeforeBookingprice=CallCenter.Select_roomtype(roomtype, Enterrooms,RateType);
			CallCenter.payment();
			CallCenter.First_name(FirstName);
			CallCenter.Last_Name(LastName);
			CallCenter.Email(Email);
			CallCenter.Extra_information();
			CallCenter.card_name(Cardname);
			CallCenter.Card_number(Numberoncard);
			CallCenter.Expdate();
			CallCenter.CountryName(Entercountry);
			CallCenter.Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
			CallCenter.PhoneNumber(Enterphonenum);
			CallCenter.Click_accept();
			CallCenter.Complete_Reservation();


		} catch (Exception e) 
		{
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();

		}
	}
	@Test(priority = 3,enabled=true,dataProvider = "RateGrid",description="Rooms Count After Room Reservation")
	public void CountComparision(HashMap<String, String> h3) throws InterruptedException 
	{
		try 
		{
			test = extent.createTest("Checking the Rooms Count After Booking and Before Canceling Reservation");
			logger.info("Checking the Rooms Count After Booking and Before Canceling Reservation");

			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			RoomRate=h3.get("RoomRate").toString().trim();

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			System.out.println(" Switched to Admin Window Successfully");

			System.out.println("Before booking and Before cancel  Rooms count is "+" "+BeforeBooking_count);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AfterBooking_Count=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After booking and Before Canceling Rooms count is "+" "+AfterBooking_Count);	
			
			
			logger.info("After booking and before cancel Rooms count is "+" "+AfterBooking_Count);
			NewRategrid.count_validation(BeforeBooking_count, AfterBooking_Count);

			SeleniumRepo.driver.switchTo().window(NewWindow);

		}
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
	@Test(priority = 4,enabled=true,dataProvider = "RateGrid",description="Change Reservation")

	public void ChangeReservation_Ratecheck(HashMap<String, String> h4) throws InterruptedException, IOException 
	{
		test = extent.createTest("Checking the Rooms Count After Booking and After Canceling Reservation");
		logger.info("Checking the Rooms Count After Booking and After Canceling Reservation");

		CallCenterBookings  CallCenter=PageFactory.initElements(SeleniumRepo.driver, CallCenterBookings.class);
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

		test = extent.createTest("Changing Room Reservation ");
		logger.info("Changing Room Reservation"); 

		System.out.println("Switched to Booking Enginee Window Successfully");	

		CallCenter.Click_CancelReservation();
		CallCenter.Cancel_Popup_title();

		SeleniumRepo.driver.switchTo().window(ParentWindow);

		System.out.println(" Switched to Admin Window Successfully");
		
		SeleniumRepo.driver.navigate().refresh();

		SeleniumRepo.waitForPageLoaded();

		System.out.println("After booking and Before Canceling rooms count is "+" "+AfterBooking_Count);

		AftercancelBooking=NewRategrid.CurrentRooms_Count(RoomType);

		System.out.println("After Cancel booking rooms count is "+" "+AftercancelBooking);	
		
		logger.info("After Cancel booking rooms count is "+" "+AftercancelBooking);
		NewRategrid.Cancel_CountValidation(BeforeBooking_count, AftercancelBooking);

		test.log(Status.INFO, "Reservation Modified Successfully and Rooms count is not reduced after change reservation ");
		logger.info("Reservation Modified Successfully and Rooms count is not reduced after change reservation");


	}


}
