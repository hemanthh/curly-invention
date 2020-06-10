package com.tt.admin.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.tt.utility.SeleniumRepo;

public class DeleteRoomsInList {

	@FindAll({ @FindBy(xpath = "//div[contains(., 'Rooms')]"),

	})
	private WebElement Click_Room_link;

	@FindAll({
		@FindBy(xpath = "//*[contains(., 'Rooms')]//li/a[starts-with(@href, '/rt/admin/action/roomTypesList')]"), })
	
	private WebElement Click_List;

	@FindAll({ @FindBy(xpath = "//input[@value='Yes']"), })
	
	private WebElement click_yes;

	@FindAll({ @FindBy(xpath = "//input[@value='Delete']"), })
	
	private WebElement Delete;

	public void deleteRooms(String roomName) throws InterruptedException 
	{

		if (Click_Room_link.isDisplayed()) 
		{
			Click_Room_link.click();
			System.out.println("Clicked Rooms link");
		} else
			System.out.println("Not Clicked on Links");

		SeleniumRepo.waitForElementPresent(Click_List);
		SeleniumRepo.isElementPresent(Click_List);
		if (Click_List.isDisplayed())
		{
			Click_List.click();
			System.out.println("Clicked  on list");
		} 

		else

			System.out.println("Not Clicked on List");
		
		
		String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
		if(body.contains(roomName))
		{
			System.out.println("Room "+roomName+" already present going to delete");
			SeleniumRepo.driver.findElement(By.xpath("(//*[contains(text(),'" + roomName + "')]//preceding::input[2])[1]")).click();
		    Thread.sleep(2000);
		    Delete.click();
		    click_yes.click();
		    SeleniumRepo.waitForPageLoaded();
		
		}
		else
		{
			System.out.println("room "+roomName+" not created yet");
		}

		/*List<WebElement> checkbox = SeleniumRepo.driver.findElements(By.xpath("//input[@name='selectedItems']"));
		int length = checkbox.size();

		try {
				// String Room1= "'Classic King_G3'";
				System.out.println(roomName);
				WebElement roomTypeEle = SeleniumRepo.driver
						.findElement(By.xpath("(//*[contains(text(),'" + roomName + "')]//preceding::input[2])[1]"));
				// System.out.println(notcount);
				if (SeleniumRepo.driver
						.findElements(By.xpath("(//*[contains(text(),'" + roomName + "')]//preceding::input[2])[1]")).size()>0)
				{
					SeleniumRepo.driver
					.findElement(By.xpath("(//*[contains(text(),'" + roomName + "')]//preceding::input[2])[1]")).click();
					Delete.click();
					click_yes.click();
				}
				else
					System.out.println("No Element found");

				// System.out.println("Room Delete" + roomName);
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
