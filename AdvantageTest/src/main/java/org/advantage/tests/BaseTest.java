package org.advantage.tests;

import org.advantage.driver.Driver;
import org.advantage.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.*;


/**
 * Parent of the other classes of test.
 */
public class BaseTest {
	
	Driver driver;
	
	protected HomePage home;
	public Logger log = Logger.getLogger(BaseTest.class);
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"browser"})
	public void beforeTest(String browser) {
		driver = new Driver(browser);
		driver.getDriver().manage().window().maximize();
	}


	@AfterClass(alwaysRun=true)
	public void afterTest() {
		log.info("Session disposed");
		home.dispose();
	}
	
	/**
	 * Get the home page.
	 * @return {@link HomePage}
	 */
	public HomePage getHomePage() {
		return home;
	}

}
