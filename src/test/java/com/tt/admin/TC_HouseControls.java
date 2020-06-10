package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.HouseControls;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_HouseControls extends BaseTest
{
	String days;
	String CloseControl;
	String SelectRateplan;
	String OpenControl;
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] House_Controls() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"House Controls");

		return (testObjArray);
	}
	@Test(dataProvider = "House_Controls",priority=1,description="Closing all the rate/room using House Control ")
	public void HouseControl(HashMap<String, String> h) throws Exception 
	{
		try 
		{
			HouseControls HouseControls =PageFactory.initElements(SeleniumRepo.driver, HouseControls.class);


			 days= h.get("Days").toString().trim();
			 CloseControl = h.get("CloseControl").toString().trim();
			 OpenControl = h.get("OpenControl").toString().trim();
			 SelectRateplan = h.get("SelectRateplan").toString().trim();

	
			test = extent.createTest("Closing  all the rate/room using House Control");
			logger.info("Closing  all the rate/room using House Control");
			
			HouseControls.click_HouseControls();
			HouseControls.HouseControl_Startdate();
			HouseControls.HouseControl_Enddate();
			HouseControls.Apply_To(days);
			HouseControls.Select_radio_Controls(CloseControl);
			HouseControls.Select_Rateplans_Rooms(SelectRateplan);
			HouseControls.Click_ApplyControl();
			
			//Write code for Email Update in House Control
					
		} 
		catch (Exception e) 
		{
			logger.error("Unable to Close rate/room using House Control because of this execption" + e);
			test.log(Status.FAIL, "Unable to Close rate/room using House Control because of this execption" + e);
			Assert.assertEquals(false, true);
			e.printStackTrace();

		}
	}
	@Test(dataProvider = "House_Controls",enabled=false,description="Open all the rate/room using House Control ")
	public void OPENHouseControl(HashMap<String, String> h) throws Exception 
	{
		try 
		{
			HouseControls HouseControls =PageFactory.initElements(SeleniumRepo.driver, HouseControls.class);
	
			test = extent.createTest("Open  all the rate/room using House Control");
			logger.info("Open  all the rate/room using House Control");
			
			HouseControls.click_HouseControls();
			HouseControls.HouseControl_Startdate();
			HouseControls.HouseControl_Enddate();
			HouseControls.Apply_To(days);
			HouseControls.Select_radio_Controls(OpenControl);
			HouseControls.Select_Rateplans_Rooms(SelectRateplan);
			HouseControls.Click_ApplyControl();
			
			
					
		} 
		catch (Exception e) 
		{
			logger.error("Unable to Close rate/room using House Control because of this execption" + e);
			test.log(Status.FAIL, "Unable to Close rate/room using House Control because of this execption" + e);
			Assert.assertEquals(false, true);
			e.printStackTrace();

		}
	}

	
}
