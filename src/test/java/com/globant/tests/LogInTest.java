package com.globant.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class LogInTest extends BaseTest{

    @Parameters({"user","password"})
    @Test(testName = "Log In on ESPN")
    public static void submitForm(String user, String password){
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getButtonAvatar()));
        homepage.accessLogInForm();
        driver.switchTo().frame("disneyid-iframe");
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getUserInput()));
        homepage.logInForm(user,password);
        homepage.pressSubmitButton();
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getButtonAvatar()));
        homepage.getButtonAvatar().click();
        Assert.assertTrue(homepage.getLogOutButton().isDisplayed());
    }
    @AfterMethod
    public static void logOut(){
        homepage.logOutAction();
    }
}

