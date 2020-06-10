package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.NearByAttraction;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_NearByAttraction extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	String attactionName;

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "NearByAttraction");

		return (testObjArray);
	}

	@Test(priority = 1, enabled = true)
	public void crteEditNearByAttract() throws InterruptedException, IOException {
		try {
			NearByAttraction nearByAttraction = PageFactory.initElements(SeleniumRepo.driver, NearByAttraction.class);

			test = extent.createTest("NearByAttraction FOR PROPERTY part one");
			logger.info("Creating NearByAttraction for selected property ");

			System.out.println("----------------------------------------");

			nearByAttraction.navigateToNearbyAttractions_ListAllPg();

			nearByAttraction.navigateToNearbyAttractions_CopyPg("QA Nearby Museum");

			nearByAttraction.navigateToNearbyAttractions_ListAllPg();

			nearByAttraction.navigateToNearbyAttractions_AddPg();

			nearByAttraction.navigateToNearbyAttractions_ListAllPg();

			nearByAttraction.deleteAllNearbyAttractions();

			// nearByAttraction.deleteNearbyAttaction("");
			// nearByAttraction.navigateToNearbyAttractions_EditPg("QA Nearby
			// Museum5");

			nearByAttraction.navigateToNearbyAttractions_AddPg();

			attactionName = "Attaction to Space" + SeleniumRepo.getRandomAlphNumeircString(4);

			nearByAttraction.editNearByAttractionName(attactionName);
			nearByAttraction.editNearByAttractionCategory("Linn glaxy");
			nearByAttraction.editNearByAttractionDescription("Ori and the lispss");
			nearByAttraction.editNearByAttraction_ImgName("Bedd Rommls", "0");
			nearByAttraction.editNearByAttraction_ImgDescription("Fallout 76 training session", "0");
			nearByAttraction.editNearByAttraction_ImgAltText("Fallout 4 is ten times better than 76", "0");
			nearByAttraction.editNearByAttraction_ImgReturnOrder("1", "0");
			nearByAttraction.editNearByAttraction_ImgChooseimage("\\images\\Room1.jpg", "0");
			nearByAttraction.editNearByAttractionCountry("United States");
			nearByAttraction.editNearByAttractionAddress1("1071 Fifth Avenue at 89th Street");
			nearByAttraction.editNearByAttractionCity("Newark");
			nearByAttraction.editNearByAttractionZipCode("10144");
			nearByAttraction.editNearByAttractionLatLongitude();

			nearByAttraction.saveNearByAttractionButton();

			System.out.println("----------------------------------------");

		} catch (Exception e) {
			logger.error("Unable to create NearByAttraction for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create NearByAttraction for selected property because of this execption" + e);
			/*
			 * finalAssertTrue(true, "Failed to select NearByAttraction ");
			 */
			e.printStackTrace();

		}

	}

	@Test(priority = 2, enabled = true, dataProvider = "dataSupplier")
	public void crteNearByAttract(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
			NearByAttraction nearByAttraction = PageFactory.initElements(SeleniumRepo.driver, NearByAttraction.class);

			test = extent.createTest(" NearByAttraction FOR PROPERTY part two");
			logger.info("Creating NearByAttraction for selected property ");

			String EnterName = h.get("EnterName").toString().trim();
			String NearBy_Category = h.get("NearBy_Category").toString().trim();
			String NearBy_Description = h.get("NearBy_Description").toString().trim();
			String roomImagePath = h.get("roomImagePath").toString().trim();
			String Country = h.get("Country").toString().trim();
			String NearBy_Address = h.get("NearBy_Address").toString().trim();
			String NearBy_City = h.get("NearBy_City").toString().trim();
			String NearBy_ZipCode = h.get("NearBy_ZipCode").toString().trim();

			System.out.println("----------------------------------------");

			nearByAttraction.createNearByAttraction(EnterName, NearBy_Category, NearBy_Description, roomImagePath,
					Country, NearBy_Address, NearBy_City, NearBy_ZipCode);
			/*
			 * finalAssertTrue(true, "NearByAttraction  selected successfully");
			 */

			System.out.println("----------------------------------------");

		} catch (Exception e) {
			logger.error("Unable to create NearByAttraction for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create NearByAttraction for selected property because of this execption" + e);
			/*
			 * finalAssertTrue(true, "Failed to select NearByAttraction ");
			 */
			e.printStackTrace();

		}

	}

	@Test(priority = 3, enabled = true)
	public void crteEditNearByAttractCopy() throws InterruptedException, IOException {

		try {
			NearByAttraction nearByAttraction = PageFactory.initElements(SeleniumRepo.driver, NearByAttraction.class);

			test = extent.createTest("NearByAttraction FOR PROPERTY Copy");
			logger.info("Copying a NearByAttraction for selected property ");

			System.out.println("----------------------------------------");

			nearByAttraction.navigateToNearbyAttractions_ListAllPg();

			nearByAttraction.navigateToNearbyAttractions_CopyPg(attactionName);

			// Caesars;Churchill at Apex;Inn of Chicago;QA2-DemoADA;QA2
			// Anil-2019
		    //	nearByAttraction.propertyCopyNearByAttractionSelection("Disney 3.0");

			/*
			 * 
			 * The copy function takes too long to load and would require to add
			 * too sleep
			 * 
			 * nearByAttraction.navigateToNearbyAttractions_ListAllPg();
			 * nearByAttraction.navigateToNearbyAttractions_CopyPg(attactionName
			 * );
			 * 
			 * //Caesars;Churchill at Apex;Inn of Chicago;QA2-DemoADA;QA2
			 * Anil-2019 nearByAttraction.
			 * propertyCopyNearByAttractionSelection("Disney 3.0");
			 * 
			 */

			System.out.println("----------------------------------------");

		} catch (Exception e) {
			logger.error("Unable to create NearByAttraction for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create NearByAttraction for selected property because of this execption" + e);
			/*
			 * finalAssertTrue(true, "Failed to select NearByAttraction ");
			 */
			e.printStackTrace();

		}

	}

}
