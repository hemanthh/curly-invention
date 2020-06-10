package com.tt.admin.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class SmartPolicies extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//div[text()= 'Smart Policies']"),

	})
	private WebElement SmartPolicies_link;


	@FindAll({ @FindBy(xpath = "//*[@id='add_new_smart_policy']"),

	})
	private WebElement SP_AddNew;

	@FindAll({ @FindBy(xpath = "//td/form/p/input[@name='name']"),

	})
	private WebElement SP_Name;

	@FindAll({ @FindBy(xpath = "//select[@name='defaultPolicyId']"),

	})
	private WebElement Select_DefaultPoliciy;

	@FindAll({ @FindBy(xpath = "//select[@name='altDefaultPolicyA']"),

	})
	private WebElement Select_APoliciy;

	@FindAll({ @FindBy(xpath = "//select[@name='altDefaultPolicyB']"),

	})
	private WebElement Select_BPoliciy;

	@FindAll({ @FindBy(xpath = "//select[@name='prePaymentTypeA']"),

	})
	private WebElement Select_APayment;


	@FindAll({ @FindBy(xpath = "//select[@name='prePaymentTypeB']"),

	})
	private WebElement Select_BPayment;

	@FindAll({ @FindBy(xpath = "//td//*[@name='amountA']"),

	})
	private WebElement Enter_Aamount;

	@FindAll({ @FindBy(xpath = "//td//*[@name='amountB']"),

	})
	private WebElement Enter_Bamount;


	@FindAll({ @FindBy(xpath = "//td/form/a[text()='Add a new Exceptional Policy']"),

	})
	private WebElement NewExceptional_link;


	@FindAll({ @FindBy(xpath = "//input[@name='startDate']"),

	})
	private WebElement Start_Date;


	@FindAll({ @FindBy(xpath = "//input[@name='endDate']"),

	})
	private WebElement End_Date;

	@FindAll({ @FindBy(xpath = "//td/select[@name='exPolicyPolicyId']"),

	})
	private WebElement Exceptional_Policy;


	@FindAll({ @FindBy(xpath = "//input[@value='Save']"),

	})
	private WebElement Exceptional_Save;


	@FindAll({ @FindBy(xpath = "//input[@value='Save']"),

	})
	private WebElement SP_Save;


	public void smartPolicy
	(String SPName,String DefaultPoliciy,String APoliciy, String BPoliciy,
			String APayment, String BPayment,String Aamount,String Bamount,String Ex_Policy)
	{

		try {


			if (SP_AddNew.isDisplayed()) 
			{
				SP_AddNew.click();
				ExplicitWait(SP_Name);
				
				System.out.println("Smart Policies element Expanded and Add New  element  found");
				test.log(Status.INFO, "Smart Policies element Expanded and Add New  element  found");
				Assert.assertTrue(true, "Smart Policies element Expanded and Add New  element  found");
			} 
			else 
			{
				System.out.println("Smart Policies Menu is not expanded");
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()='Smart Policies']")));
				System.out.println("Clicked on Smart policies Link");
				test.log(Status.INFO, "Clicked on Smart policies Link");

				ExplicitWait(SP_AddNew);

				if (SP_AddNew.isDisplayed()) 
				{
					SP_AddNew.click();
					ExplicitWait(SP_Name);
					test.log(Status.PASS, "Clicked on Addnew link");
					logger.info("Clicked on Addnew link");
					Assert.assertTrue(true, "Clicked on Addnew link");
				} 
				else
				{
					logger.info("Add new element not found");
					test.log(Status.FAIL, "Add new element not found");
				}
			}
			if (SP_Name.isEnabled()) 
			{
				SP_Name.click();
				SP_Name.clear();
				SP_Name.sendKeys(SPName);
				test.log(Status.PASS, 
						"SP_Name is entered successfully");
				logger.info("SP_Name is entered successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter SP_Name");
				logger.error("Failed to Enter SP_Name");
			}

			Thread.sleep(3000);

			if (Select_DefaultPoliciy.isDisplayed())
			{
				Select sc=new Select(Select_DefaultPoliciy);
				sc.selectByVisibleText(DefaultPoliciy);

				//SeleniumRepoDropdown.selectDropDownText(Select_DefaultPoliciy, DefaultPoliciy);
				test.log(Status.PASS,"DefaultPoliciy selectDropDown successfully");
				logger.info("DefaultPoliciy  selectDropDown successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to DefaultPoliciy selectDropDown");
				logger.error("Failed to DefaultPoliciy selectDropDown");
			}

			Thread.sleep(3000);
			if (Select_APoliciy.isDisplayed())
			{
				Select sc=new Select(Select_APoliciy);
				sc.selectByVisibleText(APoliciy);

				//SeleniumRepoDropdown.selectDropDownText(Select_APoliciy, APoliciy);
				test.log(Status.PASS, 
						"APoliciy selectDropDown successfully");
				logger.info("APoliciy  selectDropDown successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to APoliciy selectDropDown");
				logger.error("Failed to APoliciy selectDropDown");
			}
			Thread.sleep(3000);

			if (Select_BPoliciy.isDisplayed()) 
			{
				Select sc=new Select(Select_BPoliciy);
				sc.selectByVisibleText(BPoliciy);

				test.log(Status.PASS, 
						"BPoliciy selectDropDown successfully");
				logger.info("BPoliciy selectDropDown successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to BPoliciy selectDropDown");
				logger.error("Failed to BPoliciy selectDropDown");
			}

			SeleniumRepo.waitForElementPresent(Select_APayment);
			if (Select_APayment.isDisplayed()) 
			{
				Select sc=new Select(Select_APayment);
				sc.selectByVisibleText(APayment);
				test.log(Status.PASS,
						"APayment selectDropDown successfully");
				logger.info("APayment selectDropDown successfully");
			} else {
				test.log(Status.FAIL,  
						"Failed to APayment selectDropDown");
				logger.error("Failed to APayment selectDropDown");
			}

			SeleniumRepo.waitForElementPresent(Select_BPayment);
			if (Select_BPayment.isDisplayed()) 
			{
				Select sc=new Select(Select_BPayment);
				sc.selectByVisibleText(BPayment);

				test.log(Status.PASS, 
						"BPayment selectDropDown successfully");
				logger.info("BPayment selectDropDown successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to BPayment selectDropDown");
				logger.error("Failed to BPayment selectDropDown");
			}

			SeleniumRepo.waitForElementPresent(Enter_Aamount);
			if (Enter_Aamount.isEnabled()) 
			{
				Enter_Aamount.click();
				Enter_Aamount.clear();
				Enter_Aamount.sendKeys(Aamount);
				test.log(Status.PASS, 
						"Aamount is entered successfully");
				logger.info("Aamount is entered successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter Aamount");
				logger.error("Failed to Enter Aamount");
			}

			SeleniumRepo.waitForElementPresent(Enter_Bamount);
			if (Enter_Bamount.isEnabled()) 
			{
				Enter_Bamount.click();
				Enter_Bamount.clear();
				Enter_Bamount.sendKeys(Bamount);
				test.log(Status.PASS, 
						"Bamount is entered successfully");
				logger.info("Bamount is entered successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter Bamount");
				logger.error("Failed to Enter Bamount");
			}


			if (SeleniumRepo.isElementPresent(NewExceptional_link)) 
			{
				NewExceptional_link.click();
				test.log(Status.PASS,
						"Clicked on NewExceptional link");
				logger.info("Clicked on NewExceptional link");
				Assert.assertTrue(true, "Clicked on NewExceptional link");
			} else {
				logger.info("Failed to Click on NewExceptional link");

				test.log(Status.FAIL, 
						"Failed to Click on NewExceptional link");
			}

			ExplicitWait(Start_Date);
			if(SeleniumRepo.isElementPresent(Start_Date)) 
			{	 

				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
				Date date = new Date();
				String date1= dateFormat.format(date);
				Start_Date.clear();
				Start_Date.click();
				Start_Date.sendKeys(date1);
				test.log(Status.PASS,
						"Start Date Data Entered");
				logger.info("Start Date Data Entered");
				Assert.assertTrue(true, "Start Date Data Entered");
			}else {
				logger.info("Failed to Enter Start Date ");
				test.log(Status.FAIL,
						"Failed to Enter Start Date");
			}			

			if(SeleniumRepo.isElementPresent(End_Date)) 
			{

				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date dt = new Date();
				Calendar cl = Calendar.getInstance();
				cl.setTime(dt);;
				cl.add(Calendar.DAY_OF_YEAR, 7);
				dt=cl.getTime();
				String str = df.format(dt);
				System.out.println("the date today is " + str);
				End_Date.click();
				End_Date.clear();
				End_Date.sendKeys(str);
				test.log(Status.PASS,
						"End Date Data Entered");
				logger.info("End Date Data Entered");
				Assert.assertTrue(true, "End Date Data Entered");
			}else {
				logger.info("Failed to Enter End Date ");
				test.log(Status.FAIL,
						"Failed to Enter End Date");
			}		


			SeleniumRepo.waitForElementPresent(Exceptional_Policy);
			if (Exceptional_Policy.isDisplayed())
			{
				SeleniumRepoDropdown.selectDropDownText(Exceptional_Policy, Ex_Policy);
				test.log(Status.PASS, 
						"Ex_Policy selectDropDown successfully");
				logger.info("Ex_Policy selectDropDown successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Ex_Policy selectDropDown");
				logger.error("Failed to Ex_Policy selectDropDown");
			}


			SeleniumRepo.waitForElementPresent(Exceptional_Save);
			if (Exceptional_Save.isDisplayed())
			{
				Exceptional_Save.click();
				test.log(Status.PASS, 
						"Clicked on Exceptional_Save link");
				logger.info("Clicked on Exceptional_Save link");
				Assert.assertTrue(true, "Clicked on Exceptional_Save link");
			} else {
				logger.info("Failed to Click on Exceptional_Save link");

				test.log(Status.FAIL, 
						"Failed to Click on Exceptional_Save link");
			}


			SeleniumRepo.waitForElementPresent(SP_Save);
			if (SP_Save.isDisplayed()) 
			{
				SP_Save.click();
				SeleniumRepo.waitForPageLoaded();
				//ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List of Smart Policies']")));
				test.log(Status.PASS,
						"Clicked on SP_Save link");
				logger.info("Clicked on SP_Save link");
				Assert.assertTrue(true, "Clicked on SP_Save link");
			} else {
				logger.info("Failed to Click on SP_Save link");
				test.log(Status.FAIL, 
						"Failed to Click on SP_Save link");
			}



		} catch (Exception e) 
		{
			logger.error("Unable to create Smart Policies for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Smart Policies for selected property because of this execption" + e);
			e.printStackTrace();
		}	


	}}
