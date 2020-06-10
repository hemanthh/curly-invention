/**
 * 
 */
package Reusable_BE;

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
 * @author DM
 * 
 * TODO: Need to actually make this TC class into an appropriate reusable class by 
 * giving it the ability to be used by any property and adding test cases that will 
 * show the changes made on the admin side  are properly reflected on the BE.
 * 
 * Currently the this class only covers the automation of the Extra Information section on
 * the reservation details page. 
 *
 */
public class TC_GuestPreferenceQuestion_Booking extends BaseTest {
	
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	
	@DataProvider
	public Object[][] ClassicFlow() throws IOException {

		Object[][] testObjArray2 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray2);
	}
	

	@Test(priority = 2,enabled = true,dataProvider = "ClassicFlow",description="Standard New,Modify,Cancel Booking")
	public void Admin(HashMap<String, String> h2) throws InterruptedException, IOException {
		
		try{
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
			ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
			ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);


			test = extent.createTest("BookingEngine ClassicFlow");
			logger.info("BookingEngine ClassicFlow");

			logger.info("Opening New Window ");
			windowid();
			SeleniumRepo.driver.switchTo().window(NewWindow);

			logger.info("Switched to Booking Enginee Window Successfully ");

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


			clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			classicFlowAvailPage.select_Rooms(Enterrooms);
			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.Click_Done();
			//classicFlowAvailPage.click_CheckavailabitlityButton();
			//classicFlowAvailPage.room_type(roomtype);
			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			classicFlowReservationDet.verify_available_offers();
			classicFlowReservationDet.Verify_Reservationdetails();
			classicFlowReservationDet.checkbox();
			classicFlowReservationDet.First_name(FirstName);
			classicFlowReservationDet.Last_Name(LastName);
			classicFlowReservationDet.Email(Email);
			classicFlowReservationDet.extra_inforamtion();
			
			/*
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
			
			*/

			
			
			
			
		}catch (Exception e) 
		{
			logger.error("Unable to create modify/Cance Bookings because of this exception " + e);
			e.printStackTrace();

		}
		
		
	}


}
