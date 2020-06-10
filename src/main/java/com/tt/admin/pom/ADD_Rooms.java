package com.tt.admin.pom;

import java.util.List;

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
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

public class ADD_Rooms extends BaseTest
{
	String roomNameText;
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	@FindAll({ @FindBy(xpath = "//div[contains(., 'Rooms')]"),})
	private WebElement Click_Room_link;

	@FindAll({
		@FindBy(xpath = "(//div[contains(text(),'Rooms')]/../ul/li/a)[2]"), })
	@CacheLookup
	private WebElement Click_List;


	@FindAll({ @FindBy(xpath = "//input[@value='Yes']"), })
	@CacheLookup
	private WebElement click_yes;

	@FindAll({ @FindBy(xpath = "//input[@value='Delete']"), })
	@CacheLookup
	private WebElement Delete;


	@FindAll({ @FindBy(xpath = "//ul[@id='accordion']/li"),

	})
	private List<WebElement> Rooms_link;

	@FindAll({ @FindBy(css = "#add_new_room"), @FindBy(xpath = "//a[@id='add_new_room']"),

	})
	private WebElement Add_New_Room;

	@FindAll({ @FindBy(name = "name"), @FindBy(xpath = "//input[@name='name']"),

	})
	private WebElement Room_Name;

	@FindAll({ @FindBy(name = "code"), @FindBy(xpath = "//input[@name='code']"),

	})
	private WebElement Room_Code;

	@FindAll({ @FindBy(name = "gdsRoomCode"), @FindBy(xpath = "//input[@name='gdsRoomCode']"),

	})
	private WebElement Room_GDS_Code;

	@FindAll({ @FindBy(xpath = "//input[@value='Select applicable Bed Types']"),

	})
	private WebElement Room_Bed_Types;
	
	
	@FindAll({ @FindBy(xpath = "//select[@name='selectedTag']/option[2]"),

	})
	public WebElement roomCategories;


	@FindAll({ @FindBy(xpath = "//input[contains(@id,'bed')]"),

	})
	private List<WebElement> List_of_Beds;

	@FindAll({ @FindBy(xpath = "//input[@value='Add']"),

	})
	private WebElement Add_btn;




	@FindAll({ @FindBy(name = "shortDescription"), @FindBy(xpath = "//textarea[@name='shortDescription']"),

	})
	private WebElement Room_Short_Desc;

	@FindAll({ @FindBy(name = "detailedDescription"), @FindBy(xpath = "//textarea[@name='detailedDescription']"),

	})
	private WebElement Room_Detailed_Desc;

	@FindAll({ @FindBy(name = "tt_img_loader_name_0"), @FindBy(xpath = "//input[@name='tt_img_loader_name_0']"),

	})
	private WebElement Room_Upload_Image_Name;

	@FindAll({ @FindBy(name = "tt_img_loader_desc_0"), @FindBy(xpath = "//textarea[@name='tt_img_loader_desc_0']"),

	})
	private WebElement Room_Upload_Image_Desc;

	@FindAll({ @FindBy(name = "tt_img_loader_alt_text_0"),
		@FindBy(xpath = "//textarea[@name='tt_img_loader_alt_text_0']"),

	})
	private WebElement Room_Upload_Image_Alt_Txt;

	@FindAll({ @FindBy(name = "tt_img_loader_file_0"), @FindBy(xpath = "//input[@name='tt_img_loader_file_0']"),

	})
	private WebElement Room_Upload_Image_Path;

	@FindAll({ @FindBy(name = "roomSize"), @FindBy(xpath = "//input[@name='roomSize']"),

	})

	private WebElement Room_Size;

	@FindAll({ @FindBy(name = "subRooms"), @FindBy(xpath = "//input[@name='subRooms']"),

	})
	private WebElement Room_Subrooms;

	@FindAll({ @FindBy(name = "extraAdultPerRoomCharge"), @FindBy(xpath = "//input[@name='extraAdultPerRoomCharge']"),

	})
	private WebElement Extra_Adult_Charge_Per_Room;

	@FindAll({ @FindBy(name = "extraChildPerRoomCharge"), @FindBy(xpath = "//input[@name='extraChildPerRoomCharge']"),

	})
	private WebElement Extra_Child_Charge_Per_Room;

	@FindAll({ @FindBy(name = "maxOccupantsForDefaultPrice"),
		@FindBy(xpath = "//select[@name='maxOccupantsForDefaultPrice']"),

	})
	private WebElement Max_Occupancy_Per_Room;

	@FindAll({ @FindBy(name = "minAdultOccupancy"), @FindBy(xpath = "//input[@name='minAdultOccupancy']"),

	})
	private WebElement Min_Adults_Per_Room;

	@FindAll({ @FindBy(name = "maxAdultOccupancy"), @FindBy(xpath = "//input[@name='maxAdultOccupancy']"),

	})
	private WebElement Max_Adults_Per_Room;

	@FindAll({ @FindBy(name = "minChilOccupancy"), @FindBy(xpath = "//input[@name='minChilOccupancy']"),

	})
	private WebElement Min_Children_Per_Room;

	@FindAll({ @FindBy(name = "maxOccupantsForDefaultPrice"), @FindBy(xpath = "//select[@name='maxOccupantsForDefaultPrice']"),

	})
	private WebElement Max_Ocuupancy_Per_Room;

	@FindAll({ @FindBy(name = "maxChilOccupancy"), @FindBy(xpath = "//input[@name='maxChilOccupancy']"),

	})
	private WebElement Max_Children_Per_Room;

	@FindAll({ @FindBy(name = "totalMaxOccupancy"), @FindBy(xpath = "//input[@name='totalMaxOccupancy']"),

	})
	private WebElement Total_Max_Occupancy_Per_Room;

	@FindAll({ @FindBy(xpath = "//input[@value='Save']"),

	})
	private WebElement Save_Btn;
	@FindAll({ @FindBy(xpath = "//*[text()='Rooms']") })

	private WebElement Rooms_Link;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Please upload at least one image.')]") })

	private WebElement Upload_Img_Err;
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field Name')]") })

	private WebElement Name_Err;
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field Code')]") })

	private WebElement Code_Err;
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required selection Beds')]") })

	private WebElement Bed_Sels_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field Extra Adult Charge')]") })

	private WebElement Extra_Adult_Charge_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field Extra Child Charge')]") })

	private WebElement Extra_Child_Charge_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required selection Max No. of Adults for Default P')]") })

	private WebElement Max_Adult_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field: Max Adult Occupancy')]") })

	private WebElement Max_Adult_Occupancy_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field: Min Adult Occupancy')]") })

	private WebElement Min_Adult_Occupancy_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field: Max Child Occupancy')]") })

	private WebElement Max_Children_Occupancy_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field: Min Child Occupancy')]") })

	private WebElement Min_Children_Occupancy_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field: Total Max Occupancy')]") })

	private WebElement Total_Max_Occupancy_Err;

	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Required field GDS Code')]") })

	private WebElement GDS_Code_Err;
	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Room Type')]") })

	private WebElement Room_Type;

	public void Rooms_link()
	{
		
		if (SeleniumRepo.isElementDisplayed(Click_List) == true ) 
		{
			System.out.println("Rooms element Expanded and Room list element  found");
			test.log(Status.INFO, "Rooms element Expanded and Room list element  found");
			Assert.assertTrue(true, "Rooms element Expanded and Room list element  found");
		} 
		else 
		{
			System.out.println("Rooms Menu is not expanded");
			Javascriptexecutor(Click_Room_link);
			System.out.println("Clicked on Rooms Link");
			test.log(Status.INFO, "Clicked on Rooms Link");
			
			ExplicitWait(Click_List);
			if(Click_List.isDisplayed())
			{
			System.out.println("Rooms list element found");
			test.log(Status.INFO, "Rooms list element found");
			Assert.assertTrue(true, "Rooms list element found");
			}
			else
			{
				logger.info("Rooms list element not  found");

				test.log(Status.FAIL, "Rooms list element not  found");
			}
		}
	}

	public void Click_Listall() throws InterruptedException
	{
		ExplicitWait(Click_List);
		Javascriptexecutor(Click_List);
		SeleniumRepo.waitForPageLoaded();Thread.sleep(2000);
		System.out.println("All Rooms link Clicked successfully");
		logger.info("All Rooms link Clicked successfully");
		test.log(Status.PASS, "All Rooms link Clicked successfully");
	}

	public void delete_rooms(String roomname) throws InterruptedException
	{
		try {
		String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
		if(body.contains(roomname))
		{
			System.out.println("Room "+roomname+" already present going to delete");
			SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+roomname+"')]/..//input[@type='checkbox']")).click();
			Thread.sleep(2000);
			Javascriptexecutor(Delete);
			ExplicitWait(click_yes);
			click_yes.click();
			SeleniumRepo.waitForPageLoaded();

			if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains("Application Error"))
			{
			SeleniumRepo.driver.navigate().refresh();
			Thread.sleep(4000);
			SeleniumRepo.waitForPageLoaded();
			}
		}
		else
		{
			System.out.println("room "+roomname+" not created yet");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addnew(String roomname)

	{
		ExplicitWait(Add_New_Room);
		if (SeleniumRepo.isElementPresent(Add_New_Room)) 
		{
			Javascriptexecutor(Add_New_Room);
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.PASS, "Clicked on Add_New_Room link");
			logger.info("Clicked on Add_New_Room link");
			Assert.assertTrue(true, "Clicked on Add_New_Room link");
		}
		else
		{
			logger.info("Failed to Click on Rooms link");

			test.log(Status.FAIL, "Failed to Click on Rooms link");
		}
	}

	public void name(String roomName)
	{
		ExplicitWait(Room_Name);
		if (SeleniumRepo.isElementPresent(Room_Name))
		{
			Room_Name.sendKeys(roomName);
			 roomNameText=Room_Name.getText();

			test.log(Status.INFO, "Room name is entered successfully");
			logger.info("Room name is entered successfully");
		} else 
		{
			test.log(Status.FAIL, "Failed to Enter Room Name");
			logger.error("Failed to Enter Room Name");
		}
	}
	
	public void code(String roomCode)
	{
		if (Room_Code.isDisplayed()) 
		{			
			Room_Code.sendKeys(roomCode + SeleniumRepo.getRandomAlphNumeircString(2) );
			test.log(Status.INFO, "Room Code is entered successfully");
			logger.info("Room code is entered successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter Room Code");
			logger.error("Failed to Enter Room Code");
		}
	}
	public void GDS_Code()
	{
		SeleniumRepo.waitForElementPresent(Room_GDS_Code);
		if (SeleniumRepo.isElementPresent(Room_GDS_Code)) {
			Room_GDS_Code.sendKeys(SeleniumRepo.getRandomAlphNumeircString(3));
			test.log(Status.INFO, "Room GDS Code is entered successfully");
			logger.info("Room GDS code is entered successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter Room GDS Code");
			logger.error("Failed to Enter Room GDS Code");
		}

	}
	public void bed_types() throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Room_Bed_Types);
		if (SeleniumRepo.isElementPresent(Room_Bed_Types)) 
		{
			Room_Bed_Types.click();Thread.sleep(3000);
			test.log(Status.INFO, "Clicked on Room Applicable Bed Types");
			logger.info("Clicked on Room Applicable Bed Types");
		}
		else 
		{
			test.log(Status.FAIL, "Failed to Click on Room Applicable Bed Types ");
			logger.error("Failed to Click on Room Applicable Bed Types ");
		}
		
		if (List_of_Beds.size()>0) 
		{
			SeleniumRepoCheckBox.selectRandomCheckbox(List_of_Beds);
			
			test.log(Status.INFO, "Selected random bed type from list of available beds");
			logger.info("Selected random bed type from list of available beds");
		} 
		else 
		{
			test.log(Status.FAIL, "Failed to Select Random bed type ");
			logger.error("Failed to Select Random bed type ");
		}
		if (SeleniumRepo.isElementPresent(Add_btn))
		{
			Add_btn.click();
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.INFO, "Clicked on add button successfully");
			logger.info("Clicked on add button successfully");
		} 
		else
		{
			test.log(Status.FAIL, "Failed to Click on add button");
			logger.error("Failed to Click on add button");
		}
	}
	public void description(String roomShortDesc,String roomDetailedDesc)
	{
		SeleniumRepo.waitForElementPresent(Room_Short_Desc);
		if (SeleniumRepo.isElementPresent(Room_Short_Desc)) 
		{
			Room_Short_Desc.sendKeys(roomShortDesc);
			test.log(Status.INFO, "Room Short desc is entered successfully");
			logger.info("Room Short desc is entered successfully");
		}
		else 
		{
			test.log(Status.FAIL, "Failed to Enter Room Short desc");
			logger.error("Failed to Enter Room Short desc");
		}

		SeleniumRepo.waitForElementPresent(Room_Detailed_Desc);
		if (SeleniumRepo.isElementPresent(Room_Detailed_Desc))
		{
			Room_Detailed_Desc.sendKeys(roomDetailedDesc);
			test.log(Status.INFO, "Room Detailed desc is entered successfully");
			logger.info("Room Detailed desc is entered successfully");
		} 
		else 
		{
			test.log(Status.FAIL, "Failed to Enter Room Detailed desc");
			logger.error("Failed to Enter Room Detailed desc");
		}

		SeleniumRepo.waitForElementPresent(Room_Detailed_Desc);
		if (SeleniumRepo.isElementPresent(Room_Detailed_Desc))
		{
			Room_Detailed_Desc.sendKeys(roomDetailedDesc);
			test.log(Status.INFO, "Room Detailed desc is entered successfully");
			logger.info("Room Detailed desc is entered successfully");
		}
		else 
		{
			test.log(Status.FAIL, "Failed to Enter Room Detailed desc");
			logger.error("Failed to Enter Room Detailed desc");
		}
	}
	public void image(String roomImageName,String roomImageDesc,String roomImageAltText ,String roomImagePath)
	{
		SeleniumRepo.waitForElementPresent(Room_Upload_Image_Name);
		if (SeleniumRepo.isElementPresent(Room_Upload_Image_Name))
		{
			Room_Upload_Image_Name.sendKeys(roomImageName);
			test.log(Status.INFO, "Room Image Name is entered successfully");
			logger.info("Room Image Name is entered successfully");
		} 
		else 
		{
			test.log(Status.FAIL, "Failed to Enter Room Image Name");
			logger.error("Failed to Enter Room Image Name");
		}

		SeleniumRepo.waitForElementPresent(Room_Upload_Image_Desc);
		if (SeleniumRepo.isElementPresent(Room_Upload_Image_Desc))
		{
			Room_Upload_Image_Desc.sendKeys(roomImageDesc);
			test.log(Status.INFO, "Room Image Desc is entered successfully");
			logger.info("Room Image Desc is entered successfully");
		}
		else 
		{
			
			test.log(Status.FAIL, "Failed to Enter Room Image Desc");
			logger.error("Failed to Enter Room Image Desc");
		}

		SeleniumRepo.waitForElementPresent(Room_Upload_Image_Alt_Txt);
		if (SeleniumRepo.isElementPresent(Room_Upload_Image_Alt_Txt))
		{
			Room_Upload_Image_Alt_Txt.sendKeys(roomImageAltText);
			test.log(Status.INFO, "Room Image Alt Text is entered successfully");
			logger.info("Room Image Alt Text is entered successfully");
		}
		else
		{
			test.log(Status.FAIL, "Failed to Enter Room Image Alt Text");
			logger.error("Failed to Enter Room Image Alt Text");
		}

		SeleniumRepo.waitForElementPresent(Room_Upload_Image_Path);
		if (SeleniumRepo.isElementPresent(Room_Upload_Image_Path))
		{
			Room_Upload_Image_Path.sendKeys(System.getProperty("user.dir") + roomImagePath);
			test.log(Status.INFO, "Room Image Path is entered successfully");
			logger.info("Room Image Path is entered successfully");
		} 
		else
		{
			test.log(Status.FAIL, "Failed to Enter Room Image Path");
			logger.error("Failed to Enter Room Image Path");
		}
	}
	public void room_size(String roomSize, String subroomSize, String extraAdultCharge, String extraChildCharge,
			String maxadultPerRoom, String minAdultsPerRoom, String maxAdultsPerRoom, String minChildrenPerRoom,
			String maxChildrenPerRoom, String maxOccupancyPerRoom)
	{
		SeleniumRepo.waitForElementPresent(Room_Size);
		if (SeleniumRepo.isElementPresent(Room_Size)) {
			Room_Size.sendKeys(roomSize);
			test.log(Status.INFO, "Room Size is entered successfully");
			logger.info("Room Size is entered successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter Room Size");
			logger.error("Failed to Enter Room Size");
		}
		SeleniumRepo.waitForElementPresent(Room_Subrooms);
		if (SeleniumRepo.isElementPresent(Room_Subrooms)) {
			Room_Subrooms.clear();

			Room_Subrooms.sendKeys(subroomSize);
			test.log(Status.INFO, "Sub Room Size is entered successfully");
			logger.info("Sub Room Size is entered successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter Sub Room Size");
			logger.error("Failed to Enter Sub Room Size");
		}
		SeleniumRepo.waitForElementPresent(Extra_Adult_Charge_Per_Room);
		if (SeleniumRepo.isElementPresent(Extra_Adult_Charge_Per_Room)) {
			Extra_Adult_Charge_Per_Room.clear();

			Extra_Adult_Charge_Per_Room.sendKeys(extraAdultCharge);
			test.log(Status.INFO, "Extra adult charge is entered successfully");
			logger.info("Extra adult charge is entered successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter Extra adult charge");
			logger.error("Failed to Enter Extra adult charge");
		}

		SeleniumRepo.waitForElementPresent(Extra_Child_Charge_Per_Room);
		if (SeleniumRepo.isElementPresent(Extra_Child_Charge_Per_Room)) {
			Extra_Child_Charge_Per_Room.clear();

			Extra_Child_Charge_Per_Room.sendKeys(extraChildCharge);
			test.log(Status.INFO, "Extra Child charge is entered successfully");
			logger.info("Extra Child charge is entered successfully");
		} else {
			test.log(Status.FAIL, "Failed to Enter Extra Child charge");
			logger.error("Failed to Enter Extra Child charge");
		}

		SeleniumRepo.waitForElementPresent(Max_Occupancy_Per_Room);
		if (SeleniumRepo.isElementPresent(Max_Occupancy_Per_Room)) {
			SeleniumRepoDropdown.selectDropDownText(Max_Occupancy_Per_Room, maxadultPerRoom);
			if (Max_Occupancy_Per_Room.isSelected() == true) {
				test.log(Status.INFO, "Max adults per room is selected successfully");
				logger.info("Max adults per room is selected successfully");
			}

		} else {
			test.log(Status.FAIL, "Failed to Select Max adults per room");
			logger.error("Failed to Select Max adults per room");
		}

		SeleniumRepo.waitForElementPresent(Min_Adults_Per_Room);
		if (SeleniumRepo.isElementPresent(Min_Adults_Per_Room)) {
			Min_Adults_Per_Room.clear();
			Min_Adults_Per_Room.sendKeys(minAdultsPerRoom);
			test.log(Status.INFO, "Min Adults per room is entered successfully");
			logger.info("Min Adults per room is entered successfully");

		} else {
			test.log(Status.FAIL, "Failed to Enter Min Adults per room");
			logger.error("Failed to Enter Min Adults per room");
		}

		SeleniumRepo.waitForElementPresent(Max_Adults_Per_Room);
		if (SeleniumRepo.isElementPresent(Max_Adults_Per_Room)) {
			Max_Adults_Per_Room.clear();
			Max_Adults_Per_Room.sendKeys(maxAdultsPerRoom);
			test.log(Status.INFO, "Max Adults per room is entered successfully");
			logger.info("Max Adults per room is entered successfully");

		} else {
			test.log(Status.FAIL, "Failed to Enter Max Adults per room");
			logger.error("Failed to Enter Max Adults per room");
		}

		SeleniumRepo.waitForElementPresent(Min_Children_Per_Room);
		if (SeleniumRepo.isElementPresent(Min_Children_Per_Room)) {
			Min_Children_Per_Room.clear();
			Min_Children_Per_Room.sendKeys(minChildrenPerRoom);
			test.log(Status.INFO, "Min Children per room is entered successfully");
			logger.info("Min Children per room is entered successfully");

		} else {
			test.log(Status.FAIL, "Failed to Enter Min Children per room");
			logger.error("Failed to Enter Min Children per room");
		}

		SeleniumRepo.waitForElementPresent(Max_Children_Per_Room);
		if (SeleniumRepo.isElementPresent(Max_Children_Per_Room)) {
			Max_Children_Per_Room.clear();
			Max_Children_Per_Room.sendKeys(maxChildrenPerRoom);
			test.log(Status.INFO, "Max Children per room is entered successfully");
			logger.info("Max Children per room is entered successfully");

		} else {
			test.log(Status.FAIL, "Failed to Enter Max Children per room");
			logger.error("Failed to Enter Max Children per room");
		}
		SeleniumRepo.waitForElementPresent(Total_Max_Occupancy_Per_Room);
		if (SeleniumRepo.isElementPresent(Total_Max_Occupancy_Per_Room)) {

			Total_Max_Occupancy_Per_Room.sendKeys(maxOccupancyPerRoom);
			test.log(Status.INFO, "Max Occupancy per room is entered successfully");
			logger.info("Max Occupancy per room is entered successfully");

		} else {
			test.log(Status.FAIL, "Failed to Enter Max Occupancy per room");
			logger.error("Failed to Enter Max Occupancy per room");
		}

		SeleniumRepo.waitForElementPresent(Save_Btn);
		if (SeleniumRepo.isElementPresent(Save_Btn)) {
			Save_Btn.click();
			
			SeleniumRepo.waitForPageLoaded();
			test.log(Status.PASS,
					"Clicked on Save button" );
			logger.info("Clicked on Save button");
			Assert.assertTrue(true, "Clicked on Save button");
		} else {
			logger.info("Failed to Click on Save button");

			test.log(Status.FAIL, "Failed to Click on Save button");
		}
		SeleniumRepo.waitForElementPresent(Room_Type);
		if (SeleniumRepo.isElementPresent(Room_Type)) {
			test.log(Status.PASS,
					"Navigated to Room Type Screen" );
			logger.info("Navigated to Room Type Screen");
			Assert.assertTrue(true, "Navigated to Room Type Screen");
		} else {
			logger.info("Failed to Navigate to room Type");

			test.log(Status.FAIL, "Failed to Navigate to room Type");
		}
		
	}

}
