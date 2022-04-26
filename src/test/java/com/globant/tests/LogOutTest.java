package com.globant.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class LogOutTest extends BaseTest{

    @Parameters({"user","password"})
    @BeforeMethod()
    public static void submitForm(String user, String password){
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getButtonAvatar()));
        homepage.accessLogInForm();
        driver.switchTo().frame("disneyid-iframe");
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getUserInput()));
        homepage.logInForm(user,password);
        homepage.pressSubmitButton();
    }
    @Test(testName = "Log Out on ESPN")
    public static void logOut() throws InterruptedException {
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getButtonAvatar()));
        homepage.logOutAction();
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getLogInSide()));
        Assert.assertTrue(homepage.getLogInSide().isDisplayed());
    }



}
