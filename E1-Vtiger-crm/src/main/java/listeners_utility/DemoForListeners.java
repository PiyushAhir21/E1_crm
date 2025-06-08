package listeners_utility;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// PackageName.className.class

/*
 * we will write @Listeners above the class 
 * 
 * we will write all the basic, config,
 * @DataProvider and @parameters annotation 
 * above the methods
 * 
 * @findBy @FindBys @FindAll
 * we will write them above the variables 
 */

/**
 * This class gives the implementation of ItestListener
 * 
 * @author Piyush Baldaniya
 * 
 * @version 1.1
 * 
 */
//@Listeners(listeners_utility.List_Imp.class)
public class DemoForListeners {
	@Test
	public void createCity() {
		System.out.println("Allahabad created");
		Assert.assertTrue(true);
	}

	@Test(dependsOnMethods = "createCity")
	public void modifyCity() {
//		city create
		System.out.println("Prayagraj changed");
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = "modifyCity")
	public void deleteCity() {
//		city create 
		System.out.println("Prayagraj Deleted");
		Assert.assertTrue(true);
	}
}
