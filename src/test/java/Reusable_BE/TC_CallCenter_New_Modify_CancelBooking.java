package Reusable_BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.BE.pom.CallCenterBookings;
import com.tt.BE.pom.CancelBooking_Standard;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.RetryAnalyzer;
import com.tt.utility.SeleniumRepo;

public class TC_CallCenter_New_Modify_CancelBooking extends BaseTest
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
	String AftercancelBooking;
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
/*
	@Test(dataProvider = "RateGrid",priority=1,enabled=true)
	public void Rates(HashMap<String, String> h1) throws InterruptedException, IOException 
	{

		try {

			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

			test = extent.createTest("Callcenter Booking");
			logger.info("Callcenter Booking");
			EnterValue = h1.get("EnterValue").toString().trim();
			RoomType=h1.get("RoomType").toString().trim();
			RoomRate=h1.get("RoomRate").toString().trim();



			logger.info("Browser Opened");


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
			logger.error("Unable to  Create Rate Grid " + e);
			test.log(Status.ERROR, "Unable to  Create Rate Grid " + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
*/
	
	@Test(dataProvider = "dataSupplier",priority=2,enabled=true,description="Call Center New,Modify,Cancel Booking",retryAnalyzer=RetryAnalyzer.class)
	public void Callcenter(HashMap<String, String> h2) throws InterruptedException, IOException {

		try {
			CallCenterBookings  CallCenter=PageFactory.initElements(SeleniumRepo.driver, CallCenterBookings.class);
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);

			test = extent.createTest("Callcenter New Booking");
			logger.info("Callcenter  New Booking");

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

			//windowid();
			//SeleniumRepo.driver.switchTo().window(NewWindow);

			logger.info("Switched to Booking Enginee Window Successfully ");

			CallCenter.GoToUrl();

			CallCenter.Call_Center_User(CallCenterUser);
			Thread.sleep(8000);
			CallCenter.departuredate();
			CallCenter.arrival_date();
			Thread.sleep(1000);
			CallCenter.groupplan.click();
			Thread.sleep(1000);
			CallCenter.select_rooms(Enterrooms);
			CallCenter.select_adults(Adults);
			CallCenter.select_Children(Children);
			CallCenter.Check_Availability();
			SeleniumRepo.waitForPageLoaded();
			Thread.sleep(12000);
			CallCenter.selectRoom.get(0).click();
			//BeforeBookingprice=CallCenter.Select_roomtype(roomtype, Enterrooms,RateType);
			CallCenter.payment();
			Thread.sleep(12000);
			CallCenter.First_name(FirstName);
			CallCenter.Last_Name(LastName);
			CallCenter.Email(Email);
			CallCenter.Extra_information();
			CallCenter.card_name(Cardname);
			CallCenter.Card_number(Numberoncard);
			CallCenter.Expdate();
			CallCenter.CountryName(Entercountry);
			Thread.sleep(8000);
			CallCenter.Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
			CallCenter.PhoneNumber(Enterphonenum);
			CallCenter.Click_accept();

			CallCenter.Complete_Reservation();
			
			/*

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

			test = extent.createTest("CallCenter Modify Booking");
			logger.info("CallCenter Modify Booking"); 

*/
			Thread.sleep(5000);
			CallCenter.CallCenter_ChangeReservation();
			Thread.sleep(1000);
			CallCenter.acceptCHANGERESERVATIONPopUp.get(1).click();
			Thread.sleep(9000);
			CallCenter.Edit_search();
			Thread.sleep(5000);
			
			CallCenter.Check_Availability();
			SeleniumRepo.waitForPageLoaded();
			Thread.sleep(12000);
			CallCenter.selectRoom.get(1).click();
			//CallCenter.CallCenter_Pricemodifycheck(RoomType, RoomRate, Enterrooms,BeforeBookingprice,RateType);
			CallCenter.payment();
			Thread.sleep(12000);


			SeleniumRepo.waitForPageLoaded();
			
			CallCenter.First_name(FirstName);
			CallCenter.Last_Name(LastName);
			CallCenter.Email(Email);
			SeleniumRepo.WaitForLoad(5000);
			CallCenter.card_name(Cardname);
			CallCenter.Card_number(Numberoncard);
			CallCenter.Expdate();
			CallCenter.CountryName(Entercountry);
			CallCenter.Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
			CallCenter.PhoneNumber(Enterphonenum);
			CallCenter.Click_accept();
			Thread.sleep(2000);
            		
			CallCenter.Complete_Reservation();
			Thread.sleep(2000);
			
			/*
			SeleniumRepo.driver.switchTo().window(ParentWindow);


			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();

			System.out.println("After Modifying  Rooms count is "+" "+AfterBooking_Count);

			Room_afterchangereser=NewRategrid.CurrentRooms_Count(RoomType);

			logger.info("After change reservation Room count is "+" "+Room_afterchangereser);
			test.log(Status.INFO, "After change reservation Room count is "+" "+Room_afterchangereser);

			NewRategrid.count_validation(AfterBooking_Count, Room_afterchangereser);

			test.log(Status.INFO, "Reservation Modified Successfully and Rooms count is not reduced after change reservation ");
			logger.info("Reservation Modified Successfully and Rooms count is not reduced after change reservation");

			test = extent.createTest("Call Center Cancel Booking ");
			logger.info("Call Center Cancel Booking"); 

			SeleniumRepo.driver.switchTo().window(NewWindow);
            Thread.sleep(2000);
*/            
			CallCenter.Click_CancelReservation();
			Thread.sleep(2000);
			CallCenter.Cancel_Popup_title();	
			Thread.sleep(2000);
/*
			SeleniumRepo.driver.switchTo().window(ParentWindow);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AftercancelBooking=NewRategrid.CurrentRooms_Count(RoomType);

			logger.info("After Cancel booking rooms count is "+" "+AftercancelBooking);
			test.log(Status.INFO, "After Cancel booking rooms count is "+" "+AftercancelBooking);

			NewRategrid.Cancel_CountValidation(BeforeBooking_count, AftercancelBooking);

			test.log(Status.INFO, "Before New Booking ,Rooms Count is :"+BeforeBooking_count);
			test.log(Status.INFO, "After Booking ,Rooms Count is :"+AfterBooking_Count);
			test.log(Status.INFO, "After Modfiy Booking ,Rooms Count is :"+Room_afterchangereser);
			test.log(Status.INFO, "After Cancel Booking ,Rooms Count is :"+AftercancelBooking);

*/
		}
		catch (Exception e) 
		{
			logger.error("Unable to  Create a New,modify,cancel booking " + e);
			test.log(Status.ERROR, "Unable to  Create a New,modify,cancel booking " + e);

			e.printStackTrace();
			Assert.assertEquals(false, true);

			/*if(SeleniumRepo.driver.getCurrentUrl().contains("http://pom.qa2.reztrip3-qa.com"))
			{

				SeleniumRepo.driver.close();
				SeleniumRepo.driver.switchTo().window(ParentWindow);
			}
			else
			{
				System.out.println("window focus is in Admin");
				SeleniumRepo.driver.switchTo().window(NewWindow);
				SeleniumRepo.driver.close();
				SeleniumRepo.driver.switchTo().defaultContent();

			}*/

		}
	}

}
