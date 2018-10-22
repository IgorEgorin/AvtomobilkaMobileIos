import org.junit.Assert;
import org.junit.Test;
import ru.mobileAvtomobilka.helperpackage.BaseTest;
import ru.mobileAvtomobilka.helperpackage.DataForUser;

import static ru.mobileAvtomobilka.helperpackage.DataForUser.*;


public class TestRegistrationAndAuth extends BaseTest {


    @Test
    public void registrateRandomUser() throws Exception{

        footerApp.logInLikeNewUser();





        Assert.assertTrue(userCabinet.textBlockAfterCreatingAccountIsEnabled());


        header.clickButtonSettingsHeader();

        userCabinet
                .swipeDownAndclickButtonLogOutInSettingsUserCabinet()
                .clickPopUpButtonOkLogOutFromUserCabinet();

    }

    @Test
    public void logOutFromUserCabinetWasSuccess() throws Exception{
        registrateRandomUser();
        Assert.assertTrue(screenFourRegistarationAndAuthorization
                .titleAuthorizationOnRegAndAuthScreenIsEnabled());


    }

    @Test
    public void authorizationIntoUserCabinet() throws Exception{
//        registrateRandomUser();


        footerApp.clickOntabRegAndAuth()
                .enterLogInAndPassAndSubmit(varCreatedLogIn,varCreatedPassword);

        Assert.assertTrue(userCabinet.getTextUserNameHeader().equals(varCreatedUserName));


        header.clickButtonSettingsHeader();

        userCabinet
                .swipeDownAndclickButtonLogOutInSettingsUserCabinet()
                .clickPopUpButtonOkLogOutFromUserCabinet();



    }


}

