package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Locate elements using @FindBy annotations and make them public
    @FindBy(name = "add")
    public WebElement addItsId;

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = "div.error-message-container.error")
    public WebElement errorMessage;

    @FindBy(className = "app_logo")
    public WebElement swagLabsLogo;

    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Example methods to interact with the elements
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isSwagLabsLogoDisplayed() {
        return swagLabsLogo.isDisplayed();
    }


}
