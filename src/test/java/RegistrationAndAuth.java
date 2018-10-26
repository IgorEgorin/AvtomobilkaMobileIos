import org.junit.Assert;
import org.junit.Test;
import pagespackage.UserCabinet;
import ru.mobileAvtomobilka.helperpackage.BaseTest;
import ru.mobileAvtomobilka.helperpackage.DataForUser;

import static ru.mobileAvtomobilka.helperpackage.DataForUser.*;


public class RegistrationAndAuth extends BaseTest {


    @Test
    public void registrationRandomUser() {

        footerApp.logInLikeNewUser();


        Assert.assertTrue("\nUsername before registration was:" + " " + varRandomUserName +
                "\nUsername after registration in user cabinet is" + " " + userCabinet.getTextUserNameHeader()
                ,userCabinet.getTextUserNameHeader()
                .equals(varRandomUserName));


        header.clickButtonSettingsHeader();

        userCabinet.logOutFromUserCabinet();

    }



    @Test
    public void logOutFromUserCabinetWasSuccess() {
        footerApp.logInLikeNewUser();

        header.clickButtonSettingsHeader();

        userCabinet.logOutFromUserCabinet();

        Assert.assertTrue("Title 'Регистрация' does not found", screenFourRegistarationAndAuthorization
                .titleAuthorizationOnRegAndAuthScreenIsEnabled());


    }

    @Test
    public void authorizationIntoUserCabinet() {
        footerApp.logInByCreatedAccount();

        Assert.assertTrue(userCabinet.getTextUserNameHeader().equals(varCreatedUserName));


        header.clickButtonSettingsHeader();

        userCabinet.logOutFromUserCabinet();


    }


}

