package com.tt.admin.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;

public class Add_Ons extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//div[contains(text(), 'Add-Ons')]"),

	})
	private WebElement Addon_link;

	@FindAll({ @FindBy(xpath = "//a[@id='add_new_add_on']"),

	})
	private WebElement Addon_AddNew;

	@FindAll({ @FindBy(xpath = "//input[@name='name']"),

	})
	private WebElement Addon_Name;

	@FindAll({ @FindBy(xpath = "//input[@name='code']"),

	})
	private WebElement Addon_Code;


	@FindAll({ @FindBy(xpath = "//textarea [@name='shortDesc']"),})
	private WebElement Addon_Discription;

	@FindAll({ @FindBy(xpath = "//input[@name='isActive'][@value='true']"),

	})
	private WebElement Addon_ActiveStatus;

	@FindAll({ @FindBy(xpath = "//input[@name='addOnStartDate']"),

	})
	private WebElement Addon_StartDate;

	@FindAll({ @FindBy(xpath = "//input[@name='addOnEndDate']"),

	})
	private WebElement Addon_EndDate;


	@FindAll({ @FindBy(xpath = "//input[@name='priceFrequency']"),

	})
	private List<WebElement> Select_PriceFrequencyRadioButton;


	@FindAll({ @FindBy(xpath = "//input[@name='priceBasis']"),

	})
	private List<WebElement> Select_PriceBasisRadioButton;


	@FindAll({ @FindBy(xpath = "//input[@name='maxQuantityBookable']"),

	})
	private WebElement Enter_MaxQuantityBookable;


	@FindAll({ @FindBy(xpath = "//input[@id='price']"),

	})
	private WebElement Enter_PriceAdult;

	@FindAll({ @FindBy(xpath = "//input[@id='childPrice']"),

	})
	private WebElement Enter_PriceChild;


	@FindAll({ @FindBy(xpath = "//input[@id='price']"),

	})
	private WebElement AddON_Price;

	@FindAll({ @FindBy(xpath = "//input[@name='opaquePriceMode']"),

	})
	private List<WebElement> Select_OpaquePriceMode;


	@FindAll({ @FindBy(xpath = "//input[@name='isChlMgrAvailable' and @value='true']"),

	})
	private WebElement Select_AvailablethroughSiteMinder;


	@FindAll({ @FindBy(xpath = "//input[@name='isHotelTraderAvailable' and @value='true']"),

	})
	private WebElement Select_AvailablethroughHotelTrader;


	@FindAll({ @FindBy(xpath = "//input[@name='isRateTigerAvailable' and @value='true']"),

	})
	private WebElement Select_AvailablethroughRateTiger;


	@FindAll({ @FindBy(xpath = "//input[@value='Save']"),

	})
	private WebElement Click_SaveButton;


	public void addON(String AddonName,String AddonCode,String Discription,
			String PriceFrequency,String PriceBasis,String Price,String MaxQuantityBookable,
			String PriceAdult,String PriceChild,String  OpaquePrice) {

		try {
			

			SeleniumRepo.waitForElementPresent(Addon_AddNew);
			if (SeleniumRepo.isElementPresent( Addon_AddNew)) 
			{
				Addon_AddNew.click();
				test.log(Status.PASS, 
						"Clicked on  Addon_AddNew link");
				logger.info("Clicked on  Addon_AddNew link");
				Assert.assertTrue(true, "Clicked on  Addon_AddNew link");
			} else {
				logger.info("Failed to Click on  Addon_AddNew link");

				test.log(Status.FAIL, "Failed to Click on  Addon_AddNew link");
			}

			SeleniumRepo.waitForElementPresent(Addon_Name);
			if (Addon_Name.isEnabled()) 
			{
				Addon_Name.click();
				Addon_Name.clear();
				Addon_Name.sendKeys(AddonName);
				test.log(Status.PASS,
						
						"AddonName is entered successfully");
				logger.info("AddonName is entered successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Enter AddonName");
				logger.error("Failed to Enter AddonName");
			}


			SeleniumRepo.waitForElementPresent(Addon_Code);
			if (Addon_Code.isEnabled()) 
			{
				Addon_Code.click();
				Addon_Code.clear();
				Addon_Code.sendKeys(AddonCode+SeleniumRepo.getRandomAlphNumeircString(2));
				test.log(Status.PASS,
						"AddonCode is entered successfully");
				logger.info("AddonCode is entered successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Enter AddonCode");
				logger.error("Failed to Enter AddonCodes");
			}

			SeleniumRepo.waitForElementPresent(Addon_Discription);
			if (Addon_Discription.isEnabled())
			{
				Addon_Discription.click();
				Addon_Discription.clear();
				Addon_Discription.sendKeys(Discription);
				test.log(Status.PASS,
						"Discription is entered successfully");
				logger.info("Discription is entered successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Enter Discription");
				logger.error("Failed to Enter Discriptions");
			}

			SeleniumRepo.waitForElementPresent(Addon_ActiveStatus);
			if (Addon_ActiveStatus.isDisplayed()) 
			{
				Addon_ActiveStatus.click();
				Addon_ActiveStatus.isSelected();
				test.log(Status.INFO, 
						"ActiveStatus is Selected successfully");
				logger.info("ActiveStatus is Selected successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Select ActiveStatus");
				logger.error("Failed to to Select ActiveStatu");
			}

			if(SeleniumRepo.isElementPresent(Addon_StartDate)) 
			{	 

				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
				Date date = new Date();
				String date1= dateFormat.format(date);
				System.out.println(date1);
				Addon_StartDate.clear();
				Addon_StartDate.click();
				Addon_StartDate.sendKeys(date1);
				test.log(Status.PASS,
						"Start Date Data Entered");
				logger.info("Start Date Data Entered");
				Assert.assertTrue(true, "Start Date Data Entered");
			}else {
				logger.info("Failed to Enter Start Date ");
				test.log(Status.FAIL,
						"Failed to Enter Start Date");
			}	

			if(SeleniumRepo.isElementPresent(Addon_EndDate)) 
			{

				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
				Date dt = new Date();
				Calendar cl = Calendar.getInstance();
				cl.setTime(dt);;
				cl.add(Calendar.DAY_OF_YEAR, 2);
				dt=cl.getTime();
				String str = df.format(dt);
				System.out.println("the date today is " + str);
				Addon_EndDate.click();
				Addon_EndDate.clear();
				Addon_EndDate.sendKeys(str);
				test.log(Status.PASS, 
						"End Date Data Entered");
				logger.info("End Date Data Entered");
				Assert.assertTrue(true,
						"End Date Data Entered");
			}else {
				logger.info("Failed to Enter End Date ");
				test.log(Status.FAIL, 
						"Failed to Enter End Date");
			}		

			try 
			{

				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Select_PriceFrequencyRadioButton, PriceFrequency);
				test.log(Status.PASS, "PriceFrequency is selected successfully");
				logger.info("PriceFrequency is selected successfully");
			} 
			catch (Exception e) 
			{
				test.log(Status.FAIL, 
						"Failed to select PriceFrequency ");
				logger.error("Failed to select PriceFrequency");
				e.printStackTrace();
			}


			try {
				//SeleniumRepo.waitForElementsPresent(Select_PriceBasisRadioButton);
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Select_PriceBasisRadioButton, PriceBasis);
				if(AddON_Price.isDisplayed()) 
				{
					SeleniumRepo.waitForElementPresent(AddON_Price);
					AddON_Price.click();
					AddON_Price.clear();
					AddON_Price.sendKeys(Price);
				}
				if(Enter_MaxQuantityBookable.isDisplayed())
				{
					SeleniumRepo.waitForElementPresent(Enter_MaxQuantityBookable);
					Enter_MaxQuantityBookable.click();
					Enter_MaxQuantityBookable.clear();
					Enter_MaxQuantityBookable.sendKeys(MaxQuantityBookable);
				}
				if(Enter_PriceAdult.isDisplayed())
				{
					SeleniumRepo.waitForElementPresent(Enter_PriceAdult);
					Enter_PriceAdult.click();
					Enter_PriceAdult.clear();
					Enter_PriceAdult.sendKeys(PriceAdult);
				}
				if(Enter_PriceChild.isDisplayed())
				{
					SeleniumRepo.waitForElementPresent(Enter_PriceChild);	
					Enter_PriceChild.click();
					Enter_PriceChild.clear();
					Enter_PriceChild.sendKeys(PriceChild);
				}
				test.log(Status.PASS, 
						"PriceBasis is selected successfully");
				logger.info("PriceBasis is selected successfully");
			} catch (Exception e) {
				test.log(Status.FAIL, 
						"Failed to select PriceBasis ");
				logger.error("Failed to select PriceBasis");
				e.printStackTrace();
			}



			/*SeleniumRepo.waitForElementPresent(AddON_Price);
				if (AddON_Price.isEnabled()) 
				{
					AddON_Price.click();
					AddON_Price.clear();
					AddON_Price.sendKeys(Price);
					test.log(Status.PASS,
							"Price is entered successfully");
					logger.info("Price is entered successfully");
				} else {
					test.log(Status.FAIL, 
							"Failed to Enter Price");
					logger.error("Failed to Enter Price");
				}*/


			try 
			{
				//SeleniumRepo.waitForElementsPresent(Select_OpaquePriceMode);
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Select_OpaquePriceMode,OpaquePrice);
				test.log(Status.PASS,"PriceBasis is selected successfully");
				logger.info("PriceBasis is selected successfully");
			} 
			catch (Exception e) 
			{
				test.log(Status.FAIL,
						"Failed to select PriceBasis ");
				logger.error("Failed to select PriceBasis");
				e.printStackTrace();
			}


			SeleniumRepo.waitForElementPresent(Select_AvailablethroughSiteMinder);
			if (Select_AvailablethroughSiteMinder.isDisplayed()) 
			{
				Select_AvailablethroughSiteMinder.click();
				Select_AvailablethroughSiteMinder.isSelected();
				test.log(Status.PASS, 
						"SiteMinder is Selected successfully");
				logger.info("SiteMinder is Selected successfully");
			} else {
				test.log(Status.FAIL, "Failed to Select SiteMinder");
				logger.error("Failed to to Select SiteMinder");
			}




			SeleniumRepo.waitForElementPresent(Select_AvailablethroughHotelTrader);
			if (Select_AvailablethroughHotelTrader.isDisplayed()) 
			{
				Select_AvailablethroughHotelTrader.click();
				Select_AvailablethroughHotelTrader.isSelected();
				test.log(Status.PASS,
						"HotelTrader is Selected successfully");
				logger.info("HotelTrader is Selected successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Select HotelTrader");
				logger.error("Failed to to Select HotelTrader");
			}

			SeleniumRepo.waitForElementPresent(Select_AvailablethroughRateTiger);
			if (Select_AvailablethroughRateTiger.isDisplayed())
			{
				Select_AvailablethroughRateTiger.click();
				Select_AvailablethroughRateTiger.isSelected();
				test.log(Status.PASS,
						"RateTiger is Selected successfully");
				logger.info("RateTigeris Selected successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Select RateTiger");
				logger.error("Failed to to Select RateTiger");
			}


			SeleniumRepo.waitForElementPresent( Click_SaveButton);
			if (SeleniumRepo.isElementPresent( Click_SaveButton)) 
			{
				Click_SaveButton.click();
				test.log(Status.PASS, 
						"Add-On  Data before click on Save button");

				logger.info("Clicked on  Save Button");
				Assert.assertTrue(true, "Clicked on  Save Button");
			} else {
				logger.info("Failed to Click on  Save Button");
				test.log(Status.FAIL, 
						"Failed to Click on  Save Button");
			}

		} catch (Exception e) {
			logger.error("Unable to create Add-On for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to Add-On room type for selected property because of this execption" + e);
			e.printStackTrace();
		}	



	}}
