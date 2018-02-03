package abcpack;

import org.junit.*;

public class JUnitAnnotationsDemo {
	@AfterClass
	public static void oneTimeTeardown()
	{
		System.out.println("This is @AfterClass Method");
	}
	@BeforeClass
	public static void oneTimeSetup()
	{
		System.out.println("This is @BeforeClass Method");
	}
	@After
	public void tearDown()
	{
		System.out.println("This is @After Method");
	}
	@Before
	public void setUp()
	{
		System.out.println("This is @Before Method");
	}
	
	@Test
	public void testMeth1()
	{
		System.out.println("This is @Test1 method");
	}
	@Test
	public void testMeth2()
	{
		System.out.println("This is @Test2 method");
	}

}
