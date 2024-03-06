package com.Automation.listeners;



import com.Automation.helper.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	    
	    static ExtentReports extent;
	    
	    public static ExtentReports getInstance()
	    {
	    	if (extent == null) 
	    	{
	    		extent=createInstance();
	    	
	    		return extent;	
	    	}
		    else
		    	{
		    		return extent;
		    	}	
	   }
	    
	    
	    public static ExtentReports createInstance() 
	    {
	    	
	    	String htmlPath=System.getProperty("user.dir")+"\\Reports\\Automation_"+Utility.captureCurrentDateAndTime()+".html";
	    	
	    	System.out.println("Report path "+htmlPath);
	    	
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(htmlPath); 
	        
	        sparkReporter .config().setTheme(Theme.DARK);
	        
	        sparkReporter .config().setReportName("Sprint 1 Report");
	        
	        sparkReporter .config().setDocumentTitle("Automation Report");
	        
	        ExtentReports extent=new ExtentReports();
	  
	       
	        extent.attachReporter(sparkReporter);
	        
	
	        return extent;
	    }
}
