package com.tt.admin.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.tt.admin.pom.GuestPreferenceQuestion;

public class DeleteGuestPreference extends BaseTest 
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({
		@FindBy(xpath="//ul[@id='accordion']/li"),})
	
	private List<WebElement> Click_GuestPQ;

	@FindAll({ @FindBy(xpath = "//*[contains(text(), 'Guest Preference Questions')]"),
	})
	
	private WebElement Click_GuestPQ_link;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'List All')]"),

	})
	private WebElement Click_List;

	@FindAll({ @FindBy(css = "td.greybg table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) td.prompt:nth-child(6) > a:nth-child(1)"),

	})
	private WebElement Click_Delete;

	@FindAll({ @FindBy(xpath = "//*[text()='OK']"),

	})
	private WebElement Delete_OK;

	@FindAll({ @FindBy(xpath = "//*[@id='update']"), 
	})
	
	public WebElement Update;

	@FindAll({ @FindBy(xpath = "//input[@value='Save']"), 
	})

	private WebElement Click_SaveGuestPQ;

	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Guest Preference Questions')]"), 
	})

	private WebElement GPQ_Text;


	@SuppressWarnings("deprecation")
	public void delete() throws InterruptedException 
	{
		if (SeleniumRepo.driver.findElement(By.xpath("//*[text()='List All']")).isDisplayed()) 
		{
			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List All']")));
			ExplicitWait(GPQ_Text);
			System.out.println("Guest Preference Questions element Expanded and List All element  found");
			test.log(Status.INFO, "Guest Preference Questions element Expanded and List All element  found");
			Assert.assertTrue(true, "Guest Preference Questions element Expanded and List All element  found");
		} 
		else 
		{
			System.out.println("Guest Preference Questions Menu is not expanded");
			Javascriptexecutor(Click_GuestPQ_link);
			System.out.println("Clicked on Guest Preference Questions Link");
			test.log(Status.INFO, "Clicked on Guest Preference Questions Link");

			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List All']")));

			if(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List All']")).isDisplayed())
			{
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()='List All']")));
				System.out.println("Clicked on List all");
				ExplicitWait(GPQ_Text);
				Thread.sleep(2000);
				System.out.println("List All element found");
				test.log(Status.INFO, "List All  element found");
				Assert.assertTrue(true, "List All element found");
			}
			else
			{
				logger.info("List All element not  found");
				test.log(Status.FAIL, "List All element not  found");
			}
		}

		List<WebElement> checkbox = SeleniumRepo.driver.findElements(By.xpath("//input[@name='orderIndex']"));

		int length = checkbox.size();

		if(!(length==0))
		{

			for (int i = 0; i < length; i++)
			{
				Javascriptexecutor(Click_Delete);
				Thread.sleep(2000);
				//GetElement(locatorType.xPath, Delete_OK).click();

				FluentWait<WebDriver> Wait = new FluentWait<WebDriver>(SeleniumRepo.driver)
						.withTimeout(30, TimeUnit.SECONDS)
						.pollingEvery(5, TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class)
						.ignoring(StaleElementReferenceException.class);

				WebElement element = Wait.until(new Function<WebDriver, WebElement>() 
				{
					public WebElement apply(WebDriver driver)
					{
						WebElement element = Delete_OK;
						return element;
					}
				});

				ExplicitWait((Update));
			}
		}
		else
		{
			System.out.println("There are no Guest preference questions to delete");
		}
	}
}
