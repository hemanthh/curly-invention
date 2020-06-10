package com.tt.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
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
import com.tt.admin.pom.Group_Blocks;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Group_Blocks extends BaseTest
{
	Logger logger = Logger.getLogger(TC_RateGrid.class);

	String rateplan;
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
	//String EnterValue;
	String offercode;
	
	String Before_offerprice;
	String Errors;
	String Name ;
	String BlockCode;
	String Shortdescription ;
	String Detailed_description;
	String releasedate;
	String After_offerprice;
	String GroupBlock_BeforeBookingcount;
	String GroupBlock_AfterBookingCount;
	String Modifiedroomprice;

	String EnterCurrency ;
	String Enterrooms;
	String roomType;
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
	String RoomRate;
	String GroupBlock_AfterReleaseinventorycount;
	@DataProvider
	public Object[][] Rategrid() throws IOException {
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray);
	}

	@DataProvider
	public Object[][] Group_Blocks() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Group_Blocks");

		return (testObjArray1);
	}
	@DataProvider
	public Object[][] AddnewRateplan() throws IOException
	{
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "AddNewRatePlan");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] ClassicFlow() throws IOException 
	{

		Object[][] testObjArray2 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray2);
	}

	
	
	@Test(dataProvider = "Group_Blocks",description="Verify Create Group Blocks")
	public void GroupBlocks(HashMap<String, String> h) throws InterruptedException, IOException 
	{
	
			Group_Blocks group=PageFactory.initElements(SeleniumRepo.driver, Group_Blocks.class);
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			
			test = extent.createTest(" Creating GroupBlock");
			logger.info("Creating GroupBlock");
		

			Errors=h.get("ErrorMesg").toString().trim();
			Name = h.get("Name").toString().trim();
			BlockCode = h.get("BlockCode").toString().trim();
			Shortdescription = h.get("Shortdescription").toString().trim();
			Detailed_description = h.get("Detailed_description").toString().trim();
			releasedate = h.get("releasedate").toString().trim();
			roomType=h.get("roomType").toString().trim();
			rateplan = h.get("Rateplan").toString().trim();
			Ratecode = h.get("Ratecode").toString().trim();
			Category = h.get("Category").toString().trim();
			ShortDescription = h.get("ShortDescription").toString().trim();
			imagePath = h.get("imagePath").toString().trim();
			EnterSelectedpolicyid = h.get("EnterSelectedpolicyid").toString().trim();
			AdditionalNotes = h.get("AdditionalNotes").toString().trim();
			AgentComment = h.get("AgentComment").toString().trim();
			RoomRate=h.get("RoomRate").toString().trim();


			group.click_ListAll();
			group.Delete_Group(Name);
			group.Click_Addnew();
			group.click_save();
			group.verify_ErrorMessages(Errors);
			group.click_cancel();
			group.Click_Addnew();
			group.verify_Groupblock_details();
			group.Enter_name(Name);
			group.Enter_Blockcode(BlockCode);
			group.Enter_ShortDescription(Shortdescription);
			group.Enter_Detailedescription(Detailed_description);
			group.Select_Rooms();
			group.Enter_releasedate(releasedate);
			group.Enter_checkSdate();
			group.Enter_CheckEdate(releasedate);
			group.click_save();
			group.click_Manageinvenotry(Name);
			group.Click_Submit();
			group.inventory();
			NewRategrid.Click_Update();
			group.click_ListAll();

			group.click_Manageinvenotry(Name);
			group.Click_Submit();
			GroupBlock_BeforeBookingcount=group.CurrentRooms_Count(roomType);
	}
	@Test(dataProvider = "AddnewRateplan",priority=2,description="Add New Rate Plan and Verify whether GropuBlock is Enabled or not",enabled=true)
	public void center(HashMap<String, String> h) throws InterruptedException, IOException {
		

			System.out.println("***********Add New Rate Plan and Verify whether GroupBlock is Enabled or not*********");
			logger.info("***********Add New Rate Plan and Verify whether GroupBlock is Enabled or not*********");
			//test.log(Status.INFO,"***********Add New Rate Plan and Verify whether FBP is Enabled or not*********");

			AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			
			test = extent.createTest("Add New Rate Plan and Verify whether FBP is Enabled or not");

			NewRatePlan.click_Rateplan();
			NewRatePlan.click_Listall();
			NewRatePlan.Name_Search(rateplan);
			NewRatePlan.delete_rateplan(rateplan);
			NewRatePlan.Click_Addnew();
			NewRatePlan.Enter_Name(rateplan);
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
			NewRatePlan.deriverates();
			NewRatePlan.verify_GroupBlock(Name);
			NewRatePlan.Rooms_inventory();
			NewRatePlan.notes(AdditionalNotes, AgentComment);
			NewRatePlan.click_save();

			NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown("All");

			NewRategrid.sync_offer("BAR", rateplan);

			NewRategrid.Click_Continue();

			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();

			NewRategrid.rate();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

	}

	@Test(dataProvider="ClassicFlow",priority=3,description="Booking,Modifying,Canceling a room",enabled=true)
	public void FBP_New_Modify_Change_Reservation(HashMap<String, String> h2) throws ParseException, IOException
	{


		logger.info("*****Group Block New Booking****");

		test = extent.createTest("*****Group Block New Booking****");
	
		
		RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
		ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
		ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

		ChangeReservation_BE ChangeReser=PageFactory.initElements(SeleniumRepo.driver, ChangeReservation_BE.class);
		CancelBooking_Standard CancelBooking=PageFactory.initElements(SeleniumRepo.driver, CancelBooking_Standard.class);
	
		Group_Blocks group=PageFactory.initElements(SeleniumRepo.driver, Group_Blocks.class);


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

		try 
		{

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

			Before_offerprice=classicFlowAvailPage.roomprice(roomType);

			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.SpecialRateplan_selection(rateplan);
			clasicflow.SpecialRateplantext_validation(rateplan);
			classicFlowAvailPage.click_CheckavailabitlityButton();

			After_offerprice=classicFlowAvailPage.roomprice(roomType);

			System.out.println("After room price is "+After_offerprice);
			classicFlowAvailPage.roomprice_validation(After_offerprice, Before_offerprice);

			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			/*Specialrates.special_offers(After_offerprice,rateplan);*/
			classicFlowReservationDet.verify_available_offers();
			classicFlowReservationDet.Verify_Reservationdetails();
			classicFlowReservationDet.checkbox();
			classicFlowReservationDet.Select_rateplan(rateplan);
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
			classicPaymentDet.Billing_Address(Address,Enterzipcode, Address2, Enterstate, Entercity);
			classicPaymentDet.contact(Enterphonenum);
			classicPaymentDet.payment();
			classicConfirmationPg.verify_Thanku_page();
			classicConfirmationPg.offercodevalidation_payment(rateplan);


			System.out.println("*****Group Block Modify Booking****");
			logger.info("*****Group Block Modify Booking****");

			test = extent.createTest("*****Group Block Modify Booking****");


			SeleniumRepo.driver.switchTo().window(ParentWindow);

			System.out.println(" Switched to Admin Window Successfully");

			System.out.println("Before Booking Rooms count is "+" "+GroupBlock_BeforeBookingcount);

			group.click_ListAll();

			group.click_Manageinvenotry(Name);
			group.Click_Submit();
			GroupBlock_AfterBookingCount=group.CurrentRooms_Count(roomType);

			System.out.println("After booking Rooms count is "+" "+GroupBlock_AfterBookingCount);	

			logger.info("After booking Rooms count is "+" "+GroupBlock_AfterBookingCount);

			NewRategrid.count_validation(GroupBlock_BeforeBookingcount, GroupBlock_AfterBookingCount);


			NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown("All");
			NewRategrid.Searchfield(rateplan);
			NewRategrid.select_offer(rateplan);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(rateplan);
			NewRategrid.Room_Type(roomType);
			NewRategrid.Room_Rate(RoomRate);
			NewRategrid.Quick_Entry();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

			SeleniumRepo.driver.switchTo().window(NewWindow);

			test = extent.createTest("Change Reservation");
			logger.info("Change Reservation");

			System.out.println("Switched to Booking Enginee Window Successfully");	
			logger.info("Switched to Booking Enginee Window Successfully");

			ChangeReser.Change_Reservation();
			//ChangeReser.Pricemodifycheck_standard(RoomType,RoomRate);

			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.SpecialRateplan_selection(rateplan);
			classicFlowAvailPage.click_CheckavailabitlityButton();
			Modifiedroomprice = classicFlowAvailPage.roomprice(roomType);

			System.out.println("Modified Room price is :"+Modifiedroomprice);

			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			classicFlowReservationDet.verify_available_offers();
			classicFlowReservationDet.Verify_Reservationdetails();
			classicFlowReservationDet.checkbox();
			classicFlowReservationDet.Select_rateplan(rateplan);
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

			group.click_ListAll();

			group.click_Manageinvenotry(Name);
			group.Click_Submit();
			String GroupBlock_AfterChangereservationCount=group.CurrentRooms_Count(roomType);

			System.out.println("After booking Rooms count is "+" "+GroupBlock_AfterBookingCount);


			System.out.println("After change reservation Room count is "+" "+GroupBlock_AfterChangereservationCount);

			logger.info("After change reservation Room count is "+" "+GroupBlock_AfterChangereservationCount);

			NewRategrid.count_validation(GroupBlock_AfterBookingCount, GroupBlock_AfterChangereservationCount);

			System.out.println("Rooms count is not reduced after change reservation");

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

			String AftercancelBooking=group.CurrentRooms_Count(roomType);

			System.out.println("After Cancel booking rooms count is "+" "+AftercancelBooking);	

			logger.info("After Cancel booking rooms count is "+" "+AftercancelBooking);

			NewRategrid.Cancel_CountValidation(GroupBlock_BeforeBookingcount, AftercancelBooking);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "Group_Blocks",priority=4,description="Verify the status after clicking Release unsold Inventory for all Rooms  with status “Manually released “ and also check the inventory is 0 or not.",enabled=false)
	public void Releaseinventory(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		try {
			
			Group_Blocks group=PageFactory.initElements(SeleniumRepo.driver, Group_Blocks.class);
			
			test = extent.createTest("Verify the status after clicking  Release unsold Inventory for all Rooms  with status “Manually released “ and also check the inventory is 0 or not.");
			logger.info("Verify the status after clicking  Release unsold Inventory for all Rooms  with status “Manually released “ and also check the inventory is 0 or not.");

			group.click_ListAll();
			group.click_releaseunsoldinventory(Name);
			group.click_Manageinvenotry(Name);
			group.Click_Submit();
			GroupBlock_AfterReleaseinventorycount=group.CurrentRooms_Count(roomType);
			if(GroupBlock_AfterReleaseinventorycount.equals("0"))
			{
				test.log(Status.PASS, "Unsold Inventory released successfully and inventory is showing as 0");
			}
			
		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
	@Test(dataProvider="ClassicFlow",priority=5,description="Release the unsold inventory Manually and verify whether the room is able to book or not",enabled=false)
	public void VerifyBE_Releaseinventory(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		try 
		{
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);

			test = extent.createTest("Release the  unsold inventory Manually and verify whether the room is able to book or not");
			logger.info("Release the unsold inventory Manually and verify whether the room is able to book or not");

			SeleniumRepo.driver.switchTo().window(NewWindow);
			

			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.SpecialRateplan_selection(rateplan);
			clasicflow.unavailability_popup();
			
		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
}
