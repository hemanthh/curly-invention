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
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

/**
 * This is a testcase class for ClassicFlow_ConfirmationPage.java. 
 * Currently in draft, but the goal of this testcase class is to test basic functionality of classic flow's confirmation 
 * page
 * 
 * @author DM
 *
 */
public class TC_ClassicFlow_ConfirmationPage extends BaseTest {
	
	
Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	
	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray);
	}
	
	
	
	@Test(dataProvider = "dataSupplier",priority=1,description="Need to get pass the aviability and reservation page")
	public void transitionToConfirmationPg(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
		ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);

		test = extent.createTest("Creating clasicflow ");
		//logger.info("Creating clasicflow ");
		
		
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
		
		
		
		classicFlowReservationDet.verify_Headingrooms();
		classicFlowReservationDet.verify_available_offers();
		//GrandTotal=classicFlowReservationDet.Verify_Reservationdetails();
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
	
		
		
	}
	
	
	
	@Test(priority=2 , dataProvider = "dataSupplier")
	public void paymentPage(HashMap<String, String> h1) throws InterruptedException, IOException {
		
	
		
		test = extent.createTest("Creating pp ");
		//logger.info("Creating clasicflow ");

		ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);

		
		classicConfirmationPg.verify_Thanku_page();
		
		
		System.out.println("We here 5");


		
		
		
	
		
	}
	

}
