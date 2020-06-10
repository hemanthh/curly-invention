package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tt.BE.TC_CompoundAccessCodeBooking;
import com.tt.admin.pom.Interactive_Reports;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class TC_InteractiveReports_ComoundAccess extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	@Test(priority = 1,description="")
	public void rategrid() throws InterruptedException, IOException 
	{
		try 
		{
			Interactive_Reports Interactive_Reports =PageFactory.initElements(SeleniumRepo.driver, Interactive_Reports.class);
			TC_CompoundAccessCodeBooking TC_CompoundAccessCodeBooking=PageFactory.initElements(SeleniumRepo.driver, TC_CompoundAccessCodeBooking.class);
			test = extent.createTest("Verifying the Compound Access Code Tracing Name in Rate plan Access code Analysis");
			logger.info("Verifying the Compound Access Code Tracing Name in Rate plan Access code Analysis");
			
			Interactive_Reports.Click_InteractiveReporting();
			Interactive_Reports.Click_RatePlanAccessCode();
			Interactive_Reports.Enter_BookingFromDate();
			Interactive_Reports.Enter_BookingToDate();
			Interactive_Reports.Click_RunReport();
			Interactive_Reports.verify_TrackingCodeNames(TC_CompoundAccessCodes.CompoundAccesscode, TC_CompoundAccessCodeBooking.GrandTotal);
		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
}
