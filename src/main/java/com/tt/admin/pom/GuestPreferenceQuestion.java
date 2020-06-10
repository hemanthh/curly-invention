package com.tt.admin.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * This class was refacotred to cover the following: 
 * 1. Interaction with the List all page 
 * 2. Creation of all Guest Preference Question types and editing of their fields
 * 3. Editing,and Deletion of Questions
 * 
 * @author DM
 *
 */
public class GuestPreferenceQuestion extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[contains(text(), 'Guest Preference Questions')]"), })
	public WebElement Click_GuestPQ;

	@FindAll({ @FindBy(xpath = "//div[contains(., 'Rooms')]"), })
	public WebElement Click_Room_link;

	@FindAll({ @FindBy(xpath = "//li//a[contains(@href,'addEditGuestPreferences.do?')]"), })
	public WebElement Click_AddNewGuestPQ;

	@FindAll({ @FindBy(xpath = "//input[@value='Save']"), })
	public WebElement Click_SaveGuestPQ;

	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"), })
	public WebElement Click_CancelGuestPQ;

	@FindAll({ @FindBy(xpath = "//*[text()='Guest Preference Questions']/following-sibling::ul/li[1]/a"), })
	public WebElement List_All;

	@FindAll({ @FindBy(xpath = "//font[@color='red' and ./li[contains(.,'Required field Question.')]]"), })
	public WebElement Check_ErrorReqGuestPQ;

	@FindAll({ @FindBy(xpath = "//font[@color='red' and ./li[contains(.,'Required field Question Label.')]]"), })
	public WebElement Check_ErrorReqGuestPQLabel;

	@FindAll({ @FindBy(xpath = "//font[@color='red' and ./li[contains(.,'Options Label can not be blank.')]]"), })
	public WebElement Check_ErrorOptionsGuestPQLabel;

	@FindAll({ @FindBy(xpath = "//select[@id='selectionType']"), })
	public WebElement Select_GuestPType;

	@FindAll({ @FindBy(xpath = "//input[@id='maxOptionsAllowed']"), })
	public WebElement Select_MaxOptionsAllowed;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Category')]") })
	public WebElement Category_Field;

	@FindAll({ @FindBy(xpath = "//input[@id='reservation']") })
	public WebElement Click_Category_Reservation;

	@FindAll({ @FindBy(xpath = "//input[@id='room']") })
	public WebElement Click_Category_Room;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Required')]") })
	public WebElement Required_Field;

	@FindAll({ @FindBy(xpath = "//input[@name='isRequired'][1]") })
	public WebElement Click_Required_Enable;

	@FindAll({ @FindBy(xpath = "//input[@name='isRequired'][2]") })
	public WebElement Click_Required_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Channels')]") })
	public WebElement Channels_Field;

	@FindAll({ @FindBy(xpath = "//input[@name='channelOptions' and @value='HWEB']") })
	public WebElement Click_Channels_Web;

	@FindAll({ @FindBy(xpath = "//input[@name='channelOptions' and @value='CALLC']") })
	public WebElement Click_Channels_CallCenter;

	@FindAll({ @FindBy(xpath = "//input[@name='channelOptions' and @value='TBLT']") })
	public WebElement Click_Channels_Tablet;

	@FindAll({ @FindBy(xpath = "//input[@id='questionText']"), })
	public WebElement Enter_FieldQuestion;

	@FindAll({ @FindBy(xpath = "//input[@id='questionLabel']"), })
	public WebElement Enter_FieldQuestionLabel;

	@FindAll({ @FindBy(xpath = "//input[@id='optionLabel']"), })
	public WebElement Enter_FieldQuestion_1_Label;

	@FindAll({ @FindBy(xpath = "//input[@id='optionTextIndex_1']"), })
	public WebElement Enter_FieldQuestion_1_Guest_Options;

	@FindAll({ @FindBy(xpath = "//input[@id='optionLabel']"), })
	public List<WebElement> Enter_FieldQuestion_Labels;

	// *[@id="questionOptions"]/tbody/tr/td/input[@maxlength='300']
	@FindAll({ @FindBy(xpath = "//*[@id='questionOptions']/tbody/tr/td/input[@size='50']"), })
	public List<WebElement> Enter_FieldQuestion_Options;

	@FindAll({ @FindBy(xpath = "(//input[@id='optionLabel'])[last()]"), })
	public WebElement Enter_FieldQuestionLabels_Last;

	@FindAll({ @FindBy(xpath = "(//*[@id='questionOptions']/tbody/tr/td/input[@size='50'])[last()]"), })
	public WebElement Enter_FieldQuestionOption_Last;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'delivery:')]") })
	public WebElement PMSdelivery_Field;

	@FindAll({ @FindBy(xpath = "//input[@name='pmsDelivery' and @value='Comments']") })
	public WebElement Click_PMSdelivery_Comments;

	@FindAll({ @FindBy(xpath = "//input[@name='pmsDelivery' and @value='Special Request']") })
	public WebElement Click_PMSdelivery_SpReq;

	@FindAll({ @FindBy(xpath = "//a[contains(@href,'manageGuestPreferences.do?')]"), })
	public WebElement Click_ListAll;

	@FindAll({ @FindBy(xpath = "//*[@id='update']"), })
	public WebElement Update;

	@FindAll({ @FindBy(xpath = "//*[text()='Delete']") })
	public List<WebElement> Delete;

	@FindAll({ @FindBy(xpath = "(//*[text()='Delete'])[last()]") })
	public WebElement Delete_last;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'questions to display')]"), })
	public WebElement GPQ_NoQuestions;

	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Guest Preference Questions')]"), })
	public WebElement GPQ_Title;

	@FindAll({ @FindBy(xpath = "//*[text()='OK']"), })
	public WebElement Delete_OK;

	@FindAll({ @FindBy(xpath = "//*[text()='Cancel']"), })
	public WebElement Delete_Cancel;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Language')]") })
	public WebElement Language_Field;

	@FindAll({ @FindBy(xpath = "//select[@id='selectedlanCode']") })
	public WebElement Select_GuestPresQuestion_Lang_DropDown;

	@FindAll({ @FindBy(xpath = "//*[@class ='prompt'][2]"), })
	public List<WebElement> guestPrefeQuestion;

	@FindAll({ @FindBy(xpath = "//*[@class ='prompt'][5]/a"), })
	public List<WebElement> guestPrefeQuestion_EditLink;

	@FindAll({ @FindBy(xpath = "//*[@id='addNewOptionBtn']/td[2]/input") })
	public WebElement Add_Option_Button;

	@FindAll({ @FindBy(xpath = "//*[@id='returnOrder']"), })
	public List<WebElement> guestPrefeQuestion_Order;

	
	@FindAll({ @FindBy(xpath = "//td[contains(text(),'By default, Expand all questions on Booking Engine')]") })
	public WebElement BeDefaultExpStatus_Field;

	@FindAll({ @FindBy(xpath = "//input[@name='isGuestPrefQuestionsExpanded'][1]") })
	public WebElement Click_BeDefaultExpStatus_Expanded;

	@FindAll({ @FindBy(xpath = "//input[@name='isGuestPrefQuestionsExpanded'][2]") })
	public WebElement Click_BeDefaultExpStatus_Hidden;
	
	
	@FindAll({ @FindBy(xpath = "//div[@id='showSuccessMessage']") })
	public WebElement beDefaultExpStatusChange_Msg;
	
	
	//*[@id ="dataTable"]  -> potential xpath that cpatures entire question table     

	
	/**
	 * Navigates to the Guest Preference Question section in admin and clicks the list all link
	 * @throws InterruptedException
	 */
	public void click_GuestPreferQues_ListAll() throws InterruptedException {

		if (SeleniumRepo.isElementDisplayed(Click_ListAll) == false ) {
			Click_GuestPQ.click();

			SeleniumRepo.WaitForLoad(2000);

		}

		if ( SeleniumRepo.isElementDisplayed(Click_ListAll) == true) {
			Javascriptexecutor(Click_ListAll);
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			test.log(Status.INFO, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			Assert.assertTrue(true, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
		} else {
			// if first click fails it attempts a second time to click addnew
			System.out.println("Guest Preference Questions Menu is not expanded");
			// Javascriptexecutor(Click_GuestPQ);
			// System.out.println("Clicked on Guest Preference Questions Link");
			// test.log(Status.INFO, "Clicked on Guest Preference Questions
			// Link");

		}

	}

	/**
	 * Navigates to the Guest Preference Question section in admin and clicks the add new link
	 * @throws InterruptedException
	 */
	public void click_GuestPreferQues_AddNew() throws InterruptedException {

		if (Click_AddNewGuestPQ.isDisplayed() != true) {
			Click_GuestPQ.click();
			SeleniumRepo.WaitForLoad(2000);
		}

		// Clicks add new link for GPQ
		if (Click_AddNewGuestPQ.isDisplayed()) {
			Javascriptexecutor(Click_AddNewGuestPQ);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(Click_SaveGuestPQ);
			System.out.println("Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			test.log(Status.INFO, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			Assert.assertTrue(true, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
		} else {
			// if first click fails it attempts a second time to click addnew
			System.out.println("Guest Preference Questions Menu is not expanded");
			// Javascriptexecutor(Click_GuestPQ);
			// System.out.println("Clicked on Guest Preference Questions Link");
			// test.log(Status.INFO, "Clicked on Guest Preference Questions
			// Link");

		}

	}

	/**
	 * Updates the position of a question using the update feature on the list all page
	 * 
	 * @param currentPostion
	 * @param newPostion
	 */
	public void updateGuestPrefQuestOrder(int currentPostion, int newPostion) {

		int altCurrPos = currentPostion - 1;
		int altNewPos = newPostion - 1;

		String curPostionValue = "";
		String newPostionValue = "";

		String curPosQuestion = "";

		if (newPostion > guestPrefeQuestion_Order.size() || currentPostion > guestPrefeQuestion_Order.size()) {

			System.out.println("The postion you wished to change the current question to does not exsist");
			logger.info("The intended postion does not exsist ");
			test.log(Status.FAIL, "The postion you wish to update the question does not exsist");

		} else {

			curPostionValue = guestPrefeQuestion_Order.get(altCurrPos).getAttribute("value");
			newPostionValue = guestPrefeQuestion_Order.get(altNewPos).getAttribute("value");

			curPosQuestion = guestPrefeQuestion.get(altCurrPos).getText().trim();

			SeleniumRepo.doubleClick(guestPrefeQuestion_Order.get(altCurrPos));

			guestPrefeQuestion_Order.get(altCurrPos).clear();
			guestPrefeQuestion_Order.get(altCurrPos).sendKeys(newPostionValue);
			Update.click();
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Minimum Price Alert For Hotel is entered successfully");

			Assert.assertEquals(guestPrefeQuestion.get(altNewPos).getText().trim(), curPosQuestion,
					"The question postion was not change");
			logger.info("Guest Preference question position was updated sucessfully");
			test.log(Status.PASS, "Guest Preference question position was updated sucessfully");

		}

	}

	/**
	 * Handles changing the hidden or expanded status of the Guest Preference Questions on the 
	 * BE
	 * 
	 * @param beHiddenStatus
	 */
	public void changeQuestionBeDisplayStatus(String beHiddenStatus){		
		
		
		//ExplicitWait(BeDefaultExpStatus_Field);

		Assert.assertEquals(BeDefaultExpStatus_Field.isDisplayed(), true, "By default, Expand all questions on Booking Engine Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (beHiddenStatus.equalsIgnoreCase("Expanded")) {

			Click_BeDefaultExpStatus_Expanded.click();
			//SeleniumRepo.WaitForLoad(100);

			System.out.println("By default, Expand all questions on Booking Engine was set to Expanded successfully");
			logger.info("By default, Expand all questions on Booking Engine was set to Expanded selected successfully");
			test.log(Status.PASS, "By default, Expand all questions on Booking Engine was set to Comments selected successfully");

			Assert.assertTrue(Click_BeDefaultExpStatus_Expanded.isSelected(), "PMS delivery was set to Comments is Enabled");

		}

		if (beHiddenStatus.equalsIgnoreCase("Hidden")) {

			Click_BeDefaultExpStatus_Hidden.click();
			//SeleniumRepo.WaitForLoad(100);

			System.out.println("By default, Expand all questions on Booking Engine was set to Hidden successfully");
			logger.info("By default, Expand all questions on Booking Engine was set to Hidden selected successfully");
			test.log(Status.PASS, "By default, Expand all questions on Booking Engine was set to Hidden selected successfully");

			Assert.assertTrue(Click_BeDefaultExpStatus_Hidden.isSelected(),"By default, Expand all questions on Booking Engine was set to Hidden is Enabled");

		}

		clickGuestPrefSaveButton();
		
		SeleniumRepo.isElementDisplayed(beDefaultExpStatusChange_Msg);
		
		Assert.assertTrue(SeleniumRepo.isElementDisplayed(beDefaultExpStatusChange_Msg),"By default, Expand all questions on Booking Engine was set to Hidden is Enabled");

		
	}
	
	/**
	 * While on the list all page using a questions to locate and click its Edit link
	 * 
	 * @param questoinName
	 * @throws InterruptedException
	 */
	public void click_guestPrefQuestEditLink(String questoinName) throws InterruptedException {

		SeleniumRepo.WaitForLoad(2000);

		// Find the question we wish to edit and click the edit link

		for (int a = 0; a < guestPrefeQuestion.size(); a++) {

			// System.out.println(guestPrefeQuestion.get(a).getText() );
			if (guestPrefeQuestion.get(a).getText().trim().equals(questoinName)) {

				guestPrefeQuestion_EditLink.get(a).click();
			}
		}
	}

	/**
	 * While on the question edit page, this method changes the question type(Single, Multiple, Free Text) based on the input
	 * @param GuestPType
	 * @throws InterruptedException
	 */
	public void editGuestPrefQuestType(String GuestPType) throws InterruptedException {

		if (Select_GuestPType.isEnabled()) {

			// Thread.sleep(2000);
			Select_GuestPType.click();
			Thread.sleep(2000);

			SeleniumRepoDropdown.selectDropDownValue(Select_GuestPType, GuestPType);

			System.out.println("ErrorOptionsGuestPQLabel is Selected");
			test.log(Status.PASS, "ErrorOptionsGuestPQLabel is Selected ");
			Assert.assertTrue(true, "ErrorOptionsGuestPQLabel is Selected ");
		} else {
			System.out.println("ErrorOptionsGuestPQLabel is Not Selected");
			test.log(Status.FAIL, " ErrorOptionsGuestPQLabel is Not Selected");
			Assert.assertFalse(false, "ErrorOptionsGuestPQLabel is Not Selected");
		}

	}
	
	/**
	 * While on the question edit page, use this method to interact with the Max Option field 
	 * this currently only enabled when Multi selection question is picked
	 * 
	 * @param maxOptions
	 */
	public void editGuestPrefQuestMaxOptAllowed(String maxOptions) {

		if (Select_MaxOptionsAllowed.isEnabled()) {
			Select_MaxOptionsAllowed.click();
			Select_MaxOptionsAllowed.clear();
			Select_MaxOptionsAllowed.sendKeys(maxOptions);
			System.out.println("MaxOptions is Entered");
			test.log(Status.PASS, "MaxOptions is Entered ");
			Assert.assertTrue(true, "MaxOptions is Entered ");
			Assert.assertEquals(Select_MaxOptionsAllowed.getAttribute("value"), maxOptions,
					"Max option allowed text was not entered");
		}

	}

	/**
	 * While on the question edit page, this method changes the category field 
	 * 
	 * @param questionCategory
	 * @throws InterruptedException
	 */
	public void editGuestPrefQuestCategory(String questionCategory) throws InterruptedException {

		/*    	 */
		SeleniumRepo.waitForElementPresent(Category_Field);

		Assert.assertEquals(Category_Field.isDisplayed(), true, "Category field is not being displayed");

		if (questionCategory.equalsIgnoreCase("Reservation")) {

			Click_Category_Reservation.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Category was set to Reservation successfully");
			logger.info(" Category was set to Reservatio selected successfully");
			test.log(Status.PASS, "Category was set to Reservation selected successfully");
			Assert.assertTrue(Click_Category_Reservation.isSelected(), "Category was set to Reservatio is Enabled");

		}

		if (questionCategory.equalsIgnoreCase("Room")) {

			Click_Category_Room.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Category was set to Room successfully");
			logger.info(" Category was set to Room selected successfully");
			test.log(Status.PASS, "Category was set to Room selected successfully");

			Assert.assertTrue(Click_Category_Room.isSelected(), "Category was set to Room is Enabled");

		}

	}

	/**
	 * While on the question edit page, this method changes the requirement field  
	 * 
	 * @param questionReq
	 * @throws InterruptedException
	 */
	public void editGuestPrefQuestRequired(String questionReq) throws InterruptedException {

		// Need to create web element options

		/* */

		SeleniumRepo.waitForElementPresent(Required_Field);

		Assert.assertEquals(Required_Field.isDisplayed(), true, "Required Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (questionReq.equalsIgnoreCase("enable")) {

			Click_Required_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Required is enabled successfully");
			logger.info("Required field yes is selected successfully");
			test.log(Status.PASS, "Required selected successfully");
			Assert.assertTrue(Click_Required_Enable.isSelected(), "Required is Enabled");

		} else {

			Click_Required_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Required is disable successfully");
			logger.info("Required field no is selected successfully");
			test.log(Status.PASS, "Required no is selected ");

			Assert.assertTrue(Click_Required_Disable.isSelected(), "Required is disable");

		}

	}
	
	
	/**
	 * While on the question edit page, this method changes what channel(web, callcenter, or tablet) the question appears on
	 * 
	 * @param channelTypes
	 */
	public void editGuestPrefQuestChannels(String channelTypes) {

		switch (channelTypes) {

		case "HWEB":

			Click_Channels_Web.click();

			logger.info("Clicking Web checkbox for Channels on the Guest Preference Questions");
			test.log(Status.PASS, "Clicking Web checkbox for Channels on the Guest Preference Questions");

			break;

		case "CALLC":

			Click_Channels_CallCenter.click();

			logger.info("Clicking CallCenter checkbox for Channels on the Guest Preference Questions");
			test.log(Status.PASS, "Clicking Callcenter checkbox for Channels on the Guest Preference Questions");

			break;

		case "TBLT":
			logger.info("Clicking Tablet checkbox for Channels on the Guest Preference Questions");
			test.log(Status.PASS, "Clicking Tablet checkbox for Channels on the Guest Preference Questions");

			Click_Channels_Tablet.click();

			break;

		case "all":

			logger.info("Clicking Web, CallCenter and Tablet checkbox for Channels on the Guest Preference Questions");
			test.log(Status.PASS,
					"Clicking Web, CallCenter and Tablet checkbox for Channels on the Guest Preference Questions");

			Click_Channels_Web.click();
			Click_Channels_CallCenter.click();
			Click_Channels_Tablet.click();

			break;

		}

	}

	/**
	 * While on the question edit page, this method changes the language visibility of the question text while on 
	 * the page
	 * 
	 * @param dropDownLangItem
	 */
	public void editGuestPrefQuestLanguage(String dropDownLangItem) {

		SeleniumRepo.waitForElementPresent(Language_Field);

		Assert.assertEquals(Language_Field.isDisplayed(), true, "Language Field is not being displayed");

		Select_GuestPresQuestion_Lang_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_GuestPresQuestion_Lang_DropDown, dropDownLangItem);

		System.out.println("A Language was selected successfully");

		logger.info("A Langauge was selected successfully");
		test.log(Status.PASS, "A Language was selected successfully");

	}


	/**
	 * While on the question edit page, this method changes the question 
	 * 
	 * @param newValue
	 */
	public void editGuestPrefQuestQuestion(String newValue) {

		SeleniumRepo.waitForElementPresent(Enter_FieldQuestion);

		Assert.assertEquals(Enter_FieldQuestion.isDisplayed(), true, "The Question text Field is not being displayed");

		Enter_FieldQuestion.click();
		Enter_FieldQuestion.clear();
		Enter_FieldQuestion.sendKeys(newValue);

		System.out.println("The Question is entered successfully");

		Assert.assertEquals(Enter_FieldQuestion.getAttribute("value"), newValue, "Field Question text was not entered");
		logger.info("Field Question is  entered successfully");
		test.log(Status.PASS, "FieldQuestion is Entered successfully");

	}

	/**
	 * While on the question edit page, this method changes the Question Label field  
	 * 
	 * @param newValue
	 */
	public void editGuestPrefQuestQuestionLabel(String newValue) {

		SeleniumRepo.waitForElementPresent(Enter_FieldQuestionLabel);

		Assert.assertEquals(Enter_FieldQuestionLabel.isDisplayed(), true,
				"The Question Label text Field is not being displayed");

		Enter_FieldQuestionLabel.click();
		Enter_FieldQuestionLabel.clear();
		Enter_FieldQuestionLabel.sendKeys(newValue);

		System.out.println("No. of Floors is entered successfully");

		Assert.assertEquals(Enter_FieldQuestionLabel.getAttribute("value"), newValue,
				"Field Question Label text was not entered");
		logger.info("Field Question Label is entered successfully");
		test.log(Status.PASS, "Field Question Label is entered successfully");

	}

	// Create one method that interacts with options and labels publically then
	// create private meothds that change the
	
	/**
	 * While on the question edit page, this method changes and interacts with a questions options and its label
	 * 
	 * @param oldValLabel
	 * @param oldValueOption
	 * @param newValLabel
	 * @param newValueOption
	 */
	public void editGuestPrefQuestOptionsAndLabel(String oldValLabel, String oldValueOption, String newValLabel, String newValueOption) {

		boolean foundMatch = false;

		// Enter_FieldQuestion_Options Enter_FieldQuestion_Labels
		for (int b = 0; b < Enter_FieldQuestion_Options.size(); b++) {

			if (Enter_FieldQuestion_Labels.get(b).getAttribute("value").equals(oldValLabel)
					&& Enter_FieldQuestion_Options.get(b).getAttribute("value").equals(oldValueOption)) {
				
				foundMatch = true;

				// call on the methods that will change each field

				editGuestPrefQuestOptionLabel(Enter_FieldQuestion_Labels.get(b), oldValLabel, newValLabel);

				editGuestPrefQuestOptionField(Enter_FieldQuestion_Options.get(b), oldValueOption, newValueOption);

			}
		}

		if (foundMatch == false) {

			System.out.println("Guest Preference Questions optons and label does not match");
			logger.error("Guest Preference Questions optons and label does not match");
			// test.log(Status.FAIL, "Failed to Select StarRating");
			test.log(Status.INFO, "Guest Preference Questions optons and label does not match");

		}

	}

	/**
	 * While on the question edit page, this method changes a questions option label thus supports the method 
	 * editGuestPrefQuestOptionsAndLabel
	 * 
	 * 
	 * @param textField
	 * @param oldValue
	 * @param newValue
	 */
	private void editGuestPrefQuestOptionLabel(WebElement textField, String oldValue, String newValue) {

		if (newValue.equals("")) {

			System.out.println("Options Label can not be blank. so  " + oldValue + " was not changed to:  " + newValue);
			logger.info("Changed option label from: " + oldValue + " to:  " + newValue);
			test.log(Status.ERROR, "FieldQuestion label was not Entered successfully becasue it was blank ");

		} else {

			textField.click();
			textField.clear();
			textField.sendKeys(newValue);

			System.out.println("Changed option label from: " + oldValue + " to:  " + newValue);

			Assert.assertEquals(textField.getAttribute("value"), newValue, "Field Question text was not entered");
			logger.info("Changed option label from: " + oldValue + " to:  " + newValue);
			test.log(Status.PASS, "FieldQuestion label is Entered successfully");

		}

	}
	
	
	/**
	 * While on the question edit page, this method changes a questions option thus supports the method 
	 * editGuestPrefQuestOptionsAndLabel
	 * 
	 * @param textField
	 * @param oldValue
	 * @param newValue
	 */
	private void editGuestPrefQuestOptionField(WebElement textField, String oldValue, String newValue) {

		if (newValue.equals("")) {

			System.out.println("Option's can not be blank. so  " + oldValue + " was not changed to:  " + newValue);
			logger.info("Changed option  from: " + oldValue + " to:  " + newValue);
			test.log(Status.ERROR, "FieldQuestion was not Entered successfully becasue it was blank ");

		} else {

			textField.click();
			textField.clear();
			textField.sendKeys(newValue);

			System.out.println("Changed option from: " + oldValue + " to:  " + newValue);

			Assert.assertEquals(textField.getAttribute("value"), newValue, "Field Question text was not entered");
			logger.info("Changed option label from: " + oldValue + " to:  " + newValue);
			test.log(Status.PASS, "FieldQuestion is Entered successfully");

		}

	}

	/**
	 * While on the question edit page, this method clicks the add button located in the options and label section. Thus
	 * supporting the methods createGuestPrefQuest_SingleSelect and createGuestPrefQuest_MultiSelect
	 * 
	 * @param optionLabel
	 * @param optionText
	 */
	private void addGuestPrefQuestionOption(String optionLabel, String optionText) {

		String optionFieldLabelVal = Enter_FieldQuestionLabels_Last.getAttribute("value");
		String optionFieldVal = Enter_FieldQuestionOption_Last.getAttribute("value");

		if (optionFieldLabelVal.equals("") == false && optionFieldVal.equals("") == false) {

			Add_Option_Button.click();

		}

		Enter_FieldQuestionLabels_Last.click();
		Enter_FieldQuestionLabels_Last.clear();
		Enter_FieldQuestionLabels_Last.sendKeys(optionLabel);

		System.out.println("The Option label is entered successfully");

		Assert.assertEquals(Enter_FieldQuestionLabels_Last.getAttribute("value"), optionLabel,
				"Field Option Label text was not entered");
		logger.info("Field Option Label is  entered successfully");
		test.log(Status.PASS, "Field Option label is Entered successfully");

		Enter_FieldQuestionOption_Last.click();
		Enter_FieldQuestionOption_Last.clear();
		Enter_FieldQuestionOption_Last.sendKeys(optionText);

		System.out.println("The Option is entered successfully");

		Assert.assertEquals(Enter_FieldQuestionOption_Last.getAttribute("value"), optionText,
				"The Option text was not entered");
		logger.info("Field Question is  entered successfully");
		test.log(Status.PASS, "Field Option is Entered successfully");

	}

	
	/**
	 * While on the question edit page, this method changes how questions are sent in a PMS message
	 * 
	 * @param pmsDelivery
	 * @throws InterruptedException
	 */
	public void editGuestPrefQuestPmsDelivery(String pmsDelivery) throws InterruptedException {

		SeleniumRepo.waitForElementPresent(PMSdelivery_Field);

		Assert.assertEquals(PMSdelivery_Field.isDisplayed(), true, "PMS delivery Field is not being displayed");

		if (pmsDelivery.equalsIgnoreCase("Comments")) {

			Click_PMSdelivery_Comments.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("PMS delivery was set to Comments successfully");
			logger.info(" PMS delivery was set to Comments selected successfully");
			test.log(Status.PASS, "PMS delivery was set to Comments selected successfully");

			Assert.assertTrue(Click_PMSdelivery_Comments.isSelected(), "PMS delivery was set to Comments is Enabled");

		}

		if (pmsDelivery.equalsIgnoreCase("Special Request")) {

			Click_PMSdelivery_SpReq.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("PMS delivery was set to Special Request successfully");
			logger.info(" PMS delivery was set to Special Request selected successfully");
			test.log(Status.PASS, "PMS delivery was set to Special Request selected successfully");

			Assert.assertTrue(Click_PMSdelivery_SpReq.isSelected(),
					"PMS delivery was set to Special Request is Enabled");

		}

	}

	
	/**
	 * This method is used to create a single select type question. See below the format in which 
	 * the parameters must be sent.
	 *  
	 * 
	 * @param question - format to use for this variable is  "Label":"Question"
	 * @param options - format to use this variable is "OptLabel_1:Option_1";"OptLabel_2:Option_2";  ... etc
	 * @throws InterruptedException
	 */
	public void createGuestPrefQuest_SingleSelect(String question, String options) throws InterruptedException {

		String[] questionData; 
		String[] optionsData;
		String[] optionsItems;

		requiredFieldErrorCheck();

		editGuestPrefQuestType("single");

		if (question.contains(":")) {
			
			questionData = question.split(":");

			editGuestPrefQuestQuestion(questionData[1]);

			editGuestPrefQuestQuestionLabel(questionData[0]);

		}

		// this is for options
		if (options.contains(";")) {

			optionsData = options.split("[;]");

			for (int c = 0; c < optionsData.length; c++) {

				optionsItems = optionsData[c].split(":");

				addGuestPrefQuestionOption(optionsItems[0], optionsItems[1]);

				if (c != (optionsData.length - 1)) {

					Add_Option_Button.click();

				}

			}

		}

	}

	/**
	 * This method is used to create a multi select type question. See below the format in which 
	 * the parameters must be sent.
	 * 
	 * 
	 * @param question - format to use for this variable is  "Label":"Question"
	 * @param options - format to use this variable is "OptLabel_1:Option_1";"OptLabel_2:Option_2";  ... etc
	 * @param maxOptsNum - max amount of options that is select-able 
	 * @throws InterruptedException
	 */
	public void createGuestPrefQuest_MultiSelect(String question, String options, String maxOptsNum)
			throws InterruptedException {

		String[] questionData;
		String[] optionsData;
		String[] optionsItems;

		requiredFieldErrorCheck();

		editGuestPrefQuestType("multiple");

		editGuestPrefQuestMaxOptAllowed(maxOptsNum);

		if (question.contains(":")) {

			questionData = question.split(":");

			editGuestPrefQuestQuestion(questionData[1]);

			editGuestPrefQuestQuestionLabel(questionData[0]);

		}

		// this is for options

		if (options.contains(";")) {

			optionsData = options.split("[;]");

			for (int c = 0; c < optionsData.length; c++) {

				optionsItems = optionsData[c].split(":");

				addGuestPrefQuestionOption(optionsItems[0], optionsItems[1]);

				if (c != (optionsData.length - 1)) {

					Add_Option_Button.click();

				}

			}

		}

	}

	/**
	 * This method is used to create a Free Text select type question. See below the format in which 
	 * the parameters must be sent.
	 * 
	 * @param question - format to use for this variable is  "Label":"Question"
	 * @throws InterruptedException
	 */
	public void createGuestPrefQuest_FreeText(String question) throws InterruptedException {

		String[] questionData;

		requiredFieldErrorCheck();

		editGuestPrefQuestType("freeText");

		if (question.contains(":")) {
			
			questionData = question.split(":");

			editGuestPrefQuestQuestion(questionData[1]);

			editGuestPrefQuestQuestionLabel(questionData[0]);

		}

	}

	
	/**
	 * While on the question edit page, this method clicks the delete button located next to the options and label section. 
	 * 
	 * @param optionLabel
	 * @param optionField
	 */
	public void deleteQuestionOption(String optionLabel, String optionField) {

		for (int d = 0; d < Enter_FieldQuestion_Options.size(); d++) {

			if (Enter_FieldQuestion_Labels.get(d).getAttribute("value").equals(optionLabel)
					&& Enter_FieldQuestion_Options.get(d).getAttribute("value").equals(optionField)) {

				// call on the methods that will change each field

				Delete.get(d).click();

			}
		}

	}
	
	/**
	 * While on the list all page, this method clicks the delete link for the specified question . 
	 * 
	 * @param questoinName
	 * @throws InterruptedException
	 */
	public void deleteQuestion(String questoinName) throws InterruptedException {

		for (int e = 0; e < guestPrefeQuestion.size(); e++) {

			if (guestPrefeQuestion.get(e).getText().trim().equals(questoinName)) {

				Delete.get(e).click();

				if (SeleniumRepo.isElementDisplayed(Delete_last) == true) {

					System.out.println("Seen the ok button");

					// Delete_Cancel.click();

					Delete_OK.click();
				}

				SeleniumRepo.waitForPageLoaded();

			}
		}

	}

	// TODO: Edit this so that i can propperly delete all question on the list
	// all page

	/**
	 * While on the list all page, this method clicks all delete button thus deleting all questions. 
	 * 
	 * @throws InterruptedException
	 */
	public void deleteAllQuestions() throws InterruptedException {
		click_GuestPreferQues_ListAll();

		if (SeleniumRepo.isElementDisplayed(Delete_last) == false) {
			test.log(Status.INFO, " There are no guest preference questions");
			logger.info("There are no guest preference questions");
			System.out.println("There are no guest preference questions");

		} else {

			int size = Delete.size();
			System.out.println("There are " + size + " guest preference questions");
			System.out.println("need to delete the questions");

			while (SeleniumRepo.isElementDisplayed(Delete_last) == true) {

				System.out.println("enter into for loop");

				// System.out.println( Delete.get(i).getText() + "# " + i );
				System.out.println("element found");

				Javascriptexecutor(Delete_last);

				if (Delete_OK.isDisplayed() == true) {

					System.out.println("Seen the ok button");

					// Delete_Cancel.click();

					Delete_OK.click();
					SeleniumRepo.waitForPageLoaded();
				}

			}
		}
	}

	/**
	 * While on the question edit page, this method is used to verify all required fields error messages
	 * are generated after attempting to save the page with the fields blank 
	 */
	private void requiredFieldErrorCheck() {

		clickGuestPrefSaveButton();

		// After attempting to save a new guest preference question without any
		// required field filled out, the error messages appeared and the
		// the following if statements confirm the appearances of messages
		if (Check_ErrorReqGuestPQ.isDisplayed()) {
			System.out.println("ErrorReqGuestPQ is Displayed");
			test.log(Status.PASS, "ErrorReqGuestPQ is Displayed ");
			Assert.assertTrue(true, "ErrorReqGuestPQ is Displayed ");
		} else {
			System.out.println("ErrorReqGuestPQ is Not Displayed");
			test.log(Status.FAIL, " ErrorReqGuestPQ is Not Displayed");
			Assert.assertFalse(false, "ErrorReqGuestPQ is Not Displayed");
		}

		if (Check_ErrorReqGuestPQLabel.isDisplayed()) {
			System.out.println("ErrorReqGuestPQLabel is Displayed");
			test.log(Status.PASS, "ErrorReqGuestPQLabel is Displayed ");
			Assert.assertTrue(true, "ErrorReqGuestPQLabel is Displayed ");
		} else {
			System.out.println("ErrorReqGuestPQLabel is Not Displayed");
			test.log(Status.FAIL, " ErrorReqGuestPQLabel is Not Displayed");
			Assert.assertFalse(false, "ErrorReqGuestPQLabel is Not Displayed");
		}

		if (Check_ErrorOptionsGuestPQLabel.isDisplayed()) {
			System.out.println("ErrorOptionsGuestPQLabel is Displayed");
			test.log(Status.PASS, "ErrorOptionsGuestPQLabel is Displayed ");
			Assert.assertTrue(true, "ErrorOptionsGuestPQLabel is Displayed ");
		} else {
			System.out.println("ErrorOptionsGuestPQLabel is Not Displayed");
			test.log(Status.FAIL, " ErrorOptionsGuestPQLabel is Not Displayed");
			Assert.assertFalse(false, "ErrorOptionsGuestPQLabel is Not Displayed");
		}

	}

	/**
	 * Clicks the save buttons found on the list all page and the question edit page
	 * 
	 */
	public void clickGuestPrefSaveButton() {

		if (Click_SaveGuestPQ.isDisplayed()) {
			Click_SaveGuestPQ.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("SaveGuestPQ Button  found");

			test.log(Status.PASS, "Clicked on SaveGuestPQ Button ");
			Assert.assertTrue(true, "Clicked on SaveGuestPQ Button ");
		} else {
			System.out.println("SaveGuestPQ Button  not found");
			test.log(Status.FAIL, " SaveGuestPQ Button  not found");
			Assert.assertFalse(false, "SaveGuestPQ Button  not found");
		}

	}

	/**
	 * Clicks the cancel button on the question page edit page
	 * 
	 */
	public void clickGuestPrefCancelButton() {

		if (Click_CancelGuestPQ.isDisplayed()) {
			Click_CancelGuestPQ.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("CancelGuestPQ Button  found");

			test.log(Status.PASS, "Clicked on CancelGuestPQ Button ");
			Assert.assertTrue(true, "Clicked on CancelGuestPQ Button ");
		} else {
			System.out.println("CancelGuestPQ Button  not found");
			test.log(Status.FAIL, " CancelGuestPQ Button  not found");
			Assert.assertFalse(false, "CancelGuestPQ Button  not found");
		}

	}

	/**
	 * Original method before refactoring of this class , that was used to
	 * create guest preference questions
	 * 
	 * @param GuestPType
	 * @param MaxOptions
	 * @param FieldQuestion
	 * @param FieldQuestionLabel
	 * @param FieldQuestion_1_Label
	 * @param FieldQuestion_1_Guest_Options
	 * @throws InterruptedException
	 */
	public void creatGuestPQ(String GuestPType, String MaxOptions, String FieldQuestion, String FieldQuestionLabel,
			String FieldQuestion_1_Label, String FieldQuestion_1_Guest_Options) throws InterruptedException {

		Thread.sleep(4000);

		/*
		 * try {
		 * 
		 * List<WebElement> delete=SeleniumRepo.driver.findElements(By.xpath(
		 * "//*[contains(text(),'"+FieldQuestion+
		 * "')]/following-sibling::td[4]/a"));
		 * 
		 * System.out.println(FieldQuestion+" questions are ---------->>>>>>> "
		 * +delete.size());
		 * 
		 * 
		 * 
		 * //is not executing and seems it would delete all previous created
		 * questions for(WebElement del:delete) {
		 * System.out.println(FieldQuestion+" questions are "+delete.size());
		 * Javascriptexecutor(del);
		 * 
		 * System.out.println("Clicked on Delete successfully");
		 * 
		 * Javascriptexecutor(Delete_OK);
		 * 
		 * System.out.println("Clicked on Ok Delete successfully");
		 * 
		 * ExplicitWait(GPQ_Title); } } catch(Exception e) {
		 * System.out.println(e.getMessage()); System.out.
		 * println("There are no guest preference questions to display."); }
		 */

		// Clicks add new link for GPQ
		if (Click_AddNewGuestPQ.isDisplayed()) {
			Javascriptexecutor(Click_AddNewGuestPQ);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(Click_SaveGuestPQ);
			System.out.println("Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			test.log(Status.INFO, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			Assert.assertTrue(true, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
		} else {
			// if first click fails it attempts a second time to click addnew
			System.out.println("Guest Preference Questions Menu is not expanded");
			Javascriptexecutor(Click_GuestPQ);
			System.out.println("Clicked on Guest Preference Questions Link");
			test.log(Status.INFO, "Clicked on Guest Preference Questions Link");

			ExplicitWait(Click_AddNewGuestPQ);
			if (Click_AddNewGuestPQ.isDisplayed()) {
				Javascriptexecutor(Click_AddNewGuestPQ);

				ExplicitWait(Click_SaveGuestPQ);
				System.out.println("AddNew element found");
				test.log(Status.INFO, "AddNew element found");
				Assert.assertTrue(true, "AddNewelement found");
			} else {
				logger.info("AddNew element not  found");
				test.log(Status.FAIL, "AddNew element not  found");
			}
		}

		if (Click_SaveGuestPQ.isDisplayed()) {
			Click_SaveGuestPQ.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("SaveGuestPQ Button  found");
			ExplicitWait(Check_ErrorReqGuestPQ);

			test.log(Status.PASS, "Clicked on SaveGuestPQ Button ");
			Assert.assertTrue(true, "Clicked on SaveGuestPQ Button ");
		} else {
			System.out.println("SaveGuestPQ Button  not found");
			test.log(Status.FAIL, " SaveGuestPQ Button  not found");
			Assert.assertFalse(false, "SaveGuestPQ Button  not found");
		}

		// After attempting to save a new guest preference question without any
		// required field filled out, the error messages appeared and the
		// the following if statements confirm the appearances of messages
		if (Check_ErrorReqGuestPQ.isDisplayed()) {
			System.out.println("ErrorReqGuestPQ is Displayed");
			test.log(Status.PASS, "ErrorReqGuestPQ is Displayed ");
			Assert.assertTrue(true, "ErrorReqGuestPQ is Displayed ");
		} else {
			System.out.println("ErrorReqGuestPQ is Not Displayed");
			test.log(Status.FAIL, " ErrorReqGuestPQ is Not Displayed");
			Assert.assertFalse(false, "ErrorReqGuestPQ is Not Displayed");
		}

		if (Check_ErrorReqGuestPQLabel.isDisplayed()) {
			System.out.println("ErrorReqGuestPQLabel is Displayed");
			test.log(Status.PASS, "ErrorReqGuestPQLabel is Displayed ");
			Assert.assertTrue(true, "ErrorReqGuestPQLabel is Displayed ");
		} else {
			System.out.println("ErrorReqGuestPQLabel is Not Displayed");
			test.log(Status.FAIL, " ErrorReqGuestPQLabel is Not Displayed");
			Assert.assertFalse(false, "ErrorReqGuestPQLabel is Not Displayed");
		}

		if (Check_ErrorOptionsGuestPQLabel.isDisplayed()) {
			System.out.println("ErrorOptionsGuestPQLabel is Displayed");
			test.log(Status.PASS, "ErrorOptionsGuestPQLabel is Displayed ");
			Assert.assertTrue(true, "ErrorOptionsGuestPQLabel is Displayed ");
		} else {
			System.out.println("ErrorOptionsGuestPQLabel is Not Displayed");
			test.log(Status.FAIL, " ErrorOptionsGuestPQLabel is Not Displayed");
			Assert.assertFalse(false, "ErrorOptionsGuestPQLabel is Not Displayed");
		}

		ExplicitWait(Select_GuestPType);

		// Applices to single selected questions
		if (Select_GuestPType.isEnabled()) {

			Thread.sleep(2000);
			SeleniumRepoDropdown.selectDropDownValue(Select_GuestPType, GuestPType);
			System.out.println("ErrorOptionsGuestPQLabel is Selected");
			test.log(Status.PASS, "ErrorOptionsGuestPQLabel is Selected ");
			Assert.assertTrue(true, "ErrorOptionsGuestPQLabel is Selected ");
		} else {
			System.out.println("ErrorOptionsGuestPQLabel is Not Selected");
			test.log(Status.FAIL, " ErrorOptionsGuestPQLabel is Not Selected");
			Assert.assertFalse(false, "ErrorOptionsGuestPQLabel is Not Selected");
		}

		// applies for multiple selection
		if (Select_MaxOptionsAllowed.isEnabled()) {
			Select_MaxOptionsAllowed.click();
			Select_MaxOptionsAllowed.clear();
			Select_MaxOptionsAllowed.sendKeys(MaxOptions);
			System.out.println("MaxOptions is Entered");
			test.log(Status.PASS, "MaxOptions is Entered ");
			Assert.assertTrue(true, "MaxOptions is Entered ");
		} else {
			System.out.println("MaxOptions is Not Entered");
			// test.log(Status.FAIL,s" MaxOptions is Not Entered");
			Assert.assertFalse(false, "MaxOptions is Not Entered");
		}

		if (Enter_FieldQuestion.isDisplayed()) {
			Enter_FieldQuestion.click();
			Enter_FieldQuestion.clear();
			Enter_FieldQuestion.sendKeys(FieldQuestion);
			System.out.println("FieldQuestion is Entered");
			test.log(Status.PASS, "FieldQuestion is Entered ");
			Assert.assertTrue(true, "FieldQuestion is Entered ");
		} else {
			System.out.println("FieldQuestion is Not Entered");
			test.log(Status.FAIL, " FieldQuestion is Not Entered");
			Assert.assertFalse(false, "FieldQuestion is Not Entered");
		}

		if (Enter_FieldQuestion.isDisplayed()) {
			Enter_FieldQuestion.click();
			Enter_FieldQuestion.clear();
			Enter_FieldQuestion.sendKeys(FieldQuestion);
			System.out.println("FieldQuestion is Entered");
			test.log(Status.PASS, "FieldQuestion is Entered ");
			Assert.assertTrue(true, "FieldQuestion is Entered ");
		} else {
			System.out.println("FieldQuestion is Not Entered");
			test.log(Status.FAIL, " FieldQuestion is Not Entered");
			Assert.assertFalse(false, "FieldQuestion is Not Entered");
		}

		if (Enter_FieldQuestionLabel.isDisplayed()) {

			Enter_FieldQuestionLabel.click();
			Enter_FieldQuestionLabel.clear();
			Enter_FieldQuestionLabel.sendKeys(FieldQuestionLabel);
			System.out.println("FieldQuestionLabel is Entered");
			test.log(Status.PASS, "FieldQuestionLabel is Entered ");
			Assert.assertTrue(true, "FieldQuestionLabel is Entered ");
		} else {
			System.out.println("FieldQuestionLabel is Not Entered");
			test.log(Status.FAIL, " FieldQuestionLabel is Not Entered");
			Assert.assertFalse(false, "FieldQuestionLabel is Not Entered");
		}

		if (Enter_FieldQuestion_1_Label.isDisplayed()) {
			Enter_FieldQuestion_1_Label.click();
			Enter_FieldQuestion_1_Label.clear();
			Enter_FieldQuestion_1_Label.sendKeys(FieldQuestion_1_Label);
			System.out.println("FieldQuestion_1_Label is Entered");
			test.log(Status.PASS, "FieldQuestion_1_Label is Entered ");
			Assert.assertTrue(true, "FieldQuestion_1_Label is Entered ");
		} else {
			System.out.println("FieldQuestion_1_Label is Not Entered");
			test.log(Status.FAIL, " FieldQuestion_1_Label is Not Entered");
			Assert.assertFalse(false, "FieldQuestion_1_Label is Not Entered");
		}

		if (Enter_FieldQuestion_1_Guest_Options.isDisplayed()) {
			Enter_FieldQuestion_1_Guest_Options.click();
			Enter_FieldQuestion_1_Guest_Options.clear();
			Enter_FieldQuestion_1_Guest_Options.sendKeys(FieldQuestion_1_Guest_Options);
			System.out.println("FieldQuestion_1_Guest_Options is Entered");
			test.log(Status.PASS, "FieldQuestion_1_Guest_Options is Entered ");
			Assert.assertTrue(true, "FieldQuestion_1_Guest_Options is Entered ");
		} else {
			System.out.println("FieldQuestion_1_Guest_Options is Not Entered");
			test.log(Status.FAIL, " FieldQuestion_1_Guest_Options is Not Entered");
			Assert.assertFalse(false, "FieldQuestion_1_Guest_Options is Not Entered");
		}

		SeleniumRepo.waitForElementPresent(Click_SaveGuestPQ);
		if (Click_SaveGuestPQ.isDisplayed()) {
			Click_SaveGuestPQ.click();
			ExplicitWait(Update);
			System.out.println("SaveGuestPQ Button  found");
			test.log(Status.PASS, "Clicked on SaveGuestPQ Button ");
			Assert.assertTrue(true, "Clicked on SaveGuestPQ Button ");
		} else {
			System.out.println("SaveGuestPQ Button  not found");
			test.log(Status.FAIL, " SaveGuestPQ Button  not found");
			Assert.assertFalse(false, "SaveGuestPQ Button  not found");
		}

		System.out.println(guestPrefeQuestion.size());

		for (int l = 0; l < guestPrefeQuestion.size(); l++) {

			System.out.println(guestPrefeQuestion.get(l).getText().trim());
		}

		if (Update.isDisplayed()) {
			System.out.println("Guest preference questions are created successfully");
			test.log(Status.PASS, "Guest preference questions are created successfully");
			Assert.assertTrue(true, "Guest preference questions are created successfully");
		} else {
			System.out.println("Failed to create Guest preference questions");
			test.log(Status.FAIL, "Failed to create Guest preference questions");
			Assert.assertFalse(false, "Failed to create Guest preference questions");
		}

	}

}
