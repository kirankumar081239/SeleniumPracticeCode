package abcpack;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;



public class ScreenshotDemo {
	WebDriver d;
		
	@BeforeMethod
	public void init() throws  Exception
	{
		d = new FirefoxDriver();
				
	}
    @Test
    public void testScreenshot() throws Exception {
        
        d.manage().window().maximize();        
        d.get("http://www.google.com");
        d.findElement(By.name("q")).sendKeys("Selenium");
             
        Date dt=new Date();
        // then Augmenter will add the TakesScreenshot methods to the instance
        File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(scrFile, new File("F:\\Selenium_Scripts_Oct14\\ABCBank\\Results\\Screenshots\\Page1.png"));
        FileUtils.copyFile(scrFile, new File("F:\\Selenium_Scripts_Oct14\\ABCBank\\Results\\Screenshots\\"+dt.getTime()+".png"));
        d.findElement(By.id("gbqfb")).click();
        Thread.sleep(5000);
        
        
    }
    @AfterMethod
    public void stop()
    {
    	d.quit();
    }
}
