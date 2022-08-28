package org.advantage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


	//This is the title of the website
	@FindBy(xpath = "//span[text()='dvantage']")
	private WebElement tittleAdvantage;

	//This is the link to login
	@FindBy(id = "menuUserLink")
	private WebElement accountAvatar;

	//This is the link to create the account
	@FindBy(xpath = "//a[text()='CREATE NEW ACCOUNT']")
	private WebElement createNewAccLink;

	//This is the input of the user to login
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameLogIn;

	//This is the input of the user to login
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordLogIn;

	//This is the button to login
	@FindBy(xpath = "//button[text()='SIGN IN']")
	private WebElement buttonSigIn;

	//This is image from the background
	@FindBy(id = "headphonesImg")
	private WebElement headPhoneImage;

	/**
	 * Constructor.
	 *
	 * @param driver WebDriver
	 * @param url    String
	 */
	public HomePage(WebDriver driver, String url) {
		super(driver);
		driver.get(url);
	}

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Get the title text
	 */

	public String getTextTitle() {
		log.info("Get the title text");
		waitElementVisibility(tittleAdvantage);
		return getText(tittleAdvantage);
	}

	/**
	 * Click on the account avatar to open the login
	 */
	public void clickAccountAvatar() {
		log.info("Click on the account avatar");
		waitElementVisibility(accountAvatar);
		click(accountAvatar);
	}

	/**
	 * Click on the link to create the account
	 */

	public String getTextCreateAccount() {
		log.info("Click on the create account link");
		waitElementVisibility(createNewAccLink);
		return getText(createNewAccLink);
	}

	public void clickOnCreateAccount() {
		log.info("Click on the create account link");
		waitElementVisibility(headPhoneImage);
		waitElementVisibility(createNewAccLink);
		click(createNewAccLink);

	}

	/**
	 * Insert user to login
	 */
	public void setInputUserName(String userNameCreated) {
		log.info("Enter user name");
		waitElementVisibility(userNameLogIn);
		sendKeys(userNameLogIn,userNameCreated);
	}

	/**
	 * Insert password to login
	 */
	public void setInputPassword(String passwordCreated) {
		log.info("Enter password");
		waitElementVisibility(passwordLogIn);
		sendKeys(passwordLogIn,passwordCreated);
	}

	/**
	 * Click on the login Button
	 */
	public void clickSignInButton() {
		log.info("Click on Sign In button");
		waitElementVisibility(headPhoneImage);
		waitElementClickable(buttonSigIn);
		click(buttonSigIn);
	}



}
