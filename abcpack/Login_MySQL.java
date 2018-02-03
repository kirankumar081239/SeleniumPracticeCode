package abcpack;

import org.testng.Assert;

import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_MySQL {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		d.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		d.get("http://demo.exaact.co/login.jsp");
		assertEquals("Target",d.getTitle());
		
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","password12");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from Login;");
			while (rs.next())
			{											
				String username = rs.getString("UserName");
				String pwd = rs.getString("Password");
		
		
		d.findElement(By.id("loginusername")).clear();
		d.findElement(By.id("loginusername")).sendKeys(username);
		String uname=d.findElement(By.id("loginusername")).getAttribute("value");
		d.findElement(By.id("loginpassword")).clear();
		d.findElement(By.id("loginpassword")).sendKeys(pwd);
		String password=d.findElement(By.id("loginpassword")).getAttribute("value");
		d.findElement(By.id("loginformsubmit")).click();
		
		if(uname.equals("") && password.equals(""))
		{
			assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginusername_error']/span")).getText());
			assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginpassword_error']/span")).getText());
			String sql="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"';";
			PreparedStatement st1=con.prepareStatement(sql);
			st1.executeUpdate();
		}
		else if(uname.equalsIgnoreCase(""))
		{
			assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginusername_error']/span")).getText());
			String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"';";
			PreparedStatement st1=con.prepareStatement(sql1);
			st1.executeUpdate();
		}
		else if(password.equals(""))
		{
			assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginpassword_error']/span")).getText());
			String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"';";
			PreparedStatement st1=con.prepareStatement(sql1);
			st1.executeUpdate();
		}
		else if(isElementPresent(By.className("logoutpic")))
		{
			//assertTrue(d.findElement(By.className("salt")).isDisplayed());
			String sql1="UPDATE Login SET STATUS='Pass' WHERE UserName='"+username+"';";
			PreparedStatement st1=con.prepareStatement(sql1);
			st1.executeUpdate();
			d.findElement(By.className("logoutpic")).click();
		}
		else
		{
			assertEquals("x",d.findElement(By.id("close")).getText());
			String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"';";
			PreparedStatement st1=con.prepareStatement(sql1);
			st1.executeUpdate();
		}
		
	}
	
			st.close();
			con.close();
	}
			catch(Exception ex)
			   {
				System.err.print("Exception: ");
				System.err.println(ex.getMessage());
			   } 
		
		Thread.sleep(4000);
		
	}
	private boolean isElementPresent(By by) {
	    try {
	      d.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
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
