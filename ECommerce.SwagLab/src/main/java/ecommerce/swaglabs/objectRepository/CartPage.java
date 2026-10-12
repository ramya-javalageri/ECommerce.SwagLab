package ecommerce.swaglabs.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.swaglabs.genericUtility.WebDriverUtility;

public class CartPage {

	WebDriver driver;
	WebDriverUtility wbu = new WebDriverUtility();

	// Constructor
	public CartPage(WebDriver driver) {

		this.driver = driver;
	    this.wbu.setDriver(driver);
	    PageFactory.initElements(driver, this);
	}
		
	// Page title - Your Cart
	@FindBy(xpath = "//span[@data-test='title']")
	WebElement pageTitle;

	// Cart list
	@FindBy(xpath = "//div[@data-test='cart-list']")
	WebElement cartList;

	// Cart items
	@FindBy(xpath = "//div[@data-test='cart-list']//div[@data-test='inventory-item']")
	List<WebElement> cartItems;

	// Product names
	@FindBy(xpath = "//div[@data-test='cart-list']//div[@data-test='inventory-item-name']")
	List<WebElement> productNames;

	// Product prices
	@FindBy(xpath = "//div[@data-test='cart-list']//div[@data-test='inventory-item-price']")
	List<WebElement> productPrices;

	// Remove buttons
	@FindBy(xpath = "//div[@data-test='cart-list']//button[contains(@data-test,'remove')]")
	List<WebElement> removeButtons;

	// Continue Shopping
	@FindBy(id = "continue-shopping")
	WebElement continueShoppingButton;

	// Checkout
	@FindBy(id = "checkout")
	WebElement checkoutButton;

	

	// Get Cart page title
	public WebElement getPageTitle() {

		return pageTitle;
	}

	// Get number of products in cart
	public int getCartItemCount() {

		return cartItems.size();
	}

	// Get all product names
	public List<WebElement> getProductNames() {

		return productNames;
	}

	// Get all product prices
	public List<WebElement> getProductPrices() {

		return productPrices;
	}

	public String getProductPrice(String productName) {

		String xpath = "//div[@data-test='cart-list']" + "//div[@data-test='inventory-item']"
				+ "[.//div[@data-test='inventory-item-name' and normalize-space()='" + productName + "']]"
				+ "//div[@data-test='inventory-item-price']";

		return driver.findElement(By.xpath(xpath)).getText();
	}

	// Remove product using product name
	public void removeProduct(String productName) {

		String xpath = "//div[@data-test='cart-list']" + "//div[@data-test='inventory-item']"
				+ "[.//div[@data-test='inventory-item-name' and normalize-space()='" + productName + "']]"
				+ "//button[contains(@data-test,'remove')]";

		driver.findElement(By.xpath(xpath)).click();
	}

	// Get quantity of a product in cart
	public String getProductQuantity(String productName) {

		String xpath = "//div[@data-test='cart-list']" + "//div[@data-test='inventory-item']"
				+ "[.//div[@data-test='inventory-item-name' and normalize-space()='" + productName + "']]"
				+ "//div[@data-test='item-quantity']";

		return driver.findElement(By.xpath(xpath)).getText();
	}

	// Get cart badge count
	public String getCartBadgeCount() {

		try {
			return driver.findElement(By.className("shopping_cart_badge")).getText();
		} catch (Exception e) {
			return "0";
		}
	}

	public boolean isProductPresent(String productName) {

		for (WebElement product : productNames) {

			if (product.getText().equals(productName)) {
				return true;
			}
		}

		return false;
	}

	public WebElement getCartList() {
		return cartList;
	}

	public List<WebElement> getCartItems() {
		return cartItems;
	}

	public List<WebElement> getRemoveButtons() {
		return removeButtons;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
}