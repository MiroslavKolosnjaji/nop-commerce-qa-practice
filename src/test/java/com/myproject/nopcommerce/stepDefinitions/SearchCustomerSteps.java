package com.myproject.nopcommerce.stepDefinitions;

import com.myproject.nopcommerce.pageObjects.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

/**
 * @author Miroslav Kološnjaji
 */
@Slf4j
public class SearchCustomerSteps {

    @Getter
    private WebDriver webDriver;
    private SearchCustomerPage searchCustomerPage;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(getWebDriver() != null)
            getWebDriver().quit();
    }


    @When("Enter customer Email")
    public void enterCustomerEmail() {
        log.info("******Searching a customer by ID******");
        searchCustomerPage = new SearchCustomerPage(getWebDriver());
        searchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
    }

    @When("Click on search button")
    public void clickOnSearchButton() {
        searchCustomerPage.clickSearch();
    }

    @Then("User should found Email in the Search table")
    public void userShouldFoundEmailInTheSearchTable() {
        boolean status = searchCustomerPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        assertTrue(status, "Status should be: true");
    }

    @And("Enter customer FirstName")
    public void enterCustomerFirstName() {
        log.info("******Searching customer by name******");
        searchCustomerPage.setFirstName("Victoria");
    }

    @And("Enter customer LastName")
    public void enterCustomerLastName() {
        searchCustomerPage.setTxtLastName("Terces");
    }

    @Then("User should found Name in the Search table")
    public void userShouldFoundNameInTheSearchTable() {

        String firstName = "Victoria";
        String lastName = "Terces";

        boolean status = searchCustomerPage.searchCustomerByName(firstName, lastName);

        assertTrue(status, "Expected full name doesn't match");
    }
}
