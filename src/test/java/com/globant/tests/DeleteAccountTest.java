package com.globant.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DeleteAccountTest extends BaseTest{

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
    @Test(testName = "Delete ESPN account")
    public static void deleteAccount() {
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getButtonAvatar()));
        homepage.accessProfile();
        driver.switchTo().frame("disneyid-iframe");
        homepage.deleteAccount();
        homepage.getWait().until(ExpectedConditions.visibilityOf(homepage.getButtonAvatar()));
        Assert.assertTrue(homepage.getButtonAvatar().isDisplayed());
    }

}
