package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tt.admin.pom.SelectProperty;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;


public class TC_Select_Property  extends BaseTest
{
	public static String propertyName;
	Logger logger = Logger.getLogger(TC_Select_Property.class);
	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"SelectProperty_Brand");

		return (testObjArray);
	}


	@Test(dataProvider = "dataSupplier",groups = {"SMOKE"}, enabled = true)
	public void selProperty(HashMap<String, String> h) throws IOException {
		try 
		{

			SelectProperty selProperty =PageFactory.initElements(SeleniumRepo.driver, SelectProperty.class);

			test = extent.createTest("TT PROPERTY SELECTION");
			logger.info("Selecting property from existing list");

		//	propertyName = h.get("ExistingPropetyName");
			
			 propertyName = ReadProperties.getPropValues("Admin.properties", "ExistingPropetyName");
			

			selProperty.selectProperty_ByPropertyName(/*propertyName*/);

			
		}
		catch (InterruptedException e)
		{
			logger.error("Unable to select property because of this execption"+e);
			/*finalAssertTrue(true,
					"Failed to select property");*/
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

}
