package extra;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.List_Imp.class)
public class AdvanceReporting {

	
	@Test
	public void case1() {
		System.out.println("add method");
		Assert.assertTrue(false);
	}

	@Test
	public void case2() {
		System.out.println("Sub method");
		Assert.assertTrue(false);
	}

	@Test
	public void case3() {
		System.out.println("Div method");
		Assert.assertTrue(true);

	}

	@Test
	public void case4() {
		System.out.println("Mul method");
		Assert.assertTrue(true);

	}

	@Test
	public void case5() {
		System.out.println("Factorial method");
		Assert.assertTrue(true);

	}

}
