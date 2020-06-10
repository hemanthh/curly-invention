package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.BE.pom.IBE_config;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_IBE_Config_Yankee extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "YankeeFlow");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier")
	public void Flow(HashMap<String, String> h) throws InterruptedException, IOException {
	
		try {
			IBE_config  flow =PageFactory.initElements(SeleniumRepo.driver, IBE_config.class);
		
		test = extent.createTest("Setting up the Yankee flow");
		logger.info("Setting up the Yankee flow");

		String Username = ReadProperties.getPropValues("Admin.properties", "IBEusername");
		String Password = ReadProperties.getPropValues("Admin.properties", "IBEpassword");
		String ExistingPropetyName = ReadProperties.getPropValues("Admin.properties", "ExistingPropetyName");

			String YankeeFlowName = h.get("FlowName").toString().trim();
			logger.info("Browser Opened");
			flow.GotoURL();
			flow.Login(Username, Password);Thread.sleep(5000);
			flow.Portal_settings();
			flow.Search(ExistingPropetyName);
			flow.Edit(ExistingPropetyName);
			flow.YankeeFlow_Select(YankeeFlowName);
			flow.save();
			flow.Alert_Text();
		

		} catch (Exception e) {
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}
	}
}
