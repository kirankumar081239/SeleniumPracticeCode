package abcpack;

import org.testng.Assert;
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutocompleteDemo {
	WebDriver d;
	@Test
	public void testAutocomplete() throws Exception
	{
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.get("http://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		d.switchTo().frame(0);
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("No of suggestions are: "+s.size());
		System.out.println("Suggestions are:");
		String suggestions[]=new String[s.size()];
		int i=0;
		for(WebElement e:s)
		{
			suggestions[i]=e.getText();
			System.out.println(suggestions[i]);
			i++;
		}
		/*d.findElement(By.id("tags")).clear();
		d.findElement(By.id("tags")).sendKeys(suggestions[2]);*/
		if(s.size()>=3)
		{
			//d.findElement(By.id("tags")).clear();
			for(int j=0;j<3;j++)
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(2000);
			}
			d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
			
		}
		Thread.sleep(4000);
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
