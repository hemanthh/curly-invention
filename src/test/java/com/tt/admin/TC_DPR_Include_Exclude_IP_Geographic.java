package com.tt.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.BE.pom.ClasicFlow;
import com.tt.BE.pom.ClassicFlow_AvailPage;
import com.tt.admin.pom.AlternateProperties;
import com.tt.admin.pom.Dynamic_Pricing_Rules;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_DPR_Include_Exclude_IP_Geographic extends BaseTest
{
	Logger logger = Logger.getLogger(TC_DPRTestCases_FlatAmount.class);
	String RuleName ;
	String RuleCode ;
	String ShortDescription ;
	String FlatAmount ;
	String Percentage;
	String Errors ;
	String SteadyDays ;
	String SteadyFlatAmount ;
	String NthNight;
	String DOW_ALL;
	String DOW_AnyDay;
	String EnterCurrency ;
	String Enterrooms;
	String roomtype;
	String FirstName;
	String LastName;
	String Email;
	String Cardname;
	String Numberoncard;
	String Entercountry;
	String Address;
	String Address2;
	String Entercity;
	String Enterstate;
	String Enterzipcode;
	String Enterphonenum;
	String RatePlan;
	float Discountprice;
	String IPAddress;
	String Continent;
	String Country;
	String State;
	String City;

	@DataProvider
	public Object[][] DPR() throws IOException
	{
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "DPR");

		return (testObjArray);
	}
	@DataProvider
	public Object[][] ClasicFlow() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "ClasicFlow");

		return (testObjArray);
	}

	@Test(dataProvider="DPR",enabled=true,priority=1)
	public void AddNew_DPR_STAY_CONDITIONS_Black_out_Date(HashMap<String, String> h)
	{
		try 
		{

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties = PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);

			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);



			RuleName = h.get("RuleName").toString().trim();
			RuleCode = h.get("RuleCode").toString().trim();
			ShortDescription = h.get("ShortDescription").toString().trim();
			FlatAmount = h.get("FlatAmount").toString().trim();
			Percentage = h.get("Precentage").toString().trim();
			Errors = h.get("Errors").toString().trim();
			SteadyDays = h.get("SteadyDays").toString().trim();
			SteadyFlatAmount = h.get("SteadyFlatAmount").toString().trim();
			NthNight = h.get("NthNight").toString().trim();
			RatePlan = h.get("RatePlan").toString().trim();
			DOW_ALL = h.get("DOW_ALL").toString().trim();
			DOW_AnyDay = h.get("DOW_AnyDay").toString().trim();
			IPAddress = h.get("IPAddress").toString().trim();
			Continent = h.get("Continent").toString().trim();
			Country = h.get("Country").toString().trim();
			State = h.get("State").toString().trim();
			City = h.get("City").toString().trim();


			test = extent.createTest("AddNew_DPR_STAY_CONDITIONS_Black_out_Date");
			logger.info("AddNew_DPR_STAY_CONDITIONS_Black_out_Date");



			DPR.Click_DPRListAll();
			DPR.Delete_DuplictaeDPR(RuleName);
			DPR.Click_DPRAddNew();
			DPR.Enter_RuleName(RuleName);
			DPR.Enter_RuleCode(RuleCode);
			DPR.Enter_ShortDescription(ShortDescription);
			DPR.Enter_BlackOutstartdate();
			DPR.Enter_BlackOutEnddate();
			DPR.Select_DPRDiscountTypeFlatAmount("Flat Amount", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_ALL,RatePlan,NthNight,Percentage);
			AlternateProperties.Click_Save();
			DPR.verifyDPRatTitlePage(RuleName);
			

		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

	@Test(dataProvider="ClasicFlow",description="Verify in BE",enabled=true,priority=2)
	public void VerfiyinBE_AddNewDPR_Using_Include_IPAddress(HashMap<String, String> h2) throws ParseException, IOException
	{

		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);

		Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);

		EnterCurrency = h2.get("EnterCurrency").toString().trim();
		Enterrooms = h2.get("Enterrooms").toString().trim();
		roomtype = h2.get("roomtype").toString().trim();
		FirstName = h2.get("FirstName").toString().trim();
		LastName = h2.get("LastName").toString().trim();
		Email = h2.get("Email").toString().trim();
		Cardname = h2.get("Cardname").toString().trim();
		Numberoncard = h2.get("Numberoncard").toString().trim();
		Entercountry = h2.get("Entercountry").toString().trim();
		Address = h2.get("Address").toString().trim();
		Address2 = h2.get("Address2").toString().trim();
		Entercity = h2.get("Entercity").toString().trim();
		Enterstate = h2.get("Enterstate").toString().trim();
		Enterzipcode = h2.get("Enterzipcode").toString().trim();
		Enterphonenum = h2.get("Enterphonenum").toString().trim();
		
		try 
		{
			//windowid();
			SeleniumRepo.driver.switchTo().window(NewWindow);

			clasicflow.GoToUrl();
			clasicflow.verifyDPRforBlackoutdates();
			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			classicFlowAvailPage.select_Rooms(Enterrooms);
			classicFlowAvailPage.room_type(roomtype);
			clasicflow.Verify_Strike("BlackOutDates");
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

	@Test(dataProvider="DPR",enabled=true,priority=3)
	public void AddNewDPR_Using_Include_IPAddresses(HashMap<String, String> h)
	{
		try 
		{

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties = PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);




			test = extent.createTest("Add New DPR Using:IP ADDRESS FILTERING (Include IP Addresses)");
			logger.info("Add New DPR Using:IP ADDRESS FILTERING (Include IP Addresses)");


			DPR.Click_DPRListAll();
			DPR.Delete_DuplictaeDPR(RuleName);
			DPR.Click_DPRAddNew();
			DPR.Enter_RuleName(RuleName);
			DPR.Enter_RuleCode(RuleCode);
			DPR.Enter_ShortDescription(ShortDescription);
			DPR.Include_IpAddress(IPAddress);
			DPR.Enter_CheckInDate();
			DPR.Enter_CheckOutDate();
			DPR.Select_DPRDiscountTypeFlatAmount("Flat Amount", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_ALL,RatePlan,NthNight,Percentage);
			DPR.Select_Rateplan(RatePlan);
			AlternateProperties.Click_Save();
			DPR.verifyDPRatTitlePage(RuleName);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			clasicflow.GoToUrl();
			clasicflow.verify_mybooking();
			clasicflow.currencydropdown();
			classicFlowAvailPage.arrival_date();
			classicFlowAvailPage.departure_date();
			clasicflow.popup_ok();
			classicFlowAvailPage.Rooms_and_Guests(Enterrooms);
			classicFlowAvailPage.select_Rooms(Enterrooms);
			classicFlowAvailPage.room_type(roomtype);
			clasicflow.Verify_Strike("Include");

		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
	
	@Test(dataProvider="DPR",priority=4,enabled=true)
	public void VerfiyinBE_AddNewDPR_Using_Exclude_IPAddress(HashMap<String, String> h)
	{
		try 
		{
			test = extent.createTest("Add New DPR Using:IP ADDRESS FILTERING (Exclude IP Addresses)");
			logger.info("Add New DPR Using:IP ADDRESS FILTERING (Exclude IP Addresses)");

			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			
			AlternateProperties AlternateProperties = PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			DPR.Click_DPRListAll();
			DPR.OpenDPR(RuleName);
			DPR.Exclude_IpAddress(IPAddress);
			AlternateProperties.Click_Save();
			DPR.verifyDPRatTitlePage(RuleName);

			SeleniumRepo.driver.switchTo().window(NewWindow);

			classicFlowAvailPage.click_CheckavailabitlityButton();
			classicFlowAvailPage.room_type(roomtype);
			clasicflow.Verify_Strike("Exclude");
		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}
	@Test(dataProvider="DPR",priority=5,enabled=false)
	public void VerfiyinBE_AddNewDPR_Using_Include_Geographic(HashMap<String, String> h)
	{
		try 
		{
			test = extent.createTest("Add New DPR Using:GEOGRAPHIC CONDITIONS: Include only the following");
			logger.info("Add New DPR Using:GEOGRAPHIC CONDITIONS: Include only the followings");

			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);

			AlternateProperties AlternateProperties = PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			DPR.Click_DPRListAll();
			DPR.Delete_DuplictaeDPR(RuleName);
			DPR.Click_DPRAddNew();
			DPR.Enter_RuleName(RuleName);
			DPR.Enter_RuleCode(RuleCode);
			DPR.Enter_ShortDescription(ShortDescription);
			DPR.Include_GEOGRAPHIC(Continent, Country, State, City);
			DPR.Enter_CheckInDate();
			DPR.Enter_CheckOutDate();
			DPR.Select_DPRDiscountTypeFlatAmount("Flat Amount", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_ALL,RatePlan,NthNight,Percentage);
			DPR.Select_Rateplan(RatePlan);
			AlternateProperties.Click_Save();
			DPR.verifyDPRatTitlePage(RuleName);

			SeleniumRepo.driver.switchTo().window(NewWindow);

			classicFlowAvailPage.click_CheckavailabitlityButton();
			classicFlowAvailPage.room_type(roomtype);
			clasicflow.Verify_Strike("Include");


			test = extent.createTest("Add New DPR Using:GEOGRAPHIC CONDITIONS: Exclude only the following");
			logger.info("Add New DPR Using:GEOGRAPHIC CONDITIONS: Exclude only the followings");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			DPR.Click_DPRListAll();
			DPR.Delete_DuplictaeDPR(RuleName);
			DPR.Click_DPRAddNew();
			DPR.Enter_RuleName(RuleName);
			DPR.Enter_RuleCode(RuleCode);
			DPR.Enter_ShortDescription(ShortDescription);
			DPR.Exclude_GEOGRAPHIC(Continent, Country, Enterstate, City);
			DPR.Enter_CheckInDate();
			DPR.Enter_CheckOutDate();
			DPR.Select_DPRDiscountTypeFlatAmount("Flat Amount", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_ALL,RatePlan,NthNight,Percentage);
			DPR.Select_Rateplan(RatePlan);
			AlternateProperties.Click_Save();
			DPR.verifyDPRatTitlePage(RuleName);

			SeleniumRepo.driver.switchTo().window(NewWindow);

			classicFlowAvailPage.click_CheckavailabitlityButton();
			classicFlowAvailPage.room_type(roomtype);
			clasicflow.Verify_Strike("Include");

		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

}
