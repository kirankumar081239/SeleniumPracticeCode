package abcpack;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GoogleDemo1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
   
	driver.manage().window().maximize();
	  driver.get(baseUrl);
    assertEquals("Google", driver.getTitle());
    driver.findElement(By.id("gbqfq")).clear();
    String s1="Selenium";
    driver.findElement(By.id("gbqfq")).sendKeys(s1);
    String s2=driver.findElement(By.id("gbqfq")).getAttribute("value");
    System.out.println("The value of text filed is:"+s2);
    //driver.findElement(By.name("q")).sendKeys("Selenium");
    //driver.findElement(By.linkText("+You")).click();
    //driver.findElement(By.partialLinkText("+")).click();
    List<WebElement> l=driver.findElements(By.tagName("a"));
    System.out.println("No of links: "+l.size());
    //driver.findElement(By.xpath("//a[contains(text(),'+You')]")).click();
    /*driver.findElement(By.className("gbqfif")).sendKeys("Selenium");
    driver.findElement(By.id("gbqfb")).click();*/
    Thread.sleep(4000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  
}

