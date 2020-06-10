package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.PaymentGateway;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_PaymentGateway extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "PaymetGateway");

		return (testObjArray);
	}


	@Test(priority = 1, enabled = true)
	public void editPaymentGateway() throws InterruptedException, IOException {

		try {
			PaymentGateway payment = PageFactory.initElements(SeleniumRepo.driver, PaymentGateway.class);

			test = extent.createTest("Payment Gateway Edit FOR PROPERTY");
			logger.info("Editing Payment Gateway for selected property ");

			payment.navigateToPaymentGateway_Pg();
			payment.editPayGateStatus("disable");
			//payment.editPaymentGateway("Select");
			payment.editPayGateMerchantId(" ");

			payment.editPayGateAccessCode(" ");
			payment.editPayGateApiVer(" ");
			//payment.editPayGateLocale("");
			payment.editPayGateSecureHash(" ");
			payment.editPayGatePaymentChargeUrl(" ");
			payment.editPayGateFeedbackUri(" ");

			payment.Click_PaymentGateUpdate();


		} catch (Exception e) {
			logger.error("Unable to Edit Payment Gateway property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to Edit Payment Gateway for selected property because of this execption" + e);
			/*
			 * finalAssertTrue(false, "Failed to Create Payment Gateway ");
			 */
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

	@Test(priority = 2, enabled = true, dataProvider = "dataSupplier")
	public void createPaymentGateway(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
			PaymentGateway payment = PageFactory.initElements(SeleniumRepo.driver, PaymentGateway.class);

			test = extent.createTest("Payment Gateway CREATION FOR PROPERTY");
			logger.info("Creating Payment Gateway for selected property ");

			String Payment = h.get("Payment").toString().trim();
			String MerchantID = h.get("MerchantID").toString().trim();
			String AccessCode = h.get("AccessCode").toString().trim();
			String APIVerison = h.get("APIVerison").toString().trim();
			String Language = h.get("Language").toString().trim();
			String SecureHashSecret = h.get("SecureHashSecret").toString().trim();
			String PaymentchargeURL = h.get("PaymentchargeURL").toString().trim();
			String FeedbackURI = h.get("FeedbackURI").toString().trim();

			payment.createPaymentGate(Payment, MerchantID, AccessCode, APIVerison, Language, SecureHashSecret,
					PaymentchargeURL, FeedbackURI);
			/*
			 * finalAssertTrue(true, "Payment Gateway Created successfully");
			 */
		} catch (Exception e) {
			logger.error("Unable to create Payment Gateway property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create Payment Gateway for selected property because of this execption" + e);
			/*
			 * finalAssertTrue(false, "Failed to Create Payment Gateway ");
			 */
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
}
