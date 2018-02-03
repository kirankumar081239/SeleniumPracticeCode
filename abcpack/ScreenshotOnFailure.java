package abcpack;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ScreenshotOnFailure
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp()throws Exception
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
	}
	
	@Test(retryAnalyzer=Retry.class)
	public void testWebElements() throws Exception
	{
		assertEquals("Pass",getScreenshot());
			
	}
	
	String getScreenshot() throws Exception
	{
		try
		{
			d.get("http://book.theautomatedtester.co.uk/");
			WebElement tfiled=d.findElement(By.id("q"));
			tfiled.sendKeys("Selenium");
			System.out.println("The value of text filed is:"+tfiled.getAttribute("value"));
			d.findElement(By.linkText("Chapter1")).click();
			WebElement radio=d.findElement(By.id("radiobutton123"));
			if(radio.isSelected())
			{
				System.out.println("Radio button is already Selected");
			}
			else
			{
				radio.click();
			}
			
			
			
			Select dd=new Select(d.findElement(By.id("selecttype")));
			dd.selectByIndex(3);
			WebElement s=dd.getFirstSelectedOption();
			System.out.println("Selected options is: "+s.getText());
			WebElement checkbox=d.findElement(By.name("selected(1234)"));
			if(checkbox.isSelected())
			{
				System.out.println("Check box is already Selected");
			}
			else
			{
				checkbox.click();
			}
			WebElement tarea=d.findElement(By.id("html5div"));
			tarea.clear();
			tarea.sendKeys("Selenium");
			Thread.sleep(4000);
			return "Pass";
		}
		catch(Exception e)
		{
			Date dt=new Date();
	        // then Augmenter will add the TakesScreenshot methods to the instance
	        File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File("F:\\Selenium_Scripts_Oct14\\ABCBank\\Results\\Screenshots\\"+dt.getTime()+".png"));
	        return "Fail";
		}
	}

	@AfterMethod
	public void tearDown()throws Exception
	{
		d.quit();
	}
		
		
}
