package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class NearByAttraction extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	// List all page

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"), })
	private WebElement property_Management;

	@FindAll({ @FindBy(xpath = "//a[contains(.,'Nearby')]"), })
	private WebElement Click_NearByAttractionLink;

	@FindAll({ @FindBy(xpath = "//input[@value='Add New']"), })
	private WebElement Click_NearBy_AddNew;

	@FindAll({ @FindBy(xpath = "//input[@type='checkbox']"), })
	private List<WebElement> All_NearbyAttractions_Checkbox;

	@FindAll({ @FindBy(xpath = "//*[@class='prompt'][2]"), })
	private List<WebElement> All_NearbyAttractions_Name;

	@FindAll({ @FindBy(xpath = "//*[@class='prompt']/a[contains(text(),'Edit')]"), })
	private List<WebElement> All_NearbyAttractions_Edit;

	@FindAll({ @FindBy(xpath = "//*[@class='prompt']/a[contains(text(),'Copy')]"), })
	private List<WebElement> All_NearbyAttractions_Copy;

	@FindAll({ @FindBy(xpath = "//input[@name='btnDelete']"), })
	private WebElement Click_NearBy_Delete;

	@FindAll({ @FindBy(xpath = "//*[text()='Are you sure you want to delete the following Nearby Attraction(s)?']"), })
	private WebElement NearByAttractions_DeletePg_Question;

	@FindAll({ @FindBy(xpath = "//input[@value='Yes']"), })
	private WebElement NearByAttractions_DeletePg_YesButton;

	@FindAll({ @FindBy(xpath = "//input[@value='No']"), })
	private WebElement NearByAttractions_DeletePg_NoButton;

	// Copy page

	@FindAll({ @FindBy(xpath = "//h1[ contains(., 'Copy NearBy Attraction')]"), })
	public WebElement Verify_CopyNearByAttraction_Title;

	@FindAll({ @FindBy(xpath = "//*[@name='propertyIds']") })
	public WebElement Select_TargetProperty_CopyPg_MultiList;

	@FindAll({ @FindBy(xpath = "//input[@value='Copy']") })
	public WebElement CopyNearByAttraction_Copy_button;

	@FindAll({ @FindBy(xpath = "//input[@value='OK']") })
	public WebElement CopyNearByAttraction_CopyPg_OK_button;
		
	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']") })
	public WebElement CopyNearByAttraction_Cancel_button;

	// Edit page
	
	@FindAll({ @FindBy(xpath = "//input[@name='name' and @size='40']"), })
	private WebElement Enter_NearBy_EnterName;

	@FindAll({ @FindBy(xpath = "//input[@name='category']"), })
	private WebElement Enter_NearBy_Category;

	@FindAll({ @FindBy(xpath = "//textarea[@name='description']"), })
	private WebElement Enter_NearBy_Description;

	// td[contains(text(),'Name:')]/following-sibling::td/input -> List of Image
	// Name
	// td[contains(text(),'Description:')]/following-sibling::td/textarea ->
	// list of image descrtion text area
	// td[contains(text(),'Alt text')]/following-sibling::td/textarea -> list of
	// image alt text
	// td[contains(text(),'Return Order:')]/following-sibling::td/input -> list
	// of image order
	// td[contains(text(),'Choose image:')]/following-sibling::td/input

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Name:')]/following-sibling::td/a"), })
	private List<WebElement> All_NearbyAttractions_Image_Close;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Name:')]/following-sibling::td/input"), })
	private List<WebElement> All_NearbyAttractions_Image_Name;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Description:')]/following-sibling::td/textarea"), })
	private List<WebElement> All_NearbyAttractions_Image_Desc;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Alt text')]/following-sibling::td/textarea"), })
	private List<WebElement> All_NearbyAttractions_Image_AltText;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Return Order:')]/following-sibling::td/input"), })
	private List<WebElement> All_NearbyAttractions_Image_RetrunOrder;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Choose image:')]/following-sibling::td/input"), })
	private List<WebElement> All_NearbyAttractions_Image_ChooseImage;

	// do not use and use the above version of nearby image. This version is being used by
	//the original method
	@FindAll({ @FindBy(xpath = "//input[@name= 'tt_img_loader_file_0' and@type = 'file']"), })
	private WebElement Upload_NearBy_Image;
	


	@FindAll({ @FindBy(xpath = "//select[@name='selectedCountry']"), })
	private WebElement Select_NearBy_Country;

	@FindAll({ @FindBy(xpath = "//textarea[@name='address1']"), })
	private WebElement Enter_NearBy_Address;

	@FindAll({ @FindBy(xpath = "//input[@name= 'city']"), })
	private WebElement Enter_NearBy_City;

	@FindAll({ @FindBy(xpath = "//input[@name='zipCode']"), })
	private WebElement Enter_NearBy_ZipCode;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Find Lat/Long')]"), })
	private WebElement Click_NearBy_LatLong;

	@FindAll({ @FindBy(xpath = "//input[@value='Save']"), })
	private WebElement Click_NearBy_Save;

	@FindAll({ @FindBy(xpath = "//input[@name='btnCancel']"), })
	private WebElement Click_NearBy_Cancle;
	
	

	public void navigateToNearbyAttractions_ListAllPg() throws InterruptedException {

		if ((SeleniumRepo.isElementDisplayed(Click_NearByAttractionLink) == false)) {

			Javascriptexecutor(property_Management);
			
			SeleniumRepo.waitForPageLoaded();

			Thread.sleep(3000);

		}

		if (SeleniumRepo.isElementDisplayed(Click_NearByAttractionLink) == true) {

			Javascriptexecutor(Click_NearByAttractionLink);

			SeleniumRepo.waitForPageLoaded();

			test.log(Status.PASS, "Clcik on NearByAttraction Link");
			logger.info("Clcik on NearByAttraction Link successfully");
		}

	}

	
	public void navigateToNearbyAttractions_CopyPg(String nearbyAttractionName) throws InterruptedException {

		String nban = "";

		for (int a = 0; a < All_NearbyAttractions_Name.size(); a++) {

			nban = All_NearbyAttractions_Name.get(a).getText();

			if (nban.equalsIgnoreCase(nearbyAttractionName)) {
				All_NearbyAttractions_Copy.get(a).click();
				
				Thread.sleep(6000);

				SeleniumRepo.waitForPageLoaded();
				
				// Assert page header

				logger.info("");
				test.log(Status.PASS, "");
			}

		}
	}

	
	public void navigateToNearbyAttractions_AddPg() throws InterruptedException {

		if (SeleniumRepo.isElementPresent(Click_NearBy_AddNew)) {
			Click_NearBy_AddNew.click();
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.INFO, "Clcik on NearBy_AddNew Link");
			logger.info("Clcik on NearBy_AddNew Link successfully");
		} else {
			test.log(Status.FAIL, "Failed to Clcik on NearBy_AddNew Link");
			logger.error("Failed to Clcik on NearBy_AddNew Link");
		}

	}


	public void navigateToNearbyAttractions_EditPg(String nearbyAttractionName) throws InterruptedException {

		String nban = "";

		for (int b = 0; b < All_NearbyAttractions_Name.size(); b++) {

			nban = All_NearbyAttractions_Name.get(b).getText();

			if (nban.equalsIgnoreCase(nearbyAttractionName)) {

				All_NearbyAttractions_Edit.get(b).click();
				SeleniumRepo.waitForPageLoaded();

				// Assert page header

				logger.info("");
				test.log(Status.PASS, "");

			}

		}

	}

	
	public void deleteNearbyAttaction(String nearbyAttractionName) throws InterruptedException {

		String nban = "";

		for (int c = 0; c < All_NearbyAttractions_Name.size(); c++) {

			nban = All_NearbyAttractions_Name.get(c).getText();

			if (nban.equalsIgnoreCase(nearbyAttractionName)) {

				All_NearbyAttractions_Checkbox.get(c).click();
				Thread.sleep(2000);

				Click_NearBy_Delete.click();

				SeleniumRepo.waitForPageLoaded();

				//NearByAttractions_DeletePg_NoButton.click();
				NearByAttractions_DeletePg_YesButton.click();

				SeleniumRepo.waitForPageLoaded();

				Assert.assertNotEquals(All_NearbyAttractions_Name.get(c-1).getText(), nearbyAttractionName);

				logger.info("Nearby Attraction " + nearbyAttractionName + " was deleted successfully");
				test.log(Status.PASS, "Nearby Attraction " + nearbyAttractionName + " was deleted successfully");

			}

		}
	}

	public void deleteAllNearbyAttractions() throws InterruptedException {

		if (!(All_NearbyAttractions_Checkbox.isEmpty())) {
			for (int d = 0; d < All_NearbyAttractions_Checkbox.size(); d++) {
				Javascriptexecutor(All_NearbyAttractions_Checkbox.get(d));
				Thread.sleep(2000);
			}
			// WebElement Meeting=
			// SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'meetingRoom')and@value='Delete']"));

			Javascriptexecutor(Click_NearBy_Delete);
			SeleniumRepo.waitForPageLoaded();

			//NearByAttractions_DeletePg_NoButton.click();
			NearByAttractions_DeletePg_YesButton.click();

			SeleniumRepo.waitForPageLoaded();

			System.out.println("All Nearby Attraction  deleted successfully");
		} else {
			System.out.println("There are no Nearby Attraction rooms");
		}

	}

	public void propertyCopyNearByAttractionSelection(String currenciesItems) {

		try {
			String[] differentCurrencies = currenciesItems.split("[;]");

			Select_TargetProperty_CopyPg_MultiList.click();
			SeleniumRepoDropdown.selectMultiListbox(Select_TargetProperty_CopyPg_MultiList, differentCurrencies);

			CopyNearByAttraction_Copy_button.click();
			
			SeleniumRepo.waitForPageLoaded();

			//After clicking the copying button, the page  takes a while to load
			Thread.sleep(6000);

			CopyNearByAttraction_CopyPg_OK_button.click();
			
			Thread.sleep(6000);

			SeleniumRepo.waitForPageLoaded();


			System.out.println("Target Property was selected successfully");

			logger.info("Target Properties was selected successfully");
			test.log(Status.PASS, "Target Properties was selected successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void editNearByAttractionName(String NearByAttractionName) {

		SeleniumRepo.waitForElementPresent(Enter_NearBy_EnterName);
		if (Enter_NearBy_EnterName.isDisplayed()) {
			Enter_NearBy_EnterName.click();
			Enter_NearBy_EnterName.clear();
			Enter_NearBy_EnterName.sendKeys(NearByAttractionName);
			test.log(Status.INFO, "Enter_NearBy_Name");
			logger.info("Enter_NearBy_Name successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter_NearBy_Name");
			logger.error("Failed to Enter_NearBy_Name");
		}

	}

	
	public void editNearByAttractionCategory(String NearByAttractionCategory) {

		SeleniumRepo.waitForElementPresent(Enter_NearBy_Category);
		if (Enter_NearBy_Category.isDisplayed()) {
			Enter_NearBy_Category.click();
			Enter_NearBy_Category.clear();
			Enter_NearBy_Category.sendKeys(NearByAttractionCategory);
			test.log(Status.INFO, "Enter_NearBy_Category)");
			logger.info("Enter_NearBy_Category) successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter_NearBy_Category)");
			logger.error("Failed to Enter_NearBy_Category)");
		}

	}

	
	public void editNearByAttractionDescription(String NearByAttractionDescription) {

		SeleniumRepo.waitForElementPresent(Enter_NearBy_Description);
		if (Enter_NearBy_Description.isDisplayed()) {
			Enter_NearBy_Description.click();
			Enter_NearBy_Description.clear();
			Enter_NearBy_Description.sendKeys(NearByAttractionDescription);
			test.log(Status.INFO, "Enter_NearBy_Description)");
			logger.info("Enter_NearBy_Description successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter_NearBy_Description)");
			logger.error("Failed to Enter_NearBy_Description)");
		}

	}

	public void editNearByAttraction_ImgName(String nearByAttImgName, String imagePosition) {

		int imagePos = Integer.parseInt(imagePosition);

		if (imagePos > All_NearbyAttractions_Image_Name.size()) {
			// image does not exsists
			System.out.println("Image Does Not exsists ");
			test.log(Status.INFO, "Entered Near By Attraction Image Not Found");
			logger.info("Entered Near By Attraction Image Name NOT FOUND");

		} else {

			if (All_NearbyAttractions_Image_Name.get(imagePos).isDisplayed()) {
				All_NearbyAttractions_Image_Name.get(imagePos).click();
				All_NearbyAttractions_Image_Name.get(imagePos).clear();
				All_NearbyAttractions_Image_Name.get(imagePos).sendKeys(nearByAttImgName);

				test.log(Status.INFO, "Entered Near By Attraction Image Name");
				logger.info("Entered Near By Attraction Image Name successfully");
			} else {
				test.log(Status.FAIL, "Failed to Entere Near By Attraction Image Name)");
				logger.error("Failed to Enterec Near By Attraction Image Name )");
			}

		}

	}

	
	public void editNearByAttraction_ImgDescription(String nearByAttImgDes, String imagePosition) {

		int imagePos = Integer.parseInt(imagePosition);

		if (imagePos > All_NearbyAttractions_Image_Desc.size()) {
			// image does not exsists
			
			System.out.println("Image Does Not exsists ");
			test.log(Status.INFO, "Entered Near By Attraction Image Not Found");
			logger.info("Entered Near By Attraction Image Name NOT FOUND");

		} else {

			if (All_NearbyAttractions_Image_Desc.get(imagePos).isDisplayed()) {
				All_NearbyAttractions_Image_Desc.get(imagePos).click();
				All_NearbyAttractions_Image_Desc.get(imagePos).clear();
				All_NearbyAttractions_Image_Desc.get(imagePos).sendKeys(nearByAttImgDes);

				test.log(Status.INFO, "Entered Near By Attraction Image Description");
				logger.info("Entered Near By Attraction Image Description successfully");
			} else {
				test.log(Status.FAIL, "Failed to Entere Near By Attraction Image Description)");
				logger.error("Failed to Enterec Near By Attraction Image Description )");
			}

		}

	}

	public void editNearByAttraction_ImgAltText(String nearByAttImgAltTxt, String imagePosition) {

		int imagePos = Integer.parseInt(imagePosition);

		if (imagePos > All_NearbyAttractions_Image_AltText.size()) {
			// image does not exsists
			System.out.println("Image Does Not exsists ");
			test.log(Status.INFO, "Entered Near By Attraction Image Not Found");
			logger.info("Entered Near By Attraction Image Name NOT FOUND");

		} else {

			if (All_NearbyAttractions_Image_AltText.get(imagePos).isDisplayed()) {
				All_NearbyAttractions_Image_AltText.get(imagePos).click();
				All_NearbyAttractions_Image_AltText.get(imagePos).clear();
				All_NearbyAttractions_Image_AltText.get(imagePos).sendKeys(nearByAttImgAltTxt);

				test.log(Status.INFO, "Entered Near By Attraction Image Alt Text");
				logger.info("Entered Near By Attraction Image Alt Text successfully");
			} else {
				test.log(Status.FAIL, "Failed to Entere Near By Attraction Image Alt Text )");
				logger.error("Failed to Enterec Near By Attraction Image Alt Text )");
			}

		}

	}

	public void editNearByAttraction_ImgReturnOrder(String nearByAttImgRtnOde, String imagePosition) {

		int imagePos = Integer.parseInt(imagePosition);

		if (imagePos > All_NearbyAttractions_Image_RetrunOrder.size()) {
			// image does not exsists
			System.out.println("Image Does Not exsists ");
			test.log(Status.INFO, "Entered Near By Attraction Image Not Found");
			logger.info("Entered Near By Attraction Image Name NOT FOUND");

		} else {

			if (All_NearbyAttractions_Image_RetrunOrder.get(imagePos).isDisplayed()) {
				All_NearbyAttractions_Image_RetrunOrder.get(imagePos).click();
				All_NearbyAttractions_Image_RetrunOrder.get(imagePos).clear();
				All_NearbyAttractions_Image_RetrunOrder.get(imagePos).sendKeys(nearByAttImgRtnOde);

				test.log(Status.INFO, "Entered Near By Attraction Image Return Order");
				logger.info("Entered Near By Attraction Image Return Order successfully");
			} else {
				test.log(Status.FAIL, "Failed to Entere Near By Attraction Image Return Order )");
				logger.error("Failed to Enterec Near By Attraction Image Return Order )");
			}

		}

	}

	public void editNearByAttraction_ImgChooseimage(String nearByAttImgChooseImagePath, String imagePosition) {

		int imagePos = Integer.parseInt(imagePosition);

		if (imagePos > All_NearbyAttractions_Image_RetrunOrder.size()) {
			// image does not exsists
			System.out.println("Image Does Not exsists ");
			test.log(Status.INFO, "Entered Near By Attraction Image Not Found");
			logger.info("Entered Near By Attraction Image Name NOT FOUND");
			
		} else {

			SeleniumRepo.waitForElementPresent(All_NearbyAttractions_Image_ChooseImage.get(imagePos));

			System.out.println("--->>>> " + System.getProperty("user.dir") + nearByAttImgChooseImagePath);

			if (SeleniumRepo.isElementDisplayed( All_NearbyAttractions_Image_ChooseImage.get(imagePos) ) )  {
				
				//Upload_NearBy_Image
				
				All_NearbyAttractions_Image_ChooseImage.get(imagePos).sendKeys(System.getProperty("user.dir") + nearByAttImgChooseImagePath);
				test.log(Status.INFO, "Room Image Path is entered successfully");
				logger.info("Room Image Path is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Image Path");
				logger.error("Failed to Enter Room Image Path");
			}

		}

	}

	public void editNearByAttractionCountry(String NearByAttactCountry) {

		SeleniumRepo.waitForElementPresent(Select_NearBy_Country);
		if (Select_NearBy_Country.isDisplayed()) {
			SeleniumRepoDropdown.selectDropDownText(Select_NearBy_Country, NearByAttactCountry);
			test.log(Status.INFO, "Select Country");
			logger.info("Country is Select successfully");
		} else {
			test.log(Status.FAIL, "Failed to Select Country");
			logger.error("Failed to  Select Country");
		}

	}

	public void editNearByAttractionAddress1(String NearByAttactAddress) {

		SeleniumRepo.waitForElementPresent(Enter_NearBy_Address);
		if (Enter_NearBy_Address.isDisplayed()) {
			Enter_NearBy_Address.click();
			Enter_NearBy_Address.clear();
			Enter_NearBy_Address.sendKeys(NearByAttactAddress);
			test.log(Status.INFO, "Enter_NearBy_Address)");
			logger.info("Enter_NearBy_Address successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter_NearBy_Address)");
			logger.error("Failed to Enter_NearBy_Address)");
		}

	}

	public void editNearByAttractionCity(String NearByAttacCity) {

		SeleniumRepo.waitForElementPresent(Enter_NearBy_City);
		if (Enter_NearBy_City.isDisplayed()) {
			Enter_NearBy_City.click();
			Enter_NearBy_City.clear();
			Enter_NearBy_City.sendKeys(NearByAttacCity);
			test.log(Status.INFO, "Enter_NearBy_City)");
			logger.info("Enter_NearBy_City successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter_NearBy_City)");
			logger.error("Failed to Enter_NearBy_City)");
		}

	}

	public void editNearByAttractionZipCode(String NearByAttacZipCode) {

		SeleniumRepo.waitForElementPresent(Enter_NearBy_ZipCode);
		if (Enter_NearBy_ZipCode.isDisplayed()) {
			Enter_NearBy_ZipCode.click();
			Enter_NearBy_ZipCode.clear();
			Enter_NearBy_ZipCode.sendKeys(NearByAttacZipCode);
			test.log(Status.INFO, "Enter_NearBy_ZipCode)");
			logger.info("Enter_NearBy_ZipCode successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter_NearBy_ZipCode)");
			logger.error("Failed to Enter_NearBy_ZipCode)");
		}

	}

	public void editNearByAttractionLatLongitude() throws InterruptedException {

		if (Click_NearBy_LatLong.isEnabled()) {
			Click_NearBy_LatLong.click();
			Thread.sleep(4000);
			test.log(Status.INFO, "Clcik on NearBy_LatLong Link");
			logger.info("Clcik on NearBy_LatLong Link successfully");
		} else {
			test.log(Status.FAIL, "Failed to Clcik on NearBy_LatLong Link");
			logger.error("Failed to Clcik on NearBy_LatLong Link");
		}

	}
	
	public void saveNearByAttractionButton() {

		SeleniumRepo.waitForElementPresent(Click_NearBy_Save);
		if (SeleniumRepo.isElementPresent(Click_NearBy_Save)) {
			Click_NearBy_Save.click();
			test.log(Status.INFO, "Clcik on NearBy_Save Link");
			logger.info("Clcik on NearBy_Save Link successfully");
		} else {
			test.log(Status.FAIL, "Failed to Clcik on NearBy_Save Link");
			logger.error("Failed to Clcik on NearBy_Save Link");
		}

	}
	
	
	
	public void cancleNearByAttractionButton() {

		SeleniumRepo.waitForElementPresent(Click_NearBy_Cancle);
		if (SeleniumRepo.isElementPresent(Click_NearBy_Cancle)) {
			Click_NearBy_Cancle.click();
			test.log(Status.INFO, "Clcik on NearBy_Cancle Link");
			logger.info("Clcik on NearBy_Cancle Link successfully");
		} else {
			test.log(Status.FAIL, "Failed to Clcik on NearBy_Cancle Link");
			logger.error("Failed to Clcik on NearBy_Cancle Link");
		}

	}

	/**
	 *  Original Nearby Attraction creation method 
	 *  
	 * @param EnterName
	 * @param NearBy_Category
	 * @param NearBy_Description
	 * @param roomImagePath
	 * @param Country
	 * @param NearBy_Address
	 * @param NearBy_City
	 * @param NearBy_ZipCode
	 */
	public void createNearByAttraction(String EnterName, String NearBy_Category, String NearBy_Description,
			String roomImagePath, String Country, String NearBy_Address, String NearBy_City, String NearBy_ZipCode) {

		try {
			SeleniumRepo.waitForElementPresent(Click_NearByAttractionLink);
			if (SeleniumRepo.isElementPresent(Click_NearByAttractionLink)) {
				Click_NearByAttractionLink.click();
				test.log(Status.PASS, "Clcik on NearByAttraction Link");
				logger.info("Clcik on NearByAttraction Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearByAttraction Link");
				logger.error("Failed to Clcik on NearByAttraction Link");
			}

			SeleniumRepo.waitForElementPresent(Click_NearBy_AddNew);
			if (SeleniumRepo.isElementPresent(Click_NearBy_AddNew)) {
				Click_NearBy_AddNew.click();
				test.log(Status.INFO, "Clcik on NearBy_AddNew Link");
				logger.info("Clcik on NearBy_AddNew Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearBy_AddNew Link");
				logger.error("Failed to Clcik on NearBy_AddNew Link");
			}

			SeleniumRepo.waitForElementPresent(Enter_NearBy_EnterName);
			if (Enter_NearBy_EnterName.isDisplayed()) {
				Enter_NearBy_EnterName.click();
				Enter_NearBy_EnterName.clear();
				Enter_NearBy_EnterName.sendKeys(EnterName);
				test.log(Status.INFO, "Enter_NearBy_Name");
				logger.info("Enter_NearBy_Name successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Name");
				logger.error("Failed to Enter_NearBy_Name");
			}

			SeleniumRepo.waitForElementPresent(Enter_NearBy_Category);
			if (Enter_NearBy_Category.isDisplayed()) {
				Enter_NearBy_Category.click();
				Enter_NearBy_Category.clear();
				Enter_NearBy_Category.sendKeys(NearBy_Category);
				test.log(Status.INFO, "Enter_NearBy_Category)");
				logger.info("Enter_NearBy_Category) successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Category)");
				logger.error("Failed to Enter_NearBy_Category)");
			}

			SeleniumRepo.waitForElementPresent(Enter_NearBy_Description);
			if (Enter_NearBy_Description.isDisplayed()) {
				Enter_NearBy_Description.click();
				Enter_NearBy_Description.clear();
				Enter_NearBy_Description.sendKeys(NearBy_Description);
				test.log(Status.INFO, "Enter_NearBy_Description)");
				logger.info("Enter_NearBy_Description successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Description)");
				logger.error("Failed to Enter_NearBy_Description)");
			}

			SeleniumRepo.waitForElementPresent(Upload_NearBy_Image);
			if (SeleniumRepo.isElementPresent(Upload_NearBy_Image)) {
				Upload_NearBy_Image.sendKeys(System.getProperty("user.dir") + roomImagePath);
				test.log(Status.INFO, "Room Image Path is entered successfully");
				logger.info("Room Image Path is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Image Path");
				logger.error("Failed to Enter Room Image Path");
			}

			SeleniumRepo.waitForElementPresent(Select_NearBy_Country);
			if (Select_NearBy_Country.isDisplayed()) {
				SeleniumRepoDropdown.selectDropDownText(Select_NearBy_Country, Country);
				test.log(Status.INFO, "Select Country");
				logger.info("Country is Select successfully");
			} else {
				test.log(Status.FAIL, "Failed to Select Country");
				logger.error("Failed to  Select Country");
			}

			SeleniumRepo.waitForElementPresent(Enter_NearBy_Address);
			if (Enter_NearBy_Address.isDisplayed()) {
				Enter_NearBy_Address.click();
				Enter_NearBy_Address.clear();
				Enter_NearBy_Address.sendKeys(NearBy_Address);
				test.log(Status.INFO, "Enter_NearBy_Address)");
				logger.info("Enter_NearBy_Address successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Address)");
				logger.error("Failed to Enter_NearBy_Address)");
			}

			SeleniumRepo.waitForElementPresent(Enter_NearBy_City);
			if (Enter_NearBy_City.isDisplayed()) {
				Enter_NearBy_City.click();
				Enter_NearBy_City.clear();
				Enter_NearBy_City.sendKeys(NearBy_City);
				test.log(Status.INFO, "Enter_NearBy_City)");
				logger.info("Enter_NearBy_City successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_City)");
				logger.error("Failed to Enter_NearBy_City)");
			}

			SeleniumRepo.waitForElementPresent(Enter_NearBy_ZipCode);
			if (Enter_NearBy_ZipCode.isDisplayed()) {
				Enter_NearBy_ZipCode.click();
				Enter_NearBy_ZipCode.clear();
				Enter_NearBy_ZipCode.sendKeys(NearBy_ZipCode);
				test.log(Status.INFO, "Enter_NearBy_ZipCode)");
				logger.info("Enter_NearBy_ZipCode successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_ZipCode)");
				logger.error("Failed to Enter_NearBy_ZipCode)");
			}

			// SeleniumRepo.waitForElementPresent(Click_NearBy_LatLong);
			if (Click_NearBy_LatLong.isEnabled()) {
				Click_NearBy_LatLong.click();
				SeleniumRepo.waitForPageLoaded();
				test.log(Status.INFO, "Clcik on NearBy_LatLong Link");
				logger.info("Clcik on NearBy_LatLong Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearBy_LatLong Link");
				logger.error("Failed to Clcik on NearBy_LatLong Link");
			}

			SeleniumRepo.waitForElementPresent(Click_NearBy_Save);
			if (SeleniumRepo.isElementPresent(Click_NearBy_Save)) {
				Click_NearBy_Save.click();
				test.log(Status.INFO, "Clcik on NearBy_Save Link");
				logger.info("Clcik on NearBy_Save Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearBy_Save Link");
				logger.error("Failed to Clcik on NearBy_LatLong Link");
			}

		} catch (Exception e) {
			logger.error("Unable to create NearBy Attraction for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create NearBy Attraction  for selected property because of this execption" + e);
			e.printStackTrace();
		}

	}
}