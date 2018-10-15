package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

public class EditProfileScreen extends BasePageObject {
    public EditProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    private By enterUserName = By.xpath("//XCUIElementTypeTextField");


    public EditProfileScreen enterUserNameAndSubmit(String userName) throws InterruptedException {
        Thread.sleep(5000);
        typeIntoField(enterUserName, userName);
//        tabOnReadyButton();
        return new EditProfileScreen(driver);
    }
}
