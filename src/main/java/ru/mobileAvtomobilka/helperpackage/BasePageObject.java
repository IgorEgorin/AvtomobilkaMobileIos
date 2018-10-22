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
    private By buttonOkWouldYouLikeToAccessToPhoto = By.id("OK");
    private By folderCameraRoll = By.name("Camera Roll");
    private By selectFirstPhotoFromFolderCameraRoll = By.xpath("//XCUIElementTypeCell[1]");


    public BasePageObject(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 4);
    }

    protected void typeIntoField(By pathToElement, String text) {
            find(pathToElement).sendKeys(text);
    }

    public WebElement find(By pathToElement) {

        return driver.findElement(pathToElement);
    }


    public T tabOnReadyButton(){
       click(buttonReady);
        return (T) this;
    }

    public T tabOnDaButton(){
       click(buttonDa);
        return (T) this;
    }

    public T addPhotoFromStorageDevice(){
        System.out.println("\nTap on 'Add photo from device storage' button");
        click(buttonAddPhotoFromStorage);

//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("\nSelect folder with photos");
        click(folderCameraRoll);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nSelect first photo in table");
        click(selectFirstPhotoFromFolderCameraRoll);

        return (T) this;
    }



    public void click(By pathToElementClick) {
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

        WebElement оbject = driver.findElement(By.xpath(stringLocatorXpath));
        JavascriptExecutor js = driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", enterDirection);
        scrollObject.put("xpath", оbject);
        js.executeScript(swipeOrScroll, scrollObject);

        return new BasePageObject(driver);
    }



}