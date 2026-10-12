package ecommerce_swaglabs.login;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void loginTest_TC_LOGIN_01() throws IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        Assert.assertTrue(wbu.isDisplayed(loginPage.getUserName()), "Username field is not displayed");
        Assert.assertTrue(wbu.isDisplayed(loginPage.getPassword()), "Password field is not displayed");
        Assert.assertTrue(wbu.isDisplayed(loginPage.getLoginButton()), "Login button is not displayed");
        Reporter.log("loginTest_TC_LOGIN_01 executed successfully", true);
    }

    @Test(groups = {"smoke", "functional", "regression"})
    public void loginTest_TC_LOGIN_02() throws IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed after login with problem user");
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), excelUtility.getDataFromExcelFile("URL_Title", 2, 1), "Products page is not displayed after successful login");
        Reporter.log("loginTest_TC_LOGIN_02 executed successfully", true);
    }

    @Test(groups = {"functional", "regression"})
    public void loginTest_TC_LOGIN_05() throws IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        wbu.enterData(loginPage.getPassword(), fu.getDataFromPropertyFile("password"));
        Assert.assertEquals(loginPage.getPasswordType(), excelUtility.getDataFromExcelFile("Valid_Login", 1, 2), "Password characters are not masked");
        Reporter.log("loginTest_TC_LOGIN_05 executed successfully", true);
    }

    @Test(groups = {"functional", "regression"})
    public void loginTest_TC_LOGIN_06() throws EncryptedDocumentException, IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(excelUtility.getDataFromExcelFile("Valid_Login", 1, 0), excelUtility.getDataFromExcelFile("Valid_Login", 1, 1));
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed after login with problem user");
        Reporter.log("loginTest_TC_LOGIN_06 executed successfully", true);
    }

    @Test(groups = {"functional", "smoke", "regression"})
    public void loginTest_TC_LOGIN_11() throws IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        wbu.enterData(loginPage.getUserName(), fu.getDataFromPropertyFile("username"));
        wbu.enterData(loginPage.getPassword(), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(loginPage.getLoginButton());
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed after clicking Login");
        Reporter.log("loginTest_TC_LOGIN_11 executed successfully", true);
    }

    @Test(groups = {"functional", "smoke", "regression"})
    public void loginTest_TC_LOGIN_12() throws IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed after login with problem user");
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), excelUtility.getDataFromExcelFile("URL_Title", 2, 1), "Products heading is not displayed correctly");
        Assert.assertTrue(inventoryPage.getProductCount() > 0, "Products inventory is not displayed");
        Reporter.log("loginTest_TC_LOGIN_12 executed successfully", true);
    }

    @Test(groups = {"integration", "regression"})
    public void loginTest_TC_LOGIN_13() throws IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed");
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertTrue(wbu.isDisplayed(cartPage.getPageTitle()), "Cart page is not displayed");
        Reporter.log("loginTest_TC_LOGIN_13 executed successfully", true);
    }

    @Test(groups = {"system", "regression"})
    public void loginTest_TC_LOGIN_14() throws IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed");
        wbu.clickElement(inventoryPage.getMenuBar());
        Thread.sleep(2000);
        menuPage.logout();
        Assert.assertTrue(wbu.isDisplayed(loginPage.getUserName()), "Login page is not displayed after logout");
        driver.navigate().back();
        Assert.assertTrue(wbu.isDisplayed(loginPage.getUserName()), "Authenticated content is accessible after logout");
        Reporter.log("loginTest_TC_LOGIN_14 executed successfully", true);
    }

    @Test(groups = {"system", "regression"})
    public void loginTest_TC_LOGIN_15() throws IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        Assert.assertTrue(wbu.getCurrentUrl().contains(excelUtility.getDataFromExcelFile("URL_Title", 2, 2)), "Products page is not displayed after login");
        wbu.clickElement(menuPage.getMenuButton());
        Thread.sleep(1000);
        Assert.assertTrue(wbu.isDisplayed(menuPage.getLogout()), "Logout option is not displayed for authenticated user");
        Reporter.log("loginTest_TC_LOGIN_15 executed successfully", true);
    }
    
}