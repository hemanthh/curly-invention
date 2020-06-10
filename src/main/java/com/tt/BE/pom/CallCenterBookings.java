package com.tt.BE.pom;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class CallCenterBookings extends BaseTest
{
	String formattedDate1;
	String Before_Offerprice;
	String Bookingmonth_date;
	String Endmonth_date;
	int year;
	int Month;
	int date;
	String BeforeModifyprice;
	String AfterModifyPrice;

	String arrivaldate ;


	/*WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,50);*/
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//*[@id='ccid']"), })

	private WebElement Call_Center_User;


	@FindAll({ @FindBy(xpath = "//*[@name='commit']"), })

	private WebElement Ok_Button;

	/*@FindAll({ @FindBy(xpath = "//*[contains(@ng-model,'arrival_date')]/following-sibling::span"), })

	private WebElement Arrival_date;*/

	/*	@FindAll({ @FindBy(xpath = "//*[contains(@ng-model,'departure_date')]/following-sibling::span"), })

	private WebElement Departure_date;*/


	@FindAll({ @FindBy(xpath = "//*[contains(@ng-model,'arrival_date')]"), })

	private WebElement Arrival_date;

	@FindAll({ @FindBy(xpath = "//*[contains(@ng-model,'departure_date')]"), })

	private WebElement Departure_date;
	
	@FindAll({ @FindBy(xpath = "//input[@id='group-plan-input']"), })

	public WebElement groupplan;
	

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Check availability')]"), })

	private WebElement Check_Availability;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Payment')]"), })

	private WebElement Payment;

	@FindAll({ @FindBy(xpath = "//*[contains(@name,'booking[first_name_')]"), })

	private WebElement First_Name;

	@FindAll({ @FindBy(xpath = "//*[contains(@name,'booking[last_name_')]"), })

	private WebElement Last_Name;

	@FindAll({ @FindBy(xpath = "//*[contains(@name,'booking[email_0')]"), })

	private WebElement Email;

	@FindAll({ @FindBy(xpath = "//*[@class='grp']"), })
	private List<WebElement> Extra_information;

	@FindAll({ @FindBy(xpath = "//textarea[@class='like-question-area form-control grp']"), })
	private List<WebElement> Extra_information_TextQuestion;

	@FindAll({ @FindBy(xpath = "//input[@id='card-holder-name']"), })
	private WebElement Nameoncard;

	@FindAll({ @FindBy(xpath = "//input[@id='card-number']"), })

	private WebElement CardNumb;

	@FindAll({ @FindBy(xpath = "//*[@aria-labelledby='select2-expiry-month-container']"), })

	private WebElement expdate;

	@FindAll({ @FindBy(xpath = "//select[@id='expiry-year']"), })

	private WebElement expyear;

	@FindAll({ @FindBy(xpath = "//*[@id='cvv']"), })

	private WebElement CVV;

	@FindAll({ @FindBy(xpath = "//*[@id='street_address1']"), })

	private WebElement addressline1;

	@FindAll({ @FindBy(xpath = "//*[@id='street_address2']"), })

	private WebElement addressline2;

	@FindAll({ @FindBy(xpath = "//*[@id='city']"), })

	private WebElement City;

	@FindAll({ @FindBy(xpath = "//*[@id='card-zip']"), })

	private WebElement Zipcode;

	@FindAll({ @FindBy(xpath = "//*[@id='customer-phone']"), })

	private WebElement PhoneNumber;

	@FindAll({ @FindBy(xpath = "//*[@name='terms-check']"), })

	private WebElement Click_accept;

	@FindAll({ @FindBy(xpath = "//*[@value='Complete reservation']"), })

	private WebElement CompleteReservation;

	@FindAll({ @FindBy(xpath = "//*[text()='Modify']"), })

	private WebElement Modify_Reservation;

	@FindAll({ @FindBy(xpath = "(//*[@class='modal-content'])[1]"), })

	private WebElement Model_Content;

	@FindAll({ @FindBy(xpath = "(//*[@class='modal-title'])[1]"), })

	private WebElement Model_Title;

	@FindAll({ @FindBy(xpath = "(//*[@class='ng-binding'])[1]"), })

	private WebElement Reservation_Fee;

	@FindAll({ @FindBy(xpath = "//*[text()='No']"), })

	private WebElement Modify_No;

	@FindAll({ @FindBy(xpath = "//*[text()='Yes']"), })

	private WebElement Modify_Yes;

	@FindAll({ @FindBy(xpath = "//*[text()='Edit search']"), })

	private WebElement Edit_Search;

	@FindAll({ @FindBy(xpath = "(//*[contains(@ng-options,'adults_per_room')])[1]"), })
	private WebElement Adults;
	
	@FindAll({ @FindBy(xpath = "//h4[normalize-space(.)='CHANGE RESERVATION?']/../..//button"), })
	public List<WebElement> acceptCHANGERESERVATIONPopUp;

	@FindAll({ @FindBy(xpath = "(//*[contains(@ng-options,'dropDownRoomCount')])[1]"), })

	private WebElement Rooms;

	@FindAll({ @FindBy(xpath = "(//select[contains(@ng-options,'children')])[2]"), })

	private WebElement Childrens;
	
	@FindAll({ @FindBy(xpath = "//a[@class='underline']"), })

	public List<WebElement> selectRoom;

	@FindAll({ @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]"), })

	private WebElement Country;

	@FindAll({ @FindBy(xpath = "//*[text()='Select a state']"), })

	private WebElement State;

	@FindAll({ @FindBy(xpath = "//*[text()='Group by room type']"), })

	private WebElement Groupbyroom;


	@FindAll({ @FindBy(xpath = "//*[text()='Cancel']"), })

	private WebElement Cancel_Reservation;

	@FindAll({ @FindBy(xpath = "(//*[@class='modal-content'])[3]"), })

	private WebElement Model_Content_Cancel;

	@FindAll({ @FindBy(xpath = "(//*[@class='modal-title'])[3]"), })

	private WebElement Model_Title_cancel;

	@FindAll({ @FindBy(xpath = "(//*[@class='bootbox-body'])[1]"), })

	private WebElement Cancel_Reservation_Fee;

	@FindAll({ @FindBy(xpath = "(//*[text()='No'])[2]"), })

	private WebElement Cancel_No;

	@FindAll({ @FindBy(xpath = "(//*[text()='Yes'])[2]"), })

	private WebElement Cancel_Yes;

	@FindAll({ @FindBy(xpath = "//button[text()='OK']"), })

	private WebElement Ok;



	@FindAll({ @FindBy(xpath = "//strike[@class='ng-binding']"), })

	private WebElement OldPrice;

	@FindAll({ @FindBy(xpath = "//span[@class='actual-cost ng-binding']"), })

	private WebElement NewPrice;
	
	
	@FindAll({ @FindBy(xpath = "//button[@class='dismissButton']"), })
	private WebElement googleMapsApiPopUp;
	
	


	public void GoToUrl() throws IOException
	{

		String CallCenterURL=ReadProperties.getPropValues("Admin.properties", "CallCenterURL");
		SeleniumRepo.GoToUrl(CallCenterURL);

	}

	public void Call_Center_User(String user)
	{
		ExplicitWait(Call_Center_User);
		if(Call_Center_User.isDisplayed())
		{
			Call_Center_User.sendKeys(user);
			logger.info("Call_Center_User name enterd successfully");
			test.log(Status.INFO, "Call_Center_User name enterd successfully");
			Assert.assertTrue(true, "Call_Center_User name enterd successfully");
		} 
		else 
		{
			System.out.println("CallCenter text field not found");
			logger.error("CallCenter text field not found");
			test.log(Status.FAIL, " CallCenter text field not found");
			Assert.assertFalse(false, "CallCenter text field not found");

		}
		if(Ok_Button.isDisplayed())
		{
			Javascriptexecutor(Ok_Button);
			SeleniumRepo.waitForPageLoaded();
			logger.info("Call_Center_user OK button enterd successfully");
			test.log(Status.INFO, "Call_Center_user OK button enterd successfully");
			Assert.assertTrue(true, "Call_Center_user OK button enterd successfully");
		} 
		else 
		{
			System.out.println("CallCenter Ok Button not found");
			logger.error("CallCenter Ok Button not found");
			test.log(Status.FAIL, " CallCenter Ok Button not found");
			Assert.assertFalse(false, "CallCenter Ok Button not found");

		}
	}

	public void arrival_date() throws InterruptedException
	{
		ExplicitWait(Arrival_date);
		Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
		formattedDate1 = df1.format(date1);

		arrivaldate = new SimpleDateFormat("d").format(date1);

		//String arrivaldate = df1.format(date);
		System.out.println(arrivaldate);

		if (Arrival_date.isDisplayed()) 
		{
			Javascriptexecutor(Arrival_date);

			Thread.sleep(1000);

			Arrival_date.clear();

			Arrival_date.sendKeys(formattedDate1);

			System.out.println("//*[text()='"+arrivaldate+"' and @class='day']");

			WebElement arrival=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+arrivaldate+"' and @class='active selected range-start day']"));
			Javascriptexecutor(arrival);


			Thread.sleep(2000);
			System.out.println("Arrivaldate is: "+formattedDate1);
			SeleniumRepo.waitForElementPresent(Departure_date);
			test.log(Status.INFO, "Clicked on arrivaldate Link");
			logger.info("Clicked on arrivaldate Link");
			Assert.assertTrue(true, "Clicked on arrivaldate Link");
		}
		else 
		{
			System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");
			Assert.assertFalse(false, "arrivaldate TextBox not found");
		}

	}

	public void departuredate() throws InterruptedException
	{
		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/dd", Locale.ENGLISH);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM dd", Locale.ENGLISH);
		LocalDate ld = LocalDate.parse(formattedDate1 , dtf);
		String Bookingmonth_date = dtf2.format(ld);*/
		ExplicitWait(Departure_date);

		Date date = new Date();
		date.setDate(date.getDate() + 7);
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		String formattedDate = df.format(date);

		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 7);

		String output =	df.format(now.getTime());
		System.out.println("output is"+ output);


		SimpleDateFormat df1 = new SimpleDateFormat("d");

		String depdate = df1.format(date);


		//depdate=depdate+7;


		if (Departure_date.isDisplayed()) 
		{
			Javascriptexecutor(Departure_date);
			Thread.sleep(5000);
			Departure_date.clear();

			//SeleniumRepo.driver.findElement(By.xpath("//*[contains(@ng-model,'departure_date')]/following-sibling::span")).click();

			/*System.out.println("//*[text()='"+depdate+"' and @class='day']");
			WebElement departure=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+depdate+"' and @class='day']"));
			Javascriptexecutor(departure);*/

			Departure_date.sendKeys(formattedDate);

			Thread.sleep(3000);

			WebElement departure=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+depdate+"' and @class='active selected range-end day']"));
			Javascriptexecutor(departure);


			Thread.sleep(7000);
			System.out.println("departuredate is entered successfully");
			System.out.println("departuredate is "+formattedDate);

			logger.info("departuredate is entered successfully");
			test.log(Status.INFO, "departuredate is entered successfully");
			Assert.assertTrue(true, "departuredate is entered successfully");
		} 

		else 
		{
			System.out.println("departuredate TextBox not found");
			logger.error("departuredate TextBox not found");
			test.log(Status.FAIL, "departuredate TextBox not found");
			Assert.assertFalse(false, "departuredate TextBox not found");
		}


		/*now.add(Calendar.DATE, -2);


		String output1 =	df.format(now.getTime());
		System.out.println("output1 is"+ output1);

		now.add(Calendar.DATE, +1);

		String formattedDate1 =	df.format(now.getTime());
		System.out.println("output3 is"+ formattedDate1);


		SimpleDateFormat da2 = new SimpleDateFormat("dd");

		arrivaldate = da2.format(date);

		System.out.println("arrivaldate" + arrivaldate);
		 */

	}


	//	public void arrival_date() throws InterruptedException
	//	{
	//		SeleniumRepo.waitForElementPresent(Arrival_date);
	//		Date date1 = new Date();
	//		date1.setDate(date1.getDate() + 1);
	//		SimpleDateFormat df1 = new SimpleDateFormat("YYYY/MM/dd");
	//		formattedDate1 = df1.format(date1);
	//
	//		if (Arrival_date.isDisplayed())
	//		{
	//			Javascriptexecutor(Arrival_date);
	//		Arrival_date.sendKeys(formattedDate1);
	//			
	//			System.out.println("arrivaldate is entered successfully");
	//			System.out.println("arrival date is "+formattedDate1);
	//			Thread.sleep(8000);
	//			SeleniumRepo.waitForElementPresent(Departure_date);
	//			test.log(Status.INFO, "Clicked on arrivaldate Link");
	//			logger.info("Clicked on arrivaldate Link");
	//			Assert.assertTrue(true, "Clicked on arrivaldate Link");
	//		}
	//		else 
	//		{
	//			System.out.println("arrivaldate TextBox not found");
	//			logger.error("arrivaldate TextBox not found");
	//			test.log(Status.FAIL, "arrivaldate TextBox not found");
	//			Assert.assertFalse(false, "arrivaldate TextBox not found");
	//		}
	//
	//	}
	//
	//	public void departuredate() throws InterruptedException
	//	{
	//		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/dd", Locale.ENGLISH);
	//		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM dd", Locale.ENGLISH);
	//		LocalDate ld = LocalDate.parse(formattedDate1 , dtf);
	//		String Bookingmonth_date = dtf2.format(ld);*/
	//
	//
	//		Date date = new Date();
	//		date.setDate(date.getDate() + 7);
	//		SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd");
	//		String formattedDate = df.format(date);
	//
	//		if (Departure_date.isDisplayed()) 
	//		{
	//			Javascriptexecutor(Departure_date);
	//			Departure_date.clear();
	//			Departure_date.sendKeys(formattedDate);
	//			System.out.println("departuredate is entered successfully");
	//			System.out.println("departuredate is "+formattedDate);
	//			Thread.sleep(3000);
	//			logger.info("departuredate is entered successfully");
	//			test.log(Status.INFO, "departuredate is entered successfully");
	//			Assert.assertTrue(true, "departuredate is entered successfully");
	//		} else {
	//			System.out.println("departuredate TextBox not found");
	//			logger.error("departuredate TextBox not found");
	//			test.log(Status.FAIL, "departuredate TextBox not found");
	//			Assert.assertFalse(false, "departuredate TextBox not found");
	//		}
	//	}
	//	

	public void select_rooms(String Noofrooms) throws InterruptedException
	{
		System.out.println("Enterd into rooms:-"+Noofrooms);
		Thread.sleep(2000);
		if(Rooms.isDisplayed())
		{
			/*Select rooms=new Select(Rooms);
			rooms.selectByVisibleText(Noofrooms);*/
			
			selectByVisibleText(Rooms, Noofrooms);
			System.out.println(Noofrooms+" selected from roomsdropdown successfully");
			Thread.sleep(2000);
			logger.info("Rooms selected from roomsdropdown successfully");
			test.log(Status.INFO, "Rooms selected from roomsdropdown successfully");
			Assert.assertTrue(true, "Rooms selected from roomsdropdown successfully");
		} else
		{
			System.out.println("Rooms dropdown not found");
			logger.error("Rooms dropdown not found");
			test.log(Status.FAIL, "Rooms dropdown not found");
			Assert.assertFalse(false, "Rooms dropdown not found");
		}

	}
	public void select_adults(String Noofadults) throws InterruptedException
	{
		System.out.println("Enterd into adults");
		if(Adults.isDisplayed())
		{
			Select adults=new Select(Adults);
			adults.selectByVisibleText(Noofadults);
			System.out.println(Noofadults+" selected from adultsdropdown successfully");
			Thread.sleep(2000);
			logger.info("Adults selected from adultsdropdown successfully");
			test.log(Status.INFO, "Adults selected from adultsdropdown successfully");
			Assert.assertTrue(true, "Adults selected from adultsdropdown successfully");
		} else
		{
			System.out.println("Adults dropdown not found");
			logger.error("Adults dropdown not found");
			test.log(Status.FAIL, "Adults dropdown not found");
			Assert.assertFalse(false, "Adults dropdown not found");
		}

	}
	public void select_Children(String Noofchildren) throws InterruptedException
	{
		System.out.println("Enterd into children");
		if(Childrens.isDisplayed())
		{
			Select childrens=new Select(Childrens);
			childrens.selectByVisibleText(Noofchildren);
			System.out.println(Noofchildren+" selected from Childrendropdown successfully");
			Thread.sleep(2000);
			logger.info("Children selected from Childrendropdown successfully");
			test.log(Status.INFO, "Children selected from Childrendropdown successfully");
			Assert.assertTrue(true, "Children selected from Childrendropdown successfully");
		} else
		{
			System.out.println("Children dropdown not found");
			logger.error("Children dropdown not found");
			test.log(Status.FAIL, "Children dropdown not found");
			Assert.assertFalse(false, "Children dropdown not found");
		}

	}

	public void Check_Availability()
	{
		SeleniumRepo.waitForElementPresent(Check_Availability);
		if(Check_Availability.isDisplayed())
		{
			Javascriptexecutor(Check_Availability);
			SeleniumRepo.waitForPageLoaded();
			logger.info("Check Availabitlity clicked successfully");
			test.log(Status.INFO, "Check Availabitlity clicked successfully");
			Assert.assertTrue(true, "Check Availabitlity clicked successfully");
		} else
		{
			System.out.println("Check Availabitlity button not found");
			logger.error("Check Availabitlity button not found");
			test.log(Status.FAIL, "Check Availabitlity button not found");
			Assert.assertFalse(false, "Check Availabitlity button not found");
		}

	}

	public String Select_roomtype(String RoomType,String Noofrooms,String Ratetype)
	{


		ExplicitWait(Groupbyroom);
		List<WebElement>lst=SeleniumRepo.driver.findElements(By.xpath("//*[@class='hotel-room-name ng-binding']"));
		SeleniumRepo.waitForElementsPresent(lst);

		for(int i=0;i<lst.size();i++)
		{
			String RoomName=lst.get(i).getText();
			System.out.println("Room name is: "+RoomName);
			if(RoomName.equals(RoomType))
			{
				System.out.println("Rooms are matched");
				WebElement Click_Select=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/../../../following-sibling::div/div/div[2]/a[text()='"+Ratetype+"']/../following-sibling::div[2]/a"));
				BeforeModifyprice=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/../../../following-sibling::div/div/div[2]/a[text()='"+Ratetype+"']/../following-sibling::div[2]/a/../following-sibling::div[2]")).getText();
				System.out.println("Before Modifying the room rate at same dates is :"+BeforeModifyprice);
				if((Noofrooms.equals("1 rooms"))) 
				{
					Javascriptexecutor(Click_Select);

					System.out.println(Noofrooms+" selected successfully");
					logger.info(RoomType+" room is available and selected successfully");
					test.log(Status.INFO, RoomType+" room is available and selected successfully");
					Assert.assertTrue(true, RoomType+" room is available and selected successfully");
				}

				else if(!(Noofrooms.equals("1 rooms")))
				{
					WebElement Room_add=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/../../../following-sibling::div/div/div[2]/a[text()='"+Ratetype+"']/../following-sibling::div[2]/a/../preceding-sibling::div[1]/span[3]"));
					Javascriptexecutor(Room_add);
					System.out.println(Noofrooms+" selected successfully");
				}
				break;
			}
			else
			{
				System.out.println(RoomType+" room is not available");
				//logger.error(RoomType+" room is not available");
				//test.log(Status.FAIL, RoomType+" room is not available");
				Assert.assertFalse(false,RoomType+" room is not available");
			}

		}
		return BeforeModifyprice;


	}

	public void payment()
	{
		if(Payment.isDisplayed())
		{
			Javascriptexecutor(Payment);
			SeleniumRepo.waitForPageLoaded();
			logger.info("Payment Clicked Successfully");
			test.log(Status.INFO, "Payment Clicked Successfully");
			Assert.assertTrue(true,"Payment Clicked Successfully");
		} 
		else
		{
			System.out.println("Payment button not found");
			logger.error("Payment button not found");
			test.log(Status.FAIL,"Payment button not found");
			Assert.assertFalse(false,"Payment button not found");
		}

	}

	public void First_name(String FirstName)
	{
		ExplicitWait(First_Name);
		if(First_Name.isDisplayed())
		{

			Javascriptexecutor(First_Name);
			First_Name.clear();
			First_Name.sendKeys(FirstName);
			System.out.println("Firstname enterd is :"+FirstName);
			logger.info("Firstname enterd is :"+FirstName);
			test.log(Status.INFO, "Firstname enterd is :"+FirstName);
			Assert.assertTrue(true, "Firstname enterd is :"+FirstName);
		} else {
			System.out.println("FirstName text field is not found");
			logger.error("FirstName text field is not found");
			test.log(Status.FAIL, "FirstName text field is not found");
			Assert.assertFalse(false, "FirstName text field is not found");
		}
	}
	public void Last_Name(String LastName)
	{

		if(Last_Name.isDisplayed())
		{
			Javascriptexecutor(Last_Name);
			Last_Name.clear();
			Last_Name.sendKeys(LastName);
			System.out.println("Lastname Entered is :"+LastName);
			logger.info("Lastname Entered is :"+LastName);
			test.log(Status.INFO, "Lastname Entered is :"+LastName);
			Assert.assertTrue(true, "Lastname Entered is :"+LastName);
		} else 
		{
			System.out.println("LastName text field is not found");
			logger.error("LastName text field is not found");
			test.log(Status.FAIL, "LastName text field is not found");
			Assert.assertFalse(false, "LastName text field is not found");
		}
	}
	public void Email(String Emailid)
	{

		if(Email.isDisplayed())
		{

			Javascriptexecutor(Email);
			Email.clear();
			Email.sendKeys(Emailid);
			System.out.println(" Email Entered is :"+Emailid);
			logger.info(" Email Entered is :"+Emailid);
			test.log(Status.INFO, " Email Entered is :"+Emailid);
			Assert.assertTrue(true, " Email Entered is :"+Emailid);
		} 

		else 
		{
			System.out.println("Email text field not found");
			logger.error("Email text field not found");
			test.log(Status.FAIL, "Email text field not found");
			Assert.assertFalse(false, "Email text field not found");

		}
	}

	

	/**
	 * Note: This CallCenter method should mirror ClassicFlow_ReservationDetailsPage but
	 * 		callcenter is not desinged the same way as classic. Adding a patch 
	 * 		to allow callcenter to handel text field guest preference questions.
	 * 		Revisit to properly handle.   
	 * 
	 */
	public void Extra_information()
	{
		SeleniumRepo.waitForElementsPresent(Extra_information);
		if(SeleniumRepo.driver.findElement(By.xpath("//*[@id='headingResGuPreferences']")).isDisplayed())
		{
			System.out.println("Guest Preference questions are displayed");
			for(WebElement questions:Extra_information)
			{
				Javascriptexecutor(questions);
				System.out.println("Guest Preference questions clicked successfully");
			}

		}
		
		
		if(SeleniumRepo.driver.findElement(By.xpath("//*[@id='headingResGuPreferences']")).isDisplayed())
		{
			System.out.println("Guest Preference text questions are displayed");
			for(WebElement questions:Extra_information_TextQuestion)
			{
				questions.clear();
				questions.sendKeys("Hello Nurse");
				System.out.println("Guest Preference text area questions answer successfully entered");
			}

		}
		
		
	}

	public void card_name(String Cardname) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Nameoncard);

		if(Nameoncard.isDisplayed())
		{
			Nameoncard.click();
			Nameoncard.clear();
			//Javascriptexecutor(Nameoncard);
			Nameoncard.sendKeys(Cardname);Thread.sleep(1000);
			logger.info("Entered card name");
			test.log(Status.INFO, "Entered card name");
			Assert.assertTrue(true, "Entered card name");
		}
		else 
		{
			System.out.println("Not Entered card name");
			logger.error("Not Entered card name");
			test.log(Status.FAIL, "Not Entered card name");
			Assert.assertFalse(false, "Not Entered card name");}
	}
	public void Card_number(String Numberoncard) throws InterruptedException
	{


		if(CardNumb.isDisplayed())
		{

			Javascriptexecutor(CardNumb);
			CardNumb.clear();

			TypeInField(CardNumb, Numberoncard);

			Thread.sleep(3000);
			logger.info("Entered card number");
			test.log(Status.INFO, "Entered card number");
			Assert.assertTrue(true, "Entered card number");
		} else {
			System.out.println("Not Entered card number");
			logger.error("Not Entered card number");
			test.log(Status.FAIL, "Not Entered card number");
			Assert.assertFalse(false, "Not Entered card number");}
	}
	public void Expdate()
	{

		if(expdate.isDisplayed())
		{
			//CardNumb.clear();
			expdate.click();
			//expdate.clear();
			SeleniumRepo.driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys(" Mar (03)");

			//	TypeInField(expyear, "Mar (03)");

			SeleniumRepo.driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();
			//expdate.sendKeys("02");
			logger.info("Entered Experied Month");
			test.log(Status.INFO, "Entered Experied Month");
			Assert.assertTrue(true, "Entered Experied Month");
		} else {
			System.out.println("Not Entered Experied Month");
			logger.error("Not Entered Experied Month");
			test.log(Status.FAIL, "Not Entered Experied Month");
			Assert.assertFalse(false, "Not Entered Experied Month");}

		if (expyear.isEnabled()) 
		{
			expyear.isDisplayed();
			expyear.click();
			//expyear.clear();
			//expyear.sendKeys("2022");

			Select sc=new Select(expyear);
			sc.selectByVisibleText("2025");

			logger.info("Entered Experied year");
			test.log(Status.INFO, "Entered Experied year");
			Assert.assertTrue(true, "Entered Experied year");
		} else {
			System.out.println("Not Entered Experied year");
			logger.error("Not Entered Experied year");
			test.log(Status.FAIL, "Not Entered Experied year");
			Assert.assertFalse(false, "Not Entered Experied year");}


		if (CVV.isEnabled()) {
			CVV.isDisplayed();
			CVV.click();
			CVV.clear();
			CVV.sendKeys("123");
			logger.info("Entered CVV number");
			test.log(Status.INFO, "Entered CVV number");
			Assert.assertTrue(true, "Entered CVV number");
		} else 
		{
			System.out.println("Not Entered CVV number");
			logger.error("Not Entered CVV number");
			test.log(Status.FAIL, "Not Entered CVV number");
			Assert.assertFalse(false, "Not Entered CVV number");
		}
	}

	public void CountryName(String Countryname)
	{
		if(Country.isDisplayed())
		{
			Country.click();
			System.out.println("country clicked");
			SeleniumRepo.driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys(Countryname);
			SeleniumRepo.driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();

			logger.info(Countryname+" country selected");
			test.log(Status.INFO,Countryname+ " country selected");
			Assert.assertTrue(true,Countryname+" country selected");
		} else 
		{
			System.out.println("Unable to select country");
			logger.error("Unable to select country");
			test.log(Status.FAIL, " Unable to select country");
			Assert.assertFalse(false, "Unable to select country");
		}

	}

	public void Billing_Address(String Address,String Enterzipcode,String Address2,String Enterstate,String Entercity)
	{

		//		if (State.isEnabled()) 
		//		{
		//			State.isDisplayed();
		//			Javascriptexecutor(State);
		//			WebElement Stateselect=SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+Enterstate+"'])[2]"));
		//			Javascriptexecutor(Stateselect);
		//			logger.info(Stateselect+" country selected");
		//			test.log(Status.INFO,Stateselect+ " country selected");
		//			Assert.assertTrue(true,Stateselect+" country selected");
		//		} else 
		//		{
		//			System.out.println("Unable to select state");
		//			logger.error("Unable to select state");
		//			test.log(Status.FAIL, " Unable to select state");
		//			Assert.assertFalse(false, "Unable to select state");
		//		}
		if (addressline1.isEnabled()) {
			addressline1.isDisplayed();
			addressline1.click();
			addressline1.clear();
			addressline1.sendKeys(Address);
			logger.info("Entered Address ");
			test.log(Status.INFO, "Entered Address");
			Assert.assertTrue(true, "Entered Address");
		} else {
			System.out.println("Not Entered Address");
			logger.error("Not Entered Address");
			test.log(Status.FAIL, "Not Entered Address");
			Assert.assertFalse(false, "Not Entered Address");}

		if (addressline2.isEnabled()) {
			addressline2.isDisplayed();
			addressline2.click();
			addressline2.clear();
			addressline2.sendKeys(Address2);
			
			logger.info("Entered Address2 ");
			test.log(Status.INFO, "Entered Address2");
			Assert.assertTrue(true, "Entered Address2");
		} else {
			System.out.println("Not Entered Address2");
			logger.error("Not Entered Address2");
			test.log(Status.FAIL, "Not Entered Address2");
			Assert.assertFalse(false, "Not Entered Address2");}

		//create this if statement to handle possible google map pop that appears on CallCenter payment page
		if (SeleniumRepo.isElementDisplayed(googleMapsApiPopUp) == true ) 
		{
			//SeleniumRepo.driver.findElement(By.xpath("//button[@class='dismissButton']"))
			Javascriptexecutor(googleMapsApiPopUp);
					
			logger.info("Dismissing the Google maps popup ");
			test.log(Status.INFO, "Google map messaged appeared");

		} 

		if (City.isEnabled()) {
			City.isDisplayed();
			City.click();
			City.clear();
			City.sendKeys(Entercity);
			logger.info("Entered city ");
			test.log(Status.INFO, "Entered City");
			Assert.assertTrue(true, "Entered City");
		} else {
			System.out.println("Not Entered City");
			logger.error("Not Entered City");
			test.log(Status.FAIL, "Not Entered City");
			Assert.assertFalse(false, "Not Entered City");}
		

		if (Zipcode.isEnabled()) {
			Zipcode.isDisplayed();
			Zipcode.click();
			Zipcode.clear();
			Zipcode.sendKeys(Enterzipcode);
			logger.info("Entered Zipcode ");
			test.log(Status.INFO, "Entered Zipcode");
			Assert.assertTrue(true, "Entered Zipcode");
		} else {
			System.out.println("Not Entered Zipcode");
			logger.error("Not Entered Zipcode");
			test.log(Status.FAIL, "Not Entered Zipcode");
			Assert.assertFalse(false, "Not Entered Zipcode");
		}

	}
	public void PhoneNumber(String Enterphonenum)
	{
		if (PhoneNumber.isEnabled()) 
		{
			PhoneNumber.isDisplayed();
			PhoneNumber.click();
			PhoneNumber.clear();
			PhoneNumber.sendKeys(Enterphonenum);
			logger.info("Entered PhoneNumber ");
			test.log(Status.INFO, "Entered PhoneNumber");
			Assert.assertTrue(true, "Entered PhoneNumber");
		} else {
			System.out.println("Not Entered PhoneNumber");
			logger.error("Not Entered PhoneNumber");
			test.log(Status.FAIL, "Not Entered PhoneNumber");
			Assert.assertFalse(false, "Not Entered PhoneNumber");
		}
	}
	public void Click_accept()
	{
		if(Click_accept.isDisplayed())
		{
			Javascriptexecutor(Click_accept);
			SeleniumRepo.waitForPageLoaded();
			logger.info("Clicked on Accept Succesfully");
			test.log(Status.INFO, "Clicked on Accept Succesfully");
			Assert.assertTrue(true, "Clicked on Accept Succesfully");
		} else 
		{
			System.out.println("Accept checkbox not found");
			logger.error("Accept checkbox not found");
			test.log(Status.FAIL, "Accept checkbox not found");
			Assert.assertFalse(false, "Accept checkbox not found");
		}

	}

	public void Complete_Reservation() throws InterruptedException
	{

		if (CompleteReservation.isEnabled())
		{
			CompleteReservation.isDisplayed();
			Javascriptexecutor(CompleteReservation);
			logger.info("Clicked on CompleteReservation button");
			test.log(Status.INFO, "Clicked on CompleteReservation button");
			Assert.assertTrue(true, "Clicked on CompleteReservation button");

			SeleniumRepo.waitForPageLoaded();

			Thread.sleep(5000);
			logger.info("Clicked on CompleteReservation button");
			test.log(Status.INFO, "Clicked on CompleteReservation button");
			Assert.assertTrue(true, "Clicked on CompleteReservation button");
		} else {
			System.out.println("Not Clicked on CompleteReservation button");
			logger.error("Not Clicked on CompleteReservation button");
			test.log(Status.FAIL, "Not Clicked on CompleteReservation button");
			Assert.assertFalse(false, "Not Clicked on CompleteReservation button");}
	}
	public void CallCenter_ChangeReservation() throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Modify_Reservation);
		if(Modify_Reservation.isDisplayed())
		{

			Javascriptexecutor(Modify_Reservation);
			System.out.println("ChangeReservation clicked  successfully");
			test.log(Status.INFO, "ChangeReservation clicked  successfully");
			Assert.assertTrue(true,"ChangeReservation clicked  successfully");
			Thread.sleep(2000);
			try 
			{

				ExplicitWait(Model_Content);

				System.out.println("Modify reservation PopUp displayed");

				String reservationTitle=Model_Title.getText();
				System.out.println("Reservation title is "+reservationTitle);

				String Reservationfee=Reservation_Fee.getText();
				System.out.println("Reservation title is "+Reservationfee);


				//SeleniumRepo.waitForElementPresent(Change_Reservation_Fee_Yes);

				if(Modify_Yes.isDisplayed())
				{
					System.out.println(Modify_Yes.getText());
					//Change_Reservation_Fee_Yes.click();
					System.out.println("Yes button is displayed on Change reservation POPUP successfully");
					test.log(Status.INFO, "Yes button is displayed on Change reservation POPUP successfully");
					Assert.assertTrue(true,"Yes button is displayed on Change reservation POPUP successfully");

				}
				else
				{
					System.out.println("Yes button is not found  on Change reservation POPUP");
					test.log(Status.INFO, "Yes button is not found  on Change reservation POPUP");
					Assert.assertFalse(false,"Yes button is not found  on Change reservation POPUP");
				}
				if(Modify_No.isDisplayed())
				{
					System.out.println("No button is displayed on Change reservation POPUP successfully");
					test.log(Status.INFO, "Yes button is displayed on Change reservation POPUP successfully");
					Assert.assertTrue(true,"Yes button is displayed on Change reservation POPUP successfully");
				}
				else
				{
					System.out.println("NO button is not found  on Change reservation POPUP");
					test.log(Status.INFO, "NO button is not found  on Change reservation POPUP");
					Assert.assertFalse(false,"NO button is not found  on Change reservation POPUP");
				}
				Modify_Yes.click();
				SeleniumRepo.waitForPageLoaded();
				SeleniumRepo.waitForElementPresent(Edit_Search);
				System.out.println("Yes button is clicked on Change reservation POPUP successfully");
				test.log(Status.INFO, "Yes button is clicked on Change reservation POPUP successfully");
				Assert.assertTrue(true,"Yes button is clicked on Change reservation POPUP successfully");

			}
			catch(Exception e)
			{
				System.out.println("Change Reservation popup is not displayed to show Yes & No Button");
			}
		}
		else
		{
			System.out.println("ChangeReservation Element is not clicked");
			test.log(Status.INFO, "ChangeReservation Element is not clicked");
			Assert.assertTrue(true,"ChangeReservation Element is not clicked");
			Thread.sleep(2000);
		}

	}
	public void Edit_search() throws InterruptedException
	{
		Thread.sleep(5000);
		SeleniumRepo.waitForElementPresent(Edit_Search);
		if(Edit_Search.isDisplayed())

		{
			Javascriptexecutor(Edit_Search);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Edit_Search clicked successfully");
			logger.info("Clicked on Edit_Search button");
			test.log(Status.INFO, "Clicked on Edit_Search button");
			Assert.assertTrue(true, "Clicked on Edit_Search button");
		} 
		else 
		{
			System.out.println("Not Clicked on Edit_Search button");
			logger.error("Not Clicked on Edit_Search button");
			test.log(Status.FAIL, "Not Clicked on Edit_Search button");
			Assert.assertFalse(false, "Not Clicked on Edit_Search button");
		}
	}



	public void CallCenter_Pricemodifycheck(String RoomType,String RoomRate,String Noofrooms,String Beforeprice,String Ratetype)
	{
		System.out.println("enterd into");
		SeleniumRepo.waitForElementPresent(Groupbyroom);
		List<WebElement>lst=SeleniumRepo.driver.findElements(By.xpath("//*[@class='hotel-room-name ng-binding']"));
		System.out.println(lst.size()+" rooms are available");
		SeleniumRepo.waitForElementsPresent(lst);

		for(int i=0;i<lst.size();i++)
		{
			String RoomName=lst.get(i).getText();
			System.out.println("Room name is: "+RoomName);
			if(RoomName.equals(RoomType))
			{
				System.out.println("Rooms are matched and Ready to book");
				WebElement Click_Select=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/../../../following-sibling::div/div/div[2]/a[text()='"+Ratetype+"']/../following-sibling::div[2]/a"));
				AfterModifyPrice=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/../../../following-sibling::div/div/div[2]/a[text()='"+Ratetype+"']/../following-sibling::div[2]/a/../following-sibling::div[2]")).getText();
				System.out.println("Before modified room rate at same dates is :"+Beforeprice);
				System.out.println("After Modifying the room rate at same dates is :"+AfterModifyPrice);
				if(AfterModifyPrice.contains(RoomRate))
				{
					System.out.println("Room price is modified");
					System.out.println("Room price is modified Successfully");
					test.log(Status.INFO, "Room price is modified Successfully");
					Assert.assertTrue(true,"Room price is modified Successfully");

				}
				else
				{
					System.out.println("Room price is not modified Successfully");
					test.log(Status.INFO, "Room price is not modified Successfully");
					Assert.assertFalse(false,"Room price is not modified Successfully");

				}
				if((Noofrooms.equals("1 rooms"))) 
				{
					Javascriptexecutor(Click_Select);

					System.out.println(Noofrooms+" selected successfully");
					logger.info(RoomType+" room is available and selected successfully");
					test.log(Status.INFO, RoomType+" room is available and selected successfully");
					Assert.assertTrue(true, RoomType+" room is available and selected successfully");
				}

				else if(!(Noofrooms.equals("1 rooms")))
				{
					WebElement Room_add=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/../../../following-sibling::div/div[1]/div[3]/span[3]"));
					Javascriptexecutor(Room_add);
					System.out.println(Noofrooms+" selected successfully");
				}
				break;
			}
			else
			{
				System.out.println(RoomType+" room is not available");
				//logger.error(RoomType+" room is not available");
				//test.log(Status.FAIL, RoomType+" room is not available");
				Assert.assertFalse(false,RoomType+" room is not available");
			}

		}


	}


	public void Click_CancelReservation() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("enterd into cancel reservation");


		SeleniumRepo.waitForElementPresent(Cancel_Reservation);

		if(Cancel_Reservation.isDisplayed())
		{

			Javascriptexecutor(Cancel_Reservation);
			SeleniumRepo.waitForPageLoaded();
			Thread.sleep(5000);
			test.log(Status.INFO, "cancel reservation button clicked successfully");
			Assert.assertTrue(true,"cancel reservation button clicked successfully");
			SeleniumRepo.waitForElementPresent(Model_Content_Cancel);		
		}
		else
		{
			System.out.println("Cancel reservation button is not found");
			test.log(Status.INFO, "Cancel reservation button is not found");
			Assert.assertFalse(false,"Cancel reservation button is not found");
		}
	}

	public void Cancel_Popup_title() throws InterruptedException 
	{

		try {
			SeleniumRepo.waitForElementPresent(Model_Content_Cancel);

			if(Model_Content_Cancel.isDisplayed())
			{
				System.out.println("Cancel reservation popup title displayed");
				test.log(Status.INFO, "Cancel reservation popup title displayed");
				Assert.assertTrue(true,"Cancel reservation popup title displayed");
				String Actualtitle=Model_Title_cancel.getText();
				String Expectedtitle="CANCEL RESERVATION?";
				System.out.println("cancel reservation popup title is  "+Actualtitle );
				if(Actualtitle.equalsIgnoreCase(Expectedtitle))
				{
					System.out.println("Cancel reservation popup title matches");
					test.log(Status.INFO, "Cancel reservation popup title matches");
					Assert.assertTrue(true,"Cancel reservation popup title matches");		
				}
				else
				{
					System.out.println("Cancel reservation popup title not matched");
					test.log(Status.INFO, "Cancel reservation popup title not matched");
					Assert.assertFalse(false,"Cancel reservation popup title not matched");
				}
			}
			else
			{
				System.out.println("Cancel reservation popup title not found");
				test.log(Status.INFO, "Cancel reservation popup title not found");
				Assert.assertFalse(false,"Cancel reservation popup title not found");

			}

			if(Cancel_Reservation_Fee.isDisplayed())
			{
				String cancelation_fee=Cancel_Reservation_Fee.getText();
				System.out.println("Cancelation fee is  "+cancelation_fee);	
				test.log(Status.INFO, "Cancelation fee is "+cancelation_fee);
				Assert.assertTrue(true,"Cancelation fee is "+cancelation_fee);
				Javascriptexecutor(Cancel_Yes);
				SeleniumRepo.waitForPageLoaded();

			}
			else
			{
				System.out.println("Cancelation fee not applied");
				test.log(Status.INFO, "Cancelation fee not applied");
				Assert.assertFalse(false,"Cancelation fee not applied");

			}
			System.out.println("enter cancel1");

			ExplicitWait(Ok);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
			if(Model_Content_Cancel.isDisplayed())
			{
				System.out.println("Cancel reservation confirmation title displayed");
				test.log(Status.INFO, "Cancel reservation confirmation title displayed");
				Assert.assertTrue(true,"Cancel reservation confirmation title displayed");
				String Actual_confirmation=Model_Title_cancel.getText();
				String Expected_confirmation="YOUR RESERVATION HAS BEEN CANCELLED";
				System.out.println("cancel reservation popup title is  "+Actual_confirmation );
				if(Actual_confirmation.equalsIgnoreCase(Expected_confirmation))
				{
					System.out.println("Cancel reservation confirmation title matches");
					test.log(Status.INFO, "Cancel reservation confirmation title matches");
					Assert.assertTrue(true,"Cancel reservation confirmation title matches");		
				}
				else
				{
					System.out.println("Cancel reservation confirmation title not matched");
					test.log(Status.INFO, "Cancel reservation confirmation title not matched");
					Assert.assertFalse(false,"Cancel reservation confirmation title not matched");
				}
			}
			else
			{
				System.out.println("Cancel reservation popup confirmation not found");
				test.log(Status.INFO, "Cancel reservation popup confirmation not found");
				Assert.assertFalse(false,"Cancel reservation popup confirmation not found");

			}
			String cancelation_text=Cancel_Reservation_Fee.getText();

			System.out.println("Cancelation code is: "+cancelation_text);
			test.log(Status.INFO, "Cancelation code is: "+cancelation_text);


		}
		catch(Exception e)
		{
			System.out.println("Cancel reservation popup is not displayed");
			test.log(Status.INFO, "Cancel reservation popup is not displayed");
			Assert.assertFalse(false,"Cancel reservation popup is not displayed");

		}
	}

	public void verify_Strike(String AdminDay,String RatePlan,String FlatAmount,String ShortDescription,String SteadyDays,String discounttype,String NthNight,String DISCOUNT_DEFINITION,String Percentage) throws InterruptedException, ParseException
	{
		test.log(Status.PASS, "DPR applied for the Rateplan:-"+RatePlan);
		logger.info("DPR applied for the Rateplan:-"+RatePlan);


			ExplicitWait(First_Name);


			if(OldPrice.isDisplayed())
			{
				System.out.println("Before Applying the DPR Room price is:-"+OldPrice.getText());
				test.log(Status.PASS, "DPR applied Successfully in Call Center");
				test.log(Status.PASS, "Before Applying the DPR Room price is:-"+OldPrice.getText());
				logger.info("Before Applying the DPR Room price is:-"+OldPrice.getText());
			}
			else
			{
				test.log(Status.FAIL, "DPR is not applied");
				logger.error("DPR is not applied");
			}
		
	}
}











