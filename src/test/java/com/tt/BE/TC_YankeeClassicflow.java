package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.tt.BE.pom.Yankee_ClassicFlow;

import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_YankeeClassicflow extends BaseTest
{
	String EnterValue;
	String RoomType;
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
/*	
	@Test(priority = 1,enabled = false,dataProvider = "RateGrid",description="Rooms Count Before Room Reservation")
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
		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
	*/
	
	@Test(dataProvider = "dataSupplier",priority=1)
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException {
	
		try {
			Yankee_ClassicFlow  Yankee =PageFactory.initElements(SeleniumRepo.driver, Yankee_ClassicFlow.class);
			
		
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
			
			logger.info("Browser Opened");
			
			Yankee.GoToUrl();
			Yankee.currencydropdown();
			Yankee.arrival_date();
			Yankee.departuredate();
			Yankee.popup_ok();
			//Yankee.ChooseGuests();
			//Yankee.select_Members(Enterrooms);
			
			//Yankee.offers();
			//Yankee.offerscode_Validation();
			//Yankee.Specialdone();
			Yankee.checkavailabitlity();
			Yankee.BookNow();
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
		

		} catch (Exception e) {
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();

		}
}
}
