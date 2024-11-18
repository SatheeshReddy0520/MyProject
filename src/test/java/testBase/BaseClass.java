package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;


	@BeforeClass(groups={"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browser"})
	
	public void setup(String os,String br) throws IOException {
		
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass()); //log4j2 
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
	
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
				
			}
			
			else if (os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("no matching os");
				return;
				
				
				
			}
			 
			          //Browser 	
			
					switch(br.toLowerCase())
					{
					case "chrome":capabilities.setBrowserName("chrome");break;
					case "firefox":capabilities.setBrowserName("Firefox");
					case "edge":capabilities.setBrowserName("MicrosoftEdge"); break;
					default :System.out.println(" Browser is not matching"); return;
					}
						
				driver=new RemoteWebDriver(new URL("http://192.168.32.118:4444/wd/hub"),capabilities);
				
			}
			
	    	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	    	{ 		
			switch(br.toLowerCase()) {
			case "chrome":driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver(); break;
			case "Firefox": driver=new FirefoxDriver(); break;
			default :System.out.println("invalid Browser"); return;
			}
		}
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL")); //Reading URL from properties file
		driver.manage().window().maximize();
			
	}
	
	@AfterClass(groups={"Sanity","Regression","Master","DataDriven"})
	public void teardown() {
		driver.quit();
	}


	public String randomstring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
	}
	
	public String randomnumber() {
		String generatednumber=RandomStringUtils.randomAlphanumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumeric() {
		String generatedstring=RandomStringUtils.randomAlphabetic(4);
		String generatednumber=RandomStringUtils.randomAlphanumeric(6);
		return (generatedstring+"@"+generatednumber);
	}	
	
	public String captureScreen(String tname) throws IOException {
		
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver; 
		
		File sourcefile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath =System.getProperty("user.dir")+"\\reports\\"+tname+"-"+timestamp +".png";
		File targetfile=new File(targetfilepath);
		
		sourcefile.renameTo(targetfile);
		
		return targetfilepath;
		
	}
	
	
}
