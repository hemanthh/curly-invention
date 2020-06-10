package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AddNewRatePlan;
import com.tt.admin.pom.ManageAccessCode;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_ManageAccessCode extends BaseTest {

	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "Rategrid");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void crteMAC(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
				
			test = extent.createTest(" ManageAccessCode FOR PROPERTY");
			logger.info("Creating ManageAccessCode for selected property ");

		
			ManageAccessCode accesscode =PageFactory.initElements(SeleniumRepo.driver, ManageAccessCode.class);
			AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
			
			String Rateplan = h.get("offer").toString().trim();
			String Category = h.get("Category").toString().trim();
			
			System.out.println("enter");
			
		//	dates.Click_Rateplan();
			NewRatePlan.click_Listall();
			SeleniumRepo.waitForPageLoaded();
			NewRatePlan.Name_Search(Rateplan);
			NewRatePlan.Edit(Rateplan);
			NewRatePlan.Select_Category(Category);
			NewRatePlan.All_rooms();
			NewRatePlan.Book_startdate();
			//NewRatePlan.Booking_Enddate();
			NewRatePlan.Checkin_startdate();
			//NewRatePlan.checkout_date();
			NewRatePlan.minleadtime();
			NewRatePlan.maxleadtime();
			NewRatePlan.minLos();
			NewRatePlan.MaxLos();
			NewRatePlan.display_offers();
			NewRatePlan.click_save();
			
			boolean error_status=NewRatePlan.RoomsError();
			if(error_status==true)
			{
				NewRatePlan.Rooms_inventory();
				NewRatePlan.click_save();
				SeleniumRepo.waitForPageLoaded();
			}
		
			accesscode.Click_ManageAccessCode();
			accesscode.Enter_Rateplan(Rateplan);
			accesscode.Select_Rateplan();
			accesscode.Rateplan_check(Rateplan);
			accesscode.Add_NewAccesscode();
			accesscode.Accesscode_Name(Rateplan);
			accesscode.Offer_default();
			
			SeleniumRepo.waitForPageLoaded();
	
	
		} catch (Exception e) {
			logger.error("Unable to create ManageAccessCode for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create ManageAccessCode for selected property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

		
	}
	
	
	
}
