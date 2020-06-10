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
import com.tt.BE.pom.Yankee_ClassicFlow;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_YankeeFlow_New_Modify_CancelBooking extends BaseTest
{
	String BeforeBooking_count;
	String AfterBooking_Count;
	String EnterValue;
	String RoomType;
	String RoomRate;
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
	String Room_afterchangereser;
	String AftercancelBooking;
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "YankeeFlow");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] RateGrid() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}
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
			SeleniumRepo.waitForPageLoaded();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			SeleniumRepo.WaitForLoad(3000);
			BeforeBooking_count=NewRategrid.CurrentRooms_Count(RoomType);
				
			
			logger.info("Before Booking Rooms count is "+" "+BeforeBooking_count);
			test.log(Status.INFO, "Before Booking Rooms count is "+" "+BeforeBooking_count);

			
		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
	@Test(dataProvider = "dataSupplier",priority=2,description="Yankee New,Modify,Cancel Booking")
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException {
	
		try {
			Yankee_ClassicFlow  Yankee =PageFactory.initElements(SeleniumRepo.driver, Yankee_ClassicFlow.class);
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			ChangeReservation_BE ChangeReser=PageFactory.initElements(SeleniumRepo.driver, ChangeReservation_BE.class);
			CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);
			
		
		test = extent.createTest("Creating Yankee clasicflow ");
		logger.info("Creating Yankee clasicflow ");


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
			
			logger.info("Opening New Window ");
			

			windowid();
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//SeleniumRepo.driver.manage().window().maximize();
			
			test.log(Status.INFO, "Switched to Booking Enginee Window Successfully");
			logger.info("Switched to Booking Enginee Window Successfully ");
			
			Yankee.GoToUrl();
			SeleniumRepo.waitForPageLoaded();
			Yankee.currencydropdown();
			Yankee.arrival_date();
			Yankee.departuredate();
			Yankee.popup_ok();
			Yankee.ChooseGuests();
			SeleniumRepo.waitForPageLoaded();

			Yankee.select_Members(Enterrooms);
			SeleniumRepo.waitForPageLoaded();

			
			Yankee.offers();
			Yankee.offerscode_Validation();
			Yankee.Specialdone();
			Yankee.checkavailabitlity();
			SeleniumRepo.waitForPageLoaded();
			Yankee.BookNow(roomtype);
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
			SeleniumRepo.waitForPageLoaded();

			Yankee.verify_Thanku_page();
			
			
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
			SeleniumRepo.waitForPageLoaded();

			NewRategrid.Click_RateGrid();

			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			test = extent.createTest("Yankee Modify Booking");
			logger.info("Yankee Modify Booking");
			
			ChangeReser.Change_Reservation();
			ChangeReser.Pricemodifycheck_Yankee(RoomType,RoomRate);
			
			
			Yankee.BookNow(roomtype);
			Yankee.verify_startover();
			Yankee.checkbox();
			Yankee.card_information();
			Yankee.Card_number(Numberoncard);
			Yankee.Expdate();
			Yankee.payment();
			SeleniumRepo.waitForPageLoaded();

			Yankee.verify_Thanku_page();
			
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
			
			test = extent.createTest("Yankee Cancel Booking ");
			logger.info("Yankee Cancel Booking"); 
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			CancelBooking.Click_CancelReservation();
			CancelBooking.Popup_title();
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
			

		} catch (Exception e)
		{
			e.printStackTrace();
			logger.error("Unable to  create yankee New,modify,Cancel Booking becuase of this exception  " + e);
			test.log(Status.ERROR, "Unable to  create yankee New,modify,Cancel Booking becuase of this exception   " + e);
			Assert.assertEquals(false, true);
			

		}
}
}
