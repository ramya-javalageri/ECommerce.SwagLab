package ecommerce.swaglabs.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.swaglabs.genericUtility.WebDriverUtility;

public class MenuPage {

    WebDriver driver;
    WebDriverUtility wbu = new WebDriverUtility();
    
    //constructor
    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.wbu.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "bm-menu-wrap")
    WebElement menuContainer;

    @FindBy(id = "react-burger-cross-btn")
    WebElement closeMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItems;

    @FindBy(id = "dynamic_catalog_sidebar_link")
    WebElement dynamicCatalog;

    @FindBy(id="dynamic_catalog_lazy_load_link")
    WebElement lazyLoad;

    @FindBy(id = "dynamic_catalog_spinner_link")
    WebElement spinner;

    @FindBy(id = "dynamic_catalog_slider_link")
    WebElement slider;

    @FindBy(id = "about_sidebar_link")
    WebElement about;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppState;

    
    
    
    public String getMenuButtonText()
    {
        return menuButton.getText();
    }

    public String getAllItemsText() {
        return allItems.getText();
    }
    
    public String getAboutText() {
        return about.getText();
    }
    
    public void logout() throws InterruptedException
    {
        if(!logout.isDisplayed())
        {
        	wbu.clickElement(menuButton);
        }
        wbu.clickElement(logout);
    }
    
    public void clickResetAppState() throws InterruptedException {

        if (!resetAppState.isDisplayed()) {
            wbu.clickElement(menuButton);
        }

        wbu.clickElement(resetAppState);
        wbu.refresh(driver);
    }
    

    
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMenuButton() {
		return menuButton;
	}

	public WebElement getMenuContainer() {
		return allItems;
	}

	public WebElement getCloseMenuButton() {
		return closeMenuButton;
	}

	public WebElement getAllItems() {
		return allItems;
	}

	public WebElement getDynamicCatalog() {
		return dynamicCatalog;
	}

	public WebElement getLazyLoad() {
		return lazyLoad;
	}

	public WebElement getSpinner() {
		return spinner;
	}

	public WebElement getSlider() {
		return slider;
	}

	public WebElement getAbout() {
		return about;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getResetAppState() {
		return resetAppState;
	}

}