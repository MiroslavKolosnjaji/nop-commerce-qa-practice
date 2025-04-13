package com.myproject.nopcommerce.stepDefinitions;

import com.myproject.nopcommerce.pageObjects.AddCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.*;

/**
 * @author Miroslav Kološnjaji
 */
@Slf4j
public class AddCustomerSteps {

    private WebDriver webDriver;
    private AddCustomerPage addCustomerPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }

    @Then("User can view Dashboard")
    public void userCanViewDashboard() {
        addCustomerPage = new AddCustomerPage(webDriver);
        assertEquals("Title doesn't match.", "Dashboard / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("User click on customers Menu")
    public void userClickOnCustomersMenu() {
        addCustomerPage.clickOnCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void clickOnCustomersMenuItem() {
        addCustomerPage.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void clickOnAddNewButton() {
        addCustomerPage.clickOnAddNew();
    }

    @When("User can view Add new customer page")
    public void userCanViewAddNewCustomerPage() {
        assertEquals("Title doesn't match.", "Add a new customer / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("User enter customer info")
    public void userEnterCustomerInfo() {

        log.info("******Adding new customer******");
        log.info("******Providing customer details******");

        addCustomerPage.setEmail(generateRandomString("gmail"));
        addCustomerPage.setPassword("testPassword123");
        addCustomerPage.setCustomerRoles("Guest");
        addCustomerPage.setManagerOfVendor("Vendor 2");
        addCustomerPage.setGender("Male");
        addCustomerPage.setFirstName("John");
        addCustomerPage.setLastName("Smith");
        addCustomerPage.setDateOfBirth("12/12/1994");
        addCustomerPage.setCompanyName("busyQA");
        addCustomerPage.setAdminContent("This is for testing.....");

    }

    @When("click on Save button")
    public void clickOnSaveButton() {
        log.info("******Saving customer data******");
        addCustomerPage.clickOnSave();
    }

    @Then("User can view confirmation message {string}")
    public void userCanViewConfirmationMessage(String message) {
        assertTrue(webDriver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
    }

    @Then("Close browser")
    public void close_browser() {
//        webDriver.quit();
    }

    private static String generateRandomString(String email){
        return RandomStringUtils.randomAlphabetic(5) + "@" + email;
    }
}
