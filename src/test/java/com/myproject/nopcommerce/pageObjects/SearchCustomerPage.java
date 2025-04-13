package com.myproject.nopcommerce.pageObjects;

import com.myproject.nopcommerce.utils.WaitHelper;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.util.List;


/**
 * @author Miroslav Kološnjaji
 */
public class SearchCustomerPage {

    @Getter
    private final WebDriver webDriver;
    private final WaitHelper waitHelper;


    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    private WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    private WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    private WebElement txtLastName;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    private WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
    @CacheLookup
    private WebElement tblSearchResults;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    private WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    private List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    private List<WebElement> tableColumns;

    public SearchCustomerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waitHelper = new WaitHelper(getWebDriver(), Duration.ofSeconds(10));
    }

    public void setEmail(String email) {
        waitHelper.waitForElement(txtEmail);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String firstName) {
        waitHelper.waitForElement(txtFirstName);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
    }

    public void setTxtLastName(String lastName) {
        waitHelper.waitForElement(txtLastName);
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void clickSearch() {
        waitHelper.waitForClickabillity(btnSearch);
    }


    private int getNumberOfRows() {
        return tableRows.size();
    }

    private int getNumberOfColumns() {
        return tableColumns.size();
    }

    public boolean searchCustomerByEmail(String email) {

        for (int i = 0; i <= getNumberOfRows(); i++) {

            String emailId = findElement(By.xpath("//table[@id='customer-grid']/tbody/tr[" + i + "]/td[2]")).getText();

            if (emailId.equals(email))
                return true;

        }

        return false;
    }

    public boolean searchCustomerByName(String firstName, String lastName) {

        for (int i = 0; i <= getNumberOfRows(); i++) {

            String name1 = findElement(By.xpath("//table[@id='customer-grid']/tbody/tr[" + i + "]/td[3]")).getText();

            String[] names = name1.split(" ");

            if (names[0].equals(firstName) && names[1].equals(lastName))
                return true;

        }

        return false;
    }

    private  WebElement findElement(By locator) {
        return getWebDriver().findElement(locator);
    }
}
