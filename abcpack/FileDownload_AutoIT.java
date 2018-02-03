package abcpack;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class FileDownload_AutoIT {
	WebDriver d;
	@BeforeMethod
	public void init()
	{
		/*FirefoxProfile fp=new FirefoxProfile();
		fp.setPreference("C:\\Users\\SYS\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\tzlflio8.Selenium2", "true");*/
		d = new FirefoxDriver();
	}
	@AfterMethod
	public void stop()
	{
		//d.quit();
	}
	@Test
	public void testDownload() throws InterruptedException, IOException
	{
		d.manage().window().maximize();
		d.get("http://seleniumhq.org/download/");
		
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		d.findElement(By.linkText("2.44.0")).click();
		//Thread.sleep(5000);
		
		Process p = new ProcessBuilder("F:\\Selenium_Scripts_July13\\AutoIt Examples\\FDownload.exe").start(); 
		Thread.sleep(8000);

		//d.findElement(By.xpath("//a[@name='client-drivers']/table/tbody/tr[1]/td[4]/a")).click();
	}

}


