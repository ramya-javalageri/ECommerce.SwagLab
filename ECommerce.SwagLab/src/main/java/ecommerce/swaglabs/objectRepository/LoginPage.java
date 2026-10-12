package ecommerce.swaglabs.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.swaglabs.genericUtility.WebDriverUtility;

public class LoginPage {

    WebDriver driver;
    WebDriverUtility wbu=new WebDriverUtility();
    
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wbu.setDriver(driver);
        PageFactory.initElements(driver, this);
    }
    
    // Username
    @FindBy(id = "user-name")
    WebElement username;

    // Password
    @FindBy(id = "password")
    WebElement password;

    // Login button
    @FindBy(id = "login-button")
    WebElement loginButton;

    // Error message
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    


    // Login
    public void login(String userName, String passWord) throws InterruptedException {

    	wbu.enterData(username, userName);
    	wbu.enterData(password, passWord);
        wbu.clickElement(loginButton);
//        wbu.refresh(driver);
    }

    // Get Error Message
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    // Verify Error Message
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }


    // Get Password Type
    public String getPasswordType() {
        return password.getAttribute("type");
    }
    
    public WebElement getUserName()
    {
    	return username;
    }
    
    public WebElement getPassword()
    {
    	return password;
    }
    
    public WebElement getLoginButton()
    {
    	return loginButton;
    }
    
}