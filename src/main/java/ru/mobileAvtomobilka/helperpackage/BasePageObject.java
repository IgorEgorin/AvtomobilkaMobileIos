package ru.mobileAvtomobilka.helperpackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {

    public static WebDriverWait wait;
    protected AppiumDriver driver;


    private By buttonReady = By.id("Готово");


    public BasePageObject(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 12);
    }

    protected void typeIntoField(By pathToElement, String text) {
        find(pathToElement).sendKeys(text);
    }

    public WebElement find(By pathToElement) {
        return driver.findElement(pathToElement);
    }

    protected T tabOnReadyButton (){
       click(buttonReady);
        return (T) this;
    }

    protected void click(By pathToElementClick) {
        find(pathToElementClick).click();
    }

    protected void waitingVisibilityOfElement(By pathToElement, Integer... timeSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitForElement(ExpectedConditions.visibilityOfElementLocated(pathToElement)
                        , (timeSeconds.length > 0 ? timeSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }

        }
    }

    private void waitForElement(ExpectedCondition<WebElement> condition, Integer timeInSeconds) {
        timeInSeconds = timeInSeconds != null ? timeInSeconds : 10;
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds );
        wait.until(condition);
    }



}