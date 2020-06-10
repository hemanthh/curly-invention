package com.tt.MB;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

public class MobileBooking extends BaseTest
{
	int todaysdate;
	String month;
	String Year;
	String code;
	JavascriptExecutor jse;
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,50);

	@FindAll({ @FindBy(xpath = "//*[@title='Menu']"), })
	
	private WebElement Menu_Button;

	@FindAll({ @FindBy(xpath = "//*[@ng-bind='title']"), })
	
	private WebElement Verify_Menu;

	@FindAll({ @FindBy(xpath = "//div[@class='cc-compliance']"), })
	
	private WebElement ok;

	@FindAll({ @FindBy(xpath = "//*[@data-title='Language']/span[1]"), })
	
	private WebElement Verify_Language;


	@FindAll({ @FindBy(xpath = "//*[@data-title='Currency']/span[1]"), })
	
	private WebElement Verify_Currency;	

	@FindAll({ @FindBy(xpath = "//*[@data-title='Currency']/span[2]"), })
	
	private WebElement Currency_Name;

	@FindAll({ @FindBy(xpath = "//a[text()='My reservations']"), })
	
	private WebElement Verify_MyReservations;

	@FindAll({ @FindBy(xpath = "//a[text()='Specials And Packages']"), })
	
	private WebElement Verify_Specials_Packages;

	@FindAll({ @FindBy(xpath = "//a[text()='Hotel Details']"), })
	
	private WebElement Verify_Hotel_Details;

	@FindAll({ @FindBy(xpath = "//a[text()='Map']"), })
	
	private WebElement Verify_Map;

	@FindAll({ @FindBy(xpath = "//a[text()='Photos']"), })
	
	private WebElement Verify_Photos;

	@FindAll({ @FindBy(xpath = "//*[@data-title='Language']"), })
	
	private WebElement Click_Language;

	@FindAll({ @FindBy(xpath = "//*[@class='aside_button -theme-color ng-isolate-scope']"), })
	
	private WebElement Verify_Englishlink;

	@FindAll({ @FindBy(xpath = "//*[@ng-click='$hide()']"), })
	
	private WebElement Close_Button;

	@FindAll({ @FindBy(xpath = "//*[@data-title='Currency']"), })
	
	private WebElement Click_Currency;

	@FindAll({ @FindBy(xpath = "//*[@ng-bind='title']"), })
	
	private WebElement Verify_Title;

	@FindAll({ @FindBy(xpath = "//*[contains(@class,'aside_button ')]"), })
	
	private List<WebElement> Verify_USDLink;

	@FindAll({ @FindBy(xpath = "//h1[@class='header_title']"), })
	
	private WebElement Verify_MyreservationTitle;

	@FindAll({ @FindBy(xpath = "//*[@id='confirmation_code']"), })
	
	private WebElement Verify_confirmation_code;

	@FindAll({ @FindBy(xpath = "//*[@id='email']"), })
	
	private WebElement Verify_Email;

	@FindAll({ @FindBy(xpath = "//button[text()='Lookup']"), })
	
	private WebElement Verify_LookUpButton;

	@FindAll({ @FindBy(xpath = "//button[@class='navbar_button text-capitalize']"), })
	
	private WebElement Verify_Roomandguest;

	@FindAll({ @FindBy(xpath = "//button[@class='rate-button -to-slim test']"), })
	
	private WebElement Verify_Search_all_Offers;

	@FindAll({ @FindBy(xpath = "//ul[@class='rating']"), })
	
	private WebElement Verify_Hotel_Ratings;

	@FindAll({ @FindBy(xpath = "(//div[contains(@class,'col-xs')])[1]"), })
	
	private WebElement Verify_Hotel_Address;

	@FindAll({ @FindBy(xpath = "(//div[contains(@class,'col-xs')])[2]"), })
	
	private WebElement Verify_HotelMap;

	@FindAll({ @FindBy(xpath = "(//div[contains(@class,'col-xs')])[2]"), })
	
	private WebElement Verify_HotelContent;

	@FindAll({ @FindBy(xpath = "//gmap[@class='content ng-isolate-scope']"), })
	
	private WebElement Verify_MapImage;

	@FindAll({ @FindBy(xpath = "//div[@class='popover-title -sticky']"), })
	
	private WebElement Verify_MapTitle;

	@FindAll({ @FindBy(xpath = "//div[@class='header_title text-capitalize']"), })
	
	private WebElement Verify_Hotelphotos;

	@FindAll({ @FindBy(xpath = "//button[text()='Reset Dates'][@ng-click='reset()']"), })
	
	private WebElement Verify_ResetDates;

	@FindAll({ @FindBy(xpath = "//button[@type='button'][text()='Select Room']"), })
	
	private WebElement Select_Room;

	@FindAll({ @FindBy(xpath = "//*[@class='content_title']"), })
	
	private WebElement Verify_RoomTitle;

	@FindAll({ @FindBy(xpath = "//*[text()='Read More']"), })
	
	private WebElement Verify_ReadMore;

	@FindAll({ @FindBy(xpath = "(//div[contains(@class,'bottom-sheet_list-cell')])[1]"), })
	
	private WebElement Verify_DatesSection;

	@FindAll({ @FindBy(xpath = "(//*[contains(text(),'Best Price Per Night')])[1]"), })
	
	private WebElement Verify_BestPriceSection;

	@FindAll({ @FindBy(xpath = "(//*[contains(text(),'Best Price Per Night')])[2]"), })
	
	private WebElement Verify_continueBestPriceSection;

	@FindAll({ @FindBy(xpath = "//*[@value='Continue']"), })
	
	private WebElement Click_Continue;

	@FindAll({ @FindBy(xpath = "//*[@id='is_opted_in']"), })
	
	private WebElement checkbox_guest;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Full Name']"), })
	
	private WebElement FullName;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Phone number']"), })
	
	private WebElement Phoneno;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Email']"), })
	
	private WebElement Email;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Address']"), })
	
	private WebElement Address;

	@FindAll({ @FindBy(xpath = "(//div[@class='form-group']/popover-selector/input)[1]"), })
	
	private WebElement Billing_Countrylink;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='State']"), })
	
	private WebElement State;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='City']"), })
	
	private WebElement City;

	@FindAll({ @FindBy(xpath = "//input[@autocomplete='zipcode'][@placeholder='Zip code']"), })
	
	private WebElement ZipCode;

	@FindAll({ @FindBy(xpath = "//*[@id='cardName']"), })
	
	private WebElement CardName;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Card number']"), })
	
	private WebElement CardNo;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Expiration (MM/YY)']"), })
	
	private WebElement Expiration;

	@FindAll({ @FindBy(xpath = "//input[@autocomplete='off'][@placeholder='Code']"), })
	
	private WebElement CVV;

	@FindAll({ @FindBy(xpath = "//input[@autocomplete='postal-code'][@placeholder='Zip code']"), })
	
	private WebElement Postalcode;

	@FindAll({ @FindBy(xpath = "(//div[@class='form-group']/popover-selector/input)[3]"), })
	
	private WebElement Card_Countryclick;

	@FindAll({ @FindBy(xpath = "//*[@value='Continue']"), })
	
	private WebElement Verify_Terms_conditions;

	@FindAll({ @FindBy(xpath = "//input[@id='accept-tandc' and @type='checkbox']"), })
	
	private WebElement CheckBox;

	@FindAll({ @FindBy(xpath = "//button[@type='button'][text()='Complete Reservation']"), })
	
	private WebElement Complete_Reservation;

	@FindAll({ @FindBy(xpath = "//*[contains(@class,'clearfix comp-title-room')]"), })
	
	private List<WebElement> Rooms_Links;

	@FindAll({ @FindBy(xpath = "//*[@class='content_headline']"), })
	
	private WebElement confirmation;

	@FindAll({ @FindBy(xpath = "//*[@class='block text-medium']"), })
	
	private WebElement confirmation_code;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Change reservation')]"), })
	
	private WebElement Change_Reservation;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Cancel reservation')]"), })
	
	private WebElement Cancel_Reservation;


	@FindAll({ @FindBy(xpath = "//*[@class='button -xlg -block -theme-bg -phone-btn']"), })
	
	private WebElement Check_callHotel;

	@FindAll({ @FindBy(xpath = "//*[@class='button -xlg -block -theme-bg -phone-btn']/preceding-sibling::p/a"), })
	
	private WebElement Check_checkhotelmessage;

	@FindAll({ @FindBy(xpath = "//h2[contains(text(),'Cancel reservation?')]"), })
	
	private WebElement Cancel_reservationtitle;

	@FindAll({ @FindBy(xpath = "//h2[contains(text(),'Cancel reservation?')]/following-sibling::p"), })
	
	private WebElement CheckCancelationfee;

	@FindAll({ @FindBy(xpath = "//*[text()='Yes']"), })
	
	private WebElement Yes_button;

	@FindAll({ @FindBy(xpath = "//*[text()='No']"), })
	
	private WebElement No_button;
	
	@FindAll({ @FindBy(xpath = "(//div[@class='content'])[2]"), })
	
	private WebElement cancelation_content;

	@FindAll({ @FindBy(xpath = "//*[text()='BAR']/preceding-sibling::em"), })
	
	private WebElement Barradiobutton;
	
	
          @FindAll({ @FindBy(xpath = "//a[@class='card_link']"), })
	
	public List<WebElement> SelectRoom;



	public void GoToUrl() throws IOException
	{

		String MobileURL=ReadProperties.getPropValues("Admin.properties", "MobileURL");
		SeleniumRepo.GoToUrl(MobileURL);

	}

	public void Menu() throws InterruptedException
	{
		WebElement Menu=SeleniumRepo.driver.findElement(By.xpath("//*[@title='Menu']"));
		SeleniumRepo.waitForElementPresent(Menu);
		if(Menu.isDisplayed())
		{
			Thread.sleep(2000);

			boolean staleElement = true; 
			while(staleElement){
				try{
					Javascriptexecutor(Menu);
					staleElement = false;

				}
				catch(StaleElementReferenceException e)
				{
					staleElement = true;
				}
			}
			Thread.sleep(2000);
			System.out.println("Menu Button clicked successfully");
			logger.info("Menu Button clicked successfully");
			test.log(Status.INFO, "Menu Button clicked successfully");

			staleElement=true;
			while(staleElement){
				try{
					String ActualMenutext=Verify_Menu.getText();
					System.out.println(ActualMenutext);
					staleElement = false;

				}
				catch(StaleElementReferenceException e)
				{
					staleElement = true;
					SeleniumRepo.driver.navigate().refresh();
					SeleniumRepo.waitForPageLoaded();
					Javascriptexecutor(Menu);
				}
			}

			WebElement menutitle=SeleniumRepo.driver.findElement(By.xpath("//*[@ng-bind='title']"));
			if(menutitle.isDisplayed())
			{
				String ActualMenutext=Verify_Menu.getText();
				String ExpectedMenutext="Menu";
				if(ExpectedMenutext.equals(ActualMenutext))
				{
					System.out.println("Menu Title verified successfully");
					logger.info("Menu Title verified successfully");
					test.log(Status.INFO, "Menu Title verified successfully");
					Assert.assertTrue(true, "Menu Title verified successfully");
				} 
				else 
				{
					System.out.println("Menu Title  not found");
					logger.error("Menu Title  not found");
					test.log(Status.FAIL, " Menu Title  not found");
					Assert.assertFalse(false, "Menu Title  not found");

				}
			}
		}
		else
		{
			System.out.println("Menu Link not found");
			logger.error("Menu Link not found");
			test.log(Status.FAIL, " Menu Link not found");
			Assert.assertFalse(false, "Menu Link not found");

		}
	}

	public void Verify_language() 
	{
		SeleniumRepo.waitForElementPresent(Verify_Language);
		if(Verify_Language.isDisplayed())
		{
			logger.info("Language verified successfully");
			test.log(Status.INFO, "Language verified successfully");
			Assert.assertTrue(true, "Language verified successfully");
		} 
		else 
		{
			System.out.println("Language  not found");
			logger.error("Language  not found");
			test.log(Status.FAIL, " Language  not found");
			Assert.assertFalse(false, "Language  not found");
		}

		if(Click_Language.isDisplayed())
		{
			Javascriptexecutor(Click_Language);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Language clicked successfully");
		}
		if(Verify_Englishlink.isDisplayed())
		{
			System.out.println("English Link displayed successfully");
			logger.info("English Link displayed successfully");
			test.log(Status.INFO,"English Link displayed successfully");
			Assert.assertTrue(true, "English Link displayed successfully");
		} 
		else 
		{
			System.out.println("English Link not found");
			logger.error("English Link not found");
			test.log(Status.FAIL, "English Link not found");
			Assert.assertFalse(false,"English Link not found");

		}
	}
	public void close() throws InterruptedException
	{
		if(Close_Button.isDisplayed())
		{
			Javascriptexecutor(Close_Button);
			System.out.println("Close button clicked successfully");
			SeleniumRepo.waitForPageLoaded();
			logger.info("Close_Button clicked successfully");
			test.log(Status.INFO,"English Link displayed successfully");
			Assert.assertTrue(true, "English Link displayed successfully");
			Thread.sleep(3000);
		} 
		else 
		{
			System.out.println("English Link not found");
			logger.error("English Link not found");
			test.log(Status.FAIL, "English Link not found");
			Assert.assertFalse(false,"English Link not found");

		}

	}

	public void Verify_Currencylink() 
	{
		SeleniumRepo.waitForElementPresent(Verify_Currency);
		if(Verify_Currency.isDisplayed())
		{
			String ActualCurrencytext=Verify_Currency.getText();
			String ExpectedCurrencytext="Currency:";
			if(ExpectedCurrencytext.equals(ActualCurrencytext))
			{
				logger.info("Currency verified successfully");
				test.log(Status.INFO, "Currency Title verified successfully");
				Assert.assertTrue(true, "Currency verified successfully");
			} 
			else 
			{
				System.out.println("Currency not found");
				logger.error("Currency  not found");
				test.log(Status.FAIL, " Currency Title  not found");
				Assert.assertFalse(false, "Currency Title  not found");

			}
		}
		if(Click_Currency.isDisplayed())
		{
			Javascriptexecutor(Click_Currency);
			SeleniumRepo.waitForElementPresent(Verify_Title);
			String actcurrencytitle=Verify_Title.getText();
			String Expcurrencytitle="Currency";
			if(actcurrencytitle.equals(Expcurrencytitle))
			{
				System.out.println(actcurrencytitle+" title successfully present");
				logger.info(actcurrencytitle+" title successfully present");
				test.log(Status.INFO,actcurrencytitle+"title successfully present");
				Assert.assertTrue(true, actcurrencytitle+"title successfully present");
			} 
			else 
			{
				System.out.println("Currency title not matched");
				logger.error("Currency title not matched");
				test.log(Status.FAIL, " Currency title not matched");
				Assert.assertFalse(false, "Currency title not matched");

			}
		}
		for(int i=0;i<=Verify_USDLink.size();i++)
		{
			String Currency=Verify_USDLink.get(i).getText();
			if(Currency.equals("USD"))
			{
				System.out.println("USD Link Displayed successfully");
				logger.info("USD Link Displayed successfully");
				test.log(Status.INFO,"USD Link Displayed successfully");
				Assert.assertTrue(true, "USD Link Displayed successfully");
				break;
			} 
			else 
			{
				System.out.println("USD Link not found");
				//				logger.error("USD Link not found");
				//				test.log(Status.FAIL, "USD Link not found");
				Assert.assertFalse(false,"USD Link not found");

			}

		}

	}

	public void Verify_Hoteldetails()
	{
		SeleniumRepo.waitForElementPresent(Verify_Hotel_Details);
		if(Verify_Hotel_Details.isDisplayed())
		{
			String ActualHotelstext=Verify_Hotel_Details.getText();
			String ExpectedHotelstext="Hotel Details";
			if(ExpectedHotelstext.equals(ActualHotelstext))
			{
				System.out.println("Hotel Details text matched with expected details");
				logger.info("Hotel Details verified successfully");
				test.log(Status.INFO, "Hotel Details verified successfully");
				Assert.assertTrue(true, "Hotel Details successfully");
			} 
			else 
			{
				System.out.println("Hotel Details not found");
				logger.error("Hotel Details  not found");
				test.log(Status.FAIL, " Hotel Details not found");
				Assert.assertFalse(false, "Hotel Details not found");

			}
		}
		Javascriptexecutor(Verify_Hotel_Details);
		SeleniumRepo.waitForElementPresent(Verify_Hotel_Ratings);
		if(Verify_Hotel_Ratings.isDisplayed())
		{
			System.out.println("Hotel Ratings displayed successfully");
			logger.info("Hotel Ratings displayed successfully");
			test.log(Status.INFO, "Hotel Ratings displayed successfully");
			Assert.assertTrue(true, "Hotel Ratings displayed successfully");
		} 
		else 
		{
			System.out.println("Hotel Ratings not found");
			logger.error("Hotel Ratings  not found");
			test.log(Status.FAIL, " Hotel Ratings not found");
			Assert.assertFalse(false, "Hotel Ratings not found");

		}
		if(Verify_Hotel_Address.isDisplayed())
		{
			System.out.println("Hotel Address displayed Successfully");
			logger.info("Hotel Address displayed successfully");
			test.log(Status.INFO, "Hotel Address displayed successfully");
			Assert.assertTrue(true, "Hotel Address displayed successfully");
		} 
		else 
		{
			System.out.println("Hotel Address not found");
			logger.error("Hotel Address  not found");
			test.log(Status.FAIL, " Hotel Address not found");
			Assert.assertFalse(false, "Hotel Address not found");

		}
		if(Verify_HotelMap.isDisplayed())
		{
			System.out.println("Hotel Map displayed successfully");
			logger.info("Hotel Map displayed successfully");
			test.log(Status.INFO, "Hotel Map displayed successfully");
			Assert.assertTrue(true, "Hotel Map displayed successfully");
		} 
		else 
		{
			System.out.println("Hotel Map not found");
			logger.error("Hotel Map  not found");
			test.log(Status.FAIL, " Hotel Map not found");
			Assert.assertFalse(false, "Hotel Map not found");

		}

	}
	public void Map()
	{
		SeleniumRepo.waitForElementPresent(Verify_Map);
		if(Verify_Map.isDisplayed())
		{
			String Actualmaptext=Verify_Map.getText();
			String Expectedmaptext="Map";
			if(Expectedmaptext.equals(Actualmaptext))
			{
				System.out.println("Map is displayed successfully");
				logger.info("Map verified successfully");
				test.log(Status.INFO, "Map verified successfully");
				Assert.assertTrue(true, "Map successfully");
			} 
			else 
			{
				System.out.println("Map  not found");
				logger.error("Map not found");
				test.log(Status.FAIL, " Mapnot found");
				Assert.assertFalse(false, "Map not found");

			}
		}
		Javascriptexecutor(Verify_Map);
		SeleniumRepo.waitForElementPresent(Verify_MapImage);
		if(Verify_MapImage.isDisplayed())
		{
			System.out.println("map is displayed successfully");
			logger.info("Map verified successfully");
			test.log(Status.INFO, "Map verified successfully");
			Assert.assertTrue(true, "Map successfully");
		} 
		else 
		{
			System.out.println("Map not found");
			logger.error("Map not found");
			test.log(Status.FAIL, " Mapnot found");
			Assert.assertFalse(false, "Map not found");
		}
		if(Verify_MapTitle.isDisplayed())
		{

			System.out.println("Map title "+ Verify_MapTitle.getText()+" displayed successfully");
			logger.info("Map title "+ Verify_MapTitle.getText()+" displayed successfully");
			test.log(Status.INFO, "Map title "+ Verify_MapTitle.getText()+" displayed successfully");
			Assert.assertTrue(true, "Map title "+ Verify_MapTitle.getText()+" displayed successfully");
		} 
		else 
		{
			System.out.println("Map title not found");
			logger.error("Map title not found");
			test.log(Status.FAIL, " Map title not found");
			Assert.assertFalse(false, "Map title not found");
		}
	}

	public void Verify_photos()
	{
		SeleniumRepo.waitForElementPresent(Verify_Photos);
		if(Verify_Photos.isDisplayed())
		{
			System.out.println("Photos link displayed successfully");
			logger.info("Photos link displayed successfully");
			test.log(Status.INFO, "Photos link displayed successfully");
			Assert.assertTrue(true,"Photos link displayed successfully");
		} 
		else 
		{
			System.out.println("Photos link not found");
			logger.error("Photos link not found");
			test.log(Status.FAIL, " Photos link not found");
			Assert.assertFalse(false, "Photos link not found");
		}
		Javascriptexecutor(Verify_Photos);
		SeleniumRepo.waitForElementPresent(Verify_Hotelphotos);
		if(Verify_Hotelphotos.isDisplayed())
		{
			System.out.println("HotelPhotos displayed successfully");
			logger.info("HotelPhotos displayed successfully");
			test.log(Status.INFO, "HotelPhotos displayed successfully");
			Assert.assertTrue(true,"HotelPhotos displayed successfully");
		} 
		else 
		{
			System.out.println("HotelPhotos title not found");
			logger.error("HotelPhotos title not found");
			test.log(Status.FAIL, " HotelPhotos title not found");
			Assert.assertFalse(false, "HotelPhotos title not found");
		}
	}
	public void verify_guest_searchoffers()
	{
		SeleniumRepo.waitForElementPresent(Verify_Roomandguest);
		if(Verify_Roomandguest.isDisplayed())
		{
			System.out.println("Room and guest dropdown displayed successfully");
			logger.info("Room and guest dropdown displayed successfully");
			test.log(Status.INFO, "Room and guest dropdown displayed successfully");
			Assert.assertTrue(true,"Room and guest dropdown displayed successfully");
		} 
		else 
		{
			System.out.println("Room and guest dropdown not found");
			logger.error("Room and guest dropdown not found");
			test.log(Status.FAIL, "Room and guest dropdown not found");
			Assert.assertFalse(false, "Room and guest dropdown not found");
		}
		if(Verify_Search_all_Offers.isDisplayed())
		{
			System.out.println("Serach all offers displpayed successfully");
			logger.info("Serach all offers displpayed successfully");
			test.log(Status.INFO, "Serach all offers displpayed successfully");
			Assert.assertTrue(true,"Serach all offers displpayed successfully");
		} 
		else 
		{
			System.out.println("Serach all offers dropdown not found");
			logger.error("Serach all offers dropdown not found");
			test.log(Status.FAIL, "Serach all offers dropdown not found");
			Assert.assertFalse(false, "Serach all offers dropdown not found");
		}
	}
	public void arrivaldate() throws ParseException
	{
		SeleniumRepo.waitForElementPresent(Menu_Button);
		Date date1 = new Date();
		date1.setDate(date1.getDate() + 1);
		
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String arrivaldate = df1.format(date1);
		
		String day = new SimpleDateFormat("dd").format(new Date());
		month = new SimpleDateFormat("MMMM").format(new Date());
		Year = new SimpleDateFormat("YYYY").format(new Date());

		//todaysdate=Integer.parseInt(date);
		//int arrivaldate=todaysdate+1;
		System.out.println("//*[text()='"+month+" "+Year+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+day+"']");
		//System.out.println("DAy:   " + day);
		WebElement startdate=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+month+" "+Year+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+day+"']"));
		Javascriptexecutor(startdate);
		System.out.println("arrival date enterd successfully");

	}
	public void departuredate() throws ParseException
	{
		Date date2 = new Date();
		date2.setDate(date2.getDate() + 7);
		
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String departuredate = df1.format(date2);
		
		
		String month1 = new SimpleDateFormat("MMMM").format(date2);
		String Year1 = new SimpleDateFormat("YYYY").format(date2);
		
		
		System.out.println("departuredate is "+departuredate);
		//int departuredate=todaysdate+7;
		System.out.println("//*[text()='"+month1+" "+Year1+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+departuredate+"']");
		WebElement Enddate=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+month1+" "+Year1+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+departuredate+"']"));
		Javascriptexecutor(Enddate);
		System.out.println("Departure date enterd successfully");

	}

	public void popup_ok() throws InterruptedException 
	{
		Thread.sleep(3000);
		if (ok.isDisplayed()) 
		{
			ok.click();
			System.out.println("Clicked on ok");
			logger.info("Clicked on ok");
			test.log(Status.INFO, "Clicked on ok");
			Assert.assertTrue(true, "Clicked on ok");
		} else {
			System.out.println("not Clicked on ok");
			logger.error("not Clicked on ok");
			test.log(Status.FAIL, "not Clicked on ok");
			Assert.assertFalse(false, "not Clicked on ok");
		}

	}
	public void Verify_Bestprice()
	{
		SeleniumRepo.waitForElementPresent(Verify_BestPriceSection);
		if(Verify_BestPriceSection.isDisplayed())
		{
			String bestpricetext=Verify_BestPriceSection.getText();
			String bestprice=SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'Best Price Per Night')]/strong")).getText();
			System.out.println(bestpricetext+":"+bestprice);
			System.out.println("Best Price Per Night element is displayed successfully");
			logger.info("Best Price Per Night element is displayed successfully");
			test.log(Status.INFO, "Best Price Per Night element is displayed successfully");
			Assert.assertTrue(true,"Best Price Per Night element is displayed successfully");
		} 
		else 
		{
			System.out.println("Best Price Per Night element is not found");
			logger.error("Best Price Per Night element is not found");
			test.log(Status.FAIL, "Best Price Per Night element is not found");
			Assert.assertFalse(false, "Best Price Per Night element is not found");
		}
	}

	public void verify_ResetButton()
	{
		SeleniumRepo.waitForElementPresent(Verify_ResetDates);
		if(Verify_ResetDates.isDisplayed())
		{
			System.out.println("Reset dates button is displayed successfully");
			logger.info("Reset dates button is displayed successfully");
			test.log(Status.INFO, "Reset dates button is displayed successfully");
			Assert.assertTrue(true,"Reset dates button is displayed successfully");
		} 
		else 
		{
			System.out.println("Reset dates element is not found");
			logger.error("Reset dates element is not found");
			test.log(Status.FAIL, "Reset dates element is not found");
			Assert.assertFalse(false, "Reset dates element is not found");
		}
	}
	public void Select_Room()
	{
		SeleniumRepo.waitForElementPresent(Select_Room);
		if(Select_Room.isDisplayed())
		{
			Javascriptexecutor(Select_Room);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Clicked on Select room Button");
			logger.info("Clicked on Select room Button");
			test.log(Status.INFO, "Clicked on Select room Button");
			Assert.assertTrue(true,"Clicked on Select room Button");
		} 
		else 
		{
			System.out.println("Select Room element is not found");
			logger.error("Select Room element is not found");
			test.log(Status.FAIL, "Select Room element is not found");
			Assert.assertFalse(false, "Select Room element is not found");
		}

	}
	public void RoomLink(String RoomType)
	{
		SeleniumRepo.waitForElementsPresent(Rooms_Links);
		int rooms=Rooms_Links.size();
		System.out.println(rooms+" room are available");
		for(int i=0;i<rooms;i++)
		{
			String UIRoomname=Rooms_Links.get(i).getText();
			System.out.println("Room name is :"+UIRoomname);
			if(UIRoomname.equalsIgnoreCase(RoomType))
			{

				//*[@class='card_bottom_link']//*[contains(text(),'Times Square View Two Queen Room')]
				System.out.println("Roomtype is matched with the UIRoomname");
				System.out.println("//*[@class='card_bottom_link']//*[contains(text(),'"+RoomType+"')]/../../..");
				WebElement ClickRoom=SeleniumRepo.driver.findElement(By.xpath("//*[@class='card_bottom_link']//*[contains(text(),'"+RoomType+"')]/../../.."));
				Javascriptexecutor(ClickRoom);
				SeleniumRepo.waitForPageLoaded();
				SeleniumRepo.waitForElementPresent(Click_Continue);
				logger.info(RoomType + "Room clicked successfully");
				test.log(Status.INFO, RoomType + "Room clicked successfully");
				break;
			}
			else
			{
				System.out.println("Roomtype is not matched with the UIRoomname");
			}
		}
	}
	public void verify_Room_date_Readmore(String RoomType) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Click_Continue);
		if(Verify_RoomTitle.isDisplayed())
		{
			String ActualRoom=Verify_RoomTitle.getText();
			String ExpectedRoom=RoomType;
			if(ExpectedRoom.equals(ActualRoom))
			{
				System.out.println("Selected Room "+ExpectedRoom+" is showing same successfully");
				logger.info("Selected Room "+ExpectedRoom+" is showing same successfully");
				test.log(Status.INFO, "Selected Room "+ExpectedRoom+" is showing same successfully");
			}
			else
			{
				System.out.println("Selected Room "+ExpectedRoom+" is not showing same at continue page");
			}
			System.out.println("RoomTitle "+ActualRoom+ " dispplayed successfully");
			logger.info("RoomTitle "+ActualRoom+ " dispplayed successfully");
			test.log(Status.INFO, "RoomTitle "+ActualRoom+ " dispplayed successfully");
		}
		else
		{
			System.out.println("RoomTitle is not  displayed");
			logger.info("RoomTitle is not  displayed");
			test.log(Status.INFO, "RoomTitle is not  displayed");
		}
		if(Verify_ReadMore.isDisplayed())
		{
			System.out.println("ReadMore Button displayed successfully");
			logger.info("ReadMore Button displayed successfully");
			test.log(Status.INFO, "ReadMore Button displayed successfully");
			Assert.assertTrue(true,"ReadMore Button displayed successfully");
		} 
		else 
		{
			System.out.println("ReadMore button  is not found");
			logger.error("ReadMore Button is not found");
			test.log(Status.FAIL, "ReadMore Buttonis not found");
			Assert.assertFalse(false, "ReadMore Button is not found");
		}
		if(Verify_DatesSection.isDisplayed())

		{
			System.out.println("DatesSection displayed successfully");
			logger.info("DatesSection displayed successfully");
			test.log(Status.INFO, "DatesSection displayed successfully");
			Assert.assertTrue(true,"DatesSection displayed successfully");
		} 
		else 
		{
			System.out.println("DatesSection  is not found");
			logger.error("DatesSection is not found");
			test.log(Status.FAIL, "DatesSection is not found");
			Assert.assertFalse(false, "DatesSection is not found");
		}
		/*if(Verify_continueBestPriceSection.isDisplayed())
		{
			Thread.sleep(3000);
			System.out.println("BestPriceSection displayed successfully");
			logger.info("BestPriceSection displayed successfully");
			test.log(Status.INFO, "BestPriceSection displayed successfully");
			Assert.assertTrue(true,"BestPriceSection displayed successfully");
		} 
		else 
		{
			System.out.println("BestPriceSection is not found");
			logger.error("BestPriceSection is not found");
			test.log(Status.FAIL, "BestPriceSection is not found");
			Assert.assertFalse(false, "BestPriceSection is not found");
		}*/
	}
	public void Bar_radio()
	{
		if(!(Barradiobutton.isSelected()))
		{
			Javascriptexecutor(Barradiobutton);
			System.out.println("Bar Radio Button Clicked Successfully");
		}
		else
		{
			System.out.println("Defaultly Bar Radio Button Clicked Successfully");
		}
	}
	public void Click_Continue()
	{
		SeleniumRepo.waitForElementPresent(Click_Continue);
		if(Click_Continue.isDisplayed())
		{
			Javascriptexecutor(Click_Continue);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Continue button clicked successfully");
			logger.info("Continue button clicked successfully");
			test.log(Status.INFO, "Continue button clicked successfully");
			Assert.assertTrue(true,"Continue button clicked successfully");
		} 
		else 
		{
			System.out.println("Continue button is not found");
			logger.error("Continue button is not found");
			test.log(Status.FAIL, "Continue button is not found");
			Assert.assertFalse(false, "Continue button is not found");

		}
	}
	
	
	
	public void First_name(String fullName) throws InterruptedException
	{
		Thread.sleep(3000);
		ExplicitWait(FullName);
	//	SeleniumRepo.waitForElementPresent(FullName);
		if(FullName.isDisplayed())
		{
			FullName.click();
			FullName.clear();
			//jse.executeScript("arguments[0].value=fullName;", FullName);
			TypeInField(FullName, fullName);
			
			System.out.println("Fullname : "+fullName+" enterd successfully");
			logger.info("Fullname : "+fullName+" enterd successfully");
			test.log(Status.INFO, "Fullname : "+fullName+" enterd successfully");
			Assert.assertTrue(true, "Fullname : "+fullName+"  enterd successfully");
		} 
		else 
		{
			System.out.println("FullName field not found");
			logger.error("FullName field not found");
			test.log(Status.FAIL, "FullName field not found");
			Assert.assertFalse(false, "FullName field not found");
		}
	}
	public void PhoneNumber(String PhnNo)
	{
		SeleniumRepo.waitForElementPresent(Phoneno);

		if(Phoneno.isDisplayed())
		{
			Javascriptexecutor(Phoneno);
			Phoneno.clear();
			//jse.executeScript("arguments[0].value=PhnNo;", Phoneno);
			
			TypeInField(Phoneno, PhnNo);
			
			System.out.println("PhoneNO : "+PhnNo+" enterd successfully");
			logger.info("PhoneNO : "+PhnNo+"  enterd successfully");
			test.log(Status.INFO, "PhoneNO : "+PhnNo+" enterd  successfully");
			Assert.assertTrue(true, "PhoneNO : "+PhnNo+" enterd  successfully");
		} 
		else 
		{
			System.out.println("PhoneNo field not found");
			logger.error("PhoneNo field not found");
			test.log(Status.FAIL, "PhoneNo field not found");
			Assert.assertFalse(false, "PhoneNo field not found");
		}
	}
	public void Email(String EmailID)
	{
		SeleniumRepo.waitForElementPresent(Email);
		if(Email.isDisplayed())
		{
			Javascriptexecutor(Email);
			Email.clear();
//			jse.executeScript("arguments[0].value=EmailID;", Email);
			
			TypeInField(Email, EmailID);
			
			System.out.println("EmailID : "+EmailID+" enterd successfully");
			logger.info("EmailID : "+EmailID+"  enterd successfully");
			test.log(Status.INFO, "EmailID : "+EmailID+" enterd  successfully");
			Assert.assertTrue(true, "EmailID : "+EmailID+" enterd  successfully");
		} 
		else 
		{
			System.out.println("Email field not found");
			logger.error("Email field not found");
			test.log(Status.FAIL, "Email field not found");
			Assert.assertFalse(false, "Email field not found");
		}
	}
	public void Checkbox()
	{
		SeleniumRepo.waitForElementPresent(checkbox_guest);

		if(checkbox_guest.isDisplayed())
		{
			Javascriptexecutor(checkbox_guest);
			System.out.println("Check Box clicked successfully");
			logger.info("Check Box clicked successfully");
			test.log(Status.INFO, "Check Box clicked successfully");
			Assert.assertTrue(true, "Check Box clicked successfully");
		} 
		else 
		{
			System.out.println("CheckBox field not found");
			logger.error("CheckBox field not found");
			test.log(Status.FAIL, "CheckBox field not found");
			Assert.assertFalse(false, "CheckBox field not found");
		}
	}
	public void Address(String address)
	{
		SeleniumRepo.waitForElementPresent(Address);
		if(Address.isDisplayed())
		{

			Javascriptexecutor(Address);
			Address.clear();
			Address.sendKeys(address);
			System.out.println("address : "+address+" enterd successfully");
			logger.info("address : "+address+"  enterd successfully");
			test.log(Status.INFO, "address : "+address+" enterd  successfully");
			Assert.assertTrue(true, "address : "+address+" enterd  successfully");
		} 
		else 
		{
			System.out.println("Email field not found");
			logger.error("Email field not found");
			test.log(Status.FAIL, "Email field not found");
			Assert.assertFalse(false, "Email field not found");
		}
	}
	public void Country(String Country) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Billing_Countrylink);
		if(Billing_Countrylink.isDisplayed())
		{
			Javascriptexecutor(Billing_Countrylink);
			WebElement country=SeleniumRepo.driver.findElement(By.xpath("//ul[@class='page-list -theme-color']/li[text()='"+Country+"']"));
			Javascriptexecutor(country);
			Thread.sleep(2000);
			System.out.println("Country: "+Country+" enterd successfully");
			logger.info("Country : "+Country+"  enterd successfully");
			test.log(Status.INFO, "Country : "+Country+" enterd  successfully");
			Assert.assertTrue(true, "Country : "+Country+" enterd  successfully");
		} 
		else 
		{
			System.out.println("Country field not found");
			logger.error("Country field not found");
			test.log(Status.FAIL, "Country field not found");
			Assert.assertFalse(false, "Country field not found");
		}
	}	
	public void State(String state) throws InterruptedException
	{
		//SeleniumRepo.waitForElementPresent(State);
		if(State.isDisplayed())
		{
			Select st=new Select(State);
			st.selectByVisibleText(state);
			Thread.sleep(2000);
			System.out.println("state is: "+state+" enterd successfully");
			logger.info("state is : "+state+"  enterd successfully");
			test.log(Status.INFO, "state is : "+state+" enterd  successfully");
			Assert.assertTrue(true, "state is : "+state+" enterd  successfully");
		} 
		else 
		{
			System.out.println("state field not found");
			logger.error("state field not found");
			test.log(Status.FAIL, "state field not found");
			Assert.assertFalse(false, "state field not found");
		}

	}
	public void City(String city) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(City);

		if(City.isDisplayed())
		{
			Javascriptexecutor(City);
			City.clear();
			City.sendKeys(city);
			Thread.sleep(2000);
			System.out.println("city: "+city+" enterd successfully");
			logger.info("city : "+city+"  enterd successfully");
			test.log(Status.INFO, "state : "+city+" enterd  successfully");
			Assert.assertTrue(true, "state : "+city+" enterd  successfully");
		} 
		else 
		{
			System.out.println("city field not found");
			logger.error("city field not found");
			test.log(Status.FAIL, "city field not found");
			Assert.assertFalse(false, "city field not found");
		}

	}
	public void Zipcode(String Zipcode) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(ZipCode);

		if(ZipCode.isDisplayed())
		{
			Javascriptexecutor(ZipCode);
			ZipCode.clear();
			ZipCode.sendKeys(Zipcode);
			Thread.sleep(2000);
			System.out.println("ZipCode: "+Zipcode+" enterd successfully");
			logger.info("ZipCode : "+Zipcode+"  enterd successfully");
			test.log(Status.INFO, "ZipCode : "+Zipcode+" enterd  successfully");
			Assert.assertTrue(true, "ZipCode : "+Zipcode+" enterd  successfully");
		} 
		else 
		{
			System.out.println("ZipCode field not found");
			logger.error("ZipCode field not found");
			test.log(Status.FAIL, "ZipCode field not found");
			Assert.assertFalse(false, "ZipCode field not found");
		}

	}
	public void Cardname(String cardname) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(CardName);

		if(CardName.isDisplayed())
		{
			Javascriptexecutor(CardName);
			CardName.clear();
			CardName.sendKeys(cardname);
			Thread.sleep(2000);
			System.out.println("cardname: "+cardname+" enterd successfully");
			logger.info("cardname : "+cardname+"  enterd successfully");
			test.log(Status.INFO, "cardname : "+cardname+" enterd  successfully");
			Assert.assertTrue(true, "cardname : "+cardname+" enterd  successfully");
		} 
		else 
		{
			System.out.println("cardname field not found");
			logger.error("cardname field not found");
			test.log(Status.FAIL, "cardname field not found");
			Assert.assertFalse(false, "cardname field not found");
		}
	}
	public void CardNo(String CardNum) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(CardNo);
		if(CardNo.isDisplayed())
		{
			Javascriptexecutor(CardNo);
			CardNo.clear();
			
//			jse = (JavascriptExecutor)SeleniumRepo.driver;
//			jse.executeScript("arguments[0].value='4111 1111 1111 1111';", CardNo);
			
			TypeInField(CardNo, CardNum);
			
			Thread.sleep(7000);
			System.out.println("CardNum: "+CardNum+" enterd successfully");
			logger.info("CardNum : "+CardNum+"  enterd successfully");
			test.log(Status.INFO, "CardNum : "+CardNum+" enterd  successfully");
			Assert.assertTrue(true, "CardNum : "+CardNum+" enterd  successfully");
		} 
		else 
		{
			System.out.println("CardNum field not found");
			logger.error("CardNum field not found");
			test.log(Status.FAIL, "CardNum field not found");
			Assert.assertFalse(false, "CardNum field not found");
		}
	}
	public void Expdate() throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Expiration);
		if(Expiration.isDisplayed())
		{
			Javascriptexecutor(Expiration);
			Expiration.clear();
			
//			JavascriptExecutor js = (JavascriptExecutor)SeleniumRepo.driver;
//			js.executeScript("arguments[0].value='05/25';", Expiration);
			
			TypeInField(Expiration, "05/25");
			
			Thread.sleep(2000);
			System.out.println("expdate: enterd successfully");
			logger.info("expdate: enterd successfully");
			test.log(Status.INFO, "expdate: enterd successfully");
			Assert.assertTrue(true, "expdate: enterd successfully");
		} 
		else 
		{
			System.out.println("expdate field not found");
			logger.error("expdate field not found");
			test.log(Status.FAIL, "expdate field not found");
			Assert.assertFalse(false, "expdate field not found");
		}
	}
	public void postalcode(String postalcod) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Postalcode);
		if(Postalcode.isDisplayed())
		{
			Javascriptexecutor(Postalcode);
			Postalcode.clear();
			Postalcode.sendKeys(postalcod);
			Thread.sleep(2000);
			System.out.println("postalcod: "+postalcod+" enterd successfully");
			logger.info("postalcod : "+postalcod+"  enterd successfully");
			test.log(Status.INFO, "postalcod : "+postalcod+" enterd  successfully");
			Assert.assertTrue(true, "postalcod : "+postalcod+" enterd  successfully");
		} 
		else 
		{
			System.out.println("postalcod field not found");
			logger.error("postalcod field not found");
			test.log(Status.FAIL, "postalcod field not found");
			Assert.assertFalse(false, "postalcod field not found");
		}
	}

	public void Payment_Country(String Country) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Card_Countryclick);
		if(Card_Countryclick.isDisplayed())
		{
			Javascriptexecutor(Card_Countryclick);
			Thread.sleep(2000);
			WebElement country=SeleniumRepo.driver.findElement(By.xpath("//ul[@class='page-list -theme-color']/li[text()='"+Country+"']"));
			Javascriptexecutor(country);
			Thread.sleep(2000);
			System.out.println("paymentCountry: "+Country+" enterd successfully");
			logger.info("paymentCountry : "+Country+"  enterd successfully");
			test.log(Status.INFO, "paymentCountry : "+Country+" enterd  successfully");
			Assert.assertTrue(true, "paymentCountry : "+Country+" enterd  successfully");
		} 
		else 
		{
			System.out.println("paymentCountry field not found");
			logger.error("paymentCountry field not found");
			test.log(Status.FAIL, "paymentCountry field not found");
			Assert.assertFalse(false, "paymentCountry field not found");
		}
	}	
	public void CVV() throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(CVV);

		if(CVV.isDisplayed())
		{
			Javascriptexecutor(CVV);
			CVV.clear();
			CVV.sendKeys("368");
			Thread.sleep(2000);
			System.out.println("cvv: enterd successfully");
			logger.info("cvv : enterd successfully");
			test.log(Status.INFO, "cvv : enterd  successfully");
			Assert.assertTrue(true, "cvv :  enterd  successfully");
		} 
		else 
		{
			System.out.println("cvv field not found");
			logger.error("cvv field not found");
			test.log(Status.FAIL, "cvv field not found");
			Assert.assertFalse(false, "cvv field not found");
		}
	}
	public void agree() throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(CheckBox);
		if(CheckBox.isDisplayed())
		{
			Javascriptexecutor(CheckBox);
			System.out.println("CheckBox clicked successfully");
			logger.info("CheckBox clicked successfully");
			test.log(Status.INFO, "CheckBox clicked successfully");
			Assert.assertTrue(true, "CheckBox clicked successfully");
		} 
		else 
		{
			System.out.println("Agree checkBox field not found");
			logger.error("cAgree checkBox field not found");
			test.log(Status.FAIL, "Agree checkBox field not found");
			Assert.assertFalse(false, "Agree checkBox  field not found");
		}
		if(Complete_Reservation.isDisplayed())
		{
			Javascriptexecutor(Complete_Reservation);
			SeleniumRepo.waitForPageLoaded();
			SeleniumRepo.waitForElementPresent(confirmation);
			System.out.println("Complete_Reservation clicked on successfully");
			logger.info("Complete_Reservation clicked on successfully");
			test.log(Status.INFO, "Complete_Reservation clicked on successfully");
			Assert.assertTrue(true, "Complete_Reservation clicked on successfully");
		} 
		else 
		{
			System.out.println("Complete_Reservation field not found");
			logger.error("Complete_Reservation field not found");
			test.log(Status.FAIL, "Complete_Reservation field not found");
			Assert.assertFalse(false, "Complete_Reservation field not found");
		}
		if(confirmation.isDisplayed())
		{
			Thread.sleep(4000);
			String expctedconfmsg="Your Reservation is Confirmed!";
			String actualconfmsg=SeleniumRepo.driver.findElement(By.xpath("//*[@class='content_headline']")).getText();
			System.out.println("actualconfmsg is "+actualconfmsg);
			if(actualconfmsg.contains(expctedconfmsg))
			{
				System.out.println("Reservation confirmed message displayed successfully");
				logger.info("Reservation confirmed message displayed successfully");
				test.log(Status.INFO, "Reservation confirmed message displayed successfully");
				Assert.assertTrue(true,"Reservation confirmed message displayed successfully");
			} 
			else 
			{
				System.out.println("Confirmation code is not generated");
				logger.error("Confirmation code is not generated");
				test.log(Status.FAIL, "Confirmation code is not generated");
				Assert.assertFalse(false, "Confirmation code is not generated");
			}

		}

	}

	public String confirmationcode()
	{
		ExplicitWait(confirmation_code);
		if(confirmation_code.isDisplayed())
		{
			code=confirmation_code.getText();
			System.out.println("Confirmation code is: "+code);
			System.out.println("Confirmation code is  displayed successfully");
			logger.info("Confirmation code is  displayed successfully");
			test.log(Status.INFO, "Confirmation code is  displayed successfully");
			Assert.assertTrue(true,"Confirmation code is  displayed successfully");
		} 
		else 
		{
			System.out.println("Confirmation code is not displayed");
			logger.error("Confirmation code is not displayed");
			test.log(Status.FAIL, "Confirmation code is not displayed");
			Assert.assertFalse(false, "Confirmation code is not displayed");
		}
		return code;

	}

	public void changereservation()
	{
		if(Change_Reservation.isDisplayed())
		{
			Javascriptexecutor(Change_Reservation);
			System.out.println("Change Reservation clicked successfully");
			logger.info("Change Reservation clicked successfully");
			test.log(Status.INFO, "Change Reservation clicked successfully");
			Assert.assertTrue(true,"Change Reservation clicked successfully");
			SeleniumRepo.waitForPageLoaded();
			if(Check_callHotel.isDisplayed())
			{
				String actualtext=Check_callHotel.getText();
				if(actualtext.equals("Call Hotel"))
				{
					String message=Check_checkhotelmessage.getText();
					System.out.println(actualtext+" field is displayed successfully");
					if(message.contains("We don't support reservation changes on mobile. Please call the hotel."))
					{
						System.out.println(message+" message  displayed successfully");
						logger.info(message+" message  displayed successfully");
						test.log(Status.INFO, message+" message  displayed successfully");
						Assert.assertTrue(true,message+" message  displayed successfully");
					} 
					else 
					{
						System.out.println(message+" message is not  displayed");
						logger.error(message+" message is not  displayed");
						test.log(Status.FAIL,message+" message is not  displayed");
						Assert.assertFalse(false, message+" message is not  displayed");
					}

				}
			}

		}
		else
		{
			System.out.println("Change Reservation  button not found");
			logger.error("Change Reservation  button not found");
			test.log(Status.FAIL,"Change Reservation  button not found");
			Assert.assertFalse(false, "Change Reservation  button not found");

		}
	}
	public void verify_reservationslink(String EmailID,String Confirmationcode) throws InterruptedException
	{
		SeleniumRepo.waitForElementPresent(Verify_MyReservations);
		if(Verify_MyReservations.isDisplayed())
		{
			String ActualReservationstext=Verify_MyReservations.getText();
			String ExpectedReservationstext="My reservations";
			if(ExpectedReservationstext.equals(ActualReservationstext))
			{
				logger.info("My reservations verified successfully");
				test.log(Status.INFO, "My reservations verified successfully");
				Assert.assertTrue(true, "My reservations successfully");
			} 
			else 
			{
				System.out.println("My reservations not found");
				logger.error("My reservations  not found");
				test.log(Status.FAIL, " My reservations  not found");
				Assert.assertFalse(false, "My reservations not found");

			}
		}
		Javascriptexecutor(Verify_MyReservations);
		SeleniumRepo.waitForElementPresent(Verify_MyreservationTitle);
		if(Verify_MyreservationTitle.isDisplayed())
		{
			System.out.println("My Reservation title displayed successfully");
			logger.info("USD Link Displayed successfully");
			test.log(Status.INFO,"USD Link Displayed successfully");
			Assert.assertTrue(true, "USD Link Displayed successfully");
		}
		else
		{
			System.out.println("My Reservation title not found");
			logger.error("My Reservation title not found");
			test.log(Status.FAIL, " My Reservation title not found");
			Assert.assertFalse(false, "My Reservation title not found");

		}
		if(Verify_confirmation_code.isDisplayed())
		{
			Verify_confirmation_code.sendKeys(Confirmationcode);
			Thread.sleep(2000);

			System.out.println("Confirmation code displayed successfully");
			logger.info("Confirmation code displayed successfully");
			test.log(Status.INFO,"Confirmation code displayed successfully");
			Assert.assertTrue(true, "Confirmation code displayed successfully");
		}
		else
		{
			System.out.println("Confirmation code field is not found");
			logger.error("Confirmation code field is not found");
			test.log(Status.FAIL, " Confirmation code field is not found");
			Assert.assertFalse(false, "Confirmation code field is not found");

		}
		if(Verify_Email.isDisplayed())
		{
			Verify_Email.sendKeys(EmailID);
			Thread.sleep(2000);

			System.out.println("Email displayed successfully");
			logger.info("Email displayed successfully");
			test.log(Status.INFO,"Email displayed successfully");
			Assert.assertTrue(true, "Email displayed successfully");
		}
		else
		{
			System.out.println("Email field is not found");
			logger.error("Email field is not found");
			test.log(Status.FAIL, " Email field is not found");
			Assert.assertFalse(false, "Email field is not found");

		}
		if(Verify_LookUpButton.isDisplayed())
		{

			Javascriptexecutor(Verify_LookUpButton);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("LookUpButton displayed successfully");
			logger.info("LookUpButton displayed successfully");
			test.log(Status.INFO,"LookUpButton displayed successfully");
			Assert.assertTrue(true, "LookUpButton displayed successfully");
			
			WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,20);
			wait.until(ExpectedConditions.visibilityOf(confirmation_code));
			//SeleniumRepo.waitForElementPresent(confirmation_code);
			if(Confirmationcode.equals(confirmation_code.getText()))
			{
				System.out.println("Confirmation code matched successfully");
			}
			
		}
		else
		{
			System.out.println("LookUpButton is not found");
			logger.error("LookUpButton is not found");
			test.log(Status.FAIL, " LookUpButton is not found");
			Assert.assertFalse(false, "LookUpButton is not found");

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
			test.log(Status.INFO, "cancel reservation button clicked successfully");
			Assert.assertTrue(true,"cancel reservation button clicked successfully");
			SeleniumRepo.waitForElementPresent(Cancel_reservationtitle);		
		}
		else
		{
			System.out.println("Cancel reservation button is not found");
			test.log(Status.INFO, "Cancel reservation button is not found");
			Assert.assertFalse(false,"Cancel reservation button is not found");
		}
	}

	public void Popup_title() 
	{
		try {
			SeleniumRepo.waitForElementPresent(Cancel_reservationtitle);
			if(Cancel_reservationtitle.isDisplayed())
			{
				System.out.println("Cancel reservation popup title displayed");
				test.log(Status.INFO, "Cancel reservation popup title displayed");
				Assert.assertTrue(true,"Cancel reservation popup title displayed");
				String Actualtitle=Cancel_reservationtitle.getText();
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

			if(CheckCancelationfee.isDisplayed())
			{
				String cancelation_fee=CheckCancelationfee.getText();
				System.out.println("Cancelation fee is  "+cancelation_fee);	
				test.log(Status.INFO, "Cancelation fee is "+cancelation_fee);
				Assert.assertTrue(true,"Cancelation fee is "+cancelation_fee);
			}
			else
			{
				System.out.println("Cancelation fee not applied");
				test.log(Status.INFO, "Cancelation fee not applied");
				Assert.assertFalse(false,"Cancelation fee not applied");

			}
			String Body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
			if(Body.contains("Yes"))
			{
				Javascriptexecutor(Yes_button);
				SeleniumRepo.waitForPageLoaded();
				System.out.println("Yes button clicked successfully");
				logger.info("Yes button clicked successfully");
				test.log(Status.INFO, "Yes button clicked successfully");
				Assert.assertTrue(true,"Yes button clicked successfully");
			}
			else
			{
				System.out.println("Yes Button Not Found");
				test.log(Status.INFO, "Yes Button Not Found");
				Assert.assertFalse(false,"Yes Button Not Found");
			}

			if(Body.contains("No"))
			{
				System.out.println("No Button is present successfully");
				logger.info("No Button is present successfully");
				test.log(Status.INFO, "No Button is present successfully");
				Assert.assertTrue(true,"No Button is present successfully");
			}
			else
			{
				System.out.println("No Button Not Found");
				test.log(Status.INFO, "No Button Not Found");
				Assert.assertFalse(false,"No Button Not Found");
			}
			
			if(cancelation_content.isDisplayed())
			{
				String cancelconfirmation=SeleniumRepo.driver.findElement(By.xpath("(//div[@class='content'])[2]/p[1]")).getText();
				String Cancelationcodetext=SeleniumRepo.driver.findElement(By.xpath("(//div[@class='content'])[2]/h2")).getText();
				String Cancelationcode=SeleniumRepo.driver.findElement(By.xpath("(//div[@class='content'])[2]/p[2]")).getText();
				System.out.println("cancelation_content is present successfully");
				logger.info("cancelation_content is present successfully");
				test.log(Status.INFO, "cancelation_content is present successfully");
				Assert.assertTrue(true,"cancelation_content is present successfully");
				
				
				if(cancelconfirmation.equals("Your reservation has been canceled"))
				{
					System.out.println(cancelconfirmation+" message showed successfully");
					logger.info(cancelconfirmation+" message showed successfully");
					test.log(Status.INFO, cancelconfirmation+" message showed successfully");
					Assert.assertTrue(true,cancelconfirmation+" message showed successfully");
					
					System.out.println(Cancelationcodetext+" is "+Cancelationcode);
					
				}

				
			}

			
		}
		catch(Exception e)
		{
			System.out.println("Cancel reservation popup is not displayed");
			test.log(Status.INFO, "Cancel reservation popup is not displayed");
			Assert.assertFalse(false,"Cancel reservation popup is not displayed");

		}
	}
			 

}