package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Add_Ons;
import com.tt.admin.pom.Delete_AddOn;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_Add_Ons extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AddOns");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier")
	public void crteAddOns(HashMap<String, String> h) throws InterruptedException, IOException {
		Add_Ons addons= PageFactory.initElements(SeleniumRepo.driver, Add_Ons.class);
		try {
			
			Delete_AddOn delete = PageFactory.initElements(SeleniumRepo.driver, Delete_AddOn.class);
			
			
			
			

			String AddonName = h.get("AddonName").toString().trim();
			String AddonCode = h.get("AddonCode").toString().trim();
			String Discription = h.get("Discription").toString().trim();
			String PriceFrequency = h.get("PriceFrequency").toString().trim();
			String PriceBasis = h.get("PriceBasis").toString().trim();
			String Price = h.get("Price").toString().trim();
			String OpaquePrice = h.get("OpaquePrice").toString().trim();
			String MaxQuantityBookable = h.get("MaxQuantityBookable").toString().trim();
			String PriceAdult = h.get("PriceAdult").toString().trim();
			String PriceChild= h.get("PriceChild").toString().trim();
			
			test = extent.createTest(" Deleta add on "+AddonName);
			logger.info(" Deleta add on "+AddonName);
			
			 System.out.println("----------------------------------------");
			 try {
			 delete.deletePolicy(AddonName);
			 }catch(Exception e) {}
			 SeleniumRepo.waitForPageLoaded();
	
            System.out.println("----------------------------------------");
            
            test = extent.createTest(" Create Add on "+AddonName);
			logger.info(" Create Add on "+AddonName);
			
            addons.addON(AddonName, AddonCode, Discription, PriceFrequency, 
            		PriceBasis, Price, MaxQuantityBookable, PriceAdult, PriceChild, OpaquePrice);
            
			 SeleniumRepo.waitForPageLoaded();

            
		} catch (Exception e) {
			logger.error("Unable to create Add_Ons for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Add_Ons for selected property because of this execption" + e);
			/*finalAssertTrue(true,
				    "Failed to Create Add_Ons ");*/
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}
		
//		finally {
//			addons.deleteAddOns();
//		}

		
	}
			
				
}
