package Reusable_BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.BE.pom.ClassicFlow_ConfirmationPage;
import com.tt.BE.pom.ClassicFlow_PaymentDetailsPage;
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.admin.pom.ManageAccessCode;

import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_AccessCode_Booking extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String Before_offerprice;
	String After_offerprice;

	@DataProvider
	public Object[][] Rategrid() throws IOException {
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] Multiroom() throws IOException
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "Multiroom");

		return (testObjArray);
	}
	@Test(dataProvider = "Rategrid",priority=1,enabled=false)
	public void ManageAccessCode(HashMap<String, String> h) throws InterruptedException, IOException {

		try {
			
			ManageAccessCode accesscode =PageFactory.initElements(SeleniumRepo.driver, ManageAccessCode.class);
			
			test = extent.createTest("Manage Access Codes");

			String Rateplan = h.get("offer").toString().trim();
			
			accesscode.Click_ManageAccessCode();
			accesscode.Enter_Rateplan(Rateplan);
			accesscode.Select_Rateplan();
			accesscode.Rateplan_check(Rateplan);
			accesscode.Add_NewAccesscode();
			accesscode.Accesscode_Name(Rateplan);
			accesscode.Offer_default();
		}
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
	
	@Test(dataProvider = "Multiroom",priority=2)
	public void AccessCodeBooking(HashMap<String, String> h) throws InterruptedException, IOException {

		try {
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);
			ClassicFlow_PaymentDetailsPage  classicPaymentDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_PaymentDetailsPage.class);
			ClassicFlow_ConfirmationPage  classicConfirmationPg = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ConfirmationPage.class);


			test = extent.createTest("AccessCode Booking");
			logger.info("AccessCode Booking");


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
			String RatePlan=h.get("Special and offer code").toString().trim();

			logger.info("Opening New Window ");
			test.log(Status.INFO, "Opening New Window");

			windowid();
			SeleniumRepo.driver.switchTo().window(NewWindow);
			System.out.println(" Switched to Booking Enginee Window Successfully");
            Thread.sleep(8000);

			String accesscode=ManageAccessCode.Accesscode;
			System.out.println("accesscode is "+accesscode);

			clasicflow.GoToUrl();
			Thread.sleep(8000);
			clasicflow.verify_mybooking();
 			

			
			

			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			classicFlowAvailPage.Accesscode_sendkeys(accesscode);
			clasicflow.currencydropdown();

			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			classicFlowAvailPage.select_Rooms(Enterrooms);

			Before_offerprice=classicFlowAvailPage.roomprice(roomtype);
			//classicFlowAvailPage.Click_SpecialRate();
			//classicFlowAvailPage.SpecialRateplan_Validation();
			//classicFlowAvailPage.Click_Done();
			
			After_offerprice=classicFlowAvailPage.roomprice(roomtype);
			classicFlowAvailPage.roomprice_validation(After_offerprice, Before_offerprice);
			//classicFlowAvailPage.click_CheckavailabitlityButton();
			classicFlowAvailPage.selectroom();
			//classicFlowAvailPage.selectroom();
			System.out.println("Im before bookroom method");
			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			//classicFlowReservationDet.offersat_Reservationpage(After_offerprice,RatePlan);
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
			classicConfirmationPg.offercodevalidation_payment(RatePlan);
		}
		catch (Exception e) 
		{
			logger.error("Unable to do Access Code Booking  " + e);
			test.log(Status.ERROR, "Unable to do Access Code Booking " + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

	}

}
