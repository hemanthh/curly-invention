package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AlternateProperties;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_AlternateProperties extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] AlternateProperties() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AlternateProperties");

		return (testObjArray);
	}
	@Test(dataProvider = "AlternateProperties",priority=1,description="Create New Alternate Property")
	public void NewAlternateproperty(HashMap<String, String> h) throws Exception 
	{
		try 
		{
			AlternateProperties AlterPoprty =PageFactory.initElements(SeleniumRepo.driver, AlternateProperties.class);


			String AlternatePropertyTilte = h.get("AlternatePropertyTilte").toString().trim();
			String PropertyCode = h.get("PropertyCode").toString().trim();
			String channel = h.get("channel").toString().trim();

			System.out.println("----------------------------------------");


			test = extent.createTest("Delete and Add Alternate Property");
			logger.info("Delete and Add Alternate Property ");


			AlterPoprty.click_alternate();
			AlterPoprty.delete_alternate();
			AlterPoprty.click_AddProperty(channel, AlternatePropertyTilte);
			AlterPoprty.Click_Save();
			AlterPoprty.Verify_SaveError();
			AlterPoprty.Enter_PropertyCode(PropertyCode);
			AlterPoprty.Click_Save();
			AlterPoprty.verify_DeleteError();	
		} 
		catch (Exception e) 
		{
			logger.error("Unable to Add new property because of this execption" + e);
			test.log(Status.FAIL, "Unable to Add new property because of this execption" + e);
			Assert.assertEquals(false, true);
			e.printStackTrace();

		}
	}
}
