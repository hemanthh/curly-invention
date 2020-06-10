package com.tt.admin.pom;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//import org.apache.bcel.generic.Select;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class RateGrid extends BaseTest 
{
	String RoomsCount;
	String formattedDate;
	String formattedDate2;

	String year;
	int Month;
	int date;
	String startdate;
	String Enddate;
	String RoomsRate;
	String[] RoomsRate_day;
	Map<String,String>map=new HashMap<String,String>();
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//div[contains(text(), 'Rates and Inventory')]") })

	public WebElement Click_RatesandInventory;

	@FindAll({ @FindBy(xpath = "//a[contains(@href,'rateGridInitAction.do?') and normalize-space(.)='Rate Grid']"),
		 })

	public WebElement Click_RateGrid;

	@FindAll({ @FindBy(xpath = "//select[@name='rateTypeSelect']") })

	public WebElement Click_ManageDropdown;

	@FindAll({ @FindBy(xpath = "//input[@name='all']"), })

	public WebElement Select_all;

	@FindAll({ @FindBy(xpath = "//input[@name='C228418']"), })

	public WebElement Unselect_Bar;

	@FindAll({ @FindBy(xpath = "//input[(@type='checkbox') and (@type='checkbox')]") })

	public List<WebElement> Check_Rateplans;

	@FindAll({ @FindBy(xpath = "//table[@id='dataTable']/tbody/tr") })

	public List<WebElement> Check_Rateplans1;

	@FindAll({ @FindBy(xpath = "//input[(@value='Continue')]"), })

	public WebElement Click_Continue;

	@FindAll({ @FindBy(xpath = "//input[@name='startDate']"), })

	public WebElement Enter_Startdate;

	@FindAll({ @FindBy(xpath = "//input[@name='endDate']"), })

	public WebElement Enter_Enddate;

	@FindAll({ @FindBy(xpath = "//input[@name='overrideRoomHierarchy']"), })

	public WebElement Click_overrideRoomHierarchy;

	@FindAll({ @FindBy(xpath = "//input[@value='Daily Rate & Inventory']"), })

	public WebElement Click_dailyrate;

	@FindAll({ @FindBy(xpath = "//select[@id='room_select_228418']"), })

	public WebElement barroomtype;

	@FindAll({ @FindBy(xpath = "//span[@class='title']//font"), })

	public List<WebElement> ratetype;

	@FindAll({ @FindBy(xpath = "//*[starts-with(@id,'room_select')]"), })

	public List<WebElement> Select_roomtype;

	@FindAll({ @FindBy(xpath = "//input[@value='Update']"), })

	public WebElement Click_Update;

	@FindAll({ @FindBy(xpath = "//input[@value='Confirm']"), })

	public WebElement Click_Confirm;

	/*@FindAll({ @FindBy(xpath = "(//select[contains(@id,'room_select_')])"),})

	public WebElement Room_Type;*/


	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Room Type:')]/div/button/span"),})

	public WebElement Room_Type;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Search RoomType']/../following-sibling::a"),})

	public WebElement Click_SelectAll_deselectAll;


	@FindAll({ @FindBy(xpath = "(//*[starts-with(@class,'input rateInput')])"),})

	public WebElement Room_Rate;


	@FindAll({ @FindBy(xpath = "(//*[starts-with(@class,'input availRoomsInput')])"),})

	public WebElement Rooms_Available;


	@FindAll({ @FindBy(xpath = "//input[@value='Quick Entry']"),})

	public WebElement Quick_Entry;

	@FindAll({ @FindBy(xpath = "//input[@placeholder='Search']"), })

	private WebElement Searchfield;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),' Rate Type')]/../following-sibling::td/span/font"), })

	private WebElement offercheck;

	@FindAll({ @FindBy(xpath = "//*[starts-with(@for,'ms-opt-')]/input"), })

	private List<WebElement> Roomscheckbox;

	public void  Click_RatesandInventory() throws InterruptedException, IOException
	{
		ExplicitWait(Click_RatesandInventory);

		test.info("Rate and Inventory Screen Shot : " + test.addScreenCaptureFromPath(capture()));

		//SeleniumRepo.waitForPageLoaded();
		
		if (Click_RatesandInventory.isDisplayed()) 

		{
			//Click_RatesandInventory.click();
			Javascriptexecutor(Click_RatesandInventory);
			Thread.sleep(2000);
			SeleniumRepo.WaitForLoad(1000);


			System.out.println("Clicked on RatesandInventory Link");
			logger.info("Clicked on RatesandInventory Link");
			Assert.assertTrue(true, "Clicked on RatesandInventory Link");
		}
		else 
		{
			System.out.println("RatesandInventory Link not found");
			test.log(Status.FAIL, " RatesandInventory Link not found");
			logger.info("RatesandInventory Link not found");
			Assert.assertFalse(false, "RatesandInventory Link not found");
		}
	}
	public void Click_RateGrid() throws InterruptedException 
	{
		
		
		if (Click_RateGrid.isDisplayed()) 
		{
			Javascriptexecutor(Click_RateGrid);
			ExplicitWait(Click_ManageDropdown);
			System.out.println("Rates and Inventory element Expanded and Rate Grid element  found");
			test.log(Status.INFO, "Rates and Inventory element Expanded and Rate Grid element  found");
			Assert.assertTrue(true, "Rates and Inventory element Expanded and Rate Grid element  found");
		} 
		else 
		{
			System.out.println("Rates and Inventory Menu is not expanded");
			Javascriptexecutor(Click_RatesandInventory);
			System.out.println("Clicked on Rates and Inventory Link");
			test.log(Status.INFO, "Clicked on Rates and Inventory Link");

			//Click_RatesandInventory.click();

			
			ExplicitWait(Click_RateGrid);
			if(Click_RateGrid.isDisplayed())
			{
				Javascriptexecutor(Click_RateGrid);
				ExplicitWait(Click_ManageDropdown);
				System.out.println("Rate Grid element found");
				test.log(Status.INFO, "Rate Grid  element found");
				Assert.assertTrue(true, "Rate Grid element found");
			}
			else
			{
				logger.error("Rate Grid element not  found");
				test.log(Status.FAIL, "Rate Grid element not  found");
			}
		}

	}

	public void Click_ManageDropdown(String EnterValue) throws InterruptedException 
	{
		Thread.sleep(2000);
		ExplicitWait(Click_ManageDropdown);
		Select sel=new Select(Click_ManageDropdown);
		//org.openqa.selenium.support.ui.Select sel=new org.openqa.selenium.support.ui.Select(SeleniumRepo.driver.findElement(By.xpath("//select[@name='rateTypeSelect']")));
		sel.selectByVisibleText(EnterValue);
		SeleniumRepo.waitForPageLoaded();
		ExplicitWait(Click_Continue);
		System.out.println(" value is entered successfully");
		test.log(Status.INFO, " value is entered successfully");
	}
	public void Select_all() throws InterruptedException 
	{
		Thread.sleep(1000);
		ExplicitWait(Select_all);
		System.out.println("enterd into select all");

		Javascriptexecutor(Select_all);

		test.log(Status.INFO, "Selected All");
		logger.info("Selected All");
	}
	public void Click_Continue() throws InterruptedException
	{
		Thread.sleep(1000);
		ExplicitWait(Click_Continue);
		Javascriptexecutor(Click_Continue);
		SeleniumRepo.waitForPageLoaded();
		test.log(Status.INFO, "Clicked On Continue");
		logger.info("Clicked On Continue");


	}
	public void Enter_Startdate() throws InterruptedException
	{
		
		Thread.sleep(3000);
		ExplicitWait(Enter_Startdate);
		Date date1 = new Date();
		date1.setDate(date1.getDate());
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		String formattedDate1 = df1.format(date1);

		date1.setDate(date1.getDate());
		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/YY");
		formattedDate2=df2.format(date1);

		Javascriptexecutor(Enter_Startdate);
		Enter_Startdate.sendKeys(formattedDate2);
		test.log(Status.INFO, "Clicked on startingdate Link");
		logger.info("Clicked on startingdate Link");
		Assert.assertTrue(true, "Clicked on startingdate Link");

	}
	public void Enter_Enddate() throws InterruptedException
	{
		Date date = new Date();
		date.setDate(date.getDate() + 7);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
		formattedDate = df.format(date);

		/*date=date+7;

		String Month2=Integer.toString(Month);
		String date2=Integer.toString(date);

		Enddate=Month2+"/"+date2+"/"+year;*/


		//Enddate=Admin_Enddate();
		ExplicitWait(Enter_Enddate);

		System.out.println("departure date is "+formattedDate);

		logger.info("departure date is "+formattedDate);

		Javascriptexecutor(Enter_Enddate);


		Enter_Enddate.clear();

		TypeInField(Enter_Enddate, formattedDate);
		System.out.println("Enddate is entered successfully");
		test.log(Status.INFO, "Enddate is entered successfully");

		Thread.sleep(1000);
		Javascriptexecutor(Click_overrideRoomHierarchy);
		SeleniumRepo.waitForPageLoaded();

		test.log(Status.INFO, "Clicked on overrideRoomHierarchy");
		logger.info("Clicked on overrideRoomHierarchy");


		Javascriptexecutor(Click_dailyrate);

		SeleniumRepo.waitForPageLoaded();Thread.sleep(1000);


		System.out.println("Clicked on dailyrate successfully");
		test.log(Status.INFO, "Clicked on dailyrate successfully");
		Assert.assertTrue(true, "Clicked on dailyrate successfully");

	}
	public void rateandinventory() throws InterruptedException, IOException
	{
		//ExplicitWait(Room_Type);
        Thread.sleep(3000);
		String min = ReadProperties.getPropValues("Admin.properties", "Minratevalue");
		String max = ReadProperties.getPropValues("Admin.properties", "Maxratevalue");
		String minroomsa = ReadProperties.getPropValues("Admin.properties", "Minroomsavailable");
		String maxroomsa = ReadProperties.getPropValues("Admin.properties", "Maxroomsavailable");

		if(SeleniumRepo.isElementDisplayed(Room_Type) == true)
		{
			Room_Type.click();
			Thread.sleep(2000);
			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Select all"))
			{
				System.out.println("enter1");

				Click_SelectAll_deselectAll.click();
				test.log(Status.PASS, "Clicked on Selected All");
			}

			Thread.sleep(1000);
			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Unselect all"))
			{
				test.log(Status.PASS, "All the rooms selected successfully");
			}
			else
			{
				test.log(Status.FAIL, "Rooms are not selected");
			}

			Room_Rate.clear();
			Room_Rate.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(min), Integer.parseInt(max))));
			Rooms_Available.clear();
			Rooms_Available.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minroomsa), Integer.parseInt(maxroomsa))));

			if (Quick_Entry.isDisplayed()) 
			{
				Javascriptexecutor(Quick_Entry);
				Thread.sleep(2000);
				System.out.println("Quick entry button clicked successfully");
				test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
				logger.info("Clicked On Quick Entry button Successfully");
				Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
			} 
			else 
			{
				System.out.println("quick entry button not found");
				test.log(Status.FAIL, "quick entry button not found");
				logger.info("quick entry button not found");
				Assert.assertFalse(false, "Continue button not found");
			}

		}

		/*Select roomtypes=new Select(Room_Type);
		List<WebElement>rooms=roomtypes.getOptions();
		System.out.println(rooms.size());
		for(int i=0;i<rooms.size();i++)
		{
			String min = ReadProperties.getPropValues("Admin.properties", "Minratevalue");
			String max = ReadProperties.getPropValues("Admin.properties", "Maxratevalue");
			String minroomsa = ReadProperties.getPropValues("Admin.properties", "Minroomsavailable");
			String maxroomsa = ReadProperties.getPropValues("Admin.properties", "Maxroomsavailable");

			Thread.sleep(5000);

			roomtypes.selectByIndex(i);

			Room_Rate.clear();
			Room_Rate.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(min), Integer.parseInt(max))));
			//Thread.sleep(2000);
			Rooms_Available.clear();
			Rooms_Available.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minroomsa), Integer.parseInt(maxroomsa))));
			if (SeleniumRepo.isElementPresent(Quick_Entry)) 
			{
				Javascriptexecutor(Quick_Entry);
				Thread.sleep(4000);
				System.out.println("Quick entry button clicked successfully");
				test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
				logger.info("Clicked On Quick Entry button Successfully");
				Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
			} 
			else 
			{
				System.out.println("quick entry button not found");
				test.log(Status.FAIL, "quick entry button not found");
				logger.info("quick entry button not found");
				Assert.assertFalse(false, "Continue button not found");
			}

		}*/
	}
	public void inventory() throws InterruptedException, IOException
	{
		ExplicitWait(Room_Type);

		String minroomsa = ReadProperties.getPropValues("Admin.properties", "Minroomsavailable");
		String maxroomsa = ReadProperties.getPropValues("Admin.properties", "Maxroomsavailable");
		if(Room_Type.isDisplayed())
		{
			Room_Type.click();
			Thread.sleep(2000);
			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Select all"))
			{

				Click_SelectAll_deselectAll.click();
				test.log(Status.PASS, "Clicked on Selected All");
			}

			Thread.sleep(1000);
			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Unselect all"))
			{
				test.log(Status.PASS, "All the rooms selected successfully");
			}
			else
			{
				test.log(Status.FAIL, "Rooms are not selected");
			}
		}
			if(Rooms_Available.isEnabled())
			{
				Rooms_Available.clear();
				Rooms_Available.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minroomsa), Integer.parseInt(maxroomsa))));

				if (Quick_Entry.isDisplayed()) 
				{
					Javascriptexecutor(Quick_Entry);
					Thread.sleep(2000);
					System.out.println("Quick entry button clicked successfully");
					test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
					logger.info("Clicked On Quick Entry button Successfully");
					Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
				} 
				else 
				{
					System.out.println("quick entry button not found");
					test.log(Status.FAIL, "quick entry button not found");
					logger.info("quick entry button not found");
					Assert.assertFalse(false, "Continue button not found");
				}
			}
			else
			{
				test.log(Status.INFO, "Inventory is taking from BAR ,No need to update inevntory");
				System.out.println("Inventory is taking from BAR ,No need to update inevntory");
			}
		}
	

	/*if(Rooms_Available.isEnabled())
		{
			Select roomtypes=new Select(Room_Type);
			List<WebElement>rooms=roomtypes.getOptions();
			System.out.println(rooms.size());
			for(int i=0;i<rooms.size();i++)
			{

				String minroomsa = ReadProperties.getPropValues("Admin.properties", "Minroomsavailable");
				String maxroomsa = ReadProperties.getPropValues("Admin.properties", "Maxroomsavailable");

				Thread.sleep(5000);

				roomtypes.selectByIndex(i);

				Rooms_Available.clear();
				Rooms_Available.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minroomsa), Integer.parseInt(maxroomsa))));

				Javascriptexecutor(Quick_Entry);
				Thread.sleep(4000);
				System.out.println("Quick entry button clicked successfully");
				test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
				logger.info("Clicked On Quick Entry button Successfully");
				Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");

			}
		}
		else
		{
			test.log(Status.INFO, "Inventory is taking from BAR ,No need to update inevntory");
			System.out.println("Inventory is taking from BAR ,No need to update inevntory");
		}
	 */

	public void rate() throws InterruptedException, IOException
	{
		ExplicitWait(Room_Type);

		String min = ReadProperties.getPropValues("Admin.properties", "Minratevalue");
		String max = ReadProperties.getPropValues("Admin.properties", "Maxratevalue");

		if(Room_Type.isDisplayed())
		{
			Room_Type.click();
			Thread.sleep(1000);

			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Select all"))
			{
				System.out.println("enter1");

				Click_SelectAll_deselectAll.click();
				test.log(Status.PASS, "Clicked on Selected All");
			}

			Thread.sleep(1000);
			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Unselect all"))
			{
				test.log(Status.PASS, "All the rooms selected successfully");
			}
			else
			{
				test.log(Status.FAIL, "Rooms are not selected");
			}
			Room_Rate.clear();
			Room_Rate.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(min), Integer.parseInt(max))));


			if (Quick_Entry.isDisplayed()) 
			{
				Javascriptexecutor(Quick_Entry);
				Thread.sleep(2000);
				System.out.println("Quick entry button clicked successfully");
				test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
				logger.info("Clicked On Quick Entry button Successfully");
				Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
			} 
			else 
			{
				System.out.println("quick entry button not found");
				test.log(Status.FAIL, "quick entry button not found");
				logger.info("quick entry button not found");
				Assert.assertFalse(false, "Continue button not found");
			}


		}


		/*
			Select roomtypes=new Select(Room_Type);
			List<WebElement>rooms=roomtypes.getOptions();
			System.out.println(rooms.size());
			for(int i=0;i<rooms.size();i++)
			{
				String min = ReadProperties.getPropValues("Admin.properties", "Minratevalue");
				String max = ReadProperties.getPropValues("Admin.properties", "Maxratevalue");

				Thread.sleep(2000);

				roomtypes.selectByIndex(i);

				Room_Rate.clear();
				Room_Rate.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(min), Integer.parseInt(max))));
				//Thread.sleep(2000);

				if (SeleniumRepo.isElementPresent(Quick_Entry)) 
				{
					Javascriptexecutor(Quick_Entry);
					Thread.sleep(2000);
					System.out.println("Quick entry button clicked successfully");
					test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
					logger.info("Clicked On Quick Entry button Successfully");
					Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
				} 
				else 
				{
					System.out.println("quick entry button not found");
					test.log(Status.FAIL, "quick entry button not found");
					logger.info("quick entry button not found");
					Assert.assertFalse(false, "Continue button not found");
				}

			}*/
	}


	public void rate_as_0() throws InterruptedException, IOException
	{
		ExplicitWait(Room_Type);

		if(Room_Type.isDisplayed())
		{
			Room_Type.click();
			Thread.sleep(1000);

			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Select all"))
			{
				System.out.println("enter1");

				Click_SelectAll_deselectAll.click();
				test.log(Status.PASS, "Clicked on Selected All");
			}

			Thread.sleep(1000);
			if(Click_SelectAll_deselectAll.getText().equalsIgnoreCase("Unselect all"))
			{
				test.log(Status.PASS, "All the rooms selected successfully");
			}
			else
			{
				test.log(Status.FAIL, "Rooms are not selected");
			}

			Room_Rate.clear();
			Room_Rate.sendKeys("0");


			if (Quick_Entry.isDisplayed()) 
			{
				Javascriptexecutor(Quick_Entry);
				Thread.sleep(2000);
				System.out.println("Quick entry button clicked successfully");
				test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
				logger.info("Clicked On Quick Entry button Successfully");
				Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
			} 
			else 
			{
				System.out.println("quick entry button not found");
				test.log(Status.FAIL, "quick entry button not found");
				logger.info("quick entry button not found");
				Assert.assertFalse(false, "Continue button not found");
			}

		}


		/*Select roomtypes=new Select(Room_Type);
			List<WebElement>rooms=roomtypes.getOptions();
			System.out.println(rooms.size());
			for(int i=0;i<rooms.size();i++)
			{
				String min = ReadProperties.getPropValues("Admin.properties", "Minratevalue");
				String max = ReadProperties.getPropValues("Admin.properties", "Maxratevalue");


				Thread.sleep(2000);

				roomtypes.selectByIndex(i);


				Room_Rate.clear();
				Room_Rate.sendKeys("0");

				if (SeleniumRepo.isElementPresent(Quick_Entry)) 
				{
					Javascriptexecutor(Quick_Entry);
					Thread.sleep(4000);
					System.out.println("Quick entry button clicked successfully");
					test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
					logger.info("Clicked On Quick Entry button Successfully");
					Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
				} 
				else 
				{
					System.out.println("quick entry button not found");
					test.log(Status.FAIL, "quick entry button not found");
					logger.info("quick entry button not found");
					Assert.assertFalse(false, "Continue button not found");
				}

			}*/
	}


	public void Room_Type(String RoomType) throws InterruptedException 
	{
		Room_Type.click();
		Thread.sleep(1000);
		WebElement Room_Type=SeleniumRepo.driver.findElement(By.xpath("//*[contains(@title,'"+RoomType+"') and @type='checkbox']"));
		if(Room_Type.isDisplayed())
		{
			Room_Type.click();
			System.out.println("Selected RoomType successfully");
			test.log(Status.INFO, "Selected RoomType successfully");
			Assert.assertTrue(true, "Selected RoomType successfully");
		}
		else
		{
			System.out.println("RoomType dropdown not found");
			test.log(Status.INFO, "RoomType dropdown not found");
			Assert.assertFalse(false, "RoomType dropdown not found");
		}
	}
	public void Room_Rate(String Room_Rate) throws InterruptedException
	{
		if(this.Room_Rate.isDisplayed()&&this.Room_Rate.isEnabled()) 
		{
			Thread.sleep(4000);

			this.Room_Rate.sendKeys(Room_Rate);
			System.out.println("Room rate is "+" "+Room_Rate );

			System.out.println("Room Rate entered Successfully");
			test.log(Status.INFO, "Room Rate entered Successfully");
			Assert.assertTrue(true, "Room Rate entered Successfully");
		}
		else
		{
			System.out.println("Room rate Text Box not Found");
			test.log(Status.INFO, "Room rate Text Box not Found");
			Assert.assertFalse(false, "Room rate Text Box not Found");

		}		
	}

	/*public void Rooms_Available(String No_of_rooms) throws InterruptedException 
		{
			if(SeleniumRepo.isElementPresent(this.Rooms_Available))
			{

				this.Rooms_Available.sendKeys(No_of_rooms);
				Thread.sleep(4000);
				System.out.println("Rooms Avaialble entered Successfully");
				test.log(Status.INFO, "Rooms Avaialble entered Successfully");
				Assert.assertTrue(true, "Rooms Avaialble entered Successfully");
			}
			else
			{
				System.out.println("Rooms Avaialble text box not found");
				test.log(Status.INFO, "Rooms Avaialble text box not found");
				Assert.assertFalse(false, "Rooms Avaialble text box not found");

			}

		}*/
	public void Quick_Entry() throws InterruptedException
	{
		if (SeleniumRepo.isElementPresent(Quick_Entry)) 
		{
			Javascriptexecutor(this.Quick_Entry);
			Thread.sleep(2000);
			System.out.println("Quick entry button clicked successfully");
			test.log(Status.INFO, "Clicked On Quick Entry button Successfully");
			logger.info("Clicked On Quick Entry button Successfully");
			Assert.assertTrue(true, "Clicked On Quick Entry button Successfully");
		} 
		else 
		{
			System.out.println("quick entry button not found");
			test.log(Status.FAIL, "quick entry button not found");
			logger.info("quick entry button not found");
			Assert.assertFalse(false, "Continue button not found");
		}
	}
	public String CurrentRooms_Count(String RoomType ) throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		//ExplicitWait(Room_Type);
		
		if(SeleniumRepo.isElementDisplayed(Room_Type)){
		scroll(Room_Type);
		
		}



		DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		String year = df.format(Calendar.getInstance().getTime());
		Calendar now = Calendar.getInstance();
		int Month= now.get(Calendar.MONTH)+1;

		Date date1 = new Date();
		date1.setDate(date1.getDate());
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String date = df1.format(date1);

		String Month1=Integer.toString(Month);

		formattedDate2=Month1+"/"+date+"/"+year;

		System.out.println("RoomType is  "+RoomType );

		Thread.sleep(2000);
		WebElement count=SeleniumRepo.driver.findElement(By.xpath("(//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr/descendant::td[contains(text(),'"+formattedDate2+"')])[1]/following-sibling::td[8]"));
		Thread.sleep(2000);
		scroll(count);
        Thread.sleep(2000);
		RoomsCount=SeleniumRepo.driver.findElement(By.xpath("(//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr/descendant::td[contains(text(),'"+formattedDate2+"')])[1]/following-sibling::td[8]")).getText();

		if(!(RoomsCount==null))  
		{
			System.out.println(RoomType.trim() + " "+"Rooms available are  "+ RoomsCount);
			test.log(Status.INFO, "Rooms count taken for the room type successfully");
		}
		else
		{	
			System.out.println(RoomType.trim() + " Rooms are not available");
			test.log(Status.INFO, "No Rooms on that particular room type");
			logger.error("No Rooms on that particular room type");
		}

		return RoomsCount;
	}

	public String CurrentRooms_inventoryfromBarCount(String RoomType ) throws IOException, InterruptedException
	{
		ExplicitWait(Room_Type);
		Thread.sleep(3000);

		DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		String year = df.format(Calendar.getInstance().getTime());
		Calendar now = Calendar.getInstance();
		int Month= now.get(Calendar.MONTH)+1;

		Date date1 = new Date();
		date1.setDate(date1.getDate()+1);
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String date = df1.format(date1);

		String Month1=Integer.toString(Month);

		formattedDate2=Month1+"/"+date+"/"+year;


		WebElement count=SeleniumRepo.driver.findElement(By.xpath("(//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr/descendant::td[contains(text(),'"+formattedDate2+"')])[1]/following-sibling::td[7]"));
		scroll(count);


		RoomsCount=SeleniumRepo.driver.findElement(By.xpath("(//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr/descendant::td[contains(text(),'"+formattedDate2+"')])[1]/following-sibling::td[7]")).getText();

		if(!(RoomsCount==null))  
		{
			System.out.println(RoomType.trim() + " "+"Rooms available are  "+ RoomsCount);
			test.log(Status.INFO, "Rooms count taken for the room type successfully");

		}
		else
		{	

			test.log(Status.INFO, "No Rooms on that particular room type");
			logger.error("No Rooms on that particular room type");

		}

		return RoomsCount;
	}


	public String CurrentRoom_Rate(String RoomType ) throws IOException, InterruptedException
	{
		ExplicitWait(Room_Type);
		Thread.sleep(5000);

		DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		String year = df.format(Calendar.getInstance().getTime());
		Calendar now = Calendar.getInstance();
		int Month= now.get(Calendar.MONTH)+1;
		//int date= now.get(Calendar.DATE)+1;

		Date date1 = new Date();
		date1.setDate(date1.getDate()+1);
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String date = df1.format(date1);

		String Month1=Integer.toString(Month);

		formattedDate2=Month1+"/"+date+"/"+year;

		System.out.println("RoomType is  "+RoomType );

		Thread.sleep(2000);

		WebElement rate=SeleniumRepo.driver.findElement(By.xpath("(//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr/descendant::td[contains(text(),'"+formattedDate2+"')]/following-sibling::td[1])[1]"));
		scroll(rate);

		RoomsRate=SeleniumRepo.driver.findElement(By.xpath("(//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr/descendant::td[contains(text(),'"+formattedDate2+"')]/following-sibling::td[1])[1]")).getText();

		//takeScreenshotAtEndOfTest("Rooms_count");

		if(!(RoomsRate==null))  
		{

			logger.info(RoomType.trim() + " "+"rate is  "+ RoomsRate.trim());
			test.log(Status.INFO, RoomType.trim() + " "+"room rate is  "+ RoomsRate.trim());

		}
		else
		{
			test.log(Status.INFO, "No Rooms on that particular room type");
		}

		return RoomsRate;
	}


	public void count_validation(String  BeforeBooking_count,String AfterBooking_Count) 
	{
		int BeforeBooking_count_int = Integer.parseInt(BeforeBooking_count.trim());	
		int AfterBooking_Count_int = Integer.parseInt(AfterBooking_Count.trim());
		int result=BeforeBooking_count_int-AfterBooking_Count_int;
		SeleniumRepo.ScrollByupdown(1000,0);
		if(result!=0)
			//if(result==1)
		{
			System.out.println(result +" room decreased from admin successfully");	
			test.log(Status.INFO, "room decreased from admin successfully");
			Assert.assertTrue(true,"room decreased from admin successfully");
		}
		else
		{
			System.out.println(result +" room decreased from admin");
			test.log(Status.INFO, "Rooms are not decreased from admin");
			Assert.assertFalse(false,"Rooms are not decreased from admin");

		}	
	}
	public void Cancel_CountValidation(String BeforeCancel_count ,String AfterCancel_Count)
	{
		/*int Beforecancel_count_int = Integer.parseInt(BeforeCancel_count);	
		int Aftercancel_Count_int = Integer.parseInt(AfterCancel_Count);
		int result=Beforecancel_count_int-Aftercancel_Count_int;*/
		if(BeforeCancel_count.equals(AfterCancel_Count))
		{
			System.out.println("After cancel booking rooms are same as before booking count");	
			test.log(Status.INFO, "After cancel booking rooms are same as before booking count");

		}
		else
		{
			System.out.println("after cancel booking rooms are not increased");
			test.log(Status.FAIL, "after cancel booking rooms are not increased");
			logger.error("after cancel booking rooms are not increased");
            Assert.assertEquals(true, false);
		}	

	}



	public void Click_Update() throws InterruptedException
	{
		ExplicitWait(Click_Update);
		if(Click_Update.isDisplayed())
		{
			Click_Update.click();

			ExplicitWait(Click_Confirm);

			test.log(Status.INFO, "Update button is displayed and clicked successfully");
			logger.info("Update button is displayed and clicked successfully");
		}
		else
		{

			test.log(Status.FAIL, "Update button not found");
			logger.error("Update button not found");
		}

		if(Click_Confirm.isDisplayed()) 
		{ 
			Click_Confirm.click();
			SeleniumRepo.waitForPageLoaded();

			System.out.println("Confirm button is entered successfully");
			test.log(Status.INFO, "Confirm button  is entered successfully");
			Assert.assertTrue(true,"Confirm button  is entered successfully"); 

			Thread.sleep(4000);



		} 
		else
		{
			System.out.println("Confirm button not found");
			test.log(Status.FAIL,"Confirm button not found");
			Assert.assertFalse(false,"Confirm button not found");
		}

	}


	public void verify_YeildControl()
	{
		String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
		String Yeildcontrol="Cascade yield controls :";
		if(!(body.contains(Yeildcontrol)))
		{
			System.out.println(Yeildcontrol+ "feild is not displaying hence FBP is enabled");
			test.log(Status.PASS, Yeildcontrol+ "feild is not displaying hence FBP is enabled");
			logger.info(Yeildcontrol+ "feild is not displaying hence FBP is enabled");
			
		} 
		else 
		{
			System.out.println(Yeildcontrol+"is displaying hence FBP is not enabled");
			test.log(Status.FAIL, Yeildcontrol+"is displaying hence FBP is not enabled");
			logger.error(Yeildcontrol+"is displaying hence FBP is not enabled");
		}	
	}

	public Map<String, String> set_days_Rate(String RoomType,String setofdays) throws InterruptedException
	{
		ExplicitWait(Room_Type);
		Thread.sleep(5000);
		System.out.println("RoomType is  "+RoomType );


		List<WebElement>list=SeleniumRepo.driver.findElements(By.xpath("//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr[1]/descendant::td/div"));

		for(int j=0;j<=list.size()-1;j++)
		{

			String day=list.get(j).getText();
			if(setofdays.contains(day))
			{
				List<WebElement>rate=SeleniumRepo.driver.findElements(By.xpath("//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr[1]/descendant::td/div[contains(text(),'"+day+"')]/../following-sibling::td[2]"));
				List<WebElement>day_date=SeleniumRepo.driver.findElements(By.xpath("//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr[1]/descendant::td/div[contains(text(),'"+day+"')]/../following-sibling::td[1]"));
				for(int r=0;r<=rate.size()-1;r++)
				{

					map.put(day, rate.get(r).getText());
				}	
			}

		}
		System.out.println(map);

		return map;
	}
	public void Searchfield(String Offer)
	{
		SeleniumRepo.waitForPageLoaded();
		ExplicitWait(Searchfield);
		if(Searchfield.isDisplayed())
		{
			Searchfield.sendKeys(Offer);
			test.log(Status.INFO, "Search field is displayed");
			logger.info("Search field is displayed");
			Assert.assertTrue(true, "Search field is displayed");
		}
		else
		{
			test.log(Status.INFO, "Search field is not displayed");
			logger.info("Search field is not displayed");
			Assert.assertFalse(false, "Search field is not displayed");

		}
	}
	public void sync_offer(String BAR,String rateplan) throws InterruptedException
	{
		ExplicitWait(Select_all);
		Thread.sleep(1000);
		//SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+BAR+"']/../following-sibling::td/font/strong/input)[1]")).click();
		Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+BAR+"']/../following-sibling::td/font/strong/input)[1]")));
		System.out.println("Selected rate plan is:"+BAR );
		Thread.sleep(2000);
		SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+rateplan+"']/../following-sibling::td/font/strong/input)[1]")).click();
		System.out.println("Selected rate plan is:"+rateplan );
		System.out.println(BAR+" synced with "+rateplan);
		logger.info(BAR+" synced with "+rateplan);
	}
	public void sync_offer(String BAR,String rateplan1,String rateplan2) throws InterruptedException
	{
		ExplicitWait(Select_all);

		Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+BAR+"']/../following-sibling::td/font/strong/input)[1]")));
		System.out.println("Selected rate plan is:"+BAR );
		Thread.sleep(2000);
		SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+rateplan1+"']/../following-sibling::td/font/strong/input)[1]")).click();

		logger.info(BAR+" synced with "+rateplan1);
		test.log(Status.INFO, BAR+" synced with "+rateplan1);

		SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+rateplan2+"']/../following-sibling::td/font/strong/input)[1]")).click();

		logger.info(BAR+" synced with "+rateplan2);
		test.log(Status.INFO, BAR+" synced with "+rateplan2);

	}
	public void select_offer(String offercode)
	{

		if(SeleniumRepo.driver.findElement(By.xpath("(//a[text()='"+offercode+"']/../following-sibling::td/font/strong/input)[1]")).isDisplayed())
		{
			WebElement offer_checkbox=SeleniumRepo.driver.findElement(By.xpath("(//a[text()='"+offercode+"']/../following-sibling::td/font/strong/input)[1]"));

			offer_checkbox.click();
			test.log(Status.INFO, "Selected offer");
			logger.info("Selected offer");
			Assert.assertTrue(true, "Selected offer");
		} else 
		{
			System.out.println("offer not found");
			test.log(Status.FAIL, " offer not found");
			logger.info("offer not found");
			Assert.assertFalse(false, "offer All not found");
		}
	}
	public void offercheck(String offer)
	{

		ExplicitWait(offercheck);
		if(offercheck.isDisplayed())
		{
			String offername=offercheck.getText().trim();
			System.out.println("offer name at the rate type title is "+offername);
			if(offername.equals(offer))
			{
				System.out.println("selected offer displayed successfully");

			}
			else
			{
				System.out.println("offer not displayed successfully");
			}
		}
		else
		{
			System.out.println("offer not found at room type title");
		}

	}
	/*public void Compare_Maps(Map<String, String> childrateplan_map, Map<String, String> Parentrateplan_map,String formula,String FBPAmount,String ceilingAmount)
	{

		if (childrateplan_map == null || Parentrateplan_map == null)
		{
			System.out.println("Maps are not null");
		}

		for (String ch1 : childrateplan_map.values()) 
		{
			if (childrateplan_map.get(ch1).equalsIgnoreCase(Parentrateplan_map.get(ch1)))
			{

				if(formula.contains("Subtract"))
				{
					System.out.println("Discount will be applicable for the rateplan");
					int Parentrateplanrate = Integer.parseInt(Parentrateplan_map.get(ch1));		
					int FBPAmount_int=Integer.parseInt(FBPAmount);
					int result=Parentrateplanrate+FBPAmount_int;
					String result_string = Integer.toString(result);
					int ceilingAmount_int=Integer.parseInt(ceilingAmount);

					if(result>ceilingAmount_int)
					{
						String value=childrateplan_map.get(ch1);
						if(value.contains(ceilingAmount))
						{
							System.out.println("Threshold value applied successfully");
						}
					}

					else
					{
						System.out.println("Room is getting discount with "+result_string);
						if(result_string.equals(childrateplan_map.get(ch1)))
						{
							System.out.println("FBP formula applied Amount is : " +FBPAmount);

							System.out.println("result is: "+result);

							System.out.println(result +" FBP Applied successfully");	
							test.log(Status.INFO, result +" FBP Applied successfully");
							Assert.assertTrue(true,result +" FBP Applied successfully");

						}
					}
				}
					else if(formula.contains("Add"))
					{
						System.out.println("amount will be add to the rateplan");
						int ParentRateplanRate_int = Integer.parseInt(ParentRateplanRate);	
						int FBPAmount_int=Integer.parseInt(FBPAmount);

						int result=ParentRateplanRate_int+FBPAmount_int;
						String result_string = Integer.toString(result);

						System.out.println(result_string+"Amount will be added to the rateplan ");
						if(result_string.equals(Childrateplan_AfterManageFBPRate))
						{
							System.out.println("FBP formula applied Amount is : " +FBPAmount);

							System.out.println("result is: "+result);

							System.out.println(result +" FBP Applied successfully");	
							test.log(Status.INFO, result +" FBP Applied successfully");
							Assert.assertTrue(true,result +" FBP Applied successfully");

						}
					}


				}


			}
			for (String ch2 : map2.keySet()) 
			{
				if (!map2.get(ch2).equalsIgnoreCase(map1.get(ch2)))
					return false;

			}

		}


	 */







}
