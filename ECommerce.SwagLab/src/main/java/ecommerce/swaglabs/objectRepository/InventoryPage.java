package ecommerce.swaglabs.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.swaglabs.genericUtility.WebDriverUtility;

public class InventoryPage {

    WebDriver driver;
    WebDriverUtility wbu = new WebDriverUtility();
    
    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wbu.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    // Page title - Products
    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement pageTitle;

    @FindBy(id = "inventory_container")
    private WebElement productContainer;
    
    // Products
    @FindBy(xpath = "//div[@data-test='inventory-item']")
    private List<WebElement> products;

    // Product names
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private List<WebElement> productNames;

    // Product prices
    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private List<WebElement> productPrices;

    // Add to cart buttons
    @FindBy(xpath = "//button[contains(@data-test,'add-to-cart')]")
    private List<WebElement> addToCartButtons;

    // Sort dropdown
    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    // Shopping cart
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;
    
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    //menu bar
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBar;

        
    // Get total number of products
    public int getProductCount() {
        return products.size();
    }


    public String getProductDescription(String productName) {

        String xpath = "//div[@data-test='inventory-item']"+ "[.//div[@data-test='inventory-item-name' and normalize-space()='"+ productName + "']]"+ "//div[@data-test='inventory-item-desc']";

        return driver.findElement(By.xpath(xpath)).getText();
    }
    
    public String getProductButtonText(String productName) {

        String xpath = "//div[@data-test='inventory-item']"+ "[.//div[@data-test='inventory-item-name' and normalize-space()='"+ productName + "']]"+ "//button";

        return driver.findElement(By.xpath(xpath)).getText();
    }
    
    public void clickProduct(String productName) {

        String xpath = "//div[@data-test='inventory-item-name' and normalize-space()='"+ productName + "']";

        driver.findElement(By.xpath(xpath)).click();
    }
    
    
    public String getProductPrice(String productName) {

        String xpath = "//div[@data-test='inventory-item']"+"[.//div[@data-test='inventory-item-name' and normalize-space()='"+ productName + "']]"
                          + "//div[@data-test='inventory-item-price']";

        return driver.findElement(By.xpath(xpath)).getText();
    }
    
    // Add product to cart using product name
    public void addProductToCart(String productName) {

        String xpath = "//div[@data-test='inventory-item']"+ "[.//div[@data-test='inventory-item-name' and normalize-space()='" + productName + "']]"+ "//button[contains(@data-test,'add-to-cart')]";

        WebElement product = driver.findElement(By.xpath(xpath));
        wbu.conditionalWait_ActionTobePerformedOnElement(driver, product);
        product.click();
    }
    
    // Sort products
    public void sortProducts(String option) {

        wbu.select(sortDropdown, option);
    }
    
    public List<WebElement> getProductNames() {
        return productNames;
    }

    public List<WebElement> getProductPrices() {
        return productPrices;
    }

    public List<WebElement> getAddToCartButtons() {
        return addToCartButtons;
    }
       
    public WebElement getPageTitle() {
		return pageTitle;
	}
    
    public WebElement getProductContainer()
    {
    	return productContainer;
    }

	public List<WebElement> getProducts() {
		return products;
	}

	public WebElement getCartBadge() {
		return cartBadge;
	}

	public WebElement getMenuBar()
    {
    	return menuBar;
    }

	public WebElement getCartIcon() {
		return cartIcon;
	}
}