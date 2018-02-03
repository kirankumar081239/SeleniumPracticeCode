package abcpack;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiWindow {
	WebDriver d;
	@Test
	public void testMultiwindow() throws Exception
	{
		d.get("http://www.irctc.co.in/eticketing/loginHome.jsf");
		assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		String pcode=d.getWindowHandle();
		System.out.println("The parent window code is: "+pcode);
		d.findElement(By.linkText("Tour Packages")).click();
		Set<String> w=d.getWindowHandles();
		String codes[]=new String[w.size()];
		/*for(String code:d.getWindowHandles())
		{
			System.out.println("Codes: "+code);
			d.switchTo().window(code);
		}*/
		int i=0;
		for(String code:w)
		{
			codes[i]=code;
			System.out.println(codes[i]);
			i++;
		}
		d.switchTo().window(codes[1]);
		assertTrue(d.findElement(By.linkText("Login")).isDisplayed());
		//d.switchTo().window(pcode);
		d.switchTo().window(codes[0]);
		assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
		Thread.sleep(4000);
	}
	@Before
	public void setUp()
	{
		d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Oct14\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@After
	public void tearDown()
	{
		d.quit();
	}


}
