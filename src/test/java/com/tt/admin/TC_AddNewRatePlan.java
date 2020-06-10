package com.tt.admin;

	import java.io.IOException;
	import org.apache.log4j.Logger;
	import java.util.HashMap;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import com.aventstack.extentreports.Status;
    import com.tt.admin.pom.AddNewRatePlan;
    import com.tt.utility.BaseTest;
	import com.tt.utility.ReadDataFromExcel;
	import com.tt.utility.SeleniumRepo;

	public class TC_AddNewRatePlan extends BaseTest{
		 	Logger logger = Logger.getLogger(TC_Property_Branding.class);
		@DataProvider
		public Object[][] dataSupplier() throws IOException
		{
			Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "AddNewRatePlan");

			return (testObjArray);
		}
		@Test(dataProvider = "dataSupplier")
		public void center(HashMap<String, String> h) throws InterruptedException, IOException {
			try 
			{
				AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
				
			test = extent.createTest(" Creating Rate Plan");
			logger.info("Creating Rateplan");
			
				String Name = h.get("Name").toString().trim();
				String Ratecode = h.get("Ratecode").toString().trim();
				String Category = h.get("Category").toString().trim();
				String ShortDescription = h.get("ShortDescription").toString().trim();
				String imagePath = h.get("imagePath").toString().trim();
				String MinLeadtime = h.get("MinLeadtime").toString().trim();
				String MaxLeadtime = h.get("MaxLeadtime").toString().trim();
				String MinLos = h.get("MinLos").toString().trim();
				String MaxLos = h.get("MaxLos").toString().trim();
				String Usrinput = h.get("Usrinput").toString().trim();
				String EnterSelectedpolicyid = h.get("EnterSelectedpolicyid").toString().trim();
				String AdditionalNotes = h.get("AdditionalNotes").toString().trim();
				String AgentComment = h.get("AgentComment").toString().trim();
				//String Rateplan = h.get("Rateplan").toString().trim();
				
				//SeleniumRepo.driver.navigate().refresh();
				
				//SeleniumRepo.waitForPageLoaded();
				
				NewRatePlan.click_Rateplan();
				NewRatePlan.click_Listall();
				NewRatePlan.Name_Search(Name);
				NewRatePlan.delete_rateplan(Name);
				NewRatePlan.Click_Addnew();
				NewRatePlan.Enter_Name(Name);
				NewRatePlan.Ratecode(Ratecode);
				//NewRatePlan.Select_Category(Category);
				NewRatePlan.ShortDescription(ShortDescription);
				NewRatePlan.Click_Choosefile(imagePath);
				NewRatePlan.selectRoomType();
				NewRatePlan.Book_startdate();
				//NewRatePlan.Booking_Enddate();
				NewRatePlan.Checkin_startdate();
				//NewRatePlan.checkout_date();
				NewRatePlan.minLeadtime(MinLeadtime);
				NewRatePlan.MaxLeadtime(MaxLeadtime);
				NewRatePlan.MinLos(MinLos);
				NewRatePlan.MaxLos(MaxLos);
				NewRatePlan.CallCentersearch();
				NewRatePlan.display_offers();
				NewRatePlan.Select_Basicpolicy();
				NewRatePlan.selectpolicyid(EnterSelectedpolicyid);
				NewRatePlan.inventory_BaseRatePlan(Usrinput);
				/*NewRatePlan.deriverates();
				NewRatePlan.Selectrateplan(Rateplan);*/
				NewRatePlan.Rooms_inventory();
				NewRatePlan.notes(AdditionalNotes, AgentComment);
				NewRatePlan.click_save();
				
			 
				//NewRatePlan.Addnew(Name, Ratecode,Category, ShortDescription, imagePath, MinLeadtime, MaxLeadtime, MinLos, MaxLos,EnterSelectedpolicyid,Usrinput, AdditionalNotes,AgentComment);
				
			} catch (Exception e) {
				logger.error("Unable to create Rate Plan" + e);
				test.log(Status.ERROR, "Unable to create Rate Plan" + e);
				e.printStackTrace();
				Assert.assertEquals(false, true);
			}
		}
		}



