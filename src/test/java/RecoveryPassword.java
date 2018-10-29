import org.junit.Test;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BaseTest;

import java.time.Duration;

import static ru.mobileAvtomobilka.helperpackage.DataForUser.varRandomPassword;

public class RecoveryPassword extends BaseTest {

    @Test
    public void recoveryPass() throws InterruptedException {


        openSafariDropMailPage();
        String varTempMail = webTempMailAndRecoveryPage.getTextTempMailPage();

        System.out.println(varTempMail);

        driver.launchApp();

        footerApp.clickOntabRegAndAuthScreen();


        footerApp.createAndLogOutUserForRecoveryPassword(varTempMail);


        screenFourRegistarationAndAuthorization
                .tabButtonForgetApassword()
                .enterMailInfieldForPasswordRecoveryAndSubmit(varTempMail);

        iosDriverForWeb.launchApp();

        webTempMailAndRecoveryPage.openLinkOpenRecoveryMail()
                .typeNewPasswordAndSubmit(varRandomPassword);

//        submit button does not implimented on method typeNewPassword

//        maybe assert success change password message

        driver.launchApp();

        footerApp.clickOntabRegAndAuthScreen();

        screenFourRegistarationAndAuthorization
                .enterLogInAndPassAndSubmit(varTempMail,varRandomPassword);


//        assert success logIn
        Thread.sleep(99999999);


    }


}
