/**
 * 
 */
package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Login;
import com.tt.admin.pom.PropertyEdit;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * @author DM
 *
 */
public class TC_PropertyEdit extends BaseTest {	

	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AddNewProperty");

		return (testObjArray);
	}
	
	
	@Test(dataProvider = "dataSupplier")
	public void addNewProperty(HashMap<String, String> h) throws Exception {
		
		try {
			Login login =PageFactory.initElements(SeleniumRepo.driver, Login.class);

			PropertyEdit editProperty =PageFactory.initElements(SeleniumRepo.driver, PropertyEdit.class);
			/*AddNewProperty addPrtyDefault =PageFactory.initElements(SeleniumRepo.driver, AddNewProperty.class);        
			AddNewProperty addPrtyMaster =PageFactory.initElements(SeleniumRepo.driver, AddNewProperty.class);*/
		
		test = extent.createTest(" editing a  Property");
		logger.info("Editing   an exsisting  Property");
		
		
		
		
		            String PropertyName= h.get("PropertyName").toString().trim();
					String PropertyCode=  h.get("PropertyCode").toString().trim();
					String EnterPropertySubDomain = h.get("PropertySubDomain").toString().trim();
					String EnterAddress1 =  h.get("Address1").toString().trim();
					String EnterCityName =  h.get("CityName").toString().trim();
					String EnterCountryName =  h.get("CountryName").toString().trim();
					String EnterZipCode =  h.get("ZipCode").toString().trim();
					String AddPropertyTitle = h.get("AddPropertyTitle").toString().trim();
					
				
					System.out.println("----------------------------------------"); 
					
					logger.info("AddNew Opened");
					//addNewPrty.newProperty(PropertyName, PropertyCode, EnterPropertySubDomain, EnterAddress1, EnterCityName, EnterCountryName, EnterZipCode,AddPropertyTitle);
					
					
					editProperty.click_Edit();
					/*  */
					editProperty.propName("String");
					editProperty.propCode("String");
					editProperty.propBookingVersion(); // does not do anything but select version 3.0
					editProperty.propBookingEngFlow("ASAP"); // – imcomplete
					editProperty.propSubscription("RezTrip Light");
					editProperty.propEnablePrePostStayEmail("String");
					editProperty.propStatus("String"); 
					editProperty.propTestProp("enable"); 
					editProperty.propSubDomain("String");
					editProperty.propAddress1("String");
					editProperty.propAddress2("String"); // – incomplete 
					editProperty.propCity("String");
					editProperty.propCountry("Canada");
					editProperty.propState("Yukon");
					editProperty.propCountry("Cambodia");
					editProperty.propState("Woot");
					editProperty.propZip("65432");
					editProperty.propLatLong();
					editProperty.propTimeZone("US/Aleutian, Hawaii-Aleutian Standard Time (-9 Offset)");
					editProperty.propPmsInterface("MaxiMojo");
					editProperty.propMultiPropPortal("MacES");
					
					editProperty.propTripAdvisorId("738892");
					editProperty.propWihpId("String");
					editProperty.propExternalIbeHostName("String");
					
					editProperty.propRateCalendar("disable");
					editProperty.propBrg("disable");
					editProperty.propEmailRetargetingAccess("disable");
					editProperty.propAddOnTaxes("enable");
					editProperty.propAdA("enable");
					editProperty.propRatesRecievePmsInclusiveTaxes("enable");
					editProperty.propCallCenter("disable");


					editProperty.propNorParticipant("enable");
					editProperty.propIncludeTrivagoSearch("enable");
					editProperty.propSubToCommissionProcessing("enable");
					editProperty.propAdsOnConfirmationPage("enable");
					editProperty.propGoogleAnalytics("enable");
					editProperty.propGoogleAnalyticsProfile(); // – incomplete 
					editProperty.propCrossDomaintracking("enable");
					editProperty.propLinkedDomain("wow.com");
					
					editProperty.propEnforceHouseLevelInventory("enable");
					editProperty.propEnforceHouseLevelYieldControls("enable");
					editProperty.propFullPatternLosRestriction("enable");
					editProperty.propFilterAvailResultsBaseOnHurdle("enable");
					editProperty.propPerPersonPricing("enable");
					editProperty.propRecalculateUpcTaxes("enable");
					editProperty.propSendCurrencyConvInNotifiEmail("enable");
					editProperty.propRoomThresholds("enable");
					
					editProperty.propDerbySoftConn("enable");
					//editProperty.propWihpConnection("enable");
					//editProperty.propGoogleConnection();
					//editProperty.propHouseLevelYieldControlsToGroup("enable"); -> might not appear need to figure out the settings that will make it
					editProperty.propElevateProgram("enable");




					editProperty.propTrackingCodeAllPgs("woowow nurse");
					editProperty.propTrackingCodeNonConfirmPgs("blove");
					editProperty.propTrackingCodeConfimPgs("sloeve");
					
					editProperty.propInitialPmsResvSyncFlag("enable");
					editProperty.propDoNotAdjustInventoryForCancels("enable");
					
					editProperty.propGroupRatePlanPrefix("iil");


					

					/*

				

					
				
					
					*/




					
					//editProperty.propCancel();
					
					System.out.println("----------------------------------------"); 
					
				
					
		} catch (Exception e) {
			logger.error("Unable to create New Property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create New Property because of this execption" + e);
			/*finalAssertTrue(false,
				    "Failed to create New Property  ");*/
			e.printStackTrace();
		
		
		}
	
	}
	
	
	
}
