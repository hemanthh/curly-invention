package com.tt.admin.pom;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class Delete_AboutNearAttraction extends BaseTest{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	 String result=this.getClass().getSimpleName();
	 
	 @FindAll({
	        @FindBy(xpath="//a[starts-with(., 'About')]"),
	            })
		
	    private WebElement AbouttheProperty_Link;
	 
	 @FindAll({ @FindBy(xpath = "//input[@name='chkAttractionIds']"),

		})
		private List<WebElement> Check_chkAttractionIds;
	
	 
		@FindAll({ @FindBy(xpath = "//input[@value='Delete']"),

		})
		private WebElement Delete_Policy;
		
		
		
	 public void deleteAboutNearAttractoion(String NBA_Name) {
	 	  
		 try {

			 if (SeleniumRepo.isElementPresent(AbouttheProperty_Link))
				{
					boolean b=AbouttheProperty_Link.isEnabled();
					if(b)
					AbouttheProperty_Link.click();
					logger.info("Clicked on AbouttheProperty Link");
					test.log(Status.PASS,
							     "Clicked on AbouttheProperty Link" );
					Assert.assertTrue(true, "Clicked on AbouttheProperty Link");
				} else {
					System.out.println("AbouttheProperty Link not found");
					logger.error("Failed to Click on AbouttheProperty Link");
					test.log(Status.FAIL,
					                     "Failed to Click on AbouttheProperty Link");
					Assert.assertFalse(false, "AbouttheProperty Link not found");
					}
			 
			 int length = Check_chkAttractionIds.size();
				System.out.println(length);
				try {
					for (int i=0;i<length;i++) {
						            
			if(SeleniumRepo.driver.findElements(By.xpath("//*[text()[contains(.,'"+NBA_Name+"')]]/preceding-sibling::td[1]//input[1]")).size()>0) {
						
				WebElement policy=SeleniumRepo.driver.findElement(By.xpath("//*[text()[contains(.,'"+NBA_Name+"')]]/preceding-sibling::td[1]//input[1]"));
				
				System.out.println(policy);
				    policy.click();
				    Delete_Policy.click();
				    SeleniumRepo.handleAlert();
					System.out.println("Policy Deleted"+NBA_Name);
					          }else {
						 System.out.println("No Element found");
					}
					}
				} catch (Exception e) {
					logger.error("Unable to  Delete Near Attraction for selected property because of this execption" + e);
					test.log(Status.ERROR, "Unable to Delete Near Attraction for selected property because of this execption" + e);
					e.printStackTrace();
				}
			 
			
			 
		 } catch (Exception e) {
			    logger.error("Unable to Delete  Near Attraction for selected property because of this execption" + e);
				test.log(Status.ERROR, "Unable to Delete  Near Attraction for selected property because of this execption" + e);
				e.printStackTrace();
			}	
	 
	 
	 
}}
