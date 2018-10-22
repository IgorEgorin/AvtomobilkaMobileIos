package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;
import ru.mobileAvtomobilka.helperpackage.DataForUser;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.editProfileScreen;
import static ru.mobileAvtomobilka.helperpackage.DataForUser.*;

public class FooterApp extends BasePageObject {
    public FooterApp(AppiumDriver driver) {
        super(driver);
    }

    private By tabRegAndAuth = By.xpath("//XCUIElementTypeTabBar/XCUIElementTypeButton[4]");
    private By tabListOfCar = By.xpath("//XCUIElementTypeTabBar/XCUIElementTypeButton[1]");


    public ScreenFourRegistarationAndAuthorization clickOntabRegAndAuth() {
        System.out.println("\nTap on tab 'Registaration And Authorization'");

        click(tabRegAndAuth);
        return new ScreenFourRegistarationAndAuthorization(driver);
    }


    public ScreenOneSelectAcar clickTabOneSelectAcar() {
        System.out.println("\nTap on tab 'Registaration And Authorization'");

        click(tabListOfCar);
        return new ScreenOneSelectAcar(driver);
    }


    public ScreenOneSelectAcar logInByCreatedAccount() {
        clickOntabRegAndAuth()
                .enterLogInAndPassAndSubmit(DataForUser.varCreatedLogIn
                        ,DataForUser.varCreatedPassword);

        return new ScreenOneSelectAcar(driver);
    }


    public ScreenOneSelectAcar logInLikeNewUser() {
        clickOntabRegAndAuth()
                .tapRegistrationButton()
                .enterLogInAndPassAndSubmit(DataForUser.varRandomMail
                        ,DataForUser.varRandomPassword);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        editProfileScreen.enterUserNameAndSubmit(varRandomUserName)

                .addPhotoFromDeviceStorage()
                .enterName(varRandomLetters)
                .enterAboutMeInfo(varRandomInfoAboutUser)
                .hideKeyBoardAndPushSubmitButton();
        return new ScreenOneSelectAcar(driver);
    }


}
