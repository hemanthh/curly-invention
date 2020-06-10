package com.tt.admin;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.IndependentHotels;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class TC_Create_IndependentHotel extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	
	@Test
	public void creatIndependentHotel() throws InterruptedException, IOException {
		try {
			
			IndependentHotels ClickIndHotel= PageFactory.initElements(SeleniumRepo.driver, IndependentHotels.class);

			test = extent.createTest("Clcik On Independent Hotel Link");
			logger.info("Clcik On Independent Hotel Link ");

			ClickIndHotel.createIndependentHotel();
			/*finalAssertTrue(false,
				    "Independent hotel selected successfully");*/

		} catch (Exception e) {
			logger.error("Failed to select Independent Hotel" + e);
			test.log(Status.FAIL, "Failed to select Independent Hotel" + e);
			/*finalAssertTrue(false,
				    "Failed to select Independent Hotel");*/
			e.printStackTrace();

		}
	
}}
