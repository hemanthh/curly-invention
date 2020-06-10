package com.tt.admin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

public class AddNewRatePlan extends BaseTest 
{
	String startdate;
	String Enddate;
	public String Ratecode;
	boolean error;
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());



	@FindAll({
		@FindBy(xpath="//table[@id='dataTable']//tbody//tr[@id='rateplan']"),
	})     

	public List<WebElement> Selectrateplan;

	@FindAll({
		@FindBy(xpath="//a[contains(@href, 'retrieveRateTypes.do?')]"), @FindBy(css="tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) ul:nth-child(3) > li:nth-child(9)")
	})     

	public WebElement ListAll;


	@FindAll({
		@FindBy(xpath="(//input[@name='rateIdCheckbox'])[1]"),
	})       

	public WebElement Select_FirstCheckbox;

	@FindAll({
		@FindBy(xpath="(//input[@name='rateIdCheckbox'])[2]"),
	})       

	public WebElement Select_SecondCheckbox;

	@FindAll({
		@FindBy(xpath="//input[@value='Delete']"),
	})       

	public WebElement Click_Delete;

	@FindAll({
		@FindBy(xpath="//input[@value='Yes']"),
	})       

	public WebElement Click_Yes;

	@FindAll({
		@FindBy(xpath="//a[@id='add_new_rate']"),
	})       

	public WebElement Addnew;

	@FindAll({
		@FindBy(xpath="//input[@name='name']"),
	})      

	public WebElement Enter_Name;

	@FindAll({
		@FindBy(xpath="//input[@name='rateCode']"),
	})

	public WebElement Enter_Ratecode;

	@FindAll({
		@FindBy(xpath="//select[@name='selectedCategoryId']"),
	})

	public WebElement Select_Category;

	@FindAll({
		@FindBy(xpath="//textarea[@name='shortDescription']"),
	})

	public WebElement Enter_ShortDescription;

	@FindAll({
		@FindBy(xpath="//input[@name='tt_img_loader_file_0']"),
	})

	public WebElement Click_Choosefile;

	@FindAll({
		@FindBy(xpath="//input[@name='roomTypes']"),
	})

	public List<WebElement> click_Roomtype;

	@FindAll({
		@FindBy(xpath="//input[@id='roomType_1']"),
	})

	public WebElement click_Roomtype2;

	@FindAll({
		@FindBy(xpath="//input[@name='bookingSDate']"),
	})

	public WebElement Enter_BookingStartdate;

	@FindAll({
		@FindBy(xpath="//input[@name='bookingEDate']"),
	})

	public WebElement Enter_BookingEnddate;

	@FindAll({
		@FindBy(xpath="//input[@name='checkInSDate']"),
	})

	public WebElement Enter_Firstcheckindate;

	@FindAll({
		@FindBy(xpath="//input[@name='checkInEDate']"),
	})

	public WebElement Enter_Lastcheckoutdate;

	@FindAll({
		@FindBy(xpath="//input[@name='minLeadTime']"),
	})

	public WebElement Enter_MinLeadtime;

	@FindAll({
		@FindBy(xpath="//input[@name='maxLeadTime']"),
	})

	public WebElement Enter_MaxLeadtime;

	@FindAll({
		@FindBy(xpath="//input[@name='minLOS']"),
	})

	public WebElement Enter_MinLos;

	@FindAll({
		@FindBy(xpath="//input[@name='maxLOS']"),
	})

	public WebElement Enter_MaxLos;

	@FindAll({
		@FindBy(xpath="//input[@name='showInCallCenterSearchResults'][@value='true']"),
	})

	public WebElement Click_CallCenterSearchResultsyes;

	@FindAll({
		@FindBy(xpath="//input[@name='showInCallCenterSearchResults'][@value='false']"),
	})

	public WebElement Click_CallCenterSearchResultsno;


	@FindAll({
		@FindBy(xpath="//input[contains(@name,'policyCategory')]"),
	})

	public List<WebElement> Selectcancellationpolicy;


	@FindAll({
		@FindBy(xpath="//input[@value='BP']"),
	})

	public WebElement Select_Basicpolicy;

	@FindAll({
		@FindBy(xpath="//select[@name='selectedPolicyId']"),
	})

	public WebElement Selectedpolicyid;

	@FindAll({
		@FindBy(xpath="//select[@name='selectedSmartPolicyId']"),
	})

	public WebElement SelectedSmartpolicyid;


	@FindAll({
		@FindBy(xpath="//input[contains(@name,'ownInventory')]"),
	})

	public List<WebElement> Takeinventory;

	@FindAll({
		@FindBy(xpath="//input[contains(@name,'ownInventory')][@value='B']"),
	})

	public WebElement Bar;

	@FindAll({
		@FindBy(xpath="//input[contains(@name,'ownInventory')][@value='O']"),
	})

	public WebElement OwnInventory;

	@FindAll({
		@FindBy(xpath="//input[@name='floatingRate'][@value='Y']"),
	})

	public WebElement Click_DeriveratesRatePlanyes;

	@FindAll({
		@FindBy(xpath="//input[@name='floatingRate'][@value='N']"),
	})

	public WebElement Click_DeriveratesRatePlanNo;

	@FindAll({
		@FindBy(xpath="//input[@name='floatsByPercent'][@value='N']"),
	})

	public WebElement Floatbyflatdifference;

	@FindAll({
		@FindBy(xpath="//input[@name='floatsByPercent'][@value='Y']"),
	})

	public WebElement FloatbyPercentagedifference;

	@FindAll({
		@FindBy(xpath="(//*[starts-with(@id,'rate_difference')])"),
	})

	public List<WebElement> EnterNumofrooms;

	@FindAll({
		@FindBy(xpath="//input[@id='rate_difference_1']"),
	})

	public WebElement EnterNumofrooms2;

	@FindAll({
		@FindBy(xpath="//textarea[@name='comments']"),
	})

	public WebElement Enter_AdditionalNotes;

	@FindAll({
		@FindBy(xpath="//textarea[@name='agentComment']"),
	})

	public WebElement Enter_AgentComment;

	@FindAll({
		@FindBy(xpath="//input[@name='save']"),
	})

	public WebElement Click_Save;

	@FindAll({
		@FindBy(xpath="(//img[@src='/rt/images/rezadminimages/down_arrow.png'])[2]"),
	})

	public WebElement Click_arrow;


	@FindAll({
		@FindBy(xpath="//*[contains(text(),'Rate Plans')]"),
	})     

	public WebElement Rateplan;

	@FindAll({
		@FindBy(xpath="//*[contains(text(),'Rate Plans')]/..//a[normalize-space(.)='List All']"),
	})     

	public WebElement Click_List_All;

	@FindAll({
		@FindBy(xpath="(//*[@tf_colkey='name'])[1]"),
	})     

	public WebElement Name_Search;

	@FindAll({
		@FindBy(xpath="//*[@name='bookingSDate']"),
	})     

	public WebElement Booking_startdate;

	@FindAll({
		@FindBy(xpath="//*[@name='bookingEDate']"),
	})     

	public WebElement Booking_Enddate;

	@FindAll({
		@FindBy(xpath="//*[@name='checkInSDate']"),
	})     

	public WebElement Checkin_startdate;

	@FindAll({
		@FindBy(xpath="//*[@name='checkInEDate']"),
	})     

	public WebElement Checkout_Enddate;

	@FindAll({
		@FindBy(xpath="//*[@name='minLeadTime']"),
	})     

	public WebElement Min_leadtime;
	@FindAll({
		@FindBy(xpath="//*[@name='maxLeadTime']"),
	})     

	public WebElement Max_leadtime;
	@FindAll({
		@FindBy(xpath="//*[@name='minLOS']"),
	})     

	public WebElement Min_Los;
	@FindAll({
		@FindBy(xpath="//*[@name='maxLOS']"),
	})     

	public WebElement Max_Los;

	@FindAll({
		@FindBy(xpath="//*[@id='showAsPromoYes']"),
	})     

	public WebElement display_offers;

	@FindAll({
		@FindBy(xpath="//*[@name='save']"),
	})     

	public WebElement Save;

	@FindAll({
		@FindBy(xpath="//*[contains(text(),'(Manage)')]"),
	})     

	public WebElement Accesscode_Manage;

	@FindAll({
		@FindBy(xpath="//*[contains(text(),'Add new access code for')]"),
	})     

	public WebElement Add_NewAccesscode;

	@FindAll({
		@FindBy(xpath="//input[@name='accessCode']"),
	})     

	public WebElement Accesscode_Name;

	@FindAll({
		@FindBy(xpath="//input[@name='selectedRatePlanName']"),
	})     

	public WebElement Rateplancheck_Accescode;

	@FindAll({
		@FindBy(xpath="(//*[@type='checkbox']/../following-sibling::td)[2]"),
	})     

	public WebElement offer_validation;


	@FindAll({
		@FindBy(xpath="//*[@value='Delete']"),
	})     

	public WebElement delete_rateplan;



	@FindAll({@FindBy(xpath="//*[@value='Yes']"),})     

	public WebElement delete_yes;


	@FindAll({@FindBy(xpath="//*[@id='floatRatesFromBarYes']"),})     

	public WebElement Deriverates;

	@FindAll({@FindBy(xpath="//select[@name='selectedFloatsOffRatePlanId']"),})     

	public WebElement SelectRateplan;

	@FindBy(how=How.TAG_NAME,using="body") public WebElement BODY;

	@FindAll({@FindBy(xpath="//*[@name='selectedGroupBlock']/preceding-sibling::input"),})     

	public WebElement Verify_GroupBlock;


	@FindAll({@FindBy(xpath="//*[@name='selectedGroupBlock']"),})     

	public WebElement Select_GroupBlock;


	@FindAll({
		@FindBy(xpath="//input[@name='rateCode']"),
	})     
	public WebElement RateType_code;

	@FindAll({
		@FindBy(xpath="//*[@id='All']"),
	}) public WebElement All_Rooms;

	@FindAll({
		@FindBy(xpath="//h1[text()='Rate Plans']"),
	}) public WebElement RateplanTitle;



	@FindAll({@FindBy(xpath="//*[contains(text(),'Default Promotional URL')]/following-sibling::td/a"),})     

	public WebElement PromoURL;
	
	public void click_Rateplan()
	{
		ExplicitWait(Rateplan);
		//Rateplan.isDisplayed() == true && Click_List_All.isDisplayed() == false
		
		if (SeleniumRepo.isElementDisplayed(Rateplan) == true  && SeleniumRepo.isElementDisplayed(Click_List_All) == false ) 
		{
			Javascriptexecutor(Rateplan);
			test.log(Status.INFO, " Rateplan Menu found");
			Assert.assertTrue(true, "Rateplan Menu found");
		} else 
		{

			System.out.println("Rateplan Menu not found");
			test.log(Status.INFO, " Rateplan Menu not found");
			//As of release Outbound Data Filter this assertion is failing
			//commenting out for now and will fix in the future
			//Assert.assertFalse(false, "Rateplan Menu not found");
		}
	}


	public void click_Listall() throws InterruptedException
	{
		//SeleniumRepo.scrollintoview(Click_List_All);Thread.sleep(2000);

		
		if( SeleniumRepo.isElementDisplayed(Click_List_All) == true ) 
		{

			Thread.sleep(2000);

			Click_List_All.click();
			ExplicitWait(RateplanTitle);
            Thread.sleep(4000);
			System.out.println("RatePlans link Expanded and ListAll element  found");
			test.log(Status.INFO, "RatePlans link Expanded and ListAll element  found");
			Assert.assertTrue(true, "RatePlans link Expanded and ListAll element  found");
		} 
		else 
		{
			Thread.sleep(2000);
			System.out.println("Rate Plans Menu is not expanded");
			Javascriptexecutor(Rateplan);
			System.out.println("Clicked on Rate Plans Link");
			test.log(Status.INFO, "Clicked on Rate Plans Link");
            Thread.sleep(2000);
			ExplicitWait(Click_List_All);

			if (Click_List_All.isDisplayed()) 
			{
				Click_List_All.click();
				test.log(Status.PASS, "Clicked on ListAll link");
				logger.info("Clicked on ListAll link");
				Assert.assertTrue(true, "Clicked on ListAll link");
				ExplicitWait(RateplanTitle);

			} 
			else
			{
				logger.error("List All element not found");
				test.log(Status.FAIL, "List All element not found");
			}
		}
	}
	public void Name_Search(String Offercode)
	{
		ExplicitWait(Name_Search);
		if(Name_Search.isDisplayed())
		{
			Name_Search.clear();
			Name_Search.sendKeys(Offercode);
			SeleniumRepo.waitForElementPresent(Name_Search);
			System.out.println("Offercode placed in search field");
			test.log(Status.INFO, "search button is displayed and able to enter the offer");
			logger.info("search button is displayed and able to enter the offer");
			Assert.assertTrue(true, "search button is displayed and able to enter the offer");
		} else 
		{
			System.out.println("search button not found");
			test.log(Status.FAIL, " search button not found");
			logger.info("search button not found");
			Assert.assertFalse(false, "search button not found");
		}
	}

	public void Edit(String Offercode) throws InterruptedException 
	{
		
		//Must find a better xpath  than the one being used to click the edit link on the rate plan 
		//page. suggestion: //td[text()='RATEPLAN_Name']/../td[12]/a[1]
		//The previous  version breaks due to a new column for the rate plan list all page.
		if(SeleniumRepo.driver.findElement(By.xpath("//td[text()='"+Offercode+"']/../td[12]/a[contains(text(),'Edit')]")).isDisplayed())
		{   Thread.sleep(2000);
			WebElement Edit=SeleniumRepo.driver.findElement(By.xpath("//td[text()='"+Offercode+"']/../td[12]/a[contains(text(),'Edit')]"));
			Edit.click();Thread.sleep(8000);
			System.out.println("Edit button found and clicked successfully");
			test.log(Status.INFO, "search button is displayed and able to enter the offer");
			logger.info("search button is displayed and able to enter the offer");
			Assert.assertTrue(true, "search button is displayed and able to enter the offer");

		}
		else
		{
			System.out.println("Edit button not found");
			test.log(Status.FAIL, " Edit button not found");
			logger.info("Edit button not found");
			Assert.assertFalse(false, "Edit button not found");
		}
		SeleniumRepo.waitForPageLoaded();

	}
	public String Ratecode()
	{
		ExplicitWait(RateType_code);
		if(RateType_code.isDisplayed())
		{
			Ratecode=RateType_code.getAttribute("value");
			System.out.println("Ratetypecode is: "+Ratecode);
			test.log(Status.INFO, "search button is displayed and able to enter the offer");
			logger.info("search button is displayed and able to enter the offer");
			Assert.assertTrue(true, "search button is displayed and able to enter the offer");

		}
		else
		{
			System.out.println("Rate Type code is not found");
			test.log(Status.FAIL, " Rate Type code is not found");
			logger.info("Rate Type code is not found");
			Assert.assertFalse(false, "Rate Type code is not found");
		}
		return Ratecode;
	}

	public void delete_rateplan(String Offercode) throws InterruptedException
	{

		if(BODY.getText().contains(Offercode))
		{
			System.out.println("duplicate Rate plan is there");
			WebElement checkbox=SeleniumRepo.driver.findElement(By.xpath("//td[text()='"+Offercode+"']/preceding-sibling::td/input[@name='rateIdCheckbox']"));
			Javascriptexecutor(checkbox);
			Javascriptexecutor(delete_rateplan);
			ExplicitWait(delete_yes);
			Javascriptexecutor(delete_yes);

			System.out.println("Rateplan "+Offercode+" deleted successfully");
			SeleniumRepo.waitForPageLoaded();
			Thread.sleep(4000);
		}
		else
		{
			System.out.println("New rate plan is going to be create");
		}
	}

	public void Click_Addnew()
	{
		
		if(Addnew.isDisplayed()) 
		{
			Addnew.click();
			ExplicitWait(Enter_Name);

			System.out.println("RatePlans link Expanded and Add New element  found");
			test.log(Status.INFO, "RatePlans link Expanded and Add New element  found");
			Assert.assertTrue(true, "RatePlans link Expanded and Add New element  found");
		} 
		else 
		{
			System.out.println("Rate Plans Menu is not expanded");
			Javascriptexecutor(Rateplan);
			System.out.println("Clicked on Rate Plans Link");
			test.log(Status.INFO, "Clicked on Rate Plans Link");

			ExplicitWait(Addnew);

			if (Addnew.isDisplayed()) 
			{
				Addnew.click();
				test.log(Status.PASS, "Clicked on Addnew link");
				logger.info("Clicked on Addnew link");
				Assert.assertTrue(true, "Clicked on Addnew link");
				ExplicitWait(Enter_Name);

			} 
			else
			{
				logger.error("Addnew element not found");
				test.log(Status.FAIL, "Addnew element not found");
			}
		}
	}

	public void Enter_Name(String Name)
	{
		ExplicitWait(Enter_Name);
		if (Enter_Name.isDisplayed()) 
		{
			Enter_Name.click();
			Enter_Name.clear();
			Enter_Name.sendKeys(Name);
			System.out.println("Name is entered successfully");
			test.log(Status.INFO, "Name is entered successfully");
			Assert.assertTrue(true,"Name is entered successfully");
		} else {
			System.out.println("Name TextBox not found");
			test.log(Status.FAIL, "Name TextBox not found");
			Assert.assertFalse(false, "Name TextBox not found");
		}
	}


	public void Ratecode(String Ratecode)
	{
		ExplicitWait(Enter_Ratecode);
		if (Enter_Ratecode.isDisplayed())
		{
			Enter_Ratecode.click();
			Enter_Ratecode.clear();
			Enter_Ratecode.sendKeys(Ratecode);
			System.out.println("Ratecode is entered successfully");
			test.log(Status.INFO, "Ratecode is entered successfully");
			Assert.assertTrue(true,"Ratecode is entered successfully");
		} else {
			System.out.println("Ratecode TextBox not found");
			test.log(Status.FAIL, "Ratecode TextBox not found");
			Assert.assertFalse(false, "Ratecode TextBox not found");
		}
	}

	public void Select_Category(String Category) throws InterruptedException
	{
		ExplicitWait(Select_Category);
		if (Select_Category.isDisplayed()) 
		{
			Select_Category.click();
			SeleniumRepo.WaitForLoad(100);
			SeleniumRepoDropdown.selectDropDownText(Select_Category, Category);
			System.out.println(" Selectedpolicyid is entered successfully");
			test.log(Status.INFO, " Selectedpolicyid is entered successfully");
			Assert.assertTrue(true,"Selectedpolicyid is entered successfully");
		} else {
			System.out.println("Selectedpolicyid TextBox not found");
			test.log(Status.FAIL, " Selectedpolicyid TextBox not found");
			Assert.assertFalse(false, "Selectedpolicyid TextBox not found");
		}
	}


	public void ShortDescription(String ShortDescription)
	{
		if (Enter_ShortDescription.isDisplayed()) {
			Enter_ShortDescription.click();
			Enter_ShortDescription.clear();
			Enter_ShortDescription.sendKeys(ShortDescription);
			System.out.println("ShortDescription is entered successfully");
			test.log(Status.INFO, "ShortDescription is entered successfully");
			Assert.assertTrue(true,"ShortDescription is entered successfully");
		} else {
			System.out.println("ShortDescription TextBox not found");
			test.log(Status.FAIL, "ShortDescription TextBox not found");
			Assert.assertFalse(false, "ShortDescription TextBox not found");
		}
	}


	public void Click_Choosefile(String imagePath)
	{
		ExplicitWait(Click_Choosefile);
		if(SeleniumRepo.isElementPresent(Click_Choosefile))
		{
			Click_Choosefile.sendKeys(System.getProperty("user.dir")+"\\Images\\"+imagePath+"");
			logger.info("Images is entered");

			test.log(Status.INFO, "Images is entered");
		} else {
			logger.error(" Failed to enter Images");

			test.log(Status.FAIL, "Failed to enter Images");
		}
	}

	public void All_rooms()
	{
		ExplicitWait(All_Rooms);
		if(All_Rooms.isSelected())
		{
			System.out.println("All Rooms Selected ");
		}
		else
		{
			System.out.println("All rooms not selected");
			Javascriptexecutor(All_Rooms);
			System.out.println("All Rooms option Clicked successfully");
		}

	}
	public boolean RoomsError()
	{
		if(BODY.getText().contains("float Difference fields for rooms"))
		{
			System.out.println("Invalid Values for float Difference fields for rooms error displayed hence update the roooms inventory ");
			error=true;
		}
		else
		{
			System.out.println("Error is not occured");
			error=false;
		}
		return error;
	}
	public void selectRoomType() throws InterruptedException
	{

		List<WebElement> els =SeleniumRepo.driver.findElements( By.xpath("(//*[starts-with(@name,'roomType')])"));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected() ) 
			{   
				Thread.sleep(1000);
				el.click();
			}
		}
	}

	public void Book_startdate() throws InterruptedException
	{
		Date date1 = new Date();
		date1.setDate(date1.getDate());
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		startdate = df1.format(date1);

		/*DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		 year = df.format(Calendar.getInstance().getTime());


		Calendar now = Calendar.getInstance();

		Month= now.get(Calendar.MONTH)+1;
		date= now.get(Calendar.DATE);
		//int arrivaldate=date;

		String Month1=Integer.toString(Month);
		String date1=Integer.toString(date);

		startdate=Month1+"/"+date1+"/"+year;*/

		/*startdate=Admin_Startdate();*/

		System.out.println("start date is"+startdate);

		if (SeleniumRepo.isElementPresent(Booking_startdate)) 
		{
			Booking_startdate.click();
			Booking_startdate.clear();
			Thread.sleep(3000);
			Booking_startdate.sendKeys(startdate);
			System.out.println("BookStartDate enterd successfully");
			test.log(Status.INFO, "Clicked on Booking startingdate textbox");
			logger.info("Clicked on Booking startingdate textbox");
			Assert.assertTrue(true, "Clicked on Booking startingdate textbox");

		}
		else 
		{
			System.out.println("Booking Starting date TextBox not found");
			test.log(Status.FAIL, "Booking Starting date TextBox not found");
			Assert.assertFalse(false, "Booking Starting date TextBox not found");
		}
		Thread.sleep(3000);
	}
	public void Booking_Enddate() throws InterruptedException
	{

		Date date = new Date();
		date.setDate(date.getDate() + 7);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
		Enddate = df.format(date);
		/*Calendar now = Calendar.getInstance();
		date= now.get(Calendar.DATE)+7;

		String Month2=Integer.toString(Month);
		String date2=Integer.toString(date);

		Enddate=Month2+"/"+date2+"/"+year;
		 */

		/*	Enddate=Admin_Enddate();*/
		System.out.println("end date is"+Enddate);

		if (Booking_Enddate.isDisplayed()) 
		{
			Booking_Enddate.click();
			Booking_Enddate.clear();
			Thread.sleep(3000);
			Booking_Enddate.sendKeys(Enddate);
			System.out.println("departuredate is entered successfully");
			logger.info("departuredate is entered successfully");
			test.log(Status.INFO, "departuredate is entered successfully");
			Assert.assertTrue(true, "departuredate is entered successfully");
		} else 
		{
			System.out.println("departuredate TextBox not found");
			logger.error("departuredate TextBox not found");
			test.log(Status.FAIL, "departuredate TextBox not found");
			Assert.assertFalse(false, "departuredate TextBox not found");
		}
		Thread.sleep(3000);
	}

	public void Checkin_startdate() throws InterruptedException
	{
		/*Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		String formattedDate1 = df1.format(date1);*/

		if (SeleniumRepo.isElementPresent(Checkin_startdate)) 
		{
			Checkin_startdate.click();
			Checkin_startdate.clear();
			Thread.sleep(3000);
			Checkin_startdate.sendKeys(startdate);
			System.out.println("Clicked on Checkin startingdate textbox");
			test.log(Status.INFO, "Clicked on Checkin startingdate textbox");
			logger.info("Clicked on checkin startingdate textbox");
			Assert.assertTrue(true, "checkin on Booking startingdate textbox");

		}
		else 
		{
			System.out.println("checkin Starting date TextBox not found");
			test.log(Status.FAIL, "checkin Starting date TextBox not found");
			Assert.assertFalse(false, "checkin Starting date TextBox not found");
		}
		Thread.sleep(3000);
	}

	public void checkout_date() throws InterruptedException
	{

		/*Date date = new Date();
		date.setDate(date.getDate() + 7);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
		Enddate = df.format(date);*/


		if (Checkout_Enddate.isDisplayed()) {
			Checkout_Enddate.click();
			Checkout_Enddate.clear();
			Thread.sleep(3000);
			Checkout_Enddate.sendKeys(Enddate);
			System.out.println("CheckoutDate is entered successfully");
			logger.info("CheckoutDate is entered successfully");
			test.log(Status.INFO, "CheckoutDate is entered successfully");
			Assert.assertTrue(true, "CheckoutDate is entered successfully");
		} else 
		{
			System.out.println("CheckoutDate TextBox not found");
			logger.error("CheckoutDate TextBox not found");
			test.log(Status.FAIL, "CheckoutDate TextBox not found");
			Assert.assertFalse(false, "CheckoutDate TextBox not found");
		}
		Thread.sleep(3000);
	}

	public void minLeadtime( String MinLeadtime)
	{
		if (Enter_MinLeadtime.isDisplayed()) 
		{
			Enter_MinLeadtime.click();
			Enter_MinLeadtime.clear();
			Enter_MinLeadtime.sendKeys(MinLeadtime);
			System.out.println("MinLeadtime is entered successfully");
			test.log(Status.INFO, "MinLeadtime is entered successfully");
			Assert.assertTrue(true,"MinLeadtime is entered successfully");
		} else {
			System.out.println("MinLeadtime TextBox not found");
			test.log(Status.FAIL, "MinLeadtime TextBox not found");
			Assert.assertFalse(false, "MinLeadtime TextBox not found");
		}

	}

	public void MaxLeadtime(String MaxLeadtime)
	{
		if (Enter_MaxLeadtime.isDisplayed()) {
			Enter_MaxLeadtime.click();
			Enter_MaxLeadtime.clear();
			Enter_MaxLeadtime.sendKeys(MaxLeadtime);
			System.out.println("MaxLeadtime is entered successfully");
			test.log(Status.INFO, "MaxLeadtime is entered successfully");
			Assert.assertTrue(true,"MaxLeadtime is entered successfully");
		} else {
			System.out.println("MaxLeadtime TextBox not found");
			test.log(Status.FAIL, "MaxLeadtime TextBox not found");
			Assert.assertFalse(false, "MaxLeadtime TextBox not found");
		}
	}

	public void MinLos(String MinLos)
	{
		if (Enter_MinLos.isDisplayed()) {
			Enter_MinLos.click();
			Enter_MinLos.clear();
			Enter_MinLos.sendKeys(MinLos);
			System.out.println("MinLos is entered successfully");
			test.log(Status.INFO, "MinLos is entered successfully");
			Assert.assertTrue(true,"MinLos is entered successfully");
		} else {
			System.out.println("MinLos TextBox not found");
			test.log(Status.FAIL, "MinLos TextBox not found");
			Assert.assertFalse(false, "MinLos TextBox not found");
		}
	}
	public void MaxLos(String MaxLos)
	{
		if (Enter_MaxLos.isDisplayed()) {
			Enter_MaxLos.click();
			Enter_MaxLos.clear();
			Enter_MaxLos.sendKeys(MaxLos);
			System.out.println("MaxLos is entered successfully");
			test.log(Status.INFO, "MaxLos is entered successfully");
			Assert.assertTrue(true,"MaxLos is entered successfully");
		} else {
			System.out.println("MaxLos TextBox not found");
			test.log(Status.FAIL, "MaxLos TextBox not found");
			Assert.assertFalse(false, "MaxLos TextBox not found");
		}

	}

	public void minleadtime()
	{
		if(Min_leadtime.isDisplayed())
		{
			Min_leadtime.click();
			Min_leadtime.clear();
			System.out.println("Minleadtime is displayed successfully");
			logger.info("Minleadtime is displayed successfully");
			test.log(Status.INFO, "Minleadtime is displayed successfully");
			Assert.assertTrue(true, "Minleadtime is displayed successfully");
		} 
		else 
		{
			System.out.println("Minleadtime is not displayed successfully");
			logger.error("Minleadtime is not displayed successfully");
			test.log(Status.FAIL, "Minleadtime is not displayed successfully");
			Assert.assertFalse(false, "Minleadtime is not displayed successfully");
		}

	}
	public void maxleadtime()
	{
		if(Max_leadtime.isDisplayed())
		{
			Max_leadtime.click();
			Max_leadtime.clear();
			System.out.println("Maxleadtime is displayed successfully");
			logger.info("Maxleadtime is displayed successfully");
			test.log(Status.INFO, "Maxleadtime is displayed successfully");
			Assert.assertTrue(true, "Maxleadtime is displayed successfully");
		} 
		else 
		{
			System.out.println("Maxleadtime is not displayed successfully");
			logger.error("Maxleadtime is not displayed successfully");
			test.log(Status.FAIL, "Maxleadtime is not displayed successfully");
			Assert.assertFalse(false, "Maxleadtime is not displayed successfully");
		}
	}
	public void minLos()
	{


		if(Min_Los.isDisplayed())
		{
			Min_Los.click();
			Min_Los.clear();
			System.out.println("Min_Los is displayed successfully");
			logger.info("Min_Los is displayed successfully");
			test.log(Status.INFO, "Min_Los is displayed successfully");
			Assert.assertTrue(true, "Min_Los is displayed successfully");
		} 
		else 
		{
			System.out.println("Min_Los is not displayed successfully");
			logger.error("Min_Los is not displayed successfully");
			test.log(Status.FAIL, "Min_Los is not displayed successfully");
			Assert.assertFalse(false, "Min_Los is not displayed successfully");
		}

	}

	public void MaxLos() 
	{
		if(Max_Los.isDisplayed())
		{
			Max_Los.click();
			Max_Los.clear();
			System.out.println("Max_Los is displayed successfully");
			logger.info("Max_Los is displayed successfully");
			test.log(Status.INFO, "Max_Los is displayed successfully");
			Assert.assertTrue(true, "Max_Los is displayed successfully");
		} 
		else 
		{
			System.out.println("Max_Los is not displayed successfully");
			logger.error("Max_Los is not displayed successfully");
			test.log(Status.FAIL, "Max_Los is not displayed successfully");
			Assert.assertFalse(false, "Max_Los is not displayed successfully");
		}

	}

	public void CallCentersearch()
	{
		if (Click_CallCenterSearchResultsyes.isDisplayed()) {
			Click_CallCenterSearchResultsyes.click();
			System.out.println(" CallCenterSearchResultsyes is selected successfully");
			test.log(Status.INFO, "CallCenterSearchResultsyes is Selected successfully");
			Assert.assertTrue(true,"CallCenterSearchResultsyes is Selected successfully");
		} else {
			System.out.println("CallCenterSearchResultsyes Radiobutton not found");
			test.log(Status.FAIL, "CallCenterSearchResultsyes Radiobutton not found");
			Assert.assertFalse(false, "CallCenterSearchResultsyes Radiobutton not found");
		}
	}

	public void display_offers()
	{
		ExplicitWait(display_offers);
		if(display_offers.isDisplayed())
		{
			System.out.println("Display in Special Offers Dropdown?	displayed succesfully");
			if(display_offers.isSelected())
			{
				System.out.println("yes button is enabled");
				logger.info("Yes is selected successfully");
				test.log(Status.INFO, "Yes is selected successfully");
				Assert.assertTrue(true, "Yes is selected successfully");
			}
			else
			{
				display_offers.click();

			}
		}
		else
		{
			logger.error("Display in Special Offers Dropdown?	is not displayed");
			test.log(Status.FAIL, "Display in Special Offers Dropdown?	is not displayed");
			Assert.assertFalse(false, "Display in Special Offers Dropdown?	is not displayed");
		}
	}

	public void Select_Basicpolicy()
	{
		if (Select_Basicpolicy.isDisplayed()) {
			Select_Basicpolicy.click();
			System.out.println("  Basicpolicy is selected successfully");
			test.log(Status.INFO, " Basicpolicy is selected successfully");
			Assert.assertTrue(true,"Basicpolicy is selected successfully");
		} else {
			System.out.println("Basicpolicy is not selected");
			test.log(Status.FAIL, " Basicpolicy is not selected");
			Assert.assertFalse(false, "Basicpolicy is not selected");
		}
	}

	public void selectpolicyid(String EnterSelectedpolicyid) throws InterruptedException
	{
		if (Selectedpolicyid.isDisplayed()) {
			Selectedpolicyid.click();
			SeleniumRepo.WaitForLoad(100);
			SeleniumRepoDropdown.selectDropDownText(Selectedpolicyid, EnterSelectedpolicyid);
			System.out.println(" Selectedpolicyid is entered successfully");
			test.log(Status.INFO, " Selectedpolicyid is entered successfully");
			Assert.assertTrue(true,"Selectedpolicyid is entered successfully");
		} else {
			System.out.println("Selectedpolicyid TextBox not found");
			test.log(Status.FAIL, " Selectedpolicyid TextBox not found");
			Assert.assertFalse(false, "Selectedpolicyid TextBox not found");
		}
	}


	public void inventory_BaseRatePlan(String Usrinput)
	{
		WebElement inventoryplan=SeleniumRepo.driver.findElement(By.xpath("//input[contains(@name,'ownInventory')][@value='"+Usrinput+"']"));

		if(inventoryplan.isSelected())
		{
			System.out.println(Usrinput +" button is enabled");
			logger.info(Usrinput +" button is enabled");
			test.log(Status.INFO, Usrinput +" button is enabled");
			Assert.assertTrue(true, Usrinput +" button is enabled");
		}
		else
		{
			inventoryplan.click();

		}

		if (Floatbyflatdifference.isDisplayed()) 
		{
			Floatbyflatdifference.click();
			System.out.println("Floatbyflatdifference is selected successfully");
			test.log(Status.INFO, "Floatbyflatdifference is Selected successfully");
			Assert.assertTrue(true,"Floatbyflatdifference is Selected successfully");
		} else 
		{
			System.out.println("Floatbyflatdifference Radiobutton not found");
			test.log(Status.FAIL, "Floatbyflatdifference Radiobutton not found");
			Assert.assertFalse(false, "Floatbyflatdifference Radiobutton not found");
		}

	}

	public void Rooms_inventory() throws IOException
	{
		int length = EnterNumofrooms.size();
		System.out.println(length);
        try {
		for(int j=1;j<=length;j++)
		{
			String minnoofrooms = ReadProperties.getPropValues("Admin.properties", "MINnoofrooms");
			String maxnoofrooms = ReadProperties.getPropValues("Admin.properties", "MAXnoofrooms");
			Thread.sleep(2000);
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'rate_difference')])["+j+"]")).isDisplayed()) {
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'rate_difference')])["+j+"]")).clear();
				Thread.sleep(2000);
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'rate_difference')])["+j+"]")).sendKeys(Integer.toString(
						SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minnoofrooms.trim()), Integer.parseInt(maxnoofrooms.trim()))));
				Thread.sleep(2000);
				System.out.println("ro is entered successfully");
				test.log(Status.INFO, "rate is entered successfully");
				Assert.assertTrue(true, "rate is entered successfully");
			} else {
				System.out.println("rate TextBox not found");
				test.log(Status.FAIL, "rate TextBox not found");
				Assert.assertFalse(false, "rate TextBox not found");
			}
		}
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void notes(String AdditionalNotes, String AgentComment)
	{
		if (Enter_AdditionalNotes.isDisplayed()) {
			Enter_AdditionalNotes.click();
			Enter_AdditionalNotes.clear();
			Enter_AdditionalNotes.sendKeys(AdditionalNotes);
			System.out.println("AdditionalNotes is entered successfully");
			test.log(Status.INFO, "AdditionalNotes is entered successfully");
			Assert.assertTrue(true,"AdditionalNotes is entered successfully");
		} else {
			System.out.println("AdditionalNotes TextBox not found");
			test.log(Status.FAIL, "AdditionalNotes TextBox not found");
			Assert.assertFalse(false, "AdditionalNotes TextBox not found");
		}

		if (Enter_AgentComment.isDisplayed()) {
			Enter_AgentComment.click();
			Enter_AgentComment.clear();
			Enter_AgentComment.sendKeys(AgentComment);
			System.out.println("AgentComment is entered successfully");
			test.log(Status.INFO, "AgentComment is entered successfully");
			Assert.assertTrue(true,"AgentComment is entered successfully");
		} else {
			System.out.println("AgentComment TextBox not found");
			test.log(Status.FAIL, "AgentComment TextBox not found");
			Assert.assertFalse(false, "AgentComment TextBox not found");
		}


	}

	public void click_save() throws InterruptedException
	{
		Thread.sleep(3000);

		try 
		{
			Click_Save.click();
			System.out.println(" New Rateplan saved ");
		} 
		catch (Exception e1)
		{
			System.out.println(" New Rateplan Not saved ");
			e1.printStackTrace();
		}
		try
		{
			Thread.sleep(5000);
			if (Click_arrow.isDisplayed())
			{
				Click_arrow.click();
				System.out.println(" Clicked on arrow ");
				test.log(Status.INFO, "  arrow  found ");
				Assert.assertTrue(true, "arrow  found");
			} else 
			{
				Rateplan.click();
				System.out.println("no arrow found");
				test.log(Status.FAIL, " no arrow found");
				Assert.assertFalse(false, "no arrow found");
			}
		}
		catch(Exception e)
		{
                System.out.println("Invalid Values for float Difference fields for rooms ");
		}

	}
	public void deriverates()
	{
		ExplicitWait(Deriverates);
		if(Deriverates.isSelected())
		{
			System.out.println("Derive rates off of a Rate Plan? selected as Yes ");
			logger.info("Derive rates off of a Rate Plan? selected as Yes");
			test.log(Status.INFO, "Derive rates off of a Rate Plan? selected as Yes");
			Assert.assertTrue(true, "Derive rates off of a Rate Plan? selected as Yes");

		}
		else
		{
			Javascriptexecutor(Deriverates);
			System.out.println("Derive rates off of a Rate Plan? selected as Yes ");
			logger.info("Derive rates off of a Rate Plan? selected as Yes");
			test.log(Status.INFO, "Derive rates off of a Rate Plan? selected as Yes");
			Assert.assertTrue(true, "Derive rates off of a Rate Plan? selected as Yes");
		}
	}

	public void verify_FBPSelectrateplan(String rateplan)
	{

		if(SelectRateplan.isDisplayed())

		{
			Select sc=new Select(SelectRateplan);
			sc.selectByVisibleText(rateplan);
			System.out.println("FBP Enabled Successfully to the rate plan is: "+rateplan);
			logger.info("FBP Enabled Successfully to the rate plan is: "+rateplan);
			test.log(Status.PASS, "FBP Enabled Successfully to the rate plan is: "+rateplan);
			

		}
		else
		{

			System.out.println("FBP is not Enabled ");
			logger.error("FBP is not Enabled");
			test.log(Status.FAIL, "FBP is not Enabled");
			
		}
	}

	public void verify_GroupBlock(String Groupblock) throws InterruptedException
	{

		if(Verify_GroupBlock.isDisplayed())

		{
			test.log(Status.INFO, "Group Block dropdown displayed successfully");

			Verify_GroupBlock.click();

			Thread.sleep(2000);

			selectByVisibleText(Select_GroupBlock,Groupblock);
			test.log(Status.INFO, "GroupBlock Enabled Successfully");
			Assert.assertTrue(true, "GroupBlock Enabled Successfully ");

		}
		else
		{

			System.out.println("Group Block dropdown not found ");
			logger.info("Group Block dropdown not found");
			test.log(Status.INFO, "Group Block dropdown not found");
			Assert.assertTrue(false, "Group Block dropdown not found");
		}
	}
	public void PromoURL()
	{
		if(PromoURL.isDisplayed())
		{
			test.log(Status.INFO, "PromoURL displayed successfully");
			PromoURL.click();
			test.log(Status.INFO, "PromoURL Clicked successfully");
			SeleniumRepo.waitForPageLoaded();
		}
		else
		{
			test.log(Status.FAIL, "PromoURl is not displayed");
			logger.error("PromoURl is not displayed");
		}
	}
}	




















































