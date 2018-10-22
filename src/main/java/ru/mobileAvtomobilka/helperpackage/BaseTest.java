package ru.mobileAvtomobilka.helperpackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import pagespackage.ScreenFourRegistarationAndAuthorization;
import pagespackage.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    public static AppiumDriver<MobileElement> driver;
    public static BasePageObject basePageObject;
    public static FooterApp footerApp;
    public static ScreenFourRegistarationAndAuthorization screenFourRegistarationAndAuthorization;
    public static InfoStartScreen infoStartScreen;
    public static EditProfileScreen editProfileScreen;
    public static UserCabinet userCabinet;
    public static ScreenOneSelectAcar screenOneSelectAcar;
    public static HeaderApp header;


    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("\nMethod set up");
        URL serverUrl = new URL ("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "10.3");

        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("app", "Users/Tester/Desktop/Avtomobilka.app");
        capabilities.setCapability("noReset", "true");

        driver = new IOSDriver<>(serverUrl,capabilities);
        driver.manage().timeouts().implicitlyWait(700, TimeUnit.MILLISECONDS);



        basePageObject = new BasePageObject(driver);
        footerApp = new FooterApp(driver);
        header = new HeaderApp(driver);
        screenFourRegistarationAndAuthorization = new ScreenFourRegistarationAndAuthorization(driver);
        infoStartScreen = new InfoStartScreen(driver);
        editProfileScreen = new EditProfileScreen(driver);
        userCabinet = new UserCabinet(driver);
        screenOneSelectAcar = new ScreenOneSelectAcar(driver);



    }



//    @AfterClass
//    public static void quit() {
//
//        System.out.println("\nMethod tear down");
//        driver.quit();
//    }







}
