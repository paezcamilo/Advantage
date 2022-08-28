package org.advantage.tests;

import org.advantage.pages.BuyItemPage;
import org.advantage.pages.CreateAccPage;
import org.advantage.pages.HomePage;
import org.advantage.utils.Utils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BuyItemTest extends BaseTest{
	
    public Logger log = Logger.getLogger(BuyItemTest.class);

    @Parameters({"url"})
    @BeforeMethod
    public void beforeMethod(String url) {
        home= new HomePage(driver.getDriver(), url);

    }

    @Parameters({"filePath"})
    @Test(description = "LogIn the user just created", priority = 1)
    public void loginTheUer(String filePath) {
    	
    	CreateAccPage createAccPage = new CreateAccPage(driver.getDriver());
        home.clickAccountAvatar();
        Utils utilCsvWrite = new Utils();
        String values = utilCsvWrite.readDataFromCustomSeparator(filePath);
        String[] strSplit = values.split(",");
        String userName = strSplit[0];
        String PasswordUser = strSplit[1];
        home.setInputUserName(userName);
        home.setInputPassword(PasswordUser);
        home.clickSignInButton();
        Assert.assertEquals(createAccPage.getTextTitleUserLog(),userName);
    }

    @Parameters({"filePath"})
    @Test(description = "Select Item from popular items link",priority = 2)
    public void buyItems(String filePath) {
        BuyItemPage buyItemPage = new BuyItemPage(driver.getDriver());
        Utils utilCsvWrite = new Utils();
        String values = utilCsvWrite.readDataFromCustomSeparator(filePath);
        String[] strSplit = values.split(",");
        String userName = strSplit[0];
        String PasswordUser = strSplit[1];
        buyItemPage.clickOnPopularItem();
        buyItemPage.clickOnTabletItem();
        buyItemPage.clickOnChangeColorTablet();
        buyItemPage.clickOnAddToCart();
        buyItemPage.clickOnGoToHome();
        buyItemPage.clickOnPopularItem();
        buyItemPage.clickOnLaptoptItem();
        buyItemPage.clickOnAddToCart();
        buyItemPage.clickOnButtonCartBuy();
        buyItemPage.clickOnButtonCheckOut();
        buyItemPage.clickOnNextButton();
        buyItemPage.clickOnPayNow();
        buyItemPage.setInputUserNameSafPay(userName);
        buyItemPage.setInputPassSafPay(PasswordUser);
        Assert.assertEquals(buyItemPage.getTextLabelOderPayment(),"ORDER PAYMENT");
    }
    
}
