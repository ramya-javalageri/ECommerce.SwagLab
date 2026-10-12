package ecommerce_swaglabs.checkout;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void checkoutTest_TC_CHECKOUT_01() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        Assert.assertTrue(wbu.isDisplayed(checkoutPage.getPageTitle()), "Checkout Information page is not displayed");
        Assert.assertEquals(checkoutPage.getPageTitle().getText(), "Checkout: Your Information", "Incorrect Checkout page title");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_01 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_02() throws EncryptedDocumentException, InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.enterData(checkoutPage.getFirstName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0));
        Assert.assertEquals(checkoutPage.getFirstNameValue(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), "First Name is not accepted");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_02 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_03() throws EncryptedDocumentException, InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.enterData(checkoutPage.getLastName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1));
        Assert.assertEquals(checkoutPage.getLastNameValue(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), "Last Name is not accepted");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_03 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_04() throws EncryptedDocumentException, InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.enterData(checkoutPage.getPostalCode(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        Assert.assertEquals(checkoutPage.getPostalCodeValue(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2), "Postal Code is not accepted");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_04 executed successfully", true);
    }
}