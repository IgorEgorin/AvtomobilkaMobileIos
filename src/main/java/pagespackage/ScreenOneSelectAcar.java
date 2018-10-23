package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.basePageObject;

public class ScreenOneSelectAcar extends BasePageObject {


    public ScreenOneSelectAcar(AppiumDriver driver) {
        super(driver);
    }

    private String textLikeIcon = "//XCUIElementTypeCell/XCUIElementTypeButton[1]";
    private By likeIcon = By.xpath(textLikeIcon);
    private By buttonSubscribe = By.id("Подписаться");
    private By buttonUnSubscribe = By.id("Подписки");
    private By searchFieldStrangeCar = By.xpath("//XCUIElementTypeTextField");
    private By firstFindingStrangeCar = By.xpath("//XCUIElementTypeImage");

    private By firstCommentIcon = By.id("icon comment dots");
    private By buttonSendAcommentAboutCar = By.id("Отпр");
    private By buttonDa = By.id("Да");

    public ScreenOneSelectAcar searchAndOpenCarPageStrangeUser(String searchTextCar) {
        System.out.println("\nSearch and open car page strange user");

        typeIntoField(searchFieldStrangeCar, searchTextCar);
        click(firstFindingStrangeCar);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar scrollFirstPostAboutCar() {
        System.out.println("\nScroll to first post about car");

        basePageObject.swipeOrScrollToElement("mobile: scroll","down"
                , textLikeIcon);
        return new ScreenOneSelectAcar(driver);
    }


    public ScreenOneSelectAcar pressLikeInFirstPostAboutCar() {
        System.out.println("\nPress like in first post about car");

        click(likeIcon);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar writeAndSendCommentAboutFirstPost(String s) {
        System.out.println("\nWrite and send comment about first post");
        System.out.println("\nComment is" + " " + s);

        typeIntoField(firstCommentIcon,s);
        click(buttonSendAcommentAboutCar);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar tabOnIwantToSubscribeOnThisCar() throws InterruptedException {
        System.out.println("\nTab on 'I want to subscribe on this car'");

        Thread.sleep(1000);
        click(buttonSubscribe);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar tabOnIwantToUnsubscribeFromThisCar() throws InterruptedException {
        System.out.println("\nTab on 'I want to unsubscribe on this car'");

        Thread.sleep(1000);
        click(buttonUnSubscribe);
        return new ScreenOneSelectAcar(driver);
    }

    public ScreenOneSelectAcar tabOkInsidePopUpDoYouWantToUnsubscribe(){
        System.out.println("\nTab 'Ok' inside pop up 'Do you want to unsubscribe?'");

        click(buttonDa);
        return new ScreenOneSelectAcar(driver);
    }

}
