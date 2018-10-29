package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.basePageObject;

public class EditProfileScreen extends BasePageObject {
    public EditProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    private By enterUserNameOrName = By.xpath("//XCUIElementTypeTextField");
    private By fieldAboutMe = By.id("Обо мне");
    private By buttonAddPhoto = By.id("Сменить фото профиля");

    private By buttonSkip = By.id("Пропустить");



    public EditProfileScreen enterUserNameAndSubmit(String userName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nEnter user name and submit");

        typeIntoField(enterUserNameOrName, userName);
        tabOnReadyButton();
        return new EditProfileScreen(driver);
    }

    public EditProfileScreen enterName(String userName) {
        System.out.println("\nEnter name");

        typeIntoField(enterUserNameOrName, userName);
        return new EditProfileScreen(driver);
    }

    public EditProfileScreen clickSkipToEnterInfo() {
        System.out.println("\nSkip enter info");

        click(buttonSkip);
        return new EditProfileScreen(driver);
    }


    public EditProfileScreen enterAboutMeInfo(String userName) {
        System.out.println("\nEnter info about user");

        typeIntoField(fieldAboutMe, userName);

        return new EditProfileScreen(driver);
    }

    public EditProfileScreen hideKeyBoardAndPushSubmitButton() {
        System.out.println("\nHide keyBoard");

        driver.hideKeyboard();
        tabOnReadyButton();
        return new EditProfileScreen(driver);
    }



    public EditProfileScreen addPhotoFromDeviceStorage() {
        System.out.println("\nTap on 'Add photo' button");
        click(buttonAddPhoto);

        basePageObject.addPhotoFromStorageDevice();

        return new EditProfileScreen(driver);
    }




}
