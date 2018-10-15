package ru.mobileAvtomobilka.helperpackage;

import java.util.Random;

public class DataForUser {

    private static String varRandomNumber = String.valueOf(new Random().nextInt(1234567890));
    public static String varRandomMail = varRandomNumber + "Dataloft@dataloft.com";
    public static String varRandomPassword = varRandomNumber + "Aa";
    public static String varRandomUserName = "Alex" + varRandomNumber;
}
