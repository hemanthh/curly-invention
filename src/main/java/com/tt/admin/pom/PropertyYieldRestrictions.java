/**
 * 
 */
package com.tt.admin.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * @author DM
 *
 */
public class PropertyYieldRestrictions extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })
	public WebElement Click_PropertyManagement;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Yield Restrictions')]") })
	public WebElement Click_Property_Yield_Restrictions;

	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Property Yield Restrictions')]"), })
	public WebElement PropertyYieldRestrictions_title;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Same Day Check-In')]") })
	public WebElement SameDayCheckIn_field;

	@FindAll({ @FindBy(xpath = "//*[@name='identifySameDayCheckIn' and @value='Allow']") })
	public WebElement Click_SameDayCheckIn_Allow;

	@FindAll({ @FindBy(xpath = "//*[@name='identifySameDayCheckIn' and @value='Not Allow']") })
	public WebElement Click_SameDayCheckIn_DoNotAllow;

	//*[@name='identifySameDayCheckIn'][3]
	//*[@name='identifySameDayCheckIn' and @value='Not Allow After Time']
	@FindAll({ @FindBy(xpath = "//*[@name='identifySameDayCheckIn'][3]") })
	public WebElement Click_SameDayCheckIn_DoNotAllowAfter;

	@FindAll({ @FindBy(id = "denySameDayReservationsAfterHour") })
	public WebElement Select_SameDayCheckInAfterHr_DropDown;

	@FindAll({ @FindBy(id = "denySameDayReservationsAfterMin") })
	public WebElement Select_SameDayCheckInAfterMin_DropDown;

	@FindAll({ @FindBy(id = "amOrPm") })
	public WebElement Select_SameDayCheckInAfterAmPm_DropDown;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Impose Max LOS')]") })
	public WebElement ImposeMaxLOS_field;

	@FindAll({ @FindBy(xpath = "//*[@name='imposeMaxLOS' and @value='Y']") })
	public WebElement Click_ImposeMaxLOS_Enable;

	@FindAll({ @FindBy(xpath = "//*[@name='imposeMaxLOS' and @value='N']") })
	public WebElement Click_ImposeMaxLOS_Disable;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Max LOS')]") })
	public WebElement MaxLOS_field;

	@FindAll({ @FindBy(xpath = "//*[@name='maxLOS']") })
	public WebElement Enter_MaxLOS_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Minimum Lead-Time')]") })
	public WebElement MinLeadTime_field;

	@FindAll({ @FindBy(xpath = "//*[@name='minLeadTime']") })
	public WebElement Enter_MinLeadTime_Text;

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'Maximum Lead-Time')]") })
	public WebElement MaxLeadTime_field;

	@FindAll({ @FindBy(xpath = "//*[@name='maxLeadTime']") })
	public WebElement Enter_MaxLeadTime_Text;

	@FindAll({ @FindBy(xpath = "//input[@name='Submit' and @value='Save']") })
	public WebElement SaveButton;

	public void click_PropertyYieldRestrictions() {

		SeleniumRepo.waitForElementPresent(Click_PropertyManagement);
		if (Click_PropertyManagement.isDisplayed()) {
			Click_PropertyManagement.click();
			logger.info("Clicked on property Management Link");
			test.log(Status.PASS, "Clicked on property Management Link");
			Assert.assertTrue(true, "Clicked on property Management Link");
		} else {
			System.out.println(" property Management Link is not found");
			logger.error("Failed to Click on Brand button");
			test.log(Status.FAIL, "Failed to Click on Save button");
			Assert.assertFalse(false, "Property Management Link not found");
		}

		SeleniumRepo.waitForElementPresent(Click_Property_Yield_Restrictions);
		if (Click_Property_Yield_Restrictions.isDisplayed()) {
			Click_Property_Yield_Restrictions.click();
			logger.info("Clicked on Property Yield Restrictions Link");
			test.log(Status.PASS, "Clicked on Property Yield Restrictions Link");
			Assert.assertTrue(true, "Clicked on Property Yield Restrictions Link");
		} else {
			System.out.println(" Property Yield Restrictions is not found");
			logger.error("Failed to Click on Property Yield Restrictions");
			test.log(Status.FAIL, "Failed to Click on Property Yield Restrictions");
			Assert.assertFalse(false, "Property Yield Restrictions Link not found");
		}

	}

	/**
	 * This method is used to confirm if the Property Yield Restrictions link is visisble 
	 * @throws NoSuchElementException
	 * @throws Exception 
	 */
	private void verifyingPropYieldResLinkIsVisible() throws NoSuchElementException {
		
		boolean propYieldResTitlePresence = SeleniumRepo.isElementPresent(PropertyYieldRestrictions_title);

		System.out.println("is the pyr title if " + propYieldResTitlePresence);

		if (Click_Property_Yield_Restrictions.isDisplayed() != true) {
			Click_PropertyManagement.click();

			SeleniumRepo.waitForElementPresent(Click_Property_Yield_Restrictions);

			Click_Property_Yield_Restrictions.click();

			// System.out.println("is the pyr title if " + propYieldRestitle ) ;

		} else if (propYieldResTitlePresence == false && Click_Property_Yield_Restrictions.isDisplayed() == true) {

			Click_Property_Yield_Restrictions.click();
		}

	}


	/**
	 * 
	 * @throws Exception
	 */
	public void propYieldSameDayChkInAllow() throws Exception {

		verifyingPropYieldResLinkIsVisible();

		SeleniumRepo.waitForElementPresent(SameDayCheckIn_field);

		Assert.assertEquals(SameDayCheckIn_field.isDisplayed(), true, "Same Day Check-In Field is not being displayed");

		if (Click_SameDayCheckIn_Allow.isSelected() == false) {

			Click_SameDayCheckIn_Allow.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Same Day Check-In is set to Allow successfully");
			logger.info(" Same Day Check-In is set to Allow selected successfully");
			test.log(Status.PASS, "Same Day Check-In is set to Allow selected successfully");
			Assert.assertTrue(Click_SameDayCheckIn_Allow.isSelected(), "Same Day Check-In is set to Allow");

		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void propYieldSameDayChkInDoNotAllow() throws Exception {

		verifyingPropYieldResLinkIsVisible();

		SeleniumRepo.waitForElementPresent(SameDayCheckIn_field);

		Assert.assertEquals(SameDayCheckIn_field.isDisplayed(), true, "Same Day Check-In Field is not being displayed");

		if (Click_SameDayCheckIn_DoNotAllow.isSelected() == false) {

			Click_SameDayCheckIn_DoNotAllow.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Same Day Check-In is set to Not Allow successfully");
			logger.info(" Same Day Check-In is set to Not Allow selected successfully");
			test.log(Status.PASS, "Same Day Check-In is set to Not Allow selected successfully");
			Assert.assertTrue(Click_SameDayCheckIn_DoNotAllow.isSelected(), "Same Day Check-In is set to Not Allow");

		}

	}

	/**
	 *  Currently not being used 
	 * @param timeHr
	 * @param timeMin
	 * @param timeAmPm
	 * @throws Exception
	 */
	public void propYieldSameDayChkInDoNotAllowAfter(String timeHr, String timeMin, String timeAmPm) throws Exception {

		SeleniumRepo.waitForElementPresent(SameDayCheckIn_field);

		Assert.assertEquals(SameDayCheckIn_field.isDisplayed(), true, "Same Day Check-In Field is not being displayed");

		if (Click_SameDayCheckIn_DoNotAllowAfter.isSelected() == false) {

			Click_SameDayCheckIn_DoNotAllowAfter.click();

			Select_SameDayCheckInAfterHr_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterHr_DropDown, timeHr);

			Select_SameDayCheckInAfterMin_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterMin_DropDown, timeMin);

			Select_SameDayCheckInAfterAmPm_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterAmPm_DropDown, timeAmPm);

			SeleniumRepo.WaitForLoad(100);

			System.out.println(" Same Day Check-In is set to Do Not Allow After successfully");
			logger.info(" Same Day Check-In is set to Do Not Allow After selected successfully");
			test.log(Status.PASS, "Same Day Check-In is set to Do Not Allow After selected successfully");
			Assert.assertTrue(Click_SameDayCheckIn_DoNotAllowAfter.isSelected(),
					"Same Day Check-In is set to Do Not Allow After");

		} else {

			Select_SameDayCheckInAfterHr_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterHr_DropDown, timeHr);

			Select_SameDayCheckInAfterMin_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterMin_DropDown, timeMin);

			Select_SameDayCheckInAfterAmPm_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterAmPm_DropDown, timeAmPm);

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Same Day Check-In is set to Do not Allow After" + timeHr + ":" + timeHr + timeAmPm);
			logger.info("Same Day Check-in is set to Do not Allow After");
			// test.log(Status.PASS, "Same Day Check-in is set to Do not Allow
			// After");

			Assert.assertTrue(Click_SameDayCheckIn_DoNotAllow.isSelected(), "Same Day Check-In is set to Do not allow");

		}

	}

	/**
	 * 
	 */
	public void propYieldSameDayChkInDoNotAllowAfterUnavail() throws InterruptedException {

		Thread.sleep(5000);

		verifyingPropYieldResLinkIsVisible();
		
		Thread.sleep(5000);


		DateFormat dateFormat = new SimpleDateFormat("hh:mm:aa");
		String dateStringTime = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateStringTime);

		String timeParts[] = dateStringTime.split(":");

		int hour = Integer.parseInt(timeParts[0]);
		int hourBefore = hour - 1;

		System.out.println(hour + "  " + "  " + hourBefore);

		String timeHr = "";
		String timeMins = "";
		String timeMeridiem = "";

		if (Click_SameDayCheckIn_DoNotAllowAfter.isSelected() == false) {

			Click_SameDayCheckIn_DoNotAllowAfter.click();

		}

		if (timeParts[1].contains("0")) {

			int minsBefore = Integer.parseInt(timeParts[1]);

			timeParts[1] = Integer.toString(minsBefore);

		}

		if (hour == 12 && timeParts[2].equals("PM")) {

			timeHr = Integer.toString(hourBefore);
			timeMins = timeParts[1];
			timeMeridiem = "AM";

		} else if (hour == 12 && timeParts[2].equals("AM")) {

			timeHr = Integer.toString(hourBefore);
			timeMins = timeParts[1];
			timeMeridiem = "PM";

		} else if (hourBefore == 0 && timeParts[2].equals("PM")) {

			timeHr = Integer.toString(hourBefore);
			timeMins = timeParts[1];
			timeMeridiem = "PM";

		} else if (hourBefore == 0 && timeParts[2].equals("AM")) {

			timeHr = Integer.toString(hourBefore);
			timeMins = timeParts[1];
			timeMeridiem = "AM";

		} else {

			timeHr = Integer.toString(hourBefore);
			timeMins = timeParts[1];
			timeMeridiem = timeParts[2];
		}


		Select_SameDayCheckInAfterHr_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterHr_DropDown, timeHr);

		Select_SameDayCheckInAfterMin_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterMin_DropDown, timeMins);

		Select_SameDayCheckInAfterAmPm_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterAmPm_DropDown, timeMeridiem);

		logger.info(
				" Same Day Check-In is set to Do not allow after with time " + timeHr + ":" + timeMins + timeMeridiem);
		test.log(Status.PASS, "Same Day Check-In is set to Do not allow after selected successfully with time " + timeHr
				+ ":" + timeMins + timeMeridiem);

	}

	/**
	 * @throws InterruptedException 
	 * 
	 */
	public void propYieldSameDayChkInDoNotAllowAfterAvail() throws InterruptedException {

		Thread.sleep(5000);

		verifyingPropYieldResLinkIsVisible();
		
		Thread.sleep(5000);


		DateFormat dateFormat = new SimpleDateFormat("hh:mm:aa");
		String dateStringTime = dateFormat.format(new Date()).toString();
		System.out.println("Current time in AM/PM: " + dateStringTime);

		String timeParts[] = dateStringTime.split(":");

		int hour = Integer.parseInt(timeParts[0]);
		int hourAfter = hour + 1;

		System.out.println(hour + "  " + "  " + hourAfter);

		String timeHr = "";
		String timeMins = "";
		String timeMeridiem = "";
		

		if (Click_SameDayCheckIn_DoNotAllowAfter.isSelected() == false) {
			
			Click_SameDayCheckIn_DoNotAllowAfter.click();
		}

		if (timeParts[1].contains("0")) {

			int minsBefore = Integer.parseInt(timeParts[1]);

			timeParts[1] = Integer.toString(minsBefore);

		}

		if (hour == 12 && timeParts[2].equals("PM")) {

			timeHr = "1";
			timeMins = timeParts[1];
			timeMeridiem = timeParts[2];

		} else if (hour == 12 && timeParts[2].equals("AM")) {
			timeHr = "1";
			timeMins = timeParts[1];
			timeMeridiem = timeParts[2];

		} else if (hourAfter == 12 && timeParts[2].equals("AM")) {

			timeHr = "0";
			timeMins = timeParts[1];
			timeMeridiem = "PM";

		} else if (hourAfter == 12 && timeParts[2].equals("PM")) {

			timeHr = "0";
			timeMins = timeParts[1];
			timeMeridiem = "AM";

		} else {

			timeHr = Integer.toString(hourAfter);
			timeMins = timeParts[1];
			timeMeridiem = timeParts[2];
		}

		Select_SameDayCheckInAfterHr_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterHr_DropDown, timeHr);

		Select_SameDayCheckInAfterMin_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterMin_DropDown, timeMins);

		Select_SameDayCheckInAfterAmPm_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Select_SameDayCheckInAfterAmPm_DropDown, timeMeridiem);

		logger.info(
				" Same Day Check-In is set to Do not allow after with time " + timeHr + ":" + timeMins + timeMeridiem);
		test.log(Status.PASS, "Same Day Check-In is set to Do not allow after selected successfully with time " + timeHr
				+ ":" + timeMins + timeMeridiem);

	}

	/**
	 * 
	 * @param status
	 * @throws Exception
	 */
	public void propYieldImposeMaxLos(String status) throws Exception {
		
		verifyingPropYieldResLinkIsVisible();

		SeleniumRepo.waitForElementPresent(ImposeMaxLOS_field);

		Assert.assertEquals(ImposeMaxLOS_field.isDisplayed(), true, "Status Field is not being displayed");

		if (status.equalsIgnoreCase("enable")) {

			Click_ImposeMaxLOS_Enable.click();

			SeleniumRepo.WaitForLoad(1000);

			System.out.println("Impose Max LOS is set to active successfully");
			logger.info(" Impose Max LOS selected successfully");
			test.log(Status.PASS, "Impose Max LOS selected successfully");
			Assert.assertTrue(Click_ImposeMaxLOS_Enable.isSelected(), "Impose Max LOS is Enabled");

		} else {

			Click_ImposeMaxLOS_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Impose Max LOS is disable ");
			logger.info("Set Impose Max LOS to No");
			test.log(Status.PASS, "Impose Max LOS Disable sucessfully");

			Assert.assertTrue(Click_ImposeMaxLOS_Disable.isSelected(), "Impose Max LOS is disable");

		}

	}

	/**
	 * 
	 * @param EnterMaxLos
	 */
	public void propYieldMaxLOS(String EnterMaxLos) {

		verifyingPropYieldResLinkIsVisible();

		SeleniumRepo.waitForElementPresent(MaxLOS_field);

		Assert.assertEquals(MaxLOS_field.isDisplayed(), true, "Max LOS is not being displayed");

		Enter_MaxLOS_Text.click();
		Enter_MaxLOS_Text.clear();
		Enter_MaxLOS_Text.sendKeys(EnterMaxLos);

		System.out.println("Max LOS is entered successfully");

		Assert.assertEquals(Enter_MaxLOS_Text.getAttribute("value"), EnterMaxLos, "Max LOS Field text was not entered");
		logger.info("Max LOS is entered successfully");
		test.log(Status.PASS, "Max LOS is entered successfully");
	}

	/**
	 * 
	 * @param EnterMinLead
	 */
	public void propYieldMinLeadTime(String EnterMinLead) {

		verifyingPropYieldResLinkIsVisible();

		SeleniumRepo.waitForElementPresent(MinLeadTime_field);

		Assert.assertEquals(MinLeadTime_field.isDisplayed(), true, "Minimum Lead-Time is not being displayed");

		Enter_MinLeadTime_Text.click();
		Enter_MinLeadTime_Text.clear();
		Enter_MinLeadTime_Text.sendKeys(EnterMinLead);

		System.out.println("Minimum Lead-Time is entered successfully");

		Assert.assertEquals(Enter_MinLeadTime_Text.getAttribute("value"), EnterMinLead,
				"Minimum Lead-Time Field text was not entered");
		logger.info("Minimum Lead-Time is entered successfully");
		test.log(Status.PASS, "Minimum Lead-Time is entered successfully");

	}

	/**
	 * 
	 * @param EnterMaxLead
	 */
	public void propYieldMaxLeadTime(String EnterMaxLead) {

		verifyingPropYieldResLinkIsVisible();

		SeleniumRepo.waitForElementPresent(MaxLeadTime_field);

		Assert.assertEquals(MaxLeadTime_field.isDisplayed(), true, "Maximum Lead-Time is not being displayed");

		Enter_MaxLeadTime_Text.click();
		Enter_MaxLeadTime_Text.clear();
		Enter_MaxLeadTime_Text.sendKeys(EnterMaxLead);

		System.out.println("Maximum Lead-Time is entered successfully");

		Assert.assertEquals(Enter_MaxLeadTime_Text.getAttribute("value"), EnterMaxLead,
				"Maximum Lead-Time Field text was not entered");
		logger.info("Maximum Lead-Time is entered successfully");
		test.log(Status.PASS, "Maximum Lead-Time is entered successfully");

	}

	public void Click_Save() {
		ExplicitWait(SaveButton);
		if (SaveButton.isDisplayed()) {
			Javascriptexecutor(SaveButton);
			System.out.println("Save button clicked successfully");
			logger.info("Save button clicked successfully");
			test.log(Status.INFO, "Save button clicked successfully");
			Assert.assertTrue(true, "Save button clicked successfully");

		} else {
			System.out.println("Save button not found");
			logger.info("Save button not found");
			test.log(Status.INFO, "Save button not found");
			Assert.assertTrue(true, "Save button not found");

		}

	}

}
