package com.myproject.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Miroslav Kološnjaji
 */
public class LoginPage {

    public WebDriver lDriver;

    public LoginPage(WebDriver rDriver){
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Log in')]")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

    public void setUserName(String userName){
        txtEmail.clear();
        txtEmail.sendKeys(userName);
    }

    public void setPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }

}
