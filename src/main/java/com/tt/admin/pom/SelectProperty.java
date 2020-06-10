package com.tt.admin.pom;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class SelectProperty extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	public WebElement ele;
	public String propertyname;
	public String propertyName;

	@FindAll({ @FindBy(xpath = "//input[@value='Select Property']"),
		@FindBy(css = "tr:nth-child(1) td:nth-child(2) span.prompt:nth-child(4) form:nth-child(10) > input.input:nth-child(6)") })
	
	public WebElement Click_Property;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })

	public WebElement Click_PropertyManagement;

	@FindBy(xpath = "//*[contains(text(),'Administrator Home')]")

	public WebElement Administration_Hometitle;

	@FindBy(xpath = "//div[@class='banner_right_col']")

	public WebElement Get_Propertyname;

	public void selectProperty_ByPropertyName() throws InterruptedException, IOException
	{
		 propertyName = ReadProperties.getPropValues("Admin.properties", "ExistingPropetyName");

		System.out.println(propertyName);
		//SeleniumRepo.ElementWait(Sel_Property);
        Thread.sleep(5000);
		ele=SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'" + propertyName + "')]/preceding-sibling::td/input"));
		SeleniumRepo.waitForElementPresent(ele);
		if (ele.isDisplayed()) 
		{

			ele.click();
			logger.info("Property Is selected");

			
		} else {
			logger.error(" Failed to select Property ");

			
		}

		if (SeleniumRepo.isElementPresent(Click_Property)) 
		{
			Click_Property.click();
			logger.info("Clicked on Select Property");

			
		} else 
		{
			logger.error(" Failed to click on select Property button ");

			
		}

		SeleniumRepo.waitForPageLoaded();

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
		
	}
	
	public void selectProperty_ByPropertyName(String Property) throws InterruptedException, IOException
	{
		 propertyName = Property;

		System.out.println(propertyName);
		//SeleniumRepo.ElementWait(Sel_Property);
        Thread.sleep(5000);
		ele=SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'" + propertyName + "')]/preceding-sibling::td/input"));
		SeleniumRepo.waitForElementPresent(ele);
		if (ele.isDisplayed()) 
		{

			ele.click();
			logger.info("Property Is selected");

			
		} else {
			logger.error(" Failed to select Property ");

			
		}

		if (SeleniumRepo.isElementPresent(Click_Property)) 
		{
			Click_Property.click();
			logger.info("Clicked on Select Property");

			
		} else 
		{
			logger.error(" Failed to click on select Property button ");

			
		}

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
	}
	public void selectProperty_ByAlternatePropertyName(String propertyName) throws InterruptedException, IOException
	{
		//String propertyName = ReadProperties.getPropValues("Admin.properties", "SelectBrand");

		System.out.println(propertyName);
		//SeleniumRepo.ElementWait(Sel_Property);

		ele=SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'" + propertyName + "')]/preceding-sibling::td/input"));
		SeleniumRepo.waitForElementPresent(ele);
		if (ele.isDisplayed()) 
		{

			ele.click();
			logger.info("Property Is selected");

			test.log(Status.INFO, "Property Is Selected");
		} else {
			logger.error(" Failed to select Property ");

			test.log(Status.ERROR, "Failed to select Property ");
		}

		if (SeleniumRepo.isElementPresent(Click_Property)) 
		{
			Click_Property.click();
			logger.info("Clicked on Select Property");

			test.log(Status.INFO, "Clicked on Select Property");
		} else 
		{
			logger.error(" Failed to click on select Property button ");

			test.log(Status.ERROR, "Failed to click on select Property button ");
		}

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
	}
	public void selectProperty_ByPropertyCode(String PropertyCode) throws InterruptedException 
	{

		ele=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+PropertyCode+"')]/preceding-sibling::td[2]/input"));
		SeleniumRepo.waitForElementPresent(ele);
		if (ele.isDisplayed()) 
		{
			ele.click();
			logger.info("Property code " +PropertyCode+" Is Selected");

			test.log(Status.INFO, "Property code " +PropertyCode+" Is Selected");
		} 
		else 
		{
			logger.error("Failed to select Property code "+PropertyCode);

			test.log(Status.ERROR, "Failed to select Property code "+PropertyCode);
		}

		if (SeleniumRepo.isElementPresent(Click_Property)) 
		{
			Click_Property.click();
			logger.info("Clicked on Select Property");

			test.log(Status.INFO, "Clicked on Select Property");
		} else 
		{
			logger.error(" Failed to click on select Property button ");

			test.log(Status.ERROR, "Failed to click on select Property button ");
		}

		ExplicitWait(Click_PropertyManagement);
		
	}


	public void close_Existingproperty(String propertyName) throws InterruptedException
	{
		WebElement Close_property=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+propertyName+"')]/a[1]"));
		if(Close_property.isDisplayed())
		{
			Javascriptexecutor(Close_property);
			test.log(Status.INFO,"Clicked on "+propertyName +"Property closed button");
			logger.info("Clicked on "+propertyName +"Property closed button");
			ExplicitWait(Administration_Hometitle);
			Thread.sleep(2000);
		}
		else
		{
			test.log(Status.FAIL, propertyName+" proeprty close button is not displayed");
			logger.error(propertyName+" proeprty close button is not displayed");
		}
	}
	
	public  String Get_propertyname()
	{
		String[] headings=Get_Propertyname.getText().split(" ");
		 propertyname=headings[0];
		System.out.println(propertyname);
		return propertyname;
	}

}
