package com.tt.MB_Test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.MB.MobileBooking;
import com.tt.admin.TC_RateGrid;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_MobileCancelBooking extends BaseTest
{
	String BeforeBooking_count;
	String AfterBooking_Count;
	String EnterValue;
	String RoomType;
	String Room_afterchangereser;
	String EnterCurrency ;
	String Enterrooms;
	String roomtype ;
	String FirstName;
	String LastName ;
	String Email ;
	String Cardname;
	String Numberoncard; 
	String Entercountry;
	String Address ;
	String Address2 ;
	String Entercity;
	String Enterstate; 
	String Enterzipcode; 
	String Enterphonenum; 
	String Confirmationcode;
	
	Logger logger = Logger.getLogger(TC_RateGrid.class);
	Logger logger1 = Logger.getLogger(this.getClass().getSimpleName());
	//Logger logger2 = Logger.getLogger(TC_ModifyChnageReser_BE .class);

	@DataProvider
	public Object[][] RateGrid() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}
	@DataProvider
	public Object[][] MobileBooking() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "MobileBooking");

		return (testObjArray);
	}
	
	/*
	@Test(priority = 1,enabled = true,dataProvider = "RateGrid",description="Rooms Count Before Room Reservation")
	public void rategrid(HashMap<String, String> h1) throws InterruptedException, IOException 
	{
		try 
		{
			test = extent.createTest("Checking the Rooms Count Before Booking and Before Changing Reservation");
			logger.info("Checking the Rooms Count Before Booking and Before Changing Reservation");
			
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
			System.out.println(" Switched to Mobile Booking Enginee Window Successfully");

			logger.info(" Switched to Booking Enginee Window Successfully");
		} catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
*/
	
	@Test(priority = 1,enabled = true,dataProvider = "MobileBooking",description="Booking Room in Booking Engine")
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException {

		try {
			MobileBooking  mobile =PageFactory.initElements(SeleniumRepo.driver, MobileBooking.class);

			test = extent.createTest("Booking a room with mobile ");
			logger.info("Booking a room with mobile");

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

			logger.info("Browser Opened");
			
			mobile.GoToUrl();
			mobile.popup_ok();
			mobile.Menu();
			mobile.Verify_language();
			mobile.close();
			mobile.arrivaldate();
			mobile.departuredate();
			mobile.Verify_Bestprice();
			mobile.verify_ResetButton();
			mobile.Select_Room();
			mobile.RoomLink(roomtype);
			//mobile.verify_Room_date_Readmore(roomtype);
			mobile.SelectRoom.get(0).click();
			mobile.Click_Continue();
			mobile.First_name(FirstName);
			mobile.Checkbox();
			mobile.PhoneNumber(Enterphonenum);
			mobile.Email(Email);
			mobile.Address(Address);
			mobile.Country(Entercountry);
			mobile.State(Enterstate);
			mobile.City(Entercity);
			mobile.Zipcode(Enterzipcode);
			mobile.Cardname(Cardname);
			mobile.CardNo(Numberoncard);
			mobile.Expdate();
			mobile.CVV();
			mobile.Payment_Country(Entercountry);
			mobile.postalcode(Enterzipcode);
			mobile.agree();
			Confirmationcode=mobile.confirmationcode();
			
		}
		catch (Exception e) 
		{
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();

		}
	}

	@Test(priority = 2,enabled=true,dataProvider = "RateGrid",description="Rooms Count After Room Reservation")
	public void CountComparision(HashMap<String, String> h3) throws InterruptedException 
	{
		try 
		{
			
			test = extent.createTest("Checking the Rooms Count After Booking and Before Changing Reservation");
			logger.info("Checking the Rooms Count After Booking and Before Changing Reservation");
			
			
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			MobileBooking  mobile =PageFactory.initElements(SeleniumRepo.driver, MobileBooking.class);
			/*

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
			*/
			mobile.Menu();
			mobile.verify_reservationslink(Email,Confirmationcode);
			mobile.Click_CancelReservation();
			mobile.Popup_title();
			
			

		}
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
}
