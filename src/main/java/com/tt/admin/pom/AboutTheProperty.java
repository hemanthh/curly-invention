package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class AboutTheProperty extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	private WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(xpath = "//a[starts-with(., 'About')]"), })
	private WebElement AbouttheProperty_Link;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'About the Property')]"), })
	private WebElement AboutthPropertyTitle_Link;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Built Year Required')]"), })
	private WebElement ErrorMessage_Built;

	@FindAll({ @FindBy(xpath = "//input[@name='builtYear']"), })
	private WebElement Enter_YearBuilt;

	@FindAll({ @FindBy(xpath = "//input[@name='renovatedYear']"), })
	private WebElement Enter_YearRenovated;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Property Type')]") })
	public WebElement PropertyType_Field;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedPctValue']") })
	public WebElement Select_AboutProp_PropertyType_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Segment')]") })
	public WebElement Segment_Field;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedSegmentValue']") })
	public WebElement Select_AboutProp_Segment_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Location')]") })
	public WebElement Location_Field;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedLocValue']") })
	public WebElement Select_AboutProp_Location_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'ADA Compliance')]") })
	public WebElement AdaCompliance_field;

	@FindAll({ @FindBy(xpath = "//*[@name='adacompliance']") })
	public WebElement Clicking_AdaCompliance;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Pets Allowed')]") })
	public WebElement PetsAllowed_field;

	@FindAll({ @FindBy(xpath = "//*[@name='petsAllowed']") })
	public WebElement Clicking_PetsAllowed;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'US Fire Safety Compliance')]") })
	public WebElement UsFireSafetyCompliance_field;

	@FindAll({ @FindBy(xpath = "//*[@name='USFireSafetyCompliance']") })
	public WebElement Clicking_UsFireSafetyCompliance;

	@FindAll({ @FindBy(xpath = "//input[@name='save']"), })
	private WebElement Save;
	
	@FindAll({ @FindBy(xpath = "//input[@name='cancel']"), })
	private WebElement Cancel;
	
	@FindAll({ @FindBy(xpath="//*[contains(text(),'Add a Room')]"),})
	protected WebElement Click_AddRoom;

	@FindAll({ @FindBy(xpath="//td[text()='Meeting Rooms']"),})
	protected WebElement Verify_Room_Title;
	

	@FindAll({ @FindBy(xpath="//a[contains(@onclick,'dining') and contains(text(), 'Add Location')]"),})
	protected WebElement Click_AddDininglink;
	
	@FindAll({ @FindBy(xpath="//td[text()='Dining']"),})
	protected WebElement Verify_Dining_Title;
	
	
	@FindAll({ @FindBy(xpath="//a[contains(@onclick,'airport') and contains(text(), 'Add Location')]"), })
	protected WebElement Click_AddNearByAirPort_link;
	
	@FindAll({ @FindBy(xpath="//td[text()='Nearby Airports']"),})
	protected WebElement Verify_NearbyAirports_Title;
	
	
	@FindAll({ @FindBy(xpath="//a[contains(@onclick,'attraction') and contains(text(), 'Add Location')]"), })
	protected WebElement Click_AddNearbyAttractions_link;
	
	@FindAll({ @FindBy(xpath="//td[text()='Nearby Attractions']"),})
	protected WebElement Verify_NearbyAttractions_Title;
	
	
	//table[4]/tbody/tr/td/table//a
	@FindAll({ @FindBy(xpath = "//a[contains(@onclick,'meetingRoom') and not(contains(text(),'Add a Room'))]") })
	protected List<WebElement> MeetingRoom_Name_EditLink;
	
	@FindAll({ @FindBy(xpath = "//*[@name='chkMeetingRoomIds']") })
	protected List<WebElement> MeetingRoom_Delete__CheckBox;

	//table[6]/tbody/tr/td/table//a
	@FindAll({ @FindBy(xpath = "//a[contains(@onclick,'dining') and not(contains(text(), 'Add Location'))]") }) 
	protected List<WebElement> Dining_Name_EditLink;

	@FindAll({ @FindBy(xpath = "//*[@name='chkDiningIds']") })
	protected List<WebElement> Dining_Delete_CheckBox;

	//table[8]/tbody/tr/td/table//a
	@FindAll({ @FindBy(xpath = "//a[contains(@onclick,'airport') and not(contains(text(), 'Add Location'))]") })
	protected List<WebElement> NearByAirport_Name_EditLink;
	
	@FindAll({ @FindBy(xpath = "//*[@name='chkAirportIds']") })
	protected List<WebElement> NearByAirport_Delete_CheckBox;

	//table[10]/tbody/tr/td/table//a
	@FindAll({ @FindBy(xpath = "//a[contains(@onclick,'attraction') and not(contains(text(), 'Add Location'))]") })
	protected List<WebElement> NearByAttractions_Name_EditLink;
	
	@FindAll({ @FindBy(xpath = "//*[@name='chkAttractionIds']") })
	protected List<WebElement> NearByAttractions_Delete_CheckBox;   
	
	
 	@FindAll({ @FindBy(xpath = "//*[contains(@onclick,'meetingRoom')and@value='Delete']") })
	public WebElement MeetingRooms_DeleteButton;
	
	@FindAll({ @FindBy(xpath = "//*[contains(@onclick,'dining')and@value='Delete']") })
    public WebElement DiningLocation_DeleteButton;
    
    @FindAll({ @FindBy(xpath = "//*[contains(@onclick,'airport')and@value='Delete']") })
	public WebElement NearByAirportLocation_DeleteButton;
	
	@FindAll({ @FindBy(xpath = "//*[contains(@onclick,'attraction')and@value='Delete']") })
	public WebElement NearByAttractionsLocation_DeleteButton;
	
	
	
	private ChannelCreation chnlCreation =PageFactory.initElements(SeleniumRepo.driver, ChannelCreation.class);



	/** 
	 NOTES:
	 -> Should reach out to admin developer, requesting to give items in the 
	 four tables  Meeting Rooms, Dining, Airport, and Attactions, unique names
	 or ids to make automation the About Property page better
	 
	 -> Review the below notes to help future testing and verifying 
	 of the items in each table
	 
	 -> if any of the information below becomes useless, please remove it
	 from the note
	 
	//table[4]/tbody/tr  -> captures all rows including the header row 
	//table[4] -> meeting rooms 
	//table[6] -> Dining 
	//table[8] -> nearby airport
	//table[10] -> nearby attraction 
	//table[10]/tbody/tr/td  -> captures values of individual  columns but skip first item
	//table[10]/tbody/tr/th -> table header
	
	 x -> the position of the tables , x should start at 4 and increment by 2 up to 10
	 # ->  has to start at 2
	//table[x]/tbody/tr/td/table//a -> captures the link of a row that allows editing of item 
	//table[x]/tbody/tr[#]/td   -> captures values of individual columns but skip first item also
						
	 */
	
	/**
	 * 
	 * 
	 */
	public void enablingChannelTypeGDS() {
		
		try{
			
		Click_PropertyManagement();
		
		if(SeleniumRepo.isElementDisplayed(AbouttheProperty_Link) == false ){
			
			chnlCreation.createChannel("QASabreHotel", "QAGalileoHotel", "QAWorldspanHotel", "QAAmadeusHotel", "QAADSHotel");
		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	
	public void editAboutPropYearBuilt(String Year_Built) {

		try {

			SeleniumRepo.waitForElementPresent(Enter_YearBuilt);

			if (SeleniumRepo.isElementDisplayed(Enter_YearBuilt) == true) {
				
				Javascriptexecutor(Enter_YearBuilt);
				Enter_YearBuilt.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				
				Enter_YearBuilt.sendKeys(Year_Built);
				
				System.out.println("YearBuilt is entered successfully");
				test.log(Status.PASS, "YearBuilt is entered successfully");
				logger.info("YearBuilt is entered successfully");
				Assert.assertTrue(true, "YearBuilt is entered successfully");
			} else {
				System.out.println("YearBuilt TextBox not found");
				logger.error("Failed to Found YearBuilt TextBox");
				test.log(Status.FAIL, "Failed to Found YearBuilt TextBox");
				Assert.assertFalse(false, "YearBuilt TextBox not found");
			}

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property  Year Built field, for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property  Year Built field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	public void editAboutPropYearRenovated(String Year_Renovated) {

		try {

			if (SeleniumRepo.isElementDisplayed(Enter_YearRenovated) == true) {
				
				Javascriptexecutor(Enter_YearRenovated);
				(Enter_YearRenovated).clear();
				(Enter_YearRenovated).sendKeys(Year_Renovated);
				
				System.out.println("YearRenovated is entered successfully");
				test.log(Status.PASS, "YearRenovatedis entered successfully");
				logger.info("YearRenovatedis entered successfully");
				Assert.assertTrue(true, "YearRenovatedis entered successfully");
				
			} else {
				
				System.out.println("YearRenovated TextBox not found");
				logger.info("Failed YearRenovated TextBox not found");
				test.log(Status.FAIL, "Failed to Found YearRenovated TextBox ");
				Assert.assertFalse(false, "YearRenovated TextBox not found");
			}

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property  Year Renovated	 field, for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property  Year Renovated	 field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	public void editAboutPropType(String dropDownPropertyTypeItem) {

		try {

			SeleniumRepo.waitForElementPresent(PropertyType_Field);

			Assert.assertEquals(PropertyType_Field.isDisplayed(), true, "Property Type Field is not being displayed");

			Select_AboutProp_PropertyType_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_AboutProp_PropertyType_DropDown, dropDownPropertyTypeItem);

			System.out.println("A Language was selected successfully");

			logger.info("A Property Type was selected successfully");
			test.log(Status.PASS, "A Property Type was selected successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property,	Property Type field,  for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property , Property Type field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	public void editAboutPropSegment(String dropDownSegmentItem) {

		try {

			SeleniumRepo.waitForElementPresent(Segment_Field);

			Assert.assertEquals(Segment_Field.isDisplayed(), true, "Segment Field is not being displayed");

			Select_AboutProp_Segment_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_AboutProp_Segment_DropDown, dropDownSegmentItem);

			System.out.println("A Segment was selected successfully");

			logger.info("A Segment was selected successfully");
			test.log(Status.PASS, "A Segment was selected successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property	Segment field, for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property Segment field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	public void editAboutPropLocation(String dropDownLocationItem) {

		try {

			SeleniumRepo.waitForElementPresent(Location_Field);

			Assert.assertEquals(Location_Field.isDisplayed(), true, "Location Field is not being displayed");

			Select_AboutProp_Location_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_AboutProp_Location_DropDown, dropDownLocationItem);

			System.out.println("A Location was selected successfully");

			logger.info("A Location was selected successfully");
			test.log(Status.PASS, "A Location was selected successfully");

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property Location field,  for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property  Location	 field, for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	public void editAboutPropAdaCompliance(String status) {

		try {

			SeleniumRepo.waitForElementPresent(AdaCompliance_field);

			Assert.assertEquals(AdaCompliance_field.isDisplayed(), true, "ADA Compliance Field is not being displayed");

			if (status.equalsIgnoreCase("enable") && Clicking_AdaCompliance.isSelected() == false) {

				Clicking_AdaCompliance.click();

				// Javascriptexecutor(Clicking_AdaCompliance);

				Assert.assertEquals(Clicking_AdaCompliance.isSelected(), true, "ADA Compliance was checked");
			} else if (status.equalsIgnoreCase("disable") && Clicking_AdaCompliance.isSelected()) {

				Clicking_AdaCompliance.click();

				Assert.assertEquals(Clicking_AdaCompliance.isSelected(), false, "ADA Compliance was not unchecked");

			} else {

				System.out.println("Nothing was changed");

			}

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property ADA Compliance field, for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property ADA Compliance field for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	public void editAboutPropPetsAllowed(String status) {

		try {

			SeleniumRepo.waitForElementPresent(PetsAllowed_field);

			Assert.assertEquals(PetsAllowed_field.isDisplayed(), true, "Pets Allowed Field is not being displayed");

			if (status.equalsIgnoreCase("enable") && Clicking_PetsAllowed.isSelected() == false) {

				Clicking_PetsAllowed.click();

				// Javascriptexecutor(Clicking_PetsAllowed);

				Assert.assertEquals(Clicking_PetsAllowed.isSelected(), true, "Pets Allowed was checked");
			} else if (status.equalsIgnoreCase("disable") && Clicking_PetsAllowed.isSelected()) {

				Clicking_PetsAllowed.click();

				Assert.assertEquals(Clicking_PetsAllowed.isSelected(), false, "Pets Allowed was not unchecked");

			} else {

				System.out.println("Nothing was changed");

			}

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property Pets Allowed field for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property Pets Allowed			 field for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	public void editAboutPropUsFireSafety(String status) {

		try {

			SeleniumRepo.waitForElementPresent(UsFireSafetyCompliance_field);

			Assert.assertEquals(UsFireSafetyCompliance_field.isDisplayed(), true,
					"US Fire Safety Compliance Field is not being displayed");

			if (status.equalsIgnoreCase("enable") && Clicking_UsFireSafetyCompliance.isSelected() == false) {

				Clicking_UsFireSafetyCompliance.click();

				// Javascriptexecutor(Clicking_DoNotAdjustInventoryForCancels);

				Assert.assertEquals(Clicking_UsFireSafetyCompliance.isSelected(), true,
						"US Fire Safety Compliance was checked");
			} else if (status.equalsIgnoreCase("disable") && Clicking_UsFireSafetyCompliance.isSelected()) {

				Clicking_UsFireSafetyCompliance.click();

				Assert.assertEquals(Clicking_UsFireSafetyCompliance.isSelected(), false,
						"US Fire Safety Compliance was not unchecked");

			} else {

				System.out.println("Nothing was changed");

			}

		} catch (Exception e) {
			logger.error(
					"Unable to edit About The Property US Fire Safety Compliance field, for selected property because of this execption"
							+ e);
			test.log(Status.ERROR,
					"Unable to edit About The Property US Fire Safety Compliance	 field,  for selected property because of this execption"
							+ e);
			e.printStackTrace();
		}

	}

	
	public void aboutPropertySave() {

		if (Save.isDisplayed()) {
			
			Save.click();
			SeleniumRepo.waitForPageLoaded();

			
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
		} else {
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");
		}
		


	}

	public void aboutPropertyCancel() {

		if (Cancel.isDisplayed()) {
			Cancel.click();
			SeleniumRepo.waitForPageLoaded();
			
			
			navigateToAboutTheProperty_Pg();
			SeleniumRepo.waitForPageLoaded();


			logger.info("Clicked on Cancel button");
			test.log(Status.PASS, "Clicked on cancel button");
		} else {
			logger.error("Failed to Click on cancel button");
			test.log(Status.FAIL, "Failed to Click on cancel button");
		}

	}
	
	
	
	
	private void Click_PropertyManagement()
	{
		if (SeleniumRepo.isElementDisplayed( AbouttheProperty_Link ) == true) 
		{
			
			System.out.println("Property Management element Expanded and About the property element  found");
			test.log(Status.INFO, "Property Management element Expanded and About the property element  found");
			Assert.assertTrue(true, "Property Management element Expanded and About the property element  found");
		} 
		else 
		{
			System.out.println("Property Management Menu is not expanded");
			Javascriptexecutor(Click_PropertyManagement);
			System.out.println("Clicked on Property Management Link");
			test.log(Status.INFO, "Clicked on Property Management Link");

			//ExplicitWait(AbouttheProperty_Link);
			if( SeleniumRepo.isElementDisplayed( AbouttheProperty_Link ) == true )
			{
				System.out.println("About The Property list element found");
				test.log(Status.INFO, "About the Property  list element found");
				Assert.assertTrue(true, "About the Property list element found");
			}
			else
			{
				logger.info("About the Propertyy  list element not  found");
				test.log(Status.FAIL, "About the Property list element not  found");
			}
		}


	}


	public void navigateToAboutTheProperty_Pg()
	{
		
		Click_PropertyManagement();
		
		
		ExplicitWait(Click_PropertyManagement);
		if (AbouttheProperty_Link.isDisplayed()) 
		{
			Javascriptexecutor(AbouttheProperty_Link);
			
			SeleniumRepo.waitForPageLoaded();
			
			System.out.println("AbouttheProperty_Link clicked");
			ExplicitWait(Enter_YearBuilt);
			
			System.out.println("PropertyManagement element Expanded and AbouttheProperty element  found");
			test.log(Status.INFO, "PropertyManagement element Expanded and AbouttheProperty element  found");
			Assert.assertTrue(true, "PropertyManagement element Expanded and AbouttheProperty element  found");
		} 
		else 
		{
			System.out.println("PropertyManagement Menu is not expanded");
			Javascriptexecutor(Click_PropertyManagement);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");

			ExplicitWait(AbouttheProperty_Link);
			if(AbouttheProperty_Link.isDisplayed())
			{
				Javascriptexecutor(AbouttheProperty_Link);
				SeleniumRepo.waitForPageLoaded();

				System.out.println("AbouttheProperty_Link clicked");
				ExplicitWait(Enter_YearBuilt);
				System.out.println("PropertyDefaults element found");
				test.log(Status.INFO, "PropertyDefaults element found");
				Assert.assertTrue(true, "PropertyDefaults element found");
			}
			else
			{
				logger.info("PropertyDefaults element not  found");
				test.log(Status.FAIL, "PropertyDefaults element not  found");
			}
		}
	}
	
	
	public void navigateToAddMeetingRoom_Pg()   {
		
		// Click_AddRoom  Verify_Room_Title  	
		
		if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
			
			navigateToAboutTheProperty_Pg();
		}
		
		if(SeleniumRepo.isElementDisplayed(Click_AddRoom) == true ){
			
			Click_AddRoom.click();
			SeleniumRepo.waitForPageLoaded();
			
			//create a verify method
			verifyingMeetingRoom_Pg();
			
			logger.info("Add room link on the About The Property page was clicked");
			test.log(Status.PASS, "Add room link on the About The Property page was clicked");
			
		}else{
			logger.info("Add room link on the About The Property page is not displayed");
			test.log(Status.FAIL, "Add room link on the About The Property page is not displayed");
			
		}
		
		
		
		
	}
	
	
	public void navigateToEditingMeetingRoom_Pg(String meetingRoomName )   {
		
		if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
			
			navigateToAboutTheProperty_Pg();
		}
		

		if(MeetingRoom_Name_EditLink.size() > 0 ){
		  
			for(int a = 0; a < MeetingRoom_Name_EditLink.size(); a++ ){
				
				if(MeetingRoom_Name_EditLink.get(a).getText().trim().equals(meetingRoomName) ) {
		  		
					MeetingRoom_Name_EditLink.get(a).click();
					
					SeleniumRepo.waitForPageLoaded();
					verifyingMeetingRoom_Pg();
		  		
		  		
		  		System.out.println("Successfully clicked Meeting Rooms name link:  " + meetingRoomName);
				logger.info("Editing the Meeting room named  "  +  meetingRoomName);
				test.log(Status.PASS,"Successfully clicked meeting room name link:  " + meetingRoomName );
			
		  		}
			
		}
	}else{
		
		System.out.println("Meeting Rooms name link:  " + meetingRoomName +  " Was not found");
		logger.info("Unable Editing the Meeting room named  "  +  meetingRoomName + " Was not Found");
		test.log(Status.FAIL,"Meeting Rooms name link:  " + meetingRoomName +  " Was not found");
	}
		  
		  
		  
		  
}
	
	
	public void verifyingMeetingRoom_Pg()   {
		
		
		if(SeleniumRepo.isElementDisplayed(Verify_Room_Title) == false ){
			
			logger.info("Was Not able to Navigate to the About The Property Meeting Room page");
			test.log(Status.FAIL, "Was Not able to Navigate to the About The Property Meeting Room page");	
			
		}else{
			
			logger.info("Was able to Navigate to the About The Property Meeting Room page");
			test.log(Status.PASS, "Was able to Navigate to the About The Property Meeting Room page");	
			
		}
		 
	}

	
	
	
	public void navigateToAddDining_Pg()   {
		
		//Click_Dininglink Verify_Dining_Title  
		
		
	if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
			
			navigateToAboutTheProperty_Pg();
		}
		
		if(SeleniumRepo.isElementDisplayed(Click_AddDininglink) == true ){
			
			Click_AddDininglink.click();
			SeleniumRepo.waitForPageLoaded();
			
			//create a verify method
			verifyingDining_Pg();
			
			logger.info("Add dining location link on the About The Property page was clicked");
			test.log(Status.PASS, "Add dining location link on the About The Property page was clicked");
			
		}else{
			logger.info("Add dining location link on the About The Property page is not displayed");
			test.log(Status.FAIL, "Add dining location link on the About The Property page is not displayed");
			
		}
		
	}
	
	public void navigateToEditingDining_Pg(String resturantName)   {
		
		if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
			
			navigateToAboutTheProperty_Pg();
		}
		

		if(Dining_Name_EditLink.size() > 0 ){
		  
			for(int a = 0; a < Dining_Name_EditLink.size(); a++ ){
				
				if(Dining_Name_EditLink.get(a).getText().trim().equals(resturantName) ) {
					Dining_Name_EditLink.get(a).click();
					
					SeleniumRepo.waitForPageLoaded();
					verifyingDining_Pg();
					
		  		System.out.println("Successfully clicked Dining Location name link:  " + resturantName);
				logger.info("Editing the Dining Location named  "  +  resturantName);
				test.log(Status.PASS,"Successfully clicked Dining Location name link:  " + resturantName );
			
		  		}
			
		}
	}else{
		
		System.out.println("Dining Location name link:  " + resturantName +  " Was not found");
		logger.info("Unable Editing the Dining Location named  "  +  resturantName + " Was not Found");
		test.log(Status.FAIL,"Dining Location name link:  " + resturantName +  " Was not found");
	}
		
		
}
	
	
	public void verifyingDining_Pg()   {
		
		
		if(SeleniumRepo.isElementDisplayed(Verify_Dining_Title) == false ){
			
			logger.info("Was Not able to Navigate to the About The Property Dining page");
			test.log(Status.FAIL, "Was Not able to Navigate to the About The Property Dining page");	
			
		}else{
			
			logger.info("Was able to Navigate to the About The Property Dining page");
			test.log(Status.PASS, "Was able to Navigate to the About The Property Dining page");	
			
		}
		 
	}
	
	
	public void navigateToAddNearbyAirPort_Pg()   {
	//	Click_NearByAirPort_link Verify_NearbyAirports_Title  
		
	if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
			
			navigateToAboutTheProperty_Pg();
		}
		
		if(SeleniumRepo.isElementDisplayed(Click_AddNearByAirPort_link) == true ){
			
			Click_AddNearByAirPort_link.click();
			SeleniumRepo.waitForPageLoaded();
			
			//create a verify method
			verifyingNearbyAirPort_Pg();
			
			logger.info("Add nearby airport location link on the About The Property page was clicked");
			test.log(Status.PASS, "Add nearby airport location link on the About The Property page was clicked");
			
		}else{
			logger.info("Add nearby airport location link on the About The Property page is not displayed");
			test.log(Status.FAIL, "Add nearby airport location link on the About The Property page is not displayed");
			
		}
		
	}
	
	public void navigateToEditingNearbyAirPort_Pg(String airportName)   {
		
		
		if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
			
			navigateToAboutTheProperty_Pg();
		}
		

		if(NearByAirport_Name_EditLink.size() > 0 ){
		  
			for(int a = 0; a < NearByAirport_Name_EditLink.size(); a++ ){
				
				if(NearByAirport_Name_EditLink.get(a).getText().trim().equals(airportName) ) {
					NearByAirport_Name_EditLink.get(a).click();
					
					SeleniumRepo.waitForPageLoaded();
					verifyingNearbyAirPort_Pg();
					
		  		System.out.println("Successfully clicked Airport Location name link:  " + airportName);
				logger.info("Editing the Airport Location named  "  +  airportName);
				test.log(Status.PASS,"Successfully clicked Airport Location name link:  " + airportName );
			
		  		}
			
		}
	}else{
		
		System.out.println("Airport Location name link:  " + airportName +  " Was not found");
		logger.info("Unable Editing the Airport Location named  "  +  airportName + " Was not Found");
		test.log(Status.FAIL,"Airport Location name link:  " + airportName +  " Was not found");
	}
		
		
		
		
	}
	
	
	public void verifyingNearbyAirPort_Pg()   {
		
		
		if(SeleniumRepo.isElementDisplayed(Verify_NearbyAirports_Title) == false ){
			
			logger.info("Was Not able to Navigate to the About The Property Nearby Aiport page");
			test.log(Status.FAIL, "Was Not able to Navigate to the About The Property Nearby Airport page");	
			
		}else{
			
			logger.info("Was able to Navigate to the About The Property Nearby Airport page");
			test.log(Status.PASS, "Was able to Navigate to the About The Property Nearby Airport page");	
			
		}
		 
	}
	
	
	
	
	public void navigateToAddNearbyAttractions_Pg()   {
		//Click_NearbyAttractions_link  Verify_NearbyAttactions_Title
		
		
		if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
				
				navigateToAboutTheProperty_Pg();
			}
			
			if(SeleniumRepo.isElementDisplayed(Click_AddNearbyAttractions_link) == true ){
				
				Click_AddNearbyAttractions_link.click();
				SeleniumRepo.waitForPageLoaded();
				
				//create a verify method
				verifyingNearbyAttractions_Pg();
				
				logger.info("Add nearby attraction location link on the About The Property page was clicked");
				test.log(Status.PASS, "Add nearby attraction location link on the About The Property page was clicked");
				
			}else{
				logger.info("Add nearby attraction location link on the About The Property page is not displayed");
				test.log(Status.FAIL, "Add nearby attraction location link on the About The Property page is not displayed");
				
			}	
	}
	
	public void navigateToEditingNearbyAttractions_Pg(String attractionName)   {
		
		
		
		if(SeleniumRepo.isElementDisplayed(AboutthPropertyTitle_Link) == false ){
			
			navigateToAboutTheProperty_Pg();
		}
		

		if(NearByAttractions_Name_EditLink.size() > 0 ){
		  
			for(int a = 0; a < NearByAttractions_Name_EditLink.size(); a++ ){
				
				if(NearByAttractions_Name_EditLink.get(a).getText().trim().equals(attractionName) ) {
					
					NearByAttractions_Name_EditLink.get(a).click();
					
					SeleniumRepo.waitForPageLoaded();
					verifyingNearbyAttractions_Pg();
					
		  		System.out.println("Successfully clicked Nearby Attractions name link:  " + attractionName);
				logger.info("Editing the Nearby Attractions  named  "  +  attractionName);
				test.log(Status.PASS,"Successfully clicked Nearby Attractions  name link:  " + attractionName );
			
		  		}
			
		}
	}else{
		
		System.out.println("Nearby Attractions  name link:  " + attractionName +  " Was not found");
		logger.info("Unable Editing the Nearby Attractions  named  "  +  attractionName + " Was not Found");
		test.log(Status.FAIL,"Nearby Attractions  name link:  " + attractionName +  " Was not found");
	}
		
		
	}
	
	public void verifyingNearbyAttractions_Pg()   {
		
		
		if(SeleniumRepo.isElementDisplayed(Verify_NearbyAttractions_Title) == false ){
			
			logger.info("Was Not able to Navigate to the About The Property Nearby Attraction page");
			test.log(Status.FAIL, "Was Not able to Navigate to the About The Property Nearby Attraction page");	
			
		}else{
			
			logger.info("Was able to Navigate to the About The Property Nearby Attraction page");
			test.log(Status.PASS, "Was able to Navigate to the About The Property Nearby Attraction page");	
			
		}
		 
	}
	
	
	
	/*
	  
	 */
	
	public void deleteMeetingRooms(String MeetingRoomsName) throws InterruptedException{
		
		if(!(MeetingRoom_Delete__CheckBox.isEmpty()))
		{
			for(int i=0;i<MeetingRoom_Delete__CheckBox.size();i++)
			{
				if(MeetingRoom_Name_EditLink.get(i).getText().trim().equalsIgnoreCase(MeetingRoomsName)){

				Javascriptexecutor(MeetingRoom_Delete__CheckBox.get(i));
				//Meeting_delete.get(i).click();
				Thread.sleep(2000);
				}
			}
			//WebElement Meeting=	SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'meetingRoom')and@value='Delete']"));

			Javascriptexecutor(MeetingRooms_DeleteButton);
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Meeting Rooms deleted successfully");
		}
		else
		{
			System.out.println("There are no Meeting rooms");
		}
		
		
	}

	
	
	public void deleteAllMeetingRooms() throws InterruptedException{
		
		if(!(MeetingRoom_Delete__CheckBox.isEmpty()))
		{
			for(int i=0;i<MeetingRoom_Delete__CheckBox.size();i++)
			{
				Javascriptexecutor(MeetingRoom_Delete__CheckBox.get(i));
				//Meeting_delete.get(i).click();
				Thread.sleep(2000);
			}
			//WebElement Meeting=	SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'meetingRoom')and@value='Delete']"));

			Javascriptexecutor(MeetingRooms_DeleteButton);
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Meeting Rooms deleted successfully");
		}
		else
		{
			System.out.println("There are no Meeting rooms");
		}

		
		
	}
	
	
	
	public void deleteDiningLocation(String DiningLocationName) throws InterruptedException{
		
		
		if(!(Dining_Delete_CheckBox.isEmpty()))
		{
			for(int i=0;i<Dining_Delete_CheckBox.size();i++)
			{
				if(Dining_Name_EditLink.get(i).getText().trim().equalsIgnoreCase(DiningLocationName)){

				Javascriptexecutor(Dining_Delete_CheckBox.get(i));
				//Dining_delete.get(i).click();
				Thread.sleep(2000);
				}
			}
			//WebElement Resturant=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'dining')and@value='Delete']"));

			Javascriptexecutor(DiningLocation_DeleteButton);
			System.out.println("Dining Rooms deleted successfully");
			SeleniumRepo.waitForPageLoaded();
		}
		else
		{
			System.out.println("There are no Dining rooms");
		}
		
	}

	
	public void deleteAllDiningLocation() throws InterruptedException{
		
		if(!(Dining_Delete_CheckBox.isEmpty()))
		{
			for(int i=0;i<Dining_Delete_CheckBox.size();i++)
			{
				Javascriptexecutor(Dining_Delete_CheckBox.get(i));
				//Dining_delete.get(i).click();
				Thread.sleep(2000);
			}
			//WebElement Resturant=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'dining')and@value='Delete']"));

			Javascriptexecutor(DiningLocation_DeleteButton);
			System.out.println("Dining Rooms deleted successfully");
			SeleniumRepo.waitForPageLoaded();
		}
		else
		{
			System.out.println("There are no Dining rooms");
		}
		
	}
	
	
	
	public void deleteNearbyAriportLocation(String NearByAirportName) throws InterruptedException{
		
		
		if(!(NearByAirport_Delete_CheckBox.isEmpty()))
		{
			for(int i=0;i<NearByAirport_Delete_CheckBox.size();i++)
			{
				if(NearByAirport_Name_EditLink.get(i).getText().trim().equalsIgnoreCase(NearByAirportName)){

				Javascriptexecutor(NearByAirport_Delete_CheckBox.get(i));
				//Airpot_Delete.get(i).click();
				Thread.sleep(2000);
				
				}
			}

			Javascriptexecutor(NearByAirportLocation_DeleteButton);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Airpot Names deleted successfully");
		}
		else
		{
			System.out.println("There are no Airpots");
		}
		
		
	}

	
	public void deleteAllNearbyAriportLocation() throws InterruptedException{
		
		
		if(!(NearByAirport_Delete_CheckBox.isEmpty()))
		{
			for(int i=0;i<NearByAirport_Delete_CheckBox.size();i++)
			{
				Javascriptexecutor(NearByAirport_Delete_CheckBox.get(i));
				//Airpot_Delete.get(i).click();
				Thread.sleep(2000);
			}


			//WebElement Airport=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'airport')and@value='Delete']"));

			Javascriptexecutor(NearByAirportLocation_DeleteButton);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Airpot Names deleted successfully");
		}
		else
		{
			System.out.println("There are no Airpots");
		}
		
		
	}
	
	
	public void deleteNearbyAttractionLocation(String NearByAttractName) throws InterruptedException{
		// NearByAttractions_Delete_CheckBox;   NearByAttractions_Name_EditLink
		
		if(!(NearByAttractions_Delete_CheckBox.isEmpty()))
		{
			for(int i=0;i<NearByAttractions_Delete_CheckBox.size();i++)
			{
				if(NearByAttractions_Name_EditLink.get(i).getText().trim().equalsIgnoreCase(NearByAttractName)){
					
				Javascriptexecutor(NearByAttractions_Delete_CheckBox.get(i));
				//Attractions_Delete.get(i).click();
				Thread.sleep(2000);
				
				}
			}
			
			//WebElement Attractions=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'attraction')and@value='Delete']"));

			Javascriptexecutor(NearByAttractionsLocation_DeleteButton);
			Thread.sleep(2000);
			SeleniumRepo.waitForPageLoaded();	


			System.out.println("Attraction Names deleted successfully");

		}
		else
		{
			System.out.println("There are no Attractions");
		}
		
		
	}
	
	public void deleteAllNearbyAttractionLocation() throws InterruptedException{
		
		if(!(NearByAttractions_Delete_CheckBox.isEmpty()))
		{
			for(int i=0;i<NearByAttractions_Delete_CheckBox.size();i++)
			{
				Javascriptexecutor(NearByAttractions_Delete_CheckBox.get(i));
				//Attractions_Delete.get(i).click();
				Thread.sleep(2000);
			}
			
			//WebElement Attractions=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@onclick,'attraction')and@value='Delete']"));

			SeleniumRepo.scrollintoview(NearByAttractionsLocation_DeleteButton);

			Javascriptexecutor(NearByAttractionsLocation_DeleteButton);
			Thread.sleep(2000);
			SeleniumRepo.waitForPageLoaded();	


			System.out.println("Attraction Names deleted successfully");

		}
		else
		{
			System.out.println("There are no Attractions");
		}
		
		
	}

	
	public void deleteAllPropertyItems() throws InterruptedException
	{

		deleteAllMeetingRooms();
		
		Thread.sleep(2000);
		
		deleteAllDiningLocation();
		Thread.sleep(2000);

		deleteAllNearbyAriportLocation();
		Thread.sleep(2000);

		deleteAllNearbyAttractionLocation();
		Thread.sleep(2000);


	}
	
	
	
	
	/**
	 * This is the orignal automated method for the About The Property page
	 * 
	 * 
	 * @param AbouttheProperty
	 * @param YearBuilt
	 * @param YearRenovated
	 */
	public void aboutPropertyRoom(String AbouttheProperty, String YearBuilt, String YearRenovated) {

		try {

			SeleniumRepo.waitForElementPresent(Enter_YearBuilt);
			if (Enter_YearBuilt.isDisplayed()) {
				Javascriptexecutor(Enter_YearBuilt);
				Enter_YearBuilt.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_YearBuilt.sendKeys(YearBuilt);
				System.out.println("YearBuilt is entered successfully");
				test.log(Status.PASS, "YearBuilt is entered successfully");
				logger.info("YearBuilt is entered successfully");
				Assert.assertTrue(true, "YearBuilt is entered successfully");
			} else {
				System.out.println("YearBuilt TextBox not found");
				logger.error("Failed to Found YearBuilt TextBox");
				test.log(Status.FAIL, "Failed to Found YearBuilt TextBox");
				Assert.assertFalse(false, "YearBuilt TextBox not found");
			}

			if (Enter_YearRenovated.isDisplayed()) {
				Javascriptexecutor(Enter_YearRenovated);
				(Enter_YearRenovated).clear();
				(Enter_YearRenovated).sendKeys(YearRenovated);
				System.out.println("YearRenovated is entered successfully");
				test.log(Status.PASS, "YearRenovatedis entered successfully");
				logger.info("YearRenovatedis entered successfully");
				Assert.assertTrue(true, "YearRenovatedis entered successfully");
			} else {
				System.out.println("YearRenovated TextBox not found");
				logger.info("Failed YearRenovated TextBox not found");
				test.log(Status.FAIL, "Failed to Found YearRenovated TextBox ");
				Assert.assertFalse(false, "YearRenovated TextBox not found");
			}

			if (Save.isDisplayed()) {

				// Stale(Save).click();

				SeleniumRepo.driver.findElement(By.xpath("//input[@name='save']")).click();
				SeleniumRepo.waitForPageLoaded();
				test.log(Status.PASS, "Clicked on Save button");
				logger.info("Clicked on Save button");
				Assert.assertTrue(true, "Clicked on Save button");
			} else {
				logger.info("Failed to Click on Save button");
				test.log(Status.FAIL, "Failed to Click on Save button");
			}

		} catch (Exception e) {
			logger.error("Unable to create About The Property for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to About The Property for selected property because of this execption" + e);
			e.printStackTrace();
		}

	}
}
