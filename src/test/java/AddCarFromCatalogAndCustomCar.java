import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BaseTest;

import static ru.mobileAvtomobilka.helperpackage.DataForUser.*;

public class AddCarFromCatalogAndCustomCar extends BaseTest {


    @Ignore
    @Test
    public void assertBrandAndModelCarBeforeAndAfterSubscribe() throws Exception{

        footerApp.logInByCreatedAccount();

        footerApp.clickTabOneSelectAcar()
                .searchAndOpenCarPageStrangeUser(varSearchCarForTabOneVolkswagen)
                .tabOnIwantToSubscribeOnThisCar()

                .scrollFirstPostAboutCar()
                .pressLikeInFirstPostAboutCar()

                .writeAndSendCommentAboutFirstPost(varCommentWithCurrentDate);

        String varTakeUserNameStrangeUser = userCabinet.getTextUserNameHeader();

        footerApp.clickOntabRegAndAuthScreen();

        userCabinet.clickButtonIsubscribeInsideUserCabinet()
                .clickfirstCarOnScreenIsubscribeTo();

        Assert.assertTrue("Brand and model of car have difference",varTakeUserNameStrangeUser
                .equals(userCabinet.getTextUserNameHeader()));


        screenOneSelectAcar
                .tabOnIwantToUnsubscribeFromThisCar()
                .tabOkInsidePopUpDoYouWantToUnsubscribe();


        footerApp.clickOntabRegAndAuthScreen();

        header.clickButtonSettingsHeader();

        userCabinet
                .swipeDownAndclickButtonLogOutInSettingsUserCabinet()
                .clickPopUpButtonOkLogOutFromUserCabinet();

    }

    @Ignore
    @Test
    public void addCarToMyProfileAndWriteComments() throws Exception{


        footerApp.logInByCreatedAccount();

        footerApp.clickOntabRegAndAuthScreen();

        header.clickButtonPlusHeader();

        userCabinet.userAddNewCarFromCatalog(varNewUserCarAudi,varNewUserCarA1, varNewUserCarYear2015
                ,varNewUserCarEngine,varNewUserCarAutomaticGB,varNewUserCarSalePrice1300000
                ,varNewUserCarLocationMoscow);

        userCabinet.openScreenOfMyCar(varNewUserCarAudi + " " + varNewUserCarA1)
                    .editPostAboutMyCarWriteTextAndAddPhoto(varTextForPostAboutCar);


        userCabinet.openScreenOfMyCar(varNewUserCarAudi + " " + varNewUserCarA1)
                    .deleteLastAddCar();


    }

    @Test
    public void addCarToMyProfileFromCatalog() throws Exception{

//        footerApp.logInByCreatedAccount();

        footerApp.clickOntabRegAndAuthScreen();

        header.clickButtonPlusHeader();

        userCabinet.userAddNewCarFromCatalog(varNewUserCarAudi,varNewUserCarA1, varNewUserCarYear2015
                ,varNewUserCarEngine,varNewUserCarAutomaticGB,varNewUserCarSalePrice1300000
                ,varNewUserCarLocationMoscow);

        Assert.assertTrue("\nCar brand and model in settings was:" + varNewUserCarAudi + " " + varNewUserCarA1
                +"\nActual car brand and model in user cabinet is:" + " " + userCabinet.getTextBrandAndModel(),
                userCabinet.getTextBrandAndModel().equals(varNewUserCarAudi + " " + varNewUserCarA1));


        Assert.assertTrue("\nEngine volume in settings was:"+varNewUserCarEngine
                        +"\nEngine volume in user cabinet is:" + " " + userCabinet.getTextEngineGearboxYear()
                ,userCabinet.getTextEngineGearboxYear().contains(varNewUserCarEngine));

        Assert.assertTrue("Type of gearbox has difference in settings and user cabinet"
                ,userCabinet.getTextEngineGearboxYear().replaceAll("AT",varNewUserCarAutomaticGB)
                        .contains(varNewUserCarAutomaticGB));


        Assert.assertTrue("\nYear of produce in settings was:"+varNewUserCarYear2015
                        +"\nYear of produce in user cabinet is:" + " " + userCabinet.getTextEngineGearboxYear()
                ,userCabinet.getTextEngineGearboxYear()
                        .contains(varNewUserCarYear2015));


        Assert.assertTrue("\nLocation of car in settings was:"+varNewUserCarLocationMoscow
                        +"\nLocation of car in user cabinet is:" + " " + userCabinet.getTextCarLocation(),
                userCabinet.getTextCarLocation().equals(varNewUserCarLocationMoscow));

        userCabinet.openScreenOfMyCar(varNewUserCarAudi + " " + varNewUserCarA1)
                .deleteLastAddCar();


    }


    @Test
    public void addCarToMyProfileVehicleGoToModeration() throws Exception{

//        footerApp.logInByCreatedAccount();

        footerApp.clickOntabRegAndAuthScreen();

        header.clickButtonPlusHeader();

        userCabinet.userAddNewCarThatWillGoToModeration(varNewUserCarForModerationCarOne,
                varNewUserCarForModerationModelTwo,varNewUserCarYearForModeration1922,varNewUserCarEngineForModeration34TSI
        ,varNewUserCarManualGB,varNewUserCarSalePriceForModeration2100000,varNewUserCarLocationForModerationSaratov);


        Assert.assertTrue("\nCar brand and model in settings was:" + varNewUserCarForModerationCarOne
                        + " " + varNewUserCarForModerationModelTwo
                        +"\nActual car brand and model in user cabinet is:" + " " + userCabinet.getTextBrandAndModel(),
                userCabinet.getTextBrandAndModel().equals(varNewUserCarForModerationCarOne + " "
                        + varNewUserCarForModerationModelTwo));

        Assert.assertTrue("\nEngine volume in settings was:"+varNewUserCarEngineForModeration34TSI
                        +"\nEngine volume in user cabinet is:" + " " + userCabinet.getTextEngineGearboxYear()
                ,userCabinet.getTextEngineGearboxYear().contains(varNewUserCarEngineForModeration34TSI));

        Assert.assertTrue("Type of gearbox has difference in settings and user cabinet"
                ,userCabinet.getTextEngineGearboxYear().replaceAll("MT",varNewUserCarManualGB)
                        .contains(varNewUserCarManualGB));

        Assert.assertTrue("\nYear of produce in settings was:"+varNewUserCarYearForModeration1922
                        +"\nYear of produce in user cabinet is:" + " " + userCabinet.getTextEngineGearboxYear()
                ,userCabinet.getTextEngineGearboxYear()
                        .contains(varNewUserCarYearForModeration1922));



        Assert.assertTrue("\nLocation of car in settings was:"+varNewUserCarLocationForModerationSaratov
                        +"\nLocation of car in user cabinet is:" + " " + userCabinet.getTextCarLocation(),
                userCabinet.getTextCarLocation().equals(varNewUserCarLocationForModerationSaratov));


        userCabinet.clickIconGoToModerationOnCarPhoto();

        Assert.assertTrue("Text in pop up that 'auto go to moderation' is not found"
                ,userCabinet.getTextFromIconGoToModerationOnCarPhoto().equals("Он появится в каталоге позже"));

        basePageObject.tabOnOkButton();

        userCabinet.openScreenOfMyCar(varNewUserCarForModerationCarOne + " " + varNewUserCarForModerationModelTwo)
                .deleteLastAddCar();


    }



}
