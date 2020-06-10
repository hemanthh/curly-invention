package com.tt.admin.pom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class guestProfilesLoyaltyBooking  extends BaseTest{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();
	
		
	public WebElement clickmaintab(String maintabname)
	{
		WebElement e = null;
		try {
		String xpath = String.format("//div[normalize-space(.)='%s']",maintabname);
		e = SeleniumRepo.driver.findElement(By.xpath(xpath));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return e;
	}
	
	public WebElement clicksubtab(String subtabname)
	{
		WebElement e = null;
		try {
		String xpath = String.format("//li[normalize-space(.)='%s']/a",subtabname);
		e = SeleniumRepo.driver.findElement(By.xpath(xpath));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return e;
	}
	
	@FindAll({ @FindBy(xpath = "//input[@id='isLoyaltyEnabled']") })
	public WebElement EnableingLoyalty ;
	
	@FindAll({ @FindBy(xpath = "//input[@id='isLoyaltyTierRatePlanYes']") })
	public WebElement NewRateplaneEnableingLoyalty;
	
	@FindAll({ @FindBy(xpath = "//button[@role and @type]/span") })
	public WebElement EnableingLoyaltyAccept;
	
	@FindAll({ @FindBy(xpath = "//input[@id='isLoyaltyDisabled_NO']") })
	public WebElement DisableLoyalty ;
	
	@FindAll({ @FindBy(xpath = "//select[@id='selectedConnectivitySolution']") })
	public WebElement SelectLoyaltyDropDown;
	
	@FindAll({ @FindBy(xpath = "//input[@name='Save']") })
	public WebElement SavePropertyDeafults;
	
	@FindAll({ @FindBy(xpath = "//input[@name='propertySubdomain']") })
	public WebElement PropertySubDomain;
	
	@FindAll({ @FindBy(xpath = "//fieldset[@id='lookupReservation']//a[@id='login-modal']") })
	public WebElement GuestProfileLogin;
	
	@FindAll({ @FindBy(xpath = "//fieldset[@id='lookupReservation']//a[@id='signup-modal']") })
	public WebElement GuestProfileSignup;
	
	@FindAll({ @FindBy(xpath = "//table[@id='CategoryContentDetail']//a[@name='editCategoryLink']") })
	public List<WebElement> RateplaneCategoryList;
	
	@FindAll({ @FindBy(xpath = "//table[@id='TagContentDetail']//a[@name='editTagLink']") })
	public List<WebElement> RoomCategoryList;
	
	@FindAll({ @FindBy(xpath = "//div[@id='tagNameID']/input") })
	public WebElement RoomAddNewCategory;
	
	@FindAll({ @FindBy(xpath = "//div[@id='addNewCategoryButton']/input") })
	public WebElement ClickAddNewCategory;
	
	@FindAll({ @FindBy(xpath = "//td/input[@name='tagName']") })
	public WebElement RoomCategoryName;
	
	@FindAll({ @FindBy(xpath = "//input[@id='categoryId']") })
	public WebElement CategoryName;
	
	@FindAll({ @FindBy(xpath = "//input[@name='Submit3']") })
	public WebElement SaveCategory;
	
	@FindAll({ @FindBy(xpath = "//select[@name='selectedTag']") })
	public WebElement SelectRoomCategory;
	
	@FindAll({ @FindBy(xpath = "//select[@name='selectedCategoryId']") })
	public WebElement SelectRateplaneCategory;
	
	@FindAll({ @FindBy(xpath = "//table[@id='dataTable']//td[not(contains(@class,'titleCopy'))]/..//td[3]") })
	public List<WebElement> RoomNames;
	
	@FindAll({ @FindBy(xpath = "//table[@id='dataTable']//td[not(@style)]") })
	public List<WebElement> LoyaltyTireList;
	
	@FindAll({ @FindBy(xpath = "//input[@name='btnAddNew']") })
	public WebElement LoyaltyTireAddNew;
	
	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Add New')]") })
	public WebElement AddNewTireToRatePlaneAssociation;
	
	@FindAll({ @FindBy(xpath = "//input[@id='loyaltyTierName']") })
	public WebElement LoyaltyTireName;
	
	@FindAll({ @FindBy(xpath = "//select[@id='loyaltyTierId']") })
	public WebElement TireSelection;
	
	@FindAll({ @FindBy(xpath = "//select[@id='ratePlanIds']") })
	public WebElement TireRatePlaneSelection;
	
	@FindAll({ @FindBy(xpath = "//select[@id='selectedPropertyId']") })
	public WebElement LoyaltyTireSelectHotel;
	
	@FindAll({ @FindBy(xpath = "//input[@value='Save']") })
	public WebElement LoyaltyTireSave;
	
	public WebElement ratePlaneEdit(String RatePlaneName)
	{
		WebElement e = null;
		try {
		String xpath = String.format("//td[text()='%s']/..//td/a[normalize-space(.)='Edit']",RatePlaneName);
		e = SeleniumRepo.driver.findElement(By.xpath(xpath));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return e;
	}
	
	public void addNewLoyaltyTire(String LoyaltytireName,String HotelName) throws InterruptedException
	{
		boolean b=false;
		for(int i=0;i<=LoyaltyTireList.size()-1;i++) {
			if(LoyaltyTireList.get(i).getText().equals(LoyaltytireName))
				b=true;
		}
		if(!b) {
		LoyaltyTireAddNew.click();
		LoyaltyTireName.sendKeys(LoyaltytireName);
		selectByVisibleText(LoyaltyTireSelectHotel, HotelName);
		LoyaltyTireSave.click();
		}
		
	}
	
	public void addTiretoRatePlaneMapping(String Loyaltytireselect,String RatePlan) throws InterruptedException
	{
		boolean b=false;
		for(int i=0;i<=LoyaltyTireList.size()-1;i++) {
			if(LoyaltyTireList.get(i).getText().equals(Loyaltytireselect))
				b=true;
		}
		if(!b) {
		AddNewTireToRatePlaneAssociation.click();
		//LoyaltyTireName.sendKeys(LoyaltytireName);
		selectByVisibleText(TireSelection, Loyaltytireselect);
		selectByVisibleText(TireRatePlaneSelection, RatePlan);
		LoyaltyTireSave.click();
		}
		
	}
	
	public void clickonmainandsubtabs(String maintab,String subtab) throws InterruptedException
	{
		try {
		if(clicksubtab(subtab).isDisplayed())
		{
			clicksubtab(subtab).click();
		}
		else
		{
		  clickmaintab(maintab).click();
		  SeleniumRepo.waitForElementPresent(clicksubtab(subtab));
		  Thread.sleep(1000);
		  clicksubtab(subtab).click();
		}
		}
		catch(Exception e)
		{
			clickmaintab(maintab).click();
			SeleniumRepo.waitForElementPresent(clicksubtab(subtab));
			Thread.sleep(1000);
			clicksubtab(subtab).click();
		}
	}
	
	public void GoToUrl(String subdomain) throws IOException
	{
		String beurl=ReadProperties.getPropValues("Admin.properties", "BE.Environment");
		beurl="http://"+subdomain+beurl;
		System.out.println();
		SeleniumRepo.GoToUrl(beurl);
	}
	
	public void createRatePlaneCatagory(String categoryname)
	{
		try {
			boolean b=false;
			for(int i=0;i<=RateplaneCategoryList.size()-1;i++)
			{
				if(RateplaneCategoryList.get(i).getText().trim().equals(categoryname))
				{
					b=true;
				}
			}
			if(!b)
			{
				ClickAddNewCategory.click();
				CategoryName.sendKeys("Guest Profile Category");
				SaveCategory.click();
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void createRoomCatagory(String Roomcategoryname)
	{
		try {
			boolean b=false;
			for(int i=0;i<=RoomCategoryList.size()-1;i++)
			{
				if(RoomCategoryList.get(i).getText().trim().equals(Roomcategoryname))
				{
					b=true;
				}
			}
			if(!b)
			{
				RoomAddNewCategory.click();
				Thread.sleep(1000);
				RoomCategoryName.click();
				JavascriptExecutor jse = (JavascriptExecutor)SeleniumRepo.driver;
				jse.executeScript("arguments[0].value='"+Roomcategoryname+"'", RoomCategoryName);
				//RoomCategoryName.sendKeys(Roomcategoryname);
				SaveCategory.click();
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
    public Object[][] ExceldataProvider(String Sheetname) throws IOException {
		
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, Sheetname);

		return testObjArray;
	}
	
	@SuppressWarnings("unchecked")
	public void createRoomType(String sheetname,String Roomacategoryname) throws InterruptedException, IOException {
		try {
			Object[][] sheetdataobjects=ExceldataProvider(sheetname).clone();
			HashMap<String, String> h=new HashMap<String,String>();
			//RoomTypeCreation roomTypeCreation = PageFactory.initElements(SeleniumRepo.driver, RoomTypeCreation.class);
			//DeleteRoomsInList Delete =PageFactory.initElements(SeleniumRepo.driver, DeleteRoomsInList.class);
			ADD_Rooms ADD_Rooms = PageFactory.initElements(SeleniumRepo.driver, ADD_Rooms.class);

			for(int i=0;i<=sheetdataobjects.length-1;i++)
			{
				Object name=sheetdataobjects[i][0];
				h=(HashMap<String, String>) name;
			String roomName = h.get("RoomName").toString().trim();
			String roomCode = h.get("RoomCode").toString().trim();
			String roomShortDesc = h.get("RoomShortdescription").toString().trim();
			String roomDetailedDesc = h.get("RoomDetailedDescription").toString().trim();
			String roomImageName = h.get("RoomUploadImageName").toString().trim();
			String roomImageDesc = h.get("RoomUploadImageDescription").toString().trim();
			String roomImageAltText =h.get("RoomuploadImageAltText").toString().trim();
			String roomImagePath = h.get("roomImagePath").toString().trim();
			String roomSize = h.get("RoomSize").toString().trim();
			String subroomSize = h.get("SubRoomSize").toString().trim();
			String extraAdultCharge = h.get("extraAdultCharge").toString().trim();
			String extraChildCharge = h.get("ExtraChildCharge").toString().trim();
			String maxadultPerRoom = h.get("MaxAdultsInRoom").toString().trim();
			String minAdultsPerRoom = h.get("EnterMinAdultOccupancy").toString().trim();
			String maxAdultsPerRoom = h.get("EnterMaxAdultOccupancy").toString().trim();
			String minChildrenPerRoom = h.get("EnterMinChildOccupancy").toString().trim();
			String maxChildrenPerRoom = h.get("EnterMaxChildOccupancy").toString().trim();
			String maxOccupancyPerRoom =h.get("EnterTotlaMaxOccupancy").toString().trim();
			if(i==0) {
					ADD_Rooms.Rooms_link();
					ADD_Rooms.Click_Listall();
					}
			boolean b=false;
			for(int j=0;j<=RoomNames.size()-1;j++)
			{
				if(RoomNames.get(j).getText().trim().equals(roomName))
						b=true;
			}
			
			logger.info( "Delete and Create room" +roomName);
			
			System.out.println(maxOccupancyPerRoom);
			System.out.println("----------------------------------------");
		    if(!b) {
		  	ADD_Rooms.delete_rooms(roomName);
			ADD_Rooms.addnew(roomName);
			ADD_Rooms.name(roomName);
			ADD_Rooms.code(roomCode);
			//ADD_Rooms.GDS_Code();
			selectByVisibleText(SelectRoomCategory,Roomacategoryname);
			ADD_Rooms.bed_types();
			ADD_Rooms.description(roomShortDesc, roomDetailedDesc);
			ADD_Rooms.image(roomImageName, roomImageDesc, roomImageAltText, roomImagePath);
			ADD_Rooms.room_size(roomSize, subroomSize, extraAdultCharge, extraChildCharge, maxadultPerRoom, minAdultsPerRoom, maxAdultsPerRoom, minChildrenPerRoom, maxChildrenPerRoom, maxOccupancyPerRoom);
			
			System.out.println("------------room name "+roomName+" deleted and created");
			logger.info("------------room name "+roomName+" deleted and created");
			test.log(Status.INFO, "------------room name "+roomName+" deleted and created");
		    }
			h.clear();
		
		}
		}catch (Exception e) {
			logger.error("Unable to create room type for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create room type for selected property because of this execption" + e);
			
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}
	}
	@SuppressWarnings("unchecked")
	public void addNewRateplane(String sheetname,String category) throws InterruptedException, IOException {
		try 
		{
			Object[][] sheetdataobjects=ExceldataProvider(sheetname).clone();
			HashMap<String, String> h=new HashMap<String,String>();
			AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
			logger.info("Creating Rateplan");
			for(int i=0;i<=sheetdataobjects.length-1;i++)
			{
				Object name=sheetdataobjects[i][0];
				h=(HashMap<String, String>) name;
			String Name = h.get("Name").toString().trim();
			String Ratecode = h.get("Ratecode").toString().trim();
			//String Category = h.get("Category").toString().trim();
			String ShortDescription = h.get("ShortDescription").toString().trim();
			String imagePath = h.get("imagePath").toString().trim();
			String MinLeadtime = h.get("MinLeadtime").toString().trim();
			String MaxLeadtime = h.get("MaxLeadtime").toString().trim();
			String MinLos = h.get("MinLos").toString().trim();
			String MaxLos = h.get("MaxLos").toString().trim();
			String Usrinput = h.get("Usrinput").toString().trim();
			String EnterSelectedpolicyid = h.get("EnterSelectedpolicyid").toString().trim();
			String AdditionalNotes = h.get("AdditionalNotes").toString().trim();
			String AgentComment = h.get("AgentComment").toString().trim();
			//String Rateplan = h.get("Rateplan").toString().trim();
			
			NewRatePlan.click_Rateplan();
			NewRatePlan.click_Listall();
			NewRatePlan.Name_Search(Name);
			NewRatePlan.delete_rateplan(Name);
			NewRatePlan.Click_Addnew();
			NewRatePlan.Enter_Name(Name);
			NewRatePlan.Ratecode(Ratecode);
			NewRatePlan.Select_Category(category);
			NewRatePlan.ShortDescription(ShortDescription);
			NewRatePlan.Click_Choosefile(imagePath);
			NewRatePlan.selectRoomType();
			NewRatePlan.Book_startdate();
			NewRatePlan.Booking_Enddate();
			NewRatePlan.Checkin_startdate();
			NewRatePlan.checkout_date();
			NewRatePlan.minLeadtime(MinLeadtime);
			NewRatePlan.MaxLeadtime(MaxLeadtime);
			NewRatePlan.MinLos(MinLos);
			NewRatePlan.MaxLos(MaxLos);
			NewRateplaneEnableingLoyalty.click();
			EnableingLoyaltyAccept.click();
			NewRatePlan.CallCentersearch();
			NewRatePlan.display_offers();
			NewRatePlan.Select_Basicpolicy();
			NewRatePlan.selectpolicyid(EnterSelectedpolicyid);
			NewRatePlan.inventory_BaseRatePlan(Usrinput);
			/*NewRatePlan.deriverates();
			NewRatePlan.Selectrateplan(Rateplan);*/
			NewRatePlan.Rooms_inventory();
			NewRatePlan.notes(AdditionalNotes, AgentComment);
			NewRatePlan.click_save();
					
		} 
		}catch (Exception e) {
			logger.error("Unable to create Rate Plan" + e);
			test.log(Status.ERROR, "Unable to create Rate Plan" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
		}
	
	@SuppressWarnings("unchecked")
	public void addNewrategrid(String sheetname) throws InterruptedException, IOException 
	{
		try {
			Object[][] sheetdataobjects=ExceldataProvider(sheetname).clone();
			HashMap<String, String> h=new HashMap<String,String>();
			AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
			logger.info("Creating Rateplan");
			for(int i=0;i<=sheetdataobjects.length-1;i++)
			{
				Object name=sheetdataobjects[i][0];
				h=(HashMap<String, String>) name;
			RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);
		
			logger.info("Creating RateGrid");
			String EnterValue = h.get("EnterValue").toString().trim();
			//NewRategrid.rate(EnterValue);
			//NewRategrid.Click_RatesandInventory();
			NewRategrid.Click_RateGrid();
			NewRategrid.Click_ManageDropdown(EnterValue);
			//NewRategrid.Select_all();
			//NewRategrid.Searchfield("BAR");
			NewRategrid.select_offer("BAR");
			NewRategrid.select_offer("Stay2NightsAndGet25PerCentOFFBAR");
			NewRategrid.Click_Continue();
			NewRategrid.Enter_Startdate();
			NewRategrid.Enter_Enddate();
			NewRategrid.rateandinventory();
			NewRategrid.Click_Update();
			NewRategrid.Click_RateGrid();
			}
		} 
		catch (Exception e) 
		{
			logger.error("Unable to create Rate Grid" + e);
			test.log(Status.ERROR, "Unable to create Rate Grid" + e);
			e.printStackTrace();
			Assert.assertEquals(false,true);
		}
		}
//	public void be_Startdate() throws InterruptedException
//	{
//		
//		Thread.sleep(3000);
//		ExplicitWait(Enter_Startdate);
//		Date date1 = new Date();
//		date1.setDate(date1.getDate());
//		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
//		String formattedDate1 = df1.format(date1);
//
//		date1.setDate(date1.getDate() + 1);
//		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/YY");
//		formattedDate2=df2.format(date1);
//
//		Javascriptexecutor(Enter_Startdate);
//		Enter_Startdate.sendKeys(formattedDate2);
//		test.log(Status.INFO, "Clicked on startingdate Link");
//		logger.info("Clicked on startingdate Link");
//		Assert.assertTrue(true, "Clicked on startingdate Link");
//
//	}
//	public void be_Enddate() throws InterruptedException
//	{
//		Date date = new Date();
//		date.setDate(date.getDate() + 7);
//		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
//		formattedDate = df.format(date);
//
//		/*date=date+7;
//
//		String Month2=Integer.toString(Month);
//		String date2=Integer.toString(date);
//
//		Enddate=Month2+"/"+date2+"/"+year;*/
//
//
//		//Enddate=Admin_Enddate();
//		ExplicitWait(Enter_Enddate);
//
//		System.out.println("departure date is "+formattedDate);
//
//		logger.info("departure date is "+formattedDate);
//
//		Javascriptexecutor(Enter_Enddate);
//
//
//		Enter_Enddate.clear();
//
//		TypeInField(Enter_Enddate, formattedDate);
//		System.out.println("Enddate is entered successfully");
//		test.log(Status.INFO, "Enddate is entered successfully");
//
//		Thread.sleep(1000);
//		Javascriptexecutor(Click_overrideRoomHierarchy);
//		SeleniumRepo.waitForPageLoaded();
//
//		test.log(Status.INFO, "Clicked on overrideRoomHierarchy");
//		logger.info("Clicked on overrideRoomHierarchy");
//
//
//		Javascriptexecutor(Click_dailyrate);
//
//		SeleniumRepo.waitForPageLoaded();
//
//		System.out.println("Clicked on dailyrate successfully");
//		test.log(Status.INFO, "Clicked on dailyrate successfully");
//		Assert.assertTrue(true, "Clicked on dailyrate successfully");
//
//	}
	
}
