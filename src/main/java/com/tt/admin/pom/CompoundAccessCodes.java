package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class CompoundAccessCodes extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	AddNewRatePlan NewRateplan=PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Compound Access Codes')]") public WebElement Click_CompoundAccessCodes;

	@FindBy(how=How.XPATH,using="//h1[text()='Compound Access Code']") public WebElement Title_CompoundAccessCode;

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Add new compound access code')]") public WebElement Click_AddNewCompoundAccessCode;

	@FindBy(how=How.XPATH,using="//*[contains(@onclick,'editCompoundAccessCode')]") public List<WebElement>Edit_Buttons;

	@FindBy(how=How.XPATH,using="//*[@name='code']") public WebElement Enter_CodeName;

	@FindBy(how=How.XPATH,using="//*[@name='selectedRatePlanIds']") public WebElement selectedRatePlanIds;

	@FindBy(how=How.XPATH,using="//*[@value='Save']") public WebElement Click_AccesscodeSave;

	@FindBy(how=How.XPATH,using="//*[text()='OK']") public WebElement Click_OK;


	public void Verify_CompoundAccessCodeLink() throws InterruptedException
	{
		Thread.sleep(2000);
		if(Click_CompoundAccessCodes.isDisplayed())
		{
			test.log(Status.PASS, "CompoundAccessCode Link is displaying Under Rate Plans");
			logger.info("CompoundAccessCode Link is displaying successfully");
		}
		else
		{
			test.log(Status.FAIL, "CompoundAccessCode Link is Not Found under Rate Plans");
			logger.error("CompoundAccessCode Link is not found under Rate Plans");
		}
	}
	public void Click_CompoundAccessCodes()
	{

		if (Click_CompoundAccessCodes.isDisplayed()) 
		{
			Click_CompoundAccessCodes.click();
			ExplicitWait(Title_CompoundAccessCode);

			System.out.println("RatePlans link Expanded and CompoundAccessCode element  found");
			test.log(Status.INFO, "RatePlans link Expanded and CompoundAccessCode element  found");
			Assert.assertTrue(true, "RatePlans link Expanded and CompoundAccessCode element  found");
		} 
		else 
		{
			System.out.println("Rate Plans Menu is not expanded");
			Javascriptexecutor(NewRateplan.Rateplan);
			System.out.println("Clicked on Rate Plans Link");
			test.log(Status.INFO, "Clicked on Rate Plans Link");

			ExplicitWait(Click_CompoundAccessCodes);

			if (Click_CompoundAccessCodes.isDisplayed()) 
			{
				Click_CompoundAccessCodes.click();
				test.log(Status.PASS, "Clicked on CompoundAccessCode link");
				logger.info("Clicked on CompoundAccessCode link");
				Assert.assertTrue(true, "Clicked on CompoundAccessCode link");
				ExplicitWait(Title_CompoundAccessCode);
				if(!(Edit_Buttons.size()>0))
				{
					if(NewRateplan.BODY.getText().contains("No Compound Access Code available."))
					{
						System.out.println("Compound Access Codes are not created yet");
						test.log(Status.PASS, "Compound Access Codes are not created yet");
					}
					else
					{
						test.log(Status.FAIL, "No Compound Access Code available. message is not showing");
						logger.error("No Compound Access Code available. message is not showing");

					}
				}
				else
				{
					System.out.println("Compound Access Codes already created");
					test.log(Status.PASS, "Compound Access Codes already created");			
				}
			} 
			else
			{
				logger.error("List All element not found");
				test.log(Status.FAIL, "List All element not found");
			}
		}
	}

	public void Click_AddCompoundAccessCode()
	{
		ExplicitWait(Click_AddNewCompoundAccessCode);
		if(Click_AddNewCompoundAccessCode.isDisplayed())
		{
			Javascriptexecutor(Click_AddNewCompoundAccessCode);
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.PASS, "Clicked on Add Compound Access Codes ");	
		}
		else
		{
			logger.error("Add Compound Access Codes element not found");
			test.log(Status.FAIL, "Add Compound Access CodesList All element not found");
		}

	}
	public void Enter_CodeName(String CompoundAccessCode)
	{
		if(Enter_CodeName.isDisplayed())
		{
			Enter_CodeName.sendKeys(CompoundAccessCode);
			test.log(Status.PASS, CompoundAccessCode+" is enterd sucessfully");
			logger.info(CompoundAccessCode+" is enterd sucessfully");
		}
		else
		{
			test.log(Status.FAIL, "Compound Access Code text field is not found");
			logger.error("Compound Access Code text field is not found");
		}
	}
	public void Click_Save()
	{
		if(Click_AccesscodeSave.isDisplayed())   	 
		{
			Javascriptexecutor(Click_AccesscodeSave);
			test.log(Status.INFO, "Clicked On Save");
			logger.info("Clicked on SAve");
			ExplicitWait(Title_CompoundAccessCode);
		}
		else
		{
			logger.error("Save Button not found");
			test.log(Status.FAIL, "Save Button not found");
		}
	}
	public void Delete_CompoundAccessCode(String CompoundAccessCode)
	{
		//WebElement ClickCheckbox_DeleteCompoundAccessCode=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+CompoundAccessCode+"')]/preceding-sibling::td/input[@name='selectedItemsToDelete']"));
		if(NewRateplan.BODY.getText().contains(CompoundAccessCode))
		{

			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+CompoundAccessCode+"')]/preceding-sibling::td/input[@name='selectedItemsToDelete']")));
			Javascriptexecutor(NewRateplan.Click_Delete);
			SeleniumRepo.waitForPageLoaded();
			Javascriptexecutor(Click_OK);
			ExplicitWait(Title_CompoundAccessCode);
		}
		else
		{
			test.log(Status.INFO, "Duplicate "+CompoundAccessCode+" is not found");
			logger.info("Duplicate "+CompoundAccessCode+" is not found");
		}
	}	
	public void SelectMultipleRateplans(String Rateplan1,String Rateplan2)

	{
		if(selectedRatePlanIds.isDisplayed())
		{
			selectByVisibleText(selectedRatePlanIds, Rateplan1);
			selectByVisibleText(selectedRatePlanIds, Rateplan2);
			test.log(Status.INFO, Rateplan1+" rate plan and "+Rateplan2+" selected");
			logger.info(Rateplan1+" rate plan and "+Rateplan2+" selected");
		}
		else
		{
			logger.error("selectedRatePlanIds Element not found");
			test.log(Status.FAIL, "selectedRatePlanIds Element not found");
		}

	}
	public String verify_MultipleRateplans(String Rateplan1,String Rateplan2,String CompoundAccessCode)
	{

		List<WebElement>Associated_Rate_plans =SeleniumRepo.driver.findElements(By.xpath("//*[contains(text(),'"+CompoundAccessCode+"')]/following-sibling::td/li"));
		String Rateplans=Rateplan1+" "+Rateplan2;
		if(Associated_Rate_plans.size()>0)
		{
			for(WebElement Associated:Associated_Rate_plans)
			{
				if(Rateplans.contains(Associated.getText()))
				{
					test.log(Status.PASS, Associated.getText()+" Rateplan associated successfully");
				}
				else
				{
					test.log(Status.FAIL, Associated.getText()+" Rateplan is not associated ");
					logger.error(Associated.getText()+" Rateplan is not associated ");
				}
			}
		}
		return CompoundAccessCode;
	}


}
