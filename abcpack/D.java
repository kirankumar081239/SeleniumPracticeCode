package abcpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class D {
    WebDriver d;
  @Test
  public void f() throws InterruptedException {
      Actions actions = new Actions(d);
       //actions.moveToElement(d.findElement(By.xpath("//span[contains(text(),'Stay signed in')]"))).perform();
       //actions.moveToElement(d.findElement(By.id("id=link-signup"))).click().build().perform();
       actions.moveToElement(d.findElement(By.xpath("//span[contains(text(),'Stay signed in')]"))).pause(5000).
       moveToElement(d.findElement(By.xpath("//a[contains(text(), 'Create an account')]"))).click().build().perform();
       Thread.sleep(2000);
     
  }
  @BeforeMethod
  public void beforeMethod() {
      d = new FirefoxDriver();
        d.manage().window().maximize();
        d.get("http://www.gmail.com/");
        d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    
  }

  @AfterMethod
  public void afterMethod() {
	  d.quit();
  }

}