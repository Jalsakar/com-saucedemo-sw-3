package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        /**
         * 1.
         * Enter “standard_user” username
         * Enter “secret_sauce” password
         * Click on ‘LOGIN’ button
         * Verify the text “PRODUCTS”
         */
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        Thread.sleep(2000);
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        Thread.sleep(2000);
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        Thread.sleep(2000);
        //Verify the text “PRODUCTS”
        verifyText("Products", "Products", getTextElement(By.xpath("//span[text()='Products']")));
        Thread.sleep(2000);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        /**
         * Enter “standard_user” username
         * Enter “secret_sauce” password
         * Click on ‘LOGIN’ button
         * Verify that six products are displayed on page
         */
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        Thread.sleep(2000);
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        Thread.sleep(2000);
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        Thread.sleep(2000);
        //Verify that six products are displayed on page
        List<WebElement> actualElements = driver.findElements(By.className("inventory_item"));
        int actualNumbers = actualElements.size();
        Assert.assertEquals("Does not match", 6, actualNumbers);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
