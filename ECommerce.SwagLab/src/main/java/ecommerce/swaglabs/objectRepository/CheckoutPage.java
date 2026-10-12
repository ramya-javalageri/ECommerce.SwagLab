package ecommerce.swaglabs.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.swaglabs.genericUtility.WebDriverUtility;

public class CheckoutPage {

    WebDriver driver;
    WebDriverUtility wbu = new WebDriverUtility();

    // Page title - Checkout: Your Information
    @FindBy(xpath = "//span[@data-test='title']")
    WebElement pageTitle;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wbu.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

	// First Name
    @FindBy(id = "first-name")
    WebElement firstName;

    // Last Name
    @FindBy(id = "last-name")
    WebElement lastName;

    // Zip / Postal Code
    @FindBy(id = "postal-code")
    WebElement postalCode;
    
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    // Cancel button
    @FindBy(id = "cancel")
    WebElement cancelButton;

    // Continue button
    @FindBy(id = "continue")
    WebElement continueButton;

    

    // Enter customer information
    public void enterCustomerInformation(String fn,String ln,String pc) throws InterruptedException {

    	wbu.enterData(firstName, fn);
    	wbu.enterData(lastName, ln);
    	wbu.enterData(postalCode, pc);
    }

    public WebElement getPageTitle() {
		return pageTitle;
	}
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	
	public String getFirstNameValue() {
		return firstName.getAttribute("value");
	}

	public String getLastNameValue() {
		return lastName.getAttribute("value");
	}

	public String getPostalCodeValue() {
		return postalCode.getAttribute("value");
	}

	
	public boolean isErrorDisplayed() {
		return errorMessage.isDisplayed();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}
}