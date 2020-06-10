package com.tt.admin;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tt.admin.pom.DeleteChannel;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

/**
 * 
 * @author TT072 This test case deletes existing property channel
 */
@Test
public class TC_Delete_Property_Channel extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@Test(groups = {"SMOKE"}, enabled = true )
	public void deleteChannel() throws InterruptedException {

		try {
				DeleteChannel dltChannel = PageFactory.initElements(SeleniumRepo.driver, DeleteChannel.class);

			test = extent.createTest("TT DELETE EXISTING PROPERTY CHANNEL");
			logger.info("Deleting existing property channel");

			System.out.println("----------------------------------------");
			dltChannel.deleteChannel();
			/*finalAssertTrue(true,
				    "Property channel is created successfully");*/
		} catch (Exception e) {
			logger.error("Unable to delete property channel because of this execption" + e);
			/*finalAssertTrue(false, "Failed to Create property");*/
			e.printStackTrace();
		}

	}

}
