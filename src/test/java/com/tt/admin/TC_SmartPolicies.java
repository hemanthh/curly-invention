package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.SmartPolicies;
import com.tt.admin.pom.SmartPoliciesDelete;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;


public class TC_SmartPolicies extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"SmartPolicies");

		return (testObjArray);
	}
	


	@Test(dataProvider = "dataSupplier")
	public void crteSmartPolicy(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		try {
			
			SmartPoliciesDelete delete = PageFactory.initElements(SeleniumRepo.driver, 
					SmartPoliciesDelete.class);
			SmartPolicies smartpolicies = PageFactory.initElements(SeleniumRepo.driver,
					SmartPolicies.class);
			
			
			test = extent.createTest(" Smart Policies FOR PROPERTY");
			logger.info("Creating Smart Policies for selected property ");

			String SPName = h.get("SPName").toString().trim();
			String DefaultPoliciy = h.get("DefaultPoliciy").toString().trim();
			String APoliciy = h.get("APoliciy").toString().trim();
			String BPoliciy = h.get("BPoliciy").toString().trim();
			String APayment = h.get("APayment").toString().trim();
			String BPayment = h.get("BPayment").toString().trim();
			String Aamount = h.get("PAamount").toString().trim();
			String Bamount = h.get("Bamount").toString().trim();
			String Ex_Policy = h.get("Ex_Policy").toString().trim();

             System.out.println("----------------------------------------");

             delete.deletePolicy(SPName);
             
             SeleniumRepo.waitForPageLoaded();
             
             smartpolicies.smartPolicy(SPName, DefaultPoliciy, APoliciy, BPoliciy, APayment, BPayment,Aamount, Bamount, Ex_Policy);
            
			
		} catch (Exception e) {
			logger.error("Unable to create Smart Policies for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Policies for selected property because of this execption" + e);
			/*finalAssertTrue(true,
				    "Failed to Creat Smart Policies ");*/
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

		
	}
			
				
}


