package ecommerce.swaglabs.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.swaglabs.genericUtility.WebDriverUtility;

public class  CheckoutCompletionPage{

    WebDriver driver;
    WebDriverUtility wbu = new WebDriverUtility();
    
    // Constructor
    public CheckoutCompletionPage(WebDriver driver) {

    	this.driver = driver;
        this.wbu.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    // Page title - Checkout: Complete!
    @FindBy(xpath = "//span[@data-test='title']")
    WebElement pageTitle;

    // Order confirmation message
    @FindBy(xpath = "//h2[@data-test='complete-header']")
    WebElement confirmationMessage;

    // Order completion text
    @FindBy(xpath = "//div[@data-test='complete-text']")
    WebElement completionText;

    // Pony Express image
    @FindBy(xpath = "//img[@data-test='pony-express']")
    WebElement ponyExpressImage;

    // Back Home button
    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    // Generate PDF Order button
    @FindBy(xpath = "//button[contains(text(),'Generate PDF order')]")
    WebElement generatePDFOrderButton;


    


    public WebDriverUtility getWbu() {
		return wbu;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getPonyExpressImage() {
		return ponyExpressImage;
	}

	public WebElement getBackHomeButton() {
		return backHomeButton;
	}

	public WebElement getGeneratePDFOrderButton() {
		return generatePDFOrderButton;
	}

	// Get confirmation message
    public String getConfirmationMessage() {

        return confirmationMessage.getText();
    }

    // Get completion text
    public String getCompletionText() {

        return completionText.getText();
    }

    
}