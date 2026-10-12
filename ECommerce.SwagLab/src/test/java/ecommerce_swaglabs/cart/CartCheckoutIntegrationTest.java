package ecommerce_swaglabs.cart;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class CartCheckoutIntegrationTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void cartTest_TC_CART_10() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        Assert.assertTrue(driver.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 4, 2)), "Checkout Information page is not displayed");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_10 executed successfully", true);
    }

    @Test(groups = {"integration"})
    public void cartTest_TC_CART_11() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.enterData(checkoutPage.getFirstName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0));
        wbu.enterData(checkoutPage.getLastName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1));
        wbu.enterData(checkoutPage.getPostalCode(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertTrue(wbu.isDisplayed(checkoutOverviewPage.getPageTitle()), "Checkout Overview page is not displayed");
        Assert.assertTrue(checkoutOverviewPage.isProductPresent(productName), "Cart product is not displayed in Checkout Overview");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_11 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_14() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        cartPage.removeProduct(productName);
        Assert.assertFalse(cartPage.isProductPresent(productName), "Product is not removed");
        wbu.clickElement(cartPage.getContinueShoppingButton());
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(cartPage.isProductPresent(productName), "Product is not added again");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_14 executed successfully", true);
    }
}