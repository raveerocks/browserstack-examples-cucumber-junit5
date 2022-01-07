package com.browserstack.steps;

import com.browserstack.webdriver.config.Platform;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.core.gherkin.Pickle;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPageSteps extends BaseStep{

    // Todo : Changed logic to random failure

    @Then("I should see elements in list")
    public void iShouldSeeElementsInList() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout")));
        WebElement element;
        try {
            element = getWebDriver().findElement(By.cssSelector("#__next > main > div > div"));
            List<WebElement> orders = element.findElements(By.tagName("div"));
            int min=0,max=44;
           // Assertions.assertNotEquals(0, orders);
            Assertions.assertEquals(0,(int)(Math.random()*(max-min+1)+min) );
        } catch (NoSuchElementException e) {
           throw new AssertionError("There are no orders");
        }
    }

}
