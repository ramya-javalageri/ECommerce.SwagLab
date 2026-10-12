package ecommerce_swaglabs.menu;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class MenuTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void menuTest_TC_MENU_01() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        Assert.assertTrue(wbu.isDisplayed(menuPage.getMenuButton()), "Menu button is not displayed");
        Assert.assertTrue(wbu.isEnabled(menuPage.getMenuButton()), "Menu button is not enabled");
        Reporter.log("menuTest_TC_MENU_01 executed successfully", true);
    }

    @Test(groups = {"smoke"})
    public void menuTest_TC_MENU_02() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(menuPage.getAllItems()), "All Items option is not displayed");
        Assert.assertTrue(wbu.isDisplayed(menuPage.getAbout()), "About option is not displayed");
        Assert.assertTrue(wbu.isDisplayed(menuPage.getLogout()), "Logout option is not displayed");
        Reporter.log("menuTest_TC_MENU_02 executed successfully", true);
    }

    @Test(groups = {"smoke"})
    public void menuTest_TC_MENU_03() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(menuPage.getAllItems()), "All Items option is not displayed");
        Assert.assertEquals(menuPage.getAllItemsText(), excelUtility.getDataFromExcelFile("Menu", 1, 0), "All Items text is incorrect");
        Reporter.log("menuTest_TC_MENU_03 executed successfully", true);
    }

    @Test(groups = {"smoke"})
    public void menuTest_TC_MENU_04() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(menuPage.getAbout()), "About option is not displayed");
        Reporter.log("menuTest_TC_MENU_04 executed successfully", true);
    }

    @Test(groups = {"smoke"})
    public void menuTest_TC_MENU_05() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(menuPage.getLogout()), "Logout option is not displayed");
        Reporter.log("menuTest_TC_MENU_05 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void menuTest_TC_MENU_06() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(500);
        wbu.clickElement(menuPage.getAllItems());
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getPageTitle()), "Products heading is not displayed");
        Reporter.log("menuTest_TC_MENU_06 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void menuTest_TC_MENU_07() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(500);
        wbu.clickElement(menuPage.getAllItems());
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getProductContainer()), "Product inventory is not displayed");
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getProducts()), "Products are not displayed");
        Reporter.log("menuTest_TC_MENU_07 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void menuTest_TC_MENU_08() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(500);
        wbu.clickElement(menuPage.getAbout());
        Thread.sleep(2000);
        Assert.assertNotEquals(wbu.getCurrentUrl(), excelUtility.getDataFromExcelFile("URL_Title", 2, 0), "About page did not open");
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 11, 2)), "About destination is incorrect");
        Reporter.log("menuTest_TC_MENU_08 executed successfully", true);
    }

    @Test(groups = {"functional"})
    public void menuTest_TC_MENU_09() throws InterruptedException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Reporter.log("Logging In", true);
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(500);
        wbu.clickElement(menuPage.getAbout());
        Thread.sleep(1000);
        wbu.navigateBack(driver);
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getPageTitle()), "Products page is not displayed after returning");
        Assert.assertTrue(wbu.isDisplayed(inventoryPage.getProductContainer()), "Product inventory is not displayed after returning");
        Reporter.log("menuTest_TC_MENU_09 executed successfully", true);
    }
}