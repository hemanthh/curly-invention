package com.tt.BE.pom;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hamcrest.core.StringStartsWith;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Group_Blocks;
import com.tt.admin.pom.Taxes_Fees;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * Originally this class was used to represent the BE classic flow pages [Availability, Reservation details, Payment Details, and confirmation page]
 * and has methods/variables that interact with these BE pages. But after refactoring, this class will only contain methods and web elements 
 * that will appear for multiple BE pages and any utility method. This class will also act as a parent class for the new classes as the result of refactoring.
 *  
 * @see [ClassicFlow_AvailPage.java, ClassicFlow_ReservationDetailsPage.java, ClassicFlow_PaymentDetailsPage.java and ClassiFlow_ConfirmationPage.java]
 * 
 * TODO: Before committing/pushing to bitbucket, remove all duplicated methods and variables .
 * TODO: Also get rid of the testcase class TC_ClasicFlow.java, will create another TC class that completes a basic booking
 * 
 * Todo: Utility method idea: use this class to house methods that will gather specific info that will be used to 
 * verify or compare with
 */


public class ClasicFlow extends BaseTest 
{
	public String formattedDate1;
	public String formattedDate2;

	String Before_Offerprice;
	String Bookingmonth_date;
	String Endmonth_date;

	public String formattedDate;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//a[@id='reservation-lookup']"),@FindBy(css="#reservation-lookup") })

	public WebElement verify_mybooking;

	@FindAll({ @FindBy(xpath = "//a[@id='currency-dropdown']"), })

	public WebElement currencydropdown;

	@FindAll({ @FindBy(xpath = "//*[@id='search_arrival_date']"), })

	public WebElement arrivaldate;

	@FindAll({ @FindBy(xpath = "//*[@id='search_departure_date']"), })

	public WebElement departuredate;

	@FindAll({ @FindBy(xpath = "//*[@id='rooms_and_guests']/span/div[1]/div/div[2]"), })

	public WebElement roomsandguests;

	@FindAll({ @FindBy(xpath = "//select[@id='roomsselector']"), })

	public WebElement select_rooms;

	@FindAll({ @FindBy(xpath = "//select[@id='roomsselector']"), })

	public List<WebElement> Listselect_adults;


	@FindAll({ @FindBy(xpath = "//div[@class='cc-compliance']"), })

	public WebElement ok;

	@FindAll({ @FindBy(xpath = "(//*[starts-with(@id,'children-in-room')])"), })

	public List<WebElement> Listselect_childrens;

	@FindAll({ @FindBy(xpath = "//*[@id='guests_rooms_done']"), })

	public WebElement Done;

	@FindAll({ @FindBy(xpath = "//*[starts-with(text(),'Check ')]"), })

	public WebElement Checkavailability;

	@FindAll({ @FindBy(xpath = "//span[@class='text-capitalizes']"),@FindBy(css="body.standard-flow.ng-scope:nth-child(2) div.ng-scope:nth-child(16) div.room-page.ng-scope:nth-child(8) aside.search-form.z-index div.container.roomsSearchForm form.edit_search.ng-pristine.ng-valid.ng-isolate-scope:nth-child(4) div.search-form-item.search-form-offer:nth-child(4) a.search-form-offer-link strong:nth-child(1) > span.text-capitalizes") })

	public WebElement Click_SpecialRate;

	@FindAll({ @FindBy(xpath = "(//*[starts-with(@name,'search[promo_id]')])"), })

	public List<WebElement> select_promocode;

	@FindAll({ @FindBy(xpath = "//*[@id='modalTitle']"), })

	public WebElement Modeltitle;

	@FindAll({ @FindBy(xpath = "//button[contains(@class,'button') and @id='special-rates-promo-done']"), })

	public WebElement Specialdone;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Select room')]"), })

	public WebElement Select_Room;

	@FindAll({ @FindBy(xpath = "(//ul[@class='rooms-selector-list']//li)"), })

	public List<WebElement> rooms;

	@FindAll({ @FindBy(xpath = "//button[@id='guests_rooms_done']"), })

	public WebElement roomselectiondone;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Book now')]"), })

	public WebElement Booknow;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Rooms')]"), })

	public WebElement verify_Headingrooms;

	@FindAll({ @FindBy(xpath = "//*[@id='wrapper']/aside/div/nav/strong"), })

	public WebElement verify_Reservation;

	@FindAll({ @FindBy(xpath = "//span[@class='inline-block']"), })

	public WebElement verify_Guest;

	@FindAll({ @FindBy(xpath = "//body[@class='standard-flow ng-scope']/div[@id='wrapper']/section[@class='container main-container z-index']/div[@class='main-container-content']/form[@id='edit_booking_5bae00d886ae77014cf05627']/fieldset/div[@class='horizontal-block']/div[@class='room-details room-details-col room-details-odd']/fieldset[@class='ng-scope room-same-guests']/div[3]"), })

	public WebElement verify_iwouldlike;


	@FindAll({ @FindBy(xpath = "(//*[contains(@id,'edit_booking_')]//legend/span)"), })

	public List<WebElement> verify_offers;

	@FindAll({ @FindBy(xpath = "(//*[contains(@id, 'edit_booking_')]/fieldset//ul/li[*]/label/span/strong)"), })

	public List<WebElement> verify_rateplans;

	@FindAll({ @FindBy(xpath = "//div[@class='mainheader']"), })

	public WebElement verify_mainheader;

	@FindAll({ @FindBy(xpath = "//div[@class=\"sideheader\"]/span[@role='text']"), })

	public List<WebElement> verify_dates;

	@FindAll({ @FindBy(xpath = "//a[@class='button button-colors float-right']"), })

	public WebElement verify_startover;

	@FindBy(xpath = "//fieldset[@class='ng-scope room-same-guests']//div//input[2]")
	public WebElement click_iwouldlike;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_first_name']"), })

	public WebElement Enter_Firstname;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_last_name']"), })

	public WebElement Enter_lastname;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_email']"), })

	public WebElement Enter_Email;

	@FindAll({ @FindBy(xpath = "//input[@class='grp none-outline']"), })

	public List<WebElement> Extrainformation;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'TAXES AND FEES:')]"), })

	public WebElement verify_taxesandfees;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Taxes and fees:')]"), })

	public WebElement verify_paymenttaxesandfees;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'GRAND TOTAL:')]"), })

	public WebElement verify_grandtotal;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Grand total:')]"), })

	public WebElement verify_paymentgrandtotal;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'ROOM CHARGES:')]"), })

	public WebElement verify_roomcharges;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Room charges:')]"), })

	public WebElement verify_paymentroomcharges;

	@FindAll({ @FindBy(xpath = "//button[@class='button none-outline']"), })

	public WebElement confirmation;

	@FindAll({ @FindBy(xpath = "(//p/input[@class='grp none-outline'])"), })

	public WebElement bespecific;

	/*@FindAll({ @FindBy(xpath = "//table/thead//strong[contains(text(),'Room')]"), })

	public List<WebElement> roomslist;*/

	@FindAll({ @FindBy(xpath = "//th[@id='summary_reservation_offer']"), })

	public List<WebElement> offers;


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

	@FindAll({ @FindBy(xpath = "//select[@name='state']"), })

	public WebElement State;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_zip_code']"), })

	public WebElement Zipcode;

	@FindAll({ @FindBy(xpath = "//legend[contains(text(),'Additional contact information')]"), })

	public WebElement contactinformation;

	@FindAll({ @FindBy(xpath = "//input[@id='booking_phone_number']"), })

	public WebElement PhoneNumber;

	@FindAll({ @FindBy(xpath = "//span[@class='accept_booking']//label[2]"), })

	public WebElement Verify_accept;

	@FindAll({ @FindBy(xpath = "//input[@id='accept']"), })

	public WebElement Click_accept;

	@FindAll({ @FindBy(xpath = "//input[@value='Complete reservation']"), })

	public WebElement CompleteReservation;

	//This all are in the Thank you page web elements

	@FindAll({ @FindBy(xpath = "//h2[contains(text(),'Thank you for your reservation')]"), })

	public WebElement Verify_thankyou;

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

	@FindAll({ @FindBy(xpath = "//body[@class='standard-flow ng-scope']/div[@id='wrapper']/section[@class='container main-container z-index']/div[@class='main-container-content']/ul[1]"), })

	public WebElement verify_Termsandconditionstext;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Special rate:')]"), })

	public WebElement Offercode_Text;

	@FindAll({ @FindBy(xpath = "//*[@class='rooms_price']/strong"), })

	public WebElement RoomPrice;

	@FindAll({ @FindBy(xpath = "(//div[@ng-switch='room.brg'])[1]"), })

	public WebElement Firstroom;

	@FindAll({ @FindBy(xpath = "(//*[contains(text(),'Other available offers')])[1]"), })

	public WebElement other_offers;

	@FindAll({ @FindBy(xpath = "//*[@class='loyalty-rate-plan-title']"), })

	public WebElement RatePlan_title;

	@FindAll({ @FindBy(xpath = "(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)[1]"), })

	private WebElement Offercode;

	@FindAll({ @FindBy(xpath = "	(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)"), })

	private List<WebElement> SpecialRateplans;

	@FindAll({ @FindBy(xpath = "//*[@class='rooms-list-title ng-binding']"), })

	private List<WebElement >Roomslist;

	@FindAll({ @FindBy(xpath = "(//*[@class='rooms_price']/strong)"), })

	private WebElement price;

	@FindAll({ @FindBy(xpath = "(//*[contains(text(),'Special offer')])"), })

	private WebElement Reservationpage_offers;

	@FindAll({ @FindBy(xpath = "(//*[@headers='summary_reservation_offer'])[1]"), })

	private WebElement summary_reservation;

	@FindAll({ @FindBy(xpath = "(//*[@headers='summary_reservation_offer'])"), })

	private List<WebElement> offer_payment;

	@FindAll({ @FindBy(xpath = "//*[@name='search[offer_code]']"), })

	private WebElement OfferCode_textfeild;

	@FindAll({ @FindBy(xpath = "//*[@ng-hide='showRoomInfo']"), })

	private WebElement showRoomInfo;

	@FindAll({ @FindBy(xpath = "//*[@ng-bind='hotel.name']"), })

	private List<WebElement> Alternateproperty_name;

	@FindAll({ @FindBy(xpath = "//*[@ng-bind='booking.hotel.name']"), })

	private List<WebElement> BookNow_Alternateproperty_name;


	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Available offers')]/../following-sibling::ul/li/label/span[3]/strong"), })

	private List<WebElement> Available_Offers;

	@FindAll({ @FindBy(xpath = "//*[text()='GRAND TOTAL:']/following-sibling::td"), })

	private WebElement GrandTotalAmount;


	@FindBy(how=How.XPATH,using="//strong[contains(@ui-if,'rp.average_discounted_nightly_price')]") public WebElement Verify_NewDiscountPrice;

	@FindBy(how=How.XPATH,using="//*[@class='room_price rooms_price']/following-sibling::span/span[3]") public WebElement verify_DPRDescription;


	@FindBy(how=How.XPATH,using="//*[@id='offer-details-title']") public WebElement Verify_OfferDetailsTitle;

	@FindBy(how=How.XPATH,using="//*[@id='offer-details-close']") public WebElement OfferDetails_Close;

	@FindBy(how=How.XPATH,using="(//*[@ng-bind='d.dates'])[1]") public WebElement FirstRatedetails;

	@FindBy(how=How.XPATH,using="(//*[@ng-bind='d.dates'])") public List<WebElement> LastRatedetails;

	@FindBy(how=How.XPATH,using="//span[@class='room-desc-price ng-scope']/span/strike") public WebElement Verify_Strike;

	
	/**
	 * Method goes to a booking engine web url found in the  Admin properties file  
	 * 
	 * @throws IOException
	 */
	public void GoToUrl() throws IOException
	{
		String beurl=ReadProperties.getPropValues("Admin.properties", "BEURL");
		SeleniumRepo.GoToUrl(beurl);
	}
	
	/**
	 * Method goes to the booking engine web url found in the  Admin properties file with an additon of 
	 * rate plan accesscode
	 *  
	 * Refactoring idea: there is a new url that handles compound codes so confirm if the accesscode url and 
	 * compound url are the same if not make a compound accesscode goto url
	 * 
	 * @param Ratetypecode
	 * @throws IOException
	 */
	public void GoToPromoURL(String Ratetypecode) throws IOException
	{
		String PromoURL=ReadProperties.getPropValues("Admin.properties", "PromoURL1")+Ratetypecode+ReadProperties.getPropValues("Admin.properties", "PromoURL2")+Ratetypecode+ReadProperties.getPropValues("Admin.properties", "PromoURL3");
		//String PromoURL="http://pom.qa2.reztrip3-qa.com/en/special_offer?rate_code="+Ratetypecode+"&rate_code="+Ratetypecode+"&vr=3";
		//System.out.println("Promo URL is :"+PromoURL);
		SeleniumRepo.GoToUrl(PromoURL);
	}
	
	/**
	 * Verifies the "My Booking" reservation link is present 
	 *  
	 *  Refactoring idea: Look for the class that handels reservation and see if its wise to include methods
	 *  in this class that deals with it since "my bookings" can appear on any page 
	 * 
	 */
	public void verify_mybooking()
	{
		ExplicitWait(verify_mybooking);
		if (verify_mybooking.isDisplayed()) 
		{
			String text=verify_mybooking.getText();
			//System.out.println("Text obtained is"+text);
			if(text.contains("My bookings"))
			{
				//System.out.println("Expected text "+text+" is obtained");
				test.log(Status.PASS, "Expected text "+text+" is obtained");
				logger.info("Expected text "+text+" is obtained");
			}
			else{
				//System.out.println("Expected text "+text+" is not obtained");
				test.log(Status.FAIL, "Expected text "+text+" is not obtained");
				logger.error("Expected text "+text+" is not obtained");
			}
			logger.info("verified mybooking text");
			test.log(Status.PASS, "verified mybooking text");

		} 
		else 
		{

			logger.error("My Bookings field notfound");
			test.log(Status.FAIL, "My Bookings field notfound");
		}
	}	

	/**
	 * Methods click the currency dropdown 
	 * 
	 * Refactoring idea: Create a verifying method for currency dropdown
	 * 2. reenabled the ability for a currency to be selected 
	 * 
	 * @throws InterruptedException
	 */
	public void currencydropdown() throws InterruptedException 
	{
		ExplicitWait(currencydropdown);
		if (currencydropdown.isDisplayed()) 
		{
			currencydropdown.click();
			SeleniumRepo.waitForPageLoaded();
			//SeleniumRepoDropdown.selectDropDownText(currencydropdown, EnterCurrency);
			logger.info("Clicked on currnecy dropdown Link");
			test.log(Status.INFO, "Clicked on currnecy dropdown Link");

		} 
		else 
		{
			//System.out.println("currency dropdown not found");
			logger.error("currency dropdown not found");
			test.log(Status.FAIL, " currency dropdown not found");


		}
	}
	
	/**
	 * Mehtod will be similar to the currency dropdown method.
	 * 
	 *  Todo: Will add FindAll selenium web element  
	 * @throws InterruptedException
	 */
	public void languagedropdown() throws InterruptedException{
		
	}
	
	/* currently located in ClassicFlow_AvailPage.java
	public void arrival_date()
	{
		ExplicitWait(arrivaldate);
		
		//will use this attriute to find out the date format
		System.out.println(arrivaldate.getAttribute("placeholder"));
	
		Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YYYY");
		formattedDate1 = df1.format(date1);

		if (SeleniumRepo.isElementPresent(arrivaldate)) 
		{
			arrivaldate.click();
			arrivaldate.clear();
			arrivaldate.sendKeys(formattedDate1);
			//System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on arrivaldate Link");
			logger.info("Clicked on arrivaldate Link");

		}
		else 
		{
			//System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");

		}

	}
*/
	
	/*
	public void departuredate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM dd", Locale.ENGLISH);
		LocalDate ld = LocalDate.parse(formattedDate1 , dtf);
		Bookingmonth_date = dtf2.format(ld);
		//System.out.println(Bookingmonth_date);


		Date date = new Date();
		date.setDate(date.getDate() + 6);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		formattedDate = df.format(date);

		if (departuredate.isDisplayed()) 
		{
			departuredate.click();
			departuredate.clear();
			TypeInField(departuredate, formattedDate);
			//departuredate.sendKeys(formattedDate);
			//System.out.println("departuredate is entered successfully");
			logger.info("departuredate is entered successfully");
			test.log(Status.INFO, "departuredate is entered successfully");

		} else {
			//System.out.println("departuredate TextBox not found");
			logger.error("departuredate TextBox not found");
			test.log(Status.FAIL, "departuredate TextBox not found");

		}
	}
	*/
	
	
	/**
	 * Method clicks the "Got It" button on the cookies message popup on booking engine 
	 * 
	 * Refactor idea: Change name to represent what this method is for
	 * 2. See if you can create a method that can click either the close button or done button
	 * 
	 * @throws InterruptedException
	 */
	public void popup_ok() throws InterruptedException 
	{

		Thread.sleep(3000);
		if (ok.isDisplayed()) 
		{
			ok.click();

			logger.info("Clicked on ok");
			test.log(Status.INFO, "Clicked on ok");

		} 
		else 
		{
			//logger.error("Pop not found");
			test.log(Status.INFO, "Pop not found");

		}

	}
	
	/*
	public void Rooms_and_Guests() 
	{
		ExplicitWait(roomsandguests);
		if (roomsandguests.isDisplayed()) 
		{
			roomsandguests.click();
			//System.out.println("roomsandguests popup opened successfully");
			logger.info("roomsandguests popup opened successfully");
			test.log(Status.PASS, "roomsandguests popup opened successfully");

		} else {
			//System.out.println("roomsandguests popup  not found");
			logger.error("roomsandguests popup  not found");
			test.log(Status.FAIL, "roomsandguests popup  not found");

		}
	}
	
	*/
	
	/*
	public void select_Rooms(String Enterrooms) throws InterruptedException, IOException
	{
		ExplicitWait(select_rooms);

		if (select_rooms.isEnabled()) 
		{
			//select_rooms.isDisplayed();
			/*select_rooms.click();
			SeleniumRepo.WaitForLoad(100);
			SeleniumRepoDropdown.selectDropDownValue(select_rooms, Enterrooms);
			logger.info("rooms selected");
			test.log(Status.PASS, "rooms selected");

		} else 
		{
			//System.out.println("Unable to select rooms");
			logger.error("Unable to select rooms");
			test.log(Status.FAIL, " Unable to select rooms");

		}

		int adultslength = Listselect_adults.size();
		//System.out.println(adultslength);

		for(int j=1;j<=adultslength;j++)
		{
			String minnoofadults = ReadProperties.getPropValues("Admin.properties", "MINnoofadults");	
			String maxnoofadults = ReadProperties.getPropValues("Admin.properties", "MAXnoofadults");
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'adults-in-room')])["+j+"]")).isDisplayed()) 
			{
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'adults-in-room')])["+j+"]")).sendKeys(Integer.toString(
						SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minnoofadults), Integer.parseInt(maxnoofadults))));
				//System.out.println("adults is entered successfully");
				logger.info("adults is entered successfully");
				test.log(Status.INFO, "adults is entered successfully");

			}
			else 
			{
				//System.out.println("adults dropdown not found");
				logger.error("adults dropdown not found");
				test.log(Status.FAIL, "adults dropdown not found");

			}
		}
		int childrenslength = Listselect_childrens.size();
		//System.out.println(childrenslength);

		for(int i=1;i<=childrenslength;i++)
		{
			String minnoofchildrens = ReadProperties.getPropValues("Admin.properties", "MINnoofchildrens");
			String maxnoofchildrens = ReadProperties.getPropValues("Admin.properties", "MAXnoofchildrens");
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'children-in-room')])["+i+"]")).isDisplayed()) {
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'children-in-room')])["+i+"]")).sendKeys(Integer.toString(
						SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minnoofchildrens), Integer.parseInt(maxnoofchildrens))));
				//System.out.println("childrens is entered successfully");
				logger.info("childrens is entered successfully");
				test.log(Status.INFO, "childrens is entered successfully");

			}
		}

		Thread.sleep(2000);	
		if (roomselectiondone.isEnabled()) 
		{
			roomselectiondone.isDisplayed();
			roomselectiondone.click();
			SeleniumRepo.waitForPageLoaded();
			Thread.sleep(5000);
			//System.out.println("Clicked on done");
			logger.info("Clicked on done");
			test.log(Status.INFO, "Clicked on done");
		}

		else 
		{
			//System.out.println("Done Button Not found");
			logger.error("Done Button Not found");
			test.log(Status.FAIL, "Done Button Not found");

		}
	}

	*/
	
	/*
	public void checkavailabitlity()
	{
		ExplicitWait(Checkavailability);


		Javascriptexecutor(Checkavailability);
		//System.out.println("clicked on Checkavailability");
		SeleniumRepo.waitForPageLoaded();
		logger.info("clicked on Checkavailability");
		test.log(Status.INFO, "clicked on Checkavailability");


	}
	
	*/
	
	/*
	public void roomprice_validation(String After_offerprice ,String Before_offerprice )
	{
		//System.out.println("Before offer price is "+Before_offerprice);
		//System.out.println("After offer price is "+After_offerprice);

		if(!(After_offerprice.equals(Before_offerprice)))
		{
			//System.out.println("Offer code applied successfully and room price chnaged according to the offer");

			logger.info("Offer code applied successfully and room price chnaged according to the offer");
			test.log(Status.PASS, "Offer code applied successfully and room price changed according to the offer");

		}
		else 
		{
			//System.out.println("After offer code applied room price not changed");
			//logger.error("After offer code applied room price not changed");
			//test.log(Status.FAIL, "After offer code applied room price not changed");

		}
	}
	
	
	public String roomprice(String RoomType) throws InterruptedException
	{	
		Thread.sleep(2000);
		//System.out.println("total rooms are"+ Roomslist.size());
		for(int i=0;i<Roomslist.size();i++)
		{
			int j=i+1;
			//System.out.println(RoomType);
			String Roomname=Roomslist.get(i).getText();
			//System.out.println("room name is " +Roomname);
			if(RoomType.contains(Roomname))
			{
				//System.out.println("Room names are matched");
				logger.info("Room names are matched");
				test.log(Status.INFO, "Room names are matched");

				WebElement room=SeleniumRepo.driver.findElement(By.xpath("(//div[@ng-switch='room.brg'])["+j+"]"));

				JavascriptExecutor js= (JavascriptExecutor)SeleniumRepo.driver;
				js.executeScript("arguments[0].click();", room);

				Thread.sleep(3000);
				Before_Offerprice=price.getText();	
				//System.out.println("price is"+Before_Offerprice);
				break;
			}

		}
		return Before_Offerprice;

	}
	
	*/
	
	/*
	public void offersat_Reservationpage(String After_offerprice,String Offercode)
	{

		//System.out.println("Special offers are applied successfully");
		logger.info("Special offers are applied successfully");
		test.log(Status.INFO, "Special offers are applied successfully");


		List <WebElement> specialoffers=SeleniumRepo.driver.findElements(By.xpath("(//*[contains(text(),'Special offer')])"));

		for(int o=1;o<=specialoffers.size();o++)
		{
			String offername=SeleniumRepo.driver.findElement(By.xpath("(//*[contains(text(),'Special offer')])["+o+"]/following-sibling::ul/li/label/span[3]/strong")).getText();
			//System.out.println("Special offer at room "+o+" is "+offername);
			if(offername.equals(Offercode))
			{

				//System.out.println("Offer code is applied successfully and also shwoed at Reservation details page ");
			}
			String offerprice=SeleniumRepo.driver.findElement(By.xpath("(//*[contains(text(),'Special offer')])["+o+"]/following-sibling::ul/li/label/span[3]/span[2]/span/strong")).getText();
			//System.out.println(offername + "at room "+o+" price is "+offerprice);
			if(offerprice.equals(After_offerprice))
			{
				//System.out.println("Offer code is applied successfully and also shwoed at Reservation details page ");
			}
		}
	}
	
	*/

	/*
	public void Click_SpecialRate() throws InterruptedException
	{
		ExplicitWait(Click_SpecialRate);
		if (Click_SpecialRate.isDisplayed()) 
		{
			String offercodetitle=Click_SpecialRate.getText();
			//System.out.println(offercodetitle);
			try
			{
				Click_SpecialRate.click();
			}
			catch(Exception e)
			{
				Javascriptexecutor(Click_SpecialRate);
			}
			Thread.sleep(3000);
			//System.out.println("Text obtained in title is "+offercodetitle);
			if(offercodetitle.contains("Special rate"))
			{
				//System.out.println("Expected text Special_rate is obtained");
				logger.info("Expected text Special_rate is obtained");
				test.log(Status.INFO, "Expected text Special_rate is obtained");
			}
			else
			{
				//System.out.println("Expected text is not obtained");
				logger.error("Special rate Text is matched");
				test.log(Status.FAIL, "Special rate Text is matched");
			}

			ExplicitWait(Modeltitle);
			if (Modeltitle.isDisplayed())
			{
				String ofercodepopuptitle=Modeltitle.getText();
				//System.out.println("Text obtained in title is "+ofercodepopuptitle);
				if(ofercodepopuptitle.equalsIgnoreCase(offercodetitle))
				{
					//System.out.println(offercodetitle+ "title is matching with the popup title");
				}

				logger.info("modalTitle Element is present");
				test.log(Status.INFO, "modalTitle Element is present");

			} 
			else 
			{
				//System.out.println("modalTitle Element is not present");
				logger.error("modalTitle Element is not present");
				test.log(Status.FAIL, "modalTitle Element is not present");

			}

		} 
		else 
		{
			//System.out.println("Special rate element is not present");
			logger.error("Special rate element is not present");
			test.log(Status.FAIL, "Special rate element is not present");

		}	

	}


	public void SpecialRateplan_Validation() throws InterruptedException
	{
		Thread.sleep(3000);

		ExplicitWait(Offercode);
		int No_of_offercdes=SpecialRateplans.size();
		//System.out.println(No_of_offercdes+"  offer codes are available");
		for(int i=1;i<=No_of_offercdes;i++)
		{

			WebElement Specialrateplan= SeleniumRepo.driver.findElement(By.xpath("(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)["+i+"]"));

			if(Specialrateplan.isDisplayed())
			{	
				String offercode=Specialrateplan.getText();
				////System.out.println(offercode);
				//System.out.println("Offer code present at "+i+" radio button SPECIAL RATES & OFFER CODE is  "+offercode);
				test.log(Status.INFO, "Obtained text is displayed successfully");

			}
		}
	}


	public void Click_Done()
	{
		ExplicitWait(Specialdone);
		if (Specialdone.isDisplayed()) 
		{
			Javascriptexecutor(Specialdone);
			ExplicitWait(Checkavailability);
			//System.out.println("Clicked on Special Rate plan done button ");
			logger.info("Clicked on Special Rate plan done button");
			test.log(Status.INFO, "Clicked on Special Rate plan done button");

		} else {
			//System.out.println("Special Rate plan done button not found");
			logger.error("Special Rate plan done button not found");
			test.log(Status.FAIL, "Special Rate plan done button not found");

		}
	}
	
	*/
	
	/*
	public void Accesscode_sendkeys(String Accesscode) throws InterruptedException
	{
		//System.out.println(Accesscode);
		ExplicitWait(OfferCode_textfeild);
		if(OfferCode_textfeild.isDisplayed())
		{
			//System.out.println("entring into accesscode");
			//OfferCode_button.click();
			Javascriptexecutor(OfferCode_textfeild);
			OfferCode_textfeild.sendKeys(Accesscode);

			Thread.sleep(4000);

			//	OfferCode_textfeild.sendKeys(Keys.ENTER);
			SeleniumRepo.waitForPageLoaded();
			//System.out.println("Offercode "+ Accesscode+" placed successfully");
			test.log(Status.INFO, "Offercode "+ Accesscode+" placed successfully");

			Thread.sleep(2000);	
		}
		else 
		{
			//System.out.println("Accesscode text field is not displayed");
			logger.error("Accesscode text field is not displayed");
			test.log(Status.FAIL, "Accesscode text field is not displayed");

		}

	}
	
	*/
	
	/*
	public void room_type(String roomtype) throws InterruptedException
	{
		WebElement Room=SeleniumRepo.driver.findElement(By.xpath("//span[contains(text(),'"+roomtype+"') and @class='rooms-list-title ng-binding']"));

		Javascriptexecutor(Room);
		Thread.sleep(1000);
		logger.info( "Clicked on "+roomtype+ " room");
		test.log(Status.INFO, "Clicked on "+roomtype+ " room");

	}
	*/
	
	/*
	public void selectroom() throws InterruptedException
	{
		ExplicitWait(Select_Room);
		if (Select_Room.isDisplayed()) 
		{
			Select_Room.click();
			Thread.sleep(3000);
			//System.out.println("Clicked on select room");
			logger.info("Clicked on select room");
			test.log(Status.INFO, "Clicked on select room");

		} else 
		{
			//System.out.println("Unable to Click on select room");
			logger.error("Unable to Click on select room");
			test.log(Status.FAIL, "Unable to Click on select room");
		}

		Thread.sleep(2000);
		int roomlength = rooms.size();
		//System.out.println(roomlength);
		for(int L=1;L<=roomlength;L++)
		{

			if (SeleniumRepo.driver.findElement(By.xpath("(//ul[@class='rooms-selector-list']//li)["+L+"]/a")).isDisplayed()) 
			{
				SeleniumRepo.driver.findElement(By.xpath("(//ul[@class='rooms-selector-list']//li)["+L+"]/a")).click();
				Thread.sleep(4000);

				//System.out.println("room "+L+" selected successfully");
				logger.info("rooms selected successfully");
				test.log(Status.INFO, "rooms selected successfully");

			} else 
			{
				//System.out.println("rooms not selected successfully");
				logger.error("rooms not selected successfully");
				test.log(Status.FAIL, "rooms not selected successfully");

			}
		}
	}
*/
	/*
	public void BookRoom() throws InterruptedException
	{
		ExplicitWait(Booknow);

		Thread.sleep(2000);
		if (Booknow.isEnabled()) 
		{
			Booknow.isDisplayed();
			Javascriptexecutor(Booknow);

			//System.out.println("Clicked on Booknow");
			SeleniumRepo.waitForPageLoaded(); 
			ExplicitWait(verify_Headingrooms);
			logger.info("Clicked on Booknow");
			test.log(Status.INFO, "Clicked on Booknow");

		} else 
		{
			//System.out.println("BookNow button not found");
			logger.error("BookNow button not found");
			test.log(Status.FAIL, "BookNow button not found");

		}
	}

*/
	
	/**
	 * Method verifies the headers of the booking engine after the availability page
	 * 
	 * Reactor idea: break this up into individual verifying methods as well as clicking methods
	 * 
	 * @throws InterruptedException
	 */
	public void verify_Headingrooms() throws InterruptedException
	{
		ExplicitWait(verify_Headingrooms);
		Thread.sleep(5000);
		String heading=verify_Headingrooms.getText();
		//System.out.println("Text obtained is"+heading);
		if(heading.contains("Rooms"))
		{
			//System.out.println("Expected text "+heading+ " is obtained");
			logger.info("Element is present");
			test.log(Status.INFO, "Verified Headingrooms");

		}
		else
		{

			logger.error("Headingrooms not found");
			test.log(Status.FAIL, "Headingrooms not found");

		}	


		String reservation=verify_Reservation.getText();
		//System.out.println("Text obtained is"+reservation);
		if(reservation.contains("Reservation details"))
		{
			//System.out.println("Expected text "+reservation+ " is obtained");
			logger.info("Reservation details text present");
			test.log(Status.INFO, "Reservation details text present");
		}
		else
		{
			//System.out.println("Reservation details text is not present");
			logger.error("Reservation details text is not present");
			test.log(Status.FAIL, "Reservation details text is not present");

		}
		logger.info("Reservation element is present");
		test.log(Status.INFO, "Reservation element is present");

		String startover=verify_startover.getText();
		//System.out.println("Text obtained is"+startover);
		if(startover.contains("Start over"))
		{
			//System.out.println("Expected text "+startover+" is obtained");
			logger.info("startover text present");
			test.log(Status.INFO, "startover text present");
		}
		else
		{
			//System.out.println("startover text is not obtained");
			logger.error("startover text is not present");
			test.log(Status.FAIL, "startover text is not present");
		}
		logger.info("startover Element is present");
		test.log(Status.INFO, "startover Element is present");

		String guest=verify_Guest.getText();
		//System.out.println("Text obtained is"+guest);
		if(guest.equalsIgnoreCase("Guest details"))
		{
			//System.out.println("Expected text"+guest+ " is obtained");
			logger.info("GUEST DETAILS text present");
			test.log(Status.INFO, "GUEST DETAILS text present");
		}
		else{
			//System.out.println("GUEST DETAILS is not obtained");
			logger.error("GUEST DETAILS is not present");
			test.log(Status.FAIL, "GUEST DETAILS text is not present");
		}
	}

	/*
	public void verify_available_offers() 
	{

		int availableoffers = verify_offers.size();
		//System.out.println(availableoffers);
		for(int M=1;M<=availableoffers;M++)
		{
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[contains(@id,'edit_booking_')]//legend/span)["+M+"]")).isDisplayed()) 
			{
				String available =	SeleniumRepo.driver.findElement(By.xpath("(//*[contains(@id,'edit_booking_')]//legend/span)["+M+"]")).getText();
				//System.out.println("Text Obtained is " +available);
				if(available.contains("AVAILABLE OFFERS"))
				{
					//System.out.println("Expected text"+available+"  is obtained");
					logger.info("AVAILABLE OFFERS text present");
					test.log(Status.INFO, "AVAILABLE OFFERS text present");
				}
				else{
					//System.out.println("AVAILABLE OFFERS text is not obtained");
					logger.error("AVAILABLE OFFERS is not present");
					test.log(Status.FAIL, "AVAILABLE OFFERS text is not present");
				}
			}
		} 
	}

*/
	
	/*
	public String Verify_Reservationdetails() 
	{
		ExplicitWait(verify_mainheader);
		if (verify_mainheader.isDisplayed()) 
		{
			String mainheader=verify_mainheader.getText();
			//System.out.println("Text obtained is"+mainheader);
			if(mainheader.contains("RESERVATION DETAILS"))
			{
				//System.out.println("Expected text"+mainheader+ " is obtained");
				logger.info("RESERVATION DETAILS text present");
				test.log(Status.INFO, "RESERVATION DETAILS text present");

			}
			else{
				//System.out.println("Expected text is not obtained");
				logger.error("RESERVATION DETAILS is not present");
				test.log(Status.FAIL, "RESERVATION DETAILS text is not present");
			}
			test.log(Status.INFO, "mainheader Element is present");

		} 
		else {
			//System.out.println("mainheader Element is not present");
			logger.error("mainheader Expected value is not obtained");
			test.log(Status.FAIL, "mainheader Element is not present");

		}

		int Dates = verify_dates.size();
		//System.out.println(Dates);
		for(int Q=1;Q<=Dates;Q++)
		{
			if (SeleniumRepo.driver.findElement(By.xpath("(//div[@class='sideheader']/span[@role='text'])['"+Q+"']")).isDisplayed()) {
				String reserdate =	SeleniumRepo.driver.findElement(By.xpath("(//div[@class='sideheader']/span[@role='text'])['"+Q+"']")).getText();
				//System.out.println("Text Obtained is "+reserdate);
			} else 
			{
				//System.out.println("Expected dateis not obtained");
				logger.error("Expected date is not obtained");
				test.log(Status.FAIL, "Expected date is not obtained");

			}
		}
		if (verify_roomcharges.isDisplayed()) 
		{
			String room=verify_roomcharges.getText();
			//System.out.println("Text obtained is"+room);
			if(room.contains("ROOM CHARGES:"))
			{
				//System.out.println("Expected text "+room+ " is obtained");
				logger.info("ROOM CHARGES: text present");
				test.log(Status.INFO, "ROOM CHARGES: text present");
			}
			else{
				//System.out.println("ROOM CHARGES: text is not obtained");
				logger.error("ROOM CHARGES: text is not obtained");
				test.log(Status.FAIL, "ROOM CHARGES: text is not obtained");

			}
			test.log(Status.INFO, "roomcharges Element is present");

		} else {
			//System.out.println("roomcharges Element is not present");
			logger.error("roomcharges is not present");
			test.log(Status.FAIL, " roomcharges Element is not present");

		}

		if (verify_taxesandfees.isDisplayed()) 
		{
			String taxes=verify_taxesandfees.getText();
			//System.out.println("Text obtained is"+taxes);
			if(taxes.contains("TAXES AND FEES:"))
			{
				//System.out.println("Expected text " +taxes+" is obtained");

			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "taxesandfees Element is present");

		} else {
			//System.out.println("taxesandfees Element is not present");
			logger.error("taxesandfees is not present");
			test.log(Status.FAIL, "taxesandfees Element is not present");

		}

		if (verify_grandtotal.isDisplayed())
		{
			String grand=verify_grandtotal.getText();
			//System.out.println("Text obtained is"+grand);
			if(grand.contains("GRAND TOTAL:"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "grandtotal Element is present");



		} else {
			//System.out.println("grandtotal Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "grandtotal Element is not present");
		}
		return GrandTotalAmount.getText();
	}

	*/
	
	/*
	public void checkbox()
	{
		if(click_iwouldlike.isSelected())
		{

			//System.out.println("Clicked on checkbox i would like email");
			logger.info("Clicked on checkbox i would like email");
			test.log(Status.INFO, "Clicked on checkbox i would like email");

		}
		else
		{
			click_iwouldlike.click();
			//System.out.println("Clicked on checkbox i would like email");
			logger.info("Clicked on checkbox i would like email");
			test.log(Status.INFO, "Clicked on checkbox i would like email");

		}
	}

	*/
	
	
	/*
	public void Select_rateplan(String rateplan)
	{

		WebElement select_rateplan=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+rateplan+"')]/../preceding-sibling::span/span"));

		if(select_rateplan.isSelected())
		{
			//System.out.println("Rate plan "+rateplan+" selected successfully");
			logger.info("Rate plan "+rateplan+" selected successfully");
			test.log(Status.PASS, "Rate plan "+rateplan+" selected successfully");
		}
		else
		{
			Javascriptexecutor(select_rateplan);
			//System.out.println("Rate plan "+rateplan+" selected successfully");
			logger.info("Rate plan "+rateplan+" selected successfully");
			test.log(Status.PASS, "Rate plan "+rateplan+" selected successfully");
		}

	}

	
	public void First_name(String FirstName)
	{

		if(Enter_Firstname.isDisplayed())
		{
			Enter_Firstname.clear();
			Enter_Firstname.click();
			Enter_Firstname.sendKeys(FirstName);
			//System.out.println("Entered Firstname");
			logger.info("Entered Firstname");
			test.log(Status.INFO, "Entered Firstname");

		} else {
			//System.out.println("Not Entered Firstname");
			logger.error("Not Entered Firstname");
			test.log(Status.FAIL, "Not Entered Firstname");
		}

	}
	public void Last_Name(String LastName)
	{

		if(Enter_lastname.isDisplayed())
		{
			Enter_lastname.clear();
			Enter_lastname.click();
			Enter_lastname.sendKeys(LastName);
			//System.out.println("Entered Lastname");
			logger.info("Entered Lastname");
			test.log(Status.INFO, "Entered Lastname");

		} else 
		{
			//System.out.println("Not Entered Lastname");
			logger.error("Not Entered Lastname");
			test.log(Status.FAIL, "Not Entered Lastname");

		}
	}
	public void Email(String Email)
	{

		if(Enter_Email.isDisplayed())
		{
			Enter_Email.clear();
			Enter_Email.click();
			Enter_Email.sendKeys(Email);
			//System.out.println("Entered Email");
			logger.info("Entered Email");
			test.log(Status.INFO, "Entered Email");

		}
		else 
		{
			//System.out.println("Not Entered Email");
			logger.error("Not Entered Email");
			test.log(Status.FAIL, "Not Entered Email");


		}
	}
	
	*/
	
	/*
	public void extra_inforamtion()
	{

		List<WebElement> els =SeleniumRepo.driver.findElements( By.xpath("(//input[@class='grp none-outline'])"));
		for(WebElement el : els ) {
			if (!el.isSelected() ) {
				Javascriptexecutor(el);
			}
		}
	}
	
	*/

	/*
	public void confirmation() throws InterruptedException
	{


		if(confirmation.isDisplayed())
		{
			confirmation.click();
			//System.out.println("Clicked on confirmation button");
			logger.info("Clicked on confirmation button");
			test.log(Status.INFO, "Clicked on confirmation button");

		} else {
			//System.out.println("Not Clicked on confirmation button");
			logger.error("Not Clicked on confirmation button");
			test.log(Status.FAIL, "Not Clicked on confirmation button");
		}

		SeleniumRepo.waitForPageLoaded();
		Thread.sleep(3000);
	}
	
	*/

	
	/*
	public void card_information()
	{

		if (Verify_CardInformation.isDisplayed()) 
		{
			String card=Verify_CardInformation.getText();
			//System.out.println("Text obtained is" +card);
			if(card.contains("CARD INFORMATION"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "CardInformation Element is present");

		} else {
			//System.out.println("CardInformation Element is not present");
			logger.error("CardInformation Expected value is not present");
			test.log(Status.FAIL, "CardInformation Element is not present");

		}


		if (Verify_AcceptedCreditcard.isDisplayed()) {
			String Acceptcc=Verify_AcceptedCreditcard.getText();
			//System.out.println("Text obtained is" +Acceptcc);
			if(Acceptcc.contains("ACCEPTED CREDIT CARDS"))
			{
				//System.out.println("Expected text" +Acceptcc+ " is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "AcceptedCreditcard Element is present");

		} else {
			//System.out.println("AcceptedCreditcard Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "AcceptedCreditcard Element is not present");

		}
	}

*/
	/*
	public void card_name(String Cardname)
	{

		if(Nameoncard.isDisplayed())
		{
			Nameoncard.clear();
			Nameoncard.click();
			Nameoncard.sendKeys(Cardname);
			logger.info("Entered card name");
			test.log(Status.INFO, "Entered card name");

		} else {
			//System.out.println("Not Entered card name");
			logger.error("Not Entered card name");
			test.log(Status.FAIL, "Not Entered card name");
		}
	}
	public void Card_number(String Numberoncard)
	{

		if (CardNumb.isDisplayed())
		{
			Javascriptexecutor(CardNumb);

			CardNumb.clear();

			TypeInField(CardNumb, Numberoncard);
			//CardNumb.sendKeys(Numberoncard);
			logger.info("Entered card number");
			test.log(Status.INFO, "Entered card number");

		} else {
			//System.out.println("Not Entered card number");
			logger.error("Not Entered card number");
			test.log(Status.FAIL, "Not Entered card number");
		}
	}
	public void Expdate()
	{

		if(expdate.isDisplayed())
		{
			//CardNumb.clear();
			expdate.click();
			expdate.sendKeys("02");
			logger.info("Entered Experied Month");
			test.log(Status.INFO, "Entered Experied Month");

		} else {
			//System.out.println("Not Entered Experied Month");
			logger.error("Not Entered Experied Month");
			test.log(Status.FAIL, "Not Entered Experied Month");
		}

		if (expyear.isEnabled()) {
			expyear.isDisplayed();
			//expyear.click();
			selectByVisibleText(expyear, "2022");
			//expyear.sendKeys("2022");
			logger.info("Entered Experied year");
			test.log(Status.INFO, "Entered Experied year");

		} else {
			//System.out.println("Not Entered Experied year");
			logger.error("Not Entered Experied year");
			test.log(Status.FAIL, "Not Entered Experied year");
		}


		if (CVV.isEnabled()) {
			CVV.isDisplayed();
			CVV.click();
			CVV.sendKeys("123");
			logger.info("Entered CVV number");
			test.log(Status.INFO, "Entered CVV number");

		} else 
		{
			//System.out.println("Not Entered CVV number");
			logger.error("Not Entered CVV number");
			test.log(Status.FAIL, "Not Entered CVV number");

		}
	}

	public void Country(String Entercountry) throws InterruptedException
	{
		if (Countrydropdown.isDisplayed()) 
		{
			selectByVisibleText(Countrydropdown, Entercountry);
			logger.info(Entercountry+" country selected");
			test.log(Status.INFO, Entercountry+"country selected");

		} else 
		{
			//System.out.println("Unable to select country");
			logger.error("Unable to select country");
			test.log(Status.FAIL, " Unable to select country");

		}
	}
	public void payment() throws InterruptedException
	
	{
		if (verify_paymentroomcharges.isDisplayed()) {
			String paymentroom=verify_paymentroomcharges.getText();
			//System.out.println("Text obtained is" +paymentroom);
			if(paymentroom.contains("ROOM CHARGES:"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{
	
				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "paymentroomcharges Element is present");
	
		} else {
			//System.out.println("paymentroomcharges Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "paymentroomcharges Element is not present");
	
		}
	
	
		if (verify_paymenttaxesandfees.isDisplayed()) {
			String paymenttaxes=verify_paymenttaxesandfees.getText();
			//System.out.println("Text obtained is" +paymenttaxes);
			if(paymenttaxes.contains("TAXES AND FEES:"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{
	
				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "Element is present");
	
		} else {
			//System.out.println("Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "Element is not present");
		}
	
	
		if (verify_paymentgrandtotal.isDisplayed()) {
			String paymentgrandtotal=verify_paymentgrandtotal.getText();
			//System.out.println("Text obtained is"+paymentgrandtotal);
			if(paymentgrandtotal.contains("GRAND TOTAL:"))
			{
				//System.out.println("Expected text "+paymentgrandtotal+ " is obtained");
			}
			else{
	
				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "paymentgrandtotal Element is present");
	
		} else {
			//System.out.println("paymentgrandtotal Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "paymentgrandtotal Element is not present");
	
		}
	
		if (Verify_accept.isDisplayed()) {
			String termsandcondition=Verify_accept.getText();
			//System.out.println("Text obtained is"+termsandcondition);
			if(termsandcondition.contains("I accept the Terms & Conditions"))
			{
				//System.out.println("Expected text "+termsandcondition +" is obtained");
			}
			else{
	
				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "I accept the Terms & Conditions Element is present");
	
		} else {
			//System.out.println("I accept the Terms & Conditions Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "I accept the Terms & Conditions Element is not present");
	
		}
	
		if (Click_accept.isEnabled()) {
			Click_accept.isDisplayed();
			Click_accept.click();
			logger.info("Clicked on accept checkbox");
			test.log(Status.INFO, "Clicked on accept checkbox");
	
		} else {
			//System.out.println("Not Clicked on accept checkbox");
			logger.error("Not Clicked on accept checkbox");
			test.log(Status.FAIL, "Not Clicked on accept checkbox");
		}
	
	
		if (CompleteReservation.isEnabled()) 
		{
	
			Javascriptexecutor(CompleteReservation);
			logger.info("Clicked on CompleteReservation button");
			test.log(Status.INFO, "Clicked on CompleteReservation button");
	
		} else {
			//System.out.println("Not Clicked on CompleteReservation button");
			logger.error("Not Clicked on CompleteReservation button");
			test.log(Status.FAIL, "Not Clicked on CompleteReservation button");
		}
	
		SeleniumRepo.waitForPageLoaded();
	
		ExplicitWait(Verify_thankyou);
	
		if (Verify_thankyou.isDisplayed()) 
		{
			String Thankyou=Verify_thankyou.getText();
			//System.out.println("Text obtained is"+Thankyou);
			if(Thankyou.contains("THANK YOU FOR YOUR RESERVATION"))
			{
				//System.out.println("Expected text "+Thankyou+" is obtained");
			}
			else{
	
				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "Thank you for your reservation Element is present");
	
	
		}
	}
	
	*/
	
	/*
	public void Billing_Address(String Address,String Enterzipcode,String Address2,String Enterstate,String Entercity)
	{
		if (verify_Billingaddress.isDisplayed()) {
			String address=verify_Billingaddress.getText();
			//System.out.println("Text obtained is" +address);
			if(address.contains("BILLING ADDRESS"))
			{
				//System.out.println("Expected text "+address+" is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "address Element is present");

		} else {
			//System.out.println("address Element is not present");
			logger.error("address Expected value is not present");
			test.log(Status.FAIL, "address Element is not present");

		}

		if (addressline1.isEnabled()) {
			addressline1.isDisplayed();
			addressline1.click();
			addressline1.sendKeys(Address);
			logger.info("Entered Address ");
			test.log(Status.INFO, "Entered Address");

		} else {
			//System.out.println("Not Entered Address");
			logger.error("Not Entered Address");
			test.log(Status.FAIL, "Not Entered Address");
		}

		if (addressline2.isEnabled()) {
			addressline2.isDisplayed();
			addressline2.sendKeys(Address2);
			addressline2.click();
			logger.info("Entered Address2 ");
			test.log(Status.INFO, "Entered Address2");

		} else {
			//System.out.println("Not Entered Address2");
			logger.error("Not Entered Address2");
			test.log(Status.FAIL, "Not Entered Address2");
		}


		if (City.isEnabled()) {
			City.isDisplayed();
			City.click();
			City.sendKeys(Entercity);
			logger.info("Entered city ");
			test.log(Status.INFO, "Entered City");

		} else {
			//System.out.println("Not Entered City");
			logger.error("Not Entered City");
			test.log(Status.FAIL, "Not Entered City");
		}


		if (State.isDisplayed()) 
		{
			State.click();
			selectByVisibleText(State, Enterstate);
			//State.sendKeys(Enterstate);
			logger.info("Entered city ");
			test.log(Status.INFO, "Entered City");

		} else {
			//System.out.println("Not Entered City");
			logger.error("Not Entered City");
			test.log(Status.FAIL, "Not Entered City");
		}


		if (Zipcode.isEnabled()) {
			Zipcode.isDisplayed();
			Zipcode.click();
			Zipcode.sendKeys(Enterzipcode);
			logger.info("Entered Zipcode ");
			test.log(Status.INFO, "Entered Zipcode");

		} else {
			//System.out.println("Not Entered Zipcode");
			logger.error("Not Entered Zipcode");
			test.log(Status.FAIL, "Not Entered Zipcode");

		}

	}

	*/
	
	
	/*
	public void contact(String Enterphonenum) throws InterruptedException
	{
		if (contactinformation.isDisplayed()) {
			String contact=contactinformation.getText();
			//System.out.println("Text obtained is" +contact);
			if(contact.contains("ADDITIONAL CONTACT INFORMATION"))
			{
				//System.out.println("Expected text" +contact+ " is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "contactinformation Element is present");

		} else {
			//System.out.println("contactinformation Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "contactinformation Element is not present");

		}
		if (PhoneNumber.isEnabled()) 
		{
			PhoneNumber.isDisplayed();
			PhoneNumber.click();
			PhoneNumber.clear();
			PhoneNumber.sendKeys(Enterphonenum);
			logger.info("Entered PhoneNumber ");
			test.log(Status.INFO, "Entered PhoneNumber");

		} else {
			//System.out.println("Not Entered PhoneNumber");
			logger.error("Not Entered PhoneNumber");
			test.log(Status.FAIL, "Not Entered PhoneNumber");

		}
	}
	
	*/
	
	/*
	public void SpecialRateplan_selection(String Rateplan) throws InterruptedException
	{
		if(SeleniumRepo.driver.findElement(By.xpath("//label[text()='"+Rateplan+"']")).isDisplayed())
		{
			SeleniumRepo.driver.findElement(By.xpath("//label[text()='"+Rateplan+"']")).click();
			//System.out.println("Rateplan selected successfully");
			test.log(Status.INFO, "Rateplan selected successfully");

			Thread.sleep(2000);	
			if (Specialdone.isDisplayed()) 
			{
				Specialdone.click();
				SeleniumRepo.waitForPageLoaded();
				//System.out.println("Clicked on done");
				logger.info("Clicked on done");
				test.log(Status.INFO, "Clicked on done");

			}
			else 
			{
				//System.out.println("not Clicked on done");
				logger.error("not Clicked on done");
				test.log(Status.FAIL, "not Clicked on done");

			}

		}
		else
		{
			test.log(Status.FAIL, "Element is not present");

		}	
	}
	
	*/
	
	//Figure out what this method is trying to do, it seems like a generic method that is 
	// looking for a specific  rate plan 
	public void SpecialRateplantext_validation(String Rateplan)
	{
		ExplicitWait(Offercode_Text);
		//System.out.println("Special Rateplan is "+Rateplan);

		if(Offercode_Text.isDisplayed())
		{
			String specialrateplantext=Offercode_Text.getText();
			if(specialrateplantext.contains(Rateplan))
			{
				//System.out.println("Special Rateplan applied successfully");
				test.log(Status.INFO, "Special Rateplan  applied successfully");

				SeleniumRepo.waitForElementPresent(Firstroom);
			}
			else
			{
				//System.out.println("Special Rateplan  is not applied");
				test.log(Status.INFO, "Special Rateplan  is not applied");

			}
		}
		else
		{
			test.log(Status.FAIL, "Element is not present");

		}
	}
	
	
	/*
	public void verify_Thanku_page()
	{
		int cancelreservation = Verify_cancelreservation.size();
		//System.out.println(cancelreservation );
		for(int R=1;R<=cancelreservation;R++)
		{
			if (SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Cancel reservation')])["+R+"]")).isDisplayed()) {
				//System.out.println(SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Cancel reservation')])["+R+"]")).getText());
				//System.out.println("Cancel Reservation is displayed successfully");
				logger.info("Cancel Reservation is displayed successfully");
				test.log(Status.INFO, "Cancel Reservation is displayed successfully");

			} else {
				//System.out.println("Cancel Reservation not found");
				logger.error("Cancel Reservation not found");
				test.log(Status.FAIL, "Cancel Reservation not found");

			}
		}

		int changereservation = Verify_changereservation.size();
		//System.out.println(changereservation );
		for(int S=1;S<=changereservation;S++)
		{
			if (SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Change reservation')])["+S+"]")).isDisplayed()) {
				//System.out.println(SeleniumRepo.driver.findElement(By.xpath("(//a[contains(text(),'Change reservation')])["+S+"]")).getText());
				//System.out.println("Changesreservation button found");
				logger.info("Changesreservation button found");
				test.log(Status.INFO, "Changesreservation button found");

			} else 
			{
				//System.out.println("Changesreservation button not found");
				logger.error("Changesreservation button not found");
				test.log(Status.FAIL, "Changesreservation button not found");

			}		
		}

		if (Verify_Thankuroomcharges.isDisplayed()) 
		{
			String Thankuroomcharges=Verify_Thankuroomcharges.getText();
			//System.out.println("Text obtained is" +Thankuroomcharges);
			if(Thankuroomcharges.contains("Room charges"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "Thankuroomcharges Element is present");

		} else {
			//System.out.println("Thankuroomcharges Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "Thankuroomcharges Element is not present");

		}


		/*if (Verify_Thankuothercharges.isDisplayed()) 
		{
			String Thankuothercharges=Verify_Thankuothercharges.getText();
			//System.out.println("Text obtained is" +Thankuothercharges);
			if(Thankuothercharges.contains("Other Services"))
			{
				//System.out.println("Expected text is obtained");
			}
			else
			{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "Thankuothercharges Element is present");

		}
		else 
		{
			//System.out.println("Thankuothercharges Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "Thankuothercharges Element is not present");

		}
//comment out block

		if (Verify_ThankuTaxesandfees.isDisplayed()) {
			String ThankuTaxesandfees=Verify_ThankuTaxesandfees.getText();
			//System.out.println("Text obtained is" +ThankuTaxesandfees);
			if(ThankuTaxesandfees.contains("Taxes and fees"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "ThankuTaxesandfee Element is present");

		} else {
			//System.out.println("ThankuTaxesandfee Element is not present");
			logger.error("ThankuTaxesandfee Expected value is not present");
			test.log(Status.FAIL, "ThankuTaxesandfee Element is not present");

		}


		if (Verify_Thankugrandtotal.isDisplayed()) {
			String Thankugrandtotal=Verify_Thankugrandtotal.getText();
			//System.out.println("Text obtained is" +Thankugrandtotal);
			if(Thankugrandtotal.contains("Grand total"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "Thankugrandtotal Element is present");

		} else {
			//System.out.println("Thankugrandtotal Element is not present");
			logger.error("Thankugrandtotal Expected value is not present");
			test.log(Status.FAIL, "Thankugrandtotal Element is not present");

		}


		if (verify_Checkintime.isDisplayed()) {
			String checkin=verify_Checkin.getText();
			//System.out.println("Text obtained is" +checkin);
			if(checkin.contains("Check in time:"))
			{
				//System.out.println("Expected text is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "Checkintime Element is present");

		} else {
			//System.out.println("Checkintime Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "Checkintime Element is not present");

		}

		if (verify_Checkouttime.isDisplayed()) 
		{
			String checkout=verify_Checkout.getText();
			//System.out.println("Text obtained is" +checkout);
			if(checkout.contains("Check out time:"))
			{
				//System.out.println("Expected text"+checkout+" is obtained");
			}
			else{

				//System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "Checkouttime Element is present");

		} else {
			//System.out.println("Checkouttime Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "Checkouttime Element is not present");

		}
		if (verify_Termsandconditionstext.isDisplayed()) 
		{
			String Termsandconditionstext=verify_Termsandconditionstext.getText();
			//System.out.println("Text obtained is" +Termsandconditionstext);
		}
	}

*/
	/*
	public void offercodevalidation_payment(String Offercode)
	{
		ExplicitWait(summary_reservation);
		for(int p=1;p<=offer_payment.size();p++)
		{
			String offername_payment=SeleniumRepo.driver.findElement(By.xpath("(//*[@headers='summary_reservation_offer'])["+p+"]")).getText();
			//System.out.println(offername_payment.trim());
			if((offername_payment.trim()).contains(Offercode))
			{
				//System.out.println("Offer code successfully applied at "+ p+ " room and showed at payment details page ");
				test.log(Status.PASS, "Offer code successfully applied at "+ p+ " room and showed at payment details page ");
				logger.info("Offer code successfully applied at "+ p+ " room and showed at payment details page ");
			}
			else
			{
				test.log(Status.FAIL, "Selected Rateplan is not showing at payment details page");
				logger.error("Selected Rateplan is not showing at payment details page");
			}
		}
	}
	
	*/
	
	
	//Have no idea whay an admin  class method is in the BE class, explor the TC class that uses this
	//method
	public void unavailability_popup() throws InterruptedException
	{
		Thread.sleep(3000);
		Group_Blocks group=PageFactory.initElements(SeleniumRepo.driver, Group_Blocks.class);

		if(group.BODY.getText().contains("No availability for requested offer"))
		{
			//System.out.println("After releasing unsold inventory,rates are not showing in Booking Engine ");
			logger.info("After releasing unsold inventory,rates are not showing in Booking Engine ");
			test.log(Status.PASS, "After releasing unsold inventory,rates are not showing in Booking Engine ");
		}
		else
		{
			logger.error("Unsold inventory is not released properly in Admin");
			test.log(Status.FAIL, "Unsold inventory is not released properly in Admin");
		}
	}
	
	/*
	public void Verify_UnfortunatelyMessage() throws InterruptedException
	{
		ExplicitWait(Checkavailability);
		Thread.sleep(3000);
		if(showRoomInfo.getText().contains("Unfortunately, there are no available rooms.")||(showRoomInfo.getText().contains("Or try our partner hotels below."))||(showRoomInfo.getText().contains("Please try adjusting your search criteria.")))
		{
			//System.out.println("After Closing the room/rate using House Control ,rooms  are not showing in Booking Engine ");
			logger.info("After Closing the room/rate using House Control ,rooms  are not showing in Booking Engine ");
			test.log(Status.PASS, "After Closing the room/rate using House Control ,rooms  are not showing in Booking Engine ");
		}
		else
		{
			logger.error("Room/rate are not closed properly in Admin");
			test.log(Status.FAIL, "Room/rate are not closed properly in Admin");
		}
	}
	
	*/
	
	
	/*
	public void verify_Roomsavailable(String SelectProperty) throws InterruptedException
	{
		Thread.sleep(2000);
		if(Roomslist.size()>0)
		{
			logger.info("Rooms and rates are available for the property "+SelectProperty);
			test.log(Status.PASS,"Rooms and rates are available for the property "+SelectProperty);

			for(int i=0;i<Roomslist.size();i++)
			{
				test.log(Status.INFO, Roomslist.get(i).getText()+" room is available for the property "+SelectProperty);
				logger.info(Roomslist.get(i).getText()+" room is available for the property "+SelectProperty);
			}

		}
		else
		{
			logger.error(SelectProperty+" property is not displaying any room");
			test.log(Status.FAIL,SelectProperty+" property is not displaying any room");
		}
	}
	
	*/
	
	/*
	public void verify_Alternateproperty(String[] propertynames)
	{
		List<String>lst=new ArrayList<String>();
		for(WebElement propertys:Alternateproperty_name)	
		{	
			lst.add(propertys.getText());
		}
		for(int i=0;i<propertynames.length;i++)		
		{
			if(lst.contains(propertynames[i]))
			{
				test.log(Status.PASS, "Alternate Property "+propertynames[i]+" displayed successfully");
				logger.info("Alternate Property "+propertynames[i]+" displayed successfully");
			}
			else
			{
				test.log(Status.FAIL, "Alternate Property "+propertynames[i]+"  not found in Booking Engine");
				logger.error("Alternate Property "+propertynames[i]+"  not found in Booking Engine");
			}
		}
	}
	
	*/
	
	/*
	public void Select_Alternateproperty_BookNow(String SelectProperty)
	{
		for(WebElement propertys:Alternateproperty_name)	
		{	
			if(propertys.isDisplayed())
			{
				if(propertys.getText().equals(SelectProperty))
				{
					propertys.click();
					test.log(Status.INFO, SelectProperty+" property selected successfully");	
					logger.info( SelectProperty+" property selected successfully");
				}
			}
			else
			{
				test.log(Status.FAIL, SelectProperty+"  property not found ");
				logger.error(SelectProperty+" property not found ");
			}
		}
		/*try
		{
			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+SelectProperty+"' and @ng-bind='booking.hotel.name'])[1]")));
		WebElement Booking_Propoertyname=SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+SelectProperty+"' and @ng-bind='booking.hotel.name'])[1]"));

				test.log(Status.PASS, SelectProperty+" property displayed on Map Successfully");
				logger.info(SelectProperty+" property displayed on Map Successfully");

			test.log(Status.FAIL, SelectProperty+"  property not found on Map ");
			logger.error(SelectProperty+" property not found on Map");
		}
		catch(Exception e)
		{
			WebElement Booking_Propoertyname=SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+SelectProperty+"' and @ng-bind='booking.hotel.name'])[2]"));

			if(Booking_Propoertyname.isDisplayed())
			{
					test.log(Status.PASS, SelectProperty+" property displayed on Map Successfully");
					logger.info(SelectProperty+" property displayed on Map Successfully");
			}
			else
			{
				test.log(Status.FAIL, SelectProperty+"  property not found on Map ");
				logger.error(SelectProperty+" property not found on Map");
			}
		}
		 //comment out
	}
*/
	
	/*
	public void Click_BookNow_AlternateProperty(String  SelectProperty)
	{
		try
		{

			WebElement BookNow=SeleniumRepo.driver.findElement(By.xpath("(//div[text()='"+SelectProperty+"'])[1]/following-sibling::a[contains(text(),'Book now')]"));

			Javascriptexecutor(BookNow);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(arrivaldate);

			test.log(Status.PASS, "Clicked on Book Now for the property "+SelectProperty);
			logger.info("Clicked on Book Now for the property "+SelectProperty);

		}
		catch(Exception e)
		{
			WebElement BookNow=SeleniumRepo.driver.findElement(By.xpath("(//div[text()='"+SelectProperty+"'])[2]/following-sibling::a[contains(text(),'Book now')]"));

			Javascriptexecutor(BookNow);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(arrivaldate);

			test.log(Status.PASS, "Clicked on Book Now for the property "+SelectProperty);
			logger.info("Clicked on Book Now for the property "+SelectProperty);


		}
	}
	
	*/
	
	
	/*
	public void verify_CompoundAccessRateplans(String Rateplan1,String Rateplan2,String CompoundAccessCode)
	{
		String Rateplans=Rateplan1+" "+Rateplan2;

		for(WebElement offers:Available_Offers)
		{
			test.log(Status.INFO, "Available rateplan is "+offers.getText());
			logger.info("Available rateplan is "+offers.getText());
			if(Rateplans.contains(offers.getText()))
			{
				test.log(Status.PASS, offers.getText()+" Rateplan associated successfully for the Compound AccessCode "+CompoundAccessCode);
			}
			else
			{
				test.log(Status.FAIL, offers.getText()+" Rateplan is not associated ");
				logger.error(offers.getText()+" Rateplan is not associated ");
			}
		}
	}
	
	*/
	
	@SuppressWarnings("deprecation")
	public void verify_Strike(String AdminDay,String RatePlan,String FlatAmount,String ShortDescription,String SteadyDays,String discounttype,String NthNight,String DISCOUNT_DEFINITION,String Percentage) throws InterruptedException, ParseException
	{
		test.log(Status.PASS, "DPR applied for the Rateplan:-"+RatePlan);
		logger.info("DPR applied for the Rateplan:-"+RatePlan);

		float FlatAmount_float=Float.parseFloat(FlatAmount);
		float Percentage_float=Float.parseFloat(Percentage);

		WebElement Click_Offerdetails=SeleniumRepo.driver.findElement(By.xpath("//*[@class='room-packages-title ng-binding' and text()='"+RatePlan+"']/following-sibling::a[text()='Offer details']"));
		if(Click_Offerdetails.isDisplayed())
		{
			int SteadyDays_int=Integer.parseInt(SteadyDays);
			Click_Offerdetails.click();

			ExplicitWait(Verify_OfferDetailsTitle);
			List<String>Alldates=Dates_BetweenRange(formattedDate1,formattedDate);

			if(discounttype.equals("First N Nights"))
			{

				System.out.println("DPR discount applies to First:-"+SteadyDays_int+" Nights ");
				test.log(Status.INFO, "DPR discount applies to First:-"+SteadyDays_int+" Nights ");
				logger.info("DPR discount applies to First:-"+SteadyDays_int+" Nights ");

				String LastDate=Alldates.get(SteadyDays_int-1);

				int LastDate_int=Integer.parseInt(LastDate.substring(0, 2));

				String LastMonthName=Month.of(LastDate_int).name().substring(0, 3);
				String LastMonth=LastMonthName.substring(0,1).toUpperCase()+LastMonthName.substring(1).toLowerCase();
				String LastDate1=LastDate.substring(3, 5);
				String LastYear=LastDate.substring(6);
				String LastDateConcat=LastMonth+" "+LastDate1+", "+LastYear;


				int j=1;
				for(int i=0;i<SteadyDays_int;i++)
				{
					String Exactdate=Alldates.get(i);

					int Exactdate_int=Integer.parseInt(Exactdate.substring(0, 2));

					String MonthName=Month.of(Exactdate_int).name().substring(0, 3);
					String Month=MonthName.substring(0,1).toUpperCase()+MonthName.substring(1).toLowerCase();
					String Date=Exactdate.substring(3, 5);
					String Year=Exactdate.substring(6);
					String Concat=Month+" "+Date+", "+Year;


					WebElement dates=SeleniumRepo.driver.findElement(By.xpath("(//*[@ng-bind='d.dates'])["+j+"]"));
					j++;

					System.out.println("Last Dates is:-"+LastDateConcat);
					System.out.println("dates:-"+dates.getText());

					if(DISCOUNT_DEFINITION.equals("FlatAmount"))
					{
						if(dates.getText().contains(LastDateConcat))
						{
							RateReuse(LastDateConcat,FlatAmount_float,dates,"FlatAmount",Percentage_float);

							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage"))
					{
						if(dates.getText().contains(LastDateConcat))
						{
							RateReuse(LastDateConcat,FlatAmount_float,dates,"Percentage",Percentage_float);

							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Flat Amount then Percentage"))
					{
						if(dates.getText().contains(LastDateConcat))
						{
							RateReuse(LastDateConcat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);

							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage then Flat Amount"))
					{
						if(dates.getText().contains(LastDateConcat))
						{
							RateReuse(LastDateConcat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);

							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
						}
					}
				}
			}
			else if(discounttype.equals("Last N Nights"))
			{

				System.out.println("DPR discount applies to Last:-"+SteadyDays_int+" Nights ");
				test.log(Status.PASS, "DPR discount applies to Last:-"+SteadyDays_int+" Nights ");
				logger.info("DPR discount applies to Last:-"+SteadyDays_int+" Nights ");

				String LastDate=Alldates.get(Alldates.size()-1);

				Date date=new SimpleDateFormat("MM/dd/yyyy").parse(LastDate);

				date.setDate(date.getDate() -SteadyDays_int);
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String StartDate = df.format(date);

				System.out.println("Startdate is:-"+StartDate);

				int StartDate_int=Integer.parseInt(StartDate.substring(0, 2));

				String StartMonthName=Month.of(StartDate_int).name().substring(0, 3);
				String StartMonth=StartMonthName.substring(0,1).toUpperCase()+StartMonthName.substring(1).toLowerCase();
				String StartDate1=StartDate.substring(3, 5);
				String StartYear=StartDate.substring(6);
				String StartDateConcat=StartMonth+" "+StartDate1+", "+StartYear;


				int j=LastRatedetails.size();

				for(int i=Alldates.size()-2;i<=SteadyDays_int;i--)
				{
					String Exactdate=Alldates.get(i);

					int Exactdate_int=Integer.parseInt(Exactdate.substring(0, 2));

					String MonthName=Month.of(Exactdate_int).name().substring(0, 3);
					String Month=MonthName.substring(0,1).toUpperCase()+MonthName.substring(1).toLowerCase();
					String Date=Exactdate.substring(3, 5);
					String Year=Exactdate.substring(6);
					String Concat=Month+" "+Date+", "+Year;

					System.out.println("Concat"+Concat);


					WebElement dates=SeleniumRepo.driver.findElement(By.xpath("(//*[@ng-bind='d.dates'])["+j+"]"));
					j--;

					System.out.println("DPR Disocunt Start Dates is:-"+StartDateConcat);
					System.out.println("dates:-"+dates.getText());

					if(DISCOUNT_DEFINITION.equals("FlatAmount"))
					{
						if(dates.getText().contains(StartDateConcat))
						{
							RateReuse(StartDateConcat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage"))
					{
						System.out.println("enter into percentage");
						if(dates.getText().contains(StartDateConcat))
						{
							RateReuse(StartDateConcat,FlatAmount_float,dates,"Percentage",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Flat Amount then Percentage"))
					{
						if(dates.getText().contains(StartDateConcat))
						{
							RateReuse(StartDateConcat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage then Flat Amount"))
					{
						if(dates.getText().contains(StartDateConcat))
						{
							RateReuse(StartDateConcat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
						}
					}
				}
			}
			else if(discounttype.equals("AnyDay"))
			{
				System.out.println("DPR applies to Only specific Day:-"+AdminDay);
				test.log(Status.INFO, "DPR applies to Only specific Day:-"+AdminDay);
				logger.info("DPR applies to Only specific Day:-"+AdminDay);

				WebElement dates=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+AdminDay+"')]"));
				if(DISCOUNT_DEFINITION.equals("FlatAmount"))
				{
					RateReuse(AdminDay,FlatAmount_float,dates,"FlatAmount",Percentage_float);
				}
				else if(DISCOUNT_DEFINITION.equals("Percentage"))
				{
					RateReuse(AdminDay,FlatAmount_float,dates,"Percentage",Percentage_float);
				}
				else if(DISCOUNT_DEFINITION.equals("Flat Amount then Percentage"))
				{
					RateReuse(AdminDay,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
				}
			}	
			else if(discounttype.equals("Nth Night"))
			{
				System.out.println("DPR applies to Nth Night:-"+NthNight);
				test.log(Status.INFO, "DPR applies to Nth Night:-"+NthNight);
				logger.info("DPR applies to Nth Night:-"+NthNight);

				int NthNight_int=Integer.parseInt(NthNight);

				String NthNightDate=Alldates.get(NthNight_int-1);

				int NthNightDate_int=Integer.parseInt(NthNightDate.substring(0, 2));

				String MonthName=Month.of(NthNightDate_int).name().substring(0, 3);
				String Month=MonthName.substring(0,1).toUpperCase()+MonthName.substring(1).toLowerCase();

				String Date=NthNightDate.substring(3, 5);
				String Year=NthNightDate.substring(6);

				String Concat=Month+" "+Date+", "+Year;

				WebElement dates=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+Concat+"')]"));
				if(DISCOUNT_DEFINITION.equals("FlatAmount"))
				{
					RateReuse(Concat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
				}
				else if(DISCOUNT_DEFINITION.equals("Percentage"))
				{
					RateReuse(Concat,FlatAmount_float,dates,"Percentage",Percentage_float);
				}
				else if(DISCOUNT_DEFINITION.equals("Flat Amount then Percentage"))
				{
					RateReuse(Concat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
				}
				else if(DISCOUNT_DEFINITION.equals("Percentage then Flat Amount"))
				{
					RateReuse(Concat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
				}
			}

			else if(discounttype.equals("All Nights"))
			{
				String StartDate=Alldates.get(0);

				int StartDate_int=Integer.parseInt(StartDate.substring(0, 2));

				String StartMonthName=Month.of(StartDate_int).name().substring(0, 3);
				String StartMonth=StartMonthName.substring(0,1).toUpperCase()+StartMonthName.substring(1).toLowerCase();
				String StartDate1=StartDate.substring(3, 5);
				String StartYear=StartDate.substring(6);
				String StartConcat=StartMonth+" "+StartDate1+", "+StartYear;

				String EndDate=Alldates.get(Alldates.size()-2);

				int EndDate_int=Integer.parseInt(EndDate.substring(0, 2));

				String EndMonthName=Month.of(EndDate_int).name().substring(0, 3);
				String EndMonth=EndMonthName.substring(0,1).toUpperCase()+EndMonthName.substring(1).toLowerCase();
				String EndDate1=EndDate.substring(3, 5);
				String EndYear=EndDate.substring(6);
				String EndConcat=EndMonth+" "+EndDate1+", "+EndYear;


				System.out.println("DPR applies to All Nights:-"+StartConcat+" to "+EndConcat);
				test.log(Status.INFO, "DPR applies to All Nights:-"+StartConcat+" to "+EndConcat);
				logger.info("DPR applies to All Nights:-"+StartConcat+" to "+EndConcat);

				int j=1;
				for(int i=0;i<=Alldates.size()-2;i++)
				{
					String Exactdate=Alldates.get(i);
					int Exactdate_int=Integer.parseInt(Exactdate.substring(0, 2));
					String MonthName=Month.of(Exactdate_int).name().substring(0, 3);
					String Month=MonthName.substring(0,1).toUpperCase()+MonthName.substring(1).toLowerCase();
					String Date=Exactdate.substring(3, 5);
					String Year=Exactdate.substring(6);
					String Concat=Month+" "+Date+", "+Year;
					WebElement dates=SeleniumRepo.driver.findElement(By.xpath("(//*[@ng-bind='d.dates'])["+j+"]"));
					j++;
					if(DISCOUNT_DEFINITION.equals("FlatAmount"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"Percentage",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Flat Amount then Percentage"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage then Flat Amount"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
						}
					}
				}
			}
			else if(discounttype.equals("Day Of Week"))
			{
				String StartDate=Alldates.get(0);

				int StartDate_int=Integer.parseInt(StartDate.substring(0, 2));

				String StartMonthName=Month.of(StartDate_int).name().substring(0, 3);
				String StartMonth=StartMonthName.substring(0,1).toUpperCase()+StartMonthName.substring(1).toLowerCase();
				String StartDate1=StartDate.substring(3, 5);
				String StartYear=StartDate.substring(6);
				String StartConcat=StartMonth+" "+StartDate1+", "+StartYear;

				String EndDate=Alldates.get(Alldates.size()-2);

				int EndDate_int=Integer.parseInt(EndDate.substring(0, 2));

				String EndMonthName=Month.of(EndDate_int).name().substring(0, 3);
				String EndMonth=EndMonthName.substring(0,1).toUpperCase()+EndMonthName.substring(1).toLowerCase();
				String EndDate1=EndDate.substring(3, 5);
				String EndYear=EndDate.substring(6);
				String EndConcat=EndMonth+" "+EndDate1+", "+EndYear;


				System.out.println("DPR applies to All Nights:-"+StartConcat+" to "+EndConcat);
				test.log(Status.INFO, "DPR applies to All Nights:-"+StartConcat+" to "+EndConcat);
				logger.info("DPR applies to All Nights:-"+StartConcat+" to "+EndConcat);

				int j=1;
				for(int i=0;i<=Alldates.size()-2;i++)
				{
					String Exactdate=Alldates.get(i);
					int Exactdate_int=Integer.parseInt(Exactdate.substring(0, 2));
					String MonthName=Month.of(Exactdate_int).name().substring(0, 3);
					String Month=MonthName.substring(0,1).toUpperCase()+MonthName.substring(1).toLowerCase();
					String Date=Exactdate.substring(3, 5);
					String Year=Exactdate.substring(6);
					String Concat=Month+" "+Date+", "+Year;
					WebElement dates=SeleniumRepo.driver.findElement(By.xpath("(//*[@ng-bind='d.dates'])["+j+"]"));
					j++;
					if(DISCOUNT_DEFINITION.equals("FlatAmount"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"FlatAmount",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"Percentage",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Flat Amount then Percentage"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Flat Amount then Percentage",Percentage_float);
						}
					}
					else if(DISCOUNT_DEFINITION.equals("Percentage then Flat Amount"))
					{
						if(dates.getText().contains(EndConcat))
						{
							RateReuse(EndConcat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
							break;
						}
						else
						{
							RateReuse(Concat,FlatAmount_float,dates,"Percentage then Flat Amount",Percentage_float);
						}
					}
				}
			}
		}
	}

	
	//review this method to understand and investigate where this method is being used
	public void RateReuse(String date1,float FlatAmount,WebElement dates,String DISCOUNT_DEFINITION,float Percentage)
	{

		WebElement DatesNightlyoldpriceElement=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+date1+"')]/following-sibling::div/em"));
		String DatesNightlyoldprice=DatesNightlyoldpriceElement.getText().substring(4,DatesNightlyoldpriceElement.getText().lastIndexOf("."));
		float DatesNightlyoldprice_float=Float.parseFloat(DatesNightlyoldprice);

		test.log(Status.INFO, "Old price on the date:-"+date1+" "+DatesNightlyoldprice_float);


		WebElement discountPriceElement=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+date1+"')]/following-sibling::div/b"));
		String BEAfterDiscountprice=discountPriceElement.getText().substring(4,discountPriceElement.getText().lastIndexOf("."));
		float singledayDiscountprice_float=Float.parseFloat(BEAfterDiscountprice);

		test.log(Status.INFO, "After Discount New price on the date:-"+date1+singledayDiscountprice_float);

		if(DISCOUNT_DEFINITION.equals("FlatAmount"))
		{
			test.log(Status.INFO, "discount price on the date:-"+date1+" "+FlatAmount);
			float AfterdiscountPrice=DatesNightlyoldprice_float-FlatAmount;


			if(AfterdiscountPrice==singledayDiscountprice_float)
			{
				System.out.println("DPR discount applied for the days:-"+dates.getText());
				test.log(Status.PASS,"DPR discount applied for the days:-"+dates.getText());
				logger.info("DPR discount applied for the days:-"+dates.getText());
			}

			else
			{
				System.out.println("DPR is failed to apply for the days:-"+dates.getText());
				test.log(Status.FAIL, "DPR is failed to apply for the day:-"+dates.getText());
				logger.error("DPR is failed to apply for the day"+dates.getText());
			}
		}
		else if(DISCOUNT_DEFINITION.equals("Percentage"))
		{
			test.log(Status.INFO, "discount price on the date:-"+date1+" "+FlatAmount);
			float discountprice=DatesNightlyoldprice_float*Percentage/100;
			float AfterdiscountPrice=DatesNightlyoldprice_float-discountprice;

			if(AfterdiscountPrice==singledayDiscountprice_float)
			{
				System.out.println("DPR discount applied for the days:-"+dates.getText());
				test.log(Status.PASS,"DPR discount applied for the days:-"+dates.getText());
				logger.info("DPR discount applied for the days:-"+dates.getText());
			}
			else
			{
				System.out.println("DPR is failed to apply for the days:-"+dates.getText());
				test.log(Status.FAIL, "DPR is failed to apply for the day:-"+dates.getText());
				logger.error("DPR is failed to apply for the day"+dates.getText());
			}
		}
		else if(DISCOUNT_DEFINITION.equals("Flat Amount then Percentage"))
		{

			float flatdiscount=DatesNightlyoldprice_float-FlatAmount;
			float discountprice=flatdiscount*Percentage/100;
			float AfterdiscountPrice=flatdiscount-discountprice;
			test.log(Status.INFO, "discount price on the date:-"+date1+" "+discountprice);
			if(AfterdiscountPrice==singledayDiscountprice_float)
			{
				System.out.println("DPR discount applied for the days:-"+dates.getText());
				test.log(Status.PASS,"DPR discount applied for the days:-"+dates.getText());
				logger.info("DPR discount applied for the days:-"+dates.getText());
			}
			else
			{
				System.out.println("DPR is failed to apply for the days:-"+dates.getText());
				test.log(Status.FAIL, "DPR is failed to apply for the day:-"+dates.getText());
				logger.error("DPR is failed to apply for the day"+dates.getText());
			}
		}
		else if(DISCOUNT_DEFINITION.equals("Percentage then Flat Amount"))
		{
			float Percentagediscount=(DatesNightlyoldprice_float*Percentage)/100;
			float discountprice=Percentagediscount+FlatAmount;
			float AfterdiscountPrice=DatesNightlyoldprice_float-discountprice;
			test.log(Status.INFO, "discount price on the date:-"+date1+" "+discountprice);
			if(AfterdiscountPrice==singledayDiscountprice_float)
			{
				System.out.println("DPR discount applied for the days:-"+dates.getText());
				test.log(Status.PASS,"DPR discount applied for the days:-"+dates.getText());
				logger.info("DPR discount applied for the days:-"+dates.getText());
			}
			else
			{
				System.out.println("DPR is failed to apply for the days:-"+dates.getText());
				test.log(Status.FAIL, "DPR is failed to apply for the day:-"+dates.getText());
				logger.error("DPR is failed to apply for the day"+dates.getText());
			}
		}
	}
	
	/*
	public void Offerdetails_Close() throws InterruptedException
	{
		Thread.sleep(2000);
		OfferDetails_Close.click();
		ExplicitWait(Enter_Firstname);
	}
	
	*/
	
	/**
	 * 
	 * Todo: must get ride of this method by refactoring it , it uses methods that were moved
	 * into new classes 
	 * 
	 * Classes using this method: TC_DPRTestCases_Flat_Then_Percentage , TC_DPRTestCases_FlatAmount ,
	 *  TC_DPRTestCases_Percentage_Then_Flat , TC_DPRTestCases_Percentage
	 * 
	 * @param Enterrooms
	 * @param roomtype
	 * @param rateplan
	 * @param AdminDay
	 * @param RatePlan
	 * @param FlatAmount
	 * @param ShortDescription
	 * @param SteadyDays
	 * @param discounttype
	 * @param NthNight
	 * @param DISCOUNT_DEFINITION
	 * @param Percentage
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param Cardname
	 * @param Numberoncard
	 * @param Entercountry
	 * @param Address
	 * @param Enterzipcode
	 * @param Address2
	 * @param Enterstate
	 * @param Entercity
	 * @param Enterphonenum
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	
	/*
	public void ReuseMethodsforDPR(String Enterrooms,String roomtype,String rateplan,String AdminDay,String RatePlan,String FlatAmount,String ShortDescription,String SteadyDays,String discounttype,String NthNight,String DISCOUNT_DEFINITION,String Percentage,
			String FirstName,String LastName,String Email,String Cardname,String Numberoncard,String Entercountry,String Address,String Enterzipcode,String Address2,String Enterstate,String Entercity,String Enterphonenum) throws IOException, InterruptedException, ParseException
	{
		GoToUrl();
		verify_mybooking();
		currencydropdown();
		try 
		{
			arrival_date();
			departuredate();
			popup_ok();
			Rooms_and_Guests();
			select_Rooms(Enterrooms);
			Click_SpecialRate();
			SpecialRateplan_Validation();
			Click_Done();
			checkavailabitlity();
			room_type(roomtype);
			BookRoom();
		}
		catch(Exception e)
		{
			SeleniumRepo.driver.navigate().refresh();
			arrival_date();
			departure_date();
			popup_ok();
			Rooms_and_Guests();
			select_Rooms(Enterrooms);
			Click_SpecialRate();
			SpecialRateplan_Validation();
			Click_Done();
			checkavailabitlity();
			room_type(roomtype);
			BookRoom();

		}
		verify_Headingrooms();
		verify_available_offers();
		Verify_Reservationdetails();
		checkbox();
		Select_rateplan(rateplan);
		verify_Strike(AdminDay,RatePlan,FlatAmount,ShortDescription,SteadyDays,discounttype,NthNight,DISCOUNT_DEFINITION,Percentage);
		//Offerdetails_Close();
		/*
		checkbox();
		First_name(FirstName);
		Last_Name(LastName);
		Email(Email);
		extra_inforamtion();
		confirmation();
		card_information();
		card_name(Cardname);
		Card_number(Numberoncard);
		Expdate();
		Country(Entercountry);
		Billing_Address(Address, Enterzipcode, Address2, Enterstate, Entercity);
		contact(Enterphonenum);
		payment();
		verify_Thanku_page();  //this section was commented out

	}
	
	*/
	
	/**
	 * Todo: GEt ride of this method once the use case of  ReuseMethodsforDPR is understood
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void ReuseMethodsforDPRstart() throws IOException, InterruptedException, ParseException
	{
		GoToUrl();
		verify_mybooking();
		currencydropdown();
	}
	
	/**
	 * Todo: GEt ride of this method once the use case of  ReuseMethodsforDPR is understood
	 * 
	 * @param rateplan
	 * @param AdminDay
	 * @param RatePlan
	 * @param FlatAmount
	 * @param ShortDescription
	 * @param SteadyDays
	 * @param discounttype
	 * @param NthNight
	 * @param DISCOUNT_DEFINITION
	 * @param Percentage
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param Cardname
	 * @param Numberoncard
	 * @param Entercountry
	 * @param Address
	 * @param Enterzipcode
	 * @param Address2
	 * @param Enterstate
	 * @param Entercity
	 * @param Enterphonenum
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void ReuseMethodsforDPRclose(String rateplan,String AdminDay,String RatePlan,String FlatAmount,String ShortDescription,String SteadyDays,String discounttype,String NthNight,String DISCOUNT_DEFINITION,String Percentage,
			String FirstName,String LastName,String Email,String Cardname,String Numberoncard,String Entercountry,String Address,String Enterzipcode,String Address2,String Enterstate,String Entercity,String Enterphonenum) throws IOException, InterruptedException, ParseException
	{
		
		verify_Strike(AdminDay,RatePlan,FlatAmount,ShortDescription,SteadyDays,discounttype,NthNight,DISCOUNT_DEFINITION,Percentage);

		
	}
	

	/**
	 * Method attempts to verify DPR stirke through 
	 * 
	 * Todo: investigate this method and understand what its doing
	 * 
	 * @param AddressCondition
	 * @throws InterruptedException
	 */
	public void Verify_Strike(String AddressCondition) throws InterruptedException
	{
		Thread.sleep(1000);

		if(AddressCondition.equals("Exclude")||AddressCondition.equals("BlackOutDates"))
		{
			try 
			{
				if(Verify_Strike.isDisplayed())
				{
					System.out.println("DPR is  Allowed for the"+AddressCondition+" Conditions");
					test.log(Status.FAIL,"DPR is  Allowed for the"+AddressCondition+" Conditions");
					logger.error("DPR is  Allowed for the"+AddressCondition+" Conditions");

				}
			}
			catch(Exception e)
			{

				System.out.println("DPR is Not  Allowed due to "+AddressCondition+" conditions");
				test.log(Status.PASS,"DPR is Not  Allowed due to "+AddressCondition+" conditions");
				logger.info("DPR is Not  Allowed due to "+AddressCondition+" conditions");
			}
		}
		else if(AddressCondition.equals("Include"))
		{
			try
			{

				if(Verify_Strike.isDisplayed())
				{
					System.out.println("DPR is  Allowed for the Included Region");
					test.log(Status.PASS,"DPR is  Allowed for the Included Region");
					logger.info("DPR is  Allowed for the Included Region");
				}
			}
			catch(Exception e)
			{
				System.out.println("DPR is Not  Allowed for the Included Region");
				test.log(Status.FAIL,"DPR is Not Allowed for the Included Region");
				logger.error("DPR is Not  Allowed for the Included Region");
			}
		}
	}
	
	
	//this method is being used for this tc classs "TC_DPR_Include_Exclude_IP_Geographic"
	//so leave it until you explore the admin side of TC
	public void verifyDPRforBlackoutdates() throws InterruptedException
	{
		Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YYYY");
		String  Blackstartdate= df1.format(date1);
		
		Date date = new Date();
		date.setDate(date.getDate() + 2);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		String  BlackEnddate= df.format(date);
		
		arrivaldate.click();
		departuredate.clear();
		arrivaldate.sendKeys(Blackstartdate);
		Thread.sleep(1000);
		/*departuredate.click();
		departuredate.clear();
		departuredate.sendKeys(BlackEnddate);
		Thread.sleep(1000);*/
	}
	
}



