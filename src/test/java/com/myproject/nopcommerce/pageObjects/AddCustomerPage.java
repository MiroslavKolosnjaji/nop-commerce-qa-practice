package com.myproject.nopcommerce.pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miroslav Kološnjaji
 */
public class AddCustomerPage {

    @Getter
    private final WebDriver webDriver;

    By lnkCustomers_menu = By.xpath("//a[@href='#']//span[contains(text(), 'Customers')]");
    By lnkCustomers_menuitem = By.xpath("//span[@class= 'menu-item-title'][contains(text(),'Customers')]");

    By btnAddNew = By.xpath("//a[@class='btn bg-blue']"); // Add new

    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");

    By txtCustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

    By lstItemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
    By lstItemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
    By lstItemGuests = By.xpath("//li[contains(text(), 'Guests')]");
    By lstItemVendors = By.xpath("//li[contains(text(), 'Vendors')]");


    By dropManagerOfVendor = By.xpath("//*[@id='VendorId']");
    By rdMaleGender = By.id("Gender_Male");
    By rdFemaleGender = By.id("Gender_Female");

    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");

    By txtDateOfBirth = By.xpath("//input[@id='DateOfBirth']");
    By txtCompanyName = By.xpath("//input[@id='Company']");
    By txtAdminContent = By.xpath("//input[@id='AdminContent']");

    By btnSave = By.xpath("//button[@name='save']");

    public AddCustomerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private  WebElement findElement(By locator) {
        return getWebDriver().findElement(locator);
    }


    //Action methods

    public String getPageTitle(){
        return getWebDriver().getTitle();
    }

    public void clickOnCustomersMenu() {
        findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomersMenuItem() {
        findElement(lnkCustomers_menuitem).click();
    }

    public void clickOnAddNew() {
        findElement(btnAddNew).click();
    }

    public void setEmail(String email) {
        findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        findElement(txtPassword).sendKeys(password);
    }

    public void setCustomerRoles(String role) {
        Map<String, WebElement> roleMap = new HashMap<>();

        roleMap.put("Administrators", findElement(lstItemAdministrators));
        roleMap.put("Guests", findElement(lstItemGuests));
        roleMap.put("Registered", findElement(lstItemRegistered));
        roleMap.put("Vendors", findElement(lstItemVendors));

        if (roleMap.get(role) == null)
            findElement(lstItemGuests).click();
        else
            roleMap.get(role).click();
    }

    public void setManagerOfVendor(String value) {
        Select drp = new Select(getWebDriver().findElement(dropManagerOfVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender){

        if (gender.equals("Female"))
            findElement(rdFemaleGender).click();
        else
            findElement(rdMaleGender).click();

    }

    public void setFirstName(String firstName){
        findElement(txtFirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName){
        findElement(txtLastName).sendKeys(lastName);
    }

    public void setDateOfBirth(String dateOfBirth){
        findElement(txtDateOfBirth).sendKeys(dateOfBirth);
    }

    public void setCompanyName(String companyName){
        findElement(txtCompanyName).sendKeys(companyName);
    }

    public void setAdminContent(String adminContent){
        findElement(txtAdminContent).sendKeys(adminContent);
    }

    public void clickOnSave(){
        findElement(btnSave).click();
    }
}
