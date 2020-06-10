package com.tt.admin;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.IndependentHotels;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class TC_IndependentHotel extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	
	@Test
	public void creatIndependentHotel() throws InterruptedException, IOException {
		try {
			IndependentHotels ClickIndHotel= PageFactory.initElements(SeleniumRepo.driver, IndependentHotels.class);

			test = extent.createTest("Clcik On Independent Hotel Link");
			logger.info("Clcik On Independent Hotel Link ");

			ClickIndHotel.createIndependentHotel();
	

		} catch (Exception e) {
			logger.error("Unable to create room type for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create room type for selected property because of this execption" + e);
			e.printStackTrace();

		}
	
}}
