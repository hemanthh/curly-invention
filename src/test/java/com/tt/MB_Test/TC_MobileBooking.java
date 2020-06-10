package com.tt.MB_Test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.MB.MobileBooking;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_MobileBooking extends BaseTest
{
	String EnterValue;
	String RoomType;
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "MobileBooking");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] RateGrid() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}
	@Test(dataProvider = "RateGrid",priority=1,enabled=false)
	public void Rates(HashMap<String, String> h1) throws InterruptedException, IOException 
	{

		try {

			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

			test = extent.createTest("Mobile Booking");
			logger.info("Mobile Booking");
			EnterValue = h1.get("EnterValue").toString().trim();
			RoomType=h1.get("RoomType").toString().trim();


			logger.info("Browser Opened");

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
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "dataSupplier",priority=2,enabled=true)
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException {

		try {
			MobileBooking  mobile =PageFactory.initElements(SeleniumRepo.driver, MobileBooking.class);

			test = extent.createTest("Booking a room with mobile ");
			logger.info("Booking a room with mobile");

			
			
			String roomtype = h2.get("roomtype").toString().trim();
			String FirstName = h2.get("FirstName").toString().trim();
			String Email = h2.get("Email").toString().trim();
			String Cardname = h2.get("Cardname").toString().trim();
			String Numberoncard = h2.get("Numberoncard").toString().trim();
			String Entercountry = h2.get("Entercountry").toString().trim();
			String Address = h2.get("Address").toString().trim();
			String Entercity = h2.get("Entercity").toString().trim();
			String Enterstate = h2.get("Enterstate").toString().trim();
			String Enterzipcode = h2.get("Enterzipcode").toString().trim();
			String Enterphonenum = h2.get("Enterphonenum").toString().trim();

			logger.info("Browser Opened");
			
			mobile.GoToUrl();
			mobile.popup_ok();
			mobile.Menu();
			mobile.Verify_language();
			mobile.close();
			/*mobile.Menu();
			mobile.Verify_Currencylink();
			mobile.close();
			mobile.Menu();
			mobile.verify_reservationslink();
			mobile.close();
			mobile.Menu();
			mobile.Verify_Hoteldetails();
			mobile.close();
			mobile.Menu();
			mobile.Map();
			mobile.close();
			mobile.Menu();
			mobile.Verify_photos();
			mobile.close();
			mobile.verify_guest_searchoffers();*/
			mobile.arrivaldate();
			mobile.departuredate();
			mobile.Verify_Bestprice();
			mobile.verify_ResetButton();
			mobile.Select_Room();
			mobile.RoomLink(roomtype);
			mobile.verify_Room_date_Readmore(roomtype);
			mobile.Bar_radio();
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
			mobile.confirmationcode();
			
			
		}
		catch (Exception e) 
		{
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();

		}
	}
}