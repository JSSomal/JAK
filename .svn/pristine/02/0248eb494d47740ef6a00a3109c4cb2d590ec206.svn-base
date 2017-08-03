package interfaces;

import java.text.SimpleDateFormat;
import java.util.Date;


import frameworkGlobals.*;
import utilities.SetLogs;
import utilities.Utility;
import utilities.Xls_Reader;
public interface ClassObject {
	
	public static String extentDate = new SimpleDateFormat("dd_MM_yyyy").format(new Date());
	public ByClassName byClassName=new ByClassName();
	public ById byId = new ById();
	public ByXpath byXpath=new ByXpath();
	public SetLogs setLogs = new SetLogs();
	
	
	public Utility utility=new Utility();
	public Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\PreSettings.xlsx");
	
	public InitializeDriver browserSelection = new InitializeDriver();
	
//--------------------------------get current project name------------------------------------
	public int indexDir = System.getProperty("user.dir").lastIndexOf('\\');
	public String currentProjectName=System.getProperty("user.dir").substring(indexDir +1);	
//--------------------------------connection----------------------------------------------------	
	public String hostUserPswd="jdbc:sqlserver://10.8.18.112\\MSSQLSERVER2;user=automation;password=ind#123;database=testingqa";
	
	
}
