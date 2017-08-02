/**
 * 
 */
package interfaces;

/** This interface contains global variables, address, and properties that is being used in the system.
 * @author arajput
 * @version V2.0
 * 
 */
public interface GlobalComponents {
	
	// Ssystem's global variables and data.
	public String browser = "MF";
	public String appURL = "http://phpdemo.seasiainfotech.com:9040/ilook/qa_automation/";
	public String appURLAdmin = "http://phpdemo.seasiainfotech.com:9040/ilook/qa_automation/admin";

	public String userName = "arajput@yopmail.com";
	public String password = "mind@123";
	
	
	// Property file address
	public String globalData = "AppProperties/GlobalData.properties";
	
	
	// Browser executables address
	public String mozillaGeckoDriver = "/BrowserExecutables/geckodriver-v0.11.1-win64.exe";
	public String chromeExecutable = "/BrowserExecutables/chromedriver_win32.exe";
	public String ieExecutable = "/BrowserExecutables/IEDriverServer_Win32_2.53.1.exe";
	public String msEdgeExecutable = "";
	public String safariExrcutable = "";
	}