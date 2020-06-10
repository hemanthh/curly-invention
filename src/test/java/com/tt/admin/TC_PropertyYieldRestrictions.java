/**
 * 
 */
package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.PropertyYieldRestrictions;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * @author DM
 *
 */
public class TC_PropertyYieldRestrictions extends BaseTest	 {
	
	
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

			
			PropertyYieldRestrictions propYieldRes = PageFactory.initElements(SeleniumRepo.driver, PropertyYieldRestrictions.class);

			/*
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
			
			*/
			logger.info(" PropertyMaster Opened");

			
			propYieldRes.click_PropertyYieldRestrictions();
			propYieldRes.propYieldSameDayChkInAllow();
			
		
			
			propYieldRes.propYieldSameDayChkInDoNotAllow();
			propYieldRes.propYieldSameDayChkInDoNotAllowAfter("4", "23", "PM");
			
			propYieldRes.propYieldImposeMaxLos("enable");
			propYieldRes.propYieldMaxLOS("3");
			
			propYieldRes.propYieldMinLeadTime("2");
			propYieldRes.propYieldMaxLeadTime("5");
			
			//propYieldRes.Click_Save();









		} catch (Exception e) {
			logger.error("Unable to create  property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create  because of this execption" + e);
			e.printStackTrace();

		}
	}

}
