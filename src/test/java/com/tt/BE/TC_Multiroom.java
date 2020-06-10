package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;



public class TC_Multiroom extends BaseTest 
{
	String EnterValue;
	String RoomType;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "Multiroom");

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
			
			login_Brand_Property();
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
			Assert.assertEquals(false,true);
		}
	}
*/	
	
	@Test(priority=1, enabled = true, dataProvider = "dataSupplier")
	public void Flow(HashMap<String, String> h) throws InterruptedException, IOException {

			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
			ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
			ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);


			test = extent.createTest("Creating multiroom Booking");
			logger.info("Creating multiroom Booking ");

			String Enterrooms = h.get("Enterrooms").toString().trim();
			String roomtype = h.get("roomtype").toString().trim();
			String FirstName = h.get("FirstName").toString().trim();
			String LastName = h.get("LastName").toString().trim();
			String Email = h.get("Email").toString().trim();
			String Cardname = h.get("Cardname").toString().trim();
			String Numberoncard = h.get("Numberoncard").toString().trim();
			String Entercountry = h.get("Entercountry").toString().trim();
			String Address = h.get("Address").toString().trim();
			String Address2 = h.get("Address2").toString().trim();
			String Entercity = h.get("Entercity").toString().trim();
			String Enterstate = h.get("Enterstate").toString().trim();
			String Enterzipcode = h.get("Enterzipcode").toString().trim();
			String Enterphonenum = h.get("Enterphonenum").toString().trim();
			logger.info("Browser Opened");

            try {
			clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			//classicFlowAvailPage.select_Rooms(Enterrooms);
			classicFlowAvailPage.roomselectiondone.click();
			classicFlowAvailPage.click_CheckavailabitlityButton();
			
			/*Commenting out the below lines because it delayed the execution of the selectroom method*/
			//classicFlowAvailPage.Click_SpecialRate();
			//classicFlowAvailPage.SpecialRateplan_Validation();
			//classicFlowAvailPage.Click_Done();
			//classicFlowAvailPage.room_type(roomtype);
			classicFlowAvailPage.selectroom();
			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
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
			Thread.sleep(5000);
	}
            catch(Exception e)
            {
            	e.printStackTrace();
            	Assert.assertEquals(false,true);
            }
	}
}
