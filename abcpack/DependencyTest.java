package abcpack;

import org.testng.annotations.Test;

public class DependencyTest {
	@Test
	public void meth1()
	{
		System.out.println("This meth1");
		int x=10,y=0;
		System.out.println("z: "+x/y);
	}
	@Test(dependsOnMethods="meth1")
	public void meth2()
	{
		System.out.println("This meth2");
	}

}
