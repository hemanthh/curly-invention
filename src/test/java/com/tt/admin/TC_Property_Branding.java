package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.PropertyBranding;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * 
 * @author TT072
 *
 */
public class TC_Property_Branding extends BaseTest{
	Logger logger = Logger.getLogger(TC_Property_Branding.class);
	@DataProvider
	  public Object[][] dataSupplier() throws IOException {

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"PropertyBranding");
		 
  return (testObjArray);
	  }


	@Test(dataProvider = "dataSupplier",groups = {"SMOKE"}, enabled = true )
	public void test(HashMap<String, String> h) {
		try {
			 PropertyBranding prtyBranding =PageFactory.initElements(SeleniumRepo.driver, PropertyBranding.class);

			test = extent.createTest("TT PROPERTY BRANDING");
			logger.info("Adding property Branding for existing property");
			
			String hotelName = h.get("Hotel Name").toString().trim();
			String topBannerText = h.get("Top Banner Alt text").toString().trim();
			String topBannerUrl = h.get("Top Banner URL").toString().trim();
			String bottomBannerText = h.get("Bottom Banner Alt Text").trim().toString().trim();
			String bottomBannerUrl = h.get("Bottom Banner URL").toString().trim();
			String paymentPageText = h.get("Payment Page Alt").toString().trim();
			String paymentPageUrl = h.get("Payment Page URL").toString().trim();
			String ImageName = h.get("ImageName").toString().trim();

			prtyBranding.propertyBranding(hotelName,ImageName, topBannerText, topBannerUrl, bottomBannerText, bottomBannerUrl, paymentPageText, paymentPageUrl);
			
			System.out.println("----------------------------------------");
			logger.info("Browser Opened");
		} 
		catch (Exception e) 
		{
			logger.error("Unable to Add Branding for property because of this issue"+e);
			test.log(Status.FAIL, "Failed to create Property Branding" +e);

			e.printStackTrace();
			Assert.assertEquals(false,true);

		}

	}

}
