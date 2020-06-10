package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class AlternateProperties extends BaseTest
{
	RateGrid grid=PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({
		@FindBy(xpath="//a[starts-with(.,'Alternate')]"),
	})

	public WebElement Click_AlternatePropertylink;

	@FindAll({
		@FindBy(xpath="//h1[contains(text(), 'Alternate Properties')]"),
	})

	public WebElement Verify_AlternatePropertyTitle;


	@FindAll({
		@FindBy(xpath="//a[contains(text(), 'Add Property')][starts-with(@href,'./displayNewRT3AltProperty.do?')]"),
	})

	public WebElement Click_AddPropertylink;


	@FindAll({
		@FindBy(xpath="//input[@name='propertyCode']"),
	})

	public WebElement Enter_PropertyCode;

	@FindAll({
		@FindBy(xpath="//input[@value='Save']"),
	})

	public WebElement click_save;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"),

	})
	public WebElement property_Management;


	@FindAll({ @FindBy(xpath = "//*[@value='Delete']"),

	})
	public WebElement Delete;

	@FindAll({ @FindBy(xpath = "//*[@name='chkRT3AltPropertyIds']"),

	})
	public List<WebElement> delete_Propertys;

	@FindAll({ @FindBy(xpath = "//td[@class='title']"),

	})
	public WebElement Title;


	@FindAll({ @FindBy(tagName="body"),

	})
	public WebElement Body;

	@FindAll({ @FindBy(xpath = "//*[text()='Please enter property code.']/.."),

	})
	public WebElement Save_Error;


	public void delete_alternate() throws InterruptedException
	{
		if(SeleniumRepo.driver.findElement(By.xpath("(//*[@name='chkRT3AltPropertyIds'])[1]")).isDisplayed())
		{

			for(WebElement del:delete_Propertys)
			{
				Javascriptexecutor(del);
				Thread.sleep(2000);	
			}
			Javascriptexecutor(Delete);
			Thread.sleep(2000);
			Alert alert =SeleniumRepo.driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.accept();
		}
		else
		{
			System.out.println("Alternate properties are not found");
		}
	}
	public void click_alternate()
	{
		if (Click_AlternatePropertylink.isDisplayed()) 
		{
			Javascriptexecutor(Click_AlternatePropertylink);
			ExplicitWait(Click_AddPropertylink);
			System.out.println("PropertyManagement element Expanded and AlternateProperty element  found");
			test.log(Status.INFO, "PropertyManagement element Expanded and AlternateProperty element  found");
			Assert.assertTrue(true, "PropertyManagement element Expanded and AlternateProperty element  found");
		} 
		else 
		{
			System.out.println("PropertyManagement Menu is not expanded");
			Javascriptexecutor(property_Management);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");

			ExplicitWait(Click_AlternatePropertylink);
			if(Click_AlternatePropertylink.isDisplayed())
			{
				Javascriptexecutor(Click_AlternatePropertylink);
				ExplicitWait(Click_AddPropertylink);
				System.out.println("AlternateProperty element found");
				test.log(Status.INFO, "AlternateProperty  element found");
				Assert.assertTrue(true, "AlternateProperty element found");
			}
			else
			{
				logger.info("AlternateProperty element not  found");
				test.log(Status.FAIL, "AlternateProperty element not  found");
			}
		}

	}


	public void click_AddProperty(String channel,String AlternatePropertyTilte)
	{
		ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+channel+"')]/../../../following-sibling::table/tbody/tr/td[2]/span")));
		
		SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+channel+"')]/../../../following-sibling::table/tbody/tr/td[2]/span/a")).click();

		//Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+channel+"')]/../../../following-sibling::table/tbody/tr/td[2]/span/a")));

		test.log(Status.INFO, "Clicked on Add "+channel+" property");
		
		if(Verify_AlternatePropertyTitle.getText().contains(AlternatePropertyTilte))
		{
			test.log(Status.PASS, "Alternative Property Title displayed");
			logger.info("Alternative Property Title displayed");
		}
		else
		{
			logger.error("Alternative Property Title is Missing");
			test.log(Status.FAIL,"Alternative Property Title is Missing");
		}
		ExplicitWait(Title);
		if(Title.getText().equals("Add New RT3 Alternate Property"))
		{

		test.log(Status.PASS, "Add New RT3 Alternate Property label verified successfully");
		logger.info("Add New RT3 Alternate Property label verified successfully");
		}
		else
		{
			test.log(Status.FAIL, "Add New RT3 Alternate Property label is not displayed");
			logger.error("Add New RT3 Alternate Property label is not displayed");
		}

		if(Body.getText().contains("Property Code*"))
		{
			test.log(Status.PASS, "Property Code* label displayed successfully");

		}
		else
		{
			test.log(Status.FAIL, "Property Code* label is not dispplyed" );
			logger.error("Property Code* label is not dispplyed");
		}

	}

	public void Click_Save()

	{
		ExplicitWait(click_save);
		if(click_save.isEnabled()) 
		{
			Javascriptexecutor(click_save);
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.PASS,"Clicked on Save button" );
		}
		else 
		{
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,"Failed to Click on Save button");
		}	

	}
	public void Verify_SaveError()
	{
		try 
		{
			Assert.assertTrue(Body.getText().contains("Please enter property code."), "Please enter property code. displayed successfully");
			test.log(Status.PASS, "Please enter property code. error message displayed successfully");
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Please enter property code error message is not diplaying");
			logger.error("Please enter property code error message is not diplaying");
		}
	}
	public void Enter_PropertyCode(String propertycode)
	{
		ExplicitWait(Enter_PropertyCode);
		if(Enter_PropertyCode.isEnabled()) 
		{
			Enter_PropertyCode.click();
			Enter_PropertyCode.clear();
			Enter_PropertyCode.sendKeys(propertycode);
			logger.info("PropertyCode "+propertycode+" Entered successfully");
			test.log(Status.PASS,"PropertyCode "+propertycode+" Entered successfully");
		}
		else 
		{
			logger.error("Failed to Enter PropertyCode in TextBox");
			test.log(Status.FAIL,"Failed to Enter PropertyCode in TextBox");

		}	

	}
	public void verify_DeleteError()
	{
		ExplicitWait(Delete);
		Javascriptexecutor(Delete);
		Alert alt=SeleniumRepo.driver.switchTo().alert();
		if(alt.getText().equals("Please Select Properties for Delete Operation."))
		{
			test.log(Status.PASS, "Please Select Properties for Delete Operation. error popup displayed successfully");
			logger.info("Please Select Properties for Delete Operation. error popup displayed successfully");
			alt.accept();
		}
		else
		{
			test.log(Status.FAIL, "Please Select Properties for Delete Operation. alert is not displayed");
			logger.error("Please Select Properties for Delete Operation. alert is not displayed");
		}

	}

	public void createAltrPrpty
	(String AlternatePropertyTilte, String PropertyCode)
	{
		try 
		{
			if (Click_AlternatePropertylink.isDisplayed()) 
			{
				Javascriptexecutor(Click_AlternatePropertylink);
				ExplicitWait(Click_AddPropertylink);
				System.out.println("PropertyManagement element Expanded and AlternateProperty element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and AlternateProperty element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and AlternateProperty element  found");
			} 
			else 
			{
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(Click_AlternatePropertylink);
				if(Click_AlternatePropertylink.isDisplayed())
				{
					Javascriptexecutor(Click_AlternatePropertylink);
					ExplicitWait(Click_AddPropertylink);
					System.out.println("AlternateProperty element found");
					test.log(Status.INFO, "AlternateProperty  element found");
					Assert.assertTrue(true, "AlternateProperty element found");
				}
				else
				{
					logger.info("AlternateProperty element not  found");
					test.log(Status.FAIL, "AlternateProperty element not  found");
				}
			}
			SeleniumRepo.isElementPresent(Verify_AlternatePropertyTitle);

			System.out.println(Verify_AlternatePropertyTitle.getText());
			System.out.println("Expected"+AlternatePropertyTilte);

			try 
			{
				Assert.assertEquals(AlternatePropertyTilte,Verify_AlternatePropertyTitle.getText());
				System.out.println("AlternatePropertyTilte  found");
				logger.info("AlternatePropertyTilte  found");
				test.log(Status.PASS,
						"AlternatePropertyTilte  found" );
				Assert.assertTrue(true, 
						"AlternatePropertyTilte is Present");
			} catch (Error e) {
				System.out.println("Alternative Property Title is Missing");
				logger.error("Alternative Property Title is Missing");
				test.log(Status.FAIL,
						"Alternative Property Title is Missing");
				Assert.assertFalse(false, 
						"Alternative Property Title is Missing");
			}	

			ExplicitWait(Click_AddPropertylink);
			if(Click_AddPropertylink.isEnabled()) 
			{
				Click_AddPropertylink.click();
				System.out.println("AddProperty Link  found");
				logger.info("Clicked on AddProperty Link");
				test.log(Status.PASS,
						"Clicked on AddProperty Link" );
				Assert.assertTrue(true, 
						"Clicked on AddProperty Link");
			} else {
				System.out.println("Add Property Link not found");
				logger.error("Failed to Click on Add Property Link");
				test.log(Status.FAIL,
						"Failed to Click on Add Property Link");

				Assert.assertFalse(false, 
						"Add Property Link not found");
			}	
			ExplicitWait(Enter_PropertyCode);
			if(Enter_PropertyCode.isDisplayed()) 
			{
				Enter_PropertyCode.click();
				Enter_PropertyCode.clear();
				Enter_PropertyCode.sendKeys(PropertyCode);
				System.out.println("PropertyCode Entered");
				logger.info("PropertyCode Entered");
				test.log(Status.PASS,
						"PropertyCode Entered" );;
						Assert.assertTrue(true, 
								"PropertyCode Entered");
			}else {
				System.out.println("PropertyCode Not Entered");
				logger.error("Failed to Enter PropertyCode in TextBox");
				test.log(Status.FAIL,
						"Failed to Enter PropertyCode in TextBox");
				Assert.assertFalse(false, "PropertyCode Not Entered");
			}	



			if(click_save.isEnabled()) 
			{
				click_save.click();
				SeleniumRepo.waitForPageLoaded();

				System.out.println("Clicked On Save Button");
				logger.info("Clicked on Save button");
				test.log(Status.PASS,
						"Clicked on Save button" );

				Assert.assertTrue(true, 
						"Clicked On Save Button ");
			}
			else 
			{
				System.out.println("Not Clicked On Save Button");
				logger.error("Failed to Click on Save button");
				test.log(Status.FAIL,
						"Failed to Click on Save button");
				Assert.assertFalse(false, 
						"Not Clicked On Save Button");
			}	

			String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
			if(body.contains("Alternate property code already exists."))
			{
				System.out.println("Alternate property code already exists.");
				logger.info("Alternate property code already exists.");
				test.log(Status.PASS, "Alternate property code already exists.");
			}



		} catch (Exception e) {
			logger.error("Unable to create Alternate Properties for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Alternate Properties for selected property because of this execption" + e);
			e.printStackTrace();
		}






	}}
