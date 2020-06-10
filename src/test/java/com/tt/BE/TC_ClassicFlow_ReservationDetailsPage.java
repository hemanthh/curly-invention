/**
 * 
 */
package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

/**
 * This is a testcase class for ClassicFlow_ReservationDetailsPage.java. 
 * Currently in draft, but the goal of this testcase class is to test basic functionality of classic flow's reservation 
 * details page 
 * 
 * @author DM
 *
 */
public class TC_ClassicFlow_ReservationDetailsPage extends BaseTest {
	
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	

	
	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray);
	}
	
	
	
	@Test(dataProvider = "dataSupplier",priority=1,description="Need to get pass the aviability page")
	public void transitionToReservationDetails(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
		
		test = extent.createTest("Creating clasicflow ");
		//logger.info("Creating clasicflow ");
		
		
		String Enterrooms = h.get("Enterrooms").toString().trim();
		String roomtype = h.get("roomtype").toString().trim();
		
		
		clasicflow.GoToUrl();
		System.out.println("We here");
		classicFlowAvailPage.verify_mybooking();
		System.out.println("We here 3");

		classicFlowAvailPage.currencydropdown();
		classicFlowAvailPage.arrival_date();
		classicFlowAvailPage.departure_date();
		classicFlowAvailPage.popup_ok();
		classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
		classicFlowAvailPage.select_Rooms(Enterrooms);
		classicFlowAvailPage.room_type(roomtype);
		classicFlowAvailPage.BookRoom();
		
		
		
	}
	
	
	
	@Test(priority=2 , dataProvider = "dataSupplier")
	public void reservationPage(HashMap<String, String> h1) throws InterruptedException, IOException {
		System.out.println("We here 4");

		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);

		String FirstName = h1.get("FirstName").toString().trim();
		String LastName = h1.get("LastName").toString().trim();
		String Email = h1.get("Email").toString().trim();
		
		classicFlowReservationDet.verify_Headingrooms();
		classicFlowReservationDet.verify_available_offers();
		//GrandTotal=classicFlowReservationDet.Verify_Reservationdetails();
		//clasicflow.checkbox();
		
		
		classicFlowReservationDet.First_name(FirstName);
		classicFlowReservationDet.Last_Name(LastName);
		classicFlowReservationDet.Email(Email);
		classicFlowReservationDet.extra_inforamtion();//look into this method
		classicFlowReservationDet.confirmation();
		
	}
	

}
