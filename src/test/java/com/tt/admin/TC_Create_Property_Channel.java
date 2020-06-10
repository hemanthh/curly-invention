package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.ChannelCreation;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;



public class TC_Create_Property_Channel extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	@DataProvider
	public Object[][] dataSupplier() throws IOException {
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"ChannelCreation");

		return (testObjArray);
	}


	@Test(dataProvider = "dataSupplier",groups = {"SMOKE"}, enabled = true)
	public void createChannel(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		try 
		{


			ChannelCreation chnlCreation =PageFactory.initElements(SeleniumRepo.driver, ChannelCreation.class);

			test = extent.createTest("TT PROPERTY CHANNEL CREATION");
			logger.info("Creating Channel for selected property ");

			String sabreHotelCode = h.get("sabreHotelCode");
			String GalileoHotelCode = h.get("GalileoHotelCode");
			String WorldspanHotelCode = h.get("WorldspanHotelCode");
			String AmadeusHotelCode = h.get("AmadeusHotelCode");
			String AdsHotelCode = h.get("AdsHotelCode");

			System.out.println("----------------------------------------");
			chnlCreation.createChannel(sabreHotelCode, GalileoHotelCode, WorldspanHotelCode, AmadeusHotelCode, AdsHotelCode);

			chnlCreation.navigateToChannels_Pg();
			
			
			//chnlCreation.navigateToPmsChannelGroupSettingsPg();

			chnlCreation.navigateToGdsChannelGroupSettingsPg();
			chnlCreation.editGDSstatusDropDown("Inactive");
			chnlCreation.editGDSChannelTypeWorldspan("Cakkmee");
			chnlCreation.cancelGDSbutton();
			
			chnlCreation.deletePMSChannelGroup();
			
			chnlCreation.navigateToAddNewChannelGroup_PG();

			chnlCreation.channelGroupSelectionPg("PMS");
			chnlCreation.navigateToPMSAddNewChannelPg();
			chnlCreation.editPMSChannelTypeDropDown("Opera PMS");
			chnlCreation.editPMSStatusDropDown("InActive");
			//https://qa1.ttaws.com/xsys/xsysWS
			chnlCreation.editPMSExternalServerURI("www.LOOOL.com");
			chnlCreation.editPMSRetryIntervalMiliSec("0");
			chnlCreation.editPMSMaxRetryCount("255");
			
			chnlCreation.submitPMSbutton();
			
			chnlCreation.navigateToChannels_Pg();
			
			SeleniumRepo.waitForPageLoaded();
			
			//must delete because currently some job is not running to 
			//that allows a pms to be deleted after bookings are made
			chnlCreation.deletePMSChannelGroup();

			
			
			
			
			
		} 
		catch (Exception e) 
		{
			logger.error("Unable to Add property channel because of this execption" + e);
			test.log(Status.FAIL, "Unable to Add property channel because of this execption" + e);
			Assert.assertEquals(false, true);
			e.printStackTrace();

		}

	}

}



