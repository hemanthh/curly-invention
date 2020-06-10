/**
 * 
 */
package com.tt.admin;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.CardSurcharge;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

/**
 * @author DM
 *
 */
public class TC_CardSurcharge  extends BaseTest {
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	
	
	
	@Test(priority = 1, enabled = true)
	public void editPaymentGateway() throws InterruptedException, IOException {

		try {
			CardSurcharge surchargeCard = PageFactory.initElements(SeleniumRepo.driver, CardSurcharge.class);

			test = extent.createTest("Card Surcharge Edit FOR PROPERTY");
			logger.info("Editing Card Surcharge for selected property ");

			
			surchargeCard.enableCardSurcharge();

			surchargeCard.navigateToCardSurcharge_Pg();

			surchargeCard.editCardSurchargeCardStatus("enable");
			
			surchargeCard.editCardSurchargeCardType("Diners Club");
			
			surchargeCard.editCardSurchargeAmount("34");

			surchargeCard.editCardSurchargeType("Percentage");
			
			surchargeCard.CardSurchargeSaveButton();


		} catch (Exception e) {
			logger.error("Unable to Edit Card Surcharge for property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to Edit Surcharge for selected property because of this execption" + e);

			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

}
