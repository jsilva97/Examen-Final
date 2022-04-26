package com.globant.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = "#sideLogin-right-rail>.button-alt")
    private WebElement logInSide;

    @FindBy(css = ".user>a")
    private WebElement buttonAvatar;

    @FindBy(css = "#global-viewport div:nth-child(3)  a[tref*='login']:only-of-type")
    private WebElement logInButton;

    @FindBy(css = "span input[type='email']")
    private WebElement userInput;

    @FindBy(css = "span input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[aria-label='Log In']")
    private WebElement submitLogIn;

    @FindBy(css = ".hover ul.account-management li:nth-child(9)>a")
    private WebElement logOutButton;

    @FindBy(css = ".tools a[tref*='modify']")
    private WebElement myProfileButton;

    @FindBy(css = "#cancel-account")
    private WebElement deleteAccountButton;

    @FindBy(css = "button[did-translate*='buttons.confirm']")
    private WebElement confirmDeleteAccount;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getButtonAvatar() {
        return buttonAvatar;
    }

    public WebElement getLogInSide(){
        return logInSide;
    }

    public WebElement getUserInput(){
        return userInput;
    }
    public WebElement getLogOutButton(){
        return logOutButton;
    }
    public WebElement getLogInButton(){
        return logInButton;
    }
    public void accessLogInForm(){
        this.buttonAvatar.click();
        this.logInButton.click();
    }

    public void logInForm(String user, String password){
        this.userInput.sendKeys(user);
        this.passwordInput.sendKeys(password);
    }

    public void pressSubmitButton(){
        this.submitLogIn.click();
    }

    public void logOutAction(){
        this.buttonAvatar.click();
        this.logOutButton.click();
    }
    public void accessProfile(){
        this.buttonAvatar.click();
        this.myProfileButton.click();
    }

    public void deleteAccount() {
        try{
            this.deleteAccountButton.click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            this.deleteAccountButton.click();
        }
        getWait().until(ExpectedConditions.visibilityOf(confirmDeleteAccount));
        this.confirmDeleteAccount.click();

    }
}