package ecommerce_swaglabs.product;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class ProductTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void productTest_TC_PRODUCT_01()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getPageTitle()), "Products page is not displayed");
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),
                excelUtility.getDataFromExcelFile("URL_Title", 2, 1), "Products heading is not displayed");
        Assert.assertTrue(inventoryPage.getProductCount() > 0, "Products are not displayed");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC1");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_02()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        Assert.assertEquals(String.valueOf(inventoryPage.getProductCount()),
                excelUtility.getDataFromExcelFile("Product", 1, 2), "All product cards are not displayed");
        Assert.assertEquals(String.valueOf(inventoryPage.getProductNames().size()),
                excelUtility.getDataFromExcelFile("Product", 1, 2), "Product names are not displayed");
        Assert.assertEquals(String.valueOf(inventoryPage.getProductPrices().size()),
                excelUtility.getDataFromExcelFile("Product", 1, 2), "Product prices are not displayed");
        Assert.assertEquals(String.valueOf(inventoryPage.getAddToCartButtons().size()),
                excelUtility.getDataFromExcelFile("Product", 1, 2), "Add to Cart buttons are not displayed");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC2");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_03()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        List<WebElement> productNames = inventoryPage.getProductNames();

        Assert.assertEquals(String.valueOf(productNames.size()),
                excelUtility.getDataFromExcelFile("Product", 1, 2), "Product count is not 6");

        for (WebElement productName : productNames) {
            Assert.assertTrue(wbu.isDisplayed(productName), "Product name is not displayed");
            Assert.assertFalse(productName.getText().trim().isEmpty(), "Product name is empty");
        }

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC3");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_04()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        List<WebElement> productPrices = inventoryPage.getProductPrices();

        Assert.assertEquals(String.valueOf(productPrices.size()),
                excelUtility.getDataFromExcelFile("Product", 1, 2), "All product prices are not displayed");

        for (WebElement price : productPrices) {
            Assert.assertTrue(wbu.isDisplayed(price), "Product price is not displayed");
            Assert.assertTrue(price.getText().startsWith(
                    excelUtility.getDataFromExcelFile("Product", 1, 3)), "Invalid price format");
        }

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC4");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_05()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);
        String description = inventoryPage.getProductDescription(product);

        Assert.assertFalse(description.trim().isEmpty(), "Product description is not displayed");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC5");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_08()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);

        Assert.assertEquals(inventoryPage.getProductButtonText(product),
                excelUtility.getDataFromExcelFile("Product", 1, 5), "Add to Cart button is not displayed");

        inventoryPage.addProductToCart(product);

        Assert.assertEquals(inventoryPage.getProductButtonText(product),
                excelUtility.getDataFromExcelFile("Product", 2, 5), "Button is not changed to Remove");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC8");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_09()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        inventoryPage.sortProducts(excelUtility.getDataFromExcelFile("Product", 1, 4));
        List<WebElement> names = inventoryPage.getProductNames();

        for (int i = 0; i < names.size() - 1; i++) {
            Assert.assertTrue(names.get(i).getText().compareTo(names.get(i + 1).getText()) <= 0,
                    "Products are not sorted A-Z");
        }

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC9");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_10()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        inventoryPage.sortProducts(excelUtility.getDataFromExcelFile("Product", 2, 4));
        List<WebElement> names = inventoryPage.getProductNames();

        for (int i = 0; i < names.size() - 1; i++) {
            Assert.assertTrue(names.get(i).getText().compareTo(names.get(i + 1).getText()) >= 0,
                    "Products are not sorted Z-A");
        }

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC10");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_11()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        inventoryPage.sortProducts(excelUtility.getDataFromExcelFile("Product", 3, 4));
        List<WebElement> prices = inventoryPage.getProductPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            double current = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            double next = Double.parseDouble(prices.get(i + 1).getText().replace("$", ""));

            Assert.assertTrue(current <= next, "Products are not sorted Low to High");
        }

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC11");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_12()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        inventoryPage.sortProducts(excelUtility.getDataFromExcelFile("Product", 4, 4));
        List<WebElement> prices = inventoryPage.getProductPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            double current = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            double next = Double.parseDouble(prices.get(i + 1).getText().replace("$", ""));

            Assert.assertTrue(current >= next, "Products are not sorted High to Low");
        }

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC12");
    }

    @Test(groups = {"functional"})
    public void productTest_TC_PRODUCT_13()
            throws EncryptedDocumentException, IOException, InterruptedException {

        driver.get(fu.getDataFromPropertyFile("url"));

        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

        String product = excelUtility.getDataFromExcelFile("Product", 1, 0);
        inventoryPage.clickProduct(product);

        Assert.assertTrue(driver.getCurrentUrl().contains(
                excelUtility.getDataFromExcelFile("URL_Title", 7, 2)),
                "Product details page is not displayed");

        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        System.out.println("productTest_TC13");
    }
}