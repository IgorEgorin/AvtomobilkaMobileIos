package ru.mobileAvtomobilka.helperpackage;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataForUser {

    private static String varRandomNumber = String.valueOf(new Random().nextInt(1234567890));
    private static String varCurrentTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


    public static String varRandomMail = varRandomNumber + "Dataloft@dataloft.com";
    public static String varRandomPassword = varRandomNumber + "Aa";
    public static String varRandomUserName = "alex" + varRandomNumber;
    public static String varRandomLetters = RandomStringUtils.randomAlphabetic(10);
    public static String varRandomInfoAboutUser = "Инфо About User" + varRandomNumber;
    public static String varCommentWithCurrentDate = "Этот комментарий был сделан " + varCurrentTime;


    public static String varCreatedLogIn = "mail345555@ff.ffggg";
    public static String varCreatedPassword = "asdfffg";
    public static String varCreatedUserName = "qwe";


    public static String varNewUserCarAudi = "Audi";
    public static String varNewUserCarA1 = "A1";
    public static String varNewUserCarYear2015 = "2015";
    public static String varNewUserCarEngine = "1.4 TDI";
    public static String varNewUserCarManualGB = "МКПП";
    public static String varNewUserCarAutomaticGB = "АКПП";
    public static String varNewUserCarSalePrice1300000 = "1300000";
    public static String varNewUserCarLocationMoscow = "Москва";


    public static String varNewUserCarForModerationCarOne = "Car one";
    public static String varNewUserCarForModerationModelTwo = "Model two";
    public static String varNewUserCarYearForModeration1922 = "1922";
    public static String varNewUserCarEngineForModeration34TSI = "3.4 TSI";

    public static String varNewUserCarSalePriceForModeration2100000 = "2100000";
    public static String varNewUserCarLocationForModerationSaratov = "Саратов";





    public static String varSearchCarForTabOneVolkswagen = "V";

    public static String varTextForPostAboutCar = "I recently install new tyres";


}
