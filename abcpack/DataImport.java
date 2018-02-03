package abcpack;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataImport {
	WebDriver d;
	@Test
	public void testDataImport() throws Exception
	{
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		FileInputStream fis=new FileInputStream("F:\\Selenium_Scripts_Oct14\\ABCBank\\TestData\\Search Words.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet s=wb.getSheet("Sheet1");
		for(int i=0;i<s.getRows();i++)
		{
			d.findElement(By.id("gbqfq")).clear();
			d.findElement(By.id("gbqfq")).sendKeys(s.getCell(0, i).getContents());
			Thread.sleep(2000);
		}
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUp()
	{
		//d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
	}
	

	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
		

}
