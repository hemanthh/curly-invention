package com.tt.BE.pom;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.tt.utility.SeleniumRepo;

/**
 * This class will host all verifying and action based methods for TT classic
 * flow booking engine Reservation Details Page.
 *
 * @author DM (refactored from ClasicFlow)
 *
 */
public class ClassicFlow_ReservationDetailsPage extends ClasicFlow {

	@FindAll({
			@FindBy(xpath = "//*[contains(text(),'Available offers')]/../following-sibling::ul/li/label/span[3]/strong"), })

	private List<WebElement> Available_Offers;

	@FindAll({ @FindBy(xpath = "//*[@id='wrapper']/aside/div/nav/strong"), })

	public WebElement verify_Reservation;

	@FindAll({ @FindBy(xpath = "//div[@class='inline-block']"), })

	public WebElement verify_Guest;

	@FindAll({
			@FindBy(xpath = "//body[@class='standard-flow ng-scope']/div[@id='wrapper']/section[@class='container main-container z-index']/div[@class='main-container-content']/form[@id='edit_booking_5bae00d886ae77014cf05627']/fieldset/div[@class='horizontal-block']/div[@class='room-details room-details-col room-details-odd']/fieldset[@class='ng-scope room-same-guests']/div[3]"), })

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

	@FindBy(xpath = "//*[@id='is_opted_in']")
	public WebElement click_iwouldlike;
	// fieldset[@class='ng-scope room-same-guests']//div//input[2]

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

	@FindAll({ @FindBy(xpath = "//*[text()='GRAND TOTAL:']/following-sibling::td"), })

	private WebElement GrandTotalAmount;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Grand total:')]"), })

	public WebElement verify_paymentgrandtotal;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'ROOM CHARGES:')]"), })

	public WebElement verify_roomcharges;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Room charges:')]"), })

	public WebElement verify_paymentroomcharges;

	@FindAll({ @FindBy(xpath = "//button[@class='button none-outline']"), })

	public WebElement confirmation;

	@FindAll({ @FindBy(xpath = "//*[@id='offer-details-title']"), })
	public WebElement Verify_OfferDetailsTitle;

	@FindAll({ @FindBy(xpath = "//*[@id='offer-details-close']"), })
	public WebElement OfferDetails_Close;

	@FindAll({ @FindBy(xpath = "(//*[@ng-bind='d.dates'])[1]"), })
	public WebElement FirstRatedetails;

	@FindAll({ @FindBy(xpath = "(//*[@ng-bind='d.dates'])"), })
	public List<WebElement> LastRatedetails;

	@FindAll({ @FindBy(xpath = "//div[@class='sixth-block-toggle']/div/div[1]") })
	public WebElement extraInfo_Section_toggling;

	@FindAll({ @FindBy(xpath = "(//div[@class='addons gpref']) ") })
	public List<WebElement> allExtraInfoQuestinos;

	@FindAll({ @FindBy(xpath = "(//div[@class='addons gpref' and @data-type='FreeText'])") })
	public List<WebElement> extraInfoQuestinos_FreeText;

	/**
	 * Closes the offer details popup
	 * 
	 * @throws InterruptedException
	 */
	public void Offerdetails_Close() throws InterruptedException {
		Thread.sleep(2000);
		OfferDetails_Close.click();
		ExplicitWait(Enter_Firstname);
	}

	/**
	 * Verifies the headings on the reservation details page such as "start
	 * over", "roooms link". Refactor idea: break down to individual methods to
	 * represent each item and create click base methods for them
	 */
	public void verify_Headingrooms() throws InterruptedException {
		Thread.sleep(2000);
		ExplicitWait(verify_Headingrooms);
		String heading = verify_Headingrooms.getText();
		// System.out.println("Text obtained is"+heading);
		if (heading.contains("Rooms")) {
			// System.out.println("Expected text "+heading+ " is obtained");
			logger.info("Element is present");
			test.log(Status.INFO, "Verified Headingrooms");

		} else {

			logger.error("Headingrooms not found");
			test.log(Status.FAIL, "Headingrooms not found");

		}

		String reservation = verify_Reservation.getText();
		// System.out.println("Text obtained is"+reservation);
		if (reservation.contains("Reservation details")) {
			// System.out.println("Expected text "+reservation+ " is obtained");
			logger.info("Reservation details text present");
			test.log(Status.INFO, "Reservation details text present");
		} else {
			// System.out.println("Reservation details text is not present");
			logger.error("Reservation details text is not present");
			test.log(Status.FAIL, "Reservation details text is not present");

		}
		logger.info("Reservation element is present");
		test.log(Status.INFO, "Reservation element is present");

		String startover = verify_startover.getText();
		// System.out.println("Text obtained is"+startover);
		if (startover.contains("Start over")) {
			// System.out.println("Expected text "+startover+" is obtained");
			logger.info("startover text present");
			test.log(Status.INFO, "startover text present");
		} else {
			// System.out.println("startover text is not obtained");
			logger.error("startover text is not present");
			test.log(Status.FAIL, "startover text is not present");
		}
		logger.info("startover Element is present");
		test.log(Status.INFO, "startover Element is present");

		String guest = verify_Guest.getText();
		// System.out.println("Text obtained is"+guest);
		if (guest.equalsIgnoreCase("Guest details")) {
			// System.out.println("Expected text"+guest+ " is obtained");
			logger.info("GUEST DETAILS text present");
			test.log(Status.INFO, "GUEST DETAILS text present");
		} else {
			// System.out.println("GUEST DETAILS is not obtained");
			logger.error("GUEST DETAILS is not present");
			test.log(Status.FAIL, "GUEST DETAILS text is not present");
		}
	}

	/**
	 * 
	 * 
	 * This method attempts to verify the offercode used on the Availability
	 * page is returning the correct rate plan or list of rate plans and trys to
	 * verify the pricing. But the if statements are not doing anything so this
	 * methond can be refactored
	 */
	public void offersat_Reservationpage(String After_offerprice, String Offercode) {

		// *[contains(text(),'Special offer')]/following-sibling::ul/li

		// System.out.println("Special offers are applied successfully");
		logger.info("Special offers are applied successfully");
		test.log(Status.INFO, "Special offers are applied successfully");

		List<WebElement> specialoffers = SeleniumRepo.driver
				.findElements(By.xpath("(//*[contains(text(),'Special offer')])"));

		for (int o = 1; o <= specialoffers.size(); o++) {
			String offername = SeleniumRepo.driver.findElement(By.xpath(
					"(//*[contains(text(),'Special offer')])[" + o + "]/following-sibling::ul/li/label/span[3]/strong"))
					.getText();
			// System.out.println("Special offer at room "+o+" is "+offername);

			if (offername.equals(Offercode)) {

				// System.out.println("Offer code is applied successfully and
				// also shwoed at Reservation details page ");
			}
			String offerprice = SeleniumRepo.driver.findElement(By.xpath("(//*[contains(text(),'Special offer')])[" + o
					+ "]/following-sibling::ul/li/label/span[3]/span[2]/span/strong")).getText();
			// System.out.println(offername + "at room "+o+" price is
			// "+offerprice);
			if (offerprice.equals(After_offerprice)) {
				// System.out.println("Offer code is applied successfully and
				// also shwoed at Reservation details page ");
			}
		}
	}

	/**
	 * This method just verifies the "Available Offers" text appears for a non
	 * access code booking. The if statement do not test anything but reports
	 * logger and test info
	 * 
	 * Refactor idea: use this to verify if a specific rate plan is being
	 * displayed for a general booking
	 * 
	 */
	public void verify_available_offers() {

		int availableoffers = verify_offers.size();
		// System.out.println(availableoffers);
		for (int M = 1; M <= availableoffers; M++) {
			if (SeleniumRepo.driver
					.findElement(By.xpath("(//*[contains(@id,'edit_booking_')]//legend/span)[" + M + "]"))
					.isDisplayed()) {
				String available = SeleniumRepo.driver
						.findElement(By.xpath("(//*[contains(@id,'edit_booking_')]//legend/span)[" + M + "]"))
						.getText();
				// System.out.println("Text Obtained is " +available);
				if (available.contains("AVAILABLE OFFERS")) {
					// System.out.println("Expected text"+available+" is
					// obtained");
					logger.info("AVAILABLE OFFERS text present");
					test.log(Status.INFO, "AVAILABLE OFFERS text present");
				} else {
					// System.out.println("AVAILABLE OFFERS text is not
					// obtained");
					logger.error("AVAILABLE OFFERS is not present");
					test.log(Status.INFO, "AVAILABLE OFFERS text is not present");
				}
			}
		}
	}

	/**
	 * This is speicifcally for the list of rate plans that will appear on the
	 * reservation details page while using compound access code
	 * 
	 */
	public void verify_CompoundAccessRateplans(String Rateplan1, String Rateplan2, String CompoundAccessCode) {
		String Rateplans = Rateplan1 + " " + Rateplan2;

		for (WebElement offers : Available_Offers) {
			test.log(Status.INFO, "Available rateplan is " + offers.getText());
			logger.info("Available rateplan is " + offers.getText());
			if (Rateplans.contains(offers.getText())) {
				test.log(Status.PASS, offers.getText()
						+ " Rateplan associated successfully for the Compound AccessCode " + CompoundAccessCode);
			} else {
				test.log(Status.FAIL, offers.getText() + " Rateplan is not associated ");
				logger.error(offers.getText() + " Rateplan is not associated ");
			}
		}
	}

	/**
	 * Methods verifies the visible fields found in the Reservation Details
	 * section.
	 * 
	 * Refactor ideas: try breaking this up into separate verifying methods ->
	 * look into notes for what to incluce in verifying methods
	 * 
	 * @return
	 */
	public String Verify_Reservationdetails() {
		ExplicitWait(verify_mainheader);
		if (verify_mainheader.isDisplayed()) {
			String mainheader = verify_mainheader.getText();
			// System.out.println("Text obtained is"+mainheader);
			if (mainheader.contains("RESERVATION DETAILS")) {
				// System.out.println("Expected text"+mainheader+ " is
				// obtained");
				logger.info("RESERVATION DETAILS text present");
				test.log(Status.INFO, "RESERVATION DETAILS text present");

			} else {
				// System.out.println("Expected text is not obtained");
				logger.error("RESERVATION DETAILS is not present");
				test.log(Status.FAIL, "RESERVATION DETAILS text is not present");
			}
			test.log(Status.INFO, "mainheader Element is present");

		} else {
			// System.out.println("mainheader Element is not present");
			logger.error("mainheader Expected value is not obtained");
			test.log(Status.FAIL, "mainheader Element is not present");

		}

		int Dates = verify_dates.size();
		// System.out.println(Dates);
		for (int Q = 1; Q <= Dates; Q++) {
			if (SeleniumRepo.driver
					.findElement(By.xpath("(//div[@class='sideheader']/span[@role='text'])['" + Q + "']"))
					.isDisplayed()) {
				String reserdate = SeleniumRepo.driver
						.findElement(By.xpath("(//div[@class='sideheader']/span[@role='text'])['" + Q + "']"))
						.getText();
				// System.out.println("Text Obtained is "+reserdate);
			} else {
				// System.out.println("Expected dateis not obtained");
				logger.error("Expected date is not obtained");
				test.log(Status.FAIL, "Expected date is not obtained");

			}
		}
		if (verify_roomcharges.isDisplayed()) {
			String room = verify_roomcharges.getText();
			// System.out.println("Text obtained is"+room);
			if (room.contains("ROOM CHARGES:")) {
				// System.out.println("Expected text "+room+ " is obtained");
				logger.info("ROOM CHARGES: text present");
				test.log(Status.INFO, "ROOM CHARGES: text present");
			} else {
				// System.out.println("ROOM CHARGES: text is not obtained");
				logger.error("ROOM CHARGES: text is not obtained");
				test.log(Status.FAIL, "ROOM CHARGES: text is not obtained");

			}
			test.log(Status.INFO, "roomcharges Element is present");

		} else {
			// System.out.println("roomcharges Element is not present");
			logger.error("roomcharges is not present");
			test.log(Status.FAIL, " roomcharges Element is not present");

		}

		if (verify_taxesandfees.isDisplayed()) {
			String taxes = verify_taxesandfees.getText();
			// System.out.println("Text obtained is"+taxes);
			if (taxes.contains("TAXES AND FEES:")) {
				// System.out.println("Expected text " +taxes+" is obtained");

			} else {

				// System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "taxesandfees Element is present");

		} else {
			// System.out.println("taxesandfees Element is not present");
			logger.error("taxesandfees is not present");
			test.log(Status.FAIL, "taxesandfees Element is not present");

		}

		if (verify_grandtotal.isDisplayed()) {
			String grand = verify_grandtotal.getText();
			// System.out.println("Text obtained is"+grand);
			if (grand.contains("GRAND TOTAL:")) {
				// System.out.println("Expected text is obtained");
			} else {

				// System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "grandtotal Element is present");

		} else {
			// System.out.println("grandtotal Element is not present");
			logger.error("Expected value is not present");
			test.log(Status.FAIL, "grandtotal Element is not present");
		}
		return GrandTotalAmount.getText();
	}

	/**
	 * This method is used for GDS/email retargeting check box by verifying if
	 * its checked or clicking it if its not check Refactoring idea: 1. will
	 * create a verifying method for GDS/email check box and rename this method
	 * 2. change the check box xpath to "//*[@id='is_opted_in']" ] 3. Create a
	 * click method
	 * 
	 */
	public void checkbox() {
		if (click_iwouldlike.isSelected()) {

			// System.out.println("Clicked on checkbox i would like email");
			logger.info("Clicked on checkbox i would like email");
			test.log(Status.INFO, "Clicked on checkbox i would like email");

		} else {
			click_iwouldlike.click();
			// System.out.println("Clicked on checkbox i would like email");
			logger.info("Clicked on checkbox i would like email");
			test.log(Status.INFO, "Clicked on checkbox i would like email");

		}
	}

	/**
	 * Methods selects the specified rateplan
	 * 
	 * REfactor idea: create a method that will select a rateplan at random
	 */
	public void Select_rateplan(String rateplan) {

		WebElement select_rateplan = SeleniumRepo.driver
				.findElement(By.xpath("//*[contains(text(),'" + rateplan + "')]/../preceding-sibling::span/span"));

		if (select_rateplan.isSelected()) {
			// System.out.println("Rate plan "+rateplan+" selected
			// successfully");
			logger.info("Rate plan " + rateplan + " selected successfully");
			test.log(Status.PASS, "Rate plan " + rateplan + " selected successfully");
		} else {
			Javascriptexecutor(select_rateplan);
			// System.out.println("Rate plan "+rateplan+" selected
			// successfully");
			logger.info("Rate plan " + rateplan + " selected successfully");
			test.log(Status.PASS, "Rate plan " + rateplan + " selected successfully");
		}

	}

	/**
	 * Enters first name
	 * 
	 * Refator Idea: create a verfying method for first name that will get used
	 * for loylaty bookings
	 */
	public void First_name(String FirstName) {

		if (Enter_Firstname.isDisplayed()) {
			Enter_Firstname.clear();
			Enter_Firstname.click();
			Enter_Firstname.sendKeys(FirstName);
			// System.out.println("Entered Firstname");
			logger.info("Entered Firstname");
			test.log(Status.INFO, "Entered Firstname");

		} else {
			// System.out.println("Not Entered Firstname");
			logger.error("Not Entered Firstname");
			test.log(Status.FAIL, "Not Entered Firstname");
		}

	}

	/**
	 * Enters last name
	 * 
	 * Refator Idea: create a verfying method for last name that will get used
	 * for loylaty bookings
	 */
	public void Last_Name(String LastName) {

		if (Enter_lastname.isDisplayed()) {
			Enter_lastname.clear();
			Enter_lastname.click();
			Enter_lastname.sendKeys(LastName);
			// System.out.println("Entered Lastname");
			logger.info("Entered Lastname");
			test.log(Status.INFO, "Entered Lastname");

		} else {
			// System.out.println("Not Entered Lastname");
			logger.error("Not Entered Lastname");
			test.log(Status.FAIL, "Not Entered Lastname");

		}
	}

	/**
	 * Enters email address
	 * 
	 * Refator Idea: create a verfying method for email that will get used for
	 * loylaty bookings
	 */
	public void Email(String Email) {

		if (Enter_Email.isDisplayed()) {
			Enter_Email.clear();
			Enter_Email.click();
			Enter_Email.sendKeys(Email);
			// System.out.println("Entered Email");
			logger.info("Entered Email");
			test.log(Status.INFO, "Entered Email");

		} else {
			// System.out.println("Not Entered Email");
			logger.error("Not Entered Email");
			test.log(Status.FAIL, "Not Entered Email");

		}
	}

	/**
	 * Method is used for the "Extra Information", currently able to interact with 
	 * all three types of questions. 
	 * 
	 * TODO: Allow user input 
	 * 
	 * Refactoring ideas: Create a method that will handle the "Additional Room Request" section
	 * 
	 */
	public void extra_inforamtion() {

		/*
		 * Add this to this class when its possible to use
		 * 
		 * @FindAll({ @FindBy(xpath =
		 * "(//div[@class='addons gpref' and @data-type='Single'])") }) public
		 * List <WebElement> extraInfoQuestinos_Single;
		 * 
		 * @FindAll({ @FindBy(xpath =
		 * "(//div[@class='addons gpref' and @data-type='Multiple'])") }) public
		 * List <WebElement> extraInfoQuestinos_Multiple;
		 * 
		 */
		String questionType;
		String questionVisibility;
		int singleCount = 0;
		int multiCount = 0;
		int textCount = 0;
		

		// Check to see if questions are hidden
		questionVisibility = extraInfo_Section_toggling.getAttribute("data-hide");

		if (questionVisibility.equals("true")) {
			extraInfo_Section_toggling.click();
		}

		for (int l = 0; l < allExtraInfoQuestinos.size(); l++) {

			questionType = allExtraInfoQuestinos.get(l).getAttribute("data-type");

			switch (questionType) {

			case "Single":
				singleCount++;

				extraInfoSingleSelection(singleCount);
				break;

			case "Multiple":

				multiCount++;

				extraInfoMultipleSelection(multiCount);
				break;

			case "FreeText":
				
				extraInfoFreeText(textCount);
				textCount++; 
				break;
			}
		}
		
		
		
		/* 
		 * List<WebElement> els =SeleniumRepo.driver.findElements(
		 * By.xpath("(//input[@class='grp none-outline'])")); for(WebElement el
		 * : els ) { if (!el.isSelected() ) { Javascriptexecutor(el); } }
		 */
		
		/*
		List<WebElement> els =SeleniumRepo.driver.findElements( By.xpath("(//input[@class='grp none-outline'])"));
		for(WebElement el : els ) {
			if (!el.isSelected() ) {
				Javascriptexecutor(el);
			}
		}
		List<WebElement> textarea =SeleniumRepo.driver.findElements( By.xpath("//textarea"));
		for(WebElement el : textarea ) {
			el.sendKeys("Ravi");
		}
		*/

	}

	/**
	 * Used to handle guest preference questions that are single selection type
	 * 
	 * 
	 * @param currentQuestion - an int that is used to represent count of the single selection question 
	 */
	private void extraInfoSingleSelection(int currentQuestion) {

		int sele;

		List<WebElement> extraInfoQuestinos = SeleniumRepo.driver.findElements(By.xpath(
				("(//div[@class='addons gpref' and @data-type='Single'])[" + currentQuestion + "]//label/input")));

		if (extraInfoQuestinos.size() > 1) {
			sele = SeleniumRepo.getRandomNumberInRange(1, extraInfoQuestinos.size()) - 1;

		} else {
			sele = 0;

		}

		extraInfoQuestinos.get(sele).click();
		
		logger.info("Selected  a singel Selection Question for Booking");
		test.log(Status.INFO, "Selected  a singel Selection Question for Booking");

	}

	/**
	 * Used to handle guest preference questions that are multiple selection type
	 * 
	 * 
	 * @param currentQuestion - an int that is used to represent count of the single selection question 
	 */
	private void extraInfoMultipleSelection(int currentQuestion) {

		int sele;

		List<WebElement> extraInfoQuestions = SeleniumRepo.driver.findElements(By.xpath(
				("(//div[@class='addons gpref' and @data-type='Multiple'])[" + currentQuestion + "]//label/input")));

		if (extraInfoQuestions.size() < 2) {

			extraInfoQuestions.get(0).click();

		} else {

			for (int p = 0; p < 2; p++) {

				sele = SeleniumRepo.getRandomNumberInRange(1, extraInfoQuestions.size()) - 1;

				System.out.println("Multi Selection  " + sele);

				if (extraInfoQuestions.get(sele).isSelected() == false) {

					extraInfoQuestions.get(sele).click();

				}

			}

		}
		
		logger.info("Selected Multi Selection Question for Booking");
		test.log(Status.INFO, "Selected  a Multi Selection Question for Booking");


	}

	/**
	 * Used to handle guest preference questions that are free text type
	 * 
	 * 
	 * @param currentQuestion - an int that is used to represent count of the single selection question 
	 */
	private void extraInfoFreeText(int currentQuestion) {

		String currentTextFieldId = extraInfoQuestinos_FreeText.get(currentQuestion).getAttribute("data-id");

		WebElement extraInfoTextArea = SeleniumRepo.driver
				.findElement(By.xpath(("//*[@id=" + currentTextFieldId + "]")));

		extraInfoTextArea.clear();
		extraInfoTextArea.sendKeys("Hello Nurse");
		
		logger.info("Enter text into a Free Text Question for Booking");
		test.log(Status.INFO, "Enter text into a Free Text Question for Booking");

	}

	/**
	 * Clicks the confirmation details button
	 * 
	 * Refactor idea: change name to confirmationDetailsButton
	 * 
	 */
	public void confirmation() throws InterruptedException {

        Thread.sleep(2000);

		if (confirmation.isDisplayed()) {
			confirmation.click();
			// System.out.println("Clicked on confirmation button");
			logger.info("Clicked on confirmation button");
			test.log(Status.INFO, "Clicked on confirmation button");

		} else {
			// System.out.println("Not Clicked on confirmation button");
			logger.error("Not Clicked on confirmation button");
			test.log(Status.FAIL, "Not Clicked on confirmation button");
		}

		SeleniumRepo.waitForPageLoaded();
		Thread.sleep(3000);
	}

	/**
	 * Todo: GEt ride of this method once the use case of ReuseMethodsforDPR in
	 * ClasicFlow class is understood
	 */
	public void ReuseMethodsforDPRsetupResDetails(String rateplan)
			throws IOException, InterruptedException, ParseException {

		verify_available_offers();
		Verify_Reservationdetails();
		checkbox();
		Select_rateplan(rateplan);

	}

}
