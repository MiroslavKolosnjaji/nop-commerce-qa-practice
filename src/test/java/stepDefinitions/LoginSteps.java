package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;


import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Miroslav Kološnjaji
 */
@Slf4j
public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url){
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_and_password(String username, String password){
        log.info("Username: {}", username);
        log.info("Password: {}", password);

        loginPage.setUserName(username);
        loginPage.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(3000);
    }

    @Then("Page Title should be {string}")
    public void testName(String title) throws InterruptedException {

        if(driver.getPageSource().contains("Login was unsuccessful."))
            driver.close();

        assertEquals("Title doesn't match!", title, driver.getTitle());
        Thread.sleep(3000);
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        loginPage.clickLogout();
        Thread.sleep(3000);
    }
    
    @Then("close browser")
    public void close_browser(){
        driver.quit();
    }

}
