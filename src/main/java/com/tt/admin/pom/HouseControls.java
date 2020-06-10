package com.tt.admin.pom;

import java.text.SimpleDateFormat;
import java.util.Date;

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

public class HouseControls extends BaseTest
{
	RateGrid grid=PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
	AlternateProperties AlterPoprty =PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindBy(how=How.XPATH,using="//*[contains(@href,'/rt/admin/action/displayCloseHouse')]") public WebElement Click_HouseControls;

	@FindBy(how=How.XPATH,using="//*[starts-with(@id,'fromDate_')]") public WebElement HouseControl_StartDate;

	@FindBy(how=How.XPATH,using="//*[starts-with(@id,'toDate_')]") public WebElement HouseControl_EndDate;

	@FindBy(how=How.XPATH,using="//h1[contains(text(),'House Controls')]") public WebElement HouseControl_Title;

	@FindBy(how=How.XPATH,using="//input[@name='all']") public WebElement Select_AllRooms;

	@FindBy(how=How.XPATH,using= "//input[@value='Apply Control']")public  WebElement Click_ApplyControl;



	public void click_HouseControls()
	{
		if (Click_HouseControls.isDisplayed()) 
		{
			Javascriptexecutor(Click_HouseControls);
			ExplicitWait(HouseControl_Title);
			System.out.println("Rates and Inventory element Expanded and House Controls element  found");
			test.log(Status.INFO, "Rates and Inventory element Expanded and House Controls element  found");
			Assert.assertTrue(true, "Rates and Inventory element Expanded and House Controls element  found");
		} 
		else 
		{
			System.out.println("Rates and Inventory Menu is not expanded");
			Javascriptexecutor(grid.Click_RatesandInventory);
			System.out.println("Clicked on Rates and Inventory Link");
			test.log(Status.INFO, "Clicked on Rates and Inventory Link");

			ExplicitWait(Click_HouseControls);
			if(Click_HouseControls.isDisplayed())
			{
				Javascriptexecutor(Click_HouseControls);
				ExplicitWait(HouseControl_Title);
				System.out.println("House Controls element found");
				test.log(Status.INFO, "House Controls  element found");
				Assert.assertTrue(true, "House Controls element found");
			}
			else
			{
				logger.error("House Controls element not  found");
				test.log(Status.FAIL, "House Controls element not  found");
			}
		}

	}

	@SuppressWarnings("deprecation")
	public void HouseControl_Startdate() throws InterruptedException
	{
		Thread.sleep(2000);
		ExplicitWait(HouseControl_StartDate);
		if(HouseControl_StartDate.isEnabled())
		{
			Date date1 = new Date();
			date1.setDate(date1.getDate());
			SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/YY");
			String Startdate=df2.format(date1);
			HouseControl_StartDate.click();
			HouseControl_StartDate.sendKeys(Startdate);
			test.log(Status.INFO, "StartDate "+Startdate+" enterd successfully");
			logger.info("StartDate "+Startdate+" enterd successfully");
		}
		else
		{
			test.log(Status.FAIL, "Start date Element not found");
			logger.error("Start date Element not found");
		}

	}
	@SuppressWarnings("deprecation")
	public void HouseControl_Enddate()
	{
		Date date = new Date();
		date.setDate(date.getDate() + 7);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
		String Enddate = df.format(date);

		if(HouseControl_EndDate.isEnabled())
		{
			HouseControl_EndDate.sendKeys(Enddate);
			test.log(Status.PASS, "EndDate "+Enddate+" enterd successfully");
			logger.info("EndDate "+Enddate+" enterd successfully");
		}
		else
		{
			test.log(Status.FAIL, "EndDate Element not found");
			logger.error("EndDate Element not found");
		}			
	}

	public void Select_radio_Controls(String Control)
	{
		ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[contains(@id,'"+Control+"') and @type='radio']")));
		WebElement Select_control=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@id,'"+Control+"') and @type='radio']"));
		if(Select_control.isDisplayed())
		{
			test.log(Status.PASS, "Control "+Control+" displayed successfully");
			logger.info("Control "+Control+" displayed successfully");
			if(!(Select_control.isSelected()))
			{
				Javascriptexecutor(Select_control);
				test.log(Status.INFO, "Control "+Control+" Selected successfully");
				logger.info("Control "+Control+" Selected successfully");

			}
			else
			{
				test.log(Status.INFO, "Control "+Control+" already Selected successfully");
				logger.info("Control "+Control+" already Selected successfully");

			}
		}
		else
		{
			test.log(Status.FAIL, "Control "+Control+" element not found");
			logger.error("Control "+Control+" element not found");
		}
	}
	public void Apply_To(String days)
	{
		ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'Apply To :')]/following-sibling::td/input[contains(@id,'"+days+"')]")));
		WebElement Select_ApplyTo=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'Apply To :')]/following-sibling::td/input[contains(@id,'"+days+"')]"));
		if(Select_ApplyTo.isDisplayed())
		{
			test.log(Status.PASS, "Apply to "+days+" day displayed successfully");
			logger.info("Apply to "+days+" day displayed successfully");
			if(!(Select_ApplyTo.isSelected()))
			{
				Javascriptexecutor(Select_ApplyTo);
				test.log(Status.INFO, "Apply To "+days+" day Selected successfully");
				logger.info("Apply To "+days+" Selected successfully");

			}
			else
			{
				test.log(Status.INFO, "Apply To "+days+" day already Selected");
				logger.info("Apply To "+days+" already Selected");

			}
		}
		else
		{
			test.log(Status.FAIL, "Apply to "+days+" day  element not found");
			logger.error("Apply to "+days+"  day element not found");
		}
	}

	public void Select_Rateplans_Rooms(String SelectRateplan)
	{
		ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[@value='"+SelectRateplan+"']")));
		WebElement Select_Rateplan=SeleniumRepo.driver.findElement(By.xpath("//*[@value='"+SelectRateplan+"']"));

		if(SelectRateplan.equals("AllRatePlans"))
		{
			if(Select_Rateplan.isDisplayed())
			{
				Javascriptexecutor(Select_Rateplan);

				test.log(Status.PASS, SelectRateplan +" selected successfully");
				logger.info(SelectRateplan +" selected successfully");
				ExplicitWait(Select_AllRooms);
				if(Select_AllRooms.isDisplayed())
				{

					Javascriptexecutor(Select_AllRooms);
					test.log(Status.PASS, "Under "+SelectRateplan+" All rooms Selected successfully");
					logger.info( "Under "+SelectRateplan+" All rooms Selected successfully");     
				}
				else
				{
					test.log(Status.FAIL,  "Under "+SelectRateplan+" All rooms check box not found");
					logger.error(  "Under "+SelectRateplan+" All rooms check box not found");
				}

			}
			else
			{
				test.log(Status.FAIL, SelectRateplan +" rateplan not found");
				logger.error(SelectRateplan +" rateplan not found");
			}
		}
		else if(SelectRateplan.equals("FixedFloating"))
		{

		}
		else if(SelectRateplan.equals("RateClassification"))
		{

		}
		else if(SelectRateplan.equals("RatePlanTag"))
		{

		}

	}

	public void Click_ApplyControl() throws InterruptedException
	{
		ExplicitWait(Click_ApplyControl);
		if(Click_ApplyControl.isEnabled())
		{
			Javascriptexecutor(Click_ApplyControl);
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.PASS, "Apply Control displayed and Clicked successfully");
			logger.info("Apply Control displayed and Clicked successfully");
			ExplicitWait(grid.Click_Confirm);

			Javascriptexecutor(grid.Click_Confirm);
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.INFO, "Confirm button clicked successfully");
			logger.info("Confirm button clicked successfully");

			ExplicitWait(HouseControl_Title);
			Thread.sleep(2000);

			if(AlterPoprty.Body.getText().contains("House Control request has been successfully submitted."))
			{
				test.log(Status.PASS, "House Control request has been successfully submitted.");
				logger.info("House Control request has been successfully submitted.");
			}
			else
			{
				test.log(Status.FAIL,  "Failed to submit House Control request");
				logger.error( "Failed to submit House Control request");
			}

		}
		else
		{
			test.log(Status.FAIL,  "Apply Control element not found");
			logger.error( "Apply Control element not found");
		}
	}
	public void openhousecontrol(String days,String OpenControl,String SelectRateplan) throws InterruptedException
	{

		click_HouseControls();
		HouseControl_Startdate();
		HouseControl_Enddate();
		Apply_To(days);
		Select_radio_Controls(OpenControl);
		Select_Rateplans_Rooms(SelectRateplan);
		Click_ApplyControl();
	}

}
