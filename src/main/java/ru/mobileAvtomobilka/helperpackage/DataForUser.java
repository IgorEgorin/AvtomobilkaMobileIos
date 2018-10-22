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


    public static String varCreatedLogIn = "mail345555@ff.ffgg";
    public static String varCreatedPassword = "asdfffg";
    public static String varCreatedUserName = "qwe";


    public static String varNewUserCarAudi = "Audi";
    public static String varNewUserCarA1 = "A1";
    public static String varNewUserCarYear = "2015";
    public static String varNewUserCarEngine = "1.4 TDI";
    public static String varNewUserCarManualGB = "МКПП";
    public static String varNewUserCarAutomaticGB = "АКПП";
    public static String varNewUserCarSalePrice1300000 = "1300000";
    public static String varNewUserCarLocationMoscow = "Moscow";

    public static String varTextForPostAboutCar = "I recently install new tyres";


}
