package com.tt.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.BE.pom.CancelBooking_Standard;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.BE.pom.ChangeReservation_BE;
import com.tt.admin.pom.AddNewRatePlan;
import com.tt.admin.pom.Manage_FBP;
import com.tt.admin.pom.PropertyDefaults;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;



public class TC_FBP extends BaseTest
{

	//Take the child rateplan room price
	//update the invenotry of the child rateplan
	//take the parentrateplan room price
	//take the inventory of child rate plan before booking room

	String ChildRateplan;
	String Ratecode;
	String Category;
	String ShortDescription ;
	String imagePath;
	String MinLeadtime;
	String MaxLeadtime;
	String MinLos;
	String MaxLos ;
	String Usrinput;
	String EnterSelectedpolicyid ;
	String AdditionalNotes;
	String AgentComment;
	String ParentRateplan;
	String EnterValue;
	String offercode;
	String RoomType;
	String RoomRate;
	String Childrateplan_BeforeManageFBPRate;
	String Childrateplan_AfterManageFBPRate;
	String Amount;
	String ParentRateplanRate;
	String formula;
	String Percentage;
	String Set_days;
	String Rateafter_thresholdvalue;

	String Dayofweek ;
	String Adj_Type ;
	String Rooms ;
	String FloorAmount;
	String CielingAmount;
	String FBPRateplan;
	String Threasholdvalue;


	String Before_offerprice;
	String After_offerprice;
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
	String BeforeBooking_count;
	String AfterBooking_Count;
	String Modifiedroomprice;
	String Room_afterchangereser;
	String AftercancelBooking;
	String value;


	Logger logger = Logger.getLogger(TC_FBP.class);


	@DataProvider
	public Object[][] AddnewRateplan() throws IOException
	{
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "AddNewRatePlan");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] Rategrid() throws IOException {
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] FBP() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "ManageFBP");

		return (testObjArray1);
	}

	@DataProvider
	public Object[][] ClassicFlow() throws IOException 
	{

		Object[][] testObjArray2 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray2);
	}

	@Test(priority=1,description="Verify the FBP Radio Button in Property Defaults and Enable the FBP",enabled=true)
	public void Enable_FBP ()
	{
		try 
		{
			PropertyDefaults PropertyDefaults =PageFactory.initElements(SeleniumRepo.driver, PropertyDefaults.class);

			test = extent.createTest("Verify the FBP Radio Button in Property Defaults and Enable the FBP");
			logger.info("Verify the FBP Radio Button in Property Defaults and Enable the FBP");

			System.out.println("***********Verify the FBP Radio Button in Property Defaults and Enable the FBP*********");

			value="true";
			
			login_Brand_Property();

			PropertyDefaults.click_PropertyDefaults();
			PropertyDefaults.FBP_RadioButton(value);
			PropertyDefaults.Click_Save();
		}
		catch (Exception e) 
		{
			logger.error("unable to click yes on FBP" + e);
			test.log(Status.ERROR, "unable to click yes on FBP" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

	@Test(dataProvider = "AddnewRateplan",priority=2,description="Add New Rate Plan and Verify whether FBP is Enabled or not",enabled=true)
	public void Verify_FBP_Enabledornot(HashMap<String, String> h) throws InterruptedException, IOException {
		try {

			System.out.println("***********Add New Rate Plan and Verify whether FBP is Enabled or not*********");
			logger.info("***********Add New Rate Plan and Verify whether FBP is Enabled or not*********");
			//test.log(Status.INFO,"***********Add New Rate Plan and Verify whether FBP is Enabled or not*********");

			AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
			

			test = extent.createTest("Add New Rate Plan and Verify whether FBP is Enabled or not");


			ChildRateplan = h.get("Name").toString().trim();
			Ratecode = h.get("Ratecode").toString().trim();

			Category = h.get("Category").toString().trim();
			ShortDescription = h.get("ShortDescription").toString().trim();
			imagePath = h.get("imagePath").toString().trim();
			MinLeadtime = h.get("MinLeadtime").toString().trim();
			MaxLeadtime = h.get("MaxLeadtime").toString().trim();
			MinLos = h.get("MinLos").toString().trim();
			MaxLos = h.get("MaxLos").toString().trim();
			Usrinput = h.get("Usrinput").toString().trim();
			EnterSelectedpolicyid = h.get("EnterSelectedpolicyid").toString().trim();
			AdditionalNotes = h.get("AdditionalNotes").toString().trim();
			AgentComment = h.get("AgentComment").toString().trim();
			ParentRateplan = h.get("FBPRateplan").toString().trim();
//setting up dates for parentrateplan
			NewRatePlan.click_Rateplan();
			NewRatePlan.click_Listall();
			NewRatePlan.Name_Search(ParentRateplan);
			NewRatePlan.Edit(ParentRateplan);
			NewRatePlan.Select_Category(Category);
			NewRatePlan.All_rooms();
			NewRatePlan.Book_startdate();
			NewRatePlan.Booking_Enddate();
			NewRatePlan.Checkin_startdate();
			NewRatePlan.checkout_date();
			NewRatePlan.minleadtime();
			NewRatePlan.maxleadtime();
			NewRatePlan.minLos();
			NewRatePlan.MaxLos();
			NewRatePlan.display_offers();
			NewRatePlan.click_save();
			boolean error_status=NewRatePlan.RoomsError();
			if(error_status==true)
			{
				NewRatePlan.Rooms_inventory();
				NewRatePlan.click_save();
			}
		
//Add Child New Rateplan
			NewRatePlan.click_Listall();
			NewRatePlan.Name_Search(ChildRateplan);
			NewRatePlan.delete_rateplan(ChildRateplan);
			NewRatePlan.Click_Addnew();
			NewRatePlan.Enter_Name(ChildRateplan);
			NewRatePlan.Ratecode(Ratecode);
			NewRatePlan.Select_Category(Category);
			NewRatePlan.ShortDescription(ShortDescription);
			NewRatePlan.Click_Choosefile(imagePath);
			NewRatePlan.selectRoomType();
			NewRatePlan.Book_startdate();
			NewRatePlan.Booking_Enddate();
			NewRatePlan.Checkin_startdate();
			NewRatePlan.checkout_date();
			NewRatePlan.CallCentersearch();

			NewRatePlan.display_offers();
			NewRatePlan.Select_Basicpolicy();
			NewRatePlan.selectpolicyid(EnterSelectedpolicyid);
			NewRatePlan.inventory_BaseRatePlan(Usrinput);
			NewRatePlan.deriverates();
			NewRatePlan.verify_FBPSelectrateplan(ParentRateplan);
			NewRatePlan.Rooms_inventory();
			NewRatePlan.notes(AdditionalNotes, AgentComment);
			NewRatePlan.click_save();
		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Plan" + e);
			test.log(Status.ERROR, "Unable to create Rate Plan" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}



	@Test(dataProvider = "Rategrid",enabled=true,priority=3,description="Verify the Room Rate for the Child Rateplan without syncing the BAR whether FBP is applied correctly or not")
	public void BeforeFBPRoomRate(HashMap<String, String> h) throws InterruptedException, IOException 
	{

		try 
		{
			System.out.println("***********Verify the Room Rate for the Child Rateplan without syncing the BAR whether FBP is applied correctly or not*********");
			logger.info("***********Verify the Room Rate for the Child Rateplan without syncing the BAR whether FBP is applied correctly or not*********");
			//test.log(Status.INFO,"***********Verify the Room Rate for the Child Rateplan without syncing the BAR whether FBP is applied correctly or not*********");



			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		

			test = extent.createTest("Verify the Room Rate for the Child Rateplan without syncing the BAR whether FBP is applied correctly or not");
			logger.info("Verify the Room Rate for the Child Rateplan without syncing the BAR whether FBP is applied correctly or not");
			EnterValue = h.get("EnterValue").toString().trim();
			offercode = h.get("offer").toString().trim();
			RoomType = h.get("RoomType").toString().trim();
			RoomRate=h.get("RoomRate").toString().trim();
			System.out.println("enter");

			//Updating the rooms and inventory for the BAR  to get the rate and inventory to the parent rate plan

		//	NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);

		/*	NewRategrid.Searchfield("BAR");
			NewRategrid.select_offer("BAR");
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();*/

			//Taking the room rate for the parentrateplan 

			NewRategrid.Searchfield(ParentRateplan);
			NewRategrid.select_offer(ParentRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ParentRateplan);
			//Updating the inventory for the parentrateplan
			NewRategrid.inventory();
			ParentRateplanRate=NewRategrid.CurrentRoom_Rate(RoomType);
			System.out.println("***********ParentRateplan :"+ParentRateplan+" rate is :"+ParentRateplanRate);
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

			//Taking the  child rate plan rate for particular day

			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);

			Childrateplan_BeforeManageFBPRate=NewRategrid.CurrentRoom_Rate(RoomType);
			if(!(Childrateplan_BeforeManageFBPRate==null))
			{
				System.out.println("****************Without syncing with the Parent rate plan room rate is updated successfully for the FBP enbaled property*********");
				logger.info("********************Without syncing with the Parent rate plan room rate is updated successfully for the FBP enbaled property**********");
				test.log(Status.PASS, "********************Without syncing with the Parent rate plan room rate is updated successfully for the FBP enbaled property**********");
			}
			else
			{
				test.log(Status.FAIL, "Room Rate is not updated for the FBP enabled rate plan");
				logger.error("Room Rate is not updated for the FBP enabled rate plan");
			}


			System.out.println("Before applying formula to the ChildRateplan :"+ChildRateplan+" room :"+RoomType+" rate is :"+Childrateplan_BeforeManageFBPRate);

			
			test.log(Status.INFO, "Before applying formula to the ChildRateplan :"+ChildRateplan+" room :"+RoomType+" rate is :"+Childrateplan_BeforeManageFBPRate);
		//	test = extent.createTest("Verify the Room Rate for the Parent Rateplan By syncing with the BAR");

			//Taking the rooms count for the child rate plan before booking room

		}
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}


	}

	@Test(dataProvider = "Rategrid",enabled=true,priority=4,description="Verify If FBP enabled, cascade yield control function in the rate grid will no longer work")
	public void YeildControl(HashMap<String, String> h) throws InterruptedException, IOException 
	{

		try 
		{

			System.out.println("***********Verify If FBP enabled, cascade yield control function in the rate grid will no longer work*********");
			logger.info("***********Verify If FBP enabled, cascade yield control function in the rate grid will no longer work*********");
			//test.log(Status.INFO,"***********Verify If FBP enabled, cascade yield control function in the rate grid will no longer work*********");


			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

			test = extent.createTest("Verify If FBP enabled, cascade yield control function in the rate grid will no longer work");

			NewRategrid.verify_YeildControl();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

		}
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}


	}



	@Test(dataProvider="FBP",priority=5,description="Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Flat Amount")
	public void ManageFBP_FlatAmount(HashMap<String, String> h1) throws ParseException, IOException
	{


		System.out.println("*****Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Flat Amount****");
		logger.info("*****Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Flat Amount*****");

		test = extent.createTest("Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Flat Amount");

		//test.log(Status.INFO,"*******Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Flat Amount*********");

		Manage_FBP  FBP =PageFactory.initElements(SeleniumRepo.driver,Manage_FBP.class);
		AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		


		try 
		{
			Dayofweek = h1.get("Dayofweek").toString().trim();
			Adj_Type = h1.get("Adj_Type").toString().trim();
			Amount = h1.get("Flat Amount ").toString().trim();
			Percentage = h1.get("Percentage").toString().trim();
			Rooms = h1.get("Rooms").toString().trim();
			FBPRateplan = h1.get("FBPRateplan").toString().trim();
			FloorAmount = h1.get("FloorAmount").toString().trim();
			CielingAmount = h1.get("CielingAmount").toString().trim();
			Threasholdvalue = h1.get("Threasholdvalue").toString().trim();
			Set_days = h1.get("Set of days").toString().trim();

			NewRatePlan.click_Rateplan();
			FBP.Click_ManageFBP();
			FBP.Enter_Rateplan(ChildRateplan);
			FBP.Select_Rateplan();
			FBP.FromDate();
			FBP.Todate();
			FBP.Day_of_week(Dayofweek);
			FBP.Adj_type_FlatAmount();
			FBP.Amount(Amount);
			FBP.verify_Flatoff(ParentRateplan);
			FBP.Rooms();
			FBP.Floor(FloorAmount);
			FBP.Cieling(ReadProperties.getPropValues("Admin.properties", "FBPCielingAmount"));
			FBP.add();
			formula=FBP.verify_formula(ChildRateplan);

			System.out.println("formula applied for the rateplan :"+ChildRateplan+" is "+formula);

			//NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);
			Childrateplan_AfterManageFBPRate=NewRategrid.CurrentRoom_Rate(RoomType);

			System.out.println("After applying formula to the ChildRateplan :"+ChildRateplan+" room :"+RoomType+" rate is :"+Childrateplan_AfterManageFBPRate);
			test.log(Status.INFO, "After applying formula to the ChildRateplan :"+ChildRateplan+" room :"+RoomType+" rate is :"+Childrateplan_AfterManageFBPRate);
			
			FBP.Verify_FBPRate_FlatAmount(ParentRateplanRate, Childrateplan_AfterManageFBPRate, Amount, formula);

			BeforeBooking_count=NewRategrid.CurrentRooms_inventoryfromBarCount(RoomType);

		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}


	@Test(dataProvider="ClassicFlow",priority=6,description="Booking,Modifying,Canceling a room",enabled=true)
	public void FBP_New_Modify_Change_Reservation(HashMap<String, String> h2) throws ParseException, IOException
	{

		System.out.println("*****FBP New Booking****");
		logger.info("*****FBP New Booking****");

		test = extent.createTest("*****FBP New Booking****");
		
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
		ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
		ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

		ChangeReservation_BE ChangeReser=PageFactory.initElements(SeleniumRepo.driver, ChangeReservation_BE.class);
		CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);

		try 
		{
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


			windowid();
			logger.info("Opening New Window ");
			System.out.println("opening new window");

			SeleniumRepo.driver.switchTo().window(NewWindow);

			System.out.println(" Switched to Booking Enginee Window Successfully");
			logger.info("Switched to Booking Enginee Window Successfully ");


			clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			classicFlowAvailPage.select_Rooms(Enterrooms);

			Before_offerprice=classicFlowAvailPage.roomprice(roomtype);

			test.log(Status.INFO, "Before selecting rateplan : room price is :"+Before_offerprice);
			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.SpecialRateplan_selection(ChildRateplan);
			clasicflow.SpecialRateplantext_validation(ChildRateplan);
			classicFlowAvailPage.click_CheckavailabitlityButton();

			After_offerprice=classicFlowAvailPage.roomprice(roomtype);
			
			test.log(Status.INFO, "Before selecting rateplan : room price is :"+After_offerprice);

			System.out.println("After room price is "+After_offerprice);
			classicFlowAvailPage.roomprice_validation(After_offerprice, Before_offerprice);

			if(After_offerprice.contains(Childrateplan_AfterManageFBPRate))
			{
				System.out.println("special rate plan rate replicated successfully");
				test.log(Status.PASS, "special rate plan rate replicated successfully");
			}
			else
			{
				System.out.println("rate is different");
			}

			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			classicFlowReservationDet.offersat_Reservationpage(After_offerprice,ChildRateplan);
			classicFlowReservationDet.verify_available_offers();
			classicFlowReservationDet.Verify_Reservationdetails();
			classicFlowReservationDet.checkbox();
			classicFlowReservationDet.Select_rateplan(ChildRateplan);
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
			classicConfirmationPg.offercodevalidation_payment(ChildRateplan);

			System.out.println("*****FBP Modify Booking****");
			logger.info("*****FBP Modify Booking****");

			test = extent.createTest("*****FBP Modify Booking****");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			
			
			System.out.println(" Switched to Admin Window Successfully");

			System.out.println("Before Booking Rooms count is "+" "+BeforeBooking_count);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			AfterBooking_Count=NewRategrid.CurrentRooms_inventoryfromBarCount(RoomType);

			System.out.println("After booking Rooms count is "+" "+AfterBooking_Count);	

			logger.info("After booking Rooms count is "+" "+AfterBooking_Count);

			NewRategrid.count_validation(BeforeBooking_count, AfterBooking_Count);


			NewRategrid.Room_Type(RoomType);
			NewRategrid.Room_Rate(RoomRate);
			NewRategrid.Quick_Entry();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

			SeleniumRepo.driver.switchTo().window(NewWindow);


			System.out.println("Switched to Booking Enginee Window Successfully");	
			logger.info("Switched to Booking Enginee Window Successfully");

			ChangeReser.Change_Reservation();
			//ChangeReser.Pricemodifycheck_standard(RoomType,RoomRate);

			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.SpecialRateplan_selection(ChildRateplan);
			//Specialrates.SpecialRateplantext_validation(ChildRateplan);
			classicFlowAvailPage.click_CheckavailabitlityButton();
			Modifiedroomprice = classicFlowAvailPage.roomprice(roomtype);

			System.out.println("Modified Room price is :"+Modifiedroomprice);

			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			classicFlowReservationDet.verify_available_offers();
			classicFlowReservationDet.Verify_Reservationdetails();
			classicFlowReservationDet.checkbox();
			classicFlowReservationDet.Select_rateplan(ChildRateplan);
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

			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);

			System.out.println("After booking Rooms count is "+" "+AfterBooking_Count);

			Room_afterchangereser=NewRategrid.CurrentRooms_inventoryfromBarCount(RoomType);

			System.out.println("After change reservation Room count is "+" "+Room_afterchangereser);

			logger.info("After change reservation Room count is "+" "+Room_afterchangereser);

			NewRategrid.count_validation(AfterBooking_Count, Room_afterchangereser);

			test.log(Status.INFO, "Reservation Modified Successfully and Rooms count is not reduced after change reservation ");
			logger.info("Reservation Modified Successfully and Rooms count is not reduced after change reservation");

			SeleniumRepo.driver.switchTo().window(NewWindow);

			test = extent.createTest("*******FBP Cancel Booking*******");
			logger.info("*******FBP Cancel Booking*******");

			System.out.println("Switched to Booking Enginee Window Successfully");	
			logger.info("Switched to Booking Enginee Window Successfully");

			CancelBooking.Click_CancelReservation();
			CancelBooking.Popup_title();

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			SeleniumRepo.driver.navigate().refresh();

			SeleniumRepo.waitForPageLoaded();

			System.out.println(" Switched to Admin Window Successfully");

			AftercancelBooking=NewRategrid.CurrentRooms_inventoryfromBarCount(RoomType);

			System.out.println("After Cancel booking rooms count is "+" "+AftercancelBooking);	

			logger.info("After Cancel booking rooms count is "+" "+AftercancelBooking);

			NewRategrid.Cancel_CountValidation(BeforeBooking_count, AftercancelBooking);
			
			test.log(Status.INFO, "Before New Booking ,Rooms Count is :"+BeforeBooking_count);
			test.log(Status.INFO, "After Booking ,Rooms Count is :"+AfterBooking_Count);
			test.log(Status.INFO, "After Modfiy Booking ,Rooms Count is :"+Room_afterchangereser);
			test.log(Status.INFO, "After Cancel Booking ,Rooms Count is :"+AftercancelBooking);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}


	@Test(dataProvider = "Rategrid",enabled=true,priority=7,description="Verfy FBP formula does not work when the selected dates are overlapping existing dates")
	public void Overlapdates(HashMap<String, String> h) throws InterruptedException, IOException, ParseException 
	{

		System.out.println("*****Verfy FBP formula does not work when the selected dates are overlapping existing dates****");
		logger.info("*****Verfy FBP formula does not work when the selected dates are overlapping existing dates*****");
		//test.log(Status.INFO,"*******Verfy FBP formula does not work when the selected dates are overlapping existing dates*********");

		test = extent.createTest("Verfy FBP formula does not work when the selected dates are overlapping existing dates");
		Manage_FBP  FBP =PageFactory.initElements(SeleniumRepo.driver,Manage_FBP.class);
		AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);



		try 
		{

			NewRatePlan.click_Rateplan();
			FBP.Click_ManageFBP();
			FBP.Enter_Rateplan(ChildRateplan);
			FBP.Select_Rateplan();
			FBP.FromDate();
			FBP.Todate();
			FBP.Day_of_week(Dayofweek);
			FBP.Adj_type_Percentage();
			FBP.Amount(Percentage);
			FBP.verify_Flatoff(ParentRateplan);
			FBP.Rooms();
			FBP.Floor(FloorAmount);
			FBP.Cieling(CielingAmount);
			FBP.add();
			FBP.verify_overlappdates();
			FBP.delete();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

	@Test(dataProvider = "Rategrid",enabled=true,priority=8,description="Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Percentage")
	public void ManageFBP_Percentage(HashMap<String, String> h) throws InterruptedException, IOException, ParseException 
	{

		System.out.println("*****Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Percentage****");
		logger.info("*****Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Percentage*****");
		//test.log(Status.INFO,"*******Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Percentage*********");

		test = extent.createTest("Verify whether the new rate is instantly available on the Rate Grid after enabling FBP with Adj Type: Percentage");
		Manage_FBP  FBP =PageFactory.initElements(SeleniumRepo.driver,Manage_FBP.class);
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
	


		try 
		{

			FBP.FromDate();
			FBP.Todate();
			FBP.Day_of_week(Dayofweek);
			FBP.Adj_type_Percentage();
			FBP.Amount(Percentage);
			FBP.verify_Flatoff(ParentRateplan);
			FBP.Rooms();
			FBP.Floor(FloorAmount);
			FBP.Cieling(ReadProperties.getPropValues("Admin.properties", "FBPCielingAmount"));
			FBP.add();
			formula=FBP.verify_formula(ChildRateplan);

			//NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			/*NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);

			NewRategrid.rate_as_0();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();*/

			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);


			Childrateplan_AfterManageFBPRate=NewRategrid.CurrentRoom_Rate(RoomType);

			System.out.println("After applying formula to the ChildRateplan :"+ChildRateplan+" room :"+RoomType+" rate is :"+Childrateplan_AfterManageFBPRate);

			FBP.verify_FBPRate_Percentage(ParentRateplanRate, Childrateplan_AfterManageFBPRate, Percentage, formula);

		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
	@Test(dataProvider="Rategrid",enabled=true,priority=9,description="Verify Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value")
	public void Thresholdvalue(HashMap<String, String> h) throws InterruptedException, IOException, ParseException 
	{

		System.out.println("*****verify Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value****");
		logger.info("*****verify Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value*****");
		//test.log(Status.INFO,"*******Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value*********");

		test = extent.createTest("verify Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value");


		Manage_FBP  FBP =PageFactory.initElements(SeleniumRepo.driver,Manage_FBP.class);
		AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		


		try 
		{

			NewRatePlan.click_Rateplan();
			FBP.Click_ManageFBP();
			FBP.Enter_Rateplan(ChildRateplan);
			FBP.Select_Rateplan();
			FBP.delete();
			FBP.FromDate();
			FBP.Todate();
			FBP.Day_of_week(Dayofweek);
			FBP.Adj_type_FlatAmount();
			FBP.Amount(Amount);
			FBP.verify_Flatoff(ParentRateplan);
			FBP.Rooms();
			FBP.Floor(FloorAmount);
			FBP.Cieling(Threasholdvalue);
			FBP.add();
			formula=FBP.verify_formula(ChildRateplan);

			System.out.println("formula applied for the rateplan :"+ChildRateplan+" is "+formula);

		//	NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);
			Rateafter_thresholdvalue=NewRategrid.CurrentRoom_Rate(RoomType);



			FBP.verify_thresholdvalue(ParentRateplanRate,Threasholdvalue,formula,Amount,Rateafter_thresholdvalue);




		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

	@Test(dataProvider="Rategrid",enabled=true,priority=10,description="Verfiy the Room Rate by giving only the specific Days in Manage Formula Based Pricing")
	public void Setofdays(HashMap<String, String> h) throws InterruptedException, IOException, ParseException 
	{

		System.out.println("*****Verfiy the Room Rate by giving only the specific Days in Manage Formula Based Pricing****");
		logger.info("*****Verfiy the Room Rate by giving only the specific Days in Manage Formula Based Pricing*****");
		//test.log(Status.INFO,"*******Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value*********");

		test = extent.createTest("Verfiy the Room Rate by giving only the specific Days in Manage Formula Based Pricing");


		Manage_FBP  FBP =PageFactory.initElements(SeleniumRepo.driver,Manage_FBP.class);
		AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
	


		try 
		{

			NewRatePlan.click_Rateplan();
			FBP.Click_ManageFBP();
			FBP.Enter_Rateplan(ChildRateplan);
			FBP.Select_Rateplan();
			FBP.delete();
			FBP.FromDate();
			FBP.Todate();
			FBP.Setof_days(Set_days);
			FBP.Adj_type_FlatAmount();
			FBP.Amount(Amount);
			FBP.verify_Flatoff(ParentRateplan);
			FBP.Rooms();
			FBP.Floor(FloorAmount);
			FBP.Cieling(CielingAmount);
			FBP.add();
			formula=FBP.verify_formula(ChildRateplan);

			System.out.println("formula applied for the rateplan :"+ChildRateplan+" is "+formula);

		//	NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);
			NewRategrid.set_days_Rate(RoomType,Set_days);


			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ParentRateplan);
			NewRategrid.select_offer(ParentRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ParentRateplan);
			NewRategrid.set_days_Rate(RoomType,Set_days);




		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

	@Test(dataProvider="Rategrid",enabled=true,priority=11,description="Verify whether the rates are populated correct as per the discount when we update the rate as “0” in rate grid for the request rate plan for the date range ")
	public void Rate_as_0(HashMap<String, String> h) throws InterruptedException, IOException, ParseException 
	{

		System.out.println("*****Verify whether the rates are populated correct as per the discount when we update the rate as “0” in rate grid for the request rate plan for the date range ****");
		logger.info("*****Verify whether the rates are populated correct as per the discount when we update the rate as “0” in rate grid for the request rate plan for the date range *****");
		//test.log(Status.INFO,"*******Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value*********");

		test = extent.createTest("Verify whether the rates are populated correct as per the discount when we update the rate as “0” in rate grid for the request rate plan for the date range ");


		
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		


		try 
		{


			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);
			NewRategrid.rate_as_0();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();


			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);


			String roomrateafter0=NewRategrid.CurrentRoom_Rate(RoomType);
			if(!(roomrateafter0==null))
			{
				System.out.println("Verify the  rates are populated correct as per the discount when we update the rate as “0” in rate grid for the request rate plan for the date range  ");
			}
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

	@Test(dataProvider="Rategrid",enabled=true,priority=12,description="Verify FBP rates in Booking Engine after disabling the FBP")
	public void Delete_FBP(HashMap<String, String> h) throws InterruptedException, IOException, ParseException 
	{

		System.out.println("*****Verify FBP rates in Booking Engine after disabling the FBP****");
		logger.info("*****Verify FBP rates in Booking Engine after disabling the FBP*****");
		//test.log(Status.INFO,"*******Celing Amount should reflect in the Rate Grid and Booking Engine when the  Room Rate reaches the Threshold value*********");

		test = extent.createTest("Verify FBP rates in Booking Engine after disabling the FBP ");

		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);

		

		try 
		{
			PropertyDefaults PropertyDefaults =PageFactory.initElements(SeleniumRepo.driver, PropertyDefaults.class);

			value="false";

			PropertyDefaults.click_PropertyDefaults();

			PropertyDefaults.FBP_RadioButton(value);
			PropertyDefaults.Click_Save();


			//NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(ChildRateplan);
			NewRategrid.select_offer(ChildRateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(ChildRateplan);
			String DisableFBPamount=NewRategrid.CurrentRoom_Rate(RoomType);

			if(DisableFBPamount.contains("-"))
			{
				System.out.println("After Disbaling FBP Rooms are not having rate without syncing with the parent plan");
				logger.info("After Disbaling FBP Rooms are not having rate without syncing with the parent plan");
				test.log(Status.PASS, "After Disbaling FBP Rooms are not having rate without syncing with the parent plan");

			}

			SeleniumRepo.driver.switchTo().window(NewWindow);

			System.out.println("Switched to Booking Engine Successfully");

			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.SpecialRateplan_selection(ChildRateplan);
			//Thread.sleep(3000);
			classicFlowAvailPage.Verify_UnfortunatelyMessage();

		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}



}
