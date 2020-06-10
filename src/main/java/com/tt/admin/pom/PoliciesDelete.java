package com.tt.admin.pom;



import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class PoliciesDelete extends BaseTest {
	WebDriver driver ;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//ul[@id='accordion']/li"),

	})
	private List<WebElement> Policies_link;


	@FindAll({@FindBy(xpath = "//a[contains(@href, 'displayPolicies.do?')]"),
		@FindBy(css = "ul:nth-child(3) li:nth-child(6) ul:nth-child(2) li:nth-child(1) > a:nth-child(1)"),

	})
	private WebElement ListAll_link;




	@FindAll({ @FindBy(xpath = "//input[@name='policyIdCheckbox']"),

	})
	private List<WebElement> Select_policyIdCheckbox;

	@FindAll({ @FindBy(xpath = "//input[@value='Delete']"),

	})
	private WebElement Delete_Policy;


	@FindAll({ @FindBy(xpath = "//*[text()='Policies']"),

	})
	private WebElement Click_Policies;


	public void deletePolicy(String PolicyName) {

		try 
		{
			if (ListAll_link.isDisplayed()) 
			{
				Javascriptexecutor(ListAll_link);
				SeleniumRepo.waitForPageLoaded();
				ExplicitWait(Delete_Policy);
				System.out.println("Policies element Expanded and policies list element  found");
				test.log(Status.INFO, "Policies element Expanded and policies list element  found");
				Assert.assertTrue(true, "Policies element Expanded and policies list element  found");
			} 
			else 
			{
				System.out.println("Policies Menu is not expanded");
				Javascriptexecutor(Click_Policies);
				System.out.println("Clicked on policies Link");
				test.log(Status.INFO, "Clicked on policies Link");

				ExplicitWait(ListAll_link);
				if(ListAll_link.isDisplayed())
				{
					Javascriptexecutor(ListAll_link);
					SeleniumRepo.waitForPageLoaded();
					ExplicitWait(Delete_Policy);
					System.out.println("policies list element found");
					test.log(Status.INFO, "policies list element found");
					Assert.assertTrue(true, "policies list element found");
				}
				else
				{
					logger.info("policies list element not  found");
					test.log(Status.FAIL, "policies list element not  found");
				}
			}

			Thread.sleep(3000);
			if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains(PolicyName))
			{
				System.out.println("policy "+PolicyName+" already created");
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()[contains(.,'"+PolicyName+"')]]//preceding-sibling::td[1]//input[1]")));
				Thread.sleep(2000);

				Javascriptexecutor(Delete_Policy);
				Thread.sleep(2000);
				
				SeleniumRepo.handleAlert();
				SeleniumRepo.waitForPageLoaded();
				ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("(//*[@name='policyIdCheckbox'])[1]")));
				System.out.println("Policy Deleted"+PolicyName);
			}
			else
			{
				System.out.println("policy "+PolicyName+" not yet created");
			}

			/*
			int length = Select_policyIdCheckbox.size();
			System.out.println(length);
			try {

				if(SeleniumRepo.driver.findElements(By.xpath("//*[text()[contains(.,'"+PolicyName+"')]]//preceding-sibling::td[1]//input[1]")).size()>0)
				{

					WebElement policy=SeleniumRepo.driver.findElement(By.xpath("//*[text()[contains(.,'"+PolicyName+"')]]//preceding-sibling::td[1]//input[1]"));
					System.out.println(policy);
					policy.click();
					Delete_Policy.click();
					Thread.sleep(2000);
					SeleniumRepo.handleAlert();
					SeleniumRepo.waitForPageLoaded();
					System.out.println("Policy Deleted"+PolicyName);
				}
				else 
				{
					System.out.println("Policy "+ PolicyName+" not yet created");
				}
			} 
			catch (Exception e) 
			{
				logger.error("Unable to  Delete Policy for selected property because of this execption" + e);
				test.log(Status.ERROR, "Unable to Delete Policyfor selected property because of this execption" + e);
				e.printStackTrace();
			}*/
		} 
		catch (Exception e)
		{
			logger.error("Unable to create Policies for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Policies for selected property because of this execption" + e);
			e.printStackTrace();
		}	


	}

}
