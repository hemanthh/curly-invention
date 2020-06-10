package com.tt.admin.pom;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

public class Policies extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//ul[@id='accordion']/li"),

	})
	private List<WebElement> Policies_link;


	@FindAll({ @FindBy(xpath = "//a[@id='add_new_policy']"),	
	})
	private WebElement Add_New;

	@FindAll({ @FindBy(xpath = "//*[@id='policyForm']//input[@name='name']"),

	})
	private WebElement Policy_Name;

	@FindAll({ @FindBy(xpath = "//*[@id='policyForm']//input[@name='code']"),

	})
	private WebElement Policy_Code;

	@FindAll({ @FindBy(xpath = "//*[@id='policyForm']//textarea[@name='description']"),

	})
	private WebElement Policy_Discription;

	@FindAll({ @FindBy(xpath = "//*[@id='policyForm']//select[@name='selectedGuaranteeId']"),

	})
	private WebElement Policy_DropDown;


	@FindAll({ @FindBy(xpath = "//*[@name='prePaymentType']"),

	})
	private List<WebElement> Check_Deposite;

	@FindAll({ @FindBy(xpath = "//input[@id='full']"),

	})
	private WebElement Fixed_Amount;


	@FindAll({ @FindBy(xpath = "//*[@id='policyForm']/a"),

	})
	private WebElement Click_NewCancellation;

	@FindAll({ @FindBy(xpath = "//input[@id='endInterval']"),

	})
	private WebElement EnterCancelation_windowindays;

	@FindAll({ @FindBy(xpath = "//select[@id='checkInOrMidnightTime']"),

	})
	private WebElement Select_Before;

	@FindAll({ @FindBy(xpath = "//select[@id='selectedHourOrDay']"),

	})
	private WebElement Select_DayorHour;

	@FindAll({ @FindBy(xpath = "//input[@name='selectedDeductionOption']"),

	})
	private List<WebElement> Check_CancellationFee;

	@FindAll({ @FindBy(xpath = "//input[@name='selectedDeductionOption']"),

	})
	private WebElement Enter_CancellationFee;


	@FindAll({ @FindBy(xpath = "//input[@value='Save']"),

	})
	private WebElement Click_Cancellation_Save;


	@FindAll({ @FindBy(xpath = "//input[@value='Save']"),

	})
	private WebElement Click_Save;


	@FindAll({ @FindBy(xpath = "//*[text()='Policies']"),

	})
	private WebElement Click_Policies;
	
	@FindAll({ @FindBy(xpath = "//input[@value='Delete']"),

	})
	private WebElement Delete_Policy;
	
	public void crtPolicies
	(String PolicyName,String  PolicyCode,String  PolicyDiscription,
			String PolicyDD,String CheckDeposite,String CancellationFee,
			String FixedAmount ,String days ,String DayorHour,String value , String Before)
	{

		try {
			if (Add_New.isDisplayed()) 
			{
				Javascriptexecutor(Add_New);
				ExplicitWait(Policy_Name);
				System.out.println("Policies element Expanded and Add_New element  found");
				test.log(Status.INFO, "Policies element Expanded and Add_New element  found");
				Assert.assertTrue(true, "Policies element Expanded and Add_New element  found");
			} 
			else 
			{
				System.out.println("Policies Menu is not expanded");
				Javascriptexecutor(Click_Policies);
				System.out.println("Clicked on policies Link");
				test.log(Status.INFO, "Clicked on policies Link");

				ExplicitWait(Add_New);
				if(Add_New.isDisplayed())
				{
					Javascriptexecutor(Add_New);
					ExplicitWait(Policy_Name);
					System.out.println("policies list element found");
					test.log(Status.INFO, "policies list element found");
					Assert.assertTrue(true, "policies list element found");
				}
				else
				{
					logger.info("policies list element not  found");
					test.log(Status.FAIL, "policies list element not  found");
				}
			}
			if (Policy_Name.isEnabled()) 
			{
				Policy_Name.click();
				Policy_Name.clear();
				Policy_Name.sendKeys(PolicyName);
				test.log(Status.PASS,"PolicyName is entered successfully");
				logger.info("PolicyName is entered successfully");
			}
			else
			{
				test.log(Status.FAIL, "Failed to Enter PolicyName");
				logger.error("Failed to Enter PolicyName");
			}


			SeleniumRepo.waitForElementPresent(Policy_Code);
			if (Policy_Code.isEnabled()) 
			{
				Policy_Code.click();
				Policy_Code.clear();
				Policy_Code.sendKeys(PolicyCode);
				test.log(Status.PASS,
						"PolicyCode is entered successfully");
				logger.info("PolicyCode is entered successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter PolicyCode");
				logger.error("Failed to Enter PolicyCode");
			}

			SeleniumRepo.waitForElementPresent(Policy_Discription);
			if (Policy_Discription.isEnabled()) 
			{
				Policy_Discription.click();
				Policy_Discription.clear();
				Policy_Discription.sendKeys(PolicyDiscription);
				test.log(Status.PASS, 
						"PolicyDiscription is entered successfully");
				logger.info("PolicyDiscription is entered successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter PolicyDiscription");
				logger.error("Failed to Enter PolicyDiscription");
			}

			SeleniumRepo.waitForElementPresent(Policy_DropDown);
			if (Policy_DropDown.isDisplayed()) 
			{
				SeleniumRepoDropdown.selectDropDownText(Policy_DropDown, PolicyDD);
				test.log(Status.PASS,
						"Policy selectDropDown successfully");
				logger.info("Policy selectDropDown successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Policy selectDropDown");
				logger.error("Failed to Policy selectDropDown");
			}



			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_Deposite, CheckDeposite);
				Fixed_Amount.sendKeys(FixedAmount);
				test.log(Status.PASS, "Check_Deposite  successfully");
				logger.info("Policy Check_Deposite successfully");
			} 
			catch (Exception e) 
			{
				test.log(Status.FAIL, 
						"Failed to Check_Deposite");
				logger.error("Failed to Check_Deposite");
				e.printStackTrace();
			}

			SeleniumRepo.waitForElementPresent(Click_NewCancellation);
			if (Click_NewCancellation.isEnabled()) 
			{
				Javascriptexecutor(Click_NewCancellation);
				SeleniumRepo.waitForPageLoaded();
				test.log(Status.PASS,"Clicked on NewCancellationWindow link");
				logger.info("Clicked on NewCancellationWindow link");
				Assert.assertTrue(true, "Clicked on NewCancellationWindow link");
			} 
			else
			{
				logger.info("Failed to Click on NewCancellationWindow link");
				test.log(Status.FAIL,"Failed to Click on NewCancellationWindow link");
			}

			ExplicitWait(EnterCancelation_windowindays);

			if (EnterCancelation_windowindays.isEnabled()) 
			{
				EnterCancelation_windowindays.click();
				EnterCancelation_windowindays.clear();
				EnterCancelation_windowindays.sendKeys(days);
				test.log(Status.PASS, "Days is entered successfully");
				logger.info("Days is entered successfully");
			} 
			else
			{
				test.log(Status.FAIL, "Failed to Enter Days");
				logger.error("Failed to Enter Days");
			}


			Thread.sleep(2000);
			if (Select_DayorHour.isDisplayed())
			{
				Select sc=new Select(Select_DayorHour);
				sc.selectByVisibleText(DayorHour);

				//SeleniumRepoDropdown.selectDropDownText(Select_DayorHour,DayorHour);
				test.log(Status.PASS,"DayorHour selectDropDown successfully");
				logger.info("DayorHour selectDropDown successfully");
			} else {
				test.log(Status.FAIL,"Failed to DayorHour selectDropDown");
				logger.error("Failed to DayorHour selectDropDown");
			}

			Thread.sleep(5000);
			if (Select_Before.isDisplayed())
			{

				Select sc=new Select(Select_Before);
				sc.selectByVisibleText(Before);

				//	SeleniumRepoDropdown.selectDropDownText(Select_Before, Before);
				test.log(Status.PASS, "Before selectDropDown successfully");
				logger.info("Before selectDropDown successfully");

			} else {
				test.log(Status.FAIL,
						"Failed to Before selectDropDown");
				logger.error("Failed to Before selectDropDown");
			}
			Thread.sleep(3000);
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Check_CancellationFee, CancellationFee);
			Enter_CancellationFee.click();
			//Enter_CancellationFee.clear();
			Enter_CancellationFee.sendKeys(value);
			test.log(Status.PASS, 
					"Check_CancellationFee successfully");
			logger.info("Policy Check_ CancellationFee successfully");

			Thread.sleep(2000);

			if (Click_Cancellation_Save.isDisplayed()) 
			{
				Javascriptexecutor(Click_Cancellation_Save);
				test.log(Status.PASS, 
						"Clicked on Save link");
				logger.info("Clicked on Save  link");
				Assert.assertTrue(true, "Clicked on Save link");
			} else {
				logger.info("Failed to Click on Save link");
				test.log(Status.FAIL, 
						"Failed to Click on Save link");
			}

			Thread.sleep(2000);

			ExplicitWait(Click_Save);
		
			
			
			if (SeleniumRepo.isElementDisplayed(Click_Save) == true) 
			{
				Click_Save.click();
				SeleniumRepo.waitForPageLoaded();
				test.log(Status.PASS,
						"Clicked on Cancellation_Save link");
				logger.info("Clicked on Cancellation_Save  link");
				Assert.assertTrue(true, "Clicked on Cancellation_Save link");
			} else {
				logger.info("Failed to Click on Cancellation_Save link");
				test.log(Status.FAIL, 
						"Failed to Click on Cancellation_Save link");
			}


		} catch (Exception e)
		{
			logger.error("Unable to create Policies for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Policies for selected property because of this execption" + e);
			e.printStackTrace();
		}	


	}}
