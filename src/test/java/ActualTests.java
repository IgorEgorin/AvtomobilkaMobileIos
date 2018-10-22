import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BaseTest;
import ru.mobileAvtomobilka.helperpackage.DataForUser;

import static ru.mobileAvtomobilka.helperpackage.DataForUser.*;

public class ActualTests extends BaseTest {


    @Test
    public void logOutFromUserCabinetWasSuccess() throws Exception{

        footerApp.logInByCreatedAccount();


        footerApp.clickTabOneSelectAcar()
                .clickPictureFromList("4")
                .tabOnIwantToSubcribeOnThisCar()

                .swipeFirstPostAboutCar()
                .pressLikeInFirstPostAboutCar()

                .writeAndSendCommentAboutFirstPost(varCommentWithCurrentDate);

        footerApp.clickOntabRegAndAuth();

        userCabinet.clickButtonIsubscribeInsideUserCabinet();



        screenOneSelectAcar.clickPictureFromList("1")
                .tabOnIwantToUnsubcribeFromThisCar()
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


        Thread.sleep(436583857);





    }



}
