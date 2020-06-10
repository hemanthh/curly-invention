package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.CancelBooking_Standard;
import com.tt.BE.pom.Yankee_ClassicFlow;
import com.tt.admin.TC_RateGrid;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_CancelBooking_Yankee extends BaseTest
{
	String BeforeCancel_count;
	String AfterCancel_Count;
	String BeforeBooking_count;
	String AfterBooking_Count;
	String EnterValue;
	String RoomType;
	String Room_afterchangereser;
	String AftercancelBooking;
	
	
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
	
	
	
	Logger logger = Logger.getLogger(TC_RateGrid.class);
	Logger logger1 = Logger.getLogger(this.getClass().getSimpleName());


	@DataProvider
	public Object[][] RateGrid() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}
	@DataProvider
	public Object[][] YankeeClassicFlow() throws IOException {

		Object[][] testObjArray2 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "YankeeFlow");

		return (testObjArray2);
	}
	
/*	
	@Test(priority = 1,enabled = true,dataProvider = "RateGrid",description="Rooms Count Before Room Reservation")
	public void rategrid(HashMap<String, String> h1) throws InterruptedException, IOException 
	{
		try 
		{
			test = extent.createTest("Checking the Rooms Count Before Booking and Canceling Reservation");
			logger.info("Checking the Rooms Count Before Booking and Canceling Reservation");

			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			
			EnterValue = h1.get("EnterValue").toString().trim();
			RoomType=h1.get("RoomType").toString().trim();
			NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();NewRategrid.Click_ManageDropdown(EnterValue);
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


		} catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
	*/
	
	@Test(/*priority = 2,*/enabled = true,dataProvider = "YankeeClassicFlow",description="Booking Room in Booking Engine")
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException {

		try {
			Yankee_ClassicFlow  Yankee =PageFactory.initElements(SeleniumRepo.driver, Yankee_ClassicFlow.class);

			logger.info("Creating clasicflow ");

			
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
			
			logger.info("Browser Opened");

			Yankee.GoToUrl();
			Yankee.currencydropdown();
			Yankee.arrival_date();
			Yankee.departuredate();
			Yankee.popup_ok();
			Yankee.ChooseGuests();
			Yankee.select_Members(Enterrooms);

			Yankee.checkavailabitlity();
			Yankee.offers();
			Yankee.offerscode_Validation();
			Yankee.Specialdone();
			Yankee.BookNow(roomtype);
			//Yankee.Room_Check(roomtype);
			Yankee.verify_startover();
			Yankee.checkbox();
			Yankee.First_name(FirstName);
			Yankee.Last_Name(LastName);
			Yankee.Email(Email);
			Yankee.card_information();
			Yankee.card_name(Cardname);
			Yankee.Card_number(Numberoncard);
			Yankee.Expdate();
			Yankee.Country(Entercountry);
			Yankee.Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
			Yankee.contact(Enterphonenum);
			Yankee.payment();
			Yankee.verify_Thanku_page();

		} catch (Exception e) 
		{
			logger.error("Unable to  Property Dining " + e);
			e.printStackTrace();

		}
	}

	/*
	
	@Test(priority = 3,enabled=true,dataProvider = "RateGrid",description="Rooms Count After Room Reservation")
	public void CountComparision(HashMap<String, String> h3) throws InterruptedException 
	{
		try 
		{
			test = extent.createTest("Checking the Rooms Count After Booking and Before Canceling Reservation");
			logger.info("Checking the Rooms Count After Booking and Before Canceling Reservation");

			
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			System.out.println(" Switched to Admin Window Successfully");

			System.out.println("Before Booking Rooms count is "+" "+BeforeBooking_count);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AfterBooking_Count=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After booking Rooms count is "+" "+AfterBooking_Count);	
			
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

	public void CancelReservation_Ratecheck(HashMap<String, String> h4) throws InterruptedException, IOException 
	{
		test = extent.createTest("Checking the Rooms Count After Booking and After Canceling Reservation");
		logger.info("Checking the Rooms Count After Booking and After Canceling Reservation");

		CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		
		test = extent.createTest("Changing Room Reservation ");
		logger.info("Changing Room Reservation"); 

		System.out.println("Switched to Booking Enginee Window Successfully");		
		CancelBooking.Click_CancelReservation();
		CancelBooking.Popup_title();
		SeleniumRepo.driver.switchTo().window(ParentWindow);

		SeleniumRepo.driver.navigate().refresh();

		SeleniumRepo.waitForPageLoaded();

		System.out.println(" Switched to Admin Window Successfully");

		AftercancelBooking=NewRategrid.CurrentRooms_Count(RoomType);

		System.out.println("After Cancel booking rooms count is "+" "+AftercancelBooking);	
		
		logger.info("After Cancel booking rooms count is "+" "+AftercancelBooking);
		
		NewRategrid.Cancel_CountValidation(BeforeBooking_count, AftercancelBooking);


	}

*/

}
