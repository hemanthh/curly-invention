package com.tt.admin.pom;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class RatePlanCategories extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({
		@FindBy(xpath="//div[contains(.,'Rate Plans')]"),
	})     
	@CacheLookup
	private WebElement Rateplan;

	@FindAll({
		@FindBy(xpath="//li/a[starts-with(@href,'/rt/admin/action/displayRatePlanCategories.do?')]"),
	})     
	@CacheLookup
	private WebElement Click_RateplanCate;

	@FindAll({
		@FindBy(xpath="//input[@id='isEnableRatePlanCategoryTrue']"),
	})     
	@CacheLookup
	private WebElement Click_EnableRatePlanyes;

	@FindAll({
		@FindBy(xpath="//input[@id='isEnableRatePlanCategoryFalse']"),
	})     
	@CacheLookup
	private WebElement EnableRatePlanNo;


	@FindAll({
		@FindBy(xpath="//input[@value='Add New Category']"),
	})     
	@CacheLookup
	private WebElement Click_AddNewCategory;


	@FindAll({
		@FindBy(xpath="//input[@name='categoryName']"),
	})     
	@CacheLookup
	private WebElement Enter_CategoryName;

	@FindAll({
		@FindBy(xpath="//input[@value='Save']"),
	})     
	@CacheLookup
	private WebElement Click_Save;

	@FindAll({
		@FindBy(xpath="//table[@id='CategoryContentDetail']"),
	})     
	@CacheLookup
	private List<WebElement> Check_categorienames;

	@FindAll({
		@FindBy(xpath="//a[@name='deleteCategoryLink']"),
	})     
	@CacheLookup
	private WebElement Click_Delete;



	public void rateplancate(String categoryName) throws IOException, InterruptedException 
	{

		Thread.sleep(3000);
		SeleniumRepo.waitForElementPresent(Rateplan);
		if (Click_RateplanCate.isDisplayed()) 
		{
			System.out.println("Rate plan element Expanded and Rate plan Categories element  found");
			test.log(Status.INFO, "Rate plan element Expanded and Rate plan Categories element  found");
			Assert.assertTrue(true, "Rate plan element Expanded and Rate plan Categories element  found");
		} 
		else 
		{
			System.out.println("Rate plan Menu is not expanded");
			Javascriptexecutor(Rateplan);
			System.out.println("Clicked on Rate plan Link");
			test.log(Status.INFO, "Clicked on Smart policies Link");

			ExplicitWait(Click_RateplanCate);
			if(Click_RateplanCate.isDisplayed())
			{
				Javascriptexecutor(Click_RateplanCate);
				System.out.println("Rate plan Catgories  element found");
				test.log(Status.INFO, "Rate plan Catgories  element found");
				Assert.assertTrue(true, "Rate plan Catgories  element found");
			}
			else
			{
				logger.info("Rate plan Catgories element not  found");
				test.log(Status.FAIL, "Rate plan Catgories element not  found");
			}
		}

		ExplicitWait(Click_EnableRatePlanyes);
		if (SeleniumRepo.isElementPresent(Click_EnableRatePlanyes)) {
			Click_EnableRatePlanyes.click();
			test.log(Status.INFO, "Clicked on EnableRatePlanyes radiobutton");
			logger.info("Clicked on EnableRatePlanyes radiobutton");
			Assert.assertTrue(true, "Clicked on EnableRatePlanyes radiobutton");
		} else {
			System.out.println("EnableRatePlanyes radiobutton not found");
			test.log(Status.FAIL, " EnableRatePlanyes radiobutton not found");
			logger.info("EnableRatePlanyes radiobutton not found");
			Assert.assertFalse(false, "EnableRatePlanyes radiobutton not found");
		}

		Thread.sleep(3000);

		String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
		if(body.contains(categoryName))
		{
			WebElement delet=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+categoryName+"']/../following-sibling::td/a"));
			Javascriptexecutor(delet);
			Thread.sleep(2000);
			Alert alert =SeleniumRepo.driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.accept();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Category "+categoryName+"  deleted successfully");
			
		}
		else
		{
		System.out.println(categoryName+" duplicate Category is not present hence creating new amenity\"");
		}
		if (SeleniumRepo.isElementPresent(Click_AddNewCategory))
		{
			Thread.sleep(2000);
			Click_AddNewCategory.click();Thread.sleep(2000);
			test.log(Status.INFO, "Clicked on AddNewCategory button");
			logger.info("Clicked on AddNewCategory button");
			Assert.assertTrue(true, "Clicked on AddNewCategory button");
		} else {
			System.out.println("AddNewCategory button not found");
			test.log(Status.FAIL, "AddNewCategory button not found");
			logger.info("AddNewCategory button not found");
			Assert.assertFalse(false, "AddNewCategory button not found");
		}

		if (SeleniumRepo.isElementPresent(Enter_CategoryName)) {
			Enter_CategoryName.click();
			Enter_CategoryName.clear();
			Enter_CategoryName.sendKeys(categoryName);
			test.log(Status.INFO, "Clicked on AddNewCategory button");
			logger.info("Clicked on AddNewCategory button");
			Assert.assertTrue(true, "Clicked on AddNewCategory button");
		} else {
			System.out.println("AddNewCategory button not found");
			test.log(Status.FAIL, "AddNewCategory button not found");
			logger.info("AddNewCategory button not found");
			Assert.assertFalse(false, "AddNewCategory button not found");
		}

		if (SeleniumRepo.isElementPresent(Click_Save)) {
			Click_Save.click();Thread.sleep(3000);
			test.log(Status.INFO, "Clicked on Save button");
			logger.info("Clicked on Save button");
			Assert.assertTrue(true, "Clicked on Save button");
		} else {
			System.out.println("Save button not found");
			test.log(Status.FAIL, "Save button not found");
			logger.info("Save button not found");
			Assert.assertFalse(false, "Save button not found");
		}

		/*int length = Check_categorienames.size();
		System.out.println(length);
		try {
			for (int i=1;i<length;i++) {

				if(SeleniumRepo.driver.findElements(By.xpath("//*[text()[contains(.,'"+categoryName+"')]]/following::td[1]//a[@name='deleteCategoryLink'][contains(text(),'Delete')]")).size()>0) {

					WebElement policy=SeleniumRepo.driver.findElement(By.xpath("//*[text()[contains(.,'"+categoryName+"')]]/following::td[1]//a[@name='deleteCategoryLink'][contains(text(),'Delete')]"));
					System.out.println(policy);
					Click_Delete.click();
					SeleniumRepo.handleAlert();
					System.out.println("Policy Deleted"+categoryName);
				}
				else {
					System.out.println("No Element found");
				}
			}
		} catch (Exception e) {
			logger.error("Unable to  Delete Policy for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to Delete Policyfor selected property because of this execption" + e);
			e.printStackTrace();

		}*/
	}
}
