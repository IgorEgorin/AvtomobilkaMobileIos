package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

public class HeaderApp extends BasePageObject {
    public HeaderApp(AppiumDriver driver) {
        super(driver);
    }

    private By buttonSettingsHeader = By.id("top settings");
    private By buttonBackHeader = By.id("Back");
    private By buttonPlusHeader = By.id("plus");
    private By buttonCreate = By.id("Создать");
    private By buttonAdd = By.id("Добавить");
    private By buttonThreeDots = By.id("menu");
    private By popUpMenuWriteIntoJournal = By.id("Написать в журнал");
    private By popUpMenuEditAcar = By.id("Редактировать автомобиль");


    public HeaderApp clickButtonSettingsHeader() {
        click(buttonSettingsHeader);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonBackHeader() {
        click(buttonBackHeader);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonPlusHeader() {
        click(buttonPlusHeader);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonCreate() {
        click(buttonCreate);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonThreeDots() {
        click(buttonThreeDots);
        return new HeaderApp(driver);
    }

    public HeaderApp clickPopUpMenuWriteIntoJournal() {
        click(popUpMenuWriteIntoJournal);
        return new HeaderApp(driver);
    }

    public HeaderApp clickPopUpMenuEditAcar() {
        click(popUpMenuEditAcar);
        return new HeaderApp(driver);
    }

    public HeaderApp clickButtonAddHeader() {
        click(buttonAdd);
        return new HeaderApp(driver);
    }


}
