package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Policies;
import com.tt.admin.pom.PoliciesDelete;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_Policies extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"Policies");

		return (testObjArray);
	}
	

	@Test(dataProvider = "dataSupplier")
	public void crtePolicy(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
			
			PoliciesDelete pdelete = PageFactory.initElements(SeleniumRepo.driver, 
					PoliciesDelete.class);
			Policies policies = PageFactory.initElements(SeleniumRepo.driver,
					Policies.class);
			
			
			
			String PolicyName = h.get("PolicyName").toString().trim();
			String PolicyCode = h.get("PolicyCode").toString().trim();
			String PolicyDiscription = h.get("PolicyDiscription").toString().trim();
			String PolicyDD = h.get("PolicyDD").toString().trim();
			String CheckDeposite = h.get("CheckDeposite").toString().trim();
			String CancellationFee = h.get("CancellationFee").toString().trim();
			String FixedAmount = h.get("FixedAmount").toString().trim();
			String days = h.get("days").toString().trim();
			String DayorHour = h.get("DayorHour").toString().trim();
			String Before = h.get("Before").toString().trim();
			String value = h.get("value").toString().trim();
			
			test = extent.createTest("Creating "+PolicyName+" Policy");
			logger.info(" Creating "+PolicyName+" Policy");

			
			pdelete.deletePolicy(PolicyName);
		
			System.out.println("----------------------------------------");
		
			
			policies.crtPolicies(PolicyName, PolicyCode, PolicyDiscription, PolicyDD,
					CheckDeposite, CancellationFee, FixedAmount, days, DayorHour, value, Before);
			
			System.out.println("----------------------------------------");

				
			
		} catch (Exception e) {
			logger.error("Unable to create Policies for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Policies for selected property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

	
	
	
	
	}
			
			
			
			
}
