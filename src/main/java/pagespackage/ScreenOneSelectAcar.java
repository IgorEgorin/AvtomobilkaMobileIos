package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.basePageObject;

public class ScreenOneSelectAcar extends BasePageObject {


    public ScreenOneSelectAcar(AppiumDriver driver) {
        super(driver);
    }

    private String firstPostAboutCar = "//XCUIElementTypeTable/XCUIElementTypeCell";
    private By firstLikeIcon = By.xpath("//XCUIElementTypeCell/XCUIElementTypeButton[1]");
    private By buttonSubscribe = By.id("Подписаться");
    private By buttonUnSubscribe = By.id("Подписки");

    private By firstCommentIcon = By.id("icon comment dots");
    private By buttonSendAcommentAboutCar = By.id("Отпр");
    private By buttonDa = By.id("Да");

    public ScreenOneSelectAcar clickPictureFromList(String numberCarFromListXpathNumber) {
        click(By.xpath("//XCUIElementTypeCell["+numberCarFromListXpathNumber
                +"]/*/XCUIElementTypeImage"));
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar swipeFirstPostAboutCar() {
        basePageObject.swipeOrScrollToElement("mobile: swipe","up"
                ,firstPostAboutCar);
        return new ScreenOneSelectAcar(driver);
    }


    public ScreenOneSelectAcar pressLikeInFirstPostAboutCar() {
        click(firstLikeIcon);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar writeAndSendCommentAboutFirstPost(String s) {
        typeIntoField(firstCommentIcon,s);
        click(buttonSendAcommentAboutCar);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar tabOnIwantToSubcribeOnThisCar() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonSubscribe);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar tabOnIwantToUnsubcribeFromThisCar() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonUnSubscribe);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar tabOkInsidePopUpDoYouWantToUnsubscribe(){
        click(buttonDa);
        return new ScreenOneSelectAcar(driver);
    }

}
