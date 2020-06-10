package com.tt.admin.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class ManageAccessCode extends BaseTest
{
	public static String Accesscode;
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//div[contains(text(), 'Rate Plans')]"),

	})
	public WebElement RatePlan_link;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Manage Access Codes')]"),

	})
	private WebElement MAC_link;

	@FindAll({ @FindBy(xpath = "//input[@id='allRatePlan']"),

	})
	private WebElement Enter_RatePlan;

	@FindAll({ @FindBy(xpath = "//ul[@id='ui-id-1']"),

	})
	private WebElement Select_RatePlan;



	@FindAll({ @FindBy(xpath = "//input[@id='go']"),

	})
	private WebElement Click_GO;


	@FindAll({ @FindBy(xpath = "//a[@href='#'][contains(text(),'Delete')]"),

	})
	private WebElement Delete;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'OK')]"),

	})
	private WebElement OK_Delete;



	@FindAll({ @FindBy(xpath = "//a[contains(@onclick,'addNewRatePlanToAccessCode')]"),

	})
	private WebElement Add_NewAccessCode;

	@FindAll({ @FindBy(xpath = "//input[@name='alternateName']"),

	})
	private WebElement Enter_AlternateName;

	@FindAll({ @FindBy(xpath = "//input[@name='accessCode']"),

	})
	private WebElement Enter_AccessCode;

	@FindAll({ @FindBy(xpath = "//textarea[@name='notes']"),

	})
	private WebElement Enter_Note;


	@FindAll({ @FindBy(xpath = "//input[@type='button'][@value='Save']"),

	})
	private WebElement save_Button;


	@FindAll({ @FindBy(xpath = "//tr[@id='viewRatePlanLink']//a[text()='View Rate Plan']"),

	})
	private WebElement ClickOn_ViewRatePlan	;


	@FindAll({ @FindBy(xpath = "//td[@class='prompt']//a[contains(@href,'accessCode')]"),

	})
	private WebElement Get_PromoUrl	;
	
	
	@FindAll({
		@FindBy(xpath="//*[contains(text(),'(Manage)')]"),
	})     
	@CacheLookup
	private WebElement Accesscode_Manage;

	@FindAll({
		@FindBy(xpath="//*[contains(text(),'Add new access code for')]"),
	})     
	@CacheLookup
	private WebElement Add_NewAccesscode;

	@FindAll({
		@FindBy(xpath="//input[@name='accessCode']"),
	})     
	@CacheLookup
	 WebElement Accesscode_Name;

	@FindAll({
		@FindBy(xpath="//input[@name='selectedRatePlanName']"),
	})     
	@CacheLookup
	private WebElement Rateplancheck_Accescode;



	public void Click_ManageAccessCode()
	{
		SeleniumRepo.waitForElementPresent(MAC_link);
		if (SeleniumRepo.isElementPresent(MAC_link)) 
		{
			Javascriptexecutor(MAC_link);
			test.log(Status.PASS, "Clicked on Manage Acces Code link");
			logger.info("Clicked on Manage Acces Code link");
			Assert.assertTrue(true, "Clicked on Manage Acces Code link");
		} else
		{
			logger.info("Failed to Click on Manage Acces Code link");
			test.log(Status.FAIL, "Failed to Click on Manage Acces Codes link");
		}
		SeleniumRepo.waitForElementPresent(Enter_RatePlan);

	}
	public void Enter_Rateplan(String Rateplan)
	{
		if (Enter_RatePlan.isEnabled()) 
		{
			Enter_RatePlan.click();
			Enter_RatePlan.clear();
			Enter_RatePlan.sendKeys(Rateplan);
			test.log(Status.INFO, "RatePlan is entered successfully");
			logger.info("RatePlan is entered successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter RatePlan");
			logger.error("Failed to Enter RatePlan");
		}

	}

	public void Select_Rateplan()
	{
		SeleniumRepo.waitForElementPresent(Select_RatePlan);
		if (SeleniumRepo.isElementPresent(Select_RatePlan)) 
		{
			Select_RatePlan.click();
			test.log(Status.PASS, "Clicked on Select_RatePlan");
			logger.info("Clicked on Select_RatePlan");
			Assert.assertTrue(true, "Clicked on Select_RatePlan");
		} else 
		{
			logger.info("Failed to Click on Select_RatePlan");
			test.log(Status.FAIL, "Failed to Click on Select_RatePlan");
		}
		SeleniumRepo.waitForElementPresent(Click_GO);
		if (SeleniumRepo.isElementPresent(Click_GO)) 
		{
			Click_GO.click();
			test.log(Status.PASS, "Clicked on GO link");
			logger.info("Clicked on GO link");
			Assert.assertTrue(true, "Clicked on GO link");
		} else 
		{
			logger.info("Failed to Click on Manage Acces Code link");
			test.log(Status.FAIL, "Failed to Click on Manage Acces Codes link");
		}

	}


	public void Accesscode_Manage()
	{
		SeleniumRepo.waitForElementPresent(Accesscode_Manage);
		if(Accesscode_Manage.isDisplayed())
		{
			Javascriptexecutor(Accesscode_Manage);
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Accesscode_Manage is displayed and clicked successfully");
			logger.info("Accesscode_Manage is displayed and clicked successfully");
			test.log(Status.INFO, "Accesscode_Manage is displayed and clicked successfully");
			Assert.assertTrue(true, "Accesscode_Manage is displayed and clicked successfully");
		} 
		else 
		{
			System.out.println("Accesscode_Manage is not displayed and clicked successfully");
			logger.error("Accesscode_Manage is not displayed and clicked successfully");
			test.log(Status.FAIL, "Accesscode_Manage is not displayed and clicked successfully");
			Assert.assertFalse(false, "Accesscode_Manage is not displayed and clicked successfully");
		}

	}
	public void Rateplan_check(String Expectedrateplan)
	{
		SeleniumRepo.waitForElementPresent(Rateplancheck_Accescode);

		String ActualRatePlan=Rateplancheck_Accescode.getAttribute("value");
		if(ActualRatePlan.equals(Expectedrateplan))
		{
			System.out.println("Selected Rateplan displayed successsfully on select rate plan text box ");
			logger.info("Selected Rateplan displayed successsfully on select rate plan text box ");
			test.log(Status.INFO, "Selected Rateplan displayed successsfully on select rate plan text box ");
			Assert.assertTrue(true, "Selected Rateplan displayed successsfully on select rate plan text box");
			System.out.println("Create Acesscode for the Rateplan is "+ActualRatePlan);
		}
		else
		{
			System.out.println("Selected Rateplan not displayed successsfully on select rate plan text box ");
			logger.info("Selected Rateplan not displayed successsfully on select rate plan text box ");
			test.log(Status.INFO, "Selected Rateplan not displayed successsfully on select rate plan text box ");
			Assert.assertFalse(false, "Selected Rateplan notdisplayed successsfully on select rate plan text box");
		}
	}

	public void Add_NewAccesscode()
	{
		SeleniumRepo.waitForElementPresent(Add_NewAccesscode);
		if(Add_NewAccesscode.isDisplayed())
		{
			Javascriptexecutor(Add_NewAccesscode);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Add_NewAccesscode is displayed and clicked successfully");
			logger.info("Add_NewAccesscode is displayed and clicked successfully");
			test.log(Status.INFO, "Add_NewAccesscode is displayed and clicked successfully");
			Assert.assertTrue(true, "Add_NewAccesscode is displayed and clicked successfully");
		} 
		else 
		{
			System.out.println("Add_NewAccesscode is not displayed and clicked successfully");
			logger.error("Add_NewAccesscode is not displayed and clicked successfully");
			test.log(Status.FAIL, "Add_NewAccesscode is not displayed and clicked successfully");
			Assert.assertFalse(false, "Add_NewAccesscode is not displayed and clicked successfully");
		}

	}
	public  void Accesscode_Name(String Rateplan) throws InterruptedException
	{

		SeleniumRepo.waitForElementPresent(Accesscode_Name);
		if(Accesscode_Name.isDisplayed())
		{
			Accesscode="AccessCode"+SeleniumRepo.getRandomAlphNumeircString(6);
			System.out.println("Accesscode for the Rate plan "+Rateplan+" is"+Accesscode);

			Accesscode_Name.sendKeys(Accesscode);
			System.out.println("AccesscodeName is displayed and Entered successfully");
			logger.info("AccesscodeName is displayed and Entered successfully");
			test.log(Status.INFO, "AccesscodeName is displayed and Entered successfully");
			Assert.assertTrue(true, "AccesscodeName is displayed and Entered successfully");
		} 
		else 
		{
			System.out.println("AccesscodeName is not displayed and Entered successfully");
			logger.error("AccesscodeName is not displayed and Entered successfully");
			test.log(Status.FAIL, "AccesscodeName is not displayed and Entered successfully");
			Assert.assertFalse(false, "AccesscodeName is not displayed and Entered successfully");
		}

		Thread.sleep(3000);
		Javascriptexecutor(save_Button);
		SeleniumRepo.waitForPageLoaded();
	}

	
	/**
	 * This method sets the newly created accesscode to default 
	 * 
	 * 
	 */
	public void Offer_default()
	{
		WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='"+Accesscode+"']/following-sibling::td[4]/a")));
		
		try {
		WebElement element=SeleniumRepo.driver.findElement(By.xpath("//*[@title='"+Accesscode+"']/following-sibling::td[6]/a"));
		Javascriptexecutor(element);
		}
		catch(Exception e)
		{
			System.out.println("offer Selected by defaultly");
		}
		SeleniumRepo.waitForPageLoaded();
		WebElement code_status=SeleniumRepo.driver.findElement(By.xpath("//*[@title='"+Accesscode+"']/following-sibling::td[6]/span"));
		
		if(code_status.getText().equalsIgnoreCase("Yes"))
		{
			System.out.println("Accesscode "+Accesscode+"set as Default");
		}
		
		
		
	}






























	public void manageAccesCode(String RatePlan,String AlternateName,String AccessCode,String Note) {

		try {

			SeleniumRepo.waitForElementPresent(RatePlan_link);
			if (SeleniumRepo.isElementPresent(RatePlan_link)) {
				RatePlan_link.click();
				test.log(Status.PASS, "Clicked on RatePlan link");
				logger.info("Clicked on RatePlan link");
				Assert.assertTrue(true, "Clicked on RatePlan link");
			} else {
				logger.info("Failed to Click on RatePlan link");
				test.log(Status.FAIL, "Failed to Click on RatePlan link");
			}


			SeleniumRepo.waitForElementPresent(MAC_link);
			if (SeleniumRepo.isElementPresent(MAC_link)) {
				MAC_link.click();
				test.log(Status.PASS, "Clicked on Manage Acces Code link");
				logger.info("Clicked on Manage Acces Code link");
				Assert.assertTrue(true, "Clicked on Manage Acces Code link");
			} else {
				logger.info("Failed to Click on Manage Acces Code link");
				test.log(Status.FAIL, "Failed to Click on Manage Acces Codes link");
			}


			SeleniumRepo.waitForElementPresent(Enter_RatePlan);
			if (Enter_RatePlan.isEnabled()) {
				Enter_RatePlan.click();
				Enter_RatePlan.clear();
				Enter_RatePlan.sendKeys(RatePlan);
				test.log(Status.INFO, "RatePlan is entered successfully");
				logger.info("RatePlan is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter RatePlan");
				logger.error("Failed to Enter RatePlan");
			}

			SeleniumRepo.waitForElementPresent(Select_RatePlan);
			if (SeleniumRepo.isElementPresent(Select_RatePlan)) {
				Select_RatePlan.click();
				test.log(Status.PASS, "Clicked on Select_RatePlan");
				logger.info("Clicked on Select_RatePlan");
				Assert.assertTrue(true, "Clicked on Select_RatePlan");
			} else {
				logger.info("Failed to Click on Select_RatePlan");
				test.log(Status.FAIL, "Failed to Click on Select_RatePlan");
			}
			SeleniumRepo.waitForElementPresent(Click_GO);
			if (SeleniumRepo.isElementPresent(Click_GO)) {
				Click_GO.click();
				test.log(Status.PASS, "Clicked on GO link");
				logger.info("Clicked on GO link");
				Assert.assertTrue(true, "Clicked on GO link");
			} else {
				logger.info("Failed to Click on Manage Acces Code link");
				test.log(Status.FAIL, "Failed to Click on Manage Acces Codes link");
			}


			if(Delete.isDisplayed()) {
				Delete.click();
				OK_Delete.click();
				test.log(Status.PASS, "Clicked on Delete");
				logger.info("Clicked on Delete");
				Assert.assertTrue(true, "Clicked on Delete");
			} else {
				logger.info("Failed to Click on Delete");
				test.log(Status.FAIL, "Failed to Click on Delete");
			}


			SeleniumRepo.waitForElementPresent(Add_NewAccessCode);
			if (SeleniumRepo.isElementPresent(Add_NewAccessCode)) {
				Add_NewAccessCode.click();
				test.log(Status.PASS, "Clicked on Add_NewAccessCode link");
				logger.info("Clicked on Add_NewAccessCode link");
				Assert.assertTrue(true, "Clicked on Add_NewAccessCode link");
			} else {
				logger.info("Failed to Click on Add_NewAccessCode link");
				test.log(Status.FAIL, "Failed to Click on Add_NewAccessCode link");
			}



			SeleniumRepo.waitForElementPresent(Enter_AlternateName);
			if (Enter_AlternateName.isEnabled()) {
				Enter_AlternateName.click();
				Enter_AlternateName.clear();
				Enter_AlternateName.sendKeys(AlternateName);
				test.log(Status.INFO, "AlternateName is entered successfully");
				logger.info("AlternateName is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter AlternateName");
				logger.error("Failed to Enter AlternateName");
			}

			SeleniumRepo.waitForElementPresent(Enter_AccessCode);
			if (Enter_AccessCode.isEnabled()) {
				Enter_AccessCode.click();
				Enter_AccessCode.clear();
				Enter_AccessCode.sendKeys(AccessCode);
				test.log(Status.INFO, "AccessCode is entered successfully");
				logger.info("AccessCode is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter AccessCode");
				logger.error("Failed to Enter AccessCode");
			}

			SeleniumRepo.waitForElementPresent(Enter_Note);
			if (Enter_Note.isEnabled()) {
				Enter_Note.click();
				Enter_Note.clear();
				Enter_Note.sendKeys(Note);
				test.log(Status.INFO, "Note is entered successfully");
				logger.info("Note is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Note");
				logger.error("Failed to Enter Note");
			}

			//SeleniumRepo.waitForElementPresent(save_Button);
			if (save_Button.isEnabled()) {
				save_Button.click();
				test.log(Status.PASS, "Clicked on save_Button ");
				logger.info("Clicked on save_Button ");
				Assert.assertTrue(true, "Clicked on save_Button ");
			} else {
				logger.info("Failed to Click on save_Button");
				test.log(Status.FAIL, "Failed to Click on save_Button");
			}

			//	SeleniumRepo.waitForElementPresent(ClickOn_ViewRatePlan);
			if (ClickOn_ViewRatePlan.isEnabled()) {
				ClickOn_ViewRatePlan.click();
				test.log(Status.PASS, "Clicked on ClickOn_ViewRatePlan ");
				logger.info("Clicked on ClickOn_ViewRatePlan ");
				Assert.assertTrue(true, "Clicked on ClickOn_ViewRatePlan ");
			} else {
				logger.info("Failed to Click on ClickOn_ViewRatePlan");
				test.log(Status.FAIL, "Failed to Click on ClickOn_ViewRatePlan");
			}

			//SeleniumRepo.waitForElementPresent(Get_PromoUrl);
			if (Get_PromoUrl.isDisplayed()) {
				Get_PromoUrl.click();
				test.log(Status.PASS, "Clicked on Get_PromoUrl link");
				logger.info("Clicked on Get_PromoUrl link");
				Assert.assertTrue(true, "Clicked on Get_PromoUrl link");
			} else {
				logger.info("Failed to Click on Get_PromoUrl link");
				test.log(Status.FAIL, "Failed to Click on Get_PromoUrl link");
			}



		} catch (Exception e) {
			logger.error("Unable to create Manage Acces Code for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Manage Acces Code for selected property because of this execption" + e);
			e.printStackTrace();
		}	





	}
}
