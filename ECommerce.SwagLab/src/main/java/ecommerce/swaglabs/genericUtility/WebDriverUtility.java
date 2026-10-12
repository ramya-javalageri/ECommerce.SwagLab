package ecommerce.swaglabs.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;

	public WebDriver launchBrowser(String browser) {
		if (browser.equals("chrome")) {
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		}

		else if(browser.equals("edge"))
		{
			EdgeOptions settings = new EdgeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new EdgeDriver(settings);
		}
		
		else if(browser.equals("firefox"))
		{
			FirefoxOptions settings = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("signon.management.page.breachAlert.enabled", false);
			settings.setProfile(profile);
			driver = new FirefoxDriver(settings);
		}

		maximizeWindow(driver);
		genericWait(driver);

		return driver;
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void genericWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void conditionalWait_ElementTobePresent(WebDriver driver, WebElement ele) {
	    WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wd.until(ExpectedConditions.visibilityOf(ele));
	}

	public void conditionalWait_ActionTobePerformedOnElement(WebDriver driver, WebElement ele) {
	    WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wd.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void clickElement(WebElement ele) throws InterruptedException {
	    conditionalWait_ActionTobePerformedOnElement(driver, ele);
	    ele.click();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void quitBrowser(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}

	public void select(WebElement ele, String visibleText) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(visibleText);
	}

	public void select(String value, WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}

	public void select(int index, WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}

	public void enterData(WebElement ele, String value) throws InterruptedException {
		ele.clear();
		ele.sendKeys(value);
//		Thread.sleep(1000);
	}

//	public void clickElement(WebElement ele) throws InterruptedException {
//		conditionalWait_ActionTobePerformedOnElement(driver, ele);
//		ele.click();
////		Thread.sleep(2000);
//	}

	public boolean isDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}

	public boolean isDisplayed(List<WebElement> ele) {
		return ele.size() > 0;
	}

	public boolean isEnabled(WebElement ele) {
		return ele.isEnabled();
	}

	public void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File("./Screenshots/" + screenshotName + ".png");

		FileHandler.copy(source, destination);
	}
	
	
	public void setDriver(WebDriver driver) {
	    this.driver = driver;
	}
	

}
