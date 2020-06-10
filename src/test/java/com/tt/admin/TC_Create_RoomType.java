package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.ADD_Rooms;
import com.tt.admin.pom.DeleteRoomsInList;
import com.tt.admin.pom.RoomTypeCreation;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;



/**
 * 
 * @author TT072
 *This test case creates Room Types for selected property by fetching values from Excel
 */
public class TC_Create_RoomType extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {
		
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "RoomCreation");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier",groups = {"SMOKE"}, enabled = true )
	public void createRoomType(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
			
			RoomTypeCreation roomTypeCreation = PageFactory.initElements(SeleniumRepo.driver, RoomTypeCreation.class);
			DeleteRoomsInList Delete =PageFactory.initElements(SeleniumRepo.driver, DeleteRoomsInList.class);
			
			ADD_Rooms ADD_Rooms = PageFactory.initElements(SeleniumRepo.driver, ADD_Rooms.class);

			
			String roomName = h.get("RoomName").toString().trim();
			String roomCode = h.get("RoomCode").toString().trim();
			String roomShortDesc = h.get("RoomShortdescription").toString().trim();
			String roomDetailedDesc = h.get("RoomDetailedDescription").toString().trim();
			String roomImageName = h.get("RoomUploadImageName").toString().trim();
			String roomImageDesc = h.get("RoomUploadImageDescription").toString().trim();
			String roomImageAltText = h.get("RoomuploadImageAltText").toString().trim();
			String roomImagePath = h.get("roomImagePath").toString().trim();
			String roomSize = h.get("RoomSize").toString().trim();
			String subroomSize = h.get("SubRoomSize").toString().trim();
			String extraAdultCharge = h.get("extraAdultCharge").toString().trim();
			String extraChildCharge = h.get("ExtraChildCharge").toString().trim();
			String maxadultPerRoom = h.get("MaxAdultsInRoom").toString().trim();
			String minAdultsPerRoom = h.get("EnterMinAdultOccupancy").toString().trim();
			String maxAdultsPerRoom = h.get("EnterMaxAdultOccupancy").toString().trim();
			String minChildrenPerRoom = h.get("EnterMinChildOccupancy").toString().trim();
			String maxChildrenPerRoom = h.get("EnterMaxChildOccupancy").toString().trim();
			String maxOccupancyPerRoom = h.get("EnterTotlaMaxOccupancy").toString().trim();
			
		
			test = extent.createTest( "Delete and Create room" +roomName);
			logger.info( "Delete and Create room" +roomName);
			
			System.out.println(maxOccupancyPerRoom);
			System.out.println("----------------------------------------");
		
			ADD_Rooms.Rooms_link();
			ADD_Rooms.Click_Listall();
			
			ADD_Rooms.delete_rooms(roomName);
			
			ADD_Rooms.addnew(roomName);
			ADD_Rooms.name(roomName);
			ADD_Rooms.code(roomCode);
			ADD_Rooms.roomCategories.click();
			//ADD_Rooms.GDS_Code();
			ADD_Rooms.bed_types();
			ADD_Rooms.description(roomShortDesc, roomDetailedDesc);
			ADD_Rooms.image(roomImageName, roomImageDesc, roomImageAltText, roomImagePath);
			ADD_Rooms.room_size(roomSize, subroomSize, extraAdultCharge, extraChildCharge, maxadultPerRoom, minAdultsPerRoom, maxAdultsPerRoom, minChildrenPerRoom, maxChildrenPerRoom, maxOccupancyPerRoom);
			
			System.out.println("------------room name "+roomName+" deleted and created");
			logger.info("------------room name "+roomName+" deleted and created");
			test.log(Status.INFO, "------------room name "+roomName+" deleted and created");
		
		} catch (Exception e) {
			logger.error("Unable to create room type for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create room type for selected property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

	}
}
