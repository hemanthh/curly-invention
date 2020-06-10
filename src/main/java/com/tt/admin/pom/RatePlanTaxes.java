/**
 * 
 */
package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

/**
 * @author DM
 *
 */
public class RatePlanTaxes extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//td[@class='taxHeader']/b"), })
	public List<WebElement> RatePlanTaxesTable_HeaderRow;

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//tr[@class='prompt'][1]//input"), })
	public List<WebElement> RatePlanTaxesTable_Apply_TaxToAllRatePlan;

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//td[@tf_colkey='name']"), })
	public List<WebElement> RatePlanTaxesTable_RatePlanName;

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//input[@tf_colkey='name']"), })
	public WebElement RatePlanTaxesTable_RatePlanNameFilter;

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//td[@tf_colkey='classification']"), })
	public List<WebElement> RatePlanTaxesTable_RatePlanClassification;

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//input[@tf_colkey='classification']"), })
	public WebElement RatePlanTaxesTable_RatePlanClassificationFilter;

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//td[@tf_colkey='rateCode']"), })
	public List<WebElement> RatePlanTaxesTable_RatePlanCode;

	@FindAll({ @FindBy(xpath = "//*[@id='normalRatePlan']//input[@tf_colkey='rateCode']"), })
	public WebElement RatePlanTaxesTable_RatePlanCodeFilter;

	@FindAll({ @FindBy(xpath = "//*[text()='Rate Plans']") })
	public WebElement Click_RatePlans;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Rate Plan Taxes')]") })
	public WebElement click_RatePlanTaxes;

	@FindAll({ @FindBy(xpath = "//h1[text()='Rate Plan Taxes']") })
	public WebElement Verify_RatePlanTaxes_Title;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Rate Plan Tax not available')]") })
	public WebElement Verify_NoRatePlanTaxesExist;

	@FindAll({ @FindBy(xpath = "//input[@name='button1' and @value='Save']"), })
	public WebElement Click_Save;

	public void navigateToRatePlanTaxes() throws InterruptedException {

		if (SeleniumRepo.isElementDisplayed(click_RatePlanTaxes) == false
				&& SeleniumRepo.isElementDisplayed(Click_RatePlans) == true) {

			Click_RatePlans.click();

			Thread.sleep(2000);

			click_RatePlanTaxes.click();

			SeleniumRepo.waitForPageLoaded();

			logger.info("Clicked on Rate Plans  Tab and proceed to click Rate Plan Taxes link");
			test.log(Status.PASS, "Clicked on Rate Plans Tab and Rate Plan Taxes Link");
			Assert.assertTrue(SeleniumRepo.isElementDisplayed(Verify_RatePlanTaxes_Title),
					"Clicked on Rate Plans Tab and Rate Plan Taxes Link");

		} else {

			click_RatePlanTaxes.click();

			logger.info("Clicked Rate Plan Taxes link");
			test.log(Status.PASS, "Clicked Rate Plan Taxes Link");
			Assert.assertTrue(SeleniumRepo.isElementDisplayed(Verify_RatePlanTaxes_Title),
					"Clicked on Rate Plans Tab and Rate Plan Taxes Link");

		}

	}

	private void isTaxesPresent() {

		Assert.assertFalse(SeleniumRepo.isElementDisplayed(Verify_NoRatePlanTaxesExist),
				"There is either no rate plan or no taxes");

	}

	private void clearFilter() {

		RatePlanTaxesTable_RatePlanNameFilter.click();
		RatePlanTaxesTable_RatePlanNameFilter.clear();

		RatePlanTaxesTable_RatePlanClassificationFilter.click();
		RatePlanTaxesTable_RatePlanClassificationFilter.clear();

		RatePlanTaxesTable_RatePlanCodeFilter.click();
		RatePlanTaxesTable_RatePlanCodeFilter.clear();

		// RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(0).click();

		System.out.println("Clearing and Entering rate plan into the filter");
		logger.info("Clearing and Entering rate plan into the filter");
		test.log(Status.INFO, "Clearing and Entering rate plan into the filter");

	}

	public void applyAllTaxesToAllRatePlans() {

		isTaxesPresent();
		clearFilter();

		RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(0).click();

		System.out.println("Applying all Taxes to All Rate plans");
		logger.info("Applying all Taxes to All Rate plans");
		test.log(Status.INFO, "Applying all Taxes to All Rate plans");

	}

	public void applyTaxToAllRatePlans(String taxName) {

		int taxPos = 0;

		isTaxesPresent();
		clearFilter();

		// search for the Tax to obtain its positions

		for (int a = 2; a < RatePlanTaxesTable_HeaderRow.size(); a++) {

			if (RatePlanTaxesTable_HeaderRow.get(a).getText().trim().equalsIgnoreCase(taxName)) {

				taxPos = a - 2;

				System.out.println("Tax name postion :  " + taxPos + "  and original value  " + a + " "
						+ RatePlanTaxesTable_HeaderRow.get(a).getText());

				logger.info("Found the tax called " + taxName + "  location");
				test.log(Status.PASS, "Found the tax to apply to all rate plans");
			}
		}

		// pass the postion of the rate plan

		if (taxPos == 0) {

			logger.info("Was Not able to find tax ");
			test.log(Status.FAIL, "The tax " + taxName + "  does not exsists ");
			Assert.assertFalse(true, "The tax " + taxName + " was not found ");

		} else {
			RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(taxPos).click();

			logger.info("Clicked the all checkbox for tax : " + taxName);
			test.log(Status.PASS, "Clicked the all checkbox for tax : " + taxName);

			Assert.assertTrue(RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(taxPos).isSelected(),
					"The all checkbox for  tax " + taxName + " is not checked");

		}

	}

	public void applyAllTaxesToRatePlane(String ratePlanName, String ratePlanCode) {

		isTaxesPresent();

		// enter rate plan name and code string into filter

		RatePlanTaxesTable_RatePlanNameFilter.click();
		RatePlanTaxesTable_RatePlanNameFilter.clear();
		RatePlanTaxesTable_RatePlanNameFilter.sendKeys(ratePlanName);

		System.out.println("Clearing and Entering rate plan " + ratePlanName + "  into the filter");
		logger.info("Clearing and Entering rate plan " + ratePlanName + "  into the filter");
		test.log(Status.INFO, "Clearing and Entering rate plan " + ratePlanName + "  into the filter");

		RatePlanTaxesTable_RatePlanCodeFilter.click();
		RatePlanTaxesTable_RatePlanCodeFilter.clear();
		RatePlanTaxesTable_RatePlanCodeFilter.sendKeys(ratePlanCode);

		System.out.println("Clearing and Entering rate plan code " + ratePlanCode + "  into the filter");
		logger.info("Clearing and Entering rate plan code " + ratePlanCode + "  into the filter");
		test.log(Status.INFO, "Clearing and Entering rate plan code " + ratePlanCode + "  into the filter");

		// proceed to applying all taxes to before doing so check that check box

		if (RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(0).isSelected() == true) {

			RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(0).click();
		}

		RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(0).click();

		clearFilter();

	}

	public void applyTaxToRatePlan(String ratePlanName, String ratePlanCode, String taxName) {

		// *[@id='normalRatePlan']//tr[@class='prompt'][1]//input -> use this to
		// build an xpath

		isTaxesPresent();

		// enter rate plan name and code string into filter

		RatePlanTaxesTable_RatePlanNameFilter.click();
		RatePlanTaxesTable_RatePlanNameFilter.clear();
		RatePlanTaxesTable_RatePlanNameFilter.sendKeys(ratePlanName);

		System.out.println("Clearing and Entering rate plan " + ratePlanName + "  into the filter");
		logger.info("Clearing and Entering rate plan " + ratePlanName + "  into the filter");
		test.log(Status.INFO, "Clearing and Entering rate plan " + ratePlanName + "  into the filter");

		RatePlanTaxesTable_RatePlanCodeFilter.click();
		RatePlanTaxesTable_RatePlanCodeFilter.clear();
		RatePlanTaxesTable_RatePlanCodeFilter.sendKeys(ratePlanCode);

		System.out.println("Clearing and Entering rate plan code " + ratePlanCode + "  into the filter");
		logger.info("Clearing and Entering rate plan code " + ratePlanCode + "  into the filter");
		test.log(Status.INFO, "Clearing and Entering rate plan code " + ratePlanCode + "  into the filter");

		// proceed to applying all taxes to before doing so check that check box

		if (RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(0).isSelected() == true) {

			RatePlanTaxesTable_Apply_TaxToAllRatePlan.get(0).click();
		}

		// Since the filter does not really change the postion of the rate plan
		// still need to find the row

		int ratePlanRow = 0;
		int taxColumn = 0;

		for (int b = 0; b < RatePlanTaxesTable_RatePlanName.size(); b++) {
			if (RatePlanTaxesTable_RatePlanName.get(b).getText().equalsIgnoreCase(ratePlanName)) {

				System.out.println(RatePlanTaxesTable_RatePlanName.get(b).getText() + "    " + b);

				// adding 2, 1 to adjust for rate plan physical location and
				// another 1 for the
				// check box row location
				ratePlanRow = b + 2;

			}
		}

		for (int c = 0; c < RatePlanTaxesTable_HeaderRow.size(); c++) {
			if (RatePlanTaxesTable_HeaderRow.get(c).getText().equalsIgnoreCase(taxName)) {

				// Adjusting for the physical location of the tax
				taxColumn = c - 2;
			}
		}

		List<WebElement> ratePlanTaxCheckBox = SeleniumRepo.driver.findElements(By.xpath(
				("//*[@id='normalRatePlan']//tr[@class='prompt'][" + Integer.toString(ratePlanRow) + "]//input")));

		// System.out.println(ratePlanRow + " " + taxColumn + " " );

		ratePlanTaxCheckBox.get(taxColumn).click();

		clearFilter();

	}

	public void saveTaxToRatePlan() {

		if (Click_Save.isDisplayed()) {

			Click_Save.click();
			logger.info("Clicked on Save button");
			test.log(Status.PASS, "Clicked on Save button");
		} else {
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL, "Failed to Click on Save button");

		}

	}

}
