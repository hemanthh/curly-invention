package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.admin.pom.BrandSelection;
import com.tt.admin.pom.EMailOTP;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * 
 * @author TT072
 *This test case selects the brand name from the list
 */
public class TC_Brand_Selection extends BaseTest 
{
	@DataProvider
	  public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"SelectProperty_Brand");
		 
  return (testObjArray);
	  }

	@Test(dataProvider="dataSupplier", enabled = true )
	public void brandSelection(HashMap<String, String> h) throws IOException, InterruptedException
	{
		try {
			
			BrandSelection brandSel =PageFactory.initElements(SeleniumRepo.driver, BrandSelection.class);
			EMailOTP mail =PageFactory.initElements(SeleniumRepo.driver, EMailOTP.class);
			
			
			mail.clickNext();
			mail.openEMail();
			String OTP=mail.loginEmail();
			List<String>tabs1=windowidList();
			SeleniumRepo.driver.switchTo().window(tabs1.get(0));
			mail.enteringOTP(OTP);
			
			
		//	String BrandName = h.get("SelectBrand").toString().trim();
			
			String BrandName = ReadProperties.getPropValues("Admin.properties", "SelectBrand");

			test = extent.createTest("TT BRAND SELECTION");
			brandSel.selectBrand(/*BrandName*/);
						/*finalAssertTrue(true,
				    "Brand selected successfully");*/
		} catch (Exception e) {
			/*finalAssertTrue(false,
				    "Failed to select brand");*/
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
		
	}
}
