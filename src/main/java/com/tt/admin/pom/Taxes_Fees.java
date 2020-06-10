package com.tt.admin.pom;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;


public class Taxes_Fees extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();
	
	//Consider adding property edit class object so its possible to enable addon Taxes

	
	
	@FindAll({ @FindBy(xpath = "//li[contains(text(),'Tax Name Required')]"), })
    private WebElement Check_ErrorTaxNameLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Tax Code Required')]"), })
    private WebElement Check_ErrorTaxCodeLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Charge Frequency required')]"), })
    private WebElement Check_ErrorTaxChargeFreqLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Charge Basis required')]"), })
    private WebElement Check_ErrorTaxChargeBasisLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Charge Type required')]"), })
    private WebElement Check_ErrorTaxChargeTypeLabel;
    
    @FindAll({ @FindBy(xpath = "//li[contains(text(),'Charge Amount is required and must be greater than 0, and of format #, #.#, #.## or #.### (up to 3 decimals)')]"), })
    private WebElement Check_ErrorTaxChargeAmountLabel;
    
    @FindAll({ @FindBy(xpath = "//font[@color='red']/li[contains(text(),'Tax Code')]"), })
    private WebElement Check_ErrorTaxSelectAdayLabel;
    

	@FindAll({ @FindBy(xpath = "//a[contains(., 'Taxes')]"), 
		@FindBy(css = "ul:nth-child(3) li:nth-child(3) ul:nth-child(2) li:nth-child(7) > a:nth-child(1)") 
	})
	private WebElement Click_TaxesFees;

	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Property Taxes')]"),
		@FindBy(css = "table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) > h1:nth-child(1)")
	})
	private WebElement Verify_Property_Taxes;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Add New Tax to Property')]"),
		@FindBy(css = "tbody:nth-child(1) tr:nth-child(1) td:nth-child(3) p:nth-child(3) > a:nth-child(1)") 
	})
	private WebElement Click_AddNewTaxToPropertyLinkText;	

	@FindAll({ @FindBy(xpath = "//input[@name='taxName']"),
		@FindBy(css = "table.formtable:nth-child(10) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > input.input.guest-facing-fields")
	})
	private WebElement Enter_Tax_Name;	

	@FindAll({ @FindBy(xpath = "//input[@name='code']"),
		@FindBy(css = "table.formtable:nth-child(10) tbody:nth-child(1) tr:nth-child(4) td:nth-child(2) > input:nth-child(1)")
	})
	private WebElement Enter_Tax_Code;	

	@FindAll({ @FindBy(xpath = "//input[contains(@name,'chargeFrequency')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(1) > td:nth-child(2)") 
	})
	private List<WebElement>Enter_Charge_Frequency;	

	@FindAll({ @FindBy(xpath = "//input[contains(@name,'chargeBasis')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(2)") 
	})
	private List<WebElement> Enter_Charge_Basis;	

	@FindAll({ @FindBy(xpath = "//input[contains(@name,'chargeType')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(3) > td:nth-child(2)") 
	})
	private List<WebElement> Enter_Charge_Type;	

	@FindAll({ @FindBy(xpath = "//input[@id='amountId']"),
		@FindBy(css = "#amountId")
	})
	private WebElement Enter_Charge_Amount;	

	
	@FindAll({ @FindBy(xpath = "//input[@id='txtChargeAmount']")
	})
	private WebElement Enter_Charge_Amount_On_OtherTaxes;	

	@FindAll({ @FindBy(xpath = "//input[@name='dowCheckAll']"),
		@FindBy(css = "table.formtable:nth-child(13) tbody:nth-child(1) tr:nth-child(3) td:nth-child(2) > input:nth-child(1)")
	})
	private WebElement DayOfWeekAll;	


	@FindAll({ @FindBy(xpath = "//input[@id='btnSubmit']"),
		@FindBy(css = "#btnSubmit") })
	private WebElement Click_SaveButton;	


	@FindAll({ @FindBy(xpath = "//a[contains(text(),'PerStay PerRoom 10%')]"),
		@FindBy(css = "table.listtable:nth-child(2) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > a:nth-child(1)") 
	})
	private List<WebElement> PerStayPerRoom10;	


	@FindAll({ @FindBy(xpath = "//form[@name='listTaxForm']//tbody//tr[2]"),
		@FindBy(css = "td:nth-child(3) form:nth-child(4) table.listtable:nth-child(2) tbody:nth-child(1) > tr:nth-child(2)") 
	})
	
	private  List<WebElement> ListTaxForm;	

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"), })
	private WebElement property_Management;
	
	
	 @FindAll({ @FindBy(xpath = "//*[@id='listTaxForm']/p[1]/input"), })
	 public WebElement Click_TaxDelete_button;

	
	 
	 @FindAll({ @FindBy(xpath = "//*[@value='Delete']"), })
	 public WebElement Delete_Button;
	 

		 @FindAll({ @FindBy(xpath = "//*[@name='taxIdsToDelete']"), })
	 public List <WebElement> all_TaxesAndFees_Delete_CheckBox;
	 
	 
	 	@FindAll({ @FindBy(xpath = "//*[text()='OK']"), })
public WebElement Delete_OK;

@FindAll({ @FindBy(xpath = "//*[text()='Cancel']"), })
public WebElement Delete_Cancel;


@FindAll({ @FindBy(xpath = "//td[ text()='Type ']") })
public WebElement TaxOrFeeType_Field;

@FindAll({ @FindBy(xpath = "//*[@name='taxFeeType' and @value='tax']") })
public WebElement Click_TaxOrFeeType_Tax;

@FindAll({ @FindBy(xpath = "//*[@name='taxFeeType' and @value='fee']") })
public WebElement Click_TaxOrFeeType_Fee;


@FindAll({ @FindBy(xpath = "//select[@name='selectedTaxValue']") })
public WebElement Select_TaxType_DropDown;

@FindAll({ @FindBy(xpath = "//select[@name='selectedFeeValue']") })
public WebElement Select_FeeType_DropDown;


 @FindAll({ @FindBy(xpath = "//td[contains(text(),'Tax Description')]") })
public WebElement TaxDescription_Field;

@FindAll({ @FindBy(xpath = "//textarea[@name='description']") })
public WebElement Enter_TaxDescription_Text;



 	 @FindAll({ @FindBy(xpath = "//td[contains(text(),'Charge by Rooms in Room Type')]") })
public WebElement ChargeByRooms_Field;

@FindAll({ @FindBy(xpath = "//*[@name='chargeByRooms' and @value='true']") })
public WebElement Click_ChargeByRooms_Enable;

@FindAll({ @FindBy(xpath = "//*[@name='chargeByRooms' and @value='false']") })
public WebElement Click_ChargeByRooms_Disable;
 
 



 @FindAll({ @FindBy(xpath = "//input[@type='checkbox' and @name='taxValueChanges']") })
public WebElement AmountChangeAft_CheckBox;

@FindAll({ @FindBy(xpath = "//input[@name='taxValueChangesAfter']") })
public WebElement Enter_AmountChangeAft_Text;

@FindAll({ @FindBy(xpath = "//input[@name='taxValueChangesTo']") })
public WebElement Enter_AmountTaxChgsTo_Text;	 



 @FindAll({ @FindBy(xpath = "//td[contains(text(),'Apply Tax on other Taxes')]") })
public WebElement TaxOnOtherTaxes_Field;

@FindAll({ @FindBy(xpath = "//*[@name='isTaxOnTax' and @value='true']") })
public WebElement Click_TaxOnOtherTaxes_Enable;

@FindAll({ @FindBy(xpath = "//*[@name='isTaxOnTax' and @value='false']") })
public WebElement Click_TaxOnOtherTaxes_Disable;




 @FindAll({ @FindBy(xpath = "//td[contains(text(),'Charge Based on which Rate')]") })
public WebElement ChargeBasedOnRate_Field;

@FindAll({ @FindBy(xpath = "//*[@name='taxBasisRatePlanId']") })
public WebElement Click_ChargeBasedOnRate_DropDown;






 @FindAll({ @FindBy(xpath = "//td[contains(text(),'Applies to Children')]") })
public WebElement AppliesToChildren_Field;

@FindAll({ @FindBy(xpath = "//*[@name='appliesToChildren' and @value='true']") })
public WebElement Click_AppliesToChildren_Enable;

@FindAll({ @FindBy(xpath = "//*[@name='appliesToChildren' and @value='false']") })
public WebElement Click_AppliesToChildren_Disable;






@FindAll({ @FindBy(xpath = "//td[contains(text(),'Apply Tax (or fee) on Rate Range')]") })
public WebElement ApplyTaxOnRateRange_Field;

@FindAll({ @FindBy(xpath = "//*[@name='taxSlabEnabled' and @value='true']") })
public WebElement Click_ApplyTaxOnRateRange_Tru;

@FindAll({ @FindBy(xpath = "//*[@name='taxSlabEnabled' and @value='false']") })
public WebElement Click_ApplyTaxOnRateRange_False;


//*[@id='listTaxForm']/table[1]/tbody/tr/td/a -> use this xpath if addon's are enable
@FindAll({ @FindBy(xpath = "//*[@id='listTaxForm']/table/tbody/tr/td/a") })
public  List <WebElement> allTaxesAndFeeLink;


@FindAll({ @FindBy(xpath = "//*[@id='taxSlabTable']/tbody/tr") })
public List <WebElement> allRateRageTaxTable_Rows;


@FindAll({ @FindBy(xpath = "//*[@id='taxSlabTable']/tbody/tr[1]/th[6]/a") })
public WebElement RateRageTaxTable_AddLink;



@FindAll({ @FindBy(xpath = "//a[@onmouseover=\"window.status='Date Picker';\"]") })
public List <WebElement> datePickerLinks;




@FindAll({ @FindBy(xpath = "//tr[@class='headrow'][2]/td[@colspan='1'][1]") })
public WebElement callendarNavigationArrows_LeftYear;

@FindAll({ @FindBy(xpath = "//tr[@class='headrow'][2]/td[@colspan='1'][4]") })
public WebElement callendarNavigationArrows_RightYear;

@FindAll({ @FindBy(xpath = "//tr[@class='headrow'][2]/td[@colspan='1'][2]") })
public WebElement callendarNavigationArrows_LeftMonth;

@FindAll({ @FindBy(xpath = "//tr[@class='headrow'][2]/td[@colspan='1'][3]") })
public WebElement callendarNavigationArrows_RighMonth;




@FindAll({ @FindBy(xpath = "//td[@class='caltitle']") })
public WebElement currentMonthYear;

//td[@class='day today']

@FindAll({ @FindBy(xpath = "//td[@class='day today']") })
public WebElement callendarTodaysDate;

	@FindAll({ @FindBy(xpath = "//td[@class='day']") })
public List<WebElement> callendarWeekDaysDate;
	
	@FindAll({ @FindBy(xpath = "//td[@class='day weekend']") })
public List<WebElement> callendarWeekendDate;
	
	
	@FindAll({ @FindBy(xpath = "//td[@class='day selected today']") })
	public WebElement callendarCurrentDateIsSelected;

	@FindAll({ @FindBy(xpath = "//td[@class='day selected weekend']") })
	public WebElement callendarWkEndDateIsSelected;

	@FindAll({ @FindBy(xpath = "//td[@class='day selected']") })
	public WebElement callendarWkDateIsSelected;



 








//div[@id='visitRatePlanTaxes']    -> rate plan div that popups up after creating a tax or fee

//*[@id="listTaxForm"]/table/tbody/tr/td/a -> captures all link taxes and will allow to edit 

/**
 * TODO: 1. Create methods that will interact with the List all page (will ignore the "Rate Plan Taxes" link
 * 		 2. Create a error code check for required fields on tax edit page
 * 		 3. Create methods for each field 
 * 
 * 
 * 
 * Note: for calendar - going to assign months numbers , will do current "month - selected" (if 0 same month, if - move forward, if positive move backwards)
 * https://stackoverflow.com/questions/2268969/convert-month-string-to
 * https://stackoverflow.com/questions/20331163/how-to-format-joda-time-datetime-to-only-mm-dd-yyyy
 *  
 *  
 */



	public void editTaxLink(String taxesOrFeesName){
				

		  for(int a = 0; a < allTaxesAndFeeLink.size(); a++ ){
		  
		  	if(allTaxesAndFeeLink.get(a).getText().equals(taxesOrFeesName) ) {
		  		allTaxesAndFeeLink.get(a).click();
		  	}
		  
		  }
		  
		  System.out.println("Successfully clicked tax name link:  " + taxesOrFeesName);
			logger.info("Editing the tax or fee titled  "  +  taxesOrFeesName);
			test.log(Status.PASS,"Successfully clicked tax name link:  " + taxesOrFeesName );
			//Assert.assertTrue(true, "Tax_Name is entered successfully");
	}
	
	
	
	
	public void editTaxName(String Tax_Name){
		
		
		ExplicitWait(Enter_Tax_Name);
		if (Enter_Tax_Name.isDisplayed()) 
		{
			Enter_Tax_Name.click();
			Enter_Tax_Name.clear();
			Enter_Tax_Name.sendKeys(Tax_Name+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			System.out.println(" Tax_Name is entered successfully");
			logger.info("Tax_Name is entered successfully");
			test.log(Status.PASS,
					"Tax_Name is entered successfully" );
			Assert.assertTrue(true,
					"Tax_Name is entered successfully");
		} else {
			System.out.println("Tax_Name TextBox not found");
			logger.error("Failed to Enter Tax_Name in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Tax_Name in TextBox");
			Assert.assertFalse(false, 
					"Tax_Name TextBox not found");
		}
		
		
	}
	
	public void editTaxType(String type, String actualTaxOrFee) throws InterruptedException{
		
		
		SeleniumRepo.isElementDisplayed(TaxOrFeeType_Field);
		
		Assert.assertEquals(TaxOrFeeType_Field.isDisplayed(), true, "Tax Type Field is not being displayed");

		
		
		if (type.equalsIgnoreCase("Tax")) {

			Click_TaxOrFeeType_Tax.click();
			SeleniumRepo.WaitForLoad(100);
			
			Select_TaxType_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_TaxType_DropDown, actualTaxOrFee);
			
			//simplify this to match the radio button and dropdown

			System.out.println("Tax was selected successfully as Type and category tax selected is  " + actualTaxOrFee );
			logger.info("Tax was selected successfully as Type and category tax selected is  " + actualTaxOrFee);
			test.log(Status.PASS, "Tax was selected successfully as Type and category tax selected is  " + actualTaxOrFee);
			

			Assert.assertTrue(Click_TaxOrFeeType_Tax.isSelected(), "Tax as type was selected sucessfully");

		}

		if (type.equalsIgnoreCase("Fee")) {

			Click_TaxOrFeeType_Fee.click();
			SeleniumRepo.WaitForLoad(100);
			
			
			Select_FeeType_DropDown.click();
			SeleniumRepoDropdown.selectDropDownText(Select_FeeType_DropDown, actualTaxOrFee);
			
			System.out.println("Fee was selected successfully as Type and category tax selected is  " + actualTaxOrFee );
			logger.info("Fee was selected successfully as Type and category tax selected is  " + actualTaxOrFee);
			test.log(Status.PASS, "Fee was selected successfully as Type and category tax selected is  " + actualTaxOrFee);
			

			Assert.assertTrue(Click_TaxOrFeeType_Fee.isSelected(), "Fee as type was selected sucessfully");
		}
		
	}
	
	
	public void editTaxCode(String Tax_Code){
		
		
		if (Enter_Tax_Code.isDisplayed())
		{
			Enter_Tax_Code.click();
			Enter_Tax_Code.clear();
			Enter_Tax_Code.sendKeys(Tax_Code+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			System.out.println(" Tax_Code is entered successfully");
			logger.info("Tax_Code is entered successfully");
			test.log(Status.PASS,
					"Tax_Code is entered successfully" );
			Assert.assertTrue(true,
					"Tax_Code is entered successfully");
		} else {
			System.out.println("Tax_Code TextBox not found");
			logger.error("Failed to Enter Tax_Code in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Tax_Code in TextBox");
			Assert.assertFalse(false, 
					"Tax_Code TextBox not found");
		}
		
	}
	
	public void editApplyTaxOnOtherTaxes(String status) throws InterruptedException{
	
		SeleniumRepo.waitForElementPresent(TaxOnOtherTaxes_Field);

		Assert.assertEquals(TaxOnOtherTaxes_Field.isDisplayed(), true, "Apply Tax on other Taxes Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_TaxOnOtherTaxes_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Apply Tax on other Taxes is enabled successfully");
			logger.info("Apply Tax on other Taxes selected successfully");
			test.log(Status.PASS, "Apply Tax on other Taxes selected successfully");
			Assert.assertTrue(Click_TaxOnOtherTaxes_Enable.isSelected(), "Apply Tax on other Taxes is Enabled");

		} else {

			Click_TaxOnOtherTaxes_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Apply Tax on other Taxes is disable ");
			logger.info(" Select disable for Apply Tax on other Taxes");
			test.log(Status.PASS, "Select Disable  for Apply Tax on other Taxes");

			Assert.assertTrue(Click_TaxOnOtherTaxes_Disable.isSelected(), "Apply Tax on other Taxes is disable");

		}

		
	}

	
	public void editTaxStartDate(String startDate) throws ParseException{
		
		editTaxDates(startDate, datePickerLinks.get(0));
		
		System.out.println("Entered End date:  " + startDate);
		logger.info("Entered End date:  " + startDate);
		test.log(Status.PASS,"Entered End date:  " + startDate);
		//Assert.assertTrue(true, "Tax_Name is entered successfully");
		
		
		
	}

	
	public void editTaxEndDate(String endDate) throws ParseException{
		
		//TODO: 

		editTaxDates(endDate, datePickerLinks.get(1));
		
		 System.out.println("Entered End date:  " + endDate);
			logger.info("Entered End date:  " + endDate);
			test.log(Status.PASS,"Entered End date:  " + endDate );
			//Assert.assertTrue(true, "Tax_Name is entered successfully");

		
		
	}
	
	
	//the identifyer being used to locate the items on the calendar changes depending on if 
	//the item is selected. so this method is used to verify if any of these items are visible 
	private WebElement calendarDateStatus() {
		
		//callendarCurrentDateIsSelected   callendarWkEndDateIsSelected   callendarWkDateIsSelected

		if( SeleniumRepo.isElementDisplayed(callendarCurrentDateIsSelected) == true){
			
			return callendarCurrentDateIsSelected;
			
		}else if(SeleniumRepo.isElementDisplayed(callendarWkEndDateIsSelected) == true){
		
		
		return callendarWkEndDateIsSelected;
		
		
		}else if( SeleniumRepo.isElementDisplayed(callendarWkDateIsSelected) == true ){
			
			return callendarWkDateIsSelected;
			
		}else{
			
			return callendarTodaysDate;
		}
		
		
	}
	
	
	private void calendarDatePicker(String selectingDate ){
		
		
		
		System.out.println("Elseee witd date " +  selectingDate);
	
	for(int wk = 0; wk < callendarWeekDaysDate.size(); wk++){
		
		
		//System.out.println(dateBreakDown[1] + " calenddar dates we are comparint to  ? "  + callendarWeekDaysDate.get(wk).getText() );
		
		if(selectingDate.equals(callendarWeekDaysDate.get(wk).getText() )){
			
			callendarWeekDaysDate.get(wk).click();
						
			
			break;
			
			
		}
	}
	
	for(int wkEd = 0; wkEd<callendarWeekendDate.size(); wkEd++){
		
		//System.out.println(dateBreakDown[1] +  " calenddar dates we are comparint to  ? "  + callendarWeekendDate.get(wkEd).getText());

		
		if(selectingDate.equals(callendarWeekendDate.get(wkEd).getText() )){
			
			callendarWeekendDate.get(wkEd).click();
			break;	
		}
	}
    	
	}
	
	
	
	private void editTaxDates(String dateInput , WebElement ele) throws ParseException{		
		
		//tr[@class='headrow'][1]/td[@colspan='1'] -> admin calendar buttons besides the month
		//td[@class='caltitle'] -> current calendar month,year title 
		//tr[@class='headrow'][2]/td[@colspan='1']  -> admin calendar arrows row
		//td[@class='day'] -> captures day
		//td[@class='day weekend'] -> captures weekend days
				
		ele.click();
				
		//WebElement regUl = SeleniumRepo.driver.findElement(By.xpath(("//td[@class='caltitle']")));

		
		String lol[] = currentMonthYear.getText().split(",");
		String dateBreakDown[] = dateInput.split("/");

		
		Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(lol[0]);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    
	    
	    int monthFromAdmin = cal.get(Calendar.MONTH);
		int yearFromAdmin = Integer.parseInt(lol[1].trim());
		
		
		int monthFromSd = Integer.parseInt(dateBreakDown[0]) - 1 ;
		int dayFromSd = Integer.parseInt(dateBreakDown[1] );
		int yearFromSd = Integer.parseInt(dateBreakDown[2]);
		
		//compare items 
		
		
		if(  monthFromAdmin == monthFromSd && yearFromAdmin == yearFromSd ){
			//Click the date requested
						
			if(dateBreakDown[1].equals(calendarDateStatus().getText())  ){
				
				calendarDateStatus().click();	
				
			}else if( SeleniumRepo.isElementDisplayed(callendarTodaysDate) == true  &&  dateBreakDown[1].equals(callendarTodaysDate.getText())) {
				
				
				callendarTodaysDate.click();
				
				
 			}else{
 				
				System.out.println("Elseee witd date " +  dateBreakDown[1]);
				calendarDatePicker(dateBreakDown[1] );
			}
					
		}

		
		if( (monthFromAdmin != monthFromSd)   ||  (yearFromAdmin != yearFromSd) ){
	
			//caluclate the amount of clicks reqired to find the requested month
			
			int reqMonth = (monthFromAdmin+1) - (monthFromSd+1); //return to normal values
			int reqYear = yearFromAdmin - yearFromSd;

			if((monthFromAdmin != monthFromSd)){
			
			if(reqMonth < 0){
				
				System.out.println("O");

				
				//select left month arrow
				for(int p =0; p> reqMonth; p--){
					//click the arrow 
					callendarNavigationArrows_RighMonth.click();

				}	
				
			}else{
				
				//select right month arrow 
				System.out.println("P");

				for(int p =0; p< reqMonth; p++){
					//click the arrow 
					callendarNavigationArrows_LeftMonth.click();

				}
				
			}
			
			
			}
			
					
			if(yearFromAdmin != yearFromSd){
								
				if(reqYear < 0){
					
					//select left year arrow
					for(int p =0; p> reqYear; p--){
						//click the arrow 
						callendarNavigationArrows_RightYear.click();

					}	
					
				}else{
					//select right year arrow 
					for(int p =0; p< reqYear; p++){
						//click the arrow 
						callendarNavigationArrows_LeftYear.click();
					}
					
				}
			}
			
			
			//call the date picking method
			if(dateBreakDown[1].equals(calendarDateStatus().getText())  ){
				
				calendarDateStatus().click();	
				
			}else{
			
			calendarDatePicker(dateBreakDown[1] );
			}

		}
		
		/*
	    System.out.println(monthFromAdmin == Calendar.SEPTEMBER);
	    //System.out.println(Calendar.SEPTEMBER);
	    System.out.println(monthFromAdmin);
	    System.out.println(monthFromSd);
	    System.out.println(dayFromSd);
	    System.out.println(yearFromAdmin + "  " + yearFromSd);
	    
	    System.out.println(" if condtions " + (monthFromAdmin == monthFromSd && yearFromAdmin == yearFromSd) );
	    
	    System.out.println(lol[0] + "   " + lol[1] );
	    
	    */

	}
			
		

	


	public void editTaxChargeFrequency(String Charge_Frequency ){
		
		
		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Frequency,Charge_Frequency);
			System.out.println("Charge Frequency is Selected succesfully");
			logger.info("Charge Frequency is Selected succesfully");
			test.log(Status.PASS,
					"Charge Frequency is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge Frequency is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge Frequency is not Selected");
			logger.error("Failed to Select Charge Frequency");
			test.log(Status.FAIL,
					"Failed to Select Charge Frequency");
			Assert.assertFalse(false, 
					"Failed to Select Charge Frequency");
			e.printStackTrace();
		}

		
	}
	
	public void editTaxChargeBasis(String Charge_Basis){

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Basis,Charge_Basis);
			System.out.println("Charge_Basisis Selected succesfully");
			logger.info("Charge_Basis is Selected succesfully");
			test.log(Status.PASS,
					"Charge_Basis is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge_Basis is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge_Basis is not Selected");
			logger.error("Failed to Select Charge Basis");
			test.log(Status.FAIL,
					"Failed to Select Charge Basis");
			Assert.assertFalse(false, 
					"Failed to Select Charge Basis");
			e.printStackTrace();
		}
		
	}
	
	public void editTaxChargeType(String Charge_Type){
		
		
		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Type,Charge_Type);
			System.out.println("Charge_Type is Selected succesfully");
			logger.info("Charge_Type is Selected succesfully");
			test.log(Status.PASS,
					"Charge_Type is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge_Type is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge_Type is not Selected");
			logger.error("Failed to Select Charge Type");
			test.log(Status.FAIL,
					"Failed to Select Charge Type");
			Assert.assertFalse(false, 
					"Failed to Select Charge Type");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void editApplyTaxOrFeeRateRange	(String applyingRateRange) throws InterruptedException{
		
		//if the above method, is true  the edit page changes and a new table is created with the remaining fields 
		//change based on which rate and tax description
		//See method  editTaxRateRanges		
		
		
		//SeleniumRepo.isElementDisplayed(TaxOrFeeType_Field);
		
		Assert.assertEquals(ApplyTaxOnRateRange_Field.isDisplayed(), true, "Apply Tax (or fee) on Rate Range Field is not being displayed");

		
		
		if (applyingRateRange.equalsIgnoreCase("True")  ) {

			Click_ApplyTaxOnRateRange_Tru.click();
			SeleniumRepo.WaitForLoad(100);
			
			//simplify this to match the radio button and dropdown

			System.out.println("Apply Tax (or fee) on Rate Range was selected successfully as " + applyingRateRange );
			logger.info("Apply Tax (or fee) on Rate Range was selected successfully as  " + applyingRateRange);
			test.log(Status.PASS, "Apply Tax (or fee) on Rate Range was selected successfully as " + applyingRateRange);
			

			Assert.assertTrue(Click_ApplyTaxOnRateRange_Tru.isSelected(), "Tax as type was selected sucessfully");

		}

		if (applyingRateRange.equalsIgnoreCase("False")) {

			Click_ApplyTaxOnRateRange_False.click();
			SeleniumRepo.WaitForLoad(100);
			
			System.out.println("Apply Tax (or fee) on Rate Range was selected successfully as " + applyingRateRange );
			logger.info("Apply Tax (or fee) on Rate Range was selected successfully as  " + applyingRateRange );
			test.log(Status.PASS, "Apply Tax (or fee) on Rate Range was selected successfully as  " + applyingRateRange );
			

			Assert.assertTrue(Click_ApplyTaxOnRateRange_False.isSelected(), "Apply Tax (or fee) on Rate Range was selected sucessfully");
		}
		
		
	}

	/*
	 * Notes: the first rate range automatically has upper Limit checked and it can not be deleted  as well as
	 *  the To field is not displayed.  After saving the frist range will be pushed to the bottom
	 * 
	 */
	
	//can take a single or bulk range entry
	public void createRateRageTax(String rateRangesToCreate){
		
		//need to create a formate that can be used  from:to:up:tax;
		
		//surround spliting in a if statment that confirms  ; is contained in the string
		//Take in the format, split the format and then call
		
		logger.info("Creating Range Rate Taxes based on this input  " + rateRangesToCreate );


		String[] individualRateRages;


		// this is for options

		if (rateRangesToCreate.contains(";") ) {

			individualRateRages = rateRangesToCreate.split("[;]");
			

			for (int c = 0; c < individualRateRages.length; c++) {


				if( individualRateRages[c].contains(":") ){

					addTaxRateRanges(individualRateRages[c]);
				}else{
					System.out.println("rate rage item does not match format");
				}
			}

		}else {
			
			addTaxRateRanges(rateRangesToCreate);

		}
		
		
	}
	
	private void addTaxRateRanges(String addingRateRage){
		
		
		//need to create a formate that can be used  from:to:up:tax -> 500:na:na:30

		
		//*[@id="taxSlabTable"]/tbody/tr[1]/th[6]/a -> "Add" link
		
		String from;
		String to;
		String tax;
		boolean chek;
		String[] rateRageData = null;
		
		
		List<WebElement> rateRageInputItems = SeleniumRepo.driver.findElements(By.xpath(("//*[@id='taxSlabTable']/tbody/tr[" + "2" + "]//input")));

		 from =  rateRageInputItems.get(0).getAttribute("value");
		 to = rateRageInputItems.get(1).getAttribute("value");
		 chek = rateRageInputItems.get(2).isSelected();
		 tax = rateRageInputItems.get(3).getAttribute("value");
		 
		 
		 System.out.println("from " + from +  " to  " +to + " chek "+ chek  + "  tax"+ tax+ "  compar " + from.equals(""));

		if (addingRateRage.contains(":")) {

			rateRageData = addingRateRage.split("[:]");

			}
		
		
		/*
		for(int o = 0; o < rateRageData.length; o++){
			System.out.println( "input data  " + rateRageData[o]);
		}*/

			
		//Handles initial rate range row 
		if(allRateRageTaxTable_Rows.size() < 3 && from.equals("") && to.equals("") && chek==true && tax.equals("")  ){
			 
				rateRageInputItems.get(0).click();
				rateRageInputItems.get(0).clear();
				rateRageInputItems.get(0).sendKeys(rateRageData[0]);
				
				
				rateRageInputItems.get(3).click();
				rateRageInputItems.get(3).clear();
				rateRageInputItems.get(3).sendKeys(rateRageData[3]);
				
			}else {
				//deals with  rate range rows after the 1st
				RateRageTaxTable_AddLink.click();
				
				int currentRatRand =  allRateRageTaxTable_Rows.size(); 
				
				System.out.println("nullsm " + currentRatRand );
				
				String currentRateRange = Integer.toString(currentRatRand );
				
				rateRageInputItems = SeleniumRepo.driver.findElements(By.xpath(("//*[@id='taxSlabTable']/tbody/tr[" + currentRateRange + "]//input")));
				
				rateRageInputItems.get(0).click();
				rateRageInputItems.get(0).clear();
				rateRageInputItems.get(0).sendKeys(rateRageData[0]);
				
				rateRageInputItems.get(1).click();
				rateRageInputItems.get(1).clear();
				rateRageInputItems.get(1).sendKeys(rateRageData[1]);
				
				rateRageInputItems.get(3).click();
				rateRageInputItems.get(3).clear();
				rateRageInputItems.get(3).sendKeys(rateRageData[3]);
				
			}
			
		}
		
	
	
	public void editTaxRateRangesFrom(String rangePosition, String fromValue, String toValue, String taxValue){
		
		//TODO:  need to add a create method that will create tax ranges    and add a method that will add a tax range(make this method private)
		// then make an edit method that will search for a range

		
		//*[@id="taxSlabTable"]/tbody/tr[3]//input  -> navigate inputs through a row
		
		//*[@id="taxSlabTable"]/tbody/tr -> get table's row by row
		
		//*[@id="taxSlabTable"]/tbody/tr[1]/th[6]/a -> "Add" link
		
		
		//Create a check to confirm Rate rage is enable for tax
		
		int realRangePostion = Integer.parseInt(rangePosition) + 1; // adding 1 to get the accurate row location 
		
		rangePosition = Integer.toString(realRangePostion);
		
		List <WebElement> rateRageInputItems = SeleniumRepo.driver.findElements(By.xpath(("//*[@id='taxSlabTable']/tbody/tr[" + rangePosition + "]//input")));
		
		
		if(rateRageInputItems.get(2).isEnabled() == true){
			
			rateRageInputItems.get(0).click();
			rateRageInputItems.get(0).clear();
			rateRageInputItems.get(0).sendKeys(fromValue);
			
			rateRageInputItems.get(3).click();
			rateRageInputItems.get(3).clear();
			rateRageInputItems.get(3).sendKeys(taxValue);
			
		}else{
		
		rateRageInputItems.get(0).click();
		rateRageInputItems.get(0).clear();
		rateRageInputItems.get(0).sendKeys(fromValue);
		
		rateRageInputItems.get(1).click();
		rateRageInputItems.get(1).clear();
		rateRageInputItems.get(1).sendKeys(toValue);
		
		rateRageInputItems.get(3).click();
		rateRageInputItems.get(3).clear();
		rateRageInputItems.get(3).sendKeys(taxValue);
		
		}
		
		
		
		
	}
	
	
	public void deleteTaxRateRanges(String rangePosition){
		
		
		logger.info("Deleting Tax Rate Ranges in position : " + rangePosition);

		
		int realRangePostion = Integer.parseInt(rangePosition) + 1; // adding 1 to get the accurate row location 
		
		rangePosition = Integer.toString(realRangePostion);
		
		List <WebElement> rateRageInputItems = SeleniumRepo.driver.findElements(By.xpath(("//*[@id='taxSlabTable']/tbody/tr[" + rangePosition + "]//input")));
		
		
		
		if(allRateRageTaxTable_Rows.size() < 3){
			
			System.out.println("Unable to delete the last rate range");
			
			
		}else{
			
			rateRageInputItems.get(4).click();

			
			
		}
		
		

		  test.log(Status.INFO, "Deleted Rate Range Taxe that occupied postion : "  + rangePosition);
			//Assert.assertFalse(allAddOnTaxesAndFeeLink.get(pos).getText().equals(addOntaxesOrFeesName), "Was not abel to delete addon taxes " +addOntaxesOrFeesName);

		
	}
	
	


	public void editTaxChargeAmountOnOtherTaxes(String Charge_Amount){
		
		
		if (Enter_Charge_Amount_On_OtherTaxes.isDisplayed()) 
		{
			Enter_Charge_Amount_On_OtherTaxes.click();
			Enter_Charge_Amount_On_OtherTaxes.clear();
			Enter_Charge_Amount_On_OtherTaxes.sendKeys(Charge_Amount);
			System.out.println(" Charge_Amount is entered successfully");
			logger.info("Charge_Amount is entered successfully");
			test.log(Status.PASS,
					"Charge_Amount is entered successfully" );
			Assert.assertTrue(true,
					"Charge_Amount is entered successfully");
		} else {
			System.out.println("Charge_Amount TextBox not found");
			logger.error("Failed to Enter Charge_Amount in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Charge_Amount in TextBox");
			Assert.assertFalse(false, 
					"Charge_AmountTextBox not found");
		}

	
		
	}
	


	
	public void editTaxChargeAmount(String Charge_Amount){
		
		
		if (Enter_Charge_Amount.isDisplayed()) 
		{
			Enter_Charge_Amount.click();
			Enter_Charge_Amount.clear();
			Enter_Charge_Amount.sendKeys(Charge_Amount);
			System.out.println(" Charge_Amount is entered successfully");
			logger.info("Charge_Amount is entered successfully");
			test.log(Status.PASS,
					"Charge_Amount is entered successfully" );
			Assert.assertTrue(true,
					"Charge_Amount is entered successfully");
		} else {
			System.out.println("Charge_Amount TextBox not found");
			logger.error("Failed to Enter Charge_Amount in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Charge_Amount in TextBox");
			Assert.assertFalse(false, 
					"Charge_AmountTextBox not found");
		}

	
		
	}
	
	

	
	public void editTaxChargeAmountEnableChangesAfter(String checkStatus, String nightsLosBefChange, String newChareAmount){		
		

		
		if (checkStatus.equalsIgnoreCase("disable")  && AmountChangeAft_CheckBox.isSelected() == true) {
			
			AmountChangeAft_CheckBox.click();
			
		}
		
		if (checkStatus.equalsIgnoreCase("enable")  && AmountChangeAft_CheckBox.isSelected() == false) {
			
			AmountChangeAft_CheckBox.click();
			
		}
		
		
	if (checkStatus.equalsIgnoreCase("enable")  && AmountChangeAft_CheckBox.isSelected() == true) {
			
		logger.error("Failed to Enter Charge_Amount in TextBox");

		
		Enter_AmountChangeAft_Text.click();
		Enter_AmountChangeAft_Text.clear();
		Enter_AmountChangeAft_Text.sendKeys(nightsLosBefChange);
		
		//Assert.assertEquals(Enter_AmountChangeAft_Text.getAttribute("value"), nightsLosBefChange, " Before Charge_Amount was not entered");
		test.log(Status.INFO,"Enter whwn new Charge_Amount charges go into effect TextBox");

		
		Enter_AmountTaxChgsTo_Text.click();
		Enter_AmountTaxChgsTo_Text.clear();
		Enter_AmountTaxChgsTo_Text.sendKeys(newChareAmount);	
		
		//Assert.assertEquals(Enter_AmountTaxChgsTo_Text.getText(), newChareAmount, "After Charge_Amount was not entered");
		test.log(Status.INFO,"Enter new Charge_Amount charges after LOS TextBox");

		
	 } 
	
	
		
	}
	
	
	
	public void editTaxChargeByRoomsInRmType(String status) throws InterruptedException{

		
		SeleniumRepo.waitForElementPresent(ChargeByRooms_Field);

		Assert.assertEquals(ChargeByRooms_Field.isDisplayed(), true, "Charge by Rooms in Room Type Field is not being displayed");

		// if (Click_RateCalendar.isDisplayed()) {}
		if (status.equalsIgnoreCase("enable")) {

			Click_ChargeByRooms_Enable.click();

			SeleniumRepo.WaitForLoad(100);

			System.out.println("Charge by Rooms in Room Type is enabled successfully");
			logger.info("Charge by Rooms in Room Type selected successfully");
			test.log(Status.PASS, "Charge by Rooms in Room Type selected successfully");
			Assert.assertTrue(Click_ChargeByRooms_Enable.isSelected(), "Charge by Rooms in Room Type is Enabled");

		} else {

			Click_ChargeByRooms_Disable.click();
			SeleniumRepo.WaitForLoad(100);

			System.out.println("Charge by Rooms in Room Type is disable ");
			logger.info(" Select disable for Charge by Rooms in Room Type");
			test.log(Status.PASS, "Select Disable  for Charge by Rooms in Room Type");

			Assert.assertTrue(Click_ChargeByRooms_Disable.isSelected(), "Charge by Rooms in Room Type is disable");

		}

		
	}
	
	public void editTaxChargeBasedOnRate(String seleRate){

	
		SeleniumRepo.waitForElementPresent(ChargeBasedOnRate_Field);

		Assert.assertEquals(ChargeBasedOnRate_Field.isDisplayed(), true, "Charge Based on which Rate Field is not being displayed");

		
		Click_ChargeBasedOnRate_DropDown.click();
		SeleniumRepoDropdown.selectDropDownText(Click_ChargeBasedOnRate_DropDown, seleRate);
		
		
		logger.info("Charge Based on which Rate was selected successfully");
		test.log(Status.PASS, "Charge Based on which Rate was selected successfully");
		
		
	}
	
	
	public void editTaxDayOfWeekApp(String Day_OfWeek) throws InterruptedException{
		
		//Notes: going to open this up and allow ability to pick days
		
		/*
		 
		 //TODO: Last

		 
		 //input[@name='dowMonday']
		 //input[@name='dowTuesday']
		 //input[@name='dowWednesday']
		 //input[@name='dowThursday']
		 //input[@name='dowFriday']
		 //input[@name='dowSaturday']
		 //input[@name='dowSunday']
		 
		 
		 */
		
		if (DayOfWeekAll.isDisplayed()) 
		{
			if (DayOfWeekAll.isSelected() == false)
				DayOfWeekAll.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println("DayOfWeekAll is Clicked successfully");
			logger.info("Clicked on DayOfWeekAll");
			test.log(Status.PASS,
					"Clicked on DayOfWeekAll" );
			Assert.assertTrue(true,
					"DayOfWeekAll is Clicked successfully");
		} else {
			System.out.println("DayOfWeekAll not Clicked");
			logger.error("Failed to Click on DayOfWeekAll");
			test.log(Status.FAIL,
					"Failed to Click on DayOfWeekAll");
			Assert.assertFalse(false, 
					"DayOfWeekAll not Clicked");
		}

		
	}
	
	/**
	 * 
	 * 
	 * Note: This field will be disable if Charge Basis  is set to Room
	 * @param status
	 * @throws InterruptedException
	 */
	public void editTaxAppliesToChild(String status) throws InterruptedException{
		
		
	SeleniumRepo.waitForElementPresent(AppliesToChildren_Field);

	Assert.assertEquals(AppliesToChildren_Field.isDisplayed(), true, "Applies to Children Field is not being displayed");

	if (Click_AppliesToChildren_Enable.isEnabled()) {
	
	
	if (status.equalsIgnoreCase("enable")) {

		Click_AppliesToChildren_Enable.click();

		SeleniumRepo.WaitForLoad(100);

		System.out.println("Applies to Children is enabled successfully");
		logger.info("Applies to Children selected successfully");
		test.log(Status.PASS, "Applies to Children selected successfully");
		Assert.assertTrue(Click_AppliesToChildren_Enable.isSelected(), "Applies to Children is Enabled");

	} else {

		Click_AppliesToChildren_Disable.click();
		SeleniumRepo.WaitForLoad(100);

		System.out.println("Applies to Children is disable ");
		logger.info(" Select disable for Applies to Children");
		test.log(Status.PASS, "Select Disable  for Applies to Children");

		Assert.assertTrue(Click_AppliesToChildren_Disable.isSelected(), "Applies to Children is disable");

	}

	}else{
		
		
		System.out.println("Applies to Children is disable ");
		logger.info(" Select disable for Applies to Children");
		//test.log(Status.PASS, "Select Disable  for Applies to Children");
		
	}
		
		
	}
	
	
	public void editTaxDescription(String EnterTaxDes){
		
		
		SeleniumRepo.waitForElementPresent(TaxDescription_Field);

		Assert.assertEquals(TaxDescription_Field.isDisplayed(), true, "Tax Description text Field is not being displayed");

		Enter_TaxDescription_Text.click();
		Enter_TaxDescription_Text.clear();
		Enter_TaxDescription_Text.sendKeys(EnterTaxDes);

		System.out.println("Tax Description	is entered successfully");

		Assert.assertEquals(Enter_TaxDescription_Text.getAttribute("value"), EnterTaxDes,"Tax Description Field text was not entered");
		logger.info("Tax Description	 is entered successfully");
		test.log(Status.PASS, "Tax Description is entered successfully");

		
	}
	
	
	
	

	public void delete_Tax(String taxesOrFeesName) throws InterruptedException {
				
		  
		  for(int a = 0; a < allTaxesAndFeeLink.size(); a++ ){
		  
		  	if(allTaxesAndFeeLink.get(a).getText().equals(taxesOrFeesName) ) {
		  		//allTaxesAndFeeLink.get(a).click();
		  		
		  		all_TaxesAndFees_Delete_CheckBox.get(a).click();
				Thread.sleep(2000);

				Delete_Button.click();

		  		Delete_OK.click();
		  		
		  		
		  		Assert.assertNotEquals(allTaxesAndFeeLink.get(a).getText(), taxesOrFeesName);
		  		//Assert.assertEquals(SeleniumRepo.isElementDisplayed(ele), EnterTaxDes,"Tax Description Field text was not entered");
				logger.info("Tax " + taxesOrFeesName  + " was deleted successfully");
				test.log(Status.PASS, "Tax " + taxesOrFeesName  + " was deleted successfully");
		  		
		  		
		  	}
		  
		  }
	}
	
	


/**
 * 
 * @throws InterruptedException
 */
	public void delete_AllTaxes() throws InterruptedException
	{
				
		if(SeleniumRepo.isElementDisplayed(Verify_Property_Taxes) == false){
		click_TaxesAndFeesLink();
		SeleniumRepo.waitForPageLoaded();
		
		}
		
		System.out.println("Deleting all Taxes");
		test.log(Status.INFO, "Deleting all Taxes");
		
		ExplicitWait(Click_AddNewTaxToPropertyLinkText);
		//	if(ListTaxForm.size()>0);
		
		
		if(SeleniumRepo.isElementDisplayed(Click_TaxDelete_button) == true )
		{
			System.out.println("already tax created");

			for(WebElement del:all_TaxesAndFees_Delete_CheckBox)
			{
				Javascriptexecutor(del);
			}


			//Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[@value='Delete']")));
			Delete_Button.click();
			Thread.sleep(2000);
			Javascriptexecutor(Delete_OK);


			ExplicitWait(Click_AddNewTaxToPropertyLinkText);
		}

		else
		{
			System.out.println("No taxes To delete");
		}
		
		
		/*

		if(SeleniumRepo.driver.findElement(By.xpath("(//*[@name='taxIdsToDelete'])[1]")).isDisplayed())
		{
			System.out.println("already tax created");

			List<WebElement>delete=SeleniumRepo.driver.findElements(By.xpath("//*[@name='taxIdsToDelete']"));
			for(WebElement del:delete)
			{
				Javascriptexecutor(del);
			}


			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[@value='Delete']")));
			Thread.sleep(2000);
			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()='OK']")));


			ExplicitWait(Click_AddNewTaxToPropertyLinkText);
		}

		else
		{
			System.out.println("No taxes ");
		}
		
		
		
		*/
	}


	public void click_TaxesAndFeesLink() throws InterruptedException
	{
		//SeleniumRepo.waitForElementPresent(Click_TaxesFees);
		
		
		
		
		if( SeleniumRepo.isElementDisplayed(Click_TaxesFees) == false   ) 
		{
			
			System.out.println("PropertyManagement Menu is not expanded");
			Javascriptexecutor(property_Management); 
			SeleniumRepo.WaitForLoad(3000);
		
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");
			
			ExplicitWait(Click_TaxesFees);

			Javascriptexecutor(Click_TaxesFees);
			ExplicitWait(Verify_Property_Taxes);
			logger.info("Clicked on TaxesFees Link");
			test.log(Status.PASS,
					"Clicked on TaxesFees Link" );
			Assert.assertTrue(true, "Clicked on TaxesFees Link");
		}
		else
		{
			Thread.sleep(2000);
			Javascriptexecutor(Click_TaxesFees);
			ExplicitWait(Verify_Property_Taxes);
			logger.info("Clicked on TaxesFees Link");
			test.log(Status.PASS,
					"Clicked on TaxesFees Link" );
			Assert.assertTrue(true, "Clicked on TaxesFees Link");
			
			/*
			System.out.println(" TaxesFees is not found");
			logger.error("Failed to Click on TaxesFees Link");
			test.log(Status.FAIL,
					"Failed to Click on TaxesFees Link");
			Assert.assertFalse(false, 
					"TaxesFees Link not found");
			
			*/
		}

	}
		
	public void click_addtax()
	{
		ExplicitWait(Click_AddNewTaxToPropertyLinkText);
		if (Click_AddNewTaxToPropertyLinkText.isDisplayed()) 
		{
			Javascriptexecutor(Click_AddNewTaxToPropertyLinkText);
			logger.info("Clicked on TaxToProperty Link");
			test.log(Status.PASS,
					"Clicked on TaxToProperty Link" );
			Assert.assertTrue(true,
					"Clicked on TaxToProperty Link");}
		else {
			System.out.println(" TaxToProperty Link is not found");
			logger.error("Failed to Click on TaxToProperty Link");
			test.log(Status.FAIL,
					"Failed to Click on TaxToProperty Link");
			Assert.assertFalse(false, 
					"TaxToProperty Link not found");
		}
	}
	
	
	public void requiredFieldErrorCheck() {

		clickTaxesAndFeesSaveButton();
		
		SeleniumRepo.waitForPageLoaded();

		/*
		 
		 //li[contains(text(),'Please select at least one day of the week.')]
		     
		 */
		
		
		// After attempting to save a new guest preference question without any
		// required field filled out, the error messages appeared and the
		// the following if statements confirm the appearances of messages
		if (Check_ErrorTaxNameLabel.isDisplayed()) {
			System.out.println("Error Message Tax Name Required  is Displayed");
			test.log(Status.PASS, "Error Message Tax Name Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Tax Name Required  is Displayed ");
		} else {
			System.out.println("Error Message Tax Name Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Tax Name Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Tax Name Required  is Not Displayed");
		}

		if (Check_ErrorTaxCodeLabel.isDisplayed()) {
			System.out.println("Error Message Tax Code Required  is Displayed");
			test.log(Status.PASS, "Error Message Tax Code Required  is Displayed ");
			Assert.assertTrue(true, "Error Message Tax Code Required  is Displayed ");
		} else {
			System.out.println("Error Message Tax Code Required  is Not Displayed");
			test.log(Status.FAIL, " Error Message Tax Code Required  is Not Displayed");
			Assert.assertFalse(false, "Error Message Tax Code Required  is Not Displayed");
		}

		if (Check_ErrorTaxChargeFreqLabel.isDisplayed()) {
			System.out.println("Error Message Charge Frequency Required is Displayed");
			test.log(Status.PASS, "Error Message Charge Frequency Required is Displayed ");
			Assert.assertTrue(true, "Error Message Charge Frequency Required is Displayed ");
		} else {
			System.out.println("Error Message Charge Frequency Required is Not Displayed");
			test.log(Status.FAIL, " Error Message Charge Frequency Required is Not Displayed");
			Assert.assertFalse(false, "Error Message Charge Frequency Required is Not Displayed");
		}
		
		if (Check_ErrorTaxChargeBasisLabel.isDisplayed()) {
			System.out.println("Error Message Charge Basis  Required is Displayed");
			test.log(Status.PASS, "Error Message Charge Basis  Required is Displayed ");
			Assert.assertTrue(true, "Error Message Charge Basis  Required is Displayed ");
		} else {
			System.out.println("Error Message Charge Basis  Required is Not Displayed");
			test.log(Status.FAIL, " Error Message Charge Basis  Required is Not Displayed");
			Assert.assertFalse(false, "Error Message Charge Basis Required is Not Displayed");
		}
		
		if (Check_ErrorTaxChargeTypeLabel.isDisplayed()) {
			System.out.println("Error Message Charge Type  is Displayed");
			test.log(Status.PASS, "Error Message Charge Type  is Displayed ");
			Assert.assertTrue(true, "Error Message Charge Type  is Displayed ");
		} else {
			System.out.println("Error Message Charge Type  is Not Displayed");
			test.log(Status.FAIL, " Error Message Charge Type  is Not Displayed");
			Assert.assertFalse(false, "Error Message Charge Type  is Not Displayed");
		}
		
		if (Check_ErrorTaxChargeAmountLabel.isDisplayed()) {
			System.out.println("Error Message Charge Amount  is Displayed");
			test.log(Status.PASS, "Error Message Charge Amount  is Displayed ");
			Assert.assertTrue(true, "Error Message Charge Amount  is Displayed ");
		} else {
			System.out.println("Error Message Charge Amount  is Not Displayed");
			test.log(Status.FAIL, " Error Message Charge Amount  is Not Displayed");
			Assert.assertFalse(false, "Error Message Charge Amount  is Not Displayed");
		}
		
		if (Check_ErrorTaxSelectAdayLabel.isDisplayed()) {
			System.out.println("Error Message select at least one day of the week  is Displayed");
			test.log(Status.PASS, "Error Message select at least one day of the week is Displayed ");
			Assert.assertTrue(true, "Error Message select at least one day of the week  is Displayed ");
		} else {
			System.out.println("Error Message select at least one day of the week  is Not Displayed");
			test.log(Status.FAIL, " Error Message select at least one day of the week  is Not Displayed");
			Assert.assertFalse(false, "Error Message select at least one day of the week is Not Displayed");
		}

	}
	
	
	public void clickTaxesAndFeesSaveButton() {
		// TODO Auto-generated method stub
		
		SeleniumRepo.waitForElementPresent(Click_SaveButton);
		
		try {
			Click_SaveButton.click();
			Thread.sleep(2000);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Saved");
			logger.info("Clicked on Save button");
			test.log(Status.PASS,
					"Clicked on Save button" );
		} catch (Exception e) {
			System.out.println("Not Saved");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");
			e.printStackTrace();
		}
		
		
		
	}




	public void tax(String Tax_Name, String Tax_Code, 
			String Charge_Frequency, String Charge_Basis, 
			String Charge_Type, String Charge_Amount ) throws InterruptedException
	{
		ExplicitWait(Enter_Tax_Name);
		if (Enter_Tax_Name.isDisplayed()) 
		{
			Enter_Tax_Name.click();
			Enter_Tax_Name.clear();
			Enter_Tax_Name.sendKeys(Tax_Name+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			System.out.println(" Tax_Name is entered successfully");
			logger.info("Tax_Name is entered successfully");
			test.log(Status.PASS,
					"Tax_Name is entered successfully" );
			Assert.assertTrue(true,
					"Tax_Name is entered successfully");
		} else {
			System.out.println("Tax_Name TextBox not found");
			logger.error("Failed to Enter Tax_Name in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Tax_Name in TextBox");
			Assert.assertFalse(false, 
					"Tax_Name TextBox not found");
		}

		if (Enter_Tax_Code.isDisplayed())
		{
			Enter_Tax_Code.click();
			Enter_Tax_Code.clear();
			Enter_Tax_Code.sendKeys(Tax_Code+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			System.out.println(" Tax_Code is entered successfully");
			logger.info("Tax_Code is entered successfully");
			test.log(Status.PASS,
					"Tax_Code is entered successfully" );
			Assert.assertTrue(true,
					"Tax_Code is entered successfully");
		} else {
			System.out.println("Tax_Code TextBox not found");
			logger.error("Failed to Enter Tax_Code in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Tax_Code in TextBox");
			Assert.assertFalse(false, 
					"Tax_Code TextBox not found");
		}

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Frequency,Charge_Frequency);
			System.out.println("Charge Frequency is Selected succesfully");
			logger.info("Charge Frequency is Selected succesfully");
			test.log(Status.PASS,
					"Charge Frequency is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge Frequency is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge Frequency is not Selected");
			logger.error("Failed to Select Charge Frequency");
			test.log(Status.FAIL,
					"Failed to Select Charge Frequency");
			Assert.assertFalse(false, 
					"Failed to Select Charge Frequency");
			e.printStackTrace();
		}


		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Basis,Charge_Basis);
			System.out.println("Charge_Basisis Selected succesfully");
			logger.info("Charge_Basis is Selected succesfully");
			test.log(Status.PASS,
					"Charge_Basis is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge_Basis is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge_Basis is not Selected");
			logger.error("Failed to Select Charge Basis");
			test.log(Status.FAIL,
					"Failed to Select Charge Basis");
			Assert.assertFalse(false, 
					"Failed to Select Charge Basis");
			e.printStackTrace();
		}

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Type,Charge_Type);
			System.out.println("Charge_Type is Selected succesfully");
			logger.info("Charge_Type is Selected succesfully");
			test.log(Status.PASS,
					"Charge_Type is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge_Type is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge_Type is not Selected");
			logger.error("Failed to Select Charge Type");
			test.log(Status.FAIL,
					"Failed to Select Charge Type");
			Assert.assertFalse(false, 
					"Failed to Select Charge Type");
			e.printStackTrace();
		}
		if (Enter_Charge_Amount.isDisplayed()) 
		{
			Enter_Charge_Amount.click();
			Enter_Charge_Amount.clear();
			Enter_Charge_Amount.sendKeys(Charge_Amount);
			System.out.println(" Charge_Amount is entered successfully");
			logger.info("Charge_Amount is entered successfully");
			test.log(Status.PASS,
					"Charge_Amount is entered successfully" );
			Assert.assertTrue(true,
					"Charge_Amount is entered successfully");
		} else {
			System.out.println("Charge_Amount TextBox not found");
			logger.error("Failed to Enter Charge_Amount in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Charge_Amount in TextBox");
			Assert.assertFalse(false, 
					"Charge_AmountTextBox not found");
		}


		if (DayOfWeekAll.isDisplayed()) 
		{
			if (DayOfWeekAll.isSelected() == false)
				DayOfWeekAll.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println("DayOfWeekAll is Clicked successfully");
			logger.info("Clicked on DayOfWeekAll");
			test.log(Status.PASS,
					"Clicked on DayOfWeekAll" );
			Assert.assertTrue(true,
					"DayOfWeekAll is Clicked successfully");
		} else {
			System.out.println("DayOfWeekAll not Clicked");
			logger.error("Failed to Click on DayOfWeekAll");
			test.log(Status.FAIL,
					"Failed to Click on DayOfWeekAll");
			Assert.assertFalse(false, 
					"DayOfWeekAll not Clicked");
		}


		try {
			Click_SaveButton.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Saved");
			logger.info("Clicked on Save button");
			test.log(Status.PASS,
					"Clicked on Save button" );
		} catch (Exception e) {
			System.out.println("Not Saved");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");
			e.printStackTrace();
		}
	}

	public  void  createTaxFees
	(String Property_Taxes_Title, String Tax_Name, String Tax_Code, 
			String Charge_Frequency, String Charge_Basis, 
			String Charge_Type, String Charge_Amount ) throws Exception 
	{
		try 
		{
			
			
			if (Click_TaxesFees.isDisplayed()) 
			{
				Javascriptexecutor(Click_TaxesFees);
				ExplicitWait(Click_AddNewTaxToPropertyLinkText);
				System.out.println("PropertyManagement element Expanded and TaxesFees element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and TaxesFees element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and TaxesFees element  found");
			} 
			else 
			{
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(Click_TaxesFees);
				if(Click_TaxesFees.isDisplayed())
				{
					Javascriptexecutor(Click_TaxesFees);
					SeleniumRepo.waitForPageLoaded();
					ExplicitWait(Click_AddNewTaxToPropertyLinkText);
					System.out.println("TaxesFees element found");
					test.log(Status.INFO, "TaxesFees element found");
					Assert.assertTrue(true, "TaxesFees element found");
				}
				else
				{
					logger.info("TaxesFees element not  found");
					test.log(Status.FAIL, "TaxesFees element not  found");
				}
			}
			
			
			Thread.sleep(4000);
			if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains(Tax_Name))
			{
				System.out.println("Tax "+Tax_Name+" already created and going to delete");
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+Tax_Name+"')]/../preceding-sibling::td/input")));
			     Thread.sleep(2000);

					Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[@value='Delete']")));
					Thread.sleep(2000);
					Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()='OK']")));	     
			}
			else
			{
				System.out.println("tax "+Tax_Name+" not yet created");
			}
			
			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Tax to Property')]")));
			
			if (SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Tax to Property')]")).isDisplayed()) 
			{
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Tax to Property')]")));
				SeleniumRepo.waitForPageLoaded();
				logger.info("Clicked on TaxToProperty Link");
				test.log(Status.PASS,
						"Clicked on TaxToProperty Link" );
				Assert.assertTrue(true,
						"Clicked on TaxToProperty Link");}
			else {
				System.out.println(" TaxToProperty Link is not found");
				logger.error("Failed to Click on TaxToProperty Link");
				test.log(Status.FAIL,
						"Failed to Click on TaxToProperty Link");
				Assert.assertFalse(false, 
						"TaxToProperty Link not found");
			}

			ExplicitWait(Enter_Tax_Name);
			if (Enter_Tax_Name.isDisplayed()) 
			{
				Enter_Tax_Name.click();
				Enter_Tax_Name.clear();
				Enter_Tax_Name.sendKeys(Tax_Name+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				System.out.println(" Tax_Name is entered successfully");
				logger.info("Tax_Name is entered successfully");
				test.log(Status.PASS,
						"Tax_Name is entered successfully" );
				Assert.assertTrue(true,
						"Tax_Name is entered successfully");
			} else {
				System.out.println("Tax_Name TextBox not found");
				logger.error("Failed to Enter Tax_Name in TextBox");
				test.log(Status.FAIL,
						"Failed to Enter Tax_Name in TextBox");
				Assert.assertFalse(false, 
						"Tax_Name TextBox not found");
			}

			if (Enter_Tax_Code.isDisplayed())
			{
				Enter_Tax_Code.click();
				Enter_Tax_Code.clear();
				Enter_Tax_Code.sendKeys(Tax_Code+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				System.out.println(" Tax_Code is entered successfully");
				logger.info("Tax_Code is entered successfully");
				test.log(Status.PASS,
						"Tax_Code is entered successfully" );
				Assert.assertTrue(true,
						"Tax_Code is entered successfully");
			} else {
				System.out.println("Tax_Code TextBox not found");
				logger.error("Failed to Enter Tax_Code in TextBox");
				test.log(Status.FAIL,
						"Failed to Enter Tax_Code in TextBox");
				Assert.assertFalse(false, 
						"Tax_Code TextBox not found");
			}

			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Frequency,Charge_Frequency);
				System.out.println("Charge Frequency is Selected succesfully");
				logger.info("Charge Frequency is Selected succesfully");
				test.log(Status.PASS,
						"Charge Frequency is Selected succesfully" );
				Assert.assertTrue(true,
						"Charge Frequency is Selected succesfully");
			} catch (Exception e) {
				System.out.println("Charge Frequency is not Selected");
				logger.error("Failed to Select Charge Frequency");
				test.log(Status.FAIL,
						"Failed to Select Charge Frequency");
				Assert.assertFalse(false, 
						"Failed to Select Charge Frequency");
				e.printStackTrace();
			}


			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Basis,Charge_Basis);
				System.out.println("Charge_Basisis Selected succesfully");
				logger.info("Charge_Basis is Selected succesfully");
				test.log(Status.PASS,
						"Charge_Basis is Selected succesfully" );
				Assert.assertTrue(true,
						"Charge_Basis is Selected succesfully");
			} catch (Exception e) {
				System.out.println("Charge_Basis is not Selected");
				logger.error("Failed to Select Charge Basis");
				test.log(Status.FAIL,
						"Failed to Select Charge Basis");
				Assert.assertFalse(false, 
						"Failed to Select Charge Basis");
				e.printStackTrace();
			}

			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Type,Charge_Type);
				System.out.println("Charge_Type is Selected succesfully");
				logger.info("Charge_Type is Selected succesfully");
				test.log(Status.PASS,
						"Charge_Type is Selected succesfully" );
				Assert.assertTrue(true,
						"Charge_Type is Selected succesfully");
			} catch (Exception e) {
				System.out.println("Charge_Type is not Selected");
				logger.error("Failed to Select Charge Type");
				test.log(Status.FAIL,
						"Failed to Select Charge Type");
				Assert.assertFalse(false, 
						"Failed to Select Charge Type");
				e.printStackTrace();
			}
			
			if (Enter_Charge_Amount.isDisplayed()) 
			{
				Enter_Charge_Amount.click();
				Enter_Charge_Amount.clear();
				Enter_Charge_Amount.sendKeys(Charge_Amount);
				System.out.println(" Charge_Amount is entered successfully");
				logger.info("Charge_Amount is entered successfully");
				test.log(Status.PASS,
						"Charge_Amount is entered successfully" );
				Assert.assertTrue(true,
						"Charge_Amount is entered successfully");
			} else {
				System.out.println("Charge_Amount TextBox not found");
				logger.error("Failed to Enter Charge_Amount in TextBox");
				test.log(Status.FAIL,
						"Failed to Enter Charge_Amount in TextBox");
				Assert.assertFalse(false, 
						"Charge_AmountTextBox not found");
			}


			if (DayOfWeekAll.isDisplayed()) 
			{
				if (DayOfWeekAll.isSelected() == false)
					DayOfWeekAll.click();
				SeleniumRepo.WaitForLoad(100);
				System.out.println("DayOfWeekAll is Clicked successfully");
				logger.info("Clicked on DayOfWeekAll");
				test.log(Status.PASS,
						"Clicked on DayOfWeekAll" );
				Assert.assertTrue(true,
						"DayOfWeekAll is Clicked successfully");
			} else {
				System.out.println("DayOfWeekAll not Clicked");
				logger.error("Failed to Click on DayOfWeekAll");
				test.log(Status.FAIL,
						"Failed to Click on DayOfWeekAll");
				Assert.assertFalse(false, 
						"DayOfWeekAll not Clicked");
			}


			try {
				Click_SaveButton.click();
				SeleniumRepo.waitForPageLoaded();
				System.out.println("Saved");
				logger.info("Clicked on Save button");
				test.log(Status.PASS,
						"Clicked on Save button" );
			} catch (Exception e) {
				System.out.println("Not Saved");
				logger.error("Failed to Click on Save button");
				test.log(Status.FAIL,
						"Failed to Click on Save button");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.error("Unable to create Taxes And Fees for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Taxes And Fees for selected property because of this execption" + e);
			e.printStackTrace();
		}
	}
}
