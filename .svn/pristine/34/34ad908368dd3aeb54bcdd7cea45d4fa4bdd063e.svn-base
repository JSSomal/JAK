package frameworkGlobals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import interfaces.ClassObject;
import io.appium.java_client.android.AndroidDriver;

public class InitializeDriver implements ClassObject {
	
	public static boolean driverFlag= true;
	//public static WebDriver driver;
	public static AndroidDriver driver;

	public static WebDriver privateDriver;
	public static Capabilities caps;
	public static String imgeHtmlPath;
	public static ExtentTest extentTest;
	//extentDate = new SimpleDateFormat("dd_MM_yyyy").format(new Date());
	public static ExtentReports extentReport = new ExtentReports(
			
			System.getProperty("user.dir") + "\\LogsAndReports\\Reports_"+ClassObject.extentDate+"\\Reports_" + ClassObject.extentDate + ".html", true); ;
	

	@BeforeClass
	public static void LaunchApp() {
		try {
			System.out.println(extentDate);
			extentTest = extentReport.startTest("Browser initialization", "initialization of browser and open browser");			
			
			 DesiredCapabilities capabilities = new DesiredCapabilities();

		        // Set android deviceName desired capability. Set your device name.
		        capabilities.setCapability("deviceName", excel.getCellData("Info", "DeviceName", 2));//"07ce7ce700f1d0e1");

		        // Set BROWSER_NAME desired capability. It's Android in our case here.
		        capabilities.setCapability(CapabilityType.BROWSER_NAME, excel.getCellData("Info", "DeviceType", 2));

		        // Set android VERSION desired capability. Set your mobile device's OS version.
		        capabilities.setCapability(CapabilityType.VERSION, excel.getCellData("Info", "Version", 2));

		        // Set android platformName desired capability. It's Android in our case here.
		        capabilities.setCapability("platformName", excel.getCellData("Info", "DeviceType", 2));
		        capabilities.setCapability("app", System.getProperty("user.dir")+excel.getCellData("Info", "ApkPath", 2));//"D:\\Selenium_Workspace\\JakMobileAutomation\\Apk\\Jak-Customer-staging-release.apk");
		        // Set android appPackage desired capability. It is
		        // com.android.calculator2 for calculator application.
		        // Set your application's appPackage if you are using any other app.
		        capabilities.setCapability("package", excel.getCellData("Info", "Package", 2));

		        // Set android appActivity desired capability. It is
		        // com.android.calculator2.Calculator for calculator application.
		        // Set your application's appPackage if you are using any other app.
		        capabilities.setCapability("appActivity", excel.getCellData("Info", "Activity", 2));
		        
		        // Created object of RemoteWebDriver will all set capabilities.
		        // Set appium server address and port number in URL string.
		        // It will launch calculator app in android device.
		        driver = new AndroidDriver<WebElement>(new URL(excel.getCellData("Info", "URL", 2)), capabilities);
		        //driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		        //WebDriver driver = new RemoteWebDriver()//FirefoxDriver();
		        //System.out.println("2");

		        // Click on DELETE/CLR button to clear result text box before running test.
		        //driver.findElement(By.xpath("com.google.android.calculator:id/digit_7")).click();

		        // Click on number 2 button.
		       // driver.findElement(By.name("7")).click();
		} 
		catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		}
	}
	
	@AfterMethod(alwaysRun = true, groups = {"Smoke", "Regression","Harman","Harinder","Jasmeet","Deepak"}, enabled = true)
	public void afterMethod(ITestResult result) {
	    switch (result.getStatus()) {
	         case 1://Pass
				extentTest.log(LogStatus.PASS, "Test passed sucessfully");
				break;
				
			case 2://Fail
				String get_ErrorMessg = result.getThrowable().toString();
				String errorMSg = result.getThrowable().getMessage();
				String actionInfo=result.getName();
				
				if (get_ErrorMessg.contains("AssertionError")) {
					
					extentTest.log(LogStatus.FAIL, "BUGGG >> " + errorMSg);
					utility.takeScreenshot(actionInfo.replaceAll(" ", "_"));
					extentTest.log(LogStatus.FAIL, "Screenshort of BuGG :"+ imgeHtmlPath);
					break;
				}
				
				else if (get_ErrorMessg.contains("RUNTIME_ERROR")) {
					extentTest.log(LogStatus.UNKNOWN, "Class : ",  result.getInstanceName());
					extentTest.log(LogStatus.ERROR, "" + errorMSg);
					extentTest.log(LogStatus.ERROR, "Screenshort of Error :"+ imgeHtmlPath);
					break;
				}
				
				else{
					
					if(get_ErrorMessg.contains("Unable to locate element") || get_ErrorMessg.contains("no_such_element")){
					
						extentTest.log(LogStatus.UNKNOWN, "Class : ",  result.getInstanceName());
						extentTest.log(LogStatus.ERROR, "RUNTIME ERROR >> " + errorMSg);
					utility.takeScreenshot(actionInfo.replaceAll(" ", "_"));
					extentTest.log(LogStatus.ERROR, "Screenshort of Error :" + imgeHtmlPath);
					break;
					}
					else{
						extentTest.log(LogStatus.UNKNOWN, "Class : ",  result.getInstanceName());
					extentTest.log(LogStatus.ERROR, "RUNTIME ERROR >> " + errorMSg);	
					break;
					}
				}
			case 3://Skip
				extentTest = extentReport.startTest(result.getName(), "Class : "+
			result.getInstanceName());
				extentTest.log(LogStatus.UNKNOWN, "Class : ",  result.getInstanceName());
				  extentTest.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
				  break;
	    }	
	            extentReport.endTest(extentTest);
		        extentReport.flush();
	}
	
	@AfterSuite(alwaysRun = true, enabled = true)
	public void aftersuite() {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\BrowserExecuteable\\geckodriver.exe");
		WebDriver driverResult = new FirefoxDriver();
		driverResult.get("file://" + System.getProperty("user.dir") + "\\LogsAndReports\\Reports_"+extentDate+"\\Reports_" + extentDate + ".html");
		System.out.println("Report generated successfully :)");
	}
	
}