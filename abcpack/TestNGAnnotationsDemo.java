package abcpack;

import org.testng.annotations.*;

public class TestNGAnnotationsDemo {
	@BeforeClass
	public void meth1()
	{
		System.out.println("This is @BeforeClass method");
	}
	@AfterClass
	public void meth2()
	{
		System.out.println("This is @AfterClass method");
	}
	@BeforeTest
	public void meth3()
	{
		System.out.println("This is @BeforeTest method");
	}
	@AfterTest
	public void meth4()
	{
		System.out.println("This is @AfterTest method");
	}
	@BeforeSuite
	public void meth5()
	{
		System.out.println("This is @BeforeSuite method");
	}
	@AfterSuite
	public void meth6()
	{
		System.out.println("This is @AfterSuite method");
	}
	@BeforeMethod
	public void meth7()
	{
		System.out.println("This is @BeforeMethod method");
	}
	@AfterMethod
	public void meth8()
	{
		System.out.println("This is @AfterMethod method");
	}
	@Test
	public void meth9()
	{
		System.out.println("This is @Test1 method");
	}
	@Test
	public void meth10()
	{
		System.out.println("This is @Test2 method");
	}

}
