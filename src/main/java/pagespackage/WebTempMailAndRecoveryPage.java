package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.iosDriverForWeb;

public class WebTempMailAndRecoveryPage extends BasePageObject {
    public WebTempMailAndRecoveryPage(AppiumDriver driver) {
        super(driver);
    }

    private By textCopyToMemory = By.id("mail");
    private By linkOpenRecoveryMail = By.linkText("Изменение пароля учетной");
    private By linkClickToChangeApasswordOrConfirmPassword = By.partialLinkText("Изменить пароль");
    private By fieldEnterNewPassword = By.id("password");
    private By fieldRepeatNewPassword = By.id("password-confirm");


    public String getTextTempMailPage(){
        System.out.println("\nGet mail from temp-mail page");

        return findWeb(textCopyToMemory).getAttribute("value");
    }

    public WebTempMailAndRecoveryPage openLinkOpenRecoveryMail() {
        System.out.println("\nOpen letter where will be link to recovery web page");

        click(linkOpenRecoveryMail);
        click(linkClickToChangeApasswordOrConfirmPassword);
        return new WebTempMailAndRecoveryPage(driver);
    }

    public WebTempMailAndRecoveryPage typeNewPasswordAndSubmit(String newPass){
        System.out.println("\nEnter new password");

        typeIntoField(fieldEnterNewPassword,newPass);
        typeIntoField(fieldRepeatNewPassword,newPass);
        return new WebTempMailAndRecoveryPage(driver);
    }

}
