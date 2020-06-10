package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openqa.grid.internal.listeners.Prioritizer;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AddNewRatePlan;
import com.tt.admin.pom.CompoundAccessCodes;
import com.tt.admin.pom.PropertyDefaults;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_CompoundAccessCodes extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	public static String Rateplan1;
	public static String Rateplan2;
	public static String CompoundAccesscode;

	@DataProvider
	public Object[][] AddNewRatePlan() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AddNewRatePlan");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] Rategrid() throws IOException {
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray);
	}

	@Test(dataProvider = "AddNewRatePlan",description="Verify Compound Access Codes Link under RatePlans And Add",priority=1)
	public void propertyRoom(HashMap<String, String> h) throws InterruptedException, IOException 
	{

		try {

			CompoundAccessCodes  CompoundAccessCodes =PageFactory.initElements(SeleniumRepo.driver, CompoundAccessCodes .class);
			PropertyDefaults PropertyDefaults =PageFactory.initElements(SeleniumRepo.driver, PropertyDefaults.class);
			AddNewRatePlan NewRateplan=PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);

			String CompoundAccessCode= h.get("CompoundAccessCode").toString().trim();
			 Rateplan1= h.get("Rateplan1").toString().trim();
			 Rateplan2= h.get("Rateplan2").toString().trim();

			test = extent.createTest("Verify Compound Access Codes Link under RatePlans And Add");
			logger.info("Verify Compound Access Codes Link under RatePlans And Add");

			PropertyDefaults.click_PropertyDefaults();
			PropertyDefaults.CompoundAccess_RadioButton("enable");
			PropertyDefaults.Click_Save();
			
			NewRateplan.click_Rateplan();
			CompoundAccessCodes.Verify_CompoundAccessCodeLink();
			CompoundAccessCodes.Click_CompoundAccessCodes();
			CompoundAccessCodes.Delete_CompoundAccessCode(CompoundAccessCode);
			CompoundAccessCodes.Click_AddCompoundAccessCode();
			CompoundAccessCodes.Enter_CodeName(CompoundAccessCode);
			CompoundAccessCodes.SelectMultipleRateplans(Rateplan1, Rateplan2);
			CompoundAccessCodes.Click_Save();
			CompoundAccesscode=CompoundAccessCodes.verify_MultipleRateplans(Rateplan1, Rateplan2, CompoundAccessCode);



		}
		catch (Exception e)
		{
			logger.error("Unable to Add Compound Access Codes because of this execption" + e);
			test.log(Status.ERROR, "Unable to Add Compound Access Codes because of this execption" + e);
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "Rategrid",priority=2)
	public void specialrateplan(HashMap<String, String> h) throws InterruptedException, IOException 
	{

		try {
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);


			test = extent.createTest("Setting up RatePlan Dates,Room And Inventory");
			logger.info("Setting up RatePlan Dates,Room And Inventory");

			String EnterValue = h.get("EnterValue").toString().trim();
			String Rateplan = h.get("offer").toString().trim();
			String Category = h.get("Category").toString().trim();

			//NewRatePlan.click_Rateplan();
			NewRatePlan.click_Listall();
			NewRatePlan.Name_Search(Rateplan1);
			NewRatePlan.Edit(Rateplan1);
			NewRatePlan.Select_Category(Category);
			NewRatePlan.All_rooms();
			NewRatePlan.Book_startdate();
			NewRatePlan.Booking_Enddate();
			NewRatePlan.Checkin_startdate();
			NewRatePlan.checkout_date();
			NewRatePlan.minleadtime();
			NewRatePlan.maxleadtime();
			NewRatePlan.minLos();
			NewRatePlan.MaxLos();
			NewRatePlan.display_offers();
			NewRatePlan.click_save();

			boolean error_status=NewRatePlan.RoomsError();
			if(error_status==true)
			{
				NewRatePlan.Rooms_inventory();
				NewRatePlan.click_save();
			}
			
			NewRatePlan.click_Listall();
			NewRatePlan.Name_Search(Rateplan2);
			NewRatePlan.Edit(Rateplan2);
			NewRatePlan.Select_Category(Category);
			NewRatePlan.All_rooms();
			NewRatePlan.Book_startdate();
			NewRatePlan.Booking_Enddate();
			NewRatePlan.Checkin_startdate();
			NewRatePlan.checkout_date();
			NewRatePlan.minleadtime();
			NewRatePlan.maxleadtime();
			NewRatePlan.minLos();
			NewRatePlan.MaxLos();
			NewRatePlan.display_offers();
			NewRatePlan.click_save();

			boolean error_status1=NewRatePlan.RoomsError();
			if(error_status==true)
			{
				NewRatePlan.Rooms_inventory();
				NewRatePlan.click_save();
			}

			NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);

			NewRategrid.sync_offer("BAR", Rateplan1,Rateplan2);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();
			NewRategrid.Searchfield(Rateplan1);
			NewRategrid.select_offer(Rateplan1);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(Rateplan1);
			NewRategrid.inventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();
			
			NewRategrid.Click_ManageDropdown(EnterValue);
			NewRategrid.Searchfield(Rateplan2);
			NewRategrid.select_offer(Rateplan2);
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.offercheck(Rateplan2);
			NewRategrid.inventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();

		}
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
}
