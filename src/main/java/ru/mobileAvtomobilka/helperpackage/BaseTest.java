package ru.mobileAvtomobilka.helperpackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.Keys;
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
    public static WebTempMailAndRecoveryPage webTempMailAndRecoveryPage;
    public static IOSDriver iosDriverForWeb;

    private URL serverUrl;

    {
        try {
            serverUrl = new URL ("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        System.out.println("\nOpen app");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "10.3");

        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("app", "Users/Tester/Desktop/Avtomobilka24102018.app");
        capabilities.setCapability("noReset", "true");

        driver = new IOSDriver<>(serverUrl,capabilities);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        basePageObject = new BasePageObject(driver);
        footerApp = new FooterApp(driver);
        header = new HeaderApp(driver);
        screenFourRegistarationAndAuthorization = new ScreenFourRegistarationAndAuthorization(driver);
        infoStartScreen = new InfoStartScreen(driver);
        editProfileScreen = new EditProfileScreen(driver);
        userCabinet = new UserCabinet(driver);
        screenOneSelectAcar = new ScreenOneSelectAcar(driver);
        webTempMailAndRecoveryPage = new WebTempMailAndRecoveryPage(driver);
    }

    public void openSafariDropMailPage() {
        DesiredCapabilities capabilities2 = new DesiredCapabilities();
        capabilities2.setCapability("platformName", "iOS");
        capabilities2.setCapability("platformVersion", "10.3");

        capabilities2.setCapability("deviceName", "iPhone 7");
        capabilities2.setCapability("browserName", "Safari");
        iosDriverForWeb = new IOSDriver(serverUrl, capabilities2);
        iosDriverForWeb.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
        iosDriverForWeb.get("https://temp-mail.org/ru/");
    }

    @AfterClass
    public static void quit() throws InterruptedException {
        Thread.sleep(1000);

        System.out.println("\nClose app");
        driver.quit();
    }

}
