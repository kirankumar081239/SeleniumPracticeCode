package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d=new FirefoxDriver();
		d.get("https://www.google.co.in/");
		String t1=d.getTitle();
		String t2="Google";
		if(t1.equals(t2))
		{
			d.findElement(By.id("gbqfq")).sendKeys("Selenium");
			d.findElement(By.id("gbqfb")).click();
		}
		Thread.sleep(8000);
		d.quit();

	}

}
