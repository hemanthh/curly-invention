package com.tt.BE.pom;

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
import com.tt.utility.SeleniumRepo;

public class CancelBooking_Standard extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	@FindAll({ @FindBy(xpath = "(//*[contains(text(),'Cancel reservation')])[2]"), })
	
	private WebElement Click_CancelReservation;

	@FindAll({ @FindBy(xpath = "//h3[@id='myModalLabel']"), })
	
	private WebElement Popup_title;

	@FindAll({ @FindBy(xpath = "//h3[@id='myModalLabel']/following-sibling::p[1]"), })
	
	private WebElement Cancel_Popup_fee;

	@FindAll({ @FindBy(xpath = "//*[text()='Yes']"), })
	
	private WebElement Yes_button;

	@FindAll({ @FindBy(xpath = "//*[text()='No']"), })
	
	private WebElement No_button;


	@FindAll({ @FindBy(xpath = "//*[@id='myModalLabel']/following-sibling::p[1]/b"), })
	
	private WebElement Cancelation_code;

	public void Click_CancelReservation() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		System.out.println("enterd into cancel reservation");
		
		
		SeleniumRepo.waitForElementPresent(Click_CancelReservation);
		
		if(Click_CancelReservation.isDisplayed())
		{
			test.info("cancel Reservation Screenshot : " + test.addScreenCaptureFromPath(capture()));
			Click_CancelReservation.click();
			test.log(Status.INFO, "cancel reservation button clicked successfully");
			Assert.assertTrue(true,"cancel reservation button clicked successfully");
			SeleniumRepo.waitForElementPresent(Popup_title);		
		}
		else
		{
			System.out.println("Cancel reservation button is not found");
			test.log(Status.INFO, "Cancel reservation button is not found");
			Assert.assertFalse(false,"Cancel reservation button is not found");
		}
	}

	public void Popup_title() 
	{
		try {
			SeleniumRepo.waitForElementPresent(Popup_title);
			if(Popup_title.isDisplayed())
			{
				System.out.println("Cancel reservation popup title displayed");
				test.log(Status.INFO, "Cancel reservation popup title displayed");
				Assert.assertTrue(true,"Cancel reservation popup title displayed");
				String Actualtitle=Popup_title.getText();
				String Expectedtitle="CANCEL RESERVATION?";
				System.out.println("cancel reservation popup title is  "+Actualtitle );
				if(Actualtitle.equalsIgnoreCase(Expectedtitle))
				{
					System.out.println("Cancel reservation popup title matches");
					test.log(Status.INFO, "Cancel reservation popup title matches");
					Assert.assertTrue(true,"Cancel reservation popup title matches");		
				}
				else
				{
					System.out.println("Cancel reservation popup title not matched");
					test.log(Status.INFO, "Cancel reservation popup title not matched");
					Assert.assertFalse(false,"Cancel reservation popup title not matched");
				}
			}
			else
			{
				System.out.println("Cancel reservation popup title not found");
				test.log(Status.INFO, "Cancel reservation popup title not found");
				Assert.assertFalse(false,"Cancel reservation popup title not found");

			}

			if(Cancel_Popup_fee.isDisplayed())
			{
				String cancelation_fee=Cancel_Popup_fee.getText();
				System.out.println("Cancelation fee is  "+cancelation_fee);	
				test.log(Status.INFO, "Cancelation fee is "+cancelation_fee);
				Assert.assertTrue(true,"Cancelation fee is "+cancelation_fee);
				Javascriptexecutor(Yes_button);
				SeleniumRepo.waitForPageLoaded();	
				
			}
			else
			{
				System.out.println("Cancelation fee not applied");
				test.log(Status.INFO, "Cancelation fee not applied");
				Assert.assertFalse(false,"Cancelation fee not applied");

			}
			
			SeleniumRepo.waitForElementPresent(Popup_title);
			if(Popup_title.isDisplayed())
			{
				System.out.println("Cancel reservation confirmation title displayed");
				test.log(Status.INFO, "Cancel reservation confirmation title displayed");
				Assert.assertTrue(true,"Cancel reservation confirmation title displayed");
				String Actual_confirmation=Popup_title.getText();
				String Expected_confirmation="YOUR RESERVATION HAS BEEN CANCELED";
				System.out.println("cancel reservation popup title is  "+Actual_confirmation );
				if(Actual_confirmation.equalsIgnoreCase(Expected_confirmation))
				{
					System.out.println("Cancel reservation confirmation title matches");
					test.log(Status.INFO, "Cancel reservation confirmation title matches");
					Assert.assertTrue(true,"Cancel reservation confirmation title matches");		
				}
				else
				{
					System.out.println("Cancel reservation confirmation title not matched");
					test.log(Status.INFO, "Cancel reservation confirmation title not matched");
					Assert.assertFalse(false,"Cancel reservation confirmation title not matched");
				}
			}
			else
			{
				System.out.println("Cancel reservation popup confirmation not found");
				test.log(Status.INFO, "Cancel reservation popup confirmation not found");
				Assert.assertFalse(false,"Cancel reservation popup confirmation not found");

			}
			String cancelation_text=SeleniumRepo.driver.findElement(By.xpath("//*[@id='myModalLabel']/following-sibling::p[1]")).getText();
			
			System.out.println(cancelation_text);
			Thread.sleep(3000);
			SeleniumRepo.driver.findElement(By.partialLinkText("OK")).click();

		}
		catch(Exception e)
		{
			System.out.println("Cancel reservation popup is not displayed");
			test.log(Status.INFO, "Cancel reservation popup is not displayed");
			Assert.assertFalse(false,"Cancel reservation popup is not displayed");
                   
		}
	}

	

}

