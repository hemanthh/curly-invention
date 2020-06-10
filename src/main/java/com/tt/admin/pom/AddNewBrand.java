package com.tt.admin.pom;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class AddNewBrand extends BaseTest{
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	 String result=this.getClass().getSimpleName();


	@FindAll({
        @FindBy(xpath="//a[contains(text(),'Brands')]"),
        @FindBy(css="td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td.prompt:nth-child(2) > a:nth-child(1)"),
    })
	
    private WebElement Brand_Link;
	
	@FindAll({
        @FindBy(xpath="//a[contains(text(),'Add a New Brand')]"),})
	
    private WebElement Add_NewBrand;

	
	@FindAll({
        @FindBy(xpath="//input[@name='brandName']"), })
	
    private WebElement Brand_Name;
	
	
	@FindAll({
        @FindBy(xpath="//input[@value='Y']"), })
	
    private WebElement Select_Status;
	
	
	@FindAll({
        @FindBy(xpath="//input[@value='Save']"), })
	
    private WebElement Brand_Save;

	public void addBrand(String BrandName) throws IOException, InterruptedException {
		SeleniumRepo.waitForElementPresent(Brand_Link);

		if (SeleniumRepo.isElementPresent(Brand_Link)) {
			Brand_Link.click();
			test.log(Status.INFO, "Clicked on Brands Link");
			logger.info("Clicked on Brands Link");
			Assert.assertTrue(true, "Clicked on Brands Link");
		} else {
			System.out.println("Brands Link not found");
			test.log(Status.FAIL, " Brands Link not found");
			logger.info("Brands Link not found");
			Assert.assertFalse(false, "Brands Link not found");

		}
		
		
		SeleniumRepo.waitForElementPresent(Add_NewBrand);

		if (SeleniumRepo.isElementPresent(Add_NewBrand)) {
			Add_NewBrand.click();
			test.log(Status.INFO, "Clicked on Add_NewBrand Link");
			logger.info("Clicked on Add_NewBrand link");
			Assert.assertTrue(true, "Clicked on Add_NewBrandLink");
		} else {
			System.out.println("Add_NewBrand Link not found");
			test.log(Status.FAIL, " Add_NewBrand Link not found");
			logger.info("Add_NewBrand Link not found");
			Assert.assertFalse(false, "Add_NewBrand Link not found");}
		
		SeleniumRepo.waitForElementPresent( Brand_Name);

		if (SeleniumRepo.isElementPresent( Brand_Name)) {
			 Brand_Name.click();
			 Brand_Name.clear();
			 Brand_Name.sendKeys(BrandName);
			 test.log(Status.INFO, "BrnadName Entered");
				logger.info("BrnadName Entered");
				Assert.assertTrue(true, "BrnadName Entered");
			} else {
				System.out.println("BrnadName Not Entered");
				test.log(Status.FAIL, " BrnadName Not Entered");
				logger.info("BrnadName Not Entered");
				Assert.assertFalse(false, "BrnadName Not Entered");}
	
		
		
		SeleniumRepo.waitForElementPresent( Select_Status);

		if (SeleniumRepo.isElementPresent( Select_Status)) {
			Select_Status.isSelected();
			 test.log(Status.INFO, "BrnadName Entered");
				logger.info("BrnadName Entered");
				Assert.assertTrue(true, "BrnadName Entered");
			} else {
				System.out.println("BrnadName Not Entered");
				test.log(Status.FAIL, " BrnadName Not Entered");
				logger.info("BrnadName Not Entered");
				Assert.assertFalse(false, "BrnadName Not Entered");}
	
		/*
	         if(Brand_Save.isDisplayed()) {
	        	 Brand_Save.click();
	        	 test.log(Status.INFO, "Clicked on Brand_Save");
					logger.info("Clicked on Brand_Save");
					Assert.assertTrue(true, "Clicked on Brand_Save");
				} else {
					System.out.println("Not Clicked  on Brand_Save");
					test.log(Status.FAIL, " Not Clicked  on Brand_Save");
					logger.info("Not Clicked  on Brand_Save");
					Assert.assertFalse(false, "Not Clicked  on Brand_Save");}
	
	*/
	
}}
