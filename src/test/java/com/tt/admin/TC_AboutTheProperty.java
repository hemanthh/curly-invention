/**
 * 
 */
package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AboutNearAttractions;
import com.tt.admin.pom.AboutNearBYAirPort;
import com.tt.admin.pom.AboutPDining;
import com.tt.admin.pom.AboutPRoom;
import com.tt.admin.pom.AboutTheProperty;
import com.tt.admin.pom.Rooms_delete;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * @author DM
 *
 */
public class TC_AboutTheProperty extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "AboutTheProperty");

		return (testObjArray);
	}

	@DataProvider
	public Object[][] meetingRoomsDataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "AboutMeetingRooms");

		return (testObjArray);
	}

	@DataProvider
	public Object[][] diningLocationDataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "AboutPDining");

		return (testObjArray);
	}

	@DataProvider
	public Object[][] nearByAirportDataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "AboutNearByAirport");

		return (testObjArray);
	}

	@DataProvider
	public Object[][] nearByAttractionDataSupplier() throws IOException {

		String fileName = System.getProperty("user.dir") + "\\TestData\\AdminTestData\\"
				+ ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "AboutNearByAttraction");

		return (testObjArray);
	}
	
	

	//@Test(priority = 2, enabled = true, description = "Same Day Check-In BE Availability ")
	public void removingAboutPropItems() throws InterruptedException, IOException {

		AboutTheProperty abtPropertyPg = PageFactory.initElements(SeleniumRepo.driver, AboutTheProperty.class);

	}

	@Test( priority = 1, enabled = true, dataProvider = "dataSupplier", description = "About the Property Landing page")
	public void aboutThePropertyPage(HashMap<String, String> h) throws InterruptedException, IOException {
		
		test = extent.createTest("TT About Property Page");


		AboutTheProperty abtPropertyPg = PageFactory.initElements(SeleniumRepo.driver, AboutTheProperty.class);
		
		AboutPRoom  CrtPRoom =PageFactory.initElements(SeleniumRepo.driver, AboutPRoom .class);
		
		AboutPDining  CrtPDining =PageFactory.initElements(SeleniumRepo.driver, AboutPDining .class);

		AboutNearBYAirPort NearByAirport =PageFactory.initElements(SeleniumRepo.driver, AboutNearBYAirPort.class);

		AboutNearAttractions NearByAttract = PageFactory.initElements(SeleniumRepo.driver, AboutNearAttractions.class);

		
		String year_built = h.get("YearBuilt").toString().trim();
		String year_renovated = h.get("YearRenovated").toString().trim();
		String property_type = h.get("PropertyType").toString().trim();
		String seg = h.get("Segment").toString().trim();
		String local = h.get("Location").toString().trim();
		String ada_compliance = h.get("ADACompliance").toString().trim();
		String pets_allowed = h.get("PetsAllowed").toString().trim();
		String us_safety_comp = h.get("UsFireSafetyCompliance").toString().trim();

		
		abtPropertyPg.enablingChannelTypeGDS();
		

		abtPropertyPg.navigateToAboutTheProperty_Pg();

		abtPropertyPg.editAboutPropYearBuilt(year_built);
		abtPropertyPg.editAboutPropYearRenovated(year_renovated);
		abtPropertyPg.editAboutPropType(property_type);
		abtPropertyPg.editAboutPropSegment(seg);
		abtPropertyPg.editAboutPropLocation(local);
		abtPropertyPg.editAboutPropAdaCompliance(ada_compliance);
		abtPropertyPg.editAboutPropPetsAllowed(pets_allowed);
		abtPropertyPg.editAboutPropUsFireSafety(us_safety_comp);
		abtPropertyPg.aboutPropertySave();
		//abtPropertyPg.aboutPropertyCancel();
		
		//abtPropertyPg.navigateToAboutTheProperty_Pg();

		abtPropertyPg.navigateToAddMeetingRoom_Pg();
		abtPropertyPg.verifyingMeetingRoom_Pg();
		CrtPRoom.requiredFieldErrorCheck();


		abtPropertyPg.navigateToAboutTheProperty_Pg();

		//abtPropertyPg.navigateToEditingMeetingRoom_Pg("BoardRoom");
		//abtPropertyPg.verifyingMeetingRoom_Pg();



		abtPropertyPg.navigateToAboutTheProperty_Pg();
		
		abtPropertyPg.navigateToAddDining_Pg();
		abtPropertyPg.verifyingDining_Pg();
		CrtPDining.requiredFieldErrorCheck();
		
		
		
		abtPropertyPg.navigateToAboutTheProperty_Pg();
		
		//abtPropertyPg.navigateToEditingDining_Pg("Carnegie Deli");
		//abtPropertyPg.verifyingDining_Pg();


		abtPropertyPg.navigateToAboutTheProperty_Pg();
		
		abtPropertyPg.navigateToAddNearbyAirPort_Pg();
		abtPropertyPg.verifyingNearbyAirPort_Pg();
		NearByAirport.requiredFieldErrorCheck();

		
		abtPropertyPg.navigateToAboutTheProperty_Pg();


		//abtPropertyPg.navigateToEditingNearbyAirPort_Pg("John F. Kennedy International AirPort");
		//abtPropertyPg.verifyingNearbyAirPort_Pg();
		
		
		abtPropertyPg.navigateToAboutTheProperty_Pg();
		
		abtPropertyPg.navigateToAddNearbyAttractions_Pg();
		abtPropertyPg.verifyingNearbyAttractions_Pg();
		NearByAttract.requiredFieldErrorCheck();

		abtPropertyPg.navigateToAboutTheProperty_Pg();
		
		//abtPropertyPg.navigateToEditingNearbyAttractions_Pg("Carnegie Hall");
		//abtPropertyPg.verifyingNearbyAttractions_Pg();

		abtPropertyPg.navigateToAboutTheProperty_Pg();
		
		
		abtPropertyPg.deleteAllPropertyItems();

		/*
		 call a delete methods after editing the property page 
		 
		abtPropertyPg.deleteMeetingRooms("BoardRoom");
		abtPropertyPg.deleteDiningLocation("Carnegie Deli");
		abtPropertyPg.deleteNearbyAriportLocation("John F. Kennedy International AirPort");
		abtPropertyPg.deleteNearbyAttractionLocation("Carnegie Hall");
		abtPropertyPg.deleteAllPropertyItems();
		
		
		*/


		/*
		 
		abtPropertyPg.enablingChannelTypeGDS();


navigateToAboutTheProperty_Pg();
navigateToAddMeetingRoom_Pg();
navigateToEditingMeetingRoom_Pg(String);
verifyingMeetingRoom_Pg();



deleteAllMeetingRooms()
deleteAllDiningLocation()
deleteAllNearbyAriportLocation()
deleteAllNearbyAttractionLocation()
deleteAllPropertyItems()
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 */


	}
	
	
	
	@Test(priority = 2, enabled = true, dataProvider = "meetingRoomsDataSupplier", description = "About the Property Meeting Rooms")
	public void meetingRooms(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		
		test = extent.createTest("TT About Property Meeting Rooms");


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
			
			
			int excelEntryCount = 0;

			
			
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


			//CrtAbtPropty.aboutPropertyRoom(AbouttheProperty, YearBuilt, YearRenovated);

			System.out.println("----------------------------------------");
			
			CrtAbtPropty.navigateToAboutTheProperty_Pg();

			
			
			if(excelEntryCount < 1){

			

			CrtPRoom.CreatePRoom(Room_Title, RoomName, RoomCode, Type, Description, Services,
					Capacity, Units, Height, Area, Width, Length);
			
			excelEntryCount++;

			
			}else{
				
				CrtAbtPropty.navigateToAboutTheProperty_Pg();
				CrtAbtPropty.navigateToAddNearbyAttractions_Pg();
				
				CrtPRoom.editMeetingRoomName(RoomName);
				CrtPRoom.editMeetingRoomCode(RoomCode);
				CrtPRoom.editMeetingRoomType(Type);
				CrtPRoom.editMeetingRoomDescription(Description);
				CrtPRoom.editMeetingRoomServices(Services);
				CrtPRoom.editMeetingRoomCapacity(Capacity);
				CrtPRoom.editMeetingRoomUnits(Units);
				CrtPRoom.editMeetingRoomLength(Length);
				CrtPRoom.editMeetingRoomWidth(Width);
				CrtPRoom.editMeetingRoomHeight(Height);
				CrtPRoom.editMeetingRoomArea(Area);
				
				
				excelEntryCount++;

				
			}
			
			
			
			
			
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
	
	
	
	@Test(priority = 3, enabled = true, dataProvider = "diningLocationDataSupplier", description = "About the Property Dining Location")
	public void diningLocation(HashMap<String, String> h) throws InterruptedException, IOException {

		test = extent.createTest("TT About Property Dining Page");

		
		try {
			
			AboutTheProperty abtPropertyPg = PageFactory.initElements(SeleniumRepo.driver, AboutTheProperty.class);
			
			AboutPDining  CrtPDining =PageFactory.initElements(SeleniumRepo.driver, AboutPDining .class);



			String RestaurantName = h.get("RestaurantName").toString().trim();
			String Code = h.get("Code").toString().trim();
			String Proximity = h.get("Proximity").toString().trim();
			String Cuisine = h.get("Cuisine").toString().trim();
			String Description = h.get("Description").toString().trim();
			String Address1 = h.get("Address1").toString().trim();
			String City = h.get("City").toString().trim();
			String Country = h.get("Country").toString().trim();
			String Zipcode = h.get("Zipcode").toString().trim();
			String Distance_Away = h.get("Distance_Away").toString().trim();
			String Distance  = h.get("Distance").toString().trim();

			int excelEntryCount = 0;


			test = extent.createTest("Creating Property Dining with name   "+RestaurantName);
			logger.info("Creating Property Dining with name   "+RestaurantName);
			
			
			if(excelEntryCount < 1){


			CrtPDining.aboutPDining(RestaurantName, Code, Proximity, 
					Cuisine, Description, Address1, City, Country, Zipcode, Distance_Away,Distance);
			
			excelEntryCount++;

			
			}else{
				
				
				abtPropertyPg.navigateToAboutTheProperty_Pg();
				abtPropertyPg.navigateToAddNearbyAttractions_Pg();
				
				CrtPDining.requiredFieldErrorCheck();
				
				CrtPDining.editDiningName(RestaurantName);
				CrtPDining.editAirportCode(Zipcode);
				CrtPDining.editDiningProximity(Proximity);
				CrtPDining.editDiningCuisine(Cuisine);
				CrtPDining.editDiningDescription(Description);
				CrtPDining.editDiningAddress(Address1);
				CrtPDining.editDiningCity(City);
				CrtPDining.editDiningCountry(Country);
				CrtPDining.editDiningDistanceAway(Distance_Away, Distance);
				
				CrtPDining.clickDiningSaveButton();
				
				
				excelEntryCount++;
				
				
				
			}
			
			
			
			
			System.out.println("-------Restaurant Name "+RestaurantName+" created successfully---------");
			
			test.log(Status.INFO, "-------Restaurant Name "+RestaurantName+" created successfully---------");
			logger.info("-------Restaurant Name "+RestaurantName+" created successfully---------");
			
			/*finalAssertTrue(true,
					"Near By Dining  selected successfully");*/


		}
		catch (Exception e) 
		{
			logger.error("Unable to  Property Dining " + e);
			test.log(Status.ERROR, "Unable to create  Property Dining " + e);
			e.printStackTrace();
			/*finalAssertTrue(true,
					"Failed to select Near By Dining ");*/
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}


	}
	
	
	
	
	@Test(priority = 4, enabled = true, dataProvider = "nearByAirportDataSupplier", description = "About the Property Nearby Airport")
	public void nearbyAirport(HashMap<String, String> h) throws InterruptedException, IOException {
		
		test = extent.createTest("TT About Near By Airport  Page");

		
		try {
			
		AboutTheProperty abtPropertyPg = PageFactory.initElements(SeleniumRepo.driver, AboutTheProperty.class);

		AboutNearBYAirPort NearByAirport =PageFactory.initElements(SeleniumRepo.driver, AboutNearBYAirPort.class);
		
		
			String AirportName = h.get("AirportName").toString().trim();
			String AirportCode = h.get("AirportCode").toString().trim();
			String AirportURL = h.get("AirportURL").toString().trim();
			String AirportDescription = h.get("AirportDescription").toString().trim();
			String AirportAddress1 = h.get("AirportAddress1").toString().trim();
			String AirportCity = h.get("AirportCity").toString().trim();
			String AirportCountry = h.get("AirportCountry").toString().trim();
			String Zipcode = h.get("Zipcode").toString().trim();
			String DistanceAway = h.get("DistanceAway").toString().trim();
			String DistanceUnit = h.get("DistanceUnit").toString().trim();
			String TranspotationMode = h.get("TranspotationMode").toString().trim();
			
			int excelEntryCount = 0;


			System.out.println("----------------------------------------");
			
			test = extent.createTest(" Creating NearBy Airport "+AirportName);
			logger.info(" Creating NearBy Airport "+AirportName);
			
			
			if(excelEntryCount < 1){
			
			NearByAirport.nearByAirport(AirportName, AirportCode, AirportURL, AirportDescription, 
					AirportAddress1, AirportCity, AirportCountry, Zipcode, DistanceAway, 
					DistanceUnit,TranspotationMode);
			
			excelEntryCount++;

			
			
			}else{
				
				
				abtPropertyPg.navigateToAboutTheProperty_Pg();
				abtPropertyPg.navigateToAddNearbyAttractions_Pg();
				
				NearByAirport.clickNearbyAirportSaveButton();
				
				NearByAirport.editAirportName(AirportName);
				NearByAirport.editAirportCode(AirportCode);
				NearByAirport.editAirportUrl(AirportURL);
				NearByAirport.editAirportDescription(AirportDescription);
				NearByAirport.editAirportAddress(AirportAddress1);
				NearByAirport.editAirportCity(AirportCity);
				NearByAirport.editAirportCountry(AirportCountry);
				NearByAirport.editAirportZipCode(Zipcode);
				NearByAirport.editAirportDistanceAway(DistanceAway, DistanceUnit);
				NearByAirport.editAirportTransportaionMethod(TranspotationMode);
				
				NearByAirport.clickNearbyAirportSaveButton();
				
				
				excelEntryCount++;

			}
			
			
			
			
			
			
			System.out.println("-------Airport Name "+AirportName+" created successfully---------");
			test.log(Status.INFO, "-------Airport Name "+AirportName+" created successfully---------");
			
			/*finalAssertTrue(true,
				    "Near By Airport  selected successfully");*/
			
			
		} catch (Exception e) {
			logger.error("Unable to create NearBy Airport" + e);
			test.log(Status.ERROR, "Unable to create NearBy Airport" + e);
			/*finalAssertTrue(true,
				    "Failed to select Near By Airport ");*/
			e.printStackTrace();
			Assert.assertEquals(false,true);
		}
		
	}

	@Test(priority = 5, enabled = true, dataProvider = "nearByAttractionDataSupplier", description = "About the Property Nearby Attraction")
	public void nearbyAttraction(HashMap<String, String> h) throws InterruptedException, IOException {

		test = extent.createTest("TT About Property Near By Attraction Page");

		
		try {
			
			AboutTheProperty abtPropertyPg = PageFactory.initElements(SeleniumRepo.driver, AboutTheProperty.class);

			
			AboutNearAttractions NearByAttract = PageFactory.initElements(SeleniumRepo.driver, AboutNearAttractions.class);

			String NBA_Name = h.get("NBA_Name").toString().trim();
			String NBA_Code = h.get("NBA_Code").toString().trim();
			String NBA_Type = h.get("NBA_Type").toString().trim();
			String NBA_URL = h.get("NBA_URL").toString().trim();
			String NBA_Description = h.get("NBA_Description").toString().trim();
			String NBA_Address1 = h.get("NBA_Address1").toString().trim();
			String NBA_City = h.get("NBA_City").toString().trim();
			String NBA_Zipcode = h.get("NBA_Zipcode").toString().trim();
			String NBA_Country = h.get("NBA_Country").toString().trim();
			String NBA_DistanceAway = h.get("NBA_DistanceAway").toString().trim();
			String DistanceUnit = h.get("DistanceUnit").toString().trim();
			String TranspotationMode = h.get("TranspotationMode").toString().trim();
			
			int excelEntryCount = 0;

			System.out.println("----------------------------------------");

			test = extent.createTest(" Creating Near By Attraction Property " + NBA_Name);
			logger.info("Creating Near By Attraction Property " + NBA_Name);
			

			
			
			if(excelEntryCount < 1){

			NearByAttract.nearByAttraction(NBA_Name, NBA_Code, NBA_Type, NBA_URL, NBA_Description, NBA_Address1,
					NBA_City, NBA_Zipcode, NBA_Country, NBA_DistanceAway, DistanceUnit, TranspotationMode);

			excelEntryCount++;
			
			}else{
				
				abtPropertyPg.navigateToAboutTheProperty_Pg();
				abtPropertyPg.navigateToAddNearbyAttractions_Pg();
				
				NearByAttract.clickNearbyAttractionSaveButton();
				
				NearByAttract.editAttractionName(NBA_Name);
				NearByAttract.editAttractionCode(NBA_Code);
				NearByAttract.editAttractionType(NBA_Type);
				NearByAttract.editAttractionUrl(NBA_URL);
				NearByAttract.editAttractionDescription(NBA_Description);
				NearByAttract.editAttractionAddress(NBA_Address1);
				NearByAttract.editAttractionCity(NBA_City);
				NearByAttract.editAttractionCountry(NBA_Country);
				NearByAttract.editAttractionZipCode(NBA_Zipcode);
				NearByAttract.editAttractionDistanceAway(NBA_DistanceAway, DistanceUnit);
				NearByAttract.editAttractionTransportaionMethod(TranspotationMode);
				
				NearByAttract.clickNearbyAttractionSaveButton();

				excelEntryCount++;


				
			}
			
			
			
			System.out.println("-------Attraction Name " + NBA_Name + " created successfully---------");
			test.log(Status.INFO, "-------Attraction Name " + NBA_Name + " created successfully---------");

			/*
			 * finalAssertTrue(true,
			 * "Near By Attraction  selected successfully");
			 */

		} catch (Exception e) {
			logger.error("Unable to create Near By Attraction property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Near By Attraction property because of this execption" + e);
			/*
			 * finalAssertTrue(true, "Failed to select Near By Attraction ");
			 */
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}
	}

}
