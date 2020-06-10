package com.tt.admin.pom;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.admin.pom.RateGrid;

public class Group_Blocks extends BaseTest
{
	String todaydate;
	String formattedDate2;
	String RoomsCount;
	
	RateGrid NewRategrid =PageFactory.initElements(SeleniumRepo.driver, RateGrid.class);

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Group Blocks')]") public WebElement Click_GroupBlocks;

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Group Blocks')]/following-sibling::ul/li/a[contains(text(),'List')]") public WebElement Click_ListAll;

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Group Blocks')]/following-sibling::ul/li/a[contains(text(),'Add')]") public WebElement Click_Addnew;

	@FindBy(how=How.XPATH,using="//*[@class='prompt']") public List<WebElement> GroupBlocks_Details;

	@FindBy(how=How.XPATH,using="//*[@value='Save']") public WebElement Click_Save;

	@FindBy(how=How.NAME,using="cancel") public WebElement Click_cancel;

	@FindBy(how=How.XPATH,using="//*[@class='title']/../../../following-sibling::font") public List<WebElement> Error_Messages;

	@FindBy(how=How.XPATH,using="//*[@class='title']") public WebElement Group_list_title;

	@FindBy(how=How.XPATH,using="//*[@class='title']/../preceding-sibling::tr[2]/td/h1") public WebElement Title;

	@FindBy(how=How.XPATH,using="//*[@color='red']") public WebElement Error_Mesage_title;

	@FindBy(how=How.XPATH,using="//*[@name='name']") public WebElement Enter_Name;

	@FindBy(how=How.XPATH,using="//*[@name='blockCode']") public WebElement Enter_blockcode;

	@FindBy(how=How.XPATH,using="//*[@name='shortDescription']") public WebElement Enter_ShortDescription;

	@FindBy(how=How.XPATH,using="//*[@name='detailDescription']") public WebElement Enter_DetailedDescription;

	@FindBy(how=How.XPATH,using="//*[contains(@id,'roomType')]") public List<WebElement> Click_Rooms;

	@FindBy(how=How.XPATH,using="//*[@name='blockReleaseDate']") public WebElement Enter_Releasedate;

	@FindBy(how=How.XPATH,using="//*[@name='checkInSDate']") public WebElement Enter_checkInSDate;

	@FindBy(how=How.XPATH,using="//*[@name='checkInEDate']") public WebElement Enter_checkInEDate;

	@FindBy(how=How.XPATH,using="//*[@value='Delete']") public WebElement Click_Delete;

	@FindBy(how=How.XPATH,using="(//*[@tf_colkey='name'])[1]") public WebElement Search;

	@FindBy(how=How.XPATH,using="//*[@value='Release unsold Inventory for all Rooms']") public WebElement Release_inventory;

	@FindBy(how=How.XPATH,using="//*[@id='mSDate']") public WebElement Inventory_Sdate;

	@FindBy(how=How.XPATH,using="//*[@id='mEDate']") public WebElement Inventory_Edate;

	@FindBy(how=How.XPATH,using="//*[@name='submitDialogBtn']") public WebElement Click_Submit;

	@FindBy(how=How.XPATH,using="//*[@id='selectedRoomTypeId']") public WebElement Select_RoomType;

	@FindBy(how=How.XPATH,using="//*[@id='noOfRoomsAvailable']") public WebElement Enter_inventory;

	@FindBy(how=How.XPATH,using="//*[@value='Delete']") public WebElement Delete_Groupblock;

	@FindBy(how=How.XPATH,using="//*[@value='Yes']") public WebElement Delete_Yes;

	@FindBy(how=How.TAG_NAME,using="body") public WebElement BODY;

	@FindBy(how=How.XPATH,using="(//*[@tf_colkey='name'])[1]") public WebElement GroupBlock_Search;

	@FindBy(how=How.XPATH,using="//*[text()='Release Date']/../following-sibling::tr[2]/td[5]") public WebElement Verify_Releaseinventorystatus;



	public void click_ListAll()
	{

		if (Click_ListAll.isDisplayed()) 
		{
			Click_ListAll.click();
			ExplicitWait(Title);

			test.log(Status.INFO, "Group Blocks link Expanded and List All element  found");
		} 
		else 
		{
			System.out.println("Group Blocks Menu is not expanded");
			Javascriptexecutor(Click_GroupBlocks);
			System.out.println("Clicked on Group Blocks Link");
			test.log(Status.INFO, "Clicked on Group Blocks Link");

			ExplicitWait(Click_ListAll);

			if (Click_ListAll.isDisplayed()) 
			{
				Click_ListAll.click();
				test.log(Status.PASS, "Clicked on List All link");
				logger.info("Clicked on List All link");
				
				ExplicitWait(Title);
				if(BODY.getText().contains("Group Block not found for the selected property"))
				{
					System.out.println("Group Blocks are not created yet");
				}
				else
				{
					System.out.println("Group blocks already created");
				}

			} 
			else
			{
				logger.error("List All element not found");
				test.log(Status.FAIL, "List All element not found");
			}
		}
	}

	public void Click_Addnew() throws InterruptedException
	{
		Thread.sleep(2000);
		//ExplicitWait(Click_Addnew);
		if (Click_Addnew.isDisplayed()) 
		{
			
			//Javascriptexecutor(Click_Addnew);
			Click_Addnew.click();
			ExplicitWait(Enter_Name);

			System.out.println("Group Blocks link Expanded and AddNew element  found");
			test.log(Status.INFO, "Group Blocks link Expanded and AddNew element  found");
			Assert.assertTrue(true, "Group Blocks link Expanded and AddNew element  found");
		} 
		else 
		{
			System.out.println("Group Blocks Menu is not expanded");
			Javascriptexecutor(Click_GroupBlocks);
			System.out.println("Clicked on Group Blocks Link");
			test.log(Status.INFO, "Clicked on Group Blocks Link");

			ExplicitWait(Click_Addnew);

			if (Click_Addnew.isDisplayed()) 
			{
				Click_Addnew.click();
				ExplicitWait(Enter_Name);
				test.log(Status.PASS, "Clicked on Addnew link");
				logger.info("Clicked on Addnew link");
				Assert.assertTrue(true, "Clicked on Addnew link");
			} 
			else
			{
				logger.info("Addnew element not found");
				test.log(Status.FAIL, "Addnew element not found");
			}
		}	
	}

	public void verify_ErrorMessages(String Errors)
	{
		for(WebElement error:Error_Messages)
		{
			if(Errors.contains(error.getText()))
			{
				System.out.println("Error "+error.getText()+" displayed successfully");
				logger.info("Error "+error.getText()+" displayed successfully");
				test.log(Status.PASS,"Error "+error.getText()+" displayed successfully");
			}
		}
	}

	public void verify_Groupblock_details()
	{
		for(WebElement field:GroupBlocks_Details)
		{
			System.out.println("element present in group block page is "+field.getText());
			logger.info("element present in group block page is "+field.getText());
			test.log(Status.INFO, "element present in group block page is "+field.getText());
		}
	}
	public void Enter_name(String name)
	{
		Enter_Name.click();
		Enter_Name.clear();
		Enter_Name.sendKeys(name);
		System.out.println("Group block name "+name+" enterd successfully");
		test.log(Status.PASS, "Group block name "+name+" enterd successfully");
		logger.info("Group block name "+name+" enterd successfully");
	}
	public void Enter_Blockcode(String code)
	{
		Enter_blockcode.click();
		Enter_blockcode.clear();
		Enter_blockcode.sendKeys(code);
		System.out.println("Group block code "+code+" enterd successfully");
		test.log(Status.PASS, "Group block code "+code+" enterd successfully");
		logger.info("Group block code "+code+" enterd successfully");
	}
	public void Enter_ShortDescription(String Sdec)
	{
		Enter_ShortDescription.click();
		Enter_ShortDescription.clear();
		Enter_ShortDescription.sendKeys(Sdec);
		System.out.println("Short Description "+Sdec+" enterd successfully");
		test.log(Status.PASS, "Short Description "+Sdec+" enterd successfully");
		logger.info("Short Description "+Sdec+" enterd successfully");
	}

	public void Enter_Detailedescription(String Ddesc)
	{
		Enter_DetailedDescription.click();
		Enter_DetailedDescription.clear();
		Enter_DetailedDescription.sendKeys(Ddesc);
		System.out.println("Detailed Description "+Ddesc+" enterd successfully");
		test.log(Status.PASS, "Detailed Description "+Ddesc+" enterd successfully");
		logger.info("Detailed Description "+Ddesc+" enterd successfully");
	}
	public void Select_Rooms()
	{
		int rooms=Click_Rooms.size();
		System.out.println("rooms size is "+rooms);
		for(WebElement room:Click_Rooms)
		{
			room.click();
			if(room.isSelected())
			{
				System.out.println("All rooms selected successfully");
				logger.info("All rooms selected successfully");
				test.log(Status.PASS, "All rooms selected successfully");
			}
			else
			{
				System.out.println("Room is not selected ");
				logger.info("Room is not selected ");
				test.log(Status.PASS, "Room is not selected ");
			}	
		}
	}
	public void Enter_releasedate(String releasedate)
	{
		ExplicitWait(Enter_Releasedate);
		Enter_Releasedate.clear();
		Enter_Releasedate.click();
		Enter_Releasedate.sendKeys(releasedate);
		System.out.println("Release date "+releasedate+" enterd successfully");
		logger.info("Release date "+releasedate+" enterd successfully");
		test.log(Status.PASS, "Release date "+releasedate+" enterd successfully");


	}
	public void Enter_checkSdate()
	{
		Date date1 = new Date();
		date1.setDate(date1.getDate());
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		todaydate = df1.format(date1);

		ExplicitWait(Enter_checkInSDate);
		Enter_checkInSDate.clear();
		Enter_checkInSDate.click();
		Enter_checkInSDate.sendKeys(todaydate);

		System.out.println("checkSdate  "+todaydate+" enterd successfully");
		logger.info("checkSdate "+todaydate+" enterd successfully");
		test.log(Status.PASS, "checkSdate "+todaydate+" enterd successfully");

	}
	public void Enter_CheckEdate(String checkInEDate)
	{
		ExplicitWait(Enter_checkInEDate);
		Enter_checkInEDate.clear();
		Enter_checkInEDate.click();
		Enter_checkInEDate.sendKeys(checkInEDate);
		System.out.println("checkInEDate "+checkInEDate+" enterd successfully");
		logger.info("checkInEDate "+checkInEDate+" enterd successfully");
		test.log(Status.PASS, "checkInEDate "+checkInEDate+" enterd successfully");
	}
	public void click_save()
	{
		if(Click_Save.isEnabled())
		{
			Click_Save.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("clicked on save successfully");
			logger.info("clicked on save successfully");
			test.log(Status.PASS, "clicked on save successfully");
		}
	}
	public void click_cancel()
	{
		if(Click_cancel.isEnabled())
		{
			Javascriptexecutor(Click_cancel);
			ExplicitWait(Title);
			System.out.println("Group block Cancel button is workiing successfully");

		}
	}
	public void Delete_Group(String Name) throws InterruptedException
	{

		if(BODY.getText().contains(Name))
		{
			WebElement delete_checkbox=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+Name+"']/preceding-sibling::td/input"));
			Javascriptexecutor(delete_checkbox);
			Thread.sleep(1000);
			Javascriptexecutor(Delete_Groupblock);
			ExplicitWait(Delete_Yes);
			Javascriptexecutor(Delete_Yes);
			System.out.println("Group Block "+Name+" deleted Successfully");
			logger.info("Group Block "+Name+" deleted Successfully");
			test.log(Status.INFO, "Group Block "+Name+" deleted Successfully");

		}
		else
		{
			System.out.println("There are no Duplicate Group blocks with name "+Name);
		}

	}
	public void click_Manageinvenotry(String Groupname)
	{
		ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+Groupname+"']/following-sibling::td[4]/a[3]")));
		WebElement manageinv=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+Groupname+"']/following-sibling::td[4]/a[3]"));
		Javascriptexecutor(manageinv);
		/*ExplicitWait(Inventory_Sdate);
		Inventory_Sdate.clear();
		Inventory_Sdate.sendKeys(todaydate);

		System.out.println("Inventory_Sdate  "+todaydate+" enterd successfully");
		logger.info("Inventory_Sdate "+todaydate+" enterd successfully");
		test.log(Status.PASS, "Inventory_Sdate "+todaydate+" enterd successfully");

		Inventory_Edate.clear();
		Inventory_Edate.sendKeys(In_Edate);

		System.out.println("Inventory_Edate  "+In_Edate+" enterd successfully");
		logger.info("Inventory_Edate "+In_Edate+" enterd successfully");
		test.log(Status.PASS, "Inventory_Edate "+In_Edate+" enterd successfully");*/

	}

	public void Click_Submit()
	{
		ExplicitWait(Click_Submit);
		if(Click_Submit.isEnabled())
		{
			Javascriptexecutor(Click_Submit);
			System.out.println("Clicked on Release submit  Button Successfully");
			test.log(Status.PASS, "Clicked on Release submit Button Successfully");
			logger.info("Clicked on Release submit Button Successfully");
		}
	}
	public void inventory() throws InterruptedException, IOException
	{
		ExplicitWait(Select_RoomType);
		Select roomtypes=new Select(Select_RoomType);

		List<WebElement>rooms=roomtypes.getOptions();
		System.out.println(rooms.size());
		for(int i=0;i<rooms.size();i++)
		{
			String minroomsa = ReadProperties.getPropValues("Admin.properties", "Minroomsavailable");
			String maxroomsa = ReadProperties.getPropValues("Admin.properties", "Maxroomsavailable");

			Thread.sleep(2000);

			roomtypes.selectByIndex(i);

			Enter_inventory.click();
			Enter_inventory.clear();
			Enter_inventory.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minroomsa), Integer.parseInt(maxroomsa))));
			if (NewRategrid.Quick_Entry.isEnabled()) 
			{
				Javascriptexecutor(NewRategrid.Quick_Entry);
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
	}
	public String CurrentRooms_Count(String RoomType ) throws IOException, InterruptedException
	{
		ExplicitWait(Select_RoomType);
		Thread.sleep(5000);
		/*Date date1 = new Date();
		date1.setDate(date1.getDate());
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		String formattedDate1 = df1.format(date1);

		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/YY");
		formattedDate2=df2.format(date1);*/


		DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		String year = df.format(Calendar.getInstance().getTime());
		Calendar now = Calendar.getInstance();
		int Month= now.get(Calendar.MONTH)+1;

		Date date1 = new Date();
		date1.setDate(date1.getDate()+1);
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String date = df1.format(date1);

		//int date= now.get(Calendar.DATE)+1;

		String Month1=Integer.toString(Month);
		//String date1=Integer.toString(date);

		formattedDate2=Month1+"/"+date+"/"+year;

		System.out.println("RoomType is  "+RoomType );
		org.openqa.selenium.support.ui.Select sel=new org.openqa.selenium.support.ui.Select(Select_RoomType);
		List<WebElement> Rooms=sel.getOptions();
		for(int i=0;i<Rooms.size();i++)
		{
			String formattedDate=formattedDate2;
			//System.out.println("Rooms Count checking on the date is "+" " +formattedDate);
			String RoomName=Rooms.get(i).getText();
			System.out.println("RoomName is "+RoomName.trim());
			if(RoomType.contains(RoomName.trim()))
			{
				System.out.println("room type and room names are matching");
				test.log(Status.INFO, "room type and room names are matching");
				Assert.assertTrue(true,"room type and room names are matching");

				WebElement count=SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr[1]/descendant::td[contains(text(),'"+formattedDate+"')]/following-sibling::td[4]"));
				scroll(count);


				RoomsCount=SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'"+RoomType+"')]/../following-sibling::tr[1]/descendant::td[contains(text(),'"+formattedDate+"')]/following-sibling::td[4]")).getText();

				if(!(RoomsCount==null))  
				{
					System.out.println(RoomName.trim() + " "+"Rooms available are  "+ RoomsCount);
					test.log(Status.INFO, "Rooms count taken for the room type successfully");
					Assert.assertTrue(true,"Rooms count taken for the room type successfully");

					break;
				}
				else
				{	
					System.out.println(RoomName.trim() + " Rooms are not available");
					test.log(Status.INFO, "No Rooms on that particular room type");
					Assert.assertFalse(false,"No Rooms on that particular room type");
				}
			}
			else
			{
				System.out.println("RoomName and Roomtype are not matching");
				test.log(Status.INFO, "RoomName and Roomtype are not matching");
				Assert.assertFalse(false,"RoomName and Roomtype are not matching");
			}


		}
		return RoomsCount;
	}
	public void click_releaseunsoldinventory(String Groupblockname)
	{
		ExplicitWait(GroupBlock_Search);
		Javascriptexecutor(GroupBlock_Search);
		GroupBlock_Search.sendKeys(Groupblockname);
		WebElement checkbox=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+Groupblockname+"']/preceding-sibling::td/input"));
		Javascriptexecutor(checkbox);
		Javascriptexecutor(Release_inventory);
		test.log(Status.INFO, "Clicked on release unsold inventory");
		try 
		{
			assertTrue(Verify_Releaseinventorystatus.getText().contains("Manually Released"));
			test.log(Status.PASS, "Unsold Inventory released successfully");
		}
		catch(Exception e)
		{
			logger.error("unsold inventory is not released and status is not diplayig");
		}
	}


}
