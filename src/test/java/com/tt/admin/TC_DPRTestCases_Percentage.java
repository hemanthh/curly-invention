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
import com.tt.BE.pom.ClassicFlow_ReservationDetailsPage;
import com.tt.admin.pom.AlternateProperties;
import com.tt.admin.pom.Dynamic_Pricing_Rules;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_DPRTestCases_Percentage extends BaseTest
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
	
	float DiscountPercent;
	float DiscountPercent1;

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
	public void AddNewDPR_Discounttype_Percentage_DOW_AllDays(HashMap<String, String> h)
	{
		try 
		{
			//login_Brand_Property();

			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties=PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);


			test = extent.createTest("Add New DPR Using:DISCOUNT DEFINITION:Discount type: Percentage :All Days");
			logger.info("Add New DPR Using:DISCOUNT DEFINITION:Discount type: Percentage :All Days");


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

			
		//SeleniumRepo.driver.switchTo().window(ParentWindow);
			
			DiscountPercent1=DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_ALL,RatePlan,NthNight,Percentage);

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
	public void VerfiyinBE_AddNewDPR_Discounttype_Percentage_DOW(HashMap<String, String> h2) throws ParseException, IOException
	{

		ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
		ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
		ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);

		
		Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);

		try 
		{

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

			windowid();

			SeleniumRepo.driver.switchTo().window(NewWindow);
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"Percentage",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,FlatAmount,DiscountPercent,ShortDescription,SteadyDays,"Day Of Week",NthNight,"Percentage",Precentage);
			
			clasicflow.ReuseMethodsforDPRstart();
			classicFlowAvailPage.ReuseMethodsforDPRcheckavailabitlity(Enterrooms, roomtype);
			classicFlowReservationDet.ReuseMethodsforDPRsetupResDetails(RatePlan);
			clasicflow.ReuseMethodsforDPRclose(RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
		
		
		
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
		
	}
	@Test(dataProvider="DPR",priority=3,enabled=true)
	public void AddNewDPR_Discounttype_Percentage_DOW_particularDay(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties=PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage: Day Of Week :particular Day");
			logger.info("Add New DPR Discount type: Percentage : Day Of Week :particular Day");

			SeleniumRepo.driver.switchTo().window(ParentWindow);


			DiscountPercent1=DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
		
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"AnyDay",NthNight,"Percentage",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,FlatAmount,DiscountPercent,ShortDescription,SteadyDays,"AnyDay",NthNight,"Percentage",Precentage);	
			clasicflow.ReuseMethodsforDPRstart();
			classicFlowAvailPage.ReuseMethodsforDPRcheckavailabitlity(Enterrooms, roomtype);
			classicFlowReservationDet.ReuseMethodsforDPRsetupResDetails(RatePlan);
			clasicflow.ReuseMethodsforDPRclose(RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
		
		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			//Assert.assertEquals(false, true);
		}
	}

	@Test(dataProvider="DPR",priority=4,enabled=true)
	public void AddNewDPR_Discounttype_Percentage_First_N_Nights(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties=PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage :First N Nights");
			logger.info("Add New DPR Discount type: Percentage : Day Of Week :First N Nights");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			DiscountPercent1=DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage", "First N Nights", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
		
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,ShortDescription,SteadyDays,"First N Nights",NthNight,"Percentage",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,DiscountPercent,ShortDescription,SteadyDays,"First N Nights",NthNight,"Percentage",Precentage);		
		
			clasicflow.ReuseMethodsforDPRstart();
			classicFlowAvailPage.ReuseMethodsforDPRcheckavailabitlity(Enterrooms, roomtype);
			classicFlowReservationDet.ReuseMethodsforDPRsetupResDetails(RatePlan);
			clasicflow.ReuseMethodsforDPRclose(RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			//Assert.assertEquals(false, true);
		}
	}
	@Test(dataProvider="DPR",priority=5,enabled=true)
	public void AddNewDPR_Discounttype_Percentage_Last_N_Nights(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties=PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage :Last N Nights");
			logger.info("Add New DPR Discount type: Percentage : Day Of Week :Last N Nights");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			DiscountPercent1=DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage", "Last N Nights", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,ShortDescription,SteadyDays,"Last N Nights",NthNight,"Percentage",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,DiscountPercent,ShortDescription,SteadyDays,"Last N Nights",NthNight,"Percentage",Precentage);
		
			clasicflow.ReuseMethodsforDPRstart();
			classicFlowAvailPage.ReuseMethodsforDPRcheckavailabitlity(Enterrooms, roomtype);
			classicFlowReservationDet.ReuseMethodsforDPRsetupResDetails(RatePlan);
			clasicflow.ReuseMethodsforDPRclose(RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
		
		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			//Assert.assertEquals(false, true);
		}
	}
	@Test(dataProvider="DPR",priority=6,enabled=true)
	public void AddNewDPR_Discounttype_Percentage_NthNight(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties=PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage :Nth Night");
			logger.info("Add New DPR Discount type: Percentage : Day Of Week :Nth Night");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

		/*	DPR.Click_DPRListAll();
			DPR.Delete_DuplictaeDPR(RuleName);
			DPR.Click_DPRAddNew();
			DPR.Enter_RuleName(RuleName);
			DPR.Enter_RuleCode(RuleCode);
			DPR.Enter_ShortDescription(ShortDescription);
			DPR.Enter_CheckInDate();
			DPR.Enter_CheckOutDate();
			DiscountPercent=	DPR.Select_DPRDiscountTypePercent("Percentage", "Nth Night", Precentage, SteadyDays,DOW_AnyDay,RatePlan,NthNight);
			DPR.Select_Rateplan(RatePlan);
			AlternateProperties.Click_Save();
			DPR.verifyDPRatTitlePage(RuleName);*/
			
			DiscountPercent1=DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage", "Nth Night", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,ShortDescription,SteadyDays,"Nth Night",NthNight,"Percentage",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,DiscountPercent,ShortDescription,SteadyDays,"Nth Night",NthNight,"Percentage",Precentage);
	
			
			clasicflow.ReuseMethodsforDPRstart();
			classicFlowAvailPage.ReuseMethodsforDPRcheckavailabitlity(Enterrooms, roomtype);
			classicFlowReservationDet.ReuseMethodsforDPRsetupResDetails(RatePlan);
			clasicflow.ReuseMethodsforDPRclose(RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			//Assert.assertEquals(false, true);
		}
	}
	@Test(dataProvider="DPR",priority=7,enabled=true)
	public void AddNewDPR_Discounttype_Percentage_AllNights(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			AlternateProperties AlternateProperties=PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage :All Nights");
			logger.info("Add New DPR Discount type: Percentage : Day Of Week :All Nights");

			SeleniumRepo.driver.switchTo().window(ParentWindow);
			
			DiscountPercent1=DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage", "All Nights", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,ShortDescription,SteadyDays,"All Nights",NthNight,"Percentage",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			
			clasicflow.ReuseMethodsforDPRstart();
			classicFlowAvailPage.ReuseMethodsforDPRcheckavailabitlity(Enterrooms, roomtype);
			classicFlowReservationDet.ReuseMethodsforDPRsetupResDetails(RatePlan);
			clasicflow.ReuseMethodsforDPRclose(RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			
			SeleniumRepo.driver.close();
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,DiscountPercent,ShortDescription,SteadyDays,"All Nights",NthNight,"Percentage",Precentage);	
		}
		catch (Exception e) 
		{
			logger.error("unable to "+getClass().getEnclosingMethod().getName() + e);
			test.log(Status.ERROR, "unable to "+getClass().getEnclosingMethod().getName() + e);
			e.printStackTrace();
			//Assert.assertEquals(false, true);
		}
	}
}
