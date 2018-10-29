package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.basePageObject;

public class ScreenFourRegistarationAndAuthorization extends BasePageObject {
    public ScreenFourRegistarationAndAuthorization(AppiumDriver driver) {
        super(driver);
    }


    private By tabButtonRegistration = By.id("Регистрация");
    private By fieldMail = By.xpath("//XCUIElementTypeTextField");
    private By fieldPassword = By.xpath("//XCUIElementTypeSecureTextField");
    private By submitButton = By.id("Готово");
    private By titleAuthorizationOnRegAndAuthScreen = By.id("Авторизация");
    private By tabButtonForgetApassword = By.id("Забыли пароль?");


    public ScreenFourRegistarationAndAuthorization tapRegistrationButton() {
        System.out.println("\nTap registration button on 'Registaration And Authorization' screen");

        click(tabButtonRegistration);
        return new ScreenFourRegistarationAndAuthorization(driver);
    }

    public ScreenFourRegistarationAndAuthorization tabButtonForgetApassword() {
        System.out.println("\nTap registration button on 'Forget a password?'");

        click(tabButtonForgetApassword);
        return new ScreenFourRegistarationAndAuthorization(driver);
    }

    public ScreenFourRegistarationAndAuthorization enterMailInfieldForPasswordRecoveryAndSubmit(String mail) {
        System.out.println("\nTap registration button on 'Forget a password?'");

        typeIntoField(fieldMail, mail);
        tabOnReadyButton();
        return new ScreenFourRegistarationAndAuthorization(driver);
    }

    public ScreenFourRegistarationAndAuthorization enterLogInAndPassAndSubmit (
            String mail, String pass) {
        System.out.println("\nEnter login, password and submit on 'Registaration And Authorization' screen");
        typeIntoField(fieldMail, mail);
        typeIntoField(fieldPassword, pass);
        click(submitButton);
        return new ScreenFourRegistarationAndAuthorization(driver);

    }

    public boolean titleAuthorizationOnRegAndAuthScreenIsEnabled() {
        System.out.println("\nGet title 'Авторизация' on 'Registaration And Authorization' screen");

        return find(titleAuthorizationOnRegAndAuthScreen)
                .isEnabled();
    }
}
