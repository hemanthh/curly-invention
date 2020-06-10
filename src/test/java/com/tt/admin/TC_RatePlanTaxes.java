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

import com.tt.admin.pom.RatePlanTaxes;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * @author DM
 *
 */
public class TC_RatePlanTaxes  extends BaseTest{
	
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"
				+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"RatePlanTaxes");     

		return (testObjArray);
	}
	
	
	@Test(priority=1, enabled=true , dataProvider = "dataSupplier" )
	public void testTaxesAndFeesDeleation(HashMap<String, String> h) throws Exception {
		
		
		RatePlanTaxes MappingTaxesToRatePlan =PageFactory.initElements(SeleniumRepo.driver, RatePlanTaxes.class);
		
		System.out.println("----------------------------------------");

		logger.info("Mapping taxes to rate plan");

		test = extent.createTest("Mapping Taxes to Rate Plan");
		
		String RatePlan_Name= h.get("RatePlan_Name").toString().trim();
		String RatePlan_Code= h.get("RatePlan_Code").toString().trim();
		String Tax_Name= h.get("Tax_Name").toString().trim();



		
		SeleniumRepo.waitForPageLoaded();

		MappingTaxesToRatePlan.navigateToRatePlanTaxes();
		SeleniumRepo.waitForPageLoaded();
		MappingTaxesToRatePlan.applyAllTaxesToRatePlane(RatePlan_Name, RatePlan_Code);

		//Create a Save method 
		MappingTaxesToRatePlan.saveTaxToRatePlan();
		SeleniumRepo.waitForPageLoaded();

		
		//MappingTaxesToRatePlan.applyAllTaxesToAllRatePlans();
		//MappingTaxesToRatePlan.applyTaxToAllRatePlans("Add To Tax_T76195");
		//MappingTaxesToRatePlan.applyAllTaxesToRatePlane(RatePlan_Name, RatePlan_Code);
		//MappingTaxesToRatePlan.applyTaxToRatePlan("FixedCorporateVaryingOffer", "FCVO", "City Ranged Tax_C72386");

		
	}

}
