/**
 * 
 */
package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * @author DM
 *
 */
public class EmailRetargeting extends BaseTest {

	@FindAll({ @FindBy(xpath = "//tr[2]/td[contains(text(),'Enabled')]") })
	public WebElement GeneralOpt_Enabled_Field;

	@FindAll({ @FindBy(xpath = "//*[@id='emailRetargetingOptionEnabledId']") })
	public WebElement GeneralOpt_Enabled_RadioButton;

	@FindAll({ @FindBy(xpath = "//*[@id='emailRetargetingOptionDisabedId']") })
	public WebElement GeneralOpt_DisEnable_RadioButton;

	@FindAll({ @FindBy(xpath = "//*[@id='emailRetargetingOptionSelectedId']") })
	public WebElement GeneralOpt_UpdateEnabledOpt_RadioButton;

	@FindAll({ @FindBy(xpath = "//*[@id='enableOptions']") })
	public WebElement GeneralOpt_UpdateEnabledOpt_DropDown;

	@FindAll({ @FindBy(xpath = "//*[@id='enableOptionsLabel']") })
	public WebElement GeneralOpt_EnterRateClassificationCodes_Field;

	// Add tag button
	@FindAll({ @FindBy(xpath = "//*[@id='ratePlanCodes_tag']") })
	public WebElement GeneralOpt_EnterRateClassificationCodes_TextField;

	  //*[@id='ratePlanCodes_tagsinput']/span/span or //span[@class='tag'] -> use for list of items in the tag text area
	@FindAll({ @FindBy(xpath = "//span[@class='tag']") })
	public List<WebElement> All_EnterRateClassificationCodes;

	@FindAll({ @FindBy(xpath = "//a[@title='Removing tag']") })
	public List<WebElement> All_EnterRateClassificationCodes_RemoveLink;

	// Set in hours
	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Time Lapse')]") })
	public WebElement GeneralOpt_TimeLapse_Field;

	@FindAll({ @FindBy(xpath = "//input[@name='timeLapseBeforeEmailRecovery']") })
	private WebElement GeneralOpt_TimeLapse_TextField;

	@FindAll({ @FindBy(xpath = "//tr[3]/td[contains(text(),'Enabled')]") })
	public WebElement RatePlanRetar_Enabled_Field;

	@FindAll({ @FindBy(xpath = "//*[@id='ratePlanRetargettingEnabledId']") })
	private WebElement RatePlanRetar_Enabled_RadioButton;

	@FindAll({ @FindBy(xpath = "//input[@name='ratePlanRetargettingEnabled' and @value='false']") })
	private WebElement RatePlanRetar_DisEnable_RadioButton;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Time Lapse')]") })
	public WebElement RatePlanRetar_ExpirationTime_Field;

	@FindAll({ @FindBy(xpath = "//input[@id='expirationHoursId']") })
	private WebElement RatePlanRetar_ExpirationTime_TextField;

	@FindAll({ @FindBy(xpath = "//*[@id='rateCodeId']") })
	private WebElement RatePlanRetar_RateCode_RadioButton;

	@FindAll({ @FindBy(xpath = "//input[@name='rateCode' and  @value='false']") })
	private WebElement RatePlanRetar_CompoundCode_RadioButton;

	@FindAll({ @FindBy(xpath = "//input[@id='rateTypeCodeId']") })
	private WebElement RatePlanRetar_Code_TextField;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Greeting')]") })
	public WebElement EmailOpt_Greeting_Field;

	@FindAll({ @FindBy(xpath = "//*[@id='emailGreetingId']") })
	public WebElement EmailOpt_Greeting_TextField;

	@FindAll({ @FindBy(xpath = "//*[@id='emailNameOptionId']") })
	public WebElement EmailOpt_Name_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Subject')]") })
	public WebElement EmailOpt_Subject_Label;

	@FindAll({ @FindBy(xpath = "//*[@id='emailSubjectId']") })
	public WebElement EmailOpt_Subject_TextField;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Email Body')]") })
	public WebElement EmailOpt_Body_Label;

	@FindAll({ @FindBy(xpath = "//*[@id='emailBodyId']") })
	public WebElement EmailOpt_Body_TextField;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Overall')]") })
	public WebElement CustomizeOpt_Overall_Field;

	@FindAll({ @FindBy(xpath = "//*[@id='wholeBackgroundColorId']") })
	public WebElement CustomizeOpt_Overall_BackgroundColor;

	@FindAll({ @FindBy(xpath = "//*[@id='bodyFontColorId']") })
	public WebElement CustomizeOpt_Overall_FontColor;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Reservation Summary')]") })
	public WebElement CustomizeOpt_ReservationSummary_Field;

	@FindAll({ @FindBy(xpath = "//*[@id='reservationSummaryContainerBackgroundColorId']") })
	public WebElement CustomizeOpt_ReservationSum_BackgroundColor;

	@FindAll({ @FindBy(xpath = "//*[@id='reservationSummaryContainerFontColorId']") })
	public WebElement CustomizeOpt_ReservationSum_FontColor;

	@FindAll({ @FindBy(xpath = "//td[text()='Book It Button']") })
	public WebElement CustomizeOpt_BookItButton_Field;

	@FindAll({ @FindBy(xpath = "//*[@id='bookItButtonFontColorId']") })
	public WebElement CustomizeOpt_BookItButton_FontColor;

	@FindAll({ @FindBy(xpath = "//*[@id='bookItButtonBackgroundColorId']") })
	public WebElement CustomizeOpt_BookItButton_BackgroundColor;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Book It Button Label')]") })
	public WebElement CustomizeOpt_BookItButtonLabel_Field;

	@FindAll({ @FindBy(xpath = "//*[@id='bookItButtonLabelId']") })
	public WebElement CustomizeOpt_BookItButtonLable_TextField;

	@FindAll({ @FindBy(xpath = "//*[@name='resetcolors']") })
	public WebElement CustomizeOpt_ResetToDefaults_Button;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	private WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(linkText = "Email Retargeting"),
			@FindBy(xpath = "//a[normalize-space()='Email Retargeting']"), })
	private WebElement emailRetargeting_link;

	@FindAll({ @FindBy(xpath = "//input[@name='save']") })
	private WebElement save_button;

	@FindAll({ @FindBy(xpath = "//input[@name='cancel']") })
	private WebElement cancel_button;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	
	public void navigateToEmailRetargeting_Pg() {

		try {
			if (emailRetargeting_link.isDisplayed()) {
				Javascriptexecutor(emailRetargeting_link);

				SeleniumRepo.waitForPageLoaded();

				System.out.println("PropertyManagement element Expanded and Email Retargeting element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and Email Retargeting element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and Email Retargeting element  found");
			} else {
				System.out.println("PropertyManagement Menu is not expanded");
				SeleniumRepo.scrollintoview(Click_PropertyManagement);
				Thread.sleep(2000);
				Javascriptexecutor(Click_PropertyManagement);
				Thread.sleep(2000);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(emailRetargeting_link);
				if (emailRetargeting_link.isDisplayed()) {
					Javascriptexecutor(emailRetargeting_link);

					SeleniumRepo.waitForPageLoaded();

					System.out.println("Email Retargeting element found");
					test.log(Status.INFO, "Email Retargeting element found");
					Assert.assertTrue(true, "Email Retargeting element found");
				} else {
					logger.info("Email Retargeting element not  found");
					test.log(Status.FAIL, "Email Retargeting element not  found");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickGeneralOptEnabledButton() throws InterruptedException {

		SeleniumRepo.waitForElementPresent(GeneralOpt_Enabled_Field);

		Assert.assertEquals(GeneralOpt_Enabled_Field.isDisplayed(), true,
				"GeneralOpt Enable Radio Button  Field is not being displayed");

		GeneralOpt_Enabled_RadioButton.click();

		SeleniumRepo.WaitForLoad(1000);

		System.out.println("General Option Enable Radio Button is enabled successfully");
		logger.info("General Option Enable Radio Button  selected successfully");
		test.log(Status.PASS, "General Option Enable Radio Button selected successfully");
		Assert.assertTrue(GeneralOpt_Enabled_RadioButton.isSelected(),
				"General Option Enable Radio Button  is Enabled");

	}

	public void clickGeneralOptDisabledButton() throws InterruptedException {

		SeleniumRepo.waitForElementPresent(GeneralOpt_Enabled_Field);

		Assert.assertEquals(GeneralOpt_Enabled_Field.isDisplayed(), true,
				"GeneralOpt DisEnable Radio Button is not being displayed");

		GeneralOpt_DisEnable_RadioButton.click();

		SeleniumRepo.WaitForLoad(1000);

		System.out.println("GeneralOpt DisEnable Radio Button is enabled successfully");
		logger.info("GeneralOpt DisEnable Radio Button selected successfully");
		test.log(Status.PASS, "GeneralOpt DisEnable Radio Button selected successfully");
		Assert.assertTrue(GeneralOpt_DisEnable_RadioButton.isSelected(),
				"GeneralOpt DisEnable Radio Button is Enabled");

	}

	public void clickGeneralOptdUpdateEnableButton(String dropDownOption) {

		try {

			SeleniumRepo.waitForElementPresent(GeneralOpt_Enabled_Field);

			Assert.assertEquals(GeneralOpt_Enabled_Field.isDisplayed(), true,
					"Update Enabled Option Radio Button is not being displayed");

			GeneralOpt_UpdateEnabledOpt_RadioButton.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Update Enabled Option Radio Button is enabled successfully");
			logger.info("Update Enabled Option Radio Button selected successfully");
			test.log(Status.PASS, "Update Enabled Option Radio Button selected successfully");
			Assert.assertTrue(GeneralOpt_UpdateEnabledOpt_RadioButton.isSelected(),
					"Update Enabled Option Radio Button is Enabled");

			Assert.assertEquals(GeneralOpt_UpdateEnabledOpt_DropDown.isDisplayed(), true,
					"Update Enabled Option Field is not being displayed");

			GeneralOpt_UpdateEnabledOpt_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(GeneralOpt_UpdateEnabledOpt_DropDown, dropDownOption);

			System.out.println("Update Enabled Option Type was selected or changed successfully");

			logger.info("Update Enabled Option Type was selected or changed successfully");
			test.log(Status.PASS, "Update Enabled Option Type was selected or changed successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit Update Enabled Option Type field,  for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit Update Enabled Option Type field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	
	/**
	 * This method will only work, when clickGeneralOptdUpdateEnableButton is enabled
	 * 
	 * @param EnterRatesCodes
	 */
	public void editGeneralOptEnterRateCodes(String EnterRatesCodes) {

		SeleniumRepo.waitForElementPresent(GeneralOpt_EnterRateClassificationCodes_Field);

		Assert.assertEquals(GeneralOpt_EnterRateClassificationCodes_Field.isDisplayed(), true,
				"Enter Rate Codes text Field is not being displayed");

		deleteGeneralOptEnterRateCodes(EnterRatesCodes);

		GeneralOpt_EnterRateClassificationCodes_TextField.click();

		GeneralOpt_EnterRateClassificationCodes_TextField.sendKeys(EnterRatesCodes);

		// clicking outside of the text area so that the code will be added
		GeneralOpt_EnterRateClassificationCodes_Field.click();

		System.out.println("Enter Rate Codes is entered successfully");

		// Assert.assertEquals(GeneralOpt_EnterRateClassificationCodes_TextField.getAttribute("value"),
		// EnterRatesCodes,"Enter Rate Codes Field text was not entered");
		logger.info("Enter Rate Codes is entered successfully");
		test.log(Status.PASS, "Enter Rate Codes is entered successfully");

	}

	private void deleteGeneralOptEnterRateCodes(String EnterRatesCodes) {

		// if the code already is present below will remove it
		for (int l = 0; l < All_EnterRateClassificationCodes.size(); l++) {

			// System.out.println(
			// All_EnterRateClassificationCodes.get(l).getText() );

			String codeName = All_EnterRateClassificationCodes.get(l).getText().split(" ")[0];

			System.out.println(codeName);

			if (codeName.equalsIgnoreCase(EnterRatesCodes)) {

				All_EnterRateClassificationCodes_RemoveLink.get(l).click();

			}

		}

	}

	public void editGeneralOptTimeLapse(String EnterTimeLapse) {

		SeleniumRepo.waitForElementPresent(GeneralOpt_TimeLapse_Field);

		Assert.assertEquals(GeneralOpt_TimeLapse_Field.isDisplayed(), true,
				"General Option Time Lapse text Field is not being displayed");

		GeneralOpt_TimeLapse_TextField.click();
		GeneralOpt_TimeLapse_TextField.clear();
		GeneralOpt_TimeLapse_TextField.sendKeys(EnterTimeLapse);

		System.out.println("General Option Time Lapse is entered successfully");

		Assert.assertEquals(GeneralOpt_TimeLapse_TextField.getAttribute("value"), EnterTimeLapse,
				"General Option Time Lapse text was not entered");
		logger.info("Geneal Option Time Lapse is entered successfully");
		test.log(Status.PASS, "Geneal Option Time Lapse is entered successfully");

	}

	public void clickRatePlanEnabled(String status) throws InterruptedException {

		SeleniumRepo.waitForElementPresent(RatePlanRetar_Enabled_Field);

		Assert.assertEquals(RatePlanRetar_Enabled_Field.isDisplayed(), true,
				"Rate Plan Retargeting Enabled Field is not being displayed");

		if (status.equalsIgnoreCase("enable")) {

			RatePlanRetar_Enabled_RadioButton.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Rate Plan Retargeting Enabled is enabled successfully");
			logger.info("Rate Plan Retargeting Enabled selected successfully");
			test.log(Status.PASS, "Rate Plan Retargeting Enabled selected successfully");
			Assert.assertTrue(RatePlanRetar_Enabled_RadioButton.isSelected(),
					"Rate Plan Retargeting Enabled is Enabled");

		} else {

			RatePlanRetar_DisEnable_RadioButton.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Rate Plan Retargeting Enabled is disable successfully ");
			logger.error("Disable Rate Plan Retargeting");
			test.log(Status.PASS, "Disable Rate Plan Retargeting");

			Assert.assertTrue(RatePlanRetar_DisEnable_RadioButton.isSelected(), " Rate Plan Retargeting is disable");

		}

	}

	public void editRatePlanExpiartionTime(String EnterExpirationTime) {

		SeleniumRepo.waitForElementPresent(RatePlanRetar_ExpirationTime_Field);

		Assert.assertEquals(RatePlanRetar_ExpirationTime_Field.isDisplayed(), true,
				"Expiration Time text Field is not being displayed");

		RatePlanRetar_ExpirationTime_TextField.click();
		RatePlanRetar_ExpirationTime_TextField.clear();
		RatePlanRetar_ExpirationTime_TextField.sendKeys(EnterExpirationTime);

		System.out.println("Expiration Time is entered successfully");

		Assert.assertEquals(RatePlanRetar_ExpirationTime_TextField.getAttribute("value"), EnterExpirationTime,
				"Expiration Time Field text was not entered");
		logger.info("Expiration Time is entered successfully");
		test.log(Status.PASS, "Expiration Time is entered successfully");

	}

	public void clickRatePlanRateCode() throws InterruptedException {

		SeleniumRepo.waitForElementPresent(RatePlanRetar_RateCode_RadioButton);

		Assert.assertEquals(RatePlanRetar_RateCode_RadioButton.isDisplayed(), true,
				"Rate Code  is not being displayed");

		RatePlanRetar_RateCode_RadioButton.click();

		SeleniumRepo.WaitForLoad(100);

		System.out.println("Rate Code is enabled successfully");
		logger.info("Rate Code  selected successfully");
		test.log(Status.PASS, "Rate Code  selected successfully");
		Assert.assertTrue(RatePlanRetar_RateCode_RadioButton.isSelected(), "Rate Code is Enabled");

	}

	public void clickRatePlanRateCompoundAccessCode() throws InterruptedException {

		SeleniumRepo.waitForElementPresent(RatePlanRetar_CompoundCode_RadioButton);

		Assert.assertEquals(RatePlanRetar_CompoundCode_RadioButton.isDisplayed(), true,
				"House Level Inventory Field is not being displayed");

		RatePlanRetar_CompoundCode_RadioButton.click();

		SeleniumRepo.WaitForLoad(100);

		System.out.println("Compound Access Code is enabled successfully");
		logger.info("Compound Access Code selected successfully");
		test.log(Status.PASS, "Compound Access Code selected successfully");
		Assert.assertTrue(RatePlanRetar_CompoundCode_RadioButton.isSelected(), "Compound Access Code is Enabled");

	}

	public void editRatePlanRateOrCompoundCode(String EnterRateOrCompCode) {

		SeleniumRepo.waitForElementPresent(RatePlanRetar_Code_TextField);

		Assert.assertEquals(RatePlanRetar_Code_TextField.isDisplayed(), true,
				"The Rate or Compound Access code text Field is not being displayed");

		RatePlanRetar_Code_TextField.click();
		RatePlanRetar_Code_TextField.clear();
		RatePlanRetar_Code_TextField.sendKeys(EnterRateOrCompCode);

		System.out.println("The Rate or Compound Access code is entered successfully");

		Assert.assertEquals(RatePlanRetar_Code_TextField.getAttribute("value"), EnterRateOrCompCode,
				"The Rate or Compound Access code text was not entered");
		logger.info("The Rate or Compound Access code is entered successfully");
		test.log(Status.PASS, "The Rate or Compound Access code is entered successfully");

	}

	public void editEmailOptGreeting(String EnterGreeting) {

		SeleniumRepo.waitForElementPresent(EmailOpt_Greeting_Field);

		Assert.assertEquals(EmailOpt_Greeting_Field.isDisplayed(), true, "Greeting text Field is not being displayed");

		EmailOpt_Greeting_TextField.click();
		EmailOpt_Greeting_TextField.clear();
		EmailOpt_Greeting_TextField.sendKeys(EnterGreeting);

		System.out.println("Greeting is entered successfully");

		Assert.assertEquals(EmailOpt_Greeting_TextField.getAttribute("value"), EnterGreeting,
				"Greeting Field text was not entered");
		logger.info("Greeting is entered successfully");
		test.log(Status.PASS, "Greeting is entered successfully");

	}

	public void editEmailOptGreetingNameTypeSelection(String SelectGreetingNameType) {

		try {

			SeleniumRepo.waitForElementPresent(EmailOpt_Greeting_Field);

			Assert.assertEquals(EmailOpt_Greeting_Field.isDisplayed(), true, "Greeting Field is not being displayed");

			EmailOpt_Name_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(EmailOpt_Name_DropDown, SelectGreetingNameType);

			System.out.println("Greeting" + SelectGreetingNameType + " was selected or changed successfully");

			logger.info("Greeting Name Type was selected or changed successfully");
			test.log(Status.PASS, "Greeting Name Type was selected or changed successfully");

		} catch (Exception e) {
			logger.error("Unable to edit Greeting Name Type field,  for Email Option because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to edit Greeting Name Type field, for Email Option because of this execption" + e);
			e.printStackTrace();
		}

	}

	public void editEmailOptSubject(String EnterSubject) {

		SeleniumRepo.waitForElementPresent(EmailOpt_Subject_Label);

		Assert.assertEquals(EmailOpt_Subject_Label.isDisplayed(), true, "Subject text Field is not being displayed");

		EmailOpt_Subject_TextField.click();
		EmailOpt_Subject_TextField.clear();
		EmailOpt_Subject_TextField.sendKeys(EnterSubject);

		System.out.println("Subject is entered successfully");

		Assert.assertEquals(EmailOpt_Subject_TextField.getAttribute("value"), EnterSubject,
				"Subject Field text was not entered");
		logger.info("Subject is entered successfully");
		test.log(Status.PASS, "Subject is entered successfully");

	}

	public void editEmailOptEmailBody(String EnterEmailBody) {

		SeleniumRepo.waitForElementPresent(EmailOpt_Body_Label);

		Assert.assertEquals(EmailOpt_Body_Label.isDisplayed(), true, "Email Body text Field is not being displayed");

		EmailOpt_Body_TextField.click();
		EmailOpt_Body_TextField.clear();
		EmailOpt_Body_TextField.sendKeys(EnterEmailBody);

		System.out.println("Email Body is entered successfully");

		Assert.assertEquals(EmailOpt_Body_TextField.getAttribute("value"), EnterEmailBody,
				"Email Body Field text was not entered");
		logger.info("Email Body is entered successfully");
		test.log(Status.PASS, "Email Body is entered successfully");

	}

	/*
	 * NoTE Start: The methods below interact with the Retargeting email Color fields,
	 * currently these methods are only executable for chrome. Edge and Firefox
	 * are not interpreting the fields as text fields thus the methods are not 
	 * interacting with the text fields.
	 * 
	 */

	public void editCustomOptOverallBackColor(String EnterBackGroundColor) {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_Overall_Field);

		Assert.assertEquals(CustomizeOpt_Overall_Field.isDisplayed(), true,
				"Overall Background text Field is not being displayed");

		CustomizeOpt_Overall_BackgroundColor.click();
		CustomizeOpt_Overall_BackgroundColor.clear();
		CustomizeOpt_Overall_BackgroundColor.sendKeys(EnterBackGroundColor);

		System.out.println("Overall Background text  is entered successfully");

		Assert.assertEquals(CustomizeOpt_Overall_BackgroundColor.getAttribute("value"), EnterBackGroundColor,
				"Overall Background text Field text was not entered");
		logger.info("Overall Background text is entered successfully");
		test.log(Status.PASS, "Overall Background text is entered successfully");

	}

	public void editCustomOptOverallFontColor(String EnterFontColor) {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_Overall_Field);

		Assert.assertEquals(CustomizeOpt_Overall_Field.isDisplayed(), true,
				"Overall Font text Field is not being displayed");

		CustomizeOpt_Overall_FontColor.click();
		CustomizeOpt_Overall_FontColor.clear();
		CustomizeOpt_Overall_FontColor.sendKeys(EnterFontColor);

		System.out.println("Overall Font text is entered successfully");

		Assert.assertEquals(CustomizeOpt_Overall_FontColor.getAttribute("value"), EnterFontColor,
				"Overall Font Field text was not entered");
		logger.info("Overall Font is entered successfully");
		test.log(Status.PASS, "Overall Font is entered successfully");

	}

	public void editCustomOptResSummaryBackColor(String EnterBackGroundColor) {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_ReservationSummary_Field);

		Assert.assertEquals(CustomizeOpt_ReservationSummary_Field.isDisplayed(), true,
				"Reservation Summary text  Field is not being displayed");

		CustomizeOpt_ReservationSum_BackgroundColor.click();
		CustomizeOpt_ReservationSum_BackgroundColor.clear();
		CustomizeOpt_ReservationSum_BackgroundColor.sendKeys(EnterBackGroundColor);

		System.out.println("Reservation Summary Background text  is entered successfully");

		Assert.assertEquals(CustomizeOpt_ReservationSum_BackgroundColor.getAttribute("value"), EnterBackGroundColor,
				"Reservation Summary Background Field text was not entered");
		logger.info("Reservation Summary Background text  is entered successfully");
		test.log(Status.PASS, "Reservation Summary Background text  is entered successfully");

	}

	public void editCustomOptResSummaryFontColor(String EnterFontColor) {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_ReservationSummary_Field);

		Assert.assertEquals(CustomizeOpt_ReservationSummary_Field.isDisplayed(), true,
				"Reservation Summary text Field is not being displayed");

		CustomizeOpt_ReservationSum_FontColor.click();
		CustomizeOpt_ReservationSum_FontColor.clear();
		CustomizeOpt_ReservationSum_FontColor.sendKeys(EnterFontColor);

		System.out.println("Reservation Summary Font text is entered successfully");

		Assert.assertEquals(CustomizeOpt_ReservationSum_FontColor.getAttribute("value"), EnterFontColor,
				"Reservation Summary Font text was not entered");
		logger.info("Reservation Summary Font text is entered successfully");
		test.log(Status.PASS, "Reservation Summary Font text is entered successfully");

	}

	public void editCustomOpBookItBttBackColor(String EnterBackGroundColor) throws InterruptedException {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_BookItButton_Field);

		Assert.assertEquals(CustomizeOpt_BookItButton_Field.isDisplayed(), true,
				"Book It Button Font text Field is not being displayed");

		Javascriptexecutor(CustomizeOpt_BookItButton_BackgroundColor);

		// CustomizeOpt_BookItButton_BackgroundColor.click();
		Thread.sleep(3000);
		CustomizeOpt_BookItButton_BackgroundColor.clear();
		CustomizeOpt_BookItButton_BackgroundColor.sendKeys(EnterBackGroundColor);

		System.out.println("Book It Button Font text is entered successfully");

		Assert.assertEquals(CustomizeOpt_BookItButton_BackgroundColor.getAttribute("value"), EnterBackGroundColor,
				"Book It Button Background text was not entered");
		logger.info("Book It Button Background is entered successfully");
		test.log(Status.PASS, "Book It Button Background is entered successfully");

	}

	public void editCustomOpBookItBttFontColor(String EnterFontColor) {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_BookItButton_Field);

		Assert.assertEquals(CustomizeOpt_BookItButton_Field.isDisplayed(), true,
				"Book It Button Font text Field is not being displayed");

		CustomizeOpt_BookItButton_FontColor.click();

		CustomizeOpt_BookItButton_FontColor.clear();
		CustomizeOpt_BookItButton_FontColor.sendKeys(EnterFontColor);

		System.out.println("Book It Button Font text is entered successfully");

		// Assert.assertEquals(CustomizeOpt_BookItButton_FontColor.getAttribute("value"),
		// EnterFontColor, "Book It Button Font text was not entered");
		logger.info("Book It Button Font text is entered successfully");
		test.log(Status.PASS, "Book It Button Font text is entered successfully");

	}
	
	/* NoTE End */
	
	

	public void editCustomOpBookItBttLabel(String EnterBookItLable) {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_BookItButtonLabel_Field);

		Assert.assertEquals(CustomizeOpt_BookItButtonLabel_Field.isDisplayed(), true,
				"Book It Button Label Field is not being displayed");

		CustomizeOpt_BookItButtonLable_TextField.click();
		CustomizeOpt_BookItButtonLable_TextField.clear();
		CustomizeOpt_BookItButtonLable_TextField.sendKeys(EnterBookItLable);

		System.out.println("Book It Button Label text is entered successfully");

		Assert.assertEquals(CustomizeOpt_BookItButtonLable_TextField.getAttribute("value"), EnterBookItLable,
				"Book It Button Label Field text was not entered");
		logger.info("Book It Button Label text entered successfully");
		test.log(Status.PASS, "Book It Button Label text entered successfully");

	}

	public void clickCustomOpBookItBttResetButton() throws InterruptedException {

		SeleniumRepo.waitForElementPresent(CustomizeOpt_BookItButtonLabel_Field);

		Assert.assertEquals(CustomizeOpt_BookItButtonLabel_Field.isDisplayed(), true,
				"Book It Button Label is not being displayed");

		CustomizeOpt_ResetToDefaults_Button.click();

		SeleniumRepo.WaitForLoad(100);

		System.out.println("Book It Button Label is reset to Defaults successfully");
		logger.info("Book It Button Label is reset to Defaults successfully");
		test.log(Status.PASS, "Book It Button Label is reset to Defaults successfully");

	}

	public void clickEmailRetargetingSaveButton() {

		if (SeleniumRepo.isElementDisplayed(save_button) == true) {

			Javascriptexecutor(save_button);
			SeleniumRepo.waitForPageLoaded();

			logger.info("Clicked on Save button successfully ");

			test.log(Status.INFO, "Clicked on Email Retargeting save button successfully");
		} else {
			logger.error(" Failed to click on Email Retargeting button");

			test.log(Status.ERROR, "Failed to click on Email Retargeting button");
		}

	}

	public void clickEmailRetargetingCancelButton() {

		if (SeleniumRepo.isElementDisplayed(cancel_button) == true) {

			Javascriptexecutor(cancel_button);
			SeleniumRepo.waitForPageLoaded();

			logger.info("Clicked on Save button successfully ");

			test.log(Status.INFO, "Clicked on Email Retargeting save button successfully");
		} else {
			logger.error(" Failed to click on Email Retargeting button");

			test.log(Status.ERROR, "Failed to click on Email Retargeting button");
		}

	}

}
