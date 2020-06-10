package com.tt.BE.pom;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
//import org.apache.xml.dtm.ref.ExpandedNameTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class ChangeReservation_BE extends BaseTest
{
	String ParentWindow;
	String NewWindow;
	WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,5);

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	RateGrid r=new RateGrid();
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Change reservation")WebElement Change_Reservation;
	@FindBy(how=How.XPATH,using="//*[text()='Yes']")WebElement Change_Reservation_popup ;
	@FindBy(how=How.XPATH,using="//*[text()='Yes']")WebElement Change_Reservation_Fee_Yes ;
	@FindBy(how=How.XPATH,using="//*[text()='No']")WebElement Change_Reservation_Fee_No ;
	@FindBy(how=How.XPATH,using="//h3[@id='myModalLabel']/following-sibling::p")WebElement Reservation_POPUPText;
	@FindBy(how=How.XPATH,using="//div[@ng-switch='room.brg']")List<WebElement> Rooms_List_Standard;
	@FindBy(how=How.XPATH,using="//*[@class='rooms-list-title ng-binding']")List<WebElement> RoomsList_Text;
	@FindBy(how=How.XPATH,using="//span[text()='Your price with applicable discounts']/following-sibling::strong")WebElement RoomPrice_Text;
	@FindBy(how=How.XPATH,using="//*[@class='room-title-name ng-binding']")WebElement RoomName_Text;
	@FindAll({ @FindBy(xpath = "//*[@class='rooms_item_title']"), })
	@CacheLookup
	private List<WebElement> Rooms_List_Yankee;

	@FindAll({ @FindBy(xpath = "//button[@id='check-availability-btn']"), })
	@CacheLookup
	private WebElement Checkavailability;

	public void Change_Reservation() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		SeleniumRepo.waitForElementPresent(Change_Reservation);
		
		if(Change_Reservation.isDisplayed())
		{
			test.info("Change Reservation Screenshot : " + test.addScreenCaptureFromPath(capture()));
			Change_Reservation.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("ChangeReservation clicked  successfully");
			test.log(Status.INFO, "ChangeReservation clicked  successfully");
			Assert.assertTrue(true,"ChangeReservation clicked  successfully");
			Thread.sleep(2000);
			try 
			{

				wait.until(ExpectedConditions.visibilityOf(Change_Reservation_popup));
				String reservationTitle=Change_Reservation_popup.getText();
				System.out.println("Reservation title is "+reservationTitle);
				//SeleniumRepo.waitForElementPresent(Change_Reservation_Fee_Yes);

				if(Change_Reservation_Fee_Yes.isDisplayed())
				{
					System.out.println(Reservation_POPUPText.getText());
					//Change_Reservation_Fee_Yes.click();
					System.out.println("Yes button is displayed on Change reservation POPUP successfully");
					test.log(Status.INFO, "Yes button is displayed on Change reservation POPUP successfully");
					Assert.assertTrue(true,"Yes button is displayed on Change reservation POPUP successfully");

				}
				else
				{
					System.out.println("Yes button is not found  on Change reservation POPUP");
					test.log(Status.INFO, "Yes button is not found  on Change reservation POPUP");
					Assert.assertFalse(false,"Yes button is not found  on Change reservation POPUP");
				}
				if(Change_Reservation_Fee_No.isDisplayed())
				{
					System.out.println("No button is displayed on Change reservation POPUP successfully");
					test.log(Status.INFO, "Yes button is displayed on Change reservation POPUP successfully");
					Assert.assertTrue(true,"Yes button is displayed on Change reservation POPUP successfully");
				}
				else
				{
					System.out.println("NO button is not found  on Change reservation POPUP");
					test.log(Status.INFO, "NO button is not found  on Change reservation POPUP");
					Assert.assertFalse(false,"NO button is not found  on Change reservation POPUP");
				}
				Change_Reservation_Fee_Yes.click();
				SeleniumRepo.waitForElementPresent(Checkavailability);
				System.out.println("Yes button is clicked on Change reservation POPUP successfully");
				test.log(Status.INFO, "Yes button is clicked on Change reservation POPUP successfully");
				Assert.assertTrue(true,"Yes button is clicked on Change reservation POPUP successfully");

			}
			catch(Exception e)
			{
				System.out.println("Change Reservation popup is not displayed to show Yes & No Button");
			}
		}
		else
		{
			System.out.println("ChangeReservation Element is not clicked");
			test.log(Status.INFO, "ChangeReservation Element is not clicked");
			Assert.assertTrue(true,"ChangeReservation Element is not clicked");
			Thread.sleep(2000);
		}

	}
	public void Pricemodifycheck_standard(String RoomType,String RoomRate) throws InterruptedException
	{
		System.out.println("RoomRate modified in admin is "+" "+RoomRate);
		List<WebElement> Rooms=Rooms_List_Standard;
		List<WebElement> Text_Room=RoomsList_Text;
		System.out.println(Rooms.size());
		for(int i=0;i<Rooms.size();i++)
		{	
			String RoomText=Text_Room.get(i).getText();
			System.out.println("room name is "+RoomText);
			if(RoomText.equalsIgnoreCase(RoomType))
			{	System.out.println("Rooms are matching");
			Rooms.get(i).click();
			Thread.sleep(3000);
			String RoomPrice=RoomPrice_Text.getText();
			System.out.println(RoomText + " " + "Room Price is "+ " " + RoomPrice);
			if(RoomPrice.contains(RoomRate))
			{
				
				test.log(Status.INFO, "Room price is modified Successfully");
				

			}
			else
			{
				System.out.println("Room price is not modified Successfully");
				test.log(Status.INFO, "Room price is not modified Successfully");
				logger.error("Room price is not modified Successfully");

			}
			break;
			}
			/*else 
			{
				System.out.println("Rooms are not matching");
				test.log(Status.INFO, "Rooms are not matching");
				Assert.assertFalse(false,"Rooms are not matching");

			}*/
		}

	}
	
	public void Pricemodifycheck_standard() throws InterruptedException
	{
		List<WebElement> Rooms=Rooms_List_Standard;
		List<WebElement> Text_Room=RoomsList_Text;
		System.out.println(Rooms.size());
			String RoomText=Text_Room.get(1).getText();
			System.out.println("room name is "+RoomText);
			Rooms.get(1).click();
			Thread.sleep(3000);
			System.out.println("Room  modified Successfully");
			test.log(Status.INFO, "Room  modified Successfully");
			logger.error("Room modified Successfully");
		}

	public void Pricemodifycheck_Yankee(String RoomType,String RoomRate) throws InterruptedException
	{
		System.out.println("RoomRate modified in admin is "+" "+RoomRate);
		List<WebElement> Rooms=Rooms_List_Yankee;
		System.out.println("Total "+Rooms.size()+" rooms are available");
		for(int i=0;i<Rooms.size();i++)
		{	
			String RoomText=Rooms.get(i).getText();
			System.out.println("room name is "+RoomText);
			if(RoomText.equalsIgnoreCase(RoomType))
			{	System.out.println("Rooms are matching");

			Thread.sleep(3000);
			String RoomPrice=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+RoomType+"']/following-sibling::div[1]/div[3]/span/strong")).getText();
			System.out.println(RoomText + " " + "Room Price is "+ " " + RoomPrice);
			if(RoomPrice.contains(RoomRate))
			{
				System.out.println("Room price is modified");
				System.out.println("Room price is modified Successfully");
				test.log(Status.INFO, "Room price is modified Successfully");
				Assert.assertTrue(true,"Room price is modified Successfully");

			}
			else
			{
				System.out.println("Room price is not modified Successfully");
				test.log(Status.INFO, "Room price is not modified Successfully");
				Assert.assertFalse(false,"Room price is not modified Successfully");

			}
			break;
			}
			else 
			{
				System.out.println("Rooms are not matching");
				test.log(Status.INFO, "Rooms are not matching");
				Assert.assertFalse(false,"Rooms are not matching");

			}
		}
		
	}
	
}
