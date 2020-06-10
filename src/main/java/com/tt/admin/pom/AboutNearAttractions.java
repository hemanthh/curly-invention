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

public class AboutNearAttractions extends AboutTheProperty {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();
	
	
	
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Attraction Name Required')]"), })
    private WebElement Check_ErrorAttractionNameLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Code Required')]"), })
    private WebElement Check_ErrorCodeLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Distance Away Required')]"), })
    private WebElement Check_ErrorDistanceAwayLabel;
    

	@FindAll({ @FindBy(xpath = "//a[starts-with(., 'About')]"), })
	private WebElement AbouttheProperty_Link;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Nearby Attractions*')]/following-sibling::td/a"), })
	private WebElement Click_NearbyAttractions_link;

	@FindAll({ @FindBy(xpath = "//input[@name='attractionName']"), })
	private WebElement Enter_NBA_Name;

	@FindAll({ @FindBy(xpath = "//input[@name='code']"), })
	private WebElement Enter_NBA_Code;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedTypeValue']"), })
	private WebElement Select_NBA_Type;

	@FindAll({ @FindBy(xpath = "//input[@name='url']"), })
	private WebElement Enter_NBA_URL;

	@FindAll({ @FindBy(xpath = "//textarea[@name='description']"), })
	private WebElement Enter_NBA_Description;

	@FindAll({ @FindBy(xpath = "//input[@name='address1']"), })
	private WebElement Enter_NBA_Address1;

	@FindAll({ @FindBy(xpath = "//input[@name='city']"), })
	private WebElement Enter_NBA_City;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedCountry']"), })
	private WebElement Select_NBA_Country;

	@FindAll({ @FindBy(xpath = "//input[@name='zipCode']"), })
	private WebElement Enter_NBA_Zipcode;

	@FindAll({ @FindBy(xpath = "//input[@name='distanceAway']"), })
	private WebElement Enter_NBA_DistanceAway;

	@FindAll({ @FindBy(xpath = "//select[@id='selectedUnit']"), })
	private WebElement Select_DistanceUnit;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedTranspotationMethod']"), })
	private WebElement Select_TranspotationMode;

	@FindAll({ @FindBy(xpath = "//*[@id='saveBtn']/input[@value='Save']"), })
	private WebElement Click_NBA_Save;
	
	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"), })
	private WebElement Click_NBA_Cancel;
	

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })

	private WebElement Click_PropertyManagement;

	
	
	
	
	
	public void editAttractionName(String NBA_Name) {
		
		if (Enter_NBA_Name.isDisplayed()) {
			Enter_NBA_Name.click();
			Enter_NBA_Name.clear();
			// Enter_NBA_Name.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_Name.sendKeys(NBA_Name);
			System.out.println("NBA_Name is entered successfully");
			logger.info("NBA_Name is entered successfully");
			test.log(Status.PASS, "NBA_Name is entered successfully");
			Assert.assertTrue(true, "NBA_Name is entered successfully");
		} else {
			System.out.println("NBA_Name TextBox not found");
			logger.error("Failed to Found  NBA_Name TextBox");
			test.log(Status.FAIL, "Failed to Found  NBA_Name TextBox");
			Assert.assertFalse(false, "NBA_Name TextBox not found");
		}

		
		
	}

	public void editAttractionCode(String NBA_Code) {
		
		if (Enter_NBA_Code.isDisplayed()) {
			Enter_NBA_Code.click();
			Enter_NBA_Code.clear();
			// Enter_NBA_Code.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_Code.sendKeys(NBA_Code);
			System.out.println("NBA_Code is entered successfully");
			logger.info("NBA_Code is entered successfully");
			test.log(Status.PASS, "NBA_Code is entered successfully");
			Assert.assertTrue(true, "NBA_Code is entered successfully");
		} else {
			System.out.println("NBA_Code TextBox not found");
			logger.error("Failed to Found NBA_Code TextBox");
			test.log(Status.FAIL, "Failed to Found NBA_Code TextBox");
			Assert.assertFalse(false, "NBA_Code TextBox not found");
		}
		
	}

	public void editAttractionType(String NBA_Type) {
		
		try {
			
			Select_NBA_Type.click();
			
			SeleniumRepoDropdown.selectDropDownValue(Select_NBA_Type, NBA_Type);
			System.out.println("NBA_Type Selected ");
			logger.info("NBA_Type Selected");
			test.log(Status.PASS, "NBA_Type Selected");

			Assert.assertTrue(true, "NBA_Type Selected");
		} catch (Exception e) {
			System.out.println("NBA_Type Not Selected ");
			logger.error("Failed to Select NBA_Type");
			test.log(Status.FAIL, "Failed to Select NBA_Type");
			Assert.assertFalse(false, "Failed to Select NBA_Type");
			e.printStackTrace();
		}
		
		
		
	}

	public void editAttractionUrl(String NBA_URL) {
		
		
		if (Enter_NBA_URL.isDisplayed()) {
			Enter_NBA_URL.click();
			Enter_NBA_URL.clear();
			// Enter_NBA_URL.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_URL.sendKeys(NBA_URL);
			System.out.println("NBA_URL is entered successfully");
			logger.info("NBA_URL is entered successfully");
			test.log(Status.PASS, "NBA_URL is entered successfully");
			Assert.assertTrue(true, "NBA_URL is entered successfully");
		} else {
			System.out.println("NBA_URL TextBox not found");
			logger.error("Failed to Found NBA_URL TextBox");
			test.log(Status.FAIL, "Failed to Found NBA_URL TextBox");
			Assert.assertFalse(false, "NBA_URL TextBox not found");
		}
		
	}

	public void editAttractionDescription(String NBA_Description) throws InterruptedException {
		
		
		if (Enter_NBA_Description.isDisplayed()) {
			Enter_NBA_Description.click();
			Enter_NBA_Description.clear();
			// Enter_NBA_Description.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_Description.sendKeys(NBA_Description);
			
			Thread.sleep(1000);
			System.out.println("NBA_Description is entered successfully");
			logger.info("NBA_Description is entered successfully");
			test.log(Status.PASS, "NBA_Description is entered successfully");
			Assert.assertTrue(true, "NBA_Description is entered successfully");
		} else {
			System.out.println("NBA_Description TextBox not found");
			logger.error("Failed to Found NBA_Description TextBox ");
			test.log(Status.FAIL, "Failed to Found NBA_Description TextBox");
			Assert.assertFalse(false, "NBA_Description TextBox not found");
		}


		
		
	}

	public void editAttractionAddress(String NBA_Address1) {
		
		
		if (Enter_NBA_Address1.isDisplayed()) {
			Enter_NBA_Address1.click();
			Enter_NBA_Address1.clear();
			// Enter_NBA_Address1.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_Address1.sendKeys(NBA_Address1);
			System.out.println("NBA_Address1 is entered successfully");
			logger.info("NBA_Address1 is entered successfully");
			test.log(Status.PASS, "NBA_Address1 is entered successfully");
			Assert.assertTrue(true, "NBA_Address1 is entered successfully");
		} else {
			System.out.println("NBA_Address1 TextBox not found");
			logger.error("Failed to Found NBA_Address1 TextBox");
			test.log(Status.FAIL, "Failed  to Found NBA_Address1 TextBox");
			Assert.assertFalse(false, "NBA_Address1 TextBox not found");
		}

		
		
	}

	public void editAttractionCity(String NBA_City) {
		
		
		if (Enter_NBA_City.isDisplayed()) {
			Enter_NBA_City.click();
			Enter_NBA_City.clear();
			// Enter_NBA_City.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_City.sendKeys(NBA_City);
			System.out.println("NBA_City is entered successfully");
			logger.info("NBA_City is entered successfully");
			test.log(Status.PASS, "NBA_City is entered successfully");

			Assert.assertTrue(true, "NBA_City is entered successfully");
		} else {
			System.out.println("NBA_City TextBox not found");
			logger.error("Failed to Found NBA_City TextBox ");
			test.log(Status.FAIL, "Failed to Found NBA_City TextBox");
			Assert.assertFalse(false, "NBA_City TextBox not found");
		}
		
	}

	public void editAttractionCountry(String NBA_Country) {
		
		
		try {
			SeleniumRepoDropdown.selectDropDownText(Select_NBA_Country, NBA_Country);
			System.out.println("NBA_Country Selected ");
			logger.info("NBA_Country Selected");
			test.log(Status.PASS, "NBA_Country Selected");

			Assert.assertTrue(true, "NBA_Country Selected");
		} catch (Exception e) {
			System.out.println("NBA_Country Not Selected ");
			logger.error("Failed to Select NBA_Country ");
			test.log(Status.FAIL, "Failed to Select NBA_Countrys");
			e.printStackTrace();
		}

		
		
	}

	public void editAttractionZipCode(String NBA_Zipcode) {
		
		
		if (Enter_NBA_Zipcode.isDisplayed()) {
			Enter_NBA_Zipcode.click();
			Enter_NBA_Zipcode.clear();
			// Enter_NBA_Zipcode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_Zipcode.sendKeys(NBA_Zipcode);
			System.out.println("NBA_Zipcode is entered successfully");
			logger.info("NBA_Zipcode is entered successfully");
			test.log(Status.PASS, "NBA_Zipcode is entered successfully");

			Assert.assertTrue(true, "NBA_Zipcode is entered successfully");
		} else {
			System.out.println("NBA_Zipcode TextBox not found");
			logger.error("Failed to Found NBA_Zipcode TextBox");
			test.log(Status.FAIL, "Failed to Found NBA_Zipcode TextBox");
			Assert.assertFalse(false, "NBA_Zipcode TextBox not found");
		}
		
	}

	public void editAttractionDistanceAway(String NBA_DistanceAway,  String DistanceUnit) {
		
		if (Enter_NBA_DistanceAway.isDisplayed()) {
			Enter_NBA_DistanceAway.click();
			Enter_NBA_DistanceAway.clear();
			// Enter_NBA_DistanceAway.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_NBA_DistanceAway.sendKeys(NBA_DistanceAway);
			System.out.println("NBA_DistanceAway is entered successfully");
			logger.info("NBA_DistanceAway is entered successfully");
			test.log(Status.PASS, "NBA_DistanceAway is entered successfully");
			Assert.assertTrue(true, "NBA_DistanceAway is entered successfully");
		} else {
			System.out.println("NBA_DistanceAway TextBox not found");
			logger.error("Failed to Found NBA_DistanceAway TextBox");
			test.log(Status.FAIL, "Failed to Found NBA_DistanceAway TextBox");
			Assert.assertFalse(false, "NBA_DistanceAway TextBox not found");
		}
		
		
		try {
			SeleniumRepoDropdown.selectDropDownValue(Select_DistanceUnit, DistanceUnit);
			System.out.println("DistanceUnit Selected ");
			logger.info("DistanceUnit Selected");
			test.log(Status.PASS, "DistanceUnit Selected");
		} catch (Exception e) {
			System.out.println("DistanceUnit Not Selected ");
			logger.error("Failed to Select DistanceUnit ");
			test.log(Status.FAIL, "Failed to Select DistanceUnit");
			e.printStackTrace();
		}
		
	}

	public void editAttractionTransportaionMethod(String TranspotationMode) {
		
		
		
		try {
			SeleniumRepoDropdown.selectDropDownValue(Select_TranspotationMode, TranspotationMode);
			System.out.println("TranspotationMode  Selected ");
			logger.info("TranspotationMode  Selected");
			test.log(Status.PASS, "TranspotationMode  Selected");
		} catch (Exception e) {
			System.out.println("TranspotationMode Not Selected ");
			logger.error("Failed to Select TranspotationMode");
			test.log(Status.FAIL, "Failed to Select TranspotationMode");
			e.printStackTrace();
		}
		
		
	}


	
	
	public void requiredFieldErrorCheck() {

		clickNearbyAttractionSaveButton();
		
		SeleniumRepo.waitForPageLoaded();

		if (Check_ErrorAttractionNameLabel.isDisplayed()) {
			System.out.println("Error Message Attraction Name Required  is Displayed");
			test.log(Status.PASS, "Error Message Attraction Name Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Attraction Name Required  is Displayed ");
		} else {
			System.out.println("Error Message Attraction Name Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Attraction Name Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Attraction Name Required  is Not Displayed");
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

	
	public void clickNearbyAttractionSaveButton() {
		
		try {
			Click_NBA_Save.click();
			SeleniumRepo.waitForPageLoaded();

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
	
	
	
	/**
	 * Original automated method that is used populate, the About the Property page
	 * Nearby Attraction Add page
	 * 
	 * 
	 * @param NBA_Name
	 * @param NBA_Code
	 * @param NBA_Type
	 * @param NBA_URL
	 * @param NBA_Description
	 * @param NBA_Address1
	 * @param NBA_City
	 * @param NBA_Zipcode
	 * @param NBA_Country
	 * @param NBA_DistanceAway
	 * @param DistanceUnit
	 * @param TranspotationMode
	 */
	public void nearByAttraction(String NBA_Name, String NBA_Code, String NBA_Type, String NBA_URL,
			String NBA_Description, String NBA_Address1, String NBA_City, String NBA_Zipcode, String NBA_Country,
			String NBA_DistanceAway, String DistanceUnit, String TranspotationMode) {

		try {

			if (AbouttheProperty_Link.isDisplayed()) {
				Javascriptexecutor(AbouttheProperty_Link);
				System.out.println("AbouttheProperty_Link clicked");
				ExplicitWait(Click_NearbyAttractions_link);
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
					ExplicitWait(Click_NearbyAttractions_link);
					System.out.println("PropertyDefaults element found");
					test.log(Status.INFO, "PropertyDefaults element found");
					Assert.assertTrue(true, "PropertyDefaults element found");
				} else {
					logger.info("PropertyDefaults element not  found");
					test.log(Status.FAIL, "PropertyDefaults element not  found");
				}
			}

			Thread.sleep(2000);
			try {
				Click_NearbyAttractions_link.click();
			} catch (Exception e) {
				Click_NearbyAttractions_link.click();
			}

			logger.info("Clicked on NearbyAttractions Link");
			test.log(Status.PASS, "Clicked on NearbyAttractions Link");

			Assert.assertTrue(true, "Clicked on NearbyAttractions Link");

			ExplicitWait(Enter_NBA_Name);
			
			if (Enter_NBA_Name.isDisplayed()) {
				Enter_NBA_Name.click();
				Enter_NBA_Name.clear();
				// Enter_NBA_Name.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_Name.sendKeys(NBA_Name);
				System.out.println("NBA_Name is entered successfully");
				logger.info("NBA_Name is entered successfully");
				test.log(Status.PASS, "NBA_Name is entered successfully");
				Assert.assertTrue(true, "NBA_Name is entered successfully");
			} else {
				System.out.println("NBA_Name TextBox not found");
				logger.error("Failed to Found  NBA_Name TextBox");
				test.log(Status.FAIL, "Failed to Found  NBA_Name TextBox");
				Assert.assertFalse(false, "NBA_Name TextBox not found");
			}

			if (Enter_NBA_Code.isDisplayed()) {
				Enter_NBA_Code.click();
				Enter_NBA_Code.clear();
				// Enter_NBA_Code.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_Code.sendKeys(NBA_Code);
				System.out.println("NBA_Code is entered successfully");
				logger.info("NBA_Code is entered successfully");
				test.log(Status.PASS, "NBA_Code is entered successfully");
				Assert.assertTrue(true, "NBA_Code is entered successfully");
			} else {
				System.out.println("NBA_Code TextBox not found");
				logger.error("Failed to Found NBA_Code TextBox");
				test.log(Status.FAIL, "Failed to Found NBA_Code TextBox");
				Assert.assertFalse(false, "NBA_Code TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_NBA_Type, NBA_Type);
				System.out.println("NBA_Type Selected ");
				logger.info("NBA_Type Selected");
				test.log(Status.PASS, "NBA_Type Selected");

				Assert.assertTrue(true, "NBA_Type Selected");
			} catch (Exception e) {
				System.out.println("NBA_Type Not Selected ");
				logger.error("Failed to Select NBA_Type");
				test.log(Status.FAIL, "Failed to Select NBA_Type");
				Assert.assertFalse(false, "Failed to Select NBA_Type");
				e.printStackTrace();
			}

			if (Enter_NBA_URL.isDisplayed()) {
				Enter_NBA_URL.click();
				Enter_NBA_URL.clear();
				// Enter_NBA_URL.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_URL.sendKeys(NBA_URL);
				System.out.println("NBA_URL is entered successfully");
				logger.info("NBA_URL is entered successfully");
				test.log(Status.PASS, "NBA_URL is entered successfully");
				Assert.assertTrue(true, "NBA_URL is entered successfully");
			} else {
				System.out.println("NBA_URL TextBox not found");
				logger.error("Failed to Found NBA_URL TextBox");
				test.log(Status.FAIL, "Failed to Found NBA_URL TextBox");
				Assert.assertFalse(false, "NBA_URL TextBox not found");
			}

			if (Enter_NBA_Description.isDisplayed()) {
				Enter_NBA_Description.click();
				Enter_NBA_Description.clear();
				// Enter_NBA_Description.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_Description.sendKeys(NBA_Description);
				Thread.sleep(1000);
				System.out.println("NBA_Description is entered successfully");
				logger.info("NBA_Description is entered successfully");
				test.log(Status.PASS, "NBA_Description is entered successfully");
				Assert.assertTrue(true, "NBA_Description is entered successfully");
			} else {
				System.out.println("NBA_Description TextBox not found");
				logger.error("Failed to Found NBA_Description TextBox ");
				test.log(Status.FAIL, "Failed to Found NBA_Description TextBox");
				Assert.assertFalse(false, "NBA_Description TextBox not found");
			}

			if (Enter_NBA_Address1.isDisplayed()) {
				Enter_NBA_Address1.click();
				Enter_NBA_Address1.clear();
				// Enter_NBA_Address1.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_Address1.sendKeys(NBA_Address1);
				System.out.println("NBA_Address1 is entered successfully");
				logger.info("NBA_Address1 is entered successfully");
				test.log(Status.PASS, "NBA_Address1 is entered successfully");
				Assert.assertTrue(true, "NBA_Address1 is entered successfully");
			} else {
				System.out.println("NBA_Address1 TextBox not found");
				logger.error("Failed to Found NBA_Address1 TextBox");
				test.log(Status.FAIL, "Failed  to Found NBA_Address1 TextBox");
				Assert.assertFalse(false, "NBA_Address1 TextBox not found");
			}

			if (Enter_NBA_City.isDisplayed()) {
				Enter_NBA_City.click();
				Enter_NBA_City.clear();
				// Enter_NBA_City.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_City.sendKeys(NBA_City);
				System.out.println("NBA_City is entered successfully");
				logger.info("NBA_City is entered successfully");
				test.log(Status.PASS, "NBA_City is entered successfully");

				Assert.assertTrue(true, "NBA_City is entered successfully");
			} else {
				System.out.println("NBA_City TextBox not found");
				logger.error("Failed to Found NBA_City TextBox ");
				test.log(Status.FAIL, "Failed to Found NBA_City TextBox");
				Assert.assertFalse(false, "NBA_City TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownText(Select_NBA_Country, NBA_Country);
				System.out.println("NBA_Country Selected ");
				logger.info("NBA_Country Selected");
				test.log(Status.PASS, "NBA_Country Selected");

				Assert.assertTrue(true, "NBA_Country Selected");
			} catch (Exception e) {
				System.out.println("NBA_Country Not Selected ");
				logger.error("Failed to Select NBA_Country ");
				test.log(Status.FAIL, "Failed to Select NBA_Countrys");
				e.printStackTrace();
			}

			if (Enter_NBA_Zipcode.isDisplayed()) {
				Enter_NBA_Zipcode.click();
				Enter_NBA_Zipcode.clear();
				// Enter_NBA_Zipcode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_Zipcode.sendKeys(NBA_Zipcode);
				System.out.println("NBA_Zipcode is entered successfully");
				logger.info("NBA_Zipcode is entered successfully");
				test.log(Status.PASS, "NBA_Zipcode is entered successfully");

				Assert.assertTrue(true, "NBA_Zipcode is entered successfully");
			} else {
				System.out.println("NBA_Zipcode TextBox not found");
				logger.error("Failed to Found NBA_Zipcode TextBox");
				test.log(Status.FAIL, "Failed to Found NBA_Zipcode TextBox");
				Assert.assertFalse(false, "NBA_Zipcode TextBox not found");
			}

			if (Enter_NBA_DistanceAway.isDisplayed()) {
				Enter_NBA_DistanceAway.click();
				Enter_NBA_DistanceAway.clear();
				// Enter_NBA_DistanceAway.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_NBA_DistanceAway.sendKeys(NBA_DistanceAway);
				System.out.println("NBA_DistanceAway is entered successfully");
				logger.info("NBA_DistanceAway is entered successfully");
				test.log(Status.PASS, "NBA_DistanceAway is entered successfully");
				Assert.assertTrue(true, "NBA_DistanceAway is entered successfully");
			} else {
				System.out.println("NBA_DistanceAway TextBox not found");
				logger.error("Failed to Found NBA_DistanceAway TextBox");
				test.log(Status.FAIL, "Failed to Found NBA_DistanceAway TextBox");
				Assert.assertFalse(false, "NBA_DistanceAway TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_DistanceUnit, DistanceUnit);
				System.out.println("DistanceUnit Selected ");
				logger.info("DistanceUnit Selected");
				test.log(Status.PASS, "DistanceUnit Selected");
			} catch (Exception e) {
				System.out.println("DistanceUnit Not Selected ");
				logger.error("Failed to Select DistanceUnit ");
				test.log(Status.FAIL, "Failed to Select DistanceUnit");
				e.printStackTrace();
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_TranspotationMode, TranspotationMode);
				System.out.println("TranspotationMode  Selected ");
				logger.info("TranspotationMode  Selected");
				test.log(Status.PASS, "TranspotationMode  Selected");
			} catch (Exception e) {
				System.out.println("TranspotationMode Not Selected ");
				logger.error("Failed to Select TranspotationMode");
				test.log(Status.FAIL, "Failed to Select TranspotationMode");
				e.printStackTrace();
			}
			try {
				Click_NBA_Save.click();
				
				SeleniumRepo.waitForPageLoaded();
				
				System.out.println(" PD saved ");
				logger.info("Clicked on Save button");
				test.log(Status.PASS, "Clicked on Save button");

			} catch (Exception e) {
				System.out.println(" PD Not saved ");
				logger.error("Failed to Click on Save button");
				test.log(Status.FAIL, "Failed to Click on Save button");
				e.printStackTrace();
			}

		} catch (Exception e) {
			logger.error("Unable to create Near By Attraction for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create Near By Attraction for selected property because of this execption" + e);
			e.printStackTrace();
		}

	}
}
