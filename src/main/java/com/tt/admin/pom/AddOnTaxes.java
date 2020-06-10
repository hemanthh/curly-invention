/**
 * 
 */
package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * @author DM
 *
 */
public class AddOnTaxes extends BaseTest {
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();
	
	//PageFactory.initElements(SeleniumRepo.driver, PropertyEdit.class);

	private PropertyEdit editingProp = PageFactory.initElements(SeleniumRepo.driver, PropertyEdit.class);	
	private PropertyDefaults editingPropDefaults = PageFactory.initElements(SeleniumRepo.driver, PropertyDefaults.class);


	
	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"), })
	private WebElement property_Management;
	
	@FindAll({ @FindBy(xpath = "//a[contains(., 'Taxes')]"), 
		@FindBy(css = "ul:nth-child(3) li:nth-child(3) ul:nth-child(2) li:nth-child(7) > a:nth-child(1)") 
	})
	private WebElement Click_TaxesFees;
	
	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Property Taxes')]"),
		@FindBy(css = "table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) > h1:nth-child(1)")
	})
	private WebElement Verify_Property_Taxes;
	
	

	 @FindAll({ @FindBy(xpath = "//*[@name='addOnTaxIdsToDelete']"), })
	 public List <WebElement> all_AddOnTaxes_Delete_CheckBox;
	 
	 @FindAll({ @FindBy(xpath = "//*[@id='listTaxForm']/p[2]/input"), })
	 public WebElement addOnTaxes_Delete_button;
	 
	 
	 	@FindAll({ @FindBy(xpath = "//*[text()='OK']"), })
	 	public WebElement Delete_OK;

	 	@FindAll({ @FindBy(xpath = "//*[text()='Cancel']"), })
	 	public WebElement Delete_Cancel;
	
	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Add New Addon Tax')]"),
		@FindBy(css = "tbody:nth-child(1) tr:nth-child(1) td:nth-child(3) p:nth-child(3) > a:nth-child(1)") 
	})
	private WebElement Click_AddNewAddonTaxLinkText;	
	
	
	@FindAll({ @FindBy(xpath = "//*[@id='listTaxForm']/table[3]/tbody/tr/td/a") })
	public  List <WebElement> allAddOnTaxesAndFeeLink;
	
	
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Tax Name Required')]"), })
    private WebElement Check_ErrorTaxNameLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Tax Code Required')]"), })
    private WebElement Check_ErrorTaxCodeLabel;
   
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Charge Amount is required and must be greater than 0, and of format #, #.#, #.## or #.### (up to 3 decimals)')]"), })
    private WebElement Check_ErrorTaxChargeAmountLabel;
    
 
	@FindAll({ @FindBy(xpath = "//input[@name='taxName']"),
		@FindBy(css = "table.formtable:nth-child(10) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > input.input.guest-facing-fields")
	})
	private WebElement Enter_Tax_Name;	
	
	@FindAll({ @FindBy(xpath = "//td[ text()='Type ']") })
	public WebElement TaxOrFeeType_Field;
	
	@FindAll({ @FindBy(xpath = "//*[@name='taxFeeType' and @value='tax']") })
	public WebElement Click_TaxOrFeeType_Tax;

	@FindAll({ @FindBy(xpath = "//*[@name='taxFeeType' and @value='fee']") })
	public WebElement Click_TaxOrFeeType_Fee;
	
	@FindAll({ @FindBy(xpath = "//input[@name='code']"),
		@FindBy(css = "table.formtable:nth-child(10) tbody:nth-child(1) tr:nth-child(4) td:nth-child(2) > input:nth-child(1)")
	})
	private WebElement Enter_Tax_Code;	
	
	
	@FindAll({ @FindBy(xpath = "//input[@name='chargeAmount']"), })
	private WebElement Enter_AddonTax_Charge_Amount;	
	
	
	@FindAll({ @FindBy(xpath = "//input[contains(@name,'chargeType')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(3) > td:nth-child(2)") 
	})
	private List<WebElement> Enter_AddOnTaxCharge_Type;	
	
	@FindAll({ @FindBy(xpath = "//input[contains(@name,'taxBasis')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(2)") 
	})
	private List<WebElement> Enter_Tax_Basis;	
    
	 @FindAll({ @FindBy(xpath = "//td[contains(text(),'Apply On')]") })
	 public WebElement AddOnTax_ApplyOn_Field;

	 @FindAll({ @FindBy(xpath = "//*[@id='applyOnTaxBasis']") })
	 public WebElement Click_AddOnTax_ApplyOn_DropDown;
	 
	 
	 @FindAll({ @FindBy(xpath = "//td[contains(text(),'Tax Description')]") })
	 public WebElement TaxDescription_Field;

	 @FindAll({ @FindBy(xpath = "//textarea[@name='description']") })
	 public WebElement Enter_TaxDescription_Text;
	 
    
	@FindAll({ @FindBy(xpath = "//input[@value='Save']"), })
	private WebElement Click_SaveButton;	
	
	
	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"),})
	private WebElement Click_CancelButton;	
    
	
	
	public void enablingAddOnTaxes()  throws Exception {
		
		logger.info("Enabling Addon Taxes ");

		
		editingProp.click_Edit();
		editingProp.propAddOnTaxes("enable");
		
		
		test.log(Status.INFO,"Clicked Addon Taxes Enabled radio button" );
		Assert.assertTrue(editingProp.Click_AddOnTaxes_Enable.isSelected(), "Was not able to Click on TaxesFees Link");
		
		editingProp.propSave();
		
		System.out.println("Enabled AddOn Taxes");
		
	}
	
	public void disableAddOnTaxes()  throws Exception {
		
		logger.info("Disable Addon Taxes ");

		
		editingProp.click_Edit();
		editingProp.propAddOnTaxes("disable");
		
		test.log(Status.INFO,"Clicked Addon Taxes Enabled radio button" );
		Assert.assertTrue(editingProp.Click_AddOnTaxes_Disable.isSelected(), "Was not able to Click on TaxesFees Link");
		
		
		editingProp.propSave();
		
		System.out.println("Disable AddOn Taxes");

		
	}
	
	/**
	 * 
	 * @param addonTaxPriceType expected values are "inclusive  exclusive"
	 * @throws Exception
	 */
	public void setAddOnPriceTypeToInclusive()  throws Exception {
		
		logger.info("Changing Addon Taxes pricing type to Inclusive ");

		
		editingPropDefaults.click_PropertyDefaults();
		editingPropDefaults.propDefAddOnPriceType("inclusive");
		
		
		test.log(Status.INFO,"Clicked Addon Taxes price type inclusive radio button" );
		Assert.assertTrue(editingPropDefaults.Click_AddOnPriceType_​TaxInclusive.isSelected(), "Was not able to click on TaxesFees Link");
		
		
		editingPropDefaults.Click_Save();
		
		System.out.println("Selected Inclusive AddOn Taxes Type");

	
		
	}
	
	
	public void setAddOnPriceTypeToExclusive()  throws Exception {
		
		logger.info("Changing Addon Taxes pricing type to Exclusive  ");

		
		editingPropDefaults.click_PropertyDefaults();
		editingPropDefaults.propDefAddOnPriceType("exclusive");
		
		test.log(Status.INFO,"Clicked Addon Taxes price type exculsive radio button" );
		Assert.assertTrue(editingPropDefaults.Click_AddOnPriceType_​TaxExclusive.isSelected(), "Was not able to Click on TaxesFees Link");
		
		
		editingPropDefaults.Click_Save();
	
		System.out.println("Selected Exclusive AddOn Taxes Type");

		
	}
	
	
	public void click_TaxesAndFeesLink()
	{
		//SeleniumRepo.waitForElementPresent(Click_TaxesFees);
		
		
		if( SeleniumRepo.isElementDisplayed(Click_TaxesFees) == false   ) 
		{
			
			System.out.println("PropertyManagement Menu is not expanded");
			Javascriptexecutor(property_Management);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");
			
			ExplicitWait(Click_TaxesFees);

			Javascriptexecutor(Click_TaxesFees);
			ExplicitWait(Verify_Property_Taxes);
			logger.info("Clicked on TaxesFees Link");
			test.log(Status.PASS,
					"Clicked on TaxesFees Link" );
			Assert.assertTrue(true, "Clicked on TaxesFees Link");
		}
		else
		{
			Javascriptexecutor(Click_TaxesFees);
			SeleniumRepo.waitForPageLoaded();
			//ExplicitWait(Verify_Property_Taxes);
			logger.info("Clicked on TaxesFees Link");
			test.log(Status.PASS,
					"Clicked on TaxesFees Link" );
			Assert.assertTrue(true, "Clicked on TaxesFees Link");
			
			/*
			System.out.println(" TaxesFees is not found");
			logger.error("Failed to Click on TaxesFees Link");
			test.log(Status.FAIL,
					"Failed to Click on TaxesFees Link");
			Assert.assertFalse(false, 
					"TaxesFees Link not found");
			
			*/
		}

	}
		
	public void click_addAddOntax()
	{
		ExplicitWait(Click_AddNewAddonTaxLinkText);
		if (Click_AddNewAddonTaxLinkText.isDisplayed()) 
		{
			Javascriptexecutor(Click_AddNewAddonTaxLinkText);
			logger.info("Clicked on TaxToProperty Link");
			test.log(Status.PASS,
					"Clicked on TaxToProperty Link" );
			Assert.assertTrue(true,
					"Clicked on TaxToProperty Link");}
		else {
			System.out.println(" TaxToProperty Link is not found");
			logger.error("Failed to Click on TaxToProperty Link");
			test.log(Status.FAIL,
					"Failed to Click on TaxToProperty Link");
			Assert.assertFalse(false, 
					"TaxToProperty Link not found");
		}
	}
	
	
public void editAddOnTaxName(String Tax_Name){
		
		
		ExplicitWait(Enter_Tax_Name);
		if (Enter_Tax_Name.isDisplayed()) 
		{
			Enter_Tax_Name.click();
			Enter_Tax_Name.clear();
			Enter_Tax_Name.sendKeys(Tax_Name+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			System.out.println("Addon Tax Tax_Name is entered successfully");
			logger.info("Addon Tax Tax_Name is entered successfully");
			test.log(Status.PASS,
					"Addon Tax Tax_Name is entered successfully" );
			Assert.assertTrue(true,
					"Addon Tax Tax_Name is entered successfully");
		} else {
			System.out.println("Addon Tax Tax_Name TextBox not found");
			logger.error("Failed to Enter Addon Tax Tax_Name in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Addon Tax Tax_Name in TextBox");
			Assert.assertFalse(false, 
					"Addon Tax Tax_Name TextBox not found");
		}
		
		
	}
	

public void editAddOnTaxType(String type) throws InterruptedException{
	
	logger.info("Ediitng Addon Tax Type ");

	
	SeleniumRepo.isElementDisplayed(TaxOrFeeType_Field);
	
	Assert.assertEquals(TaxOrFeeType_Field.isDisplayed(), true, "Addon Tax Type Field is not being displayed");

	
	
	if (type.equalsIgnoreCase("Tax")) {

		Click_TaxOrFeeType_Tax.click();
		SeleniumRepo.WaitForLoad(100);
		
		//simplify this to match the radio button and dropdown

		System.out.println("Addon Tax was selected successfully as Type");
		logger.info("Addon Tax was selected successfully as Type ");
		test.log(Status.PASS, "Addon Tax was selected successfully as Type");
		

		Assert.assertTrue(Click_TaxOrFeeType_Tax.isSelected(), "Addon Tax as type was selected sucessfully");

	}

	if (type.equalsIgnoreCase("Fee")) {

		Click_TaxOrFeeType_Fee.click();
		SeleniumRepo.WaitForLoad(100);
		
		System.out.println("Fee was selected successfully as Type" );
		logger.info("Fee was selected successfully as Type");
		test.log(Status.PASS, "Fee was selected successfully as Type");
		

		Assert.assertTrue(Click_TaxOrFeeType_Fee.isSelected(), "Fee as type was selected sucessfully");
	}
	
}


public void editAddOnTaxCode(String Tax_Code){
	
	
	if (Enter_Tax_Code.isDisplayed())
	{
		Enter_Tax_Code.click();
		Enter_Tax_Code.clear();
		Enter_Tax_Code.sendKeys(Tax_Code+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
		System.out.println(" Addon Tax Tax_Code is entered successfully");
		logger.info("Addon Tax Tax_Code is entered successfully");
		test.log(Status.PASS,
				"Addon Tax Tax_Code is entered successfully" );
		Assert.assertTrue(true,
				"Addon Tax Tax_Code is entered successfully");
	} else {
		System.out.println("Addon Tax Tax_Code TextBox not found");
		logger.error("Failed to Enter Addon Tax Tax_Code in TextBox");
		test.log(Status.FAIL,
				"Failed to Enter Addon Tax Tax_Code in TextBox");
		Assert.assertFalse(false, 
				"Addon Tax Tax_Code TextBox not found");
	}
	
}



//there is a field change depending on this fields setting

public void editAddOnTaxChargeType(String addOnCharge_Type){
	
	
	try {
		SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_AddOnTaxCharge_Type,addOnCharge_Type);
		System.out.println("Addon Tax Charge_Type is Selected succesfully");
		logger.info("Addon Tax Charge_Type is Selected succesfully");
		test.log(Status.PASS,
				"Addon Tax Charge_Type is Selected succesfully" );
		Assert.assertTrue(true,
				"Addon Tax Charge_Type is Selected succesfully");
	} catch (Exception e) {
		System.out.println("Addon Tax Charge_Type is not Selected");
		logger.error("Failed to Select Charge Type");
		test.log(Status.FAIL,
				"Failed to Select Addon Tax Charge Type");
		Assert.assertFalse(false, 
				"Failed to Select Addon Tax Charge Type");
		e.printStackTrace();
	}
	
	
	
}


//Note: appears when charge type is flat fee
public void editAddOnTaxBasis(String addOnCharge_Basis){
	
	if (Enter_AddOnTaxCharge_Type.get(1).isEnabled()) {


	try {
		SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Tax_Basis,addOnCharge_Basis);
		System.out.println("Addon Tax Charge_Basisis Selected succesfully");
		logger.info("Addon Tax Charge_Basis is Selected succesfully");
		test.log(Status.PASS,
				"Addon Tax Charge_Basis is Selected succesfully" );
		Assert.assertTrue(true,
				"Addon Tax Charge_Basis is Selected succesfully");
	} catch (Exception e) {
		System.out.println("Charge_Basis is not Selected");
		logger.error("Failed to Select Addon Tax Charge Basis");
		test.log(Status.FAIL,
				"Failed to Select Addon Tax Charge Basis");
		Assert.assertFalse(false, 
				"Failed to Select Addon Tax Charge Basis");
		e.printStackTrace();
	}
	
	}
	
}
	

public void editAddOnTaxApplyOn(String addOnApplyOnPrice){
	

	if (Enter_AddOnTaxCharge_Type.get(0).isEnabled()) {

	
	SeleniumRepo.waitForElementPresent(AddOnTax_ApplyOn_Field);

	Assert.assertEquals(AddOnTax_ApplyOn_Field.isDisplayed(), true, "Addon Tax Apply On Field is not being displayed");

	
	Click_AddOnTax_ApplyOn_DropDown.click();
	SeleniumRepoDropdown.selectDropDownText(Click_AddOnTax_ApplyOn_DropDown, addOnApplyOnPrice);
	
	
	System.out.println("Addon apply priced is " +  addOnApplyOnPrice);
	logger.info("Addon Tax Apply On was selected successfully");
	test.log(Status.PASS, "Addon Tax Apply On was selected successfully");
	
	}
}


public void editAddOnTaxChargeAmount(String addOnCharge_Amount){
	
	
	if (Enter_AddonTax_Charge_Amount.isDisplayed()) 
	{
		Enter_AddonTax_Charge_Amount.click();
		Enter_AddonTax_Charge_Amount.clear();
		Enter_AddonTax_Charge_Amount.sendKeys(addOnCharge_Amount);
		System.out.println(" Addon Tax Charge_Amount is entered successfully");
		logger.info("Addon Tax Charge_Amount is entered successfully");
		test.log(Status.PASS,
				" Addon Tax Charge_Amount is entered successfully" );
		Assert.assertTrue(true,
				"Addon Tax Charge_Amount is entered successfully");
	} else {
		System.out.println("Addon Tax Charge_Amount TextBox not found");
		logger.error("Failed to Enter Addon Tax Charge_Amount in TextBox");
		test.log(Status.FAIL,
				"Failed to Enter Addon Tax Charge_Amount in TextBox");
		Assert.assertFalse(false, 
				"Addon Tax Charge_AmountTextBox not found");
	}


	
}



public void editTaxDescription(String EnterTaxDes){
	
	
	SeleniumRepo.waitForElementPresent(TaxDescription_Field);

	Assert.assertEquals(TaxDescription_Field.isDisplayed(), true, "Tax Description text Field is not being displayed");

	Enter_TaxDescription_Text.click();
	Enter_TaxDescription_Text.clear();
	Enter_TaxDescription_Text.sendKeys(EnterTaxDes);

	System.out.println("Tax Description	is entered successfully");

	Assert.assertEquals(Enter_TaxDescription_Text.getAttribute("value"), EnterTaxDes,"Tax Description Field text was not entered");
	logger.info("Tax Description	 is entered successfully");
	test.log(Status.PASS, "Tax Description is entered successfully");

	
}


	public void requiredFieldErrorCheck() {

		logger.info("Verifying required field  Addon Taxes error messages ");

		clickAddOnTaxesAndFeesSaveButton();
		
		SeleniumRepo.waitForPageLoaded();

		/*
		 
		 //li[contains(text(),'Please select at least one day of the week.')]
		     
		 */
		
		
		// After attempting to save a new guest preference question without any
		// required field filled out, the error messages appeared and the
		// the following if statements confirm the appearances of messages
		if (Check_ErrorTaxNameLabel.isDisplayed()) {
			System.out.println("Error Message Tax Name Required  is Displayed");
			test.log(Status.PASS, "Error Message Tax Name Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Tax Name Required  is Displayed ");
		} else {
			System.out.println("Error Message Tax Name Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Tax Name Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Tax Name Required  is Not Displayed");
		}

		if (Check_ErrorTaxCodeLabel.isDisplayed()) {
			System.out.println("Error Message Tax Code Required  is Displayed");
			test.log(Status.PASS, "Error Message Tax Code Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Tax Code Required  is Displayed ");
		} else {
			System.out.println("Error Message Tax Code Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Tax Code Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Tax Code Required  is Not Displayed");
		}


		
		if (Check_ErrorTaxChargeAmountLabel.isDisplayed()) {
			System.out.println("Error Message Charge Amount  is Displayed");
			test.log(Status.PASS, "Error Message Charge Amount  is Displayed ");
			Assert.assertTrue(true, "Error Message Charge Amount  is Displayed ");
		} else {
			System.out.println("Error Message Charge Amount  is Not Displayed");
			test.log(Status.FAIL, " Error Message Charge Amount  is Not Displayed");
			Assert.assertFalse(false, "Error Message Charge Amount  is Not Displayed");
		}
		

	}
	
	public void clickAddOnTaxesAndFeesSaveButton() {
		// TODO Auto-generated method stub
		
		
		try {
			Click_SaveButton.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Saved");
			logger.info("Clicked on Save button");
			test.log(Status.PASS,
					"Clicked on Save button" );
		} catch (Exception e) {
			System.out.println("Not Saved");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void clickAddOnTaxesAndFeesCancelButton() {
		// TODO Auto-generated method stub
		
		
		try {
			Click_CancelButton.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Cancel");
			logger.info("Clicked on Cancel button");
			test.log(Status.PASS,
					"Clicked on Cancel button" );
		} catch (Exception e) {
			System.out.println("Not Cancel");
			logger.error("Failed to Click on Cancel button");
			test.log(Status.FAIL,
					"Failed to Click on Cancel button");
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
	public void delete_AllAddOnTaxes() throws InterruptedException
	{
				
		logger.info("Deleting all Addon Taxes");

		if(SeleniumRepo.isElementDisplayed(Verify_Property_Taxes) == false){

		click_TaxesAndFeesLink();
		SeleniumRepo.waitForPageLoaded();
		
		}
		
		//ExplicitWait(Click_AddNewAddonTaxLinkText);
		//	if(ListTaxForm.size()>0);
		
		
		if(SeleniumRepo.isElementDisplayed(addOnTaxes_Delete_button) == true )
		{
			System.out.println("already tax created");

			for(WebElement del:all_AddOnTaxes_Delete_CheckBox)
			{
				del.click();
				//Javascriptexecutor(del);
			}

			Thread.sleep(2000);
			//Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[@value='Delete']")));
			addOnTaxes_Delete_button.click();
			Thread.sleep(3000);

	  		Delete_OK.click();	
	  		
	  		SeleniumRepo.waitForPageLoaded();
			

			
			System.out.println("Deleted All Addon Taxes");
			test.log(Status.INFO, "Deleted All Addon Taxes");
			Assert.assertTrue(all_AddOnTaxes_Delete_CheckBox.size()== 0, "Was not abel to delete all addon taxes");

			ExplicitWait(Click_AddNewAddonTaxLinkText);
		}

		else
		{
			System.out.println("No AddOn taxes To delete");
			test.log(Status.INFO, "No AddOn taxes To delete");
		}
		
		

	}
	
	
	
	public void delete_AddOnTax(String addOntaxesOrFeesName) throws InterruptedException {
		
		
		logger.info("Deleting Addon Taxes: " + addOntaxesOrFeesName);
  
		int pos=0; 
		
		
		  for(int a = 0; a < allAddOnTaxesAndFeeLink.size(); a++ ){
		  
		  	if(allAddOnTaxesAndFeeLink.get(a).getText().equals(addOntaxesOrFeesName) ) {
		  		//allTaxesAndFeeLink.get(a).click();
		  		pos = a;
		  		all_AddOnTaxes_Delete_CheckBox.get(a).click();
				Thread.sleep(2000);

				addOnTaxes_Delete_button.click();

		  		Delete_OK.click();	
		  		
		  	}
		  
		  }
		  
		  
		  test.log(Status.INFO, "Deleted Addon Taxes: "  + addOntaxesOrFeesName);
			Assert.assertFalse(allAddOnTaxesAndFeeLink.get(pos).getText().equals(addOntaxesOrFeesName), "Was not abel to delete addon taxes " +addOntaxesOrFeesName);

		  
		  
	}
	
	
	

	public void delete_RandomAddOnTax() throws InterruptedException {
		
		logger.info("Deleting Random Addon Taxes ");

		
		  int numOfAddonTaxesBefore =  allAddOnTaxesAndFeeLink.size();
		  
		  	if( numOfAddonTaxesBefore > 0 ) {
		  		//allTaxesAndFeeLink.get(a).click();
		  		
		  		all_AddOnTaxes_Delete_CheckBox.get(SeleniumRepo.getRandomNumberInRange(0,numOfAddonTaxesBefore-1)).click();

				Thread.sleep(2000);

				addOnTaxes_Delete_button.click();

		  		Delete_OK.click();
		  		
		  	}
		  	
		  	
			  int numOfAddonTaxesAfter =  allAddOnTaxesAndFeeLink.size();

		  	
		  	test.log(Status.INFO, "Deleted random Addon Taxes ");
			Assert.assertFalse(numOfAddonTaxesBefore == numOfAddonTaxesAfter , "Was not abel to delete addon taxes ");

		  		
		  	
		  
	}
	


}
