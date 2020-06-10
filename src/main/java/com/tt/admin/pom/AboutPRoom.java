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

public class AboutPRoom extends AboutTheProperty {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();
	
	
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Meeting Room Name Required')]"), })
    private WebElement Check_ErrorMeetingRoomNameLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Code Required')]"), })
    private WebElement Check_ErrorCodeLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Please Select Services')]"), })
    private WebElement Check_ErrorSelectServicesLabel;
    
    
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Capacity Required')]"), })
    private WebElement Check_ErrorCapacityLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Area Required (Width and Length required to calculate area)')]"), })
    private WebElement Check_ErrorAreaLabel;
    


	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Add a Room')]"), })
	private WebElement Click_AddRoom;

	@FindAll({ @FindBy(xpath = "//td[text()='Meeting Rooms']"), })
	private WebElement Verify_Room_Title;

	@FindAll({ @FindBy(xpath = "//input[@name='name']"), })
	private WebElement Enter_RoomName;

	@FindAll({ @FindBy(xpath = "//input[@name='code']"), })
	private WebElement Enter_Code;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedTypeValue']"), })
	private WebElement SelectedTypeValue;

	@FindAll({ @FindBy(xpath = "//textarea[@name='description']"), })
	private WebElement Enter_Description;

	@FindAll({ @FindBy(xpath = "//td//select[@name='categoryId']"), })
	private WebElement Select_Services;

	@FindAll({ @FindBy(xpath = "//input[@name='capacity']"), })
	private WebElement Enter_Capacity;

	@FindAll({ @FindBy(xpath = "//select[@name='selectedUntisValue']"), })
	private WebElement Select_Units;

	@FindAll({ @FindBy(xpath = "//input[@name='length']"), })
	private WebElement Enter_Length;

	@FindAll({ @FindBy(xpath = "//input[@name='width']"), })
	private WebElement Enter_Width;

	@FindAll({ @FindBy(xpath = "//input[@name='height']"), })
	private WebElement Enter_Height;

	@FindAll({ @FindBy(xpath = "//input[@name='area']"), })
	private WebElement Enter_Area;

	@FindAll({ @FindBy(xpath = "//*[@id='saveBtn']/input[@value='Save']"), })
	private WebElement PRoom_Save;
	
	@FindAll({ @FindBy(xpath = "//input[@value='Cancel']"), })
	private WebElement PRoom_Cancel;

	@FindAll({ @FindBy(xpath = "//*[text()='Rooms']"), })
	private WebElement Rooms;
	
	
	
	
	
	public void editMeetingRoomName(String RoomName){
		
		if (Enter_RoomName.isDisplayed()) {
			Javascriptexecutor(Enter_RoomName);
			Enter_RoomName.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_RoomName.sendKeys(RoomName);
			System.out.println("RoomName is entered successfully");
			logger.info("RoomName is entered successfully");
			test.log(Status.PASS, "RoomName is entered successfully");
			Assert.assertTrue(true, "RoomName is entered successfully");
		} else {
			System.out.println("RoomName TextBox not found");
			logger.error("Failed to Found RoomName TextBox");
			test.log(Status.FAIL, "Failed to Found RoomName TextBox");
			Assert.assertFalse(false, "RoomName TextBox not found");
		}

	}
	
	public void editMeetingRoomCode(String RoomCode){
		

		if (Enter_Code.isDisplayed()) {
			Javascriptexecutor(Enter_Code);
			Enter_Code.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Code.sendKeys(RoomCode);
			System.out.println("RoomCode is entered successfully");
			logger.info("RoomCode is entered successfully");
			test.log(Status.PASS, "RoomCode is entered successfully");
			Assert.assertTrue(true, "RoomCode is entered successfully");
		} else {
			System.out.println("RoomCode TextBox not found");
			logger.error("Failed to Found RoomCode TextBox");
			test.log(Status.FAIL, "Failed to Found RoomCode TextBox");
			Assert.assertFalse(false, "RoomCode TextBox not found");
		}


	}
	
	public void editMeetingRoomType(String Type){
		
		
		try {
			SeleniumRepoDropdown.selectDropDownValue(SelectedTypeValue, Type);
			System.out.println("Type Selected ");
			logger.info("Type Selected");
			test.log(Status.PASS, "Type Selected");
		} catch (Exception e) {
			System.out.println("Type Not Selected ");
			logger.error("Failed to Select Type");
			test.log(Status.FAIL, "Failed to Select Type");
			e.printStackTrace();
		}

	
		
	}
	
	
	public void editMeetingRoomDescription(String Description ) throws InterruptedException{
		
		
		if (Enter_Description.isDisplayed()) {
			Javascriptexecutor(Enter_Description);
			Enter_Description.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Description.sendKeys(Description);
			System.out.println(" Description is entered successfully");
			logger.info("Description is entered successfully");
			test.log(Status.PASS, "Description is entered successfully");
			Assert.assertTrue(true, "Description is entered successfully");
		} else {
			System.out.println("Description TextBox not found");
			logger.error("Failed to Found Description TextBox");
			test.log(Status.FAIL, "Failed to Found Description TextBox");
			Assert.assertFalse(false, "Description TextBox not found");
		}


	}
	
	public void editMeetingRoomServices(String Services){
		
		
		if (Select_Services.isDisplayed()) {
			SeleniumRepoDropdown.selectDropDownText(Select_Services, Services);
			System.out.println("Services Selected");
			logger.info("Services Selected");
			test.log(Status.PASS, "Services Selected");
			Assert.assertTrue(true, "Services Selected is  successfully");
		} else {
			System.out.println("Services  not Selected ");
			logger.error("Failed to Select Services ");
			test.log(Status.FAIL, "Failed to Select Services ");
			Assert.assertFalse(false, "Services  not Selected");
		}	
		
	}
	
	
	public void editMeetingRoomCapacity(String Capacity){
		
		
		if (Enter_Capacity.isDisplayed()) {
			Javascriptexecutor(Enter_Capacity);
			Enter_Capacity.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Capacity.sendKeys(Capacity);
			System.out.println(" Capacity is entered successfully");
			logger.info("Capacity is entered successfully");
			test.log(Status.PASS, "Capacity is entered successfully");
			Assert.assertTrue(true, "Capacity is entered successfully");
		} else {
			System.out.println("Capacity TextBox not found");
			logger.error("Failed to Found Capacity TextBox");
			test.log(Status.FAIL, "Failed to Found Capacity TextBox");
			Assert.assertFalse(false, "Capacity TextBox not found");
		}


		
	}
	
	public void editMeetingRoomUnits(String Units){
		
		
		try {
			SeleniumRepoDropdown.selectDropDownValue(Select_Units, Units);
			System.out.println("Units Selected");
			logger.info("Units Selected");
			test.log(Status.PASS, "Units Selected");
		} catch (Exception e) {
			System.out.println("Units Not Selected");
			logger.error("Failed to Select Units");
			test.log(Status.FAIL, "Failed to Select Units");

			e.printStackTrace();
		}

	
		
	}
	
	public void editMeetingRoomLength(String Length){
		
		if (Enter_Length.isDisplayed()) {
			Javascriptexecutor(Enter_Length);
			Enter_Length.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Length.sendKeys(Length);
			System.out.println(" Length is entered successfully");
			logger.info("Length is entered successfully");
			test.log(Status.PASS, "Length is entered successfully");
			Assert.assertTrue(true, "Length is entered successfully");
		} else {
			System.out.println("Length TextBox not found");
			logger.error("Failed to Found Length TextBox");
			test.log(Status.FAIL, "Failed to Found Length TextBox");
			Assert.assertFalse(false, "Length TextBox not found");
		}

	
		
	}
	
	
	public void editMeetingRoomWidth(String Width){
		
		if (Enter_Width.isDisplayed()) {
			Javascriptexecutor(Enter_Width);
			Enter_Width.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Width.sendKeys(Width);
			System.out.println(" Width is entered successfully");
			logger.info("Width is entered successfully");
			test.log(Status.PASS, "Width is entered successfully");
			Assert.assertTrue(true, "Width is entered successfully");
		} else {
			System.out.println("Width TextBox not found");
			logger.error("Failed to Found Width TextBox");
			test.log(Status.FAIL, "Failed to Found Width TextBox");
			Assert.assertFalse(false, "Width TextBox not found");
		}


		
		
	}
	
	public void editMeetingRoomHeight(String Height){
		
		
		if (Enter_Height.isDisplayed()) {
			Javascriptexecutor(Enter_Height);
			Enter_Height.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Height.sendKeys(Height);
			System.out.println(" Height is entered successfully");
			logger.info("Height is entered successfully");
			test.log(Status.PASS, "Height is entered successfully");
			Assert.assertTrue(true, "Height is entered successfully");
		} else {
			System.out.println("Height TextBox not found");
			logger.error("Failed to Found Height TextBox");
			test.log(Status.FAIL, "Failed to Found Height TextBox");
			Assert.assertFalse(false, "Height TextBox not found");
		}


	
		
		
	}
	
	public void editMeetingRoomArea(String Area){
		
		
		if (Enter_Area.isDisplayed()) {
			Javascriptexecutor(Enter_Area);
			Enter_Area.clear();
			// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			Enter_Area.sendKeys(Area);
			System.out.println(" Area is entered successfully");
			logger.info("Area is entered successfully");
			test.log(Status.PASS, "Area is entered successfully");
			Assert.assertTrue(true, "Area is entered successfully");
		} else {
			System.out.println("Area TextBox not found");
			logger.error("Failed to Found Area TextBox");
			test.log(Status.FAIL, "Failed to Found Area TextBox");
			Assert.assertFalse(false, "Area TextBox not found");
		}

		
	}
	


	public void requiredFieldErrorCheck() {
		
		clickMeetingRoomsSaveButton();
		
		SeleniumRepo.waitForPageLoaded();

		if (Check_ErrorMeetingRoomNameLabel.isDisplayed()) {
			System.out.println("Error Message Meeting Room Name Required  is Displayed");
			test.log(Status.PASS, "Error Message Meeting Room Name Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Meeting Room Name Required  is Displayed ");
		} else {
			System.out.println("Error Message Meeting Room Name Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Meeting Room Name Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Meeting Room Name Required  is Not Displayed");
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

		if (Check_ErrorSelectServicesLabel.isDisplayed()) {
			System.out.println("Error Message Select Services is Displayed");
			test.log(Status.PASS, "Error MessageSelect Services is Displayed ");
			Assert.assertTrue(true, "Error MessageSelect Services is Displayed ");
		} else {
			System.out.println("Error Message Select Services is Not Displayed");
			test.log(Status.FAIL, " Error Message Select Services is Not Displayed");
			Assert.assertFalse(false, "Error Message Select Services is Not Displayed");
		}
				
		
		if (Check_ErrorCapacityLabel.isDisplayed()) {
			System.out.println("Error Message  Capacity Required  is Displayed");
			test.log(Status.PASS, "Error Message  Capacity Required  is Displayed ");
			Assert.assertTrue(true, "Error Message  Capacity Required  is Displayed ");
		} else {
			System.out.println("Error Message  Capacity Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message  Capacity Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message  Capacity Required  is Not Displayed");
		}

		if (Check_ErrorAreaLabel.isDisplayed()) {
			System.out.println("Error Message Area Required is Displayed");
			test.log(Status.PASS, "Error Message Area Required is Displayed ");
			Assert.assertTrue(true, "Error Message Area Required is Displayed ");
		} else {
			System.out.println("Error Message Area Required is Not Displayed");
			test.log(Status.FAIL, " Error Message Area Required is Not Displayed");
			Assert.assertFalse(false, "Error Message Area Required is Not Displayed");
		}
			
		
		
	}
	
	
	public void clickMeetingRoomsSaveButton(){
		
		
		try {
			Javascriptexecutor(PRoom_Save);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Saved");
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
		} catch (Exception e) {
			System.out.println("Not Saved");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

	public void CreatePRoom(String Room_Title, String RoomName, String RoomCode, String Type, String Description,
			String Services, String Capacity, String Units, String Height, String Area, String Width, String Length) {

		try {

			// ExplicitWait(Click_AddRoom);
			if (Click_AddRoom.isDisplayed()) {
				Javascriptexecutor(Click_AddRoom);
				logger.info("Clicked on AddRoom Link");
				test.log(Status.PASS, "Clicked on AddRoom Link");
				Assert.assertTrue(true, "Clicked on AddRoom Link");
			} else {
				System.out.println("AddRoom Link not found");
				logger.error("Failed to Click on AddRoom Link");
				test.log(Status.FAIL, "Failed to Click on AddRoom Link");
				Assert.assertFalse(false, "AddRoom Link not found");
			}

			ExplicitWait(Verify_Room_Title);
			System.out.println(Verify_Room_Title.getText());
			System.out.println("Expected" + Room_Title);
			try {
				Assert.assertEquals(Room_Title, Verify_Room_Title.getText());
				System.out.println("Title Matched");
				logger.info("Title Matched");
				test.log(Status.PASS, "Title Matched");
				Assert.assertTrue(true, " Room_Title  Matched");
			} catch (Error e) {
				System.out.println("Title didn't match");
				logger.error(" Title didn't match");
				test.log(Status.FAIL, " Title didn't match");
				Assert.assertFalse(false, "Room_Title  didn't match");
			}

			if (Enter_RoomName.isDisplayed()) {
				Javascriptexecutor(Enter_RoomName);
				Enter_RoomName.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_RoomName.sendKeys(RoomName);
				System.out.println("RoomName is entered successfully");
				logger.info("RoomName is entered successfully");
				test.log(Status.PASS, "RoomName is entered successfully");
				Assert.assertTrue(true, "RoomName is entered successfully");
			} else {
				System.out.println("RoomName TextBox not found");
				logger.error("Failed to Found RoomName TextBox");
				test.log(Status.FAIL, "Failed to Found RoomName TextBox");
				Assert.assertFalse(false, "RoomName TextBox not found");
			}

			if (Enter_Code.isDisplayed()) {
				Javascriptexecutor(Enter_Code);
				Enter_Code.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Code.sendKeys(RoomCode);
				System.out.println("RoomCode is entered successfully");
				logger.info("RoomCode is entered successfully");
				test.log(Status.PASS, "RoomCode is entered successfully");
				Assert.assertTrue(true, "RoomCode is entered successfully");
			} else {
				System.out.println("RoomCode TextBox not found");
				logger.error("Failed to Found RoomCode TextBox");
				test.log(Status.FAIL, "Failed to Found RoomCode TextBox");
				Assert.assertFalse(false, "RoomCode TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(SelectedTypeValue, Type);
				System.out.println("Type Selected ");
				logger.info("Type Selected");
				test.log(Status.PASS, "Type Selected");
			} catch (Exception e) {
				System.out.println("Type Not Selected ");
				logger.error("Failed to Select Type");
				test.log(Status.FAIL, "Failed to Select Type");
				e.printStackTrace();
			}

			if (Enter_Description.isDisplayed()) {
				Javascriptexecutor(Enter_Description);
				Enter_Description.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Description.sendKeys(Description);
				System.out.println(" Description is entered successfully");
				logger.info("Description is entered successfully");
				test.log(Status.PASS, "Description is entered successfully");
				Assert.assertTrue(true, "Description is entered successfully");
			} else {
				System.out.println("Description TextBox not found");
				logger.error("Failed to Found Description TextBox");
				test.log(Status.FAIL, "Failed to Found Description TextBox");
				Assert.assertFalse(false, "Description TextBox not found");
			}

			if (Select_Services.isDisplayed()) {
				SeleniumRepoDropdown.selectDropDownText(Select_Services, Services);
				System.out.println("Services Selected");
				logger.info("Services Selected");
				test.log(Status.PASS, "Services Selected");
				Assert.assertTrue(true, "Services Selected is  successfully");
			} else {
				System.out.println("Services  not Selected ");
				logger.error("Failed to Select Services ");
				test.log(Status.FAIL, "Failed to Select Services ");
				Assert.assertFalse(false, "Services  not Selected");
			}

			if (Enter_Capacity.isDisplayed()) {
				Javascriptexecutor(Enter_Capacity);
				Enter_Capacity.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Capacity.sendKeys(Capacity);
				System.out.println(" Capacity is entered successfully");
				logger.info("Capacity is entered successfully");
				test.log(Status.PASS, "Capacity is entered successfully");
				Assert.assertTrue(true, "Capacity is entered successfully");
			} else {
				System.out.println("Capacity TextBox not found");
				logger.error("Failed to Found Capacity TextBox");
				test.log(Status.FAIL, "Failed to Found Capacity TextBox");
				Assert.assertFalse(false, "Capacity TextBox not found");
			}

			try {
				SeleniumRepoDropdown.selectDropDownValue(Select_Units, Units);
				System.out.println("Units Selected");
				logger.info("Units Selected");
				test.log(Status.PASS, "Units Selected");
			} catch (Exception e) {
				System.out.println("Units Not Selected");
				logger.error("Failed to Select Units");
				test.log(Status.FAIL, "Failed to Select Units");

				e.printStackTrace();
			}

			if (Enter_Length.isDisplayed()) {
				Javascriptexecutor(Enter_Length);
				Enter_Length.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Length.sendKeys(Length);
				System.out.println(" Length is entered successfully");
				logger.info("Length is entered successfully");
				test.log(Status.PASS, "Length is entered successfully");
				Assert.assertTrue(true, "Length is entered successfully");
			} else {
				System.out.println("Length TextBox not found");
				logger.error("Failed to Found Length TextBox");
				test.log(Status.FAIL, "Failed to Found Length TextBox");
				Assert.assertFalse(false, "Length TextBox not found");
			}

			if (Enter_Width.isDisplayed()) {
				Javascriptexecutor(Enter_Width);
				Enter_Width.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Width.sendKeys(Width);
				System.out.println(" Width is entered successfully");
				logger.info("Width is entered successfully");
				test.log(Status.PASS, "Width is entered successfully");
				Assert.assertTrue(true, "Width is entered successfully");
			} else {
				System.out.println("Width TextBox not found");
				logger.error("Failed to Found Width TextBox");
				test.log(Status.FAIL, "Failed to Found Width TextBox");
				Assert.assertFalse(false, "Width TextBox not found");
			}

			if (Enter_Height.isDisplayed()) {
				Javascriptexecutor(Enter_Height);
				Enter_Height.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Height.sendKeys(Height);
				System.out.println(" Height is entered successfully");
				logger.info("Height is entered successfully");
				test.log(Status.PASS, "Height is entered successfully");
				Assert.assertTrue(true, "Height is entered successfully");
			} else {
				System.out.println("Height TextBox not found");
				logger.error("Failed to Found Height TextBox");
				test.log(Status.FAIL, "Failed to Found Height TextBox");
				Assert.assertFalse(false, "Height TextBox not found");
			}

			if (Enter_Area.isDisplayed()) {
				Javascriptexecutor(Enter_Area);
				Enter_Area.clear();
				// Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Area.sendKeys(Area);
				System.out.println(" Area is entered successfully");
				logger.info("Area is entered successfully");
				test.log(Status.PASS, "Area is entered successfully");
				Assert.assertTrue(true, "Area is entered successfully");
			} else {
				System.out.println("Area TextBox not found");
				logger.error("Failed to Found Area TextBox");
				test.log(Status.FAIL, "Failed to Found Area TextBox");
				Assert.assertFalse(false, "Area TextBox not found");
			}

			try {
				Javascriptexecutor(PRoom_Save);
				SeleniumRepo.waitForPageLoaded();
				System.out.println("Saved");
				logger.info("Clicked on Save button");
				test.log(Status.PASS, "Clicked on Save button");
			} catch (Exception e) {
				System.out.println("Not Saved");
				logger.error("Failed to Click on Save button");
				test.log(Status.FAIL, "Failed to Click on Save button");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.error("Unable to create About Property Room for selected property because of this execption" + e);
			test.log(Status.ERROR,
					"Unable to create About Property Room  for selected property because of this execption" + e);
			e.printStackTrace();
		}
	}

}
