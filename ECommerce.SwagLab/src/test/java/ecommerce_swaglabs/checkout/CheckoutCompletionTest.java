package ecommerce_swaglabs.checkout;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class CheckoutCompletionTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void checkoutTest_TC_CHECKOUT_14() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        Assert.assertTrue(wbu.isDisplayed(checkoutOverviewPage.getPageTitle()), "Checkout Overview page is not displayed");
        wbu.clickElement(checkoutOverviewPage.getFinishButton());
        Assert.assertTrue(wbu.isDisplayed(completionPage.getPageTitle()), "Checkout Complete page is not displayed");
        Reporter.log("Order completed successfully", true);
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_14 executed successfully", true);
    }

    @Test(groups = {"smoke"})
    public void checkoutTest_TC_CHECKOUT_15() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getCheckoutButton());
        checkoutPage.enterCustomerInformation(excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 0), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 1), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 2));
        wbu.clickElement(checkoutPage.getContinueButton());
        wbu.clickElement(checkoutOverviewPage.getFinishButton());
        Assert.assertTrue(wbu.isDisplayed(completionPage.getPageTitle()), "Order confirmation page is not displayed");
        Assert.assertEquals(completionPage.getConfirmationMessage(), excelUtility.getDataFromExcelFile("Valid_Checkout", 1, 3), "Incorrect confirmation message");
        wbu.clickElement(completionPage.getBackHomeButton());
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), excelUtility.getDataFromExcelFile("URL_Title", 2, 1), "Products page is not displayed after clicking Back Home");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("checkoutTest_TC_CHECKOUT_15 executed successfully", true);
    }
}