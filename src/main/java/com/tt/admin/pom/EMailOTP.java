package com.tt.admin.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.CharMatcher;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class EMailOTP extends BaseTest {
	
	@FindAll({ @FindBy(xpath = "//input[@name='identifier']"),
	})
	public WebElement Mail_UserName;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Next')]"),
	})
	public WebElement Mail_Next;

	@FindAll({ @FindBy(xpath = "//input[@name='password']"),
	})
	public WebElement Mail_Password;
	
	@FindAll({ @FindBy(xpath = "//button[@id='next']"), })
	public WebElement next;
	
	@FindAll({ @FindBy(xpath = "//input[@name='otp_code']"), })
	public WebElement otp_code;
	
	@FindAll({ @FindBy(xpath = "//button[normalize-space(.)='Submit']"), })
	public WebElement otpSubmit;

	@FindAll({ @FindBy(xpath = "//div[@class='y6']//span[contains(text(),'OTP For Authentication')]"),
	})
	public List<WebElement> openAuthenticationMail;
	
	@FindAll({ @FindBy(xpath = "//p[contains(text(),' (OTP) has been generated')]"), })
	public WebElement getOTP;
	
	public void clickNext()
	{
		ExplicitWait(next);
		next.click();
	}
	
	public void enteringOTP(String OTP)
	{
		ExplicitWait(otp_code);
		otp_code.sendKeys(OTP);
		otpSubmit.click();
		
	}
	
	
	public void openEMail()
	{
		List<String>tabs1=windowidList();
		SeleniumRepo.driver.switchTo().window(tabs1.get(1));
	}	
		
	public String loginEmail() throws Exception {
		SeleniumRepo.waitForPageLoaded();
		Thread.sleep(1000);

		// System.out.println("***********Login****************");

		SeleniumRepo.driver.get(ReadProperties.getPropValues("Admin.properties", "Email"));

		SeleniumRepo.waitForPageLoaded();
		SeleniumRepo.waitForElementPresent(Mail_UserName);
		Mail_UserName.sendKeys(ReadProperties.getPropValues("Admin.properties", "Email_username"));

		Mail_Next.click();

		SeleniumRepo.waitForPageLoaded();
		SeleniumRepo.waitForElementPresent(Mail_Password);
		Mail_Password.sendKeys(ReadProperties.getPropValues("Admin.properties", "Email_password"));
		
		Javascriptexecutor(Mail_Next);
		Thread.sleep(9000);
		try {
		Javascriptexecutor(openAuthenticationMail.get(0));
		}catch(Exception e) {
			if(openAuthenticationMail.get(0).isDisplayed())
			{
			Javascriptexecutor(openAuthenticationMail.get(0));
			}
		}
	    Thread.sleep(5000);
		String otp= getOTP.getText().trim();
		String OTP= CharMatcher.inRange('0', '9').retainFrom(otp);
		return OTP;

	}
	

}
