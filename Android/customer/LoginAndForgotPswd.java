package customer;


import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
<<<<<<< .mine
=======
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
>>>>>>> .r932

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import frameworkGlobals.InitializeDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectRepository.iCustomer;

public class LoginAndForgotPswd extends InitializeDriver implements iCustomer{
	SoftAssert softAssert = new SoftAssert();
	
	/*****************SignUp_Start************************/
	
	//static WebDriverWait wait = new WebDriverWait(driver,45);
	@BeforeMethod
	public static void SplashScreen()
	{
		extentTest.log(LogStatus.INFO, "Go to Splash Screen");
		driver.startActivity(excel.getCellData("Info", "Package", 2), excel.getCellData("Info", "Activity", 2));
	}
	
	@Test(priority = 0)
	public static void Jak_0016() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		extentTest = extentReport.startTest("Jak_0016", "Verify user redirect to 'SignUp' screen.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
		int getSize = byId.getSize(id_SignupScreenSignupButton, "Getting size of 'Signup button'");
		driver.navigate().back();
		System.out.println(getSize);
		Assert.assertTrue(getSize > 0, "Signup button is missing on the page.");
		extentTest.log(LogStatus.INFO, "User redirecting to 'SignUp' screen.");
	}
	
	@Test(priority = 1, enabled = false)
	public static void Jak_0028() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 45);
			extentTest = extentReport.startTest("Jak_0027", "Validation message 'Phone verification failed' should display.");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
			byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
			byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
			byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
			// ------- Select Country code.
	        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
	        
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
			
			
			byId.clearThenSetText(id_SignupScreenPhonedField, excel.getCellData("Info", "PhoneNumber", 2), "Enter valid phone under field");
			driver.hideKeyboard();
			byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
			Thread.sleep(3000);
			
			byId.clearThenSetText(id_VerifyPhoneScreenEnterCodeField, value_SignupScreenInvalidOTP, "Enter invalid OTP");
			
			String getText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_VerifyPhoneScreenPhoneFailedValidation))).getText();
			System.out.println(getText);
			driver.navigate().back();
			driver.navigate().back();
			Assert.assertEquals(getText, "Phone verification failed");
			extentTest.log(LogStatus.INFO, "Validation message 'Phone verification failed' should display.");
			}
		
		//----------------------------------------------------------------------------------------------------------------
		
		
		
		@Test(priority = 2, enabled = false)

		public static void Jak_0029() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, 45);
			extentTest = extentReport.startTest("Jak_0028", "A new OTP should be generated.");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
			byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
			byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
			byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
			
			// ------- Select Country code.
			
	        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
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
			byId.clearThenSetText(id_SignupScreenPhonedField,excel.getCellData("Info", "PhoneNumber", 2), "Enter valid phone under field");
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
			driver.navigate().back();
			driver.navigate().back();
			extentTest.log(LogStatus.INFO, "A new OTP should be generated.");
			}
		
		//------------------------------------------------------------------------------------------------------------------
		
		
		/*@Test(priority = 3, enabled = false)

		public static void Jak_0046() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, 45);
			extentTest = extentReport.startTest("Jak_0046", "User should be successfully registered with the app and logged into the app.");
			CommonFunctions.SignUp();
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
			}*/
		
		//-------------------------------------------------------------------------------------------------------------------
		
		@Test(priority = 4)

		public static void Jak_0017() {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			extentTest = extentReport.startTest("Jak_0017", "Validation message 'Name can not be empty' should display.");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
			byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
			String getText = byXpath.getText(xpath_SignupScreenNameFieldValidation,
					"Getting the validation message for blank name");
			System.out.println(getText);
			driver.navigate().back();
			Assert.assertEquals(getText, "Name can not be empty");
			extentTest.log(LogStatus.INFO, "Validation message 'Name can not be empty' should display.");

		}
		//----------------------------------------------------------------------------------------------

		@Test(priority = 5)
		public static void Jak_0018() {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			extentTest = extentReport.startTest("Jak_0018", "Validation message 'Invalid email address' should display.");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
			byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
			driver.hideKeyboard();
			byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
			
			String getText = byXpath.getText(xpath_SignupScreenEmailFieldValidation,
					"Getting the validation message for blank email");
			driver.navigate().back();
			Assert.assertEquals(getText, "Invalid email address");
			extentTest.log(LogStatus.INFO, "Validation message 'Invalid email address' should display.");
		}
		
		//----------------------------------------------------------------------------------------------
		
		@Test(priority = 6)

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
			driver.navigate().back();
			Assert.assertEquals(getText, "Invalid email address");
			extentTest.log(LogStatus.INFO, "Validation message 'Invalid email address' should display.");

		}
		
		//--------------------------------------------------------------------------------------------------
		
		@Test(priority = 7)

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
			driver.navigate().back();
			Assert.assertEquals(getText, "Password length must be more than 8 characters");
			extentTest.log(LogStatus.INFO, "Validation message 'Password length must be more than 8 characters' should display.");

		}
		
		//----------------------------------------------------------------------------------------
		
		
		@Test(priority = 8)

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
			driver.navigate().back();
			Assert.assertEquals(getText, "Password length must be more than 8 characters");
			extentTest.log(LogStatus.INFO, "Validation message 'Password length must be more than 8 characters' should display.");

		}
		
		//---------------------------------------------------------------------------------------------------
		
		@Test(priority = 9)

		public static void Jak_0022() {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			extentTest = extentReport.startTest("Jak_0022", "Dropdown list should be open to select the country code.");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
			//byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
			//byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
			//byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
			//driver.hideKeyboard();
			byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
			//byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
			String getText = byXpath.getText(xpath_SignupScreenCountryDDLTitle,
					"Getting the title of country code popup");
			driver.navigate().back();
			driver.navigate().back();
			Assert.assertEquals(getText, "Select your country");
			
			extentTest.log(LogStatus.INFO, "Dropdown list should be open to select the country code.");

			}
		
		//-----------------------------------------------------------------------------------------------------------
		
		@Test(priority = 10)
	    
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
			driver.navigate().back();
			Assert.assertEquals(getText, "Please enter valid phone number");
			
			extentTest.log(LogStatus.INFO, "Validation message 'Please enter valid phone no.' should display.");
			}
		
		//------------------------------------------------------------------------------------------------------
		
		
		@Test(priority = 11)

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
			driver.navigate().back();
			Assert.assertEquals(getText, "The mobile number is invalid");
			extentTest.log(LogStatus.INFO, "Validation message 'The mobile number is invalid' should display.");
			}
		
		//--------------------------------------------------------------------------------------------------------
		
		@Test(priority = 12)

		public static void Jak_0025() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			extentTest = extentReport.startTest("Jak_0025", "Validation message 'PhoneNumber has been used' should display.");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
			byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
			byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail2, "Enter valid email under field");
			byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
			
			// ------- Select Country code.
			
	        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
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
			
			byId.clearThenSetText(id_SignupScreenPhonedField,excel.getCellData("Info", "PhoneNumber", 2), "Enter duplicate phone under field");
			driver.hideKeyboard();
			
			byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_SignupScreenDuplicatePhoneValidation)));
			String getText = byXpath.getText(xpath_SignupScreenDuplicatePhoneValidation,
				"Getting the validation message for duplicate phone");
			driver.navigate().back();
			Assert.assertEquals(getText, "PhoneNumber has been used");
			extentTest.log(LogStatus.INFO, "Validation message 'PhoneNumber has been used' should display.");
			
			}
		
		//---------------------------------------------------------------------------------------------
		
		@Test(priority = 13)

		public static void Jak_0026() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			extentTest = extentReport.startTest("Jak_0026", "Validation message should display for already exist email address.");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id_LoginPageCreateAccountLink))).click();
			byId.clearThenSetText(id_SignupScreenNameField, value_SignupScreenNameField, "Enter name under field");
			byId.clearThenSetText(id_SignupScreenEmailField, value_SignupScreenvalidEmail1, "Enter valid email under field");
			byId.clearThenSetText(id_SignupScreenPasswordField, value_SignupScreenvalidPassword, "Enter valid password under field");
			
			// ------- Select Country code.
			
	        byId.click(id_SignupScreenCountryDDL, "Click on the country DDL");
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
			
			byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenValidPhone2, "Enter new phone under field");
			driver.hideKeyboard();
			
			byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_SignupScreenDuplicatePhoneValidation)));
			String getText = byXpath.getText(xpath_SignupScreenDuplicatePhoneValidation,
				"Getting the validation message for duplicate phone");
			Assert.assertEquals(getText, "PhoneNumber has been used");
			extentTest.log(LogStatus.INFO, "Validation message should display for already exist email address.");
			
			}
		
	@Test(priority = 14)
	public void Jak_0001() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0001","Login Page should display after launching the app");
		Thread.sleep(15000);
		List<WebElement> getEle = driver.findElements(By.xpath("//"+className_LoginPageLogo+"[@index='0']"));
		int getSize = getEle.size();
		System.out.println("size is =" +getEle);
		Assert.assertEquals(getSize, 3, "Logo is missing on Login page");
		extentTest.log(LogStatus.INFO, "Verified, Login Page is displaying after launching the app");
		}

	@Test(priority = 15)
	public void Jak_0002() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0002","Login Page should have following fields: App Logo, Enter Email, Facebook Button, Google+ Button and Create Account Link");
		Thread.sleep(15000);
		List<WebElement> getEle = driver.findElements(By.xpath("//"+className_LoginPageLogo+"[@index='0']"));
		int getSize = getEle.size();
		int getEmail = byId.getSize(id_LoginPageEnterEmailTB, "Get Size if 'Enter Email' field exists on Login screen");
		int getFacebbbok = byId.getSize(id_LoginPageFacebookBtn, "Get Size if 'Facebook' button exists on Login screen");
		int getGoogle = byId.getSize(id_LoginPageGoogleBtn, "Get Size if 'Google' button exists on Login screen");
		int getCreateAccLink = byId.getSize(id_LoginPageCreateAccountLink, "Get Size if 'Create Account' link exists on Login screen");
		softAssert.assertEquals(getSize, 3, "Logo is missing on Login page");
		softAssert.assertEquals(getEmail, 1, "'Enter Email' field is missing on Login page");
		softAssert.assertEquals(getFacebbbok, 1, "'Facebook' Button is missing on Login page");
		softAssert.assertEquals(getGoogle, 1, "'Google' Button is missing on Login page");
		softAssert.assertEquals(getCreateAccLink, 1, "'Create Account' Link is missing on Login page");
		softAssert.assertAll();
		extentTest.log(LogStatus.INFO, "Verified, Login Page have following fields: App Logo, Enter Email, Facebook Button, Google+ Button and Create Account Link");
		}
	
	@Test(priority = 16)
	public void Jak_0003() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0003","Tap on Next Icon Adjacent to 'Enter Email' field >> User should redirect on SignUp screen");
		Thread.sleep(15000);
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(10000);
		String getHeaderName = byId.getText(id_SignupScrHeader, "Get Header name of SignUp screen");
		byClassName.click("android.widget.ImageButton", "Click on 'Back' icon from top left of signup screen");
		Thread.sleep(10000);
		Assert.assertEquals(getHeaderName, "SIGN UP", "User is not redirecting on SignUp screen/ Header is missing for SignUp screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on Next Icon Adjacent to 'Enter Email' field >> User should redirect on SignUp screen");
		}
	
	@Test(priority = 17)
	public void Jak_0004() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0004","Enter invalid Email address in 'Enter Email' field >> User should redirect on SignUp screen");
		byId.clearThenSetText(id_LoginPageEnterEmailTB, value_InvalidEmailID, "Enter invalid Email address in 'Enter Email' field");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(10000);
		String getHeaderName = byId.getText(id_SignupScrHeader, "Get Header name of SignUp screen");
		byClassName.click("android.widget.ImageButton", "Click on 'Back' icon from top left of signup screen");
		Thread.sleep(10000);
		Assert.assertEquals(getHeaderName, "SIGN UP", "User is not redirecting on SignUp screen/ Header is missing for SignUp screen");
		extentTest.log(LogStatus.INFO, "Verified, Enter invalid Email address in 'Enter Email' field >> User should redirect on SignUp screen");
		}
	
	@Test(priority = 18)
	public void Jak_0005() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0005","Tap on 'Create Account' Link >> User should redirect on SignUp screen");
		//Thread.sleep(15000);
		byId.click(id_LoginPageCreateAccountLink, "Tap on 'Create Account' Link");
		Thread.sleep(10000);
		String getHeaderName = byId.getText(id_SignupScrHeader, "Get Header name of SignUp screen");
		byClassName.click("android.widget.ImageButton", "Click on 'Back' icon from top left of signup screen");
		Thread.sleep(10000);
		Assert.assertEquals(getHeaderName, "SIGN UP", "User is not redirecting on SignUp screen/ Header is missing for SignUp screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Create Account' Link >> User should redirect on SignUp screen");
		}
	
	@Test(priority = 19)
	public void Jak_0007() throws InterruptedException, MalformedURLException{
		extentTest = extentReport.startTest("Jak_0007","Tap on 'Facebook' Button >> Facebook app login page should display");
		Thread.sleep(15000);
	    byId.click(id_LoginPageFacebookBtn, "Tap on 'Facebook' Button");
		Thread.sleep(10000);
		int getSize = byId.getSize(id_FacebookLoginPageLayout, "Get size if Facebook app login Screen is displayed");
		driver.navigate().back();
		Assert.assertEquals(getSize, 1, "User is not redirecting on Facebook app login Screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Facebook' Button >> Facebook app login page should display");
		}
	
	@Test(priority = 21)
	public void Jak_0006() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0006","Tap on 'Facebook' Button >> Facebook login page should display in browser");
		Thread.sleep(15000);
		driver.removeApp("com.facebook.katana");
		byId.click(id_LoginPageFacebookBtn, "Tap on 'Facebook' Button");
		Thread.sleep(10000);
		int getSize = byXpath.getSize("//android.widget.ImageView[@index='1']", "Get Size of cross icon if facebook Login page opended in browser");
		Assert.assertEquals(getSize, 1, "User is not redirecting on Facebook login page on browser");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Facebook' Button >> Facebook login page should display in browser");
		}
	
	@Test(priority = 21)
	public void Jak_0009() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0009","Tap on 'GOOGLE+' Button >> 'Choose account for Jak popup should display.");
		Thread.sleep(15000);
		byId.click(id_LoginPageGoogleBtn, "Tap on 'GOOGLE+' Button");
		Thread.sleep(10000);
		String getHeader = byId.getText(id_GooglePopupTitle, "Get popup Header displayed clicking on 'Google+' button from login screen");
		driver.navigate().back();
		Assert.assertEquals(getHeader, "Choose account for Jak", "'Choose account for Jak' popup is not displayed clicking on 'Google+' button from login screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'GOOGLE+' Button >> 'Choose account for Jak popup should display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 22)
	public void Jak_0013() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0013","Login Scree >> Enter Valid email and tap on next icon >> tap on Next button without entering password field >> Validation message 'Password length must be more than 8 characters' should be display");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_SignupScrPasswordNextIcon, "Tap on Next Icon Adjacent to 'Enter Password' field");
		String getText = byId.getText(id_ForgotPwdScrValidationMsgs, "Get validation message");
		driver.navigate().back();
		Assert.assertEquals(getText, validationMsg_ResetPasswordPwdLength, "No 'Password length must be more than 8 characters' validation message is displayed");
		extentTest.log(LogStatus.INFO, "Verified, Login Scree >> Enter Valid email and tap on next icon >> tap on Next button without entering password field >> Validation message 'Password length must be more than 8 characters' should be display");
		}
	
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 23)
	public void Jak_0014() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0014","Login Scree >> Enter Valid email and tap on next icon >> Enter wrong password and tap on Next button >> Validation message 'Login is invalid' should display");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.clearThenSetText(id_LoginPageEnterPasswordTB, value_InvalidPhoneNo, "Enter wrong password in 'Enter Password' field on login page");
		byId.click(id_SignupScrPasswordNextIcon, "Tap on Next Icon Adjacent to 'Enter Password' field");
		Thread.sleep(3000);
		String getText = byId.getText(id_ForgotPwdScrValidationMsgs, "Get validation message");
		driver.navigate().back();
		Assert.assertEquals(getText, validationMsg_LoginPageWrongPassword, "No 'Login is invalid' validation message is displayed");
		extentTest.log(LogStatus.INFO, "Verified, Login Scree >> Enter Valid email and tap on next icon >> Enter wrong password and tap on Next button >> Validation message 'Login is invalid' should display");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	//Enter Valid Password
	@Test(priority = 24)
	public void Jak_0015() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0015","Login Scree >> Enter Valid email and tap on next icon >> Enter Valid password and tap on Next button >> User should be successfully logged into the app.");
		Thread.sleep(15000);
		CommonFunctions.Login("jasmeet@yopmail.com", "mind@123");
		/*byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.clearThenSetText(id_LoginPageEnterPasswordTB, "mind@123", "Enter valid password in 'Enter Password' field on login page");
		byId.click(id_SignupScrPasswordNextIcon, "Tap on Next Icon Adjacent to 'Enter Password' field");*/
		Thread.sleep(10000);
		String getText = byId.getText(id_LandingScrTitle, "Get Title of Landing screen");
		Thread.sleep(5000);
		CommonFunctions.Logout();
		Assert.assertEquals(getText, "New request", "Title/Header name is missing on landing page or User is unable to login into Jak app");
		extentTest.log(LogStatus.INFO, "Verified, Login Scree >> Enter Valid email and tap on next icon >> Enter Valid password and tap on Next button >> User should be successfully logged into the app.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 25)
	public void Jak_0030_1() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0030_1","Tap on 'Forgot password' link  >> User should be redirect to 'Reset Password' screen");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		Thread.sleep(5000);
		String getHeader = byId.getText(id_SignupScrHeader, "Get Header title of forgot password screen");
		driver.navigate().back();
		Assert.assertEquals(getHeader, "RESET PASSWORD", "'RESET PASSWORD' Header is missing or user is not redirecting on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Forgot password' link >> 'Choose account for Jak popup should display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 26)
	public void Jak_0030_2() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0030_2","Tap on 'Forgot password' link  >> Email and SMS options should display");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		String getEmailText = byId.getText(id_ForgotPwdScrEmailLbl, "Get 'Email' label from forgot password screen");
		String getSMSText = byId.getText(id_ForgotPwdScrSMSLbl, "Get 'SMS' label from forgot password screen");
		driver.navigate().back();
		softAssert.assertEquals(getEmailText, "Email", "'Email' option is missing on 'RESET PASSWORD' screen");
		softAssert.assertEquals(getSMSText, "SMS", "'SMS' option is missing on 'RESET PASSWORD' screen");
		softAssert.assertAll();
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Forgot password' link >> Email and SMS options should display");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 27)
	public void Jak_0031() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0031","Tap on 'Send' button without enter email  >> Validation message 'Invalid email address' should display");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get validation message");
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ForgotPwdScrInvalidEmailID, "No validation message is displaying for blank email field/ validation message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Send' button without enter email  >> Validation message 'Invalid email address' should display");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 28)
	public void Jak_0032() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0032","Enter invalid email address and tap on 'Send' button >> Validation message 'Invalid email address' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "test", "Enter invalid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get validation message");
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ForgotPwdScrInvalidEmailID, "No validation message is displaying for invalid email address/ validation message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Enter invalid email address and tap on 'Send' button >> Validation message 'Invalid email address' should display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 29)
	public void Jak_0033() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0032","Enter non-existing email address and tap on 'Send' button >> Validation message 'email is invalid' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "test@yopmail.com", "Enter invalid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		Thread.sleep(3000);
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get validation message");
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ForgotPwdScrNonExistEmailID, "No validation message is displaying by entering non-existing email address in email field/ validation message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Enter non-existing email address and tap on 'Send' button >> Validation message 'email is invalid' should display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time.
	@Test(priority = 30)
	public void Jak_0035() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0035","Reset Password Screen >> Tap on 'Reset' button >> Validation message 'Reset password code can not be empty' should be display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "jasmeet@yopmail.com", "Enter valid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		Thread.sleep(3000);
		byId.click(id_ForgotPwdScrSendBtn, "Tap on 'RESET' button on Reset password screen without filling any fields");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message on Reset password screen");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordResetPwdCodeEmptyTB, "No validation message is displaying clicking on 'RESET' button without filling any field on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Tap on 'Reset' button >> Validation message 'Reset password code can not be empty' should be display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	// Get Reset code from Email API and use in this test case
	@Test(priority = 31)
	public void Jak_0036() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0036","Reset Password Screen >> Enter reset code >> Tap on 'Reset' button without enter new and confirm password >> Validation message 'Password length must be more than 8 characters' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "jasmeet@yopmail.com", "Enter valid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		Thread.sleep(3000);
		byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, "3E5Be5y", "Enter Reset Code in Password Reset Code field");
		byId.click(id_ForgotPwdScrSendBtn, "Tap on 'RESET' button on Reset password screen without filling any fields");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message on Reset password screen");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordPwdLength, "No validation message is displaying on 'RESET PASSWORD' screen/ Message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Enter reset code >> Tap on 'Reset' button without enter new and confirm password >> Validation message 'Password length must be more than 8 characters' should display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	// Get Reset code from Email API and use in this test case
	@Test(priority = 32)
	public void Jak_0037() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0037","Reset Password Screen >> Enter reset code and password >> Tap on 'Reset' button without enter confirm password >> Validation message 'Password confirmation must match password' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "jasmeet@yopmail.com", "Enter valid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		Thread.sleep(3000);
		byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, "3E5Be5y", "Enter Reset Code in Password Reset Code field");
		byId.clearThenSetText(id_ResetPasswordPwdNewPwdTB, value_Password, "Enter new password in 'New Password' field");
		byId.click(id_ForgotPwdScrSendBtn, "Tap on 'RESET' button on Reset password screen ");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message on Reset password screen");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordPwdMatching, "No validation message is displaying on 'RESET PASSWORD' screen/ Message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Enter reset code and password >> Tap on 'Reset' button without enter confirm password >> Validation message 'Password confirmation must match password' should display.");
		}
		
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	// Get Reset code from Email API and use in this test case
	@Test(priority = 33)
	public void Jak_0038() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0038","Reset Password Screen >> Enter reset code and Enter mismatch password and Tap on 'Reset' button >> Validation message 'Password confirmation must match password' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "jasmeet@yopmail.com", "Enter valid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		Thread.sleep(3000);
		byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, "3E5Be5y", "Enter Reset Code in Password Reset Code field");
		byId.clearThenSetText(id_ResetPasswordPwdNewPwdTB, value_Password, "Enter new password in 'New Password' field");
		byId.clearThenSetText(id_ResetPasswordPwdConfirmPwdTB, value_Password, "Enter Confirm password in 'Confirm password' field");
		driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		byId.click(id_ForgotPwdScrSendBtn, "Tap on 'RESET' button on Reset password screen ");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message on Reset password screen");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordPwdMatching, "No validation message is displaying on 'RESET PASSWORD' screen/ Message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Enter reset code and Enter mismatch password and Tap on 'Reset' button >> Validation message 'Password confirmation must match password' should display.");
	}
		
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 34)
	public void Jak_0039() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0039","Reset Password Screen >> Enter invalid reset code, matched new and confirmation password and Tap on 'Reset' button >> Validation message 'Password token is invalid' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "jasmeet@yopmail.com", "Enter valid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		Thread.sleep(3000);
		byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, "3E5Be5y", "Enter Reset Code in Password Reset Code field");
		byId.clearThenSetText(id_ResetPasswordPwdNewPwdTB, value_Password, "Enter new password in 'New Password' field");
		byId.clearThenSetText(id_ResetPasswordPwdConfirmPwdTB, value_Password, "Enter Confirm password in 'Confirm password' field");			byId.click(id_ForgotPwdScrSendBtn, "Tap on 'RESET' button on Reset password screen ");
		Thread.sleep(3000);
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message on Reset password screen");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordInvalidToken, "No validation message is displaying on 'RESET PASSWORD' screen/ Message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Enter invalid reset code, matched new and confirmation password and Tap on 'Reset' button >> Validation message 'Password token is invalid' should display.");
	}
		
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	// Get Reset code from Email API and use in this test case
	@Test(priority = 35)
	public void Jak_0040() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0040","Reset Password Screen >> Enter valid reset code, matched new and confirmation password and Tap on 'Reset' button >> Confirmation message display 'Password reset successfully' and user should again redirect to back screen.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "jasmeet@yopmail.com", "Enter valid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		Thread.sleep(3000);
		byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, "729967", "Enter Reset Code in Password Reset Code field");
		byId.clearThenSetText(id_ResetPasswordPwdNewPwdTB, value_Password, "Enter new password in 'New Password' field");
		byId.clearThenSetText(id_ResetPasswordPwdConfirmPwdTB, value_Password, "Enter Confirm password in 'Confirm password' field");
		byId.click(id_ForgotPwdScrSendBtn, "Tap on 'RESET' button on Reset password screen ");
		Thread.sleep(2000);
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message on Reset password screen");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordPwdResetsuccessfully, "No 'Password reset successfully' validation message is displaying on 'RESET PASSWORD' screen/ Message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Enter valid reset code, matched new and confirmation password and Tap on 'Reset' button >> Confirmation message display 'Password reset successfully' and user should again redirect to back screen.");
	}
		
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 36)
	public void Jak_0041() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0041","Reset Password Screen >> Select 'SMS' option >> Phone field should be display to user");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.click(id_ForgotPwdScrSMSLbl, "Click on SMS radio button");
		int getSize = byId.getSize(id_ForgotPwdScrPhoneTB, "Get size if phone field displayed clicking on SMS radio button");
		driver.navigate().back();
		Assert.assertEquals(getSize, 1, "'Phone' field is not displayed clicking on SMS radio button on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Select 'SMS' option >> Phone field should be display to user");
	}
		
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 37)

	

	public void Jak_0042() throws InterruptedException{

		extentTest = extentReport.startTest("Jak_0042","Reset Password Screen >> Select 'SMS' option and Tap on send button without enter phone no.>> Validation message 'Phone can not be empty' should be display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.click(id_ForgotPwdScrSMSLbl, "Click on SMS radio button");
		byId.clearThenSetText(id_ForgotPwdScrPhoneTB, "", "Clear Number from Phone field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on 'SEND' Button on 'RESET PASSWORD' screen");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message after tap on send button without enter phone no.");
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordPwdEmptyPhone, "No 'Phone can not be empty' validation message is displaying tap on send button without enter phone no.");
		
			/*Thread.sleep(15000);
			driver.startActivity("com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
			Thread.sleep(5000);
			String gettext = byId.getText(id_MessageAppFirstMsgContent, "get Message content for recently recieved message from Message app");
			String[] arr = gettext.split(" ");
			driver.navigate().back();
			byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, arr[4], "Enter OTP in 'Password Reset Code' field");
			byId.clearThenSetText(id_ResetPasswordPwdNewPwdTB, value_Password, "Enter New Password in 'New Password' field");
			byId.clearThenSetText(id_ResetPasswordPwdConfirmPwdTB, value_Password, "Enter Confirm Password in 'Confirm Password' field");
			byId.click(id_ForgotPwdScrSendBtn, "Click on 'Reset' Button");
			
			Thread.sleep(15000);
			int getSize = byId.getSize(id_ForgotPwdScrPhoneTB, "Get size if phone field displayed clicking on SMS radio button");
			driver.navigate().back();
			Assert.assertEquals(getSize, 1, "'Phone' field is not displayed clicking on SMS radio button on 'RESET PASSWORD' screen");
			*/
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Select 'SMS' option and Tap on send button without enter phone no.>> Validation message 'Phone can not be empty' should be display.");
	}
				
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 38)
	public void Jak_0043() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0043","Reset Password Screen >> Select 'SMS' option and Tap on send button on entering Invalid phone no.>> Validation message 'Phone is invalid' should be display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.click(id_ForgotPwdScrSMSLbl, "Click on SMS radio button");
		byId.clearThenSetText(id_ForgotPwdScrPhoneTB, value_InvalidPhoneNo, "Clear Number from Phone field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on 'SEND' Button on 'RESET PASSWORD' screen");
		Thread.sleep(3000);
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message after tap on send button entering Invalid phone no.");
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordPwdInvalidPhoneNo, "No 'Phone can not be empty' validation message is displaying tap on send button on entering Invalid phone no.");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Select 'SMS' option and Tap on send button on entering Invalid phone no.>> Validation message 'Phone is invalid' should be display.");
		}
	
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 39)
	public void Jak_0044() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0044","Reset Password Screen >> Select 'SMS' option >> Enter Valid Phone No. and Tap on send button>> Reset Password OTP code should sent to the number");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.click(id_ForgotPwdScrSMSLbl, "Click on SMS radio button");
		byId.clearThenSetText(id_ForgotPwdScrPhoneTB,excel.getCellData("Info", "PhoneNumber", 2), "Enter valid PhoneNumber in Phone field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on 'SEND' Button on 'RESET PASSWORD' screen");
		Thread.sleep(5000);
		driver.startActivity("com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
		Thread.sleep(8000);
		String gettext = byId.getText(id_MessageAppFirstMsgContent, "get Message content for recently recieved message from Message app");
		String[] arr = gettext.split(" ");
		driver.navigate().back();
		byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, arr[4], "Enter OTP in 'Password Reset Code' field");
		String getAttrib = driver.getPageSource();
		System.out.println("Page Source = " +getAttrib);
		String getAttri = byId.getAttribute(id_ResetPasswordPwdResetCodeTB, "text", "Get value from Reset Password Code field");
		System.out.println("Page Source = " +getAttri);
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getAttri, arr[4], "Reset Password OTP is not Recieved on provided phone no.");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Select 'SMS' option >> Enter Valid Phone No. and Tap on send button>> Reset Password OTP code should sent to the number");
	}
	
	//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 40)
	public void Jak_0045() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0045","Reset Password Screen >> Tap on 'I already have reset code' link>> user should be redirect to next screen.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.click(id_ForgotPwdScrSMSLbl, "Click on SMS radio button");
		byId.click(id_ResetPasswordPwdIAlreadyHaveResetCodeLink, "Click on 'I Already Have Reset Code' Link");
		int getSize = byId.getSize(id_ResetPasswordPwdResetCodeTB, "Get size of 'Password Reset Code' field");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(getSize, 1, "User is not redirecting to next screen tapping on 'I already have reset code' link");
		extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Tap on 'I already have reset code' link>> user should be redirect to next screen.");
		}
	}
