package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AddNewProperty;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_Add_NewProperty extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AddNewProperty");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier")
	public void addNewProperty(HashMap<String, String> h) throws Exception {
		
		try {
			AddNewProperty addNewPrty =PageFactory.initElements(SeleniumRepo.driver, AddNewProperty.class);
			/*AddNewProperty addPrtyDefault =PageFactory.initElements(SeleniumRepo.driver, AddNewProperty.class);        
			AddNewProperty addPrtyMaster =PageFactory.initElements(SeleniumRepo.driver, AddNewProperty.class);*/
		
		test = extent.createTest(" Creating  New Property");
		logger.info("Creating  New Property");
		
		            String PropertyName= h.get("PropertyName").toString().trim();
					String PropertyCode=  h.get("PropertyCode").toString().trim();
					String EnterPropertySubDomain = h.get("PropertySubDomain").toString().trim();
					String EnterAddress1 =  h.get("Address1").toString().trim();
					String EnterCityName =  h.get("CityName").toString().trim();
					String EnterCountryName =  h.get("CountryName").toString().trim();
					String EnterZipCode =  h.get("ZipCode").toString().trim();
					String AddPropertyTitle = h.get("AddPropertyTitle").toString().trim();
					
					/*
					 //***********Property Defaults********************
					 
				
					String PropertyDefaultsTitle = h.get("PropertyDefaultsTitle").toString().trim();
					String StarRating = h.get("StarRating").toString().trim();
					String Adultage = h.get("Adultage").toString().trim();
					String CheckinTime = h.get("CheckinTime").toString().trim();
					String CheckoutTime = h.get("CheckoutTime").toString().trim();
					
					//***********Property Masters********************
					
					String PropertyMasterTitle = h.get("PropertyMasterTitle").toString().trim();
					String Phone_Code = h.get("Phone_Code").toString().trim();
					String Phone_Area_Code = h.get("Phone_Area_Code").toString().trim();
					String Phone_Number = h.get("Phone_Number").toString().trim();
					String Website_URL = h.get("Website_URL").toString().trim();
					String Primary_Email = h.get("Primary_Email").toString().trim();
					String NumberOf_Rooms = h.get("NumberOf_Rooms").toString().trim();
					String NumberOf_Floors = h.get("NumberOf_Floors").toString().trim();
					String FirstBedTypeName = h.get("FirstBedTypeName").toString().trim();
					String FirstBedCode = h.get("FirstBedCode").toString().trim();
					String SecondBedTypeName = h.get("SecondBedTypeName").toString().trim();
					String  SecondBedCode = h.get("SecondBedCode").toString().trim();
					String ThirdBedTypeName = h.get("ThirdBedTypeName").toString().trim();
					String ThirdBedCode = h.get("ThirdBedCode").toString().trim();
					String  Visa = h.get("Visa").toString().trim();
					String MasterCard = h.get("MasterCard").toString().trim();
					String AmericanExpress = h.get("AmericanExpress").toString().trim();
					String Short_Description= h.get("Short_Description").toString().trim();
					*/
					System.out.println("----------------------------------------"); 
					
					logger.info("AddNew Opened");
					addNewPrty.newProperty(PropertyName, PropertyCode, EnterPropertySubDomain, 
							EnterAddress1, EnterCityName, EnterCountryName, EnterZipCode,AddPropertyTitle);
					/*finalAssertTrue(true,
						    "AddNew Created  successfully");*/
					System.out.println("----------------------------------------"); 
					
					/*
					logger.info("ProperptyDefault Opened");
					addPrtyDefault.propertyDefault(PropertyDefaultsTitle, StarRating, Adultage, 
							CheckinTime,CheckoutTime);
					finalAssertTrue(true,
						    "ProperptyDefault Created successfully");
					System.out.println("----------------------------------------"); 
					

					logger.info("propertyMaster Opened");
					addPrtyMaster.propertyMaster(PropertyMasterTitle, Phone_Code, Phone_Area_Code, 
							Phone_Number, Website_URL, Primary_Email, NumberOf_Rooms, NumberOf_Floors, 
							FirstBedTypeName, FirstBedCode, SecondBedTypeName, SecondBedCode, ThirdBedTypeName,
							ThirdBedCode, Visa, MasterCard, AmericanExpress, Short_Description);
					finalAssertTrue(true,
						    "propertyMaster Created successfully");
					System.out.println("----------------------------------------"); 
	
	*/
					
		} catch (Exception e) {
			logger.error("Unable to create New Property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create New Property because of this execption" + e);
			/*finalAssertTrue(false,
				    "Failed to create New Property  ");*/
			e.printStackTrace();
		
		
		}
	
	}
}

