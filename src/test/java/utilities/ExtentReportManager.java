package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.URL;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkreporter;   //UI of the Report 
	public ExtentReports extent;   //populate common info of the report
	public ExtentTest test;   //Creating test case entries in the report and update stus of the methods 
	
	String repName;
	
	 public void onStart(ITestContext testcontext) {
		 
		 String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 
		 repName="Test-Report-"+timestamp+".html";
		 
		 sparkreporter=new ExtentSparkReporter(".\\reports\\"+ repName);   
		 sparkreporter.config().setDocumentTitle("Automation Testing"); 
		 sparkreporter.config().setReportName("Functional Testing");
		 sparkreporter.config().setTheme(Theme.DARK);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(sparkreporter);		 
		 extent.setSystemInfo("Application","OpenCart");
		 extent.setSystemInfo("module","Admin");
		 extent.setSystemInfo("SubModule","Customers");
		 extent.setSystemInfo("User Name",System.getProperty("user.name"));
		 extent.setSystemInfo("Environment","QA");
		 
		 String os=testcontext.getCurrentXmlTest().getParameter("os");
		 extent.setSystemInfo("operating system", os);
		 
		 String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		 extent.setSystemInfo("browser", browser);
		 
		 List<String> includegroups=testcontext.getCurrentXmlTest().getIncludedGroups();
		 
		 if(!includegroups.isEmpty()) {
			 extent.setSystemInfo("Groups",includegroups.toString());
		 }		 
		 
	 }
	 


	 public void onTestSuccess(ITestResult result) {
		   test=extent.createTest(result.getTestClass().getName());
		   test.assignCategory(result.getMethod().getGroups());
		   test.log(Status.PASS,"Test Case Passed :"+result.getName());
		   
		    
		  }
 
	 public void onTestFailure(ITestResult result) {

		    test=extent.createTest(result.getClass().getName());
		    test.assignCategory(result.getMethod().getGroups());
		    test.log(Status.FAIL,"Test Case Failed"+result.getName());
		    test.log(Status.INFO,"Test Case Failed Cause is:"+result.getThrowable().getMessage());
		    
		    try {
		    	String imgpath=new BaseClass().captureScreen(result.getName());
		    	test.addScreenCaptureFromPath(imgpath);
		    	
		    }
		    catch(IOException e1) {
		    	e1.printStackTrace();
		    }
		    
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		    test=extent.createTest(result.getClass().getName());
		    test.assignCategory(result.getMethod().getGroups());
		    test.log(Status.SKIP,"Test Is Skipped"+result.getName());
		    test.log(Status.INFO,result.getThrowable().getMessage());
		    
		 
		  }
 
	 public void onFinish(ITestContext context) {
		   extent.flush();
		   
		 
		   // How to Automatically open the report  
		   
		   String pathofextentreport=System.getProperty("user.dir")+"\\reports\\"+ repName;
		   
		   File extentreport=new File(pathofextentreport);
		   
		   try {
			   Desktop.getDesktop().browse(extentreport.toURI());
		   }
		   catch(IOException e) {
			   e.printStackTrace();
		   }
		 
		  }
	 

	/* 
	 // How to send Extent Report to via Email
	 
	 
	 try {
		  URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\repName");
		 

		     ImageHtmlEmail email=new ImageHtmlEmail();
			 email.setDataSourceResolver(new DataSourceUrlResolver(null)); // Pass the parameter as a url that is file location 
			 email.setHostName("smtp.googlemail.com");
			 email.setSmtpPort(465);
			 email.setAuthenticator(new DefaultAuthenticator("satheeshreddy629@gmail.com","@Reddys143"))
			 email.setSSLOnConnect(true);
			 email.setFrom("satheeshreddy629@gmail.com");   //sender
			 email.setSubject("Test Report");
			 email.setMsg("Please Find Attached Report");
			 email.addTo("satheeshreddy0099@gmail.com");
			 email.attach(url, "extent report","please chack report");
			 email.send();
	 }
			 catch(IOException e) {
				 e.printStackTrace();
			 }
                                                         */
						 }
	 



