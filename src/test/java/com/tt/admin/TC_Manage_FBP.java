package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tt.admin.pom.AddNewRatePlan;
import com.tt.admin.pom.Manage_FBP;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Manage_FBP extends BaseTest
{
	String RatePlan;
	String Dayofweek ;
	String Adj_Type ;
	String Amount ;
	String Rooms ;
	String FloorAmount;
	String CielingAmount;
	String FBPRateplan;

	Logger logger = Logger.getLogger(TC_RateGrid.class);
	@DataProvider
	public Object[][] FBP() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "ManageFBP");

		return (testObjArray1);
	}

	@Test(priority = 1,enabled = true,dataProvider = "FBP",description="Manage Formula Bassed Pricing")
	public void ManageFBP(HashMap<String, String> h1) throws InterruptedException, IOException 
	{
		try 
		{

			Manage_FBP  FBP =PageFactory.initElements(SeleniumRepo.driver,Manage_FBP.class);

			AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
			
			test = extent.createTest("Manage Formula Based Pricing");
			logger.info("Manage Formula Based Pricing");


			RatePlan = h1.get("RatePlan").toString().trim();
			Dayofweek = h1.get("Dayofweek").toString().trim();
			Adj_Type = h1.get("Adj_Type").toString().trim();
			Amount = h1.get("Amount ").toString().trim();
			Rooms = h1.get("Rooms").toString().trim();
			FBPRateplan = h1.get("FBPRateplan").toString().trim();
			FloorAmount = h1.get("FloorAmount").toString().trim();
			CielingAmount = h1.get("CielingAmount").toString().trim();

			NewRatePlan.click_Rateplan();
			FBP.Click_ManageFBP();
			FBP.Enter_Rateplan(RatePlan);
			FBP.Select_Rateplan();
			FBP.FromDate();
			FBP.Todate();
			FBP.Day_of_week(Dayofweek);
			FBP.Adj_type_FlatAmount();
			FBP.Amount(Amount);
			FBP.verify_Flatoff(FBPRateplan);
			FBP.Rooms();
			FBP.Floor(FloorAmount);
			FBP.Cieling(CielingAmount);
			FBP.add();

	

		} catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
}
