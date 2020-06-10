package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AddNewProperty;
import com.tt.admin.pom.PropertyDefaults;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;


public class TC_PropertyDefaults extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"Property_Default");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void addNewProperty_Default(HashMap<String, String> h) throws Exception 
	{
		try {
			//old way of interacting witht he defaults page
			AddNewProperty addPrtyDefault =PageFactory.initElements(SeleniumRepo.driver, AddNewProperty.class);  
			test = extent.createTest("Add New Property_Default");
			logger.info("Add New Property_Default");
			
			PropertyDefaults propDef=PageFactory.initElements(SeleniumRepo.driver, PropertyDefaults.class);
					
					

			String PropertyDefaultsTitle = h.get("PropertyDefaultsTitle").toString().trim();
			String StarRating = h.get("StarRating").toString().trim();
			String Adultage = h.get("Adultage").toString().trim();
			String CheckinTime = h.get("CheckinTime").toString().trim();
			String CheckoutTime = h.get("CheckoutTime").toString().trim();

			logger.info("Properpty Default Opened");
			
			 propDef.click_PropertyDefaults();
			 
			 propDef.propDefStarRating("2.0");
			 
			 propDef.propDefCreditCardVerif("disable");
			 
			 propDef.propDefPropertyEmailNotif("disable");
			 
			 propDef.propDefGuestEmailNotif("disable");
			 
			 propDef.propDefChannelManagerEmailNotif("disable");
			 
			 propDef.propDefMobileLocation("enable");

			 propDef.propDefAdultAge("21");
			 
			 propDef.propDefChildrenInSearch("disable");
			 
			 propDef.propDefaultNumOfAdultsInSearch("1");
			 
			 //propDef.propDefaultCancellationPolicy("Hope");
			 
			 propDef.propDefMinPriceAlertHotel("344");
			 
			 propDef.propDefaultCurrency("Cordoba Oro");
			 
			 propDef.propDefCurrencies("CFP Franc;Malawian Kwacha;Hong Kong Dollar;Indian Rupee");


			 propDef.propDefTaxDisplay("enable");
			 
			// propDef.propDefAddOnPriceType("disable");
			 
			 propDef.propDefPriceDisplay("total");
			 
			 propDef.propDefTaxBreakDownMobile("disable");
			 
			 propDef.propDefRoundUpPrice("enable");
			 
			 propDef.propDefaultDateFormat("mm/dd/yy");
			 
			 propDef.propDefMaxNumOfRoomsBookedAtOnce("2");
			 
			 propDef.propDefMaxNumOfRoomsBookedAtOnceCallCen("8");
			 
			 propDef.propDefCheckinTime("04:30 a.m.");
			 

			 propDef.propDefCheckoutTime("09:00 p.m.");

			 propDef.propDefIATACodeTracking("disable");
			 
			 propDef.propDefFeeDisclaimerMobile("HI MY Name");

			 propDef.propDefDailyRateDisplay("avg");
			 
			 propDef.propDefRateGridCascadesYieldControls("disable");
			 
			 propDef.propDefRateGridCalendarView("disable");

			 propDef.propDefLOSRestrictionType("arrival");
			 
			 propDef.propDefShowLowestPriceOnDetailsPage("disable");
			 
			 propDef.FBP_RadioButton("false");
			 
			 //propDef.propDefSlashThrouPricingFBPrates(String);
			 propDef.propDefAddonsInPGDeposit("enable");
			 propDef.propDefTaxInPGDeposit("enable");
			 //propDef.propDefSmartRatePlan(String);
			 //propDef.propDefDerbySoftConnection("enable");
			 //propDef.propDefWIHPConnection(String);
			 
			 //Create a method that allows a selection of a loylaty program
			 propDef.propDefLoyaltyProgram("enable");
			 propDef.propDefLoyaltyProgSelection("House Advantage");

			 
			 propDef.propDefCOMPRatePlan("disable");
			 
			 propDef.propDefUplift("enable");
			 
			 propDef.CompoundAccess_RadioButton("disable");
			 
			 propDef.propDefAllowZeroRate("enable");

			 propDef.propDefFacebookPageId("Face BoOOOOk");
			 
			 propDef.propDefRateCalendarRatePlan("CopperComplimentary");
			 
			// propDef.propDefTripConnectShowPriceRatePlan("per person");
			 
			// propDef.propDefTripAdvisorInstantBookingRatePlan("Deep");

			 propDef.propDefFlipToEnabled("disable");

			 propDef.propDefFlipToCompanyCode("LOOOiss");
			 
			 propDef.propDefFlipToCampaignCode("lswwe");

			 




































			
			
			/*
			 


Click_Save()
propertyDefault(String, String, String, String, String)
			 
			 
			 
			 
			 
			 */
			

			//old way of interacting with property defaults
		//	addPrtyDefault.propertyDefault(PropertyDefaultsTitle, StarRating, Adultage, CheckinTime, CheckoutTime);
			
		}
		catch (Exception e) 
		{
			logger.error("Unable to create New Property_Default property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Add New Property_Default property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false,true);

		}
	}
}



