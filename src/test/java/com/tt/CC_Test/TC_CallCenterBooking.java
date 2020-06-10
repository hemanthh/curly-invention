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

public class TC_CallCenterBooking extends BaseTest
{
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
	String Room_afterchangereser;
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

	@Test(dataProvider = "RateGrid",priority=1,enabled=false)
	public void Rates(HashMap<String, String> h1) throws InterruptedException, IOException 
	{

		try {
			
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
			
		} catch (Exception e) 
		{
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
}
