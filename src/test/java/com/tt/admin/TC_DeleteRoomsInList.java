package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.DeleteRoomsInList;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_DeleteRoomsInList extends BaseTest{
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\TestData.xlsx", "DeleteRoomList");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier")
	
	public void deleteRMList(HashMap<String, String> h) throws Exception {
		try {
		test = extent.createTest("Taxes And Fees");
     	logger.info("Add Taxes & Fees  ");
     	DeleteRoomsInList Delete =PageFactory.initElements(SeleniumRepo.driver, DeleteRoomsInList.class);
			  String Room1= h.get("Room1").toString().trim();
	
			  Delete .deleteRooms(Room1);
	
	
		} catch (Exception e) {
			logger.error("Unable to create Taxes And Fees property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Taxes And Fees property because of this execption" + e);
			e.printStackTrace();
	
	
	
		}}}
	
	
	
	
	
	

