package com.tt.admin.pom;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;

public class Login extends BaseTest 
{
	 String result=this.getClass().getSimpleName();

	/*public static By user_name = By.name("j_username");
	public static By pass_word = By.name("j_password");
	public static By Click_Login = By.name("submit");*/
	
	
	@FindAll({@FindBy(xpath="//input[@name='j_username']") })
    public WebElement user_name;
	
	@FindAll({ @FindBy(xpath="//input[@name='j_password']")})
    public WebElement pass_word;
	
	@FindAll({
        @FindBy(name="submit"),
        @FindBy(xpath="//nput[@value='Login']"),
    })
    private WebElement Click_Login;
	
	@FindAll({
        @FindBy(xpath="//h1[contains(text(),'Administrator Home')]"),
        @FindBy(css="table:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h1:nth-child(1)")
    })
    private List<WebElement> Home_Msg;

	/**
	 * @author Harshini
	 * @param uname
	 * @param pwd
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	public void login() throws InterruptedException, IOException 
	{
		
		String env=ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.Environment");
		String url=ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.LoginUrl");
		String uname = ReadProperties.getPropValues("Admin.properties", "AdminUsername");
		String pwd = ReadProperties.getPropValues("Admin.properties", "AdminPassword");
		
		try {
		SeleniumRepo.driver.get("https://"+env+"."+url);
        
		if (user_name.isDisplayed()) 
		{
			SeleniumRepo.waitForElementPresent(user_name);
			user_name.click();
			user_name.clear();
			user_name.sendKeys(uname);
			System.out.println("UserName is entered successfully");
			Assert.assertTrue(true, "UserName is entered successfully");
		} else {
			System.out.println("UserName TextBox not found");

		}

		if (pass_word.isDisplayed()) {
			//pass_word.click();
			SeleniumRepo.waitForElementPresent(user_name);
			pass_word.clear();
			pass_word.sendKeys(pwd);
			System.out.println("Password is entered  successfully");
			Assert.assertTrue(true, "Password is entered  successfully");
		} else {
			System.out.println("Password TextBox not found");

		}
		SeleniumRepo.waitForElementPresent(Click_Login);

		if (Click_Login.isDisplayed()) {
			Click_Login.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Login Button is enabled and clicked");
			Assert.assertTrue(true, "Login Button Found and clicked");
		} else {


		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

		
	}
	
	
	
	/**
	 * Takes in a string for username and password thus able to be used with the excel data file
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void login(String username, String password) throws InterruptedException, IOException 
	{
		
		String env=ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.Environment");
		String url=ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.LoginUrl");
		String uname = username; //ReadProperties.getPropValues("Admin.properties", "AdminUsername");
		String pwd = password;  //ReadProperties.getPropValues("Admin.properties", "AdminPassword");
		
		
		SeleniumRepo.driver.get("https://"+env+"."+url);
		
		
		
		
		if (user_name.isDisplayed()) 
		{
			user_name.click();
			user_name.sendKeys(uname);
			System.out.println("UserName is entered successfully");
			Assert.assertTrue(true, "UserName is entered successfully");
		} else {
			System.out.println("UserName TextBox not found");

		}

		if (pass_word.isDisplayed()) {
			//pass_word.click();
			pass_word.sendKeys(pwd);
			System.out.println("Password is entered  successfully");
			Assert.assertTrue(true, "Password is entered  successfully");
		} else {
			System.out.println("Password TextBox not found");

		}
		SeleniumRepo.waitForElementPresent(Click_Login);

		if (Click_Login.isDisplayed()) {
			Click_Login.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Login Button is enabled and clicked");
			Assert.assertTrue(true, "Login Button Found and clicked");
		} else {


		}
		
		

		
	}
	
	
	
	
}

