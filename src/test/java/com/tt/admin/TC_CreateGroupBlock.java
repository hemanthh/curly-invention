package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Group_Blocks;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class TC_CreateGroupBlock extends BaseTest
{
	Logger logger = Logger.getLogger(TC_RateGrid.class);
	String Errors;
	String Name ;
	String BlockCode;
	String Shortdescription ;
	String Detailed_description;
	String releasedate;
	
	@Test(dataProvider = "Group_Blocks",description="Create Group Blocks")
	public void GroupBlocks(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		try {
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
			Group_Blocks group=PageFactory.initElements(SeleniumRepo.driver, Group_Blocks.class);
			
			test = extent.createTest(" Creating GroupBlock");
			logger.info("Creating GroupBlock");

			Errors=h.get("ErrorMesg").toString().trim();
			Name = h.get("Name").toString().trim();
			BlockCode = h.get("BlockCode").toString().trim();
			Shortdescription = h.get("Shortdescription").toString().trim();
			Detailed_description = h.get("Detailed_description").toString().trim();
			releasedate = h.get("releasedate").toString().trim();

			group.click_ListAll();
			group.Delete_Group(Name);
			group.Click_Addnew();
			group.click_save();
			group.verify_ErrorMessages(Errors);
			group.click_cancel();
			group.Click_Addnew();
			group.verify_Groupblock_details();
			group.Enter_name(Name);
			group.Enter_Blockcode(BlockCode);
			group.Enter_ShortDescription(Shortdescription);
			group.Enter_Detailedescription(Detailed_description);
			group.Select_Rooms();
			group.Enter_releasedate(releasedate);
			group.Enter_checkSdate();
			group.Enter_CheckEdate(releasedate);
			group.click_save();
			group.click_Manageinvenotry(Name);
			group.Click_Submit();
			group.inventory();
			NewRategrid.Click_Update();
			group.click_ListAll();

			group.click_Manageinvenotry(Name);
			group.Click_Submit();


		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
		}
	}
}
