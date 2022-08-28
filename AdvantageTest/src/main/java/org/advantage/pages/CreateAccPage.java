package org.advantage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccPage extends BasePage {


	//This is the title of the website
	@FindBy(xpath = "//h3[text()='CREATE ACCOUNT']")
	private WebElement tittleCreatAcc;
	
	//This is the input Name
	@FindBy(xpath = "//input[@name='usernameRegisterPage']")
	private WebElement inputName;
	
	//This is the input email
	@FindBy(xpath = "//input[@name='emailRegisterPage']")
	private WebElement inputEmail;
	
	//This is the input password
	@FindBy(xpath = "//input[@name='passwordRegisterPage']")
	private WebElement inputPassword;
	
	//This is the input confirm password
	@FindBy(xpath = "//input[@name='confirm_passwordRegisterPage']")
	private WebElement inputConfPass;

	//This is the input first name
	@FindBy(xpath = "//input[@name='first_nameRegisterPage']")
	private WebElement inputFirstName;
	
	//This is the input last name
	@FindBy(xpath = "//input[@name='last_nameRegisterPage']")
	private WebElement inputLastName;
	
	//This is the input phone number
	@FindBy(xpath = "//input[@name='phone_numberRegisterPage']")
	private WebElement inputPhoneNum;
	
	//This is the drop down list for the country
	@FindBy(xpath = "//select[@name='countryListboxRegisterPage']")
	private WebElement dropDownCountry;
	
	//This is the value selected from the dropdownlist (Colombia)
	@FindBy(xpath = "//option[text()='Colombia']")
	private WebElement dropDownListCoun;
	
	//This is the input city
	@FindBy(xpath = "//input[@name='cityRegisterPage']")
	private WebElement inputCity;
	
	//This is the input address
	@FindBy(xpath = "//input[@name='addressRegisterPage']")
	private WebElement inputAddress;
	
	//This is the input state
	@FindBy(xpath = "//input[@name='state_/_province_/_regionRegisterPage']")
	private WebElement inputState;

	//This is the input postal Code
	@FindBy(xpath = "//input[@name='postal_codeRegisterPage']")
	private WebElement inputPostalCode;
	
	//This is the checkbox I agree
	@FindBy(xpath = "//input[@name='i_agree']")
	private WebElement checkIagree;
	
	//This is the register button
	@FindBy(id = "register_btnundefined")
	private WebElement buttonRegister;

	//This is text of the user logged
	@FindBy(css = ".hi-user:nth-child(1)")
	private WebElement userNameLogged;

	
    /**
     * Constructor.
     * @param driver WebDriver
     */
    
    public CreateAccPage(WebDriver driver) {
        super(driver);
    }

    public String getTextTitle() {
    	log.info("Get the title text creater account");
    	waitElementVisibility(tittleCreatAcc);
    	return getText(tittleCreatAcc);
    }
    
    /**
     * Send the keys of the username
     */
    public String setInputUsername() {
        log.info("Insert the username");
        waitElementVisibility(inputName);
        String textRandom = generateRandomPasswordAlp(12);
        String username = "T"+textRandom;
		sendKeys(inputName, username);
		return (username);
    }

	/**
	 * Send the keys of the Email
	 */
	public void setInputEmail() {
		log.info("Insert the Email");
		waitElementVisibility(inputEmail);
		String textRandom = generateRandomPasswordAlp(8);
		sendKeys(inputEmail, "Test"+textRandom+"@test.com");
	}

	/**
	 * Send the keys of the Password and confirmation password
	 */
	public String setInputPassword() {
		log.info("Insert the Password");
		waitElementVisibility(inputPassword);
		waitElementVisibility(inputConfPass);
		String textRandom = generateRandomPasswordAlpNum(10);
		String passwordTyped = "T1"+textRandom;
		sendKeys(inputPassword, passwordTyped);
		sendKeys(inputConfPass, passwordTyped);
		return passwordTyped;
	}

	/**
	 * Send the keys of the First name
	 */
	public void setInputFirstName() {
		log.info("Insert the first name");
		waitElementVisibility(inputFirstName);
		String textRandom = generateRandomPasswordAlpNum(30);
		sendKeys(inputFirstName, textRandom);
	}

	/**
	 * Send the keys of the Last name
	 */
	public void setInputLastName() {
		log.info("Insert the last name");
		waitElementVisibility(inputLastName);
		String textRandom = generateRandomPasswordAlpNum(30);
		sendKeys(inputLastName, textRandom);
	}

	/**
	 * Send the keys of the Phone number
	 */
	public void setInputPhoneNum() {
		log.info("Insert the phone number");
		waitElementVisibility(inputPhoneNum);
		String textRandom = generateRandomPasswordInt(20);
		sendKeys(inputPhoneNum, textRandom);
	}

	/**
	 * Send the keys of the country
	 */
	public void setInputCountry() {
		log.info("Insert the country");
		waitElementVisibility(dropDownCountry);
		click(dropDownCountry);
		waitElementVisibility(dropDownListCoun);
		click(dropDownListCoun);
	}

	/**
	 * Send the keys of the City
	 */
	public void setInputCity() {
		log.info("Insert the city");
		waitElementVisibility(inputCity);
		click(inputCity);
		String textRandom = generateRandomPasswordAlpNum(25);
		sendKeys(inputCity, textRandom);
	}

	/**
	 * Send the keys of the Address
	 */
	public void setInputAddress() {
		log.info("Insert the address");
		waitElementVisibility(inputAddress);
		click(inputAddress);
		String textRandom = generateRandomPasswordAlpNum(50);
		sendKeys(inputAddress, textRandom);
	}

	/**
	 * Send the keys of the state
	 */
	public void setInputState() {
		log.info("Insert the State");
		waitElementVisibility(inputState);
		click(inputState);
		String textRandom = generateRandomPasswordAlpNum(10);
		sendKeys(inputState, textRandom);
	}

	/**
	 * Send the keys of the Postal code
	 */
	public void setInputPostalCode() {
		log.info("Insert the Postal code");
		waitElementVisibility(inputPostalCode);
		click(inputPostalCode);
		String textRandom = generateRandomPasswordInt(10);
		sendKeys(inputPostalCode, textRandom);
	}

	/**
	 * Send the keys of the state
	 */
	public void setInputCheckAgree() {
		log.info("Click on the check agree");
		waitElementVisibility(checkIagree);
		click(checkIagree);
	}

	public String getTextTitleUserLog() {
		log.info("Get the title of the user logged");
		waitElementVisibility(userNameLogged);
		return getText(userNameLogged);
	}
    
     public void validateButtonReg() {
        log.info("Insert the username");
        waitElementClickable(buttonRegister);
        click(buttonRegister);
    }
}
