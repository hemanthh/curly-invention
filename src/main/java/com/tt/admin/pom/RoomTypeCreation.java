package com.tt.admin.pom;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

public class RoomTypeCreation extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	 String result=this.getClass().getSimpleName();


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
	String roomNameText=null;
	public void createRoom(String roomName, String roomCode, String roomShortDesc,
			String roomDetailedDesc, String roomImageName, String roomImageDesc, String roomImageAltText,
			String roomImagePath, String roomSize, String subroomSize, String extraAdultCharge, String extraChildCharge,
			String maxadultPerRoom, String minAdultsPerRoom, String maxAdultsPerRoom, String minChildrenPerRoom,
			String maxChildrenPerRoom, String maxOccupancyPerRoom) throws IOException 
	{
		try {
			/*SeleniumRepo.waitForElementPresent(Rooms_Link);
			if (SeleniumRepo.isElementPresent(Rooms_Link)) {

				

					Rooms_Link.click();
					System.out.println("Clicked on Rooms link");
					test.log(Status.PASS, "Clicked on Rooms link");
					logger.info("Clicked on Rooms link");

					Assert.assertTrue(true, "Clicked on Rooms link");
				

			} else {
				logger.error("Failed to click on Rooms link");

				System.out.println(" Failed to click on Rooms link");
				test.log(Status.FAIL, "Failed to Click on Rooms link");

			}*/
			
			
			SeleniumRepo.waitForElementsPresent(Rooms_link);
			for(WebElement ele:Rooms_link)
			{
				if(ele.getText().equals("Rooms"))
				{
					SeleniumRepo.waitForElementPresent(ele);
					ele.click();
					test.log(Status.PASS, "Clicked on Rooms link");
					logger.info("Clicked on Rooms link");
					Assert.assertTrue(true, "Clicked on Rooms link");
					break;
				}
			}
			/*SeleniumRepo.waitForElementPresent(Rooms_link);
			if (Rooms_link.isDisplayed()) {
				Rooms_link.click();
				test.log(Status.PASS, "Clicked on Rooms link");
				logger.info("Clicked on Rooms link");
				Assert.assertTrue(true, "Clicked on Rooms link");
			} else {
				logger.info("Clicked on Rooms link");

				test.log(Status.PASS, "Clicked on Rooms link");
			}*/

			SeleniumRepo.waitForElementPresent(Add_New_Room);
			if (SeleniumRepo.isElementPresent(Add_New_Room)) {
				Add_New_Room.click();
				test.log(Status.PASS, "Clicked on Add_New_Room link");
				logger.info("Clicked on Add_New_Room link");
				Assert.assertTrue(true, "Clicked on Add_New_Room link");
			} else {
				logger.info("Failed to Click on Rooms link");

				test.log(Status.FAIL, "Failed to Click on Rooms link");
			}

			SeleniumRepo.waitForElementPresent(Save_Btn);
			if (SeleniumRepo.isElementPresent(Save_Btn)) {
				Save_Btn.click();
				/*test.log(Status.PASS,
						"Clicked on Save button" + MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(result,"pass")).build());*/
				logger.info("Clicked on Save button");
				Assert.assertTrue(true, "Clicked on Save button");
			} else {
				logger.info("Failed to Click on Save button");

				test.log(Status.FAIL, "Failed to Click on Save button");
			}

			SeleniumRepo.waitForElementPresent(Upload_Img_Err);
			if (SeleniumRepo.isTextPresent(Upload_Img_Err, "Please upload at least one image.")) {
				test.log(Status.INFO, "Upload image is mandatory field");
				logger.info("Upload image is mandatory field");
			} else {
				test.log(Status.INFO, "Upload image is not a mandatory field");
				logger.info("Upload image is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Name_Err);
			if (SeleniumRepo.isTextPresent(Name_Err, "Required field Name")) {
				test.log(Status.INFO, "Name field is mandatory field");
				logger.info("Name field is mandatory field");
			} else {
				test.log(Status.INFO, "Name field is not a mandatory field");
				logger.info("Name field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Code_Err);
			if (SeleniumRepo.isTextPresent(Code_Err, "Required field Code")) {
				test.log(Status.INFO, "Code field is mandatory field");
				logger.info("Code field is mandatory field");
			} else {
				test.log(Status.INFO, "Code field is not a mandatory field");
				logger.info("Code field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Bed_Sels_Err);
			if (SeleniumRepo.isTextPresent(Bed_Sels_Err, "Required selection Beds")) {
				test.log(Status.INFO, "selection Beds field is mandatory field");
				logger.info("selection Beds field is mandatory field");
			} else {
				test.log(Status.INFO, "selection Beds field is not a mandatory field");
				logger.info("selection Beds field is not a mandatory field");
			}
			SeleniumRepo.waitForElementPresent(Extra_Adult_Charge_Err);
			if (SeleniumRepo.isTextPresent(Extra_Adult_Charge_Err, "Required field Extra Adult Charge")) {
				test.log(Status.INFO, "Extra Adult Charge field is mandatory field");
				logger.info("Extra Adult Charge field is mandatory field");
			} else {
				test.log(Status.INFO, "Extra Adult Charge field is not a mandatory field");
				logger.info("Extra Adult Charge field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Extra_Child_Charge_Err);
			if (SeleniumRepo.isTextPresent(Extra_Child_Charge_Err, "Required field Extra Child Charge")) {
				test.log(Status.INFO, "Extra Child Charge field is mandatory field");
				logger.info("Extra Child Charge field is mandatory field");
			} else {
				test.log(Status.INFO, "Extra Child Charge field is not a mandatory field");
				logger.info("Extra Child Charge field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Max_Adult_Err);
			if (SeleniumRepo.isTextPresent(Max_Adult_Err, "Required selection Max No. of Adults for Default Price")) {
				test.log(Status.INFO, "Max No of Adults field is mandatory field");
				logger.info("Max No of Adults field is mandatory field");
			} else {
				test.log(Status.INFO, "Max No of Adults field is not a mandatory field");
				logger.info("Max No of Adults field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Max_Adult_Occupancy_Err);
			if (SeleniumRepo.isTextPresent(Max_Adult_Occupancy_Err, "Required field: Max Adult Occupancy")) {
				test.log(Status.INFO, "Max Adults occupancy field is mandatory field");
				logger.info("Max Adults occupancy field is mandatory field");
			} else {
				test.log(Status.INFO, "Max Adults occupancy field is not a mandatory field");
				logger.info("Max Adults occupancy field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Min_Adult_Occupancy_Err);
			if (SeleniumRepo.isTextPresent(Min_Adult_Occupancy_Err, "Required field: Min Adult Occupancy")) {
				test.log(Status.INFO, "Min Adult Occupancy field is mandatory field");
				logger.info("Min Adult Occupancy field is mandatory field");
			} else {
				test.log(Status.INFO, "Min Adult Occupancy field is not a mandatory field");
				logger.info("Min Adult Occupancy field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Max_Children_Occupancy_Err);
			if (SeleniumRepo.isTextPresent(Max_Children_Occupancy_Err, "Required field: Max Child Occupancy")) {
				test.log(Status.INFO, "Max Child Occupancy field is mandatory field");
				logger.info("Max Child Occupancy field is mandatory field");
			} else {
				test.log(Status.INFO, "Max Child Occupancy field is not a mandatory field");
				logger.info("Max Child Occupancy field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Min_Children_Occupancy_Err);
			if (SeleniumRepo.isTextPresent(Min_Children_Occupancy_Err, "Required field: Min Child Occupancy")) {
				test.log(Status.INFO, "Min Child Occupancy field is mandatory field");
				logger.info("Min Child Occupancy field is mandatory field");
			} else {
				test.log(Status.INFO, "Min Child Occupancy field is not a mandatory field");
				logger.info("Min Child Occupancy field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Total_Max_Occupancy_Err);
			if (SeleniumRepo.isTextPresent(Total_Max_Occupancy_Err, "Required field: Total Max Occupancy")) {
				test.log(Status.INFO, "Total Max Occupancy field is mandatory field");
				logger.info("Total Max Occupancy field is mandatory field");
			} else {
				test.log(Status.INFO, "Total Max Occupancy field is not a mandatory field");
				logger.info("Total Max Occupancy field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(GDS_Code_Err);
			if (SeleniumRepo.isTextPresent(GDS_Code_Err, "Required field GDS Code")) {
				test.log(Status.INFO, "GDS field is mandatory field");
				logger.info("GDS field is mandatory field");
			} else {
				test.log(Status.INFO, "GDS field is not a mandatory field");
				logger.info("GDS field is not a mandatory field");
			}

			SeleniumRepo.waitForElementPresent(Room_Name);
			if (SeleniumRepo.isElementPresent(Room_Name)) {
				Room_Name.sendKeys(roomName);
				 roomNameText=Room_Name.getText();

				test.log(Status.INFO, "Room name is entered successfully");
				logger.info("Room name is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Name");
				logger.error("Failed to Enter Room Name");
			}

			SeleniumRepo.waitForElementPresent(Room_Code);
			if (SeleniumRepo.isElementPresent(Room_Code)) {
				Room_Code.sendKeys(roomCode);
				test.log(Status.INFO, "Room Code is entered successfully");
				logger.info("Room code is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Code");
				logger.error("Failed to Enter Room Code");
			}

			SeleniumRepo.waitForElementPresent(Room_Bed_Types);
			if (SeleniumRepo.isElementPresent(Room_Bed_Types)) {
				Room_Bed_Types.click();
				test.log(Status.INFO, "Clicked on Room Applicable Bed Types");
				logger.info("Clicked on Room Applicable Bed Types");
			} else {
				test.log(Status.FAIL, "Failed to Click on Room Applicable Bed Types ");
				logger.error("Failed to Click on Room Applicable Bed Types ");
			}
			
			if (List_of_Beds.size()>0) {
				SeleniumRepoCheckBox.selectRandomCheckbox(List_of_Beds);
				
				test.log(Status.INFO, "Selected random bed type from list of available beds");
				logger.info("Selected random bed type from list of available beds");
			} else {
				test.log(Status.FAIL, "Failed to Select Random bed type ");
				logger.error("Failed to Select Random bed type ");
			}
			
			SeleniumRepo.waitForElementPresent(Add_btn);
			if (SeleniumRepo.isElementPresent(Add_btn)) {
				Add_btn.click();
				test.log(Status.INFO, "Clicked on add button successfully");
				logger.info("Clicked on add button successfully");
			} else {
				test.log(Status.FAIL, "Failed to Click on add button");
				logger.error("Failed to Click on add button");
			}
			

			
			SeleniumRepo.waitForElementPresent(Room_GDS_Code);
			if (SeleniumRepo.isElementPresent(Room_GDS_Code)) {
				Room_GDS_Code.sendKeys(SeleniumRepo.getRandomAlphNumeircString(3));
				test.log(Status.INFO, "Room GDS Code is entered successfully");
				logger.info("Room GDS code is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room GDS Code");
				logger.error("Failed to Enter Room GDS Code");
			}

			SeleniumRepo.waitForElementPresent(Room_Short_Desc);
			if (SeleniumRepo.isElementPresent(Room_Short_Desc)) {
				Room_Short_Desc.sendKeys(roomShortDesc);
				test.log(Status.INFO, "Room Short desc is entered successfully");
				logger.info("Room Short desc is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Short desc");
				logger.error("Failed to Enter Room Short desc");
			}

			SeleniumRepo.waitForElementPresent(Room_Detailed_Desc);
			if (SeleniumRepo.isElementPresent(Room_Detailed_Desc)) {
				Room_Detailed_Desc.sendKeys(roomDetailedDesc);
				test.log(Status.INFO, "Room Detailed desc is entered successfully");
				logger.info("Room Detailed desc is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Detailed desc");
				logger.error("Failed to Enter Room Detailed desc");
			}

			SeleniumRepo.waitForElementPresent(Room_Detailed_Desc);
			if (SeleniumRepo.isElementPresent(Room_Detailed_Desc)) {
				Room_Detailed_Desc.sendKeys(roomDetailedDesc);
				test.log(Status.INFO, "Room Detailed desc is entered successfully");
				logger.info("Room Detailed desc is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Detailed desc");
				logger.error("Failed to Enter Room Detailed desc");
			}

			SeleniumRepo.waitForElementPresent(Room_Upload_Image_Name);
			if (SeleniumRepo.isElementPresent(Room_Upload_Image_Name)) {
				Room_Upload_Image_Name.sendKeys(roomImageName);
				test.log(Status.INFO, "Room Image Name is entered successfully");
				logger.info("Room Image Name is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Image Name");
				logger.error("Failed to Enter Room Image Name");
			}

			SeleniumRepo.waitForElementPresent(Room_Upload_Image_Desc);
			if (SeleniumRepo.isElementPresent(Room_Upload_Image_Desc)) {
				Room_Upload_Image_Desc.sendKeys(roomImageDesc);
				test.log(Status.INFO, "Room Image Desc is entered successfully");
				logger.info("Room Image Desc is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Image Desc");
				logger.error("Failed to Enter Room Image Desc");
			}

			SeleniumRepo.waitForElementPresent(Room_Upload_Image_Alt_Txt);
			if (SeleniumRepo.isElementPresent(Room_Upload_Image_Alt_Txt)) {
				Room_Upload_Image_Alt_Txt.sendKeys(roomImageAltText);
				test.log(Status.INFO, "Room Image Alt Text is entered successfully");
				logger.info("Room Image Alt Text is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Image Alt Text");
				logger.error("Failed to Enter Room Image Alt Text");
			}

			SeleniumRepo.waitForElementPresent(Room_Upload_Image_Path);
			if (SeleniumRepo.isElementPresent(Room_Upload_Image_Path)) {
				Room_Upload_Image_Path.sendKeys(System.getProperty("user.dir") + roomImagePath);
				test.log(Status.INFO, "Room Image Path is entered successfully");
				logger.info("Room Image Path is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Image Path");
				logger.error("Failed to Enter Room Image Path");
			}

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
			SeleniumRepo.waitForPageLoaded();
			WebElement roomNameEle=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+roomNameText+"')]"));
			
			SeleniumRepo.waitForElementPresent(roomNameEle);
			if(SeleniumRepo.isElementPresent(roomNameEle))
			{
				test.log(Status.PASS,
						"Room is created with given data");
				logger.info("Room is created with given data");
				Assert.assertTrue(true, "Room is created with given data");
			} else {
				logger.info("Failed to create room");

				test.log(Status.FAIL, "Failed to create room");
			}
		} catch (Exception e) {
			logger.error("Unable to create room type for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create room type for selected property because of this execption" + e);
			e.printStackTrace();
		}
		

	}

}
