/**
 * 
 */
package com.tt.admin.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * @author DM
 * 
 *         -> create a getter and setter for the property name and various
 *         feilds that will help delete the property
 * 
 *         -> Create an error base class that handles negative test cases for
 *         required fields. C Currently each field just assert if text was
 *         entered or if a radio button was selected, but this need more testing
 *         depth
 *
 */
public class PropertyEdit extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'QA_AUTOMATION')]"),
			@FindBy(css = "td.prompt:nth-child(2) td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(62) td.prompt:nth-child(1) > a:nth-child(1)") })

	public WebElement Click_QAAutomation;

	@FindAll({ @FindBy(xpath = "//input[@value='1519']"),
			@FindBy(css = "span.prompt:nth-child(4) td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(7) td.prompt:nth-child(1) > input:nth-child(1)") })

	public WebElement Select_property;

	@FindAll({ @FindBy(xpath = "//input[@value='Select Property']"),
			@FindBy(css = "tr:nth-child(1) td:nth-child(2) span.prompt:nth-child(4) form:nth-child(10) > input.input:nth-child(6)") })

	public WebElement Click_Property;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })

	public WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(id = "add_new_property"), @FindBy(xpath = "//a[@id='add_new_property'] ") })

	public WebElement Click_AddNew;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Edit')]") })
	public WebElement Click_Edit;

	@FindAll({ @FindBy(xpath = "//td[@class='title']"),
			@FindBy(xpath = "//td[@class = 'title' and contains(., 'Add Property')] ") })
	public WebElement Verify_AddPropertyTitle;

	@FindAll({ @FindBy(name = "propertyName"), @FindBy(xpath = "//input[@name='propertyName'] ") })
	public WebElement Enter_PropertyName;

	@FindAll({ @FindBy(name = "propertyCode"), @FindBy(xpath = "//input[@name='propertyCode'] ") })
	public WebElement Enter_PropertyCode;

	@FindAll({ @FindBy(id = "bookingVersion3Id"), @FindBy(xpath = "//input[@id='bookingVersion3Id'] ") })
	public WebElement Click_BookingEngineVersion;

	@FindAll({ @FindBy(name = "propertySubdomain"), @FindBy(xpath = "//input[@name='propertySubdomain'] ") })
	public WebElement propertySubdomain;

	@FindAll({ @FindBy(name = "address1"), @FindBy(xpath = "//input[@name='address1'] ") })
	public WebElement Enter_Address;

	@FindAll({ @FindBy(name = "city"), @FindBy(xpath = "//input[@name='city'] ") })
	public WebElement Enter_CityName;

	@FindAll({ @FindBy(name = "country"), @FindBy(xpath = "//select[@name='country']") })
	public WebElement Select_country;

	@FindAll({  @FindBy(xpath = "//*[@id='text']//select[@id='state']")  })
	public WebElement Enter_state_dropdown;

	@FindAll({ @FindBy(xpath = "//*[@id='text']//input[@name='stateName']") })
	public WebElement Enter_state_text;

	@FindAll({ @FindBy(name = "zip"), @FindBy(xpath = "//input[@name='zip']") })
	public WebElement Enter_Zip;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Find Lat/Long')]"),
			@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(18) td:nth-child(2) > a:nth-child(3)") })
	public WebElement Click_LatLong;

	// @FindAll({ @FindBy(name = "enableRateCalendar"), @FindBy(xpath =
	// "//tbody//tr[25]//td[2]//input[1]") })
	// lable xpath //td[contains(text(),'Enable AddOn Taxes')]
	// Yes radio button //*[@name='isAddOnTaxesEnabled'][1]" No radio button
	// //*[@name='isAddOnTaxesEnabled'][2]"

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable AddOn Taxes')]") })
	public WebElement Click_RateCalendar;

	@FindAll({ @FindBy(xpath = "//*[@name='enableRateCalendar'][1]") }) // *[@name='isAddOnTaxesEnabled'][1]
	public WebElement Click_RateCalendar_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='enableRateCalendar'][2]") })
	public WebElement Click_RateCalendar_Disable;

	@FindAll({ @FindBy(xpath = "//tbody//tr[28]//td[2]//input[1]"),
			@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(28) td:nth-child(2) > input:nth-child(1)") })

	public WebElement Click_CallCenter;

	/*
	 * @FindAll({ @FindBy(xpath = "//tbody//tr[33]//td[2]//input[1]"),
	 * 
	 * @FindBy(xpath = "//input[@value = 'Y' and @name = 'adsOnConfPage']"),
	 * 
	 * @FindBy(css =
	 * "table:nth-child(4) tbody:nth-child(1) tr:nth-child(33) td:nth-child(2) > input:nth-child(1)"
	 * ) })
	 * 
	 * public WebElement Click_EnableAdsonConfirmation;
	 */

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Booking Engine Flow')]") })
	public WebElement Booking_Engine_Flow_field;

	@FindAll({ @FindBy(xpath = "//*[@name='bookingUIFlow']") })
	public WebElement Select_Booking_Engine_Flow_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Property Subscription')]") })
	public WebElement PropertySubscription_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isStandardProperty'][1]") })
	public WebElement Click_PropertySubscription_RezTripLight;

	@FindAll({ @FindBy(xpath = "//*[@name='isStandardProperty'][2]") })
	public WebElement Click_PropertySubscription_Standard;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable pre/post-stay email feature')]") })
	public WebElement PrePosStayEmail_field;

	@FindAll({ @FindBy(xpath = "//*[@name='prepostEmailStatus'][1]") })
	public WebElement Click_PrePosStayEmail_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='prepostEmailStatus'][2]") })
	public WebElement Click_PrePosStayEmail_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Status')]") })
	public WebElement Status_field;

	@FindAll({ @FindBy(xpath = "//*[@name='status'][1]") })
	public WebElement Click_Status_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='status'][2]") })
	public WebElement Click_Status_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Test Property?')]") })
	public WebElement TestProperty_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isTestProp'][1]") })
	public WebElement Click_TestProperty_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='Enable isTestProp'][2]") })
	public WebElement TestProperty_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'External IBE Host Name')]") })
	public WebElement ExternalIbeHost_field;

	@FindAll({ @FindBy(xpath = "//*[@name='externalIBEHostName']") })
	public WebElement Enter_EnterExternalIbeHost_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'WIHP ID')]") })
	public WebElement WihpID_field;

	@FindAll({ @FindBy(xpath = "//*[@name='wihpId']") })
	public WebElement Enter_WihpID_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'TripAdvisor ID')]") })
	public WebElement TripAdvisorID_field;

	@FindAll({ @FindBy(xpath = "//*[@name='tripAdvisorId']") })
	public WebElement Enter_TripAdvisorID_Text;

	//For some reason this field is surrounded by a div
	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Multi-Property Portals')]") })
	public WebElement MultiPropPortals_field;

	@FindAll({ @FindBy(xpath = "//*[@name='propertyPortals']") })
	public WebElement Enter_MultiPropPortals_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Select PMS Interface')]") })
	public WebElement PMS_Interface_field;

	@FindAll({ @FindBy(xpath = "//*[@name='oxiInterfaceId']") })
	public WebElement Select_PMS_Interface_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Time Zone')]") })
	public WebElement Time_Zone_field;

	@FindAll({ @FindBy(xpath = "//*[@name='timeZoneId']") })
	public WebElement Select_Time_Zone_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable BRG')]") })
	public WebElement BRG_field;

	@FindAll({ @FindBy(xpath = "//*[@name='enableBrg'][1]") }) // *[@name='isAddOnTaxesEnabled'][1]
	public WebElement Click_BRG_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='enableBrg'][2]") })
	public WebElement Click_BRG_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Email Retargeting Access')]") })
	public WebElement EmailRetargetingAcces_field;

	@FindAll({ @FindBy(xpath = "//*[@name='enabledEmailRetargeting'][1]") })
	public WebElement Click_EmailRetargetingAcces_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='enabledEmailRetargeting'][2]") })
	public WebElement Click_EmailRetargetingAcces_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable AddOn Taxes')]") })
	public WebElement AddOnTaxes_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isAddOnTaxesEnabled'][1]") })
	public WebElement Click_AddOnTaxes_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isAddOnTaxesEnabled'][2]") })
	public WebElement Click_AddOnTaxes_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable ADA')]") })
	public WebElement ADA_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isADAEnabled'][1]") })
	public WebElement Click_ADA_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isADAEnabled'][2]") })
	public WebElement Click_ADA_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Are the rates recieved from PMS inclusive of Taxes?')]") })
	public WebElement PMSratesIncludeTaxes_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isRatesIncludeTaxes'][1]") })
	public WebElement Click_PMSratesIncludeTaxes_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isRatesIncludeTaxes'][2]") })
	public WebElement Click_PMSratesIncludeTaxes_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Call Center')]") })
	public WebElement CallCenter_field;

	@FindAll({ @FindBy(xpath = "//*[@name='callCenter'][1]") })
	public WebElement Click_CallCenter_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='callCenter'][2]") })
	public WebElement Click_CallCenter_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Nor1 Participant?')]") })
	public WebElement Click_Nor1Participant;

	@FindAll({ @FindBy(xpath = "//*[@name='norStatus'][1]") })
	public WebElement Click_Nor1Participant_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='norStatus'][2]") })
	public WebElement Click_Nor1Participant_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Include in Trivago Search?')]") })
	public WebElement TrivagoSearch_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isTrivagoEnabled'][1]") })
	public WebElement Click_TrivagoSearch_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isTrivagoEnabled'][2]") })
	public WebElement Click_TrivagoSearch_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Subscribed to Commission Processing')]") })
	public WebElement SubscribedCommissionProcessing_field;

	@FindAll({ @FindBy(xpath = "//*[@name='subscribedToCommissionPro'][1]") })
	public WebElement Click_SubscribedCommissionProcessing_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='subscribedToCommissionPro'][2]") })
	public WebElement Click_SubscribedCommissionProcessing_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Ads on Confirmation Page?')]") })
	public WebElement AdsOnConfirmationPage_field;

	@FindAll({ @FindBy(xpath = "//*[@name='adsOnConfPage'][1]") })
	public WebElement Click_AdsOnConfirmationPage_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='adsOnConfPage'][2]") })
	public WebElement Click_AdsOnConfirmationPage_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Google Analytics')]") })
	public WebElement GoogleAnalytics_field;

	@FindAll({ @FindBy(xpath = "//*[@name='gaEnabled'][1]") })
	public WebElement Click_GoogleAnalytics_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='gaEnabled'][2]") })
	public WebElement Click_GoogleAnalytics_Disable;

	// Add google analytics profile fields here

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Cross-Domain Tracking')]") })
	public WebElement CrossDomainTracking_field;

	@FindAll({ @FindBy(xpath = "//*[@name='gaCrossDomain'][1]") })
	public WebElement Click_CrossDomainTracking_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='gaCrossDomain'][2]") })
	public WebElement Click_CrossDomainTracking_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Linked Domain:')]") })
	public WebElement LinkedDomain_field;

	@FindAll({ @FindBy(xpath = "//*[@name='gaLinkedDomains']") })
	public WebElement Enter_LinkedDomain_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enforce House Level Inventory')]") })
	public WebElement HouseLevelInventory_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isHouseLevelInventoryEnforced'][1]") })
	public WebElement Click_HouseLevelInventory_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isHouseLevelInventoryEnforced'][2]") })
	public WebElement Click_HouseLevelInventory_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enforce House Level Yield Controls ')]") })
	public WebElement HouseLevelYieldControls_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isHouseLevelYieldEnforced'][1]") })
	public WebElement Click_HouseLevelYieldControls_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isHouseLevelYieldEnforced'][2]") })
	public WebElement Click_HouseLevelYieldControls_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Full Pattern LOS Restriction')]") })
	public WebElement FullPatternLOSRestriction_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isFPLOSRestrictionEnabled'][1]") })
	public WebElement Click_FullPatternLOSRestriction_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isFPLOSRestrictionEnabled'][2]") })
	public WebElement Click_FullPatternLOSRestriction_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Filter Availability Results based on Hurdle Rate')]") })
	public WebElement FilterAvailResBaseHurdleRate_field;

	@FindAll({ @FindBy(xpath = "//*[@name='gaCrossDomain'][1]") })
	public WebElement Click_FilterAvailResBaseHurdleRate_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='gaCrossDomain'][2]") })
	public WebElement Click_FilterAvailResBaseHurdleRate_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Use Per Person Pricing')]") })
	public WebElement PerPersonPricing_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isPerPersonPricingEnabled'][1]") })
	public WebElement Click_PerPersonPricingg_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isPerPersonPricingEnabled'][2]") })
	public WebElement Click_PerPersonPricing_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Recalculate UPC Taxes')]") })
	public WebElement RecalculateUPCTaxes_field;

	@FindAll({ @FindBy(xpath = "//*[@name='recalculateTaxesAfterUpc'][1]") })
	public WebElement Click_RecalculateUPCTaxes_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='recalculateTaxesAfterUpc'][2]") })
	public WebElement Click_RecalculateUPCTaxes_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Send currency conversions in notification emails')]") })
	public WebElement SendCurrencyConversionsInEmails_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isCurrencyConversionEnabled'][1]") })
	public WebElement Click_SendCurrencyConversionsInEmails_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isCurrencyConversionEnabled'][2]") })
	public WebElement Click_SendCurrencyConversionsInEmails_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Room Thresholds')]") })
	public WebElement RoomThresholds_fields;

	@FindAll({ @FindBy(xpath = "//*[@name='isRoomThresholdEnabled'][1]") })
	public WebElement Click_RoomThresholds_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isRoomThresholdEnabled'][2]") })
	public WebElement Click_RoomThresholds_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable DerbySoft Connection ')]") })
	public WebElement DerbySoftConnection_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isDerbySoftEnabled'][1]") })
	public WebElement Click_DerbySoftConnection_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isDerbySoftEnabled'][2]") })
	public WebElement Click_DerbySoftConnection_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable WIHP Connection ')]") })
	public WebElement WihpConnection_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isWHIPEnabled'][1]") })
	public WebElement Click_WihpConnection_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isWHIPEnabled'][2]") })
	public WebElement Click_WihpConnection_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Apply House Level Yield Controls to Groups')]") })
	public WebElement HouseLevelYieldControlsGroups_field;

	@FindAll({ @FindBy(xpath = "//*[@name='applyHouseLevelYieldToGroups'][1]") })
	public WebElement Click_HouseLevelYieldControlsGroups_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='applyHouseLevelYieldToGroups'][2]") })
	public WebElement Click_HouseLevelYieldControlsGroups_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Turn On Elevate Meriton Program')]") })
	public WebElement ElevateProgram_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isEnableMeritonElevateProgram'][1]") })
	public WebElement Click_ElevateProgram_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isEnableMeritonElevateProgram'][2]") })
	public WebElement Click_ElevateProgram_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Tracking Code - all pages')]") })
	public WebElement TrackingCodeAllPgs_field;

	@FindAll({ @FindBy(xpath = "//*[@name='tabChangeJs']") })
	public WebElement Enter_TrackingCodeAllPgs_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Tracking Code - non-confirmation pages ')]") })
	public WebElement TrackingCodeNonConfirmPg_field;

	@FindAll({ @FindBy(xpath = "//*[@name='nonConfTabChangeJs']") })
	public WebElement Enter_TrackingCodeNonConfirmPg_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Tracking Code - confirmation pages')]") })
	public WebElement TrackingCodeConfirmPg_field;

	@FindAll({ @FindBy(xpath = "//*[@name='reservationJs']") })
	public WebElement Enter_TrackingCodeConfirmPg_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Initial PMS Reservation Sync Flag')]") })
	public WebElement IniPMSReservationSyncFlag_field;

	@FindAll({ @FindBy(xpath = "//*[@name='initialPMSReservationSync']") })
	public WebElement Clicking_IniPMSReservationSyncFlag;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Do Not Adjust Inventory for Cancels')]") })
	public WebElement DoNotAdjustInventoryForCancels_field;

	@FindAll({ @FindBy(xpath = "//*[@name='webReservationSync']") })
	public WebElement Clicking_DoNotAdjustInventoryForCancels;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Group ratePlan prefix')]") })
	public WebElement GroupRatePlanPrefix_field;

	@FindAll({ @FindBy(xpath = "//*[@name='pmsGroupPrefix']") })
	public WebElement Enter_GroupRatePlanPrefix_Text;

	@FindAll({ @FindBy(xpath = "//input[@name='button1' and @value= 'Save']"),
			@FindBy(css = "tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) form:nth-child(2) > input.input:nth-child(6)") })

	public WebElement Click_Save1;

	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"),
			@FindBy(css = "tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) form:nth-child(2) > input.input:nth-child(7)") })

	public WebElement Cancel_Button;
	
	
 	@FindAll({ @FindBy(xpath = "//*[text()='OK']"), })
public WebElement WhipConnection_Popup_OK;
	

	public void click_AddNew() {

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
		if (Click_PropertyManagement.isDisplayed()) {
			Click_PropertyManagement.click();
			logger.info("Clicked on property Management Link");
			test.log(Status.PASS, "Clicked on property Management Link");
			Assert.assertTrue(true, "Clicked on property Management Link");
		} else {
			System.out.println(" property Management Link is not found");
			logger.error("Failed to Click on Brand button");
			test.log(Status.FAIL, "Failed to Click on Save button");
			Assert.assertFalse(false, "Property Management Link not found");
		}

		SeleniumRepo.waitForElementPresent(Click_AddNew);
		if (Click_AddNew.isDisplayed()) {
			Click_AddNew.click();
			logger.info("Clicked on AddNew Link");
			test.log(Status.PASS, "Clicked on AddNew Link");
			Assert.assertTrue(true, "Clicked on AddNew Link");
		} else {
			System.out.println(" AddNew is not found");
			logger.error("Failed to Click on AddNew");
			test.log(Status.FAIL, "Failed to Click on AddNew");
			Assert.assertFalse(false, "AddNew Link not found");
		}

	}

	public void click_Edit() {

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
		if (Click_Edit.isDisplayed() == false) {
			Click_PropertyManagement.click();
			logger.info("Clicked on property Management Link");
			test.log(Status.PASS, "Clicked on property Management Link");
			Assert.assertTrue(true, "Clicked on property Management Link");
		} else {
			System.out.println(" property Management Link is not found");
			logger.error("Failed to Click on Brand button");
			test.log(Status.FAIL, "Failed to Click on Save button");
			Assert.assertFalse(false, "Property Management Link not found");
		}

		SeleniumRepo.waitForElementPresent(Click_Edit);
		if (Click_Edit.isDisplayed() == true ) {
			Click_Edit.click();
			logger.info("Clicked on Edit Link");
			test.log(Status.PASS, "Clicked on Edit Link");
			Assert.assertTrue(true, "Clicked on Edit Link");
		} else {
			System.out.println(" Edit is not found");
			logger.error("Failed to Click on Edit");
			test.log(Status.FAIL, "Failed to Click on Edit");
			Assert.assertFalse(false, "Edit Link not found");
		}

	}

	/**
	 * Enters
	 * 
	 * @param PropertyName
	 */
	public void propName(String PropertyName) {

		if (Enter_PropertyName.isDisplayed()) {
			Enter_PropertyName.click();
			Enter_PropertyName.clear();
			Enter_PropertyName.sendKeys(PropertyName);
			System.out.println(" PropertyName is entered successfully");
			logger.info("PropertyName is entered successfully");
			test.log(Status.PASS, "PropertyName is entered successfully");
			Assert.assertTrue(true, "PropertyName is entered successfully");
		} else {
			System.out.println("PropertyName TextBox not found");
			logger.error("Failed to Found PropertyName  TextBox");
			test.log(Status.FAIL, "Failed to Found PropertyName  TextBox");
			Assert.assertFalse(false, "PropertyName TextBox not found");
		}

	}

	/**
	 * 
	 * @param PropertyCode
	 */
	public void propCode(String PropertyCode) {

		if (Enter_PropertyCode.isDisplayed()) {
			Enter_PropertyCode.click();
			Enter_PropertyCode.clear();
			Enter_PropertyCode.sendKeys(PropertyCode);

			System.out.println(" PropertyCode is entered successfully");
			logger.info("PropertyCode is entered successfully");
			test.log(Status.PASS, "PropertyCode is entered successfully");
			Assert.assertTrue(true, "PropertyCode is entered successfully");
		} else {
			System.out.println("PropertyCode TextBox not found");
			logger.error("Failed to Enter  PropertyCode in TextBox");
			test.log(Status.FAIL, "Failed to Enter PropertyCode in TextBox");
			Assert.assertFalse(false, "PropertyCode TextBox not found");
		}

	}

	/**
	 * Regression ideas: 1. Allow user input specifically, "version" and "satus"
	 * inputs 2. Allow the ability select version as well as status
	 * 
	 * @throws Exception
	 */
	public void propBookingVersion() throws Exception {

		if (Click_BookingEngineVersion.isDisplayed()) {
			if (Click_BookingEngineVersion.isSelected() == false)

				Click_BookingEngineVersion.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Booking Engine Version is Clicked successfully");

			logger.info("Booking Engine Version is Clicked successfully");

			test.log(Status.PASS, "Booking Engine Version is Clicked successfully");

			Assert.assertTrue(true, " Booking Engine Version is Clicked successfully");
		} else {
			System.out.println("Booking Engine Version not Clicked");
			logger.error("Failed to Click on Booking Engine Version");
			test.log(Status.FAIL, "Failed to Click on Booking Engine Version");
			Assert.assertFalse(false, "Booking Engine Version not Clicked");
		}
	}

	public void propBookingEngFlow(String BookingFlow) {

		SeleniumRepo.waitForElementPresent(Booking_Engine_Flow_field);

		Assert.assertEquals(Booking_Engine_Flow_field.isDisplayed(), true,
				"Booking engine flow dropdown Field is not being displayed");

		Select_Booking_Engine_Flow_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_Booking_Engine_Flow_DropDown, BookingFlow);

		System.out.println("Booking engine flow  was selected successfully");
		
		System.out.println( Select_Booking_Engine_Flow_DropDown.getSize() );
		
		//Due to the way selecting items in dropdown are being handled by the "seleniumrepoDropdown"(nothing in this
		//class allows us to return the actual items or entire list of the dropdown - need to add this to the class)
		//Also the way admin works it will have the previous value or default value of a dropdown item as selected
		//and will only change this status once a save is completed. So will have to figure out a way to
		// to compare the newly selected item does not match the previous or does match
		//The getText of method of a webeleent dropdown will return all options
		//Assert.assertEquals(Select_Booking_Engine_Flow_DropDown.getText(), BookingFlow, "Booking Engine Flow dropdown was not selected");
		logger.info("Booking Engine Flow was selected successfully");
		test.log(Status.PASS, "Booking Engine Flow was selected successfully");

	}

	public void propSubscription(String subscription) throws Exception {
		
		System.out.println("This is just to check if propSubscription entry point  " +  subscription);

		SeleniumRepo.waitForElementPresent(PropertySubscription_field);

		Assert.assertEquals(PropertySubscription_field.isDisplayed(), true,
				"Property Subscription Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (subscription.equalsIgnoreCase("Standard")) {

			SeleniumRepo.WaitForLoad(100);

			Click_PropertySubscription_Standard.click();


			System.out.println(" Property Subscription Standard is enabled successfully");
			logger.info("Property Subscription Standard selected successfully");
			test.log(Status.PASS, "Property Subscription Standard selected successfully");
			Assert.assertTrue(Click_PropertySubscription_Standard.isSelected(),
					"Property Subscription Standard is Enabled");

		} else if (subscription.equalsIgnoreCase("RezTrip Light")) {

			SeleniumRepo.WaitForLoad(100);

			System.out.println("into the RezTrip Light sectoin ");
			
			Click_PropertySubscription_RezTripLight.click();


			System.out.println(" Property Subscription RezTrip Light is enabled successfully");
			logger.info("Property Subscription RezTrip Light selected successfully");
			test.log(Status.PASS, "Property Subscription RezTrip Light selected successfully");
			Assert.assertTrue(Click_PropertySubscription_RezTripLight.isSelected(),
					"Property Subscription Reztrip Light is Enabled");

		} else {

			System.out.println("The default value was selected for subscrtipon ");

		}

	}

	public void propEnablePrePostStayEmail(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(PrePosStayEmail_field);

		Assert.assertEquals(PrePosStayEmail_field.isDisplayed(), true,
				"Enable pre/post-stay email Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_PrePosStayEmail_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("pre/post-stay email is enabled successfully");
			logger.info(" pre/post-stay email selected successfully");
			test.log(Status.PASS, "pre/post-stay email selected successfully");
			Assert.assertTrue(Click_PrePosStayEmail_Enable.isSelected(), "pre/post-stay email is Enabled");

		} else {

			Click_PrePosStayEmail_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("pre/post-stay email not selected");
			logger.error("Failed to Select Enable pre/post-stay email");
			test.log(Status.FAIL, "Failed to SelectEnable pre/post-stay email");

			Assert.assertTrue(Click_PrePosStayEmail_Disable.isSelected(), "Enable pre/post-stay email is disable");

		}

	}

	public void propStatus(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(Status_field);

		Assert.assertEquals(Status_field.isDisplayed(), true, "Status Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_Status_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Status is set to active successfully");
			logger.info(" Status selected successfully");
			test.log(Status.PASS, "Statusselected successfully");
			Assert.assertTrue(Click_Status_Enable.isSelected(), "Status is Enabled");

		} else {

			Click_Status_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Status not selected");
			logger.error("Failed to Select Status");
			test.log(Status.FAIL, "Failed to SelectEnable pre/post-stay email");

			Assert.assertTrue(Click_Status_Disable.isSelected(), "Enable pre/post-stay email is disable");

		}

	}

	public void propTestProp(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(TestProperty_field);

		Assert.assertEquals(TestProperty_field.isDisplayed(), true, "Test Property? not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_TestProperty_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Test Property? is set to Yes successfully");
			logger.info(" Test Property? selected successfully");
			test.log(Status.PASS, "Test Property? selected successfully");
			Assert.assertTrue(Click_TestProperty_Enable.isSelected(), "Test Property? is Enabled");

		} else {

			TestProperty_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Test Property? not selected");
			logger.error("Failed to Select Test Property?");
			test.log(Status.FAIL, "Failed to SelectEnable pre/post-stay email");

			Assert.assertTrue(TestProperty_Disable.isSelected(), "Enable pre/post-stay email is disable");

		}

	}

	/**
	 * 
	 * @param SubDomain
	 */
	public void propSubDomain(String SubDomain) {

		if (propertySubdomain.isDisplayed()) {
			propertySubdomain.click();
			propertySubdomain.clear();
			propertySubdomain.sendKeys(SubDomain);
			System.out.println(" SubDomain is entered successfully");
			test.log(Status.INFO, " SubDomain is entered successfully");
			Assert.assertTrue(true, "SubDomain is entered successfully");
		} else {
			System.out.println("SubDomain TextBox not found");
			test.log(Status.FAIL, "SubDomain TextBox not found");
			Assert.assertFalse(false, "SubDomain TextBox not found");
		}

	}

	public void propAddress1(String EnterAddress1) {

		if (Enter_Address.isDisplayed()) {
			Enter_Address.click();
			Enter_Address.clear();
			test.log(Status.INFO, "Clicked on Brands Link");
			Enter_Address.sendKeys(EnterAddress1);
			System.out.println(" Address1 is entered successfully");
			logger.info("Address1 is entered successfully");
			test.log(Status.PASS, "Address1 is entered successfully");
			Assert.assertTrue(true, " Address1 is entered successfully");
		} else {
			System.out.println("Address1 TextBox not found");
			logger.error("Failed to Enter Address1 in TextBox");
			test.log(Status.FAIL, "Failed to Enter Address1 in TextBox");
			Assert.assertFalse(false, "Address1 TextBox not found");
		}

	}

	public void propAddress2(String EnterAddress2) {

	}

	public void propCity(String EnterCityName) {

		if (Enter_CityName.isDisplayed()) {
			Enter_CityName.click();
			Enter_CityName.clear();
			Enter_CityName.sendKeys(EnterCityName);
			System.out.println(" CityName is entered successfully");
			logger.info("CityName is entered successfully");
			test.log(Status.PASS, "CityName is entered successfully");
			Assert.assertTrue(true, "CityName is entered successfully");
		} else {
			System.out.println("CityName TextBox not found");
			logger.error("Failed to Enter CityName in TextBox");
			test.log(Status.FAIL, "Failed to Enter CityName in TextBox");
			Assert.assertFalse(false, "CityName is entered successfully");
		}

	}

	public void propCountry(String EnterCountryName) throws Exception {

		if (Select_country.isDisplayed()) {

			Select_country.click();
			SeleniumRepoDropdown.selectDropDownText(Select_country, EnterCountryName);
			// Select select = new Select(Enter_country);
			// select.selectByVisibleText(EnterCountryName);
			// Enter_country.sendKeys(EnterCountryName);
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" country is entered successfully");
			logger.info("country is entered successfully");
			test.log(Status.PASS, "country is entered successfully");
			Assert.assertTrue(true, "country is entered successfully");
		} else {
			System.out.println("country TextBox not found");
			logger.error("Failed to Enter country in TextBox");
			test.log(Status.FAIL, "Failed to Enter country in TextBox");
			Assert.assertFalse(false, "country TextBox not found");
		}

	}

	/**
	 * Note: Mehtod has two try catch statements because the state field has two states {text, and dropdown}. So
	 * if one appears webdriver can not find the other state and throws a nosuchelementexctpion 
	 * @param EnterStateName
	 * @throws NoSuchElementException
	 * @throws Exception
	 */
	public void propState(String EnterStateName) throws NoSuchElementException, Exception {

		// State field is not required and depending on country a dropdown or a
		// text field will appear
		// this is for the text field "//*[@id='text']" or state
		// "//*[@id='state']"


		SeleniumRepo.WaitForLoad(1000);
		
		
		try{
		
		
		if (Enter_state_dropdown.isDisplayed()) {
			Enter_state_dropdown.click();
			SeleniumRepoDropdown.selectDropDownText(Enter_state_dropdown, EnterStateName);
			// Select select = new Select(Enter_country);
			// select.selectByVisibleText(EnterCountryName);
			// Enter_country.sendKeys(EnterCountryName);
			SeleniumRepo.WaitForLoad(100);

			System.out.println(" country state is entered successfully");
			logger.info("country is entered successfully");
			test.log(Status.PASS, "country is entered successfully");
			Assert.assertTrue(true, "country is entered successfully");

		} 
	
	 } catch (org.openqa.selenium.NoSuchElementException e) {
			 
			 System.out.println("State Dropdown does not appear");
		    }
		
		try{
		
		if ( Enter_state_text.isDisplayed() ) {

			Enter_state_text.click();
			Enter_state_text.clear();
			Enter_state_text.sendKeys(EnterStateName);


			System.out.println(" state is entered successfully");
			logger.info("state is entered successfully");
			test.log(Status.PASS, "state is entered successfully");
			Assert.assertTrue(true, "state is entered successfully");

		} else {

			System.out.println("country TextBox or DropDown not found");
			logger.error("Failed to Enter country in TextBox");
			test.log(Status.FAIL, "Failed to Enter country in TextBox");
			Assert.assertFalse(false, "country TextBox not found");
		}
		
		
		 } catch (org.openqa.selenium.NoSuchElementException e) {
			 
			 System.out.println("state text field does not appear");
		    }

	}

	public void propZip(String EnterZipCode) {

		if (Enter_Zip.isDisplayed()) {
			Enter_Zip.click();
			Enter_Zip.clear();
			Enter_Zip.sendKeys(EnterZipCode);
			System.out.println(" ZipCode is entered successfully");
			logger.info("ZipCode is entered successfully");
			test.log(Status.PASS, "ZipCode is entered successfully");

			Assert.assertTrue(true, "ZipCode is entered successfully");
		} else {
			System.out.println("ZipCode TextBox not found");
			logger.error("Failed to Enter ZipCode in TextBox");
			test.log(Status.FAIL, "Failed to Enter ZipCode in TextBox");
			Assert.assertFalse(false, "ZipCode TextBox not found");
		}
	}

	public void propLatLong() throws Exception {

		if (Click_LatLong.isDisplayed()) {
			Javascriptexecutor(Click_LatLong);

			Thread.sleep(3000);

			System.out.println(" Clicked On LatLong ");
			logger.info("Clicked On LatLong ");
			test.log(Status.PASS, "Clicked On LatLong ");
			Assert.assertTrue(true, "Clicked On LatLong");
		} else {
			System.out.println("Clicked On LatLong");
			logger.error("Failed to Click on LatLong");
			test.log(Status.FAIL, "Failed to Click on LatLong");
			Assert.assertFalse(false, "Clicked On LatLong");
		}
	}

	public void propTimeZone(String EnterPropTimeZon) {

		SeleniumRepo.waitForElementPresent(Time_Zone_field);

		Assert.assertEquals(Time_Zone_field.isDisplayed(), true, "Time Zone dropdown Field is not being displayed");

		Select_Time_Zone_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_Time_Zone_DropDown, EnterPropTimeZon);

		System.out.println("Time Zone was selected successfully");

		//Due to the way selecting items in dropdown are being handled by the "seleniumrepoDropdown"(nothing in this
		//class allows us to return the actual items or entire list of the dropdown - need to add this to the class)
		//Also the way admin works it will have the previous value or default value of a dropdown item as selected
		//and will only change this status once a save is completed. So will have to figure out a way to
		// to compare the newly selected item does not match the previous or does match
		//The getText of method of a webeleent dropdown will return all options
		//-> Assert.assertEquals(Select_Time_Zone_DropDown.getText(), EnterPropTimeZon,"Time Zone dropdown was not selected");
		logger.info("Select PMS Interface was selected successfully");
		test.log(Status.PASS, "Select PMS Interface was selected successfully");

		/*
		 * if (Select_timezone.isDisplayed()) {
		 * 
		 * Select_time.click();
		 * SeleniumRepoDropdown.selectDropDownText(Select_timezone,
		 * EnterPropTimeZon);
		 * 
		 * SeleniumRepo.WaitForLoad(100);
		 * System.out.println(" timezone was selected successfully");
		 * logger.info("timezone was selected successfully");
		 * test.log(Status.PASS, "timezone is selected successfully");
		 * Assert.assertTrue(true, "timezone is selected successfully"); } else
		 * { System.out.println("Timezone dropdown was not found");
		 * logger.error("Failed to Select a Timezone"); test.log(Status.FAIL,
		 * "Failed to Select a  timezone"); Assert.assertFalse(false,
		 * "timezone dropdown not found"); }
		 */

	}

	public void propPmsInterface(String EnterPropPmsInterface){
		
		SeleniumRepo.waitForElementPresent(PMS_Interface_field);

		Assert.assertEquals(PMS_Interface_field.isDisplayed(), true,
				"Select PMS Interface dropdown Field is not being displayed");

		Select_PMS_Interface_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_PMS_Interface_DropDown, EnterPropPmsInterface);

		System.out.println("Select PMS Interface was selected successfully");
		//Due to the way selecting items in dropdown are being handled by the "seleniumrepoDropdown"(nothing in this
		//class allows us to return the actual items or entire list of the dropdown - need to add this to the class)
		//Also the way admin works it will have the previous value or default value of a dropdown item as selected
		//and will only change this status once a save is completed. So will have to figure out a way to
		// to compare the newly selected item does not match the previous or does match
		//The getText of method of a webeleent dropdown will return all options
		//update:tried using getAttribute("value") and the vlaue returned its index vlaue 
		//Assert.assertEquals(Select_PMS_Interface_DropDown.getAttribute("value"), EnterPropPmsInterface, "Select PMS Interface dropdown was not selected");
		logger.info("Select PMS Interface was selected successfully");
		test.log(Status.PASS, "Select PMS Interface was selected successfully");

		/*
		 * 
		 * if (Select_PMS_Interface.isDisplayed()) {
		 * 
		 * Select_PMS_Interface.click();
		 * SeleniumRepoDropdown.selectDropDownText(Select_PMS_Interface,
		 * EnterPropPmsInterface);
		 * 
		 * SeleniumRepo.WaitForLoad(100);
		 * System.out.println(" PMS Interfac was selected successfully");
		 * logger.info("PMS Interface was selected successfully");
		 * test.log(Status.PASS, " A PMS interface was selected successfully");
		 * Assert.assertTrue(true, "A PMS interface was selected successfully");
		 * } else { System.out.println("PMS Interface dropdown was not found");
		 * logger.error("Failed to Select a PMS Interface");
		 * test.log(Status.FAIL, "Failed to Select a  PMS Interface");
		 * Assert.assertFalse(false, "PMS Interface dropdown not found"); }
		 */

	}

	public void propMultiPropPortal(String EnterMultiPropertyPortals) {

		// take this into consideration " Separate portals using commas "

		SeleniumRepo.waitForElementPresent(MultiPropPortals_field);

		Assert.assertEquals(MultiPropPortals_field.isDisplayed(), true,
				"Multi-Property Portals text Field is not being displayed");

		Enter_MultiPropPortals_Text.click();
		Enter_MultiPropPortals_Text.clear();
		Enter_MultiPropPortals_Text.sendKeys(EnterMultiPropertyPortals);

		System.out.println("Multi-Property Portals is entered successfully");

		//Also the way admin works it will have the previous value or default value of a textfield
		//and will only change this status once a save is completed. So will have to figure out a way to
		// to compare the newly selected item does not match the previous or does match
		//The getText of method of a webeleent dropdown will return all options
		Assert.assertEquals(Enter_MultiPropPortals_Text.getAttribute("value"), EnterMultiPropertyPortals,"Multi-Property Portals Field text was not entered");
		logger.info("Multi-Property Portals is entered successfully");
		test.log(Status.PASS, "Multi-Property Portals is entered successfully");

		/*
		 * if (Enter_MultiPropPortals.isDisplayed()) {
		 * Enter_MultiPropPortals.click(); Enter_MultiPropPortals.clear();
		 * Enter_MultiPropPortals.sendKeys(EnterMultiPropertyPortals);
		 * 
		 * System.out.println(" multi property portals are entered successfully"
		 * ); logger.info("multi property portals are entered successfully");
		 * test.log(Status.PASS,
		 * "multi property portals are entered successfully");
		 * 
		 * Assert.assertTrue(true,
		 * "multi property portals are entered successfully"); } else {
		 * System.out.println("multi property portals TextBox not found");
		 * logger.error("Failed to Enter multi property portals in TextBox");
		 * test.log(Status.FAIL,
		 * "Failed to Enter multi property portals in TextBox");
		 * Assert.assertFalse(false,
		 * "multi property portals TextBox not found"); }
		 */

	}

	public void propTripAdvisorId(String EnterTripAdvisoId) {
		// keep in mind "Numbers Only. Ex: 730099" the field does not allow
		// letters or symbols

		SeleniumRepo.waitForElementPresent(TripAdvisorID_field);

		Assert.assertEquals(TripAdvisorID_field.isDisplayed(), true, "TripAdvisor ID text Field is not being displayed");

		Enter_TripAdvisorID_Text.click();
		Enter_TripAdvisorID_Text.clear();
		Enter_TripAdvisorID_Text.sendKeys(EnterTripAdvisoId);

		System.out.println("TripAdvisor ID is entered successfully");

		Assert.assertEquals(Enter_TripAdvisorID_Text.getAttribute("value"), EnterTripAdvisoId,"TripAdvisor ID Field text was not entered");
		logger.info("TripAdvisor ID is entered successfully");
		test.log(Status.PASS, "TripAdvisor ID is entered successfully");

		/*
		 * 
		 * if (Enter_TripAdviosrId.isDisplayed()) { Enter_TripAdviosrId.click();
		 * Enter_TripAdviosrId.clear();
		 * Enter_TripAdviosrId.sendKeys(EnterTripAdvisoId);
		 * 
		 * System.out.println(" tripadvisor id is entered successfully");
		 * logger.info("tripadvisor id is entered successfully");
		 * test.log(Status.PASS, "tripadvisor id is entered successfully");
		 * 
		 * Assert.assertTrue(true, "tripadvisor id is entered successfully"); }
		 * else { System.out.println("tripadvisor id TextBox not found");
		 * logger.error("Failed to Enter tripadvisor id in TextBox");
		 * test.log(Status.FAIL, "Failed to Enter tripadvisor id in TextBox");
		 * Assert.assertFalse(false, "tripadvisor id TextBox not found"); }
		 * 
		 * 
		 */

	}

	public void propWihpId(String EnterWhipId) {

		SeleniumRepo.waitForElementPresent(WihpID_field);

		Assert.assertEquals(WihpID_field.isDisplayed(), true, "WIHP ID text Field is not being displayed");

		Enter_WihpID_Text.click();
		Enter_WihpID_Text.clear();
		Enter_WihpID_Text.sendKeys(EnterWhipId);

		System.out.println("WIHP ID is entered successfully");

		Assert.assertEquals(Enter_WihpID_Text.getAttribute("value"), EnterWhipId, "WIHP ID Field text was not entered");
		logger.info("WIHP ID is entered successfully");
		test.log(Status.PASS, "WIHP ID is entered successfully");

		/*
		 * 
		 * if (Enter_EnterWhipId.isDisplayed()) { Enter_EnterWhipId.click();
		 * Enter_EnterWhipId.clear(); Enter_EnterWhipId.sendKeys(EnterWhipId);
		 * 
		 * System.out.println(" whip id is entered successfully");
		 * logger.info("whip id is entered successfully"); test.log(Status.PASS,
		 * "whip id is entered successfully");
		 * 
		 * Assert.assertTrue(true, "whip id is entered successfully"); } else {
		 * System.out.println("whip id TextBox not found");
		 * logger.error("Failed to Enter whip id in TextBox");
		 * test.log(Status.FAIL, "Failed to Enter whip id in TextBox");
		 * Assert.assertFalse(false, "whip id TextBox not found"); }
		 * 
		 */

	}

	public void propExternalIbeHostName(String EnterExternalIbeHostName) {

		SeleniumRepo.waitForElementPresent(LinkedDomain_field);

		Assert.assertEquals(LinkedDomain_field.isDisplayed(), true,
				"External IBE Host Name text Field is not being displayed");

		Enter_EnterExternalIbeHost_Text.click();
		Enter_EnterExternalIbeHost_Text.clear();
		Enter_EnterExternalIbeHost_Text.sendKeys(EnterExternalIbeHostName);

		System.out.println(" Linked Domain is entered successfully");

		Assert.assertEquals(Enter_EnterExternalIbeHost_Text.getAttribute("value"), EnterExternalIbeHostName,
				"The expected External IBE Host Name Field text was not entered");
		logger.info("External IBE Host Name is entered successfully");
		test.log(Status.PASS, "External IBE Host Name is entered successfully");

		/*
		 * 
		 * 
		 * if (Enter_EnterExternalIbeHost.isDisplayed()) {
		 * Enter_EnterExternalIbeHost.click();
		 * Enter_EnterExternalIbeHost.clear();
		 * Enter_EnterExternalIbeHost.sendKeys(EnterExternalIbeHostName);
		 * 
		 * System.out.println(" external ibe host name is entered successfully"
		 * ); logger.info("external ibe host name is entered successfully");
		 * test.log(Status.PASS,
		 * "external ibe host name is entered successfully");
		 * 
		 * Assert.assertTrue(true,
		 * "external ibe host name is entered successfully"); } else {
		 * System.out.println("external ibe host name TextBox not found");
		 * logger.error("Failed to Enter external ibe host name in TextBox");
		 * test.log(Status.FAIL,
		 * "Failed to Enter external ibe host name in TextBox");
		 * Assert.assertFalse(false,
		 * "external ibe host name TextBox not found"); }
		 * 
		 */

	}

	// Need to add a parameter that String activeStatus
	// Also confirm if this is actually clicking the correct radio button
	// WebElement
	// Room_Type=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@title,'"+RoomType+"')
	// and @type='checkbox']"));
	// -> the above line is how we are able to redefine a webelement within a
	// method
	public void propRateCalendar(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(Click_RateCalendar);

		Assert.assertEquals(Click_RateCalendar.isDisplayed(), true, "Rate Calendar Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_RateCalendar_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" RateCalendar enabled successfully");
			logger.info("RateCalendar selected successfully");
			test.log(Status.PASS, "RateCalendar selected successfully");
			Assert.assertTrue(Click_RateCalendar_Enable.isSelected(), "Rate Calendar is Enabled");

		} else {

			Click_RateCalendar_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("RateCalendar not selected");
			logger.error("Failed to Select RateCalendar");
			test.log(Status.FAIL, "Failed to Select RateCalendar");

			Assert.assertTrue(Click_RateCalendar_Disable.isSelected(), "Rate Calendar is disable");

		}

	}

	public void propBrg(String status) throws Exception {

		// -> //*[@name='isAddOnTaxesEnabled'][2] -> [#] can either be 1 yes or
		// 2 for no

		SeleniumRepo.waitForElementPresent(BRG_field);

		Assert.assertEquals(BRG_field.isDisplayed(), true, "The BRG Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_BRG_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" BRG is enabled successfully");
			logger.info("BRG selected successfully");
			test.log(Status.PASS, "BRG selected successfully");
			Assert.assertTrue(Click_BRG_Enable.isSelected(), "BRG is Enabled");

		} else {

			Click_BRG_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("BRG not selected");
			logger.error("Failed to Select BRG");
			test.log(Status.FAIL, "Failed to Select BRG");

			Assert.assertTrue(Click_BRG_Disable.isSelected(), "Rate Calendar is disable");

		}

	}

	public void propEmailRetargetingAccess(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(EmailRetargetingAcces_field);

		Assert.assertEquals(EmailRetargetingAcces_field.isDisplayed(), true,
				"Email Retargeting Accees Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_EmailRetargetingAcces_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Email Retargeting Accees is enabled successfully");
			logger.info("Email Retargeting Accees selected successfully");
			test.log(Status.PASS, "Email Retargeting Accees selected successfully");
			Assert.assertTrue(Click_EmailRetargetingAcces_Enable.isSelected(), "BRG is Enabled");

		} else {

			Click_EmailRetargetingAcces_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Email Retargeting Accees not selected");
			logger.error("Failed to Select Email Retargeting Accees");
			test.log(Status.FAIL, "Failed to Select Email Retargeting");

			Assert.assertTrue(Click_EmailRetargetingAcces_Disable.isSelected(), "Email Retargeting Accees is disable");

		}

	}

	public void propAddOnTaxes(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(AddOnTaxes_field);

		Assert.assertEquals(AddOnTaxes_field.isDisplayed(), true, "AddOn Taxes Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_AddOnTaxes_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" AddOn Taxes is enabled successfully");
			logger.info("AddOn Taxes selected successfully");
			test.log(Status.PASS, "AddOn Taxes selected successfully");
			Assert.assertTrue(Click_AddOnTaxes_Enable.isSelected(), "AddOn Taxes is Enabled");

		} else {

			Click_AddOnTaxes_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("AddOn Taxes not selected");
			logger.error("Failed to Select AddOn Taxes");
			test.log(Status.FAIL, "Failed to Select AddOn Taxes");

			Assert.assertTrue(Click_AddOnTaxes_Disable.isSelected(), "AddOn Taxes is disable");

		}

	}

	public void propAdA(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(ADA_field);

		Assert.assertEquals(ADA_field.isDisplayed(), true, "AddOn Taxes Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_ADA_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" ADA is enabled successfully");
			logger.info("ADA selected successfully");
			test.log(Status.PASS, "ADA selected successfully");
			Assert.assertTrue(Click_ADA_Enable.isSelected(), "ADA is Enabled");

		} else {

			Click_ADA_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("ADA not selected");
			logger.error("Failed to Select ADA");
			test.log(Status.FAIL, "Failed to Select ADA");

			Assert.assertTrue(Click_ADA_Disable.isSelected(), "ADA is disable");

		}

	}

	public void propRatesRecievePmsInclusiveTaxes(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(PMSratesIncludeTaxes_field);

		Assert.assertEquals(PMSratesIncludeTaxes_field.isDisplayed(), true,
				"rates recieved from PMS inclusive of Taxes Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_PMSratesIncludeTaxes_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" rates recieved from PMS inclusive of Taxes is enabled successfully");
			logger.info("rates recieved from PMS inclusive of Taxes selected successfully");
			test.log(Status.PASS, "rates recieved from PMS inclusive of Taxes selected successfully");
			Assert.assertTrue(Click_PMSratesIncludeTaxes_Enable.isSelected(),
					"rates recieved from PMS inclusive of Taxes is Enabled");

		} else {

			Click_PMSratesIncludeTaxes_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("rates recieved from PMS inclusive of Taxes not selected");
			logger.error("Failed to Select rates recieved from PMS inclusive of Taxes");
			test.log(Status.FAIL, "Failed to Select rates recieved from PMS inclusive of Taxes");

			Assert.assertTrue(Click_PMSratesIncludeTaxes_Disable.isSelected(),
					"rates recieved from PMS inclusive of Taxes is disable");

		}

	}

	public void propCallCenter(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(CallCenter_field);

		Assert.assertEquals(CallCenter_field.isDisplayed(), true, "CallCenter Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_CallCenter_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" CallCenter is enabled successfully");
			logger.info("CallCenter selected successfully");
			test.log(Status.PASS, "CallCenter selected successfully");
			Assert.assertTrue(Click_CallCenter_Enable.isSelected(), "CallCenter is Enabled");

		} else {

			Click_CallCenter_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("CallCenter not selected");
			logger.error("Failed to Select CallCenter");
			test.log(Status.FAIL, "Failed to Select CallCenter");

			Assert.assertTrue(Click_CallCenter_Disable.isSelected(),
					"rates recieved from PMS inclusive of Taxes is disable");

		}

		/*
		 * if (Click_CallCenter.isDisplayed()) { if
		 * (Click_CallCenter.isSelected() == false) Click_CallCenter.click();
		 * SeleniumRepo.WaitForLoad(100);
		 * System.out.println(" CallCenter selected successfully");
		 * logger.info("CallCenter selected successfully");
		 * test.log(Status.PASS, "CallCenter selected successfully");
		 * Assert.assertTrue(true, "CallCenter selected successfully"); } else {
		 * System.out.println("CallCenter not selected");
		 * logger.error("Failed to Select CallCenter"); test.log(Status.FAIL,
		 * "Failed to Select CallCenter"); Assert.assertFalse(false,
		 * "CallCenter not selected"); }
		 * 
		 */

	}

	public void propNorParticipant(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(Click_Nor1Participant);

		Assert.assertEquals(Click_Nor1Participant.isDisplayed(), true, "Nor1 Participant Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_Nor1Participant_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Nor1 Participant is enabled successfully");
			logger.info("Nor1 Participant selected successfully");
			test.log(Status.PASS, "Nor1 Participant selected successfully");
			Assert.assertTrue(Click_Nor1Participant_Enable.isSelected(), "Nor1 Participant is Enabled");

		} else {

			Click_Nor1Participant_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Nor1 Participant not selected");
			logger.error("Failed to Select Nor1 Participant");
			test.log(Status.FAIL, "Failed to Select Nor1 Participant");

			Assert.assertTrue(Click_Nor1Participant_Disable.isSelected(), "Nor1 Participant is disable");

		}

	}

	public void propIncludeTrivagoSearch(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(TrivagoSearch_field);

		Assert.assertEquals(TrivagoSearch_field.isDisplayed(), true, "Trivago Search Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_TrivagoSearch_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Trivago Search is enabled successfully");
			logger.info("Trivago Search selected successfully");
			test.log(Status.PASS, "Trivago Search selected successfully");
			Assert.assertTrue(Click_TrivagoSearch_Enable.isSelected(), "Trivago Search is Enabled");

		} else {

			Click_TrivagoSearch_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Trivago Search not selected");
			logger.error("Failed to Select Trivago Search");
			test.log(Status.FAIL, "Failed to Select Trivago Search");

			Assert.assertTrue(Click_TrivagoSearch_Disable.isSelected(), "Trivago Search is disable");

		}

	}

	public void propSubToCommissionProcessing(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(SubscribedCommissionProcessing_field);

		Assert.assertEquals(SubscribedCommissionProcessing_field.isDisplayed(), true,
				"Subscribed to Commission Processing Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_SubscribedCommissionProcessing_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Subscribed to Commission Processing is enabled successfully");
			logger.info("Subscribed to Commission Processing selected successfully");
			test.log(Status.PASS, "Subscribed to Commission Processing selected successfully");
			Assert.assertTrue(Click_SubscribedCommissionProcessing_Enable.isSelected(),
					"Subscribed to Commission Processing is Enabled");

		} else {

			Click_SubscribedCommissionProcessing_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Subscribed to Commission Processing not selected");
			logger.error("Failed to Select Subscribed to Commission Processing");
			test.log(Status.FAIL, "Failed to Select Subscribed to Commission Processing");

			Assert.assertTrue(Click_SubscribedCommissionProcessing_Disable.isSelected(), "Trivago Search is disable");

		}

	}

	public void propAdsOnConfirmationPage(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(AdsOnConfirmationPage_field);

		Assert.assertEquals(AdsOnConfirmationPage_field.isDisplayed(), true,
				"Ads on Confirmation Page Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_AdsOnConfirmationPage_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Ads on Confirmation Page is enabled successfully");
			logger.info("Ads on Confirmation Page selected successfully");
			test.log(Status.PASS, "Ads on Confirmation Page selected successfully");
			Assert.assertTrue(Click_AdsOnConfirmationPage_Enable.isSelected(), "Ads on Confirmation Page is Enabled");

		} else {

			Click_AdsOnConfirmationPage_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Ads on Confirmation Page not selected");
			logger.error("Failed to Select Ads on Confirmation Page");
			test.log(Status.FAIL, "Failed to Select Ads on Confirmation Page");

			Assert.assertTrue(Click_AdsOnConfirmationPage_Disable.isSelected(), " Ads on Confirmation Page is disable");

		}

	}

	public void propGoogleAnalytics(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(GoogleAnalytics_field);

		Assert.assertEquals(GoogleAnalytics_field.isDisplayed(), true, "Google Analytics Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_GoogleAnalytics_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Google Analytics is enabled successfully");
			logger.info("Google Analytics selected successfully");
			test.log(Status.PASS, "Google Analytics selected successfully");
			Assert.assertTrue(Click_GoogleAnalytics_Enable.isSelected(), "Google Analytics is Enabled");

		} else {

			Click_GoogleAnalytics_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Google Analytics not selected");
			logger.error("Failed to Select Google Analytics");
			test.log(Status.FAIL, "Failed to Select Google Analytics");

			Assert.assertTrue(Click_GoogleAnalytics_Disable.isSelected(), " Google Analytics is disable");

		}

	}

	public void propGoogleAnalyticsProfile() {

		// Deal with is a latter

		/*
		 * 
		 * @FindAll({@FindBy(xpath =
		 * "//td[contains(text(),'Google Analytics Profile')]") }) public
		 * WebElement Click_GoogleAnalyticsProfile;
		 * 
		 * @FindAll({@FindBy(xpath = "//*[@name='gaEnabled'][1]") })
		 * //*[@name='isAddOnTaxesEnabled'][1] public WebElement <List>
		 * Click_GoogleAnalyticsProfile_Text;
		 * 
		 * @FindAll({@FindBy(xpath = "//*[@name='gaEnabled'][2]") }) public
		 * WebElement Click_GoogleAnalytics_Disable;
		 * 
		 * 
		 */

		// has a text field[ can access it by using name "gaProfile_3" initail
		// field is "gaProfile_0"] , a delete link and a add button

	}

	public void propCrossDomaintracking(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(CrossDomainTracking_field);

		Assert.assertEquals(CrossDomainTracking_field.isDisplayed(), true,
				"Cross-Domain Tracking Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_CrossDomainTracking_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Cross-Domain Tracking is enabled successfully");
			logger.info("Cross-Domain Tracking selected successfully");
			test.log(Status.PASS, "Cross-Domain Tracking selected successfully");
			Assert.assertTrue(Click_CrossDomainTracking_Enable.isSelected(), "Cross-Domain Tracking is Enabled");

		} else {

			Click_CrossDomainTracking_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Cross-Domain not selected");
			logger.error("Failed to Select Cross-Domain");
			test.log(Status.FAIL, "Failed to Select Cross-Domain");

			Assert.assertTrue(Click_CrossDomainTracking_Disable.isSelected(), " Cross-Domain is disable");

		}

	}

	public void propLinkedDomain(String EnterDomain) {

		// Based on if propCrossDomainTracking is yes

		SeleniumRepo.waitForElementPresent(LinkedDomain_field);

		Assert.assertEquals(LinkedDomain_field.isDisplayed(), true, "Linked Domain text Field is not being displayed");

		Enter_LinkedDomain_Text.click();
		Enter_LinkedDomain_Text.clear();
		Enter_LinkedDomain_Text.sendKeys(EnterDomain);

		System.out.println(" Linked Domain is entered successfully");

		Assert.assertEquals(Enter_LinkedDomain_Text.getAttribute("value"), EnterDomain,
				"The expected Domain Field text was not entered");
		logger.info("Linked Domain is entered successfully");
		test.log(Status.PASS, "Linked Domain is entered successfully");

		// System.out.println("whip id TextBox not found");
		// logger.error("Failed to Enter whip id in TextBox");
		// test.log(Status.FAIL, "Failed to Enter whip id in TextBox");
		// Assert.assertFalse(false, "whip id TextBox not found");

	}

	public void propEnforceHouseLevelInventory(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(HouseLevelInventory_field);

		Assert.assertEquals(HouseLevelInventory_field.isDisplayed(), true,
				"House Level Inventory Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_HouseLevelInventory_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("House Level Inventory is enabled successfully");
			logger.info("House Level Inventory selected successfully");
			test.log(Status.PASS, "House Level Inventory selected successfully");
			Assert.assertTrue(Click_HouseLevelInventory_Enable.isSelected(), "House Level Inventory is Enabled");

		} else {

			Click_HouseLevelInventory_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("House Level Inventory not selected");
			logger.error("Failed to Select House Level Inventory");
			test.log(Status.FAIL, "Failed to Select House Level Inventory");

			Assert.assertTrue(Click_HouseLevelInventory_Disable.isSelected(), " House Level Inventory is disable");

		}

	}

	public void propEnforceHouseLevelYieldControls(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(HouseLevelYieldControls_field);

		Assert.assertEquals(HouseLevelYieldControls_field.isDisplayed(), true,
				"House Level Yield Controls Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_HouseLevelYieldControls_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("House Level Yield Controls is enabled successfully");
			logger.info("House Level Yield Controls selected successfully");
			test.log(Status.PASS, "House Level Yield Controls selected successfully");
			Assert.assertTrue(Click_HouseLevelYieldControls_Enable.isSelected(),
					"House Level Yield Controls is Enabled");

		} else {

			Click_HouseLevelYieldControls_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("House Level Yield Controls not selected");
			logger.error("Failed to Select House Level Yield Controls");
			test.log(Status.FAIL, "Failed to Select House Level Yield Controls");

			Assert.assertTrue(Click_HouseLevelYieldControls_Disable.isSelected(),
					" House Level Yield Controls is disable");

		}

	}

	public void propFullPatternLosRestriction(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(FullPatternLOSRestriction_field);

		Assert.assertEquals(FullPatternLOSRestriction_field.isDisplayed(), true,
				"Full Pattern LOS Restriction Field is not being displayed");

		if (status.equalsIgnoreCase("enable")) {

			Click_FullPatternLOSRestriction_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Full Pattern LOS Restriction is enabled successfully");
			logger.info("Full Pattern LOS Restriction selected successfully");
			test.log(Status.PASS, "Full Pattern LOS Restriction selected successfully");
			Assert.assertTrue(Click_FullPatternLOSRestriction_Enable.isSelected(),
					"Full Pattern LOS Restriction is Enabled");

		} else {

			Click_FullPatternLOSRestriction_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Full Pattern LOS Restriction not selected");
			logger.error("Failed to Select Full Pattern LOS Restriction");
			test.log(Status.FAIL, "Failed to Select Full Pattern LOS Restriction");

			Assert.assertTrue(Click_FullPatternLOSRestriction_Disable.isSelected(),
					" Full Pattern LOS Restriction is disable");

		}

	}

	public void propFilterAvailResultsBaseOnHurdle(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(FilterAvailResBaseHurdleRate_field);

		Assert.assertEquals(FilterAvailResBaseHurdleRate_field.isDisplayed(), true,
				"Filter Availability Results based on Hurdle Rate Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_FilterAvailResBaseHurdleRate_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Filter Availability Results based on Hurdle Rate is enabled successfully");
			logger.info("Filter Availability Results based on Hurdle Rate selected successfully");
			test.log(Status.PASS, "Filter Availability Results based on Hurdle Rate selected successfully");
			Assert.assertTrue(Click_FilterAvailResBaseHurdleRate_Enable.isSelected(),
					"Filter Availability Results based on Hurdle Rate is Enabled");

		} else {

			Click_FilterAvailResBaseHurdleRate_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Filter Availability Results based on Hurdle Rate not selected");
			logger.error("Failed to Select Filter Availability Results based on Hurdle Rate");
			test.log(Status.FAIL, "Failed to Select Filter Availability Results based on Hurdle Rate");

			Assert.assertTrue(Click_FilterAvailResBaseHurdleRate_Disable.isSelected(),
					" Filter Availability Results based on Hurdle Rate is disable");

		}

	}

	public void propPerPersonPricing(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(PerPersonPricing_field);

		Assert.assertEquals(PerPersonPricing_field.isDisplayed(), true,
				"Per Person Pricing Field is not being displayed");

		if (status.equalsIgnoreCase("enable")) {

			Click_PerPersonPricingg_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Per Person Pricing is enabled successfully");
			logger.info("Per Person Pricing selected successfully");
			test.log(Status.PASS, "Per Person Pricing selected successfully");
			Assert.assertTrue(Click_PerPersonPricingg_Enable.isSelected(), "Per Person Pricing is Enabled");

		} else {

			Click_PerPersonPricing_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Per Person Pricing not selected");
			logger.error("Failed to Select Per Person Pricing");
			test.log(Status.FAIL, "Failed to Select Per Person Pricing");

			Assert.assertTrue(Click_PerPersonPricing_Disable.isSelected(), " Per Person Pricing is disable");

		}

	}

	public void propRecalculateUpcTaxes(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(RecalculateUPCTaxes_field);

		Assert.assertEquals(RecalculateUPCTaxes_field.isDisplayed(), true,
				"Recalculate UPC Taxes Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_RecalculateUPCTaxes_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Recalculate UPC Taxes is enabled successfully");
			logger.info("Recalculate UPC Taxes selected successfully");
			test.log(Status.PASS, "Recalculate UPC Taxes selected successfully");
			Assert.assertTrue(Click_RecalculateUPCTaxes_Enable.isSelected(), "Recalculate UPC Taxes is Enabled");

		} else {

			Click_RecalculateUPCTaxes_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Recalculate UPC Taxes not selected");
			logger.error("Failed to Select Recalculate UPC Taxes");
			test.log(Status.FAIL, "Failed to Select Recalculate UPC Taxes");

			Assert.assertTrue(Click_RecalculateUPCTaxes_Disable.isSelected(), " Recalculate UPC Taxes is disable");

		}

	}

	public void propSendCurrencyConvInNotifiEmail(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(SendCurrencyConversionsInEmails_field);

		Assert.assertEquals(SendCurrencyConversionsInEmails_field.isDisplayed(), true,
				"Send currency conversions in notification emails Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_SendCurrencyConversionsInEmails_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Send currency conversions in notification emails is enabled successfully");
			logger.info("Send currency conversions in notification emails selected successfully");
			test.log(Status.PASS, "Send currency conversions in notification emails selected successfully");
			Assert.assertTrue(Click_SendCurrencyConversionsInEmails_Enable.isSelected(),
					"Send currency conversions in notification emails is Enabled");

		} else {

			Click_SendCurrencyConversionsInEmails_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Send currency conversions in notification emails not selected");
			logger.error("Failed to Select Send currency conversions in notification emails");
			test.log(Status.FAIL, "Failed to Select Send currency conversions in notification emails");

			Assert.assertTrue(Click_SendCurrencyConversionsInEmails_Disable.isSelected(),
					" Send currency conversions in notification emails  is disable");

		}

	}

	public void propRoomThresholds(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(RoomThresholds_fields);

		Assert.assertEquals(RoomThresholds_fields.isDisplayed(), true, "Room Thresholds Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_RoomThresholds_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Room Thresholds is enabled successfully");
			logger.info("Room Thresholds selected successfully");
			test.log(Status.PASS, "Room Thresholds selected successfully");
			Assert.assertTrue(Click_RoomThresholds_Enable.isSelected(), "Room Thresholds is Enabled");

		} else {

			Click_RoomThresholds_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Room Thresholds not selected");
			logger.error("Failed to Select Room Thresholds");
			test.log(Status.FAIL, "Failed to Select Room Thresholds");

			Assert.assertTrue(Click_RoomThresholds_Disable.isSelected(), " Room Thresholds is disable");

		}
		
		//After enabling threshold call another method that will select its channels
		// Field name Enable Room Thresholds for channels
		//check box: //*[@name='applicableChannelsForRoomThresold'][n]
	
		

	}

	public void propDerbySoftConn(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(DerbySoftConnection_field);

		Assert.assertEquals(DerbySoftConnection_field.isDisplayed(), true,
				"DerbySoft Connection Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_DerbySoftConnection_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("DerbySoft Connection is enabled successfully");
			logger.info("DerbySoft Connection selected successfully");
			test.log(Status.PASS, "DerbySoft Connection selected successfully");
			Assert.assertTrue(Click_DerbySoftConnection_Enable.isSelected(), "DerbySoft Connection is Enabled");

		} else {

			Click_DerbySoftConnection_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("DerbySoft Connection not selected");
			logger.error("Failed to Select DerbySoft Connection");
			test.log(Status.FAIL, "Failed to Select DerbySoft Connection");

			Assert.assertTrue(Click_DerbySoftConnection_Disable.isSelected(), "DerbySoft Connection is disable");

		}

	}

	public void propWihpConnection(String status) throws Exception {
		
		//Seems to be disable and does not appear on the initial add property page

		SeleniumRepo.waitForElementPresent(WihpConnection_field);

		Assert.assertEquals(WihpConnection_field.isDisplayed(), true, "WIHP Connection Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_WihpConnection_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("WIHP Connection is enabled successfully");
			logger.info("WIHP Connection selected successfully");
			test.log(Status.PASS, "WIHP Connection selected successfully");
			Assert.assertTrue(Click_WihpConnection_Enable.isSelected(), "WIHP Connection is Enabled");

		} else {

			Click_WihpConnection_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("WIHP Connection not selected");
			logger.error("Failed to Select WIHP Connection");
			test.log(Status.FAIL, "Failed to Select WIHP Connection");

			Assert.assertTrue(Click_WihpConnection_Disable.isSelected(), "WIHP Connection is disable");

		}

	}

	/**
	 * Will have to deal with this later because a few other places need to be
	 * enabled before using ths field
	 * 
	 */
	public void propGoogleConnection() { // must activate a few things on
											// another page

		/*
		 * 
		 * @FindAll({@FindBy(xpath =
		 * "//td[contains(text(),'Enable Cross-Domain Tracking')]") }) public
		 * WebElement Click_CrossDomainTracking;
		 * 
		 * @FindAll({@FindBy(xpath = "//*[@name='gaCrossDomain'][1]") })
		 * //*[@name='isAddOnTaxesEnabled'][1] public WebElement
		 * Click_CrossDomainTracking_Enable;
		 * 
		 * @FindAll({@FindBy(xpath = "//*[@name='gaCrossDomain'][2]") }) public
		 * WebElement Click_CrossDomainTracking_Disable;
		 * 
		 * 
		 */

	}

	public void propHouseLevelYieldControlsToGroup(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(HouseLevelYieldControlsGroups_field);

		Assert.assertEquals(HouseLevelYieldControlsGroups_field.isDisplayed(), true,
				"House Level Yield Controls to Groups Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_HouseLevelYieldControlsGroups_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("House Level Yield Controls to Groups is enabled successfully");
			logger.info("House Level Yield Controls to Groups selected successfully");
			test.log(Status.PASS, "Cross-Domain Tracking selected successfully");
			Assert.assertTrue(Click_HouseLevelYieldControlsGroups_Enable.isSelected(),
					"House Level Yield Controls to Groups is Enabled");

		} else {

			Click_HouseLevelYieldControlsGroups_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("House Level Yield Controls to Groups not selected");
			logger.error("Failed to Select House Level Yield Controls to Groups");
			test.log(Status.FAIL, "Failed to Select House Level Yield Controls to Groups");

			Assert.assertTrue(Click_HouseLevelYieldControlsGroups_Disable.isSelected(),
					" House Level Yield Controls to Groups is disable");

		}

	}

	public void propElevateProgram(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(ElevateProgram_field);

		Assert.assertEquals(ElevateProgram_field.isDisplayed(), true,
				"Elevate Meriton Program Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_ElevateProgram_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Elevate Meriton Program is enabled successfully");
			logger.info("Elevate Meriton Program selected successfully");
			test.log(Status.PASS, "Elevate Meriton Program selected successfully");
			Assert.assertTrue(Click_ElevateProgram_Enable.isSelected(), "Elevate Meriton Program is Enabled");

		} else {

			Click_ElevateProgram_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Elevate Meriton Program not selected");
			logger.error("Failed to Select Elevate Meriton Program");
			test.log(Status.FAIL, "Failed to Select Elevate Meriton Program");

			Assert.assertTrue(Click_ElevateProgram_Disable.isSelected(), " Elevate Meriton Program is disable");

		}

	}

	public void propTrackingCodeAllPgs(String trackingCodeAllpg) {

		SeleniumRepo.waitForElementPresent(TrackingCodeAllPgs_field);

		Assert.assertEquals(TrackingCodeAllPgs_field.isDisplayed(), true,
				"Tracking Code - all pages text Field is not being displayed");

		Enter_TrackingCodeAllPgs_Text.click();
		Enter_TrackingCodeAllPgs_Text.clear();
		Enter_TrackingCodeAllPgs_Text.sendKeys(trackingCodeAllpg);

		System.out.println("Tracking Code - all pages text is entered successfully");

		Assert.assertEquals(Enter_TrackingCodeAllPgs_Text.getAttribute("value"), trackingCodeAllpg,
				"The expected Tracking Code - all pages Field text was not entered");
		logger.info("Tracking Code - all pages is entered successfully");
		test.log(Status.PASS, "Tracking Code - all pages is entered successfully");

	}

	public void propTrackingCodeNonConfirmPgs(String TrackCodeNonConfPg) {

		SeleniumRepo.waitForElementPresent(TrackingCodeNonConfirmPg_field);

		Assert.assertEquals(TrackingCodeNonConfirmPg_field.isDisplayed(), true,
				"Tracking Code - non-confirmation pages text Field is not being displayed");

		Enter_TrackingCodeNonConfirmPg_Text.click();
		Enter_TrackingCodeNonConfirmPg_Text.clear();
		Enter_TrackingCodeNonConfirmPg_Text.sendKeys(TrackCodeNonConfPg);

		System.out.println(" Tracking Code - non-confirmation pages is entered successfully");

		Assert.assertEquals(Enter_TrackingCodeNonConfirmPg_Text.getAttribute("value"), TrackCodeNonConfPg,
				"The expected Tracking Code - non-confirmation pages Field text was not entered");
		logger.info("Tracking Code - non-confirmation pages is entered successfully");
		test.log(Status.PASS, "Tracking Code - non-confirmation pages is entered successfully");

	}

	public void propTrackingCodeConfimPgs(String TrackCodeConfPg) {

		SeleniumRepo.waitForElementPresent(TrackingCodeConfirmPg_field);

		Assert.assertEquals(TrackingCodeConfirmPg_field.isDisplayed(), true,
				"Tracking Code - confirmation pages text Field is not being displayed");

		Enter_TrackingCodeConfirmPg_Text.click();
		Enter_TrackingCodeConfirmPg_Text.clear();
		Enter_TrackingCodeConfirmPg_Text.sendKeys(TrackCodeConfPg);

		System.out.println(" Tracking Code - confirmation pages is entered successfully");

		Assert.assertEquals(Enter_TrackingCodeConfirmPg_Text.getAttribute("value"), TrackCodeConfPg,
				"The expected Tracking Code - confirmation pages Field text was not entered");
		logger.info("Tracking Code - confirmation pages is entered successfully");
		test.log(Status.PASS, "Tracking Code - confirmation pages is entered successfully");

	}

	public void propInitialPmsResvSyncFlag(String status) {

		SeleniumRepo.waitForElementPresent(IniPMSReservationSyncFlag_field);

		Assert.assertEquals(IniPMSReservationSyncFlag_field.isDisplayed(), true,
				"Initial PMS Reservation Sync Flag  Field is not being displayed");

		// if statement that will check the status of the field and whether the
		// check box is checked or not

		if (status.equalsIgnoreCase("enable") && Clicking_DoNotAdjustInventoryForCancels.isSelected() == false) {

			Clicking_IniPMSReservationSyncFlag.click();

			Assert.assertEquals(Clicking_IniPMSReservationSyncFlag.isSelected(), true,
					"Initial PMS Reservation Sync Flag  was not checked");
		} else if (status.equalsIgnoreCase("disable") && Clicking_IniPMSReservationSyncFlag.isSelected()) {

			Clicking_IniPMSReservationSyncFlag.click();

			Assert.assertEquals(Clicking_IniPMSReservationSyncFlag.isSelected(), false,
					"Initial PMS Reservation Sync Flag  was not unchecked");

		} else {

			System.out.println("Nothing was changed");

		}

	}

	public void propDoNotAdjustInventoryForCancels(String status) {

		SeleniumRepo.waitForElementPresent(DoNotAdjustInventoryForCancels_field);

		Assert.assertEquals(DoNotAdjustInventoryForCancels_field.isDisplayed(), true,
				"Do Not Adjust Inventory for Cancels Field is not being displayed");
		


		if (status.equalsIgnoreCase("enable") && Clicking_DoNotAdjustInventoryForCancels.isSelected() == false ) {
			
			Clicking_DoNotAdjustInventoryForCancels.click();
			
			//Javascriptexecutor(Clicking_DoNotAdjustInventoryForCancels);	


			Assert.assertEquals(Clicking_DoNotAdjustInventoryForCancels.isSelected(), true,
					"Do Not Adjust Inventory for Cancels was checked");
		} else if (status.equalsIgnoreCase("disable") && Clicking_DoNotAdjustInventoryForCancels.isSelected()) {

			Clicking_DoNotAdjustInventoryForCancels.click();

			Assert.assertEquals(Clicking_DoNotAdjustInventoryForCancels.isSelected(), false,
					"Do Not Adjust Inventory for Cancels was not unchecked");

		} else {

			System.out.println("Nothing was changed");

		}

	}

	public void propGroupRatePlanPrefix(String GroupRatePlanPrefix) {

		SeleniumRepo.waitForElementPresent(GroupRatePlanPrefix_field);

		Assert.assertEquals(GroupRatePlanPrefix_field.isDisplayed(), true,
				"Group ratePlan prefix text Field is not being displayed");

		Enter_GroupRatePlanPrefix_Text.click();
		Enter_GroupRatePlanPrefix_Text.clear();
		Enter_GroupRatePlanPrefix_Text.sendKeys(GroupRatePlanPrefix);

		System.out.println(" Group ratePlan prefix is entered successfully");

		Assert.assertEquals(Enter_GroupRatePlanPrefix_Text.getAttribute("value"), GroupRatePlanPrefix,
				"Group ratePlan prefix Field text was not entered");
		logger.info("Group ratePlan prefix is entered successfully");
		test.log(Status.PASS, "Group ratePlan prefix is entered successfully");
	}

	public void propSave() {

		if (Click_Save1.isDisplayed()) {
			Click_Save1.click();
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
		} else {
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");
		}
		
		if (SeleniumRepo.isElementDisplayed(WhipConnection_Popup_OK) == true){
			WhipConnection_Popup_OK.click();
		}

	}

	public void propCancel() {

		if (Cancel_Button.isDisplayed()) {
			Cancel_Button.click();
			logger.info("Clicked on Cancel button");
			test.log(Status.PASS, "Clicked on cancel button");
		} else {
			logger.error("Failed to Click on cancel button");
			test.log(Status.FAIL, "Failed to Click on cancel button");
		}

	}

	
	
	/**
	 * Original method that was used during regression found in AddNewProperty.java
	 * @param PropertyName
	 * @param PropertyCode
	 * @param SubDomain
	 * @param EnterAddress1
	 * @param EnterCityName
	 * @param EnterCountryName
	 * @param EnterZipCode
	 * @param AddPropertyTitle
	 * @throws Exception
	 */
	public void newProperty
	(String PropertyName, String PropertyCode, String SubDomain, String EnterAddress1,
			String EnterCityName, String EnterCountryName, String EnterZipCode,
			String AddPropertyTitle) throws Exception 
	{

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
		if(Click_PropertyManagement.isDisplayed()) 
		{
			Click_PropertyManagement.click();
			logger.info("Clicked on property Management Link");
			test.log(Status.PASS,
					"Clicked on property Management Link" );
			Assert.assertTrue(true, "Clicked on property Management Link");}
		else {
			System.out.println(" property Management Link is not found");
			logger.error("Failed to Click on Brand button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");
			Assert.assertFalse(false, "Property Management Link not found");}



		SeleniumRepo.waitForElementPresent(Click_AddNew);
		if(Click_AddNew.isDisplayed()) 
		{
			Click_AddNew.click();
			logger.info("Clicked on AddNew Link");
			test.log(Status.PASS,
					"Clicked on AddNew Link" );
			Assert.assertTrue(true, "Clicked on AddNew Link");
		}else {
			System.out.println(" AddNew is not found");
			logger.error("Failed to Click on AddNew");
			test.log(Status.FAIL,
					"Failed to Click on AddNew");
			Assert.assertFalse(false, "AddNew Link not found");
		}

		/*//System.out.println("Expected"+AddPropertyTitle);
		String actualTitle = Verify_AddPropertyTitle.getText();
       //System.out.println(Verify_AddPropertyTitle.getText());
				if(actualTitle.equalsIgnoreCase(AddPropertyTitle)) {
			System.out.println("Title Matched");
		test.log(Status.INFO, " AddProperty Title Matched");
		Assert.assertTrue(true, "AddProperty Title Matched");}
			else {
			System.out.println("Title didn't match");
		test.log(Status.FAIL, "AddProperty Title didn't match");
		Assert.assertFalse(false, "AddProperty Title didn't match");}*/

		System.out.println(Verify_AddPropertyTitle.getText());
		System.out.println("Expected"+AddPropertyTitle);
		try  
		{
			Assert.assertEquals(AddPropertyTitle,Verify_AddPropertyTitle.getText());
			System.out.println("Title Matched");
			logger.info("AddProperty Title Matched");
			test.log(Status.PASS,
					"AddProperty Title Matched" );
			Assert.assertTrue(true, "AddProperty Title Matched");
		} catch (Error e) {
			System.out.println("Title didn't match");
			logger.error("AddProperty Title didn't match");
			test.log(Status.FAIL,
					"AddProperty Title didn't match");
			Assert.assertFalse(false, "AddProperty Title didn't match");
		}

		if (Enter_PropertyName.isDisplayed()) 
		{
			Enter_PropertyName.click();
			Enter_PropertyName.sendKeys(PropertyName);
			System.out.println(" PropertyName is entered successfully");
			logger.info("PropertyName is entered successfully");
			test.log(Status.PASS,
					"PropertyName is entered successfully" );
			Assert.assertTrue(true,"PropertyName is entered successfully");
		} else {
			System.out.println("PropertyName TextBox not found");
			logger.error("Failed to Found PropertyName  TextBox");
			test.log(Status.FAIL,
					"Failed to Found PropertyName  TextBox");
			Assert.assertFalse(false, "PropertyName TextBox not found");
		}

		if (Enter_PropertyCode.isDisplayed()) 
		{
			Enter_PropertyCode.click();
			Enter_PropertyCode.sendKeys(PropertyCode);
			System.out.println(" PropertyCode is entered successfully");
			logger.info("PropertyCode is entered successfully");
			test.log(Status.PASS,
					"PropertyCode is entered successfully" );
			Assert.assertTrue(true,"PropertyCode is entered successfully");
		} else {
			System.out.println("PropertyCode TextBox not found");
			logger.error("Failed to Enter  PropertyCode in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter PropertyCode in TextBox");
			Assert.assertFalse(false, "PropertyCode TextBox not found");
		}

		if (Click_BookingEngineVersion.isDisplayed()) 
		{
			if (Click_BookingEngineVersion.isSelected() == false)
				Click_BookingEngineVersion.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println("Booking Engine Version is Clicked successfully");
			logger.info("Booking Engine Version is Clicked successfully");
			test.log(Status.PASS,
					"Booking Engine Version is Clicked successfully" );
			Assert.assertTrue(true," Booking Engine Version is Clicked successfully");
		} else {
			System.out.println("Booking Engine Version not Clicked");
			logger.error("Failed to Click on Booking Engine Version");
			test.log(Status.FAIL,
					"Failed to Click on Booking Engine Version");
			Assert.assertFalse(false, "Booking Engine Version not Clicked");
		}

		if (propertySubdomain.isDisplayed()) 
		{
			propertySubdomain.click();
			propertySubdomain.sendKeys(SubDomain);
			System.out.println(" SubDomain is entered successfully");
			test.log(Status.INFO, " SubDomain is entered successfully");
			Assert.assertTrue(true,"SubDomain is entered successfully");
		} else {
			System.out.println("SubDomain TextBox not found");
			test.log(Status.FAIL, "SubDomain TextBox not found");
			Assert.assertFalse(false, "SubDomain TextBox not found");
		}

		if (Enter_Address.isDisplayed()) 
		{
			Enter_Address.click();
			test.log(Status.INFO, "Clicked on Brands Link");
			Enter_Address.sendKeys(EnterAddress1);
			System.out.println(" Address1 is entered successfully");
			logger.info("Address1 is entered successfully");
			test.log(Status.PASS,
					"Address1 is entered successfully" );
			Assert.assertTrue(true, " Address1 is entered successfully");
		} else {
			System.out.println("Address1 TextBox not found");
			logger.error("Failed to Enter Address1 in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Address1 in TextBox");
			Assert.assertFalse(false, "Address1 TextBox not found");
		}

		if (Enter_CityName.isDisplayed())
		{
			Enter_CityName.click();
			Enter_CityName.sendKeys(EnterCityName);
			System.out.println(" CityName is entered successfully");
			logger.info("CityName is entered successfully");
			test.log(Status.PASS,
					"CityName is entered successfully" );
			Assert.assertTrue(true,"CityName is entered successfully");
		} else {
			System.out.println("CityName TextBox not found");
			logger.error("Failed to Enter CityName in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter CityName in TextBox");
			Assert.assertFalse(false, "CityName is entered successfully");
		}		

		/* this should work but set it up correctly
		if (Enter_country.isDisplayed())
		{
			Enter_country.click();
			SeleniumRepoDropdown.selectDropDownText(Enter_country, EnterCountryName);
			//Select select = new Select(Enter_country);
			//select.selectByVisibleText(EnterCountryName);
			//Enter_country.sendKeys(EnterCountryName);
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" country is entered successfully");
			logger.info("country is entered successfully");
			test.log(Status.PASS,
					"country is entered successfully" );
			Assert.assertTrue(true,"country is entered successfully");
		} else {
			System.out.println("country TextBox not found");
			logger.error("Failed to Enter country in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter country in TextBox");
			Assert.assertFalse(false, "country TextBox not found");
		}		
*/
		if (Enter_Zip.isDisplayed()) 
		{
			Enter_Zip.click();
			Enter_Zip.clear();
			Enter_Zip.sendKeys(EnterZipCode);
			System.out.println(" ZipCode is entered successfully");
			logger.info("ZipCode is entered successfully");
			test.log(Status.PASS,
					"ZipCode is entered successfully" );

			Assert.assertTrue(true,"ZipCode is entered successfully");
		} else {
			System.out.println("ZipCode TextBox not found");
			logger.error("Failed to Enter ZipCode in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter ZipCode in TextBox");
			Assert.assertFalse(false, "ZipCode TextBox not found");
		}	

		if (Click_LatLong.isDisplayed()) 
		{
			Javascriptexecutor(Click_LatLong);

			Thread.sleep(3000);

			System.out.println(" Clicked On LatLong ");
			logger.info("Clicked On LatLong ");
			test.log(Status.PASS,
					"Clicked On LatLong " );
			Assert.assertTrue(true,"Clicked On LatLong");
		} else {
			System.out.println("Clicked On LatLong");
			logger.error("Failed to Click on LatLong");
			test.log(Status.FAIL,
					"Failed to Click on LatLong");
			Assert.assertFalse(false, "Clicked On LatLong");}	

		SeleniumRepo.waitForElementPresent(Click_RateCalendar);
		if (Click_RateCalendar.isDisplayed())
		{
			if (Click_RateCalendar.isSelected() == false)
				Click_RateCalendar.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" RateCalendar selected successfully");
			logger.info("RateCalendar selected successfully");
			test.log(Status.PASS,
					"RateCalendar selected successfully" );
			Assert.assertTrue(true,"RateCalendar selected successfully");

		} else {
			System.out.println("RateCalendar not selected");
			logger.error("Failed to Select RateCalendar");
			test.log(Status.FAIL,
					"Failed to Select RateCalendar");
			Assert.assertFalse(false, "RateCalendar not selected");
		}	

		if (Click_CallCenter.isDisplayed()) 
		{
			if (Click_CallCenter.isSelected() == false)
				Click_CallCenter.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" CallCenter selected successfully");
			logger.info("CallCenter selected successfully");
			test.log(Status.PASS,
					"CallCenter selected successfully" );
			Assert.assertTrue(true,"CallCenter selected successfully");
		} else {
			System.out.println("CallCenter not selected");
			logger.error("Failed to Select CallCenter");
			test.log(Status.FAIL,
					"Failed to Select CallCenter");
			Assert.assertFalse(false, "CallCenter not selected");
		}	


		if(Click_Save1.isDisplayed()) {
			Click_Save1.click();
			logger.info("Clicked on Save button");
			test.log(Status.PASS,
					"Clicked on Save button" );
		}else{
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");
		}



		/*if(Cancel_Button.isDisplayed()) 
		{
			Cancel_Button.click();
			logger.info("Clicked on Cancel button");
			test.log(Status.PASS,
					"Clicked on Cancel button" );
		}else{
			logger.error("Failed to Click on Cancel button");
			test.log(Status.FAIL,
					"Failed to Click on Cancel button");
		}*/

		/*
		if (Click_EnableAdsonConfirmation.isDisplayed()) {
			if (Click_EnableAdsonConfirmation.isSelected() == false)
				Click_EnableAdsonConfirmation.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" EnableAdsonConfirmation selected successfully");
			test.log(Status.INFO, " EnableAdsonConfirmation selected successfully");
			Assert.assertTrue(true,"EnableAdsonConfirmation selected successfully");
		} else {
			System.out.println("EnableAdsonConfirmation not selected");
		test.log(Status.FAIL, " EnableAdsonConfirmation not selected");
    	Assert.assertFalse(false, "EnableAdsonConfirmation not selected");}	
		SeleniumRepo.WaitForLoad(3000);
		Click_Save1.click();*/
	}	
	
}
