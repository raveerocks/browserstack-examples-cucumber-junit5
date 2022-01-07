package com.browserstack.steps;

import com.browserstack.util.Constants;
import com.browserstack.util.ElementLocatorUtil;
import com.browserstack.webdriver.core.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSteps extends BaseStep{

    @Given("I navigate to homepage")
    public void navigateToHome() {
        getWebDriver().get(WebDriverFactory.getInstance().getTestEndpoint());
        ElementLocatorUtil.waitUntilTitleIs(getWebDriver(), Constants.ElementLocators.HOME_PAGE_TITLE, Constants.ErrorMessages.HOME_PAGE_NOT_LOADED_ON_TIME);
        waitForSpinner();
    }

    @And("I click on {string} link")
    public void iClickOnLink(String linkText) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText))).click();
    }

    @And("I type {string} in {string}")
    public void iTypeIn(String text, String inputName) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        if (inputName.equalsIgnoreCase("username")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username > div > div:nth-child(1)"))).click();
            getWebDriver().findElement(By.id("react-select-2-input")).sendKeys(text);
            getWebDriver().findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
        } else if (inputName.equalsIgnoreCase("password")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div > div:nth-child(1)"))).click();
            getWebDriver().findElement(By.id("react-select-3-input")).sendKeys(text);
            getWebDriver().findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
        }
    }

}
