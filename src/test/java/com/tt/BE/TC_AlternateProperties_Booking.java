package com.tt.BE;

import java.io.IOException;
import java.text.ParseException;
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
import com.tt.admin.TC_Select_Property;
import com.tt.admin.pom.AlternateProperties;
import com.tt.admin.pom.HouseControls;
import com.tt.admin.pom.RateGrid;
import com.tt.admin.pom.SelectProperty;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_AlternateProperties_Booking extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
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

	String AlternatePropertyTilte;
	String PropertyCode;
	String channel;
	String AlternatePropertyCode1;
	String AlternatePropertyCode2;
	String  AlternatePropertyName1;
	String  AlternatePropertyName2;
	String No_Of_Alternateproperties;
	int alternateproeprties;
	String[] propertynames;
	String[] propertycodes;
	String SelectProperty;
	String Username;
	String Password;
	String BeforeBookingCount_Altprop;
	String AfterBookingCount_Altprop;
	String Room_afterchangereser;
	String RoomCount_AftercancelBooking;

	String EnterValue;
	String offercode;
	String RoomType;
	String RoomRate;

	String days;
	String CloseControl;
	String SelectRateplan;
	String OpenControl;


	
	@DataProvider
	public Object[][] AlternateProperties() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AlternateProperties");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] House_Controls() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"House Controls");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] ClassicFlow() throws IOException 
	{

		Object[][] testObjArray2 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray2);
	}
	@DataProvider
	public Object[][] RateGrid() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}


	@Test(dataProvider = "House_Controls",priority=1,description="Close all the rate/room using House Control")
	public void HouseControls(HashMap<String, String> h1) throws Exception 
	{
		try 
		{
			login_Brand_Property();

			HouseControls HouseControls =PageFactory.initElements(SeleniumRepo.driver, HouseControls.class);
			//ImplicitWait();

			days= h1.get("Days").toString().trim();
			CloseControl = h1.get("CloseControl").toString().trim();
			OpenControl = h1.get("OpenControl").toString().trim();
			SelectRateplan = h1.get("SelectRateplan").toString().trim();


			test = extent.createTest("Closing  all the rate/room using House Control");
			logger.info("Closing  all the rate/room using House Control");


			HouseControls.click_HouseControls();
			HouseControls.HouseControl_Startdate();
			HouseControls.HouseControl_Enddate();
			HouseControls.Apply_To(days);
			HouseControls.Select_radio_Controls(CloseControl);
			HouseControls.Select_Rateplans_Rooms(SelectRateplan);
			HouseControls.Click_ApplyControl();

		} 
		catch (Exception e) 
		{
			logger.error("Unable to Close the room/rate  because of this execption" + e);
			test.log(Status.FAIL, "Unable to Close the room/rate  because of this execption" + e);
			Assert.assertEquals(false, true);
			e.printStackTrace();

		}
		
	}


	@Test(dataProvider="ClassicFlow",priority=2,description="Verify the Booking UI for above date after closing the room/rate using House Control",enabled=true)
	public void VerifyBEafterClosingTheRooms(HashMap<String, String> h2) throws ParseException, IOException
	{


		logger.info("*****Verify the Booking UI for above date after closing the room/rate using House Control****");

		test = extent.createTest("*****Verify the Booking UI for above date after closing the room/rate using House Control****");


		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);	
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);




		EnterCurrency = h2.get("EnterCurrency").toString().trim();
		Enterrooms = h2.get("Enterrooms").toString().trim();
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
		Username = h2.get("Username").toString().trim();
		Password = h2.get("Password").toString().trim();
		roomtype = h2.get("roomtype").toString().trim();

		try 
		{

			windowid();


			SeleniumRepo.driver.switchTo().window(NewWindow);

			SeleniumRepo.driver.manage().window().maximize();

			logger.info("Switched to Booking Enginee Window Successfully ");
			test.log(Status.INFO, "Switched to Booking Enginee Window Successfully");


			clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			classicFlowAvailPage.select_Rooms(Enterrooms);
			classicFlowAvailPage.Verify_UnfortunatelyMessage();
		}

		catch (Exception e) 
		{
			logger.error("Unable to Close the room/rate  because of this execption" + e);
			test.log(Status.FAIL, "Unable to Close the room/rate  because of this execption" + e);
			Assert.assertEquals(false, true);
			e.printStackTrace();

		}
	}



	@Test(dataProvider = "AlternateProperties",priority=3,description="Add Multiple Alternate Properties",enabled=true)
	public void NewAlternateproperty(HashMap<String, String> h3) throws Exception 
	{
		try 
		{
			AlternateProperties AlterPoprty =PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);


			AlternatePropertyTilte = h3.get("AlternatePropertyTilte").toString().trim();
			AlternatePropertyCode1 = h3.get("AlternatePropertyCode1").toString().trim();
			channel = h3.get("channel").toString().trim();
			AlternatePropertyName1 = h3.get("AlternatePropertyName1").toString().trim();
			AlternatePropertyCode2 = h3.get("AlternatePropertyCode2").toString().trim();
			AlternatePropertyName2 = h3.get("AlternatePropertyName2").toString().trim();
			No_Of_Alternateproperties = h3.get("No_Of_Alternateproperties").toString().trim();
			SelectProperty=h3.get("SelectProperty").toString().trim();

			alternateproeprties = Integer.parseInt(No_Of_Alternateproperties);

			propertynames= new String[] {AlternatePropertyName1,AlternatePropertyName2};
			propertycodes=new String[] {AlternatePropertyCode1,AlternatePropertyCode2};

			test = extent.createTest("Add Multiple Alternate Properties");
			logger.info("Add Multiple Alternate Properties ");


			SeleniumRepo.driver.switchTo().window(ParentWindow);

			logger.info("Switched to Admin Window Successfully ");
			test.log(Status.INFO, "Switched to Admin Window Successfully");


			AlterPoprty.click_alternate();
			AlterPoprty.delete_alternate();


			for(int i=0;i<alternateproeprties;i++)
			{
				AlterPoprty.click_AddProperty(channel, AlternatePropertyTilte);
				AlterPoprty.Click_Save();
				AlterPoprty.Verify_SaveError();
				AlterPoprty.Enter_PropertyCode(propertycodes[i]);
				AlterPoprty.Click_Save();

			}
			AlterPoprty.verify_DeleteError();
		} 
		catch (Exception e) 
		{
			logger.error("Unable to Add Multiple properties because of this execption" + e);
			test.log(Status.FAIL, "Unable to Add Multiple properties because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}
	}

	@Test(dataProvider = "RateGrid",priority=4,description="Update rooms and inventory for the alternate Property and Verify you get the available rates and rooms",enabled=true)
	public void SwitchtoAlternateProperty(HashMap<String, String> h4) throws Exception 
	{
		try 
		{

			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			SelectProperty selProperty =PageFactory.initElements(SeleniumRepo.driver, SelectProperty.class);


			test = extent.createTest("Update rooms and inventory for the alternate Property and verify in BE");
			logger.info("Update rooms and inventory for the alternate Property and verify in BE");

			EnterValue = h4.get("EnterValue").toString().trim();
			offercode = h4.get("offer").toString().trim();
			RoomType = h4.get("RoomType").toString().trim();
			RoomRate=h4.get("RoomRate").toString().trim();
			String	propertyName = ReadProperties.getPropValues("Admin.properties", "ExistingPropetyName");


			selProperty.close_Existingproperty(propertyName);
			selProperty.selectProperty_ByAlternatePropertyName(AlternatePropertyName1);

			NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			//NewRategrid.Select_all();
			NewRategrid.Searchfield("BAR");
			NewRategrid.select_offer("BAR");
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();


			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

			if(AlternatePropertyName1.equals(selProperty))
			{
				NewRategrid.Click_ManageDropdown(EnterValue);
				//NewRategrid.Select_all();
				NewRategrid.Searchfield("BAR");
				NewRategrid.select_offer("BAR");
				NewRategrid.Click_Continue();
				NewRategrid.Enter_Startdate();
				NewRategrid.Enter_Enddate();

				BeforeBookingCount_Altprop=NewRategrid.CurrentRooms_Count(roomtype);

			}

			selProperty.close_Existingproperty(AlternatePropertyName1);
			selProperty.selectProperty_ByAlternatePropertyName(AlternatePropertyName2);


			NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			//NewRategrid.Select_all();
			NewRategrid.Searchfield("BAR");
			NewRategrid.select_offer("BAR");
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();


			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

			if(AlternatePropertyName2.equals(SelectProperty))
			{
				NewRategrid.Click_ManageDropdown(EnterValue);
				//NewRategrid.Select_all();
				NewRategrid.Searchfield("BAR");
				NewRategrid.select_offer("BAR");
				NewRategrid.Click_Continue();
				NewRategrid.Enter_Startdate();
				NewRategrid.Enter_Enddate();

				BeforeBookingCount_Altprop=NewRategrid.CurrentRooms_Count(roomtype);
			}

		} 
		catch (Exception e) 
		{
			logger.error("Unable to Add new property because of this execption" + e);
			test.log(Status.FAIL, "Unable to Add new property because of this execption" + e);
			//Assert.assertEquals(false, true);
			e.printStackTrace();

		}
	}
	@Test(dataProvider="ClassicFlow",priority=5,description="Verfiy_MultipleAlternateProperties in Booking Engine",enabled=true)
	public void Verfiy_MultipleAlternateProperties(HashMap<String, String> h4) throws Exception 
	{
		try 
		{


			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);



			test = extent.createTest("Verfiy_MultipleAlternateProperties in Booking Engine");
			logger.info("Verfiy_MultipleAlternateProperties in Booking Engine");


			SeleniumRepo.driver.switchTo().window(NewWindow);

			test.log(Status.INFO, "Switched to Booking Enigne");
			logger.info("Switched to Booking Engine");

			/*clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			clasicflow.arrival_date();
			clasicflow.departuredate();
			clasicflow.popup_ok();
			clasicflow.Rooms_and_Guests();
			clasicflow.select_Rooms(Enterrooms);*/
			classicFlowAvailPage.click_CheckavailabitlityButton();
			classicFlowAvailPage.Verify_UnfortunatelyMessage();
			classicFlowAvailPage.verify_Alternateproperty(propertynames);
			classicFlowAvailPage.Select_Alternateproperty_BookNow(SelectProperty);
			classicFlowAvailPage.Click_BookNow_AlternateProperty(SelectProperty);
			classicFlowAvailPage.verify_Roomsavailable(SelectProperty);

		} 
		catch (Exception e) 
		{
			logger.error("Unable to view multiple  properties because of this execption" + e);
			test.log(Status.FAIL, "Unable to view multiple  properties because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);


		}
	}

	@Test(priority = 6,enabled = true,dataProvider = "ClassicFlow",description="New Room Booking ,Modifying,Canceling using alternate property")
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


			test = extent.createTest("Checking the Rooms Count After Booking and After Changing Reservation");
			logger.info("Checking the Rooms Count After Booking and After Changing Reservation");
			
			clasicflow.popup_ok();
			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.Click_Done();
			classicFlowAvailPage.click_CheckavailabitlityButton();
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

			System.out.println(" Switched to Admin Window Successfully");

			System.out.println("Before Booking Rooms count is "+" "+BeforeBookingCount_Altprop);
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield("BAR");
			NewRategrid.select_offer("BAR");
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();

			AfterBookingCount_Altprop=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After booking Rooms count is "+" "+AfterBookingCount_Altprop);	

			logger.info("After booking Rooms count is "+" "+AfterBookingCount_Altprop);

			NewRategrid.count_validation(BeforeBookingCount_Altprop,AfterBookingCount_Altprop);

			logger.info("***** Modify Booking Using Alternate Property****");

			test = extent.createTest("***** Modify Booking Using Alternate Property****");

			NewRategrid.Room_Type(roomtype);

			NewRategrid.Room_Rate(RoomRate);
			NewRategrid.Quick_Entry();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();


			SeleniumRepo.driver.switchTo().window(NewWindow);

			ChangeReser.Change_Reservation();
			ChangeReser.Pricemodifycheck_standard(RoomType,RoomRate);

			classicFlowAvailPage.BookRoom();
			classicFlowAvailPage.verify_Headingrooms();
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

			System.out.println("modified reservation completed successfully");
			SeleniumRepo.driver.switchTo().window(ParentWindow);

			System.out.println(" Switched to Admin Window Successfully");

			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Select_all();
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();

			System.out.println("After booking Rooms count is "+" "+AfterBookingCount_Altprop);

			Room_afterchangereser=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After change reservation Room count is "+" "+Room_afterchangereser);

			logger.info("After change reservation Room count is "+" "+Room_afterchangereser);

			NewRategrid.count_validation(AfterBookingCount_Altprop, Room_afterchangereser);

			test.log(Status.INFO, "Reservation Modified Successfully and Rooms count is not reduced after change reservation ");
			logger.info("Reservation Modified Successfully and Rooms count is not reduced after change reservation");

			SeleniumRepo.driver.switchTo().window(NewWindow);

			logger.info("***** Cancel Booking Using Alternate Property****");

			test = extent.createTest("***** Cancel Booking Using Alternate Property****");

			System.out.println("Switched to Booking Enginee Window Successfully");	
			logger.info("Switched to Booking Enginee Window Successfully");

			CancelBooking.Click_CancelReservation();
			CancelBooking.Popup_title();

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			System.out.println(" Switched to Admin Window Successfully");

			RoomCount_AftercancelBooking=NewRategrid.CurrentRooms_Count(RoomType);

			System.out.println("After Cancel booking rooms count is "+" "+RoomCount_AftercancelBooking);	

			logger.info("After Cancel booking rooms count is "+" "+RoomCount_AftercancelBooking);

			NewRategrid.Cancel_CountValidation(BeforeBookingCount_Altprop, RoomCount_AftercancelBooking);

			test.log(Status.INFO, "Before New Booking ,Rooms Count is :"+BeforeBookingCount_Altprop);
			test.log(Status.INFO, "After Booking ,Rooms Count is :"+AfterBookingCount_Altprop);
			test.log(Status.INFO, "After Modfiy Booking ,Rooms Count is :"+Room_afterchangereser);
			test.log(Status.INFO, "After Cancel Booking ,Rooms Count is :"+RoomCount_AftercancelBooking);

		} 
		catch (Exception e) 
		{
			logger.error("Unable to  create New Booking,modifying,canceling " + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
		
		finally 
		{
			HouseControls HouseControls =PageFactory.initElements(SeleniumRepo.driver, HouseControls.class);
			if(SeleniumRepo.driver.getCurrentUrl().contains("reztrip3-qa.com"))
			{
				System.out.println("window is in BE");
				SeleniumRepo.driver.switchTo().window(ParentWindow);
				HouseControls.openhousecontrol(days,OpenControl,SelectRateplan);
			}
			else
			{
				System.out.println("window is in Admin");
				HouseControls.openhousecontrol(days,OpenControl,SelectRateplan);
			}
			
		}
	}

	/*@Test(priority=7)
	public void OpenHouseControl() throws InterruptedException
	{
		HouseControls HouseControls =PageFactory.initElements(SeleniumRepo.driver, HouseControls.class);
		test = extent.createTest("Open  all the rate/room using House Control");
		logger.info("Open  all the rate/room using House Control");

		HouseControls.click_HouseControls();
		HouseControls.HouseControl_Startdate();
		HouseControls.HouseControl_Enddate();
		HouseControls.Apply_To(days);
		HouseControls.Select_radio_Controls(OpenControl);
		HouseControls.Select_Rateplans_Rooms(SelectRateplan);
		HouseControls.Click_ApplyControl();
	}*/
}

