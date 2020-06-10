/**
 * 
 */
package com.tt.admin.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * 
 * In order to enalbe this page, payment gateway must be enabled. Onces its
 * enable the page link will appear
 * 
 * @author DM
 *
 */
public class CardSurcharge extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();
	
	
	private PaymentGateway paymentGateway = PageFactory.initElements(SeleniumRepo.driver, PaymentGateway.class);

	
	
	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"), })
	private WebElement property_Management;
	
	@FindAll({ @FindBy(xpath = "//a[contains(.,'Card Surcharge')]"), })
	private WebElement Click_CardSurcharge_Link;
	
	@FindAll({ @FindBy(xpath = "//a[contains(.,'Payment')]"), })
	private WebElement Click_PaymentGatewayLink;
	

	@FindAll({ @FindBy(xpath = "//*[text()='Card Surcharge Configuration']"), })
	private WebElement CardSurcharge_Pg_header;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Card Surcharge Status')]") })
	public WebElement CardSur_ChargeSurchargeStatus_Field;

	@FindAll({ @FindBy(xpath = "//input[@value='true']") })
	public WebElement Click_ChargeSurchargeStatus_Enable;

	@FindAll({ @FindBy(xpath = "//input[@value='false']") })
	public WebElement Click_ChargeSurchargeStatus_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Card Type')]") })
	public WebElement CardSur_CardType_Field;

	@FindAll({ @FindBy(xpath = "//select[@name='providerIdString']"), })
	private WebElement Select_CardType_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Surcharge')]") })
	public WebElement CardSur_Surcharge_Field;

	@FindAll({ @FindBy(xpath = "//input[@id='surcharge']"), })
	public WebElement Enter_Surcharge;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Charge Type')]") })
	public WebElement CardSur_ChargeType_Field;

	@FindAll({ @FindBy(xpath = "//input[@value='PERCENT']") })
	public WebElement Click_ChargeType_Percentage;

	@FindAll({ @FindBy(xpath = "//input[@value='FIXED']") })
	public WebElement Click_ChargeType_Fixed;

	@FindAll({ @FindBy(xpath = "//font[@color='red' and contains(., 'Please Select Card type provide')]"), })
	public WebElement Check_CardTypeProviderError;

	@FindAll({ @FindBy(xpath = "//font[@color='green' and contains(., 'Card Surcharge Details Successfully Stored or Updated')]"), })
	public WebElement Check_CardSurchargeSucessSave;
	

	@FindAll({ @FindBy(xpath = "//input[@value='Save']"), })
	private WebElement cardSurcharge_SaveButton;

	@FindAll({ @FindBy(xpath = "//a[contains(., 'Cancel')]"), })
	private WebElement cardSurcharge_CancelButton;

	
	public void navigateToCardSurcharge_Pg() throws InterruptedException {
		
		
		if( ( SeleniumRepo.isElementDisplayed(Click_CardSurcharge_Link) == false )  &&   ( SeleniumRepo.isElementDisplayed(Click_PaymentGatewayLink) == false) ){
			
			Javascriptexecutor(property_Management);

			Thread.sleep(3000);
		} 
		
		
		if ( ( SeleniumRepo.isElementDisplayed(Click_CardSurcharge_Link) == false ) &&  (SeleniumRepo.isElementDisplayed(Click_PaymentGatewayLink) == true) ){
			//enable card surchange
			
			enableCardSurcharge();
			
		}
		
		
		
		if(  SeleniumRepo.isElementDisplayed(Click_CardSurcharge_Link) == true ) {
			
			Javascriptexecutor(Click_CardSurcharge_Link);

			SeleniumRepo.waitForPageLoaded();
		}
		

	}

	
	public void enableCardSurcharge() throws InterruptedException {
		
		paymentGateway.navigateToPaymentGateway_Pg();
		paymentGateway.editPayGateStatus("enable");
		paymentGateway.editPaymentGateway("JCC");
		paymentGateway.Click_PaymentGateUpdate();

	}

	
	
	public void editCardSurchargeCardStatus(String statusType) throws InterruptedException {

		SeleniumRepo.waitForElementPresent(CardSur_ChargeSurchargeStatus_Field);

		Assert.assertEquals(CardSur_ChargeSurchargeStatus_Field.isDisplayed(), true,
				"Card Surcharge Status not being displayed");

		if (statusType.equalsIgnoreCase("enable")) {

			Click_ChargeSurchargeStatus_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Card Surcharge Status is set to enabled successfully");
			logger.info("Card Surcharge Status enabled selected successfully");
			test.log(Status.PASS, "Card Surcharge Status enabled selected successfully");
			Assert.assertTrue(Click_ChargeSurchargeStatus_Enable.isSelected(), "Card Surcharge Status is Enabled");

		} else {

			Click_ChargeSurchargeStatus_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Card Surcharge Status is set to Disabled successfully");
			logger.info("Card Surcharge Status disabled selected successfully");
			test.log(Status.PASS, "Card Surcharge Status is Disabled");

			Assert.assertTrue(Click_ChargeSurchargeStatus_Disable.isSelected(), "Card Surcharge Status is disable");

		}

	}

	public void editCardSurchargeCardType(String dropDownCardType) {

		SeleniumRepo.waitForElementPresent(CardSur_CardType_Field);

		Assert.assertEquals(CardSur_CardType_Field.isDisplayed(), true, "Card Type Field is not being displayed");

		Select_CardType_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_CardType_DropDown, dropDownCardType);
		
		SeleniumRepo.waitForPageLoaded();

		System.out.println("Card Type was selected successfully");

		logger.info("Card Type was selected successfully");
		test.log(Status.PASS, "A Card Type was selected successfully");

	}

	public void editCardSurchargeAmount(String surchargeAmount) {

		SeleniumRepo.waitForElementPresent(CardSur_Surcharge_Field);

		Assert.assertEquals(CardSur_Surcharge_Field.isDisplayed(), true, "The Surcharge text Field is not being displayed");

		Enter_Surcharge.click();
		Enter_Surcharge.clear();
		Enter_Surcharge.sendKeys(surchargeAmount);

		System.out.println("The Surcharge is entered successfully");

		Assert.assertEquals(Enter_Surcharge.getAttribute("value"), surchargeAmount,
				"Field Surcharge text was not entered");
		logger.info("Field Surcharge is  entered successfully");
		test.log(Status.PASS, "Field Surcharge is Entered successfully");

	}

	public void editCardSurchargeType(String chargeType) throws InterruptedException {

		SeleniumRepo.waitForElementPresent(CardSur_ChargeType_Field);

		Assert.assertEquals(CardSur_ChargeType_Field.isDisplayed(), true, "Card  Charge Type not being displayed");

		if (chargeType.equalsIgnoreCase("percentage")) {

			Click_ChargeType_Percentage.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Card Charge Type  is set to percentage successfully");
			logger.info("Card Charge Type is set to percentage successfully");
			test.log(Status.PASS, "Card charge type was set to percentage successfully");
			Assert.assertTrue(Click_ChargeType_Percentage.isSelected(), "Card Charge Type is Enabled");

		} else {

			Click_ChargeType_Fixed.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Card Charge Type is set to fixed successfully");
			logger.info("Card Charge Type fixed selected successfully");
			test.log(Status.PASS, "Card Charge Type is Fixed");

			Assert.assertTrue(Click_ChargeType_Fixed.isSelected(), "Card Charge Type is fixed");

		}

	}
	

	public void CardSurchargeSaveButton() {

		try {
			cardSurcharge_SaveButton.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("saved");
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
			Thread.sleep(4000);

		} catch (Exception e1) {
			System.out.println("Not saved");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");
			e1.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

	public void CardSurchargeCancelButton() {

		try {
			cardSurcharge_CancelButton.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("cancel");
			logger.info("Clicked on Cancel button");
			test.log(Status.PASS, "Clicked on Cancel button");
			Thread.sleep(4000);

		} catch (Exception e1) {
			System.out.println("Not cancel");
			logger.error("Failed to Click on Cancel button");
			test.log(Status.FAIL, "Failed to Click on Cancel button");
			e1.printStackTrace();
			Assert.assertEquals(false, true);
		}

	} 

}
