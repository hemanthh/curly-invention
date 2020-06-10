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

public class SmartPoliciesDelete extends BaseTest {

	WebDriver driver ;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[text()='Smart Policies']"),

	})
	private WebElement SmartPolicies_link;


	@FindAll({@FindBy(xpath = "//a[@href='/rt/admin/action/displaySmartPolicies.do?brand_id=5&prop_id=1527']"),
		@FindBy(css = "ul:nth-child(3) li:nth-child(7) ul:nth-child(2) li:nth-child(1) > a:nth-child(1)"),

	})
	private WebElement ListAll_link;




	@FindAll({ @FindBy(xpath = "//input[@name='policyIdCheckbox']"),

	})
	private List<WebElement> Select_policyIdCheckbox;

	@FindAll({ @FindBy(xpath = "//input[@value='Delete']"),

	})
	private WebElement Delete_Policy;


	public void deletePolicy(String SPName) {

		try {

			if (SeleniumRepo.isElementDisplayed(ListAll_link) == true ) 
			{
				ListAll_link.click();
				SeleniumRepo.waitForPageLoaded();
				ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List of Smart Policies']")));
				System.out.println("Smart Policies element Expanded and policies list element  found");
				test.log(Status.INFO, "Smart Policies element Expanded and policies list element  found");
				Assert.assertTrue(true, "Smart Policies element Expanded and policies list element  found");
			} 
			else 
			{
				System.out.println("Smart Policies Menu is not expanded");
				Javascriptexecutor(SmartPolicies_link);Thread.sleep(2000);
				System.out.println("Clicked on Smart policies Link");
				test.log(Status.INFO, "Clicked on Smart policies Link");

				ExplicitWait(ListAll_link);

				if (ListAll_link.isDisplayed()) 
				{
					ListAll_link.click();
					SeleniumRepo.waitForPageLoaded();
					ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List of Smart Policies']")));
					test.log(Status.PASS, "Clicked on ListAll link");
					logger.info("Clicked on ListAll link");
					Assert.assertTrue(true, "Clicked on ListAll link");
				} 
				else
				{
					logger.info("Failed to Click on ListAll link");

					test.log(Status.FAIL, "Failed to Click on ListAll link");
				}
			}
			Thread.sleep(3000);
			if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains(SPName))
			{
				System.out.println("Smart policy "+SPName+" already created");
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()[contains(.,'"+SPName+"')]]//preceding-sibling::td[1]//input[1]")));
				Thread.sleep(2000);

				Javascriptexecutor(Delete_Policy);
				Thread.sleep(2000);

				SeleniumRepo.handleAlert();
				SeleniumRepo.waitForPageLoaded();
				ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List of Smart Policies']")));
				System.out.println("smart Policy Deleted"+SPName);
			}
			else
			{

				System.out.println("smart policy "+SPName+" not yet created");
			}

		} catch (Exception e) {
			logger.error("Unable to create Policies for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Policies for selected property because of this execption" + e);
			e.printStackTrace();
		}	


	}


































}
