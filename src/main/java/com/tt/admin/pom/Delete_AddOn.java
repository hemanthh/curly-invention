package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class Delete_AddOn extends BaseTest  {

	WebDriver driver ;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//div[contains(text(), 'Add-Ons')]"),

	})
	private WebElement Addon_link;

	@FindAll({@FindBy(xpath = "//a[contains(@href,'/rt/admin/action/displayAddOnList.do?')]"),

	})
	private WebElement ListAll_link;


	@FindAll({ @FindBy(xpath = "//input[@name='addOns']"),

	})
	private List<WebElement> Select_addOns_Checkbox;

	@FindAll({ @FindBy(xpath = "//input[@value='Delete']"),

	})
	private WebElement Delete_Policy;

	@FindAll({ @FindBy(xpath = "//input[@value='Yes']"),

	})
	private WebElement click_Yes;


	public void deletePolicy(String AddonName) {

		try {

			SeleniumRepo.waitForElementPresent(Addon_link);
			if (  SeleniumRepo.isElementDisplayed(ListAll_link) == true ) {

				test.log(Status.PASS, "Clicked on  Addon_link link");
				logger.info("Clicked on  Addon_link link");
				Assert.assertTrue(true, "Clicked on  Addon_link link");
			} else {
				Addon_link.click();
				logger.info("Clicked on  Addon_link link");
				test.log(Status.PASS, "Clicked on  Addon_link link");
			}

			Thread.sleep(2000);
			SeleniumRepo.waitForElementPresent(ListAll_link);
			if (ListAll_link.isDisplayed()) {
				ListAll_link.click();
				SeleniumRepo.waitForPageLoaded();
				test.log(Status.PASS, "Clicked on ListAll link");
				logger.info("Clicked on ListAll link");
				Assert.assertTrue(true, "Clicked on ListAll link");
			} else {
				logger.info("Failed to Click on ListAll link");

				test.log(Status.FAIL, "Failed to Click on ListAll link");
			}

			Thread.sleep(3000);

			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='Add Ons']")));

			if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains(AddonName))
			{
				System.out.println("Add On "+AddonName+" already created");
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("(//*[contains(.,'"+AddonName+"')]//preceding-sibling::tr//tr//td[1]//input[1])[1]")));
				Thread.sleep(2000);

				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//input[@value='Delete']")));
				Thread.sleep(2000);

				ExplicitWait(click_Yes);
				
				Javascriptexecutor(click_Yes);

				System.out.println("Add on  Deleted"+AddonName);
				ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='Add Ons']")));

			}

			else
			{
				System.out.println("AddonName "+AddonName+" not yet created");
			}

		} catch (Exception e) {
			logger.error("Unable to create AddonName for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Policies for selected property because of this execption" + e);
			//e.printStackTrace();
		}	
	}}






