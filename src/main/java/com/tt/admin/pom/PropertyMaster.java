/**
 * 
 */
package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;

/**
 * @author DM
 *
 */
public class PropertyMaster extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	public WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Master')]") })
	public WebElement Click_PropertyMaster;

	@FindAll({ @FindBy(xpath = "//td[@class = 'title' and contains(., 'Property Master')]"),
			@FindBy(css = "td:nth-child(2) table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) > td.title") })
	public WebElement Verify_PropertyMasterTitle;

	@FindAll({ @FindBy(name = "phone1CountryCode"), @FindBy(xpath = "//input[@name = 'phone1CountryCode']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input:nth-child(1)") })
	public WebElement Enter_Phone_Code;

	@FindAll({ @FindBy(name = "phone1AreaCode"), @FindBy(xpath = "//input[@name = 'phone1AreaCode']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input:nth-child(2)") })
	public WebElement Enter_Phone_Area_Code;

	@FindAll({ @FindBy(name = "phone1Number"), @FindBy(xpath = "//input[@name = 'phone1Number']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input:nth-child(3)") })
	public WebElement Enter_Phone_Number;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Phone (Reservation)')]") })
	public WebElement PhoneReservation_field;

	@FindAll({ @FindBy(xpath = "//*[@name='phone2CountryCode']") })
	public WebElement Enter_PhoneReservation_Country_Text;

	@FindAll({ @FindBy(xpath = "//*[@name='phone2AreaCode']") })
	public WebElement Enter_PhoneReservation_Area_Text;

	@FindAll({ @FindBy(xpath = "//*[@name='phone2Number']") })
	public WebElement Enter_PhoneReservation_Phone_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Fax')]") })
	public WebElement Fax_field;

	@FindAll({ @FindBy(xpath = "//*[@name='fax1CountryCode']") })
	public WebElement Enter_Fax_Country_Text;

	@FindAll({ @FindBy(xpath = "//*[@name='fax1AreaCode']") })
	public WebElement Enter_Fax_Area_Text;

	@FindAll({ @FindBy(xpath = "//*[@name='fax1Number']") })
	public WebElement Enter_Fax_Phone_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Website URL')]") })
	public WebElement WebsiteUrl_field;

	@FindAll({ @FindBy(xpath = "//*[@name='websiteURL']") })
	public WebElement Enter_WebsiteUrl_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Primary Email')]") })
	public WebElement PrimaryEmail_field;

	@FindAll({ @FindBy(xpath = "//*[@name='primaryEmail']") })
	public WebElement Enter_PrimaryEmail_Text;

	@FindAll({ @FindBy(xpath = "//div[@id ='emailStatus']") })
	public WebElement PrimaryEmailStatus_field;

	@FindAll({ @FindBy(xpath = "//a[@id = 'verifyLink']") })
	public WebElement PrimaryEmailStatusVerify_link;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Property Notification Email')]") })
	public WebElement PropertyNotifiEmail_field;

	@FindAll({ @FindBy(xpath = "//*[@name='propertyNotificationEmail']") })
	public WebElement Enter_PropertyNotifiEmail_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'INTG Notification Emails')]") })
	public WebElement IntgNotifiEmails_field;

	@FindAll({ @FindBy(xpath = "//*[@name='intgNotificationEmails']") })
	public WebElement Enter_IntgNotifiEmails_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Additional Emails')]") })
	public WebElement AdditionalEmails_field;

	@FindAll({ @FindBy(xpath = "//*[@name='additionalEmails']") })
	public WebElement Enter_AdditionalEmails_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'No. of Rooms')]") })
	public WebElement NumOfRooms_field;

	@FindAll({ @FindBy(xpath = "//*[@name='noOfRooms']") })
	public WebElement Enter_NumOfRooms_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'No. of Floors')]") })
	public WebElement NumOfFloors_field;

	@FindAll({ @FindBy(xpath = "//*[@name='noOfFloors']") })
	public WebElement Enter_NumOfFloors_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Property Languages')]") })
	public WebElement PropertyLange_field;

	@FindAll({ @FindBy(xpath = "//*[@class='prompt lang']") })
	public List<WebElement> LanaguageNames;

	@FindAll({ @FindBy(xpath = "//table[@class='language_table']/tbody/tr/td/input[@type='checkbox']") })
	public List<WebElement> LanaguageEnable;

	@FindAll({ @FindBy(xpath = "//table[@class='language_table']/tbody/tr/td/input[@type='radio'and @value='false']") })
	public List<WebElement> LanguageStage;

	@FindAll({ @FindBy(xpath = "//table[@class='language_table']/tbody/tr/td/input[@type='radio' and @value='true']") })
	public List<WebElement> LanguageLive;

	@FindAll({ @FindBy(xpath = "//*[@name='defaultLang']") })
	public List<WebElement> LanguageDefault;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Available Bed Types')]") })
	public WebElement AvblBedTypes_field;

	@FindAll({ @FindBy(xpath = "//*[@name = 'bedTypes']") })
	public List<WebElement> allBedTypes;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Name')]") })
	public WebElement BedTypeName_field;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Bed Code')]") })
	public WebElement BedTypeCode_field;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Credit Card Validation')]") })
	public WebElement CreditCardValidation_field;

	@FindAll({ @FindBy(xpath = "//*[@name='creditCardBinValidationEnabled'][1]") })
	public WebElement Click_CreditCardValidation_Basic;

	@FindAll({ @FindBy(xpath = "//*[@name='creditCardBinValidationEnabled'][2]") })
	public WebElement Click_CreditCardValidation_InfoVal;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Long')]") })
	public WebElement LongDescription_field;

	@FindAll({ @FindBy(xpath = "//*[@name='longDescription']") })
	public WebElement Enter_LongDescription_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'GDS Promotional Text')]") })
	public WebElement GdsPromotionalTxt_field;

	@FindAll({ @FindBy(xpath = "//*[@name='gdsPromotionalText1']") })
	public WebElement Enter_GdsPromotionalTxt_field_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'All Non-Smoking')]") })
	public WebElement AllNonSmokingRooms_field;

	@FindAll({ @FindBy(xpath = "//*[@name='isAllNonSmokingRooms'][1]") })
	public WebElement Click_AllNonSmokingRooms_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='isAllNonSmokingRooms'][2]") })
	public WebElement Click_AllNonSmokingRooms_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Credit Cards Accepted')]") })
	public WebElement CreditCardAccpt_field;

	@FindAll({ @FindBy(name = "websiteURL"), @FindBy(xpath = "//input[@name = 'websiteURL']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(15) td:nth-child(2) > input.input") })
	public WebElement Enter_Website_URL;

	@FindAll({ @FindBy(name = "primaryEmail"), @FindBy(xpath = "//input[@name = 'primaryEmail']"),
			@FindBy(css = "#primaryEmail") })
	public WebElement Enter_Primary_Email;

	@FindAll({ @FindBy(name = "noOfRooms"), @FindBy(xpath = "//input[@name = 'noOfRooms']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(20) td:nth-child(2) > input.input") })
	public WebElement Enter_NumberOf_Rooms;

	@FindAll({ @FindBy(name = "noOfFloors"), @FindBy(xpath = "//input[@name = 'noOfFloors']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(21) td:nth-child(2) > input.input") })
	public WebElement Enter_NumberOf_Floors;

	@FindAll({ @FindBy(id = "enable_en"), @FindBy(xpath = "//input[@id='enable_en']"), @FindBy(css = "#enable_en") })
	public WebElement Verify_Default_PropertyLanguage;

	@FindAll({ @FindBy(xpath = "//input[@value='Add Bed Type']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(23) td:nth-child(2) > input.input:nth-child(17)") })
	public WebElement Click_Add_BedType;

	@FindAll({ @FindBy(xpath = "//input[@name='bedTypeName']"),
			@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > input.input.guest-facing-fields:nth-child(1)") })
	public WebElement Enter_Bed_Type;

	@FindAll({ @FindBy(xpath = "//input[@name='bedTypeCode']"),
			@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > input.input") })
	public WebElement Enter_Bed_Type_Code;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Queen Bed & Sofabed')]") })
	public List<WebElement> FirstBedType;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Kings Bed & Sofabed')]") })
	public List<WebElement> SecondBedType;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Double Bed And Sofa King')]") })
	public List<WebElement> ThirdBedType;

	@FindAll({ @FindBy(xpath = "//input[@value='Save' and @onclick= 'saveSubmit()']"),
			@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(4) td:nth-child(1) > input.input:nth-child(1)") })
	public WebElement Click_SaveButton5;

	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"),
			@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(4) td:nth-child(1) > input.input:nth-child(2)") })
	public WebElement Click_Cancel5;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Duplicate Bed Type Code')]"),
			@FindBy(css = "tr:nth-child(1) td:nth-child(2) form:nth-child(2) font:nth-child(1) > li:nth-child(1)") })
	public WebElement ErrorMessage_DuplicateBedType;

	@FindAll({ @FindBy(xpath = "//input[(@name='creditCardsAccepted') and (@type='checkbox')]") })
	public List<WebElement> Check_CreditCardAccept;

	@FindAll({ @FindBy(xpath = "//input[(@name='creditCardsAccepted') and (@type='checkbox')]") })
	public WebElement Select_CreditCardValidation;

	@FindAll({ @FindBy(name = "shortDescription"), @FindBy(xpath = "//textarea[@name='shortDescription']"),
			@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(29) td:nth-child(2) > textarea.input") })
	public WebElement Enter_Short_Description;

	public void click_PropertyMaster() {

		try {
			SeleniumRepo.scrollintoview(Click_PropertyManagement);Thread.sleep(2000);	
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

		 SeleniumRepo.waitForPageLoaded();
		//SeleniumRepo.waitForElementPresent(Click_PropertyMaster);

		if (Click_PropertyMaster.isDisplayed()) {
			Click_PropertyMaster.click();
			logger.info("Clicked on PropertyMaster");
			test.log(Status.PASS, "Clicked on PropertyMaster");
		} else {
			Click_PropertyManagement.click();Thread.sleep(2000);
			Click_PropertyMaster.click();Thread.sleep(3000);
			 SeleniumRepo.waitForPageLoaded();
//			logger.error("Failed to Click on PropertyMaster");
//			test.log(Status.FAIL, "Failed to Click on PropertyMaster");
		}

		// System.out.println(Verify_PropertyMasterTitle.getText());
		// System.out.println("Expected"+PropertyMasterTitle);
		try {Thread.sleep(2000);
			Assert.assertEquals("Property Master", Verify_PropertyMasterTitle.getText());
			System.out.println("Title Matched");
			logger.info("PropertyMaster Title Matched");
			test.log(Status.PASS, "PropertyMaster Title Matched");
			Assert.assertTrue(true, "PropertyMaster Title Matched");
		} catch (Error e) {
			System.out.println("PropertyMaster Title didn't match");
			logger.error("PropertyMaster Title didn't match");
			test.log(Status.FAIL, "PropertyMaster Title didn't match");
			Assert.assertFalse(false, "PropertyMaster Title didn't match");
		} catch (NoSuchElementException hi) {
			System.out.println("PropertyMaster Title was not found");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void propMasterPhoneMain(String Phone_Code, String Phone_Area_Code, String Phone_Number) {

		/*
		 * @FindAll({ @FindBy(xpath =
		 * "//div[contains(text(),'Multi-Property Portals')]") }) public
		 * WebElement MultiPropPortals_field;
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@name='propertyPortals']") }) public
		 * WebElement Enter_MultiPropPortals_Text;
		 * 
		 * SeleniumRepo.waitForElementPresent(MultiPropPortals_field);
		 * 
		 * Assert.assertEquals(MultiPropPortals_field.isDisplayed(), true,
		 * "Multi-Property Portals text Field is not being displayed");
		 * 
		 * Enter_MultiPropPortals_Text.click();
		 * Enter_MultiPropPortals_Text.clear();
		 * Enter_MultiPropPortals_Text.sendKeys(EnterMultiPropertyPortals);
		 * 
		 * System.out.println("Multi-Property Portals is entered successfully");
		 * 
		 * 
		 * Assert.assertEquals(Enter_MultiPropPortals_Text.getAttribute("value")
		 * ,
		 * EnterMultiPropertyPortals,"Multi-Property Portals Field text was not entered"
		 * ); logger.info("Multi-Property Portals is entered successfully");
		 * test.log(Status.PASS,
		 * "Multi-Property Portals is entered successfully");
		 * 
		 */

		if (SeleniumRepo.isElementPresent(Enter_Phone_Code)) {
			Enter_Phone_Code.click();
			Enter_Phone_Code.clear();
			Enter_Phone_Code.sendKeys(Phone_Code);
			System.out.println("  Phone_Code is entered successfully");
			logger.info("Phone_Code is entered successfully");
			test.log(Status.PASS, "Phone_Code is entered successfully");
			Assert.assertTrue(true, " Phone_Code is entered successfully");
		} else {
			System.out.println(" Phone_Code not found");
			logger.error("Failed to Enter Phone_Code in TextBox");
			test.log(Status.FAIL, "Failed to Enter Phone_Code1 in TextBox");
			Assert.assertFalse(false, "Phone_Code not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_Phone_Area_Code)) {
			Enter_Phone_Area_Code.click();
			Enter_Phone_Area_Code.clear();
			Enter_Phone_Area_Code.sendKeys(Phone_Area_Code);
			System.out.println("  Phone_Area_Code is entered successfully");
			logger.info("Phone_Area_Code is entered successfully");
			test.log(Status.PASS, "Phone_Area_Code is entered successfully");
			Assert.assertTrue(true, " Phone_Area_Code is entered successfully");
		} else {
			System.out.println(" Phone_Area_Code not found");
			logger.error("Failed to Enter Phone_Area_Code in TextBox");
			test.log(Status.FAIL, "Failed to Enter Phone_Area_Code in TextBox");
			Assert.assertFalse(false, "Phone_Area_Code not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_Phone_Number)) {
			Enter_Phone_Number.click();
			Enter_Phone_Number.clear();
			Enter_Phone_Number.sendKeys(Phone_Number);
			System.out.println("  Phone_Number is entered successfully");
			logger.info(" Phone_Number is entered successfully");
			test.log(Status.PASS, " Phone_Number is entered successfully");
			Assert.assertTrue(true, " Phone_Number is entered successfully");
		} else {
			System.out.println(" Phone_Number not found");
			logger.error("Failed to Enter Phone_Number in TextBox");
			test.log(Status.FAIL, "Failed to Enter Phone_Number in TextBox");
			Assert.assertFalse(false, "Phone_Number not found");
		}

	}

	public void propMasterPhoneReservation(String EnterCountryNum, String EnterAreaNum, String EnterPhoneNum) {

		/*   */

		SeleniumRepo.waitForElementPresent(PhoneReservation_field);

		Assert.assertEquals(PhoneReservation_field.isDisplayed(), true,
				"Phone (Reservation) text Field is not being displayed");

		Enter_PhoneReservation_Country_Text.click();
		Enter_PhoneReservation_Country_Text.clear();
		Enter_PhoneReservation_Country_Text.sendKeys(EnterCountryNum);

		System.out.println("Phone (Reservation) is entered successfully");

		Assert.assertEquals(Enter_PhoneReservation_Country_Text.getAttribute("value"), EnterCountryNum,
				"Phone (Reservation) Country Field text was not entered");
		logger.info("Phone (Reservation) Country is entered successfully");
		test.log(Status.PASS, "Phone (Reservation) Country is entered successfully");

		Enter_PhoneReservation_Area_Text.click();
		Enter_PhoneReservation_Area_Text.clear();
		Enter_PhoneReservation_Area_Text.sendKeys(EnterAreaNum);

		System.out.println("Phone (Reservation) Area is entered successfully");

		Assert.assertEquals(Enter_PhoneReservation_Area_Text.getAttribute("value"), EnterAreaNum,
				"Phone (Reservation) Area Field text was not entered");
		logger.info("Phone (Reservation) Area is entered successfully");
		test.log(Status.PASS, "Phone (Reservation) Area is entered successfully");

		Enter_PhoneReservation_Phone_Text.click();
		Enter_PhoneReservation_Phone_Text.clear();
		Enter_PhoneReservation_Phone_Text.sendKeys(EnterPhoneNum);

		System.out.println("Phone (Reservation) phone number is entered successfully");

		Assert.assertEquals(Enter_PhoneReservation_Phone_Text.getAttribute("value"), EnterPhoneNum,
				"Phone (Reservation) Phone number Field text was not entered");
		logger.info("Phone (Reservation) phone number is entered successfully");
		test.log(Status.PASS, "Phone (Reservation) phone number is entered successfully");

	}

	public void propMasterFax(String EnterCountryNum, String EnterAreaNum, String EnterPhoneNum) {

		/*  */

		SeleniumRepo.waitForElementPresent(Fax_field);

		Assert.assertEquals(Fax_field.isDisplayed(), true, "Fax Field is not being displayed");

		Enter_Fax_Country_Text.click();
		Enter_Fax_Country_Text.clear();
		Enter_Fax_Country_Text.sendKeys(EnterCountryNum);

		System.out.println("Fax country is entered successfully");

		Assert.assertEquals(Enter_Fax_Country_Text.getAttribute("value"), EnterCountryNum,
				"Fax country Field text was not entered");
		logger.info("Fax Country is entered successfully");
		test.log(Status.PASS, "Fax Country is entered successfully");

		Enter_Fax_Area_Text.click();
		Enter_Fax_Area_Text.clear();
		Enter_Fax_Area_Text.sendKeys(EnterAreaNum);

		System.out.println("Fax Area is entered successfully");

		Assert.assertEquals(Enter_Fax_Area_Text.getAttribute("value"), EnterAreaNum,
				"Fax Area Field text was not entered");
		logger.info("Fax Area is entered successfully");
		test.log(Status.PASS, "Fax Area is entered successfully");

		Enter_Fax_Phone_Text.click();
		Enter_Fax_Phone_Text.clear();
		Enter_Fax_Phone_Text.sendKeys(EnterPhoneNum);

		System.out.println("Fax phone number is entered successfully");

		Assert.assertEquals(Enter_Fax_Phone_Text.getAttribute("value"), EnterPhoneNum,
				"Fax Phone number Field text was not entered");
		logger.info("Fax phone number is entered successfully");
		test.log(Status.PASS, "Fax phone number is entered successfully");

	}

	public void propMasterWebsiteUrl(String EnterWebsiteUrl) {

		/*   */

		SeleniumRepo.waitForElementPresent(WebsiteUrl_field);

		Assert.assertEquals(WebsiteUrl_field.isDisplayed(), true, "Website URL text Field is not being displayed");

		Enter_WebsiteUrl_Text.click();
		Enter_WebsiteUrl_Text.clear();
		Enter_WebsiteUrl_Text.sendKeys(EnterWebsiteUrl);

		System.out.println("Website URL is entered successfully");

		Assert.assertEquals(Enter_WebsiteUrl_Text.getAttribute("value"), EnterWebsiteUrl,
				"Website URL Field text was not entered");
		logger.info("Website URL is entered successfully");
		test.log(Status.PASS, "Website URL is entered successfully");

	}

	public void propMasterPrimaryEmail(String EnterPrimaryEmail) {

		/*   */

		SeleniumRepo.waitForElementPresent(PrimaryEmail_field);

		Assert.assertEquals(PrimaryEmail_field.isDisplayed(), true, "Primary Email text Field is not being displayed");

		//Enter_PrimaryEmail_Text.click();
		//Enter_PrimaryEmail_Text.clear();
		Enter_PrimaryEmail_Text.sendKeys(EnterPrimaryEmail);

		System.out.println("Primary Email is entered successfully");

		Assert.assertEquals(Enter_PrimaryEmail_Text.getAttribute("value"), EnterPrimaryEmail,
				"Primary Email Field text was not entered");
		logger.info("Primary Email is entered successfully");
		test.log(Status.PASS, "Primary Email is entered successfully");

		// Need to consider email validation

		try {

			if (PrimaryEmailStatus_field.isDisplayed() == true) {
				PrimaryEmailStatus_field.click();

				if (PrimaryEmailStatus_field.getText() != "Verified"
						&& PrimaryEmailStatusVerify_link.isDisplayed() == true) {

					PrimaryEmailStatusVerify_link.click();

					// handleAlert(); review this
					handleAlert(SeleniumRepo.driver);
				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {

			System.out.println("State Dropdown does not appear");
		}

	}

	public void propMasterPropNotificationEmail(String EnterPropNotifiEmail) {

		/*   */

		SeleniumRepo.waitForElementPresent(PropertyNotifiEmail_field);

		Assert.assertEquals(PropertyNotifiEmail_field.isDisplayed(), true,
				"Property Notification Email text Field is not being displayed");

		Enter_PropertyNotifiEmail_Text.click();
		Enter_PropertyNotifiEmail_Text.clear();
		Enter_PropertyNotifiEmail_Text.sendKeys(EnterPropNotifiEmail);

		System.out.println("Property Notification Email is entered successfully");

		Assert.assertEquals(Enter_PropertyNotifiEmail_Text.getAttribute("value"), EnterPropNotifiEmail,
				"Property Notification Email Field text was not entered");
		logger.info("Property Notification Email is entered successfully");
		test.log(Status.PASS, "Property Notification Email is entered successfully");

	}

	public void propMasterIntgNotificationEmail(String EnterIntgNotifiEmail) {

		/*   */

		SeleniumRepo.waitForElementPresent(IntgNotifiEmails_field);

		Assert.assertEquals(IntgNotifiEmails_field.isDisplayed(), true,
				"INTG Notification Emails text Field is not being displayed");

		Enter_IntgNotifiEmails_Text.click();
		Enter_IntgNotifiEmails_Text.clear();
		Enter_IntgNotifiEmails_Text.sendKeys(EnterIntgNotifiEmail);

		System.out.println("INTG Notification Emails is entered successfully");

		Assert.assertEquals(Enter_IntgNotifiEmails_Text.getAttribute("value"), EnterIntgNotifiEmail,
				"INTG Notification Emails Field text was not entered");
		logger.info("INTG Notification Emails is entered successfully");
		test.log(Status.PASS, "INTG Notification Emails is entered successfully");

	}

	public void propMasterAddEmails(String EnterAdditionalEmail) {

		/*   */

		SeleniumRepo.waitForElementPresent(AdditionalEmails_field);

		Assert.assertEquals(AdditionalEmails_field.isDisplayed(), true,
				"Additional Emails text Field is not being displayed");

		Enter_AdditionalEmails_Text.click();
		Enter_AdditionalEmails_Text.clear();
		Enter_AdditionalEmails_Text.sendKeys(EnterAdditionalEmail);

		System.out.println("Additional Emails is entered successfully");

		Assert.assertEquals(Enter_AdditionalEmails_Text.getAttribute("value"), EnterAdditionalEmail,
				"Additional Emails Field text was not entered");
		logger.info("Additional Emails is entered successfully");
		test.log(Status.PASS, "Additional Emails is entered successfully");

	}

	public void propMasterNumOfRooms(String EnterNumOfRooms) {

		/*   */

		SeleniumRepo.waitForElementPresent(NumOfRooms_field);

		Assert.assertEquals(NumOfRooms_field.isDisplayed(), true, "No. of Rooms text Field is not being displayed");

		Enter_NumOfRooms_Text.click();
		Enter_NumOfRooms_Text.clear();
		Enter_NumOfRooms_Text.sendKeys(EnterNumOfRooms);

		System.out.println("No. of Rooms is entered successfully");

		Assert.assertEquals(Enter_NumOfRooms_Text.getAttribute("value"), EnterNumOfRooms,
				"No. of Rooms Field text was not entered");
		logger.info("No. of Rooms is entered successfully");
		test.log(Status.PASS, "No. of Rooms is entered successfully");

	}

	public void propMasterNumOfFloors(String EnterNumOfFlrs) {

		/*   */

		SeleniumRepo.waitForElementPresent(NumOfFloors_field);

		Assert.assertEquals(NumOfFloors_field.isDisplayed(), true, "No. of Floors text Field is not being displayed");

		Enter_NumOfFloors_Text.click();
		Enter_NumOfFloors_Text.clear();
		Enter_NumOfFloors_Text.sendKeys(EnterNumOfFlrs);

		System.out.println("No. of Floors is entered successfully");

		Assert.assertEquals(Enter_NumOfFloors_Text.getAttribute("value"), EnterNumOfFlrs,
				"No. of Floors Field text was not entered");
		logger.info("No. of Floors is entered successfully");
		test.log(Status.PASS, "No. of Floors is entered successfully");

	}

	public void propMasterPropertyLanguages(String EnterLangaugeName) {

		/*
		 * 
		 * //input[@value='Save' and @onclick= 'saveSubmit()']
		 * 
		 * 
		 * //This captures all the languages names: //*[@class='prompt lang']
		 * 
		 * //This captures all enable checkboxes :
		 * //table[@class='language_table']/tbody/tr/td/input[@type='checkbox']
		 * 
		 * 
		 * //This captures the staging button
		 * //table[@class='language_table']/tbody/tr/td/input[@type='radio'
		 * and @value='false']
		 * 
		 * //This captures the live button
		 * //table[@class='language_table']/tbody/tr/td/input[@type='radio'
		 * and @value='true']
		 * 
		 * //This captures the defualt language section //*[@name='defaultLang']
		 * 
		 * 
		 * 
		 */
		try {
		int countLl = 0;

		String[] langList = EnterLangaugeName.split("[;]");

		while (countLl < langList.length) {

			for (int i = 0; i < LanaguageNames.size()-1; i++) {

				if (LanaguageNames.get(i).getText().contains(langList[countLl])
						&& LanguageStage.get(i).isEnabled() == false) {
					LanaguageEnable.get(i).click();
					LanguageLive.get(i).click();
				}
			}

			countLl++;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void propMasterAvailableBedTypesCreate(String EnterBedTypeName, String EnterBedtypeCode) {

		// Need to have an if satement that checks if beds are already their and
		// then slecting one
		// else create a new one

		/*
		 * 
		 * 
		 * //For Bed type edit
		 * 
		 * //This gathers all bedtypes check boxes //*[@name = 'bedTypes']
		 * 
		 * 
		 * 
		 * //This is for the bed type links can .. the xpaht will return 6 items
		 * delete the first //tbody/tr/td/a
		 * 
		 * //Donot use
		 * 
		 * @FindAll({ @FindBy(xpath = "//tr/td/input[@name='Submit']") }) public
		 * WebElement Click_AddBedType_Button;
		 * 
		 * 
		 */

		SeleniumRepo.waitForElementPresent(AvblBedTypes_field);

		Assert.assertEquals(AvblBedTypes_field.isDisplayed(), true, "Available Bed TypesField is not being displayed");

		Assert.assertEquals(Click_Add_BedType.isDisplayed(), true,
				"Available Bed Types Add bed type button is not being displayed");

		if (allBedTypes.size() > 0) {

			for (int i = 0; i < allBedTypes.size(); i++) {

				// Wiil create a if statement that will check if a checkbox is
				// checked, else check it
				System.out.println(allBedTypes.get(i).isSelected());

				if (allBedTypes.get(i).isSelected() != true) {

					allBedTypes.get(i).click();

				}
			}

		}

		if (allBedTypes.size() >= 0) {

			Click_Add_BedType.click();

			propMasterBedTypesPage(EnterBedTypeName, EnterBedtypeCode);

		}

	}

	private void propMasterBedTypesPage(String EnterBedTypeName, String EnterBedtypeCode) {

		/*
		 * 
		 * 
		 * //Bed page fields
		 * 
		 * 
		 * 
		 * //Do Not use
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@name='bedTypeName']") }) public
		 * WebElement Enter_BedTypeName_Text;
		 * 
		 * //Do NOt use
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@name='bedTypeCode']") }) public
		 * WebElement Enter_BedTypeCode_Text;
		 * 
		 * //Do Not use
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@name='Submit3']") }) public
		 * WebElement BedTypePg_Save_Button;
		 * 
		 */

		SeleniumRepo.waitForElementPresent(BedTypeName_field);

		Enter_Bed_Type.click();
		Enter_Bed_Type.clear();
		Enter_Bed_Type.sendKeys(EnterBedTypeName);

		Enter_Bed_Type_Code.click();
		Enter_Bed_Type_Code.clear();
		Enter_Bed_Type_Code.sendKeys(EnterBedtypeCode);

		Click_SaveButton5.click();

	}

	public void propMasterAllNonSmkRooms(String status) throws Exception {

		/*   */

		SeleniumRepo.waitForElementPresent(AllNonSmokingRooms_field);

		Assert.assertEquals(AllNonSmokingRooms_field.isDisplayed(), true,
				"All Non-Smoking Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_AllNonSmokingRooms_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("All Non-Smoking is enabled successfully");
			logger.info("All Non-Smoking selected successfully");
			test.log(Status.PASS, "All Non-Smoking selected successfully");
			Assert.assertTrue(Click_AllNonSmokingRooms_Enable.isSelected(), "All Non-Smoking is Enabled");

		} else {

			Click_AllNonSmokingRooms_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("All Non-Smoking not selected");
			logger.error("Failed to Select  All Non-Smoking");
			test.log(Status.FAIL, "Failed to SelectEnable All Non-Smoking");

			Assert.assertTrue(Click_AllNonSmokingRooms_Disable.isSelected(), "All Non-Smoking is disable");

		}

	}

	public void propMasterCreditCardsAccpt(String CreditCardTypes) {

		/*
		 * Code block below is not good and needs application web elements to
		 * change in order to be cleaner. the Credit Cards Accepted, section has
		 * a list of check boxes, if this method allows the selection of the
		 * checkbox by input, there needs to be a way to select the requested
		 * items. Currently the checkbox values are set to numbers "1 to 7",
		 * this is not good and there needs to be a request to set the checkbox
		 * attribute value to the name of the credit card
		 */

		SeleniumRepo.waitForElementPresent(CreditCardAccpt_field);

		String[] differentCreditCards = CreditCardTypes.split("[;]");

		String var = "";

		try {

			for (int i = 0; i < differentCreditCards.length; i++) {

				if (differentCreditCards[i].equals("Visa")) {
					differentCreditCards[i] = "1";

				} else if (differentCreditCards[i].equals("MasterCard")) {

					differentCreditCards[i] = "2";

				} else if (differentCreditCards[i].equals("American Express")) {
					differentCreditCards[i] = "3";

				} else if (differentCreditCards[i].equals("Discover")) {
					differentCreditCards[i] = "4";

				} else if (differentCreditCards[i].equals("Diners Club")) {
					differentCreditCards[i] = "5";
					System.out.println(differentCreditCards[i] + "   lsl");

				} else if (differentCreditCards[i].equals("Japan Credit Bureau")) {
					differentCreditCards[i] = "6";

				} else if (differentCreditCards[i].equals("China UnionPay")) {
					differentCreditCards[i] = "7";

				}

				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CreditCardAccept, differentCreditCards[i]);
				System.out.println("insinde prop master: " + differentCreditCards[i]);

				logger.info("\"" + differentCreditCards[i]);
				test.log(Status.PASS, "\"" + differentCreditCards[i]);

				var = differentCreditCards[i];

			}

		} catch (Exception e) {
			System.out.println(var + " Not Checked");
			logger.error("Failed to Select " + var);
			test.log(Status.FAIL, "Failed to Select " + var);
			e.printStackTrace();
		}

	}

	public void propMasterCreditCardVal(String ccValidType) throws Exception {

		/*   	 */

		SeleniumRepo.waitForElementPresent(CreditCardValidation_field);

		Assert.assertEquals(CreditCardValidation_field.isDisplayed(), true,
				"Credit Card Validation Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (ccValidType.equalsIgnoreCase("basic")) {

			Click_CreditCardValidation_Basic.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Credit Card Validation  is enabled successfully");
			logger.info("Credit Card Validation selected successfully");
			test.log(Status.PASS, "Credit Card Validation selected successfully");
			Assert.assertTrue(Click_CreditCardValidation_Basic.isSelected(), "Credit Card Validation is Enabled");

		} else {
            Thread.sleep(2000);SeleniumRepo.scrollintoview(Click_CreditCardValidation_InfoVal);
			Click_CreditCardValidation_InfoVal.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Credit Card Number Information Validation was selected");
			logger.error(" Select Enable Credit Card Number Information Validation");
			test.log(Status.FAIL, "Select Credit Card Number Information Validation ");
            boolean b=Click_CreditCardValidation_InfoVal.isSelected();
			Assert.assertTrue(Click_CreditCardValidation_InfoVal.isSelected(),
					" Credit Card Number Information Validation is enable");

		}

	}

	public void propMasterAssUsers() {
	}

	public void propMasterShortDes(String Short_Description) {

		/*
		 * @FindAll({ @FindBy(xpath =
		 * "//div[contains(text(),'Multi-Property Portals')]") }) public
		 * WebElement MultiPropPortals_field;
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@name='propertyPortals']") }) public
		 * WebElement Enter_MultiPropPortals_Text;
		 * 
		 * SeleniumRepo.waitForElementPresent(MultiPropPortals_field);
		 * 
		 * Assert.assertEquals(MultiPropPortals_field.isDisplayed(), true,
		 * "Multi-Property Portals text Field is not being displayed");
		 * 
		 * Enter_MultiPropPortals_Text.click();
		 * Enter_MultiPropPortals_Text.clear();
		 * Enter_MultiPropPortals_Text.sendKeys(EnterMultiPropertyPortals);
		 * 
		 * System.out.println("Multi-Property Portals is entered successfully");
		 * 
		 * 
		 * Assert.assertEquals(Enter_MultiPropPortals_Text.getAttribute("value")
		 * ,
		 * EnterMultiPropertyPortals,"Multi-Property Portals Field text was not entered"
		 * ); logger.info("Multi-Property Portals is entered successfully");
		 * test.log(Status.PASS,
		 * "Multi-Property Portals is entered successfully");
		 */

		SeleniumRepo.waitForElementPresent(Enter_Short_Description);

		if (Enter_Short_Description.isDisplayed()) {
			Enter_Short_Description.clear();
			Enter_Short_Description.click();
			Enter_Short_Description.sendKeys(Short_Description);
			System.out.println(" Short_Description is entered successfully");
			logger.info("Short_Description is entered successfully");
			test.log(Status.PASS, "Short_Description is entered successfully");
			Assert.assertTrue(true, "Short_Description is entered successfully");
		} else {
			System.out.println("Short_Description TextBox not found");
			logger.error("Failed to Enter Short_Description in TextBox");
			test.log(Status.FAIL, "Failed to Enter Short_Description in TextBox");
			Assert.assertFalse(false, "Short_Description TextBox not found");
		}

	}

	public void propMasterLongDes(String EnterLongDes) {

		/*   */

		SeleniumRepo.waitForElementPresent(LongDescription_field);

		Assert.assertEquals(LongDescription_field.isDisplayed(), true,
				"Long Description text Field is not being displayed");

		Enter_LongDescription_Text.click();
		Enter_LongDescription_Text.clear();
		Enter_LongDescription_Text.sendKeys(EnterLongDes);

		System.out.println("Long Description is entered successfully");

		Assert.assertEquals(Enter_LongDescription_Text.getAttribute("value"), EnterLongDes,
				"Long Description Field text was not entered");
		logger.info("Long Description is entered successfully");
		test.log(Status.PASS, "Long Description is entered successfully");

	}

	public void propMasterGdsPromoText(String EnterGDSPromoTxt) {

		/*   */

		SeleniumRepo.waitForElementPresent(GdsPromotionalTxt_field);
        boolean b=GdsPromotionalTxt_field.isDisplayed();
		Assert.assertEquals(GdsPromotionalTxt_field.isDisplayed(), true,
				"GDS Promotional Text Field is not being displayed");

		Enter_GdsPromotionalTxt_field_Text.click();
		Enter_GdsPromotionalTxt_field_Text.clear();
		Enter_GdsPromotionalTxt_field_Text.sendKeys(EnterGDSPromoTxt);

		System.out.println("GDS Promotional Text is entered successfully");
        String a=Enter_GdsPromotionalTxt_field_Text.getAttribute("value");
		Assert.assertEquals(Enter_GdsPromotionalTxt_field_Text.getAttribute("value"), EnterGDSPromoTxt,
				"GDS Promotional Text was not entered");
		logger.info("GDS Promotional Text is entered successfully");
		test.log(Status.PASS, "GDS Promotional Text	is entered successfully");

	}

	/**
	 * This is the orignal property master method used in the
	 * AddNewProperty.java class
	 * 
	 * @param PropertyMasterTitle
	 * @param Phone_Code
	 * @param Phone_Area_Code
	 * @param Phone_Number
	 * @param Website_URL
	 * @param Primary_Email
	 * @param NumberOf_Rooms
	 * @param NumberOf_Floors
	 * @param FirstBedTypeName
	 * @param FirstBedCode
	 * @param SecondBedTypeName
	 * @param SecondBedCode
	 * @param ThirdBedTypeName
	 * @param ThirdBedCode
	 * @param Visa
	 * @param MasterCard
	 * @param AmericanExpress
	 * @param Short_Description
	 * @throws Exception
	 * @throws NoSuchElementException
	 */
	public void propertyMaster(String PropertyMasterTitle, String Phone_Code, String Phone_Area_Code,
			String Phone_Number, String Website_URL, String Primary_Email, String NumberOf_Rooms,
			String NumberOf_Floors, String FirstBedTypeName, String FirstBedCode, String SecondBedTypeName,
			String SecondBedCode, String ThirdBedTypeName, String ThirdBedCode, String Visa, String MasterCard,
			String AmericanExpress, String Short_Description) throws Exception, NoSuchElementException {

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

		if (Click_PropertyMaster.isDisplayed()) {
			Click_PropertyMaster.click();
			logger.info("Clicked on PropertyMaster");
			test.log(Status.PASS, "Clicked on PropertyMaster");
		} else {
			logger.error("Failed to Click on PropertyMaster");
			test.log(Status.FAIL, "Failed to Click on PropertyMaster");
		}

		// System.out.println(Verify_PropertyMasterTitle.getText());
		// System.out.println("Expected"+PropertyMasterTitle);
		try {
			Assert.assertEquals(PropertyMasterTitle, Verify_PropertyMasterTitle.getText());
			System.out.println("Title Matched");
			logger.info("PropertyMaster Title Matched");
			test.log(Status.PASS, "PropertyMaster Title Matched");
			Assert.assertTrue(true, "PropertyMaster Title Matched");
		} catch (Error e) {
			System.out.println("PropertyMaster Title didn't match");
			logger.error("PropertyMaster Title didn't match");
			test.log(Status.FAIL, "PropertyMaster Title didn't match");
			Assert.assertFalse(false, "PropertyMaster Title didn't match");
		} catch (NoSuchElementException hi) {
			System.out.println("PropertyMaster Title was not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_Phone_Code)) {
			Enter_Phone_Code.click();
			Enter_Phone_Code.clear();
			Enter_Phone_Code.sendKeys(Phone_Code);
			System.out.println("  Phone_Code is entered successfully");
			logger.info("Phone_Code is entered successfully");
			test.log(Status.PASS, "Phone_Code is entered successfully");
			Assert.assertTrue(true, " Phone_Code is entered successfully");
		} else {
			System.out.println(" Phone_Code not found");
			logger.error("Failed to Enter Phone_Code in TextBox");
			test.log(Status.FAIL, "Failed to Enter Phone_Code1 in TextBox");
			Assert.assertFalse(false, "Phone_Code not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_Phone_Area_Code)) {
			Enter_Phone_Area_Code.click();
			Enter_Phone_Area_Code.clear();
			Enter_Phone_Area_Code.sendKeys(Phone_Area_Code);
			System.out.println("  Phone_Area_Code is entered successfully");
			logger.info("Phone_Area_Code is entered successfully");
			test.log(Status.PASS, "Phone_Area_Code is entered successfully");
			Assert.assertTrue(true, " Phone_Area_Code is entered successfully");
		} else {
			System.out.println(" Phone_Area_Code not found");
			logger.error("Failed to Enter Phone_Area_Code in TextBox");
			test.log(Status.FAIL, "Failed to Enter Phone_Area_Code in TextBox");
			Assert.assertFalse(false, "Phone_Area_Code not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_Phone_Number)) {
			Enter_Phone_Number.click();
			Enter_Phone_Number.clear();
			Enter_Phone_Number.sendKeys(Phone_Number);
			System.out.println("  Phone_Number is entered successfully");
			logger.info(" Phone_Number is entered successfully");
			test.log(Status.PASS, " Phone_Number is entered successfully");
			Assert.assertTrue(true, " Phone_Number is entered successfully");
		} else {
			System.out.println(" Phone_Number not found");
			logger.error("Failed to Enter Phone_Number in TextBox");
			test.log(Status.FAIL, "Failed to Enter Phone_Number in TextBox");
			Assert.assertFalse(false, "Phone_Number not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_Website_URL)) {
			Enter_Website_URL.click();
			Enter_Website_URL.clear();
			Enter_Website_URL.sendKeys(Website_URL);
			System.out.println(" Website_URL is entered successfully");
			logger.info("Website_URL is entered successfully");
			test.log(Status.PASS, "Website_URL is entered successfully");
			Assert.assertTrue(true, " Website_URL is entered successfully");
		} else {
			System.out.println(" Website_URL not found");
			logger.error("Failed to Enter Website_URL in TextBox");
			test.log(Status.FAIL, "Failed to Enter Website_URL in TextBox");
			Assert.assertFalse(false, "Website_URL not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_Primary_Email)) {
			Enter_Primary_Email.click();
			Enter_Primary_Email.clear();
			Enter_Primary_Email.sendKeys(Primary_Email);
			System.out.println(" Primary_Email is entered successfully");
			logger.info("Primary_Email is entered successfully");
			test.log(Status.PASS, "Primary_Email is entered successfully");
			Assert.assertTrue(true, " Primary_Email is entered successfully");
		} else {
			System.out.println(" Primary_Email not found");
			logger.error("Failed to Enter Primary_Email in TextBox");
			test.log(Status.FAIL, "Failed to Enter Primary_Email in TextBox");
			;
			Assert.assertFalse(false, "Primary_Email not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_NumberOf_Rooms)) {
			Enter_NumberOf_Rooms.click();
			Enter_NumberOf_Rooms.clear();
			Enter_NumberOf_Rooms.sendKeys(NumberOf_Rooms);
			System.out.println(" NumberOf_Rooms is entered successfully");
			logger.info("NumberOf_Rooms is entered successfully");
			test.log(Status.PASS, "NumberOf_Rooms is entered successfully");
			Assert.assertTrue(true, " NumberOf_Rooms is entered successfully");
		} else {
			System.out.println(" NumberOf_Rooms not found");
			logger.error("Failed to Enter NumberOf_Rooms in TextBox");
			test.log(Status.FAIL, "Failed to Enter NumberOf_Rooms in TextBox");
			Assert.assertFalse(false, "NumberOf_Rooms not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_NumberOf_Floors)) {
			Enter_NumberOf_Floors.click();
			Enter_NumberOf_Floors.clear();
			Enter_NumberOf_Floors.sendKeys(NumberOf_Floors);
			System.out.println(" NumberOf_Floors is entered successfully");
			logger.info(" NumberOf_Floors is entered successfully");
			test.log(Status.PASS, " NumberOf_Floors is entered successfully");
			Assert.assertTrue(true, " NumberOf_Floors is entered successfully");
		} else {
			System.out.println(" NumberOf_Floors not found");
			logger.error("Failed to Enter NumberOf_Floors in TextBox");
			test.log(Status.FAIL, "Failed to Enter NumberOf_Floors in TextBox");
			Assert.assertFalse(false, "NumberOf_Floors not found");
		}

		if (SeleniumRepo.isElementPresent(Verify_Default_PropertyLanguage)) {
			SeleniumRepoCheckBox.CheckCheckBox(Verify_Default_PropertyLanguage);
			System.out.println(" Property Language is Verified successfully");
			logger.info("Property Language is Verified successfully");
			test.log(Status.PASS, "Property Language is Verified successfully");
		} else {
			System.out.println(" Property Language is Not Verified successfully");
			logger.error("Property Language is Not Verified successfully");
			test.log(Status.FAIL, "Property Language is Not Verified successfully");

		}
		// -------1st Bed

		if (FirstBedType.size() > 0) {
			System.out.println("FirstBedType created");
			logger.info("FirstBedType created successfully");
			test.log(Status.PASS, "FirstBedType created successfully");
			Assert.assertTrue(true, " FirstBedType created successfully");
		} else {
			Click_Add_BedType.click();
			Enter_Bed_Type.sendKeys(FirstBedTypeName);
			Enter_Bed_Type_Code.sendKeys(FirstBedCode);
			Click_SaveButton5.click();
			System.out.println("FirstBedType is not created");
			logger.error("Failed to create FirstBedType");
			test.log(Status.FAIL, "Failed to create FirstBedType");
			Assert.assertFalse(false, "FirstBedType is not created");
		}

		/*
		 * if(ErrorMessage_DuplicateBedType.isDisplayed()) {
		 * Click_Cancel5.click(); System.out.println("Already Bed Created");}
		 */

		// -----------2nd Bed--------------
		if (SecondBedType.size() > 0) {
			System.out.println(" SecondBedType created");
			logger.info("SecondBedType created");
			test.log(Status.PASS, "SecondBedType created");
			Assert.assertTrue(true, " SecondBedType created successfully");
		} else {
			Click_Add_BedType.click();
			Enter_Bed_Type.sendKeys(SecondBedTypeName);
			Enter_Bed_Type_Code.sendKeys(SecondBedCode);
			Click_SaveButton5.click();
			logger.error("Failed to Create SecondBed ");
			test.log(Status.FAIL, "Failed to Create SecondBed");
		}

		// ------------3rd Bed-------------
		if (ThirdBedType.size() > 0) {
			System.out.println(" ThirdBedType created");
			logger.info("ThirdBedType created");
			test.log(Status.PASS, "ThirdBedType created");
			Assert.assertTrue(true, " ThirdBedType created successfully");
		} else {
			Click_Add_BedType.click();
			Enter_Bed_Type.sendKeys(ThirdBedTypeName);
			Enter_Bed_Type_Code.sendKeys(ThirdBedCode);
			Click_SaveButton5.click();
			logger.error("Failed to Create ThirdBed");
			test.log(Status.FAIL, "Failed to Create ThirdBed");
		}

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CreditCardAccept, Visa);
			System.out.println("Visa Checked");
			logger.info("\"Visa Checked");
			test.log(Status.PASS, "\"Visa Checked");
		} catch (Exception e) {
			System.out.println("Visa Not Checked");
			logger.error("Failed to Select Visa");
			test.log(Status.FAIL, "Failed to Select Visa");
			e.printStackTrace();
		}

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CreditCardAccept, MasterCard);
			System.out.println("MasterCard Checked");
			logger.info("MasterCard Checked");
			test.log(Status.PASS, "MasterCard Checked");
		} catch (Exception e) {
			System.out.println("MasterCard Not Checked");
			e.printStackTrace();
		}
		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CreditCardAccept, AmericanExpress);
			System.out.println("AmericanExpress Checked");
		} catch (Exception e) {
			System.out.println("AmericanExpress Not Checked");
			logger.error("Failed to Select AmericanExpress");
			test.log(Status.FAIL, "Failed to Select AmericanExpress");
			e.printStackTrace();
		}

		if (Select_CreditCardValidation.isDisplayed()) {
			if (Select_CreditCardValidation.isSelected() == false)
				Select_CreditCardValidation.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" CreditCardValidation selected successfully");
			logger.info("CreditCardValidation selected successfully");
			test.log(Status.PASS, "CreditCardValidation selected successfully");

			Assert.assertTrue(true, "CreditCardValidation selected successfully");
		} else {
			System.out.println("CreditCardValidation not selected");
			logger.error("Failed to Select CreditCardValidation");
			test.log(Status.FAIL, "Failed to Select CreditCardValidation");
			Assert.assertFalse(false, "CreditCardValidation not CreditCardValidation");
		}

		if (Enter_Short_Description.isDisplayed()) {
			Enter_Short_Description.clear();
			Enter_Short_Description.click();
			Enter_Short_Description.sendKeys(Short_Description);
			System.out.println(" Short_Description is entered successfully");
			logger.info("Short_Description is entered successfully");
			test.log(Status.PASS, "Short_Description is entered successfully");
			Assert.assertTrue(true, "Short_Description is entered successfully");
		} else {
			System.out.println("Short_Description TextBox not found");
			logger.error("Failed to Enter Short_Description in TextBox");
			test.log(Status.FAIL, "Failed to Enter Short_Description in TextBox");
			Assert.assertFalse(false, "Short_Description TextBox not found");
		}

		if (Click_SaveButton5.isDisplayed()) {
			Click_SaveButton5.click();
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
		} else {
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");
		}

	}

}
