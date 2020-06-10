/**
 * 
 */
package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.admin.pom.AddOnTaxes;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

/**
 * @author DM
 *
 */
public class TC_AddOnTaxes extends BaseTest {
	
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"
				+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"AddOnsTaxes");     

		return (testObjArray);
	}
	
	
	
	@Test(priority=1, enabled=true , description = "Enabling addon Taxes and deleting exsisitng  addon taxes " )
	public void testAddOnTaxes() throws Exception  {
		
		AddOnTaxes CreateAddOnTaxFees =PageFactory.initElements(SeleniumRepo.driver, AddOnTaxes.class);
		
		CreateAddOnTaxFees.enablingAddOnTaxes();
		SeleniumRepo.waitForPageLoaded();

		
		CreateAddOnTaxFees.setAddOnPriceTypeToInclusive();
		SeleniumRepo.waitForPageLoaded();
		
		CreateAddOnTaxFees.click_TaxesAndFeesLink();
		SeleniumRepo.waitForPageLoaded();
		
		CreateAddOnTaxFees.delete_AllAddOnTaxes();
		SeleniumRepo.waitForPageLoaded();


		
		

		
	}
	
	
	//@Test(priority=2, enabled=true , description = "Deleting all exsisting taxes" )
	@Test(priority=2, enabled=true ,dataProvider = "dataSupplier")
	public void testAddOnTaxesCreation(HashMap<String, String> h) throws Exception 
	{
		

			AddOnTaxes CreateAddOnTaxFees =PageFactory.initElements(SeleniumRepo.driver, AddOnTaxes.class);
			
			System.out.println("----------------------------------------");
			
			
			String AddOnTaxesOrFee_Value= h.get("TaxOrFeeType").toString().trim();
			String Tax_Name= h.get("Tax_Name").toString().trim();
			String Tax_Code= h.get("Tax_Code").toString().trim();
			String AddOnTaxesOrFee_ChargeType= h.get("Charge_Type").toString().trim();
			String Tax_Basis= h.get("Tax_Basis").toString().trim();
			String Apply_On= h.get("Apply_On").toString().trim();
			String Charge_Amount= h.get("Charge_Amount").toString().trim();
			String AddOn_Tax_Description= h.get("AddOn_Tax_Description").toString().trim();

			

			logger.info("AddOn taxes");

			test = extent.createTest("AddOn Taxes");
			
			//System.out.println("____________________________ " + " charge amount " + Charge_Amount);
			
			 switch(AddOnTaxesOrFee_ChargeType){
				
				
				case "Percent":
					
					CreateAddOnTaxFees.click_addAddOntax();
					SeleniumRepo.waitForPageLoaded();
					
					CreateAddOnTaxFees.requiredFieldErrorCheck();

					CreateAddOnTaxFees.editAddOnTaxName(Tax_Name);
					//CreateAddOnTaxFees.editAddOnTaxType(AddOnTaxesOrFee_Value);
					CreateAddOnTaxFees.editAddOnTaxCode(Tax_Code);
					
					CreateAddOnTaxFees.editAddOnTaxChargeType(AddOnTaxesOrFee_ChargeType);
					CreateAddOnTaxFees.editAddOnTaxApplyOn(Apply_On);
					
					CreateAddOnTaxFees.editAddOnTaxChargeAmount(Charge_Amount);
					CreateAddOnTaxFees.editTaxDescription(AddOn_Tax_Description);
					
					CreateAddOnTaxFees.clickAddOnTaxesAndFeesSaveButton();
					SeleniumRepo.waitForPageLoaded();

					
					
					break;
					
				case "Flat Fee":
					
				
						
					CreateAddOnTaxFees.click_addAddOntax();
					SeleniumRepo.waitForPageLoaded();
						
					CreateAddOnTaxFees.requiredFieldErrorCheck();

					CreateAddOnTaxFees.editAddOnTaxName(Tax_Name);
					//CreateAddOnTaxFees.editAddOnTaxType(AddOnTaxesOrFee_Value);
					CreateAddOnTaxFees.editAddOnTaxCode(Tax_Code);
					
					CreateAddOnTaxFees.editAddOnTaxChargeType(AddOnTaxesOrFee_ChargeType);
					
					CreateAddOnTaxFees.editAddOnTaxBasis(Tax_Basis);
					
					CreateAddOnTaxFees.editAddOnTaxChargeAmount(Charge_Amount);
					CreateAddOnTaxFees.editTaxDescription(AddOn_Tax_Description);
					
					CreateAddOnTaxFees.clickAddOnTaxesAndFeesSaveButton();
					
					SeleniumRepo.waitForPageLoaded();
					
					
				default:
					
					
			 }
			
			
			/*
			 
				CreateAddOnTaxFees.click_TaxesAndFeesLink();
				SeleniumRepo.waitForPageLoaded();
				
				CreateAddOnTaxFees.click_addAddOntax();
				SeleniumRepo.waitForPageLoaded();
				
			CreateAddOnTaxFees.requiredFieldErrorCheck();

			CreateAddOnTaxFees.editAddOnTaxName("AddOn Tax Flat ");
			CreateAddOnTaxFees.editAddOnTaxType("Tax");
			CreateAddOnTaxFees.editAddOnTaxCode("AD");
			
			CreateAddOnTaxFees.editAddOnTaxBasis("Apply Per Addon unit");
			
			CreateAddOnTaxFees.editAddOnTaxChargeAmount("15");
			CreateAddOnTaxFees.editTaxDescription("This is an addon tax that is a Flat Fee");
			
			CreateAddOnTaxFees.clickAddOnTaxesAndFeesSaveButton();
			
			SeleniumRepo.waitForPageLoaded();
						
			//CreateAddOnTaxFees.delete_AddOnTax("AddOn Tax Flat _Z33010");
			
			CreateAddOnTaxFees.delete_RandomAddOnTax();
			
			SeleniumRepo.waitForPageLoaded();
			
			*/

	}
	
	
	
	@Test(priority=3, enabled=true , description = "Disabeling Addon Taxes" )
	public void testAddOnTaxesDisabeling() throws Exception 
	{
		AddOnTaxes CreateAddOnTaxFees =PageFactory.initElements(SeleniumRepo.driver, AddOnTaxes.class);

		CreateAddOnTaxFees.disableAddOnTaxes();
		
	}
	
	
	

}
