package com.tt.admin.pom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class Manage_FBP extends BaseTest
{
	SimpleDateFormat df1 ;
	String formula;
	String todayDate;

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Manage Formula Based Pricing')]") public WebElement Click_ManageFBP;
	@FindBy(how=How.XPATH,using="//*[@name='selectedRatePlanName']") public WebElement Enter_Rateplan;
	@FindBy(how=How.XPATH,using="//*[@value='Go']") public WebElement Click_Go;
	@FindBy(how=How.XPATH,using="//*[text()='Add']") public WebElement Click_ADD;
	@FindBy(how=How.XPATH,using="(//*[@id='selectAll'])[1]") public WebElement Select_Alldays;
	@FindBy(how=How.XPATH,using="//*[text()='Flat Amount']/preceding-sibling::td[1]/input") public WebElement FlatAmount;
	@FindBy(how=How.XPATH,using="//*[text()='Percentage']/preceding-sibling::td[1]/input") public WebElement Percentage;
	@FindBy(how=How.XPATH,using="//*[@id='amount']") public WebElement Amount;
	@FindBy(how=How.XPATH,using="//*[@name='associatedFloatsOffWithRatePlan']") public WebElement Float_off;
	@FindBy(how=How.XPATH,using="(//td[text()='All']/preceding-sibling::td/input)[2]") public WebElement Rooms;
	@FindBy(how=How.XPATH,using="(//*[@name='floor'])[1]") public WebElement Floor_amount;
	@FindBy(how=How.XPATH,using="(//*[@name='ceiling'])[1]") public WebElement Ceiling_Amount;
	@FindBy(how=How.XPATH,using="//*[@id='dateFrom']/../following-sibling::td/a") public WebElement From_Date;
	@FindBy(how=How.XPATH,using="//*[@id='dateTo']/../following-sibling::td/a") public WebElement To_Date;
	@FindAll({ @FindBy(xpath = "//*[@class='ui-corner-all']"),})public WebElement Select_RatePlan;
	@FindBy(how=How.XPATH,using="//*[text()='Add']") public WebElement Add;
	@FindBy(how=How.XPATH,using="(//*[starts-with(@id,'formula_')])[1]") public WebElement Verify_formula;
	@FindBy(how=How.XPATH,using="//*[text()='Delete']") public WebElement Formula_delete;
	@FindBy(how=How.XPATH,using="//*[text()='OK']") public WebElement Click_DeleteOK;

	public void Click_ManageFBP()
	{
		ExplicitWait(Click_ManageFBP);
		if (Click_ManageFBP.isDisplayed()) 
		{
			Javascriptexecutor(Click_ManageFBP);
			test.log(Status.PASS, "FBP Enabled  and Manage Formula Based Pricing displayed Successfully under the Rate plans and clicked ");
			logger.info("FBP Enabled  and Manage Formula Based Pricing displayed Successfully under the Rate plans and clicked ");
			Assert.assertTrue(true, "FBP Enabled  and Manage Formula Based Pricing displayed Successfully under the Rate plans and clicked ");
		}
		else 
		{

			logger.info(" Manage Formula Based Pricing link not found");
			test.log(Status.PASS, "Manage Formula Based Pricing link not found");
			Assert.assertFalse(false, "Manage Formula Based Pricing link not found");
		}
	}

	public void Enter_Rateplan(String Rateplan) throws InterruptedException
	{
		ExplicitWait(Enter_Rateplan);
		if (Enter_Rateplan.isDisplayed()) 
		{
			Enter_Rateplan.sendKeys(Rateplan);
			Thread.sleep(2000);
			//Javascriptexecutor(Click_Go);
			test.log(Status.PASS, "Rateplan "+Rateplan+ " enterd successfully");
			logger.info("Rateplan "+Rateplan+ " enterd successfully");
			Assert.assertTrue(true, "Rateplan "+Rateplan+ " enterd successfully");
		}
		else 
		{

			logger.info(" Rate plans search field not found");
			test.log(Status.PASS, "Rate plans search field not found");
			Assert.assertFalse(false, "Rate plans search field not found");
		}
	}


	public void Select_Rateplan()
	{
		ExplicitWait(Select_RatePlan);
		if (Select_RatePlan.isDisplayed()) 
		{
			Select_RatePlan.click();
			test.log(Status.PASS, "Clicked on Select_RatePlan");
			logger.info("Clicked on Select_RatePlan");
			
		} else 
		{
			logger.error("Failed to Click on Select_RatePlan");
			test.log(Status.FAIL, "Failed to Click on Select_RatePlan");
		}
		ExplicitWait(Click_Go);
		if (SeleniumRepo.isElementPresent(Click_Go)) 
		{
			Javascriptexecutor(Click_Go);
			test.log(Status.PASS, "Clicked on GO link");
			logger.info("Clicked on GO link");
			
		} else 
		{
			logger.error("Failed to Click on Manage Acces Code link");
			test.log(Status.FAIL, "Failed to Click on Manage Acces Codes link");
		}

	}


	public void FromDate() throws ParseException
	{
		ExplicitWait(From_Date);
		if(From_Date.isDisplayed())
		{
			Javascriptexecutor(From_Date);
			System.out.println("From Date clicked successfully");
			Date date1 = new Date();
			date1.setDate(date1.getDate());
			SimpleDateFormat df1 = new SimpleDateFormat("d");
			todayDate = df1.format(date1);

			System.out.println("//*[text()='"+todayDate+"'][2]");
			try
			{
				
			WebElement Fromdate=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+todayDate+"'][2]"));
			System.out.println("From date is displayed at try level");
			Fromdate.click();
			//Javascriptexecutor(Fromdate);
			System.out.println("Fromdate selected is :"+todayDate);
			
			}
			catch(Exception e)
			{
				System.out.println("From date is displayed at catch level");
				WebElement Fromdate=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+todayDate+"'][1]"));
				Fromdate.click();
				System.out.println("Fromdate selected is :"+todayDate);
			}

		}
		else
		{
			System.out.println("From date calendar is not found");
		}
	}
	public void Todate() throws InterruptedException
	{
		ExplicitWait(To_Date);
		if(To_Date.isDisplayed())
		{
			Javascriptexecutor(To_Date);
			System.out.println("To Date clicked successfully");
			Date date = new Date();
			date.setDate(date.getDate() + 7);
			SimpleDateFormat df = new SimpleDateFormat("d");
			String Enddate = df.format(date);
			df = new SimpleDateFormat("MMMM");
			String Month = df.format(date);

			System.out.println("Month is "+Month);

			String Pre_month_year=SeleniumRepo.driver.findElement(By.xpath("//*[@class='caltitle']")).getText();
			String pre_month  = Pre_month_year.substring( 0, Pre_month_year.indexOf(","));
			System.out.println("premonth is "+pre_month);
			if(Month.equalsIgnoreCase(pre_month))
			{
				System.out.println("Todate month should select "+pre_month);
				WebElement Todate=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+Enddate+"']"));
				Todate.click();
				System.out.println("Todate selected is :"+Enddate);
			}
			else
			{
				System.out.println("Todate month should select "+Month);
				WebElement Click_Nextmonth=SeleniumRepo.driver.findElement(By.xpath("//*[text()='Today']/following-sibling::td"));
				Click_Nextmonth.click();
				Thread.sleep(3000);
				System.out.println("//*[text()='"+Enddate+"']");
				List<WebElement> Todate=SeleniumRepo.driver.findElements(By.xpath("//*[text()='"+Enddate+"']"));
				for(int i=0;i<=Todate.size()-1;i++)
				{
					String daytext=Todate.get(i).getAttribute("class");
					if(!(daytext.equals("emptycell")))
					{
						Todate.get(i).click();
					}

				}
				System.out.println("Todate selected is :"+Enddate);

			}
		}
		else
		{
			System.out.println("To date calendar is not found");

		}
	}

	public void Day_of_week(String Day)
	{
		ExplicitWait(Select_Alldays);
		WebElement day=SeleniumRepo.driver.findElement(By.xpath("(//td[text()='"+Day+"']/preceding-sibling::td/input)[1]"));
		if (day.isDisplayed()) 
		{
			Javascriptexecutor(day);
			test.log(Status.INFO, "Day of week is : "+Day+ " enterd successfully");
			logger.info("Day of week is : "+Day+ " enterd successfully");
			
		}
		else 
		{

			logger.error(" Day of week field not found");
			test.log(Status.FAIL, "Day of week field not found");
			Assert.assertFalse(false, "Day of week field not found");
		}

	}

	public void Adj_type_FlatAmount()
	{
		ExplicitWait(FlatAmount);
		//WebElement Adjtype=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+Adj_type+"']/preceding-sibling::td[1]/input"));
		if(!(FlatAmount.isSelected()))
		{
			Javascriptexecutor(FlatAmount);
			System.out.println("Adjtype FlatAmount is selected successfully");
			test.log(Status.PASS, "Adjtype FlatAmount is selected successfully");
			logger.info("Adjtype FlatAmount is selected successfully");
			
		}
		else 
		{
			System.out.println("Adj_type Flat Amount field not found");
			logger.error("Adj_type Flat Amount  field not found");
			test.log(Status.FAIL, "Adj_type Flat Amount  field not found");
			
		}
	}

	public void Adj_type_Percentage()
	{
		ExplicitWait(Percentage);
		//WebElement Adjtype=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+Adj_type+"']/preceding-sibling::td[1]/input"));
		if(!(Percentage.isSelected()))
		{
			Javascriptexecutor(Percentage);
			System.out.println("Adjtype Percentage is selected successfully");
			test.log(Status.PASS, "Adjtype Percentage is selected successfully");
			logger.info("Adjtype Percentage is selected successfully");
			Assert.assertTrue(true, "Adjtype Percentage is selected successfully");
		}
		else 
		{
			System.out.println("Adj_type Percentage field not found");
			logger.info("Adj_type Percentage  field not found");
			test.log(Status.PASS, "Adj_type Percentage  field not found");
			Assert.assertFalse(false, "Adj_type Percentage  field not found");
		}
	}


	public void Amount(String amount)
	{
		ExplicitWait(Amount);
		if(Amount.isDisplayed())
		{
			Amount.sendKeys(amount);
			System.out.println("amount is" +amount+" enterd successfully");
			test.log(Status.PASS, "amount is" +amount+" enterd successfully");
			logger.info("amount is" +amount+" enterd successfully");
			
		}
		else 
		{
			System.out.println("Amount field not found");
			logger.error("Amount field not found");
			test.log(Status.FAIL, "Amount field not found");
			
		}
	}
	public void verify_Flatoff(String rateplan)
	{
		ExplicitWait(Float_off);
		if(Float_off.isDisplayed())
		{
			String value= Float_off.getAttribute("value");
			if(value.equalsIgnoreCase(rateplan))
			{
				System.out.println("Float off of: "+rateplan +" replicated successfully");
				test.log(Status.PASS, "Float off of: "+rateplan +" replicated successfully");
				logger.info("Float off of: "+rateplan +" replicated successfully");
				
			}
			else
			{
				System.out.println("Float off of: "+rateplan +" not replicated");
				logger.error("Float off of: "+rateplan +" not replicated");
				test.log(Status.FAIL, "Float off of: "+rateplan +" not replicated");
				
			}
		}
		else 
		{
			System.out.println("Float_off field not found");
			logger.error("Float_off field not found");
			test.log(Status.FAIL, "Float_off field not found");
		
		}

	}
	public void Rooms()
	{
		ExplicitWait(Rooms);
		if(Rooms.isSelected())
		{

			System.out.println("All rooms selected successfully");
			test.log(Status.PASS, "All rooms selected successfully");
			logger.info("All rooms selected successfully");
			
		}
		else
		{
			Javascriptexecutor(Rooms);
			System.out.println("All Rooms field not found");
			logger.error("All Rooms field not found");
			test.log(Status.FAIL, "All Rooms field not found");
			
		}
	}
	public void Floor(String FloorAmount) throws InterruptedException
	{
		ExplicitWait(Floor_amount);
		if(Floor_amount.isDisplayed())
		{
			Floor_amount.sendKeys(FloorAmount);
			Thread.sleep(2000);
			SeleniumRepo.driver.findElement(By.xpath("(//*[text()='Copy All-']/following-sibling::img)[1]")).click();
			System.out.println("FloorAmount is :"+FloorAmount);
			test.log(Status.PASS, "FloorAmount is :"+FloorAmount);
			logger.info("FloorAmount is :"+FloorAmount);
		
		}
		else
		{
			System.out.println("FloorAmount field not found");
			logger.error("FloorAmount field not found");
			test.log(Status.FAIL, "FloorAmount field not found");
			
		}
	}
	public void Cieling(String CielingAmount) throws InterruptedException
	{
		ExplicitWait(Ceiling_Amount);
		if(Ceiling_Amount.isDisplayed())
		{
			Ceiling_Amount.sendKeys(CielingAmount);
			Thread.sleep(2000);
			SeleniumRepo.driver.findElement(By.xpath("(//*[text()='Copy All-']/following-sibling::img)[2]")).click();
			System.out.println("CielingAmount is :"+CielingAmount);
			test.log(Status.PASS, "CielingAmount is :"+CielingAmount);
			logger.info("CielingAmount is :"+CielingAmount);
			
		}
		else
		{
			System.out.println("CielingAmount field not found");
			logger.error("CielingAmount field not found");
			test.log(Status.FAIL, "CielingAmount field not found");
		
		}
	}

	public void add()
	{
		ExplicitWait(Add);
		if(Add.isDisplayed())
		{
			Javascriptexecutor(Add);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Clicked on Add link successfully");
			test.log(Status.PASS, "Clicked on Add link successfully");
			logger.info("Clicked on Add link successfully");
			
		}
		else
		{
			System.out.println("Add field not found");
			logger.error("Add field not found");
			test.log(Status.FAIL, "Add field not found");
			
		}
	}

	public void Verify_FBPRate_FlatAmount(String ParentRateplanRate,String Childrateplan_AfterManageFBPRate,String FBPAmount,String formula)
	{

		if(formula.contains("Subtract"))
		{
			System.out.println("Discount will be applicable for the rateplan");
			int ParentRateplanRate_int = Integer.parseInt(ParentRateplanRate);		
			int FBPAmount_int=Integer.parseInt(FBPAmount);
			int result=ParentRateplanRate_int+FBPAmount_int;
			String result_string = Integer.toString(result);

			System.out.println("Room is getting discount with "+result_string);
			if(result_string.equals(Childrateplan_AfterManageFBPRate))
			{
				System.out.println("FBP formula applied Amount is : " +FBPAmount);

				System.out.println("result is: "+result);

				System.out.println(result +" FBP Applied successfully");	
				test.log(Status.PASS, result +" FBP Applied successfully");
				
			}
		}
		else if(formula.contains("Add"))
		{
			System.out.println("amount will be add to the rateplan");
			int ParentRateplanRate_int = Integer.parseInt(ParentRateplanRate);	
			int FBPAmount_int=Integer.parseInt(FBPAmount);

			int result=ParentRateplanRate_int+FBPAmount_int;
			String result_string = Integer.toString(result);

			System.out.println(result_string+"Amount will be added to the rateplan ");
			if(result_string.equals(Childrateplan_AfterManageFBPRate))
			{
				System.out.println("FBP formula applied Amount is : " +FBPAmount);

				System.out.println("result is: "+result);

				System.out.println(result +" FBP Applied successfully");	
				test.log(Status.INFO, result +" FBP Applied successfully");
				
			}
		}
	}


	public String verify_formula(String rateplan) throws InterruptedException
	{
		ExplicitWait(Click_ADD);
        Thread.sleep(5000);
		Date date = new Date();
		date.setDate(date.getDate());
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YY");
		String DMY = df.format(date);


		WebElement Verify_formula=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+DMY+"']/following-sibling::td[3]"));
		ExplicitWait(Verify_formula);
		if(Verify_formula.isDisplayed())
		{
			formula=Verify_formula.getText();
			System.out.println("**********Formula applied for the rate plan :"+rateplan +" is "+formula);
			test.log(Status.INFO, "********Formula applied for the rate plan :"+rateplan +" is "+formula);
			
		}
		else
		{
			System.out.println("Formula is not applied");
		}
		return formula;
	}

	public void verify_FBPRate_Percentage(String ParentRateplanRate, String Childrateplan_AfterManageFBPRate, String percentage,String formula) 
	{
		if(formula.contains("Subtract"))
		{
			System.out.println("Discount will be applicable for the rateplan");
			int ParentRateplanRate_int = Integer.parseInt(ParentRateplanRate);	
			int percentage_int=Integer.parseInt(percentage);

			int discountrate=((percentage_int*ParentRateplanRate_int)/100);

			int newrate=(ParentRateplanRate_int-discountrate);

			String newrate_string=Integer.toString(newrate);
			if(newrate_string.equals(Childrateplan_AfterManageFBPRate))
			{
				System.out.println("FBP formula "+formula+" applied successfully");
			}
			else
			{
				System.out.println("Formula is not applied");
			}
		}
		else if(formula.contains("Add"))
		{
			System.out.println("amount will be add to the rateplan");
			int ParentRateplanRate_int = Integer.parseInt(ParentRateplanRate);	
			int percentage_int=Integer.parseInt(percentage);

			int discountrate=((percentage_int*ParentRateplanRate_int)/100);

			int newrate=(ParentRateplanRate_int+discountrate);

			String newrate_string=Integer.toString(newrate);

			if(newrate_string.equals(Childrateplan_AfterManageFBPRate))
			{
				System.out.println("FBP formula "+formula+" applied successfully");
			}
			else
			{
				System.out.println("Formula is not applied");
			}
		}

	}

	public void verify_overlappdates()
	{
		String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
		String expectedwarning="DOW or RoomTypes overlapping is not allowed with overlapping Date Range.";
		if(body.contains(expectedwarning))
		{
			System.out.println("Dates ar overlapping with the already existing dates an showing warning message as DOW or RoomTypes overlapping is not allowed with overlapping Date Range.");
			test.log(Status.PASS, "Dates ar overlapping with the already existing dates an showing warning message as DOW or RoomTypes overlapping is not allowed with overlapping Date Range.");
			logger.info("Dates ar overlapping with the already existing dates an showing warning message as DOW or RoomTypes overlapping is not allowed with overlapping Date Range.");
		}
		else
		{  
			System.out.println("Dates are not overlapped");

		}
	}

	public void delete() throws InterruptedException
	{
		Thread.sleep(2000);
		ExplicitWait(Formula_delete);
		if(Formula_delete.isDisplayed())
		{
			Javascriptexecutor(Formula_delete);
			Thread.sleep(2000);
			Javascriptexecutor(Click_DeleteOK);
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Deleted the formula successfully");
			logger.info("Deleted the formula successfully");
			test.log(Status.PASS, "Deleted the formula successfully");	
		}
		else
		{
			System.out.println("Delete element not found");
		}
	}


	public void Setof_days(String daysArray)
	{
		String[] array=daysArray.split(",");
		for(int i=0;i<=array.length-1;i++)
		{
			String day=array[i];
			WebElement select_day=SeleniumRepo.driver.findElement(By.xpath("(//*[text()='"+day+"'])[1]/preceding-sibling::td/input"));
			
			Javascriptexecutor(select_day);
			
			System.out.println(day+"day selectd successfully");
		}
	}

	public void verify_thresholdvalue(String ParentRateplanRate,String Threasholdvalue,String formula,String flatamount,String Rateafter_thresholdvalue)
	{

		System.out.println("Discount will be applicable for the rateplan");
		int ParentRateplanRate_int = Integer.parseInt(ParentRateplanRate);
		
		System.out.println("enterd");
		
		int Threasholdvalue_int = Integer.parseInt(Threasholdvalue);
		
		System.out.println("Threasholdvalue_int "+Threasholdvalue_int);

		int flatamount_int=Integer.parseInt(flatamount);

		int finalrate=ParentRateplanRate_int+flatamount_int;

		if(finalrate>Threasholdvalue_int)
		{
			System.out.println("Room Rate reaches the  Cieling amount "+Threasholdvalue_int);
			if(Rateafter_thresholdvalue.equals(Threasholdvalue))
			{
				System.out.println("Celing Amount reflected in the Rate Grid when the  Room Rate reaches the  value");
			}
			
		}
		else
		{
			System.out.println("Room Rate should display final rate "+finalrate);
		}

		
	}
}