package com.tt.admin.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class IndependentHotels extends BaseTest{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();


	@FindAll({ @FindBy(xpath = "//a[@title='Direct Brand']"),

	})
	private WebElement Direct_Brand;


	public void createIndependentHotel() 
	{

		try {
			SeleniumRepo.waitForElementPresent(Direct_Brand);
			if(Direct_Brand.isEnabled()) {
				Direct_Brand.click();
				test.log(Status.PASS, "Clicked on Independent Hotelslink");
				logger.info("Clicked on Independent Hotels link");
				Assert.assertTrue(true, "Clicked on Independent Hotels link");
			}else {
				logger.info("Failed to Click on Independent Hotels link");
				test.log(Status.FAIL, "Failed to Click on Independent Hotels link");}

		} catch (Exception e) 
		{
			logger.error("Unable to create room type for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create room type for selected property because of this execption" + e);
			e.printStackTrace();
		}


	}}
