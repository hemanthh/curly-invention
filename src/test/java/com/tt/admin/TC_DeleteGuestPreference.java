package com.tt.admin;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.DeleteGuestPreference;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class TC_DeleteGuestPreference extends BaseTest{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	
	
	@Test
	public void deleteGPQuestion() throws InterruptedException, IOException {
		try {
			DeleteGuestPreference delete = PageFactory.initElements(SeleniumRepo.driver, DeleteGuestPreference.class);
			
			test = extent.createTest("Deleting Guest Preference CREATION FOR PROPERTY");
			logger.info("Deleting Guest Preference for selected property ");
			
			delete.delete();
			
			
		} catch (Exception e) {
			logger.error("Unable to Delete Guest Preference property because of this execption" + e);
			test.log(Status.ERROR, "Unable to Delete Guest Preference for selected property because of this execption" + e);
			e.printStackTrace();

		}}
	
}
