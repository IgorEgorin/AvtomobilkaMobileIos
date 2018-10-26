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


    public ScreenFourRegistarationAndAuthorization clickOntabRegAndAuthScreen() {
        System.out.println("\nTap on tab 'Registration And Authorization'");

        click(tabRegAndAuth);
        return new ScreenFourRegistarationAndAuthorization(driver);
    }


    public ScreenOneSelectAcar clickTabOneSelectAcar() {
        System.out.println("\nTap on tab 'Registration And Authorization'");

        click(tabListOfCar);
        return new ScreenOneSelectAcar(driver);
    }


    public ScreenOneSelectAcar logInByCreatedAccount() {
        System.out.println("\nLogin by created account");

        clickOntabRegAndAuthScreen()
                .enterLogInAndPassAndSubmit(DataForUser.varCreatedLogIn
                        ,DataForUser.varCreatedPassword);

        return new ScreenOneSelectAcar(driver);
    }


    public ScreenOneSelectAcar logInLikeNewUser() {
        System.out.println("\nLogin like new user");

        clickOntabRegAndAuthScreen()
                .tapRegistrationButton()
                .enterLogInAndPassAndSubmit(DataForUser.varRandomMail
                        ,DataForUser.varRandomPassword);

        editProfileScreen.enterUserNameAndSubmit(varRandomUserName)

                .addPhotoFromDeviceStorage()
                .enterName(varRandomLetters)
                .enterAboutMeInfo(varRandomInfoAboutUser)
                .hideKeyBoardAndPushSubmitButton();
        return new ScreenOneSelectAcar(driver);
    }


}
