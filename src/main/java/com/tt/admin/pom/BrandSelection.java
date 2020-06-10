package com.tt.admin.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class BrandSelection extends BaseTest {
	String result=this.getClass().getSimpleName();


	@FindAll({
		@FindBy(xpath="//a[contains(text(),'Brands')]"),
		@FindBy(css="td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td.prompt:nth-child(2) > a:nth-child(1)"),
	})
	@CacheLookup
	private WebElement Brand_Link;
	/*@FindAll({
        @FindBy(xpath="//a[contains(text(),'QA_AUTOMATION')]"),
        @FindBy(css="td.prompt:nth-child(2) td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(70) > td.prompt:nth-child(1)"),
    })
	@CacheLookup
    private WebElement Brand_Name;*/



	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 * This method selects the brand from the list
	 */

	public void selectBrand() throws IOException, InterruptedException 
	{


		SeleniumRepo.waitForElementPresent(Brand_Link);
		Thread.sleep(2000);
		if (SeleniumRepo.isElementPresent(Brand_Link)) 
		{
			Brand_Link.click();
			Thread.sleep(3000);

		} else {
			System.out.println("Brands Link not found");


		}
		String BrandName = ReadProperties.getPropValues("Admin.properties", "SelectBrand");
		WebElement Brandname=SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'"+BrandName+"')]"));
		ExplicitWait(Brandname);
		Thread.sleep(2000);
		if (SeleniumRepo.isElementPresent(Brandname)) 
		{
			SeleniumRepo.scrollintoview(Brandname);
			Thread.sleep(3000);
			Brandname.click();
			Thread.sleep(3000);
			Assert.assertTrue(true, "Clicked on Brand Name");
		}
		else
		{
			System.out.println("Brand Name not found");

		}
	}
	
	public void selectBrand(String Brand) throws IOException, InterruptedException 
	{


		SeleniumRepo.waitForElementPresent(Brand_Link);
		Thread.sleep(2000);
		if (SeleniumRepo.isElementPresent(Brand_Link)) 
		{
			Brand_Link.click();
			Thread.sleep(3000);

		} else {
			System.out.println("Brands Link not found");


		}
		String BrandName = Brand;
		WebElement Brandname=SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'"+BrandName+"')]"));
		ExplicitWait(Brandname);
		Thread.sleep(2000);
		if (SeleniumRepo.isElementPresent(Brandname)) 
		{
			SeleniumRepo.scrollintoview(Brandname);
			Thread.sleep(3000);
			Brandname.click();
			Thread.sleep(3000);
			Assert.assertTrue(true, "Clicked on Brand Name");
		}
		else
		{
			System.out.println("Brand Name not found");

		}
	}
}
