package customer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkGlobals.InitializeDriver;
import objectRepository.iCustomer;

public class CommonFunctions extends InitializeDriver implements iCustomer{
	
	public static void Logout() throws InterruptedException
	{
		byClassName.click(className_LandingScrMenuIcon, "Tap on Menu icon");
		//byXpath.click("//co.jakapp.customer:id/toolbar[@index='0']", "Tap on Menu icon");
		Thread.sleep(2000);
		byXpath.click("//android.widget.CheckedTextView[@text='LOGOUT']", "Tap on Logout link");
		Thread.sleep(10000);
	}
	
	public static void SignUp() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 45);
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
		byId.clearThenSetText(id_SignupScreenPhonedField, value_SignupScreenValidPhone1, "Enter valid phone under field");
		driver.hideKeyboard();
		byId.click(id_SignupScreenSignupButton, "Click on SignUp button");
	}
	
	public static void Login(String userName, String password) throws InterruptedException
	{
		byId.clearThenSetText(id_LoginPageEnterEmailTB, userName, "Enter valid email address in email text field on login page");
		byXpath.click("//"+className_LoginPageLogo+"[@index='1']", "Tap on Next Icon Adjacent to 'Enter Email' field");
		Thread.sleep(8000);
		byId.clearThenSetText(id_LoginPageEnterPasswordTB, password, "Enter valid password in 'Enter Password' field on login page");
		byId.click(id_SignupScrPasswordNextIcon, "Tap on Next Icon Adjacent to 'Enter Password' field");
	}
}
