package com.tt.admin.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class RoomHierarchy extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result = this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//div[contains(., 'Rooms')]"),

	})
	private WebElement Click_Room_link;

	@FindAll({ @FindBy(xpath = "//a[starts-with(@href, '/rt/admin/action/displayRoomHierarchy.d')]"),

	})
	private WebElement Click_RoomHierarcy_Link;

	@FindAll({ @FindBy(xpath = "//input[@id='addNewHierarchyButton'][@value='Add New Hierarchy Values']"),

	})
	private WebElement Click_Add_RoomHierarcy_Link;

	@FindAll({ @FindBy(xpath = "//input[@id='isActiveYes']"),

	})
	private WebElement Click_on_ActiveRadio_Button;

	@FindAll({ @FindBy(xpath = "//select[@id='baseRoomTypeId']"),

	})
	private WebElement Select_BaseRoom_For_RoomHierarchy;

	@FindAll({ @FindBy(xpath = "//*[@id='roomHierarchyForm']//input[@name='isPercentageDifference'][@value='Y']"),

	})
	private WebElement Click_on_PercentageRadioButton;

	@FindAll({ @FindBy(xpath = "//*[@id=\"tt_img_loader_0\"]/div/table/tbody/tr[3]//input[@id='hierarchy_0']"),

	})
	private WebElement Enter_valueForRoom1;

	@FindAll({ @FindBy(xpath = "//input[@id='fromDate_0']"),

	})
	private WebElement Enter_StartDate;

	@FindAll({ @FindBy(xpath = "//input[@id='toDate_0']"),

	})
	private WebElement Enter_EndDate;

	@FindAll({ @FindBy(xpath = "//input[@id='chkAll_0']"),

	})
	private WebElement Check_All;

	@FindAll({ @FindBy(xpath = "//input[@id='saveButton']"),

	})
	private WebElement Click_save;

	public void createRoomHierarchy(String BaseRoom, String RoomHirVal)
	{

		try
		{

			if (SeleniumRepo.isElementDisplayed( Click_RoomHierarcy_Link) == true ) 
			{
				Javascriptexecutor(Click_RoomHierarcy_Link);
				ExplicitWait(Click_on_ActiveRadio_Button);
				System.out.println("Rooms element Expanded and Room list element  found");
				test.log(Status.INFO, "Rooms element Expanded and Room list element  found");
				Assert.assertTrue(true, "Rooms element Expanded and Room list element  found");
			} 
			else 
			{
				System.out.println("Rooms Menu is not expanded");
				Javascriptexecutor(Click_Room_link);
				System.out.println("Clicked on Rooms Link");
				test.log(Status.INFO, "Clicked on Rooms Link");

				ExplicitWait(Click_RoomHierarcy_Link);
				if(Click_RoomHierarcy_Link.isDisplayed())
				{
					Javascriptexecutor(Click_RoomHierarcy_Link);
					ExplicitWait(Click_on_ActiveRadio_Button);
					System.out.println("Rooms Hirerachy element found");
					test.log(Status.INFO, "Rooms Hirerachy element found");
					Assert.assertTrue(true, "Rooms Hirerachy element found");
				}
				else
				{
					logger.info("Rooms Hirerachy element not  found");

					test.log(Status.FAIL, "Rooms Hirerachy element not  found");
				}
			}

			if (Click_on_ActiveRadio_Button.isDisplayed())
			{
				if(Click_on_ActiveRadio_Button.isSelected())
				{
					System.out.println("Active Radio Button selected successfully");
				}
				else
				{
					Javascriptexecutor(Click_on_ActiveRadio_Button);

					test.log(Status.PASS, "Clicked on Radio_Button");
					logger.info("Clicked on Radio_Button");
					Assert.assertTrue(true, "Clicked on Radio_Button");
				}	
			}
			else {
				logger.info("ActiveRadio_Button not found");
				test.log(Status.FAIL, "ActiveRadio_Button not found");
			}

			if (Select_BaseRoom_For_RoomHierarchy.isDisplayed()) 
			{
				Select sc=new Select(Select_BaseRoom_For_RoomHierarchy);
				sc.selectByVisibleText(BaseRoom);

				//SeleniumRepoDropdown.selectDropDownText(Select_BaseRoom_For_RoomHierarchy, BaseRoom);
				test.log(Status.PASS, "Room selected");
				logger.info("Room selected");
				Assert.assertTrue(true, "Room selected");
			} else {
				logger.info("Failed to Select Room");
				test.log(Status.FAIL, "Failed to  Select Room");
			}

			if (Click_on_PercentageRadioButton.isDisplayed())
			{
				if(Click_on_PercentageRadioButton.isSelected())
				{
					System.out.println("PercentageRadioButton selected successfully");
				}
				else
				{
					Javascriptexecutor(Click_on_PercentageRadioButton);

					test.log(Status.PASS, "Clicked on Radio_Button");
					logger.info("Clicked on Radio_Button");
					Assert.assertTrue(true, "Clicked on Radio_Button");
				}	
			}
			else {
				logger.info("PercentageRadioButton not found");
				test.log(Status.FAIL, "PercentageRadioButton not found");
			}


			if (SeleniumRepo.isElementPresent(Enter_StartDate)) {

				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
				Date date = new Date();
				String date1 = dateFormat.format(date);
				Enter_StartDate.clear();
				Enter_StartDate.click();
				Enter_StartDate.sendKeys(date1);
				test.log(Status.PASS, "Start Date Data Entered");
				logger.info("Start Date Data Entered");
				Assert.assertTrue(true, "Start Date Data Entered");
			} else {
				logger.info("Failed to Enter Start Date ");
				test.log(Status.FAIL, "Failed to Enter Start Date");
			}

			if (SeleniumRepo.isElementPresent(Enter_EndDate)) 
			{
				Thread.sleep(2000);
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
				Date dt = new Date();
				Calendar cl = Calendar.getInstance();
				cl.setTime(dt);
				;
				cl.add(Calendar.DAY_OF_YEAR, 2);
				dt = cl.getTime();
				String str = df.format(dt);
				Enter_EndDate.click();
				Enter_EndDate.clear();
				Enter_EndDate.sendKeys(str);
				test.log(Status.PASS, "End Date Data Entered");
				logger.info("End Date Data Entered");
				Assert.assertTrue(true, "End Date Data Entered");
			} else {
				logger.info("Failed to Enter End Date ");
				test.log(Status.FAIL, "Failed to Enter End Date");
			}

			if (SeleniumRepo.isElementPresent(Check_All)) {
				if (Check_All.isSelected()) {

					test.log(Status.PASS, "Check box is already selected");
					logger.info("Clicked on Check_All Radio_Button");
					Assert.assertTrue(true, "Clicked on Check_All Radio_Button");
				} else {
					Check_All.click();
					logger.info("Clicked on Check_All Radio_Button");
					Assert.assertTrue(true, "Clicked on Check_All Radio_Button");
				}
			} else {
				logger.info("Failed to Click on Check_All Radio_Button");
				test.log(Status.FAIL, "Failed to Check_All Click on Radio_Button");
			}

			//Thread.sleep(3000);
			int j=0;
			String[] array=RoomHirVal.split(",");
			System.out.println("array size is "+array.length);
			
			List<WebElement> hirerachy=SeleniumRepo.driver.findElements(By.xpath("(//*[contains(@name,'difference(difference_')])"));	
			System.out.println(hirerachy.size());
			for(int i=1;i<hirerachy.size();i++)
			{
				System.out.println("(//*[contains(@name,'difference(difference_')])["+i+"]");
				if(SeleniumRepo.driver.findElement(By.xpath("(//*[contains(@name,'difference(difference_')])["+i+"]")).isDisplayed())
				{
					
					SeleniumRepo.driver.findElement(By.xpath("(//*[contains(@name,'difference(difference_')])["+i+"]")).click();
					SeleniumRepo.driver.findElement(By.xpath("(//*[contains(@name,'difference(difference_')])["+i+"]")).clear();
					SeleniumRepo.driver.findElement(By.xpath("(//*[contains(@name,'difference(difference_')])["+i+"]")).sendKeys(array[j]);
					j++;
					System.out.println("j value is "+j);
					logger.info("Hirerachy value "+j+" enterd for the room ");
					test.log(Status.INFO," Hirerachy value "+j+" enterd for the room");
				}
				else
				{
					System.out.println("Not displayed");
					j++;
				}
			}
			
			Click_save.click();
			SeleniumRepo.waitForPageLoaded();

		} catch (Exception e) {
			logger.error("Unable to create RoomHierarcy selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create RoomHierarcy for selected property because of this execption" + e);
			e.printStackTrace();
		}

	}
}
