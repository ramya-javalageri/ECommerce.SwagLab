package ecommerce_swaglabs.product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class ProductCartIntegrationTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void productTest_TC_PRODUCT_06()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"),
                fu.getDataFromPropertyFile("password"));

        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.addProductToCart(product);
        wbu.clickElement(inventoryPage.getCartIcon());

        Assert.assertTrue(cartPage.isProductPresent(product),
                "The added product " + product + " is not present in cart");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC6");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_07()
            throws InterruptedException, EncryptedDocumentException, IOException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"),
                fu.getDataFromPropertyFile("password"));

        String product1 = excelUtility.getDataFromExcelFile("Product", 1, 0);
        String product2 = excelUtility.getDataFromExcelFile("Product", 2, 0);

        inventoryPage.addProductToCart(product1);
        inventoryPage.addProductToCart(product2);
        wbu.clickElement(inventoryPage.getCartIcon());

        Assert.assertTrue(cartPage.isProductPresent(product1),
                "The added product " + product1 + " is not present in cart");
        Assert.assertTrue(cartPage.isProductPresent(product2),
                "The added product " + product2 + " is not present in cart");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC7");
    }

    @Test(groups = {"integration"})
    public void productTest_TC_PRODUCT_14()
            throws InterruptedException, EncryptedDocumentException, IOException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"),
                fu.getDataFromPropertyFile("password"));

        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);
        String inventoryPrice = inventoryPage.getProductPrice(product);

        inventoryPage.addProductToCart(product);
        wbu.clickElement(inventoryPage.getCartIcon());

        Assert.assertTrue(cartPage.isProductPresent(product),
                "Product is not present in cart");

        String cartPrice = cartPage.getProductPrice(product);
        Assert.assertEquals(cartPrice, inventoryPrice,
                "Product price is not matching");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC14");
    }
}