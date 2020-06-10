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
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

/**
 * This is a testcase class for ClassicFlow_PaymentDetailsPage.java. 
 * Currently in draft, but the goal of this testcase class is to test basic functionality of classic flow's payment 
 * details page
 * 
 * @author DM
 */
public class TC_ClassicFlow_PaymentDetailsPage extends BaseTest {
	
	
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	
	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray);
	}
	
	
	
	@Test(dataProvider = "dataSupplier",priority=1,description="Need to get pass the aviability and reservation page")
	public void transitionToPaymentDetails(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);

		test = extent.createTest("Creating clasicflow ");
		//logger.info("Creating clasicflow ");
		
		
		String Enterrooms = h.get("Enterrooms").toString().trim();
		String roomtype = h.get("roomtype").toString().trim();
		String FirstName = h.get("FirstName").toString().trim();
		String LastName = h.get("LastName").toString().trim();
		String Email = h.get("Email").toString().trim();
		
		
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
		
		
	}
	
	
	
	@Test(priority=2 , dataProvider = "dataSupplier")
	public void paymentPage(HashMap<String, String> h1) throws InterruptedException, IOException {
		
		
		ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);

		
		test = extent.createTest("Creating pp ");
		//logger.info("Creating clasicflow ");

		
		String Cardname = h1.get("Cardname").toString().trim();
		String Numberoncard = h1.get("Numberoncard").toString().trim();
		String Entercountry = h1.get("Entercountry").toString().trim();
		String Address = h1.get("Address").toString().trim();
		String Address2 = h1.get("Address2").toString().trim();
		String Entercity = h1.get("Entercity").toString().trim();
		String Enterstate = h1.get("Enterstate").toString().trim();
		String Enterzipcode = h1.get("Enterzipcode").toString().trim();
		String Enterphonenum = h1.get("Enterphonenum").toString().trim();
		
		
		
		classicPaymentDet.card_information();
		classicPaymentDet.card_name(Cardname);
		classicPaymentDet.Card_number(Numberoncard);
		classicPaymentDet.Expdate();
		classicPaymentDet.Country(Entercountry);
		classicPaymentDet.Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
		classicPaymentDet.contact(Enterphonenum);
		
		//classicPaymentDet.payment();
	
		
	}
	
	

}
