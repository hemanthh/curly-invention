package com.tt.BE.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.tt.utility.SeleniumRepo;

/**
 * This class will host all verifying and action based methods for TT classic flow booking engine Payment Details page.
 *
 * @author DM (refactored from ClasicFlow)
 *
 */
public class ClassicFlow_PaymentDetailsPage extends ClasicFlow {
	
	
	
	
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

	@FindAll({ @FindBy(xpath = "//span[@class='accept_booking']//label"), })

	public WebElement Verify_accept;

	@FindAll({ @FindBy(xpath = "//input[@id='accept']"), })

	public WebElement Click_accept;

	@FindAll({ @FindBy(xpath = "//input[@value='Complete reservation']"), })

	public WebElement CompleteReservation;
	
	
	
	/**
	 * Method verifies the appearances of Card Information header and "accepted cards" header
	 * 
	 * Refactor ideas: also use this method to verify the acceptanced cards its self
	 * @throws InterruptedException 
	 */
	public void card_information() throws InterruptedException
	{
        Thread.sleep(5000);
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

	/**
	 * Used to enter credit card name
	 * 
	 */
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
	
	/**
	 * Used to enter credit card number
	 * 
	 */
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
	
	/**
	 * Used to enter credit card expiration date
	 * 
	 */
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
	
	
	/**
	 * Used to enter address country info
	 * 
	 */
	public void Country(String Entercountry) throws InterruptedException
	{
		scroll(Countrydropdown);
		
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
	
	
	/**
	 * Used to enter phone number
	 * 
	 * Refactor idea: there is an ibeconfig field that can make the phone number required or not appear. So create 
	 * a method that will test this 
	 * 2. change the method name to phone number
	 *  
	 * 
	 */
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
	
	
	/**
	 * This method verify the "room changes', and "Taxes and Fees", as well as clicking the terms and condition 
	 * checkbox and the confirmation button
	 * 
	 */
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

		// Accepts Card Details
		
		try {
			
			
		}catch(Exception e) {}
		
		
		
		
		
		
		SeleniumRepo.waitForPageLoaded();

		ExplicitWait(Verify_thankyou);
		Thread.sleep(4000);
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
	
	
	/**
	 * Seems this method is used as a single method that handels  filling out payments page  address information
	 *  while completing a booking
	 * 
	 * @param Address
	 * @param Enterzipcode
	 * @param Address2
	 * @param Enterstate
	 * @param Entercity
	 */
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
	
	

}
