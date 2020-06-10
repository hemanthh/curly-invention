package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * The Channels page is consider as the Old TT connect Framework for  PMS, GDS setup pages
 * 
 * Interfaces[NEW] Is consider the new TT connect Framework
 * 
 * 
 * TODO: Create Setup methods for old framework's PMS enabling on Property Defaults page 
 * 
 * 
 * @author TT072 This test case creates channel for selected property by taking
 *         hotel code values from CSV file
 */
public class ChannelCreation extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//*[@name='propChannels']"), })
	public List<WebElement> All_exisiting_channelGroups;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'GDS')]"), })
	private WebElement existing_GDS_Channelgroup;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'PMS')]"), })
	private WebElement existing_PMS_Channelgroup;

	@FindAll({ @FindBy(linkText = "Channels"), @FindBy(xpath = "//a[contains(text(),'Channels')]"), })
	private WebElement channels_link;

	@FindAll({ @FindBy(xpath = "//*[@class='title']"), })
	private WebElement Channels_Pg_title;

	@FindAll({ @FindBy(xpath = "//table/tbody/tr[2]/td[2]"), })
	private WebElement ChannelGroup_Table_Row1_Name;

	@FindAll({ @FindBy(xpath = "//table/tbody/tr[3]/td[2]"), })
	private WebElement ChannelGroup_Table_Row2_Name;

	@FindAll({ @FindBy(xpath = "//table/tbody/tr[2]/td[4]/a"), })
	private WebElement ChannelGroup_Table_Row1_SettingsLink;

	@FindAll({ @FindBy(xpath = "//table/tbody/tr[3]/td[4]/a"), })
	private WebElement ChannelGroup_Table_Row2_SettingsLink;

	@FindAll({ @FindBy(linkText = "Add New Channel Group"),
			@FindBy(xpath = "//a[contains(text(),'Add New Channel Group')]"), })
	private WebElement addNew_Channel_link;

	@FindAll({ @FindBy(xpath = "//*[@name='delete' and @value='Delete']") })
	private WebElement Channel_ListAllPage__DeleteButton;

	@FindAll({ @FindBy(id = "groupList"), @FindBy(xpath = "//select[@id='groupList']"), })
	private WebElement Channel_Group;
	
	
	@FindAll({ @FindBy(xpath = "//*[@class='title']"), })
	private WebElement PMS_Channels_Page_Header;
	
	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Add New Channel')]"), })
	private WebElement PMS_Add_New_Channel_Link;
	
	
	//TODO: finish up crating vairables for the PMS creation page. Then
	//Create the methods
	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Channel Group')]") })
	public WebElement PMS_ChannelGroup_Field;
	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Channel Type')]") })
	public WebElement PMS_ChannelType_Field;
	
	@FindAll({ @FindBy(xpath = "//select[@name='channelType']") })
	public WebElement PMS_ChannelType_DropDown;
	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Status')]") })
	public WebElement PMS_Status_Field;
	
	@FindAll({ @FindBy(xpath = "//select[@name='status']") })
	public WebElement PMS_Status_DropDown;
	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'External Server URI')]") })
	public WebElement PMS_ExternalServerURI_Field;
	
	@FindAll({ @FindBy(xpath = "//input[@name='requestUri']") })
	private WebElement PMS_ExternalServerURI_Input;
	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Retry Interval')]") })
	public WebElement PMS_RetryInterval_Field;
	
	@FindAll({ @FindBy(xpath = "//input[@name='retryInterval']") })
	private WebElement PMS_RetryInterval_Input;
	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Max Retry Count')]") })
	public WebElement PMS_MaxRetryCount_Field;
	
	@FindAll({ @FindBy(xpath = "//input[@name='maxRetryCount']") })
	public WebElement PMS_MaxRetryCount_Input;

	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Status')]") })
	public WebElement GDS_Status_Field;
	
	@FindAll({ @FindBy(xpath = "//select[@name='status']") })
	public WebElement GDS_Status_DropDown;
	
	
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Chain Code')]") })
	public WebElement GDS_ChainCode_Field;
	
	@FindAll({ @FindBy(xpath = "//select[@name='channelCode']") })
	public WebElement GDS_ChainCode_DropDown;

	@FindAll({ @FindBy(xpath = "//input[@value='Sabre']") })
	private WebElement Sabre_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='Galileo']") })
	private WebElement Galileo_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='Worldspan']") })
	private WebElement Worldspan_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='Amadeus']") })
	private WebElement Amadeus_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='ADS']") })
	private WebElement ADS_Channel_Type;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[0].value"),
			@FindBy(xpath = "//input[@name='channelTypeHotelCode[0].value']") })
	private WebElement Sabre_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[1].value"),
			@FindBy(xpath = "//input[@name='channelTypeHotelCode[1].value']") })
	private WebElement Galileo_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[2].value"),
			@FindBy(xpath = "//input[@name='channelTypeHotelCode[2].value']") })
	private WebElement Worldspan_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[3].value"),
			@FindBy(xpath = "//input[@name='channelTypeHotelCode[3].value']") })
	private WebElement Amadeus_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[4].value"),
			@FindBy(xpath = "//input[@name='channelTypeHotelCode[4].value']") })
	private WebElement ADS_Hotel_Code;

	@FindAll({ @FindBy(name = "name=Submit"), @FindBy(xpath = "//input[@name='Submit']") })
	private WebElement gds_submit_button;

	@FindAll({ @FindBy(xpath = "//input[@value='Submit']") })
	private WebElement pms_submit_button;
	
	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']") })
	private WebElement gds_cancel_button;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	private WebElement Click_PropertyManagement;

	public void navigateToChannels_Pg() {

		try {
			if (channels_link.isDisplayed()) {
				Javascriptexecutor(channels_link);

				SeleniumRepo.waitForPageLoaded();

				ExplicitWait(addNew_Channel_link);
				System.out.println("PropertyManagement element Expanded and channels_link element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and channels_link element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and channels_link element  found");
			} else {
				System.out.println("PropertyManagement Menu is not expanded");
				SeleniumRepo.scrollintoview(Click_PropertyManagement);
				Thread.sleep(2000);
				Javascriptexecutor(Click_PropertyManagement);
				Thread.sleep(2000);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(channels_link);
				if (channels_link.isDisplayed()) {
					Javascriptexecutor(channels_link);

					SeleniumRepo.waitForPageLoaded();

					ExplicitWait(addNew_Channel_link);
					System.out.println("channels element found");
					test.log(Status.INFO, "channels element found");
					Assert.assertTrue(true, "channels element found");
				} else {
					logger.info("channels element not  found");
					test.log(Status.FAIL, "channels element not  found");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void navigateToAddNewChannelGroup_PG() {

		if ((SeleniumRepo.isElementDisplayed(Channels_Pg_title) == true)
				&& (SeleniumRepo.isElementDisplayed(addNew_Channel_link) == true)) {

			addNew_Channel_link.click();

			SeleniumRepo.waitForPageLoaded();

		} else {

			navigateToChannels_Pg();

			SeleniumRepo.waitForPageLoaded();

			addNew_Channel_link.click();

			SeleniumRepo.waitForPageLoaded();

		}

	}

	public void navigateToPmsChannelGroupSettingsPg() {

		try {

			if ((SeleniumRepo.isElementPresent(existing_PMS_Channelgroup) == true)
					& (All_exisiting_channelGroups.size() == 1)) {
				Javascriptexecutor(ChannelGroup_Table_Row1_SettingsLink);

				Thread.sleep(2000);

			} else if ((SeleniumRepo.isElementPresent(existing_PMS_Channelgroup) == true)
					& (All_exisiting_channelGroups.size() > 1)) {

				if (existing_PMS_Channelgroup.getText().trim().equals(ChannelGroup_Table_Row1_Name.getText().trim())) {

					Javascriptexecutor(ChannelGroup_Table_Row1_SettingsLink);
					Thread.sleep(2000);

				} else {

					Javascriptexecutor(ChannelGroup_Table_Row2_SettingsLink);
					Thread.sleep(2000);

				}

			}

		} catch (Exception e) {

			logger.error("Unable to navigate to PMS channel settings page because of this execption" + e);
			test.log(Status.FAIL, "Unable to navigate to PMS channel settings page because of this execption" + e);

			System.out.println("You are either not on the on admin Channels page or there is no PMS group");

			e.printStackTrace();

		}

	}
	
	
	public void navigateToPMSAddNewChannelPg() {
		
		
		try {

			if ((SeleniumRepo.isElementPresent(Channels_Pg_title) == true)
					& (Channels_Pg_title.getText().trim().equals("PMS Channels"))) {
				
				Javascriptexecutor(PMS_Add_New_Channel_Link);

				SeleniumRepo.waitForPageLoaded();
				
				Thread.sleep(2000);

			}

		} catch (Exception e) {

			logger.error("Unable to navigate to PMS channel add page because of this execption" + e);
			test.log(Status.FAIL, "Unable to navigate to PMS channel add page because of this execption" + e);

			System.out.println("You are either not on the on admin Channels page or there is no PMS group");

			e.printStackTrace();

		}
		
	}


	public void navigateToGdsChannelGroupSettingsPg() {

		try {

			if ((SeleniumRepo.isElementPresent(existing_GDS_Channelgroup) == true)
					& (All_exisiting_channelGroups.size() == 1)) {

				System.out.println("First If stateement");

				Javascriptexecutor(ChannelGroup_Table_Row1_SettingsLink);

				Thread.sleep(2000);

			}

			if ((SeleniumRepo.isElementPresent(existing_PMS_Channelgroup) == true)
					& (All_exisiting_channelGroups.size() > 1)) {
				System.out.println("Second If stateement");

				if (existing_GDS_Channelgroup.getText().trim().equals(ChannelGroup_Table_Row1_Name.getText().trim())) {

					System.out.println("third If stateement");

					Javascriptexecutor(ChannelGroup_Table_Row1_SettingsLink);
					Thread.sleep(2000);

				} else {

					System.out.println("else If stateement");

					Javascriptexecutor(ChannelGroup_Table_Row2_SettingsLink);
					Thread.sleep(2000);

				}

			}

		} catch (Exception e) {

			logger.error("Unable to navigate to GDS channel settings page because of this execption" + e);
			test.log(Status.FAIL, "Unable to navigate to PMS channel settings page because of this execption" + e);

			System.out.println("You are either not on the on admin Channels page or there is no PMS group");

			e.printStackTrace();

		}

	}

	public void deleteAllChannelGroup() throws InterruptedException {

		if (!(All_exisiting_channelGroups.isEmpty())) {
			for (int i = 0; i < All_exisiting_channelGroups.size(); i++) {
				Javascriptexecutor(All_exisiting_channelGroups.get(i));
				Thread.sleep(2000);
			}

			Javascriptexecutor(Channel_ListAllPage__DeleteButton);
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Deleting exsisting channel groups");
		} else {
			System.out.println("There are no Channels to Delete");
		}

	}

	public void deletePMSChannelGroup() throws InterruptedException {

		if ((SeleniumRepo.isElementPresent(existing_PMS_Channelgroup) == true)
				& (All_exisiting_channelGroups.size() == 1)) {
			Javascriptexecutor(All_exisiting_channelGroups.get(0));

			Thread.sleep(2000);

		}

		if ((SeleniumRepo.isElementPresent(existing_PMS_Channelgroup) == true)
				& (All_exisiting_channelGroups.size() > 1)) {

			if (existing_PMS_Channelgroup.getText().trim().equals(ChannelGroup_Table_Row1_Name.getText().trim())) {

				Javascriptexecutor(All_exisiting_channelGroups.get(0));
				Thread.sleep(2000);

			} else {

				Javascriptexecutor(All_exisiting_channelGroups.get(1));
				Thread.sleep(2000);

			}

		}

		if( (SeleniumRepo.isElementPresent(existing_PMS_Channelgroup) == true) ){
		
		Javascriptexecutor(Channel_ListAllPage__DeleteButton);
		SeleniumRepo.handleAlert();
		SeleniumRepo.waitForPageLoaded();

		System.out.println("Deleting exsisting PMS channel groups");
		
		}else{
			
			System.out.println(" PMS channel groups does not exsists");

		}

		// table/tbody/tr[3]/td[2] -> tr[3] is for item#2 and tr[2] is for item
		// #1 in channel group
		// table/tbody/tr[3]/td[4]/a -> tr[3] is for item#2 and tr[2] is for
		// item #1 in Update column
	}

	public void deleteGDSChannelGroup() throws InterruptedException {

		if ((SeleniumRepo.isElementPresent(existing_GDS_Channelgroup) == true)
				& (All_exisiting_channelGroups.size() == 1)) {
			Javascriptexecutor(All_exisiting_channelGroups.get(0));

			Thread.sleep(2000);

		}

		if ((SeleniumRepo.isElementPresent(existing_GDS_Channelgroup) == true)
				& (All_exisiting_channelGroups.size() > 1)) {

			if (existing_GDS_Channelgroup.getText().trim().equals(ChannelGroup_Table_Row1_Name.getText().trim())) {

				Javascriptexecutor(All_exisiting_channelGroups.get(0));
				Thread.sleep(2000);

			} else {

				Javascriptexecutor(All_exisiting_channelGroups.get(1));
				Thread.sleep(2000);
			}

		}

		Javascriptexecutor(Channel_ListAllPage__DeleteButton);
		SeleniumRepo.waitForPageLoaded();

		System.out.println("Deleting exsisting GDS channel groups");

		// table/tbody/tr[3]/td[2] -> tr[3] is for item#2 and tr[2] is for item
		// #1 in channel group
		// table/tbody/tr[3]/td[4]/a -> tr[3] is for item#2 and tr[2] is for
		// item #1 in Update column
	}

	
	
	
	public void channelGroupSelectionPg(String channelGroup){
		
		ExplicitWait(Channel_Group);

		if (SeleniumRepo.isElementPresent(Channel_Group)) {
			Select sc = new Select(Channel_Group);
			sc.selectByVisibleText(channelGroup);
			
			SeleniumRepo.waitForPageLoaded();

			logger.info("Channel group is selected");

			test.log(Status.INFO, "Channel group is selected");
		} else {
			logger.error(" Failed to Select Channel Group");

			test.log(Status.ERROR, "Failed to Select Channel Group");
		}

		
	}
	
	
	
	
	public void editPMSChannelTypeDropDown(String selectedChannelType){	
			
		try {

			SeleniumRepo.waitForElementPresent(PMS_ChannelType_Field);

			Assert.assertEquals(PMS_ChannelType_Field.isDisplayed(), true, "PMS Channel Type Field is not being displayed");

			PMS_ChannelType_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(PMS_ChannelType_DropDown, selectedChannelType);

			System.out.println("PMS Channel Type was selected or changed successfully");

			logger.info("PMS Channel Type was selected or changed successfully");
			test.log(Status.PASS, "PMS Channel Type was selected or changed successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit PMS Channel Type field,  for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit PMS Channel Type field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

		
	}
	
	
	
	public void editPMSStatusDropDown(String dropDownPMSStatus){
		

		
		
		try {

			SeleniumRepo.waitForElementPresent(PMS_Status_Field);

			Assert.assertEquals(PMS_Status_Field.isDisplayed(), true, "PMS Status Field is not being displayed");

			PMS_Status_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(PMS_Status_DropDown, dropDownPMSStatus);

			System.out.println("PMS Status was selected or changed successfully");

			logger.info("PMS Status was selected or changed successfully");
			test.log(Status.PASS, "PMS Status was selected or changed successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit PMS Status field,  for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit PMS Status field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

		
	}
	
	
	
	public void editPMSExternalServerURI(String EnterPmsExternalSErverURI){
		
		SeleniumRepo.waitForElementPresent(PMS_ExternalServerURI_Field);

		Assert.assertEquals(PMS_ExternalServerURI_Field.isDisplayed(), true,
				"Retry Interval text Field is not being displayed");

		PMS_ExternalServerURI_Input.click();
		PMS_ExternalServerURI_Input.clear();
		PMS_ExternalServerURI_Input.sendKeys(EnterPmsExternalSErverURI);

		System.out.println(" External Server URI is entered successfully");

		Assert.assertEquals(PMS_ExternalServerURI_Input.getAttribute("value"), EnterPmsExternalSErverURI,
				"The expected External Server URI Field text was not entered");
		logger.info("External Server URI is entered successfully");
		test.log(Status.PASS, "External Server URI is entered successfully");
		
		
	}

	
	public void editPMSRetryIntervalMiliSec(String EnterPmsRetryIntMili){
		
		SeleniumRepo.waitForElementPresent(PMS_RetryInterval_Field);

		Assert.assertEquals(PMS_RetryInterval_Field.isDisplayed(), true,
				"Retry Interval text Field is not being displayed");

		PMS_RetryInterval_Input.click();
		PMS_RetryInterval_Input.clear();
		PMS_RetryInterval_Input.sendKeys(EnterPmsRetryIntMili);

		System.out.println(" Retry Interval is entered successfully");

		Assert.assertEquals(PMS_RetryInterval_Input.getAttribute("value"), EnterPmsRetryIntMili,
				"The expected Retry Interval Field text was not entered");
		logger.info("Retry Interval is entered successfully");
		test.log(Status.PASS, "Retry Interval is entered successfully");
		
		
	}

	public void editPMSMaxRetryCount(String EnterPmsMaxRetryCount){

		SeleniumRepo.waitForElementPresent(PMS_MaxRetryCount_Field);

		Assert.assertEquals(PMS_MaxRetryCount_Field.isDisplayed(), true,
				"Max Retry Count text Field is not being displayed");

		PMS_MaxRetryCount_Input.click();
		PMS_MaxRetryCount_Input.clear();
		PMS_MaxRetryCount_Input.sendKeys(EnterPmsMaxRetryCount);

		System.out.println(" Max Retry Count is entered successfully");

		Assert.assertEquals(PMS_MaxRetryCount_Input.getAttribute("value"), EnterPmsMaxRetryCount,
				"The expected Max Retry Count Field text was not entered");
		logger.info("Max Retry Count is entered successfully");
		test.log(Status.PASS, "Max Retry Count is entered successfully");
		
		
	}


	
	public void editGDSstatusDropDown(String dropDownGDSStatus) {
		


		try {

			SeleniumRepo.waitForElementPresent(GDS_Status_Field);

			Assert.assertEquals(GDS_Status_Field.isDisplayed(), true, "GDS Status Field is not being displayed");

			GDS_Status_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(GDS_Status_DropDown, dropDownGDSStatus);

			System.out.println("GDS Status was selected or changed successfully");

			logger.info("GDS Status was selected or changed successfully");
			test.log(Status.PASS, "GDS Status was selected or changed successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit GDS Status field,  for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit GDS Status field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}
	
	
	public void editGDSChainCodeDropDown(String dropDownGDSChainCode) {
		


		try {

			SeleniumRepo.waitForElementPresent(GDS_ChainCode_Field);

			Assert.assertEquals(GDS_ChainCode_Field.isDisplayed(), true, "GDS Chain Code Field is not being displayed");

			GDS_ChainCode_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(GDS_ChainCode_DropDown, dropDownGDSChainCode);

			System.out.println("GDS Chain Code was selected or changed successfully");

			logger.info("GDS Chain Code was selected or changed successfully");
			test.log(Status.PASS, "GDS Chain Code was selected or changed successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit GDS Chain Code field,  for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit GDS Chain Code field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}
	
	public void editGDSChannelTypeSabre(String sabreHotelCode) {

		if (SeleniumRepoCheckBox.CheckCheckBox(Sabre_Channel_Type) == false) {
			Sabre_Channel_Type.click();
			logger.info("Sabre Channel type is selected");

			test.log(Status.INFO, "Sabre Channel type is selected");
		} else {
			logger.error(" Failed to Select Sabre Channel type");

			test.log(Status.ERROR, "Failed to Select Sabre Channel type");
		}

		SeleniumRepo.waitForElementPresent(Sabre_Hotel_Code);
		if (Sabre_Hotel_Code.isDisplayed()) {
			Sabre_Hotel_Code.sendKeys(sabreHotelCode);
			logger.info("Sabre Hotel code is entered");

			test.log(Status.INFO, "Sabre Hotel code is entered");
		} else {
			logger.error(" Failed to enter Sabre Hotel code");

			test.log(Status.ERROR, "Failed to enter Sabre Hotel code");
		}

	}

	public void editGDSChannelTypeGalileo(String GalileoHotelCode) {

		SeleniumRepo.waitForElementPresent(Galileo_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(Galileo_Channel_Type) == false) {
			Galileo_Channel_Type.click();
			logger.info("Galileo Channel type is selected");

			test.log(Status.INFO, "Galileo Channel type is selected");
		} else {
			logger.error(" Failed to Select Galileo Channel type");

			test.log(Status.ERROR, "Failed to Select Galileo  Channel type");
		}

		SeleniumRepo.waitForElementPresent(Galileo_Hotel_Code);
		if (Galileo_Hotel_Code.isDisplayed()) {
			Galileo_Hotel_Code.sendKeys(GalileoHotelCode);
			logger.info("Galileo Hotel code is entered");

			test.log(Status.INFO, "Galileo Hotel code is entered");
		} else {
			logger.error(" Failed to enter Galileo Hotel code");

			test.log(Status.ERROR, "Failed to enter Galileo Hotel code");
		}

	}

	public void editGDSChannelTypeWorldspan(String WorldspanHotelCode) {

		SeleniumRepo.waitForElementPresent(Worldspan_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(Worldspan_Channel_Type) == false) {
			Worldspan_Channel_Type.click();
			logger.info("Worldspan Channel type is selected");

			test.log(Status.INFO, "Worldspan Channel type is selected");
		} else {
			logger.error(" Failed to Select Worldspan Channel type");

			test.log(Status.ERROR, "Failed to  select Worldspan  Channel type");
		}

		SeleniumRepo.waitForElementPresent(Worldspan_Hotel_Code);
		if (Worldspan_Hotel_Code.isDisplayed()) {

			Worldspan_Hotel_Code.clear();
			Worldspan_Hotel_Code.sendKeys(WorldspanHotelCode);
			logger.info("Worldspan Hotel code is entered");

			test.log(Status.INFO, "Worldspan Hotel code is entered");
		} else {
			logger.error(" Failed to enter Worldspan Hotel code");

			test.log(Status.ERROR, "Failed to enter Worldspan Hotel code");
		}

	}

	public void editGDSChannelTypeAmadeus(String AmadeusHotelCode) {

		SeleniumRepo.waitForElementPresent(Amadeus_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(Amadeus_Channel_Type) == false) {
			Amadeus_Channel_Type.click();
			logger.info("Amadeus Channel type is selected");

			test.log(Status.INFO, "Amadeus Channel type is selected");
		} else {
			logger.error(" Failed to Select Amadeus Channel type");

			test.log(Status.ERROR, "Failed to Amadeus Sabre Channel type");
		}

		SeleniumRepo.waitForElementPresent(Amadeus_Hotel_Code);
		if (Amadeus_Hotel_Code.isDisplayed()) {
			Amadeus_Hotel_Code.sendKeys(AmadeusHotelCode);
			logger.info("Amadeus Hotel code is entered");

			test.log(Status.INFO, "Amadeus Hotel code is entered");
		} else {
			logger.error(" Failed to enter Amadeus Hotel code");

			test.log(Status.ERROR, "Failed to enter Amadeus Hotel code");
		}

	}

	public void editGDSChannelTypeAds(String AdsHotelCode) {

		SeleniumRepo.waitForElementPresent(ADS_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(ADS_Channel_Type) == false) {
			ADS_Channel_Type.click();
			logger.info("ADS Channel type is selected");

			test.log(Status.INFO, "ADS Channel type is selected");
		} else {
			logger.error(" Failed to Select ADS Channel type");

			test.log(Status.ERROR, "Failed to Select  ADS Channel type");
		}

		SeleniumRepo.waitForElementPresent(ADS_Hotel_Code);
		if (ADS_Hotel_Code.isDisplayed()) {
			ADS_Hotel_Code.sendKeys(AdsHotelCode);
			logger.info("Amadeus Hotel code is entered");

			test.log(Status.INFO, "ADS Hotel code is entered");
		} else {
			logger.error(" Failed to enter ADS Hotel code");

			test.log(Status.ERROR, "Failed to enter ADS Hotel code");
		}

	}

	
	
	public void submitPMSbutton() {

		if (SeleniumRepo.isElementDisplayed(pms_submit_button) == true) {

			Javascriptexecutor(pms_submit_button);
			SeleniumRepo.waitForPageLoaded();

			logger.info("Clicked on Submit button successfully ");

			test.log(Status.INFO, "Clicked on PMS Submit button successfully");
		} else {
			logger.error(" Failed to click on PMS Submit button");

			test.log(Status.ERROR, "Failed to click on PMS Submit button");
		}

	}
	
	public void submitGDSbutton() {

		if (SeleniumRepo.isElementDisplayed(gds_submit_button) == true) {

			Javascriptexecutor(gds_submit_button);
			SeleniumRepo.waitForPageLoaded();

			logger.info("Clicked on Submit button successfully ");

			test.log(Status.INFO, "Clicked on GDS Submit button successfully");
		} else {
			logger.error(" Failed to click on GDS Submit button");

			test.log(Status.ERROR, "Failed to click on GDS Submit button");
		}

	}

	public void cancelGDSbutton() {

		if (SeleniumRepo.isElementDisplayed(gds_cancel_button) == true) {

			Javascriptexecutor(gds_cancel_button);
			SeleniumRepo.waitForPageLoaded();

			logger.info("Clicked on GDS Cancel button successfully ");

			test.log(Status.INFO, "Clicked on GDS Cancel button successfully");
		} else {
			logger.error(" Failed to click on GDS Cancel button");

			test.log(Status.ERROR, "Failed to click on GDS Cancel button");
		}

	}

	// Creating PMS methods

	// Crating GDS

	/**
	 * Original ChannelCration method. This methohd only creates a GDS channel
	 * for a property. Enabling GDS allows "The About Property" link to appear
	 * 
	 * TODO: Must rename to reflect its functionality
	 * 
	 * @param sabreHotelCode
	 * @param GalileoHotelCode
	 * @param WorldspanHotelCode
	 * @param AmadeusHotelCode
	 * @param AdsHotelCode
	 * @throws InterruptedException
	 */
	public void createChannel(String sabreHotelCode, String GalileoHotelCode, String WorldspanHotelCode,
			String AmadeusHotelCode, String AdsHotelCode) throws InterruptedException {

		try {
			// Some where below it deletes the current gds entry

			if (channels_link.isDisplayed()) {
				Javascriptexecutor(channels_link);
				ExplicitWait(addNew_Channel_link);
				System.out.println("PropertyManagement element Expanded and channels_link element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and channels_link element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and channels_link element  found");
			} else {
				System.out.println("PropertyManagement Menu is not expanded");
				SeleniumRepo.scrollintoview(Click_PropertyManagement);
				Thread.sleep(2000);
				Javascriptexecutor(Click_PropertyManagement);
				Thread.sleep(2000);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(channels_link);
				if (channels_link.isDisplayed()) {
					Javascriptexecutor(channels_link);
					ExplicitWait(addNew_Channel_link);
					System.out.println("channels element found");
					test.log(Status.INFO, "channels element found");
					Assert.assertTrue(true, "channels element found");
				} else {
					logger.info("channels element not  found");
					test.log(Status.FAIL, "channels element not  found");
				}
			}

			if (SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains("GDS")) {
				System.out.println("Channel GDS already present ,going to delet and recreate to test");
				SeleniumRepo.driver.findElement(By.xpath("//*[@type='checkbox']")).click();
				Thread.sleep(1000);
				SeleniumRepo.driver.findElement(By.xpath("//*[@name='delete']")).click();
				Thread.sleep(2000);
				Alert alert = SeleniumRepo.driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
				Thread.sleep(3000);
			} else {
				System.out.println("GDS  Channel  not created hence create a new channel");
			}

			Thread.sleep(2000);
			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Channel Group')]")));

			SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Channel Group')]")).click();

			logger.info("Clicked on ADD New Channel Link ");

			test.log(Status.INFO, "Clicked on ADD New Channel Link ");

			ExplicitWait(Channel_Group);

			if (SeleniumRepo.isElementPresent(Channel_Group)) {
				Select sc = new Select(Channel_Group);
				sc.selectByVisibleText("GDS");

				logger.info("Channel group is selected");

				test.log(Status.INFO, "Channel group is selected");
			} else {
				logger.error(" Failed to Select Channel Group");

				test.log(Status.ERROR, "Failed to Select Channel Group");
			}

			ExplicitWait(Sabre_Channel_Type);
			if (SeleniumRepoCheckBox.CheckCheckBox(Sabre_Channel_Type) == false) {
				Sabre_Channel_Type.click();
				logger.info("Sabre Channel type is selected");

				test.log(Status.INFO, "Sabre Channel type is selected");
			} else {
				logger.error(" Failed to Select Sabre Channel type");

				test.log(Status.ERROR, "Failed to Select Sabre Channel type");
			}

			SeleniumRepo.waitForElementPresent(Sabre_Hotel_Code);
			if (Sabre_Hotel_Code.isDisplayed()) {
				Sabre_Hotel_Code.sendKeys(sabreHotelCode);
				logger.info("Sabre Hotel code is entered");

				test.log(Status.INFO, "Sabre Hotel code is entered");
			} else {
				logger.error(" Failed to enter Sabre Hotel code");

				test.log(Status.ERROR, "Failed to enter Sabre Hotel code");
			}

			SeleniumRepo.waitForElementPresent(Galileo_Channel_Type);
			if (SeleniumRepoCheckBox.CheckCheckBox(Galileo_Channel_Type) == false) {
				Galileo_Channel_Type.click();
				logger.info("Galileo Channel type is selected");

				test.log(Status.INFO, "Galileo Channel type is selected");
			} else {
				logger.error(" Failed to Select Galileo Channel type");

				test.log(Status.ERROR, "Failed to Select Galileo  Channel type");
			}

			SeleniumRepo.waitForElementPresent(Galileo_Hotel_Code);
			if (Galileo_Hotel_Code.isDisplayed()) {
				Galileo_Hotel_Code.sendKeys(GalileoHotelCode);
				logger.info("Galileo Hotel code is entered");

				test.log(Status.INFO, "Galileo Hotel code is entered");
			} else {
				logger.error(" Failed to enter Galileo Hotel code");

				test.log(Status.ERROR, "Failed to enter Galileo Hotel code");
			}

			SeleniumRepo.waitForElementPresent(Worldspan_Channel_Type);
			if (SeleniumRepoCheckBox.CheckCheckBox(Worldspan_Channel_Type) == false) {
				Worldspan_Channel_Type.click();
				logger.info("Worldspan Channel type is selected");

				test.log(Status.INFO, "Worldspan Channel type is selected");
			} else {
				logger.error(" Failed to Select Worldspan Channel type");

				test.log(Status.ERROR, "Failed to  select Worldspan  Channel type");
			}

			SeleniumRepo.waitForElementPresent(Worldspan_Hotel_Code);
			if (Worldspan_Hotel_Code.isDisplayed()) {
				Worldspan_Hotel_Code.sendKeys(WorldspanHotelCode);
				logger.info("Worldspan Hotel code is entered");

				test.log(Status.INFO, "Worldspan Hotel code is entered");
			} else {
				logger.error(" Failed to enter Worldspan Hotel code");

				test.log(Status.ERROR, "Failed to enter Worldspan Hotel code");
			}

			SeleniumRepo.waitForElementPresent(Amadeus_Channel_Type);
			if (SeleniumRepoCheckBox.CheckCheckBox(Amadeus_Channel_Type) == false) {
				Amadeus_Channel_Type.click();
				logger.info("Amadeus Channel type is selected");

				test.log(Status.INFO, "Amadeus Channel type is selected");
			} else {
				logger.error(" Failed to Select Amadeus Channel type");

				test.log(Status.ERROR, "Failed to Amadeus Sabre Channel type");
			}

			SeleniumRepo.waitForElementPresent(Amadeus_Hotel_Code);
			if (Amadeus_Hotel_Code.isDisplayed()) {
				Amadeus_Hotel_Code.sendKeys(AmadeusHotelCode);
				logger.info("Amadeus Hotel code is entered");

				test.log(Status.INFO, "Amadeus Hotel code is entered");
			} else {
				logger.error(" Failed to enter Amadeus Hotel code");

				test.log(Status.ERROR, "Failed to enter Amadeus Hotel code");
			}

			SeleniumRepo.waitForElementPresent(ADS_Channel_Type);
			if (SeleniumRepoCheckBox.CheckCheckBox(ADS_Channel_Type) == false) {
				ADS_Channel_Type.click();
				logger.info("ADS Channel type is selected");

				test.log(Status.INFO, "ADS Channel type is selected");
			} else {
				logger.error(" Failed to Select ADS Channel type");

				test.log(Status.ERROR, "Failed to Select  ADS Channel type");
			}

			SeleniumRepo.waitForElementPresent(ADS_Hotel_Code);
			if (ADS_Hotel_Code.isDisplayed()) {
				ADS_Hotel_Code.sendKeys(AdsHotelCode);
				logger.info("Amadeus Hotel code is entered");

				test.log(Status.INFO, "ADS Hotel code is entered");
			} else {
				logger.error(" Failed to enter ADS Hotel code");

				test.log(Status.ERROR, "Failed to enter ADS Hotel code");
			}

			Thread.sleep(3000);

			if (SeleniumRepo.driver.findElement(By.xpath("//input[@name='Submit']")).isDisplayed()) {
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//input[@name='Submit']")));
				SeleniumRepo.waitForPageLoaded();

				// ExplicitWait(channels_link);
				logger.info("Clicked on Submit button successfully ");

				test.log(Status.INFO, "Clicked on Submit button successfully");
			} else {
				logger.error(" Failed to click on Submit button");

				test.log(Status.ERROR, "Failed to click on Submit button");
			}

			if (SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Channels')]")).isDisplayed()) {
				Thread.sleep(3000);
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Channels')]")));
				ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Channels')]")));
				logger.info("Clicked on Channel Link ");

				test.log(Status.INFO, "Clicked on Channel Link");
			} else {
				logger.error(" Failed to Click on Channel Link");

				test.log(Status.ERROR, " Failed to Click on Channel Link");
			}

			if (SeleniumRepo.driver.findElement(By.tagName("body")).getText().equals("GDS")) {
				System.out.println("Channel GDS created successfully");
				logger.info("Channel GDS created successfully");
				test.log(Status.PASS, "Channel GDS created successfully");
			}

			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
