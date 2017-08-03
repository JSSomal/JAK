package customer;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import frameworkGlobals.InitializeDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectRepository.iCustomer;

public class LoginAndForgotPswd extends InitializeDriver implements iCustomer{
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 0)
	public void Jak_0001() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0001","Login Page should display after launching the app");
		Thread.sleep(15000);
		List<WebElement> getEle = driver.findElements(By.xpath("//"+className_LoginPageLogo+"[@index='0']"));
		int getSize = getEle.size();
		System.out.println("size is =" +getEle);
		Assert.assertEquals(getSize, 3, "Logo is missing on Login page");
		extentTest.log(LogStatus.INFO, "Verified, Login Page is displaying after launching the app");
		}

	@Test(priority = 1)
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
	
	@Test(priority = 2)
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
	
	@Test(priority = 3)
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
	
	@Test(priority = 4)
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
	
	@Test(priority = 5)
	public void Jak_0007() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0007","Tap on 'Facebook' Button >> Facebook app login page should display");
		//Thread.sleep(15000);
		byId.click(id_LoginPageFacebookBtn, "Tap on 'Facebook' Button");
		Thread.sleep(10000);
		int getSize = byId.getSize(id_FacebookLoginPageLayout, "Get size if Facebook app login Screen is displayed");
		driver.navigate().back();
		Assert.assertEquals(getSize, 1, "User is not redirecting on Facebook app login Screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Facebook' Button >> Facebook app login page should display");
		}
	
/*	@Test(priority = 7)
	public void Jak_0008() throws InterruptedException, MalformedURLException{
		extentTest = extentReport.startTest("Jak_0008","Tap on 'Facebook' Button >> User should redirect on SignUp Page with pre-filled Name and Email fields.");
		Thread.sleep(15000);
		driver.startActivity("com.facebook.katana", "com.facebook.katana.LoginActivity");
		Thread.sleep(10000);
		driver.findElement(By.id("com.facebook.katana:id/login_username")).sendKeys("testing.gsingh13@gmail.com");
		Thread.sleep(5000);
		byId.click("com.facebook.katana:id/login_password", "Click on id");
		//driver.pressKeyCode(66);//("mobile:keyevent", "keycode:66");
		//driver.longPressKeyCode(AndroidKeyCode.ENTER);
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.id("com.facebook.katana:id/login_password"))).perform();
		driver.findElement(By.id("com.facebook.katana:id/login_password")).sendKeys("mind@123");
		driver.longPressKeyCode(AndroidKeyCode.ENTER);
		//action.moveToElement(driver.findElement(By.id("com.facebook.katana:id/login_login"))).click().perform();
		driver.findElement(By.id("com.facebook.katana:id/login_login")).click();
		
		byId.clearThenSetText(id_FacebookAppLoginScrUsernameTB, "testing.gsingh13@gmail.com", "Enter Username in 'Username' textbox on facebook login screen");
		byId.click("com.facebook.katana:id/login_password", "Click on Email in list");
        byId.clearThenSetText(id_FacebookAppLoginScrPasswordTB, "mind@123", "Enter Password in 'Password' textbox on facebook login screen");
        byId.click(id_FacebookAppLoginScrLoginBtn, "Click on 'Login' button on facebook login screen");
        Thread.sleep(20000);
        byId.click("com.facebook.katana:id/button2", "Click on Id");
        byId.click("u_0_9", "Click on 'Continue' button");
        driver.navigate().back();
		byId.click(id_LoginPageFacebookBtn, "Tap on 'Facebook' Button");
		Thread.sleep(10000);
		String getHeader = byId.getText(id_GooglePopupTitle, "Get popup Header displayed clicking on 'Google+' button from login screen");
		Assert.assertEquals(getHeader, "Choose account for Jak", "'Choose account for Jak' popup is not displayed clicking on 'Google+' button from login screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Facebook' Button >> User should redirect on SignUp Page with pre-filled Name and Email fields.");
		}*/
	
	@Test(priority = 6)
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
	@Test(priority = 8)
	public void Jak_0030_1() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0030_1","Tap on 'Forgot password' link  >> User should be redirect to 'Reset Password' screen");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(5000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		String getHeader = byId.getText(id_SignupScrHeader, "Get Header title of forgot password screen");
		driver.navigate().back();
		Assert.assertEquals(getHeader, "RESET PASSWORD", "'RESET PASSWORD' Header is missing or user is not redirecting on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Forgot password' link >> 'Choose account for Jak popup should display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 9)
	public void Jak_0030_2() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0030_2","Tap on 'Forgot password' link  >> Email and SMS options should display");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(5000);
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
	@Test(priority = 10)
	public void Jak_0031() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0031","Tap on 'Send' button without enter email  >> Validation message 'Invalid email address' should display");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(5000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get validation message");
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ForgotPwdScrInvalidEmailID, "No validation message is displaying for blank email field/ validation message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Tap on 'Send' button without enter email  >> Validation message 'Invalid email address' should display");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 11)
	public void Jak_0032() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0032","Enter invalid email address and tap on 'Send' button >> Validation message 'Invalid email address' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(5000);
		byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
		byId.clearThenSetText(id_ForgotPwdScrEmailTB, "test", "Enter invalid email address in 'Email' field");
		byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
		String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get validation message");
		driver.navigate().back();
		Assert.assertEquals(getValiMsg, validationMsg_ForgotPwdScrInvalidEmailID, "No validation message is displaying for invalid email address/ validation message text has been changed on 'RESET PASSWORD' screen");
		extentTest.log(LogStatus.INFO, "Verified, Enter invalid email address and tap on 'Send' button >> Validation message 'Invalid email address' should display.");
		}
	
	// 'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
	@Test(priority = 12)
	public void Jak_0033() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0032","Enter non-existing email address and tap on 'Send' button >> Validation message 'email is invalid' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(5000);
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
	@Test(priority = 13)
	public void Jak_0035() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0035","Reset Password Screen >> Tap on 'Reset' button >> Validation message 'Reset password code can not be empty' should be display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(5000);
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
	@Test(priority = 14)
	public void Jak_0036() throws InterruptedException{
		extentTest = extentReport.startTest("Jak_0036","Reset Password Screen >> Enter reset code >> Tap on 'Reset' button without enter new and confirm password >> Validation message 'Password length must be more than 8 characters' should display.");
		Thread.sleep(15000);
		byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(5000);
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
		@Test(priority = 15)
		public void Jak_0037() throws InterruptedException{
			extentTest = extentReport.startTest("Jak_0037","Reset Password Screen >> Enter reset code and password >> Tap on 'Reset' button without enter confirm password >> Validation message 'Password confirmation must match password' should display.");
			Thread.sleep(15000);
			byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
			byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
			Thread.sleep(5000);
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
		@Test(priority = 16)
		public void Jak_0038() throws InterruptedException{
			extentTest = extentReport.startTest("Jak_0038","Reset Password Screen >> Enter reset code and Enter mismatch password and Tap on 'Reset' button >> Validation message 'Password confirmation must match password' should display.");
			Thread.sleep(15000);
			byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
			byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
			Thread.sleep(5000);
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
		@Test(priority = 17)
		public void Jak_0039() throws InterruptedException{
			extentTest = extentReport.startTest("Jak_0039","Reset Password Screen >> Enter invalid reset code, matched new and confirmation password and Tap on 'Reset' button >> Validation message 'Password token is invalid' should display.");
			Thread.sleep(15000);
			byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
			byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
			Thread.sleep(5000);
			byId.click(id_LoginPageCreateAccountLink, "Click on 'Forgot Password' link");
			byId.clearThenSetText(id_ForgotPwdScrEmailTB, "jasmeet@yopmail.com", "Enter valid email address in 'Email' field");
			byId.click(id_ForgotPwdScrSendBtn, "Click on Send Button on 'Forgot Password' screen");
			Thread.sleep(3000);
			byId.clearThenSetText(id_ResetPasswordPwdResetCodeTB, "3E5Be5y", "Enter Reset Code in Password Reset Code field");
			byId.clearThenSetText(id_ResetPasswordPwdNewPwdTB, value_Password, "Enter new password in 'New Password' field");
			byId.clearThenSetText(id_ResetPasswordPwdConfirmPwdTB, value_Password, "Enter Confirm password in 'Confirm password' field");
			byId.click(id_ForgotPwdScrSendBtn, "Tap on 'RESET' button on Reset password screen ");
			Thread.sleep(2000);
			String getValiMsg = byId.getText(id_ForgotPwdScrValidationMsgs, "Get Validation message on Reset password screen");
			driver.navigate().back();
			driver.navigate().back();
			Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordInvalidToken, "No validation message is displaying on 'RESET PASSWORD' screen/ Message text has been changed on 'RESET PASSWORD' screen");
			extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Enter invalid reset code, matched new and confirmation password and Tap on 'Reset' button >> Validation message 'Password token is invalid' should display.");
		}
		
		//'jasmeet@yopmail.com' static Email ID is used, please replace it with the same email id which has been used at signup time
		// Get Reset code from Email API and use in this test case
		@Test(priority = 18)
		public void Jak_0040() throws InterruptedException{
			extentTest = extentReport.startTest("Jak_0040","Reset Password Screen >> Enter valid reset code, matched new and confirmation password and Tap on 'Reset' button >> Confirmation message display 'Password reset successfully' and user should again redirect to back screen.");
			Thread.sleep(15000);
			byId.clearThenSetText(id_LoginPageEnterEmailTB, "jasmeet@yopmail.com", "Enter valid email address in email text field on login page");
			byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
			Thread.sleep(5000);
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
			driver.navigate().back();
			driver.navigate().back();
			Assert.assertEquals(getValiMsg, validationMsg_ResetPasswordPwdResetsuccessfully, "No 'Password reset successfully' validation message is displaying on 'RESET PASSWORD' screen/ Message text has been changed on 'RESET PASSWORD' screen");
			extentTest.log(LogStatus.INFO, "Verified, Reset Password Screen >> Enter valid reset code, matched new and confirmation password and Tap on 'Reset' button >> Confirmation message display 'Password reset successfully' and user should again redirect to back screen.");
		}
					
	
}
