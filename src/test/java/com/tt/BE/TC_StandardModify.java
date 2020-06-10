package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.BE.pom.CancelBooking_Standard;
import com.tt.BE.pom.ChangeReservation_BE;
import com.tt.admin.TC_RateGrid;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_StandardModify extends BaseTest
{
	String BeforeBooking_count;
	String AfterBooking_Count;
	String EnterValue;
	String RoomType;
	String Room_afterchangereser;

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
	String AftercancelBooking;

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
				
			logger.info("Before Booking Rooms count is "+" "+BeforeBooking_count);
			test.log(Status.INFO, "Before Booking Rooms count is "+" "+BeforeBooking_count);

			logger.info("Opening New Window ");
			System.out.println("opening new window");

			windowid();
			SeleniumRepo.driver.switchTo().window(NewWindow);
			System.out.println(" Switched to Booking Enginee Window Successfully");
			logger.info("Switched to Booking Enginee Window Successfully ");

		} catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
	*/
	
	@Test(priority = 1,enabled = true,dataProvider = "ClassicFlow",description="Booking Room in Booking Engine")
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException {

		try {
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
			ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
			ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

			test = extent.createTest("Creating clasicflow ");
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


			clasicflow.GoToUrl();
			Thread.sleep(4000);
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
			classicConfirmationPg.verify_Thanku_page();


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

			test = extent.createTest("Checking the Rooms Count After Booking and Before Changing Reservation");
			logger.info("Checking the Rooms Count After Booking and Before Changing Reservation");


			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

			String RoomType=h3.get("RoomType").toString().trim();
			String RoomRate=h3.get("RoomRate").toString().trim();

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			System.out.println(" Switched to Admin Window Successfully");

			System.out.println("Before Booking Rooms count is "+" "+BeforeBooking_count);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AfterBooking_Count=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After booking Rooms count is "+" "+AfterBooking_Count);	

			logger.info("After booking Rooms count is "+" "+AfterBooking_Count);

			NewRategrid.count_validation(BeforeBooking_count, AfterBooking_Count);

			NewRategrid.Room_Type(RoomType);

			NewRategrid.Room_Rate(RoomRate);
			NewRategrid.Quick_Entry();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();



			SeleniumRepo.driver.switchTo().window(NewWindow);

		}
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}

*/	
	@Test(priority = 2,enabled=true,dataProvider = "RateGrid",description="Change Reservation")

	public void ChangeReservation_Ratecheck(HashMap<String, String> h4) throws InterruptedException, IOException 
	{
		test = extent.createTest("Change Reservation");
		logger.info("Change Reservation");

		ChangeReservation_BE ChangeReser=PageFactory.initElements(SeleniumRepo.driver, ChangeReservation_BE.class);

		String RoomRate=h4.get("RoomRate").toString().trim();
		String RoomType=h4.get("RoomType").toString().trim();

		test = extent.createTest("Modify Booking");
		logger.info("Modify Booking"); 

		System.out.println("Switched to Booking Enginee Window Successfully");	
		logger.info("Switched to Booking Enginee Window Successfully");

		ChangeReser.Change_Reservation();
		ChangeReser.Pricemodifycheck_standard();
	}

	@Test(priority = 3,enabled=true,dataProvider = "ClassicFlow",description="Booking room after clicking Change Reservation")
	public void Bookingroom_ChangeReservation(HashMap<String, String> h5) throws InterruptedException, IOException 
	{
		try {
			test = extent.createTest("Checking the Rooms Count After Booking and After Changing Reservation");
			logger.info("Checking the Rooms Count After Booking and After Changing Reservation");

			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
			ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
			ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);


			logger.info("Creating clasicflow ");

			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			classicFlowReservationDet.verify_available_offers();
			classicFlowReservationDet.Verify_Reservationdetails();
			classicFlowReservationDet.checkbox();
			classicFlowReservationDet.extra_inforamtion();
			classicFlowReservationDet.confirmation();
			classicPaymentDet.card_information();
			classicPaymentDet.Card_number(Numberoncard);
			classicPaymentDet.Expdate();
			classicPaymentDet.payment();
			classicConfirmationPg.verify_Thanku_page();

			/*
			System.out.println("modified reservation completed successfully");
			SeleniumRepo.driver.switchTo().window(ParentWindow);

			System.out.println(" Switched to Admin Window Successfully");

			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();

			System.out.println("After booking Rooms count is "+" "+AfterBooking_Count);

			Room_afterchangereser=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After change reservation Room count is "+" "+Room_afterchangereser);

			logger.info("After change reservation Room count is "+" "+Room_afterchangereser);

			NewRategrid.count_validation(AfterBooking_Count, Room_afterchangereser);

			System.out.println("Rooms count is not reduced after change reservation");

			test.log(Status.INFO, "Reservation Modified Successfully and Rooms count is not reduced after change reservation ");
			logger.info("Reservation Modified Successfully and Rooms count is not reduced after change reservation");
			*/
		}
		catch (Exception e) 
		{
			logger.error("Unable to run Modify and Cancel Booking " + e);
			e.printStackTrace();

		}


	}
}

