package ru.mobileAvtomobilka.helperpackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class BasePageObject<T>{

    public static WebDriverWait wait;
    protected AppiumDriver driver;


    private By buttonReady = By.id("Готово");
    private By buttonDa = By.id("Да");
    private By keyBoardIsShown = By.xpath("//XCUIElementTypeKeyboard");

    private By buttonAddPhotoFromStorage = By.id("Сохраненные фото");
    private By buttonOk = By.id("OK");
    private By folderMoments = By.name("Moments");
    private By selectFirstPhotoFromFolderMoments = By.xpath("//XCUIElementTypeCell[2]");


    public BasePageObject(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected void typeIntoField(By pathToElement, String text) {
            find(pathToElement).sendKeys(text);
    }

    public WebElement find(By pathToElement) {

        return driver.findElement(pathToElement);
    }


    public T tabOnReadyButton(){
        System.out.println("\nTap on 'Ready' button");
        click(buttonReady);
        return (T) this;
    }

    public T tabOnDaButton(){
        System.out.println("\nTap on 'Yes' button");
        click(buttonDa);
        return (T) this;
    }

    public T tabOnOkButton(){
        System.out.println("\nTap on 'Ok' button");
        click(buttonOk);
        return (T) this;
    }

    public T addPhotoFromStorageDevice(){
        System.out.println("\nTap on 'Add photo from device storage' button");
        click(buttonAddPhotoFromStorage);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSelect folder with photos");
        click(folderMoments);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSelect first photo in table");
        click(selectFirstPhotoFromFolderMoments);

        return (T) this;
    }



    public void click(By pathToElementClick) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        find(pathToElementClick).click();
    }

    protected void waitingVisibilityOfElement(By pathToElement, Integer... timeSeconds) {
        int attempts = 0;
        while (attempts < 50) {
            try {
                waitForElement(ExpectedConditions.visibilityOfElementLocated(pathToElement)
                        , (timeSeconds.length > 0 ? timeSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }

        }
    }

    protected T waitForElement(ExpectedCondition<WebElement> condition, Integer timeInSeconds) {
        timeInSeconds = timeInSeconds != null ? timeInSeconds : 10;
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds );
        wait.until(condition);
        return (T) this;
    }

    public BasePageObject swipeOrScrollToElement(String swipeOrScroll, String enterDirection, String stringLocatorXpath) {

        System.out.println("\n" + swipeOrScroll.replaceAll("mobile: ","")
                        .replace("s","S")
                        + enterDirection);

        WebElement оbject = driver.findElement(By.xpath(stringLocatorXpath));
        JavascriptExecutor js = driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", enterDirection);
        scrollObject.put("xpath", оbject);
        js.executeScript(swipeOrScroll, scrollObject);

        return new BasePageObject(driver);
    }



}