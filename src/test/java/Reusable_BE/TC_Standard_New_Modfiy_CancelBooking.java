package Reusable_BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.BE.pom.CancelBooking_Standard;
import com.tt.BE.pom.ChangeReservation_BE;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;



public class TC_Standard_New_Modfiy_CancelBooking extends BaseTest
{
	String EnterValue;
	String RoomType;
	String RoomRate;
	String BeforeBooking_count;
	String AfterBooking_Count;
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

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
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
			RoomRate=h1.get("RoomRate").toString().trim();

			login_Brand_Property();
			//NewRategrid.Click_RatesandInventory();
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


		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
			Assert.assertEquals(true, false);
		}
	}
*/	
	
	@Test(priority = 1,enabled = true,dataProvider = "ClassicFlow",description="Standard New,Modify,Cancel Booking")
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException {

		try {
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
			ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
			ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			ChangeReservation_BE ChangeReser=PageFactory.initElements(SeleniumRepo.driver, ChangeReservation_BE.class);
			CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);


			test = extent.createTest("BookingEngine ClassicFlow");
			logger.info("BookingEngine ClassicFlow");

			logger.info("Opening New Window ");
			windowid();
			SeleniumRepo.driver.switchTo().window(NewWindow);

			logger.info("Switched to Booking Enginee Window Successfully ");

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
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			//classicFlowAvailPage.departure_date();
			//clasicflow.popup_ok();
			//classicFlowAvailPage.Rooms_and_Guests();
			//classicFlowAvailPage.select_Rooms(Enterrooms);
			//classicFlowAvailPage.Click_SpecialRate();
			//classicFlowAvailPage.SpecialRateplan_Validation();
			//classicFlowAvailPage.Click_Done();
			SeleniumRepo.waitForPageLoaded();
			classicFlowAvailPage.click_CheckavailabitlityButton();
			//classicFlowAvailPage.room_type(roomtype);
			classicFlowAvailPage.BookRoom();
			SeleniumRepo.waitForPageLoaded();
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
			classicPaymentDet.contact(Enterphonenum);Thread.sleep(3000);
			classicPaymentDet.payment();
			SeleniumRepo.waitForPageLoaded();
/*
			classicConfirmationPg.verify_Thanku_page();

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AfterBooking_Count=NewRategrid.CurrentRooms_Count(RoomType);

			logger.info("After booking Rooms count is "+" "+AfterBooking_Count);
			test.log(Status.INFO, "After booking Rooms count is "+" "+AfterBooking_Count);

			NewRategrid.count_validation(BeforeBooking_count, AfterBooking_Count);

			NewRategrid.Room_Type(RoomType);

			NewRategrid.Room_Rate(RoomRate);
			NewRategrid.Quick_Entry();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

			SeleniumRepo.driver.switchTo().window(NewWindow);
*/
			test = extent.createTest("Modify Booking");
			logger.info("Modify Booking"); 

			ChangeReser.Change_Reservation();
			//ChangeReser.Pricemodifycheck_standard(RoomType,RoomRate);

			classicFlowAvailPage.BookRoom();
			SeleniumRepo.waitForPageLoaded();
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
			classicPaymentDet.Card_number(Numberoncard);
			classicPaymentDet.Expdate();
			classicPaymentDet.payment();
			classicConfirmationPg.verify_Thanku_page();

			/*
			SeleniumRepo.driver.switchTo().window(ParentWindow);

			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();

			Room_afterchangereser=NewRategrid.CurrentRooms_Count(RoomType);

			logger.info("After change reservation Room count is "+" "+Room_afterchangereser);
			test.log(Status.INFO, "After change reservation Room count is "+" "+Room_afterchangereser);

			NewRategrid.count_validation(AfterBooking_Count, Room_afterchangereser);

			test.log(Status.INFO, "Reservation Modified Successfully and Rooms count is not reduced after change reservation ");
			logger.info("Reservation Modified Successfully and Rooms count is not reduced after change reservation");

			test = extent.createTest("Cancel Booking ");
			logger.info("Cancel Booking"); 

			SeleniumRepo.driver.switchTo().window(NewWindow);
*/
			CancelBooking.Click_CancelReservation();
			CancelBooking.Popup_title();	

/*			SeleniumRepo.driver.switchTo().window(ParentWindow);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AftercancelBooking=NewRategrid.CurrentRooms_Count(RoomType);

			//System.out.println("After Cancel booking rooms count is "+" "+AftercancelBooking);	

			logger.info("After Cancel booking rooms count is "+" "+AftercancelBooking);
			test.log(Status.INFO, "After Cancel booking rooms count is "+" "+AftercancelBooking);

			NewRategrid.Cancel_CountValidation(BeforeBooking_count, AftercancelBooking);

			test.log(Status.INFO, "Before New Booking ,Rooms Count is :"+BeforeBooking_count);
			test.log(Status.INFO, "After Booking ,Rooms Count is :"+AfterBooking_Count);
			test.log(Status.INFO, "After Modfiy Booking ,Rooms Count is :"+Room_afterchangereser);
			test.log(Status.INFO, "After Cancel Booking ,Rooms Count is :"+AftercancelBooking);

*/
		} catch (Exception e) 
		{
			logger.error("Unable to create modify/Cance Bookings because of this exception " + e);
			e.printStackTrace();
			Assert.assertEquals(true, false);

		}
	}
}
