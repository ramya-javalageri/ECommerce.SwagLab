package ecommerce_swaglabs.cart;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.swaglabs.genericUtility.BaseTest;

public class CartTest_Negative extends BaseTest {

    @Test(groups = {"negative"})
    public void cartTest_TC_CART_15() throws InterruptedException, EncryptedDocumentException, IOException {
        driver.get(fu.getDataFromPropertyFile("url"));
        loginPage.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
        wbu.clickElement(inventoryPage.getCartIcon());
        Assert.assertEquals(String.valueOf(cartPage.getCartItemCount()), excelUtility.getDataFromExcelFile("Cart", 1, 0), "Cart is not empty");
        wbu.takeScreenshot(driver, "TC_CART_15");
        menuPage.clickResetAppState();
        menuPage.logout();
        Reporter.log("Logout", true);
        Reporter.log("cartTest_TC_CART_15 executed successfully", true);
    }
}