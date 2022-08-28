package org.advantage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyItemPage extends BasePage {


	//This is the popularItem link
	@FindBy(xpath = "//a[text()='POPULAR ITEMS']")
	private WebElement popularItemsLink;

	//This is the tablet item to buy
	@FindBy(id = "details_16")
	private WebElement tabletItem;

	//This is the laptop item to buy
	@FindBy(id = "details_10")
	private WebElement laptopItem;

	//This is the color gray to modify the color
	@FindBy(css = "#productProperties .colors span:nth-child(2)")
	private WebElement changeColorGray;

	//Add the item to the cart
	@FindBy(xpath = "//button[@name='save_to_cart']")
	private WebElement buttonAddtoCart;

	//Click on home button
	@FindBy(xpath = "//span[text()='dvantage']")
	private WebElement buttonGoToHome;

	//Click on cart button
	@FindBy(id = "shoppingCartLink")
	private WebElement buttonCartBuy;

	//Click on checkout button
	@FindBy(xpath = "//button[@id='checkOutButton']")
	private WebElement buttonCheckOut;

	//Get Text from the label
	@FindBy(xpath = "//label[text()='PAYMENT OPTIONS: ']")
	private WebElement labelTxtPayment;

	//Get Text from the label
	@FindBy(xpath = "//h3[text()='ORDER PAYMENT']")
	private WebElement labelTxtOrderPayment;

	//Click on next Button
	@FindBy(id = "next_btn")
	private WebElement buttonClickOnNext;

	//Click on pay now button
	@FindBy(id = "pay_now_btn_SAFEPAY")
	private WebElement buttonPayNow;

	//Get Text from the label
	@FindBy(xpath = "//video")
	private WebElement vidBackground;

	//Set input username
	@FindBy(xpath = "//input[@name='safepay_username']")
	private WebElement inputUserNameSafPay;

	//Set input password
	@FindBy(xpath = "//input[@name='safepay_password']")
	private WebElement inputPassSafPay;


    /**
     * Constructor.
     * @param driver WebDriver
     */

    public BuyItemPage(WebDriver driver) {
        super(driver);
    }

	/**
	 * Click on the menu popular items
	 */

    public void clickOnPopularItem() {
    	log.info("Click on Popular Item link");
    	waitElementVisibility(popularItemsLink);
    	click(popularItemsLink);
    }

	/**
	 * click on the tablet to buy
	 */

	public void clickOnTabletItem() {
		log.info("Click on the tablet to buy");
		waitElementVisibility(tabletItem);
		click(tabletItem);
	}

	/**
	 * click on the tablet to buy
	 */

	public void clickOnLaptoptItem() {
		log.info("Click on the laptop to buy");
		waitElementVisibility(laptopItem);
		click(laptopItem);
	}

	/**
	 * Change the color of the tablet to gray
	 */

	public void clickOnChangeColorTablet() {
		log.info("Change the color of the tablet");
		waitElementVisibility(changeColorGray);
		forcedClick(changeColorGray);
	}

	/**
	 * Add the item to the cart
	 */

	public void clickOnAddToCart() {
		log.info("Add item to the cart");
		waitElementVisibility(buttonAddtoCart);
		waitElementClickable(buttonAddtoCart);
		forcedClick(buttonAddtoCart);
	}

	/**
	 * Click on go to home
	 */

	public void clickOnGoToHome() {
		log.info("Click on the item go to home");
		waitElementVisibility(buttonGoToHome);
		click(buttonGoToHome);
	}

	/**
	 * Click on cart button
	 */

	public void clickOnButtonCartBuy() {
		log.info("Click on the button cart to complete the buy");
		waitElementClickable(buttonCartBuy);
		waitElementVisibility(buttonCartBuy);
		forcedClick(buttonCartBuy);
	}

	/**
	 * Click on checkout Button to complete the buy
	 */

	public void clickOnButtonCheckOut() {
		log.info("Click on the button check out to complete the buy");
		waitElementVisibility(buttonCheckOut);
		forcedClick(buttonCheckOut);
	}

	/**
	 * Get the label text of the payment page
	 */

	public String getTextLabelPayment() {
		log.info("Validate the text of the label payment");
		waitElementVisibility(labelTxtPayment);
		return getText(labelTxtPayment);
	}

	/**
	 * Get the label text of the order payment
	 */

	public String getTextLabelOderPayment() {
		log.info("Validate the text of the label Order payment");
		waitElementVisibility(labelTxtOrderPayment);
		return getText(labelTxtOrderPayment);
	}

	/**
	 * Click on next button
	 */

	public void clickOnNextButton() {
		log.info("Click on the button next");
		waitElementVisibility(buttonClickOnNext);
		click(buttonClickOnNext);
	}

	/**
	 * Insert username
	 */

	public void setInputUserNameSafPay(String userNameSafPay) {
		log.info("Enter the username in safe pay");
		waitElementVisibility(inputUserNameSafPay);
		sendKeys(inputUserNameSafPay, userNameSafPay);
	}

	/**
	 * Insert password
	 */

	public void setInputPassSafPay(String passSafPay) {
		log.info("Enter the password in safe pay");
		waitElementVisibility(inputPassSafPay);
		sendKeys(inputPassSafPay, passSafPay);
	}

	/**
	 * Click on Pay Now button
	 */

	public void clickOnPayNow() {
		log.info("Click on the button pay now");
		waitElementVisibility(buttonPayNow);
		click(buttonPayNow);
	}
}
