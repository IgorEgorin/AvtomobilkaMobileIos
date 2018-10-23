import org.junit.Assert;
import org.junit.Test;
import ru.mobileAvtomobilka.helperpackage.BaseTest;

import static ru.mobileAvtomobilka.helperpackage.DataForUser.*;

public class ActualTests extends BaseTest {


    @Test
    public void assertBrandAndModelCarBeforeAndAfterSubscribe() throws Exception{

//        footerApp.logInByCreatedAccount();


        footerApp.clickTabOneSelectAcar()
                .searchAndOpenCarPageStrangeUser(varSearchCarForTabOneVolkswagen)
                .tabOnIwantToSubscribeOnThisCar()

                .scrollFirstPostAboutCar()
                .pressLikeInFirstPostAboutCar()

                .writeAndSendCommentAboutFirstPost(varCommentWithCurrentDate);

        String varTakeUserNameStrangeUser = userCabinet.getTextUserNameHeader();
        System.out.println(varTakeUserNameStrangeUser);

        footerApp.clickOntabRegAndAuth();

        userCabinet.clickButtonIsubscribeInsideUserCabinet()
                .clickfirstCarOnScreenIsubscribeTo();

        Assert.assertTrue("Brand and model of car have difference",varTakeUserNameStrangeUser
                .equals(userCabinet.getTextUserNameHeader()));


        screenOneSelectAcar
                .tabOnIwantToUnsubscribeFromThisCar()
                .tabOkInsidePopUpDoYouWantToUnsubscribe();


        footerApp.clickOntabRegAndAuth();

        header.clickButtonSettingsHeader();

        userCabinet
                .swipeDownAndclickButtonLogOutInSettingsUserCabinet()
                .clickPopUpButtonOkLogOutFromUserCabinet();

    }

    @Test
    public void addCarToMyProfileAndWriteComments() throws Exception{


//        footerApp.logInByCreatedAccount();
        footerApp.clickOntabRegAndAuth();

        header.clickButtonPlusHeader();

        userCabinet.userAddNewCar(varNewUserCarAudi,varNewUserCarA1,varNewUserCarYear
                ,varNewUserCarEngine,varNewUserCarAutomaticGB,varNewUserCarSalePrice1300000
                ,varNewUserCarLocationMoscow);

        userCabinet.openScreenOfMyCar(varNewUserCarAudi + " " + varNewUserCarA1)
                    .editPostAboutMyCarWriteTextAndAddPhoto(varTextForPostAboutCar);


        userCabinet.openScreenOfMyCar(varNewUserCarAudi + " " + varNewUserCarA1)
                    .deleteLastAddCar();







    }



}
