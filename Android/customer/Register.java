package customer;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.relevantcodes.extentreports.LogStatus;

import frameworkGlobals.InitializeDriver;
import io.appium.java_client.AppiumDriver;
import objectRepository.iCustomer;

public class Register extends InitializeDriver implements iCustomer {

	//static WebDriverWait wait = new WebDriverWait(driver,45);
	
	
	@BeforeMethod
	public static void SplashScreen()
	{
		extentTest.log(LogStatus.INFO, "Go to Splash Screen");
		driver.startActivity("co.jakapp.customer", "co.jakapp.customer.activities.SplashActivity");
	}
	
	
	@Test(priority = 0)

	public static void Jak_0016() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		extentTest = extentReport.startTest("Jak_0016", "Verify user redirect to 'SignUp' screen.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		int getSize = byId.getSize(id_SignupScreenSignupButton, "Getting size of 'Signup button'");
		System.out.println(getSize);
		Assert.assertTrue(getSize > 0, "Signup button is missing on the page.");
		extentTest.log(LogStatus.INFO, "User redirecting to 'SignUp' screen.");
	}
	
	//----------------------------------------------------------------------------------------------
	
	
	@Test(priority = 1)

	public static void Jak_0017() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		extentTest = extentReport.startTest("Jak_0017", "Validation message 'Name can not be empty' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();

		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		String getText = byXpath.getText(xpath_SignupScreenNameFieldValidation,
				"Getting the validation message for blank name");
		System.out.println(getText);
		Assert.assertEquals(getText, "Name can not be empty");
		extentTest.log(LogStatus.INFO, "Validation message 'Name can not be empty' should display.");

	}
	//----------------------------------------------------------------------------------------------

	@Test(priority = 2)

	public static void Jak_0018() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		extentTest = extentReport.startTest("Jak_0018", "Validation message 'Invalid email address' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		
		String getText = byXpath.getText(xpath_SignupScreenEmailFieldValidation,
				"Getting the validation message for blank email");
		Assert.assertEquals(getText, "Invalid email address");
		extentTest.log(LogStatus.INFO, "Validation message 'Invalid email address' should display.");
	}
	
	//----------------------------------------------------------------------------------------------
	
	@Test(priority = 3)

	public static void Jak_0019() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		extentTest = extentReport.startTest("Jak_0019", "Validation message 'Invalid email address' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenInvalidEmail, "Enter invalid email under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		
		String getText = byXpath.getText(xpath_SignupScreenEmailFieldValidation,
				"Getting the validation message for invalid email");
		Assert.assertEquals(getText, "Invalid email address");
		extentTest.log(LogStatus.INFO, "Validation message 'Invalid email address' should display.");

	}
	
	//--------------------------------------------------------------------------------------------------
	
	@Test(priority = 4)

	public static void Jak_0020() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		extentTest = extentReport.startTest("Jak_0020", "Validation message 'Password length must be more than 8 characters' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		
		String getText = byXpath.getText(xpath_SignupScreenPasswordFieldValidation,
				"Getting the validation message for blank password");
		Assert.assertEquals(getText, "Password length must be more than 8 characters");
		extentTest.log(LogStatus.INFO, "Validation message 'Password length must be more than 8 characters' should display.");

	}
	
	//----------------------------------------------------------------------------------------
	
	
	@Test(priority = 5)

	public static void Jak_0021() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		extentTest = extentReport.startTest("Jak_0021", "Validation message 'Password length must be more than 8 characters' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenInvalidPassword, "Enter invalid password under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		
		String getText = byXpath.getText(xpath_SignupScreenPasswordFieldValidation,
				"Getting the validation message for invalid password");
		Assert.assertEquals(getText, "Password length must be more than 8 characters");
		extentTest.log(LogStatus.INFO, "Validation message 'Password length must be more than 8 characters' should display.");

	}
	
	//---------------------------------------------------------------------------------------------------
	
	@Test(priority = 6)

	public static void Jak_0022() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 8);
		extentTest = extentReport.startTest("Jak_0022", "Dropdown list should be open to select the country code.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		
		byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
		//byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		String getText = byXpath.getText(xpath_SignupScreenCountryDDLTitle,
				"Getting the title of country code popup");
		Assert.assertEquals(getText, "Select your country");
		
		
		
		//----------------------------- Getting List of DDL ---------------------------------------
		
		for(int i=0;i<=25 ;i++){
			Dimension dim = driver.manage().window().getSize();
			Double screenheightStart = dim.getHeight() * 0.9;
			int scrollStart = screenheightStart.intValue();
			Double screenHeightEnd = dim.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
			
			Thread.sleep(3000);
			int getSize = byXpath.getSize(xpath_SignupScreenCountryDDLSelect, "Getting Size");
			if (getSize == 1){
				byXpath.click(xpath_SignupScreenCountryDDLSelect, "Select country code");
				
			}
			
			}
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		//------------------------------------End-----------------------------------------------------------
		
		
		extentTest.log(LogStatus.INFO, "Dropdown list should be open to select the country code.");

		}
	
	//-----------------------------------------------------------------------------------------------------------
	
	@Test(priority = 7)
    
	public static void Jak_0023() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		extentTest = extentReport.startTest("Jak_0023", "Validation message 'Please enter valid phone no.' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
		driver.hideKeyboard();
		
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		
		String getText = byXpath.getText(xpath_SignupScreenPhoneFieldValidation,
				"Getting the validation message for blank phone");
		Assert.assertEquals(getText, "Please enter valid phone number");
		
		extentTest.log(LogStatus.INFO, "Validation message 'Please enter valid phone no.' should display.");
		}
	
	//------------------------------------------------------------------------------------------------------
	
	
	@Test(priority = 8)

	public static void Jak_0024() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		extentTest = extentReport.startTest("Jak_0024", "Validation message 'The mobile number is invalid' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
		byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenInvalidPhone, "Enter invalid phone under field");
		driver.hideKeyboard();
		
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_SignupScreenInvalidPhoneValidation)));
		String getText = byXpath.getText(xpath_SignupScreenInvalidPhoneValidation,
			"Getting the validation message for invalid phone");
		Assert.assertEquals(getText, "The mobile number is invalid");
		extentTest.log(LogStatus.INFO, "Validation message 'The mobile number is invalid' should display.");
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	@Test(priority = 9)

	public static void Jak_0028() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 45);
		extentTest = extentReport.startTest("Jak_0027", "Validation message 'Phone verification failed' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
		// ------- Select Country code.
        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
		for(int i=0;i<=6;i++){
		Dimension dim = driver.manage().window().getSize();
		Double screenheightStart = dim.getHeight() * 0.9;
		int scrollStart = screenheightStart.intValue();
		Double screenHeightEnd = dim.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		}
		Thread.sleep(3000);
		byXpath.click(xpath_SignupScreenCountryDDLSelect, "Select country code");
		byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenValidPhone1, "Enter valid phone under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		Thread.sleep(3000);
		
		byId.clearThenSetText(id_VerifyPhoneScreenEnterCodeField, value_SignupScreenInvalidOTP, "Enter invalid OTP");
		
		String getText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_VerifyPhoneScreenPhoneFailedValidation))).getText();
		System.out.println(getText);
		Assert.assertEquals(getText, "Phone verification failed");
		extentTest.log(LogStatus.INFO, "Validation message 'Phone verification failed' should display.");
		}
	
	//----------------------------------------------------------------------------------------------------------------
	
	
	
	@Test(priority = 10)

	public static void Jak_0029() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 45);
		extentTest = extentReport.startTest("Jak_0028", "A new OTP should be generated.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
		
		// ------- Select Country code.
		
        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
		for(int i=0;i<=6;i++){
		Dimension dim = driver.manage().window().getSize();
		Double screenheightStart = dim.getHeight() * 0.9;
		int scrollStart = screenheightStart.intValue();
		Double screenHeightEnd = dim.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		}
		Thread.sleep(2000);
		byXpath.click(xpath_SignupScreenCountryDDLSelect, "Select country code");
		byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenValidPhone1, "Enter valid phone under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		Thread.sleep(130000);
		
		
		byId.click(id_VerifyPhoneScreenResendOTPLink, "Click on Resend OTP link.");
		Thread.sleep(3000);
		
		driver.openNotifications();
		String getText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/big_text"))).getText();
		System.out.println(getText);
		int getLength = getText.length();
		Assert.assertTrue(getLength>0, "No notification display.");

		byId.click("com.android.systemui:id/dismiss_text", "Clear all notifications");
		
		extentTest.log(LogStatus.INFO, "A new OTP should be generated.");
		}
	
	//------------------------------------------------------------------------------------------------------------------
	
	
	@Test(priority = 11)

	public static void Jak_0046() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 45);
		extentTest = extentReport.startTest("Jak_0046", "User should be successfully registered with the app and logged into the app.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
		// ------- Select Country code.
        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
		for(int i=0;i<=6;i++){
		Dimension dim = driver.manage().window().getSize();
		Double screenheightStart = dim.getHeight() * 0.9;
		int scrollStart = screenheightStart.intValue();
		Double screenHeightEnd = dim.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		}
		Thread.sleep(2000);
		byXpath.click(xpath_SignupScreenCountryDDLSelect, "Select country code");
		byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenValidPhone1, "Enter valid phone under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		Thread.sleep(3000);
		driver.openNotifications();
		String getText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/big_text"))).getText();
		byId.click("com.android.systemui:id/dismiss_text", "Clear all notifications");
		String OTP = getText.substring(26,30 );
		System.out.println(OTP);
		byId.clearThenSetText(id_VerifyPhoneScreenEnterCodeField, OTP, "Enter valid OTP");
		String getTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_HomeScreenTitleText))).getText();
		Assert.assertEquals(getTitle, "NEW REQUEST");
		byClassName.click(class_HomeScreenMenuIcon, "Click on menu icon under home screen");
		byXpath.click(xpath_HomeScreenMenuIconLogout, "Click on logout button");
		extentTest.log(LogStatus.INFO, "User should be successfully registered with the app and logged into the app.");
		}
	
		
	//--------------------------------------------------------------------------------------------------------
	
	
	@Test(priority = 12)

	public static void Jak_0025() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		extentTest = extentReport.startTest("Jak_0025", "Validation message 'Phone number has been used' should display.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail2, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
		
		// ------- Select Country code.
		
        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
		for(int i=0;i<=6;i++){
		Dimension dim = driver.manage().window().getSize();
		Double screenheightStart = dim.getHeight() * 0.9;
		int scrollStart = screenheightStart.intValue();
		Double screenHeightEnd = dim.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		}
		byXpath.click(xpath_SignupScreenCountryDDLSelect, "Select country code");
		
		byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenValidPhone1, "Enter duplicate phone under field");
		driver.hideKeyboard();
		
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_SignupScreenDuplicatePhoneValidation)));
		String getText = byXpath.getText(xpath_SignupScreenDuplicatePhoneValidation,
			"Getting the validation message for duplicate phone");
		Assert.assertEquals(getText, "Phone number has been used");
		extentTest.log(LogStatus.INFO, "Validation message 'Phone number has been used' should display.");
		
		}
	
	//---------------------------------------------------------------------------------------------
	
	/*@Test(priority = 13)

	public static void Jak_0026() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		extentTest = extentReport.startTest("Jak_0026", "Validation message should display for already exist email address.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
		byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
		byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
		
		// ------- Select Country code.
		
        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
		for(int i=0;i<=6;i++){
		Dimension dim = driver.manage().window().getSize();
		Double screenheightStart = dim.getHeight() * 0.9;
		int scrollStart = screenheightStart.intValue();
		Double screenHeightEnd = dim.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		}
		byXpath.click(xpath_SignupScreenCountryDDLSelect, "Select country code");
		
		byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenValidPhone2, "Enter new phone under field");
		driver.hideKeyboard();
		
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_SignupScreenDuplicatePhoneValidation)));
		String getText = byXpath.getText(xpath_SignupScreenDuplicatePhoneValidation,
			"Getting the validation message for duplicate phone");
		Assert.assertEquals(getText, "Phone number has been used");
		extentTest.log(LogStatus.INFO, "Validation message should display for already exist email address.");
		
		}*/
	
	
}