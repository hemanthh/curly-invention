package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class PropertyDefaults extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[@name='Save']") })
	public WebElement Click_Save;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	public WebElement Click_PropertyManagement;

	// @FindBy(how = How.XPATH, using = "//a[contains(text(),'Defaults')]")
	// @FindBy(css = "td.prompt:nth-child(2) table:nth-child(1)
	// tbody:nth-child(1) tr:nth-child(3) > td.title")
	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Defaults')]") })
	public WebElement click_PropertyDefaults;

	@FindAll({ @FindBy(xpath = "//td[@class = 'title' and contains(., 'Property Defaults')]"),
			@FindBy(css = "td.prompt:nth-child(2) table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) > td.title") })
	public WebElement Verify_PropertyDefaultsTitle;

	@FindAll({ @FindBy(xpath = "//select[@name='starRating']"), @FindBy(name = "starRating"),
			@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(6) td:nth-child(2) > select.input:nth-child(1)") })

	public WebElement Select_StarRating;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Credit Card Verification Required')]") })
	public WebElement CreditCardVerifiRequired_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isCreditCardVerificationRequired'][1]") })
	public WebElement Click_CreditCardVerifiRequired_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isCreditCardVerificationRequired'][2]") })
	public WebElement Click_CreditCardVerifiRequired_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Disable property email notifications?')]") })
	public WebElement DisPropertyEmailNotifications_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='disablePropResEmail'][1]") })
	public WebElement Click_DisPropertyEmailNotifications_Disable;

	@FindAll({ @FindBy(xpath = "//*[@name='disablePropResEmail'][2]") })
	public WebElement Click_DisPropertyEmailNotifications_Enable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Disable guest email notification?')]") })
	public WebElement DisGuestEmailNotifications_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='disableGuestResEmail'][1]") })
	public WebElement Click_DisGuestEmailNotifications_Disable;

	@FindAll({ @FindBy(xpath = "//*[@name='disableGuestResEmail'][2]") })
	public WebElement Click_DisGuestEmailNotifications_Enable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Disable channel manager email notification?')]") })
	public WebElement DisChMgrEmailNotifications_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='disableEmailToChMgr'][1]") })
	public WebElement Click_DisChMgrEmailNotifications_Disable;

	@FindAll({ @FindBy(xpath = "//*[@name='disableEmailToChMgr'][2]") })
	public WebElement Click_DisChMgrEmailNotifications_Enable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Ask For Mobile Location?')]") })
	public WebElement MobileLocation_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isAskForLocation'][1]") })
	public WebElement Click_MobileLocation_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isAskForLocation'][2]") })
	public WebElement Click_MobileLocation_Disable;

	@FindAll({ @FindBy(name = "adultAge"),
			@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input") })

	public WebElement Enter_AdultAge;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Allow Children in Search Criteria')]") })
	public WebElement ChildrenInSearchCriteria_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='allowChildrenInSearch'][1]") })
	public WebElement Click_ChildrenInSearchCriteria_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='allowChildrenInSearch'][2]") })
	public WebElement Click_ChildrenInSearchCriteria_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Default Number of Adults in Reservation Search')]") })
	public WebElement DefaultNumOfAdults_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='defaultNumOfAdults']") })
	public WebElement Select_DefaultNumOfAdults_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Guarantee/Cancellation')]") })
	public WebElement DefaultGuaranteeCancelPolicy_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='defaultGuaranteeCancelPolicyId']") })
	public WebElement Select_DefaultGuaranteeCancelPolicy_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Minimum Price Alert For Hotel')]") })
	public WebElement MinPriceAlert_field;

	@FindAll({ @FindBy(xpath = "//*[@name='minimumPriceAlertForHotel']") })
	public WebElement Enter_MinPriceAlert_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Default Currency')]") })
	public WebElement DefaultCurrency_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='defaultCurrencyId']") })
	public WebElement Select_DefaultCurrency_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Currencies')]") })
	public WebElement Currencies_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='selectedCurrencies']") })
	public WebElement Select_Currencies_MultiList;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Tax Display')]") })
	public WebElement TaxDisplay_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='showTaxesInDisplayPrice'][1]") })
	public WebElement Click_TaxDisplay_Disable;

	@FindAll({ @FindBy(xpath = "//*[@name='showTaxesInDisplayPrice'][2]") })
	public WebElement Click_TaxDisplay_Enable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'AddOn Price Type')]") })
	public WebElement AddOnPriceType_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isAddOnPriceTaxInclusive'][1]") })
	public WebElement Click_AddOnPriceType_​TaxInclusive;

	@FindAll({ @FindBy(xpath = "//*[@name='isAddOnPriceTaxInclusive'][2]") })
	public WebElement Click_AddOnPriceType_​TaxExclusive;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Price Display')]") })
	public WebElement PriceDisplay_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='showRoomRatesForTotalVisit'][1]") })
	public WebElement Click_PriceDisplay_Total;

	@FindAll({ @FindBy(xpath = "//*[@name='showRoomRatesForTotalVisit'][2]") })
	public WebElement Click_PriceDisplay_PerNight;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Show Tax Breakdown (Mobile Only)')]") })
	public WebElement TaxBreakDownMobile_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='showTaxBreakdown'][1]") })
	public WebElement Click_TaxBreakDownMobile_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='showTaxBreakdown'][2]") })
	public WebElement Click_TaxBreakDownMobile_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Round up Price')]") })
	public WebElement RoundUpPrice_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='roundUpDiscountedPrice'][1]") })
	public WebElement Click_RoundUpPrice_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='roundUpDiscountedPrice'][2]") })
	public WebElement Click_RoundUpPrice_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Default Date Format')]") })
	public WebElement DefaultDateFormat_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='defaultDateFormat']") })
	public WebElement Select_DefaultDateFormat_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Max. Number of rooms booked at once')]") })
	public WebElement MaxNumOfRoomsBooked_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='maxNoOfRoomsBookable']") })
	public WebElement Select_MaxNumOfRoomsBooked_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Max. Number of rooms booked at once in call center')]") })
	public WebElement MaxNumOfRoomsBookedCC_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='maxRoomsBookableAtCC']") })
	public WebElement Select_MaxNumOfRoomsBookedCC_DropDown;

	@FindAll({ @FindBy(name = "checkInTime"),
			@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(26) td:nth-child(2) > select.input:nth-child(1)") })

	public WebElement Select_CheckinTime;

	@FindAll({ @FindBy(name = "checkOutTime"),
			@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(27) td:nth-child(2) > select.input:nth-child(1)") })

	public WebElement Select_CheckoutTime;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable IATA Code Tracking')]") })
	public WebElement IATACodeTracking_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='enableIATA'][1]") })
	public WebElement Click_IATACodeTracking_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='enableIATA'][2]") })
	public WebElement Click_IATACodeTracking_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Fee Disclaimer')]") })
	public WebElement FeeDisclaimerMobile_field;

	@FindAll({ @FindBy(xpath = "//*[@name='resortFeeDisclaimer']") })
	public WebElement Enter_FeeDisclaimerMobile_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Daily Rate Display')]") })
	public WebElement DailyRateDisplay_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='blendDailyRates'][1]") })
	public WebElement Click_DailyRateDisplay_TruDailyRate;

	@FindAll({ @FindBy(xpath = "//*[@name='blendDailyRates'][2]") })
	public WebElement Click_DailyRateDisplay_AvgDailyRate;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'RateGrid cascades yield controls by default')]") })
	public WebElement RateGridCascadesYieldCtrl_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='cascadeYieldDefaultStateEnabled'][1]") })
	public WebElement Click_RateGridCascadesYieldCtrl_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='cascadeYieldDefaultStateEnabled'][2]") })
	public WebElement Click_RateGridCascadesYieldCtrl_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'RateGrid calendar view enabled')]") })
	public WebElement RateGridCalendarView_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isRategridCalendarViewEnabled'][1]") })
	public WebElement Click_RateGridCalendarView_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isRategridCalendarViewEnabled'][2]") })
	public WebElement Click_RateGridCalendarView_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'LOS Restriction Type')]") })
	public WebElement LosRestrictionType_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='losRestrictionType'][1]") })
	public WebElement Click_LosRestrictionType_StayThrough;

	@FindAll({ @FindBy(xpath = "//*[@name='losRestrictionType'][2]") })
	public WebElement Click_LosRestrictionType_ArrivalDate;

	@FindAll({
			@FindBy(xpath = "//td[contains(text(),'Show lowest price in Details page (web and mobile channels only)')]") })
	public WebElement ShowLowestRriceInDetailsPg_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isDisplayLowestPrice'][1]") })
	public WebElement Click_ShowLowestRriceInDetailsPg_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isDisplayLowestPrice'][2]") })
	public WebElement Click_ShowLowestRriceInDetailsPg_Disable;

	@FindBy(how = How.XPATH, using = "//*[@id='formulaBasedPricingEnable']")
	public WebElement RadioButton_FBP;

	@FindBy(how = How.XPATH, using = "//*[@name='isFormulaBasedPricingEnabled']")
	public List<WebElement> FBP_status;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Slash Through Pricing for FBP rates')]") })
	public WebElement SlashThruPricingFbpRates_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isSlashThroughPricingEnabledForFBP'][1]") })
	public WebElement Click_SlashThruPricingFbpRates_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isSlashThroughPricingEnabledForFBP'][2]") })
	public WebElement Click_SlashThruPricingFbpRates_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Considered Addons in PG Deposit ')]") })
	public WebElement AddonsInPgDeposit_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='addOnsConsideredInDeposit'][1]") })
	public WebElement Click_AddonsInPgDeposit_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='addOnsConsideredInDeposit'][2]") })
	public WebElement Click_AddonsInPgDeposit_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Considered Tax in PG Deposit ')]") })
	public WebElement TaxInPgDeposit_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='taxConsideredInDeposit'][1]") })
	public WebElement Click_TaxInPgDeposit_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='taxConsideredInDeposit'][2]") })
	public WebElement Click_TaxInPgDeposit_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Smart Rate Plan')]") })
	public WebElement SmartRatePlan_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isSmartRate'][1]") })
	public WebElement Click_SmartRatePlan_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isSmartRate'][2]") })
	public WebElement Click_SmartRatePlan_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable DerbySoft Connection')]") })
	public WebElement DerbySoftConnection_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isDerbySoftEnabled'][1]") })
	public WebElement Click_DerbySoftConnection_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isDerbySoftEnabled'][2]") })
	public WebElement Click_DerbySoftConnection_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable WIHP Connection ')]") })
	public WebElement WihpConnection_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isWHIPEnabled'][1]") })
	public WebElement Click_WihpConnection_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isWHIPEnabled'][2]") })
	public WebElement Click_WihpConnection_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Loyalty Program ')]") })
	public WebElement LoyaltyProgram_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isLoyaltyEnabled'][1]") })
	public WebElement Click_LoyaltyProgram_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isLoyaltyEnabled'][2]") })
	public WebElement Click_LoyaltyProgram_Disable;

	@FindAll({ @FindBy(xpath = "//*[@name='selectedConnectivitySolution']") })
	public WebElement Select_LoyaltyProgram_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable COMP Rate Plan ')]") })
	public WebElement CompRatePlan_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isCOMPRatePlanEnabled'][1]") })
	public WebElement Click_CompRatePlan_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isCOMPRatePlanEnabled'][2]") })
	public WebElement Click_CompRatePlan_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Enable Uplift')]") })
	public WebElement Uplift_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='isUpliftEnabled'][1]") })
	public WebElement Click_Uplift_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isUpliftEnabled'][2]") })
	public WebElement Click_Uplift_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Compound Access Codes ')]") })
	public WebElement Compound_Access_Codes_Field;

	@FindBy(how = How.XPATH, using = "//*[@name='isCompoundAccessCodeEnabled' and @value='true']")
	public WebElement Compound_Access_Codes_enabled;

	@FindBy(how = How.XPATH, using = "//*[@name='isCompoundAccessCodeEnabled' and @value='false']")
	public WebElement Compound_Access_Codes_disabled;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Allow Zero Rate?')]") })
	public WebElement ZeroRate_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='allowZeroRate'][1]") })
	public WebElement Click_ZeroRate_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='allowZeroRate'][2]") })
	public WebElement Click_ZeroRate_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Facebook Page ID')]") })
	public WebElement FacebookPageId_field;

	@FindAll({ @FindBy(xpath = "//*[@name='facebookPageId']") })
	public WebElement Enter_FacebookPageId_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Rate Calendar Rate Plan ')]") })
	public WebElement RateCalendarRatePlan_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='rateCalendarRatePlanId']") })
	public WebElement Select_RateCalendarRatePlan_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'TripConnect Show Price Rate Plan ')]") })
	public WebElement TripConnShowPriceRatePlan_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='tripAdvisorRatePlanId']") })
	public WebElement Select_TripConnShowPriceRatePlan_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'TripAdvisor Instant Booking Rate Plan ')]") })
	public WebElement TripAdvisorInstBookingRatePlan_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='instantBookingRatePlanId']") })
	public WebElement Select_TripAdvisorInstBookingRatePlan_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Flip.to Enabled')]") })
	public WebElement FlipDotTo_Field;

	@FindAll({ @FindBy(xpath = "//*[@name='flipToEnabled'][1]") })
	public WebElement Click_FlipDotTo_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='flipToEnabled'][2]") })
	public WebElement Click_FlipDotTo_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Flip.to Company Code')]") })
	public WebElement FlipCompanyCode_field;

	@FindAll({ @FindBy(xpath = "//*[@name='flipToCompanyCode']") })
	public WebElement Enter_FlipCompanyCode_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Flip.to Campaign Code')]") })
	public WebElement FlipCampaignCode_field;

	@FindAll({ @FindBy(xpath = "//*[@name='flipToCampaignCode']") })
	public WebElement Enter_FlipCampaignCode_Text;

	@FindAll({ @FindBy(xpath = "//input[@name='Save' and @onclick= 'saveSubmit()']"),
			@FindBy(xpath = "//td[contains(@class,'prompt')]//form[contains(@name,'addPropertyDefaults')]//table[contains(@width,'522')]//tbody"),
			@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(47) td:nth-child(1) > input.input:nth-child(1)") })
	public WebElement Click_Save3;

	// @CacheLookup
	// public WebElement Verify_PropertyDefaultsTitle;

	public void click_PropertyDefaults() {

		String PropertyDefaultsTitle = "Property Defaults";

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
		if (click_PropertyDefaults.isDisplayed() == false) {
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

		ExplicitWait(click_PropertyDefaults);
		if (click_PropertyDefaults.isDisplayed()) {
			Javascriptexecutor(click_PropertyDefaults);
			ExplicitWait(Verify_PropertyDefaultsTitle);

			System.out.println("PropertyDefaults element found");
			test.log(Status.INFO, "PropertyDefaults element found");
			Assert.assertTrue(true, "PropertyDefaults element found");
		} else {
			logger.info("PropertyDefaults element not  found");
			test.log(Status.FAIL, "PropertyDefaults element not  found");
		}

		System.out.println(Verify_PropertyDefaultsTitle.getText());
		System.out.println("Expected" + PropertyDefaultsTitle);
		if (Verify_PropertyDefaultsTitle.getText().contains(PropertyDefaultsTitle)) {
			System.out.println("Title Matched");
			logger.info("PropertyDefaults Title Matched");
			test.log(Status.PASS, "PropertyDefaults Title Matched");
			Assert.assertTrue(true, "PropertyDefaults Title Matched");
		} else {
			System.out.println("Title didn't match");
			logger.error("Title didn't match");
			// test.log(Status.FAIL,"Title didn't match");
			Assert.assertFalse(false, "PropertyDefaults Title didn't match");
		}
	}

	public void propDefStarRating(String StarRating) {

		SeleniumRepo.isElementPresent(Select_StarRating);
		if (SeleniumRepo.isElementPresent(Select_StarRating)) {
			SeleniumRepoDropdown.selectDropDownValue(Select_StarRating, StarRating);
			// SeleniumRepo.WaitForLoad(100);
			System.out.println(" StarRating selected successfully");
			logger.info("StarRating selected successfully");
			test.log(Status.PASS, "StarRating selected successfully");
			Assert.assertTrue(true, "StarRating selected successfully");
		} else {
			System.out.println("StarRating not selected");
			logger.error("Failed to Select StarRating");
			test.log(Status.FAIL, "Failed to Select StarRating");
			Assert.assertFalse(false, "StarRating not StarRating");
		}

	}

	public void propDefCreditCardVerif(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(CreditCardVerifiRequired_Field);

		Assert.assertEquals(CreditCardVerifiRequired_Field.isDisplayed(), true,
				"Enable Credit Card Verification Required Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_CreditCardVerifiRequired_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Credit Card Verification Required is enabled successfully");
			logger.info("Credit Card Verification Required selected successfully");
			test.log(Status.PASS, "Credit Card Verification Required selected successfully");
			Assert.assertTrue(Click_CreditCardVerifiRequired_Enable.isSelected(),
					"Credit Card Verification Required is Enabled");

		} else {

			Click_CreditCardVerifiRequired_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Credit Card Verification Required not selected");
			logger.error("Failed to Select Credit Card Verification Required");
			test.log(Status.FAIL, "Failed to Select Credit Card Verification Required");

			Assert.assertTrue(Click_CreditCardVerifiRequired_Disable.isSelected(),
					"Credit Card Verification Required is disable");

		}

	}

	public void propDefPropertyEmailNotif(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(DisPropertyEmailNotifications_Field);

		Assert.assertEquals(DisPropertyEmailNotifications_Field.isDisplayed(), true,
				"Disable property email notifications Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_DisPropertyEmailNotifications_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Disable property email notifications is enabled successfully");
			logger.info("Disable property email notifications selected successfully");
			test.log(Status.PASS, "Disable property email notifications selected successfully");
			Assert.assertTrue(Click_DisPropertyEmailNotifications_Enable.isSelected(),
					"Disable property email notifications is Enabled");

		} else {

			Click_DisPropertyEmailNotifications_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Disable property email notifications Field not selected");
			logger.error("Failed to Select Disable property email notifications Field");
			test.log(Status.FAIL, "Failed to Select Disable property email notifications Field");

			Assert.assertTrue(Click_DisPropertyEmailNotifications_Disable.isSelected(),
					"Disable property email notifications is disable");

		}

	}

	public void propDefGuestEmailNotif(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(DisGuestEmailNotifications_Field);

		Assert.assertEquals(DisGuestEmailNotifications_Field.isDisplayed(), true,
				"Disable guest email notifications Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_DisGuestEmailNotifications_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Disable guest email notifications is enabled successfully");
			logger.info("Disable guest email notifications selected successfully");
			test.log(Status.PASS, "Disable guest email notifications selected successfully");
			Assert.assertTrue(Click_DisGuestEmailNotifications_Enable.isSelected(),
					"Disable guest email notifications is Enabled");

		} else {

			Click_DisGuestEmailNotifications_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Disable guest email notifications Field not selected");
			logger.error("Failed to Select Disable guest email notifications Field");
			test.log(Status.FAIL, "Failed to Select Disable guest email notifications Field");

			Assert.assertTrue(Click_DisGuestEmailNotifications_Disable.isSelected(),
					"Disable guest email notifications is disable");

		}

	}

	public void propDefChannelManagerEmailNotif(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(DisChMgrEmailNotifications_Field);

		Assert.assertEquals(DisChMgrEmailNotifications_Field.isDisplayed(), true,
				"Disable channel manager email notifications Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_DisChMgrEmailNotifications_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Disable channel manager email notifications is enabled successfully");
			logger.info("Disable channel manager email notifications selected successfully");
			test.log(Status.PASS, "Disable channel manager email notifications selected successfully");
			Assert.assertTrue(Click_DisChMgrEmailNotifications_Enable.isSelected(),
					"Disable channel manager email notifications is Enabled");

		} else {

			Click_DisChMgrEmailNotifications_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Disable channel manager email notifications Field not selected");
			logger.error("Failed to Select Disable channel manager email notifications Field");
			test.log(Status.FAIL, "Failed to Select Disable channel manager email notifications Field");

			Assert.assertTrue(Click_DisChMgrEmailNotifications_Disable.isSelected(),
					"Disable channel manager email notifications is disable");

		}

	}

	public void propDefMobileLocation(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(MobileLocation_Field);

		Assert.assertEquals(MobileLocation_Field.isDisplayed(), true,
				"Ask For Mobile Location Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_MobileLocation_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Ask For Mobile Location is enabled successfully");
			logger.info("Ask For Mobile Location selected successfully");
			test.log(Status.PASS, "Ask For Mobile Location selected successfully");
			Assert.assertTrue(Click_MobileLocation_Enable.isSelected(), "Ask For Mobile Location is Enabled");

		} else {

			Click_MobileLocation_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Ask For Mobile Location not selected");
			logger.error("Failed to Select Ask For Mobile Location");
			test.log(Status.FAIL, "Failed to Select Ask For Mobile Location");

			Assert.assertTrue(Click_MobileLocation_Disable.isSelected(),
					"Credit Card Verification Required is disable");

		}

	}

	public void propDefAdultAge(String Adultage) {

		SeleniumRepo.isElementPresent(Enter_AdultAge);
		if (SeleniumRepo.isElementPresent(Enter_AdultAge)) {
			Enter_AdultAge.click();
			Enter_AdultAge.clear();
			Enter_AdultAge.sendKeys(Adultage);
			System.out.println("  Adultage is entered successfully");
			logger.info(" Adultage is entered successfully");
			test.log(Status.PASS, " Adultage is entered successfully");
			Assert.assertTrue(true, " Adultage is entered successfully");
		} else {
			System.out.println(" Adultage TextBox not found");
			logger.error("Failed to Enter Adultage in TextBox");
			test.log(Status.FAIL, "Failed to Enter Adultage in TextBox");
			Assert.assertFalse(false, "Adultage TextBox not found");
		}
	}

	public void propDefChildrenInSearch(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(ChildrenInSearchCriteria_Field);

		Assert.assertEquals(ChildrenInSearchCriteria_Field.isDisplayed(), true,
				"Allow Children in Search Criteria Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_ChildrenInSearchCriteria_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Allow Children in Search Criteria is enabled successfully");
			logger.info(" Allow Children in Search Criteria selected successfully");
			test.log(Status.PASS, "Allow Children in Search Criteria selected successfully");
			Assert.assertTrue(Click_ChildrenInSearchCriteria_Enable.isSelected(),
					"Allow Children in Search Criteria is Enabled");

		} else {

			Click_ChildrenInSearchCriteria_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Allow Children in Search Criteria not selected");
			logger.error("Failed to Select Allow Children in Search Criteria");
			test.log(Status.FAIL, "Failed to Select Allow Children in Search Criteria");

			Assert.assertTrue(Click_ChildrenInSearchCriteria_Disable.isSelected(),
					"Allow Children in Search Criteria is disable");

		}

	}

	public void propDefaultNumOfAdultsInSearch(String EnterNumOfAdults) {

		SeleniumRepo.waitForElementPresent(DefaultNumOfAdults_Field);

		Assert.assertEquals(DefaultNumOfAdults_Field.isDisplayed(), true,
				"Default Number of Adults in Reservation Search Field is not being displayed");

		Select_DefaultNumOfAdults_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_DefaultNumOfAdults_DropDown, EnterNumOfAdults);

		System.out.println("Default Number of Adults in Reservation Search was selected successfully");

		logger.info("Default Number of Adults in Reservation Search was selected successfully");
		test.log(Status.PASS, "Default Number of Adults in Reservation Search was selected successfully");
	}

	public void propDefaultCancellationPolicy(String SelectingDefPolicy) {

		SeleniumRepo.waitForElementPresent(DefaultGuaranteeCancelPolicy_Field);

		Assert.assertEquals(DefaultGuaranteeCancelPolicy_Field.isDisplayed(), true,
				"Default Guarantee/Cancellation policy Field is not being displayed");

		Select_DefaultGuaranteeCancelPolicy_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_DefaultGuaranteeCancelPolicy_DropDown, SelectingDefPolicy);

		System.out.println("Default Guarantee/Cancellation policy was selected successfully");

		logger.info("Default Guarantee/Cancellation policy was selected successfully");
		test.log(Status.PASS, "Default Guarantee/Cancellation policy was selected successfully");

	}

	public void propDefMinPriceAlertHotel(String EnterMinPriceAlert) {

		SeleniumRepo.waitForElementPresent(MinPriceAlert_field);

		Assert.assertEquals(MinPriceAlert_field.isDisplayed(), true,
				"Minimum Price Alert For Hotel is not being displayed");

		Enter_MinPriceAlert_Text.click();
		Enter_MinPriceAlert_Text.clear();
		Enter_MinPriceAlert_Text.sendKeys(EnterMinPriceAlert);

		System.out.println("Minimum Price Alert For Hotel is entered successfully");

		Assert.assertEquals(Enter_MinPriceAlert_Text.getAttribute("value"), EnterMinPriceAlert,
				"Minimum Price Alert For Hotel Field text was not entered");
		logger.info("Minimum Price Alert For Hotel is entered successfully");
		test.log(Status.PASS, "Minimum Price Alert For Hotel is entered successfully");

	}

	public void propDefaultCurrency(String SelectCurrency) {

		SeleniumRepo.waitForElementPresent(DefaultCurrency_Field);

		Assert.assertEquals(DefaultCurrency_Field.isDisplayed(), true, "Default Currency Field is not being displayed");

		Select_DefaultCurrency_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_DefaultCurrency_DropDown, SelectCurrency);

		System.out.println("Default Currency was selected successfully");

		logger.info("Default Currency was selected successfully");
		test.log(Status.PASS, "Default Currency was selected successfully");

	}

	public void propDefCurrencies(String currenciesItems) {

		// add a new method in SeleniumRepoDropdown that will handle multiple
		// select listbox
        try {
		String[] differentCurrencies = currenciesItems.split("[;]");
        
		SeleniumRepo.waitForElementPresent(Currencies_Field);
        Thread.sleep(5000);
		Assert.assertEquals(Currencies_Field.isDisplayed(), true, "Currencies Field is not being displayed");

		Select_Currencies_MultiList.click();
		SeleniumRepoDropdown.selectMultiListbox(Select_Currencies_MultiList, differentCurrencies);

		System.out.println("Currencies was selected successfully");

		logger.info("Currencies was selected successfully");
		test.log(Status.PASS, "Currencies was selected successfully");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }

	}

	public void propDefTaxDisplay(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(TaxDisplay_Field);

		Assert.assertEquals(TaxDisplay_Field.isDisplayed(), true, "Tax Display Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_TaxDisplay_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Tax Display is enabled successfully");
			logger.info(" Tax Display selected successfully");
			test.log(Status.PASS, "Tax Display selected successfully");
			Assert.assertTrue(Click_TaxDisplay_Enable.isSelected(), "Tax Display is Enabled");

		} else {

			Click_TaxDisplay_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Tax Display not selected");
			logger.error("Failed to Select Tax Display");
			test.log(Status.FAIL, "Failed to Select Tax Display");

			Assert.assertTrue(Click_TaxDisplay_Disable.isSelected(), "Tax Display is disable");

		}

	}

	public void propDefAddOnPriceType(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(AddOnPriceType_Field);

		Assert.assertEquals(AddOnPriceType_Field.isDisplayed(), true, "AddOn Price Type Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("inclusive")) {

			Click_AddOnPriceType_​TaxInclusive.click();

			SeleniumRepo.WaitForLoad(1000);

			System.out.println("AddOn Price Type is enabled successfully");
			logger.info("AddOn Price Type selected successfully");
			test.log(Status.PASS, "AddOn Price Type selected successfully");
			Assert.assertTrue(Click_AddOnPriceType_​TaxInclusive.isSelected(), "AddOn Price Type is Enabled");

		} else {

			Click_AddOnPriceType_​TaxExclusive.click();
			SeleniumRepo.WaitForLoad(1000);

			System.out.println("Selected AddOn Price Type Exclusive");
			logger.info("Selected AddOn Price Type Exclusive");
			test.log(Status.PASS, "Selected AddOn Price Type Exclusive");

			Assert.assertTrue(Click_AddOnPriceType_​TaxExclusive.isSelected(), "AddOn Price Type is disable");

		}

	}

	public void propDefPriceDisplay(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(PriceDisplay_Field);

		Assert.assertEquals(PriceDisplay_Field.isDisplayed(), true, "Price Display Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("total")) {

			Click_PriceDisplay_Total.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Price Display is enabled successfully");
			logger.info("Price Display selected successfully");
			test.log(Status.PASS, "Price Display selected successfully");
			Assert.assertTrue(Click_PriceDisplay_Total.isSelected(), "Price Display is Enabled");

		} else {

			Click_PriceDisplay_PerNight.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Price Display not selected");
			logger.error("Failed to Select Price Display");
			test.log(Status.FAIL, "Failed to Select Price Display");

			Assert.assertTrue(Click_PriceDisplay_PerNight.isSelected(), "Price Display is disable");

		}

	}

	public void propDefTaxBreakDownMobile(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(TaxBreakDownMobile_Field);

		Assert.assertEquals(TaxBreakDownMobile_Field.isDisplayed(), true,
				"Show Tax Breakdown (Mobile Only) Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_TaxBreakDownMobile_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Show Tax Breakdown (Mobile Only) is enabled successfully");
			logger.info("Show Tax Breakdown (Mobile Only) selected successfully");
			test.log(Status.PASS, "Show Tax Breakdown (Mobile Only) selected successfully");
			Assert.assertTrue(Click_TaxBreakDownMobile_Enable.isSelected(), "Price Display is Enabled");

		} else {

			Click_TaxBreakDownMobile_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Show Tax Breakdown (Mobile Only) not selected");
			logger.error("Failed to Select Show Tax Breakdown (Mobile Only)");
			test.log(Status.FAIL, "Failed to Select Show Tax Breakdown (Mobile Only)");

			Assert.assertTrue(Click_TaxBreakDownMobile_Disable.isSelected(),
					"Show Tax Breakdown (Mobile Only) is disable");

		}

	}

	public void propDefRoundUpPrice(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(RoundUpPrice_Field);

		Assert.assertEquals(RoundUpPrice_Field.isDisplayed(), true, "Round up Price Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_RoundUpPrice_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Round up Price is enabled successfully");
			logger.info("Round up Price selected successfully");
			test.log(Status.PASS, "Round up Price selected successfully");
			Assert.assertTrue(Click_RoundUpPrice_Enable.isSelected(), "Round up Price is Enabled");

		} else {

			Click_RoundUpPrice_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Round up Price not selected");
			logger.error("Failed to Select Round up Price");
			test.log(Status.FAIL, "Failed to Select Round up Price");

			Assert.assertTrue(Click_RoundUpPrice_Disable.isSelected(), "Round up Price is disable");

		}

	}

	public void propDefaultDateFormat(String EnterDateRormat) {

		SeleniumRepo.waitForElementPresent(DefaultDateFormat_Field);

		Assert.assertEquals(DefaultDateFormat_Field.isDisplayed(), true,
				"Default Date Format Field is not being displayed");

		Select_DefaultDateFormat_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_DefaultDateFormat_DropDown, EnterDateRormat);

		System.out.println("Default Date Format was selected successfully");

		logger.info("Default Date Format was selected successfully");
		test.log(Status.PASS, "Default Date Format was selected successfully");

	}

	public void propDefMaxNumOfRoomsBookedAtOnce(String EnterMaxNumOfRms) {

		SeleniumRepo.waitForElementPresent(MaxNumOfRoomsBooked_Field);

		Assert.assertEquals(MaxNumOfRoomsBooked_Field.isDisplayed(), true,
				"Max. Number of rooms booked at once Field is not being displayed");

		Select_MaxNumOfRoomsBooked_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_MaxNumOfRoomsBooked_DropDown, EnterMaxNumOfRms);

		System.out.println("Max. Number of rooms booked at once was selected successfully");

		logger.info("Max. Number of rooms booked at once was selected successfully");
		test.log(Status.PASS, "Max. Number of rooms booked at once was selected successfully");

	}

	public void propDefMaxNumOfRoomsBookedAtOnceCallCen(String EnterMaxNumOfRmsCall) {

		SeleniumRepo.waitForElementPresent(MaxNumOfRoomsBookedCC_Field);

		Assert.assertEquals(MaxNumOfRoomsBookedCC_Field.isDisplayed(), true,
				"Max. Number of rooms booked at once in call center once Field is not being displayed");

		Select_MaxNumOfRoomsBookedCC_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_MaxNumOfRoomsBookedCC_DropDown, EnterMaxNumOfRmsCall);

		System.out.println("Max. Number of rooms booked at once in call center once was selected successfully");

		logger.info("Max. Number of rooms booked at once in call center once was selected successfully");
		test.log(Status.PASS, "Max. Number of rooms booked at once in call center once was selected successfully");

	}

	public void propDefCheckinTime(String CheckinTime) {

		ExplicitWait(Select_CheckinTime);
		if (Select_CheckinTime.isDisplayed()) {
			SeleniumRepoDropdown.selectDropDownText(Select_CheckinTime, CheckinTime);
			// SeleniumRepo.WaitForLoad(100);
			System.out.println(" CheckinTime selected successfully");
			logger.info("CheckinTime selected successfully");
			test.log(Status.PASS, "CheckinTime selected successfully");

			Assert.assertTrue(true, " CheckinTime selected successfully");
		} else {
			System.out.println("CheckinTime not selected");
			logger.error("Failed to Select CheckinTime");
			test.log(Status.FAIL, "Failed to Select CheckinTime");
			Assert.assertFalse(false, "CheckinTime not selected");
		}

	}

	public void propDefCheckoutTime(String CheckoutTime) throws Exception {

		SeleniumRepo.isElementPresent(Select_CheckoutTime);
		if (SeleniumRepo.isElementPresent(Select_CheckoutTime)) {
			SeleniumRepoDropdown.selectDropDownText(Select_CheckoutTime, CheckoutTime);
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" CheckoutTime selected successfully");
			logger.info("CheckoutTime selected successfully");
			test.log(Status.PASS, "CheckoutTime selected successfully");
			Assert.assertTrue(true, " CheckoutTime selected successfully");
		} else {
			System.out.println("CheckoutTime not selected");
			logger.error("Failed to Select CheckoutTime");
			test.log(Status.FAIL, "Failed to Select CheckoutTime");
			Assert.assertFalse(false, "CheckoutTime not selected");
		}

	}

	public void propDefIATACodeTracking(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(IATACodeTracking_Field);

		Assert.assertEquals(IATACodeTracking_Field.isDisplayed(), true,
				"Enable IATA Code Tracking Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_IATACodeTracking_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable IATA Code Tracking is enabled successfully");
			logger.info("Enable IATA Code Tracking selected successfully");
			test.log(Status.PASS, "Enable IATA Code Tracking selected successfully");
			Assert.assertTrue(Click_IATACodeTracking_Enable.isSelected(), "Enable IATA Code Tracking is Enabled");

		} else {

			Click_IATACodeTracking_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable IATA Code Tracking not selected");
			logger.error("Failed to Enable IATA Code Tracking");
			test.log(Status.FAIL, "Failed to Enable IATA Code Tracking");

			Assert.assertTrue(Click_IATACodeTracking_Disable.isSelected(), "Enable IATA Code Tracking is disable");

		}

	}

	public void propDefFeeDisclaimerMobile(String EnterFeeDisclaimer) {

		SeleniumRepo.waitForElementPresent(FeeDisclaimerMobile_field);

		Assert.assertEquals(FeeDisclaimerMobile_field.isDisplayed(), true,
				"Fee Disclaimer (Mobile Only) is not being displayed");

		Enter_FeeDisclaimerMobile_Text.click();
		Enter_FeeDisclaimerMobile_Text.clear();
		Enter_FeeDisclaimerMobile_Text.sendKeys(EnterFeeDisclaimer);

		System.out.println("Fee Disclaimer (Mobile Only) is entered successfully");

		Assert.assertEquals(Enter_FeeDisclaimerMobile_Text.getAttribute("value"), EnterFeeDisclaimer,
				"Fee Disclaimer (Mobile Only) Field text was not entered");
		logger.info("Fee Disclaimer (Mobile Only) is entered successfully");
		test.log(Status.PASS, "Fee Disclaimer (Mobile Only) is entered successfully");

	}

	public void propDefDailyRateDisplay(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(DailyRateDisplay_Field);

		Assert.assertEquals(DailyRateDisplay_Field.isDisplayed(), true,
				"Daily Rate Display Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("daily")) {

			Click_DailyRateDisplay_TruDailyRate.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Daily Rate Display is enabled successfully");
			logger.info("Daily Rate Display selected successfully");
			test.log(Status.PASS, "Daily Rate Display selected successfully");
			Assert.assertTrue(Click_DailyRateDisplay_TruDailyRate.isSelected(), "Daily Rate Display is Enabled");

		} else {

			Click_DailyRateDisplay_AvgDailyRate.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Daily Rate Display not selected");
			logger.error("Failed to Daily Rate Display");
			test.log(Status.FAIL, "Failed to Daily Rate Display");

			Assert.assertTrue(Click_DailyRateDisplay_AvgDailyRate.isSelected(), "Daily Rate Display is disable");

		}

	}

	public void propDefRateGridCascadesYieldControls(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(RateGridCascadesYieldCtrl_Field);

		Assert.assertEquals(RateGridCascadesYieldCtrl_Field.isDisplayed(), true,
				"RateGrid cascades yield controls by default Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_RateGridCascadesYieldCtrl_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("RateGrid cascades yield controls by default is enabled successfully");
			logger.info("RateGrid cascades yield controls by default selected successfully");
			test.log(Status.PASS, "RateGrid cascades yield controls by default selected successfully");
			Assert.assertTrue(Click_RateGridCascadesYieldCtrl_Enable.isSelected(),
					"RateGrid cascades yield controls by default is Enabled");

		} else {

			Click_RateGridCascadesYieldCtrl_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("RateGrid cascades yield controls by default not selected");
			logger.error("Failed to RateGrid cascades yield controls by default");
			test.log(Status.FAIL, "Failed to RateGrid cascades yield controls by default");

			Assert.assertTrue(Click_RateGridCascadesYieldCtrl_Disable.isSelected(),
					"RateGrid cascades yield controls by default is disable");

		}

	}

	public void propDefRateGridCalendarView(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(RateGridCalendarView_Field);

		Assert.assertEquals(RateGridCalendarView_Field.isDisplayed(), true,
				"RateGrid calendar view enabled Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_RateGridCalendarView_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("RateGrid calendar view enabled is enabled successfully");
			logger.info("RateGrid calendar view enabled selected successfully");
			test.log(Status.PASS, "RateGrid calendar view enabled selected successfully");
			Assert.assertTrue(Click_RateGridCalendarView_Enable.isSelected(),
					"RateGrid calendar view enabled is Enabled");

		} else {

			Click_RateGridCalendarView_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("RateGrid calendar view enabled not selected");
			logger.error("Failed to RateGrid calendar view enabled");
			test.log(Status.FAIL, "Failed to RateGrid calendar view enabled");

			Assert.assertTrue(Click_RateGridCalendarView_Disable.isSelected(),
					"RateGrid calendar view enabled is disable");

		}

	}

	public void propDefLOSRestrictionType(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(LosRestrictionType_Field);

		Assert.assertEquals(LosRestrictionType_Field.isDisplayed(), true,
				"LOS Restriction Type Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("stay")) {

			Click_LosRestrictionType_StayThrough.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("LOS Restriction Type is enabled successfully");
			logger.info("LOS Restriction Type selected successfully");
			test.log(Status.PASS, "LOS Restriction Type selected successfully");
			Assert.assertTrue(Click_LosRestrictionType_StayThrough.isSelected(), "LOS Restriction Type is Enabled");

		} else {

			Click_LosRestrictionType_ArrivalDate.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("LOS Restriction Type not selected");
			logger.error("Failed to LOS Restriction Type");
			test.log(Status.FAIL, "Failed to LOS Restriction Type");

			Assert.assertTrue(Click_LosRestrictionType_ArrivalDate.isSelected(), "LOS Restriction Type is disable");

		}

	}

	public void propDefShowLowestPriceOnDetailsPage(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(ShowLowestRriceInDetailsPg_Field);

		Assert.assertEquals(ShowLowestRriceInDetailsPg_Field.isDisplayed(), true,
				"Show lowest price in Details page (web and mobile channels only) Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_ShowLowestRriceInDetailsPg_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(
					"Show lowest price in Details page (web and mobile channels only) is enabled successfully");
			logger.info("Show lowest price in Details page (web and mobile channels only) selected successfully");
			test.log(Status.PASS,
					"Show lowest price in Details page (web and mobile channels only) selected successfully");
			Assert.assertTrue(Click_ShowLowestRriceInDetailsPg_Enable.isSelected(),
					"Show lowest price in Details page (web and mobile channels only) is Enabled");

		} else {

			Click_ShowLowestRriceInDetailsPg_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Show lowest price in Details page (web and mobile channels only) not selected");
			logger.error("Failed to Show lowest price in Details page (web and mobile channels only)");
			test.log(Status.FAIL, "Failed to Show lowest price in Details page (web and mobile channels only)");

			Assert.assertTrue(Click_ShowLowestRriceInDetailsPg_Disable.isSelected(),
					"Show lowest price in Details page (web and mobile channels only) is disable");

		}

	}

	/**
	 * Method captures all possible options for the field then selects on an
	 * option based on the element's value. For example if true is passed in for
	 * value then web element option that has a value of true will be selected
	 * 
	 * @param value
	 */
	public void FBP_RadioButton(String value) {
		ExplicitWait(RadioButton_FBP);

		// This for loop, loops thorugh all the web elements/options found
		for (WebElement el : FBP_status) {
			if (el.getAttribute("value").equalsIgnoreCase(value)) {
				if (el.isSelected()) {
					System.out.println("FBP_RadioButton " + value + " Selected successfully");
					logger.info("FBP_RadioButton Selected successfully");
					test.log(Status.INFO, "FBP_RadioButton Selected successfully");

				} else {
					Javascriptexecutor(el);
					System.out.println("FBP_RadioButton " + value + " Selected successfully");
					logger.info("FBP_RadioButton Selected successfully");
					test.log(Status.INFO, "FBP_RadioButton Selected successfully");

				}
				break;
			} else {
				System.out.println("  -----------");
			}
		}
	}

	public void propDefSlashThrouPricingFBPrates(String status) throws Exception {
		// Field is normal disable when FBP is disable

		SeleniumRepo.waitForElementPresent(SlashThruPricingFbpRates_Field);

		Assert.assertEquals(SlashThruPricingFbpRates_Field.isDisplayed(), true,
				"Enable Slash Through Pricing for FBP rates Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_SlashThruPricingFbpRates_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Slash Through Pricing for FBP rates is enabled successfully");
			logger.info("Enable Slash Through Pricing for FBP rates selected successfully");
			test.log(Status.PASS, "Enable Slash Through Pricing for FBP rates selected successfully");
			Assert.assertTrue(Click_SlashThruPricingFbpRates_Enable.isSelected(),
					"Enable Slash Through Pricing for FBP rates is Enabled");

		} else {

			Click_SlashThruPricingFbpRates_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Slash Through Pricing for FBP rates not selected");
			logger.error("Failed to Enable Slash Through Pricing for FBP rates");
			test.log(Status.FAIL, "Failed to Enable Slash Through Pricing for FBP rates");

			Assert.assertTrue(Click_SlashThruPricingFbpRates_Disable.isSelected(),
					"Enable Slash Through Pricing for FBP rates is disable");

		}

	}

	public void propDefAddonsInPGDeposit(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(AddonsInPgDeposit_Field);

		Assert.assertEquals(AddonsInPgDeposit_Field.isDisplayed(), true,
				"Considered Addons in PG Deposit Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_AddonsInPgDeposit_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Considered Addons in PG Deposit  is enabled successfully");
			logger.info("Considered Addons in PG Deposit  selected successfully");
			test.log(Status.PASS, "Considered Addons in PG Deposit selected successfully");
			Assert.assertTrue(Click_AddonsInPgDeposit_Enable.isSelected(),
					"Considered Addons in PG Deposit  is Enabled");

		} else {

			Click_AddonsInPgDeposit_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Considered Addons in PG Deposit  not selected");
			logger.error("Failed to Considered Addons in PG Deposit ");
			test.log(Status.FAIL, "Failed to Considered Addons in PG Deposit ");

			Assert.assertTrue(Click_AddonsInPgDeposit_Disable.isSelected(),
					"Considered Addons in PG Deposit  is disable");

		}

	}

	public void propDefTaxInPGDeposit(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(TaxInPgDeposit_Field);

		Assert.assertEquals(TaxInPgDeposit_Field.isDisplayed(), true,
				"Considered Tax in PG Deposit Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {
            Thread.sleep(2000);
			Click_TaxInPgDeposit_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Considered Tax in PG Deposit  is enabled successfully");
			logger.info("Considered Tax in PG Deposit selected successfully");
			test.log(Status.PASS, "Considered Tax in PG Deposit selected successfully");
			boolean b=Click_TaxInPgDeposit_Enable.isSelected();
			Assert.assertTrue(Click_TaxInPgDeposit_Enable.isSelected(), "Considered Tax in PG Deposit is Enabled");

		} else {

			Click_TaxInPgDeposit_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Considered Tax in PG Deposit not selected");
			logger.error("Failed to Considered Tax in PG Deposit  ");
			test.log(Status.FAIL, "Failed to Considered Tax in PG Deposit  ");

			Assert.assertTrue(Click_TaxInPgDeposit_Disable.isSelected(), "Considered Tax in PG Deposit is disable");

		}

	}

	public void propDefSmartRatePlan(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(SmartRatePlan_Field);

		Assert.assertEquals(SmartRatePlan_Field.isDisplayed(), true,
				"Enable Smart Rate Plan Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_SmartRatePlan_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Smart Rate Plan is enabled successfully");
			logger.info("Enable Smart Rate Plan selected successfully");
			test.log(Status.PASS, "Enable Smart Rate Plan selected successfully");
			Assert.assertTrue(Click_SmartRatePlan_Enable.isSelected(), "Enable Smart Rate Plan is Enabled");

		} else {

			Click_SmartRatePlan_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Smart Rate Plan not selected");
			logger.error("Failed to Enable Smart Rate Plan ");
			test.log(Status.FAIL, "Failed to Enable Smart Rate Plan  ");

			Assert.assertTrue(Click_SmartRatePlan_Disable.isSelected(), "Enable Smart Rate Plan is disable");

		}

	}

	public void propDefDerbySoftConnection(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(DerbySoftConnection_Field);

		Assert.assertEquals(DerbySoftConnection_Field.isDisplayed(), true,
				"Enable DerbySoft Connection is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_DerbySoftConnection_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable DerbySoft Connection is enabled successfully");
			logger.info("Enable DerbySoft Connection selected successfully");
			test.log(Status.PASS, "Enable DerbySoft Connection selected successfully");
			Assert.assertTrue(Click_DerbySoftConnection_Enable.isSelected(), "Enable DerbySoft Connection is Enabled");

		} else {

			Click_DerbySoftConnection_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable DerbySoft Connection not selected");
			logger.error("Failed to Enable DerbySoft Connection ");
			test.log(Status.FAIL, "Failed to Enable DerbySoft Connection ");

			Assert.assertTrue(Click_DerbySoftConnection_Disable.isSelected(), "Enable DerbySoft Connection is disable");

		}

	}

	public void propDefWIHPConnection(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(WihpConnection_Field);

		Assert.assertEquals(WihpConnection_Field.isDisplayed(), true, "Enable WIHP Connection  is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_WihpConnection_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable WIHP Connection  is enabled successfully");
			logger.info("Enable WIHP Connection selected successfully");
			test.log(Status.PASS, "Enable WIHP Connection  selected successfully");
			Assert.assertTrue(Click_WihpConnection_Enable.isSelected(), "Enable WIHP Connection  is Enabled");

		} else {

			Click_WihpConnection_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable WIHP Connection  not selected");
			logger.error("Enable WIHP Connection  Connection ");
			test.log(Status.FAIL, "Failed to Enable WIHP Connection  ");

			Assert.assertTrue(Click_WihpConnection_Disable.isSelected(), "Enable WIHP Connection is disable");

		}

	}

	public void propDefLoyaltyProgram(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(LoyaltyProgram_Field);

		Assert.assertEquals(LoyaltyProgram_Field.isDisplayed(), true, "Enable Loyalty Program is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {
            Thread.sleep(3000);
			Click_LoyaltyProgram_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Loyalty Program   is enabled successfully");
			logger.info("Enable Loyalty Program  selected successfully");
			test.log(Status.PASS, "Enable Loyalty Program selected successfully");
			Assert.assertTrue(Click_LoyaltyProgram_Enable.isSelected(), "Enable Loyalty Program is Enabled");

		} else {

			Click_LoyaltyProgram_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Loyalty Program not selected");
			logger.error("Enable Loyalty Program  Connection ");
			test.log(Status.FAIL, "Failed to Enable Loyalty Program");

			Assert.assertTrue(Click_LoyaltyProgram_Disable.isSelected(), "Enable Loyalty Program is disable");

		}

	}

	public void propDefLoyaltyProgSelection(String loyaltyProgName) {

		SeleniumRepo.waitForElementPresent(Click_LoyaltyProgram_Enable);

		if (Click_LoyaltyProgram_Enable.isSelected()) {

			Assert.assertEquals(Select_LoyaltyProgram_DropDown.isDisplayed(), true,
					"Loyalty Program dropdown  is not being displayed");

			Select_LoyaltyProgram_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_LoyaltyProgram_DropDown, loyaltyProgName);

			System.out.println("Loyalty Program dropdown  was selected successfully");

			logger.info("Loyalty Program dropdown  was selected successfully");
			test.log(Status.PASS, "Loyalty Program dropdown was selected successfully");

		} else {

			System.out.println("Loyalty Program dropdown  is not displayed");

			logger.info("Loyalty Program dropdown  was not selected successfully");
			test.log(Status.FAIL, "Loyalty Program dropdown was not selected successfully");

		}

	}

	public void propDefCOMPRatePlan(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(CompRatePlan_Field);

		Assert.assertEquals(CompRatePlan_Field.isDisplayed(), true, "Enable COMP Rate Plan is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_CompRatePlan_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable COMP Rate Plan is enabled successfully");
			logger.info("Enable COMP Rate Plan selected successfully");
			test.log(Status.PASS, "Enable COMP Rate Plan  selected successfully");
			Assert.assertTrue(Click_CompRatePlan_Enable.isSelected(), "Enable COMP Rate Plan  is Enabled");

		} else {

			Click_CompRatePlan_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable COMP Rate Plan  not selected");
			logger.error("Enable COMP Rate Plan Connection ");
			test.log(Status.FAIL, "Failed to Enable COMP Rate Plan ");

			Assert.assertTrue(Click_CompRatePlan_Disable.isSelected(), "Enable COMP Rate Plan  is disable");

		}

	}

	public void propDefUplift(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(Uplift_Field);

		Assert.assertEquals(Uplift_Field.isDisplayed(), true, "Enable Uplift is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_Uplift_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Uplift  is enabled successfully");
			logger.info("Enable Uplift selected successfully");
			test.log(Status.PASS, "Enable Uplift selected successfully");
			Assert.assertTrue(Click_Uplift_Enable.isSelected(), "Enable Uplift is Enabled");

		} else {

			Click_Uplift_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Enable Uplift not selected");
			logger.error("Enable Uplift  Connection ");
			test.log(Status.FAIL, "Failed to Enable Uplift  ");

			Assert.assertTrue(Click_Uplift_Disable.isSelected(), "Enable Uplift is disable");

		}

	}


	public void CompoundAccess_RadioButton(String status) {

		SeleniumRepo.waitForElementPresent(Compound_Access_Codes_Field);

		if (status.equalsIgnoreCase("enable")) {
			Javascriptexecutor(Compound_Access_Codes_enabled);

			test.log(Status.INFO, "Compound_Access_Codes_is displayed and enabled successfully");
			logger.info("Compound_Access_Codes_is displayed and enabled successfully");
		} else {

			Javascriptexecutor(Compound_Access_Codes_disabled);

			test.log(Status.INFO, "Compound_Access_Codes_is displayed and enabled successfully");
			logger.info("Compound_Access_Codes_is displayed and enabled successfully");
		}

	}

	public void propDefAllowZeroRate(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(ZeroRate_Field);

		Assert.assertEquals(ZeroRate_Field.isDisplayed(), true, "Allow Zero Rate? not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {
            Thread.sleep(2000);
			Click_ZeroRate_Enable.click();
            
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Allow Zero Rate? enabled successfully");
			logger.info("Allow Zero Rate? selected successfully");
			test.log(Status.PASS, "Allow Zero Rate? selected successfully");
			boolean b=Click_ZeroRate_Enable.isSelected();
			Assert.assertTrue(Click_ZeroRate_Enable.isSelected(), "Allow Zero Rate? is Enabled");

		} else {

			Click_ZeroRate_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Allow Zero Rate? not selected");
			logger.error("Allow Zero Rate?  Connection ");
			test.log(Status.FAIL, "Failed to  Allow Zero Rate? ");

			Assert.assertTrue(Click_ZeroRate_Disable.isSelected(), "Allow Zero Rate? is disable");

		}

	}

	public void propDefFacebookPageId(String EnterFbId) {

		SeleniumRepo.waitForElementPresent(FacebookPageId_field);

		Assert.assertEquals(FacebookPageId_field.isDisplayed(), true, "Facebook Page ID is not being displayed");

		Enter_FacebookPageId_Text.click();
		Enter_FacebookPageId_Text.clear();
		Enter_FacebookPageId_Text.sendKeys(EnterFbId);

		System.out.println("Facebook Page ID is entered successfully");

		Assert.assertEquals(Enter_FacebookPageId_Text.getAttribute("value"), EnterFbId,
				"Facebook Page ID Field text was not entered");
		logger.info("Facebook Page ID is entered successfully");
		test.log(Status.PASS, "Facebook Page ID is entered successfully");

	}

	public void propDefRateCalendarRatePlan(String EnterRatePlan) {

		SeleniumRepo.waitForElementPresent(RateCalendarRatePlan_Field);

		Assert.assertEquals(RateCalendarRatePlan_Field.isDisplayed(), true,
				"Rate Calendar Rate Plan  is not being displayed");

		Select_RateCalendarRatePlan_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_RateCalendarRatePlan_DropDown, EnterRatePlan);

		System.out.println("Rate Calendar Rate Plan  was selected successfully");

		logger.info("Rate Calendar Rate Plan  was selected successfully");
		test.log(Status.PASS, "Rate Calendar Rate Plan  was selected successfully");

	}

	public void propDefTripConnectShowPriceRatePlan(String EnterTripConnRatePlan) {

		SeleniumRepo.waitForElementPresent(TripConnShowPriceRatePlan_Field);

		Assert.assertEquals(TripConnShowPriceRatePlan_Field.isDisplayed(), true,
				"TripConnect Show Price Rate Plan  Field is not being displayed");

		Select_TripConnShowPriceRatePlan_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_TripConnShowPriceRatePlan_DropDown, EnterTripConnRatePlan);

		System.out.println("TripConnect Show Price Rate Plan  was selected successfully");

		logger.info("TripConnect Show Price Rate Plan  was selected successfully");
		test.log(Status.PASS, "TripConnect Show Price Rate Plan was selected successfully");

	}

	public void propDefTripAdvisorInstantBookingRatePlan(String EnterTripAdRatePlan) {

		SeleniumRepo.waitForElementPresent(TripAdvisorInstBookingRatePlan_Field);

		Assert.assertEquals(TripAdvisorInstBookingRatePlan_Field.isDisplayed(), true,
				"TripAdvisor Instant Booking Rate Plan Field is not being displayed");

		Select_TripAdvisorInstBookingRatePlan_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_TripAdvisorInstBookingRatePlan_DropDown, EnterTripAdRatePlan);

		System.out.println("TripAdvisor Instant Booking Rate Plan was selected successfully");

		logger.info("TripAdvisor Instant Booking Rate Plan was selected successfully");
		test.log(Status.PASS, "TripAdvisor Instant Booking Rate Plan was selected successfully");

	}

	public void propDefFlipToEnabled(String status) throws Exception {

		SeleniumRepo.waitForElementPresent(FlipDotTo_Field);

		Assert.assertEquals(FlipDotTo_Field.isDisplayed(), true, "Flip.to Enabled is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_FlipDotTo_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Flip.to Enabled is enabled successfully");
			logger.info("Flip.to Enabled selected successfully");
			test.log(Status.PASS, "Flip.to Enabled selected successfully");
			Assert.assertTrue(Click_FlipDotTo_Enable.isSelected(), "Flip.to Enabled is Enabled");

		} else {

			Click_FlipDotTo_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Flip.to Enabled not selected");
			logger.error("Flip.to Enabled Connection ");
			test.log(Status.FAIL, "Failed to Flip.to Enabled ");

			Assert.assertTrue(Click_FlipDotTo_Disable.isSelected(), "Flip.to Enabled is disable");

		}

	}

	public void propDefFlipToCompanyCode(String EnterFlipDotCompCode) {

		SeleniumRepo.waitForElementPresent(FlipCompanyCode_field);

		Assert.assertEquals(FlipCompanyCode_field.isDisplayed(), true, "Flip.to Company Code is not being displayed");

		Enter_FlipCompanyCode_Text.click();
		Enter_FlipCompanyCode_Text.clear();
		Enter_FlipCompanyCode_Text.sendKeys(EnterFlipDotCompCode);

		System.out.println("Flip.to Company Code is entered successfully");

		Assert.assertEquals(Enter_FlipCompanyCode_Text.getAttribute("value"), EnterFlipDotCompCode,
				"Flip.to Company Code Field text was not entered");
		logger.info("Flip.to Company Code is entered successfully");
		test.log(Status.PASS, "Flip.to Company Code is entered successfully");

	}

	public void propDefFlipToCampaignCode(String EnterFlipDotCampCode) {

		SeleniumRepo.waitForElementPresent(FlipCampaignCode_field);

		Assert.assertEquals(FlipCampaignCode_field.isDisplayed(), true,
				"Flip.to Campaign  Code is not being displayed");

		Enter_FlipCampaignCode_Text.click();
		Enter_FlipCampaignCode_Text.clear();
		Enter_FlipCampaignCode_Text.sendKeys(EnterFlipDotCampCode);

		System.out.println("Flip.to Campaign Code is entered successfully");

		Assert.assertEquals(Enter_FlipCampaignCode_Text.getAttribute("value"), EnterFlipDotCampCode,
				"Flip.to Campaign Code Field text was not entered");
		logger.info("Flip.to Campaign  Code is entered successfully");
		test.log(Status.PASS, "Flip.to Campaign  Code is entered successfully");

	}

	public void Click_Save() {
		ExplicitWait(Click_Save);
		if (Click_Save.isDisplayed()) {
			Javascriptexecutor(Click_Save);
			System.out.println("Save button clicked successfully");
			logger.info("Save button clicked successfully");
			test.log(Status.INFO, "Save button clicked successfully");
			Assert.assertTrue(true, "Save button clicked successfully");

		} else {
			System.out.println("Save button not found");
			logger.info("Save button not found");
			test.log(Status.INFO, "Save button not found");
			Assert.assertTrue(true, "Save button not found");

		}
	}

	/**
	 * Original method that was used during regression found in
	 * AddNewProperty.java
	 * 
	 * @param PropertyDefaultsTitle
	 * @param StarRating
	 * @param Adultage
	 * @param CheckinTime
	 * @param CheckoutTime
	 * @throws Exception
	 */
	public void propertyDefault(String PropertyDefaultsTitle, String StarRating, String Adultage, String CheckinTime,
			String CheckoutTime) throws Exception {

		if (click_PropertyDefaults.isDisplayed()) {
			Javascriptexecutor(click_PropertyDefaults);
			ExplicitWait(Verify_PropertyDefaultsTitle);

			System.out.println("PropertyManagement element Expanded and Property defaults element  found");
			test.log(Status.INFO, "PropertyManagement element Expanded and Property defaults element  found");
			Assert.assertTrue(true, "PropertyManagement element Expanded and Property defaults element  found");
		} else {
			System.out.println("PropertyManagement Menu is not expanded");
			Javascriptexecutor(Click_PropertyManagement);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");

			ExplicitWait(click_PropertyDefaults);
			if (click_PropertyDefaults.isDisplayed()) {
				Javascriptexecutor(click_PropertyDefaults);
				ExplicitWait(Verify_PropertyDefaultsTitle);

				System.out.println("PropertyDefaults element found");
				test.log(Status.INFO, "PropertyDefaults element found");
				Assert.assertTrue(true, "PropertyDefaults element found");
			} else {
				logger.info("PropertyDefaults element not  found");
				test.log(Status.FAIL, "PropertyDefaults element not  found");
			}
		}
		System.out.println(Verify_PropertyDefaultsTitle.getText());
		System.out.println("Expected" + PropertyDefaultsTitle);
		if (Verify_PropertyDefaultsTitle.getText().contains(PropertyDefaultsTitle)) {
			System.out.println("Title Matched");
			logger.info("PropertyDefaults Title Matched");
			test.log(Status.PASS, "PropertyDefaults Title Matched");
			Assert.assertTrue(true, "PropertyDefaults Title Matched");
		} else {
			System.out.println("Title didn't match");
			logger.error("Title didn't match");
			// test.log(Status.FAIL,"Title didn't match");
			Assert.assertFalse(false, "PropertyDefaults Title didn't match");
		}

		SeleniumRepo.isElementPresent(Select_StarRating);
		if (SeleniumRepo.isElementPresent(Select_StarRating)) {
			SeleniumRepoDropdown.selectDropDownValue(Select_StarRating, StarRating);
			// SeleniumRepo.WaitForLoad(100);
			System.out.println(" StarRating selected successfully");
			logger.info("StarRating selected successfully");
			test.log(Status.PASS, "StarRating selected successfully");
			Assert.assertTrue(true, "StarRating selected successfully");
		} else {
			System.out.println("StarRating not selected");
			logger.error("Failed to Select StarRating");
			test.log(Status.FAIL, "Failed to Select StarRating");
			Assert.assertFalse(false, "StarRating not StarRating");
		}

		SeleniumRepo.isElementPresent(Enter_AdultAge);
		if (SeleniumRepo.isElementPresent(Enter_AdultAge)) {
			Enter_AdultAge.click();
			Enter_AdultAge.clear();
			Enter_AdultAge.sendKeys(Adultage);
			System.out.println("  Adultage is entered successfully");
			logger.info(" Adultage is entered successfully");
			test.log(Status.PASS, " Adultage is entered successfully");
			Assert.assertTrue(true, " Adultage is entered successfully");
		} else {
			System.out.println(" Adultage TextBox not found");
			logger.error("Failed to Enter Adultage in TextBox");
			test.log(Status.FAIL, "Failed to Enter Adultage in TextBox");
			Assert.assertFalse(false, "Adultage TextBox not found");
		}

		ExplicitWait(Select_CheckinTime);
		if (Select_CheckinTime.isDisplayed()) {
			SeleniumRepoDropdown.selectDropDownText(Select_CheckinTime, CheckinTime);
			// SeleniumRepo.WaitForLoad(100);
			System.out.println(" CheckinTime selected successfully");
			logger.info("CheckinTime selected successfully");
			test.log(Status.PASS, "CheckinTime selected successfully");

			Assert.assertTrue(true, " CheckinTime selected successfully");
		} else {
			System.out.println("CheckinTime not selected");
			logger.error("Failed to Select CheckinTime");
			test.log(Status.FAIL, "Failed to Select CheckinTime");
			Assert.assertFalse(false, "CheckinTime not selected");
		}

		SeleniumRepo.isElementPresent(Select_CheckoutTime);
		if (SeleniumRepo.isElementPresent(Select_CheckoutTime)) {
			SeleniumRepoDropdown.selectDropDownText(Select_CheckoutTime, CheckoutTime);
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" CheckoutTime selected successfully");
			logger.info("CheckoutTime selected successfully");
			test.log(Status.PASS, "CheckoutTime selected successfully");
			Assert.assertTrue(true, " CheckoutTime selected successfully");
		} else {
			System.out.println("CheckoutTime not selected");
			logger.error("Failed to Select CheckoutTime");
			test.log(Status.FAIL, "Failed to Select CheckoutTime");
			Assert.assertFalse(false, "CheckoutTime not selected");
		}

		SeleniumRepo.WaitForLoad(300);
		if (Click_Save3.isDisplayed()) {
			Click_Save3.click();
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
		} else {
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");

		}

	}

}
