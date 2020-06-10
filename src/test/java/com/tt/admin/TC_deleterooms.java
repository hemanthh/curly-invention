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





public class TC_deleterooms extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	/*@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AboutPRoom");

		return (testObjArray);
	}*/
	
	@Test()
	public void propertyRoom() throws InterruptedException, IOException 
	{
		
		try {
		
		Rooms_delete  rooms_delete =PageFactory.initElements(SeleniumRepo.driver, Rooms_delete .class);
		
			
			rooms_delete.AbouttheProperty_Link();
			rooms_delete.delete();
		
	
	System.out.println("----------------------------------------");
	
	
	   } catch (Exception e) {
		logger.error("Unable to create About Property Room because of this execption" + e);
		test.log(Status.ERROR, "Unable to create About Property Room because of this execption" + e);
		//finalAssertTrue(false,"Failed to select Property Room ");
		e.printStackTrace();
		Assert.assertEquals(false, true);
		}
		}
		}
	
