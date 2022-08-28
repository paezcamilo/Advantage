package org.advantage.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
	private WebDriver driver;
	private String driverType;

	public Driver(String browser) {
		driverType = browser;
	}

	public WebDriver getDriver() {
		if(driver == null) driver = setUpDriver();
		return driver;
	}

	private WebDriver setUpDriver() {
		switch (driverType) {
			case "firefox" : driver = new FirefoxDriver();
				break;
			case "chrome" :
				WebDriverManager.chromedriver().browserVersion("87.0.4280.141").setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				options.addArguments("--incognito");
				options.addArguments("--disable-cache");
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			case "ie" : driver = new InternetExplorerDriver();
				break;
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}