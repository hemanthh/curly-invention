package com.tt.admin.pom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class Dynamic_Pricing_Rules extends BaseTest 
{
	String CheckinDate;
	String CheckoutDate;
	public float Discountprice;
	public float Discountpercent;
	public float DiscountPercent1;
	public String finalDay;
	public String finalDay_Month_Date;
	WebElement DPRCheckBox;
	public static String BlackStartdate;
	public static String BlackEnddate;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	Group_Blocks Group_Blocks = PageFactory.initElements(SeleniumRepo.driver, Group_Blocks.class);
	AlternateProperties AlternateProperties = PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Dynamic Pricing Rules')]")
	public WebElement Click_DPR;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Dynamic Pricing Rules')]/following-sibling::ul/li[1]/a[//text()[normalize-space() = 'List All']]")
	public WebElement Click_DPRListAll;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Dynamic Pricing Rules')]/following-sibling::ul/li[2]/a[//text()[normalize-space() = 'Add New']]")
	public WebElement Click_DPRAddNew;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Dynamic Pricing Rules')]")
	public WebElement DPR_Title;

	@FindBy(how = How.XPATH, using = "//select[@id='activeInactiveDpr']")
	public WebElement Select_DpractiveInactive;

	@FindBy(how = How.XPATH, using = "//select[@id='langSelect']")
	public WebElement Select_language;

	@FindBy(how = How.NAME, using = "name")
	public WebElement Enter_RuleName;

	@FindBy(how = How.NAME, using = "code")
	public WebElement Enter_RuleCode;

	@FindBy(how = How.NAME, using = "short_description")
	public WebElement Enter_ShortDescription;

	@FindBy(how = How.XPATH, using = "//*[@value='include' and @name='ipFilterOption']")
	public WebElement IncludeIP_Radiobutton;

	@FindBy(how = How.XPATH, using = "//*[@value='exclude' and @name='ipFilterOption']")
	public WebElement ExcludeIP_Radiobutton;

	@FindBy(how = How.NAME, using = "minimum_lead")
	public WebElement Enter_minimum_lead;

	@FindBy(how = How.NAME, using = "maximum_lead")
	public WebElement Enter_maximum_lead;

	@FindBy(how = How.XPATH, using = "//select[@name='minimum_no_of_rooms_booked']")
	public WebElement Select_MINRooms;

	@FindBy(how = How.XPATH, using = "//select[@name='maximum_no_of_rooms_booked']")
	public WebElement Select_MaxRooms;

	@FindBy(how = How.NAME, using = "stay_start_date")
	public WebElement Enter_CheckInDate;

	@FindBy(how = How.NAME, using = "stay_end_date")
	public WebElement Enter_CheckOutDate;

	@FindBy(how = How.NAME, using = "//*[contains(@name,'blackoutstartdate')]")
	public WebElement Enter_Blockoutstartdate;

	@FindBy(how = How.XPATH, using = "//*[contains(@name,'blackoutenddate')]")
	public WebElement Enter_BlockOutEnddate;

	@FindBy(how = How.XPATH, using = "//*[contains(@name,'blackOutStayThruEnabled')]")
	public WebElement Check_Allow_staythru;

	@FindBy(how = How.XPATH, using = "//select[contains(@name,'compounddiscountType')]")
	public WebElement Select_DPRDiscountType;

	@FindBy(how = How.NAME, using = "minimum_stay")
	public WebElement Enter_MinLOS;

	@FindBy(how = How.XPATH, using = "//font[@color='red']/li")
	public List<WebElement> Verify_Errors;

	@FindBy(how = How.XPATH, using = "//*[contains(@name,'dow_') and @type='checkbox']")
	public List<WebElement> Click_DOWDays;

	@FindBy(how = How.XPATH, using = "//*[contains(@name,'dow_f') and @type='text']")
	public List<WebElement> Enter_DOWFlatAmount;

	@FindBy(how = How.XPATH, using = "//*[contains(@name,'dow_p') and @type='text']")
	public List<WebElement> Enter_DOWPercentAmount;

	@FindBy(how = How.XPATH, using = "//*[@name='first_n_steady_or_varying' and @value='steady']")
	public WebElement Click_First_Last_Steady;

	@FindBy(how = How.XPATH, using = "//select[@name='first_last_n_steady']")
	public WebElement Select_SteadyDays;

	@FindBy(how = How.XPATH, using = "//*[@name='first_last_n_steady_fixed']")
	public WebElement Enter_FirstLastSteadyFlatAmount;

	@FindBy(how = How.XPATH, using = "//*[@name='first_last_n_steady_percentage']")
	public WebElement Enter_FirstLastSteadyPercentage;

	@FindBy(how = How.XPATH, using = "//*[@name='all_nights_steady_or_varying' and @value='steady']")
	public WebElement Click_AllNights_Steady;

	@FindBy(how = How.XPATH, using = "//*[@name='all_nights_steady_fixed']")
	public WebElement Enter_AllNightsSteadyFlatAmount;

	@FindBy(how = How.XPATH, using = "//*[@name='all_nights_steady_percentage']")
	public WebElement Enter_AllNightsSteadyPercentage;

	@FindBy(how = How.XPATH, using = "//select[@name='nth_night']")
	public WebElement Select_NthNight;

	@FindBy(how = How.XPATH, using = "//*[@name='nth_night_steady_fixed']")
	public WebElement Enter_NthNightFlatAmount;

	@FindBy(how = How.XPATH, using = "//*[@name='nth_night_steady_percentage']")
	public WebElement Enter_NthNightPercentage;

	@FindBy(how = How.XPATH, using = "//*[@value='nth_night']")
	public WebElement Click_NthNight;

	@FindBy(how = How.XPATH, using = "//*[@name='ipFilterOption' and @value='include']")
	public WebElement RadioButton_IncludeIP;

	@FindBy(how = How.XPATH, using = "//*[@name='ipFilterOption' and @value='exclude']")
	public WebElement RadioButton_ExcludeIP;

	@FindBy(how = How.XPATH, using = "//*[@id='ipAddress1']")
	public WebElement Enter_IPAddress;

	@FindBy(how = How.XPATH, using = "//*[@id='ipAddressDesc1']")
	public WebElement Enter_IPAddressDescrption;
	
	@FindBy(how = How.XPATH, using = "//*[@name='geoConditionOption' and @value='Include']")
	public WebElement RadioButton_IncludeGEOGRAPHIC;

	@FindBy(how = How.XPATH, using = "//*[@name='ipFilterOption' and @value='Exclude']")
	public WebElement RadioButton_ExcludeGEOGRAPHIC ;
	
	@FindBy(how = How.XPATH, using = "//select[@name='continent1']")
	public WebElement Select_Continent ;
	
	@FindBy(how = How.XPATH, using = "//*[@name='country1']/following-sibling::span/input")
	public WebElement Enter_Country ;
	
	@FindBy(how = How.XPATH, using = "//*[@name='state1']/following-sibling::span/input")
	public WebElement Enter_State ;
	
	@FindBy(how = How.XPATH, using = "//*[@name='city1']")
	public WebElement Enter_City;

	@FindBy(how = How.XPATH, using = "//*[@name='selectGeoEntry1']")
	public WebElement Click_GeoEntryCheckbox;

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-1']")
	public WebElement Select_firststate;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Copy Rate Rules']")
	public WebElement CopyDPR_Title;
	
	@FindBy(how = How.XPATH, using = "//*[@value='Copy']")
	public WebElement Copy;
	
	@FindBy(how = How.TAG_NAME, using = "body")
	public WebElement Body;
	
	@FindBy(how = How.XPATH, using = "//*[@name='blackoutstartdate1']")
	public WebElement Black_Startdate;
	
	@FindBy(how = How.XPATH, using = "//*[@name='blackoutenddate1']")
	public WebElement Black_Enddate;
	

	public void Click_DPR() {
		if (Click_DPR.isDisplayed()) {
			Click_DPR.click();
			ExplicitWait(Click_DPRListAll);
			// System.out.println("DPR clicked Successfully");
			test.log(Status.PASS, "DPR clicked Successfully	");
			logger.info("DPR clicked Successfully	");
		} else {
			// System.out.println("DPR link not found");
			test.log(Status.FAIL, "DPR link not found");
			logger.error("DPR link not found");
		}
	}

	public void Click_DPRListAll() 
	{

		if (Click_DPRListAll.isDisplayed()) 
		{
			Click_DPRListAll.click();
			ExplicitWait(DPR_Title);
			// System.out.println("DPR link Expanded and List All element found");
			test.log(Status.INFO, "DPR link Expanded and List All element  found");
			logger.info("DPR link Expanded and List All element  found");

		} 

		else 
		{
			Javascriptexecutor(Click_DPR);
			// System.out.println("Clicked on DPR Link");
			test.log(Status.INFO, "Clicked on DPR Link");
			logger.info("Clicked on DPR Link");

			ExplicitWait(Click_DPRListAll);

			if (Click_DPRListAll.isDisplayed())
			{
				Click_DPRListAll.click();
				SeleniumRepo.waitForPageLoaded();
				// System.out.println("Clicked on List All link");
				test.log(Status.PASS, "Clicked on List All link");
				logger.info("Clicked on List All link");

				ExplicitWait(DPR_Title);
				if (Group_Blocks.BODY.getText().contains("No rules available for this property.")) 
				{
					// System.out.println("DPR is not created yet");
					test.log(Status.INFO, "DPR is not created yet");
				} 
				else
				{
					// System.out.println("DPR rule is created");
					test.log(Status.INFO, "DPR rule is created");
				}

			} 
			else 

			{
				// System.out.println("List All element not found");
				logger.error("List All element not found");
				test.log(Status.FAIL, "List All element not found");
			}
		}
	}

	public void Click_DPRAddNew() 
	{
		ExplicitWait(Click_DPRAddNew);
		if (Click_DPRAddNew.isDisplayed()) 
		{
			Click_DPRAddNew.click();
			ExplicitWait(DPR_Title);
			// System.out.println("DPR link Expanded and Add New element found");
			test.log(Status.INFO, "DPR link Expanded and Add New element  found");
			logger.info("DPR link Expanded and Add New element  found");

		} 
		else 
		{
			Javascriptexecutor(Click_DPR);
			// System.out.println();
			test.log(Status.INFO, "Clicked on DPR Link");
			logger.info("Clicked on DPR Link");

			ExplicitWait(Click_DPRAddNew);

			if (Click_DPRAddNew.isDisplayed()) 
			{
				Click_DPRAddNew.click();

				// System.out.println( "Clicked on Add New link");
				test.log(Status.PASS, "Clicked on Add New link");
				logger.info("Clicked on Add New link");

				ExplicitWait(DPR_Title);
			} 

			else 
			{
				// System.out.println("Add New element not found");
				logger.error("Add New element not found");
				test.log(Status.FAIL, "Add New element not found");
			}
		}
	}

	public void verify_ErrorMessages(String Errors) throws InterruptedException 
	{
		Thread.sleep(2000);
		for (WebElement error : Verify_Errors)

		{
			if (Errors.contains(error.getText()))
			{
				// System.out.println("Error "+error.getText()+" displayed successfully");
				logger.info("Error " + error.getText() + " displayed successfully");
				test.log(Status.PASS, "Error " + error.getText() + " displayed successfully");
			} 
			else 
			{
				// System.out.println("Error "+error.getText()+" is not displayed");
				logger.error("Error " + error.getText() + " is not displayed");
				test.log(Status.FAIL, "Error " + error.getText() + " is not displayed");
			}
		}
	}

	public void Enter_RuleName(String RuleName) {
		ExplicitWait(Enter_RuleName);
		if (Enter_RuleName.isDisplayed()) {
			Enter_RuleName.sendKeys(RuleName);
			// System.out.println("Rule Name Enterd is : "+RuleName);
			logger.info("Rule Name Enterd is : " + RuleName);
			test.log(Status.INFO, "Rule Name Enterd is : " + RuleName);
		} else {
			// System.out.println("Rule Name text field not found");
			logger.error("Rule Name text field not found");
			test.log(Status.FAIL, "Rule Name text field not found");
		}
	}

	public void Enter_RuleCode(String RuleCode) {
		ExplicitWait(Enter_RuleCode);
		if (Enter_RuleCode.isDisplayed()) {
			Enter_RuleCode.sendKeys(RuleCode);
			// System.out.println("Rule Code Enterd is : "+RuleCode);
			logger.info("Rule Code Enterd is : " + RuleCode);
			test.log(Status.INFO, "Rule Code Enterd is : " + RuleCode);
		} else {
			// System.out.println("Rule Code text field not found");
			logger.error("Rule Code text field not found");
			test.log(Status.FAIL, "Rule Code text field not found");
		}
	}

	public void Enter_ShortDescription(String ShortDescription) {
		ExplicitWait(Enter_ShortDescription);
		if (Enter_ShortDescription.isDisplayed()) {
			Enter_ShortDescription.sendKeys(ShortDescription);
			// System.out.println("ShortDescription Enterd is : "+ShortDescription);
			logger.info("ShortDescription Enterd is : " + ShortDescription);
			test.log(Status.INFO, "ShortDescription Enterd is : " + ShortDescription);
		} else {
			// System.out.println("ShortDescription text field not found");
			logger.error("ShortDescription text field not found");
			test.log(Status.FAIL, "ShortDescription text field not found");
		}
	}

	@SuppressWarnings("deprecation")
	public void Enter_CheckInDate() {
		Date date1 = new Date();
		date1.setDate(date1.getDate());
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		CheckinDate = df1.format(date1);

		if (Enter_CheckInDate.isDisplayed()) {
			Enter_CheckInDate.click();
			Enter_CheckInDate.sendKeys(CheckinDate);
			// System.out.println("Checkin date is:-"+CheckinDate);
			test.log(Status.INFO, "Checkin date is:-" + CheckinDate);
			logger.info("Checkin date is:-" + CheckinDate);
		} else {
			// System.out.println("CheckinDate text field not found");
			logger.error("CheckinDate text field not found");
			test.log(Status.FAIL, "CheckinDate text field not found");
		}
	}

	@SuppressWarnings("deprecation")
	public void Enter_CheckOutDate() {
		Date date = new Date();
		date.setDate(date.getDate() + 7);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
		CheckoutDate = df.format(date);

		if (Enter_CheckOutDate.isDisplayed()) {
			Enter_CheckOutDate.click();
			Enter_CheckOutDate.sendKeys(CheckoutDate);
			// System.out.println("Checkout date is:-"+CheckoutDate);
			test.log(Status.INFO, "Checkout date is:-" + CheckoutDate);
			logger.info("Checkout date is:-" + CheckoutDate);
		} else {
			// System.out.println("CheckoutDate text field not found");
			logger.error("CheckoutDate text field not found");
			test.log(Status.FAIL, "CheckoutDate text field not found");
		}
	}

	public void select_discounttype(String discount_type) 
	{
		WebElement click_discounttype = SeleniumRepo.driver
				.findElement(By.xpath("//*[contains(text(),'" + discount_type + "')]/preceding-sibling::input"));
		Javascriptexecutor(click_discounttype);

	}

	@SuppressWarnings("deprecation")
	public float Select_DPRDiscountTypeFlatAmount(String compounddiscountType, String discount_type, String FlatAmount,
			String SteadyDays, String SteadyFlatAmount, String days, String RatePlan, String NthNight,String Percentage)
					throws InterruptedException, ParseException 
	{
		if (Select_DPRDiscountType.isDisplayed()) 
		{
			selectByVisibleText(Select_DPRDiscountType, compounddiscountType);
			Thread.sleep(2000);
			if (discount_type.equals("Day Of Week")) 
			{
				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (days.equals("ALL")) 
				{
					System.out.println("Select All Days");
					test.log(Status.INFO, "Selecct All Days");
					logger.info("Selecct All Days");
					for (WebElement clickday : Click_DOWDays) 

					{
						Javascriptexecutor(clickday);
					}
					for (WebElement Enter_amount : Enter_DOWFlatAmount) 
					{
						Enter_amount.sendKeys(FlatAmount);
						float DaysCount = Click_DOWDays.size();
						float FlatAmount_float = Float.parseFloat(FlatAmount);
						Discountprice = FlatAmount_float * 7 / DaysCount;
					}
					System.out.println("The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountprice);
					test.log(Status.INFO,
							"The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountprice);
					logger.info("The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountprice);
				} 
				else if (days.equals("AnyDay")) 
				{
					System.out.println("Select Any Days");
					Date date = new Date();
					date.setDate(date.getDate() + 1);
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String Nextday = df.format(date);

					Date dt1 = df.parse(Nextday);
					DateFormat format2 = new SimpleDateFormat("EEE");
					finalDay = format2.format(dt1);

					DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
					finalDay_Month_Date = format3.format(dt1);

					WebElement daycheckbox = SeleniumRepo.driver
							.findElement(By.xpath("//td[contains(text(),'" + finalDay + "')]/input"));
					daycheckbox.click();
					try 
					{

						WebElement flatext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_f_"+ finalDay.toLowerCase().substring(0, 2) + "') and @type='text']"));
						flatext.sendKeys(FlatAmount);
					} 
					catch (Exception e)
					{

						WebElement flatext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_f_"+ finalDay.toLowerCase().substring(0, 1) + "') and @type='text']"));
						flatext.sendKeys(FlatAmount);
					}

					Discountprice = Float.parseFloat(FlatAmount);

					// System.out.println("The discount Price for the rate plan:-"+RatePlan+"
					// is:-"+Discountprice);
					test.log(Status.INFO,
							"The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountprice);
					logger.info("The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountprice);

				}
			} 
			else if (discount_type.equals("First N Nights")) 
			{
				System.out.println("Select First N Nights");
				Date date = new Date();
				date.setDate(date.getDate() + 1);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String Nextday = df.format(date);
				Date dt1 = df.parse(Nextday);

				DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
				finalDay_Month_Date = format3.format(dt1);

				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_First_Last_Steady.isSelected()) 
				{
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				} 
				else 
				{
					Click_First_Last_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Select_SteadyDays.isDisplayed() && Enter_FirstLastSteadyFlatAmount.isDisplayed()) 
				{
					selectByVisibleText(Select_SteadyDays, SteadyDays);
					Enter_FirstLastSteadyFlatAmount.sendKeys(SteadyFlatAmount);
					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "Num Days and Flat text field is displayed and selected");
				} 
				else
				{
					// System.out.println("Num Days dropdown or Flat text field not found");
					test.log(Status.FAIL, "Num Days dropdown or Flat text field not found");
					logger.error("Num Days dropdown or Flat text field not found");
				}
			}
			else if (discount_type.equals("Last N Nights")) 
			{
				System.out.println("Select Last N Nights");
				Date date = new Date();
				date.setDate(date.getDate() + 5);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String Nextday = df.format(date);
				Date dt1 = df.parse(Nextday);

				DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
				finalDay_Month_Date = format3.format(dt1);

				System.out.println("finalDay_Month_Date " + finalDay_Month_Date);

				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_First_Last_Steady.isSelected()) 
				{
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				else 
				{
					Click_First_Last_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Select_SteadyDays.isDisplayed() && Enter_FirstLastSteadyFlatAmount.isDisplayed()) 
				{
					selectByVisibleText(Select_SteadyDays, SteadyDays);
					Enter_FirstLastSteadyFlatAmount.sendKeys(SteadyFlatAmount);
					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "Num Days and Flat text field is displayed and selected");
				} 
				else 
				{
					// System.out.println("Num Days dropdown or Flat text field not found");
					test.log(Status.FAIL, "Num Days dropdown or Flat text field not found");
					logger.error("Num Days dropdown or Flat text field not found");
				}
			} 
			else if (discount_type.equals("All Nights")) 
			{
				System.out.println("Select All Nights");
				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_AllNights_Steady.isSelected()) 
				{
					// System.out.println( "Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				} 
				else 
				{
					Click_AllNights_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Enter_AllNightsSteadyFlatAmount.isDisplayed())
				{

					Enter_AllNightsSteadyFlatAmount.sendKeys(SteadyFlatAmount);
					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "Num Days and Flat text field is displayed and selected");
				} 
				else 
				{
					// System.out.println();
					test.log(Status.FAIL, "Num Days dropdown or Flat text field not found");
					logger.error("Num Days dropdown or Flat text field not found");
				}
			} 
			else if (discount_type.equals("Nth Night"))
			{
				System.out.println("Select Nth Night");
				// select_discounttype(discount_type);

				Click_NthNight.click();

				Thread.sleep(1000);
				if (Select_NthNight.isDisplayed()) 
				{
					selectByVisibleText(Select_NthNight, NthNight);
					// System.out.println("Nth Night Dropdown displayed and selected "+NthNight+"
					// night");
					test.log(Status.INFO, "Nth Night Dropdown displayed and selected " + SteadyDays + " night");
					logger.info("Nth Night Dropdown displayed and selected " + SteadyDays + " night");
				}

				if (Enter_NthNightFlatAmount.isDisplayed()) 
				{

					Enter_NthNightFlatAmount.sendKeys(SteadyFlatAmount);
					// System.out.println(" Flat text field is displayed and Enterd
					// "+SteadyFlatAmount);
					test.log(Status.INFO, " Flat text field is displayed and Enterd " + SteadyFlatAmount);
					logger.info(" Flat text field is displayed and Enterd " + SteadyFlatAmount);
				} 
				else 
				{
					// System.out.println("Nth Flat Amount text field not found");
					test.log(Status.FAIL, "Nth Flat Amount text field not found");
					logger.error("Nth Flat Amount text field not found");
				}
			}

		}
		return Discountprice;
	}

	@SuppressWarnings("deprecation")
	public float Select_DPRDiscountTypePercent(String compounddiscountType, String discount_type, String Percentage,String SteadyDays,String days, String RatePlan, String NthNight)
			throws InterruptedException, ParseException 
	{
		if (Select_DPRDiscountType.isDisplayed()) 
		{
			selectByVisibleText(Select_DPRDiscountType, compounddiscountType);
			Thread.sleep(2000);
			if (discount_type.equals("Day Of Week")) 
			{
				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (days.equals("ALL")) 
				{
					System.out.println("Selecct All Days");
					test.log(Status.INFO, "Selecct All Days");
					logger.info("Selecct All Days");
					for (WebElement clickday : Click_DOWDays) 

					{
						Javascriptexecutor(clickday);
					}
					for (WebElement Enter_amount : Enter_DOWPercentAmount) 
					{
						Enter_amount.sendKeys(Percentage);

						float DaysCount = Click_DOWDays.size();
						float Percentage_float = Float.parseFloat(Percentage);

						Discountpercent = Percentage_float * 7 / DaysCount;
					}
					System.out.println("The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountpercent+"%");
					test.log(Status.INFO,
							"The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountpercent+"%");
					logger.info("The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountpercent+"%");
				} 
				else if (days.equals("AnyDay")) 
				{
					System.out.println("Selected AnyDay");
					test.log(Status.INFO, "Selected Any Day");
					logger.info("Selecct All Days");

					Date date = new Date();
					date.setDate(date.getDate() + 1);
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String Nextday = df.format(date);

					Date dt1 = df.parse(Nextday);
					DateFormat format2 = new SimpleDateFormat("EEE");
					finalDay = format2.format(dt1);

					DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
					finalDay_Month_Date = format3.format(dt1);

					WebElement daycheckbox = SeleniumRepo.driver
							.findElement(By.xpath("//td[contains(text(),'" + finalDay + "')]/input"));
					Javascriptexecutor(daycheckbox);
					try 
					{

						WebElement Percentageext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_p_"+ finalDay.toLowerCase().substring(0, 2) + "') and @type='text']"));
						Percentageext.sendKeys(Percentage);
					} 
					catch (Exception e)
					{

						WebElement Percentageext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_p_"+ finalDay.toLowerCase().substring(0, 1) + "') and @type='text']"));
						Percentageext.sendKeys(Percentage);
					}

					Discountpercent = Float.parseFloat(Percentage);
					// System.out.println("The discount Price for the rate plan:-"+RatePlan+"
					// is:-"+Discountprice);
					test.log(Status.INFO,
							"The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountpercent+"%");
					logger.info("The discount Price for the rate plan:-" + RatePlan + " is:-" + Discountpercent+"%");

				}
			} 
			else if (discount_type.equals("First N Nights")) 
			{
				Date date = new Date();
				date.setDate(date.getDate() + 1);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String Nextday = df.format(date);
				Date dt1 = df.parse(Nextday);

				DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
				finalDay_Month_Date = format3.format(dt1);

				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_First_Last_Steady.isSelected()) 
				{
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				} 
				else 
				{
					Click_First_Last_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Select_SteadyDays.isDisplayed() && Enter_FirstLastSteadyPercentage.isDisplayed()) 
				{
					Discountpercent = Float.parseFloat(Percentage);

					selectByVisibleText(Select_SteadyDays, SteadyDays);
					Enter_FirstLastSteadyPercentage.sendKeys(Percentage);
					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "Num Days and Percentage text field is displayed and selected");
				} 
				else
				{
					// System.out.println("Num Days dropdown or Flat text field not found");
					test.log(Status.FAIL, "Num Days dropdown or Percentage text field not found");
					logger.error("Num Days dropdown or Percentage text field not found");
				}
			}
			else if (discount_type.equals("Last N Nights")) 
			{
				Discountpercent = Integer.parseInt(Percentage);
				Date date = new Date();
				date.setDate(date.getDate() + 5);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String Nextday = df.format(date);
				Date dt1 = df.parse(Nextday);

				DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
				finalDay_Month_Date = format3.format(dt1);

				System.out.println("finalDay_Month_Date " + finalDay_Month_Date);

				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_First_Last_Steady.isSelected()) 
				{
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				else 
				{
					Click_First_Last_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Select_SteadyDays.isDisplayed() && Enter_FirstLastSteadyPercentage.isDisplayed()) 
				{
					selectByVisibleText(Select_SteadyDays, SteadyDays);
					Enter_FirstLastSteadyPercentage.sendKeys(Percentage);
					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "Num Days and Percentage text field is displayed and selected");
				} 
				else 
				{
					// System.out.println("Num Days dropdown or Flat text field not found");
					test.log(Status.FAIL, "Num Days dropdown or Percentage text field not found");
					logger.error("Num Days dropdown or Percentage text field not found");
				}
			} 
			else if (discount_type.equals("All Nights")) 
			{
				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_AllNights_Steady.isSelected()) 
				{
					Discountpercent = Float.parseFloat(Percentage);
					// System.out.println( "Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				} 
				else 
				{
					Click_AllNights_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Enter_AllNightsSteadyPercentage.isDisplayed())
				{

					Enter_AllNightsSteadyPercentage.sendKeys(Percentage);
					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "Num Days and Percentage text field is displayed and selected");
				} 
				else 
				{
					// System.out.println();
					test.log(Status.FAIL, "Num Days dropdown or Percentage text field not found");
					logger.error("Num Days dropdown or Percentage text field not found");
				}
			} 
			else if (discount_type.equals("Nth Night"))
			{
				// select_discounttype(discount_type);

				Click_NthNight.click();

				Thread.sleep(1000);
				if (Select_NthNight.isDisplayed()) 
				{
					Discountpercent = Float.parseFloat(Percentage);
					selectByVisibleText(Select_NthNight, NthNight);
					// System.out.println("Nth Night Dropdown displayed and selected "+NthNight+"
					// night");
					test.log(Status.INFO, "Nth Night Dropdown displayed and selected " + SteadyDays + " night");
					logger.info("Nth Night Dropdown displayed and selected " + SteadyDays + " night");
				}

				if (Enter_NthNightPercentage.isDisplayed()) 
				{

					Enter_NthNightPercentage.sendKeys(Percentage);
					// System.out.println(" Flat text field is displayed and Enterd
					// "+SteadyFlatAmount);
					test.log(Status.INFO, " Percentage text field is displayed and Enterd " + Percentage);
					logger.info(" Percentage text field is displayed and Enterd " + Percentage);
				} 
				else 
				{
					// System.out.println("Nth Flat Amount text field not found");
					test.log(Status.FAIL, "Nth Percentage Amount text field not found");
					logger.error("Nth Percentage Amount text field not found");
				}
			}

		}
		return Discountpercent;
	}

	public float Select_DPRDiscountTypeFlatthenPercentage(String compounddiscountType, String discount_type, String FlatAmount,
			String SteadyDays, String SteadyFlatAmount, String days, String RatePlan, String NthNight,String Percentage)
					throws InterruptedException, ParseException 
	{
		if (Select_DPRDiscountType.isDisplayed()) 
		{
			selectByVisibleText(Select_DPRDiscountType, compounddiscountType);

			Thread.sleep(2000);

			if (discount_type.equals("Day Of Week")) 
			{
				select_discounttype(discount_type);

				Thread.sleep(1000);

				if (days.equals("ALL")) 
				{
					System.out.println("Select All Days");
					test.log(Status.INFO, "Selecct All Days");
					logger.info("Selecct All Days");
					for (WebElement clickday : Click_DOWDays) 

					{
						Javascriptexecutor(clickday);
					}
					for (WebElement Enter_Flatamount : Enter_DOWFlatAmount) 
					{
						Enter_Flatamount.clear();
						Enter_Flatamount.sendKeys(FlatAmount);

						float DaysCount = Click_DOWDays.size();
						float FlatAmount_float = Float.parseFloat(FlatAmount);
					}
					for (WebElement Enter_Percentage: Enter_DOWPercentAmount) 
					{
						Enter_Percentage.clear();
						Enter_Percentage.sendKeys(Percentage);

						float DaysCount = Click_DOWDays.size();
						float Percentage_float = Float.parseFloat(Percentage);	
					}

					System.out.println("Flat Amount for All days:-"+FlatAmount+"then Percentage:-"+Percentage);
					test.log(Status.INFO,
							"Flat Amount for All days:-"+FlatAmount+"then Percentage:-"+Percentage);
					logger.info("Flat Amount for All days:-"+FlatAmount+"then Percentage:-"+Percentage);
				} 
				else if (days.equals("AnyDay")) 
				{
					System.out.println("Select Any Days");
					Date date = new Date();
					date.setDate(date.getDate() + 1);
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String Nextday = df.format(date);

					Date dt1 = df.parse(Nextday);
					DateFormat format2 = new SimpleDateFormat("EEE");
					finalDay = format2.format(dt1);

					DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
					finalDay_Month_Date = format3.format(dt1);

					WebElement daycheckbox = SeleniumRepo.driver
							.findElement(By.xpath("//td[contains(text(),'" + finalDay + "')]/input"));
					daycheckbox.click();
					try 
					{

						WebElement flatext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_f_"+ finalDay.toLowerCase().substring(0, 2) + "') and @type='text']"));
						flatext.sendKeys(FlatAmount);
						WebElement Percentageext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_p_"+ finalDay.toLowerCase().substring(0, 2) + "') and @type='text']"));
						Percentageext.sendKeys(Percentage);
					} 
					catch (Exception e)
					{

						WebElement flatext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_f_"+ finalDay.toLowerCase().substring(0, 1) + "') and @type='text']"));
						flatext.sendKeys(FlatAmount);
						WebElement Percentageext = SeleniumRepo.driver.findElement(By.xpath("//*[contains(@name,'dow_p_"+ finalDay.toLowerCase().substring(0, 1) + "') and @type='text']"));
						Percentageext.sendKeys(Percentage);
					}

					// System.out.println("The discount Price for the rate plan:-"+RatePlan+"
					// is:-"+Discountprice);
					test.log(Status.INFO,
							"Flat Amount for "+finalDay+":-"+FlatAmount+"then Percentage:-"+Percentage);
					logger.info("Flat Amount for "+finalDay+":-"+FlatAmount+"then Percentage:-"+Percentage);

				}
			} 
			else if (discount_type.equals("First N Nights")) 
			{
				System.out.println("Select First N Nights");
				Date date = new Date();
				date.setDate(date.getDate() + 1);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String Nextday = df.format(date);
				Date dt1 = df.parse(Nextday);

				DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
				finalDay_Month_Date = format3.format(dt1);

				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_First_Last_Steady.isSelected()) 
				{
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				} 
				else 
				{
					Click_First_Last_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Select_SteadyDays.isDisplayed() && Enter_FirstLastSteadyFlatAmount.isDisplayed()) 
				{
					selectByVisibleText(Select_SteadyDays, SteadyDays);
					Enter_FirstLastSteadyFlatAmount.sendKeys(SteadyFlatAmount);
					Enter_FirstLastSteadyPercentage.sendKeys(Percentage);

					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "FlatAmount then Percentage for First N nights enterd successfully");
				} 
				else
				{
					// System.out.println("Num Days dropdown or Flat text field not found");
					test.log(Status.FAIL, "Num Days dropdown or Flat and Percentage field not found");
					logger.error("Num Days dropdown or Flat and Percentage field not found");
				}
			}
			else if (discount_type.equals("Last N Nights")) 
			{
				System.out.println("Select Last N Nights");
				Date date = new Date();
				date.setDate(date.getDate() + 5);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String Nextday = df.format(date);
				Date dt1 = df.parse(Nextday);

				DateFormat format3 = new SimpleDateFormat("EEE MMM d, YYYY");
				finalDay_Month_Date = format3.format(dt1);

				System.out.println("finalDay_Month_Date " + finalDay_Month_Date);

				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_First_Last_Steady.isSelected()) 
				{
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				else 
				{
					Click_First_Last_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Select_SteadyDays.isDisplayed() && Enter_FirstLastSteadyFlatAmount.isDisplayed()) 
				{
					selectByVisibleText(Select_SteadyDays, SteadyDays);
					Enter_FirstLastSteadyFlatAmount.sendKeys(SteadyFlatAmount);
					Enter_FirstLastSteadyPercentage.sendKeys(Percentage);

					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "FlatAmount then Percentage for Last N nights enterd successfully");
				} 
				else 
				{
					// System.out.println("Num Days dropdown or Flat text field not found");
					test.log(Status.FAIL, "Num Days dropdown or Flat and Percentage text field not found");
					logger.error("Num Days dropdown or Flat and Percentage text field not found");
				}
			} 
			else if (discount_type.equals("All Nights")) 
			{
				System.out.println("Select All Nights");
				select_discounttype(discount_type);
				Thread.sleep(1000);
				if (Click_AllNights_Steady.isSelected()) 
				{
					// System.out.println( "Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				} 
				else 
				{
					Click_AllNights_Steady.click();
					// System.out.println("Steady Radio button for the "+discount_type+" is
					// displayed and selected");
					test.log(Status.INFO,
							"Steady Radio button for the " + discount_type + " is displayed and selected");
					logger.info("Steady Radio button for the " + discount_type + " is displayed and selected");
				}
				if (Enter_AllNightsSteadyFlatAmount.isDisplayed())
				{

					Enter_AllNightsSteadyFlatAmount.sendKeys(SteadyFlatAmount);
					Enter_AllNightsSteadyPercentage.sendKeys(Percentage);
					// System.out.println("Num Days and Flat text field is displayed and selected");
					test.log(Status.INFO, "Num Days and Flat and Percentage text field is displayed and selected");
				} 
				else 
				{
					// System.out.println();
					test.log(Status.FAIL, "Num Days dropdown or Flat and Percentage text field not found");
					logger.error("Num Days dropdown or Flat and Percentage text field not found");
				}
			} 
			else if (discount_type.equals("Nth Night"))
			{
				System.out.println("Select Nth Night");
				// select_discounttype(discount_type);

				Click_NthNight.click();

				Thread.sleep(1000);
				if (Select_NthNight.isDisplayed()) 
				{
					selectByVisibleText(Select_NthNight, NthNight);
					// System.out.println("Nth Night Dropdown displayed and selected "+NthNight+"
					// night");
					test.log(Status.INFO, "Nth Night Dropdown displayed and selected " + SteadyDays + " night");
					logger.info("Nth Night Dropdown displayed and selected " + SteadyDays + " night");
				}

				if (Enter_NthNightFlatAmount.isDisplayed()) 
				{

					Enter_NthNightFlatAmount.sendKeys(SteadyFlatAmount);
					Enter_NthNightPercentage.sendKeys(Percentage);
					// System.out.println(" Flat text field is displayed and Enterd
					// "+SteadyFlatAmount);
					test.log(Status.INFO, " Flat and Percentage text field is displayed and Enterd " + SteadyFlatAmount);
					logger.info(" Flat and Percentage text field is displayed and Enterd " + SteadyFlatAmount);
				} 
				else 
				{
					// System.out.println("Nth Flat Amount text field not found");
					test.log(Status.FAIL, "Nth Flat and Percentage text field not found");
					logger.error("Nth  Flat and Percentage text field not found");
				}
			}
		}
		return DiscountPercent1;
	}

	public void Select_Rateplan(String RatePlan) 
	{
		WebElement RoomCheckbox = SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'" + RatePlan
				+ "') and @tf_colkey='rateCode']/following-sibling::td/input[contains(@name,'rooms_all_')]"));
		if (RoomCheckbox.isDisplayed()) 
		{
			Javascriptexecutor(RoomCheckbox);
			// System.out.println("Rooms checked for the rate plan:-"+RatePlan);
			test.log(Status.INFO, "Rooms checked for the rate plan:-" + RatePlan);
			logger.info("Rooms checked for the rate plan:-" + RatePlan);
		}
		else
		{
			// System.out.println(RatePlan+" Rateplan is not dsiplayed");
			test.log(Status.INFO, RatePlan + " Rateplan is not dsiplayed");
		}

	}


	public void Delete_DuplictaeDPR(String DPRRuleName) throws InterruptedException {
		try {
			DPRCheckBox = SeleniumRepo.driver.findElement(
					By.xpath("//*[contains(text(),'" + DPRRuleName + "')]/../preceding-sibling::td/input"));
			DPRCheckBox.click();
			AlternateProperties.Delete.click();
			Thread.sleep(2000);
			Alert alert = SeleniumRepo.driver.switchTo().alert();
			String alertText = alert.getText();
			// System.out.println("Alert data: " + alertText);
			alert.accept();
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(DPR_Title);
		} catch (Exception e) {
			// System.out.println("There are no duplicate DPRS created with the
			// name:-"+DPRRuleName);
			test.log(Status.INFO, "There are no duplicate DPRS created with the name:-" + DPRRuleName);
		}

	}

	public void OpenDPR(String DPRRuleName)
	{
		WebElement DPR=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+DPRRuleName+"')]"));
		if(DPR.isDisplayed())
		{
			DPR.click();
			ExplicitWait(DPR_Title);
			System.out.println("Clicked on DPR");
		}
	}
	public void verifyDPRatTitlePage(String RuleName) throws InterruptedException 
	{
		ExplicitWait(DPR_Title);
		Thread.sleep(1000);
		if (AlternateProperties.Body.getText().contains(RuleName)) {
			// System.out.println(RuleName+" DPR Added Successfully");
			test.log(Status.INFO, RuleName + " DPR Added Successfully");
			logger.info(RuleName + " DPR Added Successfully");
		} else {
			test.log(Status.FAIL, RuleName + " DPR is not Added ");
			logger.error(RuleName + " DPR is not Added ");
		}

	}
	public float ReuseDPRFlat(String DPRRuleName,String RuleCode,String ShortDescription,String compounddiscountType, String discount_type, String FlatAmount,
			String SteadyDays, String SteadyFlatAmount, String days, String RatePlan, String NthNight,String Percentage) throws InterruptedException, ParseException
	{
		Click_DPRListAll();
		Delete_DuplictaeDPR(DPRRuleName);
		Click_DPRAddNew();
		Enter_RuleName(DPRRuleName);
		Enter_RuleCode(RuleCode);
		Enter_ShortDescription(ShortDescription);
		Enter_CheckInDate();
		Enter_CheckOutDate();

		if(compounddiscountType.equals("Flat Amount"))
		{
			Discountprice=Select_DPRDiscountTypeFlatAmount(compounddiscountType,discount_type, FlatAmount, SteadyDays, SteadyFlatAmount,days,RatePlan,NthNight,Percentage);
		}
		else if(compounddiscountType.equals("Percentage"))
		{
			DiscountPercent1=Select_DPRDiscountTypePercent(compounddiscountType, discount_type, Percentage, SteadyDays,days,RatePlan,NthNight);
		}
		else if(compounddiscountType.equals("Flat Amount then Percentage")||compounddiscountType.equals("Percentage then Flat Amount"))
		{
			DiscountPercent1=Select_DPRDiscountTypeFlatthenPercentage(compounddiscountType,discount_type, FlatAmount, SteadyDays, SteadyFlatAmount,days,RatePlan,NthNight,Percentage);
		}

		Select_Rateplan(RatePlan);
		AlternateProperties.Click_Save();
		verifyDPRatTitlePage(DPRRuleName);
		return Discountprice;
	}
	public void Include_IpAddress(String IPAddress)
	{
		if(RadioButton_IncludeIP.isDisplayed())
		{
			if(RadioButton_IncludeIP.isSelected())
			{
				Enter_IPAddress.sendKeys(IPAddress);
				System.out.println("Included Ip Address is:-"+IPAddress);
				test.log(Status.INFO, "Included Ip Address is:-"+IPAddress);
				logger.info("Included Ip Address is:-"+IPAddress);
			}
			else
			{
				RadioButton_IncludeIP.click();
				Enter_IPAddress.sendKeys(IPAddress);
				System.out.println("Included Ip Address is:-"+IPAddress);
				test.log(Status.INFO, "Included Ip Address is:-"+IPAddress);
				logger.info("Included Ip Address is:-"+IPAddress);
			}
		}
		else
		{
			test.log(Status.FAIL, "Include IP Address Radio Button not Found");
			logger.error("Include IP Address Radio Button not Found");
		}
	}
	public void Exclude_IpAddress(String IPAddress)
	{
		if(RadioButton_ExcludeIP.isDisplayed())
		{
			if(RadioButton_ExcludeIP.isSelected())
			{
				RadioButton_ExcludeIP.sendKeys(IPAddress);
				System.out.println("Excluded Ip Address is:-"+IPAddress);
				test.log(Status.INFO, "Excluded Ip Address is:-"+IPAddress);
				logger.info("Excluded Ip Address is:-"+IPAddress);
			}
			else
			{
				RadioButton_ExcludeIP.click();
				RadioButton_ExcludeIP.sendKeys(IPAddress);
				System.out.println("Excluded Ip Address is:-"+IPAddress);
				test.log(Status.INFO, "Excluded Ip Address is:-"+IPAddress);
				logger.info("Excluded Ip Address is:-"+IPAddress);
			}
		}
		else
		{
			test.log(Status.FAIL, "Exclude IP Address Radio Button not Found");
			logger.error("Exclude IP Address Radio Button not Found");
		}
	}
	public void Include_GEOGRAPHIC(String Continent,String Country,String State,String City) throws InterruptedException
	{
		if(RadioButton_IncludeGEOGRAPHIC.isDisplayed())
		{
			if(RadioButton_IncludeGEOGRAPHIC.isSelected())
			{
				selectByVisibleText(Select_Continent, Continent);
				Thread.sleep(2000);
				Enter_Country.sendKeys(Country);
				Thread.sleep(5000);
				Enter_State.sendKeys(State);
				Select_firststate.click();
				Enter_City.sendKeys(City);
				Click_GeoEntryCheckbox.click();
			}
			else
			{
				RadioButton_IncludeGEOGRAPHIC.click();
				selectByVisibleText(Select_Continent, Continent);
				Thread.sleep(2000);
				Enter_Country.sendKeys(Country);
				Thread.sleep(5000);
				Enter_State.sendKeys(State);
				Select_firststate.click();
				Enter_City.sendKeys(City);
				Click_GeoEntryCheckbox.click();	
			}
		}
		else
		{
			test.log(Status.FAIL, "Include Geographic Conditions Radio Button not Found");
			logger.error("Include Geographic Conditions Radio Button not Found");
		}
	}
	public void Exclude_GEOGRAPHIC(String Continent,String Country,String State,String City) throws InterruptedException
	{
		if(RadioButton_ExcludeGEOGRAPHIC.isDisplayed())
		{
			if(RadioButton_ExcludeGEOGRAPHIC.isSelected())
			{
				selectByVisibleText(Select_Continent, Continent);
				Thread.sleep(2000);
				Enter_Country.sendKeys(Country);
				Thread.sleep(5000);
				Enter_State.sendKeys(State);
				Select_firststate.click();
				Enter_City.sendKeys(City);
				Click_GeoEntryCheckbox.click();
			}
			else
			{
				RadioButton_ExcludeGEOGRAPHIC.click();
				selectByVisibleText(Select_Continent, Continent);
				Thread.sleep(2000);
				Enter_Country.sendKeys(Country);
				Thread.sleep(5000);
				Enter_State.sendKeys(State);
				Select_firststate.click();
				Enter_City.sendKeys(City);
				Click_GeoEntryCheckbox.click();	
			}
		}
		else
		{
			test.log(Status.FAIL, "Include Geographic Conditions Radio Button not Found");
			logger.error("Include Geographic Conditions Radio Button not Found");
		}
	}
	
	public void Click_CopyDPR(String DPRRuleName) throws InterruptedException
	{
		DPRCheckBox = SeleniumRepo.driver.findElement(
				By.xpath("//*[contains(text(),'" + DPRRuleName + "')]/../preceding-sibling::td/input"));
		DPRCheckBox.click();
		
		WebElement CopyDPR=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+DPRRuleName+"')]/../following-sibling::td/a[contains(text(),'Copy')]"));
		CopyDPR.click();
		SeleniumRepo.waitForPageLoaded();
		ExplicitWait(CopyDPR_Title);
		Copy.click();
		Thread.sleep(2000);
		String body=Body.getText();
		if(body.contains("Please select at least one Property to copy Rate Rule")&&body.contains("New Rule Code is required"))
		{
			test.log(Status.PASS, "Copy DPR Errors displayed successfully");
			logger.info("Copy DPR Errors displayed successfully");
		}
		else
		{
			test.log(Status.FAIL, "DPR Errors not diplayed");
			logger.error("DPR Errors not diplayed");
		}
	}
	@SuppressWarnings("deprecation")
	public void Enter_BlackOutstartdate()
	{
		Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		BlackStartdate = df1.format(date1);

		if (Black_Startdate.isDisplayed()) 
		{
			Black_Startdate.click();
			Black_Startdate.clear();
			Black_Startdate.sendKeys(BlackStartdate);
			// System.out.println("Checkin date is:-"+CheckinDate);
			test.log(Status.INFO, "BlackStartdate is:-" + BlackStartdate);
			logger.info("BlackStartdate is:-" + BlackStartdate);
		} 
		else 
		{
			// System.out.println("CheckinDate text field not found");
			logger.error("BlackStartdate text field not found");
			test.log(Status.FAIL, "BlackStartdate text field not found");
		}
	}
	public void Enter_BlackOutEnddate()
	{
		Date date1 = new Date();
		date1.setDate(date1.getDate() + 2);
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YY");
		BlackEnddate = df1.format(date1);

		if (Black_Enddate.isDisplayed()) 
		{
			Black_Enddate.click();
			Black_Enddate.clear();
			Black_Enddate.sendKeys(BlackEnddate);
			// System.out.println("Checkin date is:-"+CheckinDate);
			test.log(Status.INFO, "BlackEnddate is:-" + BlackEnddate);
			logger.info("BlackEnddate is:-" + BlackEnddate);
		} 
		else 
		{
			// System.out.println("CheckinDate text field not found");
			logger.error("BlackStartdate text field not found");
			test.log(Status.FAIL, "BlackStartdate text field not found");
		}
	}
}
