/**
 * 
 */
package com.tt.BE;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

/**
 * This is a testcase class for ClassicFlow_AvailPag.java
 * Currently in draft, but the goal of this testcase class is to test all
 * basics of the availability/landing page of the classic flow BE
 * 
 * @author DM
 *
 */
public class TC_ClassicFlow_AvailPage extends BaseTest  {
	
	
	public String EnterValue;
	public String RoomType;
	public String GrandTotal;
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray);
	}
	
	
	
	@Test(dataProvider = "dataSupplier",priority=2)
	public void availabilityPage(HashMap<String, String> h) throws InterruptedException, IOException {
	
		
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvail = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
		
		test = extent.createTest("Creating clasicflow ");
		logger.info("Creating clasicflow ");

	
			String Enterrooms = h.get("Enterrooms").toString().trim();
			String roomtype = h.get("roomtype").toString().trim();
		
			logger.info("Browser Opened");
		/*clasicflow.clasic(EnterCurrency,Enterrooms,roomtype,FirstName,LastName,Email,Cardname,
				Numberoncard,Entercountry,Address,Address2,Entercity,Enterstate, Enterzipcode,Enterphonenum);*/
		
		
		clasicflow.GoToUrl();
		classicFlowAvail.verify_mybooking();
		classicFlowAvail.currencydropdown();
		
		try {
			
			classicFlowAvail.arrival_date("05/21/2019");
			classicFlowAvail.departure_date("05/23/2019");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		classicFlowAvail.popup_ok();
		classicFlowAvail.Rooms_and_Guests(Enterrooms);
		classicFlowAvail.select_Rooms(Enterrooms); //Enterrooms
		
		
		System.out.println("TC_ClassicFlow_avil after select rooms ");
		
		
		//This testcase currently breaks after "select_rooms". Need to get landing page classic flow to get to 
		//the reservation details page thus allowing me to create and test the remaining refactoring pages
		
		//TODO: figure out how to get the "Special Rate" popup to work
		//classicFlowAvail.Click_SpecialRate(); 
		//classicFlowAvail.SpecialRateplan_Validation();
		//classicFlowAvail.Click_Done();
		
		System.out.println("TC_ClassicFlow_avil after Special Rate "); //current issue is with checkavil()

		//classicFlowAvail.click_CheckavailabitlityButton(); {should create a separate TC class for check avail }
		classicFlowAvail.room_type(roomtype);
		classicFlowAvail.BookRoom();
	
}
	
	
	//@Test(dataProvider = "dataSupplier",priority=3)
	public void troll(HashMap<String, String> h2) throws InterruptedException, IOException {
	
		
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvail = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);		
		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
		ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
		ClassicFlow_ConfirmationPage  classicConfirmation = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

		
		
		
		test = extent.createTest("Creating clasicflow ");
		logger.info("Creating clasicflow ");

	
			String Enterrooms = h2.get("Enterrooms").toString().trim();
			String roomtype = h2.get("roomtype").toString().trim();
			String FirstName = h2.get("FirstName").toString().trim();
			String LastName = h2.get("LastName").toString().trim();
			String Email = h2.get("Email").toString().trim();
			String Cardname = h2.get("Cardname").toString().trim();
			String Numberoncard = h2.get("Numberoncard").toString().trim();
			String Entercountry = h2.get("Entercountry").toString().trim();
			String Address = h2.get("Address").toString().trim();
			String Address2 = h2.get("Address2").toString().trim();
			String Entercity = h2.get("Entercity").toString().trim();
			String Enterstate = h2.get("Enterstate").toString().trim();
			String Enterzipcode = h2.get("Enterzipcode").toString().trim();
			String Enterphonenum = h2.get("Enterphonenum").toString().trim();
			logger.info("Browser Opened");
		/*clasicflow.clasic(EnterCurrency,Enterrooms,roomtype,FirstName,LastName,Email,Cardname,
				Numberoncard,Entercountry,Address,Address2,Entercity,Enterstate, Enterzipcode,Enterphonenum);*/
		
		
		

		System.out.println("On Reservation Details Page ");
		classicFlowReservationDet.verify_Headingrooms();
		classicFlowReservationDet.verify_available_offers();
		GrandTotal=classicFlowReservationDet.Verify_Reservationdetails();
		//clasicflow.checkbox();
		
		
		classicFlowReservationDet.First_name(FirstName);
		classicFlowReservationDet.Last_Name(LastName);
		classicFlowReservationDet.Email(Email);
		classicFlowReservationDet.extra_inforamtion();//look into this method
		classicFlowReservationDet.confirmation();
		
		classicPaymentDet.card_information();
		classicPaymentDet.card_name(Cardname);
		classicPaymentDet.Card_number(Numberoncard);
		classicPaymentDet.Expdate();
		classicPaymentDet.Country(Entercountry);
		classicPaymentDet.Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
		classicPaymentDet.contact(Enterphonenum);
		
		classicPaymentDet.payment();

		
		classicConfirmation.verify_Thanku_page();

		
		
		/*
		
		*/
		
		
		
	
}
	
	

}
