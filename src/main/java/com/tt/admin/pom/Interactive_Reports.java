package com.tt.admin.pom;


import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.tt.BE.pom.ClasicFlow;
import com.aventstack.extentreports.Status;

import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class Interactive_Reports extends BaseTest
{
	ClasicFlow ClasicFlow=PageFactory.initElements(SeleniumRepo.driver, ClasicFlow.class);
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Interactive Reporting')]") public WebElement Click_InteractiveReporting;

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Interactive Reports')]") public WebElement Click_InteractiveReportsLink;

	@FindBy(how=How.ID,using="fromDate") public WebElement Enter_BookingFromDate;

	@FindBy(how=How.ID,using="toDate") public WebElement Enter_BookingToDate;

	@FindBy(how=How.XPATH,using="//*[@id='grid_ratePlanTrackingCodeName']") public WebElement RatePlanTracking;

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Rate Plan Access Code')]") public WebElement Click_RatePlanAccessCode;

	@FindBy(how=How.XPATH,using="//span[text()='Run Report']") public WebElement Click_RunReport;

	@FindBy(how=How.XPATH,using="//*[@aria-describedby='grid_ratePlanTrackingCodeName']") public List<WebElement> AccessCodes;

	@FindBy(how=How.XPATH,using="//*[@id='report-title']") public WebElement Rateplan_Title;

	

	public void Click_InteractiveReporting()
	{
		ExplicitWait(Click_InteractiveReporting);
		if(Click_InteractiveReporting.isDisplayed()&&Click_InteractiveReporting.isEnabled())
		{
			Javascriptexecutor(Click_InteractiveReporting);
			test.log(Status.PASS, "Interactive Reporting element is displayed and Clicked Successfully");
			logger.info("Interactive Reporting element is displayed and Clicked Successfully");
		}
		else
		{
			test.log(Status.FAIL, "Interactive Reporting element not found");
			logger.error("Interactive Reporting element not found");
		}
	}
	public void Click_InteractiveReportsLink()
	{
		if (Click_InteractiveReportsLink.isDisplayed()&&Click_InteractiveReportsLink.isEnabled()) 
		{
			Javascriptexecutor(Click_InteractiveReportsLink);
			ExplicitWait(Click_RunReport);
			System.out.println("InteractiveReporting element Expanded and InteractiveReportsLink element  found");
			test.log(Status.INFO, "InteractiveReporting element Expanded and InteractiveReportsLink element  found");
		} 
		else 
		{
			System.out.println("InteractiveReporting Menu is not expanded");
			Javascriptexecutor(Click_InteractiveReporting);
			System.out.println("Clicked on InteractiveReports Link");
			test.log(Status.INFO, "Clicked on InteractiveReports Link");

			ExplicitWait(Click_InteractiveReportsLink);
			if(Click_InteractiveReportsLink.isDisplayed())
			{
				Javascriptexecutor(Click_InteractiveReportsLink);
				ExplicitWait(Click_RunReport);
				System.out.println("InteractiveReportsLink element found");
				test.log(Status.INFO, "InteractiveReportsLink element found");
			}
			else
			{
				logger.error("InteractiveReportsLink element not  found");
				test.log(Status.FAIL, "InteractiveReportsLink element not  found");
			}
		}
	}

	public void Click_RatePlanAccessCode()
	{
		ExplicitWait(Click_RatePlanAccessCode);
		if(Click_RatePlanAccessCode.isDisplayed()&&Click_RatePlanAccessCode.isEnabled())
		{
			Javascriptexecutor(Click_RatePlanAccessCode);
			test.log(Status.PASS, "RatePlanAccessCode Link Clicked");
			logger.info("RatePlanAccessCode Link Clicked");
		}
		else
		{
			logger.error("RatePlanAccessCode element not  found");
			test.log(Status.FAIL, "RatePlanAccessCode element not  found");
		}
	}
	public void verify_RatePlan_AccessCode_Analysis()
	{
		ExplicitWait(Rateplan_Title);
		if(Rateplan_Title.getText().equals("Rate Plan Access Code Analysis"))
		{
			test.log(Status.PASS,"Rate Plan Access Code Analysis title is displayed successfully");
			logger.info("Rate Plan Access Code Analysis title is displayed successfully");

		}
		else
		{
			test.log(Status.FAIL, "Rate Plan Access Code Analysis title not  found");
			logger.error("Rate Plan Access Code Analysis title not  found");
		}	
	}
	public void Enter_BookingFromDate()
	{
		ExplicitWait(Enter_BookingFromDate);
		if(Enter_BookingFromDate.isDisplayed())
		{
			Enter_BookingFromDate.sendKeys(ClasicFlow.formattedDate1);
			test.log(Status.INFO,"Booking From date is :"+ClasicFlow.formattedDate1);
			logger.info("Booking From date is :"+ClasicFlow.formattedDate1);
		}
		else
		{
			test.log(Status.FAIL, "BookingFromDate text field not  found");
			logger.error("BookingFromDate text field not  found");
		}

	}
	public void Enter_BookingToDate()
	{
		ExplicitWait(Enter_BookingToDate);
		if(Enter_BookingToDate.isDisplayed())
		{
			Enter_BookingToDate.sendKeys(ClasicFlow.formattedDate);
			test.log(Status.INFO,"Booking From date is :"+ClasicFlow.formattedDate);
			logger.info("Booking From date is :"+ClasicFlow.formattedDate);
		}
		else
		{
			test.log(Status.FAIL, "BookingToDate text field not  found");
			logger.error("BookingToDate text field not  found");
		}
	}
	public void Click_RunReport()
	{
		if(Click_RunReport.isDisplayed()&&Click_RunReport.isEnabled())
		{
			Javascriptexecutor(Click_RunReport);
			test.log(Status.PASS, "RunReport Button Clicked");
			logger.info("RunReport Button Clicked");

		}
		else
		{
			logger.error("RunReport element not  found");
			test.log(Status.FAIL, "RunReport element not  found");
		}
	}

	public void verify_TrackingCodeNames(String accesscode,String GrandTotal)
	{
		ExplicitWait(RatePlanTracking);
		if(RatePlanTracking.getText().contains("Compound Access Code"))
		{
			test.log(Status.PASS, "Compound Access Codes tracing name is added successfully");
			logger.info("Compound Access Codes tracing name is added successfully");
		}
		else
		{
			logger.error("Compound Access Codes tracing name  is not addedd");
			test.log(Status.FAIL, "Compound Access Codes tracing name  is not addedd");
		}
		/*if(AccessCodes.size()>0)
		{
			for(WebElement AccessCodes:AccessCodes)
			{
				if(AccessCodes.getText().equals(accesscode))
				{
					WebElement ROOM_REVENUE=SeleniumRepo.driver.findElement(By.xpath("//*[@title='"+accesscode+"']/following-sibling::td[1]"));
					test.log(Status.INFO, "Room Revenue is : "+ROOM_REVENUE.getText());
					logger.info("Room Revenue is : "+ROOM_REVENUE.getText());
					break;
				}
			}
		}
		else
		{
			test.log(Status.INFO, "There are no Bookings happend on the above mentioned dates");
		}*/
	}

}
