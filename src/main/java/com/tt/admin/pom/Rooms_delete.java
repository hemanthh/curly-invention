package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;


/**
 * Note: This class can be deleted because refactored and moved methods into the class , 
 * AboutTheProperty  class
 * 
 * 
 * 
 * 
 *
 */
public class Rooms_delete extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })

	private WebElement Click_PropertyManagement;

	@FindAll({
		@FindBy(xpath="//a[starts-with(., 'About')]"),
	})
	
	private WebElement AbouttheProperty_Link;

	@FindAll({
		@FindBy(xpath="//td[contains(text(),'About the Property')]"),
	})
	
	private WebElement AboutthPropertyTitle_Link;

	@FindAll({
		@FindBy(xpath="//li[contains(text(),'Built Year Required')]"),
	})
	
	private WebElement ErrorMessage_Built;


	@FindAll({
		@FindBy(xpath="//input[@name='builtYear']"),
	})
	
	private WebElement Enter_YearBuilt;

	@FindAll({
		@FindBy(xpath="//input[@name='renovatedYear']"),
	})
	
	private WebElement Enter_YearRenovated;

	@FindAll({
		@FindBy(xpath="//input[@name='save']"),
	})
	
	private WebElement Save;


	@FindAll({ @FindBy(xpath = "//*[@name='chkMeetingRoomIds']") })
	
	private List<WebElement> Meeting_delete;

	@FindAll({ @FindBy(xpath = "//*[@name='chkDiningIds']") })
	
	private List<WebElement> Dining_delete;

	@FindAll({ @FindBy(xpath = "//*[@name='chkAirportIds']") })
	
	private List<WebElement> Airpot_Delete;

	@FindAll({ @FindBy(xpath = "//*[@name='chkAttractionIds']") })
	
	private List<WebElement> Attractions_Delete;


	/*Before Creating "About The Property" We have to Enable "About The Property"
	in the "Guest Preference Question"*/


	public void Click_PropertyManagement()
	{
		if (AbouttheProperty_Link.isDisplayed()) 
		{
			
			System.out.println("Property Management element Expanded and About the property element  found");
			test.log(Status.INFO, "Property Management element Expanded and About the property element  found");
			Assert.assertTrue(true, "Property Management element Expanded and About the property element  found");
		} 
		else 
		{
			System.out.println("Property Management Menu is not expanded");
			Javascriptexecutor(Click_PropertyManagement);
			System.out.println("Clicked on Property Management Link");
			test.log(Status.INFO, "Clicked on Property Management Link");

			ExplicitWait(AbouttheProperty_Link);
			if(AbouttheProperty_Link.isDisplayed())
			{
				System.out.println("Smart policies list element found");
				test.log(Status.INFO, "Smart policies list element found");
				Assert.assertTrue(true, "Smart policies list element found");
			}
			else
			{
				logger.info("Smart policies list element not  found");
				test.log(Status.FAIL, "Smart policies list element not  found");
			}
		}


	}


	public void AbouttheProperty_Link()
	{
		ExplicitWait(Click_PropertyManagement);
		if (AbouttheProperty_Link.isDisplayed()) 
		{
			Javascriptexecutor(AbouttheProperty_Link);
			System.out.println("AbouttheProperty_Link clicked");
			ExplicitWait(Enter_YearBuilt);
			System.out.println("PropertyManagement element Expanded and AbouttheProperty element  found");
			test.log(Status.INFO, "PropertyManagement element Expanded and AbouttheProperty element  found");
			Assert.assertTrue(true, "PropertyManagement element Expanded and AbouttheProperty element  found");
		} 
		else 
		{
			System.out.println("PropertyManagement Menu is not expanded");
			Javascriptexecutor(Click_PropertyManagement);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");

			ExplicitWait(AbouttheProperty_Link);
			if(AbouttheProperty_Link.isDisplayed())
			{
				Javascriptexecutor(AbouttheProperty_Link);
				System.out.println("AbouttheProperty_Link clicked");
				ExplicitWait(Enter_YearBuilt);
				System.out.println("PropertyDefaults element found");
				test.log(Status.INFO, "PropertyDefaults element found");
				Assert.assertTrue(true, "PropertyDefaults element found");
			}
			else
			{
				logger.info("PropertyDefaults element not  found");
				test.log(Status.FAIL, "PropertyDefaults element not  found");
			}
		}
	}

	public void delete() throws InterruptedException
	{
		if(!(Meeting_delete.isEmpty()))
		{
			for(int i=0;i<Meeting_delete.size();i++)
			{
				Javascriptexecutor(Meeting_delete.get(i));
				//Meeting_delete.get(i).click();
				Thread.sleep(2000);
			}
			WebElement Meeting=	SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'meetingRoom')and@value='Delete']"));

			Javascriptexecutor(Meeting);
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Meeting Rooms deleted successfully");
		}
		else
		{
			System.out.println("There are no Meeting rooms");
		}

		if(!(Dining_delete.isEmpty()))
		{
			for(int i=0;i<Dining_delete.size();i++)
			{
				Javascriptexecutor(Dining_delete.get(i));
				//Dining_delete.get(i).click();
				Thread.sleep(2000);
			}
			WebElement Resturant=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'dining')and@value='Delete']"));

			Javascriptexecutor(Resturant);
			System.out.println("Dining Rooms deleted successfully");
			SeleniumRepo.waitForPageLoaded();
		}
		else
		{
			System.out.println("There are no Dining rooms");
		}


		if(!(Airpot_Delete.isEmpty()))
		{
			for(int i=0;i<Airpot_Delete.size();i++)
			{
				Javascriptexecutor(Airpot_Delete.get(i));
				//Airpot_Delete.get(i).click();
				Thread.sleep(2000);
			}


			WebElement Airport=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'airport')and@value='Delete']"));

			Javascriptexecutor(Airport);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Airpot Names deleted successfully");
		}
		else
		{
			System.out.println("There are no Airpots");
		}

		if(!(Attractions_Delete.isEmpty()))
		{
			for(int i=0;i<Attractions_Delete.size();i++)
			{
				Javascriptexecutor(Attractions_Delete.get(i));
				//Attractions_Delete.get(i).click();
				Thread.sleep(2000);
			}
			WebElement Attractions=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'attraction')and@value='Delete']"));

			Javascriptexecutor(Attractions);
			Thread.sleep(2000);
			SeleniumRepo.waitForPageLoaded();	


			System.out.println("Attraction Names deleted successfully");

		}
		else
		{
			System.out.println("There are no Attractions");
		}

	}

}
