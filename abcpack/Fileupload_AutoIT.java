package abcpack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Fileupload_AutoIT {
public WebDriver driver;

@BeforeMethod
public void setUp() throws Exception {
driver= new FirefoxDriver();
driver.manage().window().maximize();
}
@Test
public void testTestScenario1() throws Exception
{
driver.get("http://www.2shared.com/");
driver.findElement(By.id("upField")).click();
Thread.sleep(4000);
Process p = new ProcessBuilder("F:\\Selenium_Scripts_July13\\AutoIt Examples\\FileUpload.exe").start(); 
//driver.findElement(By.xpath("//input[@title='Upload file']")).click();
Thread.sleep(5000);

}


@AfterMethod
public void tearDown() throws Exception {
driver.quit();
}
}




