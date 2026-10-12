package ecommerce_swaglabs.login;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class LoginNegativeTest extends BaseTest {

    @Test(groups = {"negative", "regression"})
    public void loginTest_TC_LOGIN_03() throws EncryptedDocumentException, IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(excelUtility.getDataFromExcelFile("Invalid_Login", 1, 0), excelUtility.getDataFromExcelFile("Invalid_Login", 1, 1));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed");
        Assert.assertEquals(loginPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Login", 1, 2), "Incorrect error message is displayed");
        wbu.takeScreenshot(driver, "TC_LOGIN_03");
        Reporter.log("loginTest_TC_LOGIN_03 executed successfully", true);
    }

    @Test(groups = {"negative", "regression"})
    public void loginTest_TC_LOGIN_04() throws EncryptedDocumentException, IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(excelUtility.getDataFromExcelFile("Invalid_Login", 2, 0), excelUtility.getDataFromExcelFile("Invalid_Login", 2, 1));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Validation message is not displayed for blank username and password");
        Assert.assertEquals(loginPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Login", 2, 2), "Incorrect validation message is displayed");
        wbu.takeScreenshot(driver, "TC_LOGIN_04");
        Reporter.log("loginTest_TC_LOGIN_04 executed successfully", true);
    }

    @Test(groups = {"negative", "regression"})
    public void loginTest_TC_LOGIN_07() throws EncryptedDocumentException, IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(excelUtility.getDataFromExcelFile("Invalid_Login", 3, 0), excelUtility.getDataFromExcelFile("Invalid_Login", 3, 1));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid password");
        Assert.assertEquals(loginPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Login", 3, 2), "Incorrect error message is displayed");
        wbu.takeScreenshot(driver, "TC_LOGIN_07");
        Reporter.log("loginTest_TC_LOGIN_07 executed successfully", true);
    }

    @Test(groups = {"negative", "regression"})
    public void loginTest_TC_LOGIN_08() throws EncryptedDocumentException, IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(excelUtility.getDataFromExcelFile("Invalid_Login", 4, 0), excelUtility.getDataFromExcelFile("Invalid_Login", 4, 1));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid username");
        Assert.assertEquals(loginPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Login", 4, 2), "Incorrect error message is displayed");
        wbu.takeScreenshot(driver, "TC_LOGIN_08");
        Reporter.log("loginTest_TC_LOGIN_08 executed successfully", true);
    }

    @Test(groups = {"negative", "regression"})
    public void loginTest_TC_LOGIN_09() throws EncryptedDocumentException, IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(excelUtility.getDataFromExcelFile("Invalid_Login", 5, 0), excelUtility.getDataFromExcelFile("Invalid_Login", 5, 1));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Username validation message is not displayed");
        Assert.assertEquals(loginPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Login", 5, 2), "Incorrect validation message is displayed");
        wbu.takeScreenshot(driver, "TC_LOGIN_09");
        Reporter.log("loginTest_TC_LOGIN_09 executed successfully", true);
    }

    @Test(groups = {"negative", "regression"})
    public void loginTest_TC_LOGIN_10() throws EncryptedDocumentException, IOException, InterruptedException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(excelUtility.getDataFromExcelFile("Invalid_Login", 6, 0), excelUtility.getDataFromExcelFile("Invalid_Login", 6, 1));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Password validation message is not displayed");
        Assert.assertEquals(loginPage.getErrorMessage(), excelUtility.getDataFromExcelFile("Invalid_Login", 6, 2), "Incorrect validation message is displayed");
        wbu.takeScreenshot(driver, "TC_LOGIN_10");
        Reporter.log("loginTest_TC_LOGIN_10 executed successfully", true);
    }
}