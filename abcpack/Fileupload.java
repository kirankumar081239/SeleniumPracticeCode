package abcpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Fileupload {
	WebDriver d;
	@Test
	public void testFileUpload() throws InterruptedException
	{
		d.get("http://www.megafileupload.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		d.findElement(By.id("uploadfile_0")).sendKeys("F:\\Test.txt");
		Thread.sleep(3000);
		d.findElement(By.id("terms")).click();
		d.findElement(By.name("send")).click();
		Thread.sleep(10000);
	}
	@BeforeMethod
	public void setUp()
	{
		d = new FirefoxDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
		
	}

}


