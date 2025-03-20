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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {

	public static  WebDriver driver;
	public Logger logger;
	public Properties p; // config class 

	@BeforeClass(groups= {"Sanity" , "Regression" , "Master"})
	@Parameters({"Os" , "browser"})
	 public	void setup(String os , String browser) throws IOException
		{
		
		//loading  config.properties file
		FileReader file = new FileReader("./src//main//resources//Config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		//grid 
		if( p.getProperty("execution_env").equals("remote")) {
		
			DesiredCapabilities dc = new DesiredCapabilities();
			
			//os
			if (os.equalsIgnoreCase("windows"))
			{
				dc.setPlatform(Platform.WIN11);
			}
			else if (os.equals("Mac")) {
				dc.setPlatform(Platform.MAC);
				
			} 
			else {
				System.out.println("No matching os");
				return;
			}
			
            
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome" : dc.setBrowserName("chrome");break;
			case "edge" : dc.setBrowserName("MicrosoftEdge");break;
			default : System.out.println("No browser");
			
			}
			//creating an object for driver
			driver = new RemoteWebDriver(new URL ( "http://192.168.0.102:4444"),dc);
		}
		
		// Local execution setup (separate from remote block
		else  if(p.getProperty("execution_env").equals("local"))
	  {
		switch (browser.toLowerCase()) {
        case "chrome":
            driver = new ChromeDriver();
            break;
        case "firefox":
            driver = new FirefoxDriver();
            break;
        case "edge":
            driver = new EdgeDriver();
            break;
        default:
            System.out.println("Invalid browser: " + browser);
            return;

		}
	 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 driver.get(p.getProperty("appURL"));//url launch
		 driver.manage().window().maximize();
		}
		}

	@AfterClass(groups= {"Sanity" ,"Regression", "Master"})
    public void teardown()
	{
		driver.quit();
	}

		//auto generate for email
		public String randomString() {
		String generated  = RandomStringUtils.randomAlphabetic(7); // Generates a 5-character random alphabetic string
		 return generated;
		}

		//phone number
		public String randomNumber() {
			String generated  = RandomStringUtils.randomNumeric(10); // Generates a 5-character random alphabetic string
			 return generated;
			}


		//password
			public String randomAlphaNumeric() {
				String generatedString  = RandomStringUtils.randomAlphabetic(3);// Generates a 5-character random alphabetic string
				String generatednumber  = RandomStringUtils.randomNumeric(4);
				 return (generatedString+generatednumber);
				}
			
			// Capture a screenshot and save it to the Screenshots folder
			
			public String capturescreenshot(String tname)
			{
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			
			    TakesScreenshot ts = (TakesScreenshot)driver;
			  File sourcefile =  ts.getScreenshotAs(OutputType.FILE);
			  
			  String targetfilepath = (System.getProperty("user.dir")+"\\Screenshot\\"+timestamp +".png");
			  File targetFile  = new File(targetfilepath);
			  
			  sourcefile.renameTo(targetFile);
			  
			  return targetfilepath;
			      
			}	 
			
			    
			}
			

		    

		
			
	


