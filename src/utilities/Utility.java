package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
/*
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

*/
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

import frameworkGlobals.InitializeDriver;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;




public class Utility extends InitializeDriver {/*
	static Dimension dimensions = driver.manage().window().getSize();
	static Double screenHeightStart = dimensions.getHeight() * 0.5;
	static int scrollStart = screenHeightStart.intValue();
	static Double screenHeightEnd = dimensions.getHeight() * 0.2;
	static int scrollEnd = screenHeightEnd.intValue();*/


	public void scrollUp() {
		try {
			// common method for login,
		//	extentTest = extentReport.startTest("scroll up screen", "scroll up screen");
		   // driver.swipe(0,scrollStart,0,scrollEnd,2000);
			Thread.sleep(3000);
         //   extentTest.log(LogStatus.PASS, "screen gets scrolled");
	} 
		
		catch (Exception e) {
			
			throw new java.lang.RuntimeException(e);
		}
	}
	
	
	
	
	/*public static void sendMail(String to, String from, String subject, String msg)
	{
	      String host = "webmail.seasiainfotech.com"; //"smtp.seasiainfotech.com";
	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject(subject);
	         message.setText(msg);
	         
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException ex) {
	         ex.printStackTrace();
	      }
		
	}*/

	
	public void takeScreenshot(String SSname) {
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			String screenShotPath=System.getProperty("user.dir") + "\\LogsAndReports\\Reports_"+extentDate+"\\Screenshots\\";
			FileUtils.copyFile(scrFile, new File(screenShotPath+SSname+".png")); 
			imgeHtmlPath=extentTest.addScreenCapture(screenShotPath+SSname+".png").replace(screenShotPath, "Screenshots\\").replace("file:///", "").replace("<img", "<img width=\"150\" height=\"70\"");                                
      
		} catch (IOException e) {
			throw new java.lang.RuntimeException("RUNTIME_ERROR : : Exception occur during take ScreenShot: "+SSname);
		}
		System.out.println("Screenshot has been generated for " +SSname);		    
	}

	public String getCurrentDateTime (String format){
	String timeStamp = new SimpleDateFormat(format).format(new Date());
	return timeStamp;
	}
	
	public String uniqueNo() {
		return getCurrentDate("HHmmss");
		//new SimpleDateFormat("HHmmss").format(new Date());
		//+Long.toString(System.currentTimeMillis());
	}
		
	public String uniqueNumString() {
		String string = RandomStringUtils.random(6, true, true);
		return (string.replaceAll("[^A-Za-z]", ""));
	}
	
	public String getCurrentDate(String dateFormate) {
		return new SimpleDateFormat(dateFormate).format(new Date());
	}
	
	public File getLatestFileFromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	/*public boolean goTo(String subURL, String actionInfo)
	{
		getDriver().get(GlobalComponents.appURL+subURL);
		String title = getDriver().getTitle();
		if(title.contains("Not Found")||title.contains("404")||title.contains("Problem loading page")||
				title.contains("Error"))
		{
			extentTest.log(LogStatus.INFO, actionInfo +" can't happen due to error in page loading");
			return false;
		}
		else {
			extentTest.log(LogStatus.INFO, actionInfo +" Page Open successfully");
			return true;
			}						
	}
	
	public String getTitle()
	{
		extentTest.log(LogStatus.INFO, "Title extracted by 'utilities.getTitle()' function");
		return getDriver().getTitle();
	}
	*/
	public  boolean uploadFiles(String filePath) {
		try {
			
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(filePath);
			System.out.println(filePath);
			Thread.sleep(2000);
			clipboard.setContents(stringSelection, null);
			Thread.sleep(3000);
           Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			/*
			 * robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_O);
			 * robot.keyRelease(KeyEvent.VK_O);
			 * robot.keyRelease(KeyEvent.VK_ALT);
			 */
			Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
			// TODO: handle exception
		}
	}



}
