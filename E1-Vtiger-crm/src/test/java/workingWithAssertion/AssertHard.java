package workingWithAssertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertHard {

	@Test(enabled = false)
	public void case1() {
		System.out.println("first line");

		String orgName = "abc";
		String actOrgName = "abc";
		Assert.assertEquals("abc", "xyz");
		Assert.assertEquals(orgName, actOrgName);
//		Assert.assertNotEquals(orgName,actOrgName);

		Object obj1 = null;
		Object obj2 = new Object();

		Assert.assertNotNull(obj2);
		Assert.assertNull(obj1);

		boolean status = orgName.equals(actOrgName + "1");

		Assert.assertTrue(status);

		System.out.println("Last Line");
	}

	@Test
	public void case2() {
		System.out.println("first line");

		String orgName = "abc";
		String actOrgName = "abc";

		boolean status = orgName.equals(actOrgName);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(orgName, actOrgName);

		sa.assertAll();

		System.out.println("Last Line");
	}
}
