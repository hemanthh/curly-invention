package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AboutPRoom;
import com.tt.admin.pom.AboutTheProperty;
import com.tt.admin.pom.Rooms_delete;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_AboutPRoom extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AboutMeetingRooms");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier",groups="TC_AboutPRoom")
	public void propertyRoom(HashMap<String, String> h) throws InterruptedException, IOException 
	{

		try {
			AboutTheProperty CrtAbtPropty =PageFactory.initElements(SeleniumRepo.driver, AboutTheProperty.class);
			AboutPRoom  CrtPRoom =PageFactory.initElements(SeleniumRepo.driver, AboutPRoom .class);
			Rooms_delete  rooms_delete =PageFactory.initElements(SeleniumRepo.driver, Rooms_delete .class);



			String AbouttheProperty = h.get("AbouttheProperty").toString().trim();
			String YearBuilt= h.get("YearBuilt").toString().trim();
			String YearRenovated= h.get("YearRenovated").toString().trim();
			String Room_Title= h.get("Room_Title").toString().trim();
			String RoomName= h.get("RoomName").toString().trim();
			String RoomCode= h.get("RoomCode").toString().trim();
			String Type= h.get("Type").toString().trim();
			String Description= h.get("Description").toString().trim();
			String Services= h.get("Services").toString().trim();
			String Capacity=null;
			try {
				Capacity= h.get("Capacity").toString().trim();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			String Units= h.get("Units").toString().trim();
			String Height= h.get("Height").toString().trim();
			String Area= h.get("Area").toString().trim();
			String  Width= h.get("Width").toString().trim();
			String Length= h.get("Length").toString().trim();

			test = extent.createTest("Creating "+RoomName+" meeting Room ");
			logger.info("Creating "+RoomName+" meeting Room" );
			
			
			System.out.println(Room_Title+ " " + RoomName + "  " + RoomCode + "  " + Type + "  " + Description + " " + Services +
					"  " + Capacity  + "  " + Units+ " " + Height + Area + Width + Length);


			CrtAbtPropty .aboutPropertyRoom(AbouttheProperty, YearBuilt, YearRenovated);

			System.out.println("----------------------------------------");

			CrtPRoom.CreatePRoom(Room_Title, RoomName, RoomCode, Type, Description, Services,
					Capacity, Units, Height, Area, Width, Length);
			
			System.out.println("-------Meeting rooms "+RoomName+" created successfully---------");
			test.log(Status.INFO, "-------Meeting rooms "+RoomName+" created successfully---------");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.error("Unable to create About Property Room because of this execption" + e);
			test.log(Status.ERROR, "Unable to create About Property Room because of this execption" + e);
			/*finalAssertTrue(false,
					"Failed to select Property Room ");*/
			Assert.assertEquals(false, true);
		}
	}
}



