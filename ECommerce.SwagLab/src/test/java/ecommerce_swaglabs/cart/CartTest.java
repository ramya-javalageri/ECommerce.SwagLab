package ecommerce_swaglabs.cart;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class CartTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void cartTest_TC_CART_01() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(wbu.isDisplayed(cartPage.getPageTitle()), "Cart page is not displayed");
        Assert.assertEquals(cartPage.getPageTitle().getText(), excelUtility.getDataFromExcelFile("URL_Title", 3, 1), "Cart heading is not displayed");
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Products are not displayed in Cart");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_01 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_02() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(cartPage.isProductPresent(productName), "Selected product is not displayed in Cart");
        Assert.assertEquals(cartPage.getProductPrice(productName), excelUtility.getDataFromExcelFile("Product", 1, 1), "Product price is incorrect");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_02 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_03() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertEquals(cartPage.getProductQuantity(productName), excelUtility.getDataFromExcelFile("Cart", 2, 0), "Product quantity is incorrect");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_03 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_04() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        String productPrice = inventoryPage.getProductPrice(productName);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertEquals(cartPage.getProductPrice(productName), productPrice, "Product price is different in Cart");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_04 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_05() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(cartPage.isProductPresent(productName), "Product is not present before removal");
        cartPage.removeProduct(productName);
        Assert.assertFalse(cartPage.isProductPresent(productName), "Product is not removed from Cart");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_05 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_06() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(productName);
        Assert.assertEquals(cartPage.getCartBadgeCount(), excelUtility.getDataFromExcelFile("Cart", 2, 0), "Cart badge is not displayed as 1");
        wbu.clickElement(inventoryPage.getCartIcon());
        cartPage.removeProduct(productName);
        Assert.assertEquals(cartPage.getCartBadgeCount(), excelUtility.getDataFromExcelFile("Cart", 1, 0), "Cart badge is not updated after removal");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_06 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_07() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String product1 = excelUtility.getDataFromExcelFile("Product", 1, 0);
        String product2 = excelUtility.getDataFromExcelFile("Product", 2, 0);
        inventoryPage.addProductToCart(product1);
        inventoryPage.addProductToCart(product2);
        wbu.clickElement(inventoryPage.getCartIcon());
        cartPage.removeProduct(product2);
        Assert.assertFalse(cartPage.isProductPresent(product2), product2 + " is still present in Cart");
        Assert.assertTrue(cartPage.isProductPresent(product1), product1 + " is not present in Cart");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_07 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void cartTest_TC_CART_08() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        inventoryPage.addProductToCart(excelUtility.getDataFromExcelFile("Product", 1, 0));
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getContinueShoppingButton());
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_08 executed successfully", true);
    }

    @Test(groups = {"integration"})
    public void cartTest_TC_CART_09() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        wbu.clickElement(cartPage.getContinueShoppingButton());
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(cartPage.isProductPresent(productName), "Product is not retained in Cart");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_09 executed successfully", true);
    }

    @Test(groups = {"integration"})
    public void cartTest_TC_CART_12() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String product1 = excelUtility.getDataFromExcelFile("Product", 1, 0);
        String product2 = excelUtility.getDataFromExcelFile("Product", 2, 0);
        inventoryPage.addProductToCart(product1);
        inventoryPage.addProductToCart(product2);
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertEquals(String.valueOf(cartPage.getCartItemCount()), excelUtility.getDataFromExcelFile("Cart", 3, 0), "Two products are not displayed in Cart");
        Assert.assertTrue(cartPage.isProductPresent(product1), product1 + " is not displayed");
        Assert.assertTrue(cartPage.isProductPresent(product2), product2 + " is not displayed");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_12 executed successfully", true);
    }

    @Test(groups = {"integration"})
    public void cartTest_TC_CART_13() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        String productName = excelUtility.getDataFromExcelFile("Product", 1, 0);
        String productPrice = inventoryPage.getProductPrice(productName);
        inventoryPage.addProductToCart(productName);
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(cartPage.isProductPresent(productName), "Product name is not consistent");
        Assert.assertEquals(cartPage.getProductPrice(productName), productPrice, "Product price is not consistent");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout successful", true);
        Reporter.log("cartTest_TC_CART_13 executed successfully", true);
    }
}