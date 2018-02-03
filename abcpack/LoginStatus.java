package abcpack;

import org.testng.Assert;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginStatus {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		d.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		d.get("http://demo.exaact.co/login.jsp");
		assertEquals("Target",d.getTitle());
		
		FileInputStream fis=new FileInputStream("F:\\Selenium_Scripts_Oct14\\ABCBank\\TestData\\Login Test Data.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet s=wb.getSheet("Sheet1");
		
		FileOutputStream fos=new FileOutputStream("F:\\Selenium_Scripts_Oct14\\ABCBank\\Results\\LoginStatus.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("Results", 0);
		
		for(int i=0;i<s.getRows();i++)
		{
			for(int j=0;j<s.getColumns();j++)
			{
				Label l=new Label(j,i,s.getCell(j, i).getContents());
				ws.addCell(l);
			}
		}
		
		
		for(int i=1;i<s.getRows();i++)
		{
			d.findElement(By.id("loginusername")).clear();
			d.findElement(By.id("loginusername")).sendKeys(s.getCell(0,i).getContents());
			String uname=d.findElement(By.id("loginusername")).getAttribute("value");
			d.findElement(By.id("loginpassword")).clear();
			d.findElement(By.id("loginpassword")).sendKeys(s.getCell(1, i).getContents());
			String password=d.findElement(By.id("loginpassword")).getAttribute("value");
			d.findElement(By.id("loginformsubmit")).click();
			
			if(uname.equals("") && password.equals(""))
			{
				assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginusername_error']/span")).getText());
				assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginpassword_error']/span")).getText());
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
			else if(uname.equalsIgnoreCase(""))
			{
				assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginusername_error']/span")).getText());
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
			else if(password.equals(""))
			{
				assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginpassword_error']/span")).getText());
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
			else if(isElementPresent(By.className("logoutpic")))
			{
				//assertTrue(d.findElement(By.className("salt")).isDisplayed());
				d.findElement(By.className("logoutpic")).click();
				Label l=new Label(2,i,"Pass");
				ws.addCell(l);
			}
			else
			{
				assertEquals("x",d.findElement(By.id("close")).getText());
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
		}
		wwb.write();
		wwb.close();
			
		
		Thread.sleep(4000);
	}
	private boolean isElementPresent(By by) {
	    try {
	      d.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
		d.manage().window().maximize();
	}
	

	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
		

}
