package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;
import ru.mobileAvtomobilka.helperpackage.BaseTest;
import ru.mobileAvtomobilka.helperpackage.DataForUser.*;

import static ru.mobileAvtomobilka.helperpackage.BaseTest.basePageObject;
import static ru.mobileAvtomobilka.helperpackage.BaseTest.header;
import static ru.mobileAvtomobilka.helperpackage.DataForUser.*;


public class UserCabinet extends BasePageObject {
    public UserCabinet(AppiumDriver driver) {
        super(driver);
    }

    private By textOnUserCabinetAfterCreatingAccount = By.id("Чтобы начать вести свой блог, необходимо добавить автомобиль");
    private By textUserNameHeader = By.xpath("//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText");
    private By textBrandAndModelMainAccountPage = By.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]");
    private By textEngineGearboxYearAccountPage = By.xpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[2]");
    private By textLocationCityAccountPage = By.xpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[3]");

    private By iconGoToModerationOnCarPhoto = By.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeButton[2]");
    private By textFromIconGoToModerationOnCarPhoto = By.id("Он появится в каталоге позже");


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
    private By searchFieldCustomCarParametrs = By.xpath("//XCUIElementTypeAlert//XCUIElementTypeTextField");
    private By addLocationOfAcar = By.id("Место нахождения");
    private By searchFieldLocation = By.id("Введите не менее трех символов");

    private By addPhotoNewUserCar = By.id("+");
    private By editPostAboutCarAddPhoto = By.id("Добавить фото");

    private By fieldWriteNewPostAboutCar = By.xpath("//XCUIElementTypeTextView");

    private String xpathDeleteAcar = "//XCUIElementTypeButton[@name=\"Удалить автомобиль\"]";
    private By buttonDeleteAcar = By.xpath(xpathDeleteAcar);

    private By firstCarOnScreenIsubscribeTo = By.xpath("//XCUIElementTypeImage");
    private By fieldUserNameInsideIsubscibeScreen = By.xpath("//XCUIElementTypeTable/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]");



    public UserCabinet userAddNewCarThatWillGoToModeration(String brand, String model, String year,
                                                String engine, String gearBox, String salePrice,
                                                String locationOfAcar) throws InterruptedException {
        System.out.println("\nAdd new car that will go to moderation inside user cabinet ");
        System.out.println("Brand:" + " " + brand);
        System.out.println("Model:" + " " + model);
        System.out.println("Year:" + " " + year);
        System.out.println("Engine:" + " " + engine);
        System.out.println("Gearbox:" + " " + gearBox);
        System.out.println("Price for sale:" + " " + salePrice);
        System.out.println("Location where car sales:" + " " + locationOfAcar);



        System.out.println("\nEnter and submit custom brand of car");
        click(addBrand);
        header.clickButtonPlusHeader();
        typeIntoField(searchFieldCustomCarParametrs,brand);
        tabOnOkButton();


        Thread.sleep(1000);
        System.out.println("\nEnter and submit custom model of car");
        click(addModel);
        typeIntoField(searchFieldCustomCarParametrs,model);
        tabOnOkButton();


        System.out.println("\nEnter and submit custom year of produce");
        click(addYear);
        typeIntoField(addYearWheel,year);


        System.out.println("\nEnter and submit custom volume and type of engine");
        click(addEngine);
        typeIntoField(searchFieldCustomCarParametrs,engine);
        tabOnOkButton();


        System.out.println("\nSet type of gearbox");
        find(By.id(gearBox)).click();

        System.out.println("\nEnter location where car sales");
        click(addLocationOfAcar);
        typeIntoField(searchFieldLocation,locationOfAcar);
        find(By.id(locationOfAcar)).click();
        basePageObject.tabOnReadyButton();


        addPhotoFromDeviceStorage();

        System.out.println("\nEnter price for sale");
        click(addOnSale);
        typeIntoField(addTextPrice,salePrice);
        find(By.id(salePrice)).click();


        header.clickButtonCreate();

        Thread.sleep(2500);
        return new UserCabinet(driver);




        }




    public UserCabinet userAddNewCarFromCatalog(String brand, String model, String year,
                                                String engine, String gearBox, String salePrice,
                                                String locationOfAcar){
        System.out.println("\nAdd new car from catalog inside user cabinet");
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


    public UserCabinet logOutFromUserCabinet() {

        swipeDownAndclickButtonLogOutInSettingsUserCabinet()
                .clickPopUpButtonOkLogOutFromUserCabinet();
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

    public UserCabinet clickIconGoToModerationOnCarPhoto() {
        System.out.println("\nClick on icon 'Car go to moderation");

        click(iconGoToModerationOnCarPhoto);
        return new UserCabinet(driver);
    }

    public String getTextFromIconGoToModerationOnCarPhoto() {
        return find(textFromIconGoToModerationOnCarPhoto).getText();
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

    public String getTextBrandAndModel() {
        System.out.println("\nGet text brand and car model");
        return find(textBrandAndModelMainAccountPage).getText();
    }


    public String getTextEngineGearboxYear() {
        System.out.println("\nGet text engine volume, gearbox type and year of produce");
        return find(textEngineGearboxYearAccountPage).getText();
    }


    public String getTextCarLocation() {
        System.out.println("\nGet text car location");
        return find(textLocationCityAccountPage).getText();
    }



}
