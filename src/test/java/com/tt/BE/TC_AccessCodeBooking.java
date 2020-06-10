package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
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

public class TC_AccessCodeBooking extends BaseTest
{
	String Before_offerprice;
	String After_offerprice;


	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "Multiroom");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier")
	public void offercode(HashMap<String, String> h) throws InterruptedException, IOException {

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


			String accesscode=ManageAccessCode.Accesscode;
			System.out.println("accesscode is "+accesscode);

			clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			classicFlowAvailPage.select_Rooms(Enterrooms);

			Before_offerprice=classicFlowAvailPage.roomprice(roomtype);
			classicFlowAvailPage.Click_SpecialRate();
			classicFlowAvailPage.SpecialRateplan_Validation();
			classicFlowAvailPage.Click_Done();
			classicFlowAvailPage.Accesscode_sendkeys(accesscode);
			
			After_offerprice=classicFlowAvailPage.roomprice(roomtype);
			classicFlowAvailPage.roomprice_validation(After_offerprice, Before_offerprice);
			classicFlowAvailPage.selectroom();
			classicFlowAvailPage.BookRoom();
			clasicflow.verify_Headingrooms();
			classicFlowReservationDet.offersat_Reservationpage(After_offerprice,RatePlan);
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

		}

	}
}
