package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ParallelMethods {
	@Test
	public void dynamicTable()throws Exception
	{
		WebDriver d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
		assertEquals(":: Government Orders ::",d.getTitle());
		Select s=new Select(d.findElement(By.id("Select1")));
		s.selectByIndex(4);
		List<WebElement> tr_collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		List<WebElement> td_collection1=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
		System.out.println("NUMBER OF Columns IN THIS TABLE = "+td_collection1.size()/tr_collection.size());
		
		int row_num,col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            //System.out.println("NUMBER OF COLUMNS="+row_num+" "+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
                System.out.println("Row # "+row_num+", Col # "+col_num  + ", Text=" +tdElement.getText());
                col_num++;
            }
            row_num++;
        }
        Thread.sleep(8000);
        d.quit();
	}
	@Test
	public void testWebElements() throws Exception
	{
		WebDriver d=new FirefoxDriver();
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
		d.quit();
	}
	@Test
	public void testLinks() throws Exception
	{
		WebDriver d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.navigate().to("http://docs.seleniumhq.org/");
		assertEquals("Selenium - Web Browser Automation",d.getTitle());
		List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
		System.out.println("No of links: "+l.size());
		System.out.println("*************************");
		System.out.println("Link names are");
		System.out.println("*************************");
		String links[]=new String[l.size()];
		int i=0;
		for(WebElement e:l)
		{
			links[i]=e.getText();
			System.out.println(links[i]);
			i++;
		}
		for(String s:links)
		{
			d.findElement(By.linkText(s)).click();
			if(d.getTitle().equals("Error 404"))
			{
				System.out.println("Link: "+s+": Not working");
			}
			else
			{
				System.out.println("Link: "+s+": working fine");
			}
		}
		Thread.sleep(4000);
		d.quit();
	}

}
