package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;
public class TC_RateGrid extends BaseTest{

	Logger logger = Logger.getLogger(TC_RateGrid.class);
	@DataProvider
	public Object[][] RateGrid() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray1);
	}

	@Test(dataProvider = "RateGrid")
	public void rategrid(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		try {
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

			test = extent.createTest(" Creating Rate Grid");
			logger.info("Creating RateGrid");

			String EnterValue = h.get("EnterValue").toString().trim();


			//NewRategrid.rate(EnterValue);

             
			//NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			//NewRategrid.Select_all();
			//NewRategrid.Searchfield("Stay2NightsAndGet25PerCentOFFBAR");
			NewRategrid.select_offer("BAR");
			NewRategrid.select_offer("Stay2NightsAndGet25PerCentOFFBAR");
			NewRategrid.select_offer("CopperComplimentary");
			NewRategrid.select_offer("AllTimeOffer");
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();


		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
			Assert.assertEquals(false,true);
		}}}


