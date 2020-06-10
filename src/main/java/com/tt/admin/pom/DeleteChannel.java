package com.tt.admin.pom;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class DeleteChannel extends BaseTest {
	 String result=this.getClass().getSimpleName();
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(linkText = "Channels"), @FindBy(xpath = "//a[contains(text(),'Channels')]"),

	})
	private WebElement channels_link;
	@FindAll({ @FindBy(xpath = "//td[contains(text(),'GDS')]"),

	})
	private List<WebElement> existing_channel;

	@FindAll({ @FindBy(linkText = "Add New Channel Group"),
			@FindBy(xpath = "//a[contains(text(),'Add New Channel Group')]"), })
	
	private WebElement addNew_Channel_link;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'GDS')]/preceding-sibling::td/input"), })
	
	private WebElement Dlt_Channel_checkbox;

	@FindAll({ @FindBy(xpath = "//input[@value='Delete']"), })
	
	private WebElement Dlt_Btn;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'No Channels Defined For This Property')]"), })
	
	private List<WebElement> Channel_msg;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	
	private WebElement Click_PropertyManagement;
	@FindAll({ @FindBy(linkText = "Channels"), @FindBy(xpath = "//a[contains(text(),'Channels')]"),

	})
	private List<WebElement> channels;
	public void deleteChannel() throws IOException {
		
		try {
		
			SeleniumRepo.waitForPageLoaded();
		if(SeleniumRepo.isElementPresent(Click_PropertyManagement))
		{

			if(channels_link.isDisplayed())
			{
				
				System.out.println("Clicked on property Management link");
				test.log(Status.PASS, "Clicked on property Management link");
				logger.info("Clicked on property Management link");

				Assert.assertTrue(true, "Clicked on property Management link");
				logger.info(" property Management link already selected");

				test.log(Status.PASS, "property Management link already selected");
			} 
			else
			{
				Click_PropertyManagement.click();
				System.out.println("Clicked on property Management link");
				test.log(Status.PASS, "Clicked on property Management link");
				logger.info("Clicked on property Management link");

				Assert.assertTrue(true, "Clicked on property Management link");

			}

		}else {
			logger.error("Failed to click on property Management link");

			System.out.println(" Failed to click on property Management link");
			test.log(Status.FAIL, "Failed to Click on property Management link");

		}


		
			SeleniumRepo.waitForElementPresent(channels_link);

			if (SeleniumRepo.isElementPresent(channels_link)) {

				channels_link.click();

				logger.info("Clicked on Channel Link ");

				test.log(Status.INFO, "Clicked on Channel Link");
			} else {
				logger.error(" Failed to Click on Channel Link");

				test.log(Status.ERROR, " Failed to Click on Channel Link");
			}

			SeleniumRepo.waitForElementPresent(addNew_Channel_link);

			if (existing_channel.size() > 0) {

				if (existing_channel.size() > 0) {

					Dlt_Channel_checkbox.click();
					logger.info("Selected checkbox ");

					test.log(Status.INFO, "Selected checkbox");
				} else {
					logger.error(" Failed to Select checkbox");

					test.log(Status.ERROR, " Failed to Select checkbox");
				}
				SeleniumRepo.waitForElementPresent(Dlt_Btn);

				if (SeleniumRepo.isElementPresent(Dlt_Btn)) {

					Dlt_Btn.click();

					logger.info("Clicked on Delete button");

					test.log(Status.INFO, "Clicked on Delete button");
				} else {
					logger.error(" Failed to Click on delete button");

					test.log(Status.ERROR, " Failed to Click on delete button");
				}

				SeleniumRepo.SwitchAlert();

				if (Channel_msg.size() > 0) {
					logger.info("Channel is deleted successfully");

					test.log(Status.INFO, "Channel is deleted successfully");
				} else {
					logger.error(" Failed to delete channel");

					test.log(Status.ERROR, " Failed to delete channel");
				}

			} else {
				logger.info("No channel to delete");

				test.log(Status.INFO, "No channel to delete"+ test.addScreenCaptureFromPath(captureScreenShot(result,"pass")));
			}
		} catch (Exception e) {
			logger.error("Unable to delete channel for selected property because of this execption"+e);
			test.log(Status.ERROR, "Unable to delete channel for selected property because of this execption"+e);
			e.printStackTrace();	
		}
	}
}
