package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.RoomHierarchy;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;



public class TC_RoomHierarchy extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	@DataProvider
	public Object[][] dataSupplier() throws IOException {
		
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "RoomHierarchy");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void createRoomType(HashMap<String, String> h) throws InterruptedException, IOException
	{

		try 
		{
           
			RoomHierarchy RmHrhy = PageFactory.initElements(SeleniumRepo.driver, RoomHierarchy.class);
			
			test = extent.createTest("Creating Room Hierarachy");
			logger.info("Creating Room Hierarachy");

			String BaseRoom = h.get("BaseRoom").toString().trim();
			String RoomHirVal = h.get("RoomHirVal").toString().trim();

			RmHrhy.createRoomHierarchy(BaseRoom, RoomHirVal);


		}
		catch (Exception e)
		{
			logger.error("Unable to create room hierarchy property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create room hierarchy for selected property because of this execption" + e);

			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

	}
}
