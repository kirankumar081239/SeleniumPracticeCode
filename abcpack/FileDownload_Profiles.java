package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownload_Profiles {
	WebDriver d;
	@Test
	public void testFileDownload() throws Exception
	{
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.get("http://docs.seleniumhq.org/download/");
		assertEquals("Downloads",d.getTitle());
		d.findElement(By.linkText("2.44.0")).click();
		Thread.sleep(8000);
		
	}
	@BeforeMethod
	public void setUp()
	{
		ProfilesIni p=new ProfilesIni();
		FirefoxProfile fp=p.getProfile("Selenium");
		d=new FirefoxDriver(fp);
		
	}
	@AfterMethod
	public void tearDown()
	{
		//d.quit();
	}

}
