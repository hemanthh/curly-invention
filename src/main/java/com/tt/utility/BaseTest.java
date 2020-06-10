package com.tt.utility;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tt.admin.pom.BrandSelection;
import com.tt.admin.pom.Login;
import com.tt.admin.pom.SelectProperty;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseTest {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static  ExtentTest test;
	Logger log=Logger.getLogger(BaseTest.class);
	//private ScreenRecorder screenRecorder;
//	String RecordingClassName;
	//String RecordingMethodName;
	//String fileRecordingLocation;
	String logFileDeleteing;
	String SucessFileDeleteing;

	public String ParentWindow;
	public String NewWindow;
	File RecordedFile;
	File LogFile;
	File SucessFile;
	public static int status;
	ExtentTest logger;
	static String Presentdate;



	public int MaxIterationCount=5;

	@Parameters({ "browser" })

	@BeforeTest(groups = {"SMOKE"})

	public void Beforem(@Optional("Insert folder name here or leave empty")String browser) throws IOException
	{
		System.out.println("browser value :-"+browser);

		PropertyConfigurator.configure(System.getProperty("user.dir")+"//Config//log4j.properties");

		Reporter.log("Reporter log started",true);

		Reporter.log("Login was successful. Moving to next step",true);

		log.info("Info message");

		log.info("Browser is "+browser);
		
		System.out.println("TestCase Starts");

		log.info("TestCase Starts");
		try
		{
			SeleniumRepo.startBrowser(browser, false);
			handleAlert(SeleniumRepo.driver).start();

		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumRepo.driver.manage().window().maximize();
	}
	
	@AfterTest
    public void driverclose()
    {
		try {
			SeleniumRepo.driver.close();
			SeleniumRepo.driver.quit();
//		Set<String> windows=SeleniumRepo.driver.getWindowHandles();
//		for(int i=0;i<=windows.size()-1;i++) {
//    	SeleniumRepo.driver.close();
//    	if(i==windows.size()-1)
//    		break;
//    	SeleniumRepo.driver.switchTo().window(windows.iterator().next());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

	@BeforeSuite(groups = {"SMOKE"}, enabled = true)
	public void setUp()
	{
		Date objDate = new Date(); // Current System Date and time is assigned to objDate
		System.out.println(objDate);
		String strDateFormat = "hh.mm.ss_ddMMMyyyy"; //Date format is Specified
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
		System.out.println(objSDF.format(objDate)); //Date formatting is applied to the current date
		 Presentdate = objSDF.format(objDate);
		System.out.println(Presentdate);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TTAutomationReport "+Presentdate+".html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Host Name", System.getProperty("user.name"));
		extent.setSystemInfo("Admin.Environmentironment", "QA");
		extent.setSystemInfo("User Name", "Harshini");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		htmlReporter.config().setReportName("TTAutomationReport");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@AfterMethod(groups = {"SMOKE"})
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			if(ReadProperties.getPropValues("AdminEnvironment.properties", "screenShotOnMethodFail").equalsIgnoreCase("yes"))
			{
				String screenShot = captureScreenShot(result,"fail");
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getRealClass().getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
				test.fail(result.getThrowable());
				test.fail("Failure Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
				//test.addScreenCaptureFromPath(screenShot);
		
			}
			else
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getRealClass().getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
				test.fail(result.getThrowable());
			}
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getRealClass().getName()+" Test Case PASSED", ExtentColor.GREEN));
			if(ReadProperties.getPropValues("AdminEnvironment.properties", "screenShotOnMethodPass").equalsIgnoreCase("yes"))
			{
				String screenShot = captureScreenShot(result,"pass");
				
				test.pass("Success Screen Shot : " + test.addScreenCaptureFromPath(screenShot));

			}
		}
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getRealClass().getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite(groups = {"SMOKE"})
	public void tearDown()
	{

		handleAlert(SeleniumRepo.driver).stop();
		//List<String> allDuplicateImagesForDeletion = DuplicateImageFinder.findDuplicatesForDeletion("C:\\Users\\TT072\\git\\ttqapomproj\\Screenshots\\Admin\\");

		// System.out.println("Size of images"+allDuplicateImagesForDeletion.size());
		extent.flush();
	}
	/*@AfterTest
    public void exit()
    {
    	SeleniumRepo.driver.quit();
    }*/
	
	//Function to capture screenshot.
	/**
	 * 
	 * @param result
	 * @param status
	 * @return 
	 * @throws IOException 
	 */
	public String captureScreenShot(ITestResult result, String status) throws IOException{	
		String destDir = "";
		String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
		//To capture screenshot.
		File scrFile = ((TakesScreenshot)SeleniumRepo.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		//If status = fail then set folder name "screenshots/Failures"
		if(status.equalsIgnoreCase("fail")&&ReadProperties.getPropValues("AdminEnvironment.properties", "screenShotOnMethodFail").equalsIgnoreCase("yes"))
		{
			destDir = System.getProperty("user.dir")+"\\Screenshots\\Admin\\Failures";
		}
		//If status = pass then set folder name "screenshots/Success"
		else if (status.equalsIgnoreCase("pass")&&ReadProperties.getPropValues("AdminEnvironment.properties", "screenShotOnMethodPass").equalsIgnoreCase("yes")){
			destDir = System.getProperty("user.dir")+"\\Screenshots\\Admin\\Success";
		}

		//To create folder to store screenshots
		new File(destDir).mkdirs();
		//Set file name with combination of test class name + date time.
		String destFile = passfailMethod+" - "+dateFormat.format(new Date()) + ".png";

		try {
			//Store file at destination folder location
			if(destDir!=null)
				FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return destDir + "/" + destFile;
	} 

	public static String capture() throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)SeleniumRepo.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\Screenshots\\"+Presentdate+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
                    
        return dest;
    }

	public String captureScreenShot(String result, String status) throws IOException{	
		String destDir = "";
		String passfailMethod = result;

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(SeleniumRepo.driver);
		//String dest = System.getProperty("user.dir") + "/ErrorScreenshots/test.png";
		// ImageIO.write(screenshot.getImage(),"PNG",new File(destDir));



		//To capture screenshot.
		//File scrFile = ((TakesScreenshot)SeleniumRepo.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		//If status = fail then set folder name "screenshots/Failures"
		if(status.equalsIgnoreCase("fail")&&ReadProperties.getPropValues("AdminEnvironment.properties", "screenShotOnMethodFail").equalsIgnoreCase("yes")){
			destDir = System.getProperty("user.dir")+"\\Screenshots\\Admin\\Failures";
		}
		//If status = pass then set folder name "screenshots/Success"
		else if (status.equalsIgnoreCase("pass")&&ReadProperties.getPropValues("AdminEnvironment.properties", "screenShotOnMethodPass").equalsIgnoreCase("yes")){
			destDir = System.getProperty("user.dir")+"\\Screenshots\\Admin\\Success";
		}
		else if (status.equalsIgnoreCase("yes")){
			destDir = System.getProperty("user.dir")+"\\Screenshots\\Admin\\Steps";
		}

		//To create folder to store screenshots
		// ImageIO.write(screenshot.getImage(),"PNG",new File(destDir));

		new File(destDir).mkdirs();
		//Set file name with combination of test class name + date time.
		String destFile = passfailMethod+" - "+dateFormat.format(new Date()) + ".png";

		try {
			//Store file at destination folder location
			if(destDir!=null&&destFile!=null)
				ImageIO.write(screenshot.getImage(),"PNG",new File(destDir+ "/" + destFile));

			//FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if(destDir!=null&&destFile!=null)
			return destDir + "/" + destFile;
		else
			return null;
	} 

	public  Thread handleAlert(final WebDriver driver)
	{
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while(true)
				{
					try

					{

						//System.out.println("Checking alert .... ");
						if(ReadProperties.getPropValues("AdminEnvironment.properties", "screenShotOnEachStep").equalsIgnoreCase("yes"))
						{
							/*test.log(Status.INFO, "STEPS SCREENSHOT"
                    					+ test.addScreenCaptureFromPath(captureScreenShot(this.getClass().getSimpleName(),"yes")));
							 */
							captureScreenShot(this.getClass().getSimpleName(), "yes");
							driver.switchTo().alert().accept();


						}
						//Thread.sleep(1000);
						// System.out.println("Alert Accepted. ");
					}catch(NoAlertPresentException n){
						try {
							Thread.sleep(80);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						//System.out.println("No Alert Present.  ");

					}catch (Exception e) {


						System.out.println("Exception: "+e.getMessage());
					}
				}
			}
		});

		return thread;
	}


	/**
	 * This method will start the recording of the execution. recorded file will
	 * get generated in the folder name as className_methodName. recording can
	 * be started from any particular time.
	 */
/*
	public void startRecording() {

		RecordingClassName = sun.reflect.Reflection.getCallerClass(2).getSimpleName();
		RecordingMethodName = new Throwable().fillInStackTrace()
				.getStackTrace()[1].getMethodName();
		fileRecordingLocation = System.getProperty("user.dir")+"//FailedTestcaseVideos//" + RecordingClassName + "_"
				+ RecordingMethodName;
		RecordedFile = new File(fileRecordingLocation);

		GraphicsConfiguration gc = GraphicsEnvironment//
				.getLocalGraphicsEnvironment()//
				.getDefaultScreenDevice()//
				.getDefaultConfiguration();
		try {
			screenRecorder = new ScreenRecorder(gc, null, new Format(
					MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
							ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey,
							ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey,
							(int) 24, FrameRateKey, Rational.valueOf(15),
							QualityKey, 1.0f, KeyFrameIntervalKey,
							(int) (15 * 60)), new Format(MediaTypeKey,
									MediaType.VIDEO, EncodingKey, "black",
									FrameRateKey, Rational.valueOf(30)), null,
					RecordedFile);
			screenRecorder.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	*//**
	 * This method will stop the recording.
	 *//*
	public void stopRecording() {
		if (screenRecorder != null) {
			try {
				screenRecorder.stop();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	*//**
	 * to delete the recorded file.if the test is passing then this method will delete the recorded file.
	 *//*

	public void deleteRecordedFile() {
		if (RecordedFile != null) {
			String[] children = RecordedFile.list();
			for (int i = 0; i <children.length; i++) {
				new File(RecordedFile, children[i]).delete();
				System.out.println("Deleted this " + RecordedFile + "//"
						+ children[i]);
			}

			// The directory is now empty so delete it
			RecordedFile.delete();
		}
	}
*/
	/**
	 * This method works similar to the org.testng.Assert.assertTrue and also
	 * performs following actions: 
	 * it takes the screenshot of the active screen if the assertion fails.
	 * it also deletes the recorded vedio file if the test is passed. Call this
	 * method only once, at the end of the test.
	 *
	 * @param condition
	 * @param message
	 */
/*	public void finalAssertTrue(boolean condition, String message)
	{
		stopRecording();
		if (condition)
			deleteRecordedFile();
		assertTrue(condition, message);
	}*/

	public  void windowid()
	{
		try {
			
		((JavascriptExecutor)SeleniumRepo.driver).executeScript("window.open();");	
		SeleniumRepo.driver.manage().window().maximize();
	    //SeleniumRepo.driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL +"t");
		Set<String> tabs=SeleniumRepo.driver.getWindowHandles();
		Iterator<String> it=tabs.iterator();
		ParentWindow=it.next();
		NewWindow=it.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void Javascriptexecutor(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor)SeleniumRepo.driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void scroll(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)SeleniumRepo.driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void takeScreenshotAtEndOfTest(String str) throws IOException 
	{
		File scrFile = ((TakesScreenshot) SeleniumRepo.driver).getScreenshotAs(OutputType.FILE);
		String currentDir = "admin//Screenshots_New";		
		FileUtils.copyFile(scrFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+str+ ".png"));
	}

	public void TypeInField(WebElement ele, String value) 
	{
		try {
		String val = value; 
		WebElement element = ele;
		element.clear();

		for (int i = 0; i < val.length(); i++){
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(200);
			element.sendKeys(s);
		} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public void ExplicitWait(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(SeleniumRepo.driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void ImplicitWait()
	{
		SeleniumRepo.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public void selectByVisibleText(WebElement element,String value)
	{

		Select sc=new Select(element);
		sc.selectByVisibleText(value);
	}
	public static void dismissalert()
	{
		Alert alert =SeleniumRepo.driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert data: " + alertText);
		alert.dismiss();
	}

	public static void login_Brand_Property() throws InterruptedException, IOException
	{
		Login Login=PageFactory.initElements(SeleniumRepo.driver, Login.class);
		SelectProperty SelectProperty=PageFactory.initElements(SeleniumRepo.driver, SelectProperty.class);
		BrandSelection BrandSelection =PageFactory.initElements(SeleniumRepo.driver, BrandSelection.class);
		
		Login.login();
		BrandSelection.selectBrand();
		SelectProperty.selectProperty_ByPropertyName();
		
		Thread.sleep(5000);
		
	}
	public List<String> Dates_BetweenRange(String Startdate,String Enddate) throws ParseException
	{
		List<Date> dates = new ArrayList<Date>();
		List<String>Alldates=new ArrayList<String>();

        DateFormat formatter ; 

        formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date  startDate = (Date)formatter.parse(Startdate); 
        Date  endDate = (Date)formatter.parse(Enddate);
        long interval = 24*1000 * 60 * 60; // 1 hour in millis
        long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
        long curTime = startDate.getTime();
        while (curTime <= endTime) {
            dates.add(new Date(curTime));
            curTime += interval;
        }
        for(int i=0;i<dates.size();i++)
        {
            Date lDate =(Date)dates.get(i);
            String ds = formatter.format(lDate);    
            System.out.println(" Date is ..." + ds);
            Alldates.add(ds);
        }
		return Alldates;
	}
	@BeforeSuite
	public void deleteLog() {

		logFileDeleteing = System.getProperty("user.dir")+"//log//";
		LogFile = new File(logFileDeleteing);

		if (LogFile != null) {
			String[] children = LogFile.list();
			for (int i = 0; i <children.length; i++)
			{
				new File(LogFile, children[i]).delete();
				System.out.println("Deleted this " + LogFile + "//"
						+ children[i]);
			}


		}

	}


	/*@BeforeSuite
	public void deleteSuccessFile()
	{
		SucessFileDeleteing = System.getProperty("user.dir")+"//ScreenShots//" +"//Admin//"+"//Success//";
		SucessFile = new File(SucessFileDeleteing);
		if (SucessFile != null)
		{
			String[] children = SucessFile.list();
			for (int i = 0; i <children.length; i++) 
			{
				new File(SucessFile, children[i]).delete();
				System.out.println("Deleted this " + SucessFile + "//"
						+ children[i]);
			}

		}
	}
*/

	/*@AfterTest
public void Teardown()
{
	SeleniumRepo.driver.quit();
}*/



	public List<String> windowidList()
	{
		ArrayList<String> windows = new ArrayList<String>();
		try {
		  
	      ((JavascriptExecutor)SeleniumRepo.driver).executeScript("window.open();");    
	       Set <String>tabs=SeleniumRepo.driver.getWindowHandles();
	       Iterator<String> it=tabs.iterator();
	       while(it.hasNext())
	       {
	    	   windows.add(it.next());//parent window
		       
	       }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    return windows;

	}




}





