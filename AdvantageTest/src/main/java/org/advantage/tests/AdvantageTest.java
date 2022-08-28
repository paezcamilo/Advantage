package org.advantage.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import org.advantage.pages.HomePage;
/*import com.advantage.pages.HotelListPage;
import com.advantage.pages.HotelPage;
import com.advantage.pages.PaymentPage;
import com.advantage.pages.ReservationPage;
import com.advantage.data.Data;*/

public class AdvantageTest extends BaseTest{
	
    public Logger log = Logger.getLogger(AdvantageTest.class);


    @BeforeClass
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
    }

    @Parameters({"url"})
    @BeforeMethod
    public void beforeMethod(String url) {
        home= new HomePage(driver.getDriver(), url);
    }

    @Test(description = "Open Website Home")
    public void validateTitle() {
    	Assert.assertEquals(home.getTextTitle(),"dvantage");
    }
    
    @Test(description = "Open modal register")
    public void validateTitleAccoun() {
        home.clickAccountAvatar();
    	Assert.assertEquals(home.getTextCreateAccount(),"CREATE NEW ACCOUNT");
    }

        
}