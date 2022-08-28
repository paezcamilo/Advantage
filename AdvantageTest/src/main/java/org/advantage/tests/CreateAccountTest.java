package org.advantage.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.advantage.utils.Utils;

import org.advantage.pages.*;

public class CreateAccountTest extends BaseTest{
	
    public Logger log = Logger.getLogger(CreateAccountTest.class);

    @Parameters({"url"})
    @BeforeMethod
    public void beforeMethod(String url) {
        home= new HomePage(driver.getDriver(), url);
        home.clickAccountAvatar();
    }

    @Parameters({"filePath"})
    @Test(description = "Create account")
    public void validateTitleModal(String filePath) {
    	
    	CreateAccPage createAccPage = new CreateAccPage(driver.getDriver());
        Utils utilCsvWrite = new Utils();
    	home.clickOnCreateAccount();
    	String userName = createAccPage.setInputUsername();
    	createAccPage.setInputEmail();
        String passworduser = createAccPage.setInputPassword();
    	createAccPage.setInputFirstName();
    	createAccPage.setInputLastName();
    	createAccPage.setInputPhoneNum();
        createAccPage.setInputCountry();
        createAccPage.setInputCity();
        createAccPage.setInputAddress();
        createAccPage.setInputState();
        createAccPage.setInputPostalCode();
        createAccPage.setInputCheckAgree();
    	createAccPage.validateButtonReg();
        utilCsvWrite.writeDataLineByLine(userName,passworduser,filePath);
        utilCsvWrite.readDataFromCustomSeparator(filePath);
        Assert.assertEquals(createAccPage.getTextTitle(),"CREATE ACCOUNT");
        Assert.assertEquals(createAccPage.getTextTitleUserLog(),userName);

    }
    
}
