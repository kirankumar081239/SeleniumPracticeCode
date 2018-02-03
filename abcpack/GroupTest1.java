package abcpack;

import org.testng.annotations.Test;

public class GroupTest1 {
	@Test(groups="G1",priority=1)
	public void meth1()
	{
		System.out.println("This is meth1 in GroupTest1");
	}
	@Test(groups="G2",priority=2)
	public void meth2()
	{
		System.out.println("This is meth2 in GroupTest1");
	}
	@Test(groups="G1",priority=1)
	public void meth3()
	{
		System.out.println("This is meth3 in GroupTest1");
	}
	@Test(groups="G2",priority=2)
	public void meth4()
	{
		System.out.println("This is meth4 in GroupTest1");
	}

}
