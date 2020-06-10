package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Taxes_Fees;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_TaxesAndFees extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"
				+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"TaxesAndFees");     

		return (testObjArray);
	}
	
	
	@Test(priority=1, enabled=true , description = "Deleting all exsisting taxes" )
	public void testTaxesAndFeesDeleation() throws Exception 
	{
		

			Taxes_Fees CreateTaxFees =PageFactory.initElements(SeleniumRepo.driver, Taxes_Fees.class);
			
			System.out.println("----------------------------------------");

			logger.info("Removing taxes");

			test = extent.createTest("Removing taxes");

			SeleniumRepo.waitForPageLoaded();

			CreateTaxFees.click_TaxesAndFeesLink();
			
			SeleniumRepo.waitForPageLoaded();

			
			CreateTaxFees.delete_AllTaxes();
			
			SeleniumRepo.waitForPageLoaded();

			
			//CreateTaxFees.delete_Tax("ouun");
			
			//CreateTaxFees.click_addtax();
			
			//CreateTaxFees.requiredFieldErrorCheck();
			
			
			//CreateTaxFees.editTaxStartDate("11/2/2020");
			//CreateTaxFees.editTaxEndDate("11/29/2019");


			
			//CreateTaxFees.editApplyTaxOrFeeRateRange("true");
			
			//CreateTaxFees.createRateRageTax("700:na:na:98;100:200:na:20");
			
			//CreateTaxFees.editTaxRateRangesFrom("2", "300", "500", "23");
			
			//CreateTaxFees.editTaxRateRangesFrom("1", "100", "5200", "998");
			
			//CreateTaxFees.deleteTaxRateRanges("2");
			//CreateTaxFees.deleteTaxRateRanges("1");


			
			//CreateTaxFees.editTaxLink("PerStay PerRoom 10%_V71400");

	}

	@Test(priority=2, enabled=true ,dataProvider = "dataSupplier")
	public void testCreationTaxesAndFees(HashMap<String, String> h) throws Exception {
		
		
		Taxes_Fees CreateTaxFees =PageFactory.initElements(SeleniumRepo.driver, Taxes_Fees.class);

		//add get data from excel 
		
		String Property_TaxesOrFee_Value= h.get("TaxOrFeeType").toString().trim();
		String Property_Taxes_Title= h.get("Property_Taxes_Title").toString().trim();
		String Tax_Name= h.get("Tax_Name").toString().trim();
		String Tax_Code= h.get("Tax_Code").toString().trim();
		String Charge_Frequency= h.get("Charge_Frequency").toString().trim();
		String Charge_Basis= h.get("Charge_Basis").toString().trim();
		String Charge_Type= h.get("Charge_Type").toString().trim();
		String Charge_Amount= h.get("Charge_Amount").toString().trim();
				
		
		 switch(Property_TaxesOrFee_Value){
			
			
			case "tax":
				
				/*   */
				
				CreateTaxFees.click_TaxesAndFeesLink();	
				SeleniumRepo.waitForPageLoaded();
				CreateTaxFees.click_addtax();
				SeleniumRepo.waitForPageLoaded();
				CreateTaxFees.requiredFieldErrorCheck();
				SeleniumRepo.waitForPageLoaded();

				CreateTaxFees.editTaxName(Tax_Name);
				//CreateTaxFees.editTaxType(Property_TaxesOrFee_Value, "State tax");
				CreateTaxFees.editTaxCode(Tax_Code);
				CreateTaxFees.editApplyTaxOnOtherTaxes("disable"); //keep as no
				//CreateTaxFees.editTaxStartDate("10/23/2019");
				//CreateTaxFees.editTaxEndDate("9/23/2025");
				CreateTaxFees.editTaxChargeFrequency(Charge_Frequency);
				CreateTaxFees.editTaxChargeBasis(Charge_Basis);
				CreateTaxFees.editTaxChargeType(Charge_Type);
				CreateTaxFees.editTaxChargeAmount(Charge_Amount);
				CreateTaxFees.editTaxChargeAmountEnableChangesAfter("enable", "2", "50");
				CreateTaxFees.editTaxChargeByRoomsInRmType("disable");
				CreateTaxFees.editTaxChargeBasedOnRate("Booked Rate");
				CreateTaxFees.editTaxDayOfWeekApp("Need to Re factor"); //currently this only checks off "all" option
				CreateTaxFees.editTaxAppliesToChild("enable"); //only enabled when charge basis is set to person 
				CreateTaxFees.editTaxDescription("This is a test taxe");
				
				
				CreateTaxFees.clickTaxesAndFeesSaveButton();
				SeleniumRepo.waitForPageLoaded();

				
				break;
				
			case "fee":
				
				/*  */
				
				CreateTaxFees.click_TaxesAndFeesLink();	
				SeleniumRepo.waitForPageLoaded();
				CreateTaxFees.click_addtax();
				SeleniumRepo.waitForPageLoaded();
				CreateTaxFees.requiredFieldErrorCheck();
				SeleniumRepo.waitForPageLoaded();

				CreateTaxFees.editTaxName(Tax_Name);
				//CreateTaxFees.editTaxType(Property_TaxesOrFee_Value, "Room service fee");
				CreateTaxFees.editTaxCode(Tax_Code);
				CreateTaxFees.editApplyTaxOnOtherTaxes("disable"); //keep as no
				//CreateTaxFees.editTaxStartDate("9/23/2019");
				//CreateTaxFees.editTaxEndDate("9/23/2025");
				CreateTaxFees.editTaxChargeFrequency(Charge_Frequency);
				CreateTaxFees.editTaxChargeBasis(Charge_Basis);
				CreateTaxFees.editTaxChargeType(Charge_Type);
				CreateTaxFees.editTaxChargeAmount(Charge_Amount);
				CreateTaxFees.editTaxChargeAmountEnableChangesAfter("enable", "2", "100");
				CreateTaxFees.editTaxChargeByRoomsInRmType("disable");
				CreateTaxFees.editTaxChargeBasedOnRate("Booked Rate");
				CreateTaxFees.editTaxDayOfWeekApp("Need to Re factor"); //currently this only checks off "all" option
				CreateTaxFees.editTaxAppliesToChild("enable");
				CreateTaxFees.editTaxDescription("This is a test Fee");
				
				CreateTaxFees.clickTaxesAndFeesSaveButton();
				SeleniumRepo.waitForPageLoaded();

				
				
				System.out.println("From the TC of guest preference questions  multiple sec");
				
				break;
				
			case "rangeTax":
				/*  */
				CreateTaxFees.click_TaxesAndFeesLink();		
				SeleniumRepo.waitForPageLoaded();

				CreateTaxFees.click_addtax();	
				SeleniumRepo.waitForPageLoaded();

				CreateTaxFees.requiredFieldErrorCheck();
				
				SeleniumRepo.waitForPageLoaded();

				CreateTaxFees.editTaxName(Tax_Name);
				//CreateTaxFees.editTaxType("tax", "State tax");
				CreateTaxFees.editTaxCode(Tax_Code);
				//CreateTaxFees.editTaxStartDate(startDate);
				//CreateTaxFees.editTaxEndDate("9/23/2025");
				CreateTaxFees.editTaxChargeFrequency(Charge_Frequency);
				CreateTaxFees.editTaxChargeType(Charge_Type);
				CreateTaxFees.editApplyTaxOrFeeRateRange("True");
				CreateTaxFees.createRateRageTax("700:na:na:98;100:200:na:20;201:300:na:30;301:400:na:40");


				CreateTaxFees.clickTaxesAndFeesSaveButton();
				SeleniumRepo.waitForPageLoaded();

				
				break;

				default:
					
					//Creates a tax that will get added on top of other taxes
					CreateTaxFees.click_TaxesAndFeesLink();	
					SeleniumRepo.waitForPageLoaded();

					CreateTaxFees.click_addtax();
					SeleniumRepo.waitForPageLoaded();

					CreateTaxFees.requiredFieldErrorCheck();
					SeleniumRepo.waitForPageLoaded();

					CreateTaxFees.editTaxName(Tax_Name);
					//CreateTaxFees.editTaxType("tax", "Surcharge");
					CreateTaxFees.editTaxCode(Tax_Code);
					CreateTaxFees.editApplyTaxOnOtherTaxes("enable");
					CreateTaxFees.editTaxChargeAmountOnOtherTaxes(Charge_Amount);
					
					CreateTaxFees.clickTaxesAndFeesSaveButton();
					SeleniumRepo.waitForPageLoaded();


					
			
			
			}
	

	}

	/**
	 *  Original test case method used for testing  the original method createTaxFees
	 * @param h
	 * @throws Exception
	 */
	//@Test(priority=3, enabled=true ,dataProvider = "dataSupplier")
	public void testTaxesAndFees(HashMap<String, String> h) throws Exception 
	{
		try 
		{

			Taxes_Fees CreateTaxFees =PageFactory.initElements(SeleniumRepo.driver, Taxes_Fees.class);
			String Property_Taxes_Title= h.get("Property_Taxes_Title").toString().trim();
			String Tax_Name= h.get("Tax_Name").toString().trim();
			String Tax_Code= h.get("Tax_Code").toString().trim();
			String Charge_Frequency= h.get("Charge_Frequency").toString().trim();
			String Charge_Basis= h.get("Charge_Basis").toString().trim();
			String Charge_Type= h.get("Charge_Type").toString().trim();
			String Charge_Amount= h.get("Charge_Amount").toString().trim();

			System.out.println("----------------------------------------");

			logger.info("Adding tax wiht tax name"+Tax_Name);

			test = extent.createTest("Adding tax wiht tax name "+Tax_Name);

			CreateTaxFees.createTaxFees(Property_Taxes_Title, Tax_Name, Tax_Code,
					Charge_Frequency, Charge_Basis, Charge_Type, Charge_Amount);
			
			SeleniumRepo.waitForPageLoaded();

			
			System.out.println("-------Tax_Name "+Tax_Name+" created successfully---------");
			test.log(Status.INFO, "-------Tax_Name "+Tax_Name+" created successfully---------");
			logger.info("-------Tax_Name "+Tax_Name+" created successfully---------");
			

		} catch (Exception e) {
			logger.error("Unable to create Taxes And Fees property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Taxes And Fees property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}}

}
