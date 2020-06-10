package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.PropertyMaster;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_PropertyMaster extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "Property_Master");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void addNewProperty_Master(HashMap<String, String> h) throws Exception {
		try {
			test = extent.createTest("Add New Property_Master");
			logger.info("Add New Property_Master");

			// AddNewProperty addPrtyMaster
			// =PageFactory.initElements(SeleniumRepo.driver,
			// AddNewProperty.class);

			PropertyMaster propMast = PageFactory.initElements(SeleniumRepo.driver, PropertyMaster.class);

			String PropertyMasterTitle = h.get("PropertyMasterTitle").toString().trim();
			String Phone_Code = h.get("Phone_Code").toString().trim();
			String Phone_Area_Code = h.get("Phone_Area_Code").toString().trim();
			String Phone_Number = h.get("Phone_Number").toString().trim();
			String Website_URL = h.get("Website_URL").toString().trim();
			String Primary_Email = h.get("Primary_Email").toString().trim();
			String NumberOf_Rooms = h.get("NumberOf_Rooms").toString().trim();
			String NumberOf_Floors = h.get("NumberOf_Floors").toString().trim();
			String FirstBedTypeName = h.get("FirstBedTypeName").toString().trim();
			String FirstBedCode = h.get("FirstBedCode").toString().trim();
			String SecondBedTypeName = h.get("SecondBedTypeName").toString().trim();
			String SecondBedCode = h.get("SecondBedCode").toString().trim();
			String ThirdBedTypeName = h.get("ThirdBedTypeName").toString().trim();
			String ThirdBedCode = h.get("ThirdBedCode").toString().trim();
			String Visa = h.get("Visa").toString().trim();
			String MasterCard = h.get("MasterCard").toString().trim();
			String AmericanExpress = h.get("AmericanExpress").toString().trim();
			String Short_Description = h.get("Short_Description").toString().trim();

			System.out.println("----------------------------------------");
			logger.info(" PropertyMaster Opened");
            Thread.sleep(5000);
			propMast.click_PropertyMaster();
			
			/*
			 
			 
			 */
			
			propMast.propMasterPhoneMain("3", "334", "3458987");
			propMast.propMasterPhoneReservation("2", "121", "3457123");
			propMast.propMasterFax("0", "987", "0934777");
			propMast.propMasterWebsiteUrl("www.hugsrus.com");
			
			propMast.propMasterPrimaryEmail("hello@travel.com");
			propMast.propMasterPropNotificationEmail("heydeer.@gmail.com");
			propMast.propMasterIntgNotificationEmail("yng@yahoo.com");
			propMast.propMasterAddEmails("harshini.vemuri@traveltripper.com, yugiho@aol.com");


			propMast.propMasterNumOfRooms("45");
			propMast.propMasterNumOfFloors("8");


			propMast.propMasterPropertyLanguages("Català;čeština;Русский;简体中国");

			//propMast.propMasterAvailableBedTypesCreate("hello", "9oo");
			
			propMast.propMasterAllNonSmkRooms("enable");
			
			propMast.propMasterCreditCardsAccpt("Diners Club;China UnionPay");


			propMast.propMasterCreditCardVal("info");
			
			propMast.propMasterShortDes("Sweet buffte crabs");
			
			propMast.propMasterLongDes("Sweet buffte crabs, sweet sweet jesuse");
			
			
			propMast.propMasterGdsPromoText("Hi Kids");







			
			/*
			propMast.propMasterAssUsers();

*/
			/*
			 * propMast.propertyMaster(PropertyMasterTitle, Phone_Code,
			 * Phone_Area_Code, Phone_Number, Website_URL, Primary_Email,
			 * NumberOf_Rooms, NumberOf_Floors, FirstBedTypeName, FirstBedCode,
			 * SecondBedTypeName, SecondBedCode, ThirdBedTypeName, ThirdBedCode,
			 * Visa, MasterCard, AmericanExpress, Short_Description);
			 * 
			 * 
			 */

			/*
			 * 
			 * Original method addPrtyMaster.propertyMaster(PropertyMasterTitle,
			 * Phone_Code, Phone_Area_Code, Phone_Number, Website_URL,
			 * Primary_Email, NumberOf_Rooms, NumberOf_Floors, FirstBedTypeName,
			 * FirstBedCode, SecondBedTypeName, SecondBedCode, ThirdBedTypeName,
			 * ThirdBedCode, Visa, MasterCard, AmericanExpress,
			 * Short_Description);
			 * 
			 * 
			 */

		} catch (Exception e) {
			logger.error("Unable to create  New Property_Master property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Add New Property_Master property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);


		}
	}
}
