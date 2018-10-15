package ru.mobileAvtomobilka.helperpackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import pagespackage.RegistarationAndAuthorizationScreen;
import pagespackage.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {


    public static AppiumDriver<MobileElement> driver;
    public static BasePageObject basePageObject;
    public static TabsFooter tabsFooter;
    public static RegistarationAndAuthorizationScreen registarationAndAuthorizationScreen;
    public static InfoStartScreen infoStartScreen;
    public static EditProfileScreen editProfileScreen;


    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("\nMethod set up");
        URL serverUrl = new URL ("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "10.3");

        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("app", "Users/Tester/Desktop/Avtomobilka.app");

        driver = new IOSDriver<MobileElement>(serverUrl,capabilities);


        basePageObject = new BasePageObject(driver);
        tabsFooter = new TabsFooter(driver);
        registarationAndAuthorizationScreen = new RegistarationAndAuthorizationScreen(driver);
        infoStartScreen = new InfoStartScreen(driver);
        editProfileScreen = new EditProfileScreen(driver);

        infoStartScreen.clickButtonSkipInfo();

    }

    @After
    public void quit() {

        System.out.println("\nMethod tear down");
        driver.quit();
    }







}
