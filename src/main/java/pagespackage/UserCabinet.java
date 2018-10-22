package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.basePageObject;
import static ru.mobileAvtomobilka.helperpackage.BaseTest.header;


public class UserCabinet extends BasePageObject {
    public UserCabinet(AppiumDriver driver) {
        super(driver);
    }

    private By textOnUserCabinetAfterCreatingAccount = By.id("Чтобы начать вести свой блог, необходимо добавить автомобиль");
    private By textUserNameHeader = By.xpath("//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText");

    private final String Выйти = "//XCUIElementTypeStaticText[@name=\"Выйти\"]";
    private By buttonLogOutFromUserCabinet = By.xpath(Выйти);

    private By popUpButtonOkLogOutFromUserCabinet = By.id("Да");
    private By buttonSubscribeInsideUserCabinet = By.xpath("//XCUIElementTypeTable//XCUIElementTypeButton[1]");

    private By addBrand = By.id("Марка");
    private By searchField = By.id("Поиск");
    private By addModel = By.id("Модель");
    private By addYear = By.id("Год");
    private By addYearWheel = By.xpath("//XCUIElementTypePickerWheel");
    private By addEngine = By.id("Двигатель");
    private By addOnSale = By.id("В продаже, Стоимость, руб.");
    private By addTextPrice = By.xpath("//XCUIElementTypeTextField[1]");
    private By addLocationOfAcar = By.id("Место нахождения");
    private By searchFieldLocation = By.id("Введите не менее трех символов");

    private By addPhotoNewUserCar = By.id("+");
    private By editPostAboutCarAddPhoto = By.id("Добавить фото");

    private By fieldWriteNewPostAboutCar = By.xpath("//XCUIElementTypeTextView");

    private String xpathDeleteAcar = "//XCUIElementTypeButton[@name=\"Удалить автомобиль\"]";
    private By buttonDeleteAcar = By.xpath(xpathDeleteAcar);

    public UserCabinet userAddNewCar(String brand, String model, String year,
                                     String engine, String gearBox, String salePrice,
                                     String locationOfAcar){
        click(addBrand);
        typeIntoField(searchField,brand);
        find(By.id(brand)).click();

        click(addModel);
        typeIntoField(searchField,model);
        find(By.id(model)).click();

        click(addYear);
        typeIntoField(addYearWheel,year);

        click(addEngine);
        typeIntoField(searchField,engine);
        find(By.id(engine)).click();

        find(By.id(gearBox)).click();

        click(addOnSale);
        typeIntoField(addTextPrice,salePrice);
        find(By.id(salePrice)).click();

        click(addLocationOfAcar);
        typeIntoField(searchFieldLocation,locationOfAcar);
        find(By.id(locationOfAcar)).click();

        basePageObject.tabOnReadyButton();


        addPhotoFromDeviceStorage();

        header.clickButtonCreate();


        return new UserCabinet(driver);
    }


    private UserCabinet addPhotoFromDeviceStorage() {
        click(addPhotoNewUserCar);

        basePageObject.addPhotoFromStorageDevice();
        return new UserCabinet(driver);
    }

    public boolean textBlockAfterCreatingAccountIsEnabled() {
        System.out.println("\nAssertTrue. Text block after creating account is enabled");

        return basePageObject.find(textOnUserCabinetAfterCreatingAccount)
                .isEnabled();
    }



    public UserCabinet clickPopUpButtonOkLogOutFromUserCabinet() {
        click(popUpButtonOkLogOutFromUserCabinet);
        return new UserCabinet(driver);
    }


    public UserCabinet clickButtonIsubscribeInsideUserCabinet() {
        click(buttonSubscribeInsideUserCabinet);
        return new UserCabinet(driver);
    }

    public UserCabinet swipeDownAndclickButtonLogOutInSettingsUserCabinet() {

        basePageObject.swipeOrScrollToElement("mobile: swipe","up",Выйти);

        click(buttonLogOutFromUserCabinet);
        return new UserCabinet(driver);
    }

    public UserCabinet openScreenOfMyCar(String brandAndModelCarAccesibilityID) {

        find(By.id(brandAndModelCarAccesibilityID)).click();
        return new UserCabinet(driver);
    }

    public UserCabinet editPostAboutMyCarWriteTextAndAddPhoto(String text) {

        header.clickButtonThreeDots()
                .clickPopUpMenuWriteIntoJournal();

        click(editPostAboutCarAddPhoto);

        basePageObject.addPhotoFromStorageDevice();

        typeIntoField(fieldWriteNewPostAboutCar,text);

        header.clickButtonAddHeader();
        return new UserCabinet(driver);
    }

    public UserCabinet deleteLastAddCar() {

        header.clickButtonThreeDots()
                .clickPopUpMenuEditAcar();

        swipeOrScrollToElement("mobile: scroll","down",xpathDeleteAcar);

        click(buttonDeleteAcar);

        basePageObject.tabOnDaButton();
        return new UserCabinet(driver);
    }


    public String getTextUserNameHeader() {
        return basePageObject.find(textUserNameHeader).getText();

    }



}
