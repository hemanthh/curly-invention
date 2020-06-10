package com.tt.BE.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.tt.utility.SeleniumRepo;

/**
 * This class will host all verifying and action based methods for TT classic flow booking engine confirmation page.
 *
 * @author DM (refactored from ClasicFlow)
 *
 */
public class ClassicFlow_ConfirmationPage extends ClasicFlow{
	
	//Todo: must integrate this class with existing classes that effect the confirmation page
	//for example ChangeReservation_BE this class is actually asserting things
	
	
	@FindAll({ @FindBy(xpath = "(//*[@headers='summary_reservation_offer'])[1]"), })

	private WebElement summary_reservation;
	

	@FindAll({ @FindBy(xpath = "(//*[@headers='summary_reservation_offer'])"), })

	private List<WebElement> offer_payment;
	
	
	@FindAll({ @FindBy(xpath = "//body[@class='standard-flow ng-scope']/div[@id='wrapper']/section[@class='container main-container z-index']/div[@class='main-container-content']/ul[1]"), })

	public WebElement verify_Termsandconditionstext;
	
	

	
	/**
	 * This method verifies various items on the confirmation page. 
	 * 
	 * Refator idea: Break this up to verify all the elements found on the confirmation page.[this will be heplful when testing ibeconfig changes] 
	 * But start witht the items listed within the method
	 */
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

*/
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
	
	
	/**
	 * Refactor ideas: We can verify using the external data input as well as confirming by keeping track of 
	 *  page transitional info 
	 */
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
	
	/**
	 * Not sure whaht this method is for but it seems to be used for FBP but investigate TC_FBP for 
	 * more information . also this method is also in ClasicFlow need to decided what to 
	 * 
	 * 
	 * @param Rateplan
	 */
	
	/*
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
	*/
	

}
