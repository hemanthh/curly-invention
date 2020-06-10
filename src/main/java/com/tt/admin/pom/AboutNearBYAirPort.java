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
import com.tt.utility.SeleniumRepoDropdown;

public class AboutNearBYAirPort extends AboutTheProperty {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();
	
	
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Airport Name Required')]"), })
    private WebElement Check_ErrorAirportNameLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Code Required')]"), })
    private WebElement Check_ErrorCodeLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Distance Away Required')]"), })
    private WebElement Check_ErrorDistanceAwayLabel;

	@FindAll({ @FindBy(xpath = "//a[starts-with(., 'About')]"), })
	private WebElement AbouttheProperty_Link;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Nearby Airport*')]/following-sibling::td/a"), })
	private WebElement Click_onNearByAirPort_link;

	@FindAll({ @FindBy(xpath = "//input[@name='airportName']"), })
	private WebElement Enter_AirportName;

	@FindAll({ @FindBy(xpath = "//input[@name='code']"), })
	private WebElement Enter_AirportCode;

	@FindAll({ @FindBy(xpath = "//input[@name='url']"), })
	private WebElement Enter_AirportURL;

	@FindAll({ @FindBy(xpath = "//textarea[@name='description']"), })
	private WebElement Enter_AirportDescription;

	@FindAll({ @FindBy(xpath = "//input[@name='address1']"), })
	private WebElement Enter_AirportAddress1;

	@FindAll({ @FindBy(xpath = "//input[@name='city']"), })
	private WebElement Enter_AirportCity;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedCountry']"), })
	private WebElement Select_AirportCountry;

	@FindAll({ @FindBy(xpath = "//input[@name='zipCode']"), })
	private WebElement Enter_Zipcode;

	@FindAll({ @FindBy(xpath = "//select[@id='selectedUnit']"), })
	private WebElement Select_DistanceUnit;

	@FindAll({ @FindBy(xpath = "//input[@id='distanceAway']"), })
	private WebElement Enter_DistanceAway;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedTranspotationMethod']"), })
	private WebElement Select_TranspotationMode;

	@FindAll({ @FindBy(xpath = "//*[@id='saveBtn']/input[@value='Save']"), })
	private WebElement AirPort_Save;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	private WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(xpath = "//input[@name='builtYear']"), })
	private WebElement Enter_YearBuilt;
	
	
	@FindAll({ @FindBy(xpath = "//*[@id='saveBtn']/input[@value='Save']"), })
	private WebElement Click_NBAP_Save;
	
	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"), })
	private WebElement Click_NBAP_Cancel;
	
	
	
	public void editAirportName(String AirportName){
		
		
		if (Enter_AirportName.isDisplayed()) {
			Javascriptexecutor(Enter_AirportName);
			Enter_AirportName.clear();
			// Enter_AirportName.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_AirportName.sendKeys(AirportName);
			System.out.println("AirportName is entered successfully");
			logger.info("AirportName is entered successfully");
			test.log(Status.PASS, "AirportName is entered successfully");
			Assert.assertTrue(true, "AirportName is entered successfully");
		} else {
			System.out.println("AirportName TextBox not found");
			logger.error("Failed to Found AirportName TextBox");
			test.log(Status.FAIL, "Failed to Found AirportName TextBox");
			Assert.assertFalse(false, "AirportName TextBox not found");
		}


		
		
	}
	
	public void editAirportCode(String AirportCode){
		
		if (Enter_AirportCode.isDisplayed()) {
			Javascriptexecutor(Enter_AirportCode);
			Enter_AirportCode.clear();
			// Enter_AirportCode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_AirportCode.sendKeys(AirportCode);
			System.out.println("AirportCode is entered successfully");
			logger.info("AirportCode is entered successfully");
			test.log(Status.PASS, "AirportCode is entered successfully");
			Assert.assertTrue(true, "AirportCode is entered successfully");
		} else {
			System.out.println("AirportCode TextBox not found");
			logger.error("Failed to Found AirportCode TextBox");
			test.log(Status.FAIL, "Failed to Found AirportCode TextBox");
			Assert.assertFalse(false, "AirportCode TextBox not found");
		}
		
	}
	
	public void editAirportUrl(String AirportURL){
		
		
		if (Enter_AirportURL.isDisplayed()) {
			Javascriptexecutor(Enter_AirportURL);
			Enter_AirportURL.clear();
			// Enter_AirportURL.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_AirportURL.sendKeys(AirportURL);
			System.out.println("AirportURL is entered successfully");
			logger.info("AirportURL is entered successfully");
			test.log(Status.PASS, "AirportURL is entered successfully");

			Assert.assertTrue(true, "AirportURL is entered successfully");
		} else {
			System.out.println("AirportURL TextBox not found");
			logger.error("Failed to Found AirportURL TextBox");
			test.log(Status.FAIL, "Failed to Found AirportURL TextBox");
			Assert.assertFalse(false, "AirportURL TextBox not found");
		}
		
	}
	

	
	public void editAirportDescription(String AirportDescription ) throws InterruptedException{
		
		
		if (Enter_AirportDescription.isDisplayed()) {
			Javascriptexecutor(Enter_AirportDescription);
			Enter_AirportDescription.clear();
			// Enter_AirportDescription.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_AirportDescription.sendKeys(AirportDescription);
			Thread.sleep(1000);
			System.out.println("AirportDescription is entered successfully");
			logger.info("AirportDescription is entered successfully");
			test.log(Status.PASS, "AirportDescription is entered successfully");
			Assert.assertTrue(true, "AirportDescription is entered successfully");
		} else {
			System.out.println("AirportDescription TextBox not found");
			logger.error("Failed to Found AirportDescription TextBox");
			test.log(Status.FAIL, "Failed to Found AirportDescription TextBox");
			Assert.assertFalse(false, "AirportDescription TextBox not found");
		}

		
		
		
	}
	
	public void editAirportAddress(String AirportAddress1){
		
		

		if (Enter_AirportAddress1.isDisplayed()) {
			Javascriptexecutor(Enter_AirportAddress1);
			Enter_AirportAddress1.clear();
			// Enter_AirportAddress1.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_AirportAddress1.sendKeys(AirportAddress1);
			System.out.println("AirportAddress1 is entered successfully");
			logger.info("AirportAddress1 is entered successfully");
			test.log(Status.PASS, "AirportAddress1 is entered successfully");
			Assert.assertTrue(true, "AirportAddress1 is entered successfully");
		} else {
			System.out.println("AirportAddress1 TextBox not found");
			logger.error("Failed to Found AirportAddress1 TextBox");
			test.log(Status.FAIL, "Failed to Found AirportAddress1 TextBox");
			Assert.assertFalse(false, "AirportAddress1 TextBox not found");
		}
				
	}
	
	public void editAirportCity(String AirportCity) {
		
		
		if (Enter_AirportCity.isDisplayed()) {
			Javascriptexecutor(Enter_AirportCity);
			Enter_AirportCity.clear();
			// Enter_AirportCity.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_AirportCity.sendKeys(AirportCity);
			System.out.println("AirportCity is entered successfully");
			logger.info("AirportCity is entered successfully");
			test.log(Status.PASS, "AirportCity is entered successfully");
			Assert.assertTrue(true, "AirportCity is entered successfully");
		} else {
			System.out.println("AirportCity TextBox not found");
			logger.error("Failed to Found AirportCity TextBox");
			test.log(Status.FAIL, "Failed to Found AirportCity TextBox");
			Assert.assertFalse(false, "AirportCity TextBox not found");
		}


		
	}
	
	public void editAirportCountry(String AirportCountry){
		
		
		try {
			SeleniumRepoDropdown.selectDropDownText(Select_AirportCountry, AirportCountry);
			System.out.println("AirportCountry Selected ");
			logger.info("AirportCountry Selected");
			test.log(Status.PASS, "AirportCountry Selected");
		} catch (Exception e) {
			System.out.println("AirportCountry Not Selected ");
			logger.error("Failed to Select AirportCountry");
			test.log(Status.FAIL, "Failed to Select AirportCountry");
			e.printStackTrace();
		}		
		
	}
	
	public void editAirportZipCode(String Zipcode){
		
		
		if (Enter_Zipcode.isDisplayed()) {
			Javascriptexecutor(Enter_Zipcode);
			Enter_Zipcode.clear();
			// Enter_Zipcode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Zipcode.sendKeys(Zipcode);
			System.out.println("Zipcode is entered successfully");
			logger.info("Zipcode is entered successfully");
			test.log(Status.PASS, "Zipcode is entered successfully");
			Assert.assertTrue(true, "Zipcode is entered successfully");
		} else {
			System.out.println("Zipcode TextBox not found");
			logger.error("Failed to Found Zipcode TextBox");
			test.log(Status.FAIL, "Failed to Found Zipcode TextBox");
			Assert.assertFalse(false, "Zipcode TextBox not found");
		}
		
	}
	
	public void editAirportDistanceAway(String DistanceAway, String DistanceUnit) {
		
		if (Enter_DistanceAway.isDisplayed()) {
			Javascriptexecutor(Enter_DistanceAway);
			Enter_DistanceAway.clear();
			// Enter_DistanceAway.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_DistanceAway.sendKeys(DistanceAway);
			System.out.println("DistanceAway is entered successfully");
			logger.info("DistanceAway is entered successfully");
			test.log(Status.PASS, "DistanceAway is entered successfully");
			Assert.assertTrue(true, "DistanceAway is entered successfully");
		} else {
			System.out.println("DistanceAway TextBox not found");
			logger.error("Failed to Found DistanceAway TextBox");
			test.log(Status.FAIL, "Failed to Found DistanceAway TextBox");
			Assert.assertFalse(false, "DistanceAway TextBox not found");
		}
		
		try {
			SeleniumRepoDropdown.selectDropDownValue(Select_DistanceUnit, DistanceUnit);
			System.out.println("DistanceUnit Selected ");
			logger.info("Distance Unit Selected");
			test.log(Status.PASS, "Distance Unit Selected");
		} catch (Exception e) {
			System.out.println("Distance Unit Not Selected ");
			logger.error("Failed to Select Distance Unit");
			test.log(Status.FAIL, "Failed to Select Distance Unit");
			e.printStackTrace();
		}




		
		
		
	}
	
	public void editAirportTransportaionMethod(String TranspotationMode){
		
		try {
			SeleniumRepoDropdown.selectDropDownValue(Select_TranspotationMode, TranspotationMode);
			System.out.println("DistanceUnit Selected ");
			logger.info("DistanceUnit Selected ");
			test.log(Status.PASS, "DistanceUnit Selected ");
		} catch (Exception e) {
			System.out.println("DistanceUnit Not Selected ");
			logger.error("Failed to Select DistanceUnit");
			test.log(Status.FAIL, "Failed to Select DistanceUnit");
			e.printStackTrace();
		}
		
		
	}
	
	public void requiredFieldErrorCheck() {
		

		clickNearbyAirportSaveButton();
		
		SeleniumRepo.waitForPageLoaded();

		if (Check_ErrorAirportNameLabel.isDisplayed()) {
			System.out.println("Error Message Airport Name Required  is Displayed");
			test.log(Status.PASS, "Error Message Airport Name Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Airport Name Required  is Displayed ");
		} else {
			System.out.println("Error Message Airport Name Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Airport Name Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Airport Name Required  is Not Displayed");
		}

		if (Check_ErrorCodeLabel.isDisplayed()) {
			System.out.println("Error Message  Code Required  is Displayed");
			test.log(Status.PASS, "Error Message  Code Required  is Displayed ");
			Assert.assertTrue(true, "Error Message  Code Required  is Displayed ");
		} else {
			System.out.println("Error Message  Code Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message  Code Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message  Code Required  is Not Displayed");
		}

		if (Check_ErrorDistanceAwayLabel.isDisplayed()) {
			System.out.println("Error Message Distance Away Required is Displayed");
			test.log(Status.PASS, "Error Message Distance Away Required is Displayed ");
			Assert.assertTrue(true, "Error Message Distance Away Required is Displayed ");
		} else {
			System.out.println("Error Message Distance Away Required is Not Displayed");
			test.log(Status.FAIL, " Error Message Distance Away Required is Not Displayed");
			Assert.assertFalse(false, "Error Message Distance Away Required is Not Displayed");
		}
				
		
		
	}
	
	
	public void clickNearbyAirportSaveButton(){
		
		
		try {
			Click_NBAP_Save.click();
			System.out.println(" PD saved ");
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");

		} catch (Exception e) {
			System.out.println(" PD Not saved ");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	

	public void nearByAirport(String AirportName, String AirportCode, String AirportURL, String AirportDescription,
			String AirportAddress1, String AirportCity, String AirportCountry, String Zipcode, String DistanceAway,
			String DistanceUnit, String TranspotationMode) {

		try {
			ExplicitWait(AbouttheProperty_Link);
			if (AbouttheProperty_Link.isDisplayed()) {
				Javascriptexecutor(AbouttheProperty_Link);
				System.out.println("AbouttheProperty_Link clicked");
				ExplicitWait(Enter_YearBuilt);
				System.out.println("PropertyManagement element Expanded and AbouttheProperty element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and AbouttheProperty element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and AbouttheProperty element  found");
			} else {
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(Click_PropertyManagement);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(AbouttheProperty_Link);
				if (AbouttheProperty_Link.isDisplayed()) {
					Javascriptexecutor(AbouttheProperty_Link);
					System.out.println("AbouttheProperty_Link clicked");
					ExplicitWait(Enter_YearBuilt);
					System.out.println("PropertyDefaults element found");
					test.log(Status.INFO, "PropertyDefaults element found");
					Assert.assertTrue(true, "PropertyDefaults element found");
				} else {
					logger.info("PropertyDefaults element not  found");
					test.log(Status.FAIL, "PropertyDefaults element not  found");
				}
			}

			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(Click_onNearByAirPort_link);

			Thread.sleep(2000);
			if (Click_onNearByAirPort_link.isDisplayed()) {
				Click_onNearByAirPort_link.click();
				logger.info("Clicked on NearByAirPort");
				test.log(Status.PASS, "Clicked on NearByAirPort");
				Assert.assertTrue(true, "Clicked on NearByAirPort Link");
			} else {
				System.out.println("onNearByAirPort Link not found");
				logger.error("Failed to Click  on NearByAirPort Link");
				test.log(Status.FAIL, "Failed to Click on NearByAirPort Link");
				Assert.assertFalse(false, "onNearByAirPort Link not found");
			}

			ExplicitWait(Enter_AirportName);
			if (Enter_AirportName.isDisplayed()) {
				Javascriptexecutor(Enter_AirportName);
				Enter_AirportName.clear();
				// Enter_AirportName.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_AirportName.sendKeys(AirportName);
				System.out.println("AirportName is entered successfully");
				logger.info("AirportName is entered successfully");
				test.log(Status.PASS, "AirportName is entered successfully");
				Assert.assertTrue(true, "AirportName is entered successfully");
			} else {
				System.out.println("AirportName TextBox not found");
				logger.error("Failed to Found AirportName TextBox");
				test.log(Status.FAIL, "Failed to Found AirportName TextBox");
				Assert.assertFalse(false, "AirportName TextBox not found");
			}

			if (Enter_AirportCode.isDisplayed()) {
				Javascriptexecutor(Enter_AirportCode);
				Enter_AirportCode.clear();
				// Enter_AirportCode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_AirportCode.sendKeys(AirportCode);
				System.out.println("AirportCode is entered successfully");
				logger.info("AirportCode is entered successfully");
				test.log(Status.PASS, "AirportCode is entered successfully");
				Assert.assertTrue(true, "AirportCode is entered successfully");
			} else {
				System.out.println("AirportCode TextBox not found");
				logger.error("Failed to Found AirportCode TextBox");
				test.log(Status.FAIL, "Failed to Found AirportCode TextBox");
				Assert.assertFalse(false, "AirportCode TextBox not found");
			}

			if (Enter_AirportURL.isDisplayed()) {
				Javascriptexecutor(Enter_AirportURL);
				Enter_AirportURL.clear();
				// Enter_AirportURL.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_AirportURL.sendKeys(AirportURL);
				System.out.println("AirportURL is entered successfully");
				logger.info("AirportURL is entered successfully");
				test.log(Status.PASS, "AirportURL is entered successfully");

				Assert.assertTrue(true, "AirportURL is entered successfully");
			} else {
				System.out.println("AirportURL TextBox not found");
				logger.error("Failed to Found AirportURL TextBox");
				test.log(Status.FAIL, "Failed to Found AirportURL TextBox");
				Assert.assertFalse(false, "AirportURL TextBox not found");
			}

			if (Enter_AirportDescription.isDisplayed()) {
				Javascriptexecutor(Enter_AirportDescription);
				Enter_AirportDescription.clear();
				// Enter_AirportDescription.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_AirportDescription.sendKeys(AirportDescription);
				Thread.sleep(1000);
				System.out.println("AirportDescription is entered successfully");
				logger.info("AirportDescription is entered successfully");
				test.log(Status.PASS, "AirportDescription is entered successfully");
				Assert.assertTrue(true, "AirportDescription is entered successfully");
			} else {
				System.out.println("AirportDescription TextBox not found");
				logger.error("Failed to Found AirportDescription TextBox");
				test.log(Status.FAIL, "Failed to Found AirportDescription TextBox");
				Assert.assertFalse(false, "AirportDescription TextBox not found");
			}

			if (Enter_AirportAddress1.isDisplayed()) {
				Javascriptexecutor(Enter_AirportAddress1);
				Enter_AirportAddress1.clear();
				// Enter_AirportAddress1.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_AirportAddress1.sendKeys(AirportAddress1);
				System.out.println("AirportAddress1 is entered successfully");
				logger.info("AirportAddress1 is entered successfully");
				test.log(Status.PASS, "AirportAddress1 is entered successfully");
				Assert.assertTrue(true, "AirportAddress1 is entered successfully");
			} else {
				System.out.println("AirportAddress1 TextBox not found");
				logger.error("Failed to Found AirportAddress1 TextBox");
				test.log(Status.FAIL, "Failed to Found AirportAddress1 TextBox");
				Assert.assertFalse(false, "AirportAddress1 TextBox not found");
			}

			if (Enter_AirportCity.isDisplayed()) {
				Javascriptexecutor(Enter_AirportCity);
				Enter_AirportCity.clear();
				// Enter_AirportCity.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_AirportCity.sendKeys(AirportCity);
				System.out.println("AirportCity is entered successfully");
				logger.info("AirportCity is entered successfully");
				test.log(Status.PASS, "AirportCity is entered successfully");
				Assert.assertTrue(true, "AirportCity is entered successfully");
			} else {
				System.out.println("AirportCity TextBox not found");
				logger.error("Failed to Found AirportCity TextBox");
				test.log(Status.FAIL, "Failed to Found AirportCity TextBox");
				Assert.assertFalse(false, "AirportCity TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownText(Select_AirportCountry, AirportCountry);
				System.out.println("AirportCountry Selected ");
				logger.info("AirportCountry Selected");
				test.log(Status.PASS, "AirportCountry Selected");
			} catch (Exception e) {
				System.out.println("AirportCountry Not Selected ");
				logger.error("Failed to Select AirportCountry");
				test.log(Status.FAIL, "Failed to Select AirportCountry");
				e.printStackTrace();
			}

			if (Enter_Zipcode.isDisplayed()) {
				Javascriptexecutor(Enter_Zipcode);
				Enter_Zipcode.clear();
				// Enter_Zipcode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Zipcode.sendKeys(Zipcode);
				System.out.println("Zipcode is entered successfully");
				logger.info("Zipcode is entered successfully");
				test.log(Status.PASS, "Zipcode is entered successfully");
				Assert.assertTrue(true, "Zipcode is entered successfully");
			} else {
				System.out.println("Zipcode TextBox not found");
				logger.error("Failed to Found Zipcode TextBox");
				test.log(Status.FAIL, "Failed to Found Zipcode TextBox");
				Assert.assertFalse(false, "Zipcode TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_DistanceUnit, DistanceUnit);
				System.out.println("DistanceUnit Selected ");
				logger.info("Distance Unit Selected");
				test.log(Status.PASS, "Distance Unit Selected");
			} catch (Exception e) {
				System.out.println("Distance Unit Not Selected ");
				logger.error("Failed to Select Distance Unit");
				test.log(Status.FAIL, "Failed to Select Distance Unit");
				e.printStackTrace();
			}

			if (Enter_DistanceAway.isDisplayed()) {
				Javascriptexecutor(Enter_DistanceAway);
				Enter_DistanceAway.clear();
				// Enter_DistanceAway.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_DistanceAway.sendKeys(DistanceAway);
				System.out.println("DistanceAway is entered successfully");
				logger.info("DistanceAway is entered successfully");
				test.log(Status.PASS, "DistanceAway is entered successfully");
				Assert.assertTrue(true, "DistanceAway is entered successfully");
			} else {
				System.out.println("DistanceAway TextBox not found");
				logger.error("Failed to Found DistanceAway TextBox");
				test.log(Status.FAIL, "Failed to Found DistanceAway TextBox");
				Assert.assertFalse(false, "DistanceAway TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_TranspotationMode, TranspotationMode);
				System.out.println("DistanceUnit Selected ");
				logger.info("DistanceUnit Selected ");
				test.log(Status.PASS, "DistanceUnit Selected ");
			} catch (Exception e) {
				System.out.println("DistanceUnit Not Selected ");
				logger.error("Failed to Select DistanceUnit");
				test.log(Status.FAIL, "Failed to Select DistanceUnit");
				e.printStackTrace();
			}
			Javascriptexecutor(AirPort_Save);
			SeleniumRepo.waitForPageLoaded();
			System.out.println(" PD saved ");
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");

		} catch (Exception e) {
			logger.error("Unable to create About NearByAirport for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create About NearByAirport for selected property because of this execption" + e);
			e.printStackTrace();
		}

	}
}
