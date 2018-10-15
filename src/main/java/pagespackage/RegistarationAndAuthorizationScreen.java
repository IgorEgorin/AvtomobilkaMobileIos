package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

public class RegistarationAndAuthorizationScreen extends BasePageObject {
    public RegistarationAndAuthorizationScreen(AppiumDriver driver) {
        super(driver);
    }

    private By tabButtonRegistration = By.id("Регистрация");

    private By fieldMail = By.xpath("//XCUIElementTypeTextField");
    private By fieldPassword = By.xpath("//XCUIElementTypeSecureTextField");
    private By submitButton = By.id("Готово");


    public RegistarationAndAuthorizationScreen tapRegistrationButton() {
        click(tabButtonRegistration);
        return new RegistarationAndAuthorizationScreen(driver);
    }

    public RegistarationAndAuthorizationScreen enterLogInAndPass (String mail, String pass) throws InterruptedException {

        typeIntoField(fieldMail, mail);
        typeIntoField(fieldPassword, pass);
        click(submitButton);
        return new RegistarationAndAuthorizationScreen(driver);
    }
}
