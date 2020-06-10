package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.RatePlanCategories;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_RatePlanCategories extends BaseTest {
	
	Logger logger = Logger.getLogger(TC_RatePlanCategories.class);
	@DataProvider
	public Object[][] RateplanCat() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "RateplanCat");

		return (testObjArray1);
	}
	@Test(dataProvider = "RateplanCat")
	public void center(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
			RatePlanCategories NewRateplancategorie =PageFactory.initElements(SeleniumRepo.driver, RatePlanCategories.class);
		
		
		String categoryName = h.get("categoryName").toString().trim();
		
		test = extent.createTest(" Creating Rate Plan Category "+categoryName);
		logger.info(" Creating Rate Plan Category "+categoryName);
	
		NewRateplancategorie.rateplancate(categoryName);
		SeleniumRepo.waitForPageLoaded();

			
		} catch (Exception e) {
			logger.error("Unable to create rateplancate" + e);
			test.log(Status.ERROR, "Unable to create rateplancate" + e);
			e.printStackTrace();
			Assert.assertEquals(false,true);
		}}

}
