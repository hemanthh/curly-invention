package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.CancelBooking_Standard;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.admin.TC_RateGrid;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_CancelBooking extends BaseTest
{
	String BeforeCancel_count;
	String AfterCancel_Count;
	String BeforeBooking_count;
	String AfterBooking_Count;
	String EnterValue;
	String RoomType;
	String Room_afterchangereser;
	String AftercancelBooking;
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
	public Object[][] ClassicFlow() throws IOException {

		Object[][] testObjArray2 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

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


		} catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
*/	
	
	@Test(priority = 1,enabled = true,dataProvider = "ClassicFlow",description="Booking Room in Booking Engine")
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException 
	{

		try {
			
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
			ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
			ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

			test = extent.createTest("Booking singleRoom");
			logger.info("Booking singleRoom");
		
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
			logger.info("Browser Opened");
			/*clasicflow.clasic(EnterCurrency,Enterrooms,roomtype,FirstName,LastName,Email,Cardname,
					Numberoncard,Entercountry,Address,Address2,Entercity,Enterstate, Enterzipcode,Enterphonenum);*/
			
			
			clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			//classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			//classicFlowAvailPage.Rooms_and_Guests();
			//classicFlowAvailPage.select_Rooms(Enterrooms);
			//classicFlowAvailPage.Click_SpecialRate();
			//classicFlowAvailPage.SpecialRateplan_Validation();
			//classicFlowAvailPage.Click_Done();
			classicFlowAvailPage.click_CheckavailabitlityButton();
			
			//classicFlowAvailPage.room_type(roomtype);
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
			//classicConfirmationPg.verify_Thanku_page();

		} 
		catch (Exception e) 
		{
			logger.error("Unable to  Property Dining " + e);
			e.printStackTrace();

		}
	}
	
	/*
	@Test(priority = 2,enabled=true,dataProvider = "RateGrid",description="Rooms Count After Room Reservation")
	public void CountComparision(HashMap<String, String> h3) throws InterruptedException 
	{
		try 
		{
			test = extent.createTest("Checking the Rooms Count After Booking and Before Canceling Reservation");
			logger.info("Checking the Rooms Count After Booking and Before Canceling Reservation");
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			SeleniumRepo.driver.switchTo().window(ParentWindow);

			System.out.println(" Switched to Admin Window Successfully");

			System.out.println("Before booking and Before cancel  Rooms count is "+" "+BeforeBooking_count);
			
			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AfterBooking_Count=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After booking and before cancel Rooms count is "+" "+AfterBooking_Count);	
			
			
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
*/	
	@Test(priority = 2,enabled=true,dataProvider = "RateGrid",description="Cancel Booking in Booking Engine")

	public void CancelReservation_Ratecheck(HashMap<String, String> h4) throws InterruptedException, IOException 
	{
		test = extent.createTest("Checking the Rooms Count After Booking and After Canceling Reservation");
		logger.info("Checking the Rooms Count After Booking and After Canceling Reservation");
		
		CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

		String RoomType=h4.get("RoomType").toString().trim();

		test = extent.createTest("Cancel Booking ");
		logger.info("Cancel Booking"); 

		System.out.println("Switched to Booking Enginee Window Successfully");	
		
		CancelBooking.Click_CancelReservation();
		CancelBooking.Popup_title();	
		
		/*
		SeleniumRepo.driver.switchTo().window(ParentWindow);
		
		SeleniumRepo.driver.navigate().refresh();

		SeleniumRepo.waitForPageLoaded();

		System.out.println(" Switched to Admin Window Successfully");
		
		AftercancelBooking=NewRategrid.CurrentRooms_Count(RoomType);

		System.out.println("After Cancel booking rooms count is "+" "+AftercancelBooking);	
		
		logger.info("After Cancel booking rooms count is "+" "+AftercancelBooking);
		
		NewRategrid.Cancel_CountValidation(BeforeBooking_count, AftercancelBooking);
		
		
*/		
		
		}

	
}
