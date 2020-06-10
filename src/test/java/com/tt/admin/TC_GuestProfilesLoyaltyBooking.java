package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AddNewRatePlan;
import com.tt.admin.pom.BrandSelection;
import com.tt.admin.pom.Login;
import com.tt.admin.pom.SelectProperty;
import com.tt.admin.pom.guestProfilesLoyaltyBooking;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_GuestProfilesLoyaltyBooking extends BaseTest 
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    
	@DataProvider
	public Object[][] GuestProfilesLoyaltyBooking() throws IOException 
	{
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"GuestProfileLoyalty");
		return (testObjArray);
	}
	
	@Test(dataProvider = "GuestProfilesLoyaltyBooking",priority=0/*,description="GuestProfilesLoyaltyBooking"*/)
	public void guestProfiles(HashMap<String, String> h1) throws Exception 
	{ 
		Login Login=PageFactory.initElements(SeleniumRepo.driver, Login.class);
	    SelectProperty SelectProperty=PageFactory.initElements(SeleniumRepo.driver, SelectProperty.class);
	    BrandSelection BrandSelection =PageFactory.initElements(SeleniumRepo.driver, BrandSelection.class);
	    guestProfilesLoyaltyBooking guestProfilesLoyaltyBooking =PageFactory.initElements(SeleniumRepo.driver, guestProfilesLoyaltyBooking.class);
		try 
		{	
			String brand=h1.get("BrandName").toString().trim();
			String PropertyName=h1.get("PropertyName").toString().trim();
			String LoyaltyType=h1.get("Loyalty Type").toString().trim();
			
			test = extent.createTest("guestProfiles Test Started");
			logger.info("guestProfiles Test Started");
			
			Login.login();
			BrandSelection.selectBrand(brand);
			SelectProperty.selectProperty_ByPropertyName(PropertyName);
			guestProfilesLoyaltyBooking.clickonmainandsubtabs("Property Management","Property Defaults");
		    SeleniumRepo.scrollintoview(guestProfilesLoyaltyBooking.EnableingLoyalty);
		    guestProfilesLoyaltyBooking.EnableingLoyalty.click();
		    selectByVisibleText(guestProfilesLoyaltyBooking.SelectLoyaltyDropDown,LoyaltyType);
		    guestProfilesLoyaltyBooking.SavePropertyDeafults.click();
		    guestProfilesLoyaltyBooking.clickonmainandsubtabs("Property Management","Edit");
		    String subdomain=guestProfilesLoyaltyBooking.PropertySubDomain.getAttribute("value");
		    windowid();
		    SeleniumRepo.driver.switchTo().window(NewWindow);
		    guestProfilesLoyaltyBooking.GoToUrl(subdomain);
		    if(!(guestProfilesLoyaltyBooking.GuestProfileLogin.isDisplayed()&&guestProfilesLoyaltyBooking.GuestProfileSignup.isDisplayed()))
		    {
		    	logger.error("Login OR Signup Link is not Present even activated Loyalty feature to the property");
				test.log(Status.FAIL, "Login OR Signup Link is not Present even activated Loyalty feature to the property");
				Assert.assertEquals(false, true);
		    }
		    SeleniumRepo.driver.switchTo().window(ParentWindow);
		    Thread.sleep(3000);
//		    guestProfilesLoyaltyBooking.clickonmainandsubtabs("Property Management","Property Defaults");
//		    SeleniumRepo.scrollintoview(guestProfilesLoyaltyBooking.DisableLoyalty);
//		    guestProfilesLoyaltyBooking.DisableLoyalty.click();
//		    guestProfilesLoyaltyBooking.SavePropertyDeafults.click();
//		    SeleniumRepo.handleAlert();
//		    SeleniumRepo.driver.switchTo().window(NewWindow);
//		    SeleniumRepo.driver.close();
//		    SeleniumRepo.driver.switchTo().window(ParentWindow);
//		    windowid();
//		    SeleniumRepo.driver.switchTo().window(NewWindow);
//		    guestProfilesLoyaltyBooking.GoToUrl(subdomain);
//		    if(guestProfilesLoyaltyBooking.GuestProfileLogin.isDisplayed()&&guestProfilesLoyaltyBooking.GuestProfileSignup.isDisplayed())
//		    {
//		    	logger.error("Login OR Signup Link is Present even deactivated Loyalty feature to the property");
//				test.log(Status.FAIL, "Login OR Signup Link is Present even deactivated Loyalty feature to the property");
//				Assert.assertEquals(false, true);
//		    }
		    
		}  
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.error("Unable to Close the room/rate  because of this execption" + e);
			test.log(Status.FAIL, "Unable to Close the room/rate  because of this execption" + e);
			Assert.assertEquals(false, true);
		}
	}
	
	@DataProvider
	public Object[][] Rateplane() throws IOException 
	{
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AddNewRatePlan");
		return (testObjArray);
	}
	public Object[][] data() throws IOException {
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");
		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"GuestProfileLoyalty");
		return (testObjArray);
	}
	@SuppressWarnings("unchecked")
	@DataProvider
	public Object[][] data1() throws IOException {

		HashMap<String, String> result = new HashMap<String, String>();
		  result.putAll((HashMap<String, String>)data()[0][0]);
		  result.putAll((HashMap<String, String>)Rateplane()[0][0]);
		  Object[][] o=new Object[1][0];
		  o[0]=new Object[] {result};
		  return o;
	}
	@Test(priority=1,dataProvider = "data1")
	public void guestProfilesReservation(HashMap<String, String> h) throws Exception 
	{   
	    guestProfilesLoyaltyBooking guestProfilesLoyaltyBooking =PageFactory.initElements(SeleniumRepo.driver, guestProfilesLoyaltyBooking.class);
	    AddNewRatePlan NewRatePlan =PageFactory.initElements(SeleniumRepo.driver, AddNewRatePlan.class);
		try 
		{	String RatePlaneCatagoryname="Guest Profile Category";
		    String Roomcategoryname="HiTech Rooms";
		    String LoyaltyTireName="GuestProfile";
		    String Rateplane=h.get("Name").toString().trim();
		    String PropertyName=h.get("PropertyName").toString().trim();
			test = extent.createTest("guestProfiles Reservation Test Started");
			logger.info("guestProfiles Reservation Test Started");
			guestProfilesLoyaltyBooking.clickonmainandsubtabs("Rate Plans","Rate Plan Categories");
			guestProfilesLoyaltyBooking.createRatePlaneCatagory(RatePlaneCatagoryname);
			guestProfilesLoyaltyBooking.clickonmainandsubtabs("Rooms","Room Categories");
			guestProfilesLoyaltyBooking.createRoomCatagory(Roomcategoryname);
			guestProfilesLoyaltyBooking.createRoomType("RoomCreation",Roomcategoryname);
			guestProfilesLoyaltyBooking.addNewRateplane("AddNewRatePlan",RatePlaneCatagoryname);
			guestProfilesLoyaltyBooking.addNewrategrid("Rategrid");
//			guestProfilesLoyaltyBooking.clickonmainandsubtabs("Rate Plans","List All");
//			NewRatePlan.Name_Search(Rateplane);
//			guestProfilesLoyaltyBooking.ratePlaneEdit(Rateplane).click();
			guestProfilesLoyaltyBooking.clickonmainandsubtabs("Loyalty Program","Loyalty Tier");
			guestProfilesLoyaltyBooking.addNewLoyaltyTire(LoyaltyTireName, PropertyName);
			guestProfilesLoyaltyBooking.clickonmainandsubtabs("Loyalty Program","Tier To Rate Plan Mapping");
			guestProfilesLoyaltyBooking.addTiretoRatePlaneMapping(LoyaltyTireName,Rateplane);
			SeleniumRepo.driver.switchTo().window(NewWindow);
			
		}  
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.error("Unable to Close the room/rate  because of this execption" + e);
			test.log(Status.FAIL, "Unable to Close the room/rate  because of this execption" + e);
			Assert.assertEquals(false, true);
		}
	}

}
