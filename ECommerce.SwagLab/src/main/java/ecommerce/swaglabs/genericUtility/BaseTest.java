package ecommerce.swaglabs.genericUtility;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ecommerce.swaglabs.objectRepository.CartPage;
import ecommerce.swaglabs.objectRepository.CheckoutCompletionPage;
import ecommerce.swaglabs.objectRepository.CheckoutPage;
import ecommerce.swaglabs.objectRepository.InventoryPage;
import ecommerce.swaglabs.objectRepository.LoginPage;
import ecommerce.swaglabs.objectRepository.MenuPage;
import ecommerce.swaglabs.objectRepository.checkoutOverviewPage;

public class BaseTest {
    public WebDriver driver = null;
    public WebDriverUtility wbu = new WebDriverUtility();
    public FileUtility fu;
    public ExcelUtility excelUtility = new ExcelUtility();
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public checkoutOverviewPage checkoutOverviewPage;
    public CheckoutCompletionPage completionPage;
    public MenuPage menuPage;

    @Parameters("browser")
    @BeforeClass(groups = {"smoke", "functional", "integration", "negative", "regression", "system"})
    public void launchBrowser(@Optional("chrome")String browser) throws IOException {
        Reporter.log("Launching the browser", true);

        fu = new FileUtility();
        driver = wbu.launchBrowser(browser);
        wbu.setDriver(driver);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new checkoutOverviewPage(driver);
        completionPage = new CheckoutCompletionPage(driver);
        menuPage = new MenuPage(driver);
        
    }

    @AfterClass(groups = {"smoke", "functional", "integration", "negative", "regression", "system"})
    public void closeBrowser() {
        Reporter.log("Closing the Browser", true);
        wbu.quitBrowser(driver);
    }
}