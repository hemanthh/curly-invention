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
import com.tt.admin.pom.Dynamic_Pricing_Rules;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_DPRTestCases_Percentage_Then_Flat extends BaseTest
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
	public void AddNewDPR_Discounttype_FlatAmount_DOW_AllDays(HashMap<String, String> h)
	{
		try 
		{
			//login_Brand_Property();
			
			//SeleniumRepo.driver.switchTo().window(ParentWindow);

			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			


			test = extent.createTest("Add New DPR Using:DISCOUNT DEFINITION:Discount type: Percentage then Flat Amount :All Days");
			logger.info("Add New DPR Using:DISCOUNT DEFINITION:Discount type: Percentage then Flat Amount :All Days");


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

			DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage then Flat Amount", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_ALL,RatePlan,NthNight,Percentage);

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
	public void VerfiyinBE_AddNewDPR_Discounttype_FlatAmount_DOW(HashMap<String, String> h2) throws ParseException, IOException
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

			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"Percentage then Flat Amount",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,FlatAmount,Discountprice,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount);
			
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
	@Test(dataProvider="DPR",enabled=true,priority=3)
	public void AddNewDPR_Discounttype_FlatAmount_DOW_particularDay(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage then Flat Amount : Day Of Week :particular Day");
			logger.info("Add New DPR Discount type: Percentage then Flat Amount : Day Of Week :particular Day");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			Discountprice=DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage then Flat Amount", "Day Of Week", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			System.out.println(DPR.finalDay);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"AnyDay",NthNight,"Percentage then Flat Amount",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,FlatAmount,Discountprice,ShortDescription,SteadyDays,"AnyDay",NthNight,"FlatAmount",FlatAmount);
		
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

	@Test(dataProvider="DPR",enabled=true,priority=4)
	public void AddNewDPR_Discounttype_FlatAmount_First_N_Nights(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage then Flat Amount :First N Nights");
			logger.info("Add New DPR Discount type: Percentage then Flat Amount : Day Of Week :First N Nights");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage then Flat Amount", "First N Nights", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"First N Nights",NthNight,"Percentage then Flat Amount",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,Discountprice,ShortDescription,SteadyDays,"First N Nights",NthNight,"FlatAmount",FlatAmount);
	
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
	@Test(dataProvider="DPR",enabled=true,priority=5)
	public void AddNewDPR_Discounttype_FlatAmount_Last_N_Nights(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage then Flat Amount :Last N Nights");
			logger.info("Add New DPR Discount type: Percentage then Flat Amount : Day Of Week :Last N Nights");

			SeleniumRepo.driver.switchTo().window(ParentWindow);
			
			DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage then Flat Amount", "Last N Nights", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Last N Nights",NthNight,"Percentage then Flat Amount",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,Discountprice,ShortDescription,SteadyDays,"Last N Nights",NthNight,"FlatAmount",FlatAmount);	
		
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
	@Test(dataProvider="DPR",enabled=true,priority=6)
	public void AddNewDPR_Discounttype_FlatAmount_NthNight(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage then Flat Amount :Nth Night");
			logger.info("Add New DPR Discount type: Percentage then Flat Amount : Day Of Week :Nth Night");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage then Flat Amount", "Nth Night", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Nth Night",NthNight,"Percentage then Flat Amount",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,Discountprice,ShortDescription,SteadyDays,"Nth Night",NthNight,"FlatAmount",FlatAmount);
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
	@Test(dataProvider="DPR",enabled=true,priority=7)
	public void AddNewDPR_Discounttype_FlatAmount_AllNights(HashMap<String, String> h)
	{
		try 
		{
			
			Dynamic_Pricing_Rules DPR =PageFactory.initElements(SeleniumRepo.driver, Dynamic_Pricing_Rules.class);
			
			ClasicFlow  clasicflow =PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
			ClassicFlow_AvailPage  classicFlowAvailPage = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_AvailPage.class);
			ClassicFlow_ReservationDetailsPage  classicFlowReservationDet = PageFactory.initElements(SeleniumRepo.driver, ClassicFlow_ReservationDetailsPage.class);



			test = extent.createTest("Add New DPR Discount type: Percentage then Flat Amount :All Nights");
			logger.info("Add New DPR Discount type: Percentage then Flat Amount : Day Of Week :All Nights");

			SeleniumRepo.driver.switchTo().window(ParentWindow);

			
			DPR.ReuseDPRFlat(RuleName,RuleCode,ShortDescription,"Percentage then Flat Amount", "All Nights", FlatAmount, SteadyDays, SteadyFlatAmount,DOW_AnyDay,RatePlan,NthNight,Percentage);
			
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
			//clasicflow.ReuseMethodsforDPR(Enterrooms, roomtype, RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"All Nights",NthNight,"Percentage then Flat Amount",Percentage,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			clasicflow.ReuseMethodsforDPRstart();
			classicFlowAvailPage.ReuseMethodsforDPRcheckavailabitlity(Enterrooms, roomtype);
			classicFlowReservationDet.ReuseMethodsforDPRsetupResDetails(RatePlan);
			clasicflow.ReuseMethodsforDPRclose(RatePlan,DPR.finalDay_Month_Date,RatePlan,FlatAmount,ShortDescription,SteadyDays,"Day Of Week",NthNight,"FlatAmount",FlatAmount,FirstName,LastName,Email,Cardname,Numberoncard,Entercountry,Address, Enterzipcode, Address2, Enterstate, Entercity,Enterphonenum);
			SeleniumRepo.driver.close();
			//clasicflow.verify_Strike(DPR.finalDay_Month_Date,RatePlan,SteadyFlatAmount,Discountprice,ShortDescription,SteadyDays,"All Nights",NthNight,"FlatAmount",FlatAmount);
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
