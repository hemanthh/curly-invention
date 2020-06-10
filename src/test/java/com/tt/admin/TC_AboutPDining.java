package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AboutPDining;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_AboutPDining extends BaseTest{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AboutPDining");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier")
	public void propertyDining(HashMap<String, String> h) throws InterruptedException, IOException {

		try {
			AboutPDining  CrtPDining =PageFactory.initElements(SeleniumRepo.driver, AboutPDining .class);



			String RestaurantName = h.get("RestaurantName").toString().trim();
			String Code = h.get("Code").toString().trim();
			String Proximity = h.get("Proximity").toString().trim();
			String Cuisine = h.get("Cuisine").toString().trim();
			String Description = h.get("Description").toString().trim();
			String Address1 = h.get("Address1").toString().trim();
			String City = h.get("City").toString().trim();
			String Country = h.get("Country").toString().trim();
			String Zipcode = h.get("Zipcode").toString().trim();
			String Distance_Away = h.get("Distance_Away").toString().trim();
			String Distance  = h.get("Distance").toString().trim();

			

			test = extent.createTest("Creating Property Dining with name   "+RestaurantName);
			logger.info("Creating Property Dining with name   "+RestaurantName);

			CrtPDining.aboutPDining(RestaurantName, Code, Proximity, 
					Cuisine, Description, Address1, City, Country, Zipcode, Distance_Away,Distance);
			
			System.out.println("-------Restaurant Name "+RestaurantName+" created successfully---------");
			
			test.log(Status.INFO, "-------Restaurant Name "+RestaurantName+" created successfully---------");
			logger.info("-------Restaurant Name "+RestaurantName+" created successfully---------");
			
			/*finalAssertTrue(true,
					"Near By Dining  selected successfully");*/


		}
		catch (Exception e) 
		{
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();
			/*finalAssertTrue(true,
					"Failed to select Near By Dining ");*/
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}


	}}
