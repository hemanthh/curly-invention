package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AboutPDining;
import com.tt.admin.pom.Rooms_delete;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class TC_Rooms_delete extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	@Test
	public void propertyDining(HashMap<String, String> h) throws InterruptedException, IOException {


		Rooms_delete  rooms_delete =PageFactory.initElements(SeleniumRepo.driver, Rooms_delete .class);

		System.out.println("enterd into delete");

		test = extent.createTest("delete the rooms");
		logger.info("delete the rooms");
		
		
		rooms_delete.Click_PropertyManagement();
		rooms_delete.AbouttheProperty_Link();
		rooms_delete.delete();
		System.out.println("----------------------------------------");




	}


}
