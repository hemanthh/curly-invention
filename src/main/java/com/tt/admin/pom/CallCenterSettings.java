package com.tt.admin.pom;

	import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.testng.Assert;
	import com.aventstack.extentreports.Status;
	import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

 

	public class CallCenterSettings extends BaseTest {

		@FindAll({
	        @FindBy(xpath="//ul//li//a[contains(., 'Call Center Settings')]"),
	        @FindBy(css = "ul:nth-child(3) li:nth-child(3) ul:nth-child(2) li:nth-child(16) > a:nth-child(1)") })
	           
		
	    private WebElement Call_Center_Settings;
		
		@FindAll({
	        @FindBy(xpath="//input[@name='hotelDetailLink']"),
	            })
		
	    private WebElement Enter_Linkforhoteldetails;
		
		@FindAll({
	        @FindBy(xpath="//textarea[@name='announcement']"),
	            })
		
	    private WebElement Enter_Announcement;
		
		@FindAll({
	        @FindBy(xpath="//input[@value='true']"),
	            })
		
	    private WebElement Select_ActivateAnnouncementyes;
				
		@FindAll({
	        @FindBy(xpath="//input[@value='false']"),
	            })
		
	    private WebElement Select_ActivateAnnouncementno;
		
		@FindAll({
	        @FindBy(xpath="//input[@name='save']"),
	            })
		
	    private WebElement Callcenter_Save;
		
		@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"),

		})
		private WebElement property_Management;
		
		
		public void callcentersetting(String  Linkhoteldetails,String Announcement) 
		{
			Logger logger = Logger.getLogger(this.getClass().getSimpleName());
			if (Call_Center_Settings.isDisplayed()) 
			{
				Javascriptexecutor(Call_Center_Settings);
				SeleniumRepo.waitForPageLoaded();
				ExplicitWait(Enter_Linkforhoteldetails);
				System.out.println("PropertyManagement element Expanded and Call_Center_Settings element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and Call_Center_Settings element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and Call_Center_Settings element  found");
			} 
			else 
			{
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(Call_Center_Settings);
				if(Call_Center_Settings.isDisplayed())
				{
					Javascriptexecutor(Call_Center_Settings);
					SeleniumRepo.waitForPageLoaded();
					ExplicitWait(Enter_Linkforhoteldetails);
					System.out.println("Call_Center_Settings element found");
					test.log(Status.INFO, "Call_Center_Settings  element found");
					Assert.assertTrue(true, "Call_Center_Settings element found");
				}
				else
				{
					logger.info("Call_Center_Settings element not  found");
					test.log(Status.FAIL, "Call_Center_Settings element not  found");
				}
			}
		
			if (Enter_Linkforhoteldetails.isDisplayed()) {
				Enter_Linkforhoteldetails.click();
				Enter_Linkforhoteldetails.clear();
 				Enter_Linkforhoteldetails.sendKeys(Linkhoteldetails);
				System.out.println("Linkhoteldetails is entered successfully");
				test.log(Status.INFO, "Linkhoteldetails is entered successfully");
				Assert.assertTrue(true,"Linkhoteldetails is entered successfully");
			} else {
				System.out.println("Linkhoteldetails TextBox not found");
				test.log(Status.FAIL, "Linkhoteldetails TextBox not found");
				Assert.assertFalse(false, "Linkhoteldetails TextBox not found");}
				
						
			if (Enter_Announcement.isDisplayed()) {
				Enter_Announcement.click();
				Enter_Announcement.clear();
 				Enter_Announcement.sendKeys(Announcement);
				System.out.println("Announcement is entered successfully");
				test.log(Status.INFO, "Announcement is entered successfully");
				Assert.assertTrue(true,"Announcement is entered successfully");
			} else {
				System.out.println("Announcement TextBox not found");
				test.log(Status.FAIL, "Announcement TextBox not found");
				Assert.assertFalse(false, "Announcement TextBox not found");}
			
			
			if (Select_ActivateAnnouncementyes.isDisplayed()) {
				Select_ActivateAnnouncementyes.click();
				System.out.println("ActivateAnnouncement is selected successfully");
				test.log(Status.INFO, "ActivateAnnouncement is Selected successfully");
				Assert.assertTrue(true,"ActivateAnnouncement is Selected successfully");
			} else {
				System.out.println("ActivateAnnouncement Radiobutton not found");
				test.log(Status.FAIL, "ActivateAnnouncement Radiobutton not found");
				Assert.assertFalse(false, "ActivateAnnouncement Radiobutton not found");}
			
			/*if (Select_ActivateAnnouncementno.isDisplayed()) {
				Select_ActivateAnnouncementno.click();
				System.out.println("ActivateAnnouncement is selected successfully");
				test.log(Status.INFO, "ActivateAnnouncement is Selected successfully");
				Assert.assertTrue(true,"ActivateAnnouncement is Selected successfully");
			} else {
				System.out.println("ActivateAnnouncement Radiobutton not found");
				test.log(Status.FAIL, "ActivateAnnouncement Radiobutton not found");
				Assert.assertFalse(false, "ActivateAnnouncement Radiobutton not found");}*/
			
			try {
				Callcenter_Save.click();
				SeleniumRepo.waitForPageLoaded();

				System.out.println(" callcenter saved ");
			} catch (Exception e) {
				System.out.println(" callcenter Not saved ");
				e.printStackTrace();
			}
			
			
		
		}}


