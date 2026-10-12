package ecommerce_swaglabs.checkout;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class CheckoutNegativeTest extends BaseTest {

    @Test(groups = {"negative"})
    public void checkoutTest_TC_CHECKOUT_05() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.enterData(checkoutPage.getLastName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1));
        wbu.enterData(checkoutPage.getPostalCode(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertTrue(checkoutPage.isErrorDisplayed(), "First Name validation is not displayed");
        Assert.assertEquals(checkoutPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Checkout", 1, 0), "Incorrect First Name validation message");
        Reporter.log("First Name validation verified", true);
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_05 executed successfully", true);
    }

    @Test(groups = {"negative"})
    public void checkoutTest_TC_CHECKOUT_06() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.enterData(checkoutPage.getFirstName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0));
        wbu.enterData(checkoutPage.getPostalCode(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertTrue(checkoutPage.isErrorDisplayed(), "Last Name validation is not displayed");
        Assert.assertEquals(checkoutPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Checkout", 2, 0), "Incorrect Last Name validation message");
        wbu.takeScreenshot(driver, "TC_CHECKOUT_06");
        Reporter.log("Last Name validation verified", true);
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_06 executed successfully", true);
    }

    @Test(groups = {"negative"})
    public void checkoutTest_TC_CHECKOUT_07() throws EncryptedDocumentException, InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.enterData(checkoutPage.getFirstName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0));
        wbu.enterData(checkoutPage.getLastName(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertTrue(checkoutPage.isErrorDisplayed(), "Postal Code validation is not displayed");
        Assert.assertEquals(checkoutPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Checkout", 3, 0), "Incorrect Postal Code validation message");
        wbu.takeScreenshot(driver, "TC_CHECKOUT_07");
        Reporter.log("Postal Code validation verified", true);
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_07 executed successfully", true);
    }

    @Test(groups = {"negative"})
    public void checkoutTest_TC_CHECKOUT_16() throws EncryptedDocumentException, InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertTrue(checkoutPage.isErrorDisplayed(), "First Name validation is not displayed");
        Assert.assertEquals(checkoutPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Checkout", 1, 0), "Incorrect First Name validation message");
        wbu.takeScreenshot(driver, "TC_CHECKOUT_16");
        Reporter.log("Empty checkout form validation verified", true);
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_16 executed successfully", true);
    }
}