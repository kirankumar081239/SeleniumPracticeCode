package abcpack;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class WebElementsDemo
{
	WebDriver d;
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) throws Exception
	{
		if(browser.equals("FF"))
		{
			DesiredCapabilities b = DesiredCapabilities.firefox();
			d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
			
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","F:\\Selenium_Scripts_Sep14\\Lib\\IEDriverServer.exe");
			DesiredCapabilities b = DesiredCapabilities.internetExplorer();
			d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Sep14\\Lib\\chromedriver.exe");
			DesiredCapabilities b = DesiredCapabilities.chrome();
			d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
		}
			
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
	}
	@Test(retryAnalyzer=Retry.class)
	public void testWebElements() throws Exception
	{
		d.get("http://book.theautomatedtester.co.uk/");
		WebElement tfiled=d.findElement(By.id("q"));
		tfiled.sendKeys("Selenium");
		System.out.println("The value of text filed is:"+tfiled.getAttribute("value"));
		d.findElement(By.linkText("Chapter1")).click();
		WebElement radio=d.findElement(By.id("radiobutton"));
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
	}

	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
		
		
}
