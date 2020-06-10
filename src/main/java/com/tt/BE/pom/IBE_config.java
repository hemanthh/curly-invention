package com.tt.BE.pom;

import java.io.IOException;

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
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class IBE_config extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//*[@id='user_login']"),})
	@CacheLookup
	private WebElement Username;

	@FindAll({ @FindBy(xpath = "//*[@id='user_password']"), })
	@CacheLookup
	private WebElement Password;

	@FindAll({ @FindBy(xpath = "//*[@value='Sign In']"), })
	@CacheLookup
	private WebElement Signin;

	@FindAll({ @FindBy(xpath = "(//*[text()='Portal settings'])[1]"), })
	@CacheLookup
	private WebElement Portal_settings;

	@FindAll({ @FindBy(xpath = "//*[@type='search']"), })
	@CacheLookup
	private WebElement Search;

	@FindAll({ @FindBy(xpath = "//*[@type='submit']"), })
	@CacheLookup
	private WebElement Submit_Search;

	@FindAll({ @FindBy(xpath = "//*[@title='Show All Items']"), })
	@CacheLookup
	private WebElement Flow_Dropdown;

	@FindAll({ @FindBy(xpath = "(//*[contains(text(),'yankee')])[2]"), })
	@CacheLookup
	private WebElement Flow_Yankee;
	@FindAll({ @FindBy(xpath = "(//*[contains(text(),'standard')])[2]"), })
	@CacheLookup
	private WebElement Flow_Standard;

	@FindAll({ @FindBy(xpath = "//*[@name='_save']"), })
	@CacheLookup
	private WebElement Save;

	@FindAll({ @FindBy(xpath = "//*[@class='page-header']/following-sibling::div[1]"), })
	@CacheLookup
	private WebElement Alert_Text;


	public void GotoURL() throws IOException
	{
		String IBEConfigURL=ReadProperties.getPropValues("Admin.properties", "IBEConfigURL");
		SeleniumRepo.GoToUrl(IBEConfigURL);
	}

	public void Login(String UName,String PWD) throws InterruptedException

	{
		SeleniumRepo.waitForElementPresent(Username);
		if(Username.isDisplayed())
		{
			Username.sendKeys(UName);
			System.out.println("Username is displayed and Enterd Successfully");
			logger.info("Username is displayed and Enterd Successfully");
			test.log(Status.INFO, "Username is displayed and Enterd Successfully");
			Assert.assertTrue(true, "Username is displayed and Enterd Successfully");
		} 
		else 
		{
			System.out.println("Username is not displayed and Enterd Successfully");
			logger.error("Username is not displayed and Enterd Successfully");
			test.log(Status.FAIL, " Username is not displayed and Enterd Successfully");
			Assert.assertFalse(false, "Username is not displayed and Enterd Successfully");

		}
		if(Password.isDisplayed())
		{
			Password.sendKeys(PWD);
			System.out.println("Password is displayed and Enterd Successfully");
			logger.info("Password is displayed and Enterd Successfully");
			test.log(Status.INFO, "Password is displayed and Enterd Successfully");
			Assert.assertTrue(true, "Password is displayed and Enterd Successfully");
		} 
		else 
		{
			System.out.println("Password is not displayed and Enterd Successfully");
			logger.error("Password is not displayed and Enterd Successfully");
			test.log(Status.FAIL, " Password is not displayed and Enterd Successfully");
			Assert.assertFalse(false, "Password is not displayed and Enterd Successfully");

		}

		if(Signin.isDisplayed())
		{
			Javascriptexecutor(Signin);
			Thread.sleep(3000);
			System.out.println("Signin is displayed and Clicked Successfully");
			logger.info("Signin is displayed and Clicked Successfully");
			test.log(Status.INFO, "Signin is displayed and Clicked Successfully");
			Assert.assertTrue(true, "Signin is displayed and Clicked Successfully");
		} 
		else 
		{
			System.out.println("Signin is not displayed and Clicked Successfully");
			logger.error("Signin is not displayed and Clicked Successfully");
			test.log(Status.FAIL, "Signin is not displayed and Clicked Successfully");
			Assert.assertFalse(false, "Signin is not displayed and Clicked Successfully");

		}
		SeleniumRepo.waitForPageLoaded();

	}

	public void Portal_settings()
	{
		SeleniumRepo.waitForElementPresent(Portal_settings);
		if(Portal_settings.isDisplayed())
		{
			Javascriptexecutor(Portal_settings);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Portal_settings is displayed and Clicked Successfully");
			logger.info("Portal_settings is displayed and Clicked Successfully");
			test.log(Status.INFO, "Portal_settings is displayed and Clicked Successfully");
			Assert.assertTrue(true, "Portal_settings is displayed and Clicked Successfully");
		} 
		else 
		{
			System.out.println("Portal_settings is not displayed and Clicked Successfully");
			logger.error("Portal_settings is not displayed and Clicked Successfully");
			test.log(Status.FAIL, "Portal_settings is not displayed and Clicked Successfully");
			Assert.assertFalse(false, "Portal_settings is not displayed and Clicked Successfully");

		}

	}
	public void Search(String ExistingPropetyName)
	{
		SeleniumRepo.waitForElementPresent(Search);
		if(Search.isDisplayed())
		{
			Search.sendKeys(ExistingPropetyName);
			Javascriptexecutor(Submit_Search);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Search is displayed and Enterd Successfully");
			logger.info("Search is displayed and Enterd Successfully");
			test.log(Status.INFO, "Search is displayed and Enterd Successfully");
			Assert.assertTrue(true, "Search is displayed and Enterd Successfully");
		} 
		else 
		{
			System.out.println("Search is not displayed and Enterd Successfully");
			logger.error("Search is not displayed and Enterd Successfully");
			test.log(Status.FAIL, " Search is not displayed and Enterd Successfully");
			Assert.assertFalse(false, "Search is not displayed and Enterd Successfully");

		}

	}
	public void Edit(String ExistingPropetyName)
	{
		WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='"+ExistingPropetyName+"']/following-sibling::td[4]/ul/li[2]/a")));

		WebElement Edit=SeleniumRepo.driver.findElement(By.xpath("//*[@title='"+ExistingPropetyName+"']/following-sibling::td[4]/ul/li[2]/a"));
		if(Edit.isDisplayed())
		{
			Javascriptexecutor(Edit);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Edit is displayed and Clicked Successfully");
			logger.info("Edit is displayed and Clicked Successfully");
			test.log(Status.INFO, "Edit is displayed and Clicked Successfully");
			Assert.assertTrue(true, "Edit is displayed and Clicked Successfully");
		} 
		else 
		{
			System.out.println("Edit is not displayed and Clicked Successfully");
			logger.error("Edit is not displayed and Clicked Successfully");
			test.log(Status.FAIL, "Edit is not displayed and Clicked Successfully");
			Assert.assertFalse(false, "Edit is not displayed and Clicked Successfully");

		}
	}

	public void YankeeFlow_Select(String flow) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Flow_Dropdown);
		if(Flow_Dropdown.isDisplayed())
		{
			Javascriptexecutor(Flow_Dropdown);


			Thread.sleep(3000);
			Javascriptexecutor(Flow_Yankee);
			System.out.println("Flow_Dropdown displayed and Enterd Successfully");
			logger.info("Flow_Dropdown is displayed and Enterd Successfully");
			test.log(Status.INFO, "Flow_Dropdown is displayed and Enterd Successfully");
			Assert.assertTrue(true, "Flow_Dropdown is displayed and Enterd Successfully");
			System.out.println("Yankee flow selected successfully");
		} 
		else 
		{
			System.out.println("Flow_Dropdown is not displayed and Enterd Successfully");
			logger.error("Flow_Dropdown is not displayed and Enterd Successfully");
			test.log(Status.FAIL, " Flow_Dropdown is not displayed and Enterd Successfully");
			Assert.assertFalse(false, "Flow_Dropdown is not displayed and Enterd Successfully");

		}
	}

	public void StandardFlow_Select() throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Flow_Dropdown);
		if(Flow_Dropdown.isDisplayed())
		{
			Javascriptexecutor(Flow_Dropdown);
			Thread.sleep(3000);
			Javascriptexecutor(Flow_Standard);
			
			System.out.println("Flow_Dropdown is displayed and Enterd Successfully");
			logger.info("SeaFlow_Dropdownrch is displayed and Enterd Successfully");
			test.log(Status.INFO, "Flow_Dropdown is displayed and Enterd Successfully");
			Assert.assertTrue(true, "Flow_Dropdown is displayed and Enterd Successfully");
			System.out.println("Standard flow selected successfully");
		} 
		else 
		{
			System.out.println("Flow_Dropdown is not displayed and Enterd Successfully");
			logger.error("Flow_Dropdown is not displayed and Enterd Successfully");
			test.log(Status.FAIL, " Flow_Dropdown is not displayed and Enterd Successfully");
			Assert.assertFalse(false, "Flow_Dropdown is not displayed and Enterd Successfully");

		}
	}
	public void save()
	{
		SeleniumRepo.waitForElementPresent(Save);
		if(Save.isDisplayed())
		{
			Javascriptexecutor(Save);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Save is displayed and Clicked Successfully");
			logger.info("Save is displayed and Clicked Successfully");
			test.log(Status.INFO, "Save is displayed and Clicked Successfully");
			Assert.assertTrue(true, "Save is displayed and Clicked Successfully");
		} 
		else 
		{
			System.out.println("Save is not displayed and Clicked Successfully");
			logger.error("Save is not displayed and Clicked Successfully");
			test.log(Status.FAIL, "Save is not displayed and Clicked Successfully");
			Assert.assertFalse(false, "Save is not displayed and Clicked Successfully");

		}

	}
	public void Alert_Text() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Portal settings'])[1]")));
		
		String Expected_SuccessAlert="Portal setting successfully updated";

		String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
		if(body.contains(Expected_SuccessAlert))
		{
			System.out.println("Portal setting successfully updated");
			logger.info("Portal setting successfully updated");
			test.log(Status.INFO, "Portal setting successfully updated");
			Assert.assertTrue(true, "Portal setting successfully updated");
		} 
		else 
		{
			System.out.println("Portal setting failed to be updated");
			logger.error("Portal setting failed to be updated");
			test.log(Status.FAIL, "Portal setting failed to be updated");
			Assert.assertFalse(false, "Portal setting failed to be updated");

		}

	}

}




