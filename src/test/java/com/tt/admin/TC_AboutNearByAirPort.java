package com.tt.admin;
import java.io.IOException;
import org.apache.log4j.Logger;
import java.util.HashMap;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AboutNearBYAirPort;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;


public class TC_AboutNearByAirPort extends BaseTest{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException {

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AboutNearByAirport");

		return (testObjArray);
	}
	@Test(dataProvider = "dataSupplier")
	public void airport(HashMap<String, String> h) throws InterruptedException, IOException {
		try {
		AboutNearBYAirPort NearByAirport =PageFactory.initElements(SeleniumRepo.driver, AboutNearBYAirPort.class);
		
		
			String AirportName = h.get("AirportName").toString().trim();
			String AirportCode = h.get("AirportCode").toString().trim();
			String AirportURL = h.get("AirportURL").toString().trim();
			String AirportDescription = h.get("AirportDescription").toString().trim();
			String AirportAddress1 = h.get("AirportAddress1").toString().trim();
			String AirportCity = h.get("AirportCity").toString().trim();
			String AirportCountry = h.get("AirportCountry").toString().trim();
			String Zipcode = h.get("Zipcode").toString().trim();
			String DistanceAway = h.get("DistanceAway").toString().trim();
			String DistanceUnit = h.get("DistanceUnit").toString().trim();
			String TranspotationMode = h.get("TranspotationMode").toString().trim();

			System.out.println("----------------------------------------");
			
			test = extent.createTest(" Creating NearBy Airport "+AirportName);
			logger.info(" Creating NearBy Airport "+AirportName);
			
			NearByAirport.nearByAirport(AirportName, AirportCode, AirportURL, AirportDescription, 
					AirportAddress1, AirportCity, AirportCountry, Zipcode, DistanceAway, 
					DistanceUnit,TranspotationMode);
			
			System.out.println("-------Airport Name "+AirportName+" created successfully---------");
			test.log(Status.INFO, "-------Airport Name "+AirportName+" created successfully---------");
			
			/*finalAssertTrue(true,
				    "Near By Airport  selected successfully");*/
			
			
		} catch (Exception e) {
			logger.error("Unable to create NearBy Airport" + e);
			test.log(Status.ERROR, "Unable to create NearBy Airport" + e);
			/*finalAssertTrue(true,
				    "Failed to select Near By Airport ");*/
			e.printStackTrace();
			Assert.assertEquals(false,true);
		}}}
