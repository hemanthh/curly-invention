package com.tt.admin.pom;

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
import com.tt.utility.SeleniumRepoDropdown;

public class AboutPDining extends AboutTheProperty {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Restaurant Name Required')]"), })
    private WebElement Check_ErrorRestaurantNameLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Code Required')]"), })
    private WebElement Check_ErrorCodeLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Distance Away Required')]"), })
    private WebElement Check_ErrorDistanceAwayLabel;
	
	@FindAll({ @FindBy(xpath = "//a[starts-with(., 'About')]"), })
	public WebElement AbouttheProperty_Link;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),' Dining*')]/following-sibling::td/a"), })
	public WebElement Click_Dininglink;

	@FindAll({ @FindBy(xpath = "//input[@name='restaurantName']"), })
	public WebElement Enter_Restaurant_Name;

	@FindAll({ @FindBy(xpath = "//input[@name='code']"), })
	public WebElement Enter_Code;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedProximityValue']"), })
	public WebElement Select_Proximity;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedCuisineValue']"), })
	public WebElement Select_Cuisine;

	@FindAll({ @FindBy(xpath = "//textarea[@name='description']"), })
	public WebElement Enter_Description;

	@FindAll({ @FindBy(xpath = "//input[@name='address1']"), })
	public WebElement Enter_Address1;

	@FindAll({ @FindBy(xpath = "//input[@name='city']"), })
	public WebElement Enter_City;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedCountry']"), })
	public WebElement Select_Country;

	@FindAll({ @FindBy(xpath = "//input[@name='zipCode']"), })
	public WebElement Enter_Zipcode;

	@FindAll({ @FindBy(xpath = "//select[@id='selectedUnit'][@name='selectedUnit']"), })
	public WebElement Select_Distance_Away;

	@FindAll({ @FindBy(xpath = "//input[@name='distanceAway']"), })
	public WebElement Enter_Distance;

	@FindAll({ @FindBy(xpath = "//*[@id='saveBtn']/input[@value='Save']"), })
	public WebElement PDsave;

	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"), })
	private WebElement Click_NBA_Cancel;
	
	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })

	public WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(xpath = "//input[@name='builtYear']"), })

	public WebElement Enter_YearBuilt;
	
	
	
	public void editDiningName(String RestaurantName){
		
		
		if (Enter_Restaurant_Name.isDisplayed()) {
			Javascriptexecutor(Enter_Restaurant_Name);
			Enter_Restaurant_Name.clear();
			// Enter_Restaurant_Name.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Restaurant_Name.sendKeys(RestaurantName);
			System.out.println("RestaurantName is entered successfully");
			logger.info("RestaurantName is entered successfully");
			test.log(Status.PASS, "RestaurantName is entered successfully");
			Assert.assertTrue(true, "RestaurantName is entered successfully");
		} else {
			System.out.println("RestaurantName TextBox not found");
			logger.error("Failed to Found RestaurantName");
			test.log(Status.FAIL, "Failed to Found RestaurantName");
			Assert.assertFalse(false, "RestaurantName TextBox not found");
		}
		
	}
	
	public void editAirportCode(String Code){

		
		if (Enter_Code.isDisplayed()) {
			Javascriptexecutor(Enter_Code);
			Enter_Code.clear();
			// Enter_Code.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Code.sendKeys(Code);
			System.out.println("Code is entered successfully");
			logger.info("Code is entered successfully");
			test.log(Status.PASS, "Code is entered successfully");
			Assert.assertTrue(true, "Code is entered successfully");
		} else {
			System.out.println("Code TextBox not found");
			logger.error("Failed to Found Code TextBox");
			test.log(Status.FAIL, "Failed to Found Code TextBox");
			Assert.assertFalse(false, "Code TextBox not found");
		}


		
	}
	
	public void editDiningProximity(String Proximity){
		

		try {
			Select_Proximity.click();
			
			SeleniumRepoDropdown.selectDropDownValue(Select_Proximity, Proximity);
			System.out.println("Proximity Selected ");
			logger.info("Proximity is Selected");
			test.log(Status.PASS, "Proximity is Selected");
		} catch (Exception e) {
			System.out.println("Proximity Not Selected ");
			logger.error("Failed to Select Proximity");
			test.log(Status.FAIL, "Failed to Select Proximity");

			e.printStackTrace();
		}


		
	}
	
	
	
	public void editDiningCuisine(String Cuisine){
		
		
		try {
			
			Select_Cuisine.click();
			SeleniumRepoDropdown.selectDropDownValue(Select_Cuisine, Cuisine);
			Thread.sleep(1000);

			System.out.println("Cuisine Selected ");
			logger.info("Cuisine Selected");
			test.log(Status.PASS, "Cuisine Selected");
		} catch (Exception e) {
			System.out.println("Cuisine Not Selected ");
			logger.error("Failed to Select Cuisine");
			test.log(Status.FAIL, "Failed to Select Cuisine");
			e.printStackTrace();
		}
		
		

		
	}
	

	
	
	
	public void editDiningDescription(String Description ) throws InterruptedException{
		
		

		if (Enter_Description.isDisplayed()) {
			Javascriptexecutor(Enter_Description);
			Enter_Description.clear();
			// Enter_Description.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Description.sendKeys(Description);
			Thread.sleep(1000);
			System.out.println("Descriptionis entered successfully");
			test.log(Status.INFO, "Description is entered successfully");
			Assert.assertTrue(true, "Description is entered successfully");
		} else {
			System.out.println("Description TextBox not found");
			test.log(Status.FAIL, "Description TextBox not found");
			Assert.assertFalse(false, "Description TextBox not found");
		}

		
	}
	
	public void editDiningAddress(String Address1){
		

		if (Enter_Address1.isDisplayed()) {
			Javascriptexecutor(Enter_Address1);
			Enter_Address1.clear();
			// Enter_Address1.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Address1.sendKeys(Address1);
			System.out.println("Address1 entered successfully");
			logger.info("Address1 entered successfully");
			test.log(Status.PASS, "Address1 entered successfully");
			Assert.assertTrue(true, "Address1is entered successfully");
		} else {
			System.out.println("Address1 TextBox not found");
			logger.error("Failed to Found Address1 TextBox");
			test.log(Status.FAIL, "Failed to Found Address1 TextBox");
			Assert.assertFalse(false, "Address1 TextBox not found");
		}


		
	}
	
	public void editDiningCity(String City) {
		
		

		if (Enter_City.isDisplayed()) {
			Javascriptexecutor(Enter_City);
			Enter_City.clear();
			// Enter_City
			// .sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_City.sendKeys(City);
			System.out.println("City entered successfully");
			logger.info("City entered successfully");
			test.log(Status.PASS, "City entered successfully");
			Assert.assertTrue(true, "City is entered successfully");
		} else {
			System.out.println("City TextBox not found");
			logger.error("Failed to Found City TextBox");
			test.log(Status.FAIL, "Failed to Found City TextBox");

			Assert.assertFalse(false, "City TextBox not found");
		}

	
	}
	
	public void editDiningCountry(String Country){
		
		try {
			SeleniumRepoDropdown.selectDropDownText(Select_Country, Country);
			System.out.println("Country Selected ");
			logger.info("Country Selected");
			test.log(Status.PASS, "Country Selected");
		} catch (Exception e) {
			System.out.println("Country Not Selected ");
			logger.error("Failed to Select Country");
			test.log(Status.FAIL, "Failed to Select Country");
			e.printStackTrace();
		}


	}
	
	public void editDiningZipCode(String Zipcode){
		
		if (Enter_Zipcode.isDisplayed()) {
			Javascriptexecutor(Enter_Zipcode);
			Enter_Zipcode.clear();
			// Enter_Zipcode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Zipcode.sendKeys(Zipcode);
			System.out.println("Zipcode entered successfully");
			logger.info("Zipcode entered successfully");
			test.log(Status.PASS, "Zipcode entered successfully");
			Assert.assertTrue(true, "Zipcode is entered successfully");
		} else {
			System.out.println("Zipcode TextBox not found");
			logger.error("Failed to Found Zipcode  TextBox");
			test.log(Status.FAIL, "Failed to Found Zipcode  TextBox");
			Assert.assertFalse(false, "Zipcode TextBox not found");
		}


		
	}
	
	public void editDiningDistanceAway(String Distance, String Distance_Away) {
		
		
		if (Enter_Distance.isDisplayed()) {
			Javascriptexecutor(Enter_Distance);
			Enter_Distance.clear();
			Enter_Distance.sendKeys(Distance);

			System.out.println("Distance entered successfully");
			logger.info("Distance entered successfully");
			test.log(Status.PASS, "Distance entered successfully");
			Assert.assertTrue(true, "Distance is entered successfully");
		} else {
			System.out.println("Distance  TextBox not found");
			logger.error("Failed to Found Distance TextBox");
			test.log(Status.FAIL, "Failed to Found Distance TextBox");
			Assert.assertFalse(false, "Distance  TextBox not found");
		}

		
		
		try {
			
			Select_Distance_Away.click();
			
			SeleniumRepoDropdown.selectDropDownValue(Select_Distance_Away, Distance_Away);
			System.out.println("Distance_Away Selected ");
			logger.info("Distance_Away Selected");
			test.log(Status.PASS, "Distance_Away Selected");
		} catch (Exception e) {
			System.out.println("Distance_Away Not Selected ");
			logger.error("Failed to Select Distance_Away");
			test.log(Status.FAIL, "Failed to Select Distance_Away");
			e.printStackTrace();
		}



		
	}
	

	
	public void requiredFieldErrorCheck() {
		

		clickDiningSaveButton();
		
		SeleniumRepo.waitForPageLoaded();

		if (Check_ErrorRestaurantNameLabel.isDisplayed()) {
			System.out.println("Error Message Dining Name Required  is Displayed");
			test.log(Status.PASS, "Error Message Dining Name Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Dining Name Required  is Displayed ");
		} else {
			System.out.println("Error Message Dining Name Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Dining Name Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Dining Name Required  is Not Displayed");
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
	
	
	public void clickDiningSaveButton(){
		
		
		try {
			PDsave.click();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void aboutPDining(String RestaurantName, String Code, String Proximity, String Cuisine, String Description,
			String Address1, String City, String Country, String Zipcode, String Distance_Away, String Distance) {

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

			if (SeleniumRepo.isElementDisplayed(Click_Dininglink) == false) {

				ExplicitWait(Click_Dininglink);

			}

			Thread.sleep(2000);
			if (Click_Dininglink.isDisplayed()) {
				Javascriptexecutor(Click_Dininglink);
				logger.info("Clicked on Dining Link");
				test.log(Status.PASS, "Clicked on Dining Link");
			} else {
				test.log(Status.FAIL, "Dining Link not found");
				logger.error("Dining Link not found");
			}

			ExplicitWait(Enter_Restaurant_Name);

			if (Enter_Restaurant_Name.isDisplayed()) {
				Javascriptexecutor(Enter_Restaurant_Name);
				Enter_Restaurant_Name.clear();
				// Enter_Restaurant_Name.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Restaurant_Name.sendKeys(RestaurantName);
				System.out.println("RestaurantName is entered successfully");
				logger.info("RestaurantName is entered successfully");
				test.log(Status.PASS, "RestaurantName is entered successfully");
				Assert.assertTrue(true, "RestaurantName is entered successfully");
			} else {
				System.out.println("RestaurantName TextBox not found");
				logger.error("Failed to Found RestaurantName");
				test.log(Status.FAIL, "Failed to Found RestaurantName");
				Assert.assertFalse(false, "RestaurantName TextBox not found");
			}

			if (Enter_Code.isDisplayed()) {
				Javascriptexecutor(Enter_Code);
				Enter_Code.clear();
				// Enter_Code.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Code.sendKeys(Code);
				System.out.println("Code is entered successfully");
				logger.info("Code is entered successfully");
				test.log(Status.PASS, "Code is entered successfully");
				Assert.assertTrue(true, "Code is entered successfully");
			} else {
				System.out.println("Code TextBox not found");
				logger.error("Failed to Found Code TextBox");
				test.log(Status.FAIL, "Failed to Found Code TextBox");
				Assert.assertFalse(false, "Code TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_Proximity, Proximity);
				System.out.println("Proximity Selected ");
				logger.info("Proximity is Selected");
				test.log(Status.PASS, "Proximity is Selected");
			} catch (Exception e) {
				System.out.println("Proximity Not Selected ");
				logger.error("Failed to Select Proximity");
				test.log(Status.FAIL, "Failed to Select Proximity");

				e.printStackTrace();
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_Cuisine, Cuisine);
				System.out.println("Cuisine Selected ");
				logger.info("Cuisine Selected");
				test.log(Status.PASS, "Cuisine Selected");
			} catch (Exception e) {
				System.out.println("Cuisine Not Selected ");
				logger.error("Failed to Select Cuisine");
				test.log(Status.FAIL, "Failed to Select Cuisine");
				e.printStackTrace();
			}
			Thread.sleep(1000);
			if (Enter_Description.isDisplayed()) {
				Javascriptexecutor(Enter_Description);
				Enter_Description.clear();
				// Enter_Description.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Description.sendKeys(Description);
				Thread.sleep(1000);
				System.out.println("Descriptionis entered successfully");
				test.log(Status.INFO, "Description is entered successfully");
				Assert.assertTrue(true, "Description is entered successfully");
			} else {
				System.out.println("Description TextBox not found");
				test.log(Status.FAIL, "Description TextBox not found");
				Assert.assertFalse(false, "Description TextBox not found");
			}

			if (Enter_Address1.isDisplayed()) {
				Javascriptexecutor(Enter_Address1);
				Enter_Address1.clear();
				// Enter_Address1.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Address1.sendKeys(Address1);
				System.out.println("Address1 entered successfully");
				logger.info("Address1 entered successfully");
				test.log(Status.PASS, "Address1 entered successfully");
				Assert.assertTrue(true, "Address1is entered successfully");
			} else {
				System.out.println("Address1 TextBox not found");
				logger.error("Failed to Found Address1 TextBox");
				test.log(Status.FAIL, "Failed to Found Address1 TextBox");
				Assert.assertFalse(false, "Address1 TextBox not found");
			}

			if (Enter_City.isDisplayed()) {
				Javascriptexecutor(Enter_City);
				Enter_City.clear();
				// Enter_City
				// .sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_City.sendKeys(City);
				System.out.println("City entered successfully");
				logger.info("City entered successfully");
				test.log(Status.PASS, "City entered successfully");
				Assert.assertTrue(true, "City is entered successfully");
			} else {
				System.out.println("City TextBox not found");
				logger.error("Failed to Found City TextBox");
				test.log(Status.FAIL, "Failed to Found City TextBox");

				Assert.assertFalse(false, "City TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownText(Select_Country, Country);
				System.out.println("Country Selected ");
				logger.info("Country Selected");
				test.log(Status.PASS, "Country Selected");
			} catch (Exception e) {
				System.out.println("Country Not Selected ");
				logger.error("Failed to Select Country");
				test.log(Status.FAIL, "Failed to Select Country");
				e.printStackTrace();
			}

			if (Enter_Zipcode.isDisplayed()) {
				Javascriptexecutor(Enter_Zipcode);
				Enter_Zipcode.clear();
				// Enter_Zipcode.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Zipcode.sendKeys(Zipcode);
				System.out.println("Zipcode entered successfully");
				logger.info("Zipcode entered successfully");
				test.log(Status.PASS, "Zipcode entered successfully");
				Assert.assertTrue(true, "Zipcode is entered successfully");
			} else {
				System.out.println("Zipcode TextBox not found");
				logger.error("Failed to Found Zipcode  TextBox");
				test.log(Status.FAIL, "Failed to Found Zipcode  TextBox");
				Assert.assertFalse(false, "Zipcode TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_Distance_Away, Distance_Away);
				System.out.println("Distance_Away Selected ");
				logger.info("Distance_Away Selected");
				test.log(Status.PASS, "Distance_Away Selected");
			} catch (Exception e) {
				System.out.println("Distance_Away Not Selected ");
				logger.error("Failed to Select Distance_Away");
				test.log(Status.FAIL, "Failed to Select Distance_Away");
				e.printStackTrace();
			}

			if (Enter_Distance.isDisplayed()) {
				Javascriptexecutor(Enter_Distance);
				Enter_Distance.clear();
				Enter_Distance.sendKeys(Distance);

				System.out.println("Distance entered successfully");
				logger.info("Distance entered successfully");
				test.log(Status.PASS, "Distance entered successfully");
				Assert.assertTrue(true, "Distance is entered successfully");
			} else {
				System.out.println("Distance  TextBox not found");
				logger.error("Failed to Found Distance TextBox");
				test.log(Status.FAIL, "Failed to Found Distance TextBox");
				Assert.assertFalse(false, "Distance  TextBox not found");
			}

			PDsave.click();
			SeleniumRepo.waitForPageLoaded();

			System.out.println(" PD saved ");
			SeleniumRepo.waitForPageLoaded();

			// ExplicitWait(Enter_YearBuilt);

			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");

		} catch (Exception e) {
			logger.error("Unable to create About Property Dining for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create About Property Dining for selected property because of this execption" + e);
			e.printStackTrace();
		}

	}
}
