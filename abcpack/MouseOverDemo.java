package abcpack;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class MouseOverDemo
{
	WebDriver d;
	@Test
	public void testMouseOver() throws Exception
	{
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.get("http://www.policybazaar.com/");
		assertEquals("Compare: Life |Car |Health |Travel Insurance, Child |Pension |Investment Plans, Credit Cards |Loans Online",d.getTitle());
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.className("catLink"))).pause(2000).moveToElement(d.findElement(By.xpath("//a[contains(text(),'Term Insurance')]"))).click().build().perform();
		assertEquals("Term Insurance",d.findElement(By.cssSelector("label.subCatName.blockItem")).getText());
		Thread.sleep(8000);
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
