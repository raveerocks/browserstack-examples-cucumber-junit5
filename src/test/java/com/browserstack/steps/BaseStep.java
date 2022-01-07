package com.browserstack.steps;

import com.browserstack.WebDriverTestRunner;
import com.browserstack.util.Constants;
import com.browserstack.util.ElementLocatorUtil;
import com.browserstack.webdriver.core.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseStep {

    public WebDriver getWebDriver(){
        return WebDriverTestRunner.getWebDriver();
    }

    public String getURL(){
        return WebDriverFactory.getInstance().getTestEndpoint();
    }

    public void waitForSpinner() {
        ElementLocatorUtil.waitUntilElementVanish(getWebDriver(), By.xpath(Constants.ElementLocators.RELOAD_SPINNER_XPATH), Constants.ErrorMessages.SPINNER_NOT_STOPPED_ON_TIME);
    }
}
