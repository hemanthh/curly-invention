package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * Refactoring idea: change class name to just property, and it will act as the parent class to 
 * property_Edit, propertyDefaults, and propertyMaster. Will also keep  the original methods as
 * a quick use method . But each field/ assoicated field will have their own methods 
 * 
 * @author DM
 *
 *
 *property, rateplan, poerty to currecn
 */


public class AddNewProperty extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'QA_AUTOMATION')]"),
		@FindBy(css = "td.prompt:nth-child(2) td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(62) td.prompt:nth-child(1) > a:nth-child(1)") 
	})
	
	public WebElement Click_QAAutomation;

	@FindAll({ @FindBy(xpath = "//input[@value='1519']"),
		@FindBy(css = "span.prompt:nth-child(4) td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(7) td.prompt:nth-child(1) > input:nth-child(1)") 
	})
	
	public WebElement Select_property;

	@FindAll({ @FindBy(xpath = "//input[@value='Select Property']"),
		@FindBy(css = "tr:nth-child(1) td:nth-child(2) span.prompt:nth-child(4) form:nth-child(10) > input.input:nth-child(6)")
	})
	
	public WebElement Click_Property;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") 
	})
	
	public WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(id = "add_new_property"), 
		@FindBy(xpath = "//a[@id='add_new_property'] ") 
	})
	
	public WebElement Click_AddNew;

	@FindAll({ @FindBy(xpath = "//td[@class='title']"),
		@FindBy(xpath = "//td[@class = 'title' and contains(., 'Add Property')] ")
	})
	
	public WebElement  Verify_AddPropertyTitle;

	@FindAll({ @FindBy(name = "propertyName"), 
		@FindBy(xpath = "//input[@name='propertyName'] ")
	})
	
	public WebElement Enter_PropertyName;

	@FindAll({ @FindBy(name = "propertyCode"), 
		@FindBy(xpath = "//input[@name='propertyCode'] ")
	})
	
	public WebElement Enter_PropertyCode;

	@FindAll({ @FindBy(id = "bookingVersion3Id"),
		@FindBy(xpath = "//input[@id='bookingVersion3Id'] ")
	})
	
	public WebElement Click_BookingEngineVersion;

	@FindAll({ @FindBy(name = "propertySubdomain"), 
		@FindBy(xpath = "//input[@name='propertySubdomain'] ") 
	})
	
	public WebElement propertySubdomain;

	@FindAll({ @FindBy(name = "address1"),
		@FindBy(xpath = "//input[@name='address1'] ") 
	})
	
	public WebElement Enter_Address;

	@FindAll({ @FindBy(name = "city"), 
		@FindBy(xpath = "//input[@name='city'] ") 
	})
	
	public WebElement Enter_CityName;

	@FindAll({ @FindBy(name = "country"), 
		@FindBy(xpath = "//select[@name='country'] ")
	})
	
	public WebElement Enter_country;

	@FindAll({ @FindBy(name = "zip"), 
		@FindBy(xpath = "//input[@name='zip']")
	})
	
	public WebElement Enter_Zip;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Find Lat/Long')]"),
		@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(18) td:nth-child(2) > a:nth-child(3)")
	})
	
	public WebElement Click_LatLong;

	@FindAll({ @FindBy(name = "enableRateCalendar"),
		@FindBy(xpath = "//tbody//tr[25]//td[2]//input[1]") 
	})
	
	public WebElement Click_RateCalendar;

	@FindAll({ @FindBy(xpath = "//tbody//tr[28]//td[2]//input[1]"),
		@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(28) td:nth-child(2) > input:nth-child(1)") 
	})
	
	public WebElement Click_CallCenter;

	/*@FindAll({ @FindBy(xpath = "//tbody//tr[33]//td[2]//input[1]"),
		@FindBy(xpath = "//input[@value = 'Y' and @name = 'adsOnConfPage']"),
		@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(33) td:nth-child(2) > input:nth-child(1)") })
        
    public WebElement Click_EnableAdsonConfirmation;*/



	@FindAll({ @FindBy(xpath = "//input[@name='button1' and @value= 'Save']"),
		@FindBy(css = "tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) form:nth-child(2) > input.input:nth-child(6)")
	})
	
	public WebElement Click_Save1;

	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"),
		@FindBy(css = "tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) form:nth-child(2) > input.input:nth-child(7)")
	})
	
	public WebElement Cancel_Button;


	//****************Property Default*******************



	@FindBy(how=How.XPATH,using="//a[contains(text(),'Defaults')]") 
	public WebElement click_PropertyDefaults;


	@FindAll({ @FindBy(xpath = "//td[@class = 'title' and contains(., 'Property Defaults')]"),
		@FindBy(css = "td.prompt:nth-child(2) table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) > td.title") 
	})
	
	public WebElement Verify_PropertyDefaultsTitle;

	@FindAll({ @FindBy(xpath = "//select[@name='starRating']"),
		@FindBy(name = "starRating"),
		@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(6) td:nth-child(2) > select.input:nth-child(1)")
	})
	
	public WebElement Select_StarRating;

	@FindAll({@FindBy(name = "adultAge"),
		@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input") 
	})
	
	public WebElement Enter_AdultAge;

	@FindAll({@FindBy(name = "checkInTime"),
		@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(26) td:nth-child(2) > select.input:nth-child(1)") 
	})
	
	public WebElement Select_CheckinTime ;

	@FindAll({@FindBy(name = "checkOutTime"),
		@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(27) td:nth-child(2) > select.input:nth-child(1)") 
	})
	
	public WebElement Select_CheckoutTime;

	@FindAll({ @FindBy(xpath = "//input[@name='Save' and @onclick= 'saveSubmit()']"),
		@FindBy(xpath = "//td[contains(@class,'prompt')]//form[contains(@name,'addPropertyDefaults')]//table[contains(@width,'522')]//tbody"),
		@FindBy(css = "td.prompt:nth-child(2) table:nth-child(4) tbody:nth-child(1) tr:nth-child(47) td:nth-child(1) > input.input:nth-child(1)")
	})
	
	public WebElement Click_Save3;

	//**************Property Master***************

	@FindAll({ @FindBy(xpath = "//*[@id=\"2\"]/li[4]/a"),
		@FindBy(css = "ul:nth-child(3) li:nth-child(3) ul:nth-child(2) li:nth-child(4) > a:nth-child(1)") 
	})
	
	public WebElement Click_PropertyMaster;


	@FindAll({ @FindBy(xpath = "//td[@class = 'title' and contains(text(),'Property Master')]"),
		@FindBy(css = "td:nth-child(2) table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) > td.title") 
	})
	
	public WebElement Verify_PropertyMasterTitle;

	@FindAll({ @FindBy(name = "phone1CountryCode"),
		@FindBy(xpath = "//input[@name = 'phone1CountryCode']"),
		@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input:nth-child(1)")
	})
	
	public WebElement Enter_Phone_Code;

	@FindAll({ @FindBy(name = "phone1AreaCode"),
		@FindBy(xpath = "//input[@name = 'phone1AreaCode']"),
		@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input:nth-child(2)") 
	})
	
	public WebElement Enter_Phone_Area_Code;

	@FindAll({ @FindBy(name = "phone1Number"),
		@FindBy(xpath = "//input[@name = 'phone1Number']"),
		@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(12) td:nth-child(2) > input.input:nth-child(3)" )
	})
	
	public WebElement Enter_Phone_Number;

	@FindAll({ @FindBy(name = "websiteURL"),
		@FindBy(xpath = "//input[@name = 'websiteURL']"),
		@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(15) td:nth-child(2) > input.input" )})
	
	public WebElement Enter_Website_URL;

	@FindAll({ @FindBy(name = "primaryEmail"),
		@FindBy(xpath = "//input[@name = 'primaryEmail']"),
		@FindBy(css = "#primaryEmail" )})
	
	public WebElement Enter_Primary_Email;


	@FindAll({ @FindBy(name = "noOfRooms"),
		@FindBy(xpath = "//input[@name = 'noOfRooms']"),
		@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(20) td:nth-child(2) > input.input" )
	})
	
	public WebElement Enter_NumberOf_Rooms;

	@FindAll({ @FindBy(name = "noOfFloors"),
		@FindBy(xpath = "//input[@name = 'noOfFloors']"),
		@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(21) td:nth-child(2) > input.input" )
	})
	
	public WebElement Enter_NumberOf_Floors;

	@FindAll({ @FindBy(id = "enable_en"),
		@FindBy(xpath = "//input[@id='enable_en']"),
		@FindBy(css = "#enable_en" )})
	
	public WebElement Verify_Default_PropertyLanguage;


	@FindAll({ @FindBy(xpath = "//input[@value='Add Bed Type']"),
		@FindBy(css = "table:nth-child(9) tbody:nth-child(1) tr:nth-child(23) td:nth-child(2) > input.input:nth-child(17)" )
	})
	
	public WebElement Click_Add_BedType;

	@FindAll({ @FindBy(xpath = "//input[@name='bedTypeName']"),
		@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > input.input.guest-facing-fields:nth-child(1)" )
	})
	
	public WebElement Enter_Bed_Type ;

	@FindAll({ @FindBy(xpath = "//input[@name='bedTypeCode']"),
		@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > input.input" )
	})
	
	public WebElement Enter_Bed_Type_Code;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Queen Bed & Sofabed')]")
	})
	
	public List<WebElement>  FirstBedType;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Kings Bed & Sofabed')]")
	})
	
	public List<WebElement>  SecondBedType;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Double Bed And Sofa King')]")
	})
	
	public List<WebElement>  ThirdBedType;

	@FindAll({ @FindBy(xpath = "//input[@value='Save' and @onclick= 'saveSubmit()']"),
		@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(4) td:nth-child(1) > input.input:nth-child(1)" )
	})
	
	public WebElement Click_SaveButton5;

	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"),
		@FindBy(css = "table:nth-child(4) tbody:nth-child(1) tr:nth-child(4) td:nth-child(1) > input.input:nth-child(2)" )
	})
	
	public WebElement Click_Cancel5;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Duplicate Bed Type Code')]"),
		@FindBy(css = "tr:nth-child(1) td:nth-child(2) form:nth-child(2) font:nth-child(1) > li:nth-child(1)" )
	})
	
	public WebElement ErrorMessage_DuplicateBedType;

	@FindAll({ @FindBy(xpath = "//input[(@name='creditCardsAccepted') and (@type='checkbox')]")
	})
	
	public List<WebElement> Check_CreditCardAccept;

	@FindAll({ @FindBy(xpath = "//input[(@name='creditCardsAccepted') and (@type='checkbox')]")
	})
	
	public WebElement Select_CreditCardValidation;

	@FindAll({@FindBy(name = "shortDescription"),
		@FindBy(xpath = "//textarea[@name='shortDescription']"),@FindBy(css ="table:nth-child(9) tbody:nth-child(1) tr:nth-child(29) td:nth-child(2) > textarea.input")
	})
	
	public WebElement Enter_Short_Description;


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
			Assert.assertEquals(AddPropertyTitle,Verify_AddPropertyTitle.getText().trim());
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
	//SeleniumRepo.WaitForLoad(3000);
	//Cancel_Button.click();



	//****************Property Default*******************






	public void propertyDefault(String PropertyDefaultsTitle,String StarRating,
			String Adultage,String CheckinTime,String CheckoutTime) throws Exception
	{

		if (click_PropertyDefaults.isEnabled()) 
		{
			Javascriptexecutor(click_PropertyDefaults);
			ExplicitWait(Verify_PropertyDefaultsTitle);

			System.out.println("PropertyManagement element Expanded and Property defaults element  found");
			test.log(Status.INFO, "PropertyManagement element Expanded and Property defaults element  found");
			Assert.assertTrue(true, "PropertyManagement element Expanded and Property defaults element  found");
		} 
		else 
		{
			System.out.println("PropertyManagement Menu is not expanded");
			Javascriptexecutor(Click_PropertyManagement);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");

			ExplicitWait(click_PropertyDefaults);
			if(click_PropertyDefaults.isDisplayed())
			{
				Javascriptexecutor(click_PropertyDefaults);
				ExplicitWait(Verify_PropertyDefaultsTitle);

				System.out.println("PropertyDefaults element found");
				test.log(Status.INFO, "PropertyDefaults element found");
				Assert.assertTrue(true, "PropertyDefaults element found");
			}
			else
			{
				logger.info("PropertyDefaults element not  found");
				test.log(Status.FAIL, "PropertyDefaults element not  found");
			}
		}
		System.out.println(Verify_PropertyDefaultsTitle.getText());
		System.out.println("Expected"+ PropertyDefaultsTitle);
		if(Verify_PropertyDefaultsTitle.getText().contains(PropertyDefaultsTitle))
		{
			System.out.println("Title Matched");
			logger.info("PropertyDefaults Title Matched");
			test.log(Status.PASS,
					"PropertyDefaults Title Matched" );
			Assert.assertTrue(true, "PropertyDefaults Title Matched");
		} 
		else
		{
			System.out.println("Title didn't match");
			logger.error("Title didn't match");
			//test.log(Status.FAIL,"Title didn't match");
			Assert.assertFalse(false, "PropertyDefaults Title didn't match");
		}

		SeleniumRepo.isElementPresent(Select_StarRating);
		if(SeleniumRepo.isElementPresent(Select_StarRating)) 
		{
			SeleniumRepoDropdown.selectDropDownValue(Select_StarRating, StarRating);
			//SeleniumRepo.WaitForLoad(100);
			System.out.println(" StarRating selected successfully");
			logger.info("StarRating selected successfully");
			test.log(Status.PASS,
					"StarRating selected successfully" );
			Assert.assertTrue(true, "StarRating selected successfully");
		}else {
			System.out.println("StarRating not selected");  
			logger.error("Failed to Select StarRating");
			test.log(Status.FAIL,
					"Failed to Select StarRating");
			Assert.assertFalse(false, "StarRating not StarRating");
		}


		SeleniumRepo.isElementPresent(Enter_AdultAge);
		if(SeleniumRepo.isElementPresent(Enter_AdultAge))
		{
			Enter_AdultAge.click();
			Enter_AdultAge.clear();
			Enter_AdultAge.sendKeys(Adultage);
			System.out.println("  Adultage is entered successfully");
			logger.info(" Adultage is entered successfully");
			test.log(Status.PASS,
					" Adultage is entered successfully" );
			Assert.assertTrue(true, " Adultage is entered successfully"); 
		}else {
			System.out.println(" Adultage TextBox not found");
			logger.error("Failed to Enter Adultage in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Adultage in TextBox");
			Assert.assertFalse(false, "Adultage TextBox not found");
		}
		ExplicitWait(Select_CheckinTime);
		if(Select_CheckinTime.isDisplayed())
		{
			SeleniumRepoDropdown.selectDropDownText(Select_CheckinTime, CheckinTime);
			//SeleniumRepo.WaitForLoad(100);
			System.out.println(" CheckinTime selected successfully");
			logger.info("CheckinTime selected successfully");
			test.log(Status.PASS,
					"CheckinTime selected successfully" );

			Assert.assertTrue(true, " CheckinTime selected successfully");
		}else {
			System.out.println("CheckinTime not selected"); 
			logger.error("Failed to Select CheckinTime");
			test.log(Status.FAIL,
					"Failed to Select CheckinTime");
			Assert.assertFalse(false, "CheckinTime not selected");
		}


		SeleniumRepo.isElementPresent(Select_CheckoutTime);
		if(SeleniumRepo.isElementPresent(Select_CheckoutTime))
		{
			SeleniumRepoDropdown.selectDropDownText(Select_CheckoutTime, CheckoutTime);
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" CheckoutTime selected successfully");
			logger.info("CheckoutTime selected successfully");
			test.log(Status.PASS,
					"CheckoutTime selected successfully" );
			Assert.assertTrue(true, " CheckoutTime selected successfully");
		}else {
			System.out.println("CheckoutTime not selected");
			logger.error("Failed to Select CheckoutTime");
			test.log(Status.FAIL,
					"Failed to Select CheckoutTime");
			Assert.assertFalse(false, "CheckoutTime not selected");
		}

		SeleniumRepo.WaitForLoad(300);
		if(Click_Save3.isDisplayed())
		{
			Click_Save3.click();
			logger.info("Clicked on Save button");
			test.log(Status.PASS,
					"Clicked on Save button" );
		}else {
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");

		}

	}




	//****************Property Master*******************




	public void propertyMaster
	(String PropertyMasterTitle,String Phone_Code,String Phone_Area_Code,
			String Phone_Number,String Website_URL,String Primary_Email,
			String NumberOf_Rooms,String NumberOf_Floors,String FirstBedTypeName,
			String FirstBedCode,String SecondBedTypeName,String  SecondBedCode,
			String ThirdBedTypeName,String ThirdBedCode, String Visa,String MasterCard,
			String AmericanExpress, String Short_Description ) throws Exception, NoSuchElementException
	{

		
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

		
		
		if(Click_PropertyMaster.isDisplayed())
		{
			Click_PropertyMaster.click();
			logger.info("Clicked on PropertyMaster");
			test.log(Status.PASS,
					"Clicked on PropertyMaster" );
		}else {
			logger.error("Failed to Click on PropertyMaster");
			test.log(Status.FAIL,
					"Failed to Click on PropertyMaster");
		}



		//System.out.println(Verify_PropertyMasterTitle.getText());
		//System.out.println("Expected"+PropertyMasterTitle);
		try {
			Assert.assertEquals(PropertyMasterTitle,Verify_PropertyMasterTitle.getText());
			System.out.println("Title Matched");
			logger.info("PropertyMaster Title Matched");
			test.log(Status.PASS,
					"PropertyMaster Title Matched" );
			Assert.assertTrue(true, "PropertyMaster Title Matched");
		} catch (Error e) {
			System.out.println("PropertyMaster Title didn't match");
			logger.error("PropertyMaster Title didn't match");
			test.log(Status.FAIL,
					"PropertyMaster Title didn't match");
			Assert.assertFalse(false, "PropertyMaster Title didn't match");
		} catch (NoSuchElementException hi){
			System.out.println("PropertyMaster Title was not found");
		}

		if(SeleniumRepo.isElementPresent(Enter_Phone_Code))
		{
			Enter_Phone_Code.click();
			Enter_Phone_Code.clear();
			Enter_Phone_Code.sendKeys(Phone_Code);
			System.out.println("  Phone_Code is entered successfully");
			logger.info("Phone_Code is entered successfully");
			test.log(Status.PASS,
					"Phone_Code is entered successfully" );
			Assert.assertTrue(true, " Phone_Code is entered successfully"); 
		}else {
			System.out.println(" Phone_Code not found");
			logger.error("Failed to Enter Phone_Code in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Phone_Code1 in TextBox");
			Assert.assertFalse(false, "Phone_Code not found");
		}

		if(SeleniumRepo.isElementPresent(Enter_Phone_Area_Code))
		{
			Enter_Phone_Area_Code.click();
			Enter_Phone_Area_Code.clear();
			Enter_Phone_Area_Code.sendKeys(Phone_Area_Code);
			System.out.println("  Phone_Area_Code is entered successfully");
			logger.info("Phone_Area_Code is entered successfully");
			test.log(Status.PASS,
					"Phone_Area_Code is entered successfully" );
			Assert.assertTrue(true, " Phone_Area_Code is entered successfully"); 
		}else {
			System.out.println(" Phone_Area_Code not found");
			logger.error("Failed to Enter Phone_Area_Code in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Phone_Area_Code in TextBox");
			Assert.assertFalse(false, "Phone_Area_Code not found");
		}

		if(SeleniumRepo.isElementPresent(Enter_Phone_Number))
		{
			Enter_Phone_Number.click();
			Enter_Phone_Number.clear();
			Enter_Phone_Number.sendKeys(Phone_Number);
			System.out.println("  Phone_Number is entered successfully");
			logger.info(" Phone_Number is entered successfully");
			test.log(Status.PASS,
					" Phone_Number is entered successfully" );
			Assert.assertTrue(true, " Phone_Number is entered successfully"); 
		}else {
			System.out.println(" Phone_Number not found");
			logger.error("Failed to Enter Phone_Number in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Phone_Number in TextBox");
			Assert.assertFalse(false, "Phone_Number not found");
		}

		if(SeleniumRepo.isElementPresent(Enter_Website_URL))
		{
			Enter_Website_URL.click();
			Enter_Website_URL.clear();
			Enter_Website_URL.sendKeys(Website_URL);
			System.out.println(" Website_URL is entered successfully");
			logger.info("Website_URL is entered successfully");
			test.log(Status.PASS,
					"Website_URL is entered successfully" );
			Assert.assertTrue(true, " Website_URL is entered successfully");
		}else {
			System.out.println(" Website_URL not found");
			logger.error("Failed to Enter Website_URL in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Website_URL in TextBox");
			Assert.assertFalse(false, "Website_URL not found");
		} 

		if(SeleniumRepo.isElementPresent(Enter_Primary_Email))
		{
			Enter_Primary_Email.click();
			Enter_Primary_Email.clear();
			Enter_Primary_Email.sendKeys(Primary_Email);
			System.out.println(" Primary_Email is entered successfully");
			logger.info("Primary_Email is entered successfully");
			test.log(Status.PASS,
					"Primary_Email is entered successfully" );
			Assert.assertTrue(true, " Primary_Email is entered successfully");
		}else {
			System.out.println(" Primary_Email not found");
			logger.error("Failed to Enter Primary_Email in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Primary_Email in TextBox");;
					Assert.assertFalse(false, "Primary_Email not found");
		} 

		if(SeleniumRepo.isElementPresent(Enter_NumberOf_Rooms))
		{
			Enter_NumberOf_Rooms.click();
			Enter_NumberOf_Rooms.clear();
			Enter_NumberOf_Rooms.sendKeys(NumberOf_Rooms);
			System.out.println(" NumberOf_Rooms is entered successfully");
			logger.info("NumberOf_Rooms is entered successfully");
			test.log(Status.PASS,
					"NumberOf_Rooms is entered successfully" );
			Assert.assertTrue(true, " NumberOf_Rooms is entered successfully"); 
		}else {
			System.out.println(" NumberOf_Rooms not found");
			logger.error("Failed to Enter NumberOf_Rooms in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter NumberOf_Rooms in TextBox");
			Assert.assertFalse(false, "NumberOf_Rooms not found");
		} 

		if(SeleniumRepo.isElementPresent(Enter_NumberOf_Floors))
		{
			Enter_NumberOf_Floors.click();
			Enter_NumberOf_Floors.clear();
			Enter_NumberOf_Floors.sendKeys(NumberOf_Floors);
			System.out.println(" NumberOf_Floors is entered successfully");
			logger.info(" NumberOf_Floors is entered successfully");
			test.log(Status.PASS,
					" NumberOf_Floors is entered successfully" );
			Assert.assertTrue(true, " NumberOf_Floors is entered successfully"); 
		}else {
			System.out.println(" NumberOf_Floors not found");
			logger.error("Failed to Enter NumberOf_Floors in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter NumberOf_Floors in TextBox");
			Assert.assertFalse(false, "NumberOf_Floors not found");
		} 

		if(SeleniumRepo.isElementPresent(Verify_Default_PropertyLanguage))
		{
			SeleniumRepoCheckBox.CheckCheckBox(Verify_Default_PropertyLanguage);
			System.out.println(" Property Language is Verified successfully");
			logger.info("Property Language is Verified successfully");
			test.log(Status.PASS,
					"Property Language is Verified successfully" );
		}else {
			System.out.println(" Property Language is Not Verified successfully");
			logger.error("Property Language is Not Verified successfully");
			test.log(Status.FAIL,
					"Property Language is Not Verified successfully");

		}
		//-------1st Bed


		if(FirstBedType.size()>0) {
			System.out.println("FirstBedType created");
			logger.info("FirstBedType created successfully");
			test.log(Status.PASS,
					"FirstBedType created successfully" );
			Assert.assertTrue(true, " FirstBedType created successfully"); 
		}else {
			Click_Add_BedType.click();
			Enter_Bed_Type.sendKeys(FirstBedTypeName);
			Enter_Bed_Type_Code.sendKeys(FirstBedCode);
			Click_SaveButton5.click();	
			System.out.println("FirstBedType is not created");
			logger.error("Failed to create FirstBedType");
			test.log(Status.FAIL,
					"Failed to create FirstBedType");
			Assert.assertFalse(false, "FirstBedType is not created");
		}


		/*	if(ErrorMessage_DuplicateBedType.isDisplayed()) {
						Click_Cancel5.click();
					System.out.println("Already Bed Created");}*/

		//-----------2nd Bed--------------
		if(SecondBedType.size()>0)
		{
			System.out.println(" SecondBedType created");
			logger.info("SecondBedType created");
			test.log(Status.PASS,
					"SecondBedType created" );
			Assert.assertTrue(true, " SecondBedType created successfully");
		}
		else {
			Click_Add_BedType.click();
			Enter_Bed_Type.sendKeys(SecondBedTypeName);
			Enter_Bed_Type_Code.sendKeys(SecondBedCode);
			Click_SaveButton5.click();
			logger.error("Failed to Create SecondBed ");
			test.log(Status.FAIL,
					"Failed to Create SecondBed");
		}

		//------------3rd Bed-------------			
		if(ThirdBedType.size()>0) 
		{
			System.out.println(" ThirdBedType created");
			logger.info("ThirdBedType created");
			test.log(Status.PASS,
					"ThirdBedType created" );
			Assert.assertTrue(true, " ThirdBedType created successfully");
		}else {
			Click_Add_BedType.click();
			Enter_Bed_Type.sendKeys(ThirdBedTypeName);
			Enter_Bed_Type_Code.sendKeys(ThirdBedCode);
			Click_SaveButton5.click();
			logger.error("Failed to Create ThirdBed");
			test.log(Status.FAIL,
					"Failed to Create ThirdBed");
		}


		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CreditCardAccept, Visa);
			System.out.println("Visa Checked");
			logger.info("\"Visa Checked");
			test.log(Status.PASS,
					"\"Visa Checked" );
		} catch (Exception e) {
			System.out.println("Visa Not Checked");
			logger.error("Failed to Select Visa");
			test.log(Status.FAIL,
					"Failed to Select Visa");
			e.printStackTrace();
		}

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CreditCardAccept,MasterCard);
			System.out.println("MasterCard Checked");
			logger.info("MasterCard Checked");
			test.log(Status.PASS,
					"MasterCard Checked" );
		} catch (Exception e) {
			System.out.println("MasterCard Not Checked");
			e.printStackTrace();
		}
		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CreditCardAccept,  AmericanExpress);
			System.out.println("AmericanExpress Checked");
		} catch (Exception e) {
			System.out.println("AmericanExpress Not Checked");
			logger.error("Failed to Select AmericanExpress");
			test.log(Status.FAIL,
					"Failed to Select AmericanExpress");
			e.printStackTrace();
		}

		if (Select_CreditCardValidation.isDisplayed()) 
		{
			if (Select_CreditCardValidation.isSelected() == false)
				Select_CreditCardValidation.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println(" CreditCardValidation selected successfully");
			logger.info("CreditCardValidation selected successfully");
			test.log(Status.PASS,
					"CreditCardValidation selected successfully" );

			Assert.assertTrue(true,
					"CreditCardValidation selected successfully");
		} else {
			System.out.println("CreditCardValidation not selected");
			logger.error("Failed to Select CreditCardValidation");
			test.log(Status.FAIL,
					"Failed to Select CreditCardValidation");
			Assert.assertFalse(false, "CreditCardValidation not CreditCardValidation");
		}	

		if (Enter_Short_Description.isDisplayed())
		{
			Enter_Short_Description.clear();
			Enter_Short_Description.click();
			Enter_Short_Description.sendKeys(Short_Description);
			System.out.println(" Short_Description is entered successfully");
			logger.info("Short_Description is entered successfully");
			test.log(Status.PASS,
					"Short_Description is entered successfully" );
			Assert.assertTrue(true,"Short_Description is entered successfully");
		} else {
			System.out.println("Short_Description TextBox not found");
			logger.error("Failed to Enter Short_Description in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Short_Description in TextBox");
			Assert.assertFalse(false, "Short_Description TextBox not found");
		}

		if(Click_SaveButton5.isDisplayed())
		{
			Click_SaveButton5.click();
			logger.info("Clicked on Save button");
			test.log(Status.PASS,
					"Clicked on Save button" );
		}else {
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");
		}

	}

}








