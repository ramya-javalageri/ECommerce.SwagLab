package ecommerce_swaglabs.menu;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class MenuIntegrationTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void menuTest_TC_MENU_10() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        menuPage.logout();
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(loginPage.getUserName()), "Username field is not displayed");
        Assert.assertTrue(wbu.isDisplayed(loginPage.getPassword()), "Password field is not displayed");
        Assert.assertTrue(wbu.isDisplayed(loginPage.getLoginButton()), "Login button is not displayed");
        Reporter.log("menuTest_TC_MENU_10 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void menuTest_TC_MENU_11() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        menuPage.logout();
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(loginPage.getLoginButton()), "Login page is not displayed");
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getPageTitle()), "Products page is not displayed after login");
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getProductContainer()), "Product inventory is not displayed after login");
        Reporter.log("menuTest_TC_MENU_11 executed successfully", true);
    }

    @Test(groups = {"system"})
    public void menuTest_TC_MENU_12() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getCartBadge()), "Cart badge is not displayed");
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        menuPage.logout();
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(loginPage.getLoginButton()), "Login page is not displayed after logout");
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(loginPage.getLoginButton()), "Login page is not displayed after browser Back and refresh");
        Reporter.log("menuTest_TC_MENU_12 executed successfully", true);
    }

    @Test(groups = {"integration"})
    public void menuTest_TC_MENU_13() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        menuPage.clickResetAppState();
        driver.navigate().refresh();
        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(product);
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getCartBadge()), "Cart badge is not displayed");
        wbu.clickElement(menuPage.getMenuButton());
        wbu.clickElement(menuPage.getAllItems());
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(cartPage.isProductPresent(product), product + " is not present in cart");
        Reporter.log("menuTest_TC_MENU_13 executed successfully", true);
    }

//    @Test(groups = {"integration"})
//    public void menuTest_TC_MENU_14() throws InterruptedException, EncryptedDocumentException, IOException {
//        driver.get(fu.getDataFromPropertyFile("url"));
//        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
//        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);
//        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getProductContainer()), "Product inventory is not displayed");
//        menuPage.clickResetAppState();
//        inventoryPage.addProductToCart(product);
//        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getCartBadge()), "Cart badge is not displayed after adding the product");
//        Assert.assertFalse(wbu.isDisplayed(inventoryPage.getCartBadge()), "Cart badge is still displayed after Reset App State");
//        Reporter.log("menuTest_TC_MENU_14 executed successfully", true);
//    }
}