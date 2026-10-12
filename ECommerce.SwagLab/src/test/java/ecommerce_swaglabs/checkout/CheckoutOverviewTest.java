package ecommerce_swaglabs.checkout;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class CheckoutOverviewTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void checkoutTest_TC_CHECKOUT_08() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertTrue(wbu.isDisplayed(checkoutOverviewPage.getPageTitle()), "Checkout Overview page is not displayed");
        Assert.assertEquals(checkoutOverviewPage.getPageTitle().getText(), excelUtility.getDataFromExcelFile("URL_Title", 5, 1), "Incorrect Checkout Overview page title");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_08 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_09() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);
        Assert.assertTrue(checkoutOverviewPage.isProductPresent(product), product + " is not displayed on Overview");
        Assert.assertEquals(checkoutOverviewPage.getProductPrices().get(0).getText(), excelUtility.getDataFromExcelFile("Product", 1, 1), "Incorrect product price is displayed");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_09 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_10() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertFalse(checkoutOverviewPage.getPaymentInformation().isEmpty(), "Payment Information is not displayed");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_10 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_11() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertFalse(checkoutOverviewPage.getShippingInformation().isEmpty(), "Shipping Information is not displayed");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_11 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_12() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertFalse(checkoutOverviewPage.getItemTotal().isEmpty(), "Item Total is not displayed");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_12 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void checkoutTest_TC_CHECKOUT_13() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        double itemTotal = Double.parseDouble(checkoutOverviewPage.getItemTotal().replace("Item total: $", ""));
        double tax = Double.parseDouble(checkoutOverviewPage.getTax().replace("Tax: $", ""));
        double total = Double.parseDouble(checkoutOverviewPage.getTotal().replace("Total: $", ""));
        Assert.assertEquals(total, itemTotal + tax, 0.01, "Total calculation is incorrect");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_13 executed successfully", true);
    }
}