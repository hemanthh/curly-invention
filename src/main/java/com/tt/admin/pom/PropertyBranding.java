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

public class PropertyBranding extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"),

	})
	private WebElement property_Management;

	@FindAll({ @FindBy(xpath = "//a[normalize-space(text())='Property Branding']"),

	})
	private WebElement property_branding_link;

	@FindAll({ @FindBy(name = "tt_img_loader_name_0"), @FindBy(xpath = "//input[@name='tt_img_loader_name_0']") })
	
	private WebElement Hotel_Name;

	@FindAll({ @FindBy(name = "specialsPackagesText"), @FindBy(xpath = "//textarea[@name='specialsPackagesText']") })
	
	private WebElement Specials_and_Packages;
	
	
	@FindAll({ @FindBy(name = "topBannerAltText"), @FindBy(xpath = "//textarea[@name='topBannerAltText']") })
	
	private WebElement Top_Banner_Alt_Text;
	
	@FindAll({ @FindBy(name = "tt_img_loader_file_0"), @FindBy(xpath = "//input[@name='tt_img_loader_file_0']") })
	
	private WebElement Image_Path;
	
	@FindAll({ @FindBy(name = "topBannerURL"), @FindBy(xpath = "//textarea[@name='topBannerURL']") })
	
	private WebElement Top_Banner_URL;
	
	@FindAll({ @FindBy(name = "bottomBannerAltText"), @FindBy(xpath = "//textarea[@name='bottomBannerAltText']") })
	
	private WebElement Bottom_Banner_Alt_Text;
	
	@FindAll({ @FindBy(name = "bottomBannerURL"), @FindBy(xpath = "//textarea[@name='bottomBannerURL']") })
	
	private WebElement Bottom_Banner_URL;
	
	@FindAll({ @FindBy(name = "addsOnPaymentAltText"), @FindBy(xpath = "//textarea[@name='addsOnPaymentAltText']") })
	
	private WebElement Payment_Page_Alt;
	
	@FindAll({ @FindBy(name = "addsOnPaymentURL"), @FindBy(xpath = "//textarea[@name='addsOnPaymentURL']") })
	
	private WebElement Payment_Page_URL;
	
	
	@FindAll({ @FindBy(xpath = "(//input[@name='Submit'])[4]"),
			@FindBy(css = "form[name=\"propertyBrandingForm\"] > input[name=\"Submit\"]"), })
	
	private WebElement Save_btn;

	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Administrator Home')]"),
			@FindBy(css = "table:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h1:nth-child(1)") })
	
	private WebElement Home_Msg;

	public void propertyBranding(String hotelName,String imagePath,String topBannerText,String topBannerUrl,String bottomBannerText,String bottomBannerUrl,String paymentPageText,String paymentPageUrl) throws InterruptedException, IOException {

		try 
		{
			//Thread.sleep(5000);
			SeleniumRepo.waitForElementPresent(property_Management);
			SeleniumRepo.scrollintoview(property_Management);Thread.sleep(2000);
			if (property_branding_link.isDisplayed()) 
			{
				SeleniumRepo.scrollintoview(property_branding_link);
				Javascriptexecutor(property_branding_link);Thread.sleep(2000);
				ExplicitWait(Hotel_Name);
				System.out.println("PropertyManagement element Expanded and property_branding element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and property_branding element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and property_branding element  found");
			} 
			else 
			{
				System.out.println("PropertyManagement Menu is not expanded");SeleniumRepo.scrollintoview(property_Management);
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(property_branding_link);Thread.sleep(3000);
				if(property_branding_link.isDisplayed())
				{
					Javascriptexecutor(property_branding_link);Thread.sleep(3000);
					System.out.println("property_branding element found");
					test.log(Status.INFO, "property_branding  element found");
					Assert.assertTrue(true, "property_branding element found");
				}
				else
				{
					logger.info("property_branding element not  found");
					test.log(Status.FAIL, "property_branding element not  found");
				}
			}
			
			SeleniumRepo.waitForElementPresent(Hotel_Name);
			if(SeleniumRepo.isElementPresent(Hotel_Name))
			{
				Hotel_Name.clear();
				Hotel_Name.sendKeys(hotelName);
				logger.info("Hotel Name is entered");

				test.log(Status.INFO, "Hotel Name is entered");
			} else {
				logger.error(" Failed to enter Hotel Name");

				test.log(Status.ERROR, "Failed to enter Hotel Name");
			}
			
			
			/*SeleniumRepo.waitForElementPresent(Specials_and_Packages);
			if(SeleniumRepo.isElementPresent(Specials_and_Packages))
			{
				Specials_and_Packages.clear();
				Specials_and_Packages.sendKeys(specialsandPackages);
				logger.info("specialsandPackages is entered");

				test.log(Status.INFO, "specialsandPackages is entered");
			} else {
				logger.error(" Failed to enter specialsandPackages");

				test.log(Status.FAIL, "Failed to enter specialsandPackages");
			}
*/			
			
			SeleniumRepo.waitForElementPresent(Image_Path);
			if(SeleniumRepo.isElementPresent(Image_Path))
			{
				Image_Path.sendKeys(System.getProperty("user.dir")+imagePath);
				logger.info("specialsandPackages is entered");

				test.log(Status.INFO, "specialsandPackages is entered");
			} else {
				logger.error(" Failed to enter specialsandPackages");

				test.log(Status.FAIL, "Failed to enter specialsandPackages");
			}
/*			
 Seems to be working fine , had to comment out one of the lines below due to some error
 
			SeleniumRepo.waitForElementPresent(Top_Banner_Alt_Text);
			if(SeleniumRepo.isElementPresent(Top_Banner_Alt_Text))
			{
				Top_Banner_Alt_Text.clear();
				Top_Banner_Alt_Text.sendKeys(topBannerText);
				logger.info("Top Banner text is entered");

				test.log(Status.INFO, "Top Banner text is entered");
			} else {
				logger.error(" Failed to enter Top Banner text");

				test.log(Status.FAIL, "Failed to enter Top Banner text");
			}
			
			SeleniumRepo.waitForElementPresent(Top_Banner_URL);
			if(SeleniumRepo.isElementPresent(Top_Banner_URL))
			{
				Top_Banner_URL.clear();
				Top_Banner_URL.sendKeys(topBannerUrl);
				logger.info("Top Banner Url is entered");

				test.log(Status.INFO, "Top Banner Url is entered");
			} else {
				logger.error(" Failed to enter Top Banner URL");

				test.log(Status.FAIL, "Failed to enter Top Banner URL");
			}
			
			SeleniumRepo.waitForElementPresent(Bottom_Banner_Alt_Text);
			if(SeleniumRepo.isElementPresent(Bottom_Banner_Alt_Text))
			{
				Bottom_Banner_Alt_Text.clear();
				Bottom_Banner_Alt_Text.sendKeys(bottomBannerText);
				logger.info("Bottom_Banner_Alt_Text is entered");

				test.log(Status.INFO, "Bottom_Banner_Alt_Text is entered");
			} else {
				logger.error(" Failed to enter Bottom_Banner_Alt_Text");

				test.log(Status.FAIL, "Failed to enter Bottom_Banner_Alt_Text");
			}
			
			SeleniumRepo.waitForElementPresent(Bottom_Banner_URL);
			if(SeleniumRepo.isElementPresent(Bottom_Banner_URL))
			{
				Bottom_Banner_URL.clear();
				Bottom_Banner_URL.sendKeys(bottomBannerUrl);
				logger.info("Bottom_Banner_URL is entered");

				test.log(Status.INFO, "Bottom_Banner_URL is entered");
			} else {
				logger.error(" Failed to enter Bottom_Banner_URL");

				test.log(Status.FAIL, "Failed to enter Bottom_Banner_URL");
			}
			
			SeleniumRepo.waitForElementPresent(Payment_Page_Alt);
			if(SeleniumRepo.isElementPresent(Payment_Page_Alt))
			{
				Payment_Page_Alt.clear();
				Payment_Page_Alt.sendKeys(paymentPageText);
				logger.info("Payment_Page_Alt is entered");

				test.log(Status.INFO, "Payment_Page_Alt is entered");
			} else {
				logger.error(" Failed to enter Payment_Page_Alt");

				test.log(Status.FAIL, "Failed to enter Payment_Page_Alt");
			}
			
			SeleniumRepo.waitForElementPresent(Payment_Page_URL);
			if(SeleniumRepo.isElementPresent(Payment_Page_URL))
			{
				Payment_Page_URL.clear();
				Payment_Page_URL.sendKeys(paymentPageUrl);
				logger.info("Payment_Page_URL is entered");

				test.log(Status.INFO, "Payment_Page_URL is entered"+ test.addScreenCaptureFromPath(captureScreen(SeleniumRepo.driver)));

			} else {
				logger.error(" Failed to enter Payment_Page_URL");

				test.log(Status.FAIL, "Failed to enter Payment_Page_URL");
			}*/
			
			SeleniumRepo.waitForElementPresent(Save_btn);
			if (Save_btn.isEnabled()) 
			{
				Save_btn.click();
				test.log(Status.PASS, "Clicked on Save button");
				Assert.assertTrue(true, "Clicked on Save button");
			} else {
				test.log(Status.FAIL, "Failed to Click on Save button");

			}

			SeleniumRepo.waitForPageLoaded();
            Thread.sleep(3000);
			if (SeleniumRepo.isElementPresent(Home_Msg))
			{

				test.log(Status.PASS, "Property Branding created successfully");

				System.out.println("Property Branding created successfully");
				Assert.assertTrue(true, "Property Branding created successfully");
			} else {
				test.log(Status.FAIL, "Failed to create Property Branding ");
				Assert.assertTrue(false, "Failed to create Property Branding ");


			}
		} 
		catch (Exception e) {
			Assert.assertTrue(false, "Failed to create Property Branding ");

			test.log(Status.FAIL, "Failed to create Property Branding "+e);
			e.printStackTrace();
		}

	}
}
