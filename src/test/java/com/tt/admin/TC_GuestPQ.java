package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.admin.pom.DeleteGuestPreference;
import com.tt.admin.pom.GuestPreferenceQuestion;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;


/**
 * 
 * @author TT072
 *This test case adds Guest Preference questions by taking test data from Excel
 */

public class TC_GuestPQ extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "GuestPQ");

		return (testObjArray);
	}
	
	
	
	@DataProvider
	public Object[][] dataSupplierVer() throws IOException 
	{

		
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "GuestPreferenceQuestions");

		return (testObjArray);
	}
	
	@Test(priority=1, enabled=true , description = "Deleting all exsisting questions" )
	public void removingAllQuestiongs() throws InterruptedException
	{
		System.out.println("enter---------------------");
		
		test = extent.createTest("Deleting all Guest Prefernce Questions ");
		logger.info("Deleting all Guest Prefernce Questions");

		
		GuestPreferenceQuestion CrtGuestPQ = PageFactory.initElements(SeleniumRepo.driver, GuestPreferenceQuestion.class);
		
		CrtGuestPQ.click_GuestPreferQues_ListAll();
		CrtGuestPQ.updateGuestPrefQuestOrder(1, 5);
		SeleniumRepo.waitForPageLoaded();
		CrtGuestPQ.changeQuestionBeDisplayStatus("Expanded");
		CrtGuestPQ.deleteAllQuestions();

	}

	@Test(priority=2, enabled=true, dataProvider = "dataSupplier" )
	public void guestPQ(HashMap<String, String> hMap) throws InterruptedException, IOException 
	{
		try
		{
			
			String GuestPType = hMap.get("GuestPType").toString().trim();
			String MaxOptions = hMap.get("MaxOptions").toString().trim();
			String FieldQuestion = hMap.get("FieldQuestion").toString().trim();
			String FieldQuestionLabel = hMap.get("FieldQuestionLabel").toString().trim();
			String FieldQuestion_1_Label = hMap.get("FieldQuestion_1_Label").toString().trim();
			String FieldQuestion_1_Guest_Options = hMap.get("FieldQuestion_1_Guest_Options").toString().trim();
			
		
			
			GuestPreferenceQuestion CrtGuestPQ = PageFactory.initElements(SeleniumRepo.driver, GuestPreferenceQuestion.class);

				
				test = extent.createTest("Creating Guest Prefernce Questions "+FieldQuestion);
				logger.info("Creating Guest Prefernce Questions "+FieldQuestion);

				
				CrtGuestPQ.creatGuestPQ(GuestPType, MaxOptions, FieldQuestion, FieldQuestionLabel, FieldQuestion_1_Label,FieldQuestion_1_Guest_Options);


				
				
		}
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

		
	}
	
	
	
	@Test(priority=3, enabled=true, dataProvider ="dataSupplierVer" )
	public void creatingGuestQuestions(HashMap<String, String> hMap) throws InterruptedException, IOException 
	{
		try
		{
			
			String GuestPType = hMap.get("GuestPType").toString().trim();
			String MaxOptions = hMap.get("MaxOptions").toString().trim();
			String FieldQuestion = hMap.get("FieldQuestion").toString().trim();
			//String FieldQuestionLabel = hMap.get("FieldQuestionLabel").toString().trim();
			//String FieldQuestion_1_Label = hMap.get("FieldQuestion_1_Label").toString().trim();
			String FieldQuestion_1_Guest_Options = hMap.get("FieldQuestion_1_Guest_Options").toString().trim();
			
			System.out.println(" queessllss    "+FieldQuestion);
			System.out.println(" Weeoo99s    "+FieldQuestion_1_Guest_Options);

			
			GuestPreferenceQuestion CrtGuestPQ = PageFactory.initElements(SeleniumRepo.driver, GuestPreferenceQuestion.class);

				test = extent.createTest("Creating Single Selection, Multiple Selection and Text Guest Prefernce Questions ");
				logger.info("Creating Single Selection, Multiple Selection and Text Guest Prefernce Questions");
				
				switch(GuestPType){
				
				
				case "single":
					
					CrtGuestPQ.click_GuestPreferQues_AddNew();
					CrtGuestPQ.createGuestPrefQuest_SingleSelect(FieldQuestion, FieldQuestion_1_Guest_Options);
					//CrtGuestPQ.clickGuestPrefCancelButton();
					CrtGuestPQ.clickGuestPrefSaveButton();
					
					break;
					
				case "multiple":
					
					CrtGuestPQ.click_GuestPreferQues_AddNew();
					CrtGuestPQ.createGuestPrefQuest_MultiSelect(FieldQuestion, FieldQuestion_1_Guest_Options, MaxOptions);
					//CrtGuestPQ.clickGuestPrefCancelButton();
					CrtGuestPQ.clickGuestPrefSaveButton();
					
					System.out.println("From the TC of guest preference questions  multiple sec");
					
					break;
					
				case "freeText":
					
					CrtGuestPQ.click_GuestPreferQues_AddNew();
					CrtGuestPQ.createGuestPrefQuest_FreeText(FieldQuestion);
					//CrtGuestPQ.clickGuestPrefCancelButton();
					CrtGuestPQ.clickGuestPrefSaveButton();				
				
				}

				
		}
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

		
	}
	
	
	//NoTE: if you want to use the excel sheet you would need to create a new spread sheet 
	//and only provide data you wish to change 
	@Test(priority=4, enabled=true , description = "Editing questions" )
	public void editingGuestQuestions() throws InterruptedException, IOException 
	{
		try
		{
				

			GuestPreferenceQuestion CrtGuestPQ = PageFactory.initElements(SeleniumRepo.driver, GuestPreferenceQuestion.class);

			String question = "What premium channel would you like to watch during your stay?";
			String questionAndLabel = "Channel Selection:What premium channel would you like to watch during your stay?";
			String questionOptAndLabel ="Home:HBO;Time:ShowTime;Lights:Starz;Max:CineMax;More:Encore";
			String maxOpt = "5";
				
				test = extent.createTest("Editing Guest Prefernce Questions ");
				logger.info("Editing Guest Prefernce Questions ");
				
				CrtGuestPQ.click_GuestPreferQues_AddNew();
				CrtGuestPQ.createGuestPrefQuest_MultiSelect(questionAndLabel, questionOptAndLabel, maxOpt);
				
				CrtGuestPQ.clickGuestPrefSaveButton();

				SeleniumRepo.waitForPageLoaded();
				
				CrtGuestPQ.click_GuestPreferQues_ListAll();
				
				SeleniumRepo.waitForPageLoaded();


				CrtGuestPQ.click_guestPrefQuestEditLink(question);
				
				SeleniumRepo.waitForPageLoaded();

				
				
				//Make changes to question and save from time to time 				
				
				CrtGuestPQ.editGuestPrefQuestType("single");
				CrtGuestPQ.editGuestPrefQuestCategory("Room");
				CrtGuestPQ.editGuestPrefQuestRequired("disable");
				CrtGuestPQ.editGuestPrefQuestChannels("HWEB");
				
				CrtGuestPQ.clickGuestPrefSaveButton();
				
				
				CrtGuestPQ.click_guestPrefQuestEditLink(question);
				
				CrtGuestPQ.editGuestPrefQuestQuestion("lol");
				CrtGuestPQ.editGuestPrefQuestQuestionLabel("OMG");
				CrtGuestPQ.editGuestPrefQuestOptionsAndLabel("Home", "HBO", "ush", "Big Push");
				
				CrtGuestPQ.deleteQuestionOption("More", "Encore");
				
				CrtGuestPQ.editGuestPrefQuestPmsDelivery("Special Request");

				CrtGuestPQ.clickGuestPrefSaveButton();

				SeleniumRepo.waitForPageLoaded();

				CrtGuestPQ.deleteQuestion("lol");
				
			
				
		}
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}

		
	}
	
	
	
	
	
}
