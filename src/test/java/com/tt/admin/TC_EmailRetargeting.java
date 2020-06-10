/**
 * 
 */
package com.tt.admin;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.EmailRetargeting;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * 
 * 
 * @author DM
 *
 */
public class TC_EmailRetargeting  extends BaseTest {
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AboutPDining");

		return (testObjArray);
	}
	
	
	@Test(priority=1, enabled=true , description = "Making Edits to the Email Retargeting fields and canceling changes" )
	public void emailRetargetingCancelChanges() throws InterruptedException, IOException {
		
		
		try {
			
			test = extent.createTest("TT Email Retargeting Cancel Changes");

			
			EmailRetargeting CreatedEmailRetargeting = PageFactory.initElements(SeleniumRepo.driver, EmailRetargeting.class);

			
			
			CreatedEmailRetargeting.navigateToEmailRetargeting_Pg();
			
			SeleniumRepo.waitForPageLoaded();

			
			CreatedEmailRetargeting.clickGeneralOptDisabledButton();

			CreatedEmailRetargeting.clickGeneralOptEnabledButton();
			
			CreatedEmailRetargeting.clickGeneralOptdUpdateEnableButton("Disable for Selected Rate Codes only");

			CreatedEmailRetargeting.editGeneralOptEnterRateCodes("comlem");
			
			CreatedEmailRetargeting.editGeneralOptTimeLapse("0.01");
			
			CreatedEmailRetargeting.clickRatePlanEnabled("disable");
			
			CreatedEmailRetargeting.clickRatePlanEnabled("enable");
			
			CreatedEmailRetargeting.editRatePlanExpiartionTime("12");
			
			//CreatedEmailRetargeting.clickRatePlanRateCompoundAccessCode();

			CreatedEmailRetargeting.clickRatePlanRateCode();
			
			CreatedEmailRetargeting.editRatePlanRateOrCompoundCode("HI");
			
			CreatedEmailRetargeting.editEmailOptGreeting("Hey Homie");
			
			CreatedEmailRetargeting.editEmailOptGreetingNameTypeSelection("First Name");
			
			CreatedEmailRetargeting.editEmailOptSubject("Sugar Zaddy wants to buy you a Trip");
			
			CreatedEmailRetargeting.editEmailOptEmailBody("OMG SIDE WALKS");
			
			/*
			 
			 Color section on email re-targeting page only works for chrome.
			 edge and firefox are unable to interact with the text fields
			 
			 
			CreatedEmailRetargeting.editCustomOptOverallBackColor("EEB74A");
			CreatedEmailRetargeting.editCustomOptOverallFontColor("6500B3");
			CreatedEmailRetargeting.editCustomOptResSummaryBackColor("BBA5AF");
			CreatedEmailRetargeting.editCustomOptResSummaryFontColor("4C38FF");
			CreatedEmailRetargeting.editCustomOpBookItBttBackColor("FF6EA8");
			CreatedEmailRetargeting.editCustomOpBookItBttFontColor("808080");
			
			
				*/
	
			CreatedEmailRetargeting.editCustomOpBookItBttLabel("Hit Dat");
			
			CreatedEmailRetargeting.clickCustomOpBookItBttResetButton();

			CreatedEmailRetargeting.clickEmailRetargetingCancelButton();		
			
			SeleniumRepo.waitForPageLoaded();

			
		}
		catch (Exception e) 
		{
			logger.error("Unable to  Email Retargeting " + e);
			test.log(Status.ERROR, "Unable to create  Email Retargeting " + e);
			e.printStackTrace();
			/*finalAssertTrue(true,"Failed to select Near By Dining ");*/
			
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
		
	}
	
	
	@Test(priority=2, enabled=true , description = "Making Edits to the Email Retargeting Page fields and saving changes" )
	public void emailRetargetingSaveChanges() throws InterruptedException, IOException {
		
		
	try {
			
		
		test = extent.createTest("TT Email Retargeting Save Changes");

			EmailRetargeting CreatedEmailRetargeting = PageFactory.initElements(SeleniumRepo.driver, EmailRetargeting.class);
			
			
			
			CreatedEmailRetargeting.navigateToEmailRetargeting_Pg();
			
			SeleniumRepo.waitForPageLoaded();

			
			CreatedEmailRetargeting.clickGeneralOptdUpdateEnableButton("Disable for Selected Rate Codes only");

			CreatedEmailRetargeting.editGeneralOptEnterRateCodes("comlem");
			

			CreatedEmailRetargeting.clickGeneralOptEnabledButton();

			
			CreatedEmailRetargeting.editGeneralOptTimeLapse("0.001");
			
			
			/*
			 
			 Color section on email re-targeting page only works for chrome.
			 edge and firefox are unable to interact with the text fields
			 
			CreatedEmailRetargeting.editCustomOptOverallBackColor("EEB74A");
			CreatedEmailRetargeting.editCustomOptOverallFontColor("6500B3");
			CreatedEmailRetargeting.editCustomOptResSummaryBackColor("BBA5AF");
			CreatedEmailRetargeting.editCustomOptResSummaryFontColor("4C38FF");
			CreatedEmailRetargeting.editCustomOpBookItBttBackColor("FF6EA8");
			CreatedEmailRetargeting.editCustomOpBookItBttFontColor("808080");
			
			*/
			CreatedEmailRetargeting.editCustomOpBookItBttLabel("Hit Dat");
			
			CreatedEmailRetargeting.clickEmailRetargetingSaveButton();
			SeleniumRepo.waitForPageLoaded();
			
			//reset coolors
			CreatedEmailRetargeting.navigateToEmailRetargeting_Pg();
			
			CreatedEmailRetargeting.clickCustomOpBookItBttResetButton();
			
			CreatedEmailRetargeting.clickEmailRetargetingSaveButton();
			
			SeleniumRepo.waitForPageLoaded();

			
			
	}
	catch (Exception e) 
	{
		logger.error("Unable to  Email Retargeting " + e);
		test.log(Status.ERROR, "Unable to create  Email Retargeting " + e);
		e.printStackTrace();
		/*finalAssertTrue(true,"Failed to select Near By Dining ");*/
		
		e.printStackTrace();
		Assert.assertEquals(false, true);
	}

			
		
		
	}
		
	
	

}
