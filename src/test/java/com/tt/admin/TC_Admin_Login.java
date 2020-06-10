package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.admin.pom.Login;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * 
 * @author suneetha This test case read the data from excel and login to the
 *         application with valid username and password
 */
public class TC_Admin_Login extends BaseTest 
{
	Logger logger = Logger.getLogger(TC_Admin_Login.class);
	@DataProvider

	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");
		System.out.println(fileName);

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(System.getProperty("user.dir")+"\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx","Login");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier",groups = {"SMOKE"})
	public void test(HashMap<String, String> h) throws InterruptedException, IOException 
	{

		Login loginPage =PageFactory.initElements(SeleniumRepo.driver, Login.class);
		test = extent.createTest("TT ADMIN LOGIN");
		logger.info("Login with valid userName and Password");

		//String userName = h.get("UserName");
		//String pwd = h.get("Password");

		//String userName = ReadProperties.getPropValues("Admin.properties", "AdminUsername");
		//String pwd = ReadProperties.getPropValues("Admin.properties", "AdminPassword");

		System.out.println("----------------------------------------");
		logger.info("Browser Opened");
		//Currenlty login info is being sent from the Admin.properties file
		//created another method that will take the info from excel
		loginPage.login(/*userName, pwd*/);
		//loginPage.login(userName, pwd);


	}
}
