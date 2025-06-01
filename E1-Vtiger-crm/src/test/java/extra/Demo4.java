package extra;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo4 {
	@Test(groups = "Smoke")
	public void case1() {
		Reporter.log("Smoke Group");
		Assert.assertTrue(false);

	}
	
	@Test(groups = "Reg")
	public void case2() {
		Reporter.log("Reg Group");
		Assert.assertTrue(false);

	}
	
	@Test(groups = "Reg")
	public void case3() {
		Reporter.log("Reg Group");
	}
	
	@Test(groups = "Smoke")
	public void case4() {
		Reporter.log("Smoke Group");
	}
	
	@Test(groups = "Reg")
	public void case5() {
		Reporter.log("Reg Group");
		Assert.assertTrue(false);

	}
}
