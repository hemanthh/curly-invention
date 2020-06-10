package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AboutNearAttractions;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_AboutNearAttractions extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AboutNearByAttraction");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void nearbyAttraction(HashMap<String, String> h) throws InterruptedException, IOException {
		
		try {
		AboutNearAttractions NearByAttract =PageFactory.initElements(SeleniumRepo.driver, AboutNearAttractions.class);
		
		
		
			String NBA_Name = h.get("NBA_Name").toString().trim();
			String NBA_Code = h.get("NBA_Code").toString().trim();
			String NBA_Type = h.get("NBA_Type").toString().trim();
			String NBA_URL = h.get("NBA_URL").toString().trim();
			String NBA_Description = h.get("NBA_Description").toString().trim();
			String NBA_Address1 = h.get("NBA_Address1").toString().trim();
			String NBA_City = h.get("NBA_City").toString().trim();
			String NBA_Zipcode = h.get("NBA_Zipcode").toString().trim();
			String NBA_Country = h.get("NBA_Country").toString().trim();
			String NBA_DistanceAway = h.get("NBA_DistanceAway").toString().trim();
			String DistanceUnit = h.get("DistanceUnit").toString().trim();
			String TranspotationMode = h.get("TranspotationMode").toString().trim();
		
			System.out.println("----------------------------------------");
			
			test = extent.createTest(" Creating Near By Attraction Property "+NBA_Name);
			logger.info("Creating Near By Attraction Property "+NBA_Name);
			
			NearByAttract.nearByAttraction(NBA_Name, NBA_Code, NBA_Type, NBA_URL, NBA_Description, 
					NBA_Address1, NBA_City, NBA_Zipcode, NBA_Country, NBA_DistanceAway, 
					DistanceUnit, TranspotationMode);
			
			System.out.println("-------Attraction Name "+NBA_Name+" created successfully---------");
			test.log(Status.INFO, "-------Attraction Name "+NBA_Name+" created successfully---------");
			
			/*finalAssertTrue(true,
				    "Near By Attraction  selected successfully");*/
			
			
		} catch (Exception e) {
			logger.error("Unable to create Near By Attraction property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Near By Attraction property because of this execption" + e);
			/*finalAssertTrue(true,
				    "Failed to select Near By Attraction ");*/
			e.printStackTrace();
			Assert.assertEquals(false, true);
		
		}}}
