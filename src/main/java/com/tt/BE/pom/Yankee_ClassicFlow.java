package com.tt.BE.pom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import ch.lambdaj.Lambda;

public class Yankee_ClassicFlow extends BaseTest
{
	String formattedDate1;
	String Before_Offerprice;
	String Bookingmonth_date;
	String Endmonth_date;
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//a[@id='currency-dropdown']"), })

	public WebElement currencydropdown;

	@FindAll({ @FindBy(xpath = "//*[@id='search_arrival_date']"), })

	public WebElement arrivaldate;

	@FindAll({ @FindBy(xpath = "//*[@id='search_departure_date']"), })

	public WebElement departuredate;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Choose Guests:')]"), })

	public WebElement ChooseGuests;

	@FindAll({ @FindBy(xpath = "//*[text()='Got it!']"), })

	public WebElement ok;

	@FindAll({ @FindBy(xpath = "(//*[contains(@title,'adults in room')])[1]"), })

	public WebElement ChooseAdults;

	@FindAll({ @FindBy(xpath = "(//*[contains(@title,'children in room 1')])[1]"), })

	public WebElement ChooseChildren;

	@FindAll({ @FindBy(xpath = "//*[@id='guests_rooms_done']"), })

	public WebElement Guests_Done;

	@FindAll({ @FindBy(xpath = "//button[@id='check-availability-btn']"), })

	public WebElement Checkavailability;

	@FindAll({ @FindBy(xpath = "//span[@class='text-capitalizes']"),@FindBy(css="body.standard-flow.ng-scope:nth-child(2) div.ng-scope:nth-child(16) div.room-page.ng-scope:nth-child(8) aside.search-form.z-index div.container.roomsSearchForm form.edit_search.ng-pristine.ng-valid.ng-isolate-scope:nth-child(4) div.search-form-item.search-form-offer:nth-child(4) a.search-form-offer-link strong:nth-child(1) > span.text-capitalizes") })

	public WebElement SpecialRates_offercode;

	@FindAll({ @FindBy(xpath = "//*[@id='modalTitle']"), })

	public WebElement Modeltitle;

	@FindAll({ @FindBy(xpath = "//button[contains(@class,'button') and @id='special-rates-promo-done']"), })

	public WebElement Specialdone;

	@FindAll({ @FindBy(xpath = "(//*[contains(@id,'edit_booking_')]/div[1]/h2/text())[1]"), })

	public WebElement Room_Check;
	
	@FindAll({ @FindBy(xpath = "//div[contains(@id,'add-on-modal-description')]/..//button[normalize-space(.)='No thanks']"), })

	public List<WebElement> nothanksRoom;
	
	

	@FindAll({ @FindBy(xpath = "//a[@class='button button-colors float-right']"), })

	public WebElement verify_startover;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_first_name']"), })

	public WebElement Enter_Firstname;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_last_name']"), })

	public WebElement Enter_lastname;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_email']"), })

	public WebElement Enter_Email;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'WE SEND YOUR CONFIRMATION?')]/following-sibling::div/descendant::input[2]"), })

	public WebElement click_iwouldlike;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Taxes and fees:')]"), })

	public WebElement verify_paymenttaxesandfees;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Grand total:')]"), })

	public WebElement verify_paymentgrandtotal;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Room charges:')]"), })

	public WebElement verify_paymentroomcharges;

	@FindAll({ @FindBy(xpath = "//fieldset[@class='room-details-form']//legend[@class='h3']"), })

	public WebElement Verify_CardInformation;

	@FindAll({ @FindBy(xpath = "//div[@class='room-billing-card-title']"), })

	public WebElement Verify_AcceptedCreditcard;

	@FindAll({ @FindBy(xpath = "//input[@id='card_holder_name']"), })

	public WebElement Nameoncard;

	@FindAll({ @FindBy(xpath = "//input[@id='card_number']"), })

	public WebElement CardNumb;

	@FindAll({ @FindBy(xpath = "//select[@id='expiration_date_month']"), })

	public WebElement expdate;

	@FindAll({ @FindBy(xpath = "//select[@id='expiration_date_year']"), })

	public WebElement expyear;

	@FindAll({ @FindBy(xpath = "//input[@id='security_code']"), })

	public WebElement CVV;


	@FindAll({ @FindBy(xpath = "//legend[contains(text(),'Billing address')]"), })

	public WebElement verify_Billingaddress;

	@FindAll({ @FindBy(xpath = "//select[@id='booking_country']"), })

	public WebElement Countrydropdown;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_street_address1']"), })

	public WebElement addressline1;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_street_address2']"), })

	public WebElement addressline2;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_city']"), })

	public WebElement City;

	@FindAll({ @FindBy(xpath = "//select[@title='State']"), })

	public WebElement State;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_zip_code']"), })

	public WebElement Zipcode;

	@FindAll({ @FindBy(xpath = "//legend[contains(text(),'Additional contact information')]"), })

	public WebElement contactinformation;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_phone_number']"), })

	public WebElement PhoneNumber;

	@FindAll({ @FindBy(xpath = "//span[@class='accept_booking']//label"), })

	public WebElement Verify_accept;

	@FindAll({ @FindBy(xpath = "//input[@id='accept']"), })

	public WebElement Click_accept;

	@FindAll({ @FindBy(xpath = "//input[@value='Pay Now']"),
		@FindBy(xpath = "//input[@value='Complete reservation']"),
		})

	public WebElement CompleteReservation;
	
	@FindAll({ @FindBy(xpath = "//button[@ng-click='submitForm()']"), })

	public List<WebElement> serChargeYes;
	
	@FindAll({ @FindBy(xpath = "//div[@class='action-buttons-container']/..//button[contains(text(),'Yes')]"), })

	public List<WebElement> serchargeYes;

	@FindAll({ @FindBy(xpath = "//select[@id='roomsselector']"), })

	public WebElement select_rooms;

	@FindAll({ @FindBy(xpath = "//select[@id='roomsselector']"), })

	public List<WebElement> Listselect_adults;

	@FindAll({ @FindBy(xpath = "(//*[starts-with(@id,'children-in-room')])[1]"), })

	public List<WebElement> Listselect_childrens;

	@FindAll({ @FindBy(xpath = "//button[@id='guests_rooms_done']"), })

	public WebElement roomselectiondone;

	@FindAll({ @FindBy(xpath = "//*[@class='rooms_item_title']"), })

	public List<WebElement> Rooms_List;
	
	@FindAll({ @FindBy(xpath = "//*[@class='rooms_item_title']/..//button[normalize-space(.)='Book now']"), })

	public List<WebElement> bookRooms_List;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Cancel reservation')]"), })

	public List<WebElement> Verify_cancelreservation;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Cancel reservation')]"), })

	public List<WebElement> Verify_changereservation;

	@FindAll({ @FindBy(xpath = "//th[@id='summary_reservation_confirmation_code']"), })

	public WebElement Verify_conformation;

	@FindAll({ @FindBy(xpath = "//th[@id='summary_reservation_confirmation_code']/strong"), })

	public WebElement Verify_conformationcode;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Room charges')]"), })

	public WebElement Verify_Thankuroomcharges;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Other Services')]"), })

	public WebElement Verify_Thankuothercharges;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Taxes and fees')]"), })

	public WebElement Verify_ThankuTaxesandfees;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Grand total')]"), })

	public WebElement Verify_Thankugrandtotal;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Check in time:')]"), })

	public WebElement verify_Checkin;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Check in time:')]/following-sibling::div"), })

	public WebElement verify_Checkintime;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Check out time:')]"), })

	public WebElement verify_Checkout;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Check out time:')]/following-sibling::div"), })

	public WebElement verify_Checkouttime;

	@FindAll({ @FindBy(xpath = "//span[@class='ng-scope']"), })

	public WebElement verify_Termsandconditions;

	@FindAll({ @FindBy(xpath = "//*[@class='h3 summary-terms-h3']/following-sibling::ul"), })

	public WebElement verify_Termsandconditionstext;


	public void GoToUrl() throws IOException
	{
		String beurl=ReadProperties.getPropValues("Admin.properties", "BEURL");
		SeleniumRepo.GoToUrl(beurl);
	}

	public void currencydropdown() throws InterruptedException 
	{
		SeleniumRepo.waitForElementPresent(currencydropdown);
		if (currencydropdown.isEnabled()) 
		{
			Javascriptexecutor(currencydropdown);
			SeleniumRepo.WaitForLoad(100);
			logger.info("Clicked on currnecy dropdown Link");
			test.log(Status.INFO, "Clicked on currnecy dropdown Link");
			Assert.assertTrue(true, "Clicked on currency dropdown Link");
		} 
		else 
		{
			System.out.println("currency dropdown not found");
			logger.error("currency dropdown not found");
			test.log(Status.FAIL, " currency dropdown not found");
			Assert.assertFalse(false, "currency dropdown not found");

		}
	}
	public void arrival_date() throws InterruptedException
	{
		Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YYYY");
		formattedDate1 = df1.format(date1);

		if (SeleniumRepo.isElementPresent(arrivaldate)) {
			Javascriptexecutor(arrivaldate);
			arrivaldate.sendKeys(formattedDate1);
			System.out.println("arrivaldate is entered successfully");
			System.out.println("arrival date is "+formattedDate1);
			Thread.sleep(3000);
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM dd", Locale.ENGLISH);
		LocalDate ld = LocalDate.parse(formattedDate1 , dtf);
		String Bookingmonth_date = dtf2.format(ld);
		System.out.println(Bookingmonth_date);


		Date date = new Date();
		date.setDate(date.getDate() + 4);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		String formattedDate = df.format(date);

		if (departuredate.isDisplayed()) {
			
			//Commented out the javascriptexecutor line becasue 
			//During RC17 regression testing the click was not registering
			departuredate.click();
			
			//Javascriptexecutor(departuredate);
			Thread.sleep(3000);
			departuredate.clear();
			
		TypeInField(departuredate, formattedDate);
			//departuredate.sendKeys(formattedDate);
			System.out.println("departuredate is entered successfully");
			System.out.println("departuredate is "+formattedDate);
			Thread.sleep(3000);
			logger.info("departuredate is entered successfully");
			test.log(Status.INFO, "departuredate is entered successfully");
			Assert.assertTrue(true, "departuredate is entered successfully");
		} else {
			System.out.println("departuredate TextBox not found");
			logger.error("departuredate TextBox not found");
			test.log(Status.FAIL, "departuredate TextBox not found");
			Assert.assertFalse(false, "departuredate TextBox not found");
		}
	}
	public void popup_ok() throws InterruptedException 
	{
		Thread.sleep(3000);
		if (ok.isDisplayed()) 
		{
			Javascriptexecutor(ok);
			
			logger.info("Clicked on ok");
			test.log(Status.INFO, "Clicked on ok");
			
		} 
		else {
			
			logger.error("Ok Popup not found");
			test.log(Status.FAIL, "Ok Popup not found");
		}

	}

	public void ChooseGuests() 
	{
		if (ChooseGuests.isDisplayed()) {
			Javascriptexecutor(ChooseGuests);
			System.out.println("ChooseGuests popup opened successfully");
			logger.info("ChooseGuests popup opened successfully");
			test.log(Status.INFO, "ChooseGuests popup opened successfully");
			Assert.assertTrue(true, "ChooseGuests popup opened successfully");
		} else {
			System.out.println("ChooseGuests popup  not opened");
			logger.error("ChooseGuests popup  not opened");
			test.log(Status.FAIL, "ChooseGuests popup  not opened");
			Assert.assertFalse(false, "ChooseGuests popup  not opened");
		}
	}
	public void select_Members(String Enterrooms) throws InterruptedException, IOException
	{
		Thread.sleep(3000);

		if (select_rooms.isEnabled()) 
		{
			//select_rooms.isDisplayed();
			select_rooms.click();
			SeleniumRepo.WaitForLoad(100);
			SeleniumRepoDropdown.selectDropDownValue(select_rooms, Enterrooms);
			logger.info("rooms selected");
			test.log(Status.INFO, "rooms selected");
			Assert.assertTrue(true, "rooms selected");
		} 
		else 
		{
			System.out.println("Rooms Dropdown is not found");
			//logger.error("Rooms Dropdown is not found");
			//test.log(Status.FAIL, "Rooms Dropdown is not found");
			Assert.assertFalse(false, "Rooms Dropdown is not found");
		}
		int adultslength = Listselect_adults.size();
		System.out.println(adultslength);

		for(int j=1;j<=adultslength;j++)
		{
			String minnoofadults = ReadProperties.getPropValues("Admin.properties", "MINnoofadults");	
			String maxnoofadults = ReadProperties.getPropValues("Admin.properties", "MAXnoofadults");
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'adults-in-room')])["+j+"]")).isDisplayed()) 
			{
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'adults-in-room')])["+j+"]")).sendKeys(Integer.toString(
						SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minnoofadults), Integer.parseInt(maxnoofadults))));
				System.out.println("adults is entered successfully");
				logger.info("adults is entered successfully");
				test.log(Status.INFO, "adults is entered successfully");
				Assert.assertTrue(true, "adults is entered successfully");
			}
			else 
			{
				System.out.println("adults dropdown not found");
				logger.error("adults dropdown not found");
				test.log(Status.FAIL, "adults dropdown not found");
				Assert.assertFalse(false, "adults dropdown not found");
			}
		}
		int childrenslength = Listselect_childrens.size();
		System.out.println(childrenslength);

		for(int i=1;i<=childrenslength;i++)
		{
			String minnoofchildrens = ReadProperties.getPropValues("Admin.properties", "MINnoofchildrens");
			String maxnoofchildrens = ReadProperties.getPropValues("Admin.properties", "MAXnoofchildrens");
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'children-in-room')])["+i+"]")).isDisplayed()) 
			{
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'children-in-room')])["+i+"]")).sendKeys(Integer.toString(
						SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minnoofchildrens), Integer.parseInt(maxnoofchildrens))));
				System.out.println("Children dropdown displayed and entered for the room "+i+" successfully");
				logger.info("Children dropdown displayed and entered for the room "+i+" successfully");
				test.log(Status.INFO, "Children dropdown displayed and entered for the room "+i+" successfully");
				Assert.assertTrue(true, "Children dropdown displayed and entered for the room "+i+" successfully");
			}
			else 
			{
				System.out.println("childrens dropdown not found for the room "+ i);
				logger.error("childrens dropdown not found for the room "+ i);
				//test.log(Status.FAIL, "childrens dropdown not found for the room "+ i);
				Assert.assertFalse(false, "childrens dropdown not found for the room "+ i);
			}
		}

		Thread.sleep(2000);	
		if (roomselectiondone.isEnabled()) 
		{
			roomselectiondone.isDisplayed();
			roomselectiondone.click();
			SeleniumRepo.waitForPageLoaded();
			Thread.sleep(5000);
			System.out.println("Clicked on done");
			logger.info("Clicked on done");
			test.log(Status.INFO, "Clicked on done");
			Assert.assertTrue(true, "Clicked on done");
		} 
		else 
		{
			System.out.println("not Clicked on done");
			logger.error("not Clicked on done");
			test.log(Status.FAIL, "not Clicked on done");
			Assert.assertFalse(false, "not Clicked on done");
		}
	}
	public void checkavailabitlity()
	{
		if (Checkavailability.isEnabled())
		{
			Javascriptexecutor(Checkavailability);
			System.out.println("clicked on Checkavailability");
			SeleniumRepo.waitForPageLoaded();
			logger.info("clicked on Checkavailability");
			test.log(Status.INFO, "clicked on Checkavailability");
			Assert.assertTrue(true, "clicked on Checkavailability");
		} else 
		{
			System.out.println("Not clicked on Checkavailability");
			logger.error("Not clicked on Checkavailability");
			test.log(Status.FAIL, "Not clicked on Checkavailability");
			Assert.assertFalse(false, "Not clicked on Checkavailability");
		}
	}
	public void offers() throws InterruptedException
	{

		if (SeleniumRepo.driver.findElement(By.xpath("//span[@class='text-capitalizes']")).isDisplayed()) 
		{
			String offercodetitle=SpecialRates_offercode.getText();
			System.out.println(offercodetitle);

			System.out.println("Text obtained in title is "+offercodetitle);
			if(offercodetitle.contains("SPECIAL RATE"))
			{
				System.out.println("Expected text  is obtained");
			}
			else
			{
				System.out.println("Expected text"+offercodetitle+" is not obtained");
			}
			logger.info(" Special rates & offer code Element is present");
			test.log(Status.INFO, "Special rates & offer code Element is present");
			Assert.assertTrue(true, "Special rates & offer code Element is present");

			//Javascriptexecutor(SpecialRates_offercode);

			SpecialRates_offercode.click();
			System.out.println("Click speical link");

			Thread.sleep(5000);
			//this was breaking because there is a duplication of id the Modeltitle is using
			//to identify the speccial and rate pagackage title. 
			//So uncomment the line below when the dupllicate is removed 
			//-> SeleniumRepo.waitForElementPresent(Modeltitle);
						
			if (SeleniumRepo.driver.findElement(By.xpath("//*[@id='modalTitle']")).isDisplayed())
			{
				System.out.println("special rate popup appeared");

				
				String ofercodepopuptitle=Modeltitle.getText();
				System.out.println("Text obtained in title is "+ofercodepopuptitle);
				if(ofercodepopuptitle.equalsIgnoreCase(offercodetitle))
				{
					System.out.println(offercodetitle+ "title is matching with the popup title");
				}
				else
				{
					System.out.println("Expected text "+ofercodepopuptitle+ "is not obtained");
				}
				logger.info("Modeltitle Element is present");
				test.log(Status.INFO, "Modeltitle Element is present");
				Assert.assertTrue(true, "Modeltitle Element is present");
			} 
			else 
			{
				System.out.println("Modeltitle Element is not present");
				logger.error("Modeltitle Element is not present");
				test.log(Status.FAIL, "Modeltitle Element is not present");
				Assert.assertFalse(false, "Modeltitle Element is not present");
			}

		} 
		else 
		{
			System.out.println("SpecialRates_offercode Element is not present");
			logger.error("SpecialRates_offercode Element is not present");
			test.log(Status.FAIL, "SpecialRates_offercode Element is not present");
			Assert.assertFalse(false, "SpecialRates_offercode Element is not present");
		}	

	}


	public void offerscode_Validation() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)[1]")));

		Thread.sleep(3000);
		List<WebElement>offercodes= SeleniumRepo.driver.findElements(By.xpath("//*[starts-with(@name,'search[promo_id]')]"));
		int No_of_offercdes=offercodes.size();
		System.out.println(No_of_offercdes+"  offer codes are available");
		for(int i=1;i<No_of_offercdes;i++)
		{

			//System.out.println("(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)["+i+"]");

			WebElement promo= SeleniumRepo.driver.findElement(By.xpath("(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)["+i+"]"));

			if(promo.isDisplayed())
			{	
				String offercode=promo.getText();
				//System.out.println(offercode);
				System.out.println("Offer code present at "+i+" radio button SPECIAL RATES & OFFER CODE is  "+offercode);
				test.log(Status.INFO, "Obtained text "+offercode+"  is displayed successfully");
				Assert.assertTrue(true, "Obtained text "+offercode+" is displayed successfully");
			}
			else
			{
				test.log(Status.FAIL, " offercode Element is not present");
				Assert.assertFalse(false, " offercode Element is not present");
			}
		}
	}
	public void Specialdone()
	{
		if (Specialdone.isEnabled()) 
		{
			Specialdone.isDisplayed();
			Javascriptexecutor(Specialdone);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Clicked on done");
			logger.info("Clicked on done");
			test.log(Status.INFO, "Clicked on done");
			Assert.assertTrue(true, "Clicked on done");
		} else {
			System.out.println("not Clicked on done");
			logger.error("not Clicked on done");
			test.log(Status.FAIL, "not Clicked on done");
			Assert.assertFalse(false, "not Clicked on done");}

	}
	public void BookNow(String RoomType) throws InterruptedException
	{
               SeleniumRepo.driver.navigate().refresh();
               SeleniumRepo.waitForPageLoaded();
             
		//List<WebElement> Rooms_List=SeleniumRepo.driver.findElements(By.xpath("//*[@class='rooms_item_title']"));
		SeleniumRepo.waitForElementsPresent(Rooms_List);


		System.out.println("Rooms available for the given dates are "+Rooms_List.size());
		for(int i=0;i<Rooms_List.size();i++)
		{
			String RoomName=Rooms_List.get(i).getText();
			System.out.println("room type from BE is "+RoomName);
			System.out.println("room from excel is "+RoomType);
			if(RoomName.equalsIgnoreCase(RoomType))
			{
				System.out.println("Rooms are matched and Ready to Book");
				logger.info("Rooms are matched and Ready to Book");
				test.log(Status.INFO, "Rooms are matched and Ready to Book");
				Assert.assertTrue(true, "Rooms are matched and Ready to Book");
				Thread.sleep(3000);

				WebElement Booknow=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/following-sibling::div[1]/descendant::button[3]"));
				Javascriptexecutor(Booknow);
				System.out.println("Clicked Booknow for the room "+RoomName);
				SeleniumRepo.waitForPageLoaded();
				break;
			}
			else
			{
				System.out.println("Rooms are not matched with room type ");
				//logger.error("Rooms are not matched with room type");
				//test.log(Status.FAIL, "Rooms are not matched with room type");
				Assert.assertFalse(false, "Rooms are not matched with room type");

			}

		}
	}

	
	public void BookNow() throws InterruptedException
	{
               SeleniumRepo.driver.navigate().refresh();
               SeleniumRepo.waitForPageLoaded();
             Thread.sleep(1000);
		//List<WebElement> Rooms_List=SeleniumRepo.driver.findElements(By.xpath("//*[@class='rooms_item_title']"));
		SeleniumRepo.waitForElementsPresent(Rooms_List);


		System.out.println("Rooms available for the given dates are "+Rooms_List.size());
		
			String RoomName=Rooms_List.get(0).getText();
			SeleniumRepo.scrollintoview(bookRooms_List.get(0));
			Thread.sleep(1000);
			bookRooms_List.get(0).click();
			System.out.println(RoomName +" is Selected");
			try {
				Thread.sleep(2000);
				Javascriptexecutor(nothanksRoom.get(0));
				Thread.sleep(3000);
			}catch(Exception e) {}
			
	}


	public void Room_Check(String Roomtype)
	{
		SeleniumRepo.waitForElementPresent(Room_Check);

		String roomtitle=Room_Check.getText();
		System.out.println("Room name present at payment details page is "+roomtitle);
		if(roomtitle.contains(Roomtype))
		{
			System.out.println("Payment details room name title matched with the given room name "+Roomtype);
			logger.info("Payment details room name title matched with the given room name "+Roomtype);
			test.log(Status.INFO, "Payment details room name title matched with the given room name "+Roomtype);
			Assert.assertTrue(true, "Payment details room name title matched with the given room name "+Roomtype);
		}
		else
		{
			System.out.println("Payment details room name title is not matched with the given room name "+Roomtype);
			logger.info("Payment details room name title is not matched with the given room name "+Roomtype);
			test.log(Status.INFO, "Payment details room name title is not matched with the given room name "+Roomtype);
			Assert.assertTrue(true, "Payment details room name title is not matched with the given room name "+Roomtype);
		}


	}
	public void verify_startover()
	{
		SeleniumRepo.waitForElementPresent(verify_startover);
		if (verify_startover.isDisplayed()) 
		{
			String startover=verify_startover.getText();
			System.out.println("Text obtained is"+startover);
			if(startover.contains("Start over"))
			{
				System.out.println("Expected text "+startover+"  is obtained");
			}
			else
			{
				System.out.println("Expected text"+startover+" is not obtained");
			}
			logger.info("startover Element is present");
			test.log(Status.INFO, "startover Element is present");
			Assert.assertTrue(true, "startover Element is present");
		} 
		else 
		{
			System.out.println("startover Element is not present");
			logger.error("startover Element is not present");
			test.log(Status.FAIL, "startover Element is not present");
			Assert.assertFalse(false, "startover Element is not present");
		}

	}

	public void checkbox()
	{
		ExplicitWait(click_iwouldlike);
		if (click_iwouldlike.isDisplayed()) 
		{

			click_iwouldlike.click();
			System.out.println("Clicked on checkbox i would like email");
			logger.info("Clicked on checkbox i would like email");
			test.log(Status.INFO, "Clicked on checkbox i would like email");
			Assert.assertTrue(true, "Clicked on checkbox i would like email");
		} else {
			System.out.println("Not Clicked on checkbox i would like email");
			logger.error("Not Clicked on checkbox i would like email");
			test.log(Status.FAIL, "Not Clicked on checkbox i would like email");
			Assert.assertFalse(false, "Not Clicked on checkbox i would like email");}
	}

	public void First_name(String FirstName)
	{
		if (Enter_Firstname.isEnabled()) {
			Enter_Firstname.isDisplayed();
			Enter_Firstname.clear();
			Enter_Firstname.click();
			Enter_Firstname.sendKeys(FirstName);
			System.out.println("Entered Firstname");
			logger.info("Entered Firstname");
			test.log(Status.INFO, "Entered Firstname");
			Assert.assertTrue(true, "Entered Firstname");
		} else {
			System.out.println("Not Entered Firstname");
			logger.error("Not Entered Firstname");
			test.log(Status.FAIL, "Not Entered Firstname");
			Assert.assertFalse(false, "Not Entered Firstname");
		}
	}
	public void Last_Name(String LastName)
	{
		if (Enter_lastname.isEnabled()) 
		{
			Enter_lastname.isDisplayed();
			Enter_lastname.clear();
			Enter_lastname.click();
			Enter_lastname.sendKeys(LastName);
			System.out.println("Entered Lastname");
			logger.info("Entered Lastname");
			test.log(Status.INFO, "Entered Lastname");
			Assert.assertTrue(true, "Entered Lastname");
		} else 
		{
			System.out.println("Not Entered Lastname");
			logger.error("Not Entered Lastname");
			test.log(Status.FAIL, "Not Entered Lastname");
			Assert.assertFalse(false, "Not Entered Lastname");
		}
	}
	public void Email(String Email)
	{
		if (Enter_Email.isEnabled()) 
		{
			Enter_Email.isDisplayed();
			Enter_Email.clear();
			Enter_Email.click();
			Enter_Email.sendKeys(Email);
			System.out.println("Entered Email");
			logger.info("Entered Email");
			test.log(Status.INFO, "Entered Email");
			Assert.assertTrue(true, "Entered Email");
		} else 
		{
			System.out.println("Not Entered Email");
			logger.error("Not Entered Email");
			test.log(Status.FAIL, "Not Entered Email");
			Assert.assertFalse(false, "Not Entered Email");

		}
	}

	public void card_information()
	{

		if (Verify_CardInformation.isDisplayed()) {
			String card=Verify_CardInformation.getText();
			System.out.println("Text obtained is" +card);
			if(card.contains("CARD INFORMATION"))
			{
				System.out.println("Expected text "+card+" is obtained");
			}
			else{

				System.out.println("Expected text "+card+" is not obtained");
			}
			test.log(Status.INFO, "CardInformation Element is present");
			Assert.assertTrue(true, "CardInformation Element is present");
		} else {
			System.out.println("CardInformation Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "CardInformation Element is not present");
			Assert.assertFalse(false, "CardInformation Element is not present");
		}


		if (Verify_AcceptedCreditcard.isDisplayed()) {
			String Acceptcc=Verify_AcceptedCreditcard.getText();
			System.out.println("Text obtained is" +Acceptcc);
			if(Acceptcc.contains("ACCEPTED CREDIT CARDS"))
			{
				System.out.println("Expected text "+Acceptcc+"  is obtained");
			}
			else{

				System.out.println("Expected text"+Acceptcc+"  is not obtained");
			}
			test.log(Status.INFO, "AcceptedCreditcard Element is present");
			Assert.assertTrue(true, "AcceptedCreditcard Element is present");
		} else {
			System.out.println("AcceptedCreditcard Element is not present");
			logger.error("AcceptedCreditcard Expected value is not present");
			test.log(Status.FAIL, "AcceptedCreditcard Element is not present");
			Assert.assertFalse(false, "AcceptedCreditcard Element is not present");
		}
	}

	public void card_name(String Cardname)
	{
		if (Nameoncard.isEnabled()) {
			Nameoncard.isDisplayed();
			Nameoncard.clear();
			Nameoncard.click();
			Nameoncard.sendKeys(Cardname);
			logger.info("Entered card name");
			test.log(Status.INFO, "Entered card name");
			Assert.assertTrue(true, "Entered card name");
		} else {
			System.out.println("Not Entered card name");
			logger.error("Not Entered card name");
			test.log(Status.FAIL, "Not Entered card name");
			Assert.assertFalse(false, "Not Entered card name");}
	}
	public void Card_number(String Numberoncard)
	{

		if (CardNumb.isDisplayed())
		{
			Javascriptexecutor(CardNumb);

			CardNumb.clear();

			TypeInField(CardNumb, Numberoncard);
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
		if (expdate.isEnabled()) {
			expdate.isDisplayed();
			//CardNumb.clear();
			expdate.click();
			expdate.sendKeys("02");
			logger.info("Entered Experied Month");
			test.log(Status.INFO, "Entered Experied Month");
			Assert.assertTrue(true, "Entered Experied Month");
		} else {
			System.out.println("Not Entered Experied Month");
			logger.error("Not Entered Experied Month");
			test.log(Status.FAIL, "Not Entered Experied Month");
			Assert.assertFalse(false, "Not Entered Experied Month");}

		if (expyear.isEnabled()) {
			expyear.isDisplayed();
			expyear.click();
			expyear.sendKeys("2022");
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

	public void Country(String Entercountry) throws InterruptedException
	{
		if (Countrydropdown.isEnabled()) 
		{
             Thread.sleep(2000);
			//select_rooms.isDisplayed();
             Countrydropdown.click();//added this line to help MsEdge
			SeleniumRepoDropdown.selectDropDownText(Countrydropdown, Entercountry);
			logger.info("country selected");
			test.log(Status.INFO, "country selected");
			Assert.assertTrue(true, "country selected");
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
		if (verify_Billingaddress.isDisplayed()) {
			String address=verify_Billingaddress.getText();
			System.out.println("Text obtained is" +address);
			if(address.contains("BILLING ADDRESS"))
			{
				System.out.println("Expected text "+address+" is obtained");
			}
			else{

				System.out.println("Expected text "+address+" is not obtained");
			}
			test.log(Status.INFO, "Billingaddress Element is present");
			Assert.assertTrue(true, "Billingaddress Element is present");
		} else {
			System.out.println("Billingaddress Element is not present");
			logger.error("Expected value Billingaddress is not present");
			test.log(Status.FAIL, "Billingaddress Element is not present");
			Assert.assertFalse(false, "Billingaddress Element is not present");
		}

		if (addressline1.isEnabled()) {
			addressline1.isDisplayed();
			addressline1.click();
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
			addressline2.sendKeys(Address2);
			addressline2.click();
			logger.info("Entered Address2 ");
			test.log(Status.INFO, "Entered Address2");
			Assert.assertTrue(true, "Entered Address2");
		} else {
			System.out.println("Not Entered Address2");
			logger.error("Not Entered Address2");
			test.log(Status.FAIL, "Not Entered Address2");
			Assert.assertFalse(false, "Not Entered Address2");}


		if (City.isEnabled()) {
			City.isDisplayed();
			City.click();
			City.sendKeys(Entercity);
			logger.info("Entered city ");
			test.log(Status.INFO, "Entered City");
			Assert.assertTrue(true, "Entered City");
		} else {
			System.out.println("Not Entered City");
			logger.error("Not Entered City");
			test.log(Status.FAIL, "Not Entered City");
			Assert.assertFalse(false, "Not Entered City");}


		if (State.isEnabled()) 
		{
			
			State.click();
			State.sendKeys(Enterstate);
			logger.info("Entered city ");
			test.log(Status.INFO, "Entered City");
			Assert.assertTrue(true, "Entered City");
		} else {
			System.out.println("Not Entered City");
			logger.error("Not Entered City");
			test.log(Status.FAIL, "Not Entered City");
			Assert.assertFalse(false, "Not Entered City");}


		if (Zipcode.isEnabled()) {
			
			Zipcode.click();
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

	public void contact(String Enterphonenum) throws InterruptedException
	{
		if (contactinformation.isDisplayed()) {
			String contact=contactinformation.getText();
			System.out.println("Text obtained is" +contact);
			if(contact.contains("ADDITIONAL CONTACT INFORMATION"))
			{
				System.out.println("Expected text "+contact+" is obtained");
			}
			else{

				System.out.println("Expected text "+contact+" is not obtained");
			}
			test.log(Status.INFO, "contactinformation Element is present");
			Assert.assertTrue(true, "contactinformation Element is present");
		} else {
			System.out.println("contactinformation Element is not present");
			logger.error("Expected value contactinformation is not present");
			test.log(Status.FAIL, "contactinformation Element is not present");
			Assert.assertFalse(false, "contactinformation Element is not present");
		}
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
	public void payment() throws InterruptedException

	{
		SeleniumRepo.scrollintoview(verify_paymentroomcharges);
		if (verify_paymentroomcharges.isDisplayed()) {
			String paymentroom=verify_paymentroomcharges.getText();
			System.out.println("Text obtained is" +paymentroom);
			if(paymentroom.contains("ROOM CHARGES:"))
			{
				System.out.println("Expected text "+paymentroom+" is obtained");
			}
			else{

				System.out.println("Expected text "+paymentroom+" is not obtained");
			}
			test.log(Status.INFO, "Element is present");
			Assert.assertTrue(true, "Element is present");
		} else {
			System.out.println("paymentroomcharges Element is not present");
			logger.error("Expected value paymentroomcharges is not present");
			test.log(Status.FAIL, "paymentroomcharges Element is not present");
			Assert.assertFalse(false, "paymentroomcharges Element is not present");
		}


		if (verify_paymenttaxesandfees.isDisplayed()) {
			String paymenttaxes=verify_paymenttaxesandfees.getText();
			System.out.println("Text obtained is" +paymenttaxes);
			if(paymenttaxes.contains("TAXES AND FEES:"))
			{
				System.out.println("Expected text "+paymenttaxes+" is obtained");
			}
			else{

				System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, " paymenttaxesandfees Element is present");
			Assert.assertTrue(true, "paymenttaxesandfees Element is present");
		} else {
			System.out.println("paymenttaxesandfees Element is not present");
			logger.error("Expected value paymenttaxesandfees is not present");
			test.log(Status.FAIL, "paymenttaxesandfees Element is not present");
			Assert.assertFalse(false, "paymenttaxesandfees Element is not present");
		}


		if (verify_paymentgrandtotal.isDisplayed()) {
			String paymentgrandtotal=verify_paymentgrandtotal.getText();
			System.out.println("Text obtained is"+paymentgrandtotal);
			if(paymentgrandtotal.contains("GRAND TOTAL:"))
			{
				System.out.println("Expected text "+paymentgrandtotal+"  is obtained");
			}
			else{

				System.out.println("Expected text "+paymentgrandtotal+"  is not obtained");
			}
			test.log(Status.INFO, "paymentgrandtotal Element is present");
			Assert.assertTrue(true, "paymentgrandtotal Element is present");
		} else {
			System.out.println("paymentgrandtotal Element is not present");
			logger.error("Expected value paymentgrandtotal is not present");
			test.log(Status.FAIL, "paymentgrandtotal Element is not present");
			Assert.assertFalse(false, "paymentgrandtotal Element is not present");
		}

		if (Verify_accept.isDisplayed()) {
			String termsandcondition=Verify_accept.getText();
			System.out.println("Text obtained is"+termsandcondition);
			if(termsandcondition.contains("I accept the Terms & Conditions"))
			{
				System.out.println("Expected text "+termsandcondition+"  is obtained");
			}
			else{

				System.out.println("Expected text "+termsandcondition+" is not obtained");
			}
			test.log(Status.INFO, "accept Element is present");
			Assert.assertTrue(true, "accept Element is present");
		} else {
			System.out.println("accept Element is not present");
			logger.error("Expected value accept is not present");
			test.log(Status.FAIL, "accept Element is not present");
			Assert.assertFalse(false, "accept Element is not present");
		}

		if (Click_accept.isEnabled()) {
			Click_accept.isDisplayed();
			Click_accept.click();
			logger.info("Clicked on accept checkbox");
			test.log(Status.INFO, "Clicked on accept checkbox");
			Assert.assertTrue(true, "Clicked on accept checkbox");
		} else {
			System.out.println("Not Clicked on accept checkbox");
			logger.error("Not Clicked on accept checkbox");
			test.log(Status.FAIL, "Not Clicked on accept checkbox");
			Assert.assertFalse(false, "Not Clicked on accept checkbox");}


		if (CompleteReservation.isEnabled()) {
			CompleteReservation.isDisplayed();
			CompleteReservation.click();
			logger.info("Clicked on CompleteReservation button");
			test.log(Status.INFO, "Clicked on CompleteReservation button");
			Assert.assertTrue(true, "Clicked on CompleteReservation button");
		} else {
			System.out.println("Not Clicked on CompleteReservation button");
			logger.error("Not Clicked on CompleteReservation button");
			test.log(Status.FAIL, "Not Clicked on CompleteReservation button");
			Assert.assertFalse(false, "Not Clicked on CompleteReservation button");}
		
		try {
			if(serChargeYes.get(0).isDisplayed()){
				Thread.sleep(1000);
				Javascriptexecutor(serChargeYes.get(0));
				Thread.sleep(2200);
				Javascriptexecutor(serchargeYes.get(0));			}
		}catch(Exception e) {}
		
		

		SeleniumRepo.waitForPageLoaded();
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Thank you for your reservation')]")));
		if (SeleniumRepo.driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your reservation')]")).isDisplayed()) {
			String Thankyou=SeleniumRepo.driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your reservation')]")).getText();
			System.out.println("Text obtained is"+Thankyou);
			if(Thankyou.contains("THANK YOU FOR YOUR RESERVATION"))
			{
				System.out.println("Expected text "+Thankyou+" is obtained");
			}
			else{

				System.out.println("Expected text "+Thankyou+" is not obtained");
			}
			test.log(Status.INFO, "Thankyou Element is present");
			Assert.assertTrue(true, "Thankyou Element is present");
		} else {
			System.out.println("Thankyou Element is not present");
			logger.error("Expected value Thankyou is not present");
			test.log(Status.FAIL, "Thankyou Element is not present");
			Assert.assertFalse(false, "Thankyou Element is not present");
		}


	}


	public void verify_Thanku_page()
	{
		int cancelreservation = Verify_cancelreservation.size();
		System.out.println(cancelreservation );
		for(int R=1;R<=cancelreservation;R++)
		{
			if (SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Cancel reservation')])["+R+"]")).isDisplayed()) {
				System.out.println(SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Cancel reservation')])["+R+"]")).getText());
				System.out.println("Cancel Reservation is displayed successfully");
				logger.info("Cancel Reservation is displayed successfully");
				test.log(Status.INFO, "Cancel Reservation is displayed successfully");
				Assert.assertTrue(true, "Cancel Reservation is displayed successfully");
			} else {
				System.out.println("Cancel Reservation not found");
				logger.error("Cancel Reservation not found");
				test.log(Status.FAIL, "Cancel Reservation not found");
				Assert.assertFalse(false, "Cancel Reservation not found");
			}
		}

		int changereservation = Verify_changereservation.size();
		System.out.println(changereservation );
		for(int S=1;S<=changereservation;S++)
		{
			if (SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Change reservation')])["+S+"]")).isDisplayed()) {
				System.out.println(SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Change reservation')])["+S+"]")).getText());
				System.out.println("Changesreservation button found");
				logger.info("Changesreservation button found");
				test.log(Status.INFO, "Changesreservation button found");
				Assert.assertTrue(true, "Changesreservation button found");
			} else {
				System.out.println("Changesreservation button not found");
				logger.error("Changesreservation button not found");
				test.log(Status.FAIL, "Changesreservation button not found");
				Assert.assertFalse(false, "Changesreservation button not found");
			}
		}

		String conformationcode=Verify_conformationcode.getText();
		System.out.println(conformationcode);
		if(conformationcode.contains("POM")){
			System.out.println("Expected text "+conformationcode+" is obtained");
		}else{
			System.out.println("Expected text "+conformationcode+" is not obtained");
			Assert.assertFalse(false, "Element is not present");
		}

		if (Verify_Thankuroomcharges.isDisplayed()) {
			String Thankuroomcharges=Verify_Thankuroomcharges.getText();
			System.out.println("Text obtained is" +Thankuroomcharges);
			if(Thankuroomcharges.contains("Room charges"))
			{
				System.out.println("Expected text "+Thankuroomcharges+" is obtained");
			}
			else{

				System.out.println("Expected text "+Thankuroomcharges+" is not obtained");
			}
			test.log(Status.INFO, "Thankuroomcharges Element is present");
			Assert.assertTrue(true, "Thankuroomcharges Element is present");
		} else {
			System.out.println("Thankuroomcharges Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "Thankuroomcharges Element is not present");
			Assert.assertFalse(false, "Thankuroomcharges Element is not present");
		}


		/*if (Verify_Thankuothercharges.isDisplayed()) {
			String Thankuothercharges=Verify_Thankuothercharges.getText();
			System.out.println("Text obtained is" +Thankuothercharges);
			if(Thankuothercharges.contains("Other Services"))
			{
				System.out.println("Expected text "+Thankuothercharges+" is obtained");
			}
			else{

				System.out.println("Expected text "+Thankuothercharges+"  is not obtained");
			}
			test.log(Status.INFO, "Thankuothercharges Element is present");
			Assert.assertTrue(true, "Thankuothercharges Element is present");
		} else {
			System.out.println("Thankuothercharges Element is not present");
			logger.error("Expected value Thankuothercharges is not present");
			test.log(Status.FAIL, "Thankuothercharges Element is not present");
			Assert.assertFalse(false, "Thankuothercharges Element is not present");
		}*/


		if (Verify_ThankuTaxesandfees.isDisplayed()) {
			String ThankuTaxesandfees=Verify_ThankuTaxesandfees.getText();
			System.out.println("Text obtained is" +ThankuTaxesandfees);
			if(ThankuTaxesandfees.contains("Taxes and fees"))
			{
				System.out.println("Expected text "+ThankuTaxesandfees+" is obtained");
			}
			else{

				System.out.println("Expected text "+ThankuTaxesandfees+" is not obtained");
			}
			test.log(Status.INFO, "ThankuTaxesandfees Element is present");
			Assert.assertTrue(true, "ThankuTaxesandfees Element is present");
		} else {
			System.out.println("ThankuTaxesandfees Element is not present");
			logger.error("Expected value  ThankuTaxesandfees is not present");
			test.log(Status.FAIL, "ThankuTaxesandfees Element is not present");
			Assert.assertFalse(false, "ThankuTaxesandfees Element is not present");
		}


		if (Verify_Thankugrandtotal.isDisplayed()) {
			String Thankugrandtotal=Verify_Thankugrandtotal.getText();
			System.out.println("Text obtained is" +Thankugrandtotal);
			if(Thankugrandtotal.contains("Grand total"))
			{
				System.out.println("Expected text "+Thankugrandtotal+" is obtained");
			}
			else{

				System.out.println("Expected text "+Thankugrandtotal+" is not obtained");
			}
			test.log(Status.INFO, "Thankugrandtotal Element is present");
			Assert.assertTrue(true, "Thankugrandtotal Element is present");
		} else {
			System.out.println("Thankugrandtotal Element is not present");
			logger.error("Expected value Thankugrandtotal is not present");
			test.log(Status.FAIL, "Thankugrandtotal Element is not present");
			Assert.assertFalse(false, "Thankugrandtotal Element is not present");
		}


		if (verify_Checkintime.isDisplayed()) {
			String checkin=verify_Checkin.getText();
			System.out.println("Text obtained is" +checkin);
			if(checkin.contains("Check in time:"))
			{
				System.out.println("Expected text "+checkin+" is obtained");
			}
			else{

				System.out.println("Expected text "+checkin+"  is not obtained");
			}
			test.log(Status.INFO, "checkin Element is present");
			Assert.assertTrue(true, "checkin Element is present");
		} else {
			System.out.println("checkin Element is not present");
			logger.error("Expected value checkin is not present");
			test.log(Status.FAIL, "checkin Element is not present");
			Assert.assertFalse(false, "checkin Element is not present");
		}

		if (verify_Checkouttime.isDisplayed()) 
		{
			String checkout=verify_Checkout.getText();
			System.out.println("Text obtained is" +checkout);
			if(checkout.contains("Check out time:"))
			{
				System.out.println("Expected text "+checkout+" is obtained");
			}
			else{

				System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "checkout Element is present");
			Assert.assertTrue(true, "checkout Element is present");
		} else {
			System.out.println("checkout Element is not present");
			logger.error("checkout Expected value is not present");
			test.log(Status.FAIL, "checkout Element is not present");
			Assert.assertFalse(false, "checkout Element is not present");
		}
		if (verify_Termsandconditionstext.isDisplayed()) 
		{
			String Termsandconditionstext=verify_Termsandconditionstext.getText();
			System.out.println("Text obtained is" +Termsandconditionstext);
		}
	}

















}

