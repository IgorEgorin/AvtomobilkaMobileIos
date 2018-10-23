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

    private By firstCarOnScreenIsubscribeTo = By.xpath("//XCUIElementTypeImage");
    private By fieldUserNameInsideIsubscibeScreen = By.xpath("//XCUIElementTypeTable/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]");

    public UserCabinet userAddNewCar(String brand, String model, String year,
                                     String engine, String gearBox, String salePrice,
                                     String locationOfAcar){
        System.out.println("\nAdd new car inside user cabinet");
        System.out.println("Brand:" + " " + brand);
        System.out.println("Model:" + " " + model);
        System.out.println("Year:" + " " + year);
        System.out.println("Engine:" + " " + engine);
        System.out.println("Gearbox:" + " " + gearBox);
        System.out.println("Price for sale:" + " " + salePrice);
        System.out.println("Location where car sales:" + " " + locationOfAcar);


        System.out.println("\nEnter and submit brand of car");
        click(addBrand);
        typeIntoField(searchField,brand);
        find(By.id(brand)).click();

        System.out.println("\nEnter and submit model of car");
        click(addModel);
        typeIntoField(searchField,model);
        find(By.id(model)).click();

        System.out.println("\nEnter and submit year of produce");
        click(addYear);
        typeIntoField(addYearWheel,year);

        System.out.println("\nEnter and submit volume and type of engine");
        click(addEngine);
        typeIntoField(searchField,engine);
        find(By.id(engine)).click();

        System.out.println("\nSet type of gearbox");
        find(By.id(gearBox)).click();

        System.out.println("\nEnter price for sale");
        click(addOnSale);
        typeIntoField(addTextPrice,salePrice);
        find(By.id(salePrice)).click();

        System.out.println("\nEnter location where car sales");
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
        System.out.println("\nTap  on 'Ok' in logout pop up menu");

        click(popUpButtonOkLogOutFromUserCabinet);
        return new UserCabinet(driver);
    }


    public UserCabinet clickButtonIsubscribeInsideUserCabinet() {
        System.out.println("\nTap  on button 'I subscribe on '");

        click(buttonSubscribeInsideUserCabinet);
        return new UserCabinet(driver);
    }

    public UserCabinet clickfirstCarOnScreenIsubscribeTo() {
        System.out.println("\nSelect first car on screen 'I subscribe on '");

        click(firstCarOnScreenIsubscribeTo);
        return new UserCabinet(driver);
    }

    public String getTextFieldUserNameInsideIsubscibeScreen() {
        return find(fieldUserNameInsideIsubscibeScreen).getText();
    }



    public UserCabinet swipeDownAndclickButtonLogOutInSettingsUserCabinet() {
        basePageObject.swipeOrScrollToElement("mobile: swipe","up",Выйти);
        System.out.println("\nTap on logout button");

        click(buttonLogOutFromUserCabinet);
        return new UserCabinet(driver);
    }

    public UserCabinet openScreenOfMyCar(String brandAndModelCarAccesibilityID) throws InterruptedException {
        System.out.println("\nOpen screen of my car");

        Thread.sleep(2000);

        find(By.id(brandAndModelCarAccesibilityID)).click();
        return new UserCabinet(driver);
    }

    public UserCabinet editPostAboutMyCarWriteTextAndAddPhoto(String text) throws InterruptedException {

        header.clickButtonThreeDots()
                .clickPopUpMenuWriteIntoJournal();

        Thread.sleep(1000);

        System.out.println("\nEdit Post About My Car (add photo and write text)");

        click(editPostAboutCarAddPhoto);

        basePageObject.addPhotoFromStorageDevice();

        System.out.println("\nWrite text:" + " " + text);

        typeIntoField(fieldWriteNewPostAboutCar,text);

        header.clickButtonAddHeader();
        return new UserCabinet(driver);
    }

    public UserCabinet deleteLastAddCar() throws InterruptedException {
        System.out.println("\nDelete last user car");

        Thread.sleep(2000);

        header.clickButtonThreeDots()
                .clickPopUpMenuEditAcar();

        swipeOrScrollToElement("mobile: scroll","down",xpathDeleteAcar);


        System.out.println("\nTap on title 'Delete a car?'");
        click(buttonDeleteAcar);

        basePageObject.tabOnDaButton();
        return new UserCabinet(driver);
    }


    public String getTextUserNameHeader() {
        System.out.println("\nGet user name");

        return find(textUserNameHeader).getText();

    }



}
