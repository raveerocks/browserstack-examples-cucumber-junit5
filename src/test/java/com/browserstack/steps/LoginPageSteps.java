package com.browserstack.steps;


import com.browserstack.util.Constants;
import com.browserstack.util.ElementLocatorUtil;
import com.browserstack.util.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageSteps extends BaseStep{

    @And("I press Log In Button")
    public void iPressLogin() {
       getWebDriver().findElement(By.cssSelector(".Button_root__24MxS")).click();
    }

    @Then("I should see {string} as Login Error Message")
    public void iShouldSeeAsLoginErrorMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        try {
            String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".api-error"))).getText();
            Assertions.assertEquals(expectedMessage, errorMessage);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Error in logging in");
        }
    }


    @And("I SignIn as {string} with {string} password")
    public void signIn(String userName, String password) {
        WebElement signInButton = getWebDriver().findElement(By.id(Constants.ElementLocators.SIGN_IN_BUTTON_ID));
        signInButton.click();
        ElementLocatorUtil.waitUntilElementAppears(getWebDriver(), By.id(Constants.ElementLocators.USER_INPUT_ID), Constants.ErrorMessages.SIGNIN_PAGE_NOT_LOADED_ON_TIME);
        WebElement userElement = getWebDriver().findElement(By.id(Constants.ElementLocators.USER_INPUT_ID));
        userElement.sendKeys(userName);
        userElement.sendKeys(Keys.ENTER);
        WebElement passwordElement = getWebDriver().findElement(By.id(Constants.ElementLocators.PASSWORD_INPUT_ID));
        passwordElement.sendKeys(password);
        passwordElement.sendKeys(Keys.ENTER);
        WebElement logInButton = getWebDriver().findElement(By.id(Constants.ElementLocators.LOGIN_BUTTON_ID));
        logInButton.click();
        ElementLocatorUtil.waitUntilElementAppears(getWebDriver(), By.className(Constants.ElementLocators.USERNAME_LABEL_CLASS), Constants.ErrorMessages.SIGNIN_NOT_COMPLETED_ON_TIME);
        Utility.mockGPS(getWebDriver());
    }
}
