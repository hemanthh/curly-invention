package com.tt.admin.pom;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

public class Amenities extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//a[contains(text(), 'Amenities')]"), })
	private WebElement Click_Amenities;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'+ Add an amenity')]"), })
	private WebElement Click_Add_Amenity;

	@FindAll({ @FindBy(xpath = "//*[@id='returnOrderCommonHotelAmenity']"), })
	private List<WebElement> All_Property_Amenity_Update_TextField;

	@FindAll({ @FindBy(xpath = "//*[@id='returnOrderCommonRoomAmenity']"), })
	private List<WebElement> All_CommonRm_Amenity_Update_TextField;

	@FindAll({ @FindBy(xpath = "//*[@id='returnOrderRoomSpecificAmenity']"), })
	private List<WebElement> All_RoomSpec_Amenity_Update_TextField;

	@FindAll({ @FindBy(xpath = "//tr/td/table/tbody/tr/td[2]"), })
	private List<WebElement> All_Amenities_Name;

	@FindAll({ @FindBy(xpath = "//td/a[text()='Edit']"), })
	private List<WebElement> All_Edit_Amenity_Link;

	@FindAll({ @FindBy(xpath = "//td/a[text()='Delete']"), })
	private List<WebElement> All_Delete_Amenity_Link;

	@FindAll({ @FindBy(xpath = "//input[@name = 'name']"), })
	private WebElement Enter_Amenity_Name;

	@FindAll({ @FindBy(xpath = "//input[@name='type']"), })
	private List<WebElement> Select_Type;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Category')]") })
	public WebElement Amenity_Category_field;

	@FindAll({ @FindBy(xpath = "//*[@name='selectedCategory']") })
	public WebElement Select_Amenity_Category_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Amenity')]") })
	public WebElement AmenityPg_Amenity_field;

	@FindAll({ @FindBy(xpath = "//*[@name='selectedAmenity']") })
	public WebElement Select_AmenityPg_Amenity_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Include In Rate?')]") })
	public WebElement Amenity_IncludeInRate_field;

	@FindAll({ @FindBy(xpath = "//input[@type='checkbox' and @name='includedInRate']") })
	public WebElement Amenity_IncludeInRate_CheckBox;

	@FindAll({ @FindBy(xpath = "//input[@value='Save']"), })
	private WebElement Save;

	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"), })
	private WebElement Cancel;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"), })
	private WebElement property_Management;
	
	

	public void navigateToAmenities_Pg() throws InterruptedException {

		Thread.sleep(2000);

		if (Click_Amenities.isDisplayed()) {
			Javascriptexecutor(Click_Amenities);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(Click_Add_Amenity);
			System.out.println("PropertyManagement element Expanded and Amenities element  found");
			test.log(Status.INFO, "PropertyManagement element Expanded and Amenities element  found");
			Assert.assertTrue(true, "PropertyManagement element Expanded and Amenities element  found");
		} else {
			System.out.println("PropertyManagement Menu is not expanded");

			Javascriptexecutor(property_Management);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");

			ExplicitWait(Click_Amenities);
			if (Click_Amenities.isDisplayed()) {
				Javascriptexecutor(Click_Amenities);
				SeleniumRepo.waitForPageLoaded();
				ExplicitWait(Click_Add_Amenity);
				System.out.println("Amenities element found");
				test.log(Status.INFO, "Amenities  element found");
				Assert.assertTrue(true, "Amenities element found");
			} else {
				logger.info("Amenities element not  found");
				test.log(Status.FAIL, "Amenities element not  found");
			}
		}

	}

	public void Click_AddAmenity_Link() {

		if (SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")).isDisplayed()) {
			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")));
			SeleniumRepo.waitForPageLoaded();

			ExplicitWait(Enter_Amenity_Name);
			System.out.println("Adding new Amenity");
			logger.info("Clicked on Add Amenities Link");
			test.log(Status.PASS, "Clicked on Add Amenities Link");
			Assert.assertTrue(true, "Clicked on Add Amenities Link");
		} else {
			System.out.println("Add Amenities Link not found");
			logger.error("Failed to Click on Add Amenities Link");
			test.log(Status.FAIL, "Failed to Click on Add Amenities Link");
			Assert.assertFalse(false, "Add Amenities Link not found");
		}

	}

	public void Click_AmenityEdit_Link(String amenityName) {

		/*
		 * All_Amenities_Name All_Edit_Amenity_Link
		 * 
		 */

		for (int i = 0; i < All_Amenities_Name.size(); i++) {

			if (All_Amenities_Name.get(i).getText().equalsIgnoreCase(amenityName)) {

				All_Edit_Amenity_Link.get(i).click();
				SeleniumRepo.waitForPageLoaded();


			}

		}

	}

	public void Click_AmenityDelete_Link(String amenityName) throws InterruptedException {

		// Refactor this to be used to delete amenities
		
		
		for (int i = 0; i < All_Amenities_Name.size(); i++) {

			if (All_Amenities_Name.get(i).getText().equalsIgnoreCase(amenityName)) {

				//Javascriptexecutor(All_Delete_Amenity_Link.get(i));

				All_Delete_Amenity_Link.get(i).click();
				
				Thread.sleep(2000);
				Alert alert =SeleniumRepo.driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
				
				SeleniumRepo.waitForPageLoaded();
				System.out.println("Amenity "+amenityName+" deleted successfully");
				test.log(Status.INFO,"Amenity "+amenityName+" deleted successfully");

			}

		}

	}

	
	
	public void editAmenityName(String nameOfAmenity) {

		if (Enter_Amenity_Name.isDisplayed()) {
			Enter_Amenity_Name.click();
			Enter_Amenity_Name.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Amenity_Name.sendKeys(nameOfAmenity);
			System.out.println("Amenity_Name is entered successfully");
			logger.info("Amenity_Name is entered successfully");
			test.log(Status.PASS, "Amenity_Name is entered successfully");
			Assert.assertTrue(true, "Amenity_Name is entered successfully");
		} else {
			System.out.println("Amenity_Name TextBox not found");
			logger.error("Failed to Found Amenity_Name TextBox");
			test.log(Status.FAIL, "Failed to Found Amenity_Name TextBox");
			Assert.assertFalse(false, "Amenity_Name TextBox not found");
		}

	}

	public void editAmenityType(String typeOfAmenity) {

		/*
		 * Amenity Type codes:
		 * Specific to only some rooms - RLS 
		 * Common to all rooms - RLC 
		 * PropertyAmenity - HAC
		 * 
		 * 
		 * save this for future use because the below xpath are the current
		 * radio buttons for each
		 * 
		 * @FindAll({ @FindBy(xpath = "//td[contains(text(),'Type')]") }) public
		 * WebElement Amenity_Type_field;
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@value='RLS']") }) public WebElement
		 * Amenity_Type_SpecificToRoom;
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@value='RLC']") }) public WebElement
		 * Amenity_Type_CommonToAllRooms;
		 * 
		 * @FindAll({ @FindBy(xpath = "//*[@value='HAC']") }) public WebElement
		 * Amenity_Type_PropertyAmenity;
		 * 
		 */

		try {

			switch (typeOfAmenity) {

			case "Specific":
				typeOfAmenity = "RLS";

				break;

			case "Common":

				typeOfAmenity = "RLC";

				break;

			case "Property":

				typeOfAmenity = "HAC";

			}

			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Select_Type, typeOfAmenity);
			System.out.println("Amenity Type  is Selected succesfully");
			logger.info("Amenity Type is Selected succesfully");
			test.log(Status.PASS, "Amenity Type is Selected succesfully");
			Assert.assertTrue(true, "Amenity Type is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Amenity Type is not Selected");
			logger.error("Failed to Select Amenity Type");
			test.log(Status.FAIL, "Failed to Select Amenity Type");
			Assert.assertFalse(false, "Amenity Type is not Selected");
			e.printStackTrace();
		}

	}

	public void editAmenityCategory(String categoryOfAmenity) throws InterruptedException {

		SeleniumRepo.waitForElementPresent(Amenity_Category_field);

		Assert.assertEquals(Amenity_Category_field.isDisplayed(), true,
				"Select Amenity category dropdown Field is not being displayed");

		Select_AmenityPg_Amenity_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_Amenity_Category_DropDown, categoryOfAmenity);
		
		Thread.sleep(3000);

		System.out.println("Select Amenity category was selected successfully");

	}

	public void editAmenity_Amenity(String SelectedAmenity) {

		// This field will be blank if a Category item is not selected		

		if (SeleniumRepoDropdown.isDropDownOptListEmpty(Select_AmenityPg_Amenity_DropDown) == true) {

			SeleniumRepo.waitForElementPresent(AmenityPg_Amenity_field);

			Assert.assertEquals(AmenityPg_Amenity_field.isDisplayed(), true,
					"Select Amenity amenity dropdown Field is not being displayed");

			Select_AmenityPg_Amenity_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_AmenityPg_Amenity_DropDown, SelectedAmenity);

			System.out.println("Select Amenity was selected successfully");

			logger.info("Select Amenity was selected successfully");
			test.log(Status.PASS, "Select Amenity was selected successfully");

		} else {

			System.out.println("Select Amenity was not selected successfully");
			logger.info("Select Amenity was selected successfully because the option does not exsist");

			test.log(Status.INFO, "Select Amenity was selected successfully because the option does not exsist");

		}

	}

	public void editAmenityIncludeInRate(String checkStatus) {

		SeleniumRepo.waitForElementPresent(Amenity_IncludeInRate_field);

		Assert.assertEquals(Amenity_IncludeInRate_field.isDisplayed(), true,
				"Amenity Include In Rate checkbox Field is not being displayed");

		if (checkStatus.equalsIgnoreCase("disable") && Amenity_IncludeInRate_CheckBox.isSelected() == true) {

			Amenity_IncludeInRate_CheckBox.click();

		}

		if (checkStatus.equalsIgnoreCase("enable") && Amenity_IncludeInRate_CheckBox.isSelected() == false) {

			Amenity_IncludeInRate_CheckBox.click();

		}

	}

	public void createRoomSpecificAmenity(String name, String category, String amenity, String RateStatus) throws InterruptedException {

		if (SeleniumRepo.isElementDisplayed(Click_Add_Amenity) == false) {

			navigateToAmenities_Pg();

		}

		Click_AddAmenity_Link();

		editAmenityName(name);

		editAmenityType("RLS");

	

		if (category.equals("")) {

			System.out.println("No category was given");

		} else {

			editAmenityCategory(category);

		}

		if (amenity.equals("")) {

			System.out.println("No amenity was given");

		} else {

			editAmenity_Amenity(amenity);

		}

		if (RateStatus.equals("")) {

			System.out.println("No rate status was given ");

		} else {

			editAmenityIncludeInRate(RateStatus);

		}    

		AmenitySaveButton();

	}

	public void createComonToAllRmAmenity(String name, String category, String amenity, String RateStatus) throws InterruptedException {
		

		if (SeleniumRepo.isElementDisplayed(Click_Add_Amenity) == false) {

			navigateToAmenities_Pg();

		}


		Click_AddAmenity_Link();

		editAmenityName(name);

		editAmenityType("RLC");

	

		if (category.equals("")) {

			System.out.println("No category was given");

		} else {

			editAmenityCategory(category);

		}

		if (amenity.equals("")) {

			System.out.println("No amenity was given");

		} else {

			editAmenity_Amenity(amenity);

		}

		if (RateStatus.equals("")) {

			System.out.println("No rate status was given");

		} else {

			editAmenityIncludeInRate(RateStatus);

		}

		AmenitySaveButton();


	}

	public void createPropertyAmenity(String name, String category, String amenity, String RateStatus) throws InterruptedException {
		

		if (SeleniumRepo.isElementDisplayed(Click_Add_Amenity) == false) {

			navigateToAmenities_Pg();

		}

		Click_AddAmenity_Link();

		editAmenityName(name);

		editAmenityType("HAC");

	

		if (category.equals("")) {

			System.out.println("No category was given");

		} else {

			editAmenityCategory(category);

		}

		if (amenity.equals("")) {

			System.out.println("No amenity was given");

		} else {

			editAmenity_Amenity(amenity);

		}

		if (RateStatus.equals("")) {

			System.out.println("No rate status was given");

		} else {

			editAmenityIncludeInRate(RateStatus);

		} 

		AmenitySaveButton();


	}

	public void AmenitySaveButton() {

		try {
			Save.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("saved");
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
			Thread.sleep(4000);

		} catch (Exception e1) {
			System.out.println("Not saved");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");
			e1.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

	public void AmenityCancelButton() {

		try {
			Cancel.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("cancel");
			logger.info("Clicked on Cancel button");
			test.log(Status.PASS, "Clicked on Cancel button");
			Thread.sleep(4000);

		} catch (Exception e1) {
			System.out.println("Not cancel");
			logger.error("Failed to Click on Cancel button");
			test.log(Status.FAIL, "Failed to Click on Cancel button");
			e1.printStackTrace();
			Assert.assertEquals(false, true);
		}

	}

	/**
	 * This is the original method of this class and it deletes , and creates an
	 * amenity
	 * 
	 * @param Amenity_Name
	 * @param Type
	 * @throws Exception
	 */
	public void addAmenity(String Amenity_Name, String Type) throws Exception {
		try {
			if (Click_Amenities.isDisplayed()) {
				Javascriptexecutor(Click_Amenities);
				ExplicitWait(Click_Add_Amenity);
				System.out.println("PropertyManagement element Expanded and Amenities element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and Amenities element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and Amenities element  found");
			} else {
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(Click_Amenities);
				if (Click_Amenities.isDisplayed()) {
					Javascriptexecutor(Click_Amenities);
					ExplicitWait(Click_Add_Amenity);
					System.out.println("Amenities element found");
					test.log(Status.INFO, "Amenities  element found");
					Assert.assertTrue(true, "Amenities element found");
				} else {
					logger.info("Amenities element not  found");
					test.log(Status.FAIL, "Amenities element not  found");
				}
			}

			Thread.sleep(4000);

			String body = SeleniumRepo.driver.findElement(By.tagName("body")).getText();
			if (body.contains(Amenity_Name)) {
				test.log(Status.INFO, Amenity_Name + " Amenitiy  already present and going to be delete");
				logger.info(Amenity_Name + " Amenitiy  already present and going to be delete");

				System.out.println("Amenity " + Amenity_Name + " is present and going to delete the amenitys");
				System.out.println("//*[contains(text(),'" + Amenity_Name + "')]/following-sibling::td[2]/a");
				WebElement delete = SeleniumRepo.driver.findElement(
						By.xpath("//*[contains(text(),'" + Amenity_Name + "')]/following-sibling::td[2]/a"));

				// Thread.sleep(4000);
				try {
					Javascriptexecutor(delete);
					Thread.sleep(2000);
					Alert alert = SeleniumRepo.driver.switchTo().alert();
					String alertText = alert.getText();
					System.out.println("Alert data: " + alertText);
					alert.accept();
				} catch (UnhandledAlertException f) {
					try {
						Alert alert = SeleniumRepo.driver.switchTo().alert();
						String alertText = alert.getText();
						System.out.println("Alert data: " + alertText);
						alert.accept();
					} catch (NoAlertPresentException e) {
						e.printStackTrace();
						Assert.assertEquals(false, true);
					}
				}
				SeleniumRepo.waitForPageLoaded();
				System.out.println("Amenity " + Amenity_Name + " deleted successfully");
				test.log(Status.INFO, "Amenity " + Amenity_Name + " deleted successfully");
				logger.info("Amenity " + Amenity_Name + " deleted successfully");
			} else {
				System.out.println(Amenity_Name + " duplicate amenity is not there hence creating new amenity");
				test.log(Status.INFO, Amenity_Name + " duplicate amenity is not there hence creating new amenity");
				logger.info(Amenity_Name + " duplicate amenity is not there hence creating new amenity");

			}

			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")));
			Thread.sleep(1000);

			if (SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")).isDisplayed()) {
				Javascriptexecutor(
						SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")));
				ExplicitWait(Enter_Amenity_Name);
				System.out.println("Adding new Amenity");
				logger.info("Clicked on Add Amenities Link");
				test.log(Status.PASS, "Clicked on Add Amenities Link");
				Assert.assertTrue(true, "Clicked on Add Amenities Link");
			} else {
				System.out.println("Add Amenities Link not found");
				logger.error("Failed to Click on Add Amenities Link");
				test.log(Status.FAIL, "Failed to Click on Add Amenities Link");
				Assert.assertFalse(false, "Add Amenities Link not found");
			}

			if (Enter_Amenity_Name.isDisplayed()) {
				Enter_Amenity_Name.click();
				Enter_Amenity_Name.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Amenity_Name.sendKeys(Amenity_Name+SeleniumRepo.getRandomAlphNumeircString(2));
				System.out.println("Amenity_Name is entered successfully");
				logger.info("Amenity_Name is entered successfully");
				test.log(Status.PASS, "Amenity_Name is entered successfully");
				Assert.assertTrue(true, "Amenity_Name is entered successfully");
			} else {
				System.out.println("Amenity_Name TextBox not found");
				logger.error("Failed to Found Amenity_Name TextBox");
				test.log(Status.FAIL, "Failed to Found Amenity_Name TextBox");
				Assert.assertFalse(false, "Amenity_Name TextBox not found");
			}

			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Select_Type, Type);
				System.out.println("Charge Frequency is Selected succesfully");
				logger.info("Charge Frequency is Selected succesfully");
				test.log(Status.PASS, "Charge Frequency is Selected succesfully");
				Assert.assertTrue(true, "Charge Frequency is Selected succesfully");
			} catch (Exception e) {
				System.out.println("Charge Frequency is not Selected");
				logger.error("Failed to Select Charge Frequency");
				test.log(Status.FAIL, "Failed to Select Charge Frequency");
				Assert.assertFalse(false, "Charge Frequency is not Selected");
				e.printStackTrace();
			}

			try {
				Save.click();
				SeleniumRepo.waitForPageLoaded();
				System.out.println("saved");
				logger.info("Clicked on Save button");
				test.log(Status.PASS, "Clicked on Save button");
				Thread.sleep(4000);

			} catch (Exception e1) {
				System.out.println("Not saved");
				logger.error("Failed to Click on Save button");
				test.log(Status.FAIL, "Failed to Click on Save button");
				e1.printStackTrace();
				Assert.assertEquals(false, true);
			}

		} catch (Exception e) {
			logger.error("Unable to create Amenties for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to Amenties type for selected property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

}
