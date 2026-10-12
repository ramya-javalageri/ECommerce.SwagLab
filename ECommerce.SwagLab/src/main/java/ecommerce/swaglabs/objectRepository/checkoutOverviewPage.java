package ecommerce.swaglabs.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.swaglabs.genericUtility.WebDriverUtility;

public class checkoutOverviewPage {

    WebDriver driver;
    WebDriverUtility wbu = new WebDriverUtility();

    
    // Constructor
    public checkoutOverviewPage(WebDriver driver) {

    	this.driver = driver;
        this.wbu.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    // Page title - Checkout: Overview
    @FindBy(xpath = "//span[@data-test='title']")
    WebElement pageTitle;

	// Cart items
    @FindBy(xpath = "//div[@data-test='cart-list']//div[@data-test='inventory-item']")
    List<WebElement> cartItems;


    // Product names
    @FindBy(xpath = "//div[@data-test='cart-list']//div[@data-test='inventory-item-name']")
    List<WebElement> productNames;


    // Product prices
    @FindBy(xpath = "//div[@data-test='cart-list']//div[@data-test='inventory-item-price']")
    List<WebElement> productPrices;


    // Payment Information
    @FindBy(xpath = "//div[@data-test='payment-info-label']")
    WebElement paymentInformationLabel;

    @FindBy(xpath = "//div[@data-test='payment-info-value']")
    WebElement paymentInformationValue;


    // Shipping Information
    @FindBy(xpath = "//div[@data-test='shipping-info-label']")
    WebElement shippingInformationLabel;

    @FindBy(xpath = "//div[@data-test='shipping-info-value']")
    WebElement shippingInformationValue;


    // Price Total
    @FindBy(xpath = "//div[@data-test='total-info-label']")
    WebElement priceTotalLabel;


    // Item Total
    @FindBy(xpath = "//div[@data-test='subtotal-label']")
    WebElement itemTotal;


    // Tax
    @FindBy(xpath = "//div[@data-test='tax-label']")
    WebElement tax;


    // Total
    @FindBy(xpath = "//div[@data-test='total-label']")
    WebElement total;


    // Cancel button
    @FindBy(id = "cancel")
    WebElement cancelButton;

    // Finish button
    @FindBy(id = "finish")
    WebElement finishButton;

    
   
    
    public WebElement getPageTitle()
    {
    	return pageTitle;
    }
   
    public List<WebElement> getCartItems() {
		return cartItems;
	}

	public WebElement getPaymentInformationLabel() {
		return paymentInformationLabel;
	}

	public WebElement getPaymentInformationValue() {
		return paymentInformationValue;
	}


	public WebElement getShippingInformationLabel() {
		return shippingInformationLabel;
	}


	public WebElement getShippingInformationValue() {
		return shippingInformationValue;
	}


	public WebElement getPriceTotalLabel() {
		return priceTotalLabel;
	}


	public WebElement getCancelButton() {
		return cancelButton;
	}


	public WebElement getFinishButton() {
		return finishButton;
	}

	// Get number of products
    public int getProductCount() {

        return cartItems.size();
    }

    // Get product names
    public List<WebElement> getProductNames() {

        return productNames;
    }

    // Get product prices
    public List<WebElement> getProductPrices() {

        return productPrices;
    }

    // Get payment information
    public String getPaymentInformation() {

        return paymentInformationValue.getText();
    }

    // Get shipping information
    public String getShippingInformation() {

        return shippingInformationValue.getText();
    }

    // Get item total
    public String getItemTotal() {

        return itemTotal.getText();
    }

    // Get tax
    public String getTax() {

        return tax.getText();
    }

    // Get total
    public String getTotal() {

        return total.getText();
    }
    
    public boolean isProductPresent(String productName) {

        for (WebElement product : productNames) {

            if (product.getText().equals(productName)) {
                return true;
            }
        }

        return false;
    }
}