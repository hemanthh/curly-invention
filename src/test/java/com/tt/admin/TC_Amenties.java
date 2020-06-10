package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Amenities;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

@Test
public class TC_Amenties extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "Amenities");

		return (testObjArray);
	}

	@Test(priority = 1, enabled = true, dataProvider = "dataSupplier", description = "Gets Data from Excel")
	public void amenities(HashMap<String, String> h) throws Exception {
		try {
			Amenities CrtAmenities = PageFactory.initElements(SeleniumRepo.driver, Amenities.class);

			String Amenity_Name = h.get("Amenity_Name").toString().trim();
			String Type = h.get("Type").toString().trim();

			test = extent.createTest("Creating Amenitiey " + Amenity_Name);
			logger.info("Creating Amenitiey " + Amenity_Name);

			System.out.println("----------------------------------------");

			CrtAmenities.addAmenity(Amenity_Name, Type);

			System.out.println("-------Amenity_Name " + Amenity_Name + " created successfully---------");
			test.log(Status.INFO, "-------Amenity_Name " + Amenity_Name + " created successfully---------");

		} catch (Exception e) {
			logger.error("Unable to create Amenities  property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Amenities property because of this execption" + e);
			/*
			 * finalAssertTrue(true, "Failed to select Amenities ");
			 */
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}
	}

	
	/*
	@Test(priority = 2, enabled = true, description = "Does not use excel")
	public void manuallyCreateAmenities() throws Exception {
		try {
			Amenities CrtAmenities = PageFactory.initElements(SeleniumRepo.driver, Amenities.class);

			test = extent.createTest("Editing/Craeating Amenitiey ");
			logger.info("Editing/Creating Amenitiey ");

			System.out.println("----------------------------------------");

			// CrtAmenities.addAmenity(Amenity_Name, Type);

			  
			CrtAmenities.navigateToAmenities_Pg();
			CrtAmenities.Click_AddAmenity_Link();
			CrtAmenities.navigateToAmenities_Pg();
			CrtAmenities.Click_AmenityEdit_Link("Iron and Ironing Board");
			CrtAmenities.navigateToAmenities_Pg();
			CrtAmenities.Click_AmenityDelete_Link("Multi-lingual Staff");

			CrtAmenities.Click_AmenityDelete_Link("Water Bed");

			CrtAmenities.Click_AmenityDelete_Link("Bath House");

			CrtAmenities.navigateToAmenities_Pg();
			CrtAmenities.Click_AddAmenity_Link();

			CrtAmenities.editAmenityName("Multi-lingual Hugs");
			CrtAmenities.editAmenityType("RLS");
			CrtAmenities.editAmenityCategory("SERVICES");
			CrtAmenities.editAmenity_Amenity("Extra adult charge");
			CrtAmenities.editAmenityIncludeInRate("enable");

			CrtAmenities.createRoomSpecificAmenity("Multi-lingual Staff", "", "", "");
			
			CrtAmenities.createComonToAllRmAmenity("Water Bed", "", "", "enable");
			
			CrtAmenities.createPropertyAmenity("Bath House", "", "", "disable");

			
			 		 
			 
			 


		} catch (Exception e) {
			logger.error("Unable to create Amenities  property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Amenities property because of this execption" + e);
			
			 * finalAssertTrue(true, "Failed to select Amenities ");
			 
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}
	}
*/
}
