package com.tt.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.admin.pom.AlternateProperties;
import com.tt.admin.pom.SelectProperty;

import ch.lambdaj.function.matcher.Predicate;


public class SeleniumRepo extends BaseTest
{
	public static WebElement webelement;
	public static List<WebElement> webelements = null;
	public static WebDriver driver = null;
	public static int defaultBrowserTimeOut = 30;
	public static List<String> windowHandlers;
	/**
	 * @author Harshini
	 * @param browser
	 *            name
	 * @param url
	 * @return driver of the browser invoked
	 * @throws UnknownHostException
	 */

	@SuppressWarnings("deprecation")
	public static WebDriver startBrowser(String browserName, boolean FirefoxBrowserProxy) throws UnknownHostException {

		if (browserName.equalsIgnoreCase("firefox")) 
		{

			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			/*
			 * DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			 * capabilities.setCapability("marionette", true); Webdriver driver = new
			 * FirefoxDriver(capabilities);

			if (FirefoxBrowserProxy) 
			{
				driver = new FirefoxDriver();
				//driver = proxySetting();

			}
			else*/

			driver = new FirefoxDriver();


		} 
		else if (browserName.equalsIgnoreCase("iexplorer")) 
		{

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");


			InternetExplorerDriverService service = (InternetExplorerDriverService) ((InternetExplorerDriverService.Builder) new InternetExplorerDriverService.Builder()
					.usingAnyFreePort()).build();

			InternetExplorerOptions cap = new InternetExplorerOptions().requireWindowFocus();

			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability("nativeEvents", true);
			cap.setCapability("ignoreZoomSetting", true);
			cap.setCapability("unexpectedAlertBehaviour", "accept");

			driver = new InternetExplorerDriver(service, cap);



			String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"no\"";
			try {
				Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				System.out.println("Error ocured!");
			}


		} 
		else if (browserName.equalsIgnoreCase("chrome")) 
		{
			//test.log(Status.INFO, "Launching Chrome");	
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("msedge")){
			
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Drivers\\MicrosoftWebDriver.exe");
			
			driver = new EdgeDriver();

			
		}

		/*
		 * driver.manage().timeouts() .implicitlyWait(defaultBrowserTimeOut,
		 * TimeUnit.SECONDS);
		 */
		driver.manage().deleteAllCookies();

		if (browserName.equalsIgnoreCase("iexplorer"))
			SeleniumRepo.SwitchAlert();

		if (windowHandlers == null)
			windowHandlers = new LinkedList<String>();
		else
			windowHandlers.clear();

		windowHandlers.add(driver.getWindowHandle());
		driver.manage().window().maximize();
		return driver;

	}

	public static void waitForPageLoaded() 
	{
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
		{
			public Boolean apply(WebDriver driver) 
			{
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}

	}

	/**
	 * @author Harshini
	 * @return Driver Set with Proxy Setting
	 */

	/*	public static WebDriver proxySetting() 
	{
		String serverIP = PropertyFileRead.FileRead("DBDetail.properties", "proxyHort");
		String port = PropertyFileRead.FileRead("DBDetail.properties", "proxyPort");
		WebDriver newDriver;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.ftp", serverIP);
		profile.setPreference("network.proxy.http", serverIP);
		profile.setPreference("network.proxy.socks", serverIP);
		profile.setPreference("network.proxy.ssl", serverIP);
		profile.setPreference("network.proxy.ftp_port", port);
		profile.setPreference("network.proxy.http_port", port);
		profile.setPreference("network.proxy.socks_port", port);
		profile.setPreference("network.proxy.ssl_port", port);


		return newDriver;
	}*/

	/**
	 * @author Harshini
	 * @return Boolean value for Switch Alert
	 */
	public static boolean SwitchAlert() {
		boolean Flag = false;

		try {
			if (driver.switchTo().alert() != null) {
				driver.switchTo().alert().accept();
				Flag = true;
			}

		}

		catch (NoAlertPresentException e) {

		}
		return Flag;

	}

	/**
	 * @author Harshini
	 * 
	 */
	public static void closeBrowser() {

		SeleniumRepo.driver.close();
		// driver = null;
		// WindowsUtils.tryToKillByName("IEDriverServer.exe");
		/* taskkill /F /IM IEDriverServer.exe - From Command Prompt */
	}

	/**
	 * @author Harshini
	 */
	public static void shutDownDriver() {
		if (driver != null)
			driver.quit();
	}

	/**
	 * @author Harshini
	 * @return current Driver instance
	 */
	public static WebDriver getWebDriver() {
		return driver;
	}

	/**
	 * @author somsahoo
	 * @throws UnknownHostException
	 */
	/*
	public static void deleteTempFile() throws UnknownHostException {
		String property = "java.io.tmpdir";
		String temp = System.getProperty(property);
		File directory = new File(temp);
		try {
			delete(directory);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	 */	/**
	 * @author Harshini
	 * @param file-
	 *            Directory and Sub directory to be deleted
	 * @throws IOException
	 */
	/*
	public static void delete(File file) throws IOException {
		if (file.isDirectory()) { // directory is empty, then delete it
			if (file.list().length == 0) {
				file.delete();
			} else {
				// list all the directory contents
				String files[] = file.list();
				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);
					// recursive delete
					delete(fileDelete);
				}
				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : " + file.getAbsolutePath());
				}
			}
		} else {
			// if file, then delete it
			file.delete();
		}
	}

	 */	/**
	 * @author Harshini
	 * @param locator
	 *            in particular format mentioned
	 * @return WebElement
	 */
	public static WebElement findElement(String locator) {

		/*// Locator Values are Expected in string format like "name==abc" or "id==pqr" or
		// "xpath==//*[@id='uname']"

		if (locator != null) {
			String[] arrLocator = locator.split("==");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();
			try {
				if (locatorTag.equalsIgnoreCase("id")) {
					webelement = driver.findElement(By.id(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("name")) {
					webelement = driver.findElement(By.name(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("xpath")) {
					webelement = driver.findElement(By.xpath(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("linkText")) {
					webelement = driver.findElement(By.linkText(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("class")) {
					webelement = driver.findElement(By.className(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("css")) {
					webelement = driver.findElement(By.cssSelector(objectLocator));
					highlightElement(driver, webelement);
				} else {
					String error = "Please Check the Given Locator Syntax :" + locator;
					error = error.replaceAll("'", "\"");

					return null;
				}
			} catch (Exception exception) {
				String error = "Please Check the Given Locator Syntax :" + locator;
				error = error.replaceAll("'", "\"");
				exception.printStackTrace();
				return null;
			}
		}
		 */		return webelement;
	}

	/**
	 * @author Harshini
	 * @param driver
	 * @param element
	 */
	public static void highlightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid DeepPink;");
	}

	/**
	 * @author Harshini
	 * @param Web
	 *            element
	 */
	public static void doubleClick(WebElement element) {
		if ((driver != null) && (element != null))
			(new Actions(driver)).doubleClick(element).build().perform();
	}

	/**
	 * @author Harshini
	 * @param locator
	 * @return True or False whether the Element Present or not
	 */
	public static boolean isElementPresent(WebElement ele) {
		By locator = toByVal(ele);
		List<WebElement> arrElements = null;
		arrElements = driver.findElements(locator);
		if (arrElements.size() > 0 && arrElements != null) {

			return true;
		} else
			System.out.println("Element not found");

		return false;
	}
	
	
	/**
	 * 
	 * @author DM
	 * @param ele
	 * @return true or false if an element is displayed
	 */
	public static boolean isElementDisplayed(WebElement ele) {
		
	
			try{
			if( ele.isDisplayed() == true){
				return true;
			}
			
			}catch(NoSuchElementException e){
				
		         System.out.println("The element is not displayed");
			}
			
			return false;
	
	}
	
	

	/**
	 * @author Harshini * @param locator Wait for Element load
	 */
	public static void ElementWait(By sel_Property) throws InterruptedException {

		WebElement element = null;
		for (int i = 0; i < 60; i++) {
			try {
				element = SeleniumRepo.findElement(sel_Property);

			} catch (Exception e) {
			}

			if (element != null || element != null)
				return;
			Thread.sleep(3000);
			System.out.println("Waiting");
		}
	}

	/**
	 * @author Harshini * @param locator Thread Wait
	 */
	public static void WaitForLoad(int TimeMillSec) throws InterruptedException {

		Thread.sleep(TimeMillSec);
	}

	/**
	 * @author Harshini * @param locator
	 * @return list of webelement found
	 */
	public static List<WebElement> findElements(By locator) {

		/*
		 * if (locator != null) { String[] arrLocator = locator.split("=="); String
		 * locatorTag = arrLocator[0].trim(); String objectLocator =
		 * arrLocator[1].trim();
		 * 
		 * if (locatorTag.equalsIgnoreCase("id")) { webelements =
		 * driver.findElements(By.id(objectLocator)); } else if
		 * (locatorTag.equalsIgnoreCase("name")) { webelements =
		 * driver.findElements(By.name(objectLocator)); } else if
		 * (locatorTag.equalsIgnoreCase("xpath")) { webelements =
		 * driver.findElements(By.xpath(objectLocator)); } else if
		 * (locatorTag.equalsIgnoreCase("linkText")) { webelements =
		 * driver.findElements(By.linkText(objectLocator)); } else if
		 * (locatorTag.equalsIgnoreCase("class")) { webelements =
		 * driver.findElements(By.className(objectLocator)); } else {
		 * System.out.println("Please Check the Locator Syntax Given :" + locator);
		 * return null; } }
		 */
		return driver.findElements(locator);
	}

	/**
	 * @author Harshini
	 * @param propertyType
	 * @param propertyValue
	 */
	public static void mousehovering(String locator) {

		WebElement mouseOverElement = findElement(locator);
		Actions builder = new Actions(driver); // Configure the Action
		Action mouseOver = builder.moveToElement(mouseOverElement).build(); // Get the action
		mouseOver.perform(); // Execute the Action
	}

	/**
	 * @author Harshini
	 * @throws AWTException
	 */
	public static void PressShiftTab() throws AWTException {
		Robot robot = new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}

	/**
	 * @author Harshini
	 * @throws AWTException
	 */
	public static void PressTab() throws AWTException {
		Robot robot = new Robot();
		robot.delay(3000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

	}

	/**
	 * @author Harshini
	 * @param locator
	 *            of the Web Element
	 * @param attributeName
	 * @return attributeValue
	 */
	public static String getAttribute(String locator, String attributeName) {
		String attributeValue = null;
		try {

			WebElement element = SeleniumRepo.findElement(locator);
			if (element != null)
				attributeValue = element.getAttribute(attributeName);
			element = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return attributeValue;
	}

	/**
	 * @author Harshini
	 * @param locator
	 *            of the Element to be cleared
	 */
	public static void clearElement(String locator) {
		try {

			WebElement element = SeleniumRepo.findElement(locator);
			element.clear();
			element = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @author Harshini
	 * @param user_name
	 * @param value
	 */
	public static void enterText(By user_name, String value) {

		try {

			WebElement element = SeleniumRepo.findElement(user_name);
			element.sendKeys(value);
			element = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @author Harshini
	 * @param user_name
	 *            of Element to be clicked
	 */
	public static void click(By user_name) {
		try {
			WebElement element = SeleniumRepo.findElement(user_name);
			if (element != null)
				element.click();
			else
				System.out.println("Element Is NULL");
			element = null;

		} catch (Exception e) {
			System.out.println(" Error occured whlie click on the element " + user_name + " *** " + e.getMessage());

		}

	}

	/**
	 * @author Harshini
	 * @param locator
	 * @return Text/value of the Element
	 */
	public static String getElementText(String locator) {
		WebElement element;
		String text = null;
		try {
			element = SeleniumRepo.findElement(locator);
			if (element != null)

				text = element.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		element = null;

		return text;
	}

	public static void driverInitialize(WebDriver webDriver) {
		SeleniumRepo.driver = webDriver;
	}

	@SuppressWarnings("deprecation")
	public static By fluentWait(final WebElement ele) {

		final By locator = toByVal(ele);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		wait.until(new com.google.common.base.Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return locator;
	}

	public static WebElement findElement(By locator) {

		// Locator Values are Expected in string format like "name==abc" or "id==pqr" or
		// "xpath==//*[@id='uname']"
		return driver.findElement(locator);

	}

	public static WebElement waitForElementPresent(WebElement elementToBeLoaded) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
			return element;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}

	public static List<WebElement> waitForElementsPresent(List<WebElement> elementsToBeLoaded) {
		List<WebElement> element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			element = wait.until(ExpectedConditions.visibilityOfAllElements(elementsToBeLoaded));
			return element;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}


	public static void GoToUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {

		}
	}
	
	public static void scrollintoview(WebElement element)
    {
		try {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	
	public static void ScrollByupdown(int up,int down)
	{
	    try {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy("+up+","+down+")","");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public static String replaceLast(String input, String regex, String replacement) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			return input;
		}
		int lastMatchStart=0;
		do {
			lastMatchStart=matcher.start();
		} while (matcher.find());
		matcher.find(lastMatchStart);
		StringBuffer sb = new StringBuffer(input.length());
		matcher.appendReplacement(sb, replacement);
		matcher.appendTail(sb);
		return sb.toString();
	}


	public static String getRandomAlphNumeircString(int n) 
	{
		// Get a n-digit multiplier of 10
		int maxDigit = (int) Math.pow(10, n - 2);
		Random random = new Random();
		/*
		 * Get a random character by getting a number from 0 t0 26 and then adding an
		 * 'A' to make it a character
		 * 
		 */
		char randomCharacter = (char) (random.nextInt(26) + 'A');
		/*
		 * Add 1*maxDigit to ensure that the number is equals to or greater than minimum
		 * value nextInt() method will return the number between 0 and 9*maxDigit
		 */
		int randomNumber = 1 * maxDigit + random.nextInt(9 * maxDigit);
		return String.valueOf(randomCharacter) + randomNumber;
	}

	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static By toByVal(WebElement we) {
		// By format = "[foundFrom] -> locator: term"
		// see RemoteWebElement toString() implementation
		/*	String[] data1 = we.toString().split("->");
		data1[data1.length - 1] = data1[data1.length - 1].replace("]", "");
		String brandNew = StringUtils.join(data1);
		System.out.println(brandNew);
		System.out.println(data1[0]);
		System.out.println(data1[1]);

		String [] vals=brandNew.split(":");
		String loc=vals[0];
		String term=vals[1];*/
		
		String webElem = we.toString();
		
		String[] data;

		
		if(webElem.contains("->") ) {
			//Example of data that is being split
			//[[ChromeDriver: chrome on XP (ef7c0d1301ddbfbcad7350e120f24729)] -> xpath: //*[@id='search_departure_date']]
			data = webElem.split(" -> ")[1].replaceFirst("]", "").split(": ");
		}else{
			//Example of data that is being split
			//Proxy element for: DefaultElementLocator 'By.all({By.xpath: //h1[contains(text(),'Property Yield Restrictions')]})'
			data = webElem.split("[{]")[1].split("[.]")[1].replace("})\'", "").split(": ");
		}		
		
		String locator = data[0];
		String term = data[1];

		//System.out.println("This from selniumreppoooooo " + data.length + "   "  + data + "   " + locator  + "   " + term);
		
		switch (locator) {
		case "xpath":
			return By.xpath(term);
		case "css selector":
			return By.cssSelector(term);
		case "id":
			return By.id(term);
		case "tag name":
			return By.tagName(term);
		case "name":
			return By.name(term);
		case "link text":
			return By.linkText(term);
		case "class name":
			return By.className(term);
		}
		return (By) we;
	}

	public static void handleAlert(){
		if(isAlertPresent()){
			Alert alert = SeleniumRepo.driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}
	public static boolean isAlertPresent(){
		try{
			SeleniumRepo.driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex){
			return false;
		}
	}
	public static boolean isTextPresent(WebElement ele,String str)
	{
		return ele.getText().contains(str);
	}

	
}
