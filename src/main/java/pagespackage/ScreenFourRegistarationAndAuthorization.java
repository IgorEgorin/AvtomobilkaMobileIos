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


    public ScreenFourRegistarationAndAuthorization tapRegistrationButton() {
        System.out.println("\nTap registration button on 'Registaration And Authorization' screen");

        click(tabButtonRegistration);
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

        return basePageObject.find(titleAuthorizationOnRegAndAuthScreen)
                .isEnabled();
    }
}
