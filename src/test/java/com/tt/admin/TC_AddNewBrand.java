package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AddNewBrand ;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_AddNewBrand extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AddNewBrand");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void newBrand(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
			AddNewBrand  Brand = PageFactory.initElements(SeleniumRepo.driver, AddNewBrand .class);

			test = extent.createTest("New Brand Created ");
			logger.info("New Brand Created");

			String BrandName = h.get("BrandName").toString().trim();
			Brand.addBrand(BrandName);
			
		} catch (Exception e) {
			logger.error("Unable to create New Brand  because of this execption" + e);
			test.log(Status.ERROR, "Unable to create New Brand because of this execption" + e);
			e.printStackTrace();

		}
	
	
	
	
}
}