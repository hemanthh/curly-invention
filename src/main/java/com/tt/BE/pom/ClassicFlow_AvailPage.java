package com.tt.BE.pom;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Group_Blocks;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * This class will host all verifying and action based methods for TT classic
 * flow booking engine availability search page[a.k.a. classic flow landing
 * page].
 * 
 * TODO: create a date picking method that handles entering dates in arrival or
 * departure to eliminate code repetition
 * 
 * @author DM (refactored from ClasicFlow)
 *
 */
public class ClassicFlow_AvailPage extends ClasicFlow {

	// Todo: Review the comments in this class while refactoring and expanding
	// also must create a different offer code field for compound access code

	// For the webelement fields for the BE look for the Id values to add to
	// each webelement variable

	// @FindBy(xpath = "//*[@class='rooms-list']/li") experimetned with adding
	// this xpath to the findAll
	// the xpath above returns the same as below but if used together it will
	// return duplicate entry
	// because there already is a find by xpath element
	@FindAll({ @FindBy(xpath = "//*[@class='rooms-list-title ng-binding']"), })
	private List<WebElement> Roomslist;

	@FindAll({ @FindBy(xpath = "(//*[@class='rooms_price']/strong)"), })
	private WebElement price;

	@FindAll({ @FindBy(xpath = "(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)[1]"), })
	private WebElement Offercode;

	@FindAll({ @FindBy(xpath = "(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)"), })

	private List<WebElement> SpecialRateplans;

	@FindAll({ @FindBy(xpath = "//a[@id='reservation-lookup']"), @FindBy(css = "#reservation-lookup") })

	public WebElement verify_mybooking;

	@FindAll({ @FindBy(xpath = "//a[@id='currency-dropdown']"), })

	public WebElement currencydropdown;

	@FindAll({ @FindBy(xpath = "//*[@id='search_arrival_date']"), })

	public WebElement arrivaldate;

	@FindAll({ @FindBy(xpath = "//*[@id='search_departure_date']"), })

	public WebElement departuredate;

	@FindAll({ @FindBy(xpath = "//*[@id='rooms_and_guests']//span[@class='search-form-item search-form-offer'][1]"), })
	//*[@id='rooms_and_guests']
	// *[@class='selectbox-toggle'][1]/span[2] /span/div[1]/div/div[2]
	//div[@class='search-form-item relative rooms_guests_field']
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

	// *[@class='search-form-item search-form-submit']
	// *[@id='check-availability-btn']
	@FindAll({ @FindBy(xpath = "//*[@id='check-availability-btn']") })
	public WebElement Checkavailability;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Check availability')]"), })
	public WebElement CheckavailabilityPromo;

	// See if id works
	@FindAll({ @FindBy(xpath = "//span[@class='text-capitalizes']"), @FindBy(id = "special_rates_and_offer_code"),
			@FindBy(css = "body.standard-flow.ng-scope:nth-child(2) div.ng-scope:nth-child(16) div.room-page.ng-scope:nth-child(8) aside.search-form.z-index div.container.roomsSearchForm form.edit_search.ng-pristine.ng-valid.ng-isolate-scope:nth-child(4) div.search-form-item.search-form-offer:nth-child(4) a.search-form-offer-link strong:nth-child(1) > span.text-capitalizes") })
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

	@FindAll({ @FindBy(xpath = "//*[@name='search[offer_code]']"), })

	private WebElement OfferCode_textfeild;

	@FindAll({ @FindBy(xpath = "//*[@ng-hide='showRoomInfo']"), })
	// *[@class='room-view-placeholder no-rooms-avaiable-message'] -> use this
	// instead of@ng-hide=...

	private WebElement showRoomInfo;

	@FindAll({ @FindBy(xpath = "//*[@ng-bind='hotel.name']"), })
	private List<WebElement> Alternateproperty_name;

	@FindAll({ @FindBy(xpath = "//*[@ng-bind='booking.hotel.name']"), })

	private List<WebElement> BookNow_Alternateproperty_name;

	/**
	 * Creates a non-user input date of Arrival. The date will always be one day
	 * from current date
	 */
	public void arrival_date() {
		ExplicitWait(arrivaldate);

		Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YYYY");
		formattedDate1 = df1.format(date1);

		if (SeleniumRepo.isElementPresent(arrivaldate)) {
			arrivaldate.click();
			arrivaldate.clear();
			arrivaldate.sendKeys(formattedDate1);
			// System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on arrivaldate Link");
			logger.info("Clicked on arrivaldate Link");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");

		}

	}

	/**
	 * This method will take a date value from data file if the date is in the
	 * past will change to current date plus 1
	 * 
	 * @param date
	 * @throws ParseException
	 */
	public void arrival_date(String arrivalDatePicker) throws ParseException {
		ExplicitWait(arrivaldate);

		SimpleDateFormat df1;

		// Formats date based on BE customer date format
		// Create and if statement around this dictating the date format
		// arrivaldate.getAttribute("placeholder")

		if (arrivaldate.getAttribute("placeholder").equals("mm/dd/yyyy")) {
			df1 = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			df1 = new SimpleDateFormat("dd/MM/yyyy");
		}

		// Converts the String text from Data file into a Date object
		Date dateForArrival = df1.parse(arrivalDatePicker);

		// Suppose to create the current date
		Date currentDate = new Date();

		System.out.println("This is current date from arrival_date() " + currentDate);

		if (dateForArrival.before(currentDate)) {

			dateForArrival.setDate(currentDate.getDate() + 1);

		}

		formattedDate1 = df1.format(dateForArrival);

		System.out.println("This is the arrival date reformat from arrival_date() " + formattedDate1);

		if (SeleniumRepo.isElementPresent(arrivaldate)) {

			arrivaldate.click();
			arrivaldate.clear();

			TypeInField(arrivaldate, formattedDate1);

			// arrivaldate.sendKeys(formattedDate1);
			// System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on arrivaldate Link");
			logger.info("Clicked on arrivaldate Link");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");

		}

	}

	/**
	 * Creates a non-user input date of Departure. The date will always be six
	 * days from arrival date
	 */
	public void departure_date() {

		Date date = new Date();
		date.setDate(date.getDate() + 3);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		formattedDate = df.format(date);

		if (departuredate.isDisplayed()) {
			departuredate.click();
			departuredate.clear();
			TypeInField(departuredate, formattedDate);
			// departuredate.sendKeys(formattedDate);
			// System.out.println("departuredate is entered successfully");
			logger.info("departuredate is entered successfully");
			test.log(Status.INFO, "departuredate is entered successfully");

		} else {
			// System.out.println("departuredate TextBox not found");
			logger.error("departuredate TextBox not found");
			test.log(Status.FAIL, "departuredate TextBox not found");

		}
	}

	/**
	 * This method will take a departure date value from data file if the date
	 * is in the past, the method will change the date to current date plus 6
	 * 
	 * @param departureDatePicker
	 * @throws ParseException
	 */
	public void departure_date(String departureDatePicker) throws ParseException {

		SimpleDateFormat df1;

		if (departuredate.getAttribute("placeholder").equals("mm/dd/yyyy")) {
			df1 = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			df1 = new SimpleDateFormat("dd/MM/yyyy");
		}

		// Formats date based on BE customer date format
		df1 = new SimpleDateFormat(departuredate.getAttribute("placeholder"));

		// Converts the String text from Data file into a Date object
		Date dateForDeparture = df1.parse(departureDatePicker);

		// Suppose to create the current date
		Date currentDate = new Date();

		System.out.println("This is current date from departure_date() " + currentDate);

		// will use this attriute to find out the date format
		System.out.println(departuredate.getAttribute("placeholder"));

		if (dateForDeparture.before(currentDate)) {

			dateForDeparture.setDate(currentDate.getDate() + 6);
		}

		formattedDate1 = df1.format(dateForDeparture);

		System.out.println("This is the departure date reformat from departure_date() " + formattedDate1);

		if (departuredate.isDisplayed()) {
			departuredate.click();
			departuredate.clear();
			TypeInField(departuredate, formattedDate1);
			// departuredate.sendKeys(formattedDate1);
			System.out.println("departuredate is entered successfully");
			logger.info("departuredate is entered successfully");
			test.log(Status.INFO, "departuredate is entered successfully");

		} else {
			// System.out.println("departuredate TextBox not found");
			logger.error("departuredate TextBox not found");
			test.log(Status.FAIL, "departuredate TextBox not found");

		}
	}

	public void sameDayBookingDates(String los) throws InterruptedException {
		ExplicitWait(arrivaldate);

		SimpleDateFormat df1;

		Date dateForArrival = new Date();
		Date dateForDeparture = new Date();

		if (arrivaldate.getAttribute("placeholder").equals("mm/dd/yyyy")) {
			df1 = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			df1 = new SimpleDateFormat("dd/MM/yyyy");
		}

		// dateForArrival.setDate(dateForArrival.getDate());
		dateForDeparture.setDate(dateForDeparture.getDate() + Integer.parseInt(los));

		formattedDate1 = df1.format(dateForArrival);

		System.out.println("the date is arrival date  " + formattedDate1);

		if (SeleniumRepo.isElementPresent(arrivaldate)) {
			arrivaldate.click();
			arrivaldate.clear();
			// TypeInField(arrivaldate, formattedDate1);

			arrivaldate.sendKeys(formattedDate1);
			// System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on arrivaldate Link");
			logger.info("Clicked on arrivaldate Link");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");

		}

		String formattedDate2 = df1.format(dateForDeparture);

		System.out.println("the date is departure date  " + formattedDate2);

		if (SeleniumRepo.isElementPresent(departuredate)) {
			departuredate.click();
			departuredate.clear();
			// TypeInField(departuredate, formattedDate1);

			departuredate.sendKeys(formattedDate2);
			System.out.println(formattedDate2);
			test.log(Status.INFO, "Clicked on departure date Link");
			logger.info("Clicked on departure date Link");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("departure date TextBox not found");
			test.log(Status.FAIL, "departure date TextBox not found");

		}

	}

	public void sameDayBookingArrivalDate() throws InterruptedException {

		ExplicitWait(arrivaldate);

		SimpleDateFormat df1;

		Date dateForArrival = new Date();

		// Formats date based on BE customer date format
		// Determines the date format based on the arrivaldate Attribute
		// "placeholder"
		if (arrivaldate.getAttribute("placeholder").equals("mm/dd/yyyy")) {
			df1 = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			df1 = new SimpleDateFormat("dd/MM/yyyy");
		}

		formattedDate1 = df1.format(dateForArrival);

		System.out.println("the date is arrival date  " + formattedDate1);

		if (SeleniumRepo.isElementPresent(arrivaldate)) {
			arrivaldate.click();
			arrivaldate.clear();
			TypeInField(arrivaldate, formattedDate1);

			// arrivaldate.sendKeys(formattedDate1);
			// System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on arrivaldate Link");
			logger.info("Clicked on arrivaldate Link");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");

		}

	}

	public void sameDayBookingDepartureDate(String los) throws InterruptedException {
		ExplicitWait(departuredate);

		SimpleDateFormat df1;
		// SimpleDateFormat df2;

		Date dateForDeparture = new Date();

		// Formats date based on BE customer date format
		// Create and if statement around this dictating the date format
		// arrivaldate.getAttribute("placeholder")

		if (arrivaldate.getAttribute("placeholder").equals("mm/dd/yyyy")) {
			df1 = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			df1 = new SimpleDateFormat("dd/MM/yyyy");
		}

		dateForDeparture.setDate(dateForDeparture.getDate() + Integer.parseInt(los));

		formattedDate1 = df1.format(dateForDeparture);

		System.out.println("the date is departure date  " + formattedDate1);

		SeleniumRepo.WaitForLoad(500);

		if (SeleniumRepo.isElementPresent(departuredate)) {
			departuredate.click();
			departuredate.clear();
			// TypeInField(departuredate, formattedDate1);

			departuredate.sendKeys(formattedDate1);
			// System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on departure date Link");
			logger.info("Clicked on departure date Link");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("departure date TextBox not found");
			test.log(Status.FAIL, "departure date TextBox not found");

		}

	}

	public void maxLosBooking(String arrivalDate, String MaxLos) throws InterruptedException, ParseException {
		ExplicitWait(arrivaldate);

		SimpleDateFormat df1;

		if (arrivaldate.getAttribute("placeholder").equals("mm/dd/yyyy")) {
			df1 = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			df1 = new SimpleDateFormat("dd/MM/yyyy");
		}

		// Converts the String text from Data file into a Date object
		Date dateForArrival = df1.parse(arrivalDate);

		Date dateForDeparture = new Date();

		// Suppose to create the current date
		Date currentDate = new Date();

		if (dateForArrival.before(currentDate)) {

			dateForArrival.setDate(currentDate.getDate() + 1);

		}

		dateForDeparture.setDate(dateForArrival.getDate() + Integer.parseInt(MaxLos));

		formattedDate1 = df1.format(dateForArrival);

		System.out.println("the date is arrival date  " + formattedDate1);

		if (SeleniumRepo.isElementPresent(arrivaldate)) {
			arrivaldate.click();
			arrivaldate.clear();
			// TypeInField(arrivaldate, formattedDate1);

			arrivaldate.sendKeys(formattedDate1);
			// System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on arrivaldate Link and enter Max LOS start date");
			logger.info("Clicked on arrivaldate Link for Max LOSt start date");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");

		}

		String formattedDate2 = df1.format(dateForDeparture);

		System.out.println("the date is departure date  " + formattedDate2);

		if (SeleniumRepo.isElementPresent(departuredate)) {
			departuredate.click();
			departuredate.clear();
			// TypeInField(departuredate, formattedDate1);

			departuredate.sendKeys(formattedDate2);
			System.out.println(formattedDate2);
			test.log(Status.INFO, "Clicked on departure date Link and enter LOS last date");
			logger.info("Clicked on departure date Link  and enter LOS last date");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("departure date TextBox not found");
			test.log(Status.FAIL, "departure date TextBox not found");

		}

	}

	public void arivalDepartureDateAutoPicks(String leadTime, String LenOfSty) throws InterruptedException {
		ExplicitWait(arrivaldate);

		SimpleDateFormat df1;
		Date arrivalDate  = new Date();
		Date departureDate  = new Date();
		

		if (departuredate.getAttribute("placeholder").equals("mm/dd/yyyy")) {
			df1 = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			df1 = new SimpleDateFormat("dd/MM/yyyy");
		}

		arrivalDate.setDate(arrivalDate .getDate() + Integer.parseInt(leadTime));
		formattedDate1 = df1.format(arrivalDate );
		
		System.out.println("auto date arrival " +  formattedDate1 + " Leadtime is " + leadTime + " los is " + LenOfSty);

		if (SeleniumRepo.isElementPresent(arrivaldate)) {
			arrivaldate.click();
			arrivaldate.clear();
			arrivaldate.sendKeys(formattedDate1);
			// System.out.println(formattedDate1);
			test.log(Status.INFO, "Clicked on arrivaldate Link to enter a date based on lead time from current date ");
			logger.info("Clicked on arrivaldate Link to enter a date based on lead time from current date");

		} else {
			// System.out.println("arrivaldate TextBox not found");
			logger.error("arrivaldate TextBox not found");
			test.log(Status.FAIL, "arrivaldate TextBox not found");

		}

		departureDate.setDate( (departureDate .getDate() + Integer.parseInt(leadTime) ) + Integer.parseInt(LenOfSty));
		String formattedDate1New = df1.format(departureDate );
		
		//String formattedDate2 = df1.format(dateForDeparture);


		System.out.println("auto date deparature " +  formattedDate1New + " Leadtime is " + leadTime + " los is " + LenOfSty);
		
		System.out.println("Date1 aka arrival date in date " + arrivalDate + "  Departure date  " + departureDate  );

		
		if (departuredate.isDisplayed()) {
			departuredate.click();
			departuredate.clear();
			// TypeInField(departuredate, formattedDate);
			departuredate.sendKeys(formattedDate1New);
			// System.out.println("departuredate is entered successfully");
			logger.info("departuredate is entered successfully based on lenght of stay");
			test.log(Status.INFO, "departuredate is entered successfully based on lenght of stay");

		} else {
			// System.out.println("departuredate TextBox not found");
			logger.error("departuredate TextBox not found");
			test.log(Status.FAIL, "departuredate TextBox not found");

		}

		logger.info(
				"Auto selected arrival and departure dates based on Lead time and Lenght of Stay from Current date");
		test.log(Status.PASS,
				"Auto selected arrival and departure dates based on Lead time and Lenght of Stay from Current date");

	}

	/**
	 * Click "Rooms & Guest" button on classic BE. Refactor: Might change to a
	 * verify method
	 */
	public void Rooms_and_Guests(String Enterrooms) {
		ExplicitWait(roomsandguests);
		if (roomsandguests.isDisplayed()) {
			roomsandguests.click();
			// System.out.println("roomsandguests popup opened successfully");
			logger.info("roomsandguests popup opened successfully");
			test.log(Status.PASS, "roomsandguests popup opened successfully");

		} else {
			// System.out.println("roomsandguests popup not found");
			logger.error("roomsandguests popup  not found");
			test.log(Status.FAIL, "roomsandguests popup  not found");

		}
		
		if (select_rooms.isEnabled()) {
			// select_rooms.isDisplayed();
			/*
			 * select_rooms.click(); SeleniumRepo.WaitForLoad(100);
			 */
			SeleniumRepoDropdown.selectDropDownValue(select_rooms, Enterrooms);
			logger.info("rooms selected");
			test.log(Status.PASS, "rooms selected");

		} else {
			// System.out.println("Unable to select rooms");
			logger.error("Unable to select rooms");
			test.log(Status.FAIL, " Unable to select rooms");

		}
		
		
	}

	/**
	 * This method acutally click the Rooms and Guests link which causes the
	 * popup to appear. Then goes through the process of selecting adults and
	 * children for the room based on the number of rooms being booked.
	 * 
	 * Refactored: The forloop used to change the values for adults/children
	 * amount was using a variable that only returned 1. So added a variable
	 * based on the rooms being requested
	 * 
	 * Future change: Will look into taking parts of this method and creating
	 * new methods for example select rooms(can be its own method) and a
	 * selecting guest methods. This will also help with PPP
	 * 
	 * @param Enterrooms
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void select_Rooms(String Enterrooms) throws InterruptedException, IOException {

		//ExplicitWait(select_rooms);
		//roomsandguests.click();

		int numberOfRooms = Integer.parseInt(Enterrooms);
		System.out.println("guest rooms   " + numberOfRooms);

		// Not sure what this is meant for but it will always return 1
		int adultslength = Listselect_adults.size();
		System.out.println("guest rooms sdult size  " + adultslength);

		for (int j = 1; j <= numberOfRooms; j++) {
			System.out.println("This is the value of j = " + j);

			String minnoofadults = ReadProperties.getPropValues("Admin.properties", "MINnoofadults");
			String maxnoofadults = ReadProperties.getPropValues("Admin.properties", "MAXnoofadults");
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'adults-in-room')])[" + j + "]"))
					.isDisplayed()) {
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'adults-in-room')])[" + j + "]"))
						.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(Integer.parseInt(minnoofadults),
								Integer.parseInt(maxnoofadults))));
				// System.out.println("adults is entered successfully");
				logger.info("adults is entered successfully");
				test.log(Status.INFO, "adults is entered successfully");

			} else {
				// System.out.println("adults dropdown not found");
				logger.error("adults dropdown not found");
				test.log(Status.FAIL, "adults dropdown not found");

			}
		}

		// NOt sure how this is suppouse to work with the for loop below but it
		// will always have a value of 1
		int childrenslength = Listselect_childrens.size();
		// System.out.println(childrenslength);

		for (int i = 1; i <= numberOfRooms; i++) {
			System.out.println("This is the value of i = " + i);

			String minnoofchildrens = ReadProperties.getPropValues("Admin.properties", "MINnoofchildrens");
			String maxnoofchildrens = ReadProperties.getPropValues("Admin.properties", "MAXnoofchildrens");
			if (SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'children-in-room')])[" + i + "]"))
					.isDisplayed()) {
				SeleniumRepo.driver.findElement(By.xpath("(//*[starts-with(@id,'children-in-room')])[" + i + "]"))
						.sendKeys(Integer.toString(SeleniumRepo.getRandomNumberInRange(
								Integer.parseInt(minnoofchildrens), Integer.parseInt(maxnoofchildrens))));
				// System.out.println("childrens is entered successfully");
				logger.info("childrens is entered successfully");
				test.log(Status.INFO, "childrens is entered successfully");

			}
		}

		Thread.sleep(2000);
		if (roomselectiondone.isEnabled()) {
			roomselectiondone.isDisplayed();
			roomselectiondone.click();
			SeleniumRepo.waitForPageLoaded();
			Thread.sleep(5000);
			// System.out.println("Clicked on done");
			logger.info("Clicked on done");
			test.log(Status.INFO, "Clicked on done");
		}

		else {
			// System.out.println("Done Button Not found");
			logger.error("Done Button Not found");
			test.log(Status.FAIL, "Done Button Not found");

		}
	}

	/**
	 * Clicks the check availability button on the BE
	 * 
	 * Note: Will change this method name checkavailability to
	 * click_CheckavailabitlityButton
	 * 
	 */
	public void click_CheckavailabitlityButton() {

		System.out.println("Inside of the checkavailabitlity");

		/*
		 * ExplicitWait(Checkavailability);
		 * 
		 * 
		 * Javascriptexecutor(Checkavailability);
		 * //System.out.println("clicked on Checkavailability");
		 * SeleniumRepo.waitForPageLoaded();
		 * logger.info("clicked on Checkavailability"); test.log(Status.INFO,
		 * "clicked on Checkavailability");
		 * 
		 */

		ExplicitWait(Checkavailability);

		if (Checkavailability.isDisplayed()) {

			Checkavailability.click();
			// Javascriptexecutor(Checkavailability);

			System.out.println("clicked on Checkavailability");

			SeleniumRepo.waitForPageLoaded();
			//ExplicitWait(Checkavailability);

			logger.info("clicked on Checkavailability");
			test.log(Status.INFO, "clicked on Checkavailability");

		} else {

			// System.out.println("BookNow button not found");
			logger.error("Check Availability button not found");
			test.log(Status.FAIL, "Check Availability button not found");

		}

		SeleniumRepo.waitForPageLoaded();

	}

	public void click_CheckavailabitlityPromoButton() {

		System.out.println("Inside of the Check availability promo");

		/*
		 * ExplicitWait(Checkavailability);
		 * 
		 * 
		 * Javascriptexecutor(Checkavailability);
		 * //System.out.println("clicked on Checkavailability");
		 * SeleniumRepo.waitForPageLoaded();
		 * logger.info("clicked on Checkavailability"); test.log(Status.INFO,
		 * "clicked on Checkavailability");
		 * 
		 */

		ExplicitWait(CheckavailabilityPromo);

		if (CheckavailabilityPromo.isDisplayed()) {

			// Checkavailability.click();
			Javascriptexecutor(CheckavailabilityPromo);

			System.out.println("clicked on Checkavailability on Promo page");

			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(Checkavailability);

			logger.info("clicked on Check availCheck availability Promo button");

		} else {

			// System.out.println("BookNow button not found");
			logger.error("Check Availability button not found");
			test.log(Status.FAIL, "Check Availability button not found");

		}

	}

	/**
	 * Note: This Method is used with roomprice(String RoomType) method , these
	 * method are used to test FBP TC
	 * 
	 * @param After_offerprice
	 * @param Before_offerprice
	 */
	public void roomprice_validation(String After_offerprice, String Before_offerprice) {
		// System.out.println("Before offer price is "+Before_offerprice);
		// System.out.println("After offer price is "+After_offerprice);

		if (!(After_offerprice.equals(Before_offerprice))) {
			// System.out.println("Offer code applied successfully and room
			// price chnaged according to the offer");

			logger.info("Offer code applied successfully and room price chnaged according to the offer");
			test.log(Status.PASS, "Offer code applied successfully and room price changed according to the offer");

		} else {
			// System.out.println("After offer code applied room price not
			// changed");
			// logger.error("After offer code applied room price not changed");
			// test.log(Status.FAIL, "After offer code applied room price not
			// changed");

		}
	}

	/**
	 * Note: This Method is used with roomprice_validation (String
	 * After_offerprice ,String Before_offerprice ) method , these method are
	 * used to test FBP. This method specifically captures/returns the price of
	 * the roomtype passed
	 * 
	 * 
	 */
	public String roomprice(String RoomType) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("total rooms are" + Roomslist.size());
		// //*[@class='rooms-list']/li
		for (int i = 0; i < Roomslist.size(); i++) {
			int j = i + 1;
			// System.out.println(RoomType);
			String Roomname = Roomslist.get(i).getText();
			// System.out.println("room name is " +Roomname);
			if (RoomType.contains(Roomname)) {
				// System.out.println("Room names are matched");
				logger.info("Room names are matched");
				test.log(Status.INFO, "Room names are matched");

				/*
				 * Need to use the SeleniumRepo click method its basically what
				 * the three lines blow is attempting
				 */
				WebElement room = SeleniumRepo.driver
						.findElement(By.xpath("(//div[@ng-switch='room.brg'])[" + j + "]"));

				JavascriptExecutor js = (JavascriptExecutor) SeleniumRepo.driver;
				js.executeScript("arguments[0].click();", room);

				Thread.sleep(3000);
				Before_Offerprice = price.getText();
				// System.out.println("price is"+Before_Offerprice);
				break;
			}

		}
		// rename this variable because name can confused ppl
		return Before_Offerprice;

	}

	/**
	 * This method just clicks the special and rate link ont he BE and conpare
	 * the links text to the popup's title to confirm the popup appeard
	 * 
	 * Refactor idea : also verify if the close button appears as well as the
	 * done
	 * 
	 * @throws InterruptedException
	 */
	public void Click_SpecialRate() throws InterruptedException {
		ExplicitWait(Click_SpecialRate);
		if (Click_SpecialRate.isDisplayed()) {
			String offercodetitle = Click_SpecialRate.getText();
			// System.out.println(offercodetitle);
			try {
				Click_SpecialRate.click();
			} catch (Exception e) {
				Javascriptexecutor(Click_SpecialRate);
			}
			Thread.sleep(3000);
			// System.out.println("Text obtained in title is "+offercodetitle);
			if (offercodetitle.contains("Special rate")) {
				// System.out.println("Expected text Special_rate is obtained");
				logger.info("Expected text Special_rate is obtained");
				test.log(Status.INFO, "Expected text Special_rate is obtained");
			} else {
				// System.out.println("Expected text is not obtained");
				logger.error("Special rate Text is matched");
				test.log(Status.FAIL, "Special rate Text is matched");
			}

			// The below code takes the title of the Special rate popup title to
			// the link that causes
			// the popup to appear
			// this was breaking for some reason -> ExplicitWait(Modeltitle);
			// similarly to TC_yankeeflow_new_modify_cancelbooking offercode()
			// mehod

			Thread.sleep(5000);

			if (Modeltitle.isDisplayed()) {
				String ofercodepopuptitle = Modeltitle.getText();
				// System.out.println("Text obtained in title is
				// "+ofercodepopuptitle);
				if (ofercodepopuptitle.equalsIgnoreCase(offercodetitle)) {
					// System.out.println(offercodetitle+ "title is matching
					// with the popup title");
				}

				logger.info("modalTitle Element is present");
				test.log(Status.INFO, "modalTitle Element is present");

			} else {
				// System.out.println("modalTitle Element is not present");
				logger.error("modalTitle Element is not present");
				test.log(Status.FAIL, "modalTitle Element is not present");

			}

		} else {
			// System.out.println("Special rate element is not present");
			logger.error("Special rate element is not present");
			test.log(Status.FAIL, "Special rate element is not present");

		}

	}

	/**
	 * this method enters the accesscode into the offer code field on the BE and
	 * waits for the page to adjust
	 * 
	 * @param Accesscode
	 * @throws InterruptedException
	 */
public void Accesscode_sendkeys(String Accesscode) throws InterruptedException
	{
		try {
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
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Method is used to click a room on the BE
	 * 
	 */
	public void room_type(String roomtype) throws InterruptedException {
		WebElement Room = SeleniumRepo.driver.findElement(
				By.xpath("//span[contains(text(),'" + roomtype + "') and @class='rooms-list-title ng-binding']"));

		Javascriptexecutor(Room);
		Thread.sleep(1000);
		logger.info("Clicked on " + roomtype + " room");
		test.log(Status.INFO, "Clicked on " + roomtype + " room");

	}

	/**
	 * This must be used with multi room booking. This method clicks the
	 * "Selelct Room" button then selects teh same room for each room
	 * 
	 * Refactoring ideas: 1. allow this method to selelct a different room for a
	 * mulit room booking 2. change the name to multiRoom_selectRoom()
	 * 
	 */
	public void selectroom() throws InterruptedException {
		// ExplicitWait(Select_Room);
		SeleniumRepo.waitForElementPresent(Select_Room);

		if (Select_Room.isDisplayed()) {
			Select_Room.click();
			Thread.sleep(3000);
			System.out.println("Clicked on select room");
			logger.info("Clicked on select room");
			test.log(Status.INFO, "Clicked on select room");

		} else {
			System.out.println("Unable to Click on select room");
			logger.error("Unable to Click on select room");
			test.log(Status.FAIL, "Unable to Click on select room");
		}

		// Thread.sleep(2000);
		int roomlength = rooms.size();
		System.out.println("What is room size " + roomlength);
		Thread.sleep(3000);

		// This for loop selects the same room for a multi room booking. Inorder
		// to change it
		// must handel the selection of a different room which clasp the select
		// room dropdown
		for (int L = 1; L <= roomlength; L++) {

			if (SeleniumRepo.driver.findElement(By.xpath("(//ul[@class='rooms-selector-list']//li)[" + L + "]/a"))
					.isDisplayed()) {
				SeleniumRepo.driver.findElement(By.xpath("(//ul[@class='rooms-selector-list']//li)[" + L + "]/a"))
						.click();
				Thread.sleep(4000);

				// System.out.println("room "+L+" selected successfully");
				logger.info("rooms selected successfully");
				test.log(Status.INFO, "rooms selected successfully");

			} else {
				// System.out.println("rooms not selected successfully");
				logger.error("rooms not selected successfully");
				test.log(Status.FAIL, "rooms not selected successfully");

			}
		}
	}

	/**
	 * Clicks the booknow button
	 * 
	 * Refactor: will change the method to click_BookNow
	 */
	public void BookRoom() throws InterruptedException {
		ExplicitWait(Booknow);

		Thread.sleep(2000);
		if (Booknow.isEnabled()) {
			Booknow.isDisplayed();
			Javascriptexecutor(Booknow);

			// System.out.println("Clicked on Booknow");
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(verify_Headingrooms);
			logger.info("Clicked on Booknow");
			test.log(Status.INFO, "Clicked on Booknow");

		} else {
			// System.out.println("BookNow button not found");
			logger.error("BookNow button not found");
			test.log(Status.FAIL, "BookNow button not found");

		}
	}

	/**
	 * This method goes through each speical rate listed and and confirm it
	 * appears
	 * 
	 * Refactoring ideas: Will use create another method like this that selects
	 * an speical rate offer 2. will include and attempt to validate other
	 * fields that/if appear within the special rate popup
	 */
	public void SpecialRateplan_Validation() throws InterruptedException {
		Thread.sleep(3000);

		ExplicitWait(Offercode);
		int No_of_offercdes = SpecialRateplans.size();
		// System.out.println(No_of_offercdes+" offer codes are available");
		for (int i = 1; i <= No_of_offercdes; i++) {

			// Confirms the xpath being used actually works
			WebElement Specialrateplan = SeleniumRepo.driver.findElement(
					By.xpath("(//input[@class='custom-radio-checkbox ng-isolate-scope none-outline']/..)[" + i + "]"));

			if (Specialrateplan.isDisplayed()) {
				String offercode = Specialrateplan.getText();
				//// System.out.println(offercode);
				// System.out.println("Offer code present at "+i+" radio button
				//// SPECIAL RATES & OFFER CODE is "+offercode);
				test.log(Status.INFO, "Obtained text is displayed successfully");

			}
		}
	}

	/**
	 * 
	 * Refactoring ideas: Will use create another method like this that selects
	 * an speical rate offer at random thus no input is required
	 */
	public void SpecialRateplan_selection(String Rateplan) throws InterruptedException {
		if (SeleniumRepo.driver.findElement(By.xpath("//label[text()='" + Rateplan + "']")).isDisplayed()) {
			SeleniumRepo.driver.findElement(By.xpath("//label[text()='" + Rateplan + "']")).click();
			// System.out.println("Rateplan selected successfully");
			test.log(Status.INFO, "Rateplan selected successfully");

			Thread.sleep(2000);
			if (Specialdone.isDisplayed()) {
				Specialdone.click();
				SeleniumRepo.waitForPageLoaded();
				// System.out.println("Clicked on done");
				logger.info("Clicked on done");
				test.log(Status.INFO, "Clicked on done");

			} else {
				// System.out.println("not Clicked on done");
				logger.error("not Clicked on done");
				test.log(Status.FAIL, "not Clicked on done");

			}

		} else {
			test.log(Status.FAIL, "Element is not present");

		}
	}

	/**
	 * Note: Need to change this to address the fact it belongs to "special
	 * rate" popup
	 */
	public void Click_Done() {
		ExplicitWait(Specialdone);
		if (Specialdone.isDisplayed()) {
			Javascriptexecutor(Specialdone);
			ExplicitWait(Checkavailability);
			// System.out.println("Clicked on Special Rate plan done button ");
			logger.info("Clicked on Special Rate plan done button");
			test.log(Status.INFO, "Clicked on Special Rate plan done button");

		} else {
			// System.out.println("Special Rate plan done button not found");
			logger.error("Special Rate plan done button not found");
			test.log(Status.FAIL, "Special Rate plan done button not found");

		}
	}

	/**
	 * This verify method scans each available room
	 */
	public void verify_Roomsavailable(String SelectProperty) throws InterruptedException {
		Thread.sleep(2000);
		if (Roomslist.size() > 0) {
			logger.info("Rooms and rates are available for the property " + SelectProperty);
			test.log(Status.PASS, "Rooms and rates are available for the property " + SelectProperty);

			for (int i = 0; i < Roomslist.size(); i++) {
				test.log(Status.INFO,
						Roomslist.get(i).getText() + " room is available for the property " + SelectProperty);
				logger.info(Roomslist.get(i).getText() + " room is available for the property " + SelectProperty);
			}

		} else {
			logger.error(SelectProperty + " property is not displaying any room");
			test.log(Status.FAIL, SelectProperty + " property is not displaying any room");
		}
	}

	/**
	 * Todo: Review This methods address alternative property booking
	 */
	public void verify_Alternateproperty(String[] propertynames) {
		List<String> lst = new ArrayList<String>();
		for (WebElement propertys : Alternateproperty_name) {
			lst.add(propertys.getText());
		}
		for (int i = 0; i < propertynames.length; i++) {
			if (lst.contains(propertynames[i])) {
				test.log(Status.PASS, "Alternate Property " + propertynames[i] + " displayed successfully");
				logger.info("Alternate Property " + propertynames[i] + " displayed successfully");
			} else {
				test.log(Status.FAIL, "Alternate Property " + propertynames[i] + "  not found in Booking Engine");
				logger.error("Alternate Property " + propertynames[i] + "  not found in Booking Engine");
			}
		}
	}

	/**
	 * Todo: Review This methods address alternative property booking
	 */
	public void Select_Alternateproperty_BookNow(String SelectProperty) {
		for (WebElement propertys : Alternateproperty_name) {
			if (propertys.isDisplayed()) {
				if (propertys.getText().equals(SelectProperty)) {
					propertys.click();
					test.log(Status.INFO, SelectProperty + " property selected successfully");
					logger.info(SelectProperty + " property selected successfully");
				}
			} else {
				test.log(Status.FAIL, SelectProperty + "  property not found ");
				logger.error(SelectProperty + " property not found ");
			}
		}
		/*
		 * try {
		 * ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"
		 * +SelectProperty+"' and @ng-bind='booking.hotel.name'])[1]")));
		 * WebElement
		 * Booking_Propoertyname=SeleniumRepo.driver.findElement(By.xpath(
		 * "(//*[text()='"+
		 * SelectProperty+"' and @ng-bind='booking.hotel.name'])[1]"));
		 * 
		 * test.log(Status.PASS,
		 * SelectProperty+" property displayed on Map Successfully");
		 * logger.info(SelectProperty+" property displayed on Map Successfully"
		 * );
		 * 
		 * test.log(Status.FAIL, SelectProperty+"  property not found on Map ");
		 * logger.error(SelectProperty+" property not found on Map"); }
		 * catch(Exception e) { WebElement
		 * Booking_Propoertyname=SeleniumRepo.driver.findElement(By.xpath(
		 * "(//*[text()='"+
		 * SelectProperty+"' and @ng-bind='booking.hotel.name'])[2]"));
		 * 
		 * if(Booking_Propoertyname.isDisplayed()) { test.log(Status.PASS,
		 * SelectProperty+" property displayed on Map Successfully");
		 * logger.info(SelectProperty+" property displayed on Map Successfully"
		 * ); } else { test.log(Status.FAIL,
		 * SelectProperty+"  property not found on Map ");
		 * logger.error(SelectProperty+" property not found on Map"); } }
		 */
	}

	/**
	 * Todo: Review This methods address alternative property booking
	 * 
	 */
	public void Click_BookNow_AlternateProperty(String SelectProperty) {
		try {

			WebElement BookNow = SeleniumRepo.driver.findElement(By.xpath(
					"(//div[text()='" + SelectProperty + "'])[1]/following-sibling::a[contains(text(),'Book now')]"));

			Javascriptexecutor(BookNow);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(arrivaldate);

			test.log(Status.PASS, "Clicked on Book Now for the property " + SelectProperty);
			logger.info("Clicked on Book Now for the property " + SelectProperty);

		} catch (Exception e) {
			WebElement BookNow = SeleniumRepo.driver.findElement(By.xpath(
					"(//div[text()='" + SelectProperty + "'])[2]/following-sibling::a[contains(text(),'Book now')]"));

			Javascriptexecutor(BookNow);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(arrivaldate);

			test.log(Status.PASS, "Clicked on Book Now for the property " + SelectProperty);
			logger.info("Clicked on Book Now for the property " + SelectProperty);

		}
	}

	/**
	 * Confirms the no availability message appears
	 * 
	 */
	public void Verify_UnfortunatelyMessage() throws InterruptedException {
		ExplicitWait(Checkavailability);
		Thread.sleep(3000);
		if (showRoomInfo.getText().contains("Unfortunately, there are no available rooms.")
				|| (showRoomInfo.getText().contains("Or try our partner hotels below."))
				|| (showRoomInfo.getText().contains("Please try adjusting your search criteria."))) {
			// System.out.println("After Closing the room/rate using House
			// Control ,rooms are not showing in Booking Engine ");
			logger.info("After Closing the room/rate using House Control ,rooms  are not showing in Booking Engine ");
			test.log(Status.PASS,
					"After Closing the room/rate using House Control ,rooms  are not showing in Booking Engine ");
		} else {
			logger.error("Room/rate are not closed properly in Admin");
			test.log(Status.FAIL, "Room/rate are not closed properly in Admin");
		}
	}

	/**
	 * Todo: GEt ride of this method once the use case of ReuseMethodsforDPR in
	 * ClasicFlow class is understood
	 */
	public void ReuseMethodsforDPRcheckavailabitlity(String Enterrooms, String roomtype)
			throws IOException, InterruptedException, ParseException {

		try {
			arrival_date();
			departure_date();
			popup_ok();
			Rooms_and_Guests(Enterrooms);
			select_Rooms(Enterrooms);
			Click_SpecialRate();
			SpecialRateplan_Validation();
			Click_Done();
			click_CheckavailabitlityButton();
			room_type(roomtype);
			BookRoom();
		} catch (Exception e) {
			SeleniumRepo.driver.navigate().refresh();
			arrival_date();
			departure_date();
			popup_ok();
			Rooms_and_Guests(Enterrooms);
			select_Rooms(Enterrooms);
			Click_SpecialRate();
			SpecialRateplan_Validation();
			Click_Done();
			click_CheckavailabitlityButton();
			room_type(roomtype);
			BookRoom();

		}

	}

}
