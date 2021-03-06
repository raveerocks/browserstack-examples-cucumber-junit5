package com.browserstack.steps;


import com.browserstack.util.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageSteps extends BaseStep{

    @And("I add two products to cart")
    public void iAddProductsToCart() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#\\31 > .shelf-item__buy-btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.float-cart__close-btn"))).click();
        getWebDriver().findElement(By.cssSelector("#\\32 > .shelf-item__buy-btn")).click();
    }

    @And("I click on Buy Button")
    public void iClickOnBuyButton() {
        getWebDriver().findElement(By.cssSelector(".buy-btn")).click();
    }

    @And("I press the Apple Vendor Filter")
    public void iPressTheAppleVendorFilter() {
        getWebDriver().findElement(By.cssSelector(".filters-available-size:nth-child(2) .checkmark")).click();
    }

    @And("I order by lowest to highest")
    public void iOrderByLowestToHighest() {
        WebElement dropdown = getWebDriver().findElement(By.cssSelector("select"));
        dropdown.findElement(By.cssSelector("option[value = 'lowestprice']")).click();
    }

    @Then("I should see user {string} logged in")
    public void iShouldUserLoggedIn(String user) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        try {
            String loggedInUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".username"))).getText();
            Assertions.assertEquals(user, loggedInUser);
        } catch (NoSuchElementException e) {
            throw new AssertionError(user + " is not logged in");
        }
    }

    @Then("I should see no image loaded")
    public void iShouldSeeNoImageLoaded() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
        String src = "";
        try {
            src = getWebDriver().findElement(By.cssSelector("img[alt='iPhone 12']")).getAttribute("src");
            Assertions.assertNotEquals("<>", src);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Error in logging in");
        }
    }

    @Then("I should see {int} items in the list")
    public void iShouldSeeItemsInTheList(int productCount) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), 5);
            webDriverWait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
            List<String> values = getWebDriver().findElements(By.cssSelector(".shelf-item__title")).stream().map(WebElement::getText).collect(Collectors.toList());
            Assertions.assertEquals(productCount, values.size());
        } catch (NoSuchElementException e) {
            throw new AssertionError("Error in page load");
        }
    }

    @Then("I should see prices in ascending order")
    public void iShouldSeePricesInAscendingOrder() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 5);
        try {
            WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), 5);
            webDriverWait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
            List<WebElement> priceWebElement = getWebDriver().findElements(By.cssSelector(".shelf-item__price > div.val > b"));
            Assertions.assertTrue(Utility.isAscendingOrder(priceWebElement, priceWebElement.size()));
        } catch (NoSuchElementException e) {
            throw new AssertionError("Error in page load");
        }
    }

}
