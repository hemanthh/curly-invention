package com.tt.admin;

import java.io.IOException;
import org.apache.log4j.Logger;
import java.util.HashMap;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.CallCenterSettings;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

	public class TC_CallCenterSettings extends BaseTest{
		 	Logger logger = Logger.getLogger(TC_Property_Branding.class);
		@DataProvider
		public Object[][] dataSupplier() throws IOException {
			String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

			Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"CallCenterSettings");

			return (testObjArray);
		}
		@Test(dataProvider = "dataSupplier")
		public void center(HashMap<String, String> h) throws InterruptedException, IOException {
			try {
				CallCenterSettings callcenter =PageFactory.initElements(SeleniumRepo.driver, CallCenterSettings.class);
			test = extent.createTest(" Creating call center");
			logger.info("Creating call center");
			
				String Linkforhoteldetails = h.get("Linkhoteldetails").toString().trim();
				String Announcement = h.get("Announcement").toString().trim();
			 
				callcenter.callcentersetting(Linkforhoteldetails, Announcement);
				
			} catch (Exception e) {
				logger.error("Unable to create call center" + e);
				test.log(Status.ERROR, "Unable to create call center" + e);
				e.printStackTrace();
				Assert.assertEquals(false, true);
			}}}


